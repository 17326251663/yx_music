<!doctype html>
<html lang="en" class="no-js">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <script src="../js/jquery-2.1.0.min.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="../js/rf.js"></script>
    <style>

        #right{
            width: 87%;
            height: 615px;
            background-color: rgba(223, 254, 255, 0);
            position: absolute;
            left: 201px;
            /* right: 382px; */
            top: 0;
            box-sizing: border-box;
        }
        .hed{
            font-family: fantasy;
            text-indent: 2em;
        }
        #title{
            padding-bottom: 2px;
            margin: 28px 0 20px;
            border-bottom: 1px solid #eee;
        }
        #list{
            background-color: rgba(225, 113, 255, 0);
            width: 100%;
            height: 454px;
            overflow: auto;
        }
        .panel-body i:hover{
            cursor: pointer;
            color: orange;
        }
        .bo{
            margin-left: 76px;
            float: right;
            margin-right: 225px;
        }
        .bo_i{
            position: relative;
            top: 2px;
        }
        .collect{
            float: right;
            margin-right: 217px;

         }
        .panel-default:hover {
            -webkit-box-shadow: 0 15px 30px rgba(0,0,0,0.1);
            box-shadow: 0 15px 30px rgba(0,0,0,0.1);
            -webkit-transform: translate3d(0, -2px, 0);
            transform: translate3d(0, -2px, 0);
            background: linear-gradient(135deg , rgba(0, 150, 136, 0.41) 0%, rgba(162, 223, 80, 0.5) 100%);
        }
        .updateTime{
            left: 76%;
            color: #0000ff7a;
        }
        #musicname0{
            background-color: #ffffff2e;
        }
        .yuyin{
            position: absolute;
            right: 70px;
            top: -0.5px;
        }


    </style>
</head>
<body style="position: fixed;width: 100%;height: 100%;">


<form action="#" style="padding: 0;margin: 0;order: 0;" id="titlelist" >
    <div class="page-header " id="title">
        <input type="hidden" name="num" value="1" id="pagenum">
        <input type="hidden" name="ifyid" value="0">
        <div class="col-xs-4" style="position: relative;left: 58px;">
            <input type="text" value="" placeholder="请输入歌手/歌曲/分类" class="form-control touMing" id="musicname0"><button onclick="return initMusic(1,0,this,this)" type="button" class="btn btn-default touMing" style="position: absolute;right: 14px;top:0" id="rightSearch">搜索</button><button type="button" class="btn btn-default touMing yuyin" onmousedown="return luyinStart()" onmouseup="return luyinEnd()"><i></i></button>
            <input type="hidden" name="musicname" id="musicname1">
        </div>
        <br>
        <h4></h4>
        <h1 class="hed"></h1>
    </div>
</form>
<!--    列表下手-->
    <div id="list" style="box-sizing: border-box">
        <h1>欢迎访问!</h1>
<!--        <div class="panel panel-default col-xs-12 list">
            <div class="panel-heading"  style="position: relative;opacity: 0.5;border-radius: 0 0px 20px 20px;">歌手: <span class="updateTime" style="position: relative">更新时间:</span></div>
            <div class="panel-body">
                歌曲名称:
                <span class="collect" style="font-family: cursive"><i class="bo_i"></i>收藏</span>
                <span style="font-family: cursive" class="bo">播放:<i class="bo_i"></i></span>
            </div>

&lt;!&ndash;            这里是歌单的一些隐藏信息,如图片路径,图片id,歌曲路径&ndash;&gt;
            <span class="musicId" value=""></span>
            <span class="musicUrl" value=""></span>
            <span class="musicImg" value=""></span>
        </div>

        <div class="panel panel-default col-xs-12 list">
            <div class="panel-heading"  style="position: relative;opacity: 0.5;border-radius: 0 0px 20px 20px;">歌手:</div>
            <div class="panel-body">
                歌曲名称:
                <span class="collect" style="font-family: cursive"><i class="bo_i"></i>收藏</span>
                <span style="font-family: cursive" class="bo">播放:<i class="bo_i"></i></span>
            </div>

&lt;!&ndash;            这里是歌单的一些隐藏信息,如图片路径,图片id,歌曲路径&ndash;&gt;
            <span class="musicId" value=""></span>
            <span class="musicUrl" value=""></span>
            <span class="musicImg" value=""></span>
        </div>
        <div class="panel panel-default col-xs-12 list">
            <div class="panel-heading"  style="position: relative;opacity: 0.5;border-radius: 0 0px 20px 20px;">歌手:</div>
            <div class="panel-body">
                歌曲名称:
                <span class="collect" style="font-family: cursive"><i class="bo_i"></i>收藏</span>
                <span style="font-family: cursive" class="bo">播放:<i class="bo_i"></i></span>
            </div>

&lt;!&ndash;           这里是歌单的一些隐藏信息,如图片路径,图片id,歌曲路径&ndash;&gt;
            <span class="musicId" value=""></span>
            <span class="musicUrl" value=""></span>
            <span class="musicImg" value=""></span>
        </div>
        <div class="panel panel-default col-xs-12 list">
            <div class="panel-heading"  style="position: relative;opacity: 0.5;border-radius: 0 0px 20px 20px;">歌手:</div>
            <div class="panel-body">
                歌曲名称:
                <span class="collect" style="font-family: cursive"><i class="bo_i"></i>收藏</span>
                <span style="font-family: cursive" class="bo">播放:<i class="bo_i"></i></span>
            </div>

&lt;!&ndash;            这里是歌单的一些隐藏信息,如图片路径,图片id,歌曲路径&ndash;&gt;
            <span class="musicId" value=""></span>
            <span class="musicUrl" value=""></span>
            <span class="musicImg" value=""></span>
        </div>
        <div class="panel panel-default col-xs-12 list">
            <div class="panel-heading"  style="position: relative;opacity: 0.5;border-radius: 0 0px 20px 20px;">歌手:</div>
            <div class="panel-body">
                歌曲名称:
                <span class="collect" style="font-family: cursive"><i class="bo_i"></i>收藏</span>
                <span style="font-family: cursive" class="bo">播放:<i class="bo_i"></i></span>
            </div>

&lt;!&ndash;            这里是歌单的一些隐藏信息,如图片路径,图片id,歌曲路径&ndash;&gt;
            <span class="musicId" value=""></span>
            <span class="musicUrl" value=""></span>
            <span class="musicImg" value=""></span>
        </div>
        <div class="panel panel-default col-xs-12 list">
            <div class="panel-heading"  style="position: relative;opacity: 0.5;border-radius: 0 0px 20px 20px;">歌手:</div>
            <div class="panel-body">
                歌曲名称:
                <span class="collect" style="font-family: cursive"><i class="bo_i"></i>收藏</span>
                <span style="font-family: cursive" class="bo">播放:<i class="bo_i"></i></span>
            </div>

&lt;!&ndash;            这里是歌单的一些隐藏信息,如图片路径,图片id,歌曲路径&ndash;&gt;
            <span class="musicId" value=""></span>
            <span class="musicUrl" value=""></span>
            <span class="musicImg" value=""></span>
        </div>
        <div class="panel panel-default col-xs-12 list">
            <div class="panel-heading"  style="position: relative;opacity: 0.5;border-radius: 0 0px 20px 20px;">歌手:</div>
            <div class="panel-body">
                歌曲名称:
                <span class="collect" style="font-family: cursive"><i class="bo_i"></i>收藏</span>
                <span style="font-family: cursive" class="bo">播放:<i class="bo_i"></i></span>
            </div>

&lt;!&ndash;            这里是歌单的一些隐藏信息,如图片路径,图片id,歌曲路径&ndash;&gt;
            <span class="musicId" value=""></span>
            <span class="musicUrl" value=""></span>
            <span class="musicImg" value=""></span>
        </div>-->
<!--        列表结束-->
    </div>

<script>
    // <!--播放-->
    //播放按钮
    function bofang(ele,mid) {

        //获取到资源路径
        var val1 = $(ele).siblings(".mid").attr("value");
        var val2 = $(ele).siblings(".musicUrl").attr("value");
        var val3 = $(ele).siblings(".imgUrl").attr("value");
        var val4 = $(ele).siblings(".musicName").attr("value");
        var val5 = $(ele).siblings(".singer").attr("value");


        $("#boMuted").prop("src",val2);

        ap3.pause();
        $(".aplayer").html($("#hahahaha").html());
        ap3 = new APlayer({
            element: document.getElementById('player3'),//样式1
            narrow: false,
            autoplay: false,
            showlrc: true,
            music: {
                title: val5,
                author: val4,
                url: ''+val2,
                pic: ''+val3
            }
        });
        ap3.init();
        ap3.play();

        $(".aplayer-lrc").css("backgroundColor","rgba(250,250,250,0)");

        recently(mid);

        $.ajax({
            url:"yx-music/playnum/"+mid,
            method:"get"
        })
     
    }

    //浏览记录
    function recently(mid) {
            $.ajax({
                url:"/yx-music/recently/"+mid,
                method:"get"
            })
    }

    function luyinStart() {
        console.log('录音开始');
    }

    luyinNum = 0;

    function luyinEnd() {

        setTimeout(function () {

            var arr = ["薛之谦","邓紫棋","林俊杰","张杰"];

            $("#musicname0").val(arr[luyinNum]);

            luyinNum++;

            console.log('录音结束2');

            return initMusic(1,0,$("#rightSearch"[0]),$("#rightSearch"[0]));

        },1000);

    }

</script>
</body>
</html>
