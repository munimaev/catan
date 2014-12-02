var Player = function(args) {
    if (!(args.hasOwnProperty('color'))) {
      throw {
        message: 'Недостаток аргументов color.'
      };
    }
    if (!(args.hasOwnProperty('isYou'))) {
      throw {
        message: 'Недостаток аргументов isYou.'
      };
    }
	this.args = args;
	this.isYou = args.isYou;
	this.flags = {
		createHTML : false,
	};
}
Player.prototype.interfaceYour = $('.interface.your');

Player.prototype.createHTML = function() {
  if (this.flags.createHTML) {
    return;
  }
  var isYouOrOpp = this.isYou ? 'you' : 'opp';
  var htmlClass = isYouOrOpp;
  var $this = $('<div />', {
    'class': htmlClass
  });
  $tr1 = $('<tr />');
  $tr1.append($('<td />',{text:'build'}));
  $tr1.append($('<td />',{text:'cost'}));
  $tr1.append($('<td />',{text:' '}));
  $tr1.append($('<td />',{text:'resourse'}));
  $tr1.append($('<td />',{text:' '}));
  $tr1.append($('<td />',{text:'card'}));
  $tr1.append($('<td />',{text:' '}));
  $tr1.append($('<td />',{text:'used'}));
  $tr1.append($('<td />',{text:' '}));
  $tr1.append($('<td />',{text:'points'}));

  $tr2 = $('<tr />');
  $tr2.append($('<td />',{text:'road'}));
  $tr2.append($('<td />',{text:'[][]'}));
  $tr2.append($('<td />',{rowspan:4}));
  $tr2.append($('<td />',{rowspan:4}));
  $tr2.append($('<td />',{rowspan:4}));
  $tr2.append($('<td />',{rowspan:4}));
  $tr2.append($('<td />',{rowspan:4}));
  $tr2.append($('<td />',{rowspan:4}));
  $tr2.append($('<td />',{rowspan:4}));
  $tr2.append($('<td />',{rowspan:4}));

  $tr3 = $('<tr />');
  $tr3.append($('<td />',{text:'village'}));
  $tr3.append($('<td />',{text:'[][][][]'}));


  $tr4 = $('<tr />');
  $tr4.append($('<td />',{text:'city'}));
  $tr4.append($('<td />',{text:'[][][][][]'}));

  $tr5 = $('<tr />');
  $tr5.append($('<td />',{text:'card'}));
  $tr5.append($('<td />',{text:'[][][]'}));

  var $table = $('<table />',{cellspacing:'1px',cellpadding:0})
  $table.append($tr1)
  $table.append($tr2)
  $table.append($tr3)
  $table.append($tr4)
  $table.append($tr5)

  $this.append($table);

  this.$this = $this;
  this.flags.createHTML = true;
}
