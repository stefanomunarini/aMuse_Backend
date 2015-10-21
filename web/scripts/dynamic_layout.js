$.fn.getBgImage = function(callback) {
    var height = 0;
    var path = $(this).css('background-image').replace('url', '').replace('(', '').replace(')', '').replace('"', '').replace('"', '');
    var tempImg = $('<img />');
    tempImg.hide(); //hide image
    tempImg.bind('load', callback);
    $('body').append(tempImg); // add to DOM before </body>
    tempImg.attr('src', path);
    $('#tempImg').remove(); //remove from DOM
};

function set_all_layout() {
	var slide_width = $("#wrapper").width();
	var slide_height = $("#wrapper").height();

	$("#cover_image_wrapper").css({"width": slide_width-320, "height": slide_height,});
	$("#cover_image").css({"width": slide_width-360, "height": slide_height-40,});

	$(".image_wrapper_one_hor").css({"width": slide_width-40, "height": slide_height-290,});
	$(".content_one_hor").css({"width": slide_width-140});

	$(".image_wrapper_one_ver").css({"width": (slide_width/2)-40, "height": slide_height-40,});
	$(".content_one_ver").css({"width": (slide_width/2),});

	$(".image_two").css({"width": ((slide_width-60)/2),});

	$(".image_three").css({"width": ((slide_width-80)/3),});
}

function decide_layout(selected) {
    var imgs = selected.getElementsByClassName("tmp_image");
    var imgs_number = imgs.length;

    if(parseInt(imgs_number) == 1) {

    	var target = imgs[0];
    	$(target).getBgImage(function() {

		    if($(this).width() > $(this).height()) {
		    	$(selected).find(".tmp_content").attr('class', 'content_one_hor');
		    	$(selected).find(".tmp_title").attr('class', 'title_one_hor');
		    	$(selected).find(".tmp_author").attr('class', 'author_one');
		    	$(selected).find(".tmp_description").attr('class', 'description_one');
		    	$(selected).find(".tmp_comment").attr('class', 'comment_one');
		    	$(selected).find(".tmp_image_wrapper").attr('class', 'image_wrapper_one_hor');
		    	$(selected).find(".tmp_image").attr('class', 'image_one');
		    } else {
		    	$(selected).find(".tmp_content").attr('class', 'content_one_ver');
		    	$(selected).find(".tmp_title").attr('class', 'title_one_ver');
		    	$(selected).find(".tmp_author").attr('class', 'author_one');
		    	$(selected).find(".tmp_description").attr('class', 'description_one');
		    	$(selected).find(".tmp_comment").attr('class', 'comment_one');
		    	$(selected).find(".tmp_image_wrapper").attr('class', 'image_wrapper_one_ver');
		    	$(selected).find(".tmp_image").attr('class', 'image_one');
		    }

		    set_all_layout();
		});

	} else if(parseInt(imgs_number) === 2) {
		
		$(selected).find(".tmp_image_wrapper").find("div:nth-child(1)").attr('class', 'image_two');
		$(selected).find(".tmp_image_wrapper").find("div:nth-child(2)").attr('class', 'image_two');
		$(selected).find(".tmp_image_wrapper").find("div:nth-child(1)").css({"margin-right": 20,});
		$(selected).find(".tmp_content").attr('class', 'content_one_hor');
		$(selected).find(".tmp_title").attr('class', 'title_one_hor');
	  	$(selected).find(".tmp_author").attr('class', 'author_one');
	 	$(selected).find(".tmp_description").attr('class', 'description_one');
	 	$(selected).find(".tmp_comment").attr('class', 'comment_one');
	 	$(selected).find(".tmp_image_wrapper").attr('class', 'image_wrapper_one_hor');

	 	
	 	set_all_layout();
	} else if(imgs_number == 3) {

		$(selected).find(".tmp_image_wrapper").find("div:nth-child(1)").attr('class', 'image_three');
		$(selected).find(".tmp_image_wrapper").find("div:nth-child(2)").attr('class', 'image_three');
		$(selected).find(".tmp_image_wrapper").find("div:nth-child(3)").attr('class', 'image_three');

		$(selected).find(".tmp_image_wrapper").find("div:nth-child(1)").css({"margin-right": 20,});
		$(selected).find(".tmp_image_wrapper").find("div:nth-child(2)").css({"margin-right": 20,});

		$(selected).find(".tmp_content").attr('class', 'content_one_hor');
		$(selected).find(".tmp_title").attr('class', 'title_one_hor');
	  	$(selected).find(".tmp_author").attr('class', 'author_one');
	 	$(selected).find(".tmp_description").attr('class', 'description_one');
	 	$(selected).find(".tmp_comment").attr('class', 'comment_one');
	 	$(selected).find(".tmp_image_wrapper").attr('class', 'image_wrapper_one_hor');

	 	
	 	set_all_layout();
	}
}

$(document).ready(function () {
	$('ul li').each(function(i)
	{
	   decide_layout(this);
	});

});

$(window).resize(function () {
	set_all_layout();
});