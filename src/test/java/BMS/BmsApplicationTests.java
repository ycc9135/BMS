package BMS;



import java.util.List;

import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import BMS.system.entity.TUser;
import BMS.system.service.TBookService;
import BMS.system.service.TUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BmsApplicationTests {
	@Autowired
	TUserService tUserService;
	@Autowired
	TBookService tBookService;
	@Test
	public void contextLoads() {
		EntityWrapper<TUser> wrapper=new EntityWrapper<TUser>();
		/*wrapper.eq("name","Mike");
	TUser user =tUserService.selectById(9);
		TUser user=tUserService.selectOne(wrapper);*/
		List<TUser> users=tUserService.selectList(wrapper);
	System.out.println(users);
	}
	@Test
	public void findAll() {
		System.out.println(tBookService.findByPage(1, 3));
	}
	@Test
	public void testLogin() {
		Boolean re = false;
		int i=0;

		String name1 = "Mike";
		String password1 = "d580857ee93a0028a1cdd8482c7876ca";
		EntityWrapper<TUser> wrapper=new EntityWrapper<TUser>();
		wrapper.eq("name", name1)
		.eq("password", password1);
		
		TUser users=tUserService.selectOne(wrapper);
		/*TUser user = tUserService.selectById(14);*/

		if (users!=null) {
			re = true;
			System.out.println(users);
		}
	
	
	}

	@Test
	public void add() {
		TUser user=new TUser();
		user.setName("明天");
		String salt=null;
		salt = new SecureRandomNumberGenerator().nextBytes().toString(); 
		user.setSalt(salt);
		user.setPassword("142538");
		System.out.println(salt);
		String encodedPassword=null;
		System.out.println("MD5加密开始");
		encodedPassword= new SimpleHash("md5",user.getPassword(),salt,1).toString();
		System.out.println(encodedPassword);
		user.setPassword(encodedPassword);
		
		boolean result=tUserService.insert(user);
		System.out.println("result:"+result);
	}
/*	@Test
	public Boolean login() {
		Boolean re=false;
		TUser user=new TUser();
		user.setUser("明天");
		user.setPassword("142538");
		Subject currentu=SecurityUtils.getSubject();
		//将用户名和密码封装到UsernamePasswordToken
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUser(),user.getPassword());
		try {
			currentu.login(token);
			//判断当前用户是否登录
			if (currentu.isAuthenticated()) {
				re=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("登录失败");
		}
		return re;
	}
*/

}
