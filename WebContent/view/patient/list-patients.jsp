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
  <title>Doctor Home</title>
</head>

<%@ include file="/view/layout/header.jsp" %>

<body>

  <%

	System.out.println(request.getParameter("message"));
	System.out.println("GET IN PATIENT");
	System.out.println(session.getAttribute("scEmail"));
	System.out.println(session.getAttribute("drEmail"));
	System.out.println(session.getAttribute("hoEmail"));
	response.setHeader("Cache-Control", "no-cache, no-store, must-revaled"); 
		if(session.getAttribute("scEmail") == null && session.getAttribute("drEmail") == null && session.getAttribute("hoEmail") == null ){
			System.out.println("True");
			response.sendRedirect("SampleCollectorServlet/login");
		}
	%>

  <div class="container">
    <br>
    <h3> ${message}</h3>
    <div class="panel-group">

      <div class="panel panel-primary">
        <div class="panel-heading">Patient List</div>
        <div class="panel-body table-responsive">

          <table class="table">
            <thead>
              <tr>
                <th>Patient ID</th>
                <th>Email</th>
                <th>UID</th>
                <th>Name</th>
                <th>Phone</th>
                
                <th>Gender</th>
                <th>Age</th>
                <th>Address</th>
                <th>Blood Group</th>
                <th>Disease</th>
                
                <th>Result</th>
                <th>Doctor</th>
                <th>Sample collector</th>
                
                <th>Action</th>
              </tr>
            </thead>

            <tbody>
              <c:forEach items="${list}" var="patient">
                <tr>
                  <td>${patient.pt_id}</td>
                  <td>${patient.email}</td>
                  <td>${patient.uid}</td>
                  <td>${patient.name}</td>
                  <td>${patient.phone}</td>
                  
                  <td>${patient.gender}</td>
                  <td>${patient.age}</td>
                  <td>${patient.address}</td>
                  <td>${patient.blood_group}</td>
                  <td>${patient.disease}</td>
                  
                  <c:if test="${scEmail != null}">
                  		<td>${patient.result}</td>
                  </c:if>
                  
                  <c:if test="${drEmail != null || hoEmail != null }">
                  		<td>
                  			<form action=""> 
								<select   name="cars" id="cars">
  									<option value="positive">Positive</option>
  									<option value="negative">Negative</option>
  								</select>
  								
  								<button class="btn btn-sm btn-primary" type="submit">Save</button> 
                  			</form>
                  		</td>
                  </c:if>
                  
                  <c:if test="${ hoEmail != null }">
                  		<td>
                  			<form action=""> 
								 <select>
    							 <c:forEach items="${listDoctors}"  var="listDoctors">
         							<option value="${listDoctors.dr_id}">${listDoctors.name}</option>
    									 </c:forEach>
    							</select>
  								<button class="btn btn-sm btn-primary" type="submit">Save</button> 
                  			</form>
                  		</td>
                  </c:if>
                   
                   
                  <c:if test="${scEmail != null}">
                  <td>${patient.dr_id}</td>
                  </c:if>
                  <td>${patient.sc_id}</td>


                  <td><a class="btn btn-primary"
                      href="<%=request.getContextPath()%>/PatientServlet/edit?pt_id=${patient.pt_id}">EDIT</a>
                      </td>

                  <td><a class="btn btn-primary"
                      href="<%=request.getContextPath()%>/PatientServlet/delete?pt_id=${patient.pt_id}">DELETE</a>
                      </td>
                 
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