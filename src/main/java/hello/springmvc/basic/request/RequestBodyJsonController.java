package hello.springmvc.basic.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/request-body-json-v1-1")
    public void requestBodyJsonV1_1(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        String requestMessageBody = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        log.info("requestMessageBody={}", requestMessageBody);
        HelloData helloData = objectMapper.readValue(requestMessageBody, HelloData.class);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        response.getWriter().write("ok");
    }

    @PostMapping(value = "/request-body-json-v1-2")
    public void requestBodyJsonV1_2(
            InputStream inputStream,
            Writer writer
    ) throws IOException {
        String requestMessageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("requestMessageBody={}", requestMessageBody);
        HelloData helloData = objectMapper.readValue(requestMessageBody, HelloData.class);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        writer.write("ok");
    }

    @ResponseBody
    @PostMapping(value = "/request-body-json-v2")
    public String requestBodyJsonV2(
            @RequestBody String requestMessageBody
    ) throws JsonProcessingException {
        log.info("requestMessageBody={}", requestMessageBody);
        HelloData helloData = objectMapper.readValue(requestMessageBody, HelloData.class);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping(value = "/request-body-json-v3")
    public String requestBodyJsonV3(
            @RequestBody HelloData helloData
    ) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping(value = "/request-body-json-v4")
    public String requestBodyJsonV4(
            HttpEntity<HelloData> httpEntity
    ) {
        HelloData helloData = httpEntity.getBody();
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping(value = "/request-body-json-v5")
    public HelloData requestBodyJsonV5(
            @RequestBody HelloData helloData
    ) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return helloData;
    }




}
