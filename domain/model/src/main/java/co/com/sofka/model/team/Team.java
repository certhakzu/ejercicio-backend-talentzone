package co.com.sofka.model.team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id.equals(team.id) && name.equals(team.name) && teamCode.equals(team.teamCode) && idCountry.equals(team.idCountry)
                && Objects.equals(idsCyclists, team.idsCyclists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, teamCode, idCountry, idsCyclists);
    }
}
