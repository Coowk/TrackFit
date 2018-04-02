<?php
$connect = mysqli_connect('localhost', "sw017644_admin", "c00ky199", "sw017644_TrackFit_data");

if(!$connect)
{
	die("Failed to connect to the database: " , mysql_error());
}

	$name = $_POST["name"];
	$username = $_POST["username"];
	$password = $_POST["password"];
	$user_weight = $_POST["user_weight"];
	$user_height = $_POST["user_height"];
	$user_email = $_POST["user_email"];
	$user_DoB = $_POST["user_DoB"];
	
	
	
	$sql_statement = mysqli_prepare($connect, "INSERT INTO user_data (name, username, password, user_weight, user_height, user_email, user_DoB) VALUES (?, ?, ?, ?)");
	mysqli_stmt_bind_param($sql_statement, "siss", $name, $username, $password, $user_weight, $user_height, $user_email, $user_DoB);
	mysqli_stmt_execute($statement);
	
	$response = array();
	$response["success"]=true;
	
	echo json_encode($response);
	
?>
	
	
	
	