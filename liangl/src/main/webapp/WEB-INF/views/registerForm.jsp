<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form:form modelAttribute="spitter" method="post" action="/register">
    <table>
        <tr>
            <td>FirstName：</td>
            <td><form:input path="firstname"/></td>
            <td><form:errors path="firstname" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>LastName：</td>
            <td><form:input path="lastname"/></td>
            <td><form:errors path="lastname" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>UserName：</td>
            <td><form:input path="username"/></td>
            <td><form:errors path="username" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>PassWord：</td>
            <td><form:input path="password" showPassword="false"/></td>
            <td><form:errors path="password" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="register">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>