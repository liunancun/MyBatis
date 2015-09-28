package com.lnc.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.lnc.mybatis.bean.UserBean;
import com.lnc.mybatis.bean.UserCondition;
import com.lnc.mybatis.dao.UserDao;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void insertUser(UserBean user) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.insert("test.insertUser", user);

		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void updateUser(UserBean user) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.update("test.updateUser", user);

		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public int findUserCount(UserCondition condition) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		int count = sqlSession.selectOne("test.findUserCount", condition);

		sqlSession.close();

		return count;
	}

	@Override
	public List<UserBean> findUserList(UserCondition condition)
			throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<UserBean> users = sqlSession.selectList("test.findUserList",
				condition);

		sqlSession.close();

		return users;
	}

	@Override
	public UserBean findUserById(String id) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		UserBean user = sqlSession.selectOne("test.findUserById", id);

		sqlSession.close();

		return user;
	}

	@Override
	public void deleteUser(String id) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.delete("test.deleteUser", id);

		sqlSession.commit();
		sqlSession.close();
	}

}
