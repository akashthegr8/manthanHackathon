var mainApp = angular.module("mainApp", ["ng-fusioncharts"]);
         
mainApp.controller('mainController', function($scope, $http) {
    /*        
        $scope.delay = 0;
	$scope.minDuration = 0;
	$scope.message = 'Please Wait...';
	$scope.backdrop = true;
	$scope.promise = null;
       */         
                $scope.myDataSource = {
    chart: {
        caption: "Count of Sales Contribution",
        subcaption: "Today",
        startingangle: "120",
        showlabels: "0",
        showlegend: "1",
        enablemultislicing: "0",
        slicingdistance: "15",
        showpercentvalues: "1",
        showpercentintooltip: "0",
        plottooltext: "Sales by : $label is : $datavalue",
        theme: "fint"
    },
    data: [
       
    ]
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
                
                $scope.summaryMStatus = {};
                $scope.summaryMStatus["Married"] = {"category" : "married" , "count" : $scope.summaryGender["male"].Married + $scope.summaryGender["female"].Married}
                $scope.summaryMStatus["Unmarried"] = {"category" : "unmarried" , "count" : $scope.summaryGender["male"].Single + $scope.summaryGender["female"].Single}
                $scope.summaryMStatus["Unknown"] = {"category" : "unknown" , "count" : $scope.summaryGender["male"].Unknown + $scope.summaryGender["female"].Unknown}
                $scope.summaryMStatus["NA"] = {"category" : "NA" , "count" :  $scope.summaryGender["NA"].NA}
               
                
/*
                angular.forEach(list.data, function(val, i) {
                    var jsonElement = {};
                    jsonElement.value = val;
                    jsonElement.label = i;
                });*/
            })
        
        
        
        
    }
    
    
    graphs = function(){
        $http.get("http://127.0.0.1:8080/storeData.json")
            .then(function (list) {
              
                $scope.myDataSource.data = [];
                angular.forEach(list.data, function(val, i) {
                    var jsonElement = {};
                    var count = 0;
                    angular.forEach(val, function(val1, i) {
                        count +=val1.sales
                        
                    })
                                    
                    jsonElement.value = count;
                    jsonElement.label = i;
                    
                    $scope.myDataSource.data.push(jsonElement);
                });
                    
                });
               
         
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
         });
          