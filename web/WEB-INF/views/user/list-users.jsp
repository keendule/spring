<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div class="container h-100">
    <div class="row h-100 justify-content-center" style="margin-top: 7rem">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">Name</th>
                <th scope="col">Login</th>
                <th scope="col">Password</th>
                <th scope="col">
                    <a href="<c:url value="/user/user-add-form"/>" class="btn btn-primary">Create</a>
                </th>
                <th scope="col"></th>
            </tr>
            <tbody>

                <c:forEach var="user" items="${users}">

                    <c:url var="updateLink" value="/user/user-update-form">
                        <c:param name="userId" value="${user.id}"/>
                    </c:url>

                    <c:url var="deleteLink" value="/user/delete-user">
                        <c:param name="userId" value="${user.id}"/>
                    </c:url>

                    <tr scope="row">
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.login}</td>
                        <td>${user.password}</td>
                        <td>
                            <a class="btn btn-success" href=${updateLink}>Update</a>
                        </td>
                        <td>
                            <a class="btn btn-danger" href=${deleteLink}>Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


</div>
</body>
</html>

