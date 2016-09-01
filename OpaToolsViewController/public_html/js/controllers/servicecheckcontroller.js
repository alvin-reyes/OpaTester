'use strict';

angular.module('OpaToolsApp')
  .controller('ServiceCheckCtrl', function ($scope) {
    $scope.serviceurl = "http://192.168.1.105:7001/OpaToolsService/";
    var _selected;
    $scope.selected = undefined;
    $scope.servers = ['http://www.nba.com'];
    $scope.services = [
            {"name":"/a","status":"","actions":function(){console.log(this)}},
            {"name":"/","status":"","actions":function(){console.log(this)}}
        ];
  });