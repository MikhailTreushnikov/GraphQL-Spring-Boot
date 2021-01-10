package graphql.demo.grahpqlspringboot.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name="phones", schema = "users")
class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    var id: Long? = null
    @Column(name = "phone")
    @JsonProperty
    var phone: String? = null
    @ManyToOne
    @JsonIgnore
    var person: User?= null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Phone

        if (id != other.id) return false
        if (phone != other.phone) return false
        if (person != other.person) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (phone?.hashCode() ?: 0)
        result = 31 * result + (person?.hashCode() ?: 0)
        return result
    }


}