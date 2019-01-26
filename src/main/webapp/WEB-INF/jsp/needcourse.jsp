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
            <h2>未选课程</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr><td>选课信息：</td><td></td><td></td><td></td></tr>
                <tr><td align="center">${msg}</td><td></td><td></td><td></td></tr>
                <tr><td></td><td></td><td></td><td></td></tr>
                <tr>
                    <td>课程号</td>
                    <td>课程名</td>
                    <td>课程课时</td>
                    <td>课程Id</td>
                    <td>课程老师</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty noSelectCourseList}">
                <c:forEach var="course" items="${noSelectCourseList}">

                    <tr>
                        <form action="${pageContext.request.contextPath}/xuan/addCourse" method="post">
                            <td><input class="common" type="text" name="couId" value="${course.course.courseId}" readonly="readonly"></td>
                            <td>${course.course.courseName}</td>
                            <td>${course.course.courseTime}</td>
                            <td>${course.teacher.teacherId}</td>
                            <td>${course.teacher.teacherName}</td>
                            <td><input class="common" type="submit" value="选课"></td>
                        </form>
                    </tr>


                    </c:forEach>
                    </c:if>
                </form>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
