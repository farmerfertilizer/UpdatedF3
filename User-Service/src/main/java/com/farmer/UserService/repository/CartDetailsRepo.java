package com.farmer.UserService.repository;

import com.farmer.UserService.dto.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailsRepo extends JpaRepository<CartDetails,Integer> {
}
