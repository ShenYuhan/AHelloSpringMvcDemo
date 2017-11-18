<%--
  Created by IntelliJ IDEA.
  User: yuhan.shen
  Date: 2017/11/16
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
    <script language="JavaScript">
        function restartLogin(){
            window.location.href="../../index.jsp";
        }
    </script>
</head>
<body>
    <table border="1" width="50%" align="center">
        <tr><th align="center" width="20%">用户名</th><td align="center" width="20%">${userName}</td><td rowspan="3" align="center" width="10%"><input type="button" value="重新登录" onclick="restartLogin()"/></td></tr>
        <tr><th align="center">密码</th><td align="center">${password}</td></tr>
        <tr><th align="center">失败原因</th><td align="center">${loginResult}</td></tr>
    </table>
</body>
</html>
