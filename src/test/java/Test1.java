import org.junit.Test;
import service.*;

import java.net.http.HttpRequest;
import java.security.PublicKey;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {

    public String token="";

    @Test
    public void TestAllProductApi() {
        CnabsApi.Init(token);

        String nameOrId = "371";
        String keywords="开元";
        var beginDate = new Date(2015 - 1900, 0, 1);
        var endDate = new Date(2021 - 1900, 0, 1);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = "2016-04-12 00:00:00";
        Date date = simpleDateFormat.parse(dateStr, new ParsePosition(0));

        var list = ProductService.getDealList(keywords, null, 2019, null, null);
        var detail = ProductService.getDealDetail(nameOrId);
        var dealDates = ProductService.getDealDates(nameOrId, null);
        var paymentDates = ProductService.getPaymentDates(nameOrId);
        var orgs = ProductService.getOrgs(nameOrId);
        var orgsByRole = ProductService.getOrgsByRole(nameOrId, "发起机构");
        var executions = ProductService.getExecutions(nameOrId);
        var snapshots = ProductService.getSnapshot(nameOrId, endDate);
        var snapshotsHistory = ProductService.getSnapshotsHistory(nameOrId, beginDate, endDate);
        var notes = ProductService.getNotes(nameOrId);
        var dealFeePaymentEntries = ProductService.getDealFeePayment(nameOrId, date);
        var dealCategoryEntries = ProductService.getDealCategories("CNABS");
        var balanceStatisticsEntriesCat = ProductService.getBalanceStatisticsByCatalog("2015", "2020", "CNABS");
        var balanceStatisticsEntriesExc = ProductService.getBalanceStatisticsByExchange("2015", "2020", "银行间债券市场");
        var balanceStatisticsEntriesOrg = ProductService.getBalanceStatisticsByOrg("2015", "2020", "招商银行股份有限公司");
    }

    @Test
    public void TestAllOrganization() {
        CnabsApi.Init(token);
        var organizationEntry = OrganizationService.getOrganization("1912");
        var organizationEntryList = OrganizationService.getOrganizations("","采矿业");
        var ratingEntries = OrganizationService.getOrgRatings("招商银行股份有限公司");
        var industrys = OrganizationService.getIndustry("证监会行业分类");
    }

    @Test
    public void TestAllProjectAudit() {
        var beginDate = new Date(2020 - 1900, 0, 1);
        var endDate = new Date(2020 - 1900, 1, 1);

        CnabsApi.Init(token);
        var exchangeStatistics = ProjectAuditService.getExchangeStatistic(beginDate, endDate, "number");
        var projectHistorys = ProjectAuditService.getProjectHistory("15095_SH");
        var ratingEntries = ProjectAuditService.getProjects("元", beginDate, endDate, "");
    }

    @Test
    public void TestAllOpendata() {
        var beginDate = new Date(2015 - 1900, 0, 1);
        var endDate = new Date(2021 - 1900, 0, 1);

        CnabsApi.Init(token);
        var holidayEntries = OpendataService.getHolidayList(2020);
        var dateType = OpendataService.getDateType(endDate);
        var map = OpendataService.getDateTypes(beginDate, endDate);
        var date = OpendataService.shiftTradingDays(endDate, "W+2", true);
        var rates = OpendataService.getRates();
        var val = OpendataService.getRateValue("CNS003M", endDate);
//        var rateValues = OpendataService.getRateValues("CNS003M", beginDate, endDate);
        var curves = OpendataService.getYieldCurves("短期融资券_A_0.083Y", null, null, null, 0.4f);
        var curvesValues = OpendataService.getYieldCurvesValues("短期融资券_A_0.083Y", null, null, null);
    }

    @Test
    public void TestAllSecurities() {
        var beginDate = new Date(2015 - 1900, 0, 1);
        var endDate = new Date(2020 - 1900, 9, 12);
        var securityId = "13573";

        CnabsApi.Init(token);
        var securitys = SecurityService.getSimpleList("和", beginDate, endDate, "已清算", 2020, null, "招商银行股份有限公司");
        var security = SecurityService.getSecurity(securityId);
        var securityRatingEntries = SecurityService.getRatingSnapshot("17031", null, null);
        var securityRatingEntriesHis = SecurityService.getRatingHistory(securityId, beginDate, endDate, null);
        var securityPaymentEntry = SecurityService.getPaymentInfo(securityId, endDate);
        var securityPaymentEntries = SecurityService.getPaymentInfos(securityId);
        var snapshots = SecurityService.getSnapshots(securityId, null, null);
        var snapshot = SecurityService.getSnapshot(securityId, null);
        var cashflowEntrys = SecurityService.getSchedulePayments(securityId);
        var securityCoupon = SecurityService.getSecurityCoupon(securityId);
        var securityCredits = SecurityService.getSecurityCredits(securityId);
        var updateEntries = SecurityService.getUpdatedNotesAll(endDate);
    }

    @Test
    public void TestAllAsset(){
        CnabsApi.Init(token);
        String dealNameOrId="6498";
        var date = new Date(2020 - 1900, 5, 30);
        var assetsDistributions = AssetService.getAssetsDistributions(dealNameOrId);
        var assetsDistributionEntries = AssetService.getAssetsDistributionItemsByName(dealNameOrId,date,"贷款逾期时间分布");
        var assetsSimpleDistributionEntries =  AssetService.getDefaultDistributions(dealNameOrId,date);
        var assetsSimpleDistributionEntries1 = AssetService.getDefaultStatusProcessDistributions(dealNameOrId,date);
        var assetsCashflowEntries = AssetService.getPromisedCashflows(dealNameOrId,date);
        var assetsRepaymentEntry = AssetService.getRepayment(dealNameOrId,date);
        var dateValueEntries = AssetService.getRepaymentDates(dealNameOrId);
        var simpleValueEntries =AssetService.getAssetsStatisticItems(dealNameOrId,"资产笔数",date);
    }
}
