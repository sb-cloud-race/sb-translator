package io.github.sbcloudrace.sbtranslator.sbpersona;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SbPersona {

    private long personaId;
    private double boost;
    private double cash;
    private int iconIndex;
    private int level;
    private String motto;
    private String name;
    private float percentToLevel;
    private double rating;
    private double rep;
    private int repAtCurrentLevel;
    private int score;
    private long userId;

}
