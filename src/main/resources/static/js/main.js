/**
 * Created by canidmars on 6/23/17.
 */

(function ($) {
    "use strict";

    var request = $.ajax({
        url: "/posts.json"
    });

    request.done(function (posts) {

        var html = "", i;
        var $posts = $("#index-posts-flexbox");

        for (i = 0; i < posts.length; i++) {
            html += "<div class='post-container'><h1>" + posts[i].title + "</h1><p>" + posts[i].body + "</p></div>";
        }

        $posts.append(html);
    });


    $('#logout-button').hover(function() {
            $(this).css('color', 'olivedrab');
            console.log("test")
        },
        function() {
            $(this).css('color', '#4D3C35');
        });


})(jQuery);




