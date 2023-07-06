package BMFactory.Assessment.Service;

import BMFactory.Assessment.DAO.LandPlotRepository;
import BMFactory.Assessment.Model.LandPlot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class LandPlotServiceImpl implements LandPlotServiceInterface {

    private final LandPlotRepository landPlotRepository;


    @Override
    public LandPlot addLand(LandPlot landPlot) {
        return landPlotRepository.save(landPlot);
    }

    @Override
    public List<LandPlot> readAllLands() {
        return landPlotRepository.findAll();
    }

    @Override
    public String editLand(LandPlot landPlot, Long id) {
        //since JPA repo is smart enough to detect an update is happening and just use save and call the save functions

        if(!landPlotRepository.findById(id).isPresent()) {
            return "Land not found please check again";
        }
        else {
            landPlotRepository.save(landPlot);
            return "land updated successfully";
        }
    }

    @Override
    public String deleteLandById(Long id) {
        if(landPlotRepository.findById(id).isPresent()){
            landPlotRepository.deleteById(id);
            return "land deleted successfully";
        }
        else
            return "can't find plot please check the id";
    }


    @Override
    public Optional<LandPlot> findLandById(Long id) {
        if (landPlotRepository.findById(id).isPresent()) {
            return landPlotRepository.findById(id);

        } else
            return Optional.empty();
    }
}
