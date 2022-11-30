var app = angular.module("EmployeeManagement", []);

// Controller Part
app.controller("EmployeeController", function($scope, $http){
	$scope.employees=[];
	$scope.employeeForm = {
		"empId": 1,
        "empNo": "",
        "empName": ""
	};
	
	_refreshEmployeeData();
	
	$scope.submitEmployee = function(){
		var method = "";
		var url="";
		
		if ($scope.employeeForm.empId == -1){
			method = "POST";
			url = '/rest/employees'
		}else{
			method = "PUT";
			url = '/rest/employees'
		}
		
		$http({
			method: method,
			url: url,
			data: angular.toJson($scope.employeeForm),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(_success, _error);
	};
	
	$scope.createEmployee = function(){
		_clearFromData();
	};
	
	$scope.deleteEmployee = function(employee){
		
		$http({
			method: 'DELETE',
			url: '/rest/employees/' + employee.empId,
			
		}).then(_success, _error);
	};
	
	$scope.editEmployee = function(employee){
		
		$scope.employeeForm.empId = employee.empId;
		$scope.employeeForm.empNo = employee.empNo;
		$scope.employeeForm.empName = employee.empName;
	};
	function _refreshEmployeeData(){
		$http({
			method: 'GET',
			url: '/rest/employees/',
		}).then(
			function(res){
				$scope.employees = res.data;
			}, 
			function(res){
				console.log("Error: " + res.status + ":" + res.data)
			});
	};
	function _success(res){
		_refreshEmployeeData();
		_clearFromData();
	};
	function _error(res){
		var data = res.data;
		var status = res.status;
		var header = res.header;
		var congig = res.config;
		alert("Error: " + status + ":" + data)
	};
	
	function _clearFromData(){
		$scope.employeeForm.empId = -1;
		$scope.employeeForm.empNo = "";
		$scope.employeeForm.empName = "";
	};
})