package hello.hellospring.controller

import org.springframework.web.bind.annotation.GetMapping

class HomeController {

    @GetMapping("/")
    fun home(): String {
        return "home"
    }

}
