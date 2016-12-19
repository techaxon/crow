/**
 * Created by pchandramohan on 12/1/16.
 */

// User form submit
$("#submit").click(function () {
    $("#createForm").submit();
});

$("#submit").click(function () {
    $("#createRoleForm").submit();
});

$("#usertable tr, a").click(function (e) {
    var $user = $(this).find("div").attr('id');
    var $reqUrl = '/deleteUser/' + $user;

/* TODO: need to change the request method from GET to DELETE */
    $.ajax({
        url: $reqUrl,
        type: 'GET',
        success: function (result) {

        }
    });
    e.stopPropagation();
});