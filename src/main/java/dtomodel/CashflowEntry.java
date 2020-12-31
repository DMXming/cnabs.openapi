package dtomodel;

import lombok.Data;

import java.util.Date;
@Data
public class CashflowEntry {
    /**
     * 日期
     */
    public java.util.Date Date ;

    /**
     * 期初余额
     */
    public double BeginningBalance ;

    /**
     * 期末余额
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
