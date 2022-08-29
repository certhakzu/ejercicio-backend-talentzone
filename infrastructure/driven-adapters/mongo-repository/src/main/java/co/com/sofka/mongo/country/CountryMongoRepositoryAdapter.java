package co.com.sofka.mongo.country;

import co.com.sofka.model.country.Country;
import co.com.sofka.model.country.gateways.CountryRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CountryMongoRepositoryAdapter extends AdapterOperations<Country, CountryDocument, String, CountryMongoDBRepository>
implements CountryRepository
{

    public CountryMongoRepositoryAdapter(CountryMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Country.class));
    }

    @Override
    public Mono<Country> update(String id, Country country) {
        return repository.save(new CountryDocument(
                id,
                country.getName(),
                country.getCode(),
                country.getTeams(),
                country.getCyclists()
        )).flatMap(countryDocument -> Mono.just(country));
    }
}
