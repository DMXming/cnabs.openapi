package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

@Data
public class AssetsRepaymentEntry {
    /**
     * 期末余额
     */
    @Nullable
    public Double Balance ;

    /**
     * 循环购买金额
     */
    @Nullable
    public Double Reinvestment ;

    /**
     * 新增违约金额
     */
    @Nullable
    public Double Default ;

    /**
     * 本金正常还款
     */
    @Nullable
    public Double PrincipalSchedule ;

    /**
     * 本金提前还款
     */
    @Nullable
    public Double PrincipalPrepayment ;

    /**
     * 本金违约回收
     */
    @Nullable
    public Double PrincipalDefaultRecovery ;

    /**
     * 本金拖欠回收
     */
    @Nullable
    public Double PrincipalDelinqRecovery ;

    /**
     * 利息正常还款
     */
    @Nullable
    public Double InterestSchedule ;

    /**
     * 利息提前还款
     */
    @Nullable
    public Double InterestPrepayment ;

    /**
     * 利息违约回收
     */
    @Nullable
    public Double InterestDefaultRecovery ;

    /**
     * 利息拖欠回收
     */
    @Nullable
    public Double InterestDelinqRecovery ;
}
