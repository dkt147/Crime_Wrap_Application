<?php

include('connection.php');

$username=$_POST['un'];
$gender=$_POST['gn'];
$contact=$_POST['cn'];
$details=$_POST['cd'];


$query="INSERT INTO `kidnapp`( `username`, `gender`, `contact`, `details`) VALUES ('$username','$gender','$contact','$details')";

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