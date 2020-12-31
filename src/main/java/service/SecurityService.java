package service;

import com.alibaba.fastjson.parser.Feature;
import dtomodel.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.prefs.PreferenceChangeListener;

public class SecurityService extends CnabsApi {
    private static StringBuilder getPrefixUrl(@Nullable String subUrl) {
        return new StringBuilder(productPrefix).append("products/openapi/securities/").append(subUrl==null?"":subUrl);
    }

    /**
     * 证券列表 证券列表，最多返回5000条数据
     * @param keywords 关键字
     * @param begin 开始日期
     * @param end 结束日期
     * @param status 产品状态
     * @param year 年份
     * @param catalog 产品分类
     * @param orgName 机构名称
     * @return 证券列表
     */
    public static List<SecuritySimpleEntry> getSimpleList(@Nullable String keywords, @Nullable Date begin, @Nullable Date end, String status, @Nullable Integer year, @Nullable String catalog, @Nullable String orgName) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("keywords", keywords);
        body.put("begin", begin);
        body.put("end", end);
        body.put("status", status);
        body.put("year", year);
        body.put("catalog", catalog);
        body.put("orgName", orgName);
        return HttpUtil.doGetList(SecuritySimpleEntry.class,getPrefixUrl(""), token, body);
    }

    /**
     * 证券详情
     * @param codeOrId 代码或者证券Id
     * @return 证券详情
     */
    public static SecurityEntry getSecurity(@NotNull String codeOrId)
    {
        return HttpUtil.doGet(SecurityEntry.class,getPrefixUrl(codeOrId), token, null);
    }

    /**
     * 证券评级截面数据
     * @param codeOrId 代码或者证券Id
     * @param date 日期
     * @param ratingAgency 评级机构
     * @return 证券评级截面数据
     */
    public static List<SecurityRatingEntry> getRatingSnapshot(@NotNull String codeOrId, @Nullable Date date, String ratingAgency) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("codeOrId", codeOrId);
        body.put("date", date);
        body.put("ratingAgency", ratingAgency);
        return HttpUtil.doGetList(SecurityRatingEntry.class,getPrefixUrl(codeOrId).append("/ratings/snapshot"), token, body);
    }

    /**
     * 证券评级历史
     * @param codeOrId 代码或者证券Id
     * @param begin 开始时间
     * @param end 结束时间
     * @param ratingAgency 评级机构
     * @return 证券评级历史
     */
    public static List<SecurityRatingEntry> getRatingHistory(@NotNull String codeOrId, @Nullable Date begin,@Nullable Date end, String ratingAgency) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("codeOrId", codeOrId);
        body.put("begin", begin);
        body.put("end", end);
        body.put("ratingAgency", ratingAgency);
        return HttpUtil.doGetList(SecurityRatingEntry.class,getPrefixUrl(codeOrId).append("/ratings"), token, body);
    }

    /**
     * 证券偿付明细
     * @param codeOrId 代码或者证券Id
     * @param paymentDate 偿付日期
     * @return 证券偿付明细
     */
    public static SecurityPaymentEntry getPaymentInfo(@NotNull String codeOrId,Date paymentDate) {
        return HttpUtil.doGet(SecurityPaymentEntry.class,getPrefixUrl(codeOrId).append("/payments/").append(FormatUtils.dateToYMD(paymentDate)), token, null);
    }

    /**
     * 证券偿付历史
     * @param codeOrId 代码或者证券Id
     * @return 证券偿付历史
     */
    public static List<SecurityPaymentEntry> getPaymentInfos(@NotNull String codeOrId) {
        return HttpUtil.doGetList(SecurityPaymentEntry.class,getPrefixUrl(codeOrId).append("/payments"), token, null);
    }

    /**
     * 证券的动态截面的历史数据
     * @param codeOrId 代码或者证券Id
     * @param begin 开始日期
     * @param end 结束日期
     * @return 证券的动态截面的历史数据
     */
    public static List<SecuritySnapshotEntry> getSnapshots(@NotNull String codeOrId,@Nullable Date begin,@Nullable Date end) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("codeOrId", codeOrId);
        body.put("begin", begin);
        body.put("end", end);
       return HttpUtil.doGetList(SecuritySnapshotEntry.class,getPrefixUrl(codeOrId).append("/snapshots"), token, body);
    }

    /**
     * 证券的最新截面数据
     * @param codeOrId 代码或者证券Id
     * @param date 日期
     * @return 证券的最新截面数据
     */
    public static SecuritySnapshotEntry getSnapshot(@NotNull String codeOrId,@Nullable Date date) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("date", date);
        return HttpUtil.doGet(SecuritySnapshotEntry.class,getPrefixUrl(codeOrId).append("/snapshot"), token, body);
    }

    /**
     * 证券的固定摊还表
     * @param codeOrId 代码或者证券Id
     * @return 证券的固定摊还表
     */
    public static List<CashflowEntry> getSchedulePayments(@NotNull String codeOrId) {
        return HttpUtil.doGetList(CashflowEntry.class,getPrefixUrl(codeOrId).append("/payments/scheduled"), token, null);
    }

    /**
     * 证券的发行利率信息
     * @param codeOrId 代码或者证券Id
     * @return
     */
    public static SecurityCouponEntry getSecurityCoupon(@NotNull String codeOrId) {
        return HttpUtil.doGet(SecurityCouponEntry.class, getPrefixUrl(codeOrId).append("/coupon"), token, null);
    }

    /**
     * 证券增信
     * @param codeOrId 代码或者证券Id
     * @return 证券增信
     */
    public static List<SecurityCreditEntry> getSecurityCredits(@NotNull String codeOrId) {
        return HttpUtil.doGetList(SecurityCreditEntry.class,getPrefixUrl(codeOrId).append("/credits"), token, null);
    }

    /**
     * 证券更新
     * @param requestTime
     * @return
     */
    public static List<UpdateEntry> getUpdatedNotesAll(@Nullable Date requestTime) {
        return HttpUtil.doGetList(UpdateEntry.class,getPrefixUrl("updated/").append(requestTime!=null?FormatUtils.dateToYMD(requestTime):""), token, null);
    }



}
