package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

/**
 * 产品统计指标
 */
@Data
public class DealSnapshotEntry {
    /**
     * 统计日期
     */
    public Date Date;

    /**
     * 状态
     */
    public String Status;

    /**
     * 证券存量
     */
    @Nullable
    public Double PrincipalBalance;

    /**
     * 证券未偿还比例
     */
    @Nullable
    public Double BalancePercentage;

    /**
     * 资产池剩余未偿付本金
     */
    @Nullable
    public Double AssetsPrincipalBalance;

    /**
     * 次级占比
     */
    @Nullable
    public Double EquityPercentage;
}
