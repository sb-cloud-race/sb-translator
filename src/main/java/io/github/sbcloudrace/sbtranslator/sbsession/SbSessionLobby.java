package io.github.sbcloudrace.sbtranslator.sbsession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SbSessionLobby {

    private Long lobbyId;
    private Integer eventId;
    private Integer timeToLive;
}
