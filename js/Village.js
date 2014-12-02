/**
 * Create Village object
 * @param {object} args object with arguments
 * @param {number} args.x X-coordinat
 * @param {number} args.y Y-coordinat
 */
var Village = function(args) {
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
    if (!(args.hasOwnProperty('color'))) {
      throw {
        message: 'Недостаток аргументов color.'
      };
    }
    this.x = args.x;
    this.y = args.y;
    this.color = args.color;
    this.flags = {
      createHTML: false,
      createTile: false
    };
  }
  /**
   * Создаем объект DOM дерева не внедряя его в HTML страницы
   * @return {[type]} [description]
   */

Village.prototype.createHTML = function() {
  if (this.flags.createHTML) {
    return;
  }
  var htmlClass = 'village X' + this.x + ' Y' + this.y;
  var $this = $('<div />', {
    'class': htmlClass
  });
  for (var i = 1; i <= 3; i++) {
    var inHex = $('<div />', {
      'class': 'vil' + i
    });
    $this.append(inHex);
    this['$vil' + i] = inHex;
  }
  this.$this = $this;
  this.flags.createHTML = true;
}

Village.prototype.$buildings = $('#buildings');

Village.prototype.lightAnimationStep = function(H) {
  return function(now, fx) {
    var inset = 1 + 20 * fx.pos;
    var blur = 30 * fx.pos;
    H.css('box-shadow', 'inset 0 ' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1), inset 0 -' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1)');
  }
}

Village.prototype.lightAnimationDone = function(H) {
  var animationStep = this.lightAnimationDoneStep(H);
  var animationDone = this.lightAnimationDoneDone(H);
  var vil = this.$this;
  var villClass = this.color;
  return function() {
    H.css('fontSize', 14);
    vil.addClass(villClass);
    H.animate({
      fontSize: 100
    }, {
      duration: 500,
      step: animationStep,
      done: animationDone
    })
  }
}

Village.prototype.lightAnimationDoneStep = function(H) {
  return function(now, fx) {
    var inset = 1 + 20 - 20 * fx.pos;
    var blur = 30 - 30 * fx.pos;
    H.css('box-shadow', 'inset 0 ' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1), inset 0 -' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1)');
  }
}

Village.prototype.lightAnimationDoneDone = function(H) {
  return function() {
    H.removeClass('inheritShadow');
    H.removeAttr('style');
  }
}

Village.prototype.createTile = function() {
  if (this.flags.createTile) {
    return;
  }
  this.flags.createTile = true;
  for (var i = 1; i <= 3; i++) {
    this['$vil' + i].css('box-shadow', 'inset 0 1px 0 0  rgba(255,255,255,1), inset 0 -1px 0 0 rgba(255,255,255,1)');
    this['$vil' + i].addClass('inheritShadow');
    // var preH = this['$vil' + i]

    var animationStep = this.lightAnimationStep(this['$vil' + i]);
    var animationDone = this.lightAnimationDone(this['$vil' + i]);
    this['$vil' + i].css('fontSize', 14);
    this['$vil' + i].animate({
      fontSize: 100
    }, {
      duration: 500,
      step: animationStep,
      done: animationDone
    })
  }
  this.$buildings.append(this.$this);
}
