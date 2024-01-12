angular
    .module("routingApp")
    .controller("dashboardCtrl", ['$rootScope', '$scope', '$http', 'APP_URL', "$location", "$routeParams", "$sce",
        function ($rootScope, $scope, $http, APP_URL, $location, $routeParams, $sce) {

            $scope.session_email = localStorage.getItem("session_email");

            $scope.employee = {};

            this.getUserByEmail = function(email){

                $('#loader-table').show();

                return $http({
                    method: 'GET',
                    url: APP_URL.url + '/users/getUserByEmail/' + $scope.session_email,
                    headers: { 'Content-Type': 'application/json', 'Accept': 'application/json' }
                }).then((res) => {

                    $scope.employee = res.data; // all data of employee of session active

                    localStorage.setItem("session_picture", $scope.employee.picture);
                    localStorage.setItem("session_email", $scope.employee.email);
                    loadDataEmployee();

                    //bbva.showNotification('info', 'Información cargada con éxito.');
                    $('#loader-table').fadeOut(1000);

                }, (e) => {
                    console.log("Error", e.message);
                });
            }

            this.getSession = function(){
                return $http({
                    method: 'GET',
                    url: APP_URL.url + '/login',
                    headers: { 'Content-Type': 'application/json', 'Accept': 'application/json' }
                }).then((res) => {

                    let email = $routeParams.employee

                    $scope.session_email = email;
                    this.getUserByEmail(email);

                    $routeParams.employee = null;


                }, (e) => {
                    console.log("Error", e.message);
                });
            };

            this.init = function(){

                if( $scope.session_email == null ){

                    this.getSession();

                } else {

                    // get user by email
                    this.getUserByEmail($scope.session_email);

                }

            };


        }
    ]);
