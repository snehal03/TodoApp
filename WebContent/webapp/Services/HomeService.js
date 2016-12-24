app.service("homeService",['ajaxService',function(ajaxService){
	
	// for get all todoes
	this.showAllTodoesList = function(successFunction,errorFunction) {
		var reqHeader =
		 { 
			method: 'GET',
			url: getApiName("showAllTodoes")+"/All",
			headers: {
				"Content-Type": "application/json",
			},
			data:''
		};
		ajaxService.AjaxCall(successFunction,errorFunction,reqHeader);
	}
	// for create new todo
	this.createNewTodo = function(successFunction,errorFunction,data) {
		var reqHeader =
		 { 
			method: 'POST',
			url: getApiName("createNewTodo"),
			headers: {
				"Content-Type": "application/json",
			},
			data:data
		};
		ajaxService.AjaxCall(successFunction,errorFunction,reqHeader);
	}
	// for update todo
	this.updateTodo = function(successFunction,errorFunction,data) {
		var reqHeader =
		 { 
			method: 'POST',
			url: getApiName("updateTodo"),
			headers: {
				"Content-Type": "application/json",
			},
			data:data
		};
		ajaxService.AjaxCall(successFunction,errorFunction,reqHeader);
	}
	// for delete todo
	this.deleteTodo = function(successFunction,errorFunction,data) {
		var reqHeader =
		 { 
			method: 'DELETE',
			url: getApiName("deleteTodo")+"?todoId="+data,
			headers: {
				"Content-Type": "application/json",
			},
			data:''
		};
		ajaxService.AjaxCall(successFunction,errorFunction,reqHeader);
	}
	// for filter todoes
	this.filterData = function(successFunction,errorFunction,filterType) {
		var reqHeader =
		 { 
			method: 'GET',
			url: getApiName("showAllTodoes")+"/"+filterType,
			headers: {
				"Content-Type": "application/json",
			},
			data:''
		};
		ajaxService.AjaxCall(successFunction,errorFunction,reqHeader);
	}
	// for search todoes
	this.searchData = function(successFunction,errorFunction,data) {
		var reqHeader =
		 { 
			method: 'GET',
			url: getApiName("searchTodoes")+"/"+data.type+"/"+data.value,
			headers: {
				"Content-Type": "application/json",
			},
			data:data
		};
		ajaxService.AjaxCall(successFunction,errorFunction,reqHeader);
	}
	// for change todo status
	this.changeTodoStatus = function(successFunction,errorFunction,todoId,status) {
		var reqHeader =
		 { 
			method: 'POST',
			url: getApiName("changeTodoStatus")+"/"+todoId+"/"+status,
			headers: {
				"Content-Type": "application/json",
			},
			data:''
		};
		ajaxService.AjaxCall(successFunction,errorFunction,reqHeader);
	}
	
}])