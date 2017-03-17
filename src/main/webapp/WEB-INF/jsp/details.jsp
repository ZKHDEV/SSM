<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("title","电影详情"); %>
<%@ include  file="./layout/web-header.jsp"%>
<%@ include  file="./layout/header.jsp"%>
<div class="container" style="margin-top: 60px;margin-bottom: 20px;">
    <h1>Details</h1>
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
    <a href="${pageContext.request.contextPath}/movie/update.action?id=${movie.id}">Edit</a> | <a href="${pageContext.request.contextPath}/movie/list.action">Back to List</a>
    <hr> &copy;2017 - ZKH
</div>
<%@ include  file="./layout/javascript.jsp"%>
<%@ include  file="./layout/web-footer.jsp"%>