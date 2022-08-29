package co.com.sofka.api.country;

import co.com.sofka.model.country.Country;
import co.com.sofka.usecase.country.createcountry.CreateCountryUseCase;
import co.com.sofka.usecase.country.deletecountry.DeleteCountryUseCase;
import co.com.sofka.usecase.country.findallcountries.FindAllCountriesUseCase;
import co.com.sofka.usecase.country.findcountrybyid.FindCountryByIdUseCase;
import co.com.sofka.usecase.country.updatecountry.UpdateCountryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CountryHandler {

    private final CreateCountryUseCase createCountryUseCase;
    private final DeleteCountryUseCase deleteCountryUseCase;
    private final UpdateCountryUseCase updateCountryUseCase;
    private final FindAllCountriesUseCase findAllCountriesUseCase;
    private final FindCountryByIdUseCase findCountryByIdUseCase;

    public Mono<ServerResponse> listenPOSTCreateCountryUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Country.class)
                .flatMap(country -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createCountryUseCase.createCountry(country), Country.class));
    }

    public Mono<ServerResponse> listenDELETEDeleteCountryUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteCountryUseCase.deleteCountry(id), Country.class);
    }

    public Mono<ServerResponse> listenPUTUpdateCOuntryUSeCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Country.class)
                .flatMap(country -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateCountryUseCase.updateCountry(id, country), Country.class));
    }

    public Mono<ServerResponse> listenGETFindAllCountriesUseCase(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findAllCountriesUseCase.findAllCountries(), Country.class);
    }

    public Mono<ServerResponse> listenGETFindCountryByIdUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findCountryByIdUseCase.findCountryById(id), Country.class);
    }
}
