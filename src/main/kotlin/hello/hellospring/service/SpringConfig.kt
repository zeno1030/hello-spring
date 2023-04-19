package hello.hellospring.service

import hello.hellospring.repository.JdbcMemberRepository
import hello.hellospring.repository.MemberRepository
import hello.hellospring.repository.MemoryMemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class SpringConfig {

    private var dataSource:DataSource

    @Autowired
    constructor(dataSource: DataSource) {
        this.dataSource = dataSource
    }


    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository())
    }

    @Bean
    fun memberRepository(): MemberRepository {
        return JdbcMemberRepository(dataSource)
    }
}
