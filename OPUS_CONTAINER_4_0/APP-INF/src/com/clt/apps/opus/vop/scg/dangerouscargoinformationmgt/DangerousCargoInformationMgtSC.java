/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DangerousCargoInformationMgtSC.java
*@FileTitle : UN Number
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt;

import java.util.List;

import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBC;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBCImpl;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0001Event;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0002Event;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0003Event;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0072Event;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg100301Event;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg100302Event;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration.IMDGCodeMgtDBDAO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgClssSegrListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgCompGrpSegrListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgUnNoSegrListVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationOutputVO;
import com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.common.ScgUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ScgImdgExptQtyVO;
import com.clt.syscommon.common.table.ScgImdgSegrGrpVO;
import com.clt.syscommon.common.table.ScgImdgSegrSymVO;


/**
 * OPUS-DangerousCargoInformationMgt Business Logic ServiceCommand - Handling business transactions of OPUS-DangerousCargoInformationMgt.
 * 
 * @author
 * @see IMDGCodeMgtDBDAO
 * @since J2EE 1.4
 */

public class DangerousCargoInformationMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DangerousCargoInformationMgt system preceding process for biz scenario<br>
	 * VOP_SCG-0001 related objects creation<br>
	 */
	public void doStart() {
		try {
			// comment --> login check
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DangerousCargoInformationMgt system biz scenario closing<br>
	 * VOP_SCG-0001 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("DangerousCargoInformationMgtSC end");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// When SC handles multiple events
		if (e.getEventName().equalsIgnoreCase("VopScg0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUNNumberList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisplayCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAutoCreation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUNNumber(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUNNumberInqList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSegregationList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSegregation(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSegregationListInquiry(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg100301Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSymbolList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg100302Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPermitMixedList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopScg0072Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = checkSegregation(e);
			}
		}
		return eventResponse;
	}

	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * Detail of UN Number retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUNNumberList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopScg0001Event event = (VopScg0001Event)e;
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<UNNumberListOptionVO>  list1 = command.searchUNNumberList(event.getUNNumberListOptionVO());
			List<ScgImdgUnNoSegrListVO> list2 = command.searchSegrList(event.getUNNumberListOptionVO());
			String[] subRskLblList 	= command.searchSubsRskLblList(event.getUNNumberListOptionVO());
			String[] spclProviList 	= command.searchSpclProviList(event.getUNNumberListOptionVO());
			String[] segrGrpDtlList = command.searchSegrGrpDtlList(event.getUNNumberListOptionVO());
			String[] segrGrpList 	= command.searchSegrGrpList(event.getUNNumberListOptionVO());
			String[] clssCdList 	= command.searchClssCdList(event.getUNNumberListOptionVO());
	
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
	        eventResponse.setETCData("subRskLblList", ScgUtil.addSpChar(subRskLblList));
	        eventResponse.setETCData("spclProviList", ScgUtil.addSpChar(spclProviList));
	        eventResponse.setETCData("segrGrpDtlList", ScgUtil.addSpChar(segrGrpDtlList));
	        eventResponse.setETCData("segrGrpList", ScgUtil.addSpChar(segrGrpList));
	        eventResponse.setETCData("clssCdList", ScgUtil.addSpChar(clssCdList));
	        if(list1.size() < 1){
				eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());        	
	        }
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"UN Number"}).getMessage(), ex);
		}		
        
		return eventResponse;
	}

	/**
	 * VOP_SCG_0001 : OnLoad <br>
	 * Excepted Q'ty, Away from SG/Separated from SG retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisplayCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//VopScg0001Event event = (VopScg0001Event)e;
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgExptQtyVO> list1 = command.searchExceptedQtyList();
			List<ScgImdgSegrGrpVO> list2 = command.searchSegregationGroupList();
			
			ScgImdgSegrGrpVO scgImdgSegrGrpVO = new ScgImdgSegrGrpVO();
			
			scgImdgSegrGrpVO.setImdgSegrGrpNm("NONE");
			scgImdgSegrGrpVO.setImdgSegrGrpNo("0");
			list2.add(0,scgImdgSegrGrpVO);
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Excepted Q'ty, Away from SG/Separated from SG"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0001 : AutoCreation <br>
	 * Segregation Auto Creation retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAutoCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopScg0001Event event = (VopScg0001Event)e;
		String clssCd = "";
    	if (event.getAutoCreationVO().getFrmSegrAsForImdgClssCd() != "") {
    		clssCd = event.getAutoCreationVO().getFrmSegrAsForImdgClssCd();
    	}else{
    		clssCd = event.getAutoCreationVO().getFrmImdgClssCd();
    	}

		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgUnNoSegrListVO> list = command.searchAutoCreation(event.getAutoCreationVO());
			eventResponse.setRsVoList(list);
	        if(list.get(0).getClssCd14().equals("") && !("N").equals(event.getAutoCreationVO().getMsgFlg())){
				eventResponse.setUserMessage(new ErrorHandler("SCG00002", new String[]{clssCd}).getUserMessage());        	
	        }
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Segregation Auto Creation"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0001 : Save <br>
	 * UN Number create/modify <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUNNumber(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0001Event event = (VopScg0001Event)e;
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		try{
			begin();
			command.manageUNNumber(event.getUNNumberGrpVO(),account);

			UNNumberListOptionVO[] unNumberListOptionVO  = event.getUNNumberGrpVO().getUNNumberListOptionVOs();
			if (unNumberListOptionVO[0].getIbflag().equals("D")) {
				eventResponse.setUserMessage(new ErrorHandler("SCG00006", new String[]{"Data"}).getUserMessage());				
			}else{
				eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Data"}).getUserMessage());
			}
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"UN Number"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_SCG_0002 : Retrieve <br>
	 * List of UN Number retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUNNumberInqList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopScg0002Event event = (VopScg0002Event)e;
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<UNNumberListOptionVO>  list = command.searchUNNumberList(event.getUNNumberListOptionVO());	
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"UN Number"}).getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * VOP_SCG_0003 : Retrieve <br>
	 * Segregation Table List retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSegregationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//VopScg0003Event event = (VopScg0003Event)e;
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgClssSegrListVO>  	list1 = command.searchSegregationClssList();
			List<ScgImdgCompGrpSegrListVO> 	list2 = command.searchSegregationCompList();
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Segregation Table"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_SCG_0003 : Save <br>
	 * Segregation Table modify <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSegregation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0003Event event = (VopScg0003Event)e;
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		try{
			begin();
			command.manageSegregation(event.getSegregationTableGrpVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("SCG00001", new String[]{"Segregation Table"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Segregation Table"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_SCG_0004 : Retrieve <br>
	 * Segregation Table retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSegregationListInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//VopScg0004Event event = (VopScg0004Event)e;
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgClssSegrListVO>  	list1 = command.searchSegregationClssList();
			List<ScgImdgCompGrpSegrListVO> 	list2 = command.searchSegregationCompList();
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Segregation Table"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_SCG_1003-01 : Retrieve <br>
	 * Numbers & symbols in segregation table between various Classes retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSymbolList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopScg100301Event event = (VopScg100301Event)e;
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgSegrSymVO>  list = command.searchSymbolList(event.getScgImdgSegrSymVO().getImdgSegrTpCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Numbers & symbols in segregation table between various Classes"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_SCG_1003-02 : Retrieve <br>
	 * Permitted mixed stowage for goods of class 1 retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPermitMixedList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopScg100302Event event = (VopScg100302Event)e;
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ScgImdgSegrSymVO>  list = command.searchPermitMixedList(event.getScgImdgSegrSymVO().getImdgSegrTpCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Permitted mixed stowage for goods of class 1"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_SCG_0072 : Retrieve <br>
	 * Segregation Simulation in a CNTR retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSegregation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopScg0072Event event = (VopScg0072Event)e;
		IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SegregationSimulationOutputVO>  list = command.checkSegregation(event.getSegregationSimulationInputVOS());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"Segregation Simulation in a CNTR"}).getMessage(), ex);
		}
		return eventResponse;
	}

}