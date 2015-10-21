/* JAVASCRIPT developed by dVruhero - UniTN - all rights reserved */

function click_event(trigger) {
			set_selected_exh(trigger.id);

			$("#content_wrapper").css({"opacity": 0});
			$("#title").css({"opacity": 0});
			$('html, body').animate({ scrollTop: 0 }, 0);

			$("#content_wrapper").transition({
				opacity: 100
			}, 1000, function() {
				this.clearQueue();
			});
			$("#title").transition({
				opacity: 100
			}, 1000, function() {
				this.clearQueue();
			});
}

function set_selected_exh(next_id) {

	var this_wrapper = $("#"+next_id);
	var prev_id = $("#selector").attr("title");
	var prev_wrapper = $("#"+prev_id);

	var prev_title = prev_wrapper.find(".exhibition_title");
	var prev_objects = prev_wrapper.find(".exhibition_objects");
	var next_title = this_wrapper.find(".exhibition_title");
	var next_objects = this_wrapper.find(".exhibition_objects");
	var all_exhibitions = document.getElementsByClassName("exhibition_wrapper");
	var all_exhibitions_length = all_exhibitions.length;
	var count = 0;
	

	// WORKING NO-ANIMATIONS

	$(prev_title).css({"height": 98, "border-bottom": "2px solid #660000", "visibility": "visible"});
	$(prev_objects).css({"position": "absolute", "visibility": "hidden"});

	$(this_wrapper).css({"margin-top": 0});
	$(next_title).css({"height": 0, "border-bottom": 0, "visibility": "hidden"});
	$(next_objects).css({"position": "relative", "visibility": "visible"});
	var this_title = this_wrapper.find(".exhibition_title");
	$("#title").text(this_title.text());

	var visible_height = this_wrapper.height();

	for(var i=1; i<=all_exhibitions_length; i++) {
		var not_visible = $("#content_wrapper li:nth-child("+i+")");
                var check = not_visible.prop("id");
		if(parseInt(check, 10) === parseInt(next_id, 10)) {
		} else {
			$(not_visible).css({"margin-top": visible_height+(104*count)});
			count++;
		}
	}


	$('#selector').prop('title', next_id);

}

$(document).ready(function () {
	var first_id = $("#selector").attr("title");
	set_selected_exh(first_id);
	
	$(".exhibition_wrapper").click(function () {
		var active_id = $("#selector").attr("title");
		var id = $(this).prop("id");
		if(parseInt(id,10) === parseInt(active_id,10)) {
		} else {
			click_event(this);
		}
	});

	$("#go_bottom").click(function () {
		var active_id = $("#selector").attr("title");
		
		var active_wrapper = $("#"+active_id);
		var visible_height = active_wrapper.height();

		$('html, body').animate({ scrollTop: visible_height }, 0);
	});
});

$(window).resize(function () {
	var active_id = $("#selector").attr("title");
	var active_wrapper = $("#"+active_id);
	var visible_height = active_wrapper.height();
	var all_exhibitions = document.getElementsByClassName("exhibition_wrapper");
	var all_exhibitions_length = all_exhibitions.length;
	var count = 0;

	for(var i=1; i<=all_exhibitions_length; i++) {
		var not_visible = $("#content_wrapper li:nth-child("+i+")");
		if(parseInt(not_visible.prop("id"), 10) == parseInt(active_id, 10)) {
		} else {
			$(not_visible).css({"margin-top": visible_height+(100*count)});
			count++;
		}
	}
});