package com.xchaset.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.xchaset.bean.UserInfo;
import com.xchaset.dao.UserInfoMapper;
import com.xchaset.dto.BaseResponse;

@Controller
public class Control {
	@Autowired
	private UserInfoMapper usersMapper;

	@RequestMapping("/user/{username}")
	@ResponseBody
	public BaseResponse<UserInfo> getUser(@PathVariable String username){
		UserInfo users = usersMapper.getByName(username);
		BaseResponse<UserInfo> baseResponse = new BaseResponse<>();
		if(null == users){
			baseResponse.setRetCode("00001");
			baseResponse.setRetMsg("无此用户");
			return baseResponse;
		}
		baseResponse.setRetCode("00000");
		baseResponse.setRetMsg("查询成功");
		baseResponse.setData(users);
		return baseResponse;
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
}