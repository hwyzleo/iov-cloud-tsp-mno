package net.hwyz.iov.cloud.tsp.mno.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.tsp.mno.service.infrastructure.repository.po.VehicleNetworkPo;
import net.hwyz.iov.cloud.framework.mysql.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 车辆网联信息表 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-12
 */
@Mapper
public interface VehicleNetworkDao extends BaseDao<VehicleNetworkPo, Long> {

    /**
     * 根据VIN查询车辆网联信息
     *
     * @param vin 车架号
     * @return 车辆网联信息
     */
    VehicleNetworkPo selectByVin(String vin);

}
