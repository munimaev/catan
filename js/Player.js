var Player = function(args) {
    if (!(args.hasOwnProperty('color'))) {
      throw {
        message: 'Недостаток аргументов color.'
      };
    }
    if (!(args.hasOwnProperty('role'))) {
      throw {
        message: 'Недостаток аргументов role.'
      };
    }
	this.args = args;
  this.color = args.color;
  this.role = args.role;
  this.$this = $('#' + args.role + 'Bar')
	this.flags = {
		createHTML : false,
	};
  this.resourses;
  this.cards;
  this.cused;
}
Player.prototype.youBar  = $('#youBar');
Player.prototype.opp1Bar = $('#opp1Bar');
Player.prototype.opp2Bar = $('#opp2Bar');
Player.prototype.opp3Bar = $('#opp3Bar');

Player.prototype.$wood = $('#wood');
Player.prototype.$clay = $('#clay');
Player.prototype.$wheat = $('#wheat');
Player.prototype.$sheep = $('#sheep');
Player.prototype.$iron = $('#iron');

Player.prototype.createHTML = function() {
  this.$this.addClass(this.color);
}

Player.prototype.updateData = function(args) {
  if (!(args.hasOwnProperty('color')) || args.color != this.color) {
    debugger;
  }
  if (!(args.hasOwnProperty('resourses'))) {
    debugger;
  }
  if (!(args.hasOwnProperty('cards'))) {
    debugger;
  }
  if (!(args.hasOwnProperty('used'))) {
    debugger;
  }
  this.resourses = args.resourses;
  this.cards = args.cards;
  this.used = args.used;
  if (this.role == 'you') {
  } 
  else {

  }
}
Player.prototype.updateHTML = function() {
  if (this.role == 'you') {
    var arr = ['wood','clay','wheat','sheep','iron'];

    for (var r in arr) {
      if (!(this.resourses.hasOwnProperty(arr[r]))) {
        debugger;
      }
      this['$'+arr[r]].empty();
      for (var i = 0; i < this.resourses[arr[r]]; i++) {
        this['$'+arr[r]].append($('<div />',{class:'card ' + arr[r]}))
      }
    }

  }

  else {

  }
}

var PlayerYou = function(args) {
  var _this = new Player(args);
  return _this;
};
PlayerYou.prototype = Player.prototype;

var PlayerOpp = function(args) {
  var _this = new Player(args);
  return _this;
};
PlayerOpp.prototype = Player.prototype;