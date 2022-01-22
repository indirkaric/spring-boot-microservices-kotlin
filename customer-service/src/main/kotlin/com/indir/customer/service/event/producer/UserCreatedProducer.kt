package com.indir.customer.service.event.producer

import com.indir.customer.service.event.Channel
import com.indir.customer.service.event.model.Event
import com.indir.customer.service.event.model.UserCreatedEvent
import org.springframework.stereotype.Component

@Component
class UserCreatedProducer (private val channel: Channel) {
    fun publish(event: UserCreatedEvent?) {
        println("UserCreatedEvent has been created")
        channel.messagingOutputChannel()?.send(Event.getEventMessage(event as Event));
    }
}