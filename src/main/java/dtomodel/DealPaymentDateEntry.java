package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Data
public class DealPaymentDateEntry
{
    /**
     * 偿付期数
     */
    public int PaymentIndex;

    /**
     * 偿付日期
     */
    public Date PaymentDate;

    /**
     * 报告日期
     */
    @Nullable
    public Date ReportDate;

    /**
     * 计息开始日期
     */
    @Nullable
    public Date AccrualStartDate;

    /**
     * 计息结束日期
     */
    @Nullable
    public Date AccrualEndDate;

    /**
     * 资产归集开始日
     */
    @Nullable
    public Date AssetCollectinBeginDate;

    /**
     * 资产归集结束日
     */
    @Nullable
    public Date AssetCollectinEndDate;
}
