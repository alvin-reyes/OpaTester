'use strict';

angular.module('OpaToolsApp')
  .controller('ServiceCheckCtrl', function ($scope) {
  
    $scope.serviceHost = "";
    $scope.services = [
        '',
        '',
        ''
    ];
    
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
