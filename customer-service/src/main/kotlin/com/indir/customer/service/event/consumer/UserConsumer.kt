package com.indir.customer.service.event.consumer

import com.indir.customer.service.event.model.UserCreatedEvent
import com.indir.customer.service.helper.Logger
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Component


@Component
class UserConsumer {
    @StreamListener(target = "messaging-channel", condition = "headers['eventType']=='usercreatedevent'")
    fun listen(event: UserCreatedEvent?) {
        Logger.log.info("Listening UserCreatedEvent {}", event.toString())
    }
}