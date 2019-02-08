package com.github.siilas.letusknow;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.github.siilas.letusknow.vo.QuestaoVO;
import com.github.siilas.letusknow.vo.ResponseVO;
import com.github.siilas.letusknow.vo.VotosVO;
import com.github.tomakehurst.wiremock.WireMockServer;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class QuestaoResourceSteps {

    private static final int PORT = 8096;

    private RestTemplate template = new RestTemplate();
    private WireMockServer server = new WireMockServer(options().port(PORT));

    @Before
    public void init() {
        server.start();
    }

    @After
    public void stop() {
        server.stop();
    }

    @Quando("a consulta ao serviço retornar sucesso")
    public void quandoAConsultaAoServicoRetornarSucesso() {
        server.stubFor(get(urlPathEqualTo("/ws/questoes"))
                .willReturn(aResponse()
                        .withHeader("content-type", "application/json")
                        .withBody(QuestaoResourceMock.GET_SUCCESS)));
    }

    @Então("deve retornar uma lista com questões")
    public void entaoDeveRetornarUmaListaComQuestoes() {
        QuestaoVO[] questoes = template.getForObject("http://localhost:" + PORT  + "/ws/questoes", QuestaoVO[].class);
        Assert.assertTrue(ArrayUtils.isNotEmpty(questoes));
    }

    @Quando("a consulta ao serviço retornar vazio")
    public void quandoAConsultaAoServicoRetornarVazio() {
        server.stubFor(get(urlPathEqualTo("/ws/questoes/1"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.SC_NOT_FOUND)));
    }

    @Então("deve retornar o status {int}")
    public void deveRetornarOStatus(int status) {
        boolean notFound = false;
        try {
            template.getForEntity("http://localhost:" + PORT  + "/ws/questoes/1", QuestaoVO.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == status) {
                notFound = true;
            }
        }
        Assert.assertTrue(notFound);
    }

    @Quando("o usuário enviar as questões")
    public void quandoOUsuarioEnviarAsQuestoes() {
        server.stubFor(post(urlPathEqualTo("/ws/questoes"))
                .willReturn(aResponse()
                        .withHeader("content-type", "application/json")
                        .withBody(QuestaoResourceMock.POST_SUCCESS)));
    }

    @Então("deve contabilizar os votos com sucesso")
    public void entaoDeveContabilizarOsVotosComSucesso() {
        ResponseVO response = template.postForObject("http://localhost:" + PORT  + "/ws/questoes", new VotosVO(), ResponseVO.class);
        Assert.assertTrue(response.isSucesso());
    }

}
