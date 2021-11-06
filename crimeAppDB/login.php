<?php

include('connection.php');

$username=$_POST['un'];
$password=$_POST['ps'];

$query="select * from users where uname='".$username."' and upassword='".$password."'";

$result= mysqli_query($conn,$query);

if(mysqli_num_rows($result) > 0)
{
	//echo "Login Successful";
	$row=mysqli_fetch_assoc($result);
	print(json_encode($row));
}
else
{
	echo "Login Failed";
}


?>