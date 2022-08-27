package co.com.sofka.api;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.usecase.createcyclist.CreateCyclistUseCase;
import co.com.sofka.usecase.findcyclistbyid.FindCyclistByIdUseCase;
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
}
