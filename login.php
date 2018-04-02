<?php
$con = mysqli_connect("https://sw017644.webs.see.reading.ac.uk", "sw017644_user", "c00ky199", "sw017644_TrackFit_data");

$username = $_POST["username"];
$password = $_POST["password"];

$sql_statement = mysqli_prepare($con, "SELECT * FROM user_data WHERE username = ? AND password = ?");
mysqli_stmt_bind_param($sql_statement, "ss", $username, $password);
mysql_stmt_execute($sql_statement);

mysqli_stmt_store_result($sql_statement);
mysqli_stmt_bind_result($sql_statement, $user_id, $name, $username, $password, $user_weight, $user_height, $user_email, $user_DoB);

$response = array();
$response["success"] = false;

while(mysqli_stmt_fetch($sql_statement)){
	
	$response["success"] = true;
	$response{"name"] = $name;
	$response{"username"] = $username;
	$response{"password"] = $password;
	$response{"user_weight"] = $user_weight;
	$response{"user_height"] = $user_height;
	$response{"user_email"] = $user_email;
	$response{"user_DoB"] = $user_DoB;
	}
	
	echo json_encode($response); 
	
?>
	
	
