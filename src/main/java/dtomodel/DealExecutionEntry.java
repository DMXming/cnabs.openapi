package dtomodel;

import lombok.Data;

@Data
public class DealExecutionEntry
{
    /**
     * 承销角色
     */
    public String Role;

    /**
     * 机构名称
     */
    public String OrgName;

    /**
     * 承销占比
     */
    public double Percentage;

    /**
     * 承销金额
     */
    public double Amount;

    /**
     * 承销证券
     */
    public String Securities;

    /**
     * 承销方式
     */
    public String Method;
}