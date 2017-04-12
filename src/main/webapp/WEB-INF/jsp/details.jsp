<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("title","电影详情"); %>
<%@ include  file="./modules/web-header.jsp"%>
<%@ include  file="./modules/header.jsp"%>
<div class="container" style="margin-top: 60px;margin-bottom: 20px;">
    <h1>Details</h1>
    <h4>Movie</h4>
    <hr>
    <dl class="dl-horizontal">
        <dt>Id</dt>
        <dd>${model.id}</dd>
        <dt>Title</dt>
        <dd>${model.title}</dd>
        <dt>Director</dt>
        <dd>${model.director}</dd>
        <dt>Genre</dt>
        <dd>${model.genre}</dd>
        <dt>Language</dt>
        <dd>${model.language}</dd>
    </dl>
    <a href="${pageContext.request.contextPath}/movie/update/${model.id}">Edit</a> | <a href="${pageContext.request.contextPath}/movie/list">Back to List</a>
    <hr> &copy;2017 - ZKH
</div>
<%@ include  file="./modules/javascript.jsp"%>
<%@ include  file="./modules/web-footer.jsp"%>