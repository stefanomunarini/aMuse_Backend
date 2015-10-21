function refresh_count(c) {
	$("#counter").text(c);
}

$(document).ready(function () {
	var limit = 20;
	var count = 0;
	var position = 1000;
	var objects_selected = [];
	refresh_count(count);

	$(".object_wrapper").click(function () {
		var grey = "rgb(153, 153, 153)";
		var button = $(this).find(".object_button");
		var id = $(this).find(".object_id");
		var background = $(button).css("background-color");

		if(background == grey) {
			if(count == limit) {
				$("#error_popup").css({"visibility": "visible"});
			}
			if(count < limit) {
			count = count+1;
			refresh_count(count);
			$(button).css({"background-color" : "#660000"});
			$(button).css({"background-image" : "url(images/button_active.jpg)"});
			objects_selected[count-1] = ($(id).attr("title"));
			}
		} else {
			count = count-1;
			refresh_count(count);
			$(button).css({"background-color" : "#999999"});
			$(button).css({"background-image" : "url(images/button_passive.jpg)"});
			
			for(var i=0; i<limit; i++) {
				if(objects_selected[i] == ($(id).attr("title"))) {
					position = i;
				}
			}
			
			objects_selected.splice(position, 1);

		}
	});

	/*$("#counter").click(function () {
		console.log(objects_selected);
		console.log(position);
	});*/
       
        $("#create").click(function (){
            if(count==0){
                    $("#error2_popup").css({"visibility": "visible"});
            }
            if (count > 0){
                $("#email_popup").css({"visibility": "visible"});
                $("#selected_string").val(objects_selected.toString());
                $("#email_input").focus();
            }
            
        });

});