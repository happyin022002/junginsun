/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BSAManageSC.java
 *@FileTitle : BSA Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 =========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.basic.BSAManageBC;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.basic.BSAManageBCImpl;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0021Event;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0023Event;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0024Event;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0026Event;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0028Event;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0120Event;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0162Event;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0172Event;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.CreateBSAVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchChgSlotSwapListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownDetailListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcJoPortDownMasterListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownDetailListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchSpcScPortDownMasterListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.basic.SPCManageBC;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.basic.SPCManageBCImpl;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event.EsmBsa0030Event;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event.EsmBsa0032Event;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event.EsmBsa0104Event;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.event.EsmBsa0143Event;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcConditionVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotInfoByVvdOnVesselListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchSpcSlotSwapByVvdListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdDetailListVO;
import com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.vo.SearchStepUpDownVvdMasterListVO;
import com.clt.apps.opus.esm.bsa.common.basic.CommonBC;
import com.clt.apps.opus.esm.bsa.common.basic.CommonBCImpl;
import com.clt.apps.opus.esm.bsa.common.vo.CommonBsaRsVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BsaCrrInfoVO;
import com.clt.syscommon.common.table.BsaVvdSwapInfoVO;


/**
 * BSAManage Business Logic ServiceCommand - Handling business transaction for BSAManage 
 * 
 * @author 
 * @see BSAManageSC
 * @since J2EE 1.6
 */
public class BSAManageSC extends ServiceCommandSupport {

	SignOnUserAccount account = null;

	String strUserId = "";

	/**
	 * BSAManage preceding process for biz scenario<br>
	 * BSAManage Creating related object by calling work scenario<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			strUserId = account.getUsr_id();
		} catch (Exception e) {
			log.error("BSAManageSC Error by preceding process " + e.toString(), e);
		}
	}

	/**
	 * BSAManage Handling for the end of working scenario<br>
	 * BSAManage Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		log.debug("BSAManageSC end ...........................");
	}

	
	/**
	 * Handling working scenario of each event<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */

	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		
		log.debug("################# BSAManageSC.perform() ############################[START]");
		
		EventResponse eventResponse = null;

		log.debug("\n [CALL] Service Command ------------------------------------------- "
						+ "\n EventName : "
						+ e.getEventName()
						+ "\n Command   : " + e.getFormCommand().getCommand());

		if (e.getEventName().equalsIgnoreCase("EsmBsa0021Event")) {
			
			log.debug("e.getFormCommand().getCommand() = " + e.getFormCommand().getCommand());
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { 							
				eventResponse = searchBSATableJOList(e);                 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { 			
				eventResponse = searchBSATableSCList(e); 	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 		
				eventResponse = multiBSATableJO(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 			
				eventResponse = multiBSATableSC(e); 		
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { 
				eventResponse = removeBSATableJO(e); 				
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) { 
				eventResponse = removeBSATableSC(e);  					
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)
					|| e.getFormCommand().isCommand(FormCommand.MULTI04)) { 
				eventResponse = createBSA(e); 								
			}
			else { 
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchBSATableHeaderList(e).getCustomData());
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCarrierRegisterList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyCarrierRegister(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiCarrierInfo(e);
			} else {
				eventResponse = searchInitComBo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Joint
				eventResponse = searchSPCJOBSA(e);// Operation
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // swap				
				eventResponse = searchChgSlotSwapList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // Space
				eventResponse = searchSPCSCBSA(e);// Chartering						
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiSPCJOBSA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiChgSlotSwap(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = multiSPCSCBSA(e);
			} else {
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchCarrierItem(e).getCustomData());
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {        
				eventResponse = searchSpcJoPortDownMasterList(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {  
				eventResponse = searchSpcJoPortDownDetailList(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { 		
				eventResponse = searchSpcScPortDownMasterList(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { 	
				eventResponse = searchSpcScPortDownDetailList(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {      
				eventResponse = multiSPCDownPortJOMaster(e);      
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 	
				eventResponse = multiSPCDownPortJODetail(e);  	  
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { 	 
				eventResponse = multiSPCDownPortSCMaster(e);	  
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { 	 
				eventResponse = multiSPCDownPortSCDetail(e);	  
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { 	 						
				eventResponse = resetSPCDownPortJO(e);		      
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { 	 			
				eventResponse = resetSpcScPortDown(e); 			  
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {    
				eventResponse = createSpcJoPortDown(e); 		  
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {    						
				eventResponse = createSpcScPortDown(e);  		  
			} else {
				eventResponse = searchInitComBo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchSlotCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { 
				eventResponse = searchRFCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)
					|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { 
				eventResponse = searchOverCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {		//20150514.ADD
				eventResponse = searchOpSlotCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = multiSlotCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)
					|| e.getFormCommand().isCommand(FormCommand.MULTI02)) { 
				eventResponse = multiRFCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)
					|| e.getFormCommand().isCommand(FormCommand.MULTI04)) { 
				eventResponse = multiOverCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)
					|| e.getFormCommand().isCommand(FormCommand.MULTI06)) {				//20150514.ADD
				eventResponse = multiOpSlotCost(e);
			} else { 
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchBsaCrrRgstList(e).getCustomData());
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0172Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchBSARateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { 
				eventResponse = searchBSARateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { 
				eventResponse = searchBSARateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = multiBSARate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 
				eventResponse = multiBSARate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { 
				eventResponse = multiBSARate(e);
			} else { 
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchBsaCrrRgstList1(e).getCustomData());
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0162Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchOverUsedSlotCostList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { 
				eventResponse = multiOverUsedSlotCost(e);
			} else { 
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchBsaCrrRgstList2(e).getCustomData());
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchSupplySwapVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { 
				eventResponse = searchSlotPrcSwapVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { 
				eventResponse = searchTEUPrcSwapVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { 
				eventResponse = searchRevCostSwapVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				eventResponse = createSupplySwapVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = resetSupplySwapVvd(e);
			} else {
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchOpJobCarrierList(e).getCustomData());
				eventResponse.setETCData(searchPrevWkPrd(e).getETCData());
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { 
				eventResponse = searchStepUpDownVvdMasterList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				eventResponse = modifyStepUpDownVvdMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { 
				eventResponse = searchStepUpDownVvdDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 
				eventResponse = multiStepUpDownVvd(e);
			} else {
				eventResponse = searchInitComBo(e);
				eventResponse.setETCData(searchPrevWkPrd(e).getETCData());
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCarrierInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCarrierInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiCarrierInfo(e);
			}
				
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { 
				eventResponse = this.searchSpcSlotInfoByVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				eventResponse = this.multiSpcSlotInfoByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { 
				eventResponse = this.searchSpcSlotSwapByVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 
				eventResponse = this.multiSpcSlotSwapByVvd(e);
			} else {
				eventResponse = searchInitComBo(e);
				eventResponse.setCustomData(searchCarrierItem(e).getCustomData());
				eventResponse.setETCData(searchPrevWkPrd(e).getETCData());
			}			
		} else if (e.getEventName().equalsIgnoreCase("EsmBsa0143Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchSpcSlotInfoByVvdOnVesselList(e);
			} else {
				eventResponse = searchInitComBo(e);
			}
		}
		
		log.debug("################# BSAManageSC.perform() ############################[END]");

		return eventResponse;
	}

	/**
	 * EsmBsa0021Event retrieve event process<br>
	 * BSAManage Header List retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */

	private EventResponse searchBSATableHeaderList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchBSATableHeaderList() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
		try{			
			CommonBsaRsVO rtnVo = command.searchBSATableHeaderList();
			
			eventResponse.setCustomData("rtnVo", rtnVo);
			
			log.debug("################# BSAManageSC.searchBSATableHeaderList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
		
	}		


	/**
	 * EsmBsa0021Event retrieve event process<br>
	 * BSAManage  selective retrieve (JO List)<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchBSATableJOList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchBSATableJOList() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{			
			CommonBsaRsVO rtnVo = command.searchBSATableJOList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rtnVo);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rtnVo);
			log.debug("################# BSAManageSC.searchBSATableJOList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	

	/**
	 * EsmBsa0021Event retrieve event process<br>
	 * BSAManage  selective retrieve (SC List)<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchBSATableSCList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchBSATableSCList() ############################[START]");
		EsmBsa0021Event event = (EsmBsa0021Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			BSAManageBC command = new BSAManageBCImpl();
			CommonBsaRsVO rtnVo = command.searchBSATableSCList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rtnVo);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rtnVo);			
			log.debug("################# BSAManageSC.searchBSATableSCList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}		

	/**
	 * EsmBsa0021Event retrieve event process<br>
	 * BSAManage  selective retrieve (JO)<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiBSATableJO(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiBSATableJO() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiBSATableJO(event.getBsaTableSaveVOs(), account);
			
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiBSATableJO() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EsmBsa0021Event save event process<br>
	 * BSAManage  selective save (SC)<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiBSATableSC(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiBSATableSC() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiBSATableSC(event.getBsaTableSaveVOs(), account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiBSATableSC() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EsmBsa0021Event remove event process<br>
	 * BSAManage  selective retrieve (JO)<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse removeBSATableJO(Event e) throws EventException {
		log.debug("################# BSAManageSC.removeBSATableJO() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.removeBSATableJO(event.getBsaTableSaveVOs());
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10051").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.removeBSATableJO() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EsmBsa0021Event remove event process<br>
	 * BSAManage  selective retrieve (SC)<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse removeBSATableSC(Event e) throws EventException {
		log.debug("################# BSAManageSC.removeBSATableSC() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.removeBSATableSC(event.getBsaTableSaveVOs());
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10051").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.removeBSATableSC() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EsmBsa0021Event create event process<br>
	 * BSAManage  BSA Create<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse createBSA(Event e) throws EventException {
		log.debug("################# BSAManageSC.createBSA() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0021Event event = (EsmBsa0021Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			CreateBSAVO createRtnVo = command.createBSA(event.getSearchBsaConditionVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			
			eventResponse.setETCData("err_cd", createRtnVo.getPErrorCode());
			eventResponse.setETCData("err_msg", createRtnVo.getPErrorMsg());
			eventResponse.setCustomData("rtnVo", createRtnVo);
			commit();
			
			log.debug("################# BSAManageSC.createBSA() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**
	 * EsmBsa0023Event retrieve event process<br>
	 * BSAManage  CarrierRegister retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCarrierRegisterList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0023Event event = (EsmBsa0023Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			CommonBsaRsVO rtnVo = command.searchCarrierRegisterList(event.getBsaOpCd());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rtnVo);
			
			eventResponse.setRsVoList(list);
			eventResponse.setCustomData("rtnVo", rtnVo);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}	

	/**
	 * EsmBsa0023Event modify event process<br>
	 * BSAManage  CarrierRegister modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse modifyCarrierRegister(Event e) throws EventException {
		log.debug("################# BSAManageSC.modifyCarrierRegister() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0023Event event = (EsmBsa0023Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.modifyCarrierRegister(event.getBsaAddCarrierSaveVOs(), account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
			log.debug("################# BSAManageSC.modifyCarrierRegister() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * EsmBsa0026Event retreive event process<br>
	 * BSAManage  Jo Port Down Master retreive<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */

	private EventResponse searchSpcJoPortDownMasterList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			List<SearchSpcJoPortDownMasterListVO> list = command.searchSpcJoPortDownMasterList(event.getSearchBsaConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	

	/**
	 * EsmBsa0026Event retreive event process<br>
	 * BSAManage  Jo Port Down Detail retreive<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchSpcJoPortDownDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			List<SearchSpcJoPortDownDetailListVO> list = command.searchSpcJoPortDownDetailList(event.getSearchBsaConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}
	

	/**
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  Jo Port Down modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse resetSPCDownPortJO(Event e) throws EventException {
	log.debug("################# SPCManageBC.resetSPCDownPortJO() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.resetSpcJoPortDown(event.getSearchBsaConditionVO(),account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
//			eventResponse.setETCData("err_cd","00000");
//			eventResponse.setETCData("err_msg","OK!");
			commit();
			log.debug("################# SPCManageBC.resetSPCDownPortJO() ############################[END]");
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EsmBsa0026Event create event process<br>
	 * BSAManage  Jo Port Down create<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse createSpcJoPortDown(Event e) throws EventException {
		log.debug("################# BSAManageSC.createSpcJoPortDown() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.createSpcJoPortDown(event.getSearchBsaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setETCData("err_cd","00000");
			eventResponse.setETCData("err_msg","OK!");
			commit();
			
			log.debug("################# BSAManageSC.createSpcJoPortDown() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	

	/**
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  Jo Port Down master modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse multiSPCDownPortJOMaster(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiSPCDownPortJOMaster() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiSPCDownPortJOMaster(event.getBsaJntOpCrrCapaVOs(), account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiSPCDownPortJOMaster() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  Jo Port Down Detail modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse multiSPCDownPortJODetail(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiSPCDownPortJODetail() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiSPCDownPortJODetail(event.getBsaJntOpPortDwnVOs(), account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiSPCDownPortJODetail() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * EsmBsa0026Event retreive event process<br>
	 * BSAManage  SC Port Down master retreive<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */

	private EventResponse searchSpcScPortDownMasterList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			List<SearchSpcScPortDownMasterListVO> list = command.searchSpcScPortDownMasterList(event.getSearchBsaConditionVO());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	

	/**
	 * EsmBsa0026Event retreive event process<br>
	 * BSAManage  SC Port Down detail retreive<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchSpcScPortDownDetailList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchSpcScPortDownDetailList() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			List<SearchSpcScPortDownDetailListVO> list = command.searchSpcScPortDownDetailList(event.getSearchBsaConditionVO());
			eventResponse.setRsVoList(list);
			log.debug("################# BSAManageSC.searchSpcScPortDownDetailList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}					
	}	

	/**
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  SC Port Down modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse resetSpcScPortDown(Event e) throws EventException {
		log.debug("################# BSAManageSC.resetSpcScPortDown() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.resetSpcScPortDown(event.getSearchBsaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setETCData("err_cd","00000");
			eventResponse.setETCData("err_msg","OK!");
			commit();
			
			log.debug("################# BSAManageSC.resetSpcScPortDown() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * EsmBsa0026Event create event process<br>
	 * BSAManage  SC Port Down create<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse createSpcScPortDown(Event e) throws EventException {
		log.debug("################# BSAManageSC.createSpcScPortDown() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.createSpcScPortDown(event.getSearchBsaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setETCData("err_cd","00000");
			eventResponse.setETCData("err_msg","OK!");
			commit();
			
			log.debug("################# BSAManageSC.createSpcScPortDown() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  SC Port Down master modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse multiSPCDownPortSCMaster(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiSPCDownPortSCMaster() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiSPCDownPortSCMaster(event.getBsaSltChtrCrrCapaVOs(), account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiSPCDownPortSCMaster() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * EsmBsa0026Event modify event process<br>
	 * BSAManage  SC Port Down detail modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse multiSPCDownPortSCDetail(Event e) throws EventException {
		log.debug("################# BSAManageSC.multiSPCDownPortSCDetail() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0026Event event = (EsmBsa0026Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiSPCDownPortSCDetail(event.getBsaSltChtrPortDwnVOs(), account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
			
			log.debug("################# BSAManageSC.multiSPCDownPortSCDetail() ############################[END]");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  op job Carrier retreive<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchOpJobCarrierList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchOpJobCarrierList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e;
		SPCManageBC command = new SPCManageBCImpl();
		try {
			CommonBsaRsVO vo = command.searchOpJobCarrierList(event.getSearchSpcConditionVO());
			eventResponse.setCustomData("rtnVo", vo);
//			eventResponse.setRsVoList(vo.getResultVOList());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  supply swap vvd list retreive<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchSupplySwapVvdList(Event e)	throws EventException {
		log.debug("################# SPCManageBC.searchSupplySwapVvdList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.searchSupplySwapVvdList(event.getSearchSpcConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);	
			
			log.debug("################# SPCManageBC.searchSupplySwapVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  slot price retreive<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchSlotPrcSwapVvdList(Event e)	throws EventException {
		log.debug("################# SPCManageBC.searchSlotPrcSwapVvdList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.searchSlotPrcSwapVvdList(event.getSearchSpcConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			

			log.debug("################# SPCManageBC.searchSlotPrcSwapVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}


	/**
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  TEU & Slot Price retreive<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchTEUPrcSwapVvdList(Event e) throws EventException {
		log.debug("################# SPCManageBC.searchTEUPrcSwapVvdList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.searchTEUPrcSwapVvdList(event.getSearchSpcConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			

			log.debug("################# SPCManageBC.searchTEUPrcSwapVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  Revenue & Cost Of Slot-swap By VVD List retreive<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse searchRevCostSwapVvdList(Event e)	throws EventException {
		log.debug("################# SPCManageBC.searchRevCostSwapVvdList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.searchRevCostSwapVvdList(event.getSearchSpcConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			

			log.debug("################# SPCManageBC.searchRevCostSwapVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	
	/**
	 * EsmBsa0030Event create event process<br>
	 * BSAManage  Slot-swap By VVD List create<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse createSupplySwapVvd(Event e) throws EventException {
		log.debug("################# SPCManageBC.createSupplySwapVvd() ############################[START]");
		// Object including the result of user request (DB Result Set, Object and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.createSupplySwapVvd(event.getSearchSpcConditionVO(),account);

			eventResponse.setETCData("err_cd",rsVO.getErrorCode());
			eventResponse.setETCData("err_msg",rsVO.getErrorMsg());
			log.debug("################# SPCManageBC.createSupplySwapVvd() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EsmBsa0030Event retreive event process<br>
	 * BSAManage  Slot-swap By VVD List modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse resetSupplySwapVvd(Event e) throws EventException {
		log.debug("################# SPCManageBC.resetSupplySwapVvd() ############################[START]");
		// Object including the result of user request (DB Result Set, Object and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0030Event event = (EsmBsa0030Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			CommonBsaRsVO rsVO = command.resetSupplySwapVvd(event.getSearchSpcConditionVO(),account);

			eventResponse.setETCData("err_cd",rsVO.getErrorCode());
			eventResponse.setETCData("err_msg",rsVO.getErrorMsg());
			
			log.debug("################# SPCManageBC.resetSupplySwapVvd() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EsmBsa0104Event retreive event process<br>
	 * BSAManage  SlotInfo by vvd retreive<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse searchSpcSlotInfoByVvdList(Event e) throws EventException {
		log.debug("################# SPCManageBC.searchSpcSlotInfoByVvdList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0104Event event = (EsmBsa0104Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		CommonBsaRsVO rsVo = new CommonBsaRsVO();
		try {
			rsVo = command.searchSpcSlotInfoByVvdList(event.getSearchSpcConditionVO());
			
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVo);

			eventResponse.setRsVoList(list);				
			
			log.debug("################# SPCManageBC.searchSpcSlotInfoByVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	

	/**
	 * EsmBsa0104Event modify event process<br>
	 * BSAManage  SlotInfo by vvd modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse multiSpcSlotInfoByVvd(Event e) throws EventException {
		log.debug("################# SPCManageBC.multiSpcSlotInfoByVvd() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0104Event event = (EsmBsa0104Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		try {
			begin();
			command.multiSpcSlotInfoByVvd(event.getBsaSpcSlotInfoByVvdSaveVOs(),account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
			log.debug("################# SPCManageBC.multiSpcSlotInfoByVvd() ############################[END]");
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EsmBsa0104Event retrieve event process<br>
	 * BSAManage  Slot swap by vvd retrieve for ESM_BSA_0121 Pop-up<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSpcSlotSwapByVvdList(Event e)throws EventException {
		log.debug("################# SPCManageBC.searchSpcSlotSwapByVvdList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0104Event event = (EsmBsa0104Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		try {
			List<SearchSpcSlotSwapByVvdListVO>list = command.searchSpcSlotSwapByVvdList(event.getSearchSpcConditionVO());
			
			eventResponse.setRsVoList(list);				
			
			log.debug("################# SPCManageBC.searchSpcSlotSwapByVvdList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	

	/**
	 * EsmBsa0104Event modify event process<br>
	 * BSAManage  Slot swap by vvd modify for ESM_BSA_0121 Pop-up<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse multiSpcSlotSwapByVvd(Event e) throws EventException {
		log.debug("################# SPCManageBC.multiSpcSlotSwapByVvd() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0104Event event = (EsmBsa0104Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		
		
		try {
			begin();
			BsaVvdSwapInfoVO[] vos = event.getBsaVvdSwapInfoVOs();
			SearchSpcConditionVO vo = event.getSearchSpcConditionVO();
			command.multiSpcSlotSwapByVvd(vo,vos,account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
			log.debug("################# SPCManageBC.multiSpcSlotSwapByVvd() ############################[END]");
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	

	/**
	 * EsmBsa0104Event retrieve event process<br>
	 * BSAManage  Slot info by vvd on vessel list retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse searchSpcSlotInfoByVvdOnVesselList(Event e)throws EventException {
		// Object including the result of user request (DB Result Set, Object and etc)
		log.debug("################# SPCManageBC.searchSpcSlotInfoByVvdOnVesselList() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0143Event event = (EsmBsa0143Event)e; 
		SPCManageBC command = new SPCManageBCImpl();
		try {
			List<SearchSpcSlotInfoByVvdOnVesselListVO>list = command.searchSpcSlotInfoByVvdOnVesselList(event.getSearchSpcConditionVO());
			
			eventResponse.setRsVoList(list);				
			
			log.debug("################# SPCManageBC.searchSpcSlotInfoByVvdOnVesselList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
 }

	/**
	 * EsmBsa0032Event retrieve event process<br>
	 * BSAManage step up down vvd master retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchStepUpDownVvdMasterList(Event e)throws EventException {
		log.debug("################# BSAManageSC.searchStepUpDownVvdMasterList() ############################[START]");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SPCManageBC command = new SPCManageBCImpl();
		EsmBsa0032Event event = (EsmBsa0032Event)e;
		try{
			List< SearchStepUpDownVvdMasterListVO > list = command.searchStepUpDownVvdMasterList(event.getSearchSpcConditionVO());
			eventResponse.setRsVoList(list);	
			log.debug("################# BSAManageSC.searchStepUpDownVvdMasterList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}

	/**
	 * EsmBsa0032Event retrieve event process<br>
	 * BSAManage step up down vvd detail retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchStepUpDownVvdDetailList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchStepUpDownVvdDetailList() ############################[START]");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SPCManageBC command = new SPCManageBCImpl();
		EsmBsa0032Event event = (EsmBsa0032Event)e;
		try{
			List< SearchStepUpDownVvdDetailListVO > list = command.searchStepUpDownVvdDetailList(event.getSearchSpcConditionVO());
			eventResponse.setRsVoList(list);	
			log.debug("################# BSAManageSC.searchStepUpDownVvdDetailList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}


	/**
	 * EsmBsa0032Event modify event process<br>
	 * BSAManage step up down vvd master modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse modifyStepUpDownVvdMaster(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0032Event event = (EsmBsa0032Event)e;
		SPCManageBC command = new SPCManageBCImpl();
		try{
			begin();
			command.modifyStepUpDownVvdMaster(event.getBsaVvdMstVOs(),account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
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
	 * EsmBsa0032Event modify event process<br>
	 * BSAManage step up down vvd modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiStepUpDownVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0032Event event = (EsmBsa0032Event)e;
		SPCManageBC command = new SPCManageBCImpl();
		try{
			begin();
			command.multiStepUpDownVvd(event.getBsaVvdPortDwnVOs(),account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
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
	 * EsmBsa0024Event & EsmBsa0104Event retrieve event process<br>
	 * BSAManage Carrier Item retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchCarrierItem(Event e) throws EventException {
		BSAManageBC command = new BSAManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBsaRsVO retVo = new CommonBsaRsVO();
	   	CommonBC comCommand = new CommonBCImpl();
		
		String jo_crrItem = "";
		String sc_crrItem = "";
		String crrItem = "";
		String cobOpJob = "";
		try{
			if(e.getEventName().equalsIgnoreCase("EsmBsa0024Event")){
				
				jo_crrItem = command.searchCarrierItem("J");
				sc_crrItem = command.searchCarrierItem("S");
				cobOpJob = comCommand.searchBSAOpt();
				
				retVo.setStrTemp(jo_crrItem);
				retVo.setStrTemp2(sc_crrItem);
				retVo.setStrTemp3(cobOpJob);
				
				eventResponse.setCustomData("retVo", retVo);
				
			}else if(e.getEventName().equalsIgnoreCase("EsmBsa0104Event")){
				crrItem = command.searchCarrierItem(""); // master sheet 조회
				cobOpJob = comCommand.searchBSAOpt();
				
				retVo.setStrTemp(crrItem);
				retVo.setStrTemp3(cobOpJob);
				
				eventResponse.setCustomData("retVo", retVo);
			}
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	
	/**
	 * EsmBsa0024Event retrieve event process<br>
	 * BSAManage BSAManage SPC Control J/O list retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSPCJOBSA(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchSPCJOBSA() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0024Event event = (EsmBsa0024Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{			
			CommonBsaRsVO rtnVo = command.searchSPCJOBSA(event.getSearchBsaConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());			
			log.debug("################# BSAManageSC.searchSPCJOBSA() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
	

	/**
	 * EsmBsa0024Event modify event process<br>
	 * BSAManage BSAManage SPC Control J/O list modify<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse multiSPCJOBSA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0024Event event = (EsmBsa0024Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		
		try {
			begin();
			command.multiSPCJOBSA(event.getBsaSlotInfoForSpcCntrSaveVOs(), account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
			return (eventResponse); 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * EsmBsa0024Event retrieve event process<br>
	 * BSAManage BSAManage SPC Control J/O POPUP List retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */			
	private EventResponse searchChgSlotSwapList(Event e) throws EventException {
		log.debug("################# SPCManageBC.searchChgSlotSwapList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object, parameter and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0024Event event = (EsmBsa0024Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		
		try {
			List<SearchChgSlotSwapListVO> list = command.searchChgSlotSwapList(event.getSearchBsaConditionVO());

			eventResponse.setRsVoList(list);			

			log.debug("################# SPCManageBC.searchChgSlotSwapList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}


	/**
	 * EsmBsa0024Event save event process<br>
	 * BSAManage BSAManage SPC Control J/O POPUP List save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiChgSlotSwap(Event e) throws EventException {
		log.debug("################# SPCManageBC.multiChgSlotSwap() ############################[START]");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0024Event event = (EsmBsa0024Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		
		try {
			begin();
			 command.multiChgSlotSwap(event.getBsaSpcCtrlSwapVOs(),event.getSearchBsaConditionVO(),account);
			 //성공메시지 : SJH.20150210.MOD
			 eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			 commit();
			 log.debug("################# SPCManageBC.multiChgSlotSwap () ############################[END]");
			}catch(EventException ex){
				rollback();
				throw ex;
			}catch(Exception ex){ 
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
	}	


	/**
	 * EsmBsa0024Event retrieve event process<br>
	 * BSAManage BSAManage SPC Control J/O List retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSPCSCBSA(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchSPCSCBSA() ############################[START]");
		EsmBsa0024Event event = (EsmBsa0024Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			BSAManageBC command = new BSAManageBCImpl();
			CommonBsaRsVO rtnVo = command.searchSPCSCBSA(event.getSearchBsaConditionVO());
            eventResponse.setRsVo(rtnVo.getDbRowset());			
			log.debug("################# BSAManageSC.searchSPCSCBSA() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}	


	/**
	 * EsmBsa0025Event save event process<br>
	 * BSAManage BSAManage SPC Control J/O List save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiSPCSCBSA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0024Event event = (EsmBsa0024Event)e; 
		BSAManageBC command = new BSAManageBCImpl();
		try {
			begin();
			command.multiSPCSCBSA(event.getBsaSlotInfoForSpcCntrSaveVOs(), account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
			return (eventResponse); 
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}		

	/**
	 * EsmBsa0120Event retrieve event process<br>
	 * BSAManage carrier info list retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	
	private EventResponse searchCarrierInfoList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchCarrierInfoList() ############################[START]");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
 
		try{
			List< BsaCrrInfoVO > list = command.searchCarrierInfoList();
			eventResponse.setRsVoList(list);	
			log.debug("################# BSAManageSC.searchCarrierInfoList() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}
	

	/**
	 * EsmBsa0120Event save event process<br>
	 * BSAManage carrier info list save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiCarrierInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
		try{
			begin();
			if(e.getEventName().equalsIgnoreCase("EsmBsa0023Event")){
				EsmBsa0023Event event = (EsmBsa0023Event)e;
				command.multiCarrierInfo(event.getSearchBsaConditionVO(),account);	
			}else if(e.getEventName().equalsIgnoreCase("EsmBsa0120Event")){
				EsmBsa0120Event event = (EsmBsa0120Event)e;
				command.multiCarrierInfo(event.getSearchBsaConditionVO(),account);	
			}			
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());			
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
	 * EsmBsa0172Event retrieve event process<br>
	 * BSAManage carrier register list retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse searchBsaCrrRgstList1(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchBsaCrrRgstList1() ############################[START]");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
 
		try{
//			String headset = command.searchBsaCrrRgstList1();
			String headset = command.searchBsaCrrRgstList3();
			eventResponse.setCustomData("headSet",headset);
			log.debug("################# BSAManageSC.searchBsaCrrRgstList1() ############################[END]");
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}

	/**
	 * EsmBsa0028Event retrieve event process<br>
	 * BSAManage carrier register list retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse searchBsaCrrRgstList(Event e) throws EventException {
		// Object including the result of user request (DB Result Set, Object, parameter and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
 
		try{
			CommonBsaRsVO vo = command.searchBsaCrrRgstList();
			eventResponse.setCustomData("rtnVo", vo);
			eventResponse.setETCData("headSet", vo.getStrTemp());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse; 		
	}
	
	/**
	 * EsmBsa0028Event retrieve event process<br>
	 * BSAManage slot cost list retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchSlotCostList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchSlotCostList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object, parameter and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0028Event event = (EsmBsa0028Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchSlotCostList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			log.debug("################# BSAManageSC.searchSlotCostList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}

	/**
	 * EsmBsa0028Event retrieve event process<br>
	 * BSAManage RF cost list retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchRFCostList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchRFCostList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object, parameter and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0028Event event = (EsmBsa0028Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchRFCostList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			log.debug("################# BSAManageSC.searchRFCostList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}

	/**
	 * EsmBsa0028Event retrieve event process<br>
	 * BSAManage over cost list retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse searchOverCostList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchRFCostList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object, parameter and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0028Event event = (EsmBsa0028Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchOverCostList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			log.debug("################# BSAManageSC.searchRFCostList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}


	/**
	 * EsmBsa0172Event retrieve event process<br>
	 * BSAManage BSA rate list retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse searchBSARateList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchBSARateList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object, parameter and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0172Event event = (EsmBsa0172Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchBSARateList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			log.debug("################# BSAManageSC.searchBSARateList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}


	/**
	 * EsmBsa0172Event save event process<br>
	 * BSAManage BSA rate list save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiBSARate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0172Event event = (EsmBsa0172Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			begin();
			String result = command.multiBSARate(event.getBsaHighCubicRateSaveVOs(), account, e);			//20150615.MOD
			log.debug("=========== result :"+result);
			if(!result.equals("S")){
				rollback();
			}
			else{
				//성공메시지 : SJH.20150210.MOD
				eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());				
				commit();
			}
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * EsmBsa0028Event save event process<br>
	 * BSAManage slot cost save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse multiSlotCost(Event e) throws EventException {
	// PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = new GeneralEventResponse();
	EsmBsa0028Event event = (EsmBsa0028Event)e;
	BSAManageBC command = new BSAManageBCImpl();
	try{
		begin();
		command.multiSlotCost(event.getBsaManageSltPrcSaveVOs(), account);
		//성공메시지 : SJH.20150210.MOD
		eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
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
	 * EsmBsa0028Event save event process<br>
	 * BSAManage RF cost save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse multiRFCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0028Event event = (EsmBsa0028Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			begin();
			command.multiRFCost(event.getBsaManageSltPrcSaveVOs(), account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
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
	 * EsmBsa0028Event save event process<br>
	 * BSAManage Over cost save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse multiOverCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0028Event event = (EsmBsa0028Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			begin();
			command.multiOverCost(event.getBsaManageSltPrcSaveVOs(), account);
			//성공메시지 : SJH.20150210.MOD
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
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
	 * EsmBsa0162Event retrieve event process<br>
	 * BSAManage BSA register retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse searchBsaCrrRgstList2(Event e) throws EventException {
		// Object including the result of user request (DB Result Set, Object, parameter and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BSAManageBC command = new BSAManageBCImpl();
 
		try{
			CommonBsaRsVO vo = command.searchBsaCrrRgstList2();
			//eventResponse.setRsVoList(vo.getResultVOList());
			
			eventResponse.setCustomData("rtnVo", vo);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse; 		
	}

	/**
	 * EsmBsa0162Event retrieve event process<br>
	 * BSAManage Used slot cost retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchOverUsedSlotCostList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchOverUsedSlotCostList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object, parameter and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0162Event event = (EsmBsa0162Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchOverUsedSlotCostList(event.getSearchBsaConditionVO());
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			log.debug("################# BSAManageSC.searchOverUsedSlotCostList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}

	/**
	 * EsmBsa0162Event save event process<br>
	 * BSAManage Used slot cost save<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse multiOverUsedSlotCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0162Event event = (EsmBsa0162Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try{
			begin();
			String result = command.multiOverUsedSlotCost(event.getBsaOverUsedSlotCostSaveVOS(), account);
			if(!result.equals("S")){
				rollback();
			}
			else{
				//성공메시지 : SJH.20150210.MOD
				eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());				
				commit();
			}
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * All retrieve event process<br>
	 * BSAManage common code retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchInitComBo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonBC comCommand = new CommonBCImpl();
		try {
			if(e.getEventName().equals("EsmBsa0021Event")){
				String array[][] = { {"trade","",""},  
									 {"rLane","",""},
		       						 {"CD00593","",""},	// Direction
		       						 {"CD00768","",""}, // JO/SC
		       						 {"ui","1",""}
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			else if(e.getEventName().equals("EsmBsa0023Event")){
				String array[][] = { {"CD00768","",""}	// JO/SC
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			else if(e.getEventName().equals("EsmBsa0024Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""},	// Direction
		       						{"CD00768","",""}	// JO/SC
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			else if(e.getEventName().equals("EsmBsa0026Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""},	// Direction
			             			{"carrier","",""},
		       						{"CD00768","",""}, // JO/SC
		       						{"ui","2",""}      // BSA(007), Slot Price(015), Weight Limit(016)
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			else if(e.getEventName().equals("EsmBsa0028Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""},	// Direction
			             			{"rLane4","",""},
			             			{"CD20002","",""},	// RATE BSA UNIT CODE(TEU/FEU)
			             			{"CD00748","",""},   // Cargo Type(Full/Empty)
			             			{"ui","3",""}
		       						};
		       eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
			}
			else if(e.getEventName().equals("EsmBsa0030Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""},	// Direction
			             			{"CD00206","",""},	// I/O
			             			{"ui","4",""} // BSA, Slottage, BSA & Slottage, Slottage Total
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
			else if(e.getEventName().equals("EsmBsa0032Event")){
				String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""},	// Direction
			             			{"CD00206","",""},	// I/O
			             			{"carrier","",""}
		       						};
				eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
			else if(e.getEventName().equals("EsmBsa0104Event")){
    			String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""},	// Direction
			             			{"CD00206","",""}	// I/O
		       						};
    			eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
			else if(e.getEventName().equals("EsmBsa0143Event")){
    			String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""},	// Direction
			             			{"CD00206","",""}	// I/O
		       						};
    			eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
			else if(e.getEventName().equals("EsmBsa0162Event")){
    		   String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""},	// Direction
			             			{"rLane4","",""}
		       						};
		       eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
	       	}
			else if(e.getEventName().equals("EsmBsa0172Event")){
    			String array[][] = { {"trade","",""},  
			             			{"rLane","",""},
			             			{"CD00593","",""},	// Direction
			             			{"rLane4","",""},
			             			{"CD20001","",""}, // D3,D5,D7  
		       						{"CD00231","",""}, // Operation Code
		       						{"CD20035","",""}  // Rate Apply Division Code
		       						};
    			eventResponse = comCommand.getMakeCodeSelectList(eventResponse,array);
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
	/**
	 * All retrieve event process<br>
	 * BSAManage previous week period retrieve<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	public EventResponse searchPrevWkPrd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	   	CommonBC comCommand = new CommonBCImpl();
	   	String prevWk = "";
	   	
		try {
			prevWk =comCommand.searchPrevWkPrd();
			eventResponse.setETCData("prevWk", prevWk);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){ 
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
   }
	
	/**
	 * EsmBsa0028Event retrieve event process<br>
	 * BSAManage op slot cost list retrieve<br>
	 * 
     * @author 20150514.ADD
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	private EventResponse searchOpSlotCostList(Event e) throws EventException {
		log.debug("################# BSAManageSC.searchSlotCostList() ############################[START]");
		// Object including the result of user request (DB Result Set, Object, parameter and etc)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBsa0028Event event = (EsmBsa0028Event)e;
		BSAManageBC command = new BSAManageBCImpl();
		try {
			CommonBsaRsVO rsVO = command.searchOpSlotCostList(event.getSearchBsaConditionVO()); //@@@ 여기부터..
			List<CommonBsaRsVO> list = new ArrayList<CommonBsaRsVO>();
			list.add(rsVO);

			eventResponse.setRsVoList(list);			
			eventResponse.setCustomData("rtnVo", rsVO);

			log.debug("################# BSAManageSC.searchSlotCostList() ############################[END]");
			return eventResponse; 
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
	}	
	
	/**
	 * EsmBsa0028Event save event process<br>
	 * BSAManage slot cost save<br>
	 * 
     * @author 20150514.ADD
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse multiOpSlotCost(Event e) throws EventException {
	// PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = new GeneralEventResponse();
	EsmBsa0028Event event = (EsmBsa0028Event)e;
	BSAManageBC command = new BSAManageBCImpl();
	try{
		begin();
		String notChk = command.multiOpSlotCost(event.getBsaManageSltPrcSaveVOs(), account, e);
		
		log.debug("============= notChk : "+notChk);
		
		if(notChk.equals("Not")){			
			rollback();
		}
		else{
			eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
			commit();
		}		
		eventResponse.setETCData("not_chk", notChk);
//		eventResponse.setUserMessage(new ErrorHandler("BSA10047").getUserMessage());
//		commit();
	}catch(EventException ex){
		rollback();
		throw ex;
	}catch(Exception ex){ 
		throw new EventException(ex.getMessage(), ex);
	}
	return eventResponse;
	}	
}