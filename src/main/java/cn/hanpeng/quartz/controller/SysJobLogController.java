package cn.hanpeng.quartz.controller;

import java.util.List;

import cn.hanpeng.quartz.domain.AjaxResult;
import cn.hanpeng.quartz.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.hanpeng.quartz.domain.SysJobLog;
import cn.hanpeng.quartz.service.ISysJobLogService;
import cn.hanpeng.quartz.service.ISysJobService;

/**
 * 调度日志操作处理
 *
 * @author hanpeng
 */
@RestController
@RequestMapping("/monitor/jobLog")
public class SysJobLogController extends BaseController {

    @Autowired
    private ISysJobLogService jobLogService;


    @PostMapping("/list")
    public TableDataInfo list(SysJobLog jobLog) {
        startPage();
        List<SysJobLog> list = jobLogService.selectJobLogList(jobLog);
        return getDataTable(list);
    }

    @PostMapping("/remove")
    public AjaxResult remove(String ids) {
        return toAjax(jobLogService.deleteJobLogByIds(ids));
    }

    @GetMapping("/detail/{jobLogId}")
    public AjaxResult detail(@PathVariable("jobLogId") Long jobLogId) {
        return success(jobLogService.selectJobLogById(jobLogId));
    }

    @PostMapping("/clean")
    @ResponseBody
    public AjaxResult clean() {
        jobLogService.cleanJobLog();
        return success();
    }
}
