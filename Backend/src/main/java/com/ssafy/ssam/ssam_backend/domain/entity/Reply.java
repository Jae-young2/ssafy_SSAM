package com.ssafy.ssam.ssam_backend.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @ManyToOne
    @JoinColumn(name="freeBoardId")
    private FreeBoard freeBoard;

    @ManyToOne
    @JoinColumn(name="userId")
    private User author;

    @Column
    private LocalDateTime fbWriteTime;

    @Column
    private LocalDateTime fbUpdateTime;



}