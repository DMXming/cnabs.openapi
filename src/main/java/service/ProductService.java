package service;

import dtomodel.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.regex.Pattern;

public class ProductService extends CnabsApi {
    private static StringBuilder getPrefixUrl(@Nullable String subUrl) {
        return new StringBuilder(productPrefix).append("products/openapi/deals/").append(subUrl==null?"":subUrl);
    }

    /**
     * 产品列表，最多返回5000条数据
     *
     * @param keywords 关键字
     * @param status   产品状态
     * @param year     年份
     * @param catalog  产品分类
     * @param orgName  机构名称
     * @return 产品列表，最多返回5000条数据
     */
    public static List<Deal> getDealList(@Nullable String keywords, @Nullable String status, @Nullable Integer year, @Nullable String catalog, @Nullable String orgName) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("keywords", keywords);
        body.put("status", status);
        body.put("year", year);
        body.put("catalog", catalog);
        body.put("orgName", orgName);
        return HttpUtil.doGetList(Deal.class, getPrefixUrl(""), token, body);
    }

    /**
     * 产品详情
     *
     * @param nameOrId 产品全称或者Id
     * @return 产品详情
     */
    public static DealEntry getDealDetail(@NotNull String nameOrId) {
        return HttpUtil.doGet(DealEntry.class, getPrefixUrl(nameOrId), token, null);
    }

    /**
     * 产品相关日期列表
     *
     * @param nameOrId 产品全称或者Id
     * @param dateType 日期类型，如”首次支付日“
     * @return 产品相关日期列表
     */
    public static List<DealDateValueEntry> getDealDates(@NotNull String nameOrId, String dateType) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("dateType", dateType);
        return HttpUtil.doGetList(DealDateValueEntry.class,getPrefixUrl(nameOrId).append("/dates"), token, body);
    }

    /**
     * 产品的偿付日期表
     *
     * @param nameOrId 产品全称或者Id
     * @return 偿付日期表
     */
    public static List<DealPaymentDateEntry> getPaymentDates(@NotNull String nameOrId) {
        return HttpUtil.doGetList(DealPaymentDateEntry.class,getPrefixUrl(nameOrId).append("/payments"), token, null);
    }

    /**
     * 产品的相关机构信息
     *
     * @param nameOrId 产品全称或者Id
     * @return 机构信息
     */
    public static List<DealOrganization> getOrgs(@NotNull String nameOrId) {
        return HttpUtil.doGetList(DealOrganization.class,getPrefixUrl(nameOrId).append("/orgs"), token, null);
    }

    /**
     * 通过角色获得参与机构信息
     *
     * @param nameOrId 产品全称或者Id
     * @param role     机构角色
     * @return 机构信息 列表
     */
    public static List<DealOrganization> getOrgsByRole(@NotNull String nameOrId, @NotNull String role) {
        return HttpUtil.doGetList(DealOrganization.class,getPrefixUrl(nameOrId).append("/orgs/").append(role), token, null);
    }

    /**
     * 产品承销信息
     *
     * @param nameOrId 产品全称或者Id
     * @return 产品承销信息 列表
     */
    public static List<DealExecutionEntry> getExecutions(@NotNull String nameOrId) {
        return HttpUtil.doGetList(DealExecutionEntry.class,getPrefixUrl(nameOrId).append("/orgs/execution"), token, null);
    }

    /**
     * 产品动态信息
     *
     * @param nameOrId 产品全称或者Id
     * @param date     日期
     * @return 产品动态信息
     */
    public static DealSnapshotEntry getSnapshot(@NotNull String nameOrId, @Nullable Date date) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("date", date);
        var result = HttpUtil.doGet(DealSnapshotEntry.class, getPrefixUrl(nameOrId).append("/snapshot"), token, body);
        return result;
    }

    /**
     * 产品动态信息历史
     *
     * @param nameOrId 产品全称或者Id
     * @param begin    开始时间
     * @param end      结束时间
     * @return 产品动态信息历史列表
     */
    public static List<DealSnapshotEntry> getSnapshotsHistory(@NotNull String nameOrId, @NotNull Date begin, @NotNull Date end) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("begin", begin);
        body.put("end", end);
        return HttpUtil.doGetList(DealSnapshotEntry.class,getPrefixUrl(nameOrId).append("/snapshots"), token, body);
    }

    /**
     * 产品证券简略信息
     *
     * @param nameOrId 产品全称或者Id
     * @return 产品证券简略信息 列表
     */
    public static List<SecuritySimpleEntry> getNotes(@NotNull String nameOrId) {
        return HttpUtil.doGetList(SecuritySimpleEntry.class,getPrefixUrl(nameOrId).append("/securities"), token, null);
    }

    /**
     * 产品费用偿付
     *
     * @param nameOrId    产品全称或者Id
     * @param paymentDate 支付日
     * @return 产品费用偿付列表
     */
    public static List<DealFeePaymentEntry> getDealFeePayment(@NotNull String nameOrId, @Nullable Date paymentDate) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("paymentDate", paymentDate);
        return HttpUtil.doGetList(DealFeePaymentEntry.class, getPrefixUrl(nameOrId).append("/feePayment"), token, body);
    }

    /**
     * 产品类别列表
     *
     * @param source 产品类别的分类，默认为CNABS
     * @return 产品类别列表
     */
    public static List<DealCategoryEntry> getDealCategories(@Nullable String source) {
        return HttpUtil.doGetList(DealCategoryEntry.class,getPrefixUrl("category/").append(source == null ? "" : source
        ), token, null);
    }

    /**
     * 产品存量按分类统计
     *
     * @param begin    开始时间 开始时间或结束时间输入无效，若为月统计，格式应为yyyy-MM，若为年统计，格式应为yyyy
     * @param end      结束时间
     * @param category 产品分类
     * @return 产品存量按分类统计列表
     */
    public static List<DealBalanceStatisticsEntry> getBalanceStatisticsByCatalog
    (@NotNull
             // @Pattern(regexp = "\\d{4}(-\\d{2})?$",message = "若为月统计，格式应为yyyy-MM，若为年统计，格式应为yyyy")
             String begin,
     @NotNull String end,
     String category) {
        ValidateDateStr(begin,end);
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("begin", begin);
        body.put("end", end);
        body.put("category", category);
        return HttpUtil.doGetList(DealBalanceStatisticsEntry.class, getPrefixUrl("statistics/dealCategory"), token, body);
    }

    /**
     * 产品存量按交易所统计
     *
     * @param begin    开始时间
     * @param end      结束时间
     * @param exchange 交易所
     * @return 产品存量按交易所统计列表
     */
    public static List<DealBalanceStatisticsEntry> getBalanceStatisticsByExchange(@NotNull String begin,@NotNull String end, String exchange) {
        ValidateDateStr(begin,end);
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("begin", begin);
        body.put("end", end);
        body.put("exchange", exchange);
        List<DealBalanceStatisticsEntry> result = HttpUtil.doGetList(DealBalanceStatisticsEntry.class,getPrefixUrl("statistics/exchange"), token, body);
        return result;
    }

    /**
     * 产品存量按机构统计
     *
     * @param begin   开始时间
     * @param end     结束时间
     * @param orgName 机构名称
     * @return 产品存量按机构统计列表
     */
    public static List<DealBalanceStatisticsEntry> getBalanceStatisticsByOrg(@NotNull String begin,@NotNull String end, String orgName) {
        ValidateDateStr(begin,end);
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("begin", begin);
        body.put("end", end);
        body.put("orgName", orgName);
        List<DealBalanceStatisticsEntry> result = HttpUtil.doGetList(DealBalanceStatisticsEntry.class,getPrefixUrl("statistics/org"), token, body);
        return result;
    }

    private static void ValidateDateStr(String... dates) {
        String regex = "^\\d{4}(-\\d{2})?$";
        for (String date : dates) {
            if (!Pattern.matches(regex, date)) {
                throw new IllegalArgumentException("若为月统计，格式应为yyyy-MM，若为年统计，格式应为yyyy");
            }
        }
    }

}
