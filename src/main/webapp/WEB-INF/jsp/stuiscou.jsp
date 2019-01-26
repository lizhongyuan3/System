<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>老师的学生</title>
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
                    <td>老师Id</td>
                    <td>老师姓名</td>
                    <td>学生学号</td>
                    <td>学生姓名</td>
                    <td>学生性别</td>
                    <td>学生爱好</td>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty stuiscoulist}">
                    <c:forEach var="stuiscou" items="${stuiscoulist}">
                        <tr>
                        <td>${stuiscou.teacher.teacherId}</td>
                        <td>${stuiscou.teacher.teacherName}</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        </tr>
                        <c:if test="${not empty stuiscou.students}">
                            <c:forEach var="students" items="${stuiscou.students}">
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td>${students.studentId}</td>
                                    <td>${students.studentName}</td>
                                    <td>${students.studentSex}</td>
                                    <td>${students.studentLike}</td>
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
</body>
</html>