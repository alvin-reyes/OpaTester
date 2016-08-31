'use strict';

angular.module('OpaToolsApp')
  .controller('ServiceCheckCtrl', function ($scope) {
  
    var _selected;
    $scope.selected = undefined;
    $scope.servers = [
    'Alabama', 'Alaska', 
    'Arizona', 'Arkansas', 
    'California', 'Colorado', 
    'Connecticut', 'Delaware', 
    'Florida', 'Georgia', 'Hawaii',
    'Idaho', 'Illinois', 'Indiana', 
    'Iowa', 'Kansas', 'Kentucky', 
    'Louisiana', 
    'Maine', 
    'Maryland', 
    'Massachusetts',
    'Michigan', 
    'Minnesota', 
    'Mississippi', 
    'Missouri', 
    'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Dakota', 'North Carolina', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'];
    
    $scope.selectServer = function(item) {
        console.log(item);
    }
    $scope.services = [
            {"name":"a","status":"ok","actions":''},
            {"name":"a","status":"ok","actions":''}
        ];
  });