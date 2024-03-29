package Serialization.DataTranferObjects;

public class WindDto {
    private float speed;
    private int deg;

    private float gust;
    public WindDto(float speed, int deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public WindDto() {
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "Wind " +
                "speed=" + speed +
                ", deg=" + deg +
                ", gust=" + gust;
    }
}
