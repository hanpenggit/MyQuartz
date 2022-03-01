package cn.hanpeng.quartz.util;

import com.github.pagehelper.PageHelper;
import cn.hanpeng.quartz.page.PageDomain;
import cn.hanpeng.quartz.page.TableSupport;
import cn.hanpeng.quartz.util.sql.SqlUtil;

/**
 * 分页工具类
 *
 * @author hanpeng
 */
public class PageUtils extends PageHelper {
    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            Boolean reasonable = pageDomain.getReasonable();
            PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
        }
    }
}
