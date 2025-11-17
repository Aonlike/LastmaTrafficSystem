package exceptions;

public class VehicleExistsException extends TrafficSystemException {
    public VehicleExistsException(String message) {
        super(message);
    }
}
