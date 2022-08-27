package co.com.sofka.usecase.findcyclistbyid;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindCyclistByIdUseCase {
    private final CyclistRepository cyclistRepository;

    public Mono<Cyclist> findCyclistById(String id){
        return cyclistRepository.findById(id);
    }
}
