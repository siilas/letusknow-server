package com.github.siilas.letusknow;

public class QuestaoResourceMock {

    public static final String GET_SUCCESS = "[\n" +
            "   {\n" +
            "      \"id\":1,\n" +
            "      \"descricao\":\"No geral, como é a sua saúde?\",\n" +
            "      \"respostas\":[\n" +
            "         {\n" +
            "            \"id\":1,\n" +
            "            \"descricao\":\"Boa\",\n" +
            "            \"votos\":0\n" +
            "         },\n" +
            "         {\n" +
            "            \"id\":2,\n" +
            "            \"descricao\":\"Ruim\",\n" +
            "            \"votos\":0\n" +
            "         }\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"id\":2,\n" +
            "      \"descricao\":\"Comparando com um ano atrás, como você diria que a sua saúde está hoje?\",\n" +
            "      \"respostas\":[\n" +
            "         {\n" +
            "            \"id\":3,\n" +
            "            \"descricao\":\"Melhor\",\n" +
            "            \"votos\":0\n" +
            "         },\n" +
            "         {\n" +
            "            \"id\":4,\n" +
            "            \"descricao\":\"Igual\",\n" +
            "            \"votos\":0\n" +
            "         },\n" +
            "         {\n" +
            "            \"id\":5,\n" +
            "            \"descricao\":\"Pior\",\n" +
            "            \"votos\":0\n" +
            "         }\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"id\":3,\n" +
            "      \"descricao\":\"Quanta dor no corpo você sentiu durante as últimas semanas?\",\n" +
            "      \"respostas\":[\n" +
            "         {\n" +
            "            \"id\":6,\n" +
            "            \"descricao\":\"Muita\",\n" +
            "            \"votos\":0\n" +
            "         },\n" +
            "         {\n" +
            "            \"id\":7,\n" +
            "            \"descricao\":\"Pouca\",\n" +
            "            \"votos\":0\n" +
            "         }\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"id\":4,\n" +
            "      \"descricao\":\"Há limitação de atividades devido ao seu estado de saúde atual?\",\n" +
            "      \"respostas\":[\n" +
            "         {\n" +
            "            \"id\":8,\n" +
            "            \"descricao\":\"Sim\",\n" +
            "            \"votos\":0\n" +
            "         },\n" +
            "         {\n" +
            "            \"id\":9,\n" +
            "            \"descricao\":\"Não\",\n" +
            "            \"votos\":0\n" +
            "         }\n" +
            "      ]\n" +
            "   },\n" +
            "   {\n" +
            "      \"id\":5,\n" +
            "      \"descricao\":\"Qual a interferência da dor no seu dia-a-dia?\",\n" +
            "      \"respostas\":[\n" +
            "         {\n" +
            "            \"id\":10,\n" +
            "            \"descricao\":\"Interfere muito\",\n" +
            "            \"votos\":0\n" +
            "         },\n" +
            "         {\n" +
            "            \"id\":11,\n" +
            "            \"descricao\":\"Interfere pouco\",\n" +
            "            \"votos\":0\n" +
            "         }\n" +
            "      ]\n" +
            "   }\n" +
            "]";

    public static final String POST_SUCCESS = "{\n" +
            "   \"sucesso\":true,\n" +
            "   \"mensagem\":\"Questões salvas com sucesso!\"\n" +
            "}";

}
