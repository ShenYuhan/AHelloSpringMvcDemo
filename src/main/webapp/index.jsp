<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<html>
<head>
    <title>
        首页
    </title>
    <script language="JavaScript">
        function checkLogin(){
            if (indexForm.userName.value==""){
                alert("用户名不能为空！")
                return false;
            }
            else if (indexForm.password.value==""){
                alert("密码不能为空！");
                return false;
            }
            else{
                indexForm.action = 'login';
                return true;
            }
        }
    </script>
</head>
<body>
    <h1 align="center">登陆注册页面</h1>
    <form name="indexForm" action="" method="post">
        <table align="center" border="1" width="35%">
            <tr><th align="center">用户名</th><td><input value="" name="userName" type="text" style="width: 99%;height: 100%"/></td></tr>
            <tr><th align="center">密码</th><td><input value="" name="password" type="password" style="width: 99%;height: 100%"/></td></tr>
            <tr><td colspan="2" align="center">
                <%--<input id="submitButton"  type="submit" value="登录" onclick="javascript:this.form.action='login'"/>--%>
                <input id="submitButton"  type="submit" value="登录" onclick="return checkLogin()"/>
                <input id="registerButton" type="submit" value="注册" onclick="javascript:this.form.action='registerDetail'"/>
            </td></tr>
            <%--<input id="registerButton2" type="button" value="注册2" onclick="javascript:window.location.href='http://www.baidu.com'"/>--%>
        </table>

    </form>
</body>
</html>
