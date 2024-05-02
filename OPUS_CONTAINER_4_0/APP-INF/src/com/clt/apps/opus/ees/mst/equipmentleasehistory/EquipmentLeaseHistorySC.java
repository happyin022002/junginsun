/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EquipmentLeaseHistorySC.java
*@FileTitle : Manageing lease History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentleasehistory;

import java.util.List;

import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.basic.LeaseSubleaseBC;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.basic.LeaseSubleaseBCImpl;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.event.EesMst0027Event;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.event.EesMst0029Event;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.event.EesMst0035Event;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusGrpVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusReportListVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;

/**
 * EquipmentLeaseHistory Business Logic ServiceCommand - 
 * handling business process about EquipmentLeaseHistory
 * 
 * @author 
 * @see LeaseSubleaseDBDAO
 * @since J2EE 1.6
 */

public class EquipmentLeaseHistorySC extends ServiceCommandSupport {
	// Login User Information
	/**
	 * preceding process for biz scenario about EquipmentLeaseHistory system<br>
	 * EES_MST_0029 related objects creation<br>
	 */
	public void doStart() {
	}

	/**
	 * biz scenario closing EquipmentLeaseHistory system <br>
	 */
	public void doEnd() {
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EesMst0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrStatusListByCntrNoService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0035Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrCheckDigitListService(e);
			}				
		}
		else if (e.getEventName().equalsIgnoreCase("EesMst0027Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrStatusReportListService(e);
			}
		}
		return eventResponse;
	}
	/**
	 * EesMst0029Event : retrieve<br>
	 * retrieving for Container Status Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrStatusListByCntrNoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMst0029Event event = (EesMst0029Event)e;   
		LeaseSubleaseBC command = new LeaseSubleaseBCImpl();

		CntrStatusGrpVO sgrVo = new CntrStatusGrpVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			sgrVo = command.searchCntrStatusListByCntrNoBasic(event.getContainerConditionVO());
			eventResponse.setRsVoList(sgrVo.getCntrMstHeadVO());
			eventResponse.setRsVoList(sgrVo.getCntrStatusListVO());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	/**
	 * EesMst0035Event : retrieve<br>
	 * retrieving for Container Check Digit and Container Checking Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrCheckDigitListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMst0035Event event = (EesMst0035Event)e;   
		LeaseSubleaseBC command = new LeaseSubleaseBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<CntrStatusListVO> list = command.searchCntrCheckDigitListBasic(event.getContainerConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}
		return eventResponse;
	}	
	
	/**
	 * EesMst0027Event : retrieve<br>
	 * retrieving for Container Status List by Lost & Found <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchCntrStatusReportListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMst0027Event event = (EesMst0027Event)e;   
		LeaseSubleaseBC command = new LeaseSubleaseBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<CntrStatusReportListVO> list = command.searchCntrStatusReportListBasic(event.getCntrStatusOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}		
		return eventResponse;
	}		
	
}