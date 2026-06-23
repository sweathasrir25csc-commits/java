import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day15_exercise{
    enum RouteType {
        CITY, SUBURBAN, EXPRESS
    }

    enum PassType {
        MONTHLY, SEMESTER, SPECIAL
    }

    enum PassStatus {
        ACTIVE, EXPIRED, SUSPENDED, CANCELLED
    }

    record Commuter(String studentId, String name, String department, String pickupStop) {
    }

    static class Route {
        private final String routeId;
        private final RouteType routeType;
        private final int capacity;
        private final List<String> stops = new ArrayList<>();

        Route(String routeId, RouteType routeType, int capacity, List<String> stops) {
            this.routeId = routeId;
            this.routeType = routeType;
            this.capacity = capacity;
            this.stops.addAll(stops);
        }

        String getRouteId() {
            return routeId;
        }

        RouteType getRouteType() {
            return routeType;
        }

        int getCapacity() {
            return capacity;
        }

        List<String> getStops() {
            return stops;
        }
    }

    static class TransportPass {
        private final String passId;
        private final String studentId;
        private final String routeId;
        private final PassType passType;
        private PassStatus status;

        TransportPass(String passId, String studentId, String routeId, PassType passType) {
            this.passId = passId;
            this.studentId = studentId;
            this.routeId = routeId;
            this.passType = passType;
            this.status = PassStatus.ACTIVE;
        }

        String getPassId() {
            return passId;
        }

        String getStudentId() {
            return studentId;
        }

        String getRouteId() {
            return routeId;
        }

        PassType getPassType() {
            return passType;
        }

        PassStatus getStatus() {
            return status;
        }

        void setStatus(PassStatus status) {
            this.status = status;
        }
    }

    static class InvalidTransportOperationException extends RuntimeException {
        InvalidTransportOperationException(String message) {
            super(message);
        }
    }

    static class TransportManager {
        private final Map<String, Route> routesById = new HashMap<>();
        private final Map<String, Commuter> commutersById = new HashMap<>();
        private final Map<String, TransportPass> passesById = new HashMap<>();

        void addRoute(Route route) {
            if (routesById.containsKey(route.getRouteId())) {
                throw new InvalidTransportOperationException("Duplicate route ID: " + route.getRouteId());
            }
            if (route.getCapacity() <= 0) {
                throw new InvalidTransportOperationException("Route capacity must be positive");
            }
            if (route.getStops().isEmpty()) {
                throw new InvalidTransportOperationException("Route must contain at least one stop");
            }
            routesById.put(route.getRouteId(), route);
        }

        void addCommuter(Commuter commuter) {
            if (commutersById.containsKey(commuter.studentId())) {
                throw new InvalidTransportOperationException("Duplicate student ID: " + commuter.studentId());
            }
            commutersById.put(commuter.studentId(), commuter);
        }

        void issuePass(TransportPass pass) {
            if (passesById.containsKey(pass.getPassId())) {
                throw new InvalidTransportOperationException("Duplicate pass ID: " + pass.getPassId());
            }

            Commuter commuter = commutersById.get(pass.getStudentId());
            if (commuter == null) {
                throw new InvalidTransportOperationException("Student not found: " + pass.getStudentId());
            }

            Route route = routesById.get(pass.getRouteId());
            if (route == null) {
                throw new InvalidTransportOperationException("Route not found: " + pass.getRouteId());
            }

            boolean stopExists = route.getStops().stream()
                    .anyMatch(stop -> stop.equalsIgnoreCase(commuter.pickupStop()));
            if (!stopExists) {
                throw new InvalidTransportOperationException("Pickup stop not available on selected route");
            }

            boolean alreadyHasActivePass = passesById.values().stream()
                    .anyMatch(existing -> existing.getStudentId().equals(pass.getStudentId())
                            && existing.getStatus() == PassStatus.ACTIVE);
            if (alreadyHasActivePass) {
                throw new InvalidTransportOperationException("Student already has an active pass");
            }

            long activePassengersOnRoute = passesById.values().stream()
                    .filter(existing -> existing.getRouteId().equals(pass.getRouteId()))
                    .filter(existing -> existing.getStatus() == PassStatus.ACTIVE)
                    .count();
            if (activePassengersOnRoute >= route.getCapacity()) {
                throw new InvalidTransportOperationException("Route is already full");
            }

            passesById.put(pass.getPassId(), pass);
        }

        void suspendPass(String passId) {
            TransportPass pass = getPassOrThrow(passId);
            if (pass.getStatus() != PassStatus.ACTIVE) {
                throw new InvalidTransportOperationException("Only active passes can be suspended");
            }
            pass.setStatus(PassStatus.SUSPENDED);
        }

        void cancelPass(String passId) {
            TransportPass pass = getPassOrThrow(passId);
            if (pass.getStatus() == PassStatus.CANCELLED) {
                throw new InvalidTransportOperationException("Pass is already cancelled");
            }
            pass.setStatus(PassStatus.CANCELLED);
        }

        void expirePass(String passId) {
            TransportPass pass = getPassOrThrow(passId);
            if (pass.getStatus() != PassStatus.ACTIVE) {
                throw new InvalidTransportOperationException("Only active passes can be expired");
            }
            pass.setStatus(PassStatus.EXPIRED);
        }

        List<Route> findFullRoutes() {
            return routesById.values().stream()
                    .filter(route -> activeCountForRoute(route.getRouteId()) >= route.getCapacity())
                    .sorted(Comparator.comparing(Route::getRouteId))
                    .toList();
        }

        Map<PassStatus, Long> countPassesByStatus() {
            Map<PassStatus, Long> counts = passesById.values().stream()
                    .collect(Collectors.groupingBy(TransportPass::getStatus, LinkedHashMap::new, Collectors.counting()));

            for (PassStatus status : PassStatus.values()) {
                counts.putIfAbsent(status, 0L);
            }
            return counts;
        }

        Map<String, Long> routeOccupancyReport() {
            return routesById.values().stream()
                    .sorted(Comparator.comparing(Route::getRouteId))
                    .collect(Collectors.toMap(
                            Route::getRouteId,
                            route -> activeCountForRoute(route.getRouteId()),
                            (left, right) -> left,
                            LinkedHashMap::new
                    ));
        }

        void saveData(Path directory) throws IOException {
            Files.createDirectories(directory);

            List<String> routeLines = new ArrayList<>();
            for (Route route : routesById.values()) {
                routeLines.add(route.getRouteId() + "," + route.getRouteType() + "," + route.getCapacity()
                        + "," + String.join(">", route.getStops()));
            }
            Files.write(directory.resolve("routes.csv"), routeLines);

            List<String> commuterLines = commutersById.values().stream()
                    .map(commuter -> commuter.studentId() + "," + commuter.name() + "," + commuter.department()
                            + "," + commuter.pickupStop())
                    .toList();
            Files.write(directory.resolve("commuters.csv"), commuterLines);

            List<String> passLines = passesById.values().stream()
                    .map(pass -> pass.getPassId() + "," + pass.getStudentId() + "," + pass.getRouteId()
                            + "," + pass.getPassType() + "," + pass.getStatus())
                    .toList();
            Files.write(directory.resolve("passes.csv"), passLines);
        }

        void loadData(Path directory) throws IOException {
            routesById.clear();
            commutersById.clear();
            passesById.clear();

            Path routesFile = directory.resolve("routes.csv");
            if (Files.exists(routesFile)) {
                for (String line : Files.readAllLines(routesFile)) {
                    String[] parts = line.split(",", 4);
                    if (parts.length != 4) {
                        continue;
                    }
                    List<String> stops = List.of(parts[3].split(">"));
                    addRoute(new Route(parts[0], RouteType.valueOf(parts[1]), Integer.parseInt(parts[2]), stops));
                }
            }

            Path commutersFile = directory.resolve("commuters.csv");
            if (Files.exists(commutersFile)) {
                for (String line : Files.readAllLines(commutersFile)) {
                    String[] parts = line.split(",", 4);
                    if (parts.length != 4) {
                        continue;
                    }
                    addCommuter(new Commuter(parts[0], parts[1], parts[2], parts[3]));
                }
            }

            Path passesFile = directory.resolve("passes.csv");
            if (Files.exists(passesFile)) {
                for (String line : Files.readAllLines(passesFile)) {
                    String[] parts = line.split(",", 5);
                    if (parts.length != 5) {
                        continue;
                    }
                    TransportPass pass = new TransportPass(parts[0], parts[1], parts[2], PassType.valueOf(parts[3]));
                    pass.setStatus(PassStatus.valueOf(parts[4]));
                    passesById.put(pass.getPassId(), pass);
                }
            }
        }

        private TransportPass getPassOrThrow(String passId) {
            TransportPass pass = passesById.get(passId);
            if (pass == null) {
                throw new InvalidTransportOperationException("Pass not found: " + passId);
            }
            return pass;
        }

        private long activeCountForRoute(String routeId) {
            return passesById.values().stream()
                    .filter(pass -> pass.getRouteId().equals(routeId))
                    .filter(pass -> pass.getStatus() == PassStatus.ACTIVE)
                    .count();
        }
    }

    public static void main(String[] args) throws Exception {
        TransportManager manager = new TransportManager();

        manager.addRoute(new Route("R101", RouteType.CITY, 2, List.of("Main Gate", "Market", "Railway Station")));
        manager.addRoute(new Route("R202", RouteType.EXPRESS, 3, List.of("Main Gate", "Bypass", "Airport Road")));

        manager.addCommuter(new Commuter("S001", "Asha", "CSE", "Market"));
        manager.addCommuter(new Commuter("S002", "Bharath", "ECE", "Railway Station"));
        manager.addCommuter(new Commuter("S003", "Charan", "EEE", "Bypass"));

        manager.issuePass(new TransportPass("P001", "S001", "R101", PassType.MONTHLY));
        manager.issuePass(new TransportPass("P002", "S002", "R101", PassType.SEMESTER));
        manager.issuePass(new TransportPass("P003", "S003", "R202", PassType.MONTHLY));

        manager.suspendPass("P003");
        manager.expirePass("P002");

        System.out.println("Route occupancy report:");
        manager.routeOccupancyReport().forEach((routeId, occupancy) ->
                System.out.println(routeId + " -> " + occupancy));

        System.out.println("\nPass count by status:");
        manager.countPassesByStatus().forEach((status, count) ->
                System.out.println(status + " -> " + count));

        System.out.println("\nFull routes:");
        for (Route route : manager.findFullRoutes()) {
            System.out.println(route.getRouteId() + " (" + route.getRouteType() + ")");
        }

        Path outputDir = Path.of("capstone", "generated_transport_data");
        manager.saveData(outputDir);

        TransportManager reloaded = new TransportManager();
        reloaded.loadData(outputDir);

        System.out.println("\nReloaded route occupancy report:");
        reloaded.routeOccupancyReport().forEach((routeId, occupancy) ->
                System.out.println(routeId + " -> " + occupancy));
    }
}
