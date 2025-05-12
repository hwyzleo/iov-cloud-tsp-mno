package net.hwyz.iov.cloud.tsp.mno.api.feign.service.factory;

import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.mno.api.contract.request.BatchImportSimRequest;
import net.hwyz.iov.cloud.tsp.mno.api.feign.service.ExSimService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * SIM卡相关服务降级处理
 *
 * @author hwyz_leo
 */
@Slf4j
@Component
public class ExSimServiceFallbackFactory implements FallbackFactory<ExSimService> {

    @Override
    public ExSimService create(Throwable throwable) {
        return new ExSimService() {
            @Override
            public void batchImport(BatchImportSimRequest request) {
                logger.error("通讯运营商服务批量导入运营商[{}]SIM卡信息[{}]调用失败", request.getMnoType(), request.getSimList().size(), throwable);
            }
        };
    }
}
