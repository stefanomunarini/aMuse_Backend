/* JAVASCRIPT developed by dVruhero - UniTN - all rights reserved */

var active = false;

function set_depth() {
	var sub = wrapper.getElementsByTagName("li");
    var sub_number = sub.length;
    for(var i = 0; i < sub_number; i++) {
		var selected = sub[i];
		$(selected).css({"z-index": 51+i});
	}
}

function hide(element) {
	$(element).animate({
		opacity: 0
	});
}

function set_animation() {
	var sub = wrapper.getElementsByTagName("li");
    var sub_number = (sub.length-1);
    var count = sub_number;
    
	$("#right").click(function () {
		if(sub_number > 0) {
			var slide_width = $("#wrapper li").width();

			var selected = sub[count];

			$(selected).transition({
					x: slide_width+50,
					y: -10,
					rotate: '2deg',
			}, 700, function() {
				this.css({"z-index": (50-(sub_number-count))});
				count--;
				if(count < 0) {
					count = sub_number;
					set_depth();
				}
			});
			$(selected).transition({
					x: 0,
					y: 0,
					rotate: '0deg',
			}, 700, function() {
				this.clearQueue();
			});
		}
	});

	$("#left").click(function () {
		if(sub_number > 0) {
			var slide_width = $("#wrapper li").width();

			var new_count = count+1;

			if(new_count > sub_number) {
				new_count = 0;
				set_depth();
			}

			var selected = sub[new_count];

			$(selected).transition({
					x: slide_width+50,
					y: -10,
					rotate: '2deg',
			}, 700, function() {
				this.css({"z-index": (52+(sub_number+new_count))});
				count++;
				if(count > sub_number) {
					count = 0;
				}
			});
			$(selected).transition({
					x: 0,
					y: 0,
					rotate: '0deg',
			}, 700, function() {
				this.clearQueue();
			});
		}
	});


}

function set_options() {

	$("#options_link").click(function () {
		if(!active) {

			$("#menu2").transition({
					x: 155,
					y: 0,
					rotate: '-5deg',
			}, function() {
				this.clearQueue();
				active = true;
			});

		} else {
			$("#menu2").transition({
					x: 0,
					y: 0,
					rotate: '5deg',
			}, function() {
				this.clearQueue();
				active = false;
			});

			
		}
	});

}

$(document).ready(function () {

	set_animation();
	set_depth();
	set_options();

});

$(window).resize(function () {
    if(active) {
			$("#menu2").transition({
					x: 155,
					y: 0,
					rotate: '-5deg',
			}, 0);
	}
});
