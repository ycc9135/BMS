package BMS.system.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  登录
 * </p>
 *
 * @author YangChao
 * @since 2018-11-19
 */



import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import BMS.system.entity.TUser;
import BMS.system.service.TUserService;
import net.sf.ehcache.search.expression.And;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	TUserService tUserService;

	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public Boolean confirm(@RequestParam("nAp") String nAp) {
		Boolean re = false;
		String str[] = nAp.split("-");
		String name1 = str[0];
		String password1 = str[1];
		EntityWrapper<TUser> wrapper=new EntityWrapper<TUser>();
		wrapper.eq("name", name1)
		.eq("password", password1);
		TUser users=tUserService.selectOne(wrapper);
		if (users!=null) {
			re = true;
		}
		return re;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public Boolean Register(@RequestParam("nAp") String nAp) {
		Boolean re = false;
		TUser user = new TUser();
		String str[] = nAp.split("-");
		String name = str[0];
		String password = str[1];
		user.setName(name);
		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
		user.setSalt(salt);
		user.setPassword(password);
		String encodedPassword = new SimpleHash("md5", user.getPassword(), salt, 2).toString();

		user.setPassword(encodedPassword);
		try {
			re = tUserService.insert(user);
			re = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("插入失败！！");
		}

		return re;
	}
	
}
