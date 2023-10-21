package com.mkmi.api.luthier.FretboardCalculator.model;

import java.util.ArrayList;

public class MultiScaleResponse {
	private String svg;
    private ArrayList<Double> distanceFromNutBass;
    private ArrayList<Double> fretToFretDistanceBass;
    private ArrayList<Double> distanceFromNutTreble;
    private ArrayList<Double> fretToFretDistanceTreble;
    
    public MultiScaleResponse(ArrayList<Double> distanceFromNutBass, ArrayList<Double> fretToFretDistanceBass, 
    							ArrayList<Double> distanceFromNutTreble, ArrayList<Double> fretToFretDistanceTreble) {
        this.setDistanceFromNutBass(distanceFromNutBass);
        this.setFretToFretDistanceBass(fretToFretDistanceBass);
        this.setDistanceFromNutTreble(distanceFromNutTreble);
        this.setFretToFretDistanceTreble(fretToFretDistanceTreble);
    }
    
	public String getSvg() {
		return svg;
	}
	
	public void setSvg(String svg) {
		this.svg = svg;
	}

	public ArrayList<Double> getDistanceFromNutBass() {
		return distanceFromNutBass;
	}

	public void setDistanceFromNutBass(ArrayList<Double> distanceFromNutBass) {
		this.distanceFromNutBass = distanceFromNutBass;
	}

	public ArrayList<Double> getFretToFretDistanceBass() {
		return fretToFretDistanceBass;
	}

	public void setFretToFretDistanceBass(ArrayList<Double> fretToFretDistanceBass) {
		this.fretToFretDistanceBass = fretToFretDistanceBass;
	}

	public ArrayList<Double> getDistanceFromNutTreble() {
		return distanceFromNutTreble;
	}

	public void setDistanceFromNutTreble(ArrayList<Double> distanceFromNutTreble) {
		this.distanceFromNutTreble = distanceFromNutTreble;
	}

	public ArrayList<Double> getFretToFretDistanceTreble() {
		return fretToFretDistanceTreble;
	}

	public void setFretToFretDistanceTreble(ArrayList<Double> fretToFretDistanceTreble) {
		this.fretToFretDistanceTreble = fretToFretDistanceTreble;
	}
	
	
}
