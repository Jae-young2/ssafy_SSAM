package com.ssafy.ssam.ssam_backend.api.repository;

import com.ssafy.ssam.ssam_backend.domain.entity.MyTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyTeamRepository extends JpaRepository<MyTeam,Long> {
}