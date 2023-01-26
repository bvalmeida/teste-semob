var app = angular.module('myApp', []);

app.controller('cepController', function($scope, cepService){

    $scope.getAll = function(){
        cepService.getAll().then(function(response){
            $scope.ceps = response.data;
        })
    }

    $scope.getViaCeps = function(){
        var pathVar = $scope.pathVar;

        cepService.getViaCeps(pathVar).then(function(response){
            $scope.viaCep = response.data;

            cepService.postCeps(response.data).then(function(response){
                console.log('Entrei no post do controler, está é a data do response: ', response.data);
            }).catch(function(error){
                console.log(error);
            })

        }).catch(function(error){
            console.log(error);
        })
    }
});

app.service('cepService', function($http){

    this.getAll = function(){
        return $http.get('http://localhost:8080/api/v1/via-ceps');
    }

    this.getViaCeps = function(pathVar){
        return $http.get('https://viacep.com.br/ws/' + pathVar + '/json/ ');
    }

    this.postCeps = function(ceps){
        return $http.post('http://localhost:8080/api/v1/via-ceps', ceps);
    }
});


// $scope.get = function(){
    //     console.log('entrou testando');
    //     console.log($http);

    //     $http({
    //         method: 'GET',
    //         url: 'http://localhost:8080/api/v1/via-ceps'
    //       }).then(function successCallback(response) {
    //         console.log(response.data)
    //         $scope.ceps = response.data;
    //           // this callback will be called asynchronously
    //           // when the response is available
    //         }, function errorCallback(response) {
    //             console.log('falha')
    //           // called asynchronously if an error occurs
    //           // or server returns response with an error status.
    //         });
        

    // }



