<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<div class="container h-100">
    <div class="row h-100 justify-content-center" style="margin-top: 7rem">
        <form:form method="post" action="${update ? 'update-user' : 'save-user'}" modelAttribute="user">
            <form:hidden path="id"/>
            <div class="form-group">
                <label for="formGroupExampleInput">Name</label>
                <form:input type="text" class="form-control" id="formGroupExampleInput"
                       placeholder="Enter name" path="name"/>
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Login</label>
                <form:input type="text" class="form-control" id="formGroupExampleInput2"
                       placeholder="login" path="login" />
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput3">Password</label>
                <form:input type="text" class="form-control" id="formGroupExampleInput3"
                       placeholder="password" path="password"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>


</div>
</body>
</html>
