<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="panel panel-default">
	<div class="panel-body">
		<div class="col-md-7 col-lg-8">
			<h4 class="mb-3">Tạo Tài Khoản</h4>
			<form class="needs-validation" novalidate>

				<div class="col-sm-6">
					<label for="firstName" class="form-label">First Name</label> <input
						type="text" class="form-control" id="firstName"
						placeholder="First Name" value="" required>

				</div>

				<div class="col-sm-6">
					<label for="lastName" class="form-label">Last name</label> <input
						type="text" class="form-control" id="lastName"
						placeholder="Last name" value="" required>

				</div>

				<div class="col-sm-12">
					<label for="username" class="form-label">Username</label>
					<div class="input-group has-validation">
						<input type="text" class="form-control" id="username"
							placeholder="Username" required>

					</div>
				</div>
				<div class="col-sm-12">
					<label for="username" class="form-label">Password</label>
					<div class="input-group has-validation">
						<input type="text" class="form-control" id="password"
							placeholder="Password" required>
					</div>
				</div>
				<div class="col-sm-12">
					<label for="email" class="form-label">Email <span
						class="text-muted">(Optional)</span></label> <input type="email"
						class="form-control" id="email" placeholder="you@example.com">
				</div>

				<button class="w-100 btn btn-primary btn-lg " type="submit"
					style='margin-left: 15px; margin-top: 5px;'>Add Account</button>
			</form>
		</div>
	</div>
</div>
<style>
/* .col-md-7 {
	max-width: 900px;
} */
</style>
<script>
	(function() {
		'use strict'

		// Fetch all the forms we want to apply custom Bootstrap validation styles to
		var forms = document.querySelectorAll('.needs-validation')

		// Loop over them and prevent submission
		Array.prototype.slice.call(forms).forEach(function(form) {
			form.addEventListener('submit', function(event) {
				if (!form.checkValidity()) {
					event.preventDefault()
					event.stopPropagation()
				}

				form.classList.add('was-validated')
			}, false)
		})
	})()
</script>