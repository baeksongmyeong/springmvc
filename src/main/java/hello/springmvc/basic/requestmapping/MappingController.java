package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping(value = "/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mapping-get-v1");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    @GetMapping(value = "/mapping/{userId}")
    public String mappingPath(@PathVariable(value = "userId") String userId) {
        log.info("mappingPath userId = {}", userId);
        return "ok";
    }

    @GetMapping(value = "/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId = {}, orderId = {}", userId, orderId);
        return "ok";
    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(@RequestParam String mode) {
        log.info("mappingPath mode = {}", mode);
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader(HttpServletRequest request) {
        log.info("mappingHeader mode = {}", request.getHeader("mode"));
        return "ok";
    }

    @GetMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes(HttpServletRequest request) {
        log.info("mappingConsumes ContentType = {}", request.getContentType());
        return "ok";
    }

    @GetMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces(HttpServletRequest request) {
        log.info("mappingConsumes Accept = {}", request.getHeader("Accept"));
        return "ok";
    }

}
