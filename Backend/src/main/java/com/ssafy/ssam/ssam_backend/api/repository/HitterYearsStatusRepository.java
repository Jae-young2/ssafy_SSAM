package com.ssafy.ssam.ssam_backend.api.repository;

import com.ssafy.ssam.ssam_backend.api.repository.mapping.HitterIdMapping;
import com.ssafy.ssam.ssam_backend.domain.entity.HitterYearsStatus;
import com.ssafy.ssam.ssam_backend.domain.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HitterYearsStatusRepository extends JpaRepository<HitterYearsStatus,Long> {

    HitterYearsStatus findByPlayerAndYears(Player player , String years);
    List<HitterIdMapping> findAllIdByPlayerAndYears(Player player, String years);

    List<HitterYearsStatus> findAllIdByYears(String year);
}