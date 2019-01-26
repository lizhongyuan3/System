<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="${pageContext.request.contextPath}/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-green" href="http://www.baidu.com" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="${pageContext.request.contextPath}/logout"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span><%String studentName=(String)session.getAttribute("studentName");if (studentName==null){studentName="你好";}%><%=studentName%>欢迎登陆</strong></div>
    <h2><span class="icon-user"></span>基本信息</h2>
    <ul style="display:block">
        <li><a href="${pageContext.request.contextPath}/student/studentId" target="right"><span class="icon-caret-right"></span>个人信息</a></li>
        <li><a href="${pageContext.request.contextPath}/course/list" target="right"><span class="icon-caret-right"></span>授课信息</a></li>
       <%-- <li><a><form action="${pageContext.request.contextPath}/student/studentId" method="post"><input type="submit" value="个人信息"></form></a></li>--%>
        <!--选课菜单-->
    </ul>
    <h2><span class="icon-pencil-square-o"></span>选课管理</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/xuan/course" target="right"><span class="icon-caret-right"></span>课程详细信息</a></li>
        <li><a href="${pageContext.request.contextPath}/xuan/show" target="right"><span class="icon-caret-right"></span>查询已选课程</a></li>
        <li><a href="${pageContext.request.contextPath}/xuan/noSelectCourse" target="right"><span class="icon-caret-right"></span>查询未选课程</a></li>
        <%--<li><a><form action="${pageContext.request.contextPath}/teacher/list" method="get"><input type="submit" value="教师列表"></form></a></li>--%>
    </ul>
</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a><form action="${pageContext.request.contextPath}/student/homeStu" method="get"><input type="submit" value="刷新首页" style="background:transparent;border:1px solid #ffffff"></form></a></li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="${pageContext.request.contextPath}/student/homeTS" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
    <p>来源:<a href="http://www.lizhongyuan.top:8080/" target="_blank">李中原</a></p>
</div>
</body>
</html>