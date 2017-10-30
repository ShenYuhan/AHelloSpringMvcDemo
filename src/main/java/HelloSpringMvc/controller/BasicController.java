package HelloSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuhan.shen on 2017/10/26.
 */
@Controller
@RequestMapping(value = "")
public class BasicController {
    @RequestMapping(value="homepage")
    public String toHomepage(){
        return "/html/basic/homepage";
    }
}
