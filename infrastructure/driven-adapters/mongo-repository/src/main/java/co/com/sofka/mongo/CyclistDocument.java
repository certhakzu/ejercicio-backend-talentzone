package co.com.sofka.mongo;

import co.com.sofka.model.cyclist.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CyclistDocument {
    @Id
    private String id;
    private Name fullName;
    private Integer competitorNumber;
    private String idTeam;
    private String idCountry;
}
