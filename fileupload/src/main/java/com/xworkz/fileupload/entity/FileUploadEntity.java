
package com.xworkz.fileupload.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "fileupload_tb")
@NamedQuery(
        name = "FileUploadEntity.findByFilePath",
        query = "SELECT f FROM FileUploadEntity f WHERE f.filePath = :path"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String filePath;
    //private String otp;
}
