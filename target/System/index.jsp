<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>
            <div class="panel loginbox">
            <form action="${pageContext.request.contextPath}/check" method="post">
                <div class="text-center margin-big padding-big-top"><h1>后台管理中心</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="userId" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">

                            <input type="password" class="input input-big" name="userPassword" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small" ></span>
                            <%--<input type="password" class="input input-big" name="userPassword" onblur="checkPwd()" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small" ></span>
                            <span class="icon icon-key margin-small" id="pwdmsg"></span>--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                           <img src="images/passcode.jpg" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'">  
                                                   
                        </div>
                    </div>
                </div>
                <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
            </form>
            <form action="${pageContext.request.contextPath}/ref2" method="get">
                <div style="margin-top: -25px; padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="注册"></div>
            </form>
        </div>
        </div>
        </div>
    </div>
</div>

</body>

<%--<script>
    function checkPwd(){
        var pwdmsg=document.getElementById("pwdmsg").innerHTML="<font color='red'>密码错误</font>";

    }

</script>--%>

</html>