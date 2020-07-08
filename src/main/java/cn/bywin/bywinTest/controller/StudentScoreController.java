package cn.bywin.bywinTest.controller;

import cn.bywin.common.model.ParameterMap;
import cn.bywin.common.model.Result;
import cn.bywin.common.utils.RandomUtil;
import cn.bywin.bywinTest.model.StudentScore;
import cn.bywin.bywinTest.service.StudentScoreServ;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.bywin.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/studentScore")
public class StudentScoreController {

	@Autowired
	private StudentScoreServ serv;

	@PostMapping("/list")
	@RequiresPermissions("studentScore:list")
	@ApiOperation(value="列表")
	public Result list(@RequestBody ParameterMap params){
		return ResultUtil.success(serv.selectList(params));
	}

	@PostMapping("/detail")
    @RequiresPermissions("studentScore:detail")
	@ApiOperation(value="详情")
	public Result detail(@RequestBody StudentScore entity){
        return ResultUtil.success(serv.selectByPK(entity.getScoreId()));
	}

    @PostMapping("/add")
    @RequiresPermissions("studentScore:add")
	@ApiOperation(value="添加")
	public Result add(@RequestBody StudentScore entity){
		entity.setScoreId(RandomUtil.getNumPrimaryKey());
		return ResultUtil.success(serv.insert(entity));
	}

	@PostMapping("/update")
    @RequiresPermissions("studentScore:update")
	@ApiOperation(value="更新")
	public Result update(@RequestBody StudentScore entity){
		return ResultUtil.success(serv.updateSelective(entity));
	}

	@PostMapping("/delete")
    @RequiresPermissions("studentScore:delete")
	@ApiOperation(value="删除")
	public Result delete(@RequestBody StudentScore entity){
        return ResultUtil.success(serv.deleteByPK(entity.getScoreId()));
	}
	@PostMapping("/avg")
	@RequiresPermissions("studentScore:selectSubject")
	@ApiOperation(value="各班课程的平均分")
	public Result avg(){
		return ResultUtil.success(serv.avg());
	}

}
