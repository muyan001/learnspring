package factory;

import bean.AirPlane;

public class AirPlaneInstanceFactory {
    /**
     *   实例工厂类
     */


    public  AirPlane getAirPlane(String jz) {

        System.out.println("实例工厂正在造飞机。。。。。");

        AirPlane airPlane = new AirPlane();
        airPlane.setColor("白色");
        airPlane.setFdj("太行");
        airPlane.setPrivice(1000000);
        airPlane.setSpeed(9999);
        airPlane.setJz(jz);
        return airPlane;

    }
}
