package co.com.sofka.usecase.cyclist.findcyclistsbyteamid;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindCyclistsByTeamIdUseCase {
    private final CyclistRepository cyclistRepository;

    public Flux<Cyclist> findCyclistsByTeamId(String idTeam){
        return cyclistRepository.findAll()
                .filter(cyclist -> cyclist.getIdTeam().equals(idTeam));
    }
}
