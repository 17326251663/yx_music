musicList = [
    {
        "mid": 37,
        "musicname": "薛之谦 - 下雨了.mp3",
        "musicurl": "http://192.168.82.134/music/music/user/music/3/7d281a5736e44e6b8cca0af88083d2b7.mp3",
        "msize": 11.6895,
        'imgurl': "images/5476ba25Ne75aa640.png",
        "singer": "薛之谦",
        "uname": "一页有千秋",
        "lyrics": null,
        "uploadtime": "2019-12-12T05:04:10.000+0000",
        "ifyid": 4,
        "status": 0,
    }
];

currentPage = 0;

function musicFormat(musicData) {
   musicList= $(musicData.list).map((i,v)=>({
        "mid":v.mid,
        'musicname': v.musicname,
        'musicurl' : v.musicurl,
       'imgurl' : v.imgurl,
        'msize' : v.msize,
        'singer' : v.singer,
        'uname' : v.uname,
        'lyrics' : v.lyrics,
        'uploadtime' : v.uploadtime,
        'ifyid' : v.ifyid,
        'status' : v.status
    }))
}

function next() {
    
}

// <!--播放-->
//播放按钮
function bofang(count) {

    if (count < 0) {
        currentPage = musicList.length-1;
    }else if (count>=musicList.length){
        currentPage = 0;
    } else {
        currentPage = count;
    }
    //获取到资源路径
    var val1 = musicList[currentPage]["mid"];
    var val2 = musicList[currentPage]["musicurl"];
    var val3 =musicList[currentPage]["imgurl"];
    var val4 =musicList[currentPage]["musicname"];
    var val5 =musicList[currentPage]["singer"];


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

    recently(val1);

    $.ajax({
        url:"yx-music/playnum/"+val1,
        method:"get"
    })

}

// <!--播放-->
//播放按钮
function bofang2_1(ele,mid) {

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
