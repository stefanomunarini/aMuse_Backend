$(document).ready(function () {

        $(".ics").click(function () {
           $(this).parent().parent().parent().css({"visibility": "hidden"});
           
        });

	$("#error_popup").click(function () {
		$(this).css({"visibility": "hidden"});
	});
        
        $("#error2_popup").click(function(){
           $(this).css({"visibility": "hidden"}); 
        });

	$("#email_popup").click(function () {
		$(this).css({"visibility": "hidden"});
	});

	$('#email_box').click(function(e) {
        e.stopPropagation();
        });
        
        $("#modify_popup").click(function () {
		$(this).css({"visibility": "hidden"});
	});
        $("#cover_popup").click(function () {
		$(this).css({"visibility": "hidden"});
	});
        $("#photo_popup").click(function () {
		$(this).css({"visibility": "hidden"});
	});
        
        $("#comment_popup").click(function () {
		$(this).css({"visibility": "hidden"});
	});
        
        $("#modify_popup1").click(function () {
		$(this).css({"visibility": "hidden"});
	});

	$('#modify_box').click(function(e) {
        e.stopPropagation();
        });
    	$('#modify_box1').click(function(e) {
        e.stopPropagation();
        });
        $('#cover_box').click(function(e) {
        e.stopPropagation();
        });
        $('#photo_box').click(function(e) {
        e.stopPropagation();
        });
        
        $('#comment_box').click(function(e) {
        e.stopPropagation();
        });
    
        $("#modify").click(function () {
			$("#modify_popup").css({"visibility": "visible"});                        		
	});
        $("#book_info").click(function () {
			$("#modify_popup").css({"visibility": "visible"});                        		
	});
        $("#modify1").click(function () {
			$("#modify_popup1").css({"visibility": "visible"});                        		
	});
        
        $("#cover").click(function () {
			$("#cover_popup").css({"visibility": "visible"});                        		
	});
        
        
        
        $(".add_comment").click(function () {
                        var id = $(this).find(".object_id");
                        var idw =$(id).attr("title");
			$("#comment_popup").css({"visibility": "visible"}); 
                        $(".idwork").val(idw);
                        $("#comment").focus();
	});
        
        $("#share_link").click(function(){
			$("#popup_share").css({"visibility": "visible"});
                        $("#url_input").focus();
                
        });
        
        $("#popup_share").click(function () {
		$(this).css({"visibility": "hidden"});   
	});

        $("#warning_popup").click(function () {
		$(this).css({"visibility": "hidden"});
	});
        
        $("#stop").click(function () {
		$("#warning_popup").css({"visibility": "hidden"});
	});

	$('#box_share').click(function(e) {
        e.stopPropagation();
        });
        
        $('#warning_box').click(function(e) {
        e.stopPropagation();
        });
        
        $("#menu_left_logged").mouseover(function(){
			$("#mouse_on").css({"visibility": "visible"});                        		
        });
        
        $("#menu_left_logged").mouseleave(function(){
			$("#mouse_on").css({"visibility": "hidden"});                        		
        }); 
        
        $("#popup_delete").click(function () {
		$(this).css({"visibility": "hidden"});
                $("#box_share").css({"visibility": "hidden"});
	});
        
        $("#flag").click(function(){
                $("#warning_popup").css({"visibility":"visible"});
        });    
});