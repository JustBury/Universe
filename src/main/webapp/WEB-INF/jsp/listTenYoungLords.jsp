<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>

<body>
<h1> List Top 10 younger lords </h1>
<table>
    <tr>
        <th>
            <p>Name</p>
        </th>
        <th>
            <p>Age</p>
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

        </tr>
    </c:forEach>
</table>
</body>
</html>