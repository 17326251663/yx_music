$("#musiclistParent").on("click", ".close", function (data) {
    $("#musiclistParent").html("");
});

$("#shareresource").click(function () {
    $("#musiclistParent").html('    <div id="musiclist">' +
        '        <div class="close">×</div>' +
        '        <br>' +
        '        <div class="row" style="width: 100%;">' +
        '            <div class="col-md-12">' +
        '                <p align="center">我的资源</p>' +
        '                <hr style="width: 104%;">' +
        '            </div>' +
        '        </div>' +
        '        <!--此为资源列表-->' +
        '        <div class="row" style="width: 100%;margin: 0;" id="mylist">' +
        '        </div>' +
        '    </div>');

    $.ajax({
        url: "/yx-music/getmyyun",
        method: "get",
        statusCode: {
            200: function (data) {
                $(data).each(function () {
                    if (resourceName=='聊天室'){
                        $("#mylist").append("<div class='col-md-3 onemusic' onclick='sendresource("+this.mid+")'>"+this.musicname+"</div>");
                    }else {
                        $("#mylist").append("<div class='col-md-3 onemusic' onclick='sendFriendResource("+this.mid+")'>"+this.musicname+"</div>");

                    }
                })
            }
        }

    })
});

function sendText() {

    $(".friendText").focus();

    var uid = $(".friendUid").val();
    var text = $(".friendText").val();

    if (/^\s*$/.test(text)){
        return;
    }

    if (text.indexOf('<')!=-1||text.indexOf('>')!=-1||text.indexOf('\\')!=-1||text.indexOf('/')!=-1){
        alert('字符中不允许包含<\\>/');
        return;
    }

    $.ajax({
        url: "/yx-friend/sendFriendText",
        method: "post",
        data:{
            text:text,
            uid:uid
        },
        statusCode: {
            200: function (data) {

                if (data == 'error') {
                    alert('你妈买菜必涨价');
                    return;
                }

                var list = $("#friendChatPage");

                list.append('<div class="col-md-12 row message">' +
                    '        <div class="col-md-11 myright"><span class="mytext">' + text + '</span></div>' +
                    '        <div class="col-md-1">' +
                    '            <img src="' + $('.lefttitle').prop('src') + '" class="tou">' +
                    '        </div>' +
                    '    </div>');

                $(".friendText").val("");
                scrollBottom();
            }
        }
    })

}

function sendFriendResource(mid){

    var uid = $(".friendUid").val();

    $.ajax({
        url: "/yx-friend/sendFriendResource/" + mid+"/"+uid,
        method: "get",
        statusCode: {
            200: function (data) {

                $("#musiclistParent").html("");

                var list = $("#friendChatPage");

                list.append("<div class='col-md-12 row message'>" +
                    "<div class='col-md-11 myright'>" +
                    "<span class='oneresource'><img src='"+data.imgurl+"' alt='' class='tou'> <span>"+data.musicname+"" +
                    "<span class='glyphicon glyphicon-play-circle mbo' aria-hidden='true' onclick='bofang2_1(this," + data.mid + ")'></span>" +
                    "<span class='mid' value='" + data.mid + "'></span>" +
                    "<span class='musicUrl' value='" + data.musicurl + "'></span>" +
                    "<span class='imgUrl' value='" + data.imgurl + "'></span>" +
                    "<span class='musicName' value='" + data.musicname + "'></span>" +
                    "<span class='singer' value='" + data.singer + "'></span>" +
                    "</span> </span>" +
                    "</div>" +
                    "<div class='col-md-1'><img src='"+$('.lefttitle').prop('src')+"'" +
                    " class='tou'>" +
                    "</div>" +
                    "</div>");

                scrollBottom();
            }
        }
    })
}


$(".friendList ul").click(function () {
    $(".sendBox").css("display","block");
    document.onkeydown = function () {
        if (event.keyCode === 13) {
            sendText();
        }
    }
});

function setMessageStatus(uid) {
    $.ajax({
        url:"/yx-friend/setMessageStatus/"+uid,
        method:"put"
    })
}

function scrollBottom() {
    /*获取完毕,拉取滚动条*/
    var divscll = document.getElementById('friendChatPage');
    divscll.scrollTop = divscll.scrollHeight;
}