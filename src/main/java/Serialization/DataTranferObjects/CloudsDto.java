package Serialization.DataTranferObjects;

public class CloudsDto {
    private int all;

    public CloudsDto(int all) {
        this.all = all;
    }

    public CloudsDto() {
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "Clouds "  + all;
    }
}
