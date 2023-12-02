package com.eric.kafka.controller

import com.eric.kafka.dto.MessageDTO
import com.eric.kafka.service.KafakaProducerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class KafkaController(
    private val kafakaProducerService: KafakaProducerService
) {

    @PostMapping("/kafka")
    fun sendMessage(@RequestBody message: MessageDTO): String {
        kafakaProducerService.sendMessage(message)

        return "done"
    }
}