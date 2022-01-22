package com.indir.order.service.exception.error

class NotFoundException(val error: RestApiError) : RuntimeException()