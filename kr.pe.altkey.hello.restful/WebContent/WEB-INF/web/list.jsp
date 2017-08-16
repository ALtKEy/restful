<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>리스트</title>
</head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>이름</th>
                    <th>성별</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${listAll}" var="list">
            	<tr>
                    <td>${list.id}</td>
                    <td>${list.name}</td>
                    <td>${list.gender}</td>
                </tr>
            	</c:forEach>
            </tbody>
        </table>
    </body>
</html>