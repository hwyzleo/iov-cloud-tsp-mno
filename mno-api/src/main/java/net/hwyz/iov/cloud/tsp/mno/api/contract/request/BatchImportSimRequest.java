package net.hwyz.iov.cloud.tsp.mno.api.contract.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.hwyz.iov.cloud.tsp.mno.api.contract.SimExService;
import net.hwyz.iov.cloud.tsp.mno.api.contract.enums.MnoType;

import java.util.List;

/**
 * 批量导入SIM卡信息请求
 *
 * @author hwyz_leo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchImportSimRequest {

    /**
     * 运营商类型
     */
    @NotBlank(message = "运营商类型不能为空")
    private MnoType mnoType;

    /**
     * SIM卡列表
     */
    @NotEmpty(message = "SIM卡列表不能为空")
    private List<SimExService> simList;

}
