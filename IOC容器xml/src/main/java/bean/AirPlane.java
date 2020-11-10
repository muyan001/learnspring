package bean;

public class AirPlane {

    private Integer privice;
    private String color;
    private Integer speed;
    private String jz; //机长
    private String fdj; //发动机

    @Override
    public String toString() {
        return "bean.AirPlane{" +
                "privice=" + privice +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                ", jz='" + jz + '\'' +
                ", fdj='" + fdj + '\'' +
                '}';
    }

    public Integer getPrivice() {
        return privice;
    }

    public void setPrivice(Integer privice) {
        this.privice = privice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getJz() {
        return jz;
    }

    public void setJz(String jz) {
        this.jz = jz;
    }

    public String getFdj() {
        return fdj;
    }

    public void setFdj(String fdj) {
        this.fdj = fdj;
    }

}
