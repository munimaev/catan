var PlayerOpp = function(args) {
  PlayerOpp.superclass.constructor.apply(this, arguments);

  this.$back = $('#'+this.role + ' .card.back');
  this.$special = $('#'+this.role + ' .card.special');
};
extend(PlayerOpp,Player);



PlayerOpp.prototype.updateHTML = function() {
  var curerntBack = this.$back.html();
  var newBack = '×' + this.resourses;
  if (newBack !== curerntBack) {
    this.updateCountCard(this.$back, newBack);
  }

  var curerntSpecial = this.$special.html();
  var newSpecial = '×' + this.cards;
  if (newSpecial !== curerntSpecial) {
    this.updateCountCard(this.$special, newSpecial);
  }

  console.log(this.used, this)
  var arrCard = ['knight', 'plenty', 'monopoly', 'point', 'buildroad'];
  var used = this.used;
  this.cardChanges(arrCard, used);
}
