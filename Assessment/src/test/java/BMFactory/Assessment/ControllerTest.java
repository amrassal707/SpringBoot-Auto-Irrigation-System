package BMFactory.Assessment;

import BMFactory.Assessment.Controller.LandController;
import BMFactory.Assessment.Model.LandPlot;
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


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ControllerTest {

    @Autowired
    private LandController landController;


    @Test
    public void contextLoads() throws Exception {
        assertThat(landController).isNotNull();
    }


}
