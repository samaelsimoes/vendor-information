package br.com.desafioNeomind.providerEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ProviderEntity extends GenericEntity {

	private String oid;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "comment", nullable = false)
	private String comment;
	
	@Column(name = "cnpj", nullable = false)
	private String cnpj;
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
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