package com.agraminfotech.dairymanagement.security.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SettingService {

    private SettingRepository settingRepository;

    @Autowired
    private SettingService(SettingRepository settingRepository){
        this.settingRepository = settingRepository;
    }

    public Setting saveOrUpdate(Setting setting){
        return settingRepository.save(setting);
    }

    public Setting findByUserId(Long userId){
        return settingRepository.findByUserId(userId);
    }

    public SettingDTO findBasicSettingByUserId(Long userId){
        return settingRepository.findBasicByUserId(userId);
    }

    public boolean existsByIdAndUserId(Long id, Long userId){
        return settingRepository.existsByIdAndUserId(id,userId);
    }

    public String getUserOperationDateSetting(Long userId){
        return settingRepository.getUserOperationDateSetting(userId);
    }

    public boolean isUserSettingAlreadyPresent(Long userId){
        return settingRepository.isUserSettingAlreadyPresent(userId);
    }

    public Long getUserSettingIdByUserId(Long userId) {
        return  settingRepository.getUserSettingIdByUserId(userId);
    }
}
