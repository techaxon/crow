/**
 * Created by pchandramohan on 12/1/16.
 */

// User form submit
$("#submit").click(function () {
    $("#createForm").submit();
});

$("#usertable tr, a").click(function (e) {
    var $user = $(this).find("div").attr('id');
    var $reqUrl = '/deleteUser/' + $user;


    $.ajax({
        url: $reqUrl,
        type: 'GET',
        success: function (result) {

        }
    });
    e.stopPropagation();
});