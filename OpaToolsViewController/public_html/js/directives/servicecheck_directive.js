'use strict';

angular.module('OpaToolsApp').directive('servicecheck', function($uibModal,$http,$q) {
  return {
    restrict: 'EA',
    templateUrl: 'pages/directives/servicecheckdirective.html',
    scope: {
      services: '=services',
      servers:'=servers'
    },
    link: function($scope, element, attr, ctrl) {
        $scope.selectedServer = '';
        $scope.selectServer = function(item) {
            console.log(item);
            var promiseArray = [];
            for( var i=0;i<$scope.services.length;i++) {
                $scope.services[i].name = item + $scope.services[i].name;
                console.log($scope.services[i].status);
                var promise = $http.get($scope.services[i].name);
                promise.success(function(data, status, headers, config) {
                    console.log(status);
                    $scope.services[i].status = "OK";
                });
                promise.error(function(data, status, headers, config) {
                    console.log(status);
                    $scope.services[i].status = "NOT OK";
                });
                //  Run the checks after.
                promiseArray.push(promise);
            }
            $q.all(promiseArray);
            
            console.log(promiseArray);
        }
        
        $scope.checkService = function(service) {
            var promise = $http.get(service.name);
            promise.success(function(data, status, headers, config) {
                console.log(status);
                service.status = "OK";
            });
            promise.error(function(data, status, headers, config) {
                console.log(status);
                service.status = "NOT OK";
            });
        }
    }
  }
});