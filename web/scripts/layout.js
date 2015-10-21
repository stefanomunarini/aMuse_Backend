function set_widths() {
	var spacer_dimension = 350; /*has to be >310*/
	var image_margin = (spacer_dimension-270);
	if($(window).width() > 1100) {
		var max_width = ($(window).width()); /*window width*/ 
	} else {
		var max_width = 1100;
	}
	var count_columns = Math.floor(max_width/spacer_dimension);	/*how many images can fit in one row?*/
	var width = (count_columns*spacer_dimension);	/*set width depending on number of images*/

	var guide = top_wrapper.getElementsByClassName("guide");
	var guide_number = guide.length;

	$("#content_wrapper").css({"width": width});
	$("#top_wrapper").css({"width": width-image_margin});
	$("#separator").css({"width": (width-image_margin)-(140*guide_number)});
	$("#red_line_wrapper").css({"width": width-image_margin});
	$(".spacer").css({"width": spacer_dimension});
	$(".spacer").css({"height": spacer_dimension});

	$(".exhibition_title").css({"width": width-image_margin, "margin-left": image_margin/2});

	var max_height = ($(window).height());
	var email_box_height = ($("#email_box").height());
	var modify_box_height = ($("#modify_box").height());
	var cover_box_height = ($("#cover_box").height());
        var photo_box_height = ($("#photo_box").height());
        var comment_box_height = ($("#comment_box").height());
        var warning_box_height = ($("#warning_box").height());
	
	$("#error_popup").css({"height": max_height});
        $("#error2_popup").css({"height": max_height});
        $(".error_message").css({"margin-top": ((max_height/2)-90)});
	$("#email_popup").css({"height": max_height});
	$("#email_box").css({"margin-top": ((max_height-email_box_height)/2)});
	$("#modify_popup").css({"height": max_height});
	$("#cover_popup").css({"height": max_height});
        $("#photo_popup").css({"height": max_height});
        $("#comment_popup").css({"height": max_height});
	$("#modify_box").css({"margin-top": ((max_height-modify_box_height)/2)});
	$("#book_description").css({"width": width-image_margin});
	$("#cover_box").css({"margin-top": ((max_height-cover_box_height)/2)});
        $("#photo_box").css({"margin-top": ((max_height-photo_box_height)/2)});
        $("#comment_box").css({"margin-top": ((max_height-comment_box_height)/2)});
        $("#warning_popup").css({"height": max_height});
	$("#warning_box").css({"margin-top": ((max_height-warning_box_height)/2)});
}

$(document).ready(function () {
	set_widths();
});

$(window).resize(function () {
	set_widths();
});