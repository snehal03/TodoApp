// routing
app.config(function($routeProvider) {
    $routeProvider
    .when("/home", {
        templateUrl : "webapp/View/Home.html",
        controller :"HomeController"
    }).otherwise({
        redirectTo: '/home',
    });
  
});
