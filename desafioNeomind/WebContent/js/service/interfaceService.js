/**
 * Arquivo service user em angular.
 * @author Samael Pereira Simões
 */

app.factory("InterfaceService", function($resource) {
	return $resource("/desafioNeomind/rest/provider/", null, {
		update: {
			method: "PUT"
		},
		remove: {
			method: "DELETE"
		}
	});
});