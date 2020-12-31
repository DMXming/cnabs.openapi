package dtomodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deal implements Serializable {

    public String Id;

    public String Code;

    public String Name;

    public String ShortName;

    public String Status;
}
