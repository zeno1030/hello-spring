package hello.hellospring.service

import hello.hellospring.domain.Member
import hello.hellospring.repository.MemberRepository
import hello.hellospring.repository.MemoryMemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class MemberService @Autowired constructor(private val memberRepository: MemberRepository) {
//    private val memberRepository: MemberRepository = MemoryMemberRepository()


    /**
     * 회원가입
     */
    fun join(member: Member): Member {
        validateDuplicateMember(member) // 중복 회원 검증
        return memberRepository.save(member)

    }

    private fun validateDuplicateMember(member: Member) {
        memberRepository.findByName(member.name!!)?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
    }

    /**
     * 전체 회원 조회
     */
    fun findMembers(): List<Member> {
        return memberRepository.findAll()
    }

    fun findOne(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }
}




