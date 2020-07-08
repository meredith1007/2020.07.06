package cn.bywin.bywinTest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.*;

/**
* Created by Mybatis Generator on 2020/07/06
*/
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassInfo implements Serializable {
    private Long classId;

    private String className;

    private Date createTime;

    private Date editTime;

    private List<StudentInfo> studentInfoList;

    private static final long serialVersionUID = 1L;
}