<%--
  Created by IntelliJ IDEA.
  User: yuhan.shen
  Date: 2017/10/27
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%! long i = 0;%>
    <%! String webName = "大公鸡交友网站";%>
</head>
<body>
<div align="center">
    <p>账号:${userName}</p>
    <p>密码:${password}</p>
    <p>${loginResult}</p>
    <p>
        <%
            ++i;
            out.println("欢迎光临"+webName);
            out.println("您是第"+i+"位访问用户");
        %>
    </p>
</div>
</body>
</html>
