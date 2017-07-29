var mainApp = angular.module("mainApp", ["ng-fusioncharts"]);
         
mainApp.controller('mainController', function($scope, $http) {
    /*        
        $scope.delay = 0;
	$scope.minDuration = 0;
	$scope.message = 'Please Wait...';
	$scope.backdrop = true;
	$scope.promise = null;
       */         
 /*               $scope.myDataSource = {
    chart: {
        caption: "Count of Hits",
        subcaption: "Today",
        startingangle: "120",
        showlabels: "0",
        showlegend: "1",
        enablemultislicing: "0",
        slicingdistance: "15",
        showpercentvalues: "1",
        showpercentintooltip: "0",
        plottooltext: "Hit by: $label Total hit : $datavalue",
        theme: "fint"
    },
    data: [
       
    ]
}
                
    showByUser = function(){
//         $scope.delay=1000; $scope.minDuration=1000;
        
              $http.get("http://localhost:8080/LogTracker/hello/"+$scope.inputValue+"/user")
            .then(function (list) {
                $scope.myDataSource.data = [];
                angular.forEach(list.data, function(val, i) {
                    var jsonElement = {};
                    jsonElement.value = val;
                    jsonElement.label = i;
                    
                    $scope.myDataSource.data.push(jsonElement);
                    
                    
                });
               
            })
            
                }
   
    showByIp = function(){
                   
                $http.get("http://localhost:8080/LogTracker/hello/"+$scope.inputValue+"/ip")
            .then(function (list) {
                $scope.myDataSource.data = [];
                angular.forEach(list.data, function(val, i) {
                    var jsonElement = {};
                    jsonElement.value = val;
                    jsonElement.label = i;
                    
                    $scope.myDataSource.data.push(jsonElement);
                    
                    
                });
               
            })
                
                }
   
    topShowByUser = function(){
                   $http.get("http://localhost:8080/LogTracker/hello/"+$scope.inputValue+"/user")
            .then(function (list) {
                $scope.myDataSource.data = [];
                angular.forEach(list.data, function(val, i) {
                    var jsonElement = {};
                    jsonElement.value = val;
                    jsonElement.label = i;
                    
                    $scope.myDataSource.data.push(jsonElement);
        var len = $scope.myDataSource.data.length;
        $scope.myDataSource.data.splice(0, len-5);
                    
                    
                });
               
            })
    
        
    }
    
    
    topShowByIp = function(){
        $http.get("http://localhost:8080/LogTracker/hello/"+$scope.inputValue+"/ip")
            .then(function (list) {
                $scope.myDataSource.data = [];
                angular.forEach(list.data, function(val, i) {
                    var jsonElement = {};
                    jsonElement.value = val;
                    jsonElement.label = i;
                    
                    $scope.myDataSource.data.push(jsonElement);
                    
        var len = $scope.myDataSource.data.length;
        $scope.myDataSource.data.splice(0, len-5);
                    
                });
               
            })
        
    }
    */
    
    
    
    
    
    come = function(){
        console.log("here");
    }
    
    dataSummary = function(){
          
         $http.get("http://127.0.0.1:8080/generatedColumns.json")
            .then(function (list) {
             
                $scope.summaryInteger = list.data;
             

                /*angular.forEach(list.data, function(val, i) {
                    var jsonElement = {};
                    jsonElement.value = val;
                    jsonElement.label = i;
                });*/
            })
        
         $http.get("http://127.0.0.1:8080/generatedColumnsGender.json")
            .then(function (list) {
             
                $scope.summaryGender = list.data;
                $scope.summaryGender["male"].gender = "Male"
                $scope.summaryGender["female"].gender = "Female"
                $scope.summaryGender["NA"].gender = "Unknown"
                
                
               
                
/*
                angular.forEach(list.data, function(val, i) {
                    var jsonElement = {};
                    jsonElement.value = val;
                    jsonElement.label = i;
                });*/
            })
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
         });
          