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

<script language="JavaScript">
    function checkRegisterDetail(){

        if (registerDetailForm.userName.value == ""){
            alert("用户名不能为空！");
            return false;
        }
        else if (registerDetailForm.password.value.length>16||registerDetailForm.password.value.length<6){
            alert("密码长度须在6-16位");
            return false;
        }
        else{
            registerDetailForm.action = 'submitRegisterDetail';
            return true;
        }
//        else if (document.getElementByName("password").value.length>16||ocument.getElementByName("password").value.length<6){
//            alert("密码须在6-16位之间");
//            return false;
//        }
    }
</script>

<body>
    <h1 align="center">注册个人信息</h1>
    <form name="registerDetailForm" method="post" action="">
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
            <%--<tr><td align="center" colspan="2"><input type="submit" name="sublitRegisterButton" onclick="this.form.action='submitRegisterDetail'" /></td></tr>--%>
            <tr><td align="center" colspan="2"><input type="submit" name="sublitRegisterButton" onclick="return checkRegisterDetail()" /></td></tr>
        </table>
    </form>
</body>
</html>
