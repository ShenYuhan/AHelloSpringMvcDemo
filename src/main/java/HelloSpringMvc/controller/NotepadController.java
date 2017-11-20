package HelloSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value="")
public class NotepadController {

    @RequestMapping(value="noteSubmit")
    public ModelAndView noteSubmit(Map<String,String> noteInfo){
        System.out.println(noteInfo.get("author"));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("html/basic/homepage");
        return mav;
    }

}
