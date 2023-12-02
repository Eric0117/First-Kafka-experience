# First-Kafka-experience
간단한 멀티 클러스터 카프카 환경을 도커로 구축하고, Spring환경에서 Producer, Consumer를 구성하여 
Producer가 메시지를 브로커의 토픽에 전송, Consumer가 구독한 토픽에 접근하여 메시지를 Pull하는 환경을 구축한다.


## Kafka structure
3 Broker, 1 Zookeeper, 1 kafka-ui

Multi cluster

## Glossary
- Brokers : 카프카 애플리케이션이 설치된 서버
- Producers : 카프카에서 메세지를 생성하고, 해당 메세지를 카프카 클러스터에 전송하는 클라이언트
- Consumers : 카프카에서 메세지를 읽는 클라이언트
- Topic : 브로커에서 데이터를 관리할 때 기준이 되는 개념
- Partition : 토픽을 구성하는 데이터 저장소
  - 파티션 내의 메시지는 offset이라는 단위로 고유 id가 증가

## Docker compose up
```bash
docker-compose -f kafka-compose.yml up
```

```bash
docker exec -it kafka /bin/bash
```


## Kafka Rest test
```
curl --location --request POST 'http://localhost:8080/kafka' \
--header 'Content-Type: application/json' \
--data-raw '{
    "from": "some server",
    "message": "some message"
}'
```