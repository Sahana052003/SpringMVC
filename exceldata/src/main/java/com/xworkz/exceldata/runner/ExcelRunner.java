package com.xworkz.exceldata.runner;

import com.xworkz.exceldata.entity.ExcelEntity;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelRunner {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("data");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<ExcelEntity> list = new ArrayList<>();

        try{
                InputStream fis = new FileInputStream("C:\\Users\\admin\\Documents\\student.xlsx");
                Workbook workbook = new XSSFWorkbook(fis);



            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            for (int i = 1; i <= sheet.getLastRowNum() && i <= 10; i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                ExcelEntity entity = new ExcelEntity();

//                entity.setName(formatter.formatCellValue(row.getCell(0)));
//                entity.setUSN(formatter.formatCellValue(row.getCell(1)));
//                entity.setPhone_No(
//                        Long.parseLong(formatter.formatCellValue(row.getCell(2)))
//                );
//                entity.setFees_due(
//                        Double.parseDouble(formatter.formatCellValue(row.getCell(3)))
//                );
//
//                Cell dateCell = row.getCell(4);
//                Date date = (dateCell.getCellType() == CellType.NUMERIC)
//                        ? dateCell.getDateCellValue()
//                        : sdf.parse(formatter.formatCellValue(dateCell));
//
//                entity.setRegst_date(date);
//
//                list.add(entity);
//            }

                tx.begin();
                Date manualDate = sdf.parse("2021-05-01");

                list.add(new ExcelEntity("Sneha", "21IS06", 9876543210L, 30000.0, manualDate));
                list.add(new ExcelEntity("Nandu", "21IS07", 9876543211L, 25000.0, manualDate));
                list.add(new ExcelEntity("Muktha", "21IS08", 9876543212L, 15000.0, manualDate));
                list.add(new ExcelEntity("Pooja", "21IS09", 9876543213L, 10000.0, manualDate));
                list.add(new ExcelEntity("Bhargavi", "21IS10", 9876543214L, 35000.0, manualDate));
                list.add(new ExcelEntity("Asha", "21IS11", 9876543215L, 28000.0, manualDate));
                list.add(new ExcelEntity("Ramesh", "21IS12", 9876543216L, 32000.0, manualDate));
                list.add(new ExcelEntity("Kavya", "21IS13", 9876543217L, 26000.0, manualDate));
                list.add(new ExcelEntity("Rahul", "21IS14", 9876543218L, 31000.0, manualDate));
                list.add(new ExcelEntity("Divya", "21IS15", 9876543219L, 29000.0, manualDate));


                for (ExcelEntity e : list) {
                    em.merge(e);
                }
                tx.commit();

//                System.out.println("Data inserted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
