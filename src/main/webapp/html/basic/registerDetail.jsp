<%--
  Created by IntelliJ IDEA.
  User: yuhan.shen
  Date: 2017/10/29
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册个人信息</title>
</head>
<body>
    <h1 align="center">注册个人信息</h1>
    <form method="post" action="">
        <table align="center" border="1" width="35%">
            <tr><th align="center">用户名</th><td><input type="text" name="userName" /></td></tr>
            <tr><th align="center">密码</th><td><input type="password" name="password" /></td></tr>
            <tr><th align="center">性别</th>
                <td>
                    <select name="sex">
                        <option value="0">男生</option>
                        <option value="1">女生</option>
                        <option value="2">保密</option>
                    </select>
                </td>
            </tr>
            <tr><th align="center">年龄</th><td><input type="text" name="age" /></td></tr>
            <tr><th align="center">电话</th><td><input type="text" name="tel" /></td></tr>
            <tr><th align="center">邮箱</th><td><input type="text " name="email"/></td></tr>
            <tr><th align="center">伴侣</th><td><input type="text" name="spouse" /></td></tr>
        </table>
        <input type="submit" name="sublitRegisterButton" onclick="javascript:this.form.action='submitRegisterDetail'" />
    </form>
</body>
</html>
