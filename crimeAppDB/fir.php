<?php

include('connection.php');

$username=$_POST['un'];
$email=$_POST['gn'];
$contact=$_POST['cn'];


$query="INSERT INTO `fir`(`Name`, `Cnic`, `Contact`) VALUES ('$username','$email','$contact')";

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