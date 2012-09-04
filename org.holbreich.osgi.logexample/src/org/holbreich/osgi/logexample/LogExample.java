package org.holbreich.osgi.logexample;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.log.LogService;

public class LogExample  {

	private LogService logService;
	
	
	
	public LogExample() {
		super();
	}


	protected void setLogService(LogService logService) {
		this.logService = logService;
	}


	protected void unsetLogService() {
		logService=null;
	}


	public void activate(ComponentContext context) {
		this.logService.log(LogService.LOG_INFO, "Start LogExample component");
	}


	public void deactivate(ComponentContext context) {
		this.logService.log(LogService.LOG_INFO, "Stoping LogExample component");
	}
	
}
