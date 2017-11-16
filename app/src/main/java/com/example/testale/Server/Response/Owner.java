package com.example.testale.Server.Response;

public class Owner{
	private String name;
	private String email;
	private String linioId;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setLinioId(String linioId){
		this.linioId = linioId;
	}

	public String getLinioId(){
		return linioId;
	}

	@Override
 	public String toString(){
		return 
			"Owner{" + 
			"name = '" + name + '\'' + 
			",email = '" + email + '\'' + 
			",linioId = '" + linioId + '\'' + 
			"}";
		}
}
