angular
    .module("routingApp")
    .controller("scoreCollaboratorCtrl", ['$rootScope', '$scope', '$http', 'APP_URL', "$location", "$routeParams",
        function ($rootScope, $scope, $http, APP_URL, $location, $routeParams) {

            $scope.session_email = localStorage.getItem("session_email");

            $scope.collaborator = {};

            $scope.option = null;
            $scope.comment = null;
            $scope.score = 0;

            $scope.scoreCollaborator = {};

            let questions = $('#content-show-questions');
            let textDescription = $('#description');

            questions.hide();
            textDescription.hide();

            this.hideInput = (event) => {

                textDescription.slideUp('slow');
                $scope.option = event.currentTarget.getAttribute("value");
                document.getElementById('description').value = null;

            };

            this.showInput = (event) => {

                textDescription.slideDown('slow');
                $scope.option = event.currentTarget.getAttribute("value");

            };

            this.selectScore = (event, score) => {

                $scope.score = parseInt(score);
                let id = event.currentTarget.getAttribute("id");

                document.getElementById("icon_love").style.filter = "grayscale(100%)";
                document.getElementById("icon_neutral").style.filter = "grayscale(100%)";
                document.getElementById("icon_angry").style.filter = "grayscale(100%)";
                document.getElementById(id).style.filter = "grayscale(0%)";

                if(id !== 'icon_love'){

                    questions.slideDown('slow');
                    $scope.option = 'Calidad';

                } else {

                    questions.slideUp('slow');
                    $scope.option = null;

                }


            };

            /*
            this.getUTCDate = () => {

                let date = new Date();
                let now_utc = Date.UTC(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate(),
                    date.getUTCHours(), date.getUTCMinutes(), date.getUTCSeconds());

                let newDate = new Date(now_utc);
                let year = newDate.getFullYear();
                let month = newDate.getMonth() + 1;
                let day = newDate.getDate();

                let hours = newDate.getHours();
                let minutes = newDate.getMinutes();
                let seconds = newDate.getSeconds();
                let miliseconds = new Date().getMilliseconds();

                return year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + (hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds) + "." + miliseconds  ;

            }
            */

            this.sendScore = async() => {
                confirmSweetAlert = null;

                await executeSweetAlert( "¿Estás seguro?", "Se enviará la evaluación de " + $scope.collaborator.name, "Aceptar", "Cancelar" );

                if(confirmSweetAlert){

                    $('#loader-table').show();

                    console.log($routeParams.token);

                    $scope.scoreCollaborator.emailEvaluator = $scope.session_email;
                    $scope.scoreCollaborator.emailEvaluated = $scope.collaborator.email;
                    $scope.scoreCollaborator.token = $routeParams.token;
                    $scope.scoreCollaborator.optionValue = $scope.option;
                    $scope.scoreCollaborator.comment = $scope.comment;
                    $scope.scoreCollaborator.score = $scope.score;
                    //$scope.scoreCollaborator.created = this.getUTCDate();

                    return $http({
                        method: 'POST',
                        url: APP_URL.url + '/scoreCollaborator/save',
                        headers: { 'Content-Type': 'application/json', 'Accept': 'application/json' },
                        data: $scope.scoreCollaborator
                    }).then((res) => {

                        bbva.showNotification('success', res.data.message);
                        document.getElementById('question-label-survey').innerHTML = 'Gracias por tu participación';

                        //console.log(res);
                        let icon_love = $('#icon_love');
                        let icon_neutral = $('#icon_neutral');
                        let icon_angry = $('#icon_angry');

                        switch( $scope.score ){
                            case 3:
                                icon_neutral.hide();
                                icon_angry.hide();
                                break;
                            case 2:
                                icon_love.hide();
                                icon_angry.hide();
                                break;
                            case 1:
                                icon_love.hide();
                                icon_neutral.hide();
                                break;
                            default:
                                break;
                        }

                        $('#content-show-questions').hide();
                        $('#content-button').hide();

                        $('#loader-table').fadeOut(1000);

                    }, (e) => {
                        console.log("Error", e.message);
                    });

                }

            };


            this.validateScore = async() => {

                if( $scope.score === 3 ) {

                    //success
                    this.sendScore();
                    $scope.option = null;

                } else if( $scope.score === 2 || $scope.score === 1 ) {

                    let other = document.getElementById('otro').checked;
                    let textArea = document.getElementById('description').value;
                    if( other === true && textArea.length < 5 ) {
                        //show error
                        alert("error");
                    } else {

                        //success
                        $scope.comment = textArea < 5 ? null : textArea;
                        this.sendScore();

                    }

                } else {

                    //show error
                    alert("error");

                }


            };


            this.init = () => {
                $('#footer').hide();
                document.getElementById('logo-sec-arch-gov').src = '../../img/LOGO_Banking-Architecture-color.png';
                document.getElementById('logo-sec-arch-gov').width = '300';

                if( $routeParams.token ) {

                    $('#loader-table').show();

                    return $http({
                        method: 'GET',
                        url: APP_URL.url + '/users/getUserByToken/' + $routeParams.token + "/" + $scope.session_email,
                        headers: { 'Content-Type': 'application/json', 'Accept': 'application/json' }
                    }).then((res) => {

                        if(res.data.status === 200){

                            bbva.showNotification('success', res.data.message);

                            $scope.collaborator = res.data.data[0];

                            document.getElementById('bar-area').innerHTML = $scope.collaborator.nameDepartment + ': ' + $scope.collaborator.nameArea;

                            $('#loader-table').fadeOut(1000);

                        } else {
                            bbva.showNotification('danger', res.data.message);
                            $location.path( "/" );

                        }



                    }, (e) => {
                        console.log("Error", e.message);
                    });

                } else {
                    $location.path( "/" );
                }




            };

        }
    ]);


