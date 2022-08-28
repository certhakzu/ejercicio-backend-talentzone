package co.com.sofka.model.team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private String id;
    private String name;
    private String teamCode;
    private String idCountry;
    private List<String> idsCyclists;
}
