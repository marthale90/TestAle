package com.example.testale.Server.Response;

public class ProductsResponse{
	private Owner owner;
	private String createdAt;
	private boolean jsonMemberDefault;
	private String visibility;
	private String name;
	private String description;
	private int id;
	private Products products;

	public void setOwner(Owner owner){
		this.owner = owner;
	}

	public Owner getOwner(){
		return owner;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setJsonMemberDefault(boolean jsonMemberDefault){
		this.jsonMemberDefault = jsonMemberDefault;
	}

	public boolean isJsonMemberDefault(){
		return jsonMemberDefault;
	}

	public void setVisibility(String visibility){
		this.visibility = visibility;
	}

	public String getVisibility(){
		return visibility;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setProducts(Products products){
		this.products = products;
	}

	public Products getProducts(){
		return products;
	}

	@Override
 	public String toString(){
		return 
			"ProductsResponse{" + 
			"owner = '" + owner + '\'' + 
			",createdAt = '" + createdAt + '\'' + 
			",default = '" + jsonMemberDefault + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",products = '" + products + '\'' + 
			"}";
		}
}
