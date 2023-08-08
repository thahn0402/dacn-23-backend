package nlu.dacn23backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "image_model")
public class ImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    //private String name;
    private String type;
    @Column(length = 5000000)
    private byte[] picByte;

    public ImageModel() {

    }

    public ImageModel(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    public String getType() {
        return type;
    }
    public byte[] getPicByte() {
        return picByte;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
    public long getId() {
        return id;
    }





    public void setType(String type) {
        this.type = type;
    }




}
