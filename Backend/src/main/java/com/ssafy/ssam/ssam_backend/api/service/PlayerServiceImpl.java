package com.ssafy.ssam.ssam_backend.api.service;

import com.ssafy.ssam.ssam_backend.api.dto.response.*;
import com.ssafy.ssam.ssam_backend.api.repository.*;
import com.ssafy.ssam.ssam_backend.api.repository.mapping.HitterIdMapping;
import com.ssafy.ssam.ssam_backend.api.repository.mapping.PitcherIdMapping;
import com.ssafy.ssam.ssam_backend.api.repository.mapping.PlayerMapping;
import com.ssafy.ssam.ssam_backend.domain.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final HitterYearsStatusRepository hitterYearsStatusRepository;
    private final HitterDaysStatusRepository hitterDaysStatusRepository;
    private final HitterSituationStatusRepository hitterSituationStatusRepository;
    private final PitcherYearsStatusRepository pitcherYearsStatusRepository;
    private final PitcherDaysStatusRepository pitcherDaysStatusRepository;
    private final PitcherSituationStatusRepository pitcherSituationStatusRepository;

    @Override
    public HitterYearsDetailResDto getHitterYearsDetail(Long playerId, String years) throws Exception{
        Player player = playerRepository.findById(playerId).get();

        HitterYearsStatus entity = hitterYearsStatusRepository.findByPlayerAndYears(player,years);

        HitterYearsDetailResDto dto = new HitterYearsDetailResDto(entity);

        return dto;

    }

    @Override
    public PitcherYearsDetailResDto getPitcherYearsDetail(Long playerId, String years) throws Exception {
        Player player = playerRepository.findById(playerId).get();

        PitcherYearsStatus entity = pitcherYearsStatusRepository.findByPlayerAndYears(player,years);

        PitcherYearsDetailResDto dto  = new PitcherYearsDetailResDto(entity);

        return dto;
    }

    @Override
    public HitterDaysDetailResDto getHitterDaysDetail(Long playerId, LocalDate days) throws Exception {
        Player player = playerRepository.findById(playerId).get();

        HitterDaysStatus entity = hitterDaysStatusRepository.findByPlayerAndDate(player,days);

        HitterDaysDetailResDto dto  = new HitterDaysDetailResDto(entity);

        return dto;
    }

    @Override
    public PitcherDaysDetailResDto getPitcherDaysDetail(Long playerId, LocalDate days) throws Exception {
        Player player = playerRepository.findById(playerId).get();

        PitcherDaysStatus entity = pitcherDaysStatusRepository.findByPlayerAndDate(player,days);

        PitcherDaysDetailResDto dto = new PitcherDaysDetailResDto(entity);

        return dto;
    }

    @Override
    public HitterSituationResDto getHitterSituation(Long playerId, String years) throws Exception {
        Player player = playerRepository.findById(playerId).get();

        HitterSituationStatus entity = hitterSituationStatusRepository.findByPlayerAndYears(player,years);

        HitterSituationResDto dto = new HitterSituationResDto(entity);
        return dto;
    }

    @Override
    public PitcherSituationResDto getPitcherSituation(Long playerId, String years) throws Exception {
        Player player = playerRepository.findById(playerId).get();

        PitcherSituationStatus entity = pitcherSituationStatusRepository.findByPlayerAndYears(player,years);
        PitcherSituationResDto dto = new PitcherSituationResDto(entity);
        return dto;
    }

    @Override
    public List<SearchResultResDto> getNameList(String year) throws Exception {

        List<SearchResultResDto> resultList = new ArrayList<>();



//        List<Player> list = playerRepository.findByPlayerNameLike("%"+word+"%");

        List<HitterYearsStatus> hitterIdList = hitterYearsStatusRepository.findAllIdByYears(year);
            for(HitterYearsStatus yearstatus : hitterIdList){
                SearchResultResDto dto = new SearchResultResDto(yearstatus.getPlayer().getPlayerName(), yearstatus.getPlayer().getPlayerId(), yearstatus.getHitterYearsSId(),"Hitter",year);
                resultList.add(dto);
            }
            List<PitcherYearsStatus> pitcherIdList = pitcherYearsStatusRepository.findAllIdByYears(year);
            for(PitcherYearsStatus yearsStatus : pitcherIdList){
                SearchResultResDto dto = new SearchResultResDto(yearsStatus.getPlayer().getPlayerName(), yearsStatus.getPlayer().getPlayerId(), yearsStatus.getPitcherYearsSId(),"Pitcher",year);
                resultList.add(dto);
            }



        return resultList;

    }

    @Override
    public PlayerInfoResDto getPlayerInfo(Long playerId) throws Exception {
        PlayerInfoResDto dto;
        Player entity = playerRepository.findById(playerId).get();
        dto = new PlayerInfoResDto(entity);

        return dto;
    }
}