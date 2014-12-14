package com.esrinea.dotGeo.tracking.model.component.resource.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.execludedAlert.entity.ExecludedAlert;
import com.esrinea.dotGeo.tracking.model.component.execludedSensor.entity.ExecludedSensor;
import com.esrinea.dotGeo.tracking.model.component.resourceGroup.entity.ResourceGroup;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;

/**
 * The persistent class for the Tracking_Resources database table.
 * 
 */
@Entity
@Table(name = "Tracking_Resources")
@NamedQuery(name="Resource.findByRetired",query="SELECT r FROM Resource r WHERE r.retired = :retired")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Resource_DBID", unique = true, nullable = false)
	private int id;

	@OneToMany(mappedBy = "resource", fetch = FetchType.EAGER)
	@MapKeyJoinColumn(name = "Alert_DBID")
	private Map<Alert, ExecludedAlert> execludedAlerts;

	@OneToMany(mappedBy = "resource", fetch = FetchType.EAGER)
	@MapKeyJoinColumn(name = "Sensor_DBID")
	private Map<Sensor, ExecludedSensor> execludedSensors;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "Device_DBID")
	private Device device;

	@OneToMany(mappedBy = "resource", fetch = FetchType.LAZY)
	private List<ResourceGroup> resourceGroups;

	@Column(name = "IsRetired")
	private boolean retired;

	public int getId() {
		return id;
	}

	public Map<Sensor, ExecludedSensor> getExecludedSensors() {
		return execludedSensors;
	}

	public Map<Alert, ExecludedAlert> getExecludedAlerts() {
		return execludedAlerts;
	}

	public List<ResourceGroup> getResourceGroups() {
		return resourceGroups;
	}

	public boolean isRetired() {
		return retired;
	}
	
	public void setResourceGroups(List<ResourceGroup> resourceGroups) {
		this.resourceGroups = resourceGroups;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", resourceGroups=" + resourceGroups + ", retired=" + retired + "]";
	}

}