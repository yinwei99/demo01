package com.offcn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.BaiCaiDao;
import com.offcn.po.BaiCai;
import com.offcn.service.BaiCaiService;
@Service
public class BaiCaiServiceImpl implements BaiCaiService {

	@Autowired
	private BaiCaiDao baiCaiDao;
	@Override
	public void save(BaiCai baiCai) {
		baiCaiDao.save(baiCai);

	}
	@Override
	public List<BaiCai> getbBcByDate(String begindate, String enddate) {
		
		return baiCaiDao.getbBcByDate(begindate, enddate);
	}

}
