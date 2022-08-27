package co.com.sofka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class CyclistRouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(CyclistHandler cyclistHandler) {
    return route(GET("/api/usecase/path"), cyclistHandler::listenGETUseCase)
    .andRoute(POST("/api/usecase/otherpath"), cyclistHandler::listenPOSTUseCase).and(route(GET("/api/otherusercase/path"), cyclistHandler::listenGETOtherUseCase));

    }
}
