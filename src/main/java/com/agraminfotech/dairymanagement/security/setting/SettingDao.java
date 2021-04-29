package com.agraminfotech.dairymanagement.security.setting;

public interface SettingDao {

    SettingDTO findBasicByUserId(Long userId);

    String getUserOperationDateSetting(Long userId);

    boolean isUserSettingAlreadyPresent(Long userId);

    Long getUserSettingIdByUserId(Long userId);
}
