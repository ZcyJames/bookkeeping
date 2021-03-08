package com.chinasoft.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinasoft.domain.Bill;
import com.chinasoft.mapper.BillMapper;
import com.chinasoft.service.BillService;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl extends ServiceImpl<BillMapper , Bill> implements BillService {
}
