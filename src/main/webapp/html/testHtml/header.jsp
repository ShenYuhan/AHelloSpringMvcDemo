<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: yuhan.shen
  Date: 2017/11/17
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用request对象获取并显示全部请求头信息</title>
</head>
<body>
    <%
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()){
            String headerName = headers.nextElement();
            String headerValue = request.getHeader(headerName);
            %>
            <b><%= headerName%></b>:<%= headerValue%><br/>
        <% }
    %>
</body>
</html>
