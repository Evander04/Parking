package jockercode.parking.Pojo;

import java.util.Date;

public class Record {
    private Long _id;
    private String description;
    private String licensePlate;
    private int type;// 1:moto, 2:carro, 3:camioneta, 4:camión
    private int count;
    private int status;
    private Date dateEntry;//0:entrada, 1:salida
    private Date dateDeparture;
    private String user;

    public Record() {
    }


    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Record{" +
                "_id=" + _id +
                ", description='" + description + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", type=" + type +
                ", count=" + count +
                ", status=" + status +
                ", dateEntry=" + dateEntry +
                ", dateDeparture=" + dateDeparture +
                ", user='" + user + '\'' +
                '}';
    }
}