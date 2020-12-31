package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Data
public class SecurityPaymentEntry {
    /**
     * 偿付日期
     */
    public Date PaymentDate ;

    /**
     * 报告日期
     */
    @Nullable
    public Date ReportDate ;

    /**
     * 计息开始日期
     */
    @Nullable
    public Date AccrualStartDate ;

    /**
     * 计息结束日期
     */
    @Nullable
    public Date AccrualEndDate ;

    /**
     * 当期利率
     */
    public double Coupon ;

    /**
     * 期初余额
     */
    public double BeginningBalance ;

    /**
     * 期末余额
     */
    public double Balance ;

    /**
     * 支付利息
     */
    public double Interest ;

    /**
     * 支付本金
     */
    public double Principal ;

    /**
     * 本金支付比例
     */
    public double PrincipalPaidPercentage ;

    /**
     * 利息支付比例
     */
    public double InterestPaidPercentage ;

    /**
     * 剩余比例
     */
    public double BalancePercentage ;
}
