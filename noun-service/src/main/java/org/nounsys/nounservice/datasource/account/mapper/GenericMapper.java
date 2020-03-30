package org.nounsys.nounservice.datasource.account.mapper;

import java.util.List;

/**
 * @author:gaoxu
 * @create:2020-03-17 9:42
 **/
public interface GenericMapper<T> {
    int deleteByPrimaryKey(Long id);
    long insert(T record);
    long insertSelective(T record);
    T selectByPrimaryKey(Long id);
    List<T> selectAll();
    int updateByPrimaryKey(T record);
    int updateByPrimaryKeySelective(T record);
}
