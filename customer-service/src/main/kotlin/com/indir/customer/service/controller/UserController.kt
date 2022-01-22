package com.indir.customer.service.controller

import com.indir.customer.service.dto.CreateUserDto
import com.indir.customer.service.dto.UserDto
import com.indir.customer.service.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/v1/users/")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun getUsers(): ResponseEntity<List<UserDto>> = ResponseEntity(userService.getUsers(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<UserDto> = ResponseEntity(userService.getUser(id), HttpStatus.OK)

    @PostMapping
    fun saveUser(@RequestBody @Valid createUserDto: CreateUserDto): ResponseEntity<Void> {
        userService.saveUser(createUserDto)
        return ResponseEntity(HttpStatus.CREATED)
    }

}