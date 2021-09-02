package pu.mca.dao.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pu.mca.models.Result;
import pu.mca.models.User;

public interface ResultRepository extends JpaRepository<Result, Long> {
	
	public List<Result> findByUserAndClassId(User user, Long classId);

}
