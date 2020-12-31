package dtomodel;

import lombok.Data;

@Data
public class ProjectStatisticModel {
    /**
     * 交易场所
     */
    public String Exchange;

    /**
     * 通过
     */
    public double Passed;

    /**
     * 待上会
     */
    public double Pending;

    /**
     * 已受理
     */
    public double Accepted;

    /**
     * 已反馈
     */
    public double Feedback;

    /**
     * 已回复意见
     */
    public double HasFeedback;

    /**
     * 中止
     */
    public double Suspend;

    /**
     * 终止
     */
    public double Terminated;

    /**
     * 未通过
     */
    public double Failed;
}
