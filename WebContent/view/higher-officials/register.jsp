<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <title>HO Register</title>
</head>

<%@ include file="/view/layout/appHeader.html" %>

<body>

  <div class="container">
    <br> <br>
    <div class="panel-group">

      <div class="panel panel-primary">
        <div class="panel-heading">High Officials Registration</div>
        <div class="panel-body">
          <form action="create" method="post">
            <div class="form-group">
              <label for="usr">Password:</label>
              <input type="text" class="form-control" name="password">
            </div>
            <div class="form-group">
              <label for="usr">Name:</label>
              <input type="text" class="form-control" name="name">
            </div>
            <div class="form-group">
              <label for="usr">Phone:</label>
              <input type="text" class="form-control" name="phone">
            </div>
            <div class="form-group">
              <label for="usr">Email:</label>
              <input type="text" class="form-control" name="email">
            </div>
            <div class="form-group">
              <label for="usr">Address:</label>
              <input type="text" class="form-control" name="address">
            </div>
            <div class="form-group">
              <input type="submit" class="btn btn-primary" value="Add New High Officials">
              <a href="${pageContext.request.contextPath}//HighOfficialsServlet/login" class="btn btn-primary">Already
                Registered</a>
              ${message }
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>




</body>

<%@ include file="/view/layout/footer.html" %>


</html>