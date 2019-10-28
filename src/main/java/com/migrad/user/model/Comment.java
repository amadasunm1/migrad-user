package com.migrad.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    @OneToOne
    private User author;
    @ManyToOne
    private Comment parent;
    @OneToMany(mappedBy = "parent")
    private List<Comment> replies;
    private String subject;
    private String content;
}
