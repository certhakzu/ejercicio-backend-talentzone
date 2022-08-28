package co.com.sofka.api.cyclist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class CyclistRouterRest {
@Bean
public RouterFunction<ServerResponse> cyclistRouterFunction(CyclistHandler cyclistHandler) {
    return route(POST("/api/cyclist/create"), cyclistHandler::listenPOSTCreateCyclistUseCase)
            .andRoute(GET("/api/cyclist/findbyid/{id}"), cyclistHandler::listenGETFindCyclistByIdUseCase)
            .andRoute(GET("/api/cyclist/findall"), cyclistHandler::listenGETFindAllCyclistUseCase)
            .andRoute(PUT("/api/cyclist/update/{id}"), cyclistHandler::listenPUTUpdateCyclistUseCase)
            .andRoute(DELETE("/api/cyclist/delete/{id}"), cyclistHandler::listenDELETEDeleteCyclistUseCase);
    }
}
