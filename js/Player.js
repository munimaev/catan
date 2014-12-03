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
    if (!(args.hasOwnProperty('color'))) {
      throw {
        message: 'Недостаток аргументов color.'
      };
    }
	this.args = args;
  this.color = args.color;
  this.$this = $('#' + args.role + 'Bar')
	this.flags = {
		createHTML : false,
	};
}
Player.prototype.youBar  = $('#youBar');
Player.prototype.opp1Bar = $('#opp1Bar');
Player.prototype.opp2Bar = $('#opp2Bar');
Player.prototype.opp3Bar = $('#opp3Bar');

Player.prototype.createHTML = function() {
  this.$this.addClass(this.color);
}

Player.prototype.updateHTML = function() {

}

