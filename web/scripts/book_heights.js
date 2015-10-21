 function set_dimensions() {
        var window_height = ($(window).height());
        var window_width = ($(window).width());

        if(window_height < 600) {
            window_height = 600;
        }
        if(window_width < 800) {
            window_width = 800;
        }

        if(window_width < window_height*1.5) {
            window_width = window_height*1.5;
        }
        if(window_width > window_height*2) {
            window_width = window_height*2;
        }

        var frazione = window_height/100;
        $("body").css({"height": window_height});
        $("#slider").css({"height": window_height, "width": ($(window).width())});


        var slider_width = $("#slider").width();
        $("#wrapper").css({"height": frazione*90, "margin-top": frazione*5, "width": window_width-200});

        if(window_width > window_height*1.5) {
            $("#wrapper").css({"margin": "auto", "margin-top": frazione*5,});
        } else {
            $("#wrapper").css({"margin-left": 100});
            $("#slider").css({"width": window_width});
        }

        var wrapper_width = $("#wrapper").width();
        var wrapper_height = $("#wrapper").height();

        $("#wrapper li").css({"width": wrapper_width-1, "height": wrapper_height-1});

        $("#menu").transition({rotate: "5deg"}, 0);
        $("#menu2").transition({rotate: "5deg"}, 0);

        $("#box_share").css({"margin-top": ($(window).height()-$("#box_share").height())/2});

 }


$(document).ready(function () {
    set_dimensions();    
});

$(window).resize(function () {
    set_dimensions()
});