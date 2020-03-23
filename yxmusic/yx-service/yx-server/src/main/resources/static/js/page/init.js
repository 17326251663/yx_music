$(function () {
    /*加载各个页面*/
    myinit($("#left1"),"/index/left.html");
    myinit($("#right2"),"/index/right.html");
    myinit($("#bottom3"),"/index/bottom.html");
});

function myinit(ele,url) {
    $.ajax({
        url:url,
        method:"get",
        success:function (data) {
            $(ele).html(data);
        }
    })
}