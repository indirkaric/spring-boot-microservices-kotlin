package com.indir.order.service.event.model

import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import java.io.Serializable

open class Event : Serializable {
    companion object {
        fun <T: Any> getEventMessage(model: T): Message<T> {
            return MessageBuilder
                .withPayload(model)
                .setHeader("eventType", model::class.simpleName?.toLowerCase())
                .build()
        }
    }

}