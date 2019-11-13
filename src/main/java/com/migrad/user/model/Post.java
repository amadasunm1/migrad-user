package com.migrad.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@ToString(exclude = {"replies"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    @OneToOne
    private User author;

    @JsonIgnore
    @ManyToOne
    private Post parent;

    @OneToMany(mappedBy = "parent")
    private List<Post> replies;
    private String subject;
    private String content;
}
