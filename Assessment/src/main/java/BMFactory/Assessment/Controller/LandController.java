package BMFactory.Assessment.Controller;

import BMFactory.Assessment.Model.LandPlot;
import BMFactory.Assessment.Service.IrrigationServiceInterface;
import BMFactory.Assessment.Service.LandPlotServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LandController {

    private final LandPlotServiceInterface landPlotServiceInterface;
    private final IrrigationServiceInterface irrigationServiceInterface;
    //No need for @AutoWired since we only have one implementation for each service and one constructor needed
    // so we use @RequiredArgsConstructor Annotation
    @GetMapping("/readall")
    public List<LandPlot> readAll(){
        return landPlotServiceInterface.readAllLands();
    }

    @GetMapping("/read/{id}")
    public Optional<LandPlot> findLandById(@PathVariable Long id) {
        return landPlotServiceInterface.findLandById(id);
    }

    @PostMapping("/addplot")
    public LandPlot addPlot(@RequestBody LandPlot landPlot){
        return landPlotServiceInterface.addLand(landPlot);

    }


    @DeleteMapping("/deleteplot/{id}")
    public String deletePlot(@PathVariable Long id) {
       return landPlotServiceInterface.deleteLandById(id);

    }
    @PutMapping("/updateplot/{id}")
    public String updatePlot(@RequestBody LandPlot landPlot, @PathVariable Long id) {
        return landPlotServiceInterface.editLand(landPlot,id);
    }


    @PutMapping("/irrigate/{id}")
    public String irrigateLand(@PathVariable Long id) {
        return irrigationServiceInterface.irrigateLand(id);
    }



}
