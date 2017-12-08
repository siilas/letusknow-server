$(document).ready(function() {
	buscarQuestoes();
});

function buscarQuestoes() {
	$.get("/buscar-questoes", function(questoes) {
		var votos = [];
		var labels = [];
		for (i in questoes) {
			labels[i] = questoes[i].descricao.split(" ");
			for (j in questoes[i].respostas) {
				votos.push({
					label: questoes[i].respostas[j].descricao,
					backgroundColor: criarCorAleatoria(),
					stack: 'Stack ' + j,
					data: criarData(questoes.length, questoes[i].respostas[j].votos, i)
				});
			}
		}
		criarGrafico(labels, votos);
	});
}

function criarGrafico(labels, votos) {
	var contex = document.getElementById("questoesChart").getContext("2d");
	var grafico = new Chart(contex, {
	    type: "bar",
	    data: {
	        labels: labels,
	        datasets: votos
	    },
	    options: {
	    	responsive: true,
	        scales: {
	        	xAxes: [{
	                stacked: true,
	            }],
	            yAxes: [{
	                ticks: {
	                    beginAtZero: true,
	                    stacked: true
	                }
	            }]
	        }
	    }
	});
}

function criarData(tamanho, votos, indice) {
	var data = [];
	for (var i = 0; i < tamanho; i++) {
		if (indice == i) {
			data[i] = votos;
		} else {
			data[i] = 0;
		}
	}
	return data;
}

function criarCorAleatoria() {
    var letras = '0123456789ABCDEF';
    var cor = '#';
    for (var i = 0; i < 6; i++ ) {
    	cor += letras[Math.floor(Math.random() * 16)];
    }
    return cor;
}
