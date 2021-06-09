<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
  <meta charset="ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <title>List Doctors</title>



</head>

<%@ include file="/view/layout/header.jsp" %>

<body>

  <%

	System.out.println("GET IN JSP");
	System.out.println(session.getAttribute("hoEmail"));
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revaled"); 
		if(session.getAttribute("hoEmail") == null){
			response.sendRedirect("HighOfficialsServlet/login");
		}
	%>


  <div class="container">
    <br> <br> <br>
    <h3>Welcome ${hoEmail} .</h3>
    <div class="panel-group">

      <div class="panel panel-primary">
        <div class="panel-heading">Doctors List</div>
        <div class="panel-body table-responsive">

          <table class="table table-bordered">
            <thead>
              <tr>
                <th>Ho_id</th>
                <th>Password</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
              </tr>
            </thead>

            <tbody>
              <c:forEach items="${list}" var="higher_officials">
                <tr>
                  <td>${higher_officials.ho_id}</td>
                  <td>${higher_officials.password}</td>
                  <td>${higher_officials.name}</td>
                  <td>${higher_officials.phone}</td>
                  <td>${higher_officials.email}</td>
                  <td>${higher_officials.address}</td>
                </tr>
              </c:forEach>
            </tbody>

          </table>
        </div>
      </div>
    </div>
  </div>


</body>

<%@ include file="/view/layout/footer.html" %>



</html>