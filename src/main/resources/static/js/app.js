angular
  .module('routingApp', ['ngRoute'])
  .config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/', {
      templateUrl: 'dashboard.html',
        controller: 'dashboardCtrl',
        controllerAs: 'ctrlDashboard'

    }).when('/survey/share', {
        templateUrl: '../view/scoreCollaborator/shareSurvey.html',
        controller: 'shareSurveyCtrl',
        controllerAs: 'ctrlShareSurvey'

    }).when('/scoreCollaborator', {
        templateUrl: '../view/scoreCollaborator/scoreCollaborator.html',
        controller: 'scoreCollaboratorCtrl',
        controllerAs: 'ctrlScoreCollaborator'

    }).otherwise({
      redirectTo: '/',
    })

  }])
  .constant('APP_URL', {
      url: 'http://localhost:8080/oauth2_client_example',
      url_server: 'http://localhost:8080'
      //url: 'https://a4a1-2806-2f0-a3e0-f54c-1133-2a61-366b-d140.ngrok-free.app/oauth2_client_example',
      //url_server: 'https://a4a1-2806-2f0-a3e0-f54c-1133-2a61-366b-d140.ngrok-free.app'

  })


