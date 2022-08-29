package co.com.sofka.mongo.team;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class TeamMongoRepositoryAdapter extends AdapterOperations<Team, TeamDocument, String, TeamMongoDBRepository>
implements TeamRepository
{

    public TeamMongoRepositoryAdapter(TeamMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Team.class));
    }

    @Override
    public Mono<Team> update(String id, Team team) {
        return repository.save(new TeamDocument(
                id,
                team.getName(),
                team.getTeamCode(),
                team.getIdCountry(),
                team.getIdsCyclists()
        )).flatMap(teamDocument -> Mono.just(team));
    }
}
