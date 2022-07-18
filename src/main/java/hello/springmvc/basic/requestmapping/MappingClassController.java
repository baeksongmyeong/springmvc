package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class MappingClassController {

    @GetMapping
    public String users() {
      log.info("get users");
        return "ok";
    }

    @PostMapping
    public String addUser() {
        log.info("post user");
        return "ok";
    }

    @GetMapping(value = "/{userId}")
    public String getUser(@PathVariable String userId) {
        log.info("get user / userId = {}", userId);
        return "ok";
    }

    @PatchMapping(value = "/{userId}")
    public String updateUser(@PathVariable String userId) {
        log.info("patch user / userId = {}", userId);
        return "ok";
    }

    @DeleteMapping(value = "/{userId}")
    public String deleteUser(@PathVariable String userId) {
        log.info("delete user / userId = {}", userId);
        return "ok";
    }
}
