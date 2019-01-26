<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="common/tag.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>教师列表</title>
    <%@include file="common/head.jsp"%>
    <style type="text/css">
        .common{
            border: 0px;
        }
    </style>

</head>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>教师</h2>
        </div>

        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>教师编号</td>
                    <td>教师Name</td>
                    <td>教师年龄</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <form action="${pageContext.request.contextPath}/teacher/add" method="post">
                    <tr>
                        <td></td>
                        <td><input type="text" name="teacherName"></td>
                        <td><input type="text" name="teacherEdu"></td>
                        <td><input type="submit" value="添加教师"></td>
                    </tr>
                </form>
                <c:if test="${not empty teacherlist}">
                    <c:forEach var="teacher" items="${teacherlist}">
                        <form action="${pageContext.request.contextPath }/teacher/update"method="post">
                            <tr>
                                <td><input class="common" type="text" name="teacherId"value="${teacher.teacherId}"></td>
                                <td><input class="common" type="text" name="teacherName"value="${teacher.teacherName}"}></td>
                                <td><input class="common" type="text" name="teacherEdu"value="${teacher.teacherEdu}"}></td>
                                <td><input class="common" type="submit" value="修改教师">
                                    <a href="${pageContext.request.contextPath }/teacher/delete?teacherId=${teacher.teacherId}">删除教师</a>
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




