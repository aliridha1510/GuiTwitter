'use strict';
/*
 * This is an Angular module, which will represent our application
 */
angular.module(
		'TwitterApplication',
		[ 'ngResource', 'ngRoute', 'ui.date', 'ui.bootstrap.tabs',
				'ui.bootstrap.dropdownToggle',
				'TwitterApplication.Angular.Data',

		]).config(
		[ '$routeProvider', '$provide', '$httpProvider',
				function($routeProvider, $provide, $httpProvider) {
					$routeProvider.otherwise({
						redirectTo : '/home'
					});
					$routeProvider.when('/home', {
						templateUrl : '/app/home.html'
					});
					$routeProvider.when('/twitter/data/remote', {
						templateUrl : '/app/angular/data/index.html',
						controller : 'DatasController',
					});

					$routeProvider.when('/twitter/data/remote/hashtag', {
						templateUrl : '/app/angular/data/hashtag.html',
						controller : 'DatasController',
					});
					$routeProvider.when('/twitter/data/remote/hashtag/all', {
						templateUrl : '/app/angular/data/all.html',
						controller : 'DatasController',
					});
					$routeProvider.when('/twitter/data/graph', {
						templateUrl : '/app/angular/data/graphe/graph.html',
						controller : 'LineCtrl',
					});

				} ]);
