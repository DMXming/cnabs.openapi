package dtomodel;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DealBalanceStatisticsEntry {
    /**
     * 统计项目
     */
    public String Name ;

    /**
     * 统计日期
     */
    public Date Date ;

    /**
     * 存续个数
     */
    public int Count ;

    /**
     * 存续金额
     */
    public BigDecimal Amount ;

    /**
     * 总发行个数
     */
    public int TotalCount ;

    /**
     * 总发行金额
     */
    public BigDecimal TotalAmount ;
}
