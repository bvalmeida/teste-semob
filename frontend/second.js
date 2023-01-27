var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider
		.when('/index', {
			templateUrl: 'index.html',
			controller: 'cepController'
		})
		.when('/second', {
			templateUrl: 'second.html',
			controller: 'SecondController'
		})
		.otherwise({
			redirectTo: '/index'
		});
});

app.controller('secondController', function($scope, navigationService){
    $scope.goBack = function(){
        navigationService.goToPage('/index.html');
        console.log('teste');
    }

});

app.service('navigationService', function($location){
    this.goToPage = function(page){
        $location.path(page);
    }
})

