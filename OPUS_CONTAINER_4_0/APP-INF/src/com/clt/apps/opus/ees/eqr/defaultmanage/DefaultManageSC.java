/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DefaultManageSC.java
*@FileTitle :DefaultManageSC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage;


import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.basic.ScenarioDefaultManageBC;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.basic.ScenarioDefaultManageBCImpl;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0115Event;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0116Event;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccMasterVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccTsTmlVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrEccLnkVO;
import com.clt.syscommon.common.table.EqrInpDatRedLgtAltVO;
/**
 * -DefaultManage Business Transaction ServiceCommand - -DefaultManage 
 * 
 * @author 
 * @see scenariodefaultmanageDBDAO
 * @since J2EE 1.6 
 */

public class DefaultManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario DefaultManage system
	 * related objects creation EES_EQR_034
	 */
	public void doStart() {
		log.debug("DefaultManageSC start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * biz scenario closing DefaultManage system <br>
	 * clearing related objects EES_EQR_034<br>
	 */
	public void doEnd() {
		log.debug("DefaultManageSC end");
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
        
		// retrieving or saving ECC info.
		if (e.getEventName().equalsIgnoreCase("EesEqr0115Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {			// click Retrieve button
				eventResponse = searchDefaultECCInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {	// click TS column
				eventResponse = searchDefaultTSTMLInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {		// click Save button
				eventResponse = modifyDefaultECCInfo(e);
			}
		}
		
		// 연간 신조 계획 조회/수정	
		if (e.getEventName().equalsIgnoreCase("EesEqr0116Event")) {	
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  // click Retrieve button
				eventResponse = searchDefaultECCLinkInfo(e);
				log.debug("EesEqr116Event start FormCommand.SEARCH "+FormCommand.SEARCH);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY)) { // click Save button
				eventResponse = modifyDefaultECCLinkInfo(e);	
			} 		
		}		


		return eventResponse;
	}

	
	/**
	 * [ EES_EQR_0115 : Retrieve ]
	 * retrieving for ECC info.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultECCInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0115Event event = (EesEqr0115Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		CommonBCImpl commonImpl = new CommonBCImpl();
		String status = event.getStatus();
		String location = event.getLocation();

		try{
			List<SearchEccMasterVO> list = command.searchDefaultECCInfo(status, location);
			eventResponse.setRsVoList(list);
			
			String[] maxArr = commonImpl.searchMaxInfo("EQR_ECC_MST", "").getResultStrArray();
			eventResponse.setETCData("userid", maxArr[0]);
			eventResponse.setETCData("date", maxArr[1]);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * retrieving for TS info.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultTSTMLInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0115Event event = (EesEqr0115Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		String eccCd = event.getEccCd();

		try{
			List<SearchEccTsTmlVO> list = command.searchDefaultTSTMLInfo(eccCd);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * saving ECC<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDefaultECCInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0115Event event = (EesEqr0115Event)e;
		ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
		
		try{
			begin();
			command.modifyDefaultECCInfo(event.getEqrEccMstVOS(), account);   // EQR_ECC_MST table modify
			command.modifyDefaultTSTMLInfo(event.getEqrTsTmlVOS(), account);   // EQR_TS_TML table modify
			eventResponse.setUserMessage(new ErrorHandler("SUCCESS").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	

	/**
	 * retrieving for ECC Link<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDefaultECCLinkInfo(Event e) throws EventException {		
		EesEqr0116Event event = (EesEqr0116Event)e; // PDTO(Data Transfer Object including Parameters) 
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		String fromLocation = "";
		String toLocation = "";
		try {
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			CommonBCImpl commonImpl = new CommonBCImpl();
			if(!event.getConditionVO().getFromStatus().equals("")) {
				fromLocation = commonImpl.convertECCInfoString(event.getConditionVO().getFromStatus(), event.getConditionVO().getFromLocation()).getResultString();
			}
			if(!event.getConditionVO().getToStatus().equals("")) {
				toLocation = commonImpl.convertECCInfoString(event.getConditionVO().getToStatus(), event.getConditionVO().getToLocation()).getResultString();
			}		
			ArrayList<String> fromEccAL = new ArrayList<String>();
			String[] fromEccArr = fromLocation.split(",");
			for(int i = 0 ; fromEccArr != null && i < fromEccArr.length ; i++){
				fromEccAL.add(fromEccArr[i]);
			}
			ArrayList<String> toEccAL = new ArrayList<String>();
			String[] toEccArr = toLocation.split(",");
			for(int i = 0 ; toEccArr != null && i < toEccArr.length ; i++){
				toEccAL.add(toEccArr[i]);
			}
			List<EqrEccLnkVO> list = command.searchDefaultECCLinkInfo(event.getConditionVO(),fromEccAL,toEccAL);
			eventResponse.setRsVoList(list);
			String[] maxArr = commonImpl.searchMaxInfo("EQR_ECC_LNK", "").getResultStrArray();
			eventResponse.setETCData("userid", maxArr[0]);
			eventResponse.setETCData("date", maxArr[1]);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * saving ECC Link <br>

	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse modifyDefaultECCLinkInfo(Event e) throws EventException {		
		EesEqr0116Event event = (EesEqr0116Event)e; // PDTO(Data Transfer Object including Parameters) 
		GeneralEventResponse eventResponse = new GeneralEventResponse();      
		
		try {
			ScenarioDefaultManageBC command = new ScenarioDefaultManageBCImpl();
			command.modifyDefaultECCLinkInfo(event.getEqrEccLnkVOS(),account);
			return (eventResponse); 
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	


}