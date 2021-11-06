<?php

include('connection.php');

$Username=$_POST["un"];
$Password=$_POST["pas"];
$Email=$_POST["em"];
$Age=$_POST["age"];
$Contact=$_POST["con"];

$query="insert into users values ('','$Username','$Password','$Email','$Age','$Contact')";

$result= mysqli_query($conn,$query);

if($result)
{
	echo "Registration Successful";
}
else
{
	echo "Registration Failed";
}


?>