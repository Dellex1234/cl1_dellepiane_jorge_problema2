package pe.edu.I202330006.cl1_jpa_data_dellepiane_jorge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class countrylanguage {

    @Id
    private String CountryCode;
    private String Language;
    private String IsOfficial;
    private Double Percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private country country;

}
