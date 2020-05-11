package com.project.zzd.entiy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "pm_fault_query")
public class FaultQuery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public FaultQuery(String carBrand, String carModel, String carType, String faultNo, String faultName, String faultDescribe, String faultEliminate) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carType = carType;
        this.faultNo = faultNo;
        this.faultName = faultName;
        this.faultDescribe = faultDescribe;
        this.faultEliminate = faultEliminate;
    }

}
