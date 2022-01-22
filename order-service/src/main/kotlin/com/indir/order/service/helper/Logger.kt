package com.indir.order.service.helper

import org.slf4j.Logger

class Logger {
    companion object {
        val log: Logger = org.slf4j.LoggerFactory.getLogger(javaClass.name)
    }
}