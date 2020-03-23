function switchToPassword() {
    $("#denglufangshi").html('\t\t\t\t\t\t\t\t\t\t\t<form action="/yx/login" id="loginform" onsubmit="return login()">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t<span id="loginMsg" style="color: red"></span>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t<div class="row form-group">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<div class="col-md-12">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span id="loginresult" style="color: red"></span><br>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for="username">账号:</label>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type="number" class="form-control" name="loginid" id="username" placeholder="请输入账号:" minlength="6" maxlength="10" required value="">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t<div class="row form-group">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<div class="col-md-12">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for="password">密码</label>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type="password" class="form-control" name="loginpassword" id="password" placeholder="请输入密码:" minlength="6" maxlength="10" required value="">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t<div class="row form-group">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<div class="col-md-12">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type="submit" class="btn btn-primary" value="登录" id="l">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a  style="margin-left: 80px;" onclick="switchToNote()">验证码登录</a>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t</form>');
}

function switchToNote() {
    $("#denglufangshi").html('<form action="/yx/login-t" id="loginform" onsubmit="return login()">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t<span id="loginMsg" style="color: red"></span>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t<div class="row form-group">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<div class="col-md-12">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span id="loginresult" style="color: red"></span><br>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for="username">手机号:</label>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type="number" class="form-control" name="telephone" id="username" placeholder="请输入手机号:" minlength="6" maxlength="10" required value="">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t<div class="row form-group">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<div class="col-md-12">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for="password">验证码</label>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type="password" class="form-control" name="securityCode" id="password" placeholder="请输入验证码:" minlength="6" maxlength="10" required value="" style="width: 130px">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type="button" class="btn btn-default" value="获取验证码" onclick="giveCode(this)" style="position: absolute;right: 13px;top: 34px">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t<div class="row form-group">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t<div class="col-md-12">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type="submit" class="btn btn-primary" value="登录" id="l">\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a  style="margin-left: 80px;" onclick="switchToPassword()">密码登录</a>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t\t</div>\n' +
        '\t\t\t\t\t\t\t\t\t\t\t</form>');
}

function giveCode(ele) {
    var tel = $("#loginform input[name=telephone]");

    if (tel.val().length != 11){
        $("#loginresult").text("请输入正确手机号");
        return;
    }

    $.ajax({
        url:"/yx/giveCode/"+tel.val(),
        method:"get",
        async:false,
        daTaype:"text",
        statusCode:{
            200:function (data) {

                if (data != "success") {
                    $(ele).prop("disabled",false);
                    $("#loginresult").text(data);
                    return false;
                }
                $(ele).prop("disabled",true);
                $("#loginresult").text("验证码已发送");
                jiazai(ele);
            },
            500:function () {
                alert("出错啦~");
                    $(ele).prop("disabled",false);
                return false;
            }
        }
    });

}

function jiazai(ele) {

    $(ele).prop("disabled",true);

    codenum = 60;

    x = setInterval(function () {

        $(ele).val(codenum+"秒...");
        codenum--;
        if (codenum <= 0) {
            clearInterval(x);
            $(ele).val("获取验证码");
            $(ele).prop("disabled",false);
        }

    },1000);
}