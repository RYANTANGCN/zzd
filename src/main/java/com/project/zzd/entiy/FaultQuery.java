package com.project.zzd.entiy;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

//@Data
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Table(name = "pm_fault_query")
public class FaultQuery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 车品牌
     */
    @NotBlank
    private String carBrand;

    /**
     * 车类型
     */
    @NotBlank
    private String carType;

    /**
     * 车型
     */
    @NotBlank
    private String carModel;

    /**
     * 故障编码
     */
    @NotBlank
    private String faultNo;

    /**
     * 故障名称
     */
    @NotBlank
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

    /**
     * 是否删除
     */
    private Boolean isDeleted = false;

    /**
     * 创建时间
     */
    private LocalDateTime createDateTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateDateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getFaultNo() {
        return faultNo;
    }

    public void setFaultNo(String faultNo) {
        this.faultNo = faultNo;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getFaultPictureUrl() {
        return faultPictureUrl;
    }

    public void setFaultPictureUrl(String faultPictureUrl) {
        this.faultPictureUrl = faultPictureUrl;
    }

    public String getFaultDescribe() {
        return faultDescribe;
    }

    public void setFaultDescribe(String faultDescribe) {
        this.faultDescribe = faultDescribe;
    }

    public String getCodeDescribe() {
        return codeDescribe;
    }

    public void setCodeDescribe(String codeDescribe) {
        this.codeDescribe = codeDescribe;
    }

    public String getFaultEliminate() {
        return faultEliminate;
    }

    public void setFaultEliminate(String faultEliminate) {
        this.faultEliminate = faultEliminate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

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
