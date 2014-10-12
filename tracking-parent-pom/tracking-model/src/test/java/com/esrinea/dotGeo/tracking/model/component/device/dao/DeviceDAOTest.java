package com.esrinea.dotGeo.tracking.model.component.device.dao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/tracking-model-test-context.xml" })
@Transactional
public class DeviceDAOTest {

	@Autowired
	private DeviceDAO deviceDAO;
	protected Device device;

	@Before
	public void setup() {
		device = deviceDAO.find(1);
		if (device == null)
			fail("Make sure you have inserted data from test-data.sql file");
	}

	@Ignore
	@Test
	public void testFindById() {
		assertEquals(1, device.getId());
	}

	@Ignore
	@Test
	public void testGetDeviceType() {
		DeviceType deviceType = device.getDeviceType();
		assertEquals(1, deviceType.getId());
	}

	@Ignore
	@Test
	public void testGetSensors() {
		Sensor oilSensor = device.getDeviceType().getSensors().get(0);
		assertEquals("OIL", oilSensor.getNameEn());
	}

	@Ignore
	@Test
	public void testGetAlerts() {
		Alert oilAlert = device.getDeviceType().getAlerts().get(0);
		assertEquals("Oil Alert", oilAlert.getNameEn());
	}

	@Ignore
	@Test
	public void testGetAlertConfigurations() {
		List<AlertConfiguration> oilAlertConfigurations = device.getDeviceType().getAlerts().get(0).getAlertConfigurations();
		assertEquals("In", oilAlertConfigurations.get(0).getSensorConfiguration().getTextValue());
	}

	@Ignore
	@Test
	public void testGetExecludedAlerts() {
		Alert oilAlert = device.getDeviceType().getAlerts().get(0);
		assertEquals("Oil Alert", device.getResource().getExecludedAlerts().get(oilAlert).getAlert().getNameEn());
	}

	@Test
	@Ignore
	public void testFindByIdQuery() {
		List<Device> devices = deviceDAO.findByIdQuery(1);
		// HEAT sensor should not be fetched
		for (Device device : devices) {
			List<Sensor> sensors = device.getDeviceType().getSensors();
			assertNotNull("Sensors should not be Null", sensors);
			for (Sensor sensor : sensors) {
				assertFalse("HEAT Sensor has been fetched while it's retired, review Device.findById query",
						"HEAT".equalsIgnoreCase(sensor.getNameEn()));
			}
		}
	}
	
	@Test
	public void testFindByIdCriteria(){
		Device device = deviceDAO.findByIdCriteria(1);
		List<Sensor> sensors = device.getDeviceType().getSensors();
		assertNotNull("Sensors should not be Null", sensors);
		for (Sensor sensor : sensors) {
			assertFalse("HEAT Sensor has been fetched while it's retired, review Device.findById query",
					"HEAT".equalsIgnoreCase(sensor.getNameEn()));
		}
	}
}