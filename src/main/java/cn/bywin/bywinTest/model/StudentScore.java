package cn.bywin.bywinTest.model;

import java.io.Serializable;
import lombok.*;

/**
* Created by Mybatis Generator on 2020/07/06
*/
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentScore implements Serializable {
    private Long scoreId;

    private Long studentId;

    private String subject;

    private Double score;

    private static final long serialVersionUID = 1L;
}