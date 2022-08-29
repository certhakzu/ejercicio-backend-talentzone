package co.com.sofka.model.country;
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
public class Country {
    private String id;
    private String name;
    private String code;
    private List<String> teams;
    private List<String> cyclists;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id.equals(country.id) && name.equals(country.name) && code.equals(country.code) && Objects.equals(teams, country.teams)
                && Objects.equals(cyclists, country.cyclists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, teams, cyclists);
    }
}
