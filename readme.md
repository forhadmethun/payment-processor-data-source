## Payment processor data source application

### Tech stack
- Java dropwizard
- Kafka

### Running the project 
##### Run project
``` 
mvn clean package
java -jar target/PaymentProcessorDataSource-1.0-SNAPSHOT.jar server config.yml
```
##### Create / View kafka topic 
``` 
bin/kafka-console-consumer.sh --topic card-info --from-beginning --bootstrap-server localhost:9092
```

### Sample Request
```
curl --location --request POST 'http://localhost:8080/api/auth' \
--header 'Content-Type: application/json' \
--data-raw '{
    "cardNumber": "1231234412",
    "expirationDate": "02/20",
    "cardCVC": "332"
}'
```

### Sample Response 
``` 
{
    "success": true,
    "transactionId": "3067af90383b42d2b05455f9050b6a3b"
}
```
