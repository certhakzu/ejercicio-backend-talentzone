package co.com.sofka.usecase.team.updateteam;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateTeamUseCase {
    private final TeamRepository teamRepository;

    public Mono<Team> updateTeam(String id, Team team){
        return teamRepository.update(id, team);
    }
}
