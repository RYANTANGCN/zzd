package com.project.zzd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class FaultQueryController {

    @Autowired
    FaultQueryDao faultQueryDao;

    @RequestMapping("fault/query")
    public RequestResult queryFault(
            String carBrand,
            String carModel,
            String carType,
            String faultNo
    ){

        try {
            if (carBrand == null || carBrand.equals("")) {
                return new RequestResult(-1, null, "carBrand required");
            }

            if (carModel == null || carModel.equals("")) {
                return new RequestResult(-1, null, "carModel required");
            }

            if (carType == null || carType.equals("")) {
                return new RequestResult(-1, null, "carType required");
            }

            if (faultNo == null || faultNo.equals("")) {
                return new RequestResult(-1, null, "faultNo required");
            }

            FaultQuery faultQuery = faultQueryDao.findByCarBrandAndCarTypeAndCarModelAndFaultNoLike(
                    carBrand, carType, carModel, faultNo
            );

            return new RequestResult(faultQuery!=null?1:0, faultQuery, faultQuery!=null?"success!":"not found!");
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return new RequestResult(-2,null,"system error!");
        }
    }

    /**
     * 车品牌
     * @return
     */
    @RequestMapping("/car/brand")
    public RequestResult<List<String>> carBrands(){

        List<String> carBrandList = faultQueryDao.getDistinctCarBrand();

        return new RequestResult<>(1,carBrandList,"success!");
    }

    /**
     * 车类型
     * @return
     */
    @RequestMapping("/car/type")
    public RequestResult<List<String>> carTypes(){

        List<String> carTypeList = faultQueryDao.getDistinctCarType();

        return new RequestResult<>(1,carTypeList,"success!");
    }

    /**
     * 车型
     * @return
     */
    @RequestMapping("/car/model")
    public RequestResult<List<String>> carModels(){

        List<String> carModelList = faultQueryDao.getDistinctCarModel();

        return new RequestResult<>(1,carModelList,"success!");
    }

}
