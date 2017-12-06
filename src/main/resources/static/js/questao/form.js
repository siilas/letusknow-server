
function adicionarResposta() {
	var count = $("#questoes-table tbody tr").length;
	var html = "<tr>"
		+ "<td scope=\"row\">"
		+ "<input type=\"text\" class=\"form-control\" name=\"respostas[" + count + "].descricao\" value=\"\" />"
		+ "</td>"
		+ "<td>"
		+ "<input type=\"hidden\" name=\"respostas[" + count + "].id\" value=\"\" />"
		+ "<input type=\"hidden\" name=\"respostas[" + count + "].votos\" value=\"0\" />"
		+ "<input type=\"hidden\" name=\"respostas[" + count + "].questaoId\" value=\"" + $("#id").val() + "\" />"
	    + "<button type=\"button\" class=\"btn btn-danger\" onclick=\"excluirResposta(this);\">Excluir</button>"
		+ "</td>"
		+ "</tr>";
	$("#questoes-table tbody").append(html);
}

function excluirResposta(button, id) {
	if (id !== undefined) {
		$.get("/resposta/excluir?id=" + id, function(response) {
			$("#messenger").html("<div class=\"alert alert-success\" role=\"alert\">" + response.mensagem + "</div>")
			$(button).parent().parent().remove();
		});
	} else {
		$(button).parent().parent().remove();
	}
}
