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
	<title>Patient Register</title>
</head>

<%@ include file="/view/layout/header.jsp" %>

<body>
	<%  
		response.setHeader("Cache-Control", "no-cache, no-store, must-revaled");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revaled");
		if(session.getAttribute("scEmail") == null && session.getAttribute("hoEmail") == null){
			response.sendRedirect("../SampleCollectorServlet/login");
		}
	%>
	<%-- ${action } --%>
	<div class="container">
		<br>
		<div class="panel-group">

			<div class="panel panel-primary">
				<c:choose>
					<c:when test="${action == 'edit' }">
						<div class="panel-heading">Patient EDIT</div>
					</c:when>
					<c:otherwise>
						<div class="panel-heading">Patient Registration</div>
					</c:otherwise>
				</c:choose>
				<div class="panel-body">
					<c:choose>
						<c:when test="${action == 'edit' }">
							<form action="../PatientServlet/update" method="post">
						</c:when>
						<c:otherwise>
							<form action="create" method="post">
						</c:otherwise>
					</c:choose>
					<div class="row">
						<c:if test="${action == 'edit' }">
						<div class="col-md-12">
							<label for="usr">Patient ID:</label>
							<input type="text" class="form-control" name="pt_id" value="${getPatient.pt_id }">
						</div>
						</c:if>
						<div class="col-md-6">
							<label for="usr">Aadhar UID:</label>
							<input type="text" class="form-control" name="uid" value="${getPatient.uid }">
						</div>
						<div class="col-md-6">
							<label for="usr">Name:</label>
							<input type="text" class="form-control" name="name" value="${getPatient.name }">
						</div> 
						<div class="col-md-6">
							<label for="usr">Phone:</label>
							<input type="text" class="form-control" name="phone" value="${getPatient.phone }">
						</div>
						<div class="col-md-6">
							<label for="usr">Email:</label>
							<input type="text" class="form-control" name="email" value="${getPatient.email }">
						</div> 
						<div class="col-md-6">
							<label for="usr">Gender:</label>
							<input type="text" class="form-control" name="gender" value="${getPatient.gender }">
						</div>
						<div class="col-md-6">
							<label for="usr">Age:</label>
							<input type="text" class="form-control" name="age" value="${getPatient.age }">
						</div> 
						<div class="col-md-6">
							<label for="usr">Address:</label>
							<input type="text" class="form-control" name="address" value="${getPatient.address }">
						</div>
						<div class="col-md-6">
							<label for="usr">Blood Group:</label>
							<input type="text" class="form-control" name="blood_group"
								value="${getPatient.blood_group }">
						</div> 

						<div class="col-md-6">
							<label for="usr">Test For Disease</label>
							<input type="text" class="form-control" name="disease" value="${getPatient.disease }">
						</div>
						
						<c:if test="${action == 'edit' }">
						<div class="col-md-6">
							<label for="usr">Result:</label>
							<input type="text" class="form-control" name="result" value="${getPatient.result }">
						</div>
						</c:if> 
					
						<c:if test="${action == 'edit' }">
						<div class="col-md-6">
							<label for="usr">Doctor id:</label>
							<input type="text" class="form-control" name="dr_id" value="${getPatient.dr_id }">
						</div>
						</c:if>
						<div class="col-md-6">
							<label for="usr">Sc_id:</label>
							<input type="text" class="form-control" name="sc_id" value="${getPatient.sc_id }">
						</div>
					</div>


					<div class="form-group"></div>

					<div class="form-group">

						<c:choose>
							<c:when test="${action == 'edit' }">
								<input type="submit" class="btn btn-primary" value="Update Patient">
								${message }
							</c:when>
							<c:otherwise>
								<input type="submit" class="btn btn-primary" value="Save Patient">
								${message }
							</c:otherwise>
						</c:choose>

						<a href="${pageContext.request.contextPath}/PatientServlet" class="btn btn-primary">Go
							Back</a>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>

<%@ include file="/view/layout/footer.html" %>


</html>