package hello.hellospring.domain

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Entity


@Entity
class Member(){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?= null
    var name: Int?= null



}
