package models;

import java.util.List;

public class AboutVga {
    private String brand;
    private String model;
    private int memory;
    private List<String> purpose;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMemory() {
        return memory;
    }

    public List<String> getPurpose() {
        return purpose;
    }
}