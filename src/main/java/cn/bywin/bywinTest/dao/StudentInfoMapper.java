package cn.bywin.bywinTest.dao;



import cn.bywin.bywinTest.model.StudentInfo;
import cn.bywin.common.dao.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentInfoMapper extends BaseMapper<StudentInfo>{

    public List<Map<String,Double>> selectScore(Long class_id);
}
