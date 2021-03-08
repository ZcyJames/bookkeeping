package com.chinasoft.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chinasoft.domain.Bill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BillMapper extends BaseMapper<Bill> {

    @Select("select * from bills")
    List<Bill> list11();

    @Select("select * from bills")
    List<Bill> listBy();
}
