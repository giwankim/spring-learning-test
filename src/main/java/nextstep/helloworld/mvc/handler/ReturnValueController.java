package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {

  @GetMapping(value = "message")
  @ResponseBody
  public String string() {
    return "message";
  }

  @GetMapping(value = "users")
  @ResponseBody
  public User responseBodyForUser() {
    return new User("name", "email");
  }

  @GetMapping(value = "users/{id}")
  public ResponseEntity<User> responseEntity(@PathVariable Long id) {
    return ResponseEntity.ok(new User("name", "email"));
  }

  @GetMapping(value = "members")
  public ResponseEntity<Void> responseEntityFor400() {
    return ResponseEntity.badRequest().build();
  }

  @GetMapping(value = "thymeleaf")
  public String thymeleaf(Model model) {
    model.addAttribute("name", "Brown");
    return "sample";
  }
}