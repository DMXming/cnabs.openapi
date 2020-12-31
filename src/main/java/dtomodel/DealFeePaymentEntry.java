package dtomodel;

import lombok.Data;

import java.util.Date;

/**
 * 产品偿付费用
 */
@Data
public class DealFeePaymentEntry {
    /**
     * 支付日
     */
    public Date PaymentDate ;
    /**
     * 费用类型
     */
    public String FeeType ;
    /**
     * 偿付金额
     */
    public double FeePayment ;
}
