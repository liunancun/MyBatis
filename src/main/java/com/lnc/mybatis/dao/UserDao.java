package com.lnc.mybatis.dao;

import java.util.List;

import com.lnc.mybatis.bean.UserBean;
import com.lnc.mybatis.bean.UserCondition;

public interface UserDao {

	void insertUser(UserBean user) throws Exception;

	void updateUser(UserBean user) throws Exception;

	int findUserCount(UserCondition condition) throws Exception;

	List<UserBean> findUserList(UserCondition condition) throws Exception;

	UserBean findUserById(String id) throws Exception;

	void deleteUser(String id) throws Exception;

}
