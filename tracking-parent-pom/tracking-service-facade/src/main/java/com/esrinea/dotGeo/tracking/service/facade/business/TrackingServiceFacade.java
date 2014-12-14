package com.esrinea.dotGeo.tracking.service.facade.business;

import com.esri.ges.core.geoevent.GeoEvent;
import com.esrinea.dotGeo.tracking.service.facade.dto.EventData;

/**
 * A facade that combines different tracking services together to fill the database with the data received from the GeoEvent based on the given scenario.<br>
 * The reason for separating this thin application is to be able to change and deploy it without changing the GeoEvent's tracking-processor or tracking-service applications.
 * 
 * @author islam.zenbaei
 *
 */
public interface TrackingServiceFacade {

	void process(GeoEvent geoEvent);

	void deviceFeedReceived(EventData eventData);
}
