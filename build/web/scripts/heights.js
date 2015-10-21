 $(document).ready(function () {
        var frazione = ($(window).height())/100;
        var width = $(window).width();       
        $("body").css({"height": ($(window).height())});
        $("#slider").css({"height": frazione*100, "width": width-130});
        $("#wrapper").css({"height": frazione*90, "margin-top": frazione*5});
        $("#previous").css({"height": (frazione*100)-130});
        $("#next").css({"height": (frazione*100)-130});
        
        /*aggiunti */
        var max_height = ($(window).height());
        var share_box_height = ($("#box_share").height());
        $("#popup_share").css({"height": max_height});
        $("#box_share").css({"margin-top": ((max_height-share_box_height)/2)});
        
      });
      $(window).resize(function () {
        var frazione = ($(window).height())/100;
        var width = $(window).width();
        var max_height = ($(window).height());
        $("body").css({"height": ($(window).height())});
        $("#slider").css({"height": frazione*100, "width": width-130});
        $("#wrapper").css({"height": frazione*90, "margin-top": frazione*5});
        $("#previous").css({"height": (frazione*100)-130});
        $("#next").css({"height": (frazione*100)-130});
        
        /*aggiunti */
        var max_height = ($(window).height());
        var share_box_height = ($("#box_share").height());
        $("#popup_share").css({"height": max_height});
        $("#box_share").css({"margin-top": ((max_height-share_box_height)/2)});
      });