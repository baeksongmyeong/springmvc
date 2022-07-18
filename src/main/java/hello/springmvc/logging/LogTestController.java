package hello.springmvc.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/log-test")
    public String logTest() {
        String name = "Spring";
        log.trace("name : {}", name);
        log.debug("name : {}", name);
        log.info("name : {}", name);
        log.warn("name : {}", name);
        log.error("name : {}", name);
        return "ok";
    }
}
