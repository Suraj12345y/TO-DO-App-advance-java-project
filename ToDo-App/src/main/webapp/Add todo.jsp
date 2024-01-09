<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.back-img {
	background: url("img/book34.jpg");
	height: 100vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<meta charset="ISO-8859-1">
<title>add_todo page</title>
<%@include file="component/all_css.jsp"%>
</head>
<body>


	<%@include file="component/navbar.jsp"%>
	<div class="container-fluid back-img">
		<div class="container text-center mt-3 ">
			<div class="row p-5">
				<div class="col-md-6 offset-md-3">
					<div class="card mt-3">
						<%
						String FailedMsg = (String) session.getAttribute("failed-msg");
						if (FailedMsg != null) {
						%>
						<div class="alert alert-danger" role="alert"><%=FailedMsg%></div>

						<%
						session.removeAttribute("failed-msg");
						}
						%>
						<div class="card-body bg-primary bg-striped" border="1px">
							<h3 class="text-center text-warning">Add Todo</h3>
							<form action="add_notes" method="post">
								<div class="form-group">
									<label for="exampleInputEmail1 text-primary">Name</label> <input
										type="text" class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" placeholder="Enter Name"
										name="name">

								</div>
								<div class="form-group">
									<label for="exampleInputEmail1 text-primary">Todo</label> <input
										type="text" class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" placeholder=" Enter Todo list"
										name="todo">

								</div>
								<div class="form-group">
									<label for="inputState">Status</label> <select id="inputState"
										class="form-control" name="status">
										<option selected><--Select--></option>
										<option value="Pending">Pending</option>
										<option value="Complete">Completed</option>
									</select>
								</div>
								<div class="text-center">
									<button type="submit" class="btn btn-success">Add</button>
								</div>

							</form>
						</div>


					</div>


				</div>


			</div>



		</div>


	</div>



































	<%@include file="component/footer.jsp"%>

</body>
</html>



















<%@include file="component/footer.jsp"%>

</body>
</html>