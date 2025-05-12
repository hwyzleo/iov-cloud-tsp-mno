package net.hwyz.iov.cloud.tsp.mno.api.feign.service.factory;

import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.mno.api.contract.VehicleNetworkExService;
import net.hwyz.iov.cloud.tsp.mno.api.feign.service.ExVehicleNetworkService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 车辆网联信息相关服务降级处理
 *
 * @author hwyz_leo
 */
@Slf4j
@Component
public class ExVehicleNetworkServiceFallbackFactory implements FallbackFactory<ExVehicleNetworkService> {

    @Override
    public ExVehicleNetworkService create(Throwable throwable) {
        return new ExVehicleNetworkService() {
            @Override
            public void create(VehicleNetworkExService vehicleNetwork) {
                logger.error("通讯运营商服务创建车辆[{}]网联信息调用失败", vehicleNetwork.getVin(), throwable);
            }
        };
    }
}
