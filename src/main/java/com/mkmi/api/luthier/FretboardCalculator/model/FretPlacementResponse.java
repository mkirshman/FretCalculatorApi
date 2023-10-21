package com.mkmi.api.luthier.FretboardCalculator.model;

public class FretPlacementResponse {
	private double scaleLength;
    private int fretCount;
    private String measurementUnit;
    // Add additional fields as needed

    public FretPlacementResponse(double scaleLength, int fretCount, String measurementUnit) {
        this.setScaleLength(scaleLength);
        this.setFretCount(fretCount);
        this.setMeasurementUnit(measurementUnit);
    }

	public double getScaleLength() {
		return scaleLength;
	}

	public void setScaleLength(double scaleLength) {
		this.scaleLength = scaleLength;
	}

	public int getFretCount() {
		return fretCount;
	}

	public void setFretCount(int fretCount) {
		this.fretCount = fretCount;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}


}
