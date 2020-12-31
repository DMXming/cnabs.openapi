package dtomodel;

import lombok.Data;

@Data
public class SecuritySimpleEntry extends SimpleEntry{
    /**
     * 产品ID
     */
    public String ProductId;

    /**
     * 交易场所
     */
    public String Exchange;

    /**
     * 发行金额
     */
    public double IssueAmount;
}
