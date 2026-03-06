package com.example.space.ingestion.primaryrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.space.ingestion.primarymodel.MinuteStats;

public interface MinuteStatsRepository
        extends JpaRepository<MinuteStats, Long> {
}
