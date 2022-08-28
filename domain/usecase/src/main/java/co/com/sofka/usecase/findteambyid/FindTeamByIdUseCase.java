package co.com.sofka.usecase.findteambyid;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindTeamByIdUseCase {
    private final TeamRepository teamRepository;

    public Mono<Team> findTeamById(String id){
        return teamRepository.findById(id);
    }
}
