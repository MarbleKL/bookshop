package edu.sit.bookshop.repository;

import edu.sit.bookshop.entity.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRequestRepository extends JpaRepository<BookRequest,Integer> {
}
