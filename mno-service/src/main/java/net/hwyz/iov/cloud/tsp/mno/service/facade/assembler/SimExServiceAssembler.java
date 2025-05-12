package net.hwyz.iov.cloud.tsp.mno.service.facade.assembler;

import net.hwyz.iov.cloud.tsp.mno.api.contract.SimExService;
import net.hwyz.iov.cloud.tsp.mno.service.infrastructure.repository.po.SimPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 对外服务SIM卡信息转换类
 *
 * @author hwyz_leo
 */
@Mapper
public interface SimExServiceAssembler {

    SimExServiceAssembler INSTANCE = Mappers.getMapper(SimExServiceAssembler.class);

    /**
     * 数据传输对象转数据对象
     *
     * @param simExService 数据传输对象
     * @return 数据对象
     */
    @Mappings({})
    SimPo toPo(SimExService simExService);

    /**
     * 数据对象列表转数据传输对象列表
     *
     * @param simExServiceList 数据传输对象列表
     * @return 数据对象列表
     */
    List<SimPo> toPoList(List<SimExService> simExServiceList);

}
