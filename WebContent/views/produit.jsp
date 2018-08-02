<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>P r o d u i t</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript">
	function confirmation(id) {
		var conf = confirm("Ëtes vous sur de le supprimer? ");
		if (conf == true)
			document.location = "controller.php?action=delete&id=" + id;
	}
</script>
</head>
<body>
	<div>
		<form action="controller.php" method="post">
			<table class="table1" align="center">
				<tr>
					<td colspan="2" align="center" style="color: blue;">Ajouter
						Produit</td>
				</tr>
				<tr>
					<c:if test="${ produit!=null}">
						<td style="color: threedface;">ID :</td>
						<td>${produit.idProduit }<input type="hidden" name="id_prod"
							value="${produit.idProduit }"></td>
					</c:if>
				</tr>
				<tr>
					<td style="color: maroon;">Désignation :</td>
					<td><input type="text" name="design"
						value="${produit.designation }"></td>
				</tr>
				<tr>
					<td>Prix :</td>
					<td><input type="text" name="prix"
						value="${produit.quantity }"></td>
				</tr>
				<tr>
					<td>Quantité :</td>
					<td><input type="text" name="quantite"
						value="${produit.prix }"></td>
				</tr>
				<tr>
					<td align="center"><input type="reset" value="Annuler"
						name="action"></td>
					<td align="center"><c:if test="${produit!=null }">
							<input type="submit" value="Update" name="action">
						</c:if> <c:if test="${produit==null}">
							<input type="submit" value="Save" name="action">
						</c:if></td>
				</tr>
			</table>
		</form>
	</div>

	<c:if test="${erreur!=null }">
		<div>${erreur }</div>
	</c:if>


	<div>
		<table class="table1" align="center">
			<tr>
				<th>ID</th>
				<th>Designation</th>
				<th>PRIX</th>
				<th>Quantité</th>
			</tr>
			<c:forEach items="${produits}" var="p">
				<tr>
					<td>${p.idProduit }</td>
					<td>${p.designation }</td>
					<td>${p.prix }</td>
					<td>${p.quantity}</td>
					<%--<td><a href="controller.php?action=delete&id=${p.idProduit }">Supprimer</a> </td> --%>
					<td><a href="javascript:confirmation('${p.idProduit }')">Supprimer</a>
					</td>
					<td><a href="controller.php?action=edit&id=${p.idProduit }">Editer</a>
					</td>

				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>