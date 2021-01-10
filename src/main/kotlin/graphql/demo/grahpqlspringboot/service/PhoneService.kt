package graphql.demo.grahpqlspringboot.service

import graphql.demo.grahpqlspringboot.entity.Phone
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Repository
interface PhoneRepository: JpaRepository<Phone,Long>{
    @Query(value = "SELECT * FROM phones WHERE person_id=:person_id", nativeQuery = true)
    fun findAllByUser(@Param("person_id") personId: Long): List<Phone>
}


@Service
@Transactional
class PhoneService(
    private val phoneRepository: PhoneRepository
    ){

    fun createPhone(phone: Phone): Phone {
        return phoneRepository.save(phone)
    }

    fun getPhoneById(id:Long): Phone? {
        return phoneRepository.findById(id).orElseGet(null)
    }

    fun getAllPhone():List<Phone>{
        return phoneRepository.findAll()
    }

    fun deletePhone(id: Long){
        phoneRepository.deleteById(id)
    }

    fun getListPhoneByUserId(id: Long): List<Phone>{
        return phoneRepository.findAllByUser(id)
    }
}