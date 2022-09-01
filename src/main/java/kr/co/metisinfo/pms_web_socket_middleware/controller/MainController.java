package kr.co.metisinfo.pms_web_socket_middleware.controller;

import kr.co.metisinfo.pms_web_socket_middleware.Object.BatteryStatusObject;
import kr.co.metisinfo.pms_web_socket_middleware.Object.PcsStatusObject;
import kr.co.metisinfo.pms_web_socket_middleware.Object.SensorStatusObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    private final MainSerivceImpl mainSerivceImpl;

    public MainController(MainSerivceImpl mainSerivceImpl) {
        this.mainSerivceImpl = mainSerivceImpl;
    }

    @GetMapping("/main") // 기본 주소 뒤에 "/main"가 오면 main 메서드가 실행
    public String main(){
        // "main"이라는 문자열(String)을 반환하는데,
        // Thymeleaf 템플릿 엔진(build.gradle)을 사용하므로 html 파일을 반환
        // 즉 main.html 파일을 리턴
        return "main";
    }

    @RequestMapping("/ajax/insertPcsStatusData")
    public String insertPcsStatusData(@RequestBody PcsStatusObject pcsStatusObject) {

        System.out.println("[ ---------- PCS Status Data ---------- ]");
        System.out.println("operationStatus : " + pcsStatusObject.operationStatus);
        System.out.println("chargingStatus : " + pcsStatusObject.chargingStatus);
        System.out.println("faultExistYn : " + pcsStatusObject.faultExistYn);
        System.out.println("disChargePower : " + pcsStatusObject.disChargePower);
        System.out.println("rSVolt : " + pcsStatusObject.rSVolt);
        System.out.println("upRCurr : " + pcsStatusObject.upRCurr);
        System.out.println("dcLinkVolt : " + pcsStatusObject.dcLinkVolt);
        System.out.println("frequencyHz : " + pcsStatusObject.frequencyHz);
        System.out.println("sTVolt : " + pcsStatusObject.sTVolt);
        System.out.println("upSCurr : " + pcsStatusObject.upSCurr);
        System.out.println("dcBatteryVolt : " + pcsStatusObject.dcBatteryVolt);
        System.out.println("tRVolt : " + pcsStatusObject.tRVolt);
        System.out.println("upTCurr : " + pcsStatusObject.upTCurr);
        System.out.println("dcBatteryCurr : " + pcsStatusObject.dcBatteryCurr);
        System.out.println("faultList : " + pcsStatusObject.faultList);

        if (pcsStatusObject.chargingStatus.equals("charging")) {
            pcsStatusObject.chargingStatus = "1";
        } else if (pcsStatusObject.chargingStatus.equals("discharging")) {
            pcsStatusObject.chargingStatus = "2";
        } else if (pcsStatusObject.chargingStatus.equals("waiting")) {
            pcsStatusObject.chargingStatus = "0";
        }

        System.out.println("[ ------------------------------------- ]");
        System.out.println("[ ---------- PCS 등록 결과 : " + mainSerivceImpl.insertPcsData(pcsStatusObject) + " ---------- ]");
        System.out.println("[ ------------------------------------- ]\n\n");

        if(pcsStatusObject.chargingStatus.equals("1") || pcsStatusObject.chargingStatus.equals("2")) {
            System.out.println("[ ------------------------------------- ]");
            System.out.println("[ -  층/방전 데이터 등록 결과 : " + mainSerivceImpl.insertDisChargeData(pcsStatusObject) + " - ]");
            System.out.println("[ ------------------------------------- ]\n\n");
        }

        return "main";
    }

    @RequestMapping("/ajax/insertBatteryStatusData")
    public String insertBatteryStatusData(@RequestBody BatteryStatusObject batteryStatusObject) {

        System.out.println("[ ---------- Battery Status Data ---------- ]");
        System.out.println("rackNo : " + batteryStatusObject.rackNo);
        System.out.println("chargingStatus : " + batteryStatusObject.chargingStatus);
        System.out.println("soc : " + batteryStatusObject.soc);
        System.out.println("rackVolt : " + batteryStatusObject.rackVolt);
        System.out.println("rackCurrent : " + batteryStatusObject.rackCurrent);
        System.out.println("faultExistYn : " + batteryStatusObject.faultExistYn);
        System.out.println("currentSensor1 : " + batteryStatusObject.currentSensor1);
        System.out.println("currentSensor2 : " + batteryStatusObject.currentSensor2);
        System.out.println("currentLimit : " + batteryStatusObject.currentLimit);
        System.out.println("faultList : " + batteryStatusObject.faultList);

        if (batteryStatusObject.chargingStatus.equals("charging")) {
            batteryStatusObject.chargingStatus = "1";
        } else if (batteryStatusObject.chargingStatus.equals("discharging")) {
            batteryStatusObject.chargingStatus = "2";
        } else if (batteryStatusObject.chargingStatus.equals("waiting")) {
            batteryStatusObject.chargingStatus = "0";
        }

        System.out.println("[ -------------------------------------------- ]");
        System.out.println("[ ------------- 배터리 등록 결과 : " + mainSerivceImpl.insertBatteryData(batteryStatusObject) + " ------------- ]");
        System.out.println("[ -------------------------------------------- ]\n\n");

        return "main";
    }

    @RequestMapping("/ajax/insertPcsInnerSensorStatusData")
    public String insertPcsInnerSensorStatusData(@RequestBody SensorStatusObject sensorStatusObject) {

        System.out.println("[ ---------- PCS Sensor Status Data ---------- ]");
        System.out.println("pmsCode : " + sensorStatusObject.pmsCode);
        System.out.println("essCode : " + sensorStatusObject.essCode);
        System.out.println("deviceCode : " + sensorStatusObject.deviceCode);
        System.out.println("deviceName : " + sensorStatusObject.deviceName);
        System.out.println("faultExistYn : " + sensorStatusObject.faultExistYn);
        System.out.println("measures : " + sensorStatusObject.measures);

        System.out.println("[ ----------------------------------------------- ]");
        System.out.println("[ ------------ PCS실 센서 등록 결과 : " + mainSerivceImpl.insertSensorData(sensorStatusObject) + " ------------ ]");
        System.out.println("[ ----------------------------------------------- ]\n\n");

        return "main";
    }

    @RequestMapping("/ajax/insertBatteryInnerSensorStatusData")
    public String insertBatteryInnerSensorStatusData(@RequestBody SensorStatusObject sensorStatusObject) {

        System.out.println("[ ---------- Battery Sensor Status Data ---------- ]");
        System.out.println("pmsCode : " + sensorStatusObject.pmsCode);
        System.out.println("essCode : " + sensorStatusObject.essCode);
        System.out.println("deviceCode : " + sensorStatusObject.deviceCode);
        System.out.println("deviceName : " + sensorStatusObject.deviceName);
        System.out.println("faultExistYn : " + sensorStatusObject.faultExistYn);
        System.out.println("measures : " + sensorStatusObject.measures);

        System.out.println("[ ------------------------------------------------ ]");
        System.out.println("[ ------------- 배터리실 센서 등록 결과: " + mainSerivceImpl.insertSensorData(sensorStatusObject) + " ------------- ]");
        System.out.println("[ ------------------------------------------------ ]\n\n");

        return "main";
    }
}
