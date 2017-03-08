<%--
  Created by IntelliJ IDEA.
  User: xuweijie
  Date: 2017/3/8
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码</title>
    <script type="text/javascript">
        function reloadCode() {
            var time=new Date().getTime();
            document.getElementById("imagecode").src="servlet/ImageServlet?d="+time;
        }
    </script>
</head>
<body>
<br><br>
    <div align="center">
        <form action="servlet/LoginServlet" method="get">
            验证码:<input type="text" name="checkcode"/>
            <img id="imagecode" alt="验证码" src="/servlet/ImageServlet"/>
            <a href="javascript:reloadCode();">看不清楚</a><br><br>
            <input type="submit" value="提交"/>
        </form>
    </div>
</body>
</html>
