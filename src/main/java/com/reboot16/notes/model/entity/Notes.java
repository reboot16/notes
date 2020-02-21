package com.reboot16.notes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Notes {
    @Id
    private String notesId;

    private String userId;
    private Date date;
    private String title;
    private String description;
    private String colorCode;
    private List<Tags> tagsList;
}
