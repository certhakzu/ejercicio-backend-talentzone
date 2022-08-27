package co.com.sofka.usecase.findallcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllCyclistUseCase {
    private final CyclistRepository cyclistRepository;

    public Flux<Cyclist> findAllCyclist(){
        return cyclistRepository.findAll();
    }
}
