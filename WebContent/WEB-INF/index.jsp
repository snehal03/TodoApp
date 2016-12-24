<html>
	<head>
		 <!-- Library  -->
		<script type="text/javascript" src="webapp/lib/jquery.min.js"></script>
		<script type="text/javascript" src="webapp/lib/bootstrap.min.js"></script>
		<script type="text/javascript" src="webapp/lib/angular.min.js"></script>
		<script type="text/javascript" src="webapp/lib/angular-route.min.js"></script>
		<link rel="stylesheet" href="webapp/lib/bootstrap.min.css"></link>
		<!-- Application Files	 -->	
		<link rel="stylesheet" href="webapp/css/todo.css"></link>
		<script type="text/javascript" src="webapp/App.js"></script>
		<script type="text/javascript" src="webapp/Router.js"></script>
		<script type="text/javascript" src="webapp/ApiDetails.js"></script>
		<!-- Controllers -->
		<script type="text/javascript" src="webapp/Controller/HomeController.js"></script>
		<!-- Services -->
		<script type="text/javascript" src="webapp/Services/AjaxService.js"></script>
		<script type="text/javascript" src="webapp/Services/HomeService.js"></script>

		
	</head>

	<body ng-app= "TodoApp" ng-controller="TodoController">
		<div class="header">
			Todo list
		</div>
 		<div ng-view></div>
 
	</body>
</html>
