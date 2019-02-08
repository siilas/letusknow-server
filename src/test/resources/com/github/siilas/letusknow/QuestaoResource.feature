# language: pt
Funcionalidade: Serviço que busca e salva votos em questões

  Cenario: Busca com sucesso
    Quando a consulta ao serviço retornar sucesso
    Então deve retornar uma lista com questões

  Cenario: Busca vazia
    Quando a consulta ao serviço retornar vazio
    Então deve retornar o status 404

  Cenario: Contabiliza as questões com sucesso
    Quando o usuário enviar as questões
    Então deve contabilizar os votos com sucesso
