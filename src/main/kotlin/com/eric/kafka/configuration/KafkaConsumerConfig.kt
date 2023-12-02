package com.eric.kafka.configuration

import com.eric.kafka.dto.MessageDTO
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer


@EnableKafka
@Configuration
class KafkaConsumerConfig {
    @Value("\${spring.kafka.bootstrap-servers}")
    private val servers: String? = null

    @Bean
    fun consumerFactory(): ConsumerFactory<String, MessageDTO> {
        val config: MutableMap<String, Any> = HashMap()
        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = servers!!
        config[ConsumerConfig.GROUP_ID_CONFIG] = "group-1"

        return DefaultKafkaConsumerFactory(
            config, StringDeserializer(), JsonDeserializer(
                MessageDTO::class.java
            )
        )
    }

    @Bean
    fun kafkaListener(): ConcurrentKafkaListenerContainerFactory<String, MessageDTO> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, MessageDTO> =
            ConcurrentKafkaListenerContainerFactory<String, MessageDTO>()
        factory.consumerFactory = consumerFactory()
        return factory
    }
}