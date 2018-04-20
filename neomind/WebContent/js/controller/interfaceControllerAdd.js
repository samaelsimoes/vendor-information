app.controller('InterfaceControllerAdd', [ '$scope', '$rootScope', '$location', 'InterfaceService',
			   function( $scope,  $rootScope,  $location,  InterfaceService ){
	
	$rootScope.activetab = $location.path();
	$scope.providers = [];
	$scope.selected = [];
	  	
	$scope.save = function(value) {
				
		if ( value == undefined || value== "" ){			
			console.log("Gentileza preencher os campos obrigatório");	
		}else if( value != undefined || value != "" ){			
			InterfaceService.save(value, function(response) {				
				
				console.log(value);
				console.log(response);

				bootbox.alert({
				    message: "This is an alert with an additional class!",
				    className: 'bb-alternate-modal'
				});
				$scope.providers = null;
			}, function(err){			
				console.log( 'Erro ' + err.data);
			})
		}
	}
}]);