$(document).ready(function() {
	buscarQuestoes();
});

function buscarQuestoes() {
	$.get("/buscar-questoes", function(questoes) {
		var votos = [];
		var labels = [];
		for (i in questoes) {
			votos[i] = questoes[i].votos;
			labels[i] = questoes[i].descricao;
		}
		criarGrafico(labels, votos);
	});
}

function criarGrafico(labels, votos) {
	var contex = document.getElementById("questoesChart").getContext("2d");
	var grafico = new Chart(contex, {
	    type: "pie",
	    data: {
	        labels: labels,
	        datasets: [{
	            data: votos
	        }]
	    }
	});
}
