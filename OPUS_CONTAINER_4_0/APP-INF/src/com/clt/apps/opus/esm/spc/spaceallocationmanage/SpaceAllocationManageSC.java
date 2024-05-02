/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SpaceAllocationManageSC.java
*@FileTitle      : SpaceAllocationManage
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0

=========================================================
*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.basic.CommonBC;
import com.clt.apps.opus.esm.spc.common.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.spc.common.common.vo.SearchOfficeCondVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.basic.SpaceAllocationManageBC;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.basic.SpaceAllocationManageBCImpl;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0042Event;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0044Event;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0045Event;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0047Event;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0053Event;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0070Event;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0071Event;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0053ManageListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchVesselSKDListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * SpaceAllocationManage Business Logic ServiceCommand - handling business transaction for SpaceAllocationManage 
 * 
 * @author 
 * @see SpaceAllocationManageBC
 * @since J2EE 1.6
 */

public class SpaceAllocationManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SpaceAllocationManage system - preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("SpaceAllocationManageSC Start");
		try {
			
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SpaceAllocationManage system biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("SpaceAllocationManageSC End");
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
		
	
		if (e.getEventName().equalsIgnoreCase("EsmSpc0042Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceAllocationMasterList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceAllocationDetailList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpaceAllocation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiControlOption(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceAllocation0044MasterList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceAllocation0044DetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpaceAllocation0044Manage(e);
			} else {
				eventResponse = searchRemarkFlagOffice(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSpc0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceAllocationManage045VVDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceAllocationManage045QtyList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchSpaceAllocation0047MasterList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchSpaceAllocation0047DetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpaceAllocation0047Manage(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSpc0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSpaceAllocationManageList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSpc0071Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchVesselSKDList(e);
			}
			}  else if (e.getEventName().equalsIgnoreCase("EsmSpc0070Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
					eventResponse = searchNoShowAdjustmentList(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = multiNoShowAdjustment(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
					eventResponse = searchNoShowDownloadDateList(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = multiForcastDownloadDate(e);
				} else {
					eventResponse = searchSpaceAllocationOfficeCond(e);
				}
		}
		
		
		return eventResponse;
	}
	

	/**
	 * EsmSpc0042Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse searchSpaceAllocationDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0042Event event = (EsmSpc0042Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocationDetailList(event.getConditionVO(), account);
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
	 * EsmSpc0042Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceAllocationMasterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0042Event event = (EsmSpc0042Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SearchSpaceAllocation0042MListVO> list = command.searchSpaceAllocationMasterList(event.getConditionVO());
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
	 * EsmSpc0042Event save event process<br>
	 * space allocation info save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiSpaceAllocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0042Event event = (EsmSpc0042Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiSpaceAllocation(event.getSpcAlocPolPodVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EsmSpc0042Event save event process<br>
	 * control option save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiControlOption(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0042Event event = (EsmSpc0042Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiControlOption(event.getSpcAlocCtrlOptVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * EsmSpc0044Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceAllocation0044DetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0044Event event = (EsmSpc0044Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocation0044DetailList(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST02");
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
	 * EsmSpc0044Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceAllocation0044MasterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0044Event event = (EsmSpc0044Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocation0044MasterList(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST01");
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
	 * EsmSpc0044Event save event process<br>
	 * space allocation info save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiSpaceAllocation0044Manage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0044Event event = (EsmSpc0044Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			
			command.multiSpaceAllocation0044Manage(event.getSpcAlocPolPodVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EsmSpc0047Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceAllocation0047DetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0047Event event = (EsmSpc0047Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocation0047DetailList(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST02");
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
	 * EsmSpc0047Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceAllocation0047MasterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0047Event event = (EsmSpc0047Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocation0047MasterList(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST01");
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
	 * EsmSpc0047Event save event process<br>
	 * space allocation info save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiSpaceAllocation0047Manage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0047Event event = (EsmSpc0047Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiSpaceAllocation0047Manage(event.getSpcAlocPolPodVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EsmSpc0045Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceAllocationManage045VVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0045Event event = (EsmSpc0045Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocationManage045VVDList(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST01");
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
	 * EsmSpc0045Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceAllocationManage045QtyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0045Event event = (EsmSpc0045Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SpaceAllocationManageVO> list = command.searchSpaceAllocationManage045QtyList(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST02");
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
	 * EsmSpc0053Event retrieve event process<br>
	 * space allocation info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpaceAllocationManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0053Event event = (EsmSpc0053Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		try{
			List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocation0053ManageListVOs = command.searchSpaceAllocationManageList(event.getConditionVO());
			List<SpaceAllocationManageVO> mainList = new ArrayList<SpaceAllocationManageVO>();
			SpaceAllocationManageVO spaceAllocationManageVO = new SpaceAllocationManageVO();
			spaceAllocationManageVO.setSearchSpaceAllocation0053ManageListVOs(searchSpaceAllocation0053ManageListVOs);
			mainList.add(spaceAllocationManageVO);
			eventResponse.setRsVoList(mainList);
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
	 * ESM_SPC_0070 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoShowAdjustmentList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0070Event event = (EsmSpc0070Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SpaceAllocationManageVO> list = command.searchNoShowAdjustmentList(event.getConditionVO());
			list.get(0).setConditionVO(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST01");
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
	 * ESM_SPC_0070 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoShowDownloadDateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0070Event event = (EsmSpc0070Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();

		try{
			List<SpaceAllocationManageVO> list = command.searchNoShowDownloadDateList(event.getConditionVO());
			list.get(0).setConditionVO(event.getConditionVO());
			list.get(0).setEventCommend("SEARCHLIST02");
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
	 * ESM_SPC_0070 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiNoShowAdjustment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0070Event event = (EsmSpc0070Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiNoShowAdjustment(event.getSpcNshwRsltVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SPC_0070 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiForcastDownloadDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0070Event event = (EsmSpc0070Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			begin();
			command.multiForcastDownloadDate(event.getSpcFcastDwnLodSkdVOS(),account);
			eventResponse.setETCData("status", "OK");
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EsmSpc0071Event retrieve event process<br>
	 * vessel schedule info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchVesselSKDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSpc0071Event event = (EsmSpc0071Event)e;
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		try{
			List<SearchVesselSKDListVO> list = command.searchVesselSKDList(event.getConditionVO());
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
	 * retrieve event process<br>
	 * remark info retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchRemarkFlagOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		String ofcCd = account.getOfc_cd();
		
		try{
			String rmkFlg = command.searchRemarkFlagOffice(ofcCd);
			eventResponse.setETCData("rmkFlg",rmkFlg);
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
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpaceAllocationOfficeCond(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC comCommand = new CommonBCImpl();
		SpaceAllocationManageBC command = new SpaceAllocationManageBCImpl();
		
		String ofcCd = account.getOfc_cd();
		
		try{
			List<SearchOfficeCondVO> list = comCommand.searchOfficeCond(e, account);
			if(list.size() > 0){
				SearchOfficeCondVO searchOfficeCondVO = list.get(0);
				eventResponse.setETCData(searchOfficeCondVO.getColumnValues());
			}
			/* 2010.08.27 이행지 [CHM-201005552-01] Allocation Control by Main Office 화면 Remark 기능 보완
               Remark 가능한 Office인지 체크하여 Flag값 받아오기.
            */
			String rmkFlg = command.searchRemarkFlagOffice(ofcCd);
			eventResponse.setETCData("rmkFlg",rmkFlg);
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