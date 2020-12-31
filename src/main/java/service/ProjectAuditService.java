package service;

import dtomodel.DateValueEntry;
import dtomodel.Deal;
import dtomodel.ProjectEntry;
import dtomodel.ProjectStatisticModel;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;

public class ProjectAuditService extends CnabsApi{
    private static StringBuilder getPrefixUrl(@Nullable String subUrl) {
        return new StringBuilder(productPrefix).append("projects/openapi/projects/").append(subUrl == null ? "" : subUrl);
    }


    /**
     * 统计交易所、ABN市场的审批项目 按照审批状态、时间维度对项目进行统计, 默认为当月
     * @param begin
     * @param end
     * @param statisticItem 按单数还是金额统计，number表示单数，amount表示金额
     * @return 统计交易所、ABN市场的审批项目
     */
    public static List<ProjectStatisticModel> getExchangeStatistic(Date begin, Date end, String statisticItem ) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("begin", begin);
        body.put("end", end);
        body.put("statisticItem", statisticItem);
        return HttpUtil.doGetList(ProjectStatisticModel.class,getPrefixUrl("exchanges"), token, body);
    }

    /**
     * 获取单个项目的审批周期 记录审批项目整个审批周期中每个状态以及对应的更新时间
     * @param id
     * @return 单个项目的审批周期
     */
    public static List<DateValueEntry> getProjectHistory(String id) {
        return HttpUtil.doGetList(DateValueEntry.class, getPrefixUrl(id).append("/timelines"), token, null);
    }

    /**
     * 获取交易所、ABN审批项目列表 通过关键词、起止时间、项目状态等参数获取交易所、ABN市场审批项目列表
     * @param keywords
     * @param begin
     * @param end
     * @param status
     * @return 获取交易所、ABN审批项目列表
     */
    public static List<ProjectEntry> getProjects(String keywords, @Nullable Date begin, @Nullable Date end, String status) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("keywords", keywords);
        body.put("begin", begin);
        body.put("end", end);
        body.put("status", status);
        return HttpUtil.doGetList(ProjectEntry.class,getPrefixUrl(null), token, body);
    }




}
