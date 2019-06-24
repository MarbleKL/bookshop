package edu.sit.bookshop.repository;

import edu.sit.bookshop.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Integer> {
}
