package BMFactory.Assessment;

import BMFactory.Assessment.DAO.LandPlotRepository;
import BMFactory.Assessment.Model.LandPlot;
import BMFactory.Assessment.Service.LandPlotServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class) //tells JUnit to run using Spring's testing support. SpringRunner is the new name for SpringJUnit4ClassRunner
// it's useful because it tells JUnit to run using Spring's testing support.
class LandPlotServiceTest {

	@Autowired
	LandPlotServiceInterface landPlotServiceInterface;

	@MockBean
	LandPlotRepository landPlotRepository;

	private LandPlot landPlot;

	@BeforeEach
	public void setup(){
		 landPlot= new LandPlot(1L,5,3,
				Date.valueOf("2023-06-09"),
				5);
	}

	@Test
	void readAllDataBack() {
		// when function is called , then it mocks the DB by returning the data in "thenReturn"
		when(landPlotRepository.findAll())
				.thenReturn(Stream.of(landPlot).toList());

		// we expect one landplot to be saved so we compare the sizes to see if that happened
		assertEquals(1,landPlotServiceInterface.readAllLands().size());
	}

	@Test
	void saveLandPlot(){
		when(landPlotRepository.save(landPlot)).thenReturn(landPlot);
		// when the Repo is called to save a specific it's expected to return the Land that it saved into the DB
		assertEquals(landPlot,landPlotServiceInterface.addLand(landPlot));
		// we compare what we saved using THE REPO to our service if it's implementing the REPO correctly
	}







}
