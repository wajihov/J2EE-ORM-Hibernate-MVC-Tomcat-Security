<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>AUTHENTIFICATION</title>
</head>
<body>
	<form action="j_security_check">
		<table>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="text" name="j_password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Connexion"></td>
			</tr>
		</table>
	</form>
</body>
</html>