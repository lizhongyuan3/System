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
                <form action="${pageContext.request.contextPath}/student/add" method="post">
                    <tr>
                        <td></td>
                        <td><input type="text" name="studentName"></td>
                        <td><input type="text" name="studentSex"></td>
                        <td><input type="text" name="studentLike"></td>
                        <td><input type="submit" value="添加学生"></td>
                    </tr>
                </form>
                <c:if test="${not empty stuentlist}">
                    <c:forEach var="student" items="${stuentlist}">
                    <form action="${pageContext.request.contextPath }/student/update" method="post">
                        <tr>
                            <td><input class="common" type="text" name="studentId"value="${student.studentId}"></td>
                            <td><input class="common" type="text" name="studentName"value="${student.studentName}"}></td>
                            <td><input class="common" type="text" name="studentSex"value="${student.studentSex}"}></td>
                            <td><input class="common" type="text" name="studentLike"value="${student.studentLike}"}></td>
                            <td><input class="common" type="submit" value="修改学生">
                                <a href="${pageContext.request.contextPath }/student/delete?studentId=${student.studentId}">删除学生</a>
                            </td>
                        </tr>
                    </form>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
