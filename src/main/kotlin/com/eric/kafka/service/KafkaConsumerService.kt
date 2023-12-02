package com.eric.kafka.service

import com.eric.kafka.dto.MessageDTO
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class KafkaConsumerService {
    @KafkaListener(topics = ["topic-1"], groupId = "group-1", containerFactory = "kafkaListener")
    @Throws(IOException::class)
    fun consume(message: MessageDTO) {
        println("consume message = ${message.from}")
        println("consume context = ${message.message}")
    }
}