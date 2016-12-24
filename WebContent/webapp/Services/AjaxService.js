// generic ajax call 
app.service('ajaxService',['$http', function($http) {
	this.AjaxCall = function (successFunction, errorFunction,ReqHeader) {
		$http(ReqHeader).
		success(function (data, status, headers, config) {
				successFunction(data);
		}).error(function (response) {
			errorFunction(response);
		});
	};
}]);
