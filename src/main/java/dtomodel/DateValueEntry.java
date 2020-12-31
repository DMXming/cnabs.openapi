package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

/**
 * 时间序列
 */
@Data
public class DateValueEntry {
    /**
     * 时间
     */
    public Date Date ;

    /**
     * 值
     */
    public String Value ;

    /**
     * 数值
     */
    @Nullable
    public Double NumberValue ;
}
