<?php

include('connection.php');

$username=$_POST['un'];
$gender=$_POST['gn'];
$contact=$_POST['cn'];
$cardetails=$_POST['cd'];


$query="insert into mobilesnatching values ('','$username','$gender','$contact',$cardetails)";

$result= mysqli_query($conn,$query);

if($result)
{
	echo "Registered Successfully";
}
else
{
	echo "Registration Failed";
}


?>