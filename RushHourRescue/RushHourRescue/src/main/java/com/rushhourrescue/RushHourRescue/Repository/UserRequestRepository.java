package com.rushhourrescue.RushHourRescue.Repository;

import com.rushhourrescue.RushHourRescue.Entity.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Integer> {
    List<UserRequest> findAllByRequestTimeAsc();
}
