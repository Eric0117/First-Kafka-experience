package com.eric.kafka.service

import com.eric.kafka.dto.MessageDTO
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafakaProducerService(
    private val kafkaTemplate: KafkaTemplate<String, MessageDTO>
) {

    companion object {
        const val TOPIC = "topic-1"
    }

    fun sendMessage(message: MessageDTO) {
        println("produce message = ${message.message}")
        kafkaTemplate.send(TOPIC, message)
    }
}