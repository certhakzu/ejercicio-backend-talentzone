package co.com.sofka.usecase.createteam;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateTeamUseCase {
    private final TeamRepository teamRepository;

    public Mono<Team> createTeam(Team team){
        return teamRepository.save(team);
    }
}
