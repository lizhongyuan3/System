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
                    <td>序号</td>
                    <td>课程Id</td>
                    <td>课程姓名</td>
                    <td>课程时长</td>
                    <td>课程讲师</td>
                    <td>课程剩余量</td>
                    <td>学生Id</td>
                    <td>学生姓名</td>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty couIsStudentList}">
                    <c:forEach var="stuiscou" items="${couIsStudentList}" >
                        <tr>
                            <td>${stuiscou.course.courseId-123399}</td>
                            <td>${stuiscou.course.courseId}</td>
                            <td>${stuiscou.course.courseName}</td>
                            <td>${stuiscou.course.courseTime}</td>
                            <td>${stuiscou.teacher.teacherName}</td>
                            <td>${10-stuiscou.students.size()}</td>
                            <td></td>
                            <td></td>
                        </tr>
                        <c:if test="${not empty stuiscou.students}">
                            <c:forEach var="course" items="${stuiscou.students}">
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>${course.studentId}</td>
                                    <td>${course.studentName}</td>
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