package BMFactory.Assessment.DAO;

import BMFactory.Assessment.Model.LandPlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandPlotRepository extends JpaRepository<LandPlot,Long> {

    // we extend to jpaRepo that will give us all CRUD operations for free
}
