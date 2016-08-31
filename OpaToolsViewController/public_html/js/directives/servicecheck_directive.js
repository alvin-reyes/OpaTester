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
        
        $scope.selectedDoctor = undefined;
        $scope.doctors = function() { 
            var doctorArray = [];
            //  Get all team members
            for(var i=0;i<$scope.erTeams.length;i++) {
                for(var j=0;j<$scope.erTeams[i].members.length;j++) {
                    if($scope.erTeams[i].members[j].type == 'Doctor') {
                        doctorArray.unshift($scope.erTeams[i].members[j]);
                    }
                }
            }
            return doctorArray;
        }
        
           
        $scope.selectServer = function(item) {
            console.log(item);
            var promiseArray = [];
            for( var i=0;i<$scope.services.length;i++) {
                $scope.services[i].name = item + $scope.services[i].name;
                console.log($scope.services[i].status);
                var promise = $http.get($scope.services[i].name)
                    .then(
                        function(resp) { console.log($scope.services[i].status); $scope.services[i].status = resp.status;}
                    ,   function(resp) { console.log($scope.services[i].status); $scope.services[i].status = resp.status;}
                    );
                //  Run the checks after.
                promiseArray.push(promise);
                
            }
            $q.add(promiseArray);
        }
        
        $scope.checkService = function(service) {
            console.log("hello");
        }
    }
  }
});