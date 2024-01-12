angular
    .module("routingApp")
    .controller("loginCtrl", ['$rootScope', '$scope', '$http', 'APP_URL', "$location", "$routeParams", "$sce",
        function ($rootScope, $scope, $http, APP_URL, $location, $routeParams, $sce) {

            this.init = function(){
                console.log("OK");

                console.log($rootScope.email);
                console.log($scope.email);
                console.log($routeParams.email);
            }


        }
    ]);