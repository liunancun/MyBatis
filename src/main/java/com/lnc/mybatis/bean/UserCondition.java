package com.lnc.mybatis.bean;

import java.util.List;

public class UserCondition {

	private String id;

	private List<String> ids;

	public UserCondition() {
	}

	public UserCondition(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

}
