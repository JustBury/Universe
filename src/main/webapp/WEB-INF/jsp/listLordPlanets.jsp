<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Lord's planets</title>
</head>

<body>
<h1> This is list Lord's planets </h1>

<table>
    <tr>
        <th>
            <p>Name</p>
        </th>
        <th>
            <p>Lord of planet</p>
        </th>
    </tr>
    <c:forEach var="planets" items="${lord.getPlanets()}">
        <tr>
            <td>
                <p>${planets.name}</p>
            </td>
            <td>
                <c:if test="${planets.getLord() == null}">
                    <p>'Absent'</p>
                </c:if>
                <p>${planets.lord}</p>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>