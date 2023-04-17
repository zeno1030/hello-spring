package hello.hellospring.repository

import hello.hellospring.domain.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MemoryMemberRepositoryTest {
    private val repository = MemoryMemberRepository()


    @Test
    fun save() {
        // given
        val member = Member()
        member.name = "spring"

        // when
        repository.save(member)

        // then
        val result = repository.findById(member.id).get()
        val equalTo = assertThat(result).isEqualTo(member)
    }
}