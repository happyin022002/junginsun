/*========================================================
*Copyright(c) 2012 CyberLogitec
*ProcessChain    : BST
*@FileName       : SampleReportFtpSC.java
*@FileTitle      	 : 
*@Author           : Jeong-Hoon, KIM
*Open Issues     :
*Change history  :
*@LastModifyDate : 2012. 4. 3.
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.sample.ftp.report;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.sample.ftp.report.basic.SampleReportFtpBC;
import com.hanjin.sample.ftp.report.basic.SampleReportFtpBCImpl;
import com.hanjin.sample.ftp.report.event.SampleReportFtpEvent;

/**
 * 
 * SampleReportFtpSC.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2012. 4. 3.
 */
public class SampleReportFtpSC extends ServiceCommandSupport{

	/**
	 *  
	 * @author Jeong-Hoon, KIM
	 * @param ev
	 * @return
	 * @throws EventException EventResponse
	 */
	public EventResponse perform(Event ev) throws EventException {
		begin();
		SampleReportFtpBC sampleReportFtpBC = new SampleReportFtpBCImpl();
		SampleReportFtpEvent sampleReportFtpEvent = (SampleReportFtpEvent)ev;
		sampleReportFtpBC.sendReportFtp(sampleReportFtpEvent.getComRptDsgnXptInfoVO());
		commit();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("KEY", "Ftp Report Success");
		return eventResponse;
	}

}
