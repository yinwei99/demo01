package com.offcn.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.offcn.po.BaiCai;

public interface BaiCaiDao {

	public void save(BaiCai  baiCai);
	
	public  List<BaiCai> getbBcByDate(@Param("begindate")String  begindate ,@Param("enddate")String enddate);
}
