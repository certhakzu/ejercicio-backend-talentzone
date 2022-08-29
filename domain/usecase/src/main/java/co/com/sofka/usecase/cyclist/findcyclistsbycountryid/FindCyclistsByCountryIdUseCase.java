package co.com.sofka.usecase.cyclist.findcyclistsbycountryid;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindCyclistsByCountryIdUseCase {
    private final CyclistRepository cyclistRepository;

    public Flux<Cyclist> findCyclistsByCountryId(String id){
        return cyclistRepository.findAll()
                .filter(cyclist -> cyclist.getIdCountry().equals(id));
    }
}
