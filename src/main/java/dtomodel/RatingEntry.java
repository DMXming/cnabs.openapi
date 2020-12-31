package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Data
public class RatingEntry {
    /**
     * 评级日期
     */
    @Nullable
    public java.util.Date Date;

    /**
     * 评级
     */
    public String Rating;

    /**
     * 评级公司
     */
    public String Agency;

    /**
     * 变动方向
     */
    public String ChangeDirection;

    /**
     * 评级分析师
     */
    public String Analyst;
}
