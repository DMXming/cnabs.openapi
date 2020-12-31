package dtomodel;

import lombok.Data;

@Data
public class MaturityYieldCurveDto {
    public int Id;

    public String Name ;

    public String Category ;

    public String Rating ;

    public float Years ;

    public String Source ;
    
}
