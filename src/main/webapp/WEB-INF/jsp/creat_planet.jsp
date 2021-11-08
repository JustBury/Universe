<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Creat new Lord</h1>

<div class="form-area">
    <form:form action="/planet/savePlanet" modelAttribute="planet" method="post">
        <form:hidden path="id"/>
        <label>Name</label>
        <br>
        <form:input  path="name"/>
        <br>
        <form:errors cssStyle="color: red" path="name"/>
        <br>
        <input type="submit"  value="Creat">
        <c:url var="back" value="/"/>
        <a href="/">Back to main page</a>
    </form:form>
</div>
</body>
</html>