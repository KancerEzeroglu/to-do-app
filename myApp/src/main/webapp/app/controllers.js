/**
 * Created by kancer on 28.07.2016.
 */
(function(angular) {
    var AppController = function($scope, Item) {
        Item.query(function(response) {
            $scope.items = response ? response : [];
        });

        $scope.addItem = function(description) {
            new Item({
                description: description,
                checked: false
            }).$save(function(item) {
                $scope.items.push(item);
            });
            $scope.newItem = "";
        };

        $scope.updateItem = function(item) {
            item.$update();
        };

        $scope.deleteItem = function(item) {
            item.$remove(function() {
                $scope.items.splice($scope.items.indexOf(item), 1);
            });
        };
    };

    AppController.$inject = ['$scope', 'Item'];
    angular.module("demoApp").controller("AppController", AppController);
}(angular));
