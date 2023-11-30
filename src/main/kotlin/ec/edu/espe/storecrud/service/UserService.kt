package ec.edu.espe.storecrud.service

import ec.edu.espe.storecrud.entity.User
import ec.edu.espe.storecrud.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserService(private val userRepository: UserRepository) {
    fun findById(userId: Long): Optional<User> {
        return userRepository.findById(userId);
    }

    fun findByUsername(username: String): User? {
        return userRepository.findByUsername(username);
    }
}