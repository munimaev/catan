/**
 * Create Road object
 * @param {object} args object with arguments
 * @param {number} args.x X-coordinat
 * @param {number} args.y Y-coordinat
 */
var Road = function(args) {
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
    this.childClass = ['roadTop','roadBottom'];
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

Road.prototype.createHTML = function() {
  if (this.flags.createHTML) {
    return;
  }
  var htmlClass = 'road X' + this.x + ' Y' + this.y;
  var $this = $('<div />', {
    'class': htmlClass
  });

  for (var i in this.childClass) {
    var inVil = $('<div />', {
      'class': this.childClass[i]
    });
    $this.append(inVil);
    this['$'+this.childClass[i]] = inVil;
  }

  this.$this = $this;
  this.flags.createHTML = true;
}

Road.prototype.$buildings = $('#buildings');

Road.prototype.lightAnimationStep = function(H) {
  return function(now, fx) {
    var inset = 1 + 20 * fx.pos;
    var blur = 30 * fx.pos;
    H.css('box-shadow', 'inset 0 ' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1), inset 0 -' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1)');
  }
}

Road.prototype.lightAnimationDone = function(H) {
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

Road.prototype.lightAnimationDoneStep = function(H) {
  return function(now, fx) {
    var inset = 1 + 20 - 20 * fx.pos;
    var blur = 30 - 30 * fx.pos;
    H.css('box-shadow', 'inset 0 ' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1), inset 0 -' + blur + 'px ' + blur + 'px -' + 10 + 'px  rgba(255,255,255,1)');
  }
}

Road.prototype.lightAnimationDoneDone = function(H) {
  return function() {
    H.removeClass('inheritShadow');
    H.removeAttr('style');
  }
}

Road.prototype.createTile = function() {
  if (this.flags.createTile) {
    return;
  }
  this.flags.createTile = true;


  for (var i in this.childClass) {
    var className = '$'+this.childClass[i];
    this[className].css('box-shadow', 'inset 0 1px 0 0  rgba(255,255,255,1), inset 0 -1px 0 0 rgba(255,255,255,1)');
    this[className].addClass('inheritShadow');

    var animationStep = this.lightAnimationStep(this[className]);
    var animationDone = this.lightAnimationDone(this[className]);

    this[className].css('fontSize', 14);
    this[className].animate({
      fontSize: 100
    }, {
      duration: 500,
      step: animationStep,
      done: animationDone
    })
  }

  this.$buildings.append(this.$this);
}
