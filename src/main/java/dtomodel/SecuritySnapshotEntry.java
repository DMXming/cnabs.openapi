package dtomodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecuritySnapshotEntry implements Serializable {
    /**
     * 日期
     */
    public java.util.Date Date ;

    /**
     * 本金余额
     */
    public double PrincipalBalance ;

    /**
     * 剩余本金分层占比
     */
    public double TranchePercentage ;

    /**
     * 面值
     */
    public double FaceValue ;

    /**
     * 利率
     */
    public double Coupon ;

    /**
     * 基准利率
     */
    @Nullable
    public Double BaseCoupon ;

    /**
     * 剩余期限
     */
    @Nullable
    public Double RemainingTerm ;

    /**
     * 剩余加权期限
     */
    @Nullable
    public Double WeightedAverageRemainingTerm ;
}
