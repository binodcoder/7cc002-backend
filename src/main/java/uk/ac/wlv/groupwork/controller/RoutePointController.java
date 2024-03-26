package uk.ac.wlv.groupwork.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.RoutePoint;
import uk.ac.wlv.groupwork.service.RoutePointService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/route-points")
public class RoutePointController {

    private final RoutePointService routePointService;

    public RoutePointController(RoutePointService routePointService) {
        this.routePointService = routePointService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllRoutePoints() {
        List<RoutePoint> routePoints = routePointService.getAllRoutePoints();
        if (routePoints.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(routePoints);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRoutePointById(@PathVariable int id) {
        Optional<RoutePoint> routePoint = routePointService.getRoutePointById(id);
        if (routePoint.isPresent()) {
            return ResponseEntity.ok(routePoint.get());
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Route Point with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addRoutePoint(@RequestBody RoutePoint routePoint) {
        RoutePoint addedRoutePoint = routePointService.addRoutePoint(routePoint);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedRoutePoint);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRoutePoint(@PathVariable int id, @RequestBody RoutePoint routePoint) {
        if (!routePointService.getRoutePointById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Route Point with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        routePoint.setId(id);
        RoutePoint updatedRoutePoint = routePointService.updateRoutePoint(routePoint);
        return ResponseEntity.ok(updatedRoutePoint);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoutePointById(@PathVariable int id) {
        if (!routePointService.getRoutePointById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Route Point with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        routePointService.deleteRoutePointById(id);
        return ResponseEntity.ok().build();
    }
}
