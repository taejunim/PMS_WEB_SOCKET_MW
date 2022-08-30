package kr.co.metisinfo.pms_web_socket_middleware.controller;

import kr.co.metisinfo.pms_web_socket_middleware.Object.BatteryStatusObject;
import kr.co.metisinfo.pms_web_socket_middleware.Object.PcsStatusObject;
import kr.co.metisinfo.pms_web_socket_middleware.Object.SensorStatusObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MainMapper {

    int insertPcsData(PcsStatusObject pcsStatusObject);

    int insertBatteryData(BatteryStatusObject batteryStatusObject);

    int insertSensorData(SensorStatusObject sensorStatusObject);
}
