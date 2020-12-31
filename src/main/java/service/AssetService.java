package service;

import com.alibaba.fastjson.parser.Feature;
import dtomodel.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;

public class AssetService extends CnabsApi {
    private static StringBuilder getPrefixUrl(@Nullable String subUrl) {
        return new StringBuilder(productPrefix).append("assets/openapi/assets/").append(subUrl == null ? "" : subUrl);
    }


    /**
     * 资产分布的名称
     * @param dealNameOrId 产品全称或者Id
     * @return
     */
    public static List<SimpleEntry> getAssetsDistributions(@NotNull String dealNameOrId) {
        return HttpUtil.doGetList(SimpleEntry.class, getPrefixUrl(dealNameOrId).append("/distributions"), token, null);
    }

    /**
     * 资产分布的明细数据
     * @param dealNameOrId 产品全称或者Id
     * @param date 产品偿付日期
     * @param name 分布类别
     * @return
     */
    public static List<AssetsDistributionEntry> getAssetsDistributionItemsByName(@NotNull String dealNameOrId, Date date, @NotNull String name) {
        return HttpUtil.doGetList(AssetsDistributionEntry.class, getPrefixUrl(dealNameOrId).append("/distributions/").append(name+"/").append(FormatUtils.dateToYMD(date)), token, null);
    }

    /**
     * 资产逾期分布
     * @param dealNameOrId 产品全称或者Id
     * @param date 产品偿付日期
     * @return
     */
    public static List<AssetsSimpleDistributionEntry> getDefaultDistributions(@NotNull String dealNameOrId, Date date) {
        return HttpUtil.doGetList(AssetsSimpleDistributionEntry.class, getPrefixUrl(dealNameOrId).append("/distributions/overdue/").append(FormatUtils.dateToYMD(date)), token, null);
    }

    /**
     * 资产违约处置分布
     * @param dealNameOrId 产品全称或者Id
     * @param date 产品偿付日期
     * @return
     */
    public static List<AssetsSimpleDistributionEntry> getDefaultStatusProcessDistributions(@NotNull String dealNameOrId, Date date) {
        return HttpUtil.doGetList(AssetsSimpleDistributionEntry.class, getPrefixUrl(dealNameOrId).append("/distributions/default_process/").append(FormatUtils.dateToYMD(date)), token, null);
    }

    /**
     * 资产预测现金流
     * @param dealNameOrId 产品全称或者Id
     * @param date 产品偿付日期
     * @return
     */
    public static List<AssetsCashflowEntry> getPromisedCashflows(@NotNull String dealNameOrId, Date date) {
        return HttpUtil.doGetList(AssetsCashflowEntry.class, getPrefixUrl(dealNameOrId).append("/cashflows/forecast/report/").append(FormatUtils.dateToYMD(date)), token, null);
    }

    /**
     * 资产偿付历史明细
     * @param dealNameOrId 产品全称或者Id
     * @param date 产品偿付日期
     * @return
     */
    public static AssetsRepaymentEntry getRepayment(@NotNull String dealNameOrId, Date date) {
        return HttpUtil.doGet(AssetsRepaymentEntry.class, getPrefixUrl(dealNameOrId).append("/cashflows/").append(FormatUtils.dateToYMD(date)), token, null);
    }

    /**
     * 资产日期列表
     * @param dealNameOrId 产品全称或者Id
     */
    public static List<DateValueEntry> getRepaymentDates(@NotNull String dealNameOrId) {
        return HttpUtil.doGetList(DateValueEntry.class, getPrefixUrl(dealNameOrId).append("/dates"), token, null);
    }

    public static List<SimpleValueEntry> getAssetsStatisticItems(@NotNull String dealNameOrId,String itemName,Date date) {
        IdentityHashMap<String,Object> body = new IdentityHashMap<>();
        body.put("itemName",itemName);
        body.put("date",date);
        return HttpUtil.doGetList(SimpleValueEntry.class, getPrefixUrl(dealNameOrId).append("/statistics"), token, body);
    }
}
