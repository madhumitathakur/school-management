package pu.mca.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pu.mca.models.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
