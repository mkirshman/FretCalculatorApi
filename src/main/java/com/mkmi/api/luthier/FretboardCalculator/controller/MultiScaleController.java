package com.mkmi.api.luthier.FretboardCalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkmi.api.luthier.FretboardCalculator.model.MultiScaleResponse;
import com.mkmi.api.luthier.FretboardCalculator.model.SingleScaleResponse;

import java.util.ArrayList;

@RestController
@RequestMapping("/mk-fretboard-calculator/multi-scale")
public class MultiScaleController {

    @GetMapping
    public ResponseEntity<MultiScaleResponse> generateFretboardSVG(
            @RequestParam("scaleLengthHigh") double scaleLengthHigh,
            @RequestParam("scaleLengthLow") double scaleLengthLow,
            @RequestParam("measurementUnit") String measurementUnit) {

        if (!isValidMeasurementUnit(measurementUnit)) {
            return ResponseEntity.badRequest().build();
        }

        // Calculate fretboard positions for the bass and treble scales
        ResponseEntity<SingleScaleResponse> bassResponse = SingleScaleController.generateFretboardSVG(scaleLengthLow, 24, measurementUnit);
        ResponseEntity<SingleScaleResponse> trebleResponse = SingleScaleController.generateFretboardSVG(scaleLengthHigh, 24, measurementUnit);

        SingleScaleResponse bassResponseBody = bassResponse.getBody();
        SingleScaleResponse trebleResponseBody = trebleResponse.getBody();
        // Create a MultiScaleResponse object to hold SVG and distance data for both scales
        MultiScaleResponse response = new MultiScaleResponse(
        		bassResponseBody.getDistanceFromNut(),
        		bassResponseBody.getFretToFretDistance(),
        		trebleResponseBody.getDistanceFromNut(),
        		trebleResponseBody.getFretToFretDistance()
        );

        return ResponseEntity.ok(response);
    }

    private boolean isValidMeasurementUnit(String unit) {
        return unit != null && (unit.equals("mm") || unit.equals("inch"));
    }
}
