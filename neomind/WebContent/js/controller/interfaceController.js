app.controller("InterfaceController", ["$scope", "$http", "$log","$rootScope", "$location", "InterfaceService", "$timeout","uiGridConstants",
	function($scope, $rootScope, $location, $http, $log, InterfaceService, timeout, uiGridConstants) {
	
		$scope.rows = [];
		$scope.provider = [];

		$scope.gridOptions = {
			
			rowHeight: 35,         
			selectionRowHeaderWidth: 35,
			enableRowSelection: true,
			enableColumnResizing: true,
			multiSelect: true,
			enableSelectAll: true,
			showGridFooter:false,
			paginationPageSize: 10,
			selectedItems: $scope.mySelections,
			enablePaginationControls: false,
		    enableFiltering : false,
		    enableSelectionBatchEvent: true,

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
	
		/* --- Server --- */ // Service
		$scope.load = function() { // load all		
			InterfaceService.query(function( provider ) {	

				$scope.provider = provider;
				$scope.gridOptions.data = provider;	
				 		
			}, function( error ) {			 
				console.log( error );
			});
		};
		
		// ---- ROWS checkeds or unchecked	
		$scope.gridOptions.onRegisterApi = function ( gridApi ) {	
			
			$scope.gridApi = gridApi;
			$scope.gridApi.grid.registerRowsProcessor( $scope.singleFilter, 200 );	
						
			gridApi.selection.on.rowSelectionChanged( $scope, function( row ) {
				
				var msg = row.isSelected; //one selected true or false
			
				if ( msg ) {
					$scope.rows.push( row );
				} else {				
					$scope.rows.splice( $scope.rows.indexOf ( row ) );
				}
			}); // Grid Edit Situation selected
		    gridApi.rowEdit.on.saveRow($scope, function(rowEntity){
		    	$scope.update( rowEntity );
		    });
		};
		
		//-- end load 
		$scope.editProvider = function ( e, t ) {			
			var row = $scope.rows[0].entity;
			$scope.update( row );
		};
		
		//---- row update grid
		$scope.update = function ( row ) {
			InterfaceService.update( row, function( response ) {			
				$scope.load();
					
				bootbox.alert({
				    message: "Editado com sucesso!",
				    className: 'bb-alternate-modal'
				});
				
			}, function (err) {	
				toastr.error( 'Erro ' + err.data);
			})
		};
		
		$scope.aceptdelet = function () {
	    	
	    	var rows = $scope.gridApi.selection.getSelectedRows();
	    	var daterowsid = [];
	    		        
	    	for (var i=0; i < rows.length; i++) {
	        	daterowsid.push(rows[i].id);
	        }
	    	$scope.deletrows( daterowsid );
	    };
	    
	    // ---=== Delet rowsw
	    $scope.deletrows = function( ids ) {

	    	var t = ids;
	    	    	console.log(ids);
	    	InterfaceService.remove({ids: t}, function(response) {
	    		
	    		bootbox.alert({
				    message: "Excluido com sucesso!",
				    className: 'bb-alternate-modal'
				});
	    		
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
				if ( !match ) { row.visible = false; }
		    });		
		  return renderableRows;
		};    	
		
	$scope.load();
}]);