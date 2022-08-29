package co.com.sofka.usecase.team.findteamsbycountryid;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindTeamsByCountryIdUseCase {
    private final TeamRepository teamRepository;

    public Flux<Team> findTeamsByCountryId(String id){
        return teamRepository.findAll()
                .filter(team -> team.getIdCountry().equals(id));
    }
}
