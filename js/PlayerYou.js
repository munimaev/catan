var PlayerYou = function(args) {
  PlayerYou.superclass.constructor.apply(this, arguments);

  this.$wood = $('#wood');
  this.$clay = $('#clay');
  this.$wheat = $('#wheat');
  this.$sheep = $('#sheep');
  this.$iron = $('#iron');

  this.$notUsedknight = $('#knight');
  this.$notUsedplenty = $('#plenty');
  this.$notUsedmonopoly = $('#monopoly');
  this.$notUsedpoint = $('#point');
  this.$notUsedbuildroad = $('#buildroad');

};
extend(PlayerYou, Player);

PlayerYou.prototype.updateHTML = function() {

  var arrRes = ['wood', 'clay', 'wheat', 'sheep', 'iron'];
  var resourses = this.resourses;
  this.cardChanges(arrRes, resourses);

  var arrCard = ['knight', 'plenty', 'monopoly', 'point', 'buildroad'];
  
   var used = this.used;
  this.cardChanges(arrCard, used );

  var cards = this.cards;
  this.cardChanges(arrCard, cards, 'notUsed');

}
