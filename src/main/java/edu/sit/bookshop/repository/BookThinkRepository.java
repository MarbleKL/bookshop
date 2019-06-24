package edu.sit.bookshop.repository;

import edu.sit.bookshop.entity.BookThink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookThinkRepository extends JpaRepository<BookThink,Integer> {
}
