package kr.co.metisinfo.pms_web_socket_middleware.Object;

import lombok.Data;

@Data
public class FaultListObject {
    public String errorCode;
    public String errorCodeName;
}
