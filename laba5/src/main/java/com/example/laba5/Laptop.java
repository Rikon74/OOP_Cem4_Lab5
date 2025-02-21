package com.example.laba5;

public class Laptop {
    private int id;
    private String fabric;
    private String model;
    private String cpu;
    private int ram;
    private int hdd;


    public Laptop(int id, String fabric, String model, String cpu, int ram, int hdd) {
        this.fabric = fabric;
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }
}
