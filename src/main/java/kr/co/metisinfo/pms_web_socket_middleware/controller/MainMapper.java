package kr.co.metisinfo.pms_web_socket_middleware.controller;

import kr.co.metisinfo.pms_web_socket_middleware.Object.PcsStatusObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MainMapper {

    int insertPcsData(PcsStatusObject pcsStatusObject);

}