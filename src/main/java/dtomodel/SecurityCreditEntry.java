package dtomodel;

import lombok.Data;

@Data
public class SecurityCreditEntry {
    /**
     * 证券简称
     */
    public String Name ;
    /**
     * 增信类别
     */
    public String CreditType ;
    /**
     * 增信方式
     */
    public String CreditWay ;
    /**
     * 增信机构
     */
    public String Organizations ;
    /**
     * 增信描述
     */
    public String Description ;
}
