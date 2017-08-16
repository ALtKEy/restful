<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>가입</title>
</head>
    <body>
        <form action="" method="post">
        <table border="1">
            <tr>
                <td>id</td>
                <td><input type="text" id="id" placeholder="ID"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" id="name" placeholder="이름"></td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <input type="radio" name="gender" id="male">남
                    <input type="radio" name="gender" id="female">여
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="등록"></td>
            </tr>
        </table>
      </form> 
    </body>
</html>