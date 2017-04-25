package com.IKP.database.service;

import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;

public interface AddUserFormService {
	public void insertUser(User user);

	public void insertRun(RunRange runRange);
}
