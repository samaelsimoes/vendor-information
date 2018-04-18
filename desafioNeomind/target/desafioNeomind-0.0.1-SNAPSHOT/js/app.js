var app = angular.module("appHome",["ngAnimate", "ngTouch", "ui.grid.selection", "ui.grid.exporter", "ui.grid", "ui.grid.pagination", "ui.grid.cellNav", "ui.grid.expandable",
	 "ui.grid.edit", "ui.grid.rowEdit", "ui.grid.saveState", "ui.grid.resizeColumns", "ui.grid.pinning", "ui.grid.moveColumns", "ui.grid.infiniteScroll", "ui.grid.grouping", "toastr", "ngResource", 
	 "ngRoute", "ngTouch"]); 

app.pathRest = 'rest';
app.config(function($routeProvider, $locationProvider){
	
    // remove o # da url
	$locationProvider.html5Mode({		
		enabled: false,
	  	requireBase: false
	});    
	 
	$routeProvider
	
	.when('/cadastro', {	
    	templateUrl: './index.html',
      	controller: 'InterfaceController',
    }) 

   .otherwise ({
	   redirectTo: '/cadastro' 
   });
});