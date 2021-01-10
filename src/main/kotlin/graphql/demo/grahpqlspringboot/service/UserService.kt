package graphql.demo.grahpqlspringboot.service

import graphql.demo.grahpqlspringboot.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Repository
interface UserRepository: JpaRepository<User,Long>{
}

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository
) {
    fun createUser(user: User): User? {
        return userRepository.save(user)
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }

    fun updateUser(user: User): User? {
        return userRepository.save(user)
    }

    fun getUser(id: Long): User? {
        return userRepository.findById(id).get()
    }

    fun getAllUsers(): List<User>? {
        return userRepository.findAll()
    }
}