package Serialization.DataTranferObjects;

public class SysDto {
    private int type;
    private int id;
    private String country;
    private int sunrise;
    private int sunset;
    private String pod;

    public SysDto(int type, int id, String country, int sunrise, int sunset) {
        this.type = type;
        this.id = id;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public SysDto() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    @Override
    public String toString() {
        return "Sys " +
                "type=" + type +
                ", id=" + id +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", pod='" + pod + '\'';
    }

    public String toStringGUI() {
        return "";
    }

}
