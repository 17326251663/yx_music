<!DOCTYPE html>
<html lang="en">
<head>
    <title>微享云音</title>
    <link rel="stylesheet" href="../css/APlayer.min.css">
    <link rel="stylesheet" type="text/css" href="../css/index.css">
    <link rel="icon" href="../start/SynLogo.ico">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <script src="../js/jquery-2.1.0.min.js"></script>
    <script src="../js/bootstrap.js"></script>
    <!--功能模块js-->
    <script src="../js/indexActon.js"></script>
    <script src="../js/rf.js"></script>
    <style>
        @font-face {
            font-family: 'icomoon';
            src: url('../fonts/icomoon.eot?a8rqf0');
            src: url('../fonts/icomoon.eot?a8rqf0#iefix') format('embedded-opentype'),
            url('../fonts/icomoon.ttf?a8rqf0') format('truetype'),
            url('../fonts/icomoon.woff?a8rqf0') format('woff'),
            url('../fonts/icomoon.svg?a8rqf0#icomoon') format('svg');
            font-weight: normal;
            font-style: normal;
        }

        * {
            margin: 0;
            padding: 0;
        }

        #nav {
            left: -270px;
            border: 1px #0000001c solid;
            position: absolute;
            height: 99.6%;
            cursor: pointer;
            box-shadow: #a8a8a8 3px 6px 7px -1px;
            background: linear-gradient(135deg, white 0%, #009688 100%);
        }

        #navb {
            /*background-color: rgb(255, 255, 255);*/
            border: 1px #0000001c solid;
            height: 711px;
            cursor: pointer;
            box-shadow: #a8a8a8 3px 6px 7px -1px;
            margin: 0;
        }

        #nav li, #navb li {
            text-align: center;
            list-style: none;
            line-height: 60px;
            overflow: hidden;
        }

        #nav li:hover, #navb li:hover {
            /*background-color: #a8a8a8;*/
            transition: all 0.2s linear;
            box-shadow: #a8a8a8 -1px 1px 30px -2px;
        }

        i {
            font-style: normal;
            font-family: 'icomoon';
        }

        i:hover {
            color: white;
        }

        #xiangqing {
            position: absolute;
            width: 75px;
            /* height: 0px; */
            /* size: 10px; */
            font-size: 13px;
            color: #000000b5;
            /* text-align: center; */
            background-color: rgb(255, 255, 255);
            border: none;
            left: 40px;
            top: 11px;
        }

        #xiangqing:active {
            border: none;
        }

        #lefthover {
            z-index: 999;
            position: fixed;
            top: 50%;
            left: -3px;
            margin-top: -50px;
            width: 33px;
            height: 100px;
            background-color: rgba(0, 0, 7, 0.37);
            border-radius: 0px 34px 34px 0;
            box-sizing: border-box;
            border: #a1a1a1 1px solid;
        }

        #lefthover::before {
            z-index: 1000;
            content: "";
            top: 50%;
            left: 12px;
            position: fixed;
            width: 8px;
            margin-top: -25px;
            height: 50px;
            background-color: rgb(192, 192, 192);
            border-radius: 15px;
        }

        #nav:hover, #navb:hover {
            transition: 0.5s all linear;
            cursor: pointer;
            left: 0;
        }

        #nav:hover {
            z-index: 999;
        }

        .panel-default > .panel-heading {
            background-color: #17c1425c !important;
        }
        a{
            text-decoration: none;
        }
        #tou2{
            position: fixed;
            right: 50px;
            top: 22px;
            z-index: 100;
            padding: 5px;
            border: #00000087 3px double;
            border-radius: 50%;
        }
        .firendMessage{
            color: white;
            background-color: red;
            border-radius: 50%;
            width: 54px;
            height: 20px;
            padding: 0 2%;
            box-shadow: #724c4c 3px 2px 7px 1px;
        }
    </style>
</head>
<body style="overflow: hidden;width: 100%;height: 100%;position: relative;">

<div class="row" style="overflow: hidden">
    <ul id="nav" class="col-md-12 col-sm-12 col-xs-12 leftlist">
        <li style="height: 118px;background-color:rgba(255,80,204,0);border-bottom: 1px #a8a8a8 solid">
            <!--左拉框-->
            <span id="lefthover"></span>

            <div style="margin: 10px auto">
                <img src="../start/q3.jpg" alt="用户头像" style="width: 40px;border-radius: 50%" class="lefttitle">
            </div>
            <div class="row">
                <div class="col-md-6" style="font-size: 12px;">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-default" style="padding: 4px;position: absolute;font-size: 12px;top: 11px;"><a href="javascript:MysafetyMsg()" >账户安全</a>
                    </button>
                    <button type="button" class="btn btn-default" style="padding: 4px;font-size: 12px;position: relative;top: -6px;left: 66px;">
                        <a href="javascript:myMsg()" >用户详情</a>
                    </button>
                </div>
                <a href="javascript:loginout()">
                    <div class="" style="font-size: 12px;display: inline">退出</div>
                </a>
            </div>
        </li>
        <li onclick="return initMusic(1,0,'',this)"><i></i><span>搜索全部</span></li>
        <li onclick="mycollect(1)"><i></i><span>我的收藏</span>

<!--        <li><i></i><span>发现音乐</span></li>-->
        </li>
        <li onclick="downloadHotList()"><i style="color: red"></i><span>下载热榜</span>
        </li>
        <li onclick="return initChatPage()"><i></i><span>聊天室</span>
        </li>
        <li onclick="myMV()"><i></i>MV</li>
        </li>
        </li>
        <li onclick="lmessage()"><i></i><span>留言板</span>
        </li>
    </ul>

    <ul id="navb" class="col-md-12 col-sm-12 col-xs-12 col-lg-12 leftlist">
        <li style="margin: 33px 0 24px 0px;border: none;box-shadow: none;vertical-align: middle;font-size: 22px;font-family: cursive;">
            <img src="../images/logo.gif" alt="" style="margin-top: -6px">微享云音
        </li>
        <hr>
        <li onclick="return initMusic(1,0,'',this)" id="index"><i></i><span>共享云音</span>

        <li onclick="cookieList()"><i></i><span>播放历史</span>
        <li onclick="myFriend()"><i></i>朋友<span class="" id="FriendMessageNum"></span></li>
        <li onclick="return uploadfunciton()"><i></i><span>上传音乐</span>

        <li><i></i></li>
        <br>
        <hr>
        <br>
        <li onclick="getmyyns()"><i></i>我的音乐云盘</li>
    </ul>
    <a href="javascript:myMsg()" id="tou2"><img src="../start/q3.jpg" alt="用户头像" style="width: 40px;border-radius: 50%" class="lefttitle"></a>
</div>
<script>
    function sub(ele) {

        var name = $("#exampleInputEmail2");
        var pwd = $("#exampleInputEmail3");

        //判断姓名
        var regex1 = /^\s*$/;
        if (regex1.test(name.val())) {
            name.siblings("span").html("姓名不能为空");
            return false;
        }
        name.siblings("span").html("");
        //判断密码
        var regex2 = /^\w{1,}$/;
        if (!regex2.test(pwd.val())) {
            pwd.siblings("span").html("密码由字母数字组成");
            return false;
        }

        pwd.siblings("span").html("");

        //调用登录
        $.post("/user?method=updateUser", $(ele).serialize(), function (data) {

            if (data != "修改密码") {
                alert("账户修改成功");
            } else {
                location.href = "/index.html";
            }

        });
        return false;

    }

    $(function () {
        obtainlist();
    });

    /*这是总资源列表*/
    function obtainlist() {
        ify();
    }

    /*初始化音乐列表*/
    function initMusic(num, ify, name, ele) {

        $(".leftlist li").css("backgroundColor","rgba(250,250,250,0)");
        $("#index").css("backgroundColor","#c0c0c0");

        if (ele != undefined) {
            $(ele).css("backgroundColor", "rgba(127,255,153,0.56)");
            $(ele).siblings().css("backgroundColor", "rgba(250,250,250,0)");
        }

        if (num == 1 && ify != undefined) {
            $("#title input[name=num]").val(num);
            $("#title input[name=ifyid]").val(ify);
        } else  {
            $("#title input[name=num]").val(num);
        }
        if (name != undefined) {
            $(".ify").css("backgroundColor", "rgba(250,250,250,0)");
            $(".ify:first").css("backgroundColor", "rgba(127,255,153,0.56)");

            $("#musicname1").val($("#musicname0").val());
        }

        $.ajax({
            url: "/yx-music/music",
            method: "post",
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            data: JSON.stringify($("#titlelist").serializeJson()),
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            statusCode: {
                200: function (data) {
                    /*获取到标签*/
                    var list = $("#list");
                    /*每次重新获取音乐列表之前先把标签内容清空*/

                    list.html("");

                    if (data.list.length == 0) {

                        list.html("<h4>暂无资源!</h4>")

                        return false;
                    }

                    /*添加内容(歌曲)*/
                    $(data.list).each(function () {
                        /* 这里是歌单的一些隐藏信息,如图片路径,图片id,歌曲路径&ndash;*/
                        list.append(
                            " <div class='panel panel-default' ondblclick='window.open(\""+SERVERURL+"/msg/msg.html?mid="+this.mid+"\",\"_blank\")'> " +
                            "<div class='panel-heading mheader'>歌手:" + this.singer + "<span class='updateTime' style='position: relative'>更新时间:" + time(this.uploadtime) + "</span></div> " +
                            "<div class='panel-body'>" +
                            "歌曲名称: " + this.musicname +
                            "<span class='collect' style='font-family: cursive' onclick='collectMusic("+this.mid+")'><i class='bo_i'></i>收藏</span>" +
                            "<span style='font-family: cursive' class='bo' onclick='bofang(this," + this.mid + ")'>播放:<i class='bo_i'></i></span>" +
                            "<a href='" + this.musicurl + "' onclick='return downloads(" + this.mid + ")' download='" + this.musicname + "'><span style='font-family: cursive' class='bo' >下载:<i></i></span></a>" +
                            " <span class='mid' value='" + this.mid + "'></span>" +
                            " <span class='musicUrl' value='" + this.musicurl + "'></span> " +
                            "<span class='imgUrl' value='" + this.imgurl + "'></span>" +
                            "<span class='musicName' value='" + this.musicname + "'></span>"
                            + "<span class='singer' value='" + this.singer + "'></span> </div>"
                        );
                    });
                    list.append('<div class="col-md-12 col-lg-12 col-sm-12"><nav style="font-size: 17px;font-family: cursive;"> <ul class="pager" id="pager"></ul> </nav></div>');

                    if (!data.isFirstPage) {
                        $("#pager").append('<li style="/*left:-80px;position: relative;*/"><a href="#" onclick="page(' + data.prePage + ')"><上一页</a></li>');
                    }

                    if (!data.isLastPage) {
                        $("#pager").append('<li><a href="#" onclick="page(' + data.nextPage + ')">下一页></a></li>');
                    }

                    $("#pager").append('<span>当前第' + data.pageNum + '页,共' + data.pages + '页</span>&nbsp;&nbsp;前往<input type="text" style="border: 0;border-bottom: black 1px solid;width: 20px;outline: none;" value="' + data.pageNum + '" id="gonum"/>页<button onclick="page(undefined,' + data.lastPage + ')" class="btn btn-default" style="position: relative;left: 18px;">前往</button>');

                    return false;
                },
                500: function () {
                    return false;
                }

            }
        });

        return false;
    }

    /*初始化分类列表*/
    function ify() {
        $.ajax({
            url: "/yx-music/ify",
            method: "get",
            dataType: "json",
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
            statusCode: {
                200: function (data) {
                    var title = $("#title h1");
                    title.html("<button onclick='return initMusic(1,0,undefined,this)' class='btn btn-default ify touMing'>全部</button>");
                    $(data).each(function () {
                        title.append("<button onclick='return initMusic(1," + this.ifyid + "," + undefined + ",this)' class='btn btn-default ify touMing'>" + this.ifyname + "</button>")
                    });
                },
                500: function () {

                }
            }
        })
    }

    function time(time) {
        var date = new Date(time);
        return date.getFullYear() + "/" + (date.getMonth()+1) + "/" + date.getDate();
    }

    //下载次数统计
    function downloads(mid) {

        if (!confirm("您确定要下载吗?")) {
            return false;
        }

        $.ajax({
            url: "/yx-up/uploadm/" + mid,
            method: "get",
            success: function (data) {

            }
        })

    }


    //浏览历史
    function cookieList() {
        $.ajax({
            url: "/yx-music/recently",
            method: "get",
            dataType: "json",
            statusCode: {
                200: function (data) {
                    /*获取到标签*/
                    var list = $("#list");
                    /*每次重新获取音乐列表之前先把标签内容清空*/

                    list.html("");
                    /*添加内容(歌曲)*/
                    $(data).each(function () {
                        /* 这里是歌单的一些隐藏信息,如图片路径,图片id,歌曲路径&ndash;*/
                        list.append(
                            " <div class='panel panel-default' ondblclick='window.open(\""+SERVERURL+"/msg/msg.html?mid="+this.mid+"\",\"_blank\")'> " +
                            "<div class='panel-heading mheader'>歌手:" + this.singer + "<span class='updateTime' style='position: relative'>更新时间:" + time(this.uploadtime) + "</span></div> " +
                            "<div class='panel-body'>" +
                            "歌曲名称: " + this.musicname +
                            "<span class='collect' style='font-family: cursive' onclick='collectMusic("+this.mid+")'><i class='bo_i'></i>收藏</span>" +
                            "<span style='font-family: cursive' class='bo' onclick='bofang(this," + this.mid + ")'>播放:<i class='bo_i'></i></span>" +
                            "<a href='" + this.musicurl + "' onclick='return downloads(" + this.mid + ")' download='" + this.musicname + "'><span style='font-family: cursive' class='bo' >下载:<i></i></span></a>" +
                            " <span class='mid' value='" + this.mid + "'></span>" +
                            " <span class='musicUrl' value='" + this.musicurl + "'></span> " +
                            "<span class='imgUrl' value='" + this.imgurl + "'></span>" +
                            "<span class='musicName' value='" + this.musicname + "'></span>"
                            + "<span class='singer' value='" + this.singer + "'></span> </div>"
                        );
                    });

                    if (data.length == 0) {
                        list.html("<h4>暂无资源!</h4>")
                    }
                }
            }
        })
    }

    //公共评论区
    function lmessage() {
        $.ajax({
            url: "/index/liuyan.html",
            method: "get",
            success: function (data) {
                /*获取到标签*/
                var list = $("#list");
                /*每次重新获取列表之前先把标签内容清空*/
                list.html(data);
                list.append("请点击右上角进行反馈");
            }
        })
    }

    //留言
    function ly() {
        $.ajax({
            url: "/yx-feedback/up",
            method: "put",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify($("#lyform").serializeJson()),
            statusCode: {
                204: function () {
                    getly(1, 1);
                }
            }

        });

        return false;
    }

    //展示前十个留言
    function getly(num, order) {
        $.ajax({
            url: "yx-feedback/get/" + num + "/" + order,
            method: "get",
            statusCode: {
                200: function (data) {

                    var list = $("#list");

                    list.html("");

                    $(data.list).each(function () {
                        list.append("<div class='panel panel-success' style='width: 90%'>" +
                            "  <div class='panel-body'>标题:" +
                            this.messagename +
                            "  </div>" +
                            " <div class='panel-footer  panel-success' style='height: 200px'><div class='form-control'>反馈人:" + this.uname + "</div><div class='form-control'>反馈时间:" + this.datetime + "</div><textrea class='form-control' col='30' row='10' style='width: 100%;height:60%;overflow-wrap: break-word'><span>反馈内容:</span>" + this.textarea + "</textrea></div>" +
                            "</div>");
                    })
                }
            }
        })
    }

    //收藏
    function collectMusic(mid) {
        $.ajax({
            url: "/yx-music/collectMusic/" + mid,
            method: "put",
            dataType:"text",
            statusCode: {
                201:function (data) {
                    if (data=='success'){
                        alert('收藏成功');
                    } else {
                        alert('收藏失败,已收藏');
                    }
                }
            }
        });
        return false;
    }

    //取消收藏
    function nocollectMusic(mid) {
        $.ajax({
            url: "/yx-music/collectMusic/" + mid,
            method: "delete",
            dataType:"json",
            statusCode: {
                204:function () {
                        alert('已取消收藏');
                    mycollect(1);
                }
            }
        });
        return false;
    }

    //我的收藏
    function mycollect(num,lastPage) {

        if (lastPage != undefined) {

            var val = $("#gonum").val();

            if (val > lastPage||val<1) {
                alert("请正常操作哦");
                return false;
            }

            num = val;

        }

        $.ajax({
            url:"/yx-music/getMyCollect/"+num,
            method:"get",
            dataType:"json",
            statusCode:{
                200:function (data) {
                    /*获取到标签*/
                    var list = $("#list");
                    /*每次重新获取音乐列表之前先把标签内容清空*/

                    list.html("");

                    if (data.list.length == 0) {

                        list.html("<h4>暂无收藏!</h4>")

                        return false;
                    }

                    /*添加内容(歌曲)*/
                    $(data.list).each(function () {
                        /* 这里是歌单的一些隐藏信息,如图片路径,图片id,歌曲路径&ndash;*/
                        list.append(
                            " <div class='panel panel-default' ondblclick='window.open(\""+SERVERURL+"/msg/msg.html?mid="+this.mid+"\",\"_blank\")'> " +
                            "<div class='panel-heading mheader'>歌手:" + this.singer + "<span class='updateTime' style='position: relative'>更新时间:" + time(this.uploadtime) + "</span></div> " +
                            "<div class='panel-body'>" +
                            "歌曲名称: " + this.musicname +
                            "<span class='collect' style='font-family: cursive' onclick='nocollectMusic("+this.mid+")'><i class='bo_i'></i>取消收藏</span>" +
                            "<span style='font-family: cursive' class='bo' onclick='bofang(this," + this.mid + ")'>播放:<i class='bo_i'></i></span>" +
                            "<a href='" + this.musicurl + "' onclick='return downloads(" + this.mid + ")' download='" + this.musicname + "'><span style='font-family: cursive' class='bo' >下载:<i></i></span></a>" +
                            " <span class='mid' value='" + this.mid + "'></span>" +
                            " <span class='musicUrl' value='" + this.musicurl + "'></span> " +
                            "<span class='imgUrl' value='" + this.imgurl + "'></span>" +
                            "<span class='musicName' value='" + this.musicname + "'></span>"
                            + "<span class='singer' value='" + this.singer + "'></span> </div>"
                        );
                    });
                    list.append('<div class="col-md-12 col-lg-12 col-sm-12"><nav style="font-size: 17px;font-family: cursive;"> <ul class="pager" id="pager"></ul> </nav></div>');

                    if (!data.isFirstPage) {
                        $("#pager").append('<li style="/*left:-80px;position: relative;*/"><a href="#" onclick="mycollect(' + data.prePage + ')"><上一页</a></li>');
                    }

                    if (!data.isLastPage) {
                        $("#pager").append('<li><a href="#" onclick="mycollect(' + data.nextPage + ')">下一页></a></li>');
                    }

                    $("#pager").append('<span>当前第' + data.pageNum + '页,共' + data.pages + '页</span>&nbsp;&nbsp;前往<input type="text" style="border: 0;border-bottom: black 1px solid;width: 20px;outline: none;" value="' + data.pageNum + '" id="gonum"/>页<button onclick="mycollect(0,' + data.lastPage + ')" class="btn btn-default" style="position: relative;left: 18px;">前往</button>');

                }
            }
        })
    }

    //分页
    function page(pagenum, lastPage) {

        if (lastPage != undefined) {

            var val = $("#gonum").val();

            if (lastPage < val || val < 1) {
                alert("输入参数有误");
                return false;
            }
            initMusic(val, undefined, undefined, undefined);
        }else {
            initMusic(pagenum, undefined, undefined, undefined);
        }
    }
    
    //下载热榜
    function downloadHotList() {
        $.ajax({
            url:"/index/musichome.html",
            method:"get",
            success:function (data) {
                var list = $("#list");
                list.html("");
                list.append(data);
            }
        })
    }

    //我的网盘
    function getmyyns() {
        $.ajax({
            url:"/index/myyun.html",
            method:"get",
            success:function (data) {
                var list = $("#list");
                list.html("");
                list.append(data);
            }
        })
    }


    resourceName="";

    $(function () {
        $(".leftlist li").click(function () {
            $(".leftlist li").css("backgroundColor","rgba(250,250,250,0)");
            $(this).css("backgroundColor","#c0c0c0");
            resourceName = $(this).find('span').text();
        });
        initimg1();
        myFriendMessage();
        setInterval(myFriendMessage,10000);
    });

    function loginout() {

        if (!confirm("您真的要退出吗?下次登录需重新验证")) {
            return;
        }
        $.ajax({
            url:"yx/loginout",
            method:"get",
            statusCode:{
                200:function (data) {
                    location.href='../welcome.html';
                },
                500:function () {
                    alert("服务器开小差了呐");
                }
            }
        })
    }

    //个人信息
    function myMsg() {
        $.ajax({
            url:"/user/mymsg.html",
            method:"get",
            success:function (data) {
                $("#list").html(data);
            }
        })
    }

    //账户安全
    function MysafetyMsg() {
        $.ajax({
            url:"/user/safetyMsg.html",
            method:"get",
            success:function (data) {
                $("#list").html(data);
            }
        })
    }

    function initimg1() {
        $.ajax({
            url:"/yx/gettimg",
            method:"get",
            dataType:"text",
            statusCode:{
                200:function (data) {
                    $(".lefttitle").prop("src",data);
                }
            }
        })
    }

    /*初始化聊天室*/
    function initChatPage() {

        $.ajax({
            url:"/chatpage/chatPage.html",
            method:"get",
            success:function (data) {
                $("#list").html(data);
            }
        });

        return false;
    }

    /*我的MV*/
    function myMV() {
        $.ajax({
            url:"/mv/mv.html",
            method:"get",
            success:function (data) {
                $("#list").html(data);
            }
        })
    }
    /*我的朋友2*/
    function myFriend() {
        $.ajax({
            url:"/friend/friendList.html",
            method:"get",
            success:function (data) {
                $("#list").html(data);
            }
        })
    }


    /*加载朋友信息*/
    function myFriendMessage() {
        console.log(111);
        $.ajax({
            url:"/yx-friend/FriendMessageNum",
            method:"get",
            dataType:"text",
            statusCode:{
                200:function (data) {
                    var friendMessageNum = $("#FriendMessageNum");
                    if (data != 0) {
                        friendMessageNum.text(data);
                        friendMessageNum.addClass("firendMessage");
                    }else {
                        friendMessageNum.text("");
                        friendMessageNum.removeClass("firendMessage");
                    }
                }
            }
        })
    }

</script>

</body>
</html>
