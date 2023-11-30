package ec.edu.espe.storecrud.config

import ec.edu.espe.storecrud.entity.User
import org.springframework.security.core.Authentication

fun Authentication.toUser(): User {
    return principal as User
}