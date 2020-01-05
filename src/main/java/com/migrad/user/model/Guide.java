package com.migrad.user.model;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Guide {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @OneToOne
    private User user;

    //TODO: Introduce Steps

    @OneToOne
    private Country location;

    @OneToOne
    private Country destination;

    @OneToOne
    private Occupation occupation;
}
