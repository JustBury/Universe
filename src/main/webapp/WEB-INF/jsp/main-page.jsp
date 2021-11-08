<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>

<body>
<h1> Hello this main page </h1>
<a href="createLord">Add new Lord</a>
<br>
<a href="planet/createPlanet">Add new planet</a>
<br>
<a href="planet/listPlanets">Show list planets</a>
<br>
<a href="getTenYoungLords">Show list 10 Younger Lords</a>
<br>
<a href="getLordSlackers">Show list lord slackers</a>
<br>
<table>
    <tr>
        <th>
            <p>Name</p>
        </th>
        <th>
            <p>Age</p>
        </th>
        <th>
            <p>Planets</p>
        </th>
    </tr>
    <c:forEach var="lord" items="${lords}">
        <tr>
            <td>
                <p>${lord.name}</p>
            </td>
            <td>
                <p>${lord.age}</p>
            </td>
            <td>
                <a href="getLordPlanets/${lord.id}">Show planets this Lord</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>