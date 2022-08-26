package kr.co.metisinfo.pms_web_socket_middleware.Object;

import lombok.Data;

import java.util.List;

@Data
public class PcsStatusObject {
    public String operationStatus;
    public String chargingStatus;
    public String faultExistYn;
    public String disChargePower;
    public String rSVolt;
    public String upRCurr;
    public String dcLinkVolt;
    public String frequencyHz;
    public String sTVolt;
    public String upSCurr;
    public String dcBatteryVolt;
    public String tRVolt;
    public String upTCurr;
    public String dcBatteryCurr;
    public List<FaultListObject> faultList;
}
