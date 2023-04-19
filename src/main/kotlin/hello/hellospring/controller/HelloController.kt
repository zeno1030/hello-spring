package hello.hellospring.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController // Json으로 받을 때는 @RestController
@Controller // view로 보여 질때는 @controller 두개를 같이 쓸 수는 없다.
class HelloController {

    @GetMapping("/hello")
    fun hello(model: Model): String {
        model.addAttribute("data", "hello!!")
        return "hello"
    }

    @GetMapping("/hello-mcv")
    fun helloMvc(@RequestParam("name") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "hello-template"
    }

    @GetMapping("/hello-string")
    @ResponseBody
    fun helloString(@RequestParam("name") name: String): String {
        return "hello+$name"
    }

    @GetMapping("/hello-api")
    @ResponseBody
    fun helloApi(@RequestParam("name") name: String): Hello {
        val hello = Hello()
        Hello.setName(name)
        return hello
    }

    class Hello {
        companion object {
            private var name: String? = null

            fun getName(): String? {
                return name
            }

            fun setName(name: String?) {
                this.name = name
            }
        }
    }
}
