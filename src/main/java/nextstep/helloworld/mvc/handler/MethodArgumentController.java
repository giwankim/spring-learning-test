package nextstep.helloworld.mvc.handler;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/method-argument")
public class MethodArgumentController {

  @GetMapping("/users")
  public ResponseEntity<List<User>> requestParam(@RequestParam(value = "name") String userName) {
    List<User> users = Arrays.asList(
        new User(userName, "email"),
        new User(userName, "email")
    );
    return ResponseEntity.ok().body(users);
  }

  @PostMapping("/users/body")
  public ResponseEntity requestBody(@RequestBody User user) {
    User newUser = new User(1L, user.getName(), user.getEmail());
    return ResponseEntity.created(URI.create("/users/" + newUser.getId())).body(newUser);
  }
}
