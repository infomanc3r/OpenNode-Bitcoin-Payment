package com.opennodetest.backend.repositories;

import com.opennodetest.backend.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface defines a repository for the Order entity - Spring generates methods for accessing the database.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findByOrderId(String orderId);
}
