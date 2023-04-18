package hello.hellospring.service

import hello.hellospring.repository.MemberRepository
import hello.hellospring.repository.MemoryMemberRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.reflect.Member

@Configuration
class SpringConfig {
    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository())
    }

    @Bean
    fun memberRepository(): MemberRepository{
        return MemoryMemberRepository()
    }


}
