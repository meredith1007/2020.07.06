package cn.bywin.bywinTest.dao;



import cn.bywin.bywinTest.model.StudentScore;
import cn.bywin.common.dao.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentScoreMapper extends BaseMapper<StudentScore>{

    public List<String> selectSubject();
}
