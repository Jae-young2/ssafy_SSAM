package com.ssafy.ssam.ssam_backend.api.dto.response;

import com.ssafy.ssam.ssam_backend.domain.GameState;
import com.ssafy.ssam.ssam_backend.domain.entity.ScheduleAndScore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ScheduleResultResDto {

    @ApiModelProperty(value="홈팀")
    private String homeTeam;
    @ApiModelProperty(value = "어웨이 팀")
    private String awayTeam;
    @ApiModelProperty(value = "날짜")
<<<<<<< HEAD

    private LocalDate date;
=======
    private LocalDateTime date;
>>>>>>> d4bc3f7f927b717e7051f2102ad59c540184772e
    @ApiModelProperty(value = "홈팀 점수")
    private int homeScore;
    @ApiModelProperty(value = "어웨이팀 점수")
    private int awayScore;
    @ApiModelProperty(value = "방송 어디서하는지")
    private String broadcasting;
    @ApiModelProperty(value = "경기장")
    private String stadium;
    @ApiModelProperty(value = "게임상태",notes = "하기전, 취소, 끝남")
    private GameState gameState;


    public ScheduleResultResDto(ScheduleAndScore entity){
        this.homeTeam = entity.getHomeTeam().getTeamName();
        this.awayTeam = entity.getAwayTeam().getTeamName();
        this.date = entity.getDate();
        this.homeScore = entity.getHomeScore();
        this.awayScore= entity.getAwayScore();
        this.broadcasting = entity.getBroadcasting();
        this.stadium = entity.getStadium();
        this.gameState = entity.getGameState();

    }

}
