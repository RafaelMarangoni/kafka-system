
# Projeto Kafka Consumer/Producer com MongoDB

Este projeto demonstra a implementação de um Kafka Consumer e Producer usando Spring Boot, integrado com um banco de dados MongoDB. Ele inclui exemplos de configuração e código para consumir mensagens de um tópico Kafka, persistir os dados no MongoDB e produzir mensagens em outro tópico Kafka.

## Tecnologias Utilizadas

**Linguagem**: Java 17 

**Frameworks**: Spring Boot, Maven, JWT, REST, Swagger</br>

**Dependências de Testes**

- spring-boot-starter-test-2.7.4
- junit-jupiter-api-5.8.2
Spring Kafka 3
MongoDB
Apache Kafka 3

## Pré Requisitos

- Rodar o docker-compose que está no projeto com comando "docker compose up ".
- Estar na brach Master

## End Points 

- Temos dois endpoints :
  - processor-order e orders:
    - processor-order é no nosso producer, onde irá validar e persistir as informações no momgoDB 
    - orders é o nosso GET onde de podemos informar até 3 parametros ou não na busca, sendo que o Seller é obrigátrio para listar as vendas de apenas um vendedor
    - Parameters endpoint /orders : 
      - seller(obrigátorio) 
      - status(opcional)
      - statusPayment(opcional)
      - itemName(opcional)
    - EndPoint /processor-order , segue json de exemplo: 
    - {
      "orderId": "testeOrder10",
      "status": "NEW", // possible values: NEW, APPROVED, FINISHED, CANCELLED
      "items": [
      {
      "itemId": "ABC0123456789",
      "sku": "SKU_DO_SELLER_123",
      "name": "Teste COM NENUM",
      "description": "O melhor desempenador de pipa que você verá na sua vida. Tração 4x4 e efeitos sonoros ideais para o seu churrasco",
      "price": 1499.99,
      "url": "https://www.minha-lojinha.com.br/products/ABC0123456789"
      }
      ],
      "seller": "ABC1F2DGHC",
      "buyer": {
      "id": "BCD2F2CCBA",
      "name": "Pietro Alcantara",
      "email": "p2alcantara_teste@gmail.com"
      },
      "shippingAddress": {
      "postalCode": "04540-010",
      "streetName": "Rua do bobos",
      "number": "456 A",
      "additionalInfo": "Apto 37"
      },
      "billingAddress": {
      "postalCode": "03333-310",
      "streetName": "Rua do sellers",
      "number": "333",
      "additionalInfo": "Próximo ao metrô cacimbas"
      },
      "payment": {
      "method": "DEBIT", // possible values: CREDIT, DEBIT, GIFT_CARD, OTHER
      "amount": 1499.99,
      "status": "PENDING" // possible values: PENDING, APPROVED, REFUSED
      }
      }
