package hello.hellospring.repository

import hello.hellospring.domain.Member
import java.util.Optional

interface MemberRepository {
    fun save(member: Member): Member
    fun findById(id: Long): Member?
    fun findByName(name: String): Member?
    fun findAll():List<Member>
}

