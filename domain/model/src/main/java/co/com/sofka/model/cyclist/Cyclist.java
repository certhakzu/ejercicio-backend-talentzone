package co.com.sofka.model.cyclist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cyclist {
    private String id;
    private Name fullName;
    private Integer competitorNumber;
    private String idTeam;
    private String idCountry;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cyclist cyclist = (Cyclist) o;
        return id.equals(cyclist.id) && fullName.equals(cyclist.fullName) && competitorNumber.equals(cyclist.competitorNumber)
                && idTeam.equals(cyclist.idTeam) && idCountry.equals(cyclist.idCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, competitorNumber, idTeam, idCountry);
    }
}
