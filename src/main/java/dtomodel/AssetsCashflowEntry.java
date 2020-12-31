package dtomodel;

import lombok.Data;

import java.util.Date;

@Data
public class AssetsCashflowEntry {
    /**
     * 开始日期
     */
    public Date BeginDate ;

    /**
     * 结束日期
     */
    public Date EndDate ;

    /**
     * 期初本金余额
     */
    public double BeginningBalance ;

    /**
     * 期末本金余额
     */
    public double Balance ;

    /**
     * 本金
     */
    public double Principal ;

    /**
     * 利息
     */
    public double Interest ;
}
