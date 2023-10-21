package com.mkmi.api.luthier.FretboardCalculator;

import com.mkmi.api.luthier.FretboardCalculator.controller.SingleScaleController;
import com.mkmi.api.luthier.FretboardCalculator.model.FretboardDistancesResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleScaleControllerTests {

    private SingleScaleController controller;

    @BeforeEach
    public void setup() {
        controller = new SingleScaleController();
    }

    @Test
    public void testGenerateFretboardSVG() {
        double scaleLength = 25.5; // Replace with your desired scale length
        int fretCount = 24; // Replace with your desired fret count
        String measurementUnit = "mm"; // Replace with your desired measurement unit

        ResponseEntity<FretboardDistancesResponse> response = controller.generateFretboardSVG(scaleLength, fretCount, measurementUnit);
        FretboardDistancesResponse responseBody = response.getBody();

        // Perform assertions on the response
        assertEquals(200, response.getStatusCode().value()); // Check if the response status is OK
        assertEquals(fretCount, responseBody.getDistanceFromNut().size()); // Check the number of frets in the response
        assertEquals(fretCount, responseBody.getFretToFretDistance().size()); // Check the number of fret distances in the response
        // Add more assertions as needed based on your specific requirements
    }

    @Test
    public void testGenerateFretboardSVGWithInvalidMeasurementUnit() {
        double scaleLength = 25.5; // Replace with your desired scale length
        int fretCount = 24; // Replace with your desired fret count
        String invalidUnit = "invalid"; // An invalid measurement unit

        ResponseEntity<FretboardDistancesResponse> response = controller.generateFretboardSVG(scaleLength, fretCount, invalidUnit);

        // Check if the response status is Bad Request (400) for an invalid measurement unit
        assertEquals(400, response.getStatusCode().value());
    }
}
