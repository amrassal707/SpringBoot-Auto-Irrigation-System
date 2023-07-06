package BMFactory.Assessment.Service;

import org.springframework.stereotype.Service;

@FunctionalInterface
public interface IrrigationServiceInterface {

    String irrigateLand(Long id);
}
