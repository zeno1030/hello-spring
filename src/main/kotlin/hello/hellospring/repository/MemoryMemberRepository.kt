package hello.hellospring.repository

import hello.hellospring.domain.Member
import org.springframework.stereotype.Repository

@Repository
class MemoryMemberRepository : MemberRepository {

    private val store = HashMap<Long, Member>()
    override fun save(member: Member): Member {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Member? {
        TODO("Not yet implemented")
    }

    override fun findByName(name: String): Member? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Member> {
        TODO("Not yet implemented")
    }

    fun clearStore() {
        store.clear()
    }
}
