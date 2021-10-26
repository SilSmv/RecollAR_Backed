package com.recollar.recollar_backend.dto;
public class ObjectSimpleRequest {
    private Integer idObject;
    private String name;
    private String image;
    private boolean ar;
   public ObjectSimpleRequest(ObjectSimpleRequestInterface osri){
       this.idObject=osri.getIdObject();
       this.name=osri.getName();
       this.image=osri.getImage();
       this.ar=osri.getAr();
   }
   public ObjectSimpleRequest(){}
    public Integer getIdObject() {
        return idObject;
    }

    public String getName() {
        return name;
    }

    public void setIdObject(Integer idObject) {
        this.idObject = idObject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getAr() {
        return ar;
    }

    public void setAr(boolean ar) {
        this.ar = ar;
    }
}
