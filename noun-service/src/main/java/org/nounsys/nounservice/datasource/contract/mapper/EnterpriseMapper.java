package org.nounsys.nounservice.datasource.contract.mapper;

import org.nounsys.nounservice.datasource.account.entity.Enterprise;

public interface EnterpriseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);
}