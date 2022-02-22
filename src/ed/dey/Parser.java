package ed.dey;

import java.util.LinkedList;

public class Parser {

    public static void parseData(String busPosInfo){

        LinkedList<String> vehicleData = new LinkedList<>();

        while(busPosInfo.length() > 2){
            vehicleData.add(busPosInfo.substring(busPosInfo.indexOf("{")+1, busPosInfo.indexOf("}")));

            busPosInfo = busPosInfo.substring(busPosInfo.indexOf("}")+2);
        }

        addVehicles(vehicleData);

        for(var v : vehicleData){
            System.out.println(v);
        }
    }


    private static void addVehicles(LinkedList<String> vDataList){
        Vehicle.vehicleType vType;
        String vName;
        float fPosX;
        float fPosY;
        int ID;

        for(var d : vDataList){
            String typeSubstring = d.substring(d.indexOf("type\":"), d.indexOf("\"",d.indexOf("type\":")+7));
            if(typeSubstring.contains("bus"))
                vType = Vehicle.vehicleType.BUS;
            else if(typeSubstring.contains("tram"))
                vType = Vehicle.vehicleType.TRAM;
            else
                vType = Vehicle.vehicleType.UNKNOWN;

            vName = d.substring(d.indexOf("name\":")+7,d.indexOf("\"",d.indexOf("name\":")+7));

            fPosX = Float.parseFloat(d.substring(d.indexOf("x\":")+3,d.indexOf(",",d.indexOf("x\":")+3)));

            fPosY = Float.parseFloat(d.substring(d.indexOf("y\":")+3,d.indexOf(",",d.indexOf("y\":")+3)));

            ID = Integer.parseInt(d.substring(d.indexOf("k\":")+3));

            Vehicle.vList.add(new Vehicle(vType,vName,fPosX,fPosY,ID));
        }
    }
}


