package org.holbreich.osgi.logservice;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;

public class ConsoleLogger implements LogListener {

	private LogReaderService logReaderService;
	
	
	
	public void unsetLogReaderService() {
		 logReaderService=null;
	}



	public void setLogReaderService(LogReaderService logReaderService) {
		this.logReaderService = logReaderService;
	}

	
	protected void activate(ComponentContext componentContext){
		logReaderService.addLogListener(this);
	}
	
	protected void deactivate(ComponentContext componentContext){
		logReaderService.removeLogListener(this);
	}


	@Override
	public void logged(LogEntry entry) {
		String logmessage = String.format("[%s] <%s> %s", "Level", entry.getBundle().getSymbolicName(), entry.getMessage());
		System.out.println(logmessage);
		
	}

}
