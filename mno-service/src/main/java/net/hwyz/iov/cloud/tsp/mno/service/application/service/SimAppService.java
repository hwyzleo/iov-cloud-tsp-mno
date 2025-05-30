package net.hwyz.iov.cloud.tsp.mno.service.application.service;

import cn.hutool.core.util.ObjUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.mno.api.contract.enums.MnoType;
import net.hwyz.iov.cloud.tsp.mno.service.domain.contract.enums.SimState;
import net.hwyz.iov.cloud.tsp.mno.service.infrastructure.repository.dao.SimDao;
import net.hwyz.iov.cloud.tsp.mno.service.infrastructure.repository.dao.SimLogDao;
import net.hwyz.iov.cloud.tsp.mno.service.infrastructure.repository.po.SimLogPo;
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
    private final SimLogDao simLogDao;

    /**
     * 批量导入SIM卡信息
     *
     * @param batchNum 批次号
     * @param mnoType  运营商类型
     * @param simList  SIM卡列表
     */
    public void batchImport(String batchNum, MnoType mnoType, List<SimPo> simList) {
        for (SimPo simPo : simList) {
            if (ObjUtil.isNull(simDao.selectByIccid(simPo.getIccid()))) {
                simPo.setMnoCode(mnoType.name());
                simPo.setSimState(SimState.TEST.state);
                simPo.setDataAbility(true);
                simPo.setSmsAbility(true);
                simPo.setVoiceAbility(true);
                simDao.insertPo(simPo);
                recordLog(simPo, "数据批次[" + batchNum + "]数据导入");
            } else {
                logger.warn("数据批次[{}]SIM卡[{}]已存在", batchNum, simPo.getIccid());
            }
        }
    }

    /**
     * 记录SIM卡变更日志
     *
     * @param simPo  SIM卡对象
     * @param remark 变更备注
     */
    private void recordLog(SimPo simPo, String remark) {
        simLogDao.insertPo(SimLogPo.builder()
                .iccid(simPo.getIccid())
                .simState(simPo.getSimState())
                .smsAbility(simPo.getSmsAbility())
                .dataAbility(simPo.getDataAbility())
                .voiceAbility(simPo.getVoiceAbility())
                .description(remark)
                .build());
    }

}
