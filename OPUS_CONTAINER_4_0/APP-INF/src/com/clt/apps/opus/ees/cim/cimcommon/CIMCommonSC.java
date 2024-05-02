/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNTROperatioNPerformanceMgtSC.java
*@FileTitle : Turn Time by Port
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon;


import java.util.List;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.event.CimComEvent;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.event.EesCim2002Event;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.event.EesCim2100Event;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.event.EesCim2001Event;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.OscarBookingSearchEdiVO;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.OscarBookingSearchVO;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.ComIntgCdListDataVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CimTpSzDpSeqVO;


/**
 * OPUS--CNTROperatioNPerformanceMgt Business Logic ServiceCommand 
 * 
 * @author 
 * @see ITurnTimePerformanceFinderBCDBDAO
 * @since J2EE 1.4
 */

public class CIMCommonSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * preceding business scenario job for CNTROperatioNPerformanceMgt system 
	 * creating object when calling UI_CIM_1001 business scenario
	 */
	public void doStart() {
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
            log.error(e.getLocalizedMessage());			
		}
	}

	/**
	 * closing CNTROperatioNPerformanceMgt system business scenario
	 */
	public void doEnd() {
		log.debug("CNTROperatioNPerformanceMgtSC 종료");
	}

	/**
	 * processing business scenarios for events
	 * handling event for OPUS--CNTROperatioNPerformanceMgt system 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("CimComEvent")) {
			 if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				// retrieving COM_INTG_CD 
				eventResponse = searchComIntgCdListService(e);					
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchComAreaGrpIdListService(e);		
			}
			
		}
		else if (e.getEventName().equalsIgnoreCase("EesCim2100Event")) 
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCntrTypeSizeDivListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) 
			{
				eventResponse = manageCntrTypeSizeDivService(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EesCim2001Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOscarBookingInformationListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOscarVesselInformationListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOscarContainerInformationListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchOscarMovementHistoryListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOscarEdiMessageHistoryListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchOscarCntrStatusListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchOscarMovementEdiErrListService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = actionOscarMovementService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = actionBookingCycChangeService(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EesCim2002Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOscarEdiErrorListService(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * retrieving COM_INTG_CD
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchComIntgCdListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();
		CimComEvent event = (CimComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{
			List<ComIntgCdListDataVO> list= command.searchComIntgCdListBasic(event.getIntgCdId(),event.getIntgCdVal());
			
			StringBuilder sb = new StringBuilder();
			if(!list.isEmpty()){
				sb.append(list.get(0).getCode()+"|"+list.get(0).getCodeNm());
				for(int i=1; i<list.size(); i++){
					sb.append("@"+list.get(i).getCode()+"|"+list.get(i).getCodeNm());
				}
			}
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("code_nm",sb.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}
	
	
	
	/**
	 * retrieving COM_INTG_CD
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchComAreaGrpIdListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();				
		try{
			List<ComIntgCdListDataVO> list= command.searchComAreaGrpIdListBasic();
			
			StringBuilder sb = new StringBuilder();
			if(!list.isEmpty()){
				for(int i=0; i<list.size(); i++){
					if(i == 0) {
						sb.append(list.get(i).getCode());
					}else{
						sb.append("|"+list.get(i).getCode());
					}
				}
			}
			
			eventResponse.setETCData("code_nm",sb.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;
	}


	/**
	 * EES_CIM_2100 : retrieve<br>
	 * Retrieving Container Type Size Division<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTypeSizeDivListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		//EesCim2100Event event = (EesCim2100Event)e;
		CIMCommonBC command = new CIMCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{		
			List<CimTpSzDpSeqVO> list = command.searchCntrTypeSizeDivListBasic();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}



	/**
	 * EES_CIM_2100 : save<br>
	 * Saving Container Type Size Division<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCntrTypeSizeDivService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim2100Event event = (EesCim2100Event)e;
		CIMCommonBC command = new CIMCommonBCImpl();
		try{
			begin();
			command.manageCntrTypeSizeDivBasic(event.getCimTpSzDpSeqVOS(),account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_CIM_2001 : retrieve<br>
	 * Retrieving Oscar Booking Information Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOscarBookingInformationListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();
		EesCim2001Event event = (EesCim2001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try{		
			List<OscarBookingSearchVO> list = command.searchOscarBookingInformationListBasic(event.getOscarBookingSearchVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	
	/**
	 * EES_CIM_2001 : retrieve<br>
	 * Retrieving Oscar Vessel Information Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOscarVesselInformationListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();
		EesCim2001Event event = (EesCim2001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try{		
			List<OscarBookingSearchVO> list = command.searchOscarVesselInformationListBasic(event.getOscarBookingSearchVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	
	/**
	 * EES_CIM_2001 : retrieve<br>
	 * Retrieving Oscar Container Information Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOscarContainerInformationListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();
		EesCim2001Event event = (EesCim2001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try{		
			List<OscarBookingSearchVO> list = command.searchOscarContainerInformationListBasic(event.getOscarBookingSearchVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	
	/**
	 * EES_CIM_2001 : retrieve<br>
	 * Retrieving Oscar Movement History Information Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOscarMovementHistoryListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();
		EesCim2001Event event = (EesCim2001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try{		
			List<SearchMovementListByContainerVO> list = command.searchOscarMovementInformationListBasic(event.getSearchMovementListByContainerVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	
	/**
	 * EES_CIM_2001 : retrieve<br>
	 * Retrieving Oscar Movement History Information Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOscarMovementEdiErrListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();
		EesCim2001Event event = (EesCim2001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try{		
			List<OscarBookingSearchVO> list = command.searchOscarMovementEdiErrInformationListBasic(event.getOscarBookingSearchVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	/**
	 * EES_CIM_2001 : retrieve<br>
	 * Retrieving Oscar EDI History Information Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOscarEdiMessageHistoryListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();
		EesCim2001Event event = (EesCim2001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try{		
			List<SearchEDIMovementListVO> list = command.searchOscarEdiMessageInformationListBasic(event.getSearchEDIMovementListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	
	/**
	 * EES_CIM_2001 : retrieve<br>
	 * Retrieving Oscar Container Status Information Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOscarCntrStatusListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();
		EesCim2001Event event = (EesCim2001Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try{		
			List<CntrStatusListVO> list = command.searchOscarCntrStatusInformationListBasic(event.getContainerConditionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
	
	/**
	 * save MOVEMENT
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse actionOscarMovementService(Event e) throws EventException {
		try {
			//SignOnUserAccount account = getSignOnUserAccount();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CIMCommonBC command = new CIMCommonBCImpl();
			
			EesCim2001Event event = (EesCim2001Event) e;
			
			OscarBookingSearchVO[] oscarBookingSearchVOs = event.getOscarBookingSearchVOs();
			
			begin();
			command.actionOscarMovementBasic(oscarBookingSearchVOs,account);
			commit();
			return eventResponse;
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	
	/**
	 * Cyc Change MOVEMENT
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse actionBookingCycChangeService(Event e) throws EventException {
		try {
			//SignOnUserAccount account = getSignOnUserAccount();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CIMCommonBC command = new CIMCommonBCImpl();
			
			EesCim2001Event event = (EesCim2001Event) e;
			
			OscarBookingSearchVO[] oscarBookingSearchVOs = event.getOscarBookingSearchVOs();
			
			begin();
			command.actionBookingCycChangeBasic(oscarBookingSearchVOs);
			commit();
			return eventResponse;
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_CIM_2002 : retrieve<br>
	 * Retrieving Oscar Booking Information Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOscarEdiErrorListService(Event e) throws EventException 
	{
		// PDTO(Data Transfer Object including Parameters)
		CIMCommonBC command = new CIMCommonBCImpl();
		EesCim2002Event event = (EesCim2002Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		try{		
			
			int rtvTotal = command.searchEdiErrorTotalCnt(event.getOscarBookingSearchEdiVO());
			eventResponse.setETCData("rtv_total", String.valueOf(rtvTotal));
			
			List<OscarBookingSearchEdiVO> list = command.searchOscarEdiErrorListBasic(event.getOscarBookingSearchEdiVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);			
		}			
		return eventResponse;
	}
	
}