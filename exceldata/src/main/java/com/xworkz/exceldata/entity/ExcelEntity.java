package com.xworkz.exceldata.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="student_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelEntity {

    private String Name;
    @Id
    private String USN;
    private Long Phone_No;
    private Double fees_due;
    private Date Regst_date;
}
