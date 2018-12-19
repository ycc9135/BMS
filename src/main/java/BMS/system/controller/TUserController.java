package BMS.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YangChao
 * @since 2018-11-30
 */
@Controller
@RequestMapping("/tUser")
public class TUserController {
	/*@RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("name");
        return "redirect:/login/confirm";
    }*/

}

