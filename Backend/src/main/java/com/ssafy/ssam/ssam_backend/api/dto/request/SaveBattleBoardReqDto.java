package com.ssafy.ssam.ssam_backend.api.dto.request;

import java.time.LocalDateTime;

import com.ssafy.ssam.ssam_backend.domain.entity.BattleBoard;
import com.ssafy.ssam.ssam_backend.domain.entity.MyTeam;
import com.ssafy.ssam.ssam_backend.domain.entity.User;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SaveBattleBoardReqDto {
	@NotNull
    public String bbTitle;
	public LocalDateTime bbUpdateTime;
	public LocalDateTime bbWriteTime;

    public SaveBattleBoardReqDto(String bbTitle) {
        this.bbTitle = bbTitle;
        bbUpdateTime = LocalDateTime.now();
        bbWriteTime = LocalDateTime.now();
    }

    public BattleBoard toEntity(User user) {
        return BattleBoard
                .builder()
                .bbTitle(bbTitle)
                .author(user)
                .bbUpdateTime(bbUpdateTime)
                .bbWriteTime(bbWriteTime)
                .build();
    }
    
    public BattleBoard toEntity(User user, MyTeam myTeam) {
        return BattleBoard
                .builder()
                .bbTitle(bbTitle)
                .author(user)
                .myTeam(myTeam)
                .bbUpdateTime(bbUpdateTime)
                .bbWriteTime(bbWriteTime)
                .build();
    }
}
