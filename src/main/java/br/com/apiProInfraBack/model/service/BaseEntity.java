//package br.com.apiProInfraBack.model.service;
//
//import java.util.Calendar;
//
//import javax.persistence.Column;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.persistence.Version;
//
//import lombok.Getter;
//import lombok.ToString;
//
//@MappedSuperclass
//@Getter
//@ToString
//public abstract class BaseEntity {
//	
//	@Column(name = "data_criacao", nullable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	private Calendar creationDate;
//	
//	
//	@Column(name = "data_atualizacao")
//	@Temporal(TemporalType.TIMESTAMP)
//	private Calendar updateDate;
//
//	@Version
//	@Column(name = "numero_versao", nullable = false)
//	private Long version;
//
//
//	@PrePersist
//	public void prePersist() {
//		this.creationDate = Calendar.getInstance();
//	}
//
//	@PreUpdate
//	public void preUpdate() {
//		this.updateDate = Calendar.getInstance();
//	}
//}
