package wizut.tpsi.ogloszenia.web;


public class OfferFilter {

    public static final Integer OFFERS_PER_PAGE= 20;

    private Integer actualPage;

    private Integer manufacturerId;
    private Integer modelId;
    private Integer yearFrom;
    private Integer yearTo;
    private Integer fuelTypeId;
    private Integer priceFrom;
    private Integer priceTo;
    private Integer sortOption;

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }

    public Integer getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(Integer fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public Integer getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Integer priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Integer getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Integer priceTo) {
        this.priceTo = priceTo;
    }

    public Integer getActualPage() {
        return actualPage;
    }

    public void setActualPage(Integer actualPage) {
        this.actualPage = actualPage;
    }

    public Integer getSortOption() {
        return sortOption;
    }

    public void setSortOption(Integer sortOption) {
        this.sortOption = sortOption;
    }

    @Override
    public String toString() {
        if(manufacturerId!=null || modelId!=null || yearFrom!=null || yearTo!=null || fuelTypeId!=null || priceFrom!=null || priceTo!=null || sortOption!=null){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("?manufacturerId=").append(manufacturerId!=null?manufacturerId:"");
            stringBuilder.append("&modelId=").append(modelId!=null?modelId:"");
            stringBuilder.append("&yearFrom=").append(yearFrom!=null?yearFrom:"");
            stringBuilder.append("&yearTo=").append(yearTo!=null?yearTo:"");
            stringBuilder.append("&fuelTypeId=").append(fuelTypeId!=null?fuelTypeId:"");
            stringBuilder.append("&priceFrom=").append(priceFrom!=null?priceFrom:"");
            stringBuilder.append("&priceTo=").append(priceTo!=null?priceTo:"");
            stringBuilder.append("&sortOption=").append(sortOption!=null?sortOption:"");
            return stringBuilder.toString();
        }
        else {
            return "";
        }
    }

}
