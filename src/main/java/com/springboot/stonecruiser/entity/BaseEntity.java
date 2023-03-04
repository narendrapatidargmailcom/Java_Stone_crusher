package com.springboot.stonecruiser.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.springboot.stonecruiser.entity.User;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column
	public Long id;
	
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "lastUpdatedBy")
	private User lastUpdatedBy ;
	
	

}
