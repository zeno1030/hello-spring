package hello.hellospring

import hello.hellospring.repository.MemberRepository
import hello.hellospring.repository.JpaMemberRepository
import hello.hellospring.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.sql.DataSource

@Configuration
class SpringConfig(
    private val dataSource: DataSource,
    private val em: EntityManager
) {

    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository())
    }

    @Bean
    fun memberRepository(): MemberRepository {
//      return MemoryMemberRepository()
//      return JdbcMemberRepository(dataSource)
//      return JdbcTemplateMemberRepository(dataSource)
        return JpaMemberRepository(em)
    }
}
