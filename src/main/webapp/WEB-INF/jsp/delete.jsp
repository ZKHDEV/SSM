<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("title","删除电影"); %>
<%@ include  file="./layout/web-header.jsp"%>
<%@ include  file="./layout/header.jsp"%>
<div class="container" style="margin-top: 60px;margin-bottom: 20px;">
    <h1>Delete</h1>
    <h2>Are you sure you want to delete this?</h2>
    <h4>Movie</h4>
    <hr>
    <dl class="dl-horizontal">
        <dt>Id</dt>
        <dd>${movie.id}</dd>
        <dt>Title</dt>
        <dd>${movie.title}</dd>
        <dt>Director</dt>
        <dd>${movie.director}</dd>
        <dt>Genre</dt>
        <dd>${movie.genre}</dd>
        <dt>Language</dt>
        <dd>${movie.language}</dd>
    </dl>
    <a href="${pageContext.request.contextPath}/movie/deleteSubmit.action?id=${movie.id}" class="btn btn-default">Delete</a> | <a href="${pageContext.request.contextPath}/movie/list.action">Back to List</a>
    <hr> &copy;2017 - ZKH
</div>
<%@ include  file="./layout/javascript.jsp"%>
<%@ include  file="./layout/web-footer.jsp"%>