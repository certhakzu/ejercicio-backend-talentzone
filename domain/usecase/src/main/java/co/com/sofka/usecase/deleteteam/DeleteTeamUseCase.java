package co.com.sofka.usecase.deleteteam;

import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteTeamUseCase {
    private final TeamRepository teamRepository;

    public Mono<Void> deleteTeam(String id){
        return teamRepository.deleteById(id);
    }
}
