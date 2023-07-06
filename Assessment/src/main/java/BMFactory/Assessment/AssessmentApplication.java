package BMFactory.Assessment;

import BMFactory.Assessment.Controller.LandController;
import BMFactory.Assessment.DAO.LandPlotRepository;
import BMFactory.Assessment.Scheduler.SchedulerMain;
import BMFactory.Assessment.Service.LandPlotServiceImpl;
import BMFactory.Assessment.Service.LandPlotServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Timer;

@SpringBootApplication
@RequiredArgsConstructor
//@EnableScheduling
public class AssessmentApplication {

	public final SchedulerMain schedulerMain;

	public static void main(String[] args) {

		SpringApplication.run(AssessmentApplication.class, args);

	}

}
