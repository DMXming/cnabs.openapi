package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

@Data
public class AssetsSimpleDistributionEntry {
    /**
     * 分布名称
     */
    public String Name ;


    /**
     * 资产数量
     */
    public double AssetCount ;


    /**
     * 数量占比
     */
    @Nullable
    public Double CountPercent ;

    /**
     * 金额总量
     */
    public double Balance ;

    /**
     * 金额占比
     */
    public double BalancePercent ;
}
