app.controller('InterfaceControllerAdd', [ '$scope', '$rootScope', '$location', 'InterfaceService',
			   function( $scope,  $rootScope,  $location,  InterfaceService ){
	
	$rootScope.activetab = $location.path();
	$scope.providers = [];
	$scope.selected = [];
	  	
	$scope.save = function(value) {
				
		if ( value == undefined || value== "" ){
			
			bootbox.alert({
			    message: "Gentileza preencher os campos obrigatório!",
			    className: 'bb-alternate-modal'
			});
		}else if( value != undefined || value != "" ){			
			InterfaceService.save(value, function(response) {		
				
				bootbox.alert({
				    message: "Cadastro realizado com sucesso!",
				    className: 'bb-alternate-modal'
				});
				
				$scope.providers = null;
				setTimeout(function(){
  	    	         location.reload();
  	    	    }, 2000);
			}, function(err){			
				console.log( 'Erro ' + err.data);
			})
		}
	}
}]);