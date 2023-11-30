package ec.edu.espe.storecrud.dto

import java.time.LocalDate
import java.time.LocalDateTime

data class AuthResponseDto(
    val token: String
)

data class AuthCredentialsDto(
    val username: String,
    val password: String
)
