package com.ysj.core.service;

import com.ysj.core.po.Admin;

public interface AdminService {
	public Admin findAdmin(String adminId, String adminPwd);
	public Admin getAdmin(String adminId);
	public int editInfo(Admin admin);
}
