package BMFactory.Assessment.Scheduler;

import BMFactory.Assessment.Model.LandPlot;
import BMFactory.Assessment.Service.IrrigationServiceInterface;
import BMFactory.Assessment.Service.LandPlotServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;



import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@RequiredArgsConstructor // injecting the services using this annotation
@Component
public class SchedulerMain {
    private final LandPlotServiceInterface landPlotServiceInterface;
    private final IrrigationServiceInterface irrigationServiceInterface;

    @Scheduled(cron ="0 0 8 * * ?") // it means the system will run the irrigation every day at 8AM
    public void irrigateLands() {
        List<LandPlot> landPlotList= landPlotServiceInterface.readAllLands();
        for(LandPlot landPlot : landPlotList) {
            irrigationServiceInterface.irrigateLand(landPlot.getId());
        }
        System.out.println("Scheduler has went through all lands and checked all for today " + LocalDate.now());
    }

}
