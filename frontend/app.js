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

app.controller('cepController', function($scope, cepService){

    $scope.getViaCeps = function(){
        var pathVar = $scope.pathVar;

        cepService.getViaCeps(pathVar).then(function(response){
            $scope.viaCep = response.data;

            cepService.postCeps(response.data).then(function(response){
                console.log(response);
            }).catch(function(error){
                console.log(error);
            })
        }).catch(function(error){
            console.log(error);
            window.alert('Algum dado está inválido, por favor revise e tente novamente');
        })
    }
});

app.service('cepService', function($http){

    this.getViaCeps = function(pathVar){
        return $http.get('https://viacep.com.br/ws/' + pathVar + '/json/ ');
    }

    this.postCeps = function(ceps){
        return $http.post('http://localhost:8080/api/v1/via-ceps', ceps);
    }
});



