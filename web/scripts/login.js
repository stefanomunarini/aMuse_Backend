function set_heights() {
	var doc_height = $(document).height();

	$('body').css({'height': doc_height});
}


$(document).ready(function () { 
	set_heights();
        
        var max_height = ($(window).height());
        var email_box_height = ($("#email_box").height());
        
        $("#email_popup").css({"height": max_height});
	$("#email_box").css({"margin-top": ((max_height-email_box_height)/2)});
        
        $("#forgot").click(function(){
                $("#email_popup").css({"visibility":"visible"});
                $("#email_err_input").focus();
        });
        
        $("#email_popup").click(function(){
                $(this).css({"visibility":"hidden"});
        });
        
        $("#email_box").click(function(e){
            e.stopPropagation();
        });
        
});

$(document).resize(function () { 
	set_heights();
});