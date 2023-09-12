package org.tensorflow.lite.examples.objectdetection;

public class DataPage {
    int color;
    String title;

    int imageId;

    public DataPage(int color, String title){
        this.color = color;
        this.title = title;
        this.imageId = -1;
    }

    public DataPage(int color, String title, int imageId){
        this.color = color;
        this.title = title;
        this.imageId = imageId;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
