package com.concordia.microservices.QualitySettingsservice;

public class QualitySettings {
    private String name;
    private String profile;
    private QualityData data;

    public QualitySettings() {
    }

    public QualitySettings(String name, String profile, QualityData data) {
        this.name = name;
        this.profile = profile;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public QualityData getData() {
        return data;
    }

    public void setData(QualityData data) {
        this.data = data;
    }

    public static class QualityData {
        private int minBitrate;
        private int maxBitrate;

        public QualityData() {
        }

        public QualityData(int minBitrate, int maxBitrate) {
            this.minBitrate = minBitrate;
            this.maxBitrate = maxBitrate;
        }

        public int getMinBitrate() {
            return minBitrate;
        }

        public void setMinBitrate(int minBitrate) {
            this.minBitrate = minBitrate;
        }

        public int getMaxBitrate() {
            return maxBitrate;
        }

        public void setMaxBitrate(int maxBitrate) {
            this.maxBitrate = maxBitrate;
        }
    }
}
