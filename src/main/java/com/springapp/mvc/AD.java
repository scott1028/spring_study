package com.springapp.mvc;

import javax.persistence.*;

/**
 * Created by scottlan on 2014/7/31.
 */

// will auto mapping Database Table by property. then use getter/setting for operation.
@Entity(name = "ads")
public class AD {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Ads_id;
    private String Ads_Image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdsId(){ return Ads_id; }

    public String getAdsImage(){ return Ads_Image; }
}
