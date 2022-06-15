<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #7be80c">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> User
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="list"
                   class="nav-link">List</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="home" method="post">

                <fieldset class="form-group">
                    <label>Name</label>
                    <input type="text"  class="form-control"
                           name="name" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Price</label>
                    <input type="text" class="form-control"
                           name="price">
                </fieldset>

                <fieldset class="form-group">
                    <label>brand</label>
                    <input type="text" class="form-control"
                           name="brand">
                </fieldset>
                    <fieldset class="form-group">
                        <label>description</label>
                        <input type="text" class="form-control"
                               name="description">
                    </fieldset>
                </fieldset>
                <button type="submit" class="btn btn-success">Save</button>
                <button type="reset" class="btn btn-success">reset</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>