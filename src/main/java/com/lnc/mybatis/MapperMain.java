package com.lnc.mybatis;

import java.io.InputStream;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lnc.mybatis.bean.UserBean;
import com.lnc.mybatis.bean.UserCondition;
import com.lnc.mybatis.mapper.UserMapper;

public class MapperMain {

	public static void main(String[] args) throws Exception {
		InputStream inputStream = Resources
				.getResourceAsStream("SqlMapConfig.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		String id = UUID.randomUUID().toString();

		UserBean user = new UserBean();
		user.setId(id);
		user.setName("zhangsan");
		user.setSex("男");
		user.setAge(30);
		user.setDesc("desc-" + id);

		// 插入
		userMapper.insertUser(user);

		// 修改
		user.setDesc("update-" + id);
		userMapper.updateUser(user);

		// 查询
		System.out.println(userMapper.findUserCount(new UserCondition(id)));
		System.out.println(userMapper.findUserList(new UserCondition(id)));
		System.out.println(userMapper.findUserById(id));

		// 删除
		userMapper.deleteUser(id);
	}

}
