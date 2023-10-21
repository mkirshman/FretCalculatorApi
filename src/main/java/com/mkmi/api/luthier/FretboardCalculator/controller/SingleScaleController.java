package com.mkmi.api.luthier.FretboardCalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkmi.api.luthier.FretboardCalculator.model.SingleScaleResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mk-fretboard-calculator/single-scale")
public class SingleScaleController {

    @GetMapping
    public static ResponseEntity<SingleScaleResponse> generateFretboardSVG(
            @RequestParam("scaleLength") double scaleLength,
            @RequestParam("fretCount") int fretCount,
            @RequestParam("measurementUnit") String measurementUnit) {

        if (!isValidMeasurementUnit(measurementUnit)) {
            return ResponseEntity.badRequest().build();
        }

        // Calculate fret distances and create SVG string
        StringBuilder svgBuilder = new StringBuilder();
        svgBuilder.append("<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 255.19 2135.78\">\r\n"
        		+ "<defs>\r\n"
        		+ "<style>.cls-1{fill:none;stroke:#000;stroke-linecap:round;stroke-linejoin:round;stroke-width:0.72px;}</style>\r\n"
        		+ "</defs>\r\n"
        		+ "<g id=\"Layer_2\" data-name=\"Layer 2\">\r\n"
        		+ "<g id=\"svg2\">\r\n"
        		+ "<g id=\"_0cf9e02c-255e-4cd6-a565-3a4cbe85c558\" data-name=\"0cf9e02c-255e-4cd6-a565-3a4cbe85c558\">\r\n"
        		+ "<path class=\"cls-1\" d=\"M155.81,395.79l-.23.1a2.74,2.74,0,0,1-1.22.29,2.79,2.79,0,0,1-2.78-2.75h0V363.75l-27.3,26.16L97,363.8v29.59h0v0a2.79,2.79,0,0,1-2.79,2.78,2.66,2.66,0,0,1-.9-.15l-.22-.06,12.72,12.08V384.35l18.5,17.55,18.45-17.68v23.84l13.08-12.27\"/>\r\n"
        		+ "<path class=\"cls-1\" d=\"M148.94,424.08a5.44,5.44,0,0,1-2.45-1.23l-22.21-21v0l-22.21,21a5.43,5.43,0,0,1-2.45,1.22,2.89,2.89,0,0,1-2.6-1.62V440l27.26-26v0L151.54,440V422.46a2.89,2.89,0,0,1-2.6,1.62\"/>\r\n"
        		+ "<path class=\"cls-1\" d=\"M155.47,124.57a14.08,14.08,0,1,1-14.07-14.08,14.08,14.08,0,0,1,14.07,14.08\"/>\r\n"
        		+ "<path class=\"cls-1\" d=\"M180.46,196.57a14.08,14.08,0,1,1-14.08-14.08,14.08,14.08,0,0,1,14.08,14.08\"/>\r\n"
        		+ "<path class=\"cls-1\" d=\"M204.85,268.07A14.08,14.08,0,1,1,190.77,254a14.07,14.07,0,0,1,14.08,14.08\"/>\r\n"
        		+ "<path class=\"cls-1\" d=\"M83.64,268.07A14.08,14.08,0,1,0,97.71,254a14.07,14.07,0,0,0-14.07,14.08\"/>\r\n"
        		+ "<path class=\"cls-1\" d=\"M59.05,340.57a14.08,14.08,0,1,0,14.07-14.08,14.08,14.08,0,0,0-14.07,14.08\"/>\r\n"
        		+ "<path class=\"cls-1\" d=\"M33.65,412.57a14.08,14.08,0,1,0,14.08-14.08,14.08,14.08,0,0,0-14.08,14.08\"/>\r\n"
        		+ "</g>\r\n"
        		+ "<g id=\"_4a7e8b8e-4e17-4234-b908-591343cbd72c\" data-name=\"4a7e8b8e-4e17-4234-b908-591343cbd72c\">\r\n"
        		+ "<path class=\"cls-1\" d=\"M79.93,1.33C98.74-9.38,135.7,71.8,158.5,70.72c2.08-.1,99.28,283.29,96.26,285.57-63.54,47.89-68.77,65.58-69.14,135.2-.05,9.58.11,46,.35,88.15L197,2116.75v.07a18.29,18.29,0,0,1-18,18.6H59.26a18,18,0,0,1-18-18l0-2.36L51.35,737.33H50.7c.15-15,1.34-110.19,1.95-178.14L53,516.58h0c.08-12.33.08-21.27,0-25.09.06-15.05-20.65-41.67-52.56-49-1.93-.44,73.51-211.47,74.09-213.61,73.45-2.11,5.38-225.31,5.44-227.59\"/>\r\n"
        		+ "</g>");

        double initialX1 = 53.36;
        double finalX1 = 45.36;
        double x1Increment = (finalX1 - initialX1) / (fretCount - 1); // Subtract 1 because you're including the first fret.
        double x1 = initialX1;

        double initialX2 = 185.36;
        double finalX2 = 196.36;
        double x2Increment = (finalX2 - initialX2) / (fretCount - 1); // Subtract 1 because you're including the first fret.
        double x2 = initialX2;
      
        double yCoordinate = 23.6;
   

        ArrayList<Double> distanceFromNut = new ArrayList<>();
        ArrayList<Double> fretToFretDistance = new ArrayList<>();
        double cumulativeDistance = 0;
        double fretPosition = 0;

        if ("mm".equals(measurementUnit)) {
            scaleLength /= 25.4;
        }
        
        
     
        
        for (int i = 0; i < fretCount; i++) {
            // Calculate fret position here based on scaleLength
        	//percentages = [(distance - 0) / (total_length - 0) * 100 for distance in distanceFromNut]
        	 fretPosition = scaleLength / 17.817;
             cumulativeDistance += fretPosition;
             scaleLength -= fretPosition;

             if ("mm".equals(measurementUnit)) {
                 fretPosition *= 25.4;
             }
             // Populate distanceFromNut and fretToFretDistance
             // Append distances to the lists
             
             distanceFromNut.add((double) Math.round(cumulativeDistance * 10000) / 10000);
             fretToFretDistance.add((double) Math.round(fretPosition * 10000) / 10000);

            
            

        }
        
        // Total length in inches

        List<Double> percentages = new ArrayList<>();
        
        for (double distance : distanceFromNut) {
            percentages.add((distance - 0) / (cumulativeDistance - 0) * 98);
        }
        
        for (double percentage : percentages) {
//        	yCoordinate = 23.6 + (percentage * 0.776);
        	// Append a line element to the SVG markup with updated x1 and x2 values
        	svgBuilder.append("<line class=\"cls-1\" x1=\"").append(x1).append("\" y1=\"").append(yCoordinate+"%")
            .append("\" x2=\"").append(x2).append("\" y2=\"").append(yCoordinate+"%").append("\"/>\n");
        	yCoordinate = 23.6 + (percentage * 0.776);
        	// Update x1 and x2 for the next fret position
            x1 += x1Increment;
            x2 += x2Increment;

        }

        svgBuilder.append("</g></g></svg>");
        
       String svgOutput = svgBuilder.toString();
       svgOutput = svgOutput.replaceAll("\\\"", "'");
       svgOutput = svgOutput.replaceAll("\\n", "");
       svgOutput = svgOutput.replaceAll("\\r", "");



        // Create a MultiScaleResponse object to hold SVG and distance data
        SingleScaleResponse response = new SingleScaleResponse(distanceFromNut, fretToFretDistance);
        response.setSvg(svgOutput);
        response.setFretToFretDistance(fretToFretDistance);
        response.setDistanceFromNut(distanceFromNut);

        return ResponseEntity.ok(response);
    }
    

    private static boolean isValidMeasurementUnit(String unit) {
        return unit != null && (unit.equals("mm") || unit.equals("inch"));
    }
}
