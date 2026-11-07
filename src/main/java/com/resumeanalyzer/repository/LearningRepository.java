package com.resumeanalyzer.repository;
import com.resumeanalyzer.model.LearningEntry; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface LearningRepository extends JpaRepository<LearningEntry,Long>{List<LearningEntry> findByOwnerOrderByIdDesc(String owner);}
