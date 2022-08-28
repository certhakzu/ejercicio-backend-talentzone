package co.com.sofka.usecase.findallteam;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllTeamUseCase {
    private final TeamRepository teamRepository;

    public Flux<Team> findAllTeams(){
        return teamRepository.findAll();
    }
}
