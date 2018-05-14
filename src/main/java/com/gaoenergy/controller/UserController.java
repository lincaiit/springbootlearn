/**
 * <p>Title: UserController.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2018</p>  
 * <p>Company: www.gaoenergy.com</p>  
 * @author lin.cai  
 * @date 2018年5月14日  
 * @version 1.0  
 */
package com.gaoenergy.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaoenergy.pojo.User;

/**
 * <p>
 * Title: UserController
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author lin.cai
 * @date 2018年5月14日
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/getUser")
	@ResponseBody
	public Object getUser() {
		User u = new User();
		u.setName("imooc2");
		u.setAge(18);
		u.setBirthday(new Date());
		u.setPassword("imooc2");
		u.setDesc("hello imooc2~~");

		return u;
	}
}
