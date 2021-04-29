package com.agraminfotech.dairymanagement.security.setting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long>,SettingDao {

    public Setting findByUserId(Long userId);

    boolean existsByIdAndUserId(Long id, Long userId);
}
