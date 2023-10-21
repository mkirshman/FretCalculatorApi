package com.mkmi.api.luthier.FretboardCalculator;

import com.mkmi.api.luthier.FretboardCalculator.model.FretboardDistancesResponse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FretboardDistancesResponseTests {

    @Test
    public void testFretboardDistancesResponse() {
        // Create sample data
        ArrayList<Double> distanceFromNut = new ArrayList<>();
        ArrayList<Double> fretToFretDistance = new ArrayList<>();
        String svg = "<svg>Sample SVG</svg>";

        // Create an instance of FretboardDistancesResponse
        FretboardDistancesResponse response = new FretboardDistancesResponse(distanceFromNut, fretToFretDistance);
        response.setSvg(svg);

        // Check if the getters return the expected values
        assertEquals(distanceFromNut, response.getDistanceFromNut());
        assertEquals(fretToFretDistance, response.getFretToFretDistance());
        assertEquals(svg, response.getSvg());
    }

    @Test
    public void testSetters() {
        // Create an instance of FretboardDistancesResponse
        FretboardDistancesResponse response = new FretboardDistancesResponse(new ArrayList<>(), new ArrayList<>());

        // Test the setters
        ArrayList<Double> distanceFromNut = new ArrayList<>();
        ArrayList<Double> fretToFretDistance = new ArrayList<>();
        String svg = "<svg>Updated SVG</svg>";

        response.setDistanceFromNut(distanceFromNut);
        response.setFretToFretDistance(fretToFretDistance);
        response.setSvg(svg);

        // Check if the getters return the updated values
        assertEquals(distanceFromNut, response.getDistanceFromNut());
        assertEquals(fretToFretDistance, response.getFretToFretDistance());
        assertEquals(svg, response.getSvg());
    }
}

