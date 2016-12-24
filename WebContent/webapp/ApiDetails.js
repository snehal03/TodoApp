/**
 * @param name
 * @returns {String}
 * function to return url of api
 * 
 */
function getApiName(name){ 
	
	var commonUrl ="http://localhost:8080/TodoApp/todo/";
	
	 var urlObj={
			 "showAllTodoes":"getAllTodoes",
			 "createNewTodo":"createTodo",
			 "updateTodo" :"updateTodo",
			 "deleteTodo":"deleteTodo",
			 "searchTodoes":"searchTodoes",
			 "changeTodoStatus":"changeTodoStatus"
	 }
	 return commonUrl+urlObj[name];
}