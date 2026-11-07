package com.resumeanalyzer.repository;
import com.resumeanalyzer.model.ResumeRecord; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface ResumeRepository extends JpaRepository<ResumeRecord,Long>{List<ResumeRecord> findByOwnerOrderByIdDesc(String owner);}
