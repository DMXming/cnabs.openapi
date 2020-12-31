package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Data
public class SecurityCouponEntry {
    /**
     * 利率公式
     */
    public String CouponString ;

    /**
     * 是否浮动利率
     */
    public boolean IsFloat ;

    /**
     * 基准利率名称
     */
    public String BaseRateName ;

    /**
     * 基准利率确认日
     */
    @Nullable
    public Date BaseRateSettleDate ;

    /**
     * 发行基准利率
     */
    @Nullable
    public Double BaseRate ;

    /**
     * 票面利率
     */
    public double Coupon ;

    /**
     * 浮动票面利差
     */
    public double Spread ;

    /**
     * 发行基差
     */
    @Nullable
    public Double InitialReferSpread ;

    /**
     * 发行参考利率
     */
    @Nullable
    public Double InitialReferBaseRate ;

    /**
     * 发行参考利率曲线
     */
    public String InitialReferBaseRateName ;

    /**
     * 发行最低利率
     */
    @Nullable
    public Double MinCoupon ;

    /**
     * 发行最高利率
     */
    @Nullable
    public Double MaxCoupon ;

    /**
     * 是否分段计息
     */
    @Nullable
    public Boolean IsSegmentInterest ;
}
