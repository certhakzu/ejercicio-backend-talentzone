package co.com.sofka.mongo.country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;@Document

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CountryDocument {
    @Id
    private String id;
    private String name;
    private String code;
    private List<String> teams;
    private List<String> cyclists;
}
