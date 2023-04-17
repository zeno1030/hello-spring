package hello.hellospring.controller

import hello.hellospring.domain.Member
import hello.hellospring.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MemberController {
    private val memberService: MemberService

   @Autowired
    constructor(memberService: MemberService) {
        this.memberService = memberService
    }

    @GetMapping("/members/new")
    fun createForm(): String {
        return "members/createMemberForm"
    }

    fun create(form: MemberForm): String {
        val member = Member()
        member.name = form.name

        memberService.join(member)

        return "redirect:/"

    }
}
