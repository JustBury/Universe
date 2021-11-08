<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Planet information</title>
</head>

<body>
<h1>Planet information</h1>
<label>Id</label>
<p>${planet.id}</p>
<br>
<label>Name</label>
<p>${planet.name}</p>
<br>
<label>Lord</label>
<p>${planet.lord}</p>

<a href="/planet/deletePlanet/${planet.id}"
   onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false">Delete</a>
<br>
<a href="/planet/updatePlanet/${planet.id}">Update</a>
<br>
<a href="/">Back to main page</a>
<br>
</body>
</html>