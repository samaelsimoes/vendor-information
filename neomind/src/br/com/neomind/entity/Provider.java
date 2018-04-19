package br.com.neomind.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "neomind")
public class Provider {
	
	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String email;	
	
	@Column
	private String comment;	
	
	@Column
	private String cnpj;
	
	 public int getId() {
        return id;
	}
	public void setId(int id) {
	    this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return email;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
