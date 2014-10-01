INSERT INTO TRACKING_DEVICE_TYPES (DEVICETYPE_DESC) VALUES ('ENFORA 5002');

INSERT INTO TRACKING_DEVICES (DEVICETYPE_DBID) VALUES (1);

INSERT INTO TRACKING_RESOURCES (DEVICE_DBID) VALUES(1);

INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN) VALUES(1, 'OIL');
INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN) VALUES(1, 'TEMP');
INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN) VALUES(1, 'HEAT'); --will be execluded


INSERT INTO RESOURCE_EXECLUDED_SENSORS (RESOURCE_DBID, SENSOR_DBID) VALUES(1, 3);

--Temp Sensor Configurations
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, MAXVALUE,MINVALUE,CONFIG_TEXT) values (2, 43.13846153, 25.0, 'Low');
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, MAXVALUE,MINVALUE,CONFIG_TEXT) values (2, 90.0, 43.13846153, 'Med');
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, MAXVALUE,MINVALUE,CONFIG_TEXT) values (2, 100.0, 90.0, 'High');
--Oil Sensor Configurations
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, TEXTVALUE) values (1, 'In');
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, TEXTVALUE) values (1, 'Out');

--Alerts
INSERT INTO dbo.Alerts (name_en, devicetype_dbid) VALUES ('Oil Alert', 1);
INSERT INTO dbo.Alerts (name_en, devicetype_dbid) VALUES ('Temp Alert', 1);

--Temp Alert Configurations
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, isretired ) values (2, 1, 0);
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, isretired ) values (2, 2, 0);
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, isretired ) values (2, 3, 1);
--Oil Alert Configurations
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, isretired ) values (1, 4, 0);
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, isretired ) values (1, 5, 0);

--SELECT * FROM TrackingFinalV1.dbo.sensor_configuration;
--SELECT * FROM sensor_configuration;

--SELECT * FROM TrackingFinalV1.dbo.sensors_liveFeeds;
