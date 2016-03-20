//$Id: Music.java 14736 2008-06-04 14:23:42Z hardy.ferentschik $
package org.hibernate.test.annotations.inheritance.singletable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DiscriminatorFormula;

/**
 * @author Emmanuel Bernard
 */
@Entity
@DiscriminatorFormula("case when zik_type is null then 0 else zik_type end")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"avgBeat", "starred"} ))
public abstract class Music {
	private Integer id;
	private int avgBeat;
	private Integer type;

	@Column(name = "zik_type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAvgBeat() {
		return avgBeat;
	}

	public void setAvgBeat(int avgBeat) {
		this.avgBeat = avgBeat;
	}
}
