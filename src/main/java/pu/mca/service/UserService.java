package pu.mca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pu.mca.dao.repository.ClassDetailsReposirory;
import pu.mca.dao.repository.FeePaymentRepository;
import pu.mca.dao.repository.ResultRepository;
import pu.mca.dao.repository.UserRepository;
import pu.mca.models.ClassDetails;
import pu.mca.models.Result;
import pu.mca.models.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	ClassDetailsReposirory classRepository;
	
	@Autowired
	ResultRepository resultRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FeePaymentRepository feeRepository;

	public User getUserById(Long id) {
		
		return repository.getById(id);
	}

	public User login(User user) {
		return repository.getByEmailAndPassword(user.getEmail(), user.getPassword())
				.orElseThrow(() -> new RuntimeException("Invalid user"));
		
	}

	public User signup(User user) {
		repository.saveAndFlush(user);
		return user;
	}

	public List<ClassDetails> getAllClasses() {
		return classRepository.findAll();
	}

	public List<Result> getResult(Long userId, Long classId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		return resultRepository.findByUserAndClassId(user, classId);
	}

	public User getAdmission(Long userId, Long classId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		ClassDetails classDetail = classRepository.findById(classId).orElseThrow(() -> new RuntimeException("Class not found"));
		user.setClassDetails(classDetail);
		userRepository.saveAndFlush(user);
		return user;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public ClassDetails updateFee(ClassDetails fee) {
		classRepository.saveAndFlush(fee);
		return fee;
	}


	
}
