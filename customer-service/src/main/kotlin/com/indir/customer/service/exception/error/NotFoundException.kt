package com.indir.customer.service.exception.error

class NotFoundException(val error: RestApiError) : RuntimeException()