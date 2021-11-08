<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List planets</title>
</head>

<body>
<h1> This is list planets </h1>

<table>
    <tr>
        <th>
            <p>Name</p>
        </th>
        <th>
            <p>Lord of planet</p>
        </th>
        <th>
            <p>Functional</p>
        </th>
    </tr>
    <c:forEach var="planet" items="${planets}">
        <tr>
            <td>
                <p>${planet.name}</p>
            </td>
            <td>
                <c:if test="${planet.getLord() == null}">
                    <p>'Absent'</p>
                </c:if>
                <p>${planet.lord.getName()}</p>
            </td>
            <td>
                <a href="showPlanetInfo/${planet.id}">Show planet information</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>