package HelloSpringMvc.controller;

import HelloSpringMvc.bo.UserDetailInfoBo;
import HelloSpringMvc.bo.UserInfoBo;
import HelloSpringMvc.enums.CheckRegisterEnum;
import HelloSpringMvc.model.UserDetailInfoModel;
import HelloSpringMvc.service.CheckParam;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yuhan.shen on 2017/11/6.
 */

@Controller
@RequestMapping(value = "")
public class UserAccountController {

    private static Logger logger = Logger.getLogger(TimerController.class);

    @RequestMapping(value="login")
    public ModelAndView login(UserInfoBo userInfoBo){
        CheckParam checkParam = new CheckParam();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/html/basic/loginSuccess");
        mav.addObject("userName",userInfoBo.getUserName());
        mav.addObject("password",userInfoBo.getPassword());
        mav.addObject("loginResult",checkParam.checkLoginParam(userInfoBo.getUserName(),userInfoBo.getPassword()).getErrorMsg());
        logger.info(userInfoBo.getUserName()+"登陆成功");
        return mav;
    }

    @RequestMapping(value="registerDetail")
    public ModelAndView registerDetail(){
        ModelAndView mav = new ModelAndView("/html/basic/registerDetail");
        return mav;
    }

    @RequestMapping(value="submitRegisterDetail")
    public ModelAndView submitRegisterDetail(UserDetailInfoBo userDetail){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/html/basic/homepage");
        CheckParam checkParam = new CheckParam();
        CheckRegisterEnum checkRegisterEnum = checkParam.registerUserDetailInfo(userDetail);
        mav.addObject("result",checkRegisterEnum.getErrorMsg());
        return mav;
    }
}
