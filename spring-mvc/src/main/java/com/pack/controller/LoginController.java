package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.service.ILoginService;

@Controller
public class LoginController {
	@Autowired
	ILoginService service;
	@GetMapping("/loginPage")
	public String getLoginPge()
	{
		return "Login";
	}
@PostMapping("/checkLogin")
public String handleLogin(@RequestParam("username")String username,@RequestParam("password")String password,Model model) {
boolean flag=service.doLogin(username, password);
if(flag==true) {
	String m="welcome"+username+"<br> Login success";
	model.addAttribute("successMsg",m);
	return "success";
}
else
{
	String m="sorry"+username+"<br> Login failed";
	model.addAttribute("failureMsg",m);
	return "failure";

}
}
}
