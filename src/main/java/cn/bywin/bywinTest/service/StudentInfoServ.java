package cn.bywin.bywinTest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bywin.bywinTest.model.StudentInfo;
import cn.bywin.common.service.BaseServ;
import cn.bywin.common.service.IBaseServ;

import java.util.List;

@Service
public class StudentInfoServ extends BaseServ<StudentInfo> implements IBaseServ<StudentInfo> {

}