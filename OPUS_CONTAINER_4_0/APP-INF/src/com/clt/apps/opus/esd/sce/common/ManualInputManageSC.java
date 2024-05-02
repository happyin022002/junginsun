/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ManualInputManageSC.java
*@FileTitle : EsdSce114
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esd.sce.common.manualinput.basic.ManualInputBC;
import com.clt.apps.opus.esd.sce.common.manualinput.basic.ManualInputBCImpl;
import com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3301Event;
import com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3302Event;
import com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3303Event;
import com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3304Event;
import com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3305Event;
import com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3306Event;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActivityGroupMappingVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActivityGroupVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActualActivityMappingVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceCntrStsMsgMvmtMapgVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceCopCntrRepoRuleVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceRailSplcVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmRegionVO;
import com.clt.syscommon.common.table.MdmYardVO;


/**
 * common Business Logic ServiceCommand
 * 
 * @author Shin Han Sung
 * @see popupDBDAO
 * @since J2EE 1.6
 */

public class ManualInputManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 */
	public void doStart() {
		log.debug("commonSC 시작");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 */
	public void doEnd() {
		log.debug("commonSC 종료");
	}

	/**
	 * Event Perform Handling<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsdSce3301Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchActualActivityMappingList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = checkActualCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = checkActualActivityMappingCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageActualActivityMapping(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EsdSce3302Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchActivityGroupList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = checkActivityGroupCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageActivityGroup(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EsdSce3303Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchActivityGroupMappingList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = checkActualCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = checkCOPDetailGroupCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)){
				eventResponse = checkActivityGroupMappingCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageActivityGroupMapping(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce3304Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                       eventResponse = searchSceCntrStsMsgMvmtMappingList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                       eventResponse = manageSceCntrStsMsgMvmt(e);
            }
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce3305Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchSceCopCntrRepoRuleList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				EsdSce3305Event event = (EsdSce3305Event)e;
				HashMap<String, String> map = new HashMap<String, String>();
				
				if(event.getFmCntrTpszCd() != null && !event.getFmCntrTpszCd().equals("")) {
					map.put("frm_cntr_tpsz_cd", event.getFmCntrTpszCd());
				}
				else if(event.getFmCntCd() != null && !event.getFmCntCd().equals("")) {
					map.put("frm_cnt_cd", event.getFmCntCd());
				}
				else if(event.getFmLocCd() != null && !event.getFmLocCd().equals("")) {
					map.put("frm_loc_cd", event.getFmLocCd());
				}
				else if(event.getFmRgnCd() != null && !event.getFmRgnCd().equals("")) {
					map.put("frm_rgn_cd", event.getFmRgnCd());
				}
				
				eventResponse = searchCheckValidation(map);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSceCopCntrRepoRule(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce3306Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchSceRailSplcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				EsdSce3306Event event = (EsdSce3306Event)e;
				HashMap<String, String> map = new HashMap<String, String>();
				
				if(event.getFmLocCd() != null && !event.getFmLocCd().equals("")) {
					map.put("frm_loc_cd", event.getFmLocCd());
				}
				else if(event.getFmYdCd() != null && !event.getFmYdCd().equals("")) {
					map.put("frm_yd_cd", event.getFmYdCd());
				}
				
				eventResponse = searchCheckValidation(map);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSceRailSplc(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * EsdSce3301 searchActualActivityMappingList.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualActivityMappingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3301Event event = (EsdSce3301Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		try{
			List<ActualActivityMappingVO> list = command.searchActualActivityMappingList(event.getActualActivityMappingVO());
			eventResponse.setRsVoList(list);
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
	 * ESD_SCE_3301 : MULTI <br>
	 * Actual Activity Mapping Manage<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageActualActivityMapping(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3301Event event = (EsdSce3301Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		try{
			begin();
			command.manageActualActivityMapping(event.getActualActivityMappingVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_SCE_3301 : COMMAND01 <br>
	 * checkActualCode<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkActualCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String actCd = "";
		String EventNm = e.getEventName();
		
		if(EventNm.equals("EsdSce3301Event")){
			EsdSce3301Event event = (EsdSce3301Event)e;
			actCd = event.getActualActivityMappingVO().getChkActCd();
		}else if(EventNm.equals("EsdSce3303Event")){
			EsdSce3303Event event = (EsdSce3303Event)e;
			actCd = event.getActivityGroupMappingVO().getChkActCd();
		}
		ManualInputBC command = new ManualInputBCImpl();
		String knt = null;
		try{
			knt = command.checkActualCode(actCd);
			eventResponse.setETCData("knt", knt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESD_SCE_3301 : COMMAND01 <br>
	 * checkActualCode<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkActualActivityMappingCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3301Event event = (EsdSce3301Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		String actCd = null;
		String actStsMapgCd = null;
		String actRcvTpCd = null;
		String chk = null;
		
		try{
			actCd = event.getActualActivityMappingVO().getChkActCd();
			actStsMapgCd = event.getActualActivityMappingVO().getChkActStsMapgCd();
			actRcvTpCd = event.getActualActivityMappingVO().getChkActRcvTpCd();
			chk = command.checkActualActivityMappingCode(actCd, actStsMapgCd, actRcvTpCd);
			eventResponse.setETCData("chk", chk);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	/**
	 * EsdSce3302 searchActivityGroupList.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActivityGroupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3302Event event = (EsdSce3302Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		try{
			List<ActivityGroupVO> list = command.searchActivityGroupList(event.getActivityGroupVO());
			eventResponse.setRsVoList(list);
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
	 * EsdSce3302 searchActivityGroupList.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkActivityGroupCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3302Event event = (EsdSce3302Event)e;
		ManualInputBC command = new ManualInputBCImpl();
		String chk = null;

		try{
			chk = command.checkActivityGroupCode(event.getActivityGroupVO());
			eventResponse.setETCData("chk", chk);
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
	 * ESD_SCE_3302 : MULTI <br>
	 * manageActivityGroup<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageActivityGroup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3302Event event = (EsdSce3302Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		try{
			begin();
			command.manageActivityGroup(event.getActivityGroupVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EsdSce3303 searchActivityGroupMappingList.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActivityGroupMappingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3303Event event = (EsdSce3303Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		try{
			List<ActivityGroupMappingVO> list = command.searchActivityGroupMappingList(event.getActivityGroupMappingVO());
			eventResponse.setRsVoList(list);
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
	 * ESD_SCE_3303 : COMMAND02 <br>
	 * checkCOPDetailGroupCode<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCOPDetailGroupCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3303Event event = (EsdSce3303Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		String copDtlGrpCd = null;
		String knt2 = null;
		
		try{
			copDtlGrpCd = event.getActivityGroupMappingVO().getChkCopDtlGrpCd();
			knt2 = command.checkCOPDetailGroupCode(copDtlGrpCd);
			eventResponse.setETCData("knt2", knt2);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESD_SCE_3303 : COMMAND03 <br>
	 * checkActivityGroupMappingCode<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkActivityGroupMappingCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3303Event event = (EsdSce3303Event)e;
		ManualInputBC command = new ManualInputBCImpl();
		
		String actCd = null;
		String copDtlGrpCd = null;
		String chk = null;
		
		try{
			actCd = event.getActivityGroupMappingVO().getChkActCd();
			copDtlGrpCd = event.getActivityGroupMappingVO().getChkCopDtlGrpCd();
			chk = command.checkActivityGroupMappingCode(actCd, copDtlGrpCd);
			eventResponse.setETCData("chk", chk);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESD_SCE_3303 : MULTI <br>
	 * manageActivityGroupMapping<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageActivityGroupMapping(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3303Event event = (EsdSce3303Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		try{
			begin();
			command.manageActivityGroupMapping(event.getActivityGroupMappingVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
		/**
	 * ESD_SCE_3304 : SEARCH <br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSceCntrStsMsgMvmtMappingList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3304Event event = (EsdSce3304Event) e;

		ManualInputBC command = new ManualInputBCImpl();

		try {
			List<SceCntrStsMsgMvmtMapgVO> list = command.searchSceCntrStsMsgMvmtMappingList(event.getSceCntrStsMsgMvmtMapgVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}

	/**
	 * ESD_SCE_3304 : MODIFY <br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSceCntrStsMsgMvmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3304Event event = (EsdSce3304Event) e;

		ManualInputBC command = new ManualInputBCImpl();

		try {
			begin();
			command.manageSceCntrStsMsgMvmt(event.getSceCntrStsMsgMvmtMapgVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}
	
	private EventResponse searchSceCopCntrRepoRuleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3305Event event = (EsdSce3305Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		try{
			List<SceCopCntrRepoRuleVO> list = command.searchSceCopCntrRepoRuleList(event.getSceCopCntrRepoRuleVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}



	private EventResponse manageSceCopCntrRepoRule(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3305Event event = (EsdSce3305Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		try{
			begin();
			command.manageSceCopCntrRepoRule(event.getSceCopCntrRepoRuleVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	
	
	private EventResponse searchSceRailSplcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3306Event event = (EsdSce3306Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		try{
			List<SceRailSplcVO> list = command.searchSceRailSplcList(event);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}



	
	private EventResponse manageSceRailSplc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce3306Event event = (EsdSce3306Event)e;
		ManualInputBC command = new ManualInputBCImpl();

		try{
			begin();
			command.manageSceRailSplc(event.getSceRailSplcVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	private EventResponse searchCheckValidation(HashMap<String, String> map) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManualInputBC command = new ManualInputBCImpl();

		try{
			if(map.get("frm_cntr_tpsz_cd") != null && !((String)map.get("frm_cntr_tpsz_cd")).equals("")) {
				List<MdmCntrTpSzVO> list = command.searchMdmCntrTpszCd(map);
				eventResponse.setRsVoList(list);
			}
			else if(map.get("frm_cnt_cd") != null && !((String)map.get("frm_cnt_cd")).equals("")) {
				List<MdmCountryVO> list = command.searchMdmCountryCd(map);
				eventResponse.setRsVoList(list);
			}
			else if(map.get("frm_loc_cd") != null && !((String)map.get("frm_loc_cd")).equals("")) {
				List<MdmLocationVO> list = command.searchMdmLocationCd(map);
				eventResponse.setRsVoList(list);
			}
			else if(map.get("frm_rgn_cd") != null && !((String)map.get("frm_rgn_cd")).equals("")) {
				List<MdmRegionVO> list = command.searchMdmRegionCd(map);
				eventResponse.setRsVoList(list);
			}
			else if(map.get("frm_yd_cd") != null && !((String)map.get("frm_yd_cd")).equals("")) {
				List<MdmYardVO> list = command.searchMdmYard(map);
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
} 