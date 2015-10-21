/* JAVASCRIPT developed by dVruhero - UniTN - all rights reserved */

$(document).ready(function () {
        var working1 = false;
        var working2 = false;
        var working3 = false;
        var working4 = false;
        var next_on = true;
        var prev_on = true;
        var count = 1;
        var sub = wrapper.getElementsByTagName("li");
        var sub_number = sub.length;
          $("#next").click(function () {
            if(next_on && count <= sub_number) {
              next_on = false;
              prev_on = false;
              $("#next").css({"animation": "hide 1s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+count+")").css({"animation": "go_back 2s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+count+")").css({"animation-play-state": "running"});

              $("#next").css({"-moz-animation": "hide 1s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+count+")").css({"-moz-animation": "go_back 2s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+count+")").css({"-moz-animation-play-state": "running"});

              $("#next").css({"-ms-animation": "hide 1s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+count+")").css({"-ms-animation": "go_back 2s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+count+")").css({"-ms-animation-play-state": "running"});

              $("#next").css({"-webkit-animation": "hide 1s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+count+")").css({"-webkit-animation": "go_back 2s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+count+")").css({"-webkit-animation-play-state": "running"});

              $("#next").css({"-o-animation": "hide 1s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+count+")").css({"-o-animation": "go_back 2s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+count+")").css({"-o-animation-play-state": "running"});

              $("#wrapper li:nth-last-child("+count+")").css({"z-index": (-count)});
              if(count == 1) {
                $("#previous").css({"animation": "appear 1s ease-in-out 0s 1 normal"});
                $("#previous").css({"animation-play-state": "running"});

                $("#previous").css({"-moz-animation": "appear 1s ease-in-out 0s 1 normal"});
                $("#previous").css({"-moz-animation-play-state": "running"});

                $("#previous").css({"-ms-animation": "appear 1s ease-in-out 0s 1 normal"});
                $("#previous").css({"-ms-animation-play-state": "running"});

                $("#previous").css({"-webkit-animation": "appear 1s ease-in-out 0s 1 normal"});
                $("#previous").css({"-webkit-animation-play-state": "running"});

                $("#previous").css({"-o-animation": "appear 1s ease-in-out 0s 1 normal"});
                $("#previous").css({"-o-animation-play-state": "running"});

                $("#previous").css({"opacity": "1"});
              } else {
                $("#previous").css({"animation": "hide 1s ease-in-out 0s 1 normal"});
                $("#previous").css({"-moz-animation": "hide 1s ease-in-out 0s 1 normal"});
                $("#previous").css({"-ms-animation": "hide 1s ease-in-out 0s 1 normal"});
                $("#previous").css({"-webkit-animation": "hide 1s ease-in-out 0s 1 normal"});
                $("#previous").css({"-o-animation": "hide 1s ease-in-out 0s 1 normal"});
              }
              count = count+1;
              if(count <= sub_number) {
                setTimeout(function(){ 
                  $("#next").css({"animation": "do_nothing"});
                  $("#previous").css({"animation": "do_nothing"});

                  $("#next").css({"-moz-animation": "do_nothing"});
                  $("#previous").css({"-moz-animation": "do_nothing"});

                  $("#next").css({"-ms-animation": "do_nothing"});
                  $("#previous").css({"-ms-animation": "do_nothing"});

                  $("#next").css({"-webkit-animation": "do_nothing"});
                  $("#previous").css({"-webkit-animation": "do_nothing"});

                  $("#next").css({"-o-animation": "do_nothing"});
                  $("#previous").css({"-o-animation": "do_nothing"});

                  next_on = true;
                }, 1000); 
              }
              if(count > sub_number) {
                setTimeout(function(){
                  $("#next").css({"animation-play-state": "paused"}); 
                  $("#next").css({"-moz-animation-play-state": "paused"}); 
                  $("#next").css({"-ms-animation-play-state": "paused"}); 
                  $("#next").css({"-webkit-animation-play-state": "paused"}); 
                  $("#next").css({"-o-animation-play-state": "paused"}); 

                  $("#next").css({"opacity": "0"});

                  $("#previous").css({"animation": "do_nothing"});
                  $("#previous").css({"-moz-animation": "do_nothing"});
                  $("#previous").css({"-ms-animation": "do_nothing"});
                  $("#previous").css({"-webkit-animation": "do_nothing"});
                  $("#previous").css({"-o-animation": "do_nothing"});
                }, 800); 
              }
              if(!working1) {
                working1 = true;
                setTimeout(function(){ 
                  if(!working2) {
                    prev_on = true;
                  }
                  working1 = false;
                }, 2000); 
              } else {
                working2 = true;
                setTimeout(function(){ 
                  if(!working1) {
                    prev_on = true;
                  }
                  working2 = false;
                }, 2000); 
              }
            };
          });

          $("#previous").click(function () {
            if(prev_on && count > 1) {
              next_on = false;
              prev_on = false;
              $("#previous").css({"animation": "hide 1s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+(count-1)+")").css({"animation": "go_front 2s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+(count-1)+")").css({"animation-play-state": "running"});

              $("#previous").css({"-moz-animation": "hide 1s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+(count-1)+")").css({"-moz-animation": "go_front 2s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+(count-1)+")").css({"-moz-animation-play-state": "running"});

              $("#previous").css({"-ms-animation": "hide 1s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+(count-1)+")").css({"-ms-animation": "go_front 2s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+(count-1)+")").css({"-ms-animation-play-state": "running"});

              $("#previous").css({"-webkit-animation": "hide 1s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+(count-1)+")").css({"-webkit-animation": "go_front 2s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+(count-1)+")").css({"-webkit-animation-play-state": "running"});

              $("#previous").css({"-o-animation": "hide 1s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+(count-1)+")").css({"-o-animation": "go_front 2s ease-in-out 0s 1 normal"});
              $("#wrapper li:nth-last-child("+(count-1)+")").css({"-o-animation-play-state": "running"});

              $("#wrapper li:nth-last-child("+(count-1)+")").css({"z-index": (1000-count)});
              if(count == sub_number+1) {
                $("#next").css({"animation": "appear 1s ease-in-out 0s 1 normal"});
                $("#next").css({"animation-play-state": "running"});

                $("#next").css({"-moz-animation": "appear 1s ease-in-out 0s 1 normal"});
                $("#next").css({"-moz-animation-play-state": "running"});

                $("#next").css({"-ms-animation": "appear 1s ease-in-out 0s 1 normal"});
                $("#next").css({"-ms-animation-play-state": "running"});

                $("#next").css({"-webkit-animation": "appear 1s ease-in-out 0s 1 normal"});
                $("#next").css({"-webkit-animation-play-state": "running"});

                $("#next").css({"-o-animation": "appear 1s ease-in-out 0s 1 normal"});
                $("#next").css({"-o-animation-play-state": "running"});

                $("#next").css({"opacity": "1"});
              } else {
                $("#next").css({"animation": "hide 1s ease-in-out 0s 1 normal"});
                $("#next").css({"-moz-animation": "hide 1s ease-in-out 0s 1 normal"});
                $("#next").css({"-ms-animation": "hide 1s ease-in-out 0s 1 normal"});
                $("#next").css({"-webkit-animation": "hide 1s ease-in-out 0s 1 normal"});
                $("#next").css({"-o-animation": "hide 1s ease-in-out 0s 1 normal"});
              }
              count = count-1;
              if(count > 1) {
                setTimeout(function(){ 
                  $("#previous").css({"animation": "do_nothing"});
                  $("#next").css({"animation": "do_nothing"});

                  $("#previous").css({"-moz-animation": "do_nothing"});
                  $("#next").css({"-moz-animation": "do_nothing"});

                  $("#previous").css({"-ms-animation": "do_nothing"});
                  $("#next").css({"-ms-animation": "do_nothing"});

                  $("#previous").css({"-webkit-animation": "do_nothing"});
                  $("#next").css({"-webkit-animation": "do_nothing"});

                  $("#previous").css({"-o-animation": "do_nothing"});
                  $("#next").css({"-o-animation": "do_nothing"});

                  prev_on = true;
                }, 1000); 
              }
              if(count == 1) {
                setTimeout(function(){ 
                  $("#previous").css({"animation-play-state": "paused"});
                  $("#previous").css({"-moz-animation-play-state": "paused"});
                  $("#previous").css({"-ms-animation-play-state": "paused"});
                  $("#previous").css({"-webkit-animation-play-state": "paused"});
                  $("#previous").css({"-o-animation-play-state": "paused"});

                  $("#previous").css({"opacity": "0"});

                  $("#next").css({"animation": "do_nothing"});
                  $("#next").css({"-moz-animation": "do_nothing"});
                  $("#next").css({"-ms-animation": "do_nothing"});
                  $("#next").css({"-webkit-animation": "do_nothing"});
                  $("#next").css({"-o-animation": "do_nothing"});
                }, 800); 
              }
              if(!working3) {
                working3 = true;
                setTimeout(function(){ 
                  if(!working4) {
                    next_on = true;
                  }
                  working3 = false;
                }, 2000); 
              } else {
                working4 = true;
                setTimeout(function(){ 
                  if(!working3) {
                    next_on = true;
                  }
                  working4 = false;
                }, 2000); 
              }
            };
          });
      });