package hello.hellospring.repository

import hello.hellospring.domain.Member

interface MemberRepository {
    fun save(member: Member): Member
    fun findById(id: Member): Member?
    fun findByName(name: String): Member?
    fun findAll():List<Member>

}

