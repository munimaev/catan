/**
 * Create hexagon object
 * @param {object} args object with arguments
 * @param {number} args.x X-coordinat
 * @param {number} args.y Y-coordinat
 */
var Hexagon = function(args) {
    if (!(args.hasOwnProperty('x'))) {
      throw {
        message: 'Недостаток аргументов x.'
      };
    }
    if (!(args.hasOwnProperty('y'))) {
      throw {
        message: 'Недостаток аргументов x.'
      };
    }
    this.x = args.x;
    this.y = args.y;
    this.flags = {
      createHTML: false,
      createTile: false
    };
  }
  /**
   * Создаем объект DOM дерева не внедряя его в HTML страницы
   * @return {[type]} [description]
   */

Hexagon.prototype.createHTML = function() {
  if (this.flags.createHTML) {
    return;
  }
  var htmlClass = 'hexagon X' + this.x + ' Y' + this.y;
  var $this = $('<div />', {
    'class': htmlClass
  });
  for (var i = 1; i <= 3; i++) {
    var inHex = $('<div />', {
      'class': 'Hex' + i
    });
    $this.append(inHex);
    this['$hex' + i] = inHex;
  }
  this.$this = $this;
  this.flags.createHTML = true;
}

Hexagon.prototype.$board = $('#board');

Hexagon.prototype.lightAnimationStep = function(H) {
  return function(now, fx) {
    var inset = 1 + 69 * fx.pos;
    var blur = 100 * fx.pos;
    H.css('box-shadow', 'inset 0 ' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1), inset 0 -' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1)');
  }
}

Hexagon.prototype.lightAnimationDone = function(H) {
  var animationStep = this.lightAnimationDoneStep(H);
  var animationDone = this.lightAnimationDoneDone(H);
  var hex = this.$this;
  return function() {
    H.css('fontSize', 14);
    hex.addClass('mountain');
    H.animate({
      fontSize: 100
    }, {
      duration: 400,
      step: animationStep,
      done: animationDone
    })
  }
}

Hexagon.prototype.lightAnimationDoneStep = function(H) {
  return function(now, fx) {
    var inset = 1 + 69 - 69 * fx.pos;
    var blur = 100 - 100 * fx.pos;
    H.css('box-shadow', 'inset 0 ' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1), inset 0 -' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1)');
  }
}

Hexagon.prototype.lightAnimationDoneDone = function(H) {
  return function() {
    H.removeClass('inheritShadow');
    H.removeAttr('style');
  }
}

Hexagon.prototype.createTile = function() {
  this.flags.createTile = true;
  for (var i = 1; i <= 3; i++) {
    this['$hex' + i].css('box-shadow', 'inset 0 1px 0 0  rgba(255,255,255,1), inset 0 -1px 0 0 rgba(255,255,255,1)');
    this['$hex' + i].addClass('inheritShadow');
    // var preH = this['$hex' + i]

    var animationStep = this.lightAnimationStep(this['$hex' + i]);
    var animationDone = this.lightAnimationDone(this['$hex' + i]);
    this['$hex' + i].css('fontSize', 14);
    this['$hex' + i].animate({
      fontSize: 100
    }, {
      duration: 400,
      step: animationStep,
      done: animationDone
    })
  }
  this.$board.append(this.$this);
}
