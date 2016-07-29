/**
 * Created by kancer on 28.07.2016.
 */
(function(angular) {
    var ItemFactory = function($resource) {
        return $resource('/items/:id', {
            id: '@id'
        }, {
            update: {
                method: "PUT"
            },
            remove: {
                method: "DELETE"
            }
        });
    };

    ItemFactory.$inject = ['$resource'];
    angular.module("demoApp").factory("Item", ItemFactory);
}(angular));
