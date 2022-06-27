package com.springboot.springbootlearning.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tenant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Tenant {
    @Id
    String tenantId;
    String name;
    String applicationName;
    Date createdOn = new Date();
    Date modifiedOn = new Date();
}
