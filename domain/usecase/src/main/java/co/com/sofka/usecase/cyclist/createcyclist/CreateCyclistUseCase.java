package co.com.sofka.usecase.cyclist.createcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateCyclistUseCase {
    private final CyclistRepository cyclistRepository;

    public Mono<Cyclist> createCyclist(Cyclist cyclist){
        return cyclistRepository.save(cyclist);
    }
}
