package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

@Data
/**
 * 审批项目
 */
public class ProjectEntry extends SimpleEntry{
    /**
     * 当前状态
     */
    public String CurrentStatus;

    /**
     * 更新时间
     */
    public String UpdateDate;

    /**
     * 预计发行金额
     */
    @Nullable
    public Double ExpectedOffering;

    /**
     * 交易场所
     */
    public String Exchange;

    /**
     * 发行人
     */
    public String Issuer;

    /**
     * 原始权益人
     */
    public String Originator;
}
