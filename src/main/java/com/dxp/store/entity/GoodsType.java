package com.dxp.store.entity;

public class GoodsType {
    private Integer typeId;
    private String typeName;
    private Double goodYf;
    private Double goodZf;

    public Double getGoodYf() {
        return goodYf;
    }

    public void setGoodYf(Double goodYf) {
        this.goodYf = goodYf;
    }

    public Double getGoodZf() {
        return goodZf;
    }

    public void setGoodZf(Double goodZf) {
        this.goodZf = goodZf;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
