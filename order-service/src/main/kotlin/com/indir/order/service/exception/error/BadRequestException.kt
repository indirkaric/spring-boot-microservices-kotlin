package com.indir.order.service.exception.error

class BadRequestException(val error: RestApiError) : RuntimeException()