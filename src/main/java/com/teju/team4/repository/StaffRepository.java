package com.teju.team4.repository;



import com.teju.team4.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    // You can define custom query methods here if needed
}

