package com.offcn.service;

import java.util.List;


import com.offcn.po.BaiCai;

public interface BaiCaiService {

	public void save(BaiCai  baiCai);
	
	public  List<BaiCai> getbBcByDate(String  begindate ,String enddate);
}
