package service;

import dtomodel.*;
import lombok.Builder;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.*;

public class OpendataService extends CnabsApi {
    private static StringBuilder getPrefixUrl(@Nullable String subUrl) {
        return new StringBuilder(productPrefix).append("opendata/openapi/").append(subUrl == null ? "" : subUrl);
    }

    /**
     * 中国假期
     * @param year
     * @return
     */
    public static List<HolidayEntry> getHolidayList(int year)
    {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("year", year);
        return HttpUtil.doGetList(HolidayEntry.class, getPrefixUrl("calendar/cn/holidays"), token, body);
    }

    /**
     * 判断日期类型
     * @param date 日期
     * @return 日期类型
     */
    public static String getDateType(Date date)
    {
        //String datestr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return HttpUtil.doGet(String.class,getPrefixUrl("calendar/cn/").append(FormatUtils.dateToYMD(date)), token, null);
    }

    /**
     * 判断日期范围内类型
     * @param start
     * @param end
     * @return
     */
    public static Map<String, Object> getDateTypes(Date start, Date end)
    {
        return HttpUtil.doGet(Map.class, getPrefixUrl("calendar/cn/").append(FormatUtils.dateToYMD(start)).append("/").append(FormatUtils.dateToYMD(end)), token,null);

        //return HttpUtil.doGetMap(getPrefixUrl("calendar/cn/").append(dateToYMD(start)).append("/").append(dateToYMD(end)), token,null);
    }

    /**
     * 日期调整
     * @param date
     * @param rule
     * @param isModify
     * @return
     */
    public static Date shiftTradingDays(Date date, String rule, boolean isModify)
    {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("isModify",isModify);
        String datestr = HttpUtil.doGet(String.class, getPrefixUrl("calendar/cn/adjust/").append(FormatUtils.dateToYMD(date)).append("/").append(rule), token,body);
        return FormatUtils.strToDate(datestr);
    }

    /**
     * 获得利率列表
     * @return 利率列表
     */
    public static List<SimpleEntry> getRates()
    {
        return HttpUtil.doGetList(SimpleEntry.class, getPrefixUrl("rates"), token,null);
    }

    /**
     * 获得该日期的执行利率
     * @param name
     * @param date
     * @return 执行利率
     */
    public static double getRateValue(String name, Date date)
    {
        var val = HttpUtil.doGet(BigDecimal.class, getPrefixUrl("rates/").append(name).append("/").append(FormatUtils.dateToYMD(date)), token,null);
        return val.doubleValue();
    }

    /**
     * 获得该日期区间的执行利率
     * @param name
     * @param begin
     * @param end
     * @return 区间执行利率
     */
    public static List<DateRangeValueEntry> getRateValues(String name, Date begin, Date end)
    {
        return HttpUtil.doGetList(DateRangeValueEntry.class,getPrefixUrl("rates/").append(name+"/"+FormatUtils.dateToYMD(begin)+"/"+FormatUtils.dateToYMD(end)), token,null);
    }

    /**
     * 收益曲线
     * @param name
     * @param source
     * @param category
     * @param rating
     * @param years
     * @return
     */
    public static List<MaturityYieldCurveDto> getYieldCurves(String name, String source,String category,String rating,@Nullable float years)
    {
        IdentityHashMap<String,Object> body = new IdentityHashMap<>();
        body.put("name",name);
        body.put("source",source);
        body.put("category",category);
        body.put("rating",rating);
        body.put("years",years);
        return HttpUtil.doGetList(MaturityYieldCurveDto.class,getPrefixUrl("yieldcurves/"), token,body);
    }

    /**
     * 收益曲线时间序列
     * @param name
     * @param start
     * @param end
     * @param isCached
     * @return 收益曲线时间序列
     */
    public static List<MaturityYieldCurveValueDto> getYieldCurvesValues(String name,@Nullable Date start,@Nullable Date end,@Nullable Boolean isCached)
    {
        IdentityHashMap<String,Object> body = new IdentityHashMap<>();
        body.put("name",name);
        body.put("start",start);
        body.put("end",end);
        if(isCached==null) isCached=false;
        body.put("isCached",isCached);
        return HttpUtil.doGetList(MaturityYieldCurveValueDto.class,getPrefixUrl("yieldcurves/values"), token,body);
    }










}
