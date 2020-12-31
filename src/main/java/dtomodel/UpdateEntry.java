package dtomodel;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEntry {
    /**
     * ID
     */
    public String Id ;



//    /**
//     * 更新时间
//     */
//    @JSONField(parseFeatures = Feature.AllowISO8601DateFormat)
//    public Date UpdateTime ;
    //Todo:ISO8601Date 序列化错误，先用string
    public String UpdateTime ;

    /**
     * 更新类型
     */
    public String UpdateType ;
}
