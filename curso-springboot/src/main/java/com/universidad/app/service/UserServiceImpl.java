package com.universidad.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidad.app.dao.UserDAO;
import com.universidad.app.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {		
		return userDAO.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {		
		return userDAO.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		return userDAO.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userDAO.deleteById(id);		
	}
	
}
