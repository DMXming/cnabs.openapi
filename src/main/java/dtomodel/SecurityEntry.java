package dtomodel;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Data
public class SecurityEntry {
    /**
     * ABS证券类型
     */
    public String Type ;

    /**
     * 还本方式
     */
    public String RepaymentType ;

    /**
     * 计息方式
     */
    public String AccrualMethod ;

    /**
     * 利率
     */
    public String Coupon ;

    /**
     * 支付周期
     */
    public String Frequency ;

    /**
     * 货币
     */
    public String Currency = "CNY";

    /**
     * 证券发行量占比
     */
    @Nullable
    public Double InitialTranchePercentage ;

    /**
     * 起息日
     */
    @Nullable
    public Date FirstInterestAccrualDate ;

    /**
     * 挂牌转让日
     */
    @Nullable
    public Date ListedToTransferDate ;

    /**
     * 实际到期日
     */
    @Nullable
    public Date ActualMaturityDate ;

    /**
     * 预计到期日
     */
    @Nullable
    public Date EstimatedMaturityDate ;

    /**
     * 发行期限描述
     */
    public String TermString ;


    /**
     * 发行期限（年）
     */
    public double Term ;

    /**
     * 发行面值
     */
    @Nullable
    public Double InitialFaceValue ;


    /**
     * 发行价格
     */
    @Nullable
    public Double InitialPrice ;

    /**
     * 初始加权期限
     */
    @Nullable
    public Double InitialWal ;

    /**
     * 法定初始加权期限
     */
    @Nullable
    public Double InitialWalLegal ;

    /**
     * 是否有增信
     */
    public boolean HasCreditEnhancement ;

    /**
     * 原始评级
     */
    public String OriginalRating ;

    /**
     * 原始评级机构
     */
    public String OriginalRatingAgency ;

    /**
     * 当前评级
     */
    public String CurrentRating ;

    /**
     * 当前评级机构
     */
    public String CurrentRatingAgency ;

    /**
     * 最新动态
     */
    public SecuritySnapshotEntry Current ;
}
