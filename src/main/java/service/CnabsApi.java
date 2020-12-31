package service;

import org.jetbrains.annotations.Nullable;

public abstract class CnabsApi {
    public static String token;
    public static final String productPrefix = "https://api.cn-abs.com/";
    public static void Init(String tokenstr)
    {
        token=tokenstr;
    }
}
