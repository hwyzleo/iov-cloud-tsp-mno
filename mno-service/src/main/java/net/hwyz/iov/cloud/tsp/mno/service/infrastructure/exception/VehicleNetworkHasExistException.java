package net.hwyz.iov.cloud.tsp.mno.service.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * 车辆网联信息已存在异常
 *
 * @author hwyz_leo
 */
@Slf4j
public class VehicleNetworkHasExistException extends MnoBaseException {

    private static final int ERROR_CODE = 204001;

    public VehicleNetworkHasExistException(String vin) {
        super(ERROR_CODE);
        logger.warn("车辆[{}]网联信息已存在", vin);
    }

}
