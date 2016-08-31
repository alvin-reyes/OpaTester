'use strict';

angular
  .module('OpaToolsApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.bootstrap'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'pages/main.html',
        controller: 'MainCtrl'
      })
      .when('/servicecheck', {
        templateUrl: 'pages/servicecheck.html',
        controller: 'ServiceCheckCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
