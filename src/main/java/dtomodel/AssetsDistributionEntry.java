package dtomodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * 资产分布
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetsDistributionEntry extends AssetsSimpleDistributionEntry {
    /**
     * 原始金额总量
     */
    @Nullable
    public Double OrignalBalance;

    /**
     * 原始金额总量占比
     */
    @Nullable
    public Double OrignalBalancePercent;
}
