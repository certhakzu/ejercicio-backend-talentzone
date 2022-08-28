package co.com.sofka.api.team;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class TeamRouterRest {
@Bean
public RouterFunction<ServerResponse> TeamRouterFunction(TeamHandler teamHandler) {
    return route(POST("/api/team/create"), teamHandler::listenPOSTCreateTeamUseCase)
            .andRoute(DELETE("/api/team/delete/{id}"), teamHandler::listenDELETEDeleteTeamUseCase)
            .andRoute(PUT("/api/team/update/{id}"), teamHandler::listenPUTUpdateTeamUseCase)
            .andRoute(GET("/api/team/findall"), teamHandler::listenGETFindAllTeamsUseCase)
            .andRoute(GET("/api/team/findbyid/{id}"), teamHandler::listenGETFindTeamByIdUseCase);
    }
}
