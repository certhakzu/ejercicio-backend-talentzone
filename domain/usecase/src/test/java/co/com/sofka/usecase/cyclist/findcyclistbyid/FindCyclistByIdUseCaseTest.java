package co.com.sofka.usecase.cyclist.findcyclistbyid;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.Name;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindCyclistByIdUseCaseTest {
    @InjectMocks
    FindCyclistByIdUseCase findCyclistByIdUseCase;

    @Mock
    CyclistRepository cyclistRepository;

    @Test
    void findCyclistById() {
        var cyclist1 = new Cyclist("1", new Name("Piter", "Velasquez"), 1, "1", "1");

        var cyclistMono = Mono.just(cyclist1);
        when(cyclistRepository.findById("1")).thenReturn(cyclistMono);

        StepVerifier.create(findCyclistByIdUseCase.findCyclistById("1"))
                .expectNextMatches(cyclist -> cyclist.getId().equals("1") && cyclist.getFullName().equals(new Name("Piter", "Velasquez"))
                        && cyclist.getCompetitorNumber().equals(1) && cyclist.getIdTeam().equals("1")
                        && cyclist.getIdCountry().equals("1"))
                .expectComplete()
                .verify();
    }
}