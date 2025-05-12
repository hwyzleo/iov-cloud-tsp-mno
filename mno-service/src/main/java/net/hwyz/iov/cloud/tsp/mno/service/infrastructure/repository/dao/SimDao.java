package net.hwyz.iov.cloud.tsp.mno.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.tsp.mno.service.infrastructure.repository.po.SimPo;
import net.hwyz.iov.cloud.framework.mysql.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * SIM卡信息表 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-12
 */
@Mapper
public interface SimDao extends BaseDao<SimPo, Long> {

}
