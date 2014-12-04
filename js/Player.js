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
  this.$this = $('#' + args.role);

  this.$knight = $('#' + args.role + 'knight');
  this.$plenty = $('#' + args.role + 'plenty');
  this.$monopoly = $('#' + args.role + 'monopoly');
  this.$point = $('#' + args.role + 'point');
  this.$buildroad = $('#' + args.role + 'buildroad');


	this.flags = {
		createHTML : false,
	};
  this.resourses;
  this.cards;
  this.cused;
}


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
}

Player.prototype.updateCountCard = function($link, newValue) {
  console.log(this.role)
  var doneFunc = this.updateCountCardDone($link, newValue);
  $link.animate({
    "font-size" : "10px"
  },{
    duration: 400,
    done : doneFunc
  })  
}

Player.prototype.updateCountCardDone = function($link, newValue) {
  
  return function() {
    $link.html(newValue);
    $link.animate({
      "font-size": "40px"
    }, {
      duration: 100
    })
  }
}

Player.prototype.cardIn = function($link, className) {
  var $div = $('<div />', {
  });
  $div.css({
    'height': '80px',
    'width': '0px',
    'float': 'left'
  })

  $link.append($div);

  var stepFunction = Hexagon.prototype.lightAnimationStep($div)
  var doneFunction = Hexagon.prototype.lightAnimationDone($div, $div, 'card ' + className);
  $div.animate({'width':'56px'},{
    duration: 600,
    step:stepFunction,
    done: doneFunction
  })
  // $link.append($('<div />', {
  //   class: 'card ' + className
  // }))
}

Player.prototype.cardOut = function($link) {
  $($link).hide(600, function() {
    $link.remove()
  });
  
}

Player.prototype.cardChanges = function(arr,resourses, classPrefix) {
  var classPrefix = classPrefix || '';
  for (var r in arr) {
    if (!(resourses.hasOwnProperty(arr[r]))) {
      debugger;
    }
    console.log(this.role , '$' + classPrefix + arr[r])
    var links = this['$' + classPrefix + arr[r]].children();

    if (links.length > resourses[arr[r]]) {
      var diff = links.length - resourses[arr[r]];
      for (var i  = 0; i< diff; i++) {
        this.cardOut(links[i]);
      }
    }
    if (links.length < resourses[arr[r]]) {
      var diff = resourses[arr[r]] - links.length;   
      for (var i  = 1; i<= diff; i++) {
        this.cardIn(this['$' + classPrefix + arr[r]], arr[r]);
      }  
    }
  }

}

