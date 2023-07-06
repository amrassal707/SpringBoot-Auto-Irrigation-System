package BMFactory.Assessment.Service;

import BMFactory.Assessment.Model.LandPlot;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;


@Service
@Data
public class IrrigationServiceImpl implements IrrigationServiceInterface{
    private final LandPlotServiceInterface landPlotServiceInterface;
    @Override
    public String irrigateLand(Long id) {
        if(landPlotServiceInterface.findLandById(id).isPresent()) {
            LandPlot landPlot= landPlotServiceInterface.findLandById(id).get();
                if (Date.valueOf(LocalDate.now()).equals(landPlot.getTimeSlot())) {
                    LocalDate todayDate = landPlot.getTimeSlot().toLocalDate();
                    LocalDate Date= todayDate.plusDays(1);
                    landPlot.setTimeSlot( java.sql.Date.valueOf(Date));
                    landPlotServiceInterface.editLand(landPlot,id);

                    System.out.println("land with id "+ landPlot.getId() +" irrigated successfully"); // to show in console
                    return "land with id "+ landPlot.getId() +" irrigated successfully"; // to show on client side
                } else {
                    // to show in console
                    System.out.println("land with id : " + landPlot.getId() + " already irrigated or the date of land to get irrigated has not yet come");
                    // to show on client side
                    return "land already irrigated or the date of land to get irrigated has not yet come";
                }
        }
        else
            return "land not found please check your id again";
    }
}
