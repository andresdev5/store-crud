package ec.edu.espe.storecrud.dto

import java.time.LocalDateTime

data class RoleDto(
    val id: Long? = null,
    val name: String,
    val description: String? = null,
)

fun RoleDto.toEntity() = ec.edu.espe.storecrud.entity.Role(
    id = id ?: 0,
    name = name,
    description = description ?: "",
)