package co.com.sofka.api.country;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class CountryRouterRest {
@Bean
public RouterFunction<ServerResponse> CountryRouterFunction(CountryHandler countryHandler) {
    return route(POST("/api/country/create"), countryHandler::listenPOSTCreateCountryUseCase)
            .andRoute(DELETE("/api/country/delete/{id}"), countryHandler::listenDELETEDeleteCountryUseCase)
            .andRoute(PUT("/api/country/update/{id}"), countryHandler::listenPUTUpdateCOuntryUSeCase)
            .andRoute(GET("/api/country/findall"), countryHandler::listenGETFindAllCountryUseCase)
            .andRoute(GET("/api/country/findbyid/{id}"), countryHandler::listenGETFindCountryByIdUseCase);
    }
}
