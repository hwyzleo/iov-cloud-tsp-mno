package net.hwyz.iov.cloud.tsp.mno.api.feign.service;

import net.hwyz.iov.cloud.framework.common.constant.ServiceNameConstants;
import net.hwyz.iov.cloud.tsp.mno.api.contract.request.BatchImportSimRequest;
import net.hwyz.iov.cloud.tsp.mno.api.feign.service.factory.ExSimServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * SIM卡相关服务接口
 *
 * @author hwyz_leo
 */
@FeignClient(contextId = "exSimService", value = ServiceNameConstants.TSP_MNO, path = "/service/sim", fallbackFactory = ExSimServiceFallbackFactory.class)
public interface ExSimService {

    /**
     * 批量导入SIM卡信息
     *
     * @param request 批量导入SIM卡信息请求
     */
    @PostMapping("/batchImport")
    void batchImport(@RequestBody @Validated BatchImportSimRequest request);

}
