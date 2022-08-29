package kr.co.metisinfo.pms_web_socket_middleware.Object;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class SensorStatusObject {
    public String pmsCode;
    public String essCode;
    public String deviceCode;
    public String deviceName;
    public String faultExistYn;
    public String measures;
    public String regDate = String.valueOf(Instant.now().getEpochSecond());
}
