package com.mkmi.api.luthier.FretboardCalculator.model;

import java.util.ArrayList;

public class FretboardDistancesResponse {
    private ArrayList<Double> distanceFromNut;
    private ArrayList<Double> fretToFretDistance;

    public FretboardDistancesResponse(ArrayList<Double> distanceFromNut, ArrayList<Double> fretToFretDistance) {
        this.setDistanceFromNut(distanceFromNut);
        this.setFretToFretDistance(fretToFretDistance);
    }

	public ArrayList<Double> getDistanceFromNut() {
		return distanceFromNut;
	}

	public void setDistanceFromNut(ArrayList<Double> distanceFromNut) {
		this.distanceFromNut = distanceFromNut;
	}

	public ArrayList<Double> getFretToFretDistance() {
		return fretToFretDistance;
	}

	public void setFretToFretDistance(ArrayList<Double> fretToFretDistance) {
		this.fretToFretDistance = fretToFretDistance;
	}

    // Add getters and setters for the fields
}