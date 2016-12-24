/**
 * Controller for Handling Todoist
 */
app.controller("HomeController",['$scope','$filter','homeService',function($scope,$filter,homeService){
	
	/**
	 * Constants 
	 */
	$scope.showTodoList = false;
	$scope.modalHeader = "Add Todo";
	$scope.completeCheckbox;
	$scope.addFlag = true;
	$scope.showText = true;
	$scope.columnName = "createdDate";
	$scope.reverse = false;
	$scope.showErrorMessage = false;
	$scope.sortClass = "";
	
	$scope.dropdownData = [
	        {
				name:"Search By Text",
				value:"text"
			},
			{
				name:"Serch By Due Date",
				value:"date"
			}];
	$scope.filterOptions = ["All","Completed","Pending"];
	
	$scope.status = ["Completed","Pending"];
	/**
	 * Success,Failure functions and service call for Show All Todo List
	 */
	var showTodoesSuccess = function(responseData) {
		if(responseData.response==0)
		{
			if(typeof(responseData.data)=='string'){
				$scope.tableMsg=responseData.data;
				$scope.showTodoList=false;
			 }
			 else{
				 $scope.showTodoList=true;
				 $scope.todoList = responseData.data;
			 }
		}
		else {
			$scope.showTodoList=false;
			$scope.PageMsgClass="error-msg";
			$scope.PageMsg=responseData.errorMessage;
		}
	}
	var showTodoesError = function(data) {
		$scope.showTodoList=false;
		$scope.PageMsgClass="error-msg";
		$scope.PageMsg=responseData.errorMessage;
	}
	homeService.showAllTodoesList(showTodoesSuccess,showTodoesError);
	
	/**
	 * Functions For add todo
	 */
	$scope.addTodo = function() {
		$scope.ModalMsg="";
		$scope.todo= {};
		$scope.modalHeader ="add Todo";
		$scope.addFlag = true;
	}
	
	/**
	 * common success and error function 
	 */
	var todoSuccess = function(responseData) {
		if(responseData.response==0)
		{
			$scope.showErrorMessage = false;
			$scope.PageMsg=responseData.data;
			$scope.PageMsgClass = "success-msg";
			$("#todoModal").modal("hide");
			$("#deleteTodoModal").modal("hide");
			homeService.showAllTodoesList(showTodoesSuccess,showTodoesError);
		}
		else {
			$scope.ModalMsgClass="error-msg";
			$scope.showErrorMessage = true;
		}
	}
	var todoError = function(data) {
		$scope.ModalMsgClass="error-msg";
		$scope.showErrorMessage = true;
	}
	/**
	 * Functions to create todo
	 */
	$scope.createTodo = function() {
		var today = new Date();
		$scope.todo.createdDate = today;
		$scope.ModalMsg="Failed to create todo.";
		$scope.todo.todoStatus = "Pending";
		console.log("add function"+JSON.stringify($scope.todo));
		homeService.createNewTodo(todoSuccess,todoError,$scope.todo);
	}
	
	/**
	 * Functions to edit todo
	 */
	$scope.editTodo = function(todo) {
		$scope.ModalMsg="";
		$scope.modalHeader ="Edit Todo";
		$scope.todo = todo;
		$scope.addFlag = false;
		var date = new Date($scope.todo.dueDate);
	//	var dueDate = new Date(date.getFullYear(),date.getMonth(),date.getDate() );
		var dueDate = $filter('date')(date, 'yyyy-MM-dd');
		$scope.todo.dueDate = dueDate;
		$("#todoModal").modal("show");
	}
	$scope.updateTodo = function() {
		$scope.ModalMsg="Failed to update todo.";
		console.log("update function"+JSON.stringify($scope.todo));
		homeService.updateTodo(todoSuccess,todoError,$scope.todo);
	}
	/**
	 * Functions to delete todo
	 */
	$scope.deleteTodo = function(todo) {
		$scope.ModalMsg="";
		$scope.deleteTodo = todo.todoId;
	}
	$scope.confirmDeleteTodo = function() {
		$scope.ModalMsg="Failed to delete todo.";
		homeService.deleteTodo(todoSuccess,todoError,$scope.deleteTodo);
	}
	/**
	 * Function for filter (All, Completed, Pending)
	 */
	$scope.applyFilter = function() {
		if($scope.filterName!="")
			homeService.filterData(showTodoesSuccess,showTodoesError,$scope.filterName);
		
	}
	
	/**
	 * Search Function
	 */
	$scope.searchTodoes = function() {
		if($scope.criteria == "text" || $scope.criteria == "")
			$scope.showText = true;
		else
			$scope.showText = false;
	}
	
	$scope.search = function() {
		
		if($scope.criteria != "") {
			 var data = {};
			 if($scope.criteria == "text")
				 data.type= "text";
			 else
				 data.type= "date";
			 console.log("================="+$scope.searchValue)
			 data.value = $scope.searchValue;
			 console.log("================="+JSON.stringify(data))
			 homeService.searchData(showTodoesSuccess,showTodoesError,data);
		}
	}
	
	/**
	 * Change status of todo
	 */
	$scope.changeStatus = function(todoId,status) {
		$scope.PageMsg="";
		homeService.changeTodoStatus(changeTodoStatusSuccess,changeTodoStatusError,todoId,status);
	}
	var changeTodoStatusSuccess = function(responseData) {
		if(responseData.response==0)
		{
			homeService.showAllTodoesList(showTodoesSuccess,showTodoesError);
			$scope.PageMsg=responseData.data;
			$scope.PageMsgClass="success-msg";
		}
		else {
			$scope.PageMsgClass="error-msg";
			$scope.PageMsg=responseData.errorMessage;
		}
	}
	var changeTodoStatusError = function(data) {
		$scope.PageMsgClass="error-msg";
		$scope.PageMsg=responseData.errorMessage;
	}
	
	/**
	 * fuction for sort data by created and due date
	 */
	$scope.sort = function(columnName) {
		if($scope.columnName == columnName) {
			$scope.reverse = !$scope.reverse;
			if($scope.sortClass =="	glyphicon glyphicon-arrow-down")
				$scope.sortClass ="	glyphicon glyphicon-arrow-up";
			else
				$scope.sortClass ="	glyphicon glyphicon-arrow-down";
		}
		else {
			$scope.reverse = false;
			$scope.sortClass ="	glyphicon glyphicon-arrow-up";
		}
		$scope.columnName = columnName
	}
}]);
