package cn.bywin.bywinTest.dao;



import cn.bywin.bywinTest.model.ClassInfo;
import cn.bywin.common.dao.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassInfoMapper extends BaseMapper<ClassInfo>{
    public List<ClassInfo> selectAllClassId();
 //   public Long selectClassId(String className);
    public List<ClassInfo> selectStudentsNum(Long classId);

}
