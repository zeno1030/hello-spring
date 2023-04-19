package hello.hellospring.service

import hello.hellospring.domain.Member
import hello.hellospring.repository.MemoryMemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalStateException

class MemberServiceTest {

    lateinit var memberService: MemberService
    lateinit var memberRepository: MemoryMemberRepository

    @BeforeEach
    fun beforeEach() {
        val memberRepository = MemoryMemberRepository()
        val memberService = MemberService(memberRepository)
    }

    @AfterEach
    fun afterEach() {
        memberRepository.clearStore()
    }
    @Test
    fun 회원가입() {
        // given
        val member = Member()
        member.name = "hello"

        // when
        val saveId: Member = memberService.join(member)

        // then
        val findMember: Member? = memberRepository.findById(member.id!!)
        assertThat(member.name).isEqualTo(findMember?.name)
    }

    @Test
    fun 중복_회원_예외() {

        // given
        val member1 = Member()
        member1.name = "spring"

        val member2 = Member()
        member2.name = "spring"

        // when
        memberService.join(member1)
        val exception = assertThrows<IllegalStateException> {
            memberService.join(member2)
        }

        assertThat(exception.message).isEqualTo("이미 존재하는 회원입니다.")
    }

    @Test
    fun findMembers() {
    }

    @Test
    fun findOne() {
    }
}
