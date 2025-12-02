package edu.pitt.se;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistRecommenderTest {

    // -------- classifyEnergy tests --------

    @Test
    public void classifyEnergyHighWhenAverageAtLeast140() {
        assertEquals("HIGH",
                PlaylistRecommender.classifyEnergy(Arrays.asList(150, 140)));
    }

    @Test
    public void classifyEnergyMediumBetween100And139() {
        assertEquals("MEDIUM",
                PlaylistRecommender.classifyEnergy(Arrays.asList(100, 120)));
    }

    @Test
    public void classifyEnergyLowBelow100() {
        assertEquals("LOW",
                PlaylistRecommender.classifyEnergy(Arrays.asList(80, 90)));
    }

    @Test
    public void classifyEnergyRejectsNullOrEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> PlaylistRecommender.classifyEnergy(null));

        assertThrows(IllegalArgumentException.class,
                () -> PlaylistRecommender.classifyEnergy(Collections.emptyList()));
    }

    // -------- isValidTrackTitle tests --------

    @Test
    public void validTrackTitleLettersAndSpaces() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Soft Jazz Mix"));
        assertTrue(PlaylistRecommender.isValidTrackTitle("Pop"));
    }

    @Test
    public void invalidTrackTitleCases() {
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
        assertFalse(PlaylistRecommender.isValidTrackTitle(""));
        assertFalse(PlaylistRecommender.isValidTrackTitle("This title is definitely more than thirty characters"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("Rock123"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("Rock&Roll"));
    }

    // -------- normalizeVolume tests --------

    @Test
    public void normalizeVolumeWithinRange() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(0));
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
        assertEquals(100, PlaylistRecommender.normalizeVolume(100));
    }

    @Test
    public void normalizeVolumeClampsBelowOrAbove() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-10));
        assertEquals(100, PlaylistRecommender.normalizeVolume(120));
    }
}
