package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @GetMapping(value = "/response-view-v1")
    @ResponseBody
    public ModelAndView responseViewV1() {
        ModelAndView mv = new ModelAndView("response/hello");
        mv.addObject("data", "hello! V1");
        return mv;
    }

    @GetMapping(value = "/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello! V2");
        return "response/hello";
    }

    @GetMapping(value = "response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello! V3");
    }
}
