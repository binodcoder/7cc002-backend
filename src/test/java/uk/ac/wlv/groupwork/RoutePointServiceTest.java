package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.ac.wlv.groupwork.dao.RoutePointRepository;
import uk.ac.wlv.groupwork.model.RoutePoint;
import uk.ac.wlv.groupwork.service.RoutePointService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RoutePointServiceTest {

    @Test
    void testAddRoutePoint() {
        // Mock dependencies
        RoutePointRepository routePointRepository = Mockito.mock(RoutePointRepository.class);
        RoutePointService routePointService = new RoutePointService(routePointRepository);

        // Create sample data
        RoutePoint routePoint = new RoutePoint();
        RoutePoint savedRoutePoint = new RoutePoint();

        // Stub the repository method
        when(routePointRepository.save(routePoint)).thenReturn(savedRoutePoint);

        // Call the service method
        RoutePoint result = routePointService.addRoutePoint(routePoint);

        // Verify the repository method is called
        verify(routePointRepository).save(routePoint);

        // Assert the result
        assertEquals(savedRoutePoint, result);
    }

    @Test
    void testGetAllRoutePoints() {
        // Mock dependencies
        RoutePointRepository routePointRepository = Mockito.mock(RoutePointRepository.class);
        RoutePointService routePointService = new RoutePointService(routePointRepository);

        // Create sample data
        List<RoutePoint> expectedRoutePoints = new ArrayList<>();
        expectedRoutePoints.add(new RoutePoint());
        expectedRoutePoints.add(new RoutePoint());

        // Stub the repository method
        when(routePointRepository.findAll()).thenReturn(expectedRoutePoints);

        // Call the service method
        List<RoutePoint> result = routePointService.getAllRoutePoints();

        // Verify the repository method is called
        verify(routePointRepository).findAll();

        // Assert the result
        assertEquals(expectedRoutePoints, result);
    }

    @Test
    void testGetRoutePointById() {
        // Mock dependencies
        RoutePointRepository routePointRepository = Mockito.mock(RoutePointRepository.class);
        RoutePointService routePointService = new RoutePointService(routePointRepository);

        // Create sample data
        int routePointId = 1;
        Optional<RoutePoint> expectedRoutePoint = Optional.of(new RoutePoint());

        // Stub the repository method
        when(routePointRepository.findById(eq(routePointId))).thenReturn(expectedRoutePoint);

        // Call the service method
        Optional<RoutePoint> result = routePointService.getRoutePointById(routePointId);

        // Verify the repository method is called
        verify(routePointRepository).findById(eq(routePointId));

        // Assert the result
        assertEquals(expectedRoutePoint, result);
    }

    @Test
    void testUpdateRoutePoint() {
        // Mock dependencies
        RoutePointRepository routePointRepository = Mockito.mock(RoutePointRepository.class);
        RoutePointService routePointService = new RoutePointService(routePointRepository);

        // Create sample data
        RoutePoint routePoint = new RoutePoint();
        RoutePoint updatedRoutePoint = new RoutePoint();

        // Stub the repository method
        when(routePointRepository.save(routePoint)).thenReturn(updatedRoutePoint);

        // Call the service method
        RoutePoint result = routePointService.updateRoutePoint(routePoint);

        // Verify the repository method is called
        verify(routePointRepository).save(routePoint);

        // Assert the result
        assertEquals(updatedRoutePoint, result);
    }

    @Test
    void testDeleteRoutePointById() {
        // Mock dependencies
        RoutePointRepository routePointRepository = Mockito.mock(RoutePointRepository.class);
        RoutePointService routePointService = new RoutePointService(routePointRepository);

        // Create sample data
        int routePointId = 1;

        // Call the service method
        routePointService.deleteRoutePointById(routePointId);

        // Verify the repository method is called
        verify(routePointRepository).deleteById(eq(routePointId));
    }
}
