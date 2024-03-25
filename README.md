kafka-consumer-producer-mongodb/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── kafka/
│   │   │               ├── consumer/
│   │   │               │   ├── ConsumerConfiguration.java
│   │   │               │   └── KafkaMessageConsumer.java
│   │   │               ├── producer/
│   │   │               │   ├── ProducerConfiguration.java
│   │   │               │   └── KafkaMessageProducer.java
│   │   │               ├── model/
│   │   │               │   └── OrderMessage.java
│   │   │               └── service/
│   │   │                   └── OrderService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── logback.xml
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── kafka/
│                       └── consumer/
│                           └── KafkaMessageConsumerTest.java
│
├── pom.xml
└── README.md
