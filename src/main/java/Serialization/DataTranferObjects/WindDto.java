package Serialization.DataTranferObjects;

public class WindDto {
    private float speed;
    private int deg;

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
}
