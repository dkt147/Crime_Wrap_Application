<?php

include('connection.php');

$username=$_POST['un'];
$gender=$_POST['gn'];
$contact=$_POST['cn'];
$address=$_POST['cd'];


$query="INSERT INTO `arson`(`username`, `gender`, `contact`, `address`) VALUES ('$username','$gender','$contact','$address')";

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