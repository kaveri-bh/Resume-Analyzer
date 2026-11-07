package com.resumeanalyzer.repository;
import com.resumeanalyzer.model.UserAccount; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface UserRepository extends JpaRepository<UserAccount,Long>{Optional<UserAccount> findByEmail(String email); boolean existsByEmail(String email);}
