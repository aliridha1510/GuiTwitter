angular.module('TwitterApplication.Angular.Data', [ 'ngResource' ]).controller(
		'DatasController',
		[ '$scope', '$resource', function($scope, $resource) {
		
			var myTweet = $resource("twitterData");
			var MyHasTag = $resource("twitterDataHashtag");
			var AllTweetsInfo = $resource("twitterDataAll");

			$scope.reload = function() {
				$scope.tweets = myTweet.query();
				$scope.hashtags = MyHasTag.query();
				$scope.alltweetsinfos = AllTweetsInfo.query();

			};

			$scope.reload();
		} ]);
