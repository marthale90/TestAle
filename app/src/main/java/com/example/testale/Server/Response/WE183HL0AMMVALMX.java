package com.example.testale.Server.Response;

public class WE183HL0AMMVALMX{
	private String image;
	private boolean freeShipping;
	private boolean imported;
	private String name;
	private boolean active;
	private int wishListPrice;
	private String conditionType;
	private int id;
	private int linioPlusLevel;
	private String slug;
	private String url;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setFreeShipping(boolean freeShipping){
		this.freeShipping = freeShipping;
	}

	public boolean isFreeShipping(){
		return freeShipping;
	}

	public void setImported(boolean imported){
		this.imported = imported;
	}

	public boolean isImported(){
		return imported;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setWishListPrice(int wishListPrice){
		this.wishListPrice = wishListPrice;
	}

	public int getWishListPrice(){
		return wishListPrice;
	}

	public void setConditionType(String conditionType){
		this.conditionType = conditionType;
	}

	public String getConditionType(){
		return conditionType;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLinioPlusLevel(int linioPlusLevel){
		this.linioPlusLevel = linioPlusLevel;
	}

	public int getLinioPlusLevel(){
		return linioPlusLevel;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"WE183HL0AMMVALMX{" + 
			"image = '" + image + '\'' + 
			",freeShipping = '" + freeShipping + '\'' + 
			",imported = '" + imported + '\'' + 
			",name = '" + name + '\'' + 
			",active = '" + active + '\'' + 
			",wishListPrice = '" + wishListPrice + '\'' + 
			",conditionType = '" + conditionType + '\'' + 
			",id = '" + id + '\'' + 
			",linioPlusLevel = '" + linioPlusLevel + '\'' + 
			",slug = '" + slug + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}
