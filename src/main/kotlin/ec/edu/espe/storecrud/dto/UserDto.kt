package ec.edu.espe.storecrud.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import ec.edu.espe.storecrud.entity.User
import java.time.LocalDateTime

data class UserDto(
    val id: Long? = null,
    val username: String? = null,
    @JsonIgnore val password: String? = null,
    val email: String? = null,
    val role: RoleDto,
    val createdAt: LocalDateTime? = null,
)

fun UserDto.toEntity() = User(
    id = id ?: 0,
    username = username ?: "",
    password = password ?: "",
    email = email ?: "",
    role = role.toEntity(),
    createdAt = createdAt ?: LocalDateTime.now(),
)