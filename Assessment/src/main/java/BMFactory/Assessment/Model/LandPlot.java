package BMFactory.Assessment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity // by using this annotation JPA will detect this class as an entity
@Table(name = "land_plot")// if not provided , jpa will create a table with the same name of the entity
@Data // @Data has all the basic getters and setters
@AllArgsConstructor
@NoArgsConstructor
public class LandPlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //// letting JPA know that SQL will handle id creation
    private Long id;
    private float length;

    private float breadth;

    @Column(name = "time_slot") // allow sql to create a column with the specific name
    private Date timeSlot;

    @Column(name = "amount_of_water")
    private float amountOfWater;



}
