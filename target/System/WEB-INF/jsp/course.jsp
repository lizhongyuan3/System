<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人信息</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>课程信息</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>课程Id</td>
                    <td>课程Name</td>
                    <td>课程时长</td>
                    <td>教师</td>
                    <td>讲师姓名</td>
                    <td>讲师学历</td>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty courselist}">
                <c:forEach var="course" items="${courselist}">
                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td>${course.courseTime}</td>
                    <td>${course.teacher.teacherId}</td>
                    <td>${course.teacher.teacherName}</td>
                    <td>${course.teacher.teacherEdu}</td>
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