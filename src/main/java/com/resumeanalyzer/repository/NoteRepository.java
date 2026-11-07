package com.resumeanalyzer.repository;
import com.resumeanalyzer.model.Note; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface NoteRepository extends JpaRepository<Note,Long>{List<Note> findByOwnerOrderByIdDesc(String owner);}
