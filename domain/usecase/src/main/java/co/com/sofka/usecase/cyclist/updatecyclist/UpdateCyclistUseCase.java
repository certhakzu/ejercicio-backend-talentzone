package co.com.sofka.usecase.cyclist.updatecyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateCyclistUseCase {
    private final CyclistRepository cyclistRepository;

    public Mono<Cyclist> updateCyclist(String id, Cyclist cyclist){
        return cyclistRepository.update(id, cyclist);
    }
}
