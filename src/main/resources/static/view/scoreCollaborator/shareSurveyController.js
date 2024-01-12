angular
    .module("routingApp")
    .controller("shareSurveyCtrl", ['$rootScope', '$scope', '$http', 'APP_URL', "$location", "$routeParams", "$sce",
        function ($rootScope, $scope, $http, APP_URL, $location, $routeParams, $sce) {

            $scope.session_email = localStorage.getItem("session_email");
            $scope.tokenVerified = {};

            this.save = function(){

                let swalWithBootstrapButtons = Swal.mixin({
                    customClass: {
                        confirmButton: 'btn btn-primary btn-bbva',
                        cancelButton: 'btn btn-light btn-bbva-cancel'
                    },
                    buttonsStyling: false
                });

                swalWithBootstrapButtons.fire({
                    title: '¿Estás seguro?',
                    text: 'Se generará el enlace para compartir',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Generar',
                    cancelButtonText: 'Cancelar',
                    reverseButtons: true,

                }).then( (res) => {

                    if(res.isConfirmed){

                        $('#loader-table').show();

                        let token = getUUID();

                        $scope.tokenVerified.emailUser = $scope.session_email;
                        $scope.tokenVerified.token = token;

                        return $http({
                            method: 'POST',
                            url: APP_URL.url + '/tokenVerified/save',
                            headers: { 'Content-Type': 'application/json', 'Accept': 'application/json' },
                            data: $scope.tokenVerified
                        }).then((res) => {

                            bbva.showNotification('success', res.data.message);
                            $('#loader-table').fadeOut(1000);

                            swalWithBootstrapButtons.fire({
                                title: 'URL',
                                html: `${APP_URL.url_server}/#!/scoreCollaborator?token=${$scope.tokenVerified.token}`,
                                icon: 'success',
                                confirmButtonText: 'Aceptar'
                            });




                        }, (e) => {
                            console.log("Error", e.message);
                        });






                    }

                });



            };

            this.init = function(){

                $('#footer').hide();
                document.getElementById('logo-sec-arch-gov').src = '../../img/LOGO_Banking-Architecture-color.png';
                document.getElementById('logo-sec-arch-gov').width = '300';


            };


        }
    ]);


