<?php

include('connection.php');

$username=$_POST['un'];
$gender=$_POST['gn'];
$contact=$_POST['cn'];
$cardetails=$_POST['cd'];


$query="INSERT INTO `carstolen`(`username`, `gender`, `contact`, `cardetails`) values ('$username','$gender','$contact','$cardetails')";

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