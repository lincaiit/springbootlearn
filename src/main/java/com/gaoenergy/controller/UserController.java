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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaoenergy.pojo.User;
import com.gaoenergy.utils.JSONResult;
import com.gaoenergy.utils.JsonUtils;
import com.gaoenergy.utils.RedisOperator;

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

	@Autowired
	private RedisOperator redis;
	
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
	
	@RequestMapping(value = "/getRedisJson")
	@ResponseBody
	public JSONResult testJedis() {
		User user = new User();
		user.setAge(18);
		user.setName("慕课网");
		user.setPassword("123456");
		user.setBirthday(new Date());
		
		
		User u1 = new User();
		u1.setAge(19);
		u1.setName("imooc");
		u1.setPassword("123456");
		u1.setBirthday(new Date());
		
		User u2 = new User();
		u2.setAge(17);
		u2.setName("hello imooc");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		
		redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);
		
		String userListJson = redis.get("json:info:userlist");
		List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);
		
		return JSONResult.ok(userListBorn);
	}
}
