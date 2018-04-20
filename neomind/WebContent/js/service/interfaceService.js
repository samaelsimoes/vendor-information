/**
 * Arquivo service user em angular.
 * @author Samael Pereira Simões
 */

app.factory("InterfaceService", function($resource) {

	return $resource("/neomind/rest/provider/", null, {
		update: {
			method: "PUT"
		},
		remove: {
			method: "DELETE"
		}
	});
});