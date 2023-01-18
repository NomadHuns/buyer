<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>
        <div>
            <h1>회원가입 페이지</h1>
        </div>
        <div>
            <form action="/join" method="post">
                상품명 <input type="text" name="username" placeholder="username"><br>
                가격 <input type="password" name="password" placeholder=""><br>
                재고 <input type="email" name="email" placeholder="ex) user@naver.com"><br>
                <button type="submit">회원가입</button>
            </form>
        </div>

        <%@ include file="../layout/footer.jsp" %>