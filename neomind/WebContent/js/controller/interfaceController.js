app.controller("InterfaceController", ["$scope", "$http", "$log","$rootScope", "$location", "InterfaceService", "$timeout","uiGridConstants",
	function($scope, $rootScope, $location, $http, $log, InterfaceService, timeout, uiGridConstants) {
	
	$scope.gridOptions = {  };
	$scope.provider = [];
	$scope.rows = [];
	
	$scope.gridOptions = {
		rowHeight: 35,         
		selectionRowHeaderWidth: 35,
		enableRowSelection: true,
		enableSelectAll: false,
		showGridFooter:false,
		paginationPageSize: 10,
		selectedItems: $scope.mySelections,
		enablePaginationControls: false,
	    enableFiltering : false,

		columnDefs: [		 
			 { 
				field: "name", 
				displayName: "Nome:", 
				enableCellEdit: false
			 },
			 {
				 field: "email",
				 displayName: "E-mail:",
				 enableCellEdit: false
			 },
			 {
				 field: "cnpj",
				 displayName: "Cnpj:",
				 enableCellEdit: false
			 },
			 {
				 field: "comment",
				 displayName: "Comentário:",
				 enableCellEdit: false
			 },
		]
	};
	
	// --- Edit ---
	$scope.editProvider = function( provider, i ) {
		var row = $scope.rows[0].entity;
		$scope.update( row );		
    };  
    // --- end edit
    
  //---- row update grid
	$scope.update = function ( row ) {
		InterfaceService.update ( row, function( response ) {			
			$scope.load();
			window.setTimeout(function() {
				location.reload();
		    }, 2000);
		}, function (err) {	
			console.log( 'Erro ' + err.data);
		})
	};
	
	$scope.aceptdelet = function () {
    	console.log("delet");
    	var rows = $scope.gridApi.selection.getSelectedRows();
    	var daterowsid = [];
    	
        for (var i=0; i < rows.length; i++) {
        	daterowsid.push(rows[i].oid);
        }
    	$scope.deletrows( daterowsid );
    };
    
    // ---=== Delet rowsw
    $scope.deletrows = function( ids ) {

    	var t = ids;
    	    	
    	InterfaceService.remove({ids: t}, function(response) {
    		
			console.log("Excluido com sucesso! ");
			$scope.load();
    	}), function(err) {
    		    		
    		console.log('Erro ' + err);
    		alert(err   + '    teste ');
    	}
    };
	
    $scope.filter = function() {
    	$scope.gridApi.grid.refresh();
	};

	$scope.singleFilter = function( renderableRows ) {
		var matcher = new RegExp( $scope.filterValue );
		
		renderableRows.forEach( function( row ) {
			var match = false;
			[ 'name', 'email' , 'cnpj'].forEach(function( field ) {
				if ( row.entity[field].toString().match(matcher) ) {
					match = true;
				}
			});
			if ( !match ) {
				row.visible = false;
			}
	    });	
		
		return renderableRows;
	};
	
	/* --- Server --- */ // Service
	$scope.load = function() { // load all		
		InterfaceService.query(function( provider ) {	

			$scope.provider = provider;
			$scope.gridOptions.data = provider;	
			 		
		}, function( error ) {			 
			console.log( error );
		});
	};
}]);