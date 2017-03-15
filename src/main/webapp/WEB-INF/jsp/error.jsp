<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include  file="./layout/web-header.jsp"%>
<%@ include  file="./layout/header.jsp"%>
<div class="container" style="margin-top: 120px;padding-left: 60px;margin-bottom: 20px;">
    <h1>${message}</h1>
    <hr>
    <a href="javascript:history.back(-1)"><h5>返回上一页</h5></a>
</div>
<%@ include  file="./layout/javascript.jsp"%>
<%@ include  file="./layout/web-footer.jsp"%>