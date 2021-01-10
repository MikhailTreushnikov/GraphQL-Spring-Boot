package graphql.demo.grahpqlspringboot.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "users", schema = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    var id: Long? = null
    @Column(name="full_name")
    @JsonProperty
    var fullName: String? = null
    @Column(name="age")
    @JsonProperty
    var age: Int? = null
    @Column(name = "gender")
    @JsonProperty
    var gender: String? = null
    @Column(name = "salary")
    @JsonProperty
    var salary: Int? = null
    @Column(name = "city")
    @JsonProperty
    var city: String? = null
    @OneToMany(mappedBy = "person",cascade = [CascadeType.ALL],orphanRemoval = true)
    @JsonIgnore
    var listPhone: MutableList<Phone> = ArrayList()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (fullName != other.fullName) return false
        if (age != other.age) return false
        if (gender != other.gender) return false
        if (salary != other.salary) return false
        if (city != other.city) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (fullName?.hashCode() ?: 0)
        result = 31 * result + (age ?: 0)
        result = 31 * result + (gender?.hashCode() ?: 0)
        result = 31 * result + (salary ?: 0)
        result = 31 * result + (city?.hashCode() ?: 0)
        return result
    }

}