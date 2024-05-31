package com.ShopComputer.site.setting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShopComputer.EntityCommon.EmailSettingBag;
import com.ShopComputer.EntityCommon.Setting;
import com.ShopComputer.EntityCommon.SettingCategory;

@Service
public class SettingService {
	@Autowired
	private SettingRepository settingRepository;
	
	public List<Setting> findBySettingForSite(){
		List<Setting> listRs= new ArrayList<>();
		List<Setting> SettingGeneral= settingRepository.findBySettingCategory(SettingCategory.GENERAL);
		List<Setting> SettingCurrentcy= settingRepository.findBySettingCategory(SettingCategory.CURRENTCY);
		listRs.addAll(SettingCurrentcy);
		listRs.addAll(SettingGeneral);
		return listRs;
	}
	
	public EmailSettingBag getEmailSettings() {
		List<Setting> rs= new ArrayList<>();
		List<Setting> listSettingMailServer= settingRepository.findBySettingCategory(SettingCategory.MAIL_SERVER);
		List<Setting> listSettingMailTemplate= settingRepository.findBySettingCategory(SettingCategory.MAIL_TEMPLATES);
	    rs.addAll(listSettingMailTemplate);
	    rs.addAll(listSettingMailServer);
	    return new EmailSettingBag(rs);
	
	}

}
