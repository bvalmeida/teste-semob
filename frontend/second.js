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

app.controller('secondController', function($scope, navigationService, cepService){
    $scope.goBack = function(){
        navigationService.goToPage('/index.html');
        console.log('teste');
    }

    $scope.getViaCepsPesquisas = function(){
        cepService.getAll().then(function(response){
            $scope.ceps = response.data;
            console.log(response.data);
        }).catch(function(error){
            window.alert(error.data.titulo);
            console.log(error.data);
        })
    }

});

app.service('navigationService', function($location){
    this.goToPage = function(page){
        $location.path(page);
    }
});

app.service('cepService', function($http){

    this.getAll = function(){
        return $http.get('http://localhost:8080/api/v1/via-ceps');
    }
});


