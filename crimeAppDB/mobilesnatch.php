<?php

include('connection.php');

$username=$_POST['un'];
$gender=$_POST['gn'];
$contact=$_POST['cn'];
$snatchingpoint=$_POST['sp'];


$query="INSERT INTO `mobilesnatch`(`username`, `gender`, `contact`, `snatchingpoint`) VALUES ('$username','$gender','$contact','$snatchingpoint')";

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