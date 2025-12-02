package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    /**
     * Return:
     * - "HIGH" if average BPM >= 140
     * - "MEDIUM" if average BPM between 100–139
     * - "LOW" if average BPM < 100
     * Reject null or empty list
     */
    public static String classifyEnergy(List<Integer> bpms) {
        if (bpms == null || bpms.isEmpty()) {
            throw new IllegalArgumentException("BPM list must not be null or empty");
        }

        double sum = 0;
        for (Integer bpm : bpms) {
            if (bpm == null) {
                throw new IllegalArgumentException("BPM list must not contain null values");
            }
            sum += bpm;
        }

        double avg = sum / bpms.size();

        if (avg >= 140) {
            return "HIGH";
        } else if (avg >= 100) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    /**
     * Valid track title:
     * - 1 to 30 characters
     * - Only letters and spaces
     * Reject null, empty, too long, or containing anything else.
     */
    public static boolean isValidTrackTitle(String title) {
        if (title == null) {
            return false;
        }

        String trimmed = title.trim();

        if (trimmed.isEmpty() || trimmed.length() > 30) {
            return false;
        }

        // Only letters A–Z and spaces
        return trimmed.matches("[A-Za-z ]+");
    }

    /**
     * Clamp volume into [0, 100]
     */
    public static int normalizeVolume(int volumeDb) {
        if (volumeDb < 0) {
            return 0;
        } else if (volumeDb > 100) {
            return 100;
        } else {
            return volumeDb;
        }
    }
}
