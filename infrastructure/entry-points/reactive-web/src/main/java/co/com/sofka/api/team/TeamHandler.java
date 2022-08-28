package co.com.sofka.api.team;

import co.com.sofka.model.team.Team;
import co.com.sofka.usecase.createteam.CreateTeamUseCase;
import co.com.sofka.usecase.deleteteam.DeleteTeamUseCase;
import co.com.sofka.usecase.findallteam.FindAllTeamUseCase;
import co.com.sofka.usecase.findteambyid.FindTeamByIdUseCase;
import co.com.sofka.usecase.updateteam.UpdateTeamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TeamHandler {

    private final CreateTeamUseCase createTeamUseCase;
    private final DeleteTeamUseCase deleteTeamUseCase;
    private final UpdateTeamUseCase updateTeamUseCase;
    private final FindAllTeamUseCase findAllTeamUseCase;
    private final FindTeamByIdUseCase findTeamByIdUseCase;

    public Mono<ServerResponse> listenPOSTCreateTeamUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Team.class)
                .flatMap(team -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createTeamUseCase.createTeam(team), Team.class));
    }

    public Mono<ServerResponse> listenDELETEDeleteTeamUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteTeamUseCase.deleteTeam(id), Team.class);
    }

    public Mono<ServerResponse> listenPUTUpdateTeamUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Team.class)
                .flatMap(team -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateTeamUseCase.updateTeam(id, team), Team.class));
    }

    public Mono<ServerResponse> listenGETFindAllTeamsUseCase(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findAllTeamUseCase.findAllTeams(), Team.class);
    }

    public Mono<ServerResponse> listenGETFindTeamByIdUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findTeamByIdUseCase.findTeamById(id), Team.class);
    }
}
