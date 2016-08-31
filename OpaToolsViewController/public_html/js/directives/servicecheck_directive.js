'use strict';

angular.module('OpaToolsApp').directive('servicecheck', function($uibModal) {
  return {
    restrict: 'EA',
    templateUrl: 'pages/directives/servicecheckdirective.html',
    scope: {
      services: '=services'
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
        
        $scope.checkService = function(service) {
                
        }
    }
  }
});