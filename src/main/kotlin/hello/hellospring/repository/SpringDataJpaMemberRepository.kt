package hello.hellospring.repository

import hello.hellospring.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SpringDataJpaMemberRepository(private val memberRepository:MemberRepository) {
    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository)
    }

}
