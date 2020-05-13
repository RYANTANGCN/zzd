package com.project.zzd.web;

import com.project.zzd.entiy.FaultQuery;
import com.project.zzd.config.QueryKeyGenerator;
import com.project.zzd.common.RequestResult;
import com.project.zzd.dao.FaultQueryDao;
import io.rebloom.client.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
public class FaultQueryController {

    @Autowired
    FaultQueryDao faultQueryDao;

    @Autowired
    RedisTemplate<String,List> redisTemplate;

    @Autowired
    RedisTemplate<String, FaultQuery> queryRedisTemplate;

    @Autowired
    QueryKeyGenerator queryKeyGenerator;

    AtomicInteger count = new AtomicInteger(0);
    int unsafeCount = 0;

    @Autowired
    Client reBloomClient;

//    @Cacheable(value = "query",keyGenerator = "queryKeyGenerator")
    @RequestMapping("fault/query")
    public RequestResult queryFault(
            String carBrand,
            String carModel,
            String carType,
            String faultNo
    ){
        log.debug("---------request form---------");
        log.debug("carBrand:{},carModel:{},carType:{},faultNo:{}",carBrand,carModel,carType,faultNo);
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

            FaultQuery result = queryRedisTemplate.opsForValue().get(queryKeyGenerator.generate(null, null, carBrand, carModel, carType, faultNo));

//            log.info("request count:{}",count.incrementAndGet());
//            log.info("request unsafe count:{}",unsafeCount++);

            if (result!=null) {
                return new RequestResult(result != null ? 1 : 0, result, result != null ? "success!" : "not found!");
            }

            FaultQuery faultQuery = faultQueryDao.findByCarBrandAndCarTypeAndCarModelAndFaultNoLike(
                    carBrand, carType, carModel, faultNo
            );
            if (faultQuery != null) {
                queryRedisTemplate.opsForValue().set(queryKeyGenerator.generate(null, null, carBrand, carModel, carType, faultNo).toString(), faultQuery);
            }
//            log.info("response body:{}",new ObjectMapper().writeValueAsString(faultQuery));
            return new RequestResult(faultQuery!=null?1:0, faultQuery, faultQuery!=null?"success!":"not found!");
        }catch (IncorrectResultSizeDataAccessException incorrectResultSizeDataAccessException){
            if (incorrectResultSizeDataAccessException.getCause() instanceof NonUniqueResultException) {
                return new RequestResult(-3, null, "请提供更详细的错误代码进行查询");
            }
            return new RequestResult(-2,null,"system error!");
        }
        catch (Exception e){
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
    public RequestResult<List<String>> carTypes(String carBrand){

        List<String> carTypeList = faultQueryDao.getCarType(carBrand);

        return new RequestResult<>(1,carTypeList,"success!");
    }

    /**
     * 车型
     * @return
     */
    @RequestMapping("/car/model")
    public RequestResult<List<String>> carModels(String carBrand,String carType){

        List<String> carModelList = faultQueryDao.getCarModel(carBrand,carType);

        return new RequestResult<>(1,carModelList,"success!");
    }

}
