/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonSC.java
*@FileTitle : EQR Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.common;

import com.clt.apps.opus.bcm.ccd.commoncode.account.basic.AccountBC;
import com.clt.apps.opus.bcm.ccd.commoncode.account.basic.AccountBCImpl;
import com.clt.apps.opus.bcm.ccd.commoncode.account.event.BcmCcd0001Event;
import com.clt.apps.opus.bcm.ccd.commoncode.account.vo.AccountVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.event.EesCommonEvent;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.event.EesEqr0008Event;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.event.EesEqr0105Event;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.integration.CommonDBDAO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrWkPrdVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrCommonVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

import java.util.ArrayList;
import java.util.List;


/**
 * - handling business transaction Common Business Logic ServiceCommand 
 * 
 * @author 
 * @see CommonDBDAO
 * @since J2EE 1.6
 */

public class EQRCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario Common system <br>
	 * related objects creation Common system <br>
	 * 
	 */
	public void doStart() {

		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * biz scenario closing Common system<br>
	 * clearing related objects Common system<br>
	 */
	public void doEnd() {
		log.debug("CommonSC end");
	}

	/**
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EesEqr0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				log.info("SC_SEARCHLIST");
				eventResponse = searchEqrWkPrd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				log.info("SC_MULTIl");
				eventResponse = manageEqrWkPrd(e);
			}
		}else{
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = scnridReMarkSearch(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = checkEccCode(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = repoidReMarkSearch(e);
			
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = checkLocCode(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) { // LOC YARD MULTI COMBO BOX
				eventResponse = searchLocYardInfo(e);
	
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST20)) {  // ECC YARD MULTI COMBO BOX
				eventResponse = searchEccYardInfo(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {     //  LOC YARD COMPANY MULTI COMBO BOX
				eventResponse = searchLocYardCompanyInfo(e);
	
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST06)) { // VENDOR MULTI COMBO BOX
				eventResponse = searchVendorInfo(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST07)) { 
				eventResponse = checkLocCodeWithMaster(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST08)) { // VVD MULTI COMBO BOX
				eventResponse = searchVvdInfo(e);		
						
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST09)) { // LOC YARD-ECC MULTI COMBO BOX
				eventResponse = searchLocYardEccInfo(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST10)) { //Get SCNR_ID 
				eventResponse = searchWeekScnrId(e);					
									
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)) {
				eventResponse = searchCountryInfo(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)) {
				eventResponse = searchCheckPeriod(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST15)) {
				eventResponse = searchCheckPeriodOpt(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST16)){
				eventResponse = searchBetweenWeek(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST17)){
				eventResponse = searchWeekDatePeriod(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST18)){
				eventResponse = searchEtaDate(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST19)) { // LOC YARD MULTI COMBO BOX
				eventResponse = searchLseCoYardInfo(e);
							
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST20)) { // LOC YARD(vessel) MULTI COMBO BOX
				eventResponse = searchLocYardVesselInfo(e);
			
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) { // SEARCH VENDOR INFO BY SEQ
				eventResponse = searchVendorInfoBySeq(e);
			
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // LOC YARD INITIAL SEARCH
				eventResponse = searchLocYardInitialInfo(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // LOC YARD EXIST
				eventResponse = searchLocYardExist(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // COMPANY LOC YARD EXIST
				eventResponse = searchLocYardCompanyExist(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // VVD CODE EXIST
				eventResponse = searchVvdExist(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) { // VVD INLAND INFO
				eventResponse = searchVvdInlandInfo(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)) {  // SEARCH  duplicate_check POD
				eventResponse = searchDuplicatCheckPod(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)) {  // SEARCH  checkPeriod -8 
				eventResponse = searchBeforeCheckPeriod(e);
				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {  // checking vessel skd
				eventResponse = searchVesselScheduleCheck(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST13)) {  // BayPort List
				eventResponse = searchBayPort(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {  // BayPort List
				eventResponse = searchLane(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
					eventResponse = searchEQRAdjust(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)) {  // EQR All-Weeks' Plan Access Grant Check
				eventResponse = checkEqrAccess(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) {  // Trade Search
				eventResponse = searchTradeEqrAccess(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)) {  // Trade Search
				eventResponse = searchEqrLocYardEccInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH15)) {  // Trade Search
				eventResponse = searchLocByYardInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH16)) {  // Yard Search
				eventResponse = searchEqrLocYardLccInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH17)) { // LOC YARD INITIAL SEARCH
				eventResponse = searchLocYardDischargeInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH18)) { // 
				eventResponse = repoidDefaultSearch(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH19)) { // LOC YARD INITIAL SEARCH
				eventResponse = searchWaterLocYardInitialInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH20)) { // LOC YARD INITIAL SEARCH
				eventResponse = searchEqrLocTrwYardLccInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH21)) { // Sub CONTINENT
				eventResponse = searchEqrSubContinentList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH22)) { // 
				eventResponse = repoidDefaultRepoPlanIdSearch(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * Common :<br>
	 * retrieving for ECC_CD <br>
	 * 
	 * @param Event e
	 * @return EventResponse (EesCommonVO)getCustomData("RetVO")
	 * @exception EventException
	 */
	private EventResponse checkEccCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		CommonBC command = new CommonBCImpl();
		String ecc_cd = event.getEesCommonConditionVO().getEcccd();
		try{
			retVO = command.checkEccCode(ecc_cd);
			//eventResponse.setCustomData("RetVO", retVO);
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * retrieving for scenario ID<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse scnridReMarkSearch(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO =  command.scnridReMarkSearch(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * retrieving for report id<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse repoidReMarkSearch(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 

		try {
			CommonBC command = new CommonBCImpl();
			retVO =  command.repoidReMarkSearch(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	
	/**

	 * checking loc cod<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 

		try {
			CommonBC command = new CommonBCImpl();
			retVO =  command.checkLocCode(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	

	/**

	 * checking loc code with master<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocCodeWithMaster(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 

		try {
			CommonBC command = new CommonBCImpl();
			retVO =  command.checkLocCodeWithMaster(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving for LOC YARD EXIST<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardExist(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardExist(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ritrieving for LOC YARD Company EXIST  이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardCompanyExist(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardCompanyExist(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
	}	
	
	/**
	 * retrieving for LOC YARD <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocByYardInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocByYardInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * retrieving for LOC YARD <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * retrieving for ECC YARD <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchEccYardInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchEccYardInfo(event.getEesCommonConditionVO()); 
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retireving for LOC YARD - vessel<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardVesselInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardVesselInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			//eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * retrieving for LOC YARD initial<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardInitialInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardInitialInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * retrieving for LOC YARD initial<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardDischargeInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardDischargeInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieving for lessor YARD <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLseCoYardInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLseCoYardInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			List<CommonVO> voList = new ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			voList.add(commonVO);
			eventResponse.setRsVoList(voList);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieving for LOC YARD - ECC<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardEccInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardEccInfo(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	
	/**
	 * retrieving for LOC YARD - ECC<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchEqrLocYardEccInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchEqrLocYardEccInfo(event.getEesCommonConditionVO(),account);
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	
	/**
	 * retrieving for LOC YARD - LCC<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchEqrLocYardLccInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		try {
			CommonBC command = new CommonBCImpl();
			String strYardYn = "";
			strYardYn = command.searchEqrLocYardLccInfo(event.getEesCommonConditionVO(),account);
			eventResponse.setETCData("strYardYn", strYardYn);
			
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	
	/**
	 * retrieving for VENDOR information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVendorInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchVendorInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * retrieving for VENDOR Company<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLocYardCompanyInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchLocYardCompanyInfo(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * retrieving for VENDOR with vendor sequence<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVendorInfoBySeq(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchVendorInfoBySeq(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		

	/**
	 * retrieving for VVD information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVvdInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchVvdInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieving for VVD Inland Info<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVvdInlandInfo(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchVvdInlandInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieving for VVD Code <br>

	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVvdExist(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchVvdExist(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieving for Scnr_id with week<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchWeekScnrId(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchWeekScnrId(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * retrieving for Country <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchCountryInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchCountryInfo(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * retrieving for max to week with from week<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchCheckPeriod(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			
			retVO = command.searchCheckPeriod(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * retrieving for max to week with from week(FM, TO, AT)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchCheckPeriodOpt(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			
			retVO = command.searchCheckPeriodOpt(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * retrieving for days between weeks<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBetweenWeek(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 

		try {
			CommonBC command = new CommonBCImpl();
			retVO =  command.searchBetweenWeek(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * retrieving for Week Date Period(fromdate, todate)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchWeekDatePeriod(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchWeekDatePeriod(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * retrieving for Eta Date<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchEtaDate(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchEtaDate(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieving for duplicate_check POD 리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchDuplicatCheckPod(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchDuplicatCheckPod(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * checkign max period<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchBeforeCheckPeriod(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			
			retVO = command.searchBeforeCheckPeriod(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * retrieving for VESSEL schedule <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchVesselScheduleCheck(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			
			retVO = command.searchVesselScheduleCheck(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * retrieving for BayPort<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchBayPort(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchBayPort(event.getEesCommonConditionVO());
			eventResponse.setCustomData("RetVO", retVO);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieving for Lane <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchLane(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			
			retVO = command.searchLane(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieving for EQRAdjust<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQRAdjust(Event e) throws EventException {
		
		EesEqr0105Event event = (EesEqr0105Event)e;  	// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();  			
		String eccString = "";
		try {
			CommonBCImpl commonImpl = new CommonBCImpl();
			eccString = commonImpl.convertECCInfoString(event.getStatus(), event.getLocation()).getResultString();
			eventResponse.setCustomData("eccString", eccString);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * checking user athurity
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkEqrAccess(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command = new CommonBCImpl();
		
		String ofcCd = "";

		try{
			CommonVO commonVO = command.getUserInfo(account.getUsr_id());
			
			DBRowSet rowSet = commonVO.getDbRowset();
			if (rowSet != null) {
				while (rowSet.next()) {
					ofcCd = JSPUtil.getNull(rowSet.getString("OFC_CD"));
				}
			}
			
			eventResponse.setETCData("ofcCd", ofcCd);
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * saving Manage EQR Week screen<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEqrWkPrd(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesEqr0008Event event = (EesEqr0008Event)e;
		CommonBC command=new CommonBCImpl();
		
		try {
			begin();
			command.manageEqrWkPrd(event.getEqrWkPrdVOs(), account);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_EQR_0008 : Retrieve<br>
	 * saving Manage EQR Week screen<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEqrWkPrd(Event e) throws EventException {
		
		EesEqr0008Event event = (EesEqr0008Event)e;  	// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC command=new CommonBCImpl();
		
		try {
			List<EqrWkPrdVO> list=command.searchEqrWkPrd(event.getPlnYr());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			//de.printStackTrace();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	
	
	
	/**
	 * retrieving for Trade <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchTradeEqrAccess(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		
		CommonBC command = new CommonBCImpl();
		try {
			
			
			List<EqrCommonVO> list =  command.searchTradeList();
			StringBuffer codes = new StringBuffer();
			
			if (list != null && list.size() > 0) {
				//insert blank in the select box
				
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getTrdCd());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			eventResponse.setETCData("all_trade_cd", codes.toString());
			
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return (eventResponse);
	}	
	
	
	/**
	 * 로딩시 기본 데이타 Set<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse repoidDefaultSearch(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		CommonBC command = new CommonBCImpl();
		
		String[] info = null;
		String[] info1 = null;
		String[] info2 = null;
		String   info3 = null;
		String[] info4 = null;
		String   info5 = null;
		String[] info6 = null;
		String   info7 = null;
		String   info8 = null;
		String[] info9 = null;
		String repoPlnNextWeek= "";
		String   info11= null;
		
		String scnr_id = "";
		String repo_rmk = "";
		String type = "";
		String repo_pln_id ="";
		String dtrb_flg = "";
		String replPlnYn = "";
		
		
		String st_year 		= "";
		String st_weekly 		= "";
		String st_month 		= "";
		String end_year 		= "";
		String end_weekly 		= "";
		String end_month 		= "";
		String perfix_month 	= "";
		String title_month 	= "";
		String perfix_weekly 	= "";
		String title_weekly 	= "";
		String perfix_monthly 	= "";
		String monthly_count 	= "";
		String max_plnYr 		= "";
		String max_weekly 		= "";
		String max_plnMon  	= "";
		String fromToPlnId 	= "";
		String scnrIdList 		= "";
		String repoPlnIdList 	= "";
		String todayWeekly 	= "";
		String exePlnEditFlg 	= "";
		String exePlnEditFlg_split= "";
		String maxWkStr 		= "";
		
		try {			
			retVO =  command.repoidDefaultSearch(event.getEesCommonConditionVO());
			
			if(retVO.getList().size() <= 0) {
				eventResponse.setETCData("DataYN", "N");
			}else{
				scnr_id 		= retVO.getList().get(0).getScnrId();
				repo_rmk 	= retVO.getList().get(0).getRepoPlnRmk();
				type 			= retVO.getList().get(0).getStatus();
				repo_pln_id = retVO.getList().get(0).getRepoPlnId();
				dtrb_flg 		= retVO.getList().get(0).getRepoPlnDtrbFlg();
				replPlnYn 	= retVO.getList().get(0).getRepoPlnLst();
				
				eventResponse.setETCData("scnr_id", scnr_id);
				eventResponse.setETCData("repo_rmk", repo_rmk);
				eventResponse.setETCData("type", type);
				eventResponse.setETCData("repo_pln_id", repo_pln_id);
				eventResponse.setETCData("dtrb_flg", dtrb_flg);
				eventResponse.setETCData("replPlnYn", replPlnYn);
			
				info = retVO.getResultset();
				st_year 		= JSPUtil.getNull(info[0]);
				st_weekly 	= JSPUtil.getNull(info[1]);
				st_month 	= JSPUtil.getNull(info[2]);
				end_year 	= JSPUtil.getNull(info[3]);
				end_weekly = JSPUtil.getNull(info[4]);
				end_month 	= JSPUtil.getNull(info[5]);
				
				eventResponse.setETCData("st_year", st_year);
				eventResponse.setETCData("st_weekly", st_weekly);
				eventResponse.setETCData("st_month", st_month);
				eventResponse.setETCData("end_year", end_year);
				eventResponse.setETCData("end_weekly", end_weekly);
				eventResponse.setETCData("end_month", end_month);
				
				
				// getting for month title
				info1 = retVO.getResultset1();
				perfix_month 	= JSPUtil.getNull(info1[0]); 
				title_month 	= JSPUtil.getNull(info1[1]);    
				eventResponse.setETCData("perfix_month", perfix_month);
				eventResponse.setETCData("title_month", title_month);
				
				
				// getting for week title
				info2 = retVO.getResultset2(); 
				perfix_weekly 	= JSPUtil.getNull(info2[0]);  
				title_weekly 	= JSPUtil.getNull(info2[1]);   
				perfix_monthly 	= JSPUtil.getNull(info2[2]); 
				
				eventResponse.setETCData("perfix_weekly", perfix_weekly);
				eventResponse.setETCData("title_weekly"	 , title_weekly);
				eventResponse.setETCData("perfix_monthly"	 , perfix_monthly);
				
				
				// getting month with week
				info3 = retVO.getResultset3();
				monthly_count 	= JSPUtil.getNull(info3); 
				eventResponse.setETCData("monthly_count", monthly_count);
				
				// getting 9 weeks
				info4 = retVO.getResultset4();
				max_plnYr 		= JSPUtil.getNull(info4[3]);		
				max_weekly 		= JSPUtil.getNull(info4[4]); //ending  9th week.		
				max_plnMon  	= JSPUtil.getNull(info4[5]); //ending  month of 9th week
				eventResponse.setETCData("max_plnYr", max_plnYr);
				eventResponse.setETCData("max_weekly", max_weekly);
				eventResponse.setETCData("max_plnMon", max_plnMon);
				
				
				info5 = retVO.getResultset5();
				fromToPlnId 	= JSPUtil.getNull(info5);   
				eventResponse.setETCData("fromToPlnId", fromToPlnId);
				
				
				// getting scnr_id list of pln id
				info6 = retVO.getResultset6();
				scnrIdList 		= JSPUtil.getNull(info6[0]); //scnr_id List of pln id
				repoPlnIdList 	= JSPUtil.getNull(info6[1]);//repo_pln_id List of pln id
				eventResponse.setETCData("scnrIdList", scnrIdList);
				eventResponse.setETCData("repoPlnIdList", repoPlnIdList);
				
				// getting current year, week
				info7 = retVO.getResultset7();
				todayWeekly 	= JSPUtil.getNull(info7);	// current year, week
				eventResponse.setETCData("todayWeekly", todayWeekly);
				
				// exePlnEditFlg : edit disable if planwk < local wk 
				info8 = retVO.getResultset8();
				exePlnEditFlg 	= JSPUtil.getNull(info8);	// exePlnEditFlg : edit disable if planwk < local wk 
				eventResponse.setETCData("exePlnEditFlg", exePlnEditFlg);
				
				// maxWk Str(seperator : ,)
				info9 = retVO.getResultset9();
				maxWkStr 		= JSPUtil.getNull(info9[0]);//
				eventResponse.setETCData("maxWkStr", maxWkStr);
				
				// next week of repo plan week
				repoPlnNextWeek	 = retVO.getResultset10();	
				repoPlnNextWeek 	= JSPUtil.getNull(repoPlnNextWeek);//
				eventResponse.setETCData("repoPlnNextWeek", repoPlnNextWeek);
				
				// exePlnEditFlg PrevOneWeek : edit available only split & last week
				info11 = retVO.getResultset11();
				exePlnEditFlg_split= JSPUtil.getNull(info11);	
				eventResponse.setETCData("exePlnEditFlg_split", exePlnEditFlg_split);
				
				eventResponse.setETCData("DataYN", "Y");
			}
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * retrieving for LOC YARD initial<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse searchWaterLocYardInitialInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		try {
			CommonBC command = new CommonBCImpl();
			retVO = command.searchWaterLocYardInitialInfo(event.getEesCommonConditionVO());
			//eventResponse.setCustomData("RetVO", retVO);
			
			List<CommonVO> list = new  ArrayList<CommonVO>();
			CommonVO commonVO = new CommonVO();
			commonVO.setConditionVo(event.getEesCommonConditionVO());
			commonVO.setResultVo(retVO);
			list.add(commonVO);
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchEqrSubContinentList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		
		CommonBC command = new CommonBCImpl();
		try {
			
			
			List<EqrCommonVO> list =  command.searchEqrSubContinentList();
			StringBuffer codes = new StringBuffer();
			
			if (list != null && list.size() > 0) {
				//insert blank in the select box
				
				for (int i = 0 ; i < list.size() ; i++) {
					codes.append(list.get(i).getFmContiCd());
					if (i < list.size() - 1) codes.append("|");
				}
			}
			//eventResponse.setETCData("all_trade_cd", codes.toString());
			eventResponse.setETCData("all_conti_cd", codes.toString());
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return (eventResponse);
	}		
	
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchEqrLocTrwYardLccInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		try {
			CommonBC command = new CommonBCImpl();
			String strYardYn = "";
			strYardYn = command.searchEqrLocTrwYardLccInfo(event.getEesCommonConditionVO(),account);
			eventResponse.setETCData("strYardYn", strYardYn);
			
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		
	
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse repoidDefaultRepoPlanIdSearch(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		EesCommonEvent event = (EesCommonEvent)e; // PDTO(Data Transfer Object including VO Parameters)
		EesCommonVO retVO = null; 
		CommonBC command = new CommonBCImpl();
		
		String[] info = null;
		String[] info1 = null;
		String[] info2 = null;
		String   info3 = null;
		String[] info4 = null;
		String   info5 = null;
		String[] info6 = null;
		String   info7 = null;
		String   info8 = null;
		String[] info9 = null;
		String repoPlnNextWeek= "";
		String   info11= null;
		
		String scnr_id = "";
		String repo_rmk = "";
		String type = "";
		String repo_pln_id ="";
		String dtrb_flg = "";
		String replPlnYn = "";
		
		
		String st_year 		= "";
		String st_weekly 		= "";
		String st_month 		= "";
		String end_year 		= "";
		String end_weekly 		= "";
		String end_month 		= "";
		String perfix_month 	= "";
		String title_month 	= "";
		String perfix_weekly 	= "";
		String title_weekly 	= "";
		String perfix_monthly 	= "";
		String monthly_count 	= "";
		String max_plnYr 		= "";
		String max_weekly 		= "";
		String max_plnMon  	= "";
		String fromToPlnId 	= "";
		String scnrIdList 		= "";
		String repoPlnIdList 	= "";
		String todayWeekly 	= "";
		String exePlnEditFlg 	= "";
		String exePlnEditFlg_split= "";
		String maxWkStr 		= "";
		
		try {			
			retVO =  command.repoidDefaultRepoPlanIdSearch(event.getEesCommonConditionVO()); 
			
			if(retVO.getList().size() <= 0) {
				eventResponse.setETCData("DataYN", "N");
			}else{
				scnr_id 		= retVO.getList().get(0).getScnrId();
				repo_rmk 	= retVO.getList().get(0).getRepoPlnRmk();
				type 			= retVO.getList().get(0).getStatus();
				repo_pln_id = retVO.getList().get(0).getRepoPlnId();
				dtrb_flg 		= retVO.getList().get(0).getRepoPlnDtrbFlg();
				replPlnYn 	= retVO.getList().get(0).getRepoPlnLst();
				
				eventResponse.setETCData("scnr_id", scnr_id);
				eventResponse.setETCData("repo_rmk", repo_rmk);
				eventResponse.setETCData("type", type);
				eventResponse.setETCData("repo_pln_id", repo_pln_id);
				eventResponse.setETCData("dtrb_flg", dtrb_flg);
				eventResponse.setETCData("replPlnYn", replPlnYn);
			
				info = retVO.getResultset();
				st_year 		= JSPUtil.getNull(info[0]);
				st_weekly 	= JSPUtil.getNull(info[1]);
				st_month 	= JSPUtil.getNull(info[2]);
				end_year 	= JSPUtil.getNull(info[3]);
				end_weekly = JSPUtil.getNull(info[4]);
				end_month 	= JSPUtil.getNull(info[5]);
				
				eventResponse.setETCData("st_year", st_year);
				eventResponse.setETCData("st_weekly", st_weekly);
				eventResponse.setETCData("st_month", st_month);
				eventResponse.setETCData("end_year", end_year);
				eventResponse.setETCData("end_weekly", end_weekly);
				eventResponse.setETCData("end_month", end_month);
				
				
				// getting for month title
				info1 = retVO.getResultset1();
				perfix_month 	= JSPUtil.getNull(info1[0]); 
				title_month 	= JSPUtil.getNull(info1[1]);    
				eventResponse.setETCData("perfix_month", perfix_month);
				eventResponse.setETCData("title_month", title_month);
				
				
				// getting for week title
				info2 = retVO.getResultset2(); 
				perfix_weekly 	= JSPUtil.getNull(info2[0]);  
				title_weekly 	= JSPUtil.getNull(info2[1]);   
				perfix_monthly 	= JSPUtil.getNull(info2[2]); 
				
				eventResponse.setETCData("perfix_weekly", perfix_weekly);
				eventResponse.setETCData("title_weekly"	 , title_weekly);
				eventResponse.setETCData("perfix_monthly"	 , perfix_monthly);
				
				
				// getting month with week
				info3 = retVO.getResultset3();
				monthly_count 	= JSPUtil.getNull(info3); 
				eventResponse.setETCData("monthly_count", monthly_count);
				
				// getting 9 weeks
				info4 = retVO.getResultset4();
				max_plnYr 		= JSPUtil.getNull(info4[3]);		
				max_weekly 		= JSPUtil.getNull(info4[4]); //ending  9th week.		
				max_plnMon  	= JSPUtil.getNull(info4[5]); //ending  month of 9th week
				eventResponse.setETCData("max_plnYr", max_plnYr);
				eventResponse.setETCData("max_weekly", max_weekly);
				eventResponse.setETCData("max_plnMon", max_plnMon);
				
				
				info5 = retVO.getResultset5();
				fromToPlnId 	= JSPUtil.getNull(info5);   
				eventResponse.setETCData("fromToPlnId", fromToPlnId);
				
				
				// getting scnr_id list of pln id
				info6 = retVO.getResultset6();
				scnrIdList 		= JSPUtil.getNull(info6[0]); //scnr_id List of pln id
				repoPlnIdList 	= JSPUtil.getNull(info6[1]);//repo_pln_id List of pln id
				eventResponse.setETCData("scnrIdList", scnrIdList);
				eventResponse.setETCData("repoPlnIdList", repoPlnIdList);
				
				// getting current year, week
				info7 = retVO.getResultset7();
				todayWeekly 	= JSPUtil.getNull(info7);	// current year, week
				eventResponse.setETCData("todayWeekly", todayWeekly);
				
				// exePlnEditFlg : edit disable if planwk < local wk 
				info8 = retVO.getResultset8();
				exePlnEditFlg 	= JSPUtil.getNull(info8);	// exePlnEditFlg : edit disable if planwk < local wk 
				eventResponse.setETCData("exePlnEditFlg", exePlnEditFlg);
				
				// maxWk Str(seperator : ,)
				info9 = retVO.getResultset9();
				maxWkStr 		= JSPUtil.getNull(info9[0]);//
				eventResponse.setETCData("maxWkStr", maxWkStr);
				
				// next week of repo plan week
				repoPlnNextWeek	 = retVO.getResultset10();	
				repoPlnNextWeek 	= JSPUtil.getNull(repoPlnNextWeek);//
				eventResponse.setETCData("repoPlnNextWeek", repoPlnNextWeek);
				
				// exePlnEditFlg PrevOneWeek : edit available only split & last week
				info11 = retVO.getResultset11();
				exePlnEditFlg_split= JSPUtil.getNull(info11);	
				eventResponse.setETCData("exePlnEditFlg_split", exePlnEditFlg_split);
				
				eventResponse.setETCData("DataYN", "Y");
			}
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}
