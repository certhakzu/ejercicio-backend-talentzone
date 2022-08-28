package co.com.sofka.mongo.cyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CyclistMongoRepositoryAdapter extends AdapterOperations<Cyclist, CyclistDocument, String, CyclistMongoDBRepository>
implements CyclistRepository
{

    public CyclistMongoRepositoryAdapter(CyclistMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Cyclist.class));
    }

    @Override
    public Mono<Cyclist> update(String id, Cyclist cyclist) {
        return repository.save(new CyclistDocument(
                id,
                cyclist.getFullName(),
                cyclist.getCompetitorNumber(),
                cyclist.getIdTeam(),
                cyclist.getIdCountry()
        )).flatMap(cyclistDocument -> Mono.just(cyclist));
    }
}
