package com.sysu.moviepro.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysu.moviepro.business.entity.User;
import com.sysu.moviepro.business.service.UserService;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@ModelAttribute("user") User user) {
		//logger.info("user {}", user.getName());
		User result = userService.getUserByName(user.getName());
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (result.getId() != 0) {
			if (result.getPassword().equals(user.getPassword())) {
				logger.info("登录成功");
				modelMap.put("code", 0);
				modelMap.put("user", user);
			} else {
				logger.info("密码错误");
				modelMap.put("code", 1);
			}
		} else {
			logger.info("用户名不存在");
			modelMap.put("code", 2);
		}
/*//		List<User> list = new ArrayList<User>();
//		User user1 = new User();
//		user1.setId(0);
//		user1.setName("zhangsan");
//		user1.setPassword("123456");
//		list.add(user1);
//		
//		User user2 = new User();
//		user2.setId(1);
//		user2.setName("lisi");
//		user2.setPassword("654321");
//		list.add(user2);
//		
//		modelMap.put("li", list);
*/		return modelMap;
	}
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> test() {
		Map<String, Object> modelMap = new HashMap();
		List<User> list = new ArrayList<User>();
		User user1 = new User();
		user1.setId(0);
		user1.setName("zhangsan");
		user1.setPassword("123456");
		list.add(user1);
		
		User user2 = new User();
		user2.setId(1);
		user2.setName("lisi");
		user2.setPassword("654321");
		list.add(user2);
		
		modelMap.put("li", list);
		return modelMap;
	}
}
