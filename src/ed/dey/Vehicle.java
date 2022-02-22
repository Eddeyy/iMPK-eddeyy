package ed.dey;

import java.util.LinkedList;

public class Vehicle {

    public static LinkedList<Vehicle> vList = new LinkedList<>();
    enum vehicleType{
        UNKNOWN,
        BUS,
        TRAM
    }

    private vehicleType vType;
    private String vName;

    private float fPosX;
    private float fPosY;

    private int ID;

    public Vehicle(vehicleType t, String n, float x, float y, int id){
        vType = t;
        vName = n;
        ID = id;

        updatePos(x,y);
    }

    public void updatePos(float newX, float newY){
        fPosX = newX;
        fPosY = newY;
    }




//=======GETTERS=============
    public float getfPosX() {
        return fPosX;
    }

    public float getfPosY() {
        return fPosY;
    }

    public String getvName() {
        return vName;
    }

    public vehicleType getvType() {
        return vType;
    }
}
