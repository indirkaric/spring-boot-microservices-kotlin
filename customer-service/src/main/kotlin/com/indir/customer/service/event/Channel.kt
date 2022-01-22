package com.indir.customer.service.event

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


interface Channel {
    @Input("messaging-channel")
    fun messagingInputChannel(): SubscribableChannel?

    @Output("messaging-channel")
    fun messagingOutputChannel(): MessageChannel?
}