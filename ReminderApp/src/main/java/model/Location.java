package model;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "location_address")
    private String locationAddress;

    @Column(name = "location_latitude")
    private float locationLatitude;

    @Column(name = "location_longitude")
    private float locationLongitude;

    public Location() {
    }

    public Location(int locationId, String locationName, String locationAddress, float locationLatitude, float locationLongitude) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationAddress = locationAddress;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", locationAddress='" + locationAddress + '\'' +
                ", locationLatitude=" + locationLatitude +
                ", locationLongitude=" + locationLongitude +
                '}';
    }

    public int getLocationId() {
        return locationId;
    }

    public Location setLocationId(int locationId) {
        this.locationId = locationId;
        return this;
    }

    public String getLocationName() {
        return locationName;
    }

    public Location setLocationName(String locationName) {
        this.locationName = locationName;
        return this;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public Location setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
        return this;
    }

    public float getLocationLatitude() {
        return locationLatitude;
    }

    public Location setLocationLatitude(float locationLatitude) {
        this.locationLatitude = locationLatitude;
        return this;
    }

    public float getLocationLongitude() {
        return locationLongitude;
    }

    public Location setLocationLongitude(float locationLongitude) {
        this.locationLongitude = locationLongitude;
        return this;
    }
}
