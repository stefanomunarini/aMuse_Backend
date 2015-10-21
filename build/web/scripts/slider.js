var count = 1;
var timer;

function set_slider_widths() {
	var spacer_dimension = 350; /*has to be >310*/
	var image_margin = (spacer_dimension-270);
	if($(window).width() > 800) {
		var max_width = ($(window).width()); /*window width*/ 
	} else {
		var max_width = 800;
	}
	var count_columns = Math.floor(max_width/spacer_dimension);	/*how many images can fit in one row?*/
	var width = (count_columns*spacer_dimension);
	var max_height = ($(window).height());
	var sub = slide.getElementsByTagName("li");
	var sub_number = sub.length;
	var thumbs_height = (max_height-185);
	var thumbs_li_height = ((thumbs_height-((sub_number-1)*4))/sub_number);
	if(thumbs_li_height > 150) {
		var thumbs_li_width = 150;
	} else {
		var thumbs_li_width = thumbs_li_height;
	}

	$("#thumbs li").css({"width": thumbs_li_width});
	$("#thumbs li").css({"height": thumbs_li_height});

	$("#slider_wrapper").css({"width": width-image_margin});
	$("#slide").css({"width": width-image_margin-thumbs_li_width-4});
	$("#slide").css({"margin-left": thumbs_li_width+4});
	$("#slide li").css({"width": width-image_margin-thumbs_li_width-4});

	$("#slider_wrapper").css({"height": max_height-185});
	$("#slide").css({"height": max_height-185});
	$("#slide li").css({"height": max_height-185});

	$("#left").css({"margin-top": ((max_height-210)/2)});
	$("#right").css({"margin-top": ((max_height-210)/2)});

	$(".description").css({"margin-top": (max_height-221)});
	$(".title").css({"margin-top": (max_height-310)});
}

function set_interactive() {
	var max_height = ($(window).height());
	var height = (max_height-185);
	var sub = slide.getElementsByTagName("li");
	var sub_number = sub.length;
	var distance = 0;
	var thumbs_height = $("#thumbs").height();
	var thumbs_li_height = (thumbs_height-((sub_number-1)*4))/sub_number;

	for(var i = 1; i<sub_number+1; i++) {
		$("#thumbs li:nth-child("+i+")").attr("id",i);
	}

	$("#right").click(function () {
		if(count < sub_number) {
			count++;
			distance -= height;
			$("#slide_ul").animate({
				top: distance
			}, function() {
			$("#slide_ul").clearQueue();
			});
		} else {
			count = 1;
			distance = 0;
			$("#slide_ul").animate({
				top: distance
			}, function() {
			$("#slide_ul").clearQueue();
			});
		}
	});

	$("#left").click(function () {
		if(count > 1) {
			count--;
			distance += height;
			$("#slide_ul").animate({
				top: distance
			}, function() {
			$("#slide_ul").clearQueue();
			});
		} else {
			count = sub_number;
			distance = -(height*(count-1));
			$("#slide_ul").animate({
				top: distance
			}, function() {
			$("#slide_ul").clearQueue();
			});
		}
	});

	$("#thumbs li").click(function () {
		var target = this.getAttribute('id');

		count = target;
		distance = -(height*(count-1));
		$("#slide_ul").animate({
			top: distance
		}, function() {
			$("#slide_ul").clearQueue();
		});	
	});

	timer = setInterval(function() {
    	if(count < sub_number) {
			count++;
			distance -= height;
			$("#slide_ul").animate({
				top: distance
			});
		} else {
			count = 1;
			distance = 0;
			$("#slide_ul").animate({
				top: distance
			});
		}
	}, 4000);

	$("#thumbs li").click(function () {
		clearInterval(timer);
		timer = setInterval(function() {
    	if(count < sub_number) {
			count++;
			distance -= height;
			$("#slide_ul").animate({
				top: distance
			});
		} else {
			count = 1;
			distance = 0;
			$("#slide_ul").animate({
				top: distance
			});
		}
		}, 4000);
	});

	$("#left").click(function () {
		clearInterval(timer);
		timer = setInterval(function() {
    	if(count < sub_number) {
			count++;
			distance -= height;
			$("#slide_ul").animate({
				top: distance
			});
		} else {
			count = 1;
			distance = 0;
			$("#slide_ul").animate({
				top: distance
			});
		}
		}, 4000);
	});

	$("#right").click(function () {
		clearInterval(timer);
		timer = setInterval(function() {
    	if(count < sub_number) {
			count++;
			distance -= height;
			$("#slide_ul").animate({
				top: distance
			});
		} else {
			count = 1;
			distance = 0;
			$("#slide_ul").animate({
				top: distance
			});
		}
		}, 4000);
	});

}


$(document).ready(function () {
	set_slider_widths();
	set_interactive();
});

$(window).resize(function () {
	location.reload();
});