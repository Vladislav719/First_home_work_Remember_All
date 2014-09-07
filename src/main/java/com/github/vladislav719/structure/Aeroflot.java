package com.github.vladislav719.structure;

/**
 * Created by vladislav on 07.09.14.
 */
public class Aeroflot {

    private AircraftTypes type;
    private Integer flightNumber;
    private String destination;
    private String departure;

    public Aeroflot(){

    }

    public AircraftTypes getType() {
        return type;
    }

    public void setType(AircraftTypes type) {
        this.type = type;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aeroflot{");
        sb.append("Тип судна: ").append(AircraftTypes.getDisplayNames(type));
        sb.append(", Номер рейса: ").append(flightNumber);
        sb.append(", Куда: '").append(destination).append('\'');
        sb.append(", Откуда:'").append(departure).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
