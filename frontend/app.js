var app = angular.module('myApp', []);

app.controller('myController', function($scope, $http){

    $scope.get = function(){
        console.log('entrou testando');
        console.log($http);

        $http({
            method: 'GET',
            url: 'http://localhost:8080/api/v1/via-ceps'
          }).then(function successCallback(response) {
            console.log(response.data)
            $scope.ceps = response.data;
              // this callback will be called asynchronously
              // when the response is available
            }, function errorCallback(response) {
                console.log('falha')
              // called asynchronously if an error occurs
              // or server returns response with an error status.
            });
        

    }
})



