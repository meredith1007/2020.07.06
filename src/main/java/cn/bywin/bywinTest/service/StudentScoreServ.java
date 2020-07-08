package cn.bywin.bywinTest.service;


import cn.bywin.bywinTest.dao.ClassInfoMapper;
import cn.bywin.bywinTest.dao.StudentInfoMapper;
import cn.bywin.bywinTest.dao.StudentScoreMapper;
import cn.bywin.bywinTest.model.ClassInfo;
import cn.bywin.bywinTest.model.StudentInfo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bywin.bywinTest.model.StudentScore;
import cn.bywin.common.service.BaseServ;
import cn.bywin.common.service.IBaseServ;

import java.util.List;
import java.util.Map;

@Service
public class StudentScoreServ extends BaseServ<StudentScore> implements IBaseServ<StudentScore>{

    @Autowired
    ClassInfoMapper classInfoMapper;
    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    StudentScoreMapper studentScoreMapper;

    public Map<String, List<Map<String,Double>>> avg(){
        List<String> subjects = studentScoreMapper.selectSubject();
        Map<String, List<Map<String,Double>>> map = new HashedMap();
        for(String subject:subjects){//所有课程
            List<ClassInfo> classInfoList = classInfoMapper.selectAllClassId();
            for(ClassInfo classInfo:classInfoList){//所有班级
                map.put(classInfo.getClassName(),studentInfoMapper.selectScore(classInfo.getClassId()));
            }

        }
        return map;
    }
}