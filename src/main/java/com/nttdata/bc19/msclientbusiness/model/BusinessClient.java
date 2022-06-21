package com.nttdata.bc19.msclientbusiness.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessClient extends BaseModel {
    private String name;
    private String ruc;
    private String tradeName;
    private String address;
    private String phone;
    private String email;
}
