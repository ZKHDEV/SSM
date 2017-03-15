<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include  file="./layout/web-header.jsp"%>
<%@ include  file="./layout/header.jsp"%>
<div class="container" style="margin-top: 60px;margin-bottom: 20px;">
    <h1>List</h1>
    <a href="${pageContext.request.contextPath}/create.action">Creat New</a>
    <table class="table table-hover">
        <thead>
            <th>Id</th>
            <th>Title</th>
            <th>Director</th>
            <th>Genre</th>
            <th>Language</th>
            <th></th>
        </thead>
        <tbody>
        <c:forEach items="${page.data}" var="movie">
            <tr>
                <td>${movie.id}</td>
                <td>${movie.title}</td>
                <td>${movie.director}</td>
                <td>${movie.genre}</td>
                <td>${movie.language}</td>
                <th><a href="${pageContext.request.contextPath}/details.action?id=${movie.id}">Details</a>|<a href="${pageContext.request.contextPath}/update.action?id=${movie.id}">Edit</a>|<a href="${pageContext.request.contextPath}delete.action?id=${movie.id}">Delete</a></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@ include  file="./layout/page-toolkit.jsp"%>
    <hr> &copy;2017 - ZKH
</div>
<%@ include  file="./layout/javascript.jsp"%>
<%@ include  file="./layout/web-footer.jsp"%>