package com.offcn.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.po.BaiCai;
import com.offcn.service.BaiCaiService;

@Controller
public class BaiCaiController {
	
	@Autowired
	private  BaiCaiService baiCaiService;
	
	@RequestMapping("/getbBcByDate")
	@ResponseBody
	public List<BaiCai> getbBcByDate(String begindate ,String enddate ){
		List<BaiCai> list = baiCaiService.getbBcByDate(begindate, enddate);
		return list;
		
	
			
	};
	
	
	
	
}
