package net.hwyz.iov.cloud.tsp.mno.service.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.mno.api.contract.enums.MnoType;
import net.hwyz.iov.cloud.tsp.mno.service.domain.contract.enums.SimState;
import net.hwyz.iov.cloud.tsp.mno.service.infrastructure.repository.dao.SimDao;
import net.hwyz.iov.cloud.tsp.mno.service.infrastructure.repository.po.SimPo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SIM卡应用服务类
 *
 * @author hwyz_leo
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SimAppService {

    private final SimDao simDao;

    /**
     * 批量导入SIM卡信息
     *
     * @param mnoType 运营商类型
     * @param simList SIM卡列表
     */
    public void batchImport(MnoType mnoType, List<SimPo> simList) {
        for (SimPo simPo : simList) {
            simPo.setMnoCode(mnoType.name());
            simPo.setSimState(SimState.TEST.state);
            simPo.setDataAbility(true);
            simPo.setSmsAbility(true);
            simPo.setVoiceAbility(true);
        }
        simDao.batchInsertPo(simList);
    }

}
