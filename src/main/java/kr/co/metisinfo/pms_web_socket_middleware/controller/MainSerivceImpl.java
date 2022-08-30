package kr.co.metisinfo.pms_web_socket_middleware.controller;

import kr.co.metisinfo.pms_web_socket_middleware.Object.BatteryStatusObject;
import kr.co.metisinfo.pms_web_socket_middleware.Object.PcsStatusObject;
import kr.co.metisinfo.pms_web_socket_middleware.Object.SensorStatusObject;
import org.springframework.stereotype.Service;

@Service
public class MainSerivceImpl {

    private final MainMapper mainMapper;

    public MainSerivceImpl(MainMapper mainMapper) {
        this.mainMapper = mainMapper;
    }

    public int insertPcsData(PcsStatusObject pcsStatusObject) {

        return mainMapper.insertPcsData(pcsStatusObject);
    }

    public int insertBatteryData(BatteryStatusObject batteryStatusObject) {

        return mainMapper.insertBatteryData(batteryStatusObject);
    }

    public int insertSensorData(SensorStatusObject sensorStatusObject) {

        return mainMapper.insertSensorData(sensorStatusObject);
    }

}
