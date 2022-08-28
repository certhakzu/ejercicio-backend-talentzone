package co.com.sofka.mongo.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TeamDocument {
    @Id
    private String id;
    private String name;
    private String teamCode;
    private String idCountry;
    private List<String> idsCyclists;
}
