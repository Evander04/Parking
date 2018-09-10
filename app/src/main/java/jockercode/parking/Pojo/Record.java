package jockercode.parking.Pojo;

import java.util.Date;

public class Record {
    private Long _id;
    private String name;
    private String licensePlate;
    private int type;// 0:moto, 1:carro, 3:camioneta, 4:camión
    private boolean status;
    private Date dateEntry;
    private Date dateDeparture;
    private String user;

    public Record() {
    }

    public Record(Long _id, String name, String licensePlate, int type, boolean status, Date dateEntry, Date dateDeparture, String user) {
        this._id = _id;
        this.name = name;
        this.licensePlate = licensePlate;
        this.type = type;
        this.status = status;
        this.dateEntry = dateEntry;
        this.dateDeparture = dateDeparture;
        this.user = user;
    }

    public Record(String name, String licensePlate, int type, boolean status, Date dateEntry, Date dateDeparture, String user) {
        this.name = name;
        this.licensePlate = licensePlate;
        this.type = type;
        this.status = status;
        this.dateEntry = dateEntry;
        this.dateDeparture = dateDeparture;
        this.user = user;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Date dateEntry) {
        this.dateEntry = dateEntry;
    }

    public Date getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Record{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", dateEntry=" + dateEntry +
                ", dateDeparture=" + dateDeparture +
                ", user='" + user + '\'' +
                '}';
    }
}