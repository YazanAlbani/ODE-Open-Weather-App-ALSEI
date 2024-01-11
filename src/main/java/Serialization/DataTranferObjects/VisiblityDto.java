package Serialization.DataTranferObjects;

public class VisiblityDto {
    private int visibility;

    public VisiblityDto(int visibility) {
        this.visibility = visibility;
    }

    public VisiblityDto() {
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
}
