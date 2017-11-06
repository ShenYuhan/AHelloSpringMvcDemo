package HelloSpringMvc.controller;

import HelloSpringMvc.bo.UserDetailInfoBo;
import HelloSpringMvc.enums.CheckRegisterEnum;
import HelloSpringMvc.model.UserDetailInfoModel;
import HelloSpringMvc.service.CheckParam;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yuhan.shen on 2017/10/25.
 */
@Controller
@RequestMapping(value = "")
public class TimerController {

    private static Logger logger = Logger.getLogger(TimerController.class);

    //访问地址：http://localhost:8080/Test/Timer/returnSuccess
    @RequestMapping(value = "testTimeNow",method=RequestMethod.POST)    //实际访问的url地址
    @ResponseBody
    public ModelAndView returnSuccess(String password) {
        ModelAndView mav = new ModelAndView("/html/basic/tt");
        return mav;
//        TimeDisplay timeDisplay = new TimeDisplay();
//        return timeDisplay.toClock();
    }

//    @RequestMapping(value="login")
//    public ModelAndView login(String userName,String password){
//        CheckParam checkParam = new CheckParam();
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("/html/basic/loginSuccess");
//        mav.addObject("userName",userName);
//        mav.addObject("password",password);
//        mav.addObject("loginResult",checkParam.checkLoginParam(userName,password).getErrorMsg());
//        logger.info(userName+"登陆成功");
//        return mav;
//    }

    @RequestMapping(value="registerOld.html")
    public ModelAndView register(String userName,String password){
        CheckParam checkParam = new CheckParam();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/html/basic/registerSuccess");
        mav.addObject("userName",userName);
        mav.addObject("password",password);
        mav.addObject("registerResult",checkParam.checkRegisterParamOld(userName,password).getErrorMsg());
        return mav;
    }

    @RequestMapping(value="registerDetailOld")
    public ModelAndView registerDetail(){
        ModelAndView mav = new ModelAndView("/html/basic/registerDetail");
        return mav;
    }

//    @RequestMapping(value="submitRegisterDetail")
//    public ModelAndView submitRegisterDetail(UserDetailInfoBo userDetail){
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("/html/basic/homepage");
//        CheckParam checkParam = new CheckParam();
//        CheckRegisterEnum checkRegisterEnum = checkParam.checkRegisterDetailParamOld(new UserDetailInfoModel());
//        mav.addObject("result",checkRegisterEnum.getErrorMsg());
////
////        String str = "不是本人";
////        if (userDetail.getUserName().equals("yuhan.shen")){
////            str = "欢迎您！";
////        }
////        mav.addObject("result",str);
//        return mav;
//    }

//    @RequestMapping(value="sumitRegisterDetail")
//    public ModelAndView tttt(){
//        ModelAndView mav = new ModelAndView("/html/basic/homepage");
//        return mav;
//    }
}