<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1>Creat new Lord</h1>

<div class="form-area">
    <form:form action="saveLord" modelAttribute="lord" method="post">
        <form:hidden path="id"/>
        <label class="label-form">Name</label>
        <br>
        <form:input cssClass="form-input" path="name"/>
        <br>
        <form:errors cssStyle="color: red" path="name"/>
        <br>
        <label class="label-form">Age</label>
        <br>
        <form:input cssClass="form-input" path="age"/>
        <br>
        <form:errors cssStyle="color: red" path="age"/>
        <br>
        <br>
        <input type="submit" value="Creat">

        <a href="/">Back to main page</a>
    </form:form>
</div>
</body>
</html>