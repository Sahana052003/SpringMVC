package com.xworkz.fileupload.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name = "fileupload_tb")

@AllArgsConstructor
@NoArgsConstructor
public class FileUploadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String filePath;
}
