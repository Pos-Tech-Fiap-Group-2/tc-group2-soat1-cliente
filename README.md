# Documentação - Tech Challenge - Grupo 2 SOAT1 - PosTech - Arquitetura de Software - FIAP
Repositório para o microsserviço de pagamentos do desafio do Tech Challenge da Pós-gradução em Software Architecture pela FIAP.

## Introdução
Uma lanchonete de bairro que está expandido sua operação devido seu grande sucesso. Porém, com a expansão e sem um sistema de controle de pedidos, o atendimento aos clientes pode ser caótico e confuso.
Para solucionar o problema, a lanchonete irá investir em um sistema de autoatendimento de fast food, que é composto por uma série de dispositivos e interfaces que permitem aos clientes selecionar e fazer pedidos sem precisar interagir com um atendente.

## Membros do Grupo 2
- [Danilo Monteiro](https://github.com/dmonteirosouza)
- [Marcel Cozono](https://github.com/macozono)
- [Viviane Scarlatti](https://github.com/viviane-scarlatti)
- [Vinicius Furin](https://github.com/VFurin)
- [Vitor Walcker](https://github.com/VitorWalcker)

# Compilação e geração de artefato
Antes de iniciar, certifique-se de que sua máquina atenda aos seguintes requisitos:<br/><br/>

**JDK 11 instalado:**<br/>
Certifique-se de ter o JDK 21 instalado em sua máquina.<br/><br/>

**Maven >= 3 instalado:**<br/>
Verifique se você tem o Maven instalado em sua máquina. Para verificar a versão do Maven instalada, execute o seguinte comando no terminal: **mvn -version**. Se o Maven não estiver instalado ou estiver em uma versão inferior à 3, faça o download e siga as instruções de instalação do site oficial do Maven ou de outra fonte confiável.<br/><br/>

**Clonando o projeto:**<br/>
Clone o repositório do projeto em seu ambiente local.<br/><br/>

**Compilando o projeto:**<br/>
Navegue até o diretório raiz do projeto no terminal e execute o seguinte comando para compilar o projeto usando o Maven:<br/><br/>

```sh
mvn clean install
```

Isso irá baixar as dependências do projeto, compilar o código-fonte e criar o artefato no diretório target com o nome **tc-group2-soat1-cliente.jar**.<br/>
Esse artefato será copiado para a imagem do container em momento de build durante a execução do docker-compose.

**Executando o projeto:**<br/>
Após a conclusão da etapa anterior, você pode executar o projeto seguindo as instruções específicas do projeto.

# Build da imagem do projeto
Caso seja necessária a geração de uma nova imagem, executar o comando no diretório raíz do projeto:
```sh
docker build --build-arg "JAR_FILE=tech-challenge-group2-soat1-cliente.jar" -t <usuario>/<imagem_nome>:<tag> .
```

## Informações adicionais
Essa API trata-se de uma implementação de consumer, via spring boot, para integração com o RabbitMQ. Seu objetivo é realizar o consumo de mensagens relacionadas a fila de notificação de cliente para recepção dos eventos associados a status de pagamento e do pedido.

### Variáveis de ambiente
Seguem as variáveis de ambiente que podem ser configuradas e seus valores default:

- RABBIT_MQ_HOST: endereço de host do broker. Valor default **localhost**
- RABBIT_MQ_PORT: porta de comunicação do broker. Valor default **5672**
- RABBIT_MQ_USER: usuário de acesso ao console do broker. Valor default **admin**
- RABBIT_MQ_PASS: senha de acesso ao console do broker. Valor default **admin**

**Obs:** Foi utilizado o framework Apache Freemarker para geração de templates customizados permitindo o uso de uma DSL específica do framework para construção de templates complexos.