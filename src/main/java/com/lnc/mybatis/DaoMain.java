package com.lnc.mybatis;

import java.io.InputStream;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lnc.mybatis.bean.UserBean;
import com.lnc.mybatis.bean.UserCondition;
import com.lnc.mybatis.dao.UserDao;
import com.lnc.mybatis.dao.impl.UserDaoImpl;

public class DaoMain {

	public static void main(String[] args) throws Exception {
		InputStream inputStream = Resources
				.getResourceAsStream("SqlMapConfig.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		String id = UUID.randomUUID().toString();

		UserBean user = new UserBean();
		user.setId(id);
		user.setName("zhangsan");
		user.setSex("男");
		user.setAge(30);
		user.setDesc("desc-" + id);

		// 插入
		userDao.insertUser(user);

		// 修改
		user.setDesc("update-" + id);
		userDao.updateUser(user);

		// 查询
		System.out.println(userDao.findUserCount(new UserCondition(id)));
		System.out.println(userDao.findUserList(new UserCondition(id)));
		System.out.println(userDao.findUserById(id));

		// 删除
		userDao.deleteUser(id);
	}

}
