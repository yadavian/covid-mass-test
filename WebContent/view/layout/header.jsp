<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 

<style type="text/css">
  /*Login*/
  /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
  .row.content {
    height: 1500px
  }

  /* Set gray background color and 100% height */
  .sidenav {
    background-color: #f1f1f1;
    height: 100%;
  }

  /* Set black background color, white text and some padding */
  footer {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    height: 40px;
    background-color: #337ab7;
    color: white;
    padding-left: 15px;
    padding-right: 15px;
    text-align: center;
    border-top-right-radius: 30px;
    border-top-left-radius: 30px;
    border-bottom-right-radius: 0px;
    border-bottom-left-radius: 0px;
    padding-top: 5px;
  }


  /* On small screens, set height to 'auto' for sidenav and grid */
  @media screen and (max-width: 767px) {
    .sidenav {
      height: auto;
      padding: 15px;
    }

    .row.content {
      height: auto;
    }
  }

  /*to blur body ::before*/
  body {
    background-color: #e8e6e69e;
    /*background: url(../images/background.jpg) no-repeat center center fixed;*/
    /*background: url(https://i.pinimg.com/originals/1f/50/3f/1f503fcfd14bc5367f656a145975eeec.jpg) no-repeat center center fixed;*/
    content: '';
    z-index: -1;
    width: 100%;
    height: 100%;
    position: absolute;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    color: grey;
    /*-webkit-filter: blur(5px);
  -moz-filter: blur(5px);
  -o-filter: blur(5px);
  -ms-filter: blur(5px);
  filter: blur(5px);*/
  }

  /* card opacity */
  .card {
    top: 50px;
    opacity: .9;
    background-color: #ffffff70;
    color: #000000;
  }

  .card:hover {
    opacity: 1;
    background-color: #ffffff99;
  }

  .card>div>div>label {
    font-weight: bold;
  }

  .card-header {
    opacity: 1;
  }

  .card-text {
    word-wrap: break-word;
  }

  .cars-body {
    opacity: 1;
  }

  .card-img-top {
    /*max-width: calc(100%);
  height: calc(100%);*/
    border-top-left-radius: calc(50rem);
    border-top-right-radius: calc(50rem);
    border-bottom-left-radius: calc(50rem);
    border-bottom-right-radius: calc(50rem);
  }

  img {
    vertical-align: middle;
    border-style: double;
    border-width: 2px;
    position: inherit;
    overflow: hidden;
    border-top-color: #eb0017;
    border-left-color: #eb0017;
    border-right-color: #eb0017;
    border-bottom-color: #eb0017;
  }

  /* Horizontal Line */
  hr.style {
    padding: 0;
    border: solid;
    /*border-top: medium double #000;*/
    color: #000;
    text-align: center;
  }

  hr.style:after {
    display: inline-block;
    position: relative;
    top: -0.7em;
    font-size: 1.5em;
    padding: 0 0.25em;
    background: white;
  }

  /*Nav Bar*/
  .appnav {
    overflow: hidden;
    background-color: #337ab7;
    /*border-radius: 25px;*/
    border-top-right-radius: 0px;
    border-top-left-radius: 0px;
    border-bottom-right-radius: 30px;
    border-bottom-left-radius: 30px;
  }

  .appnav a {
    float: right;
    display: block;
    color: #ffffff;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px;
  }

  .appnav a:hover {
    background-color: #ffffff;
    color: #337ab7;
  }

  .active {
    background-color: #17a2b8;
    color: white;
    font-size: 20px;
    padding: 8px;
  }

  .appnav .icon {
    display: block;
  }

  @media screen and (max-width: 600px) {
    .appnav a:not(:first-child) {
      display: none;
    }

    .appnav a.icon {
      float: right;
      display: block;
    }
  }

  @media screen and (max-width: 600px) {
    .appnav.responsive {
      position: relative;
    }

    .appnav.responsive .icon {
      position: absolute;
      right: 0;
      top: 0;
    }

    .appnav.responsive a {
      float: none;
      display: block;
      text-align: left;
    }

    .appnav a {
      float: right;
      display: block;
      color: #ffffff;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
      font-size: 17px;
    }
  }

  /*Student*/
  .table-bordered {
    border: 3px solid;
    border-color: #337ab7;
  }

  .row>div>label {
    font-weight: bold;
  }

  .list-group-item {
    color: #c6303e;
    background-color: #ffffff;
  }

  .list-group-item.active {
    color: #ffffff;
    background-color: #c6303e;
    border-color: #c6303e;
  }

  input[type="checkbox"],
  input[type="radio"] {
    box-sizing: border-box;
    padding: 0;
    height: 20px;
    width: 20px;
  }

  div>div>a>h5 {
    font-size: 15px;
  }

  /*Upload File*/
  .btn-file {
    position: relative;
    overflow: hidden;
  }

  .btn-file input[type=file] {
    position: absolute;
    top: 0;
    right: 0;
    min-width: 100%;
    min-height: 100%;
    font-size: 100px;
    text-align: right;
    filter: alpha(opacity=0);
    opacity: 0;
    outline: none;
    background: white;
    cursor: inherit;
    display: block;
  }

  .input-group>.form-control:not(:first-child),
  .input-group>.custom-select:not(:first-child) {
    border-top-left-radius: 0px;
    border-bottom-left-radius: 10px;
  }

  p {
    font-weight: bold;
    color: #c6303e;
  }

  /*Teacher*/
</style>
</head>
<body>
<header>
  <div class="container-fluid">
    <div class="container">
      <div class="col-md-12">
        <div class="appnav navbar-expand-lg" id="student_nav">

          <a style="float: left;"></a>
          <div>
          <c:if test="${scEmail  != null || hoEmail  != null }">
            <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/PatientServlet/create"
              class="profile_link" style="float: left; font-weight: bold;font-size: 14px;" id="navbarDropdown"
              aria-expanded="false">
              <i class="fas fa-file-alt"></i>&nbsp;Add New Patient
            </a>
            </c:if> 
            
            <c:if test="${hoEmail  != null }">
            <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/DoctorServlet"
              class="profile_link" style="float: left; font-weight: bold;font-size: 14px;" id="navbarDropdown"
              aria-expanded="false">
              <i class="fas fa-file-alt"></i>&nbsp;Doctors List
            </a>
            </c:if>

            <c:if test="${drEmail  != null || hoEmail  != null }">
            <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/SampleCollectorServlet"
              class="profile_link" style="float: left; font-weight: bold;font-size: 14px;" id="navbarDropdown"
              aria-expanded="false">
              <i class="fas fa-file-alt"></i>&nbsp;SampleCollectors List
            </a>
            </c:if>

            <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/PatientServlet"
              class="profile_link" style="float: left; font-weight: bold;font-size: 14px;" id="navbarDropdown"
              aria-expanded="false">
              <i class="fas fa-file-alt"></i>&nbsp;Patients List
            </a>

            <!--  <a class="nav-link dropdown-toggle"  href="${pageContext.request.contextPath}/"  class="profile_link" style="float: left; font-weight: bold;font-size: 14px;"id="navbarDropdown" aria-expanded="false">
              <i class="fas fa-file-alt"></i>&nbsp;Reports
            </a> -->


            <a class="profile_link" href="LogoutServlet"
              style="float: right; font-weight: bold;display: block !important;"><i
                class="fas fa-sign-out-alt"></i>&nbsp;Logout</a>


          </div>


        </div>

      </div>
    </div>
  </div>
</header>


</body>
</html>