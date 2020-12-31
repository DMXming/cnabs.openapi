package service;

import com.sun.security.auth.UnixNumericGroupPrincipal;
import dtomodel.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.IdentityHashMap;
import java.util.List;

public class OrganizationService extends CnabsApi {
    private static StringBuilder getPrefixUrl(@Nullable String subUrl) {
        return new StringBuilder(productPrefix).append("organization/openapi/organizations/").append(subUrl == null ? "" : subUrl);
    }

    /**
     * 机构信息
     *
     * @param orgNameOrId 机构名称或者Id
     * @return 机构信息
     */
    public static OrganizationEntry getOrganization(@NotNull String orgNameOrId) {
        return HttpUtil.doGet(OrganizationEntry.class, getPrefixUrl(orgNameOrId), token, null);
    }

    /**
     * 查询机构列表，最多返回5000行数据
     * @param keywords 查询关键字
     * @param industry 行业
     * @return 机构列表
     */
    public static List<OrganizationSimpleEntry> getOrganizations(String keywords, String industry) {
        IdentityHashMap<String, Object> body = new IdentityHashMap<>();
        body.put("keywords", keywords);
        body.put("industry", industry);
        return HttpUtil.doGetList(OrganizationSimpleEntry.class,getPrefixUrl(null), token, body);
    }

    /**
     * 机构评级
     * @param orgNameOrId 机构名称或者Id
     * @return 机构评级 列表
     */
    public static List<OrganizationRatingEntry> getOrgRatings(@NotNull String orgNameOrId) {
        return HttpUtil.doGetList(OrganizationRatingEntry.class,getPrefixUrl(orgNameOrId).append("/ratings"), token, null);
    }

    /**
     * 行业列表
     * @param source 行业类别，默认为 证监会行业分类
     * @return 行业列表
     */
    public static List<IndustryEntry> getIndustry(@NotNull String source) {
        return HttpUtil.doGetList(IndustryEntry.class,getPrefixUrl("industry/").append(source), token, null);
    }
}
