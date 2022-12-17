<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="login" var="login"></c:url>
<div id="navigation">
	<div id="banner-desktop">
		<div class="container">
			<div id="banner">
				<div id="login-area">
					<a  href="../logout" style = "border-spacing: 2px;"><b> Đăng xuất</b></a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- ===================================Thông tin người dùng=========================-->
	<div class="modal fade" id="thong_tin">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Thông tin người dùng</h4>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<script type="text/javascript"
		src="<c:url value="/Content/public/js/bootstrap.min.js"/>"></script>
</div>