package com.skodoskxx.techie.springngblog.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Table
@Getter
@Setter

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String title;

    @Lob
    @Column
    @NotEmpty
    private String content;

    @Column
    private Instant createOn;

    @Column
    private Instant updatedOn;

    @Column
    @NotBlank
    private String username;

}
