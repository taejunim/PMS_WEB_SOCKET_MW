package kr.co.metisinfo.pms_web_socket_middleware.Object;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class BatteryStatusObject {
    public String rackNo;
    public String chargingStatus;
    public String soc;
    public String rackVolt;
    public String rackCurrent;
    public String faultExistYn;
    public String currentSensor1;
    public String currentSensor2;
    public String currentLimit;
    public List<FaultListObject> faultList;
    public String regDate;
}
