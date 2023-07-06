package BMFactory.Assessment;

import BMFactory.Assessment.Controller.LandController;
import BMFactory.Assessment.Model.LandPlot;
import BMFactory.Assessment.Service.IrrigationServiceInterface;
import BMFactory.Assessment.Service.LandPlotServiceInterface;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IrrigationServiceTest {

    @Autowired
    IrrigationServiceInterface irrigationServiceInterface;

    @MockBean
    LandPlotServiceInterface landPlotServiceInterface;

    private LandPlot landPlot;

    @BeforeEach
    public void setup(){
        landPlot= new LandPlot(1L,5,3,
                Date.valueOf("2023-06-09"),
                5);
    }
    @Test
    public void checkIrrigationToFindLand(){
        irrigationServiceInterface.irrigateLand(1L);
        // checking to see if it finds the land to irrigate or not
        verify(landPlotServiceInterface,times(1)).findLandById(1L);

    }





}
