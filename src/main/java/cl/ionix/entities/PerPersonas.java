package cl.ionix.entities;
// Generated 21-jul-2020 7:37:34 by Hibernate Tools 5.2.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PerPersonas generated by hbm2java
 */
@Entity
@Table(name = "per_personas", catalog = "prueba")
public class PerPersonas implements java.io.Serializable {

	private Integer id;
	private String name;
	private String apellidos;
	private Set<RlcEmpresasPersonas> rlcEmpresasPersonases = new HashSet<RlcEmpresasPersonas>(0);

	public PerPersonas() {
	}

	public PerPersonas(String name, String apellidos, Set<RlcEmpresasPersonas> rlcEmpresasPersonases) {
		this.name = name;
		this.apellidos = apellidos;
		this.rlcEmpresasPersonases = rlcEmpresasPersonases;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "apellidos")
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perPersonas")
	public Set<RlcEmpresasPersonas> getRlcEmpresasPersonases() {
		return this.rlcEmpresasPersonases;
	}

	public void setRlcEmpresasPersonases(Set<RlcEmpresasPersonas> rlcEmpresasPersonases) {
		this.rlcEmpresasPersonases = rlcEmpresasPersonases;
	}

}
