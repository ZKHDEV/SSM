<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="pagination">
    <c:choose>
        <c:when test="${page.pageNum!=1}">
            <li><a href="?p=1">&laquo;</a></li>
            <li><a href="?p=${page.pageNum-1}">&lsaquo;</a></li>
        </c:when>
        <c:otherwise>
            <li class="disabled"><a href="javascript:void(0)">&laquo;</a></li>
            <li class="disabled"><a href="javascript:void(0)">&lsaquo;</a></li>
        </c:otherwise>
    </c:choose>
    <c:forEach var="p" begin="${(page.pageNum-page.indexCount/2)>0?page.pageNum-page.indexCount/2:1}" end="${(page.pageNum+page.indexCount/2)>page.pageCount?page.pageCount:page.pageNum+page.indexCount/2}">
        <c:choose>
            <c:when test="${page.pageNum == p}">
                <li class="active"><a href="javascript:void(0)">${p}</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="?p=${p}">${p}</a></li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:choose>
        <c:when test="${page.pageNum!=page.pageCount}">
            <li><a href="?p=${page.pageNum+1}">&rsaquo;</a></li>
            <li><a href="?p=${page.pageCount}">&raquo;</a></li>
        </c:when>
        <c:otherwise>
            <li class="disabled"><a href="javascript:void(0)">&rsaquo;</a></li>
            <li class="disabled"><a href="javascript:void(0)">&raquo;</a></li>
        </c:otherwise>
    </c:choose>
</ul>