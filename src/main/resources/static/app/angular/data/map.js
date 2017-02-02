angular.module('TwitterApplication.Angular.Data', []).controller(
		'DatasController',
		function($scope, $resource, $timeout, $http) {
			var Map = $resource("twitterDataMap");
			var myTweet = $resource("twitterData");
			var MyHasTag = $resource("twitterDataHashtag");
			var AllTweetsInfo = $resource("twitterDataAll");
			 $scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
			  $scope.series = ['Series A', 'Series B'];
			  $scope.data = [
			    [65, 59, 80, 81, 56, 55, 40],
			    [28, 48, 40, 19, 86, 27, 90]
			  ];
			  $scope.onClick = function (points, evt) {
			    console.log(points, evt);
			  };
			  $scope.datasetOverride = [{ yAxisID: 'y-axis-1' }, { yAxisID: 'y-axis-2' }];
			  $scope.options = {
			    scales: {
			      yAxes: [
			        {
			          id: 'y-axis-1',
			          type: 'linear',
			          display: true,
			          position: 'left'
			        },
			        {
			          id: 'y-axis-2',
			          type: 'linear',
			          display: true,
			          position: 'right'
			        }
			      ]
			    }
			  };
			$scope.reload = function() {
				$scope.tweets = myTweet.query();
				$scope.hashtags = MyHasTag.query();
				$scope.alltweetsinfos = AllTweetsInfo.query();

			};

			$scope.reload();
			$http({
				method : 'GET',
				url : '/twitterDataMap'
			}).then(
					function successCallback(response) {
						// this callback will be called asynchronously
						// when the response is available
						console.log(response);
						var cities = response.data;

						var mapOptions = {
							zoom : 4,
							center : new google.maps.LatLng(40.0000, -98.0000),
							mapTypeId : google.maps.MapTypeId.TERRAIN
						}

						$scope.map = new google.maps.Map(document
								.getElementById('map'), mapOptions);

						$scope.markers = [];

						var infoWindow = new google.maps.InfoWindow();

						var createMarker = function(info) {
							console.log(info.latitude + " " + info.longitude);
							var marker = new google.maps.Marker({
								map : $scope.map,
								position : new google.maps.LatLng(
										info.latitude, info.longitude),
								title : info.full_name + "NUMMBER OF TWEETS:"
										+ info.ftCount
							});
							marker.content = '<div class="infoWindowContent">'
									+ info.ftCount + '</div>';

							google.maps.event.addListener(marker, 'click',
									function() {
										infoWindow.setContent('<h2>'
												+ marker.title + '</h2>'
												+ marker.content);
										infoWindow.open($scope.map, marker);
									});

							$scope.markers.push(marker);

						}

						for (i = 0; i < cities.length; i++) {
							createMarker(cities[i]);
						}

						$scope.openInfoWindow = function(e, selectedMarker) {
							e.preventDefault();
							google.maps.event.trigger(selectedMarker, 'click');
						}

					}, function errorCallback(response) {
						// called asynchronously if an error occurs
						// or server returns response with an error status.
					});

		});