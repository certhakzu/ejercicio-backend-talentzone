package co.com.sofka.api.cyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.usecase.cyclist.createcyclist.CreateCyclistUseCase;
import co.com.sofka.usecase.cyclist.deletecyclist.DeleteCyclistUseCase;
import co.com.sofka.usecase.cyclist.findallcyclist.FindAllCyclistUseCase;
import co.com.sofka.usecase.cyclist.findcyclistbyid.FindCyclistByIdUseCase;
import co.com.sofka.usecase.cyclist.findcyclistsbycountryid.FindCyclistsByCountryIdUseCase;
import co.com.sofka.usecase.cyclist.findcyclistsbyteamid.FindCyclistsByTeamIdUseCase;
import co.com.sofka.usecase.cyclist.updatecyclist.UpdateCyclistUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CyclistHandler {

    private final CreateCyclistUseCase createCyclistUseCase;
    private final FindCyclistByIdUseCase findCyclistByIdUseCase;
    private final FindAllCyclistUseCase findAllCyclistUseCase;
    private final UpdateCyclistUseCase updateCyclistUseCase;
    private final DeleteCyclistUseCase deleteCyclistUseCase;
    private final FindCyclistsByTeamIdUseCase findCyclistsByTeamIdUseCase;
    private final FindCyclistsByCountryIdUseCase findCyclistsByCountryIdUseCase;


    public Mono<ServerResponse> listenPOSTCreateCyclistUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Cyclist.class)
                .flatMap(cyclist -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createCyclistUseCase.createCyclist(cyclist), Cyclist.class));

    }

    public Mono<ServerResponse> listenGETFindCyclistByIdUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findCyclistByIdUseCase.findCyclistById(id), Cyclist.class);
    }

    public Mono<ServerResponse> listenGETFindAllCyclistUseCase(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findAllCyclistUseCase.findAllCyclist(), Cyclist.class);
    }

    public Mono<ServerResponse>listenPUTUpdateCyclistUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Cyclist.class)
                .flatMap(cyclist -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateCyclistUseCase.updateCyclist(id, cyclist), Cyclist.class));
    }

    public Mono<ServerResponse> listenDELETEDeleteCyclistUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteCyclistUseCase.deleteCyclist(id), Cyclist.class);
    }

    public Mono<ServerResponse> listenGETFindCyclistsByTeamIdUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findCyclistsByTeamIdUseCase.findCyclistsByTeamId(id), Cyclist.class);
    }

    public Mono<ServerResponse> listenGETFindCyclistsByCountryIdUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findCyclistsByCountryIdUseCase.findCyclistsByCountryId(id), Cyclist.class);
    }
}
