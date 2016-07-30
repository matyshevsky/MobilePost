package com.example.repository;

import com.example.model.mRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SeBB on 24.07.2016.
 */
public interface RoleDao extends JpaRepository<mRole, Long> {
}
