package com.project.zzd;

import com.project.zzd.dao.FaultQueryDao;
import com.project.zzd.entiy.FaultQuery;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

/**
 * 导入excel数据
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelImport {

    @Autowired
    FaultQueryDao faultQueryDao;

    @Test
    public void importExcel() {

        try {
            String[] filePaths = {
//                    "/Users/ryantang/Documents/zzd/0517cd6636619d6c.xlsx",
//                    "/Users/ryantang/Documents/zzd/1_BT故障代码数(1).xlsx",
//                    "/Users/ryantang/Documents/zzd/3b9080ab07b7a796.xlsx",
                    "/Users/ryantang/Documents/zzd/LINDE故障代码数据(1).xlsx"
            };

            for (String filePath:filePaths) {

                File file = new File(filePath);
                if (!file.exists()) {
                    log.error("文件不存在");
                    return;
                }
                Workbook workbook = WorkbookFactory.create(file);


                workbook.getNumberOfSheets();
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    Sheet sheet = workbook.getSheetAt(i);

                    for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {

                        Row row = sheet.getRow(rowIndex);
                        if (row == null) {
                            continue;
                        }
//                        row.getCell(0).getCellType();
                        if (    //row.getCell(0) == null
                                getCellStringValue(row.getCell(0))==null//车品牌没有没必要导
//                                || row.getCell(4) == null
//                                || getCellStringValue(row.getCell(4))==null//错误代码没有没必要导
//                                || row.getCell(5) == null
                                || (getCellStringValue(row.getCell(5))==null
                                        &&
                                        getCellStringValue(row.getCell(6))==null
                                        &&
                                        getCellStringValue(row.getCell(7))==null))//故障名称没有没必要导
                         {
                            continue;
                        }

                        //打印一下
                        String line = String.join(" "
                                , getCellStringValue(row.getCell(0))!=null? getCellStringValue(row.getCell(0)): "null"
                                , getCellStringValue(row.getCell(2))!=null? getCellStringValue(row.getCell(2)): "null"
                                , getCellStringValue(row.getCell(3))!=null? getCellStringValue(row.getCell(3)): "null"
                                , getCellStringValue(row.getCell(4))!=null? getCellStringValue(row.getCell(4)): "null"
                                , getCellStringValue(row.getCell(5))!=null? getCellStringValue(row.getCell(5)): "null"
                                , getCellStringValue(row.getCell(6))!=null? getCellStringValue(row.getCell(6)): "null"
                                , getCellStringValue(row.getCell(7))!=null? getCellStringValue(row.getCell(7)): "null"
                        );
                        System.out.println(sheet.getSheetName() + " " + rowIndex + " " + line);

                        //保存到数据库
                        faultQueryDao.save(new FaultQuery(
                                  getCellStringValue(row.getCell(0))
                                , getCellStringValue(row.getCell(2))
                                , getCellStringValue(row.getCell(3))
                                , getCellStringValue(row.getCell(4))
                                , getCellStringValue(row.getCell(5))
                                , getCellStringValue(row.getCell(6))
                                , getCellStringValue(row.getCell(7))
                        ));
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getCellStringValue(Cell cell) {

        if (cell == null) {
            return null;
        }

        switch (cell.getCellType()) {
            case NUMERIC:{
                Double number = cell.getNumericCellValue();
                return number.toString();
//                log.debug(number.toString());
//                return String.format("%.3f",cell.getNumericCellValue());
            }
            case STRING:{
                return cell.getStringCellValue();
            }
            case BLANK:{
                return null;
            }
            default:
                log.info("uncaught type:{}",cell.getCellType().toString());
                return "";
        }

    }

}
