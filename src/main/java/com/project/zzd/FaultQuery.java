package com.project.zzd;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "pm_fault_query")
public class FaultQuery {

    @Id
    private Integer id;

    /**
     * 车品牌
     */
    private String carBrand;

    /**
     * 车类型
     */
    private String carType;

    /**
     * 车型
     */
    private String carModel;

    /**
     * 故障编码
     */
    private String faultNo;

    /**
     * 故障名称
     */
    private String faultName;

    /**
     * 故障图示
     */
    private String faultPictureUrl;

    /**
     * 故障描述
     */
    private String faultDescribe;

    /**
     * 代码描述
     */
    private String codeDescribe;

    /**
     * 消除故障步骤
     */
    private String faultEliminate;

    /**
     * 备注
     */
    private String remark;

}
