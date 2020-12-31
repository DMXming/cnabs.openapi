package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Data
public class DateRangeValueEntry {
    /**
     * 开始时间
     */
    @Nullable
    public Date Start ;

    /**
     * 结束时间
     */
    @Nullable
    public Date End ;

    /**
     * 内容
     */
    public String Content ;

    /**
     * 数值
     */
    @Nullable
    public Double Value ;
}
