package hello.hellospring.service

import hello.hellospring.repository.JdbcMemberRepository
import hello.hellospring.repository.MemoryMemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
   @Autowired
    private lateinit var memberService: MemberService

    @Autowired
    private lateinit var memberRepository: MemberRepository