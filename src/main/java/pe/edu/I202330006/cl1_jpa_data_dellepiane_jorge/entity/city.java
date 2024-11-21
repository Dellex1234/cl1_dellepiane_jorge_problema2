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
public class city {

    @Id
    private int ID;
    private String Name;
    private String CountryCode;
    private String District;
    private int Population;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private country country;

}
