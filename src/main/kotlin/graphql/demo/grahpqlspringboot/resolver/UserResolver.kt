package graphql.demo.grahpqlspringboot.resolver

import graphql.demo.grahpqlspringboot.entity.Phone
import graphql.demo.grahpqlspringboot.entity.User
import graphql.demo.grahpqlspringboot.service.PhoneService
import graphql.demo.grahpqlspringboot.service.UserService
import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLContext
import io.leangen.graphql.annotations.GraphQLMutation
import io.leangen.graphql.annotations.GraphQLQuery
import org.springframework.stereotype.Component


import io.leangen.graphql.spqr.spring.annotations.GraphQLApi


@Component
@GraphQLApi
class UserResolver(
    private val userService: UserService,
    private val phoneService: PhoneService
    ) {

    @GraphQLMutation(name = "createUser")
    fun createUser(@GraphQLArgument(name = "details") user: User): User? {
        return userService.createUser(user)
    }

    @GraphQLQuery(name = "getAllUser")
    fun getAllUser(): List<User>? {
        return userService.getAllUsers()
    }

    @GraphQLQuery(name = "phones")
    fun getUsersPones(@GraphQLContext user: User):List<Phone>{
        return phoneService.getListPhoneByUserId(user.id!!)
    }

    @GraphQLMutation(name = "updateUser")
    fun updateUser(@GraphQLArgument(name = "details") user: User): User? {
        return userService.updateUser(user)
    }

    @GraphQLMutation(name = "deleteUser")
    fun deleteUser(@GraphQLArgument(name = "userId") id: Long): Boolean? {
        userService.deleteUser(id)
        return true
    }

    @GraphQLQuery(name = "getUser")
    fun getUser(@GraphQLArgument(name = "userId") id: Long): User? {
        return userService.getUser(id)
    }
}