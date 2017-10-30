<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        首页
    </title>
</head>
<body>
    <h1 align="center">登陆注册页面</h1>
    <form action="" method="post">
        <table align="center" border="1" width="35%">
            <tr><th align="center">用户名</th><td><input name="userName" type="text" /></td></tr>
            <tr><th align="center">密码</th><td><input name="password" type="password" /></td></tr>
            <tr>
                <input id="submitButton"  type="submit" value="登录" onclick="javascript:this.form.action='login'"/>
                <%--<input id="registerButton" type="submit" value="注册" onclick="javascript:this.form.action='register.html'"/>--%>
                <input id="registerButton" type="submit" value="注册" onclick="javascript:this.form.action='registerDetail'"/>
            </tr>
            <%--<input id="registerButton2" type="button" value="注册2" onclick="javascript:window.location.href='http://www.baidu.com'"/>--%>
        </table>

    </form>
</body>
</html>
