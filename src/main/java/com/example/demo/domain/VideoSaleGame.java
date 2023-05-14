package com.example.demo.domain;

import com.example.demo.anotation.TypeJson;

import java.math.BigDecimal;

public class VideoSaleGame {

    private String publisher;
    private BigDecimal naSales;
    private BigDecimal euSales;
    private BigDecimal jpSales;
    private String name;
    private String platform;
    @TypeJson(typeClass = ShortInfo.class)
    private ShortInfo shortInfo;
    private BigDecimal year;
    private String genre;
    private BigDecimal otherSales;
    private String saleName;
    private BigDecimal globalSales;
    private BigDecimal rank;

    public ShortInfo getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(ShortInfo shortInfo) {
        this.shortInfo = shortInfo;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public BigDecimal getRank() {
        return rank;
    }

    public void setRank(BigDecimal rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public BigDecimal getYear() {
        return year;
    }

    public void setYear(BigDecimal year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getNaSales() {
        return naSales;
    }

    public void setNaSales(BigDecimal naSales) {
        this.naSales = naSales;
    }

    public BigDecimal getEuSales() {
        return euSales;
    }

    public void setEuSales(BigDecimal euSales) {
        this.euSales = euSales;
    }

    public BigDecimal getJpSales() {
        return jpSales;
    }

    public void setJpSales(BigDecimal jpSales) {
        this.jpSales = jpSales;
    }

    public BigDecimal getOtherSales() {
        return otherSales;
    }

    public void setOtherSales(BigDecimal otherSales) {
        this.otherSales = otherSales;
    }

    public BigDecimal getGlobalSales() {
        return globalSales;
    }

    public void setGlobalSales(BigDecimal globalSales) {
        this.globalSales = globalSales;
    }
}
