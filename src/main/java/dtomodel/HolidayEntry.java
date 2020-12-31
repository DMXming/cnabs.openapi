package dtomodel;

import lombok.Data;

import java.util.Date;

@Data
public class HolidayEntry {
    /**
     * 假期
     */
    public String Name ;

    /**
     * 开始时间
     */
    public Date Start ;

    /**
     * 结束时间
     */
    public Date End ;

    /**
     * 调休工作时间
     */
    public Date[] WorkingDays ;

    /**
     * 法定假日
     */
    public Date[] LegalHolidays ;
}
