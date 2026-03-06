package com.example.space.ingestion.primarymodel;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "minute_stats")
public class MinuteStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant minuteStart;

    private int uniqueIdCount;

    protected MinuteStats() {}

    public MinuteStats(Instant minuteStart, int uniqueIdCount) {
        this.minuteStart = minuteStart;
        this.uniqueIdCount = uniqueIdCount;
    }
}
