package cn.bywin.bywinTest.controller;

import cn.bywin.common.model.ParameterMap;
import cn.bywin.common.model.Result;
import cn.bywin.common.utils.RandomUtil;
import cn.bywin.bywinTest.model.StudentInfo;
import cn.bywin.bywinTest.service.StudentInfoServ;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.bywin.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {

	@Autowired
	private StudentInfoServ serv;

	@PostMapping("/list")
	@RequiresPermissions("studentInfo:list")
	@ApiOperation(value="列表")
	public Result list(@RequestBody ParameterMap params){
		return ResultUtil.success(serv.selectList(params));
	}

	@PostMapping("/detail")
    @RequiresPermissions("studentInfo:detail")
	@ApiOperation(value="详情")
	public Result detail(@RequestBody StudentInfo entity){
        return ResultUtil.success(serv.selectByPK(entity.getStudentId()));
	}

    @PostMapping("/add")
    @RequiresPermissions("studentInfo:add")
	@ApiOperation(value="添加")
	public Result add(@RequestBody StudentInfo entity){
		entity.setStudentId(RandomUtil.getNumPrimaryKey());
		return ResultUtil.success(serv.insert(entity));
	}

	@PostMapping("/update")
    @RequiresPermissions("studentInfo:update")
	@ApiOperation(value="更新")
	public Result update(@RequestBody StudentInfo entity){
		return ResultUtil.success(serv.updateSelective(entity));
	}

	@PostMapping("/delete")
    @RequiresPermissions("studentInfo:delete")
	@ApiOperation(value="删除")
	public Result delete(@RequestBody StudentInfo entity){
        return ResultUtil.success(serv.deleteByPK(entity.getStudentId()));
	}

}
