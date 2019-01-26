<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生列表</title>
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
            <h2>学生</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>学生学号</td>
                    <td>学生姓名</td>
                    <td>学生性别</td>
                    <td>学生喜好</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <form action="${pageContext.request.contextPath}/student/queryByStudentId" method="post">
                        <td><input type="text" name="studentId" placeholder="按照学号查询"></td>
                        <td><input type="submit" value="查询学生"></td>
                    </form>
                    <form action="${pageContext.request.contextPath}/student/queryByStudentName" method="post">
                        <td><input type="text" name="studentName" placeholder="按照姓名查询"></td>
                        <td><input type="submit" value="查询学生"></td>
                    </form>
                </tr>
                <c:if test="${not empty stuentlist}">
                    <c:forEach var="student" items="${stuentlist}">
                        <tr>
                            <td>${student.studentId}</td>
                            <td>${student.studentName}</td>
                            <td>${student.studentSex}</td>
                            <td>${student.studentLike}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${not empty titleIdList}">
                    <c:forEach var="studentId" items="${titleIdList}">
                        <tr>
                            <td>${studentId.studentId}</td>
                            <td>${studentId.studentName}</td>
                            <td>${studentId.studentSex}</td>
                            <td>${studentId.studentLike}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${not empty titleNameList}">
                    <c:forEach var="studentName" items="${titleNameList}">
                        <tr>
                            <td>${studentName.studentId}</td>
                            <td>${studentName.studentName}</td>
                            <td>${studentName.studentSex}</td>
                            <td>${studentName.studentLike}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
                ${msg}<br>
            </table>
        </div>
    </div>
</div>
</body>
</html>