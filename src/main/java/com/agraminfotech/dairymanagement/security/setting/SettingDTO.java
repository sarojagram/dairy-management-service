package com.agraminfotech.dairymanagement.security.setting;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class SettingDTO {

    private BigInteger Id;

    private String operationDateSetting;
}
