<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生的课程</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>课程选择信息</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>学生Id</td>
                    <td>学生姓名</td>
                    <td>课程Id</td>
                    <td>课程姓名</td>
                    <td>课程时长</td>
                    <td>课程讲师</td>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty studentIsCourseList}">
                    <c:forEach var="stuiscou" items="${studentIsCourseList}">
                        <tr>
                            <td>${stuiscou.student.studentId}</td>
                            <td>${stuiscou.student.studentName}</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <c:if test="${not empty stuiscou.courses}">
                            <c:forEach var="course" items="${stuiscou.courses}">
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td>${course.courseId}</td>
                                    <td>${course.courseName}</td>
                                    <td>${course.courseTime}</td>
                                </tr>
                            </c:forEach>
                        </c:if>

                    <c:if test="${not empty stuiscou.teachers}">
                    <c:forEach var="teacher" items="${stuiscou.teachers}">
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        <td>${teacher.teacherName}</td>
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