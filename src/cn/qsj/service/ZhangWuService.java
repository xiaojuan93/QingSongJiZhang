package cn.qsj.service;

import java.util.List;

import cn.qsj.dao.ZhangWuDao;
import cn.qsj.domain.ZhangWu;

public class ZhangWuService {
	//service都依赖dao
	private ZhangWuDao zhangWuDao = new ZhangWuDao();

	public List<ZhangWu> selectAll() {
		// TODO Auto-generated method stub
		return zhangWuDao.selectAll();
	}

	public List<ZhangWu> select(String start, String end) {
		// TODO Auto-generated method stub
		return zhangWuDao.select(start, end);
	}

	public void addZhangWu(ZhangWu zw) {
		// TODO Auto-generated method stub
		zhangWuDao.addZhangWu(zw);
	}

	public void editZhangWu(ZhangWu zw) {
		// TODO Auto-generated method stub
		zhangWuDao.editZhangWu(zw);
	}

	public void deleteZhangWu(int id) {
		// TODO Auto-generated method stub
		zhangWuDao.deleteZhangWu(id);
	}
}
