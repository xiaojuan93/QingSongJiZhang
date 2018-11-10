package cn.qsj.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.qsj.domain.ZhangWu;
import cn.qsj.tools.JDBCUtils;

public class ZhangWuDao {
	//获取数据库连接池，得到操作表数据的对象QueryRunner
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	public List<ZhangWu> selectAll() {
		// TODO Auto-generated method stub

		String sql = "select * from qsj_zhangwu";
		try {
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<ZhangWu> select(String start, String end) {
		// TODO Auto-generated method stub
		String sql = "select * from qsj_zhangwu where createtime between ? and ?";
		Object[] params = {start, end};
		try {
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void addZhangWu(ZhangWu zw) {
		// TODO Auto-generated method stub
		String sql = "insert into qsj_zhangwu(money,description,createtime) values(?,?,?)";
		try {
			Object[] params = {zw.getMoney(),zw.getDescription(),zw.getCreatetime()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}

	public void editZhangWu(ZhangWu zw) {
		// TODO Auto-generated method stub
		String sql = "update qsj_zhangwu set  money=?,description=?,createtime=? where id=?";
		try {
			Object[] params = {zw.getMoney(),zw.getDescription(),zw.getCreatetime(),zw.getId()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}

	public void deleteZhangWu(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from qsj_zhangwu where id=?";
		try {
			qr.update(sql, id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
