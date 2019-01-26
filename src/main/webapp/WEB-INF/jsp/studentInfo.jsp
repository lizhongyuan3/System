<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2018/8/2
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
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
            <h2>学生信息</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>学生ID</td>
                    <td>学生姓名</td>
                    <td>学生性别</td>
                    <td>学生喜好</td>
                    <td>操作</td>

                </tr>
                </thead>
                <tbody>
                <form action="${pageContext.request.contextPath }/student/update2" method="get">
                <tr>
                    <td><input class="common" type="text" name="studentId"value="${studentInfo.studentId}"></td>
                    <td><input class="common" type="text" name="studentName"value="${studentInfo.studentName}"></td>
                    <td><input class="common" type="text" name="studentSex"value="${studentInfo.studentSex}"}></td>
                    <td><input class="common" type="text" name="studentLike"value="${studentInfo.studentLike}"}></td>
                    <td><input class="common" type="submit" value="修改学生">
                </tr>
                </form>
                </tbody>
            </table>
        </div>

            <div class="panel-heading text-center">
                <h2>学生信息</h2>
            </div>
            <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                    <tr><td>选课信息：</td><td></td><td></td><td></td></tr>
                    <tr><td align="center">${msg}</td><td></td><td></td><td></td></tr>
                    <tr><td></td><td></td><td></td><td></td></tr>
                    <tr>
                        <td>课程ID</td>
                        <td>课程姓名</td>
                        <td>课时</td>
                        <td>授课老师</td>
                    </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty stuiscuosInfo}">
                        <c:forEach var="course" items="${stuiscuosInfo}">
                    <tr>
                    <td>${course.course.courseId}</td>
                    <td>${course.course.courseName}</td>
                    <td>${course.course.courseTime}</td>
                    <td>${course.teacher.teacherName}</td>
                    </tr>
                </c:forEach>
                </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>