package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.RoutePointRepository;
import uk.ac.wlv.groupwork.model.RoutePoint;

import java.util.List;
import java.util.Optional;

@Service
public class RoutePointService {

    private final RoutePointRepository routePointRepository;

    public RoutePointService(RoutePointRepository routePointRepository) {
        this.routePointRepository = routePointRepository;
    }

    public RoutePoint addRoutePoint(RoutePoint routePoint) {
        return routePointRepository.save(routePoint);
    }

    public List<RoutePoint> getAllRoutePoints() {
        return routePointRepository.findAll();
    }

    public Optional<RoutePoint> getRoutePointById(int id) {
        return routePointRepository.findById(id);
    }

    public RoutePoint updateRoutePoint(RoutePoint routePoint) {
        return routePointRepository.save(routePoint);
    }

    public void deleteRoutePointById(int id) {
        routePointRepository.deleteById(id);
    }

}
