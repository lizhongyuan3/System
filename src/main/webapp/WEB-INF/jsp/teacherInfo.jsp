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
            <h2>教师信息</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>教师ID</td>
                    <td>教师姓名</td>
                    <td>教师学历</td>
                    <td>所交课程Id</td>
                    <td>所交课程name</td>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${teacherInfo.teacher.teacherId}</td>
                        <td>${teacherInfo.teacher.teacherName}</td>
                        <td>${teacherInfo.teacher.teacherEdu}</td>
                        <td>${teacherInfo.courseId}</td>
                        <td>${teacherInfo.courseName}</td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="panel-heading text-center">
            <h2>学生信息</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr><td>学生信息：</td><td></td><td></td><td></td></tr>
                <tr><td align="center">${msg}</td><td></td><td></td><td></td></tr>
                <tr><td></td><td></td><td></td><td></td></tr>
                <tr>
                    <td>学生Id</td>
                    <td>学生姓名</td>
                    <td>学生性别</td>
                    <td>学生爱好</td>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty stuiscousInfo}">
                    <c:forEach var="teacherInfo" items="${stuiscousInfo}">
                            <c:if test="${not empty teacherInfo.students}">
                                <c:forEach var="studentInfo" items="${teacherInfo.students}">
                                    <tr>
                                    <td>${studentInfo.studentId}</td>
                                    <td>${studentInfo.studentName}</td>
                                    <td>${studentInfo.studentSex}</td>
                                    <td>${studentInfo.studentLike}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>
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