<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>상세페이지</title>
</head>
    <body>
        <form:form action="/restful/user/${id}" method="DELETE">
        <table border="1">
            <tr>
                <td>id</td>
                <td><input type="text" id="id" placeholder="ID" value="${id}"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" id="name" placeholder="이름" value="${name}"></td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <input type="radio" name="gender" id="male" value="남">남
                    <input type="radio" name="gender" id="female" value="여">여
                </td>
            </tr>
            <tr>
                <td><a href="" onClick="edit()">수정</a></td>
                <td><input type="submit" value="삭제"></td>
            </tr>
        </table>
        </form:form>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
        	var edit = function() {
        		$.ajax({
        			url: "/user" + ${id},
        			method: "UPDATE",
        			
        		})
        	};
        </script>
    </body>
</html>