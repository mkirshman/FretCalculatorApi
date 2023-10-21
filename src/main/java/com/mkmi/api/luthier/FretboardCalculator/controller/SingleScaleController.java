package com.mkmi.api.luthier.FretboardCalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkmi.api.luthier.FretboardCalculator.model.FretboardDistancesResponse;

import java.util.ArrayList;

@RestController
@RequestMapping("/mk-fretboard-calculator/single-scale")
public class SingleScaleController {

    @GetMapping
    public ResponseEntity<FretboardDistancesResponse> calculateFretboard(
            @RequestParam("scaleLength") double scaleLength,
            @RequestParam("fretCount") int fretCount,
            @RequestParam("measurementUnit") String measurementUnit) {

        if (!isValidMeasurementUnit(measurementUnit)) {
            return ResponseEntity.badRequest().build();
        }
        
        //create a sringbuilder to build markup
        StringBuilder svgBuilder = new StringBuilder();
        //Open svg Markup
        svgBuilder.append("<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 255.19 2135.78\">\n");
        // Close the SVG markup
        svgBuilder.append("</svg>");

        ArrayList<Double> distanceFromNut = new ArrayList<>();
        ArrayList<Double> fretToFretDistance = new ArrayList<>();
        double cumulativeDistance = 0;
        double fretPosition = 0;

        if ("mm".equals(measurementUnit)) {
            scaleLength /= 25.4;
        }

        for (int i = 0; i < fretCount; i++) {
            fretPosition = scaleLength / 17.817;
            cumulativeDistance += fretPosition;

            if ("mm".equals(measurementUnit)) {
                fretPosition *= 25.4;
            }

            distanceFromNut.add((double) Math.round(fretPosition * 10000)/10000 );
            fretToFretDistance.add((double) Math.round(cumulativeDistance * 10000)/10000 );

            scaleLength -= fretPosition; // Update scaleLength for the next fret position
        }

        FretboardDistancesResponse response = new FretboardDistancesResponse( fretToFretDistance, distanceFromNut );

        return ResponseEntity.ok(response);
    }

    private boolean isValidMeasurementUnit(String unit) {
        return unit != null && (unit.equals("mm") || unit.equals("inch"));
    }
}

