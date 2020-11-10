package factory;

import bean.AirPlane;

public class AirplaneStaticFactory {

    /**
     *  静态工厂类
     */


    public static AirPlane getAirPlane(String jz) {



        System.out.println("静态工厂正在造飞机。。。。。。");

        AirPlane airPlane = new AirPlane();
        airPlane.setColor("白色");
        airPlane.setFdj("太行");
        airPlane.setPrivice(1000000);
        airPlane.setSpeed(9999);
        airPlane.setJz(jz);
        return airPlane;

    }
}
