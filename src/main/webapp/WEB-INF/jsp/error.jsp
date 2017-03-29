<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("title","错误信息"); %>
<%@ include  file="./modules/web-header.jsp"%>
<%@ include  file="./modules/header.jsp"%>
<div class="container" style="margin-top: 120px;padding-left: 60px;margin-bottom: 20px;">
    <h1>${message}</h1>
    <hr>
    <a href="javascript:history.back(-1)"><h5>返回上一页</h5></a>
</div>
<%@ include  file="./modules/javascript.jsp"%>
<%@ include  file="./modules/web-footer.jsp"%>