package dtomodel;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

@Data
public class SecurityRatingEntry extends RatingEntry {
    /**
     * 证券跟踪基准日
     */
    @Nullable
    public Date SecurityTrackingDate;

    /**
     * 资产跟踪基准日
     */
    @Nullable
    public Date AssetPoolTrackingDate;

    /**
     * 跟踪评级开始日
     */
    @Nullable
    public Date TrackingBeginDate;

    /**
     * 跟踪评级结束日
     */
    @Nullable
    public Date TrackingEndDate;
}
