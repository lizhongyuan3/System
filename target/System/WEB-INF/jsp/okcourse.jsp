<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>课程列表</title>
    <%@include file="common/head.jsp"%>
    <style type="text/css">
        .common{
            border: 0px;
        }
    </style>

</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>已选课程</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr><td>选课信息：</td><td></td><td></td><td></td></tr>
                <tr><td align="center">${msg}</td><td></td><td></td><td></td></tr>

                <tr>
                    <td>课程号</td>
                    <td>课程名</td>
                    <td>课程课时</td>
                    <td>老师Id</td>
                    <td>课程老师</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty okcourseInfo}">
                    <c:forEach var="course" items="${okcourseInfo}">


                            <tr>
                                <form  action="${pageContext.request.contextPath}/xuan/delCourse" method="post">
                                <td><input class="common" type="text" name="couId"value="${course.couId}" readonly="readonly" ></td>
                                <td>${course.course.courseName}</td>
                                <td>${course.course.courseTime}</td>
                                <td>${course.teacher.teacherId}</td>
                                <td>${course.teacher.teacherName}</td>
                                <td><input class="common" type="submit" value="退课"></td>
                                </form>
                            </tr>


                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
