package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrganizationEntry extends SimpleEntry {
    /**
     * 组织机构代码
     */
    public String RegisterNo ;

    /**
     * 英文名称
     */
    public String EnglishName ;

    /**
     * 成立时间
     */
    @Nullable
    public Date EstablishDate ;

    /**
     * 公司网站
     */
    public String Website ;

    /**
     * 联系电话
     */
    public String Telephone ;

    /**
     * 邮箱
     */
    public String Email ;

    /**
     * 简介
     */
    public String Introduction ;

    /**
     * 企业性质
     */
    public String Nature ;

    /**
     * 资本属性
     */
    public String CapitalNature ;

    /**
     * 注册资本
     */
    @Nullable
    public BigDecimal SubscribedCapital ;

    /**
     * 实到资本
     */
    @Nullable
    public BigDecimal PaidInCapital ;

    /**
     * 法人
     */
    public String LegalPerson ;

    /**
     * 实控人
     */
    public String ActualController ;

    /**
     * 是否上市
     */
    @Nullable
    public Boolean IsIPO ;

    /// <summary>
    /// 经营范围
    /// </summary>
    /**
     * 经营范围
     */
    public String Scope ;
}
