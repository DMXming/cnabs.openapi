package dtomodel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealEntry extends Deal implements Serializable {
    @Nullable
    public Double TotalOfferingExpected;
    @Nullable
    public Double TotalOffering;
    @Nullable
    public Date CutOffDate;
    @Nullable
    public Date FirstInterestAccrualDate;
    @Nullable
    public Date LegalMaturityDate;

    public String Exchange;

    public String Regulator;

    public boolean IsReinvestment;
    @Nullable
    public Date ReinvestmentEndDate;

    public String IssueType;

    public String Status;

    public String CNABSCategory1;

    public String CNABSCategory2;

    public String CNABSCategory3;

    @Nullable
    public Double EquityPercentage;

    public String Frequency;

    public String DayRule;

    public String FundUses;

    public String RegistrationNumber;

    @Nullable
    public Date RegistrationDate;

    public String ExchangeRegisterFileNumber;

    @Nullable
    public Date LastPaymentDate;

    @Nullable
    public Date NextPaymentDate;

}

