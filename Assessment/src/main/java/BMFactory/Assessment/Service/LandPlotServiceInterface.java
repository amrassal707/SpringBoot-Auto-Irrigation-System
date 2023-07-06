package BMFactory.Assessment.Service;

import BMFactory.Assessment.Model.LandPlot;

import java.util.List;
import java.util.Optional;

public interface LandPlotServiceInterface {

    LandPlot addLand(LandPlot landPlot);
    Optional<LandPlot> findLandById(Long id);
    List<LandPlot> readAllLands();
    String editLand(LandPlot landPlot,Long id);
    String deleteLandById(Long id);



}
