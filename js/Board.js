/**
 * Create Board object
 * @param {object} args object with arguments
 * @param {number} args.x X-coordinat
 * @param {number} args.y Y-coordinat
 */
var Board = function (args) {
  // this.args = args;
  // if (!('hexes' in args)) {
  //   throw {
  //     message: 'Недостаток аргументов hexes.'
  //   }
  // }
  this.$this = $('#board');
  this.hexes = {};
  this.villages = {};
  this.roads = {};
  this.flags = {};
  this.players = {
  };
  this.flags.createTiles = false;
  this.flags.createVillages = false;
  this.updateData(args)
}
Board.prototype.updateData = function(args) {
  this.args = args;
}



Board.prototype.initialHexagon = function() {
  var hexArgs = this.args.hexes;
  for (var i in hexArgs) {
    var key = 'X' + hexArgs[i].x + 'Y' + hexArgs[i].y
    this.hexes[key] = new Hexagon(hexArgs[i]);
  }
  for (var i in this.hexes) {
    this.hexes[i].createHTML();
  }
}

Board.prototype.initialVillages = function() {
  var vilArgs = this.args.villages;
  for (var i in vilArgs) {
    var key = 'X' + vilArgs[i].x + 'Y' + vilArgs[i].y
    this.villages[key] = new Village(vilArgs[i]);
  }
  for (var i in this.villages) {
    this.villages[i].createHTML();
  }
}

Board.prototype.initialroads = function() {
  var roadArgs = this.args.roads;
  for (var i in roadArgs) {
    var key = 'X' + roadArgs[i].x + 'Y' + roadArgs[i].y
    this.roads[key] = new Road(roadArgs[i]);
  }
  for (var i in this.roads) {
    this.roads[i].createHTML();
  }
}

Board.prototype.initialPlayers = function() {
  var playerArgs = this.args.players; 
  for (var i in playerArgs) {
    var key = playerArgs[i].role;
    if (key === 'you') {
      this.players[key] = new PlayerYou(playerArgs[i]);
    } 
    else {
      this.players[key] = new PlayerOpp(playerArgs[i]);
    }
  }

  for (var i in this.players) {
    this.players[i].createHTML();
  }
}


Board.prototype.initialTrade = function() {
  var tradeArgs = this.args.trade;
  for (var i in tradeArgs) {
    var key = 'X' + tradeArgs[i].x + 'Y' + tradeArgs[i].y
    this.trade[key] = new Trade(tradeArgs[i]);
  }
  for (var i in this.trade) {
    this.trade[i].createHTML();
  }
}

Board.prototype.createHTML = function() {
  this.initialHexagon();
  this.initialVillages();
  this.initialroads();
  this.initialPlayers();
}

Board.prototype.createTiles = function() {
  if (this.flags.createTile) {
    return;
  }
  var hexes = this.hexes;
  var board = this;
  var func = function() {
    var count = 0;
    for (var i in hexes) {
      count++;  
      if (hexes[i].flags.createHTML && !hexes[i].flags.createTile) {
        hexes[i].createTile();
        return;
      }
    }
    if (count >= 3 + 4 + 5 + 4 + 3) {
      board.flags.createTile = true;
    };
    clearInterval(setIntervalId);
  }
  var setIntervalId = setInterval(func, Hexagon.prototype.lightAnimationDuration / 2 / Hexagon.prototype.lightAnimationAtSameTime)
}

Board.prototype.createVillages = function() {
  var villages = this.villages;
  var board = this;

  var func = function() {
    var count = 0;
    for (var i in villages) {
      count++;  
      if (villages[i].flags.createHTML && !villages[i].flags.createTile) {
        villages[i].createTile();
        return;
      }
    }
    clearInterval(setIntervalId);
  }
  var setIntervalId = setInterval(func, 400)
}

Board.prototype.createRoads = function() {
  var roads = this.roads;
  var board = this;

  var func = function() {
    for (var i in roads) {
      if (roads[i].flags.createHTML && !roads[i].flags.createTile) {
        roads[i].createTile();
        return;
      }
    }
    clearInterval(setIntervalId);
  }
  var setIntervalId = setInterval(func, 400)
}

Board.prototype.updatePlayersData = function(args) {
  if (!(args.hasOwnProperty('players'))) {
    debugger;
  }
  for (var i in this.players) {
    if(!(args.players.hasOwnProperty(i))) {
      debugger;
    }
    this.players[i].updateData(args.players[i]);
  }

} 
Board.prototype.updatePlayers = function() {
  for (var i in this.players) {
    if(!(args.players.hasOwnProperty(i))) {
      debugger;
    }
    this.players[i].updateHTML();
  }

}


function extend(Child, Parent) {
  var F = function() { };
  F.prototype = Parent.prototype;
  Child.prototype = new F();
  Child.prototype.constructor = Child;
  Child.superclass = Parent.prototype;
}
