package co.com.sofka.usecase.deletecyclist;

import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteCyclistUseCase {
    private final CyclistRepository cyclistRepository;

    public Mono<Void> deleteCyclist(String id){
        return cyclistRepository.deleteById(id);
    }
}
