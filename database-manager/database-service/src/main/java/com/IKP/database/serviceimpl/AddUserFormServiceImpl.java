package com.IKP.database.serviceimpl;

import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;
import com.IKP.database.query.AddUserQuery;
import com.IKP.database.service.AddUserFormService;

public class AddUserFormServiceImpl implements AddUserFormService {

	private AddUserQuery addUserQuery;

	public AddUserFormServiceImpl() {
		this.addUserQuery = new AddUserQuery();
	}

	public void insertUser(User user) {
		this.addUserQuery.insertUser(user);
	}

	public void insertRun(RunRange runRange) {
		this.addUserQuery.insertRun(runRange);

	}

}
