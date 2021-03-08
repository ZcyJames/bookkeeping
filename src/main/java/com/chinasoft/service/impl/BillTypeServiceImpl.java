package com.chinasoft.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinasoft.domain.BillType;
import com.chinasoft.mapper.BillTypeMapper;
import com.chinasoft.service.BillTypeService;
import org.springframework.stereotype.Service;

@Service
public class BillTypeServiceImpl extends ServiceImpl<BillTypeMapper, BillType> implements BillTypeService {
}
