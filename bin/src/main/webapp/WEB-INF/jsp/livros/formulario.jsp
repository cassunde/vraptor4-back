<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkTo[LivrosController].salva }" method="post">
		<h2>Formulário de cadastro de livros</h2>
		<ul>
			<li>Titulo: <br /> <input type="text" name="livro.titulo" /></li>
			<li>Descricao: <br /> <textarea name="livro.descricao"></textarea></li>
			<li>ISBN: <br /> <input type="text" name="livro.isbn" /></li>
			<li>Preco: <br /> <input type="text" name="livro.preco" /></li>
			<li>Data de publicacao: <br /> <input type="text"
				name="livro.dataPublicacao" /></li>
		</ul>
		<input type="submit" value="Salvar" />
	</form>

</body>
</html>