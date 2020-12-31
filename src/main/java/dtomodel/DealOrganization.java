package dtomodel;

import lombok.Data;

@Data
public class DealOrganization {
    /**
     * 参与方式
     */
    public String Role;

    /**
     * 参与机构名称
     */
    public String OrgName;

    /**
     * 参与机构ID
     */
    public String OrgId;
}
