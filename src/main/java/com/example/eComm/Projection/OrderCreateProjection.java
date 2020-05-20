package com.example.eComm.Projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;
import java.util.Date;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCreateProjection  {

    private int pid;
    private  int cid;
    private String odate;
    private String odel_date;
    private double  quantity;

}
