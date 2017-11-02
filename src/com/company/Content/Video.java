package com.company.Content;

public class Video implements Content{
    private String name;
    private String description;

    public Video(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void show(){
        System.out.println(String.format("video: %s, description: %s",name,description));
    }
}
