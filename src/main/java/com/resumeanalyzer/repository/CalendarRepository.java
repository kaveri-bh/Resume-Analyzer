package com.resumeanalyzer.repository;
import com.resumeanalyzer.model.CalendarEvent; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface CalendarRepository extends JpaRepository<CalendarEvent,Long>{List<CalendarEvent> findByOwnerOrderByEventDateAsc(String owner);}
