package org.mysite.myboard.presentation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class Write {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String writer;

    private LocalDateTime createTime;

    @OneToMany(mappedBy = "write", cascade = CascadeType.REMOVE)
    private List<Answer> answers;
}
