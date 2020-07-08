package cn.bywin.bywinTest.service;


import cn.bywin.bywinTest.dao.ClassInfoMapper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bywin.bywinTest.model.ClassInfo;
import cn.bywin.common.service.BaseServ;
import cn.bywin.common.service.IBaseServ;

import java.util.List;
import java.util.Map;

@Service
public class ClassInfoServ extends BaseServ<ClassInfo> implements IBaseServ<ClassInfo>{

    @Autowired
    ClassInfoMapper classInfoMapper;

    public Map<String,Integer> findStudentsNum(){
        Map<String, Integer> map = new HashedMap();
        //根据classId查找出所有符合条件的学生集合 size就是人数
        List<ClassInfo> classInfoList = classInfoMapper.selectAllClassId();//所有的class_id
        for(ClassInfo classInfo:classInfoList){
            map.put(classInfo.getClassName(),classInfoMapper.selectStudentsNum(classInfo.getClassId()).size());
        }
        return map;
    }
}