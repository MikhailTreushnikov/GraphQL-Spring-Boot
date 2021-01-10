package graphql.demo.grahpqlspringboot.resolver

import graphql.demo.grahpqlspringboot.entity.Phone
import graphql.demo.grahpqlspringboot.entity.User
import graphql.demo.grahpqlspringboot.service.PhoneService
import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLMutation
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import org.springframework.stereotype.Component


@Component
@GraphQLApi
class PhoneResolver (
    private val phoneService: PhoneService
        ){

    @GraphQLMutation(name = "createPhone")
    fun createPhone(@GraphQLArgument(name = "phoneField") phone: Phone): Phone? {
        return phoneService.createPhone(phone)
    }

    @GraphQLQuery(name = "allPhones")
    fun getAllPhones(): List<Phone>? {
        return phoneService.getAllPhone()
    }


    @GraphQLMutation(name = "deletePhone")
    fun deletePone(@GraphQLArgument(name = "phoneId") id: Long): Boolean? {
        phoneService.deletePhone(id)
        return true
    }

    @GraphQLQuery(name = "Phone")
    fun getPhone(@GraphQLArgument(name = "phoneId") id: Long): Phone? {
        return phoneService.getPhoneById(id)
    }

}