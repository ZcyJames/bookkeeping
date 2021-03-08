package com.chinasoft.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("bills") //标明表名称
public class Bill {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String title;
    private Date billTime;
    private String type;
    private Double price;
    private String explains;
}
