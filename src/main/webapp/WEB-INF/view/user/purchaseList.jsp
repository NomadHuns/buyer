<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>

        <h1>구매 목록 페이지</h1>
        <hr>
        <table border="1">
            <tr>
                <th>번호</th>
                <th>구매상품</th>
                <th>구매자</th>
                <th>구매일</th>
            </tr>
            <c:forEach items="${purchaseDtoList}" var="purchaseDto">
                <tr>
                    <td>${purchaseDto.id}</td>
                    <td>${purchaseDto.product.name}</td>
                    <td>${purchaseDto.user.username}</td>
                    <td>${purchaseDto.createdAt}</td> 
                </tr>
            </c:forEach>
        </table>

        <%@ include file="../layout/footer.jsp" %>