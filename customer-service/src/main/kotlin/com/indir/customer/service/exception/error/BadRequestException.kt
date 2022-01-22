package com.indir.customer.service.exception.error

class BadRequestException(val error: RestApiError) : RuntimeException()