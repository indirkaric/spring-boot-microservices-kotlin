package com.indir.customer.service.mapper

import com.indir.customer.service.dto.CreateUserDto
import com.indir.customer.service.dto.UserDto
import com.indir.customer.service.entity.User

class UserMapper {
    companion object {
        fun toDto(user: User): UserDto {
            return UserDto(
                id = user.id,
                firstName = user.firstName,
                lastName = user.lastName,
                username = user.username,
                createdAt = user.createdAt
            )
        }

        fun toEntity(user: CreateUserDto): User {
            return User(
                firstName = user.firstName,
                lastName = user.lastName,
                username = user.username
            )
        }
    }
}