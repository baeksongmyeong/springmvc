package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @RequestMapping(value = "/request-body-string-v1", method = RequestMethod.POST)
    public void requestBodyStringV1(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        String messageBody = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        log.info("messageBody={}", messageBody);
        response.getWriter().write("ok");
    }

    @RequestMapping(value = "/request-body-string-v2", method = RequestMethod.POST)
    public void requestBodyStringV2(
            InputStream inputStream,
            OutputStream outputStream,
            Reader reader,
            Writer responseWriter
    ) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody={}", messageBody);
        responseWriter.write("ok");
    }

    @RequestMapping(value = "/request-body-string-v3", method = RequestMethod.POST)
    public HttpEntity<String> requestBodyStringV3(
            HttpEntity<String> httpEntity
    ) {
        String messageBody = httpEntity.getBody();
        log.info("messageBody={}", messageBody);
        return new HttpEntity<>("ok");
    }

    @ResponseBody
    @RequestMapping(value = "/request-body-string-v4", method = RequestMethod.POST)
    public String requestBodyStringV4(
            @RequestBody String messageBody
    ) {
        log.info("messageBody={}", messageBody);
        return "ok";
    }

}
