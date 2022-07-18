package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping(value = "/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        Integer age = Integer.valueOf(request.getParameter("age"));
        log.info("username={}, age={}", username, age);
        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping(value = "/request-param-v2")
    public String requestParamV2(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "age") Integer age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/request-param-v3")
    public String requestParamV3(
        @RequestParam String username,
        @RequestParam Integer age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/request-param-v4")
    public String requestParamV4(
            String username,
            Integer age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/request-param-required")
    public String requestParamRequired(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "age", required = true) Integer age,
            @RequestParam(value = "ismale", required = false) Boolean isMale
    ) {
        log.info("username={}, age={}, isMale={}", username, age, isMale);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/request-param-default")
    public String requestParamDefault(
        @RequestParam(required = true, defaultValue = "guest") String username,
        @RequestParam(required = false, defaultValue = "-1") Integer age
    ) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/request-param-map")
    public String requestParamMap(
        @RequestParam Map<String, Object> paramMap
    ) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/model-attribute-v1")
    public String modelAttributeV1(
        @ModelAttribute HelloData helloData
    ) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/model-attribute-v2")
    public String modelAttributeV2(
        HelloData helloData
    ) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

}
