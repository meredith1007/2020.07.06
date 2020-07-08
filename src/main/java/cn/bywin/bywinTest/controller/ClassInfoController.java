package cn.bywin.bywinTest.controller;

import cn.bywin.common.model.ParameterMap;
import cn.bywin.common.model.Result;
import cn.bywin.common.utils.RandomUtil;
import cn.bywin.bywinTest.model.ClassInfo;
import cn.bywin.bywinTest.service.ClassInfoServ;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.bywin.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/classInfo")
public class ClassInfoController {

	@Autowired
	private ClassInfoServ serv;

	@PostMapping("/list")
	@RequiresPermissions("classInfo:list")
	@ApiOperation(value="列表")
	public Result list(@RequestBody ParameterMap params){
		return ResultUtil.success(serv.selectList(params));
	}

	@PostMapping("/detail")
    @RequiresPermissions("classInfo:detail")
	@ApiOperation(value="详情")
	public Result detail(@RequestBody ClassInfo entity){
        return ResultUtil.success(serv.selectByPK(entity.getClassId()));
	}

    @PostMapping("/add")
    @RequiresPermissions("classInfo:add")
	@ApiOperation(value="添加")
	public Result add(@RequestBody ClassInfo entity){
		entity.setClassId(RandomUtil.getNumPrimaryKey());
		return ResultUtil.success(serv.insert(entity));
	}

	@PostMapping("/update")
    @RequiresPermissions("classInfo:update")
	@ApiOperation(value="更新")
	public Result update(@RequestBody ClassInfo entity){
		return ResultUtil.success(serv.updateSelective(entity));
	}

	@PostMapping("/delete")
    @RequiresPermissions("classInfo:delete")
	@ApiOperation(value="删除")
	public Result delete(@RequestBody ClassInfo entity){
        return ResultUtil.success(serv.deleteByPK(entity.getClassId()));
	}

	@PostMapping("/findAllStudentsNum")
	@RequiresPermissions("classInfo:selectStudentsNum")
	@ApiOperation(value="班级名字与人数键值对")
	public Result findAllStudentsNum(){
		//返回一个map
		return ResultUtil.success(serv.findStudentsNum());
	}



}
