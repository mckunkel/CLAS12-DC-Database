package com.IKP.database.serviceimpl;

import java.util.List;

import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;
import com.IKP.database.query.RemoveUserQuery;
import com.IKP.database.service.RemoveUserFormService;

public class RemoveUserFormServiceImpl implements RemoveUserFormService {

	private RemoveUserQuery removeUserQuery;

	public RemoveUserFormServiceImpl() {
		this.removeUserQuery = new RemoveUserQuery();
	}

	public List<User> getAllUsers() {
		return this.removeUserQuery.getAllUsers();
	}

	public void removeUser(User user) {
		this.removeUserQuery.removeUser(user);
	}

	public List<RunRange> getAllRuns() {
		return this.removeUserQuery.getAllRuns();

	}

	public void removeRun(RunRange runRange) {
		this.removeUserQuery.removeRun(runRange);
	}

}
