/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DangerousCargoInformationMgtSC.java
*@FileTitle : UN Number
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.18 이도형
* 1.0 Creation
*=========================================================
*History
* 2013.06.04 김현화 [CHM-201324585]DG Packing Instruction 기능 적용. 
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt;

import java.util.List;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBCImpl;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBC;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.basic.IMDGCodeMgtBCImpl;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0001Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0002Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0003Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0072Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg100301Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg100302Event;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration.IMDGCodeMgtDBDAO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgClssSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgCompGrpSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgUnNoSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationSimulationOutputVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.common.ScgUtil;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0110Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ScgImdgExptQtyVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrSymVO;
import com.hanjin.syscommon.common.table.ScgImdgPckCdVO;


/**
 * ALPS-DangerousCargoInformationMgt Business Logic ServiceCommand - ALPS-DangerousCargoInformationMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Dohyoung Lee
 * @see IMDGCodeMgtDBDAO
 * @since J2EE 1.4
 */

public class DangerousCargoInformationMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DangerousCargoInformationMgt system 업무 시나리오 선행작업<br>
	 * VOP_SCG-0001업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DangerousCargoInformationMgt system 업무 시나리오 마감작업<br>
	 * VOP_SCG-0001 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DangerousCargoInformationMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DangerousCargoInformationMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
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
		}else if (e.getEventName().equalsIgnoreCase("VopScg0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01) || e.getFormCommand().isCommand(FormCommand.SEARCH02) || e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkRestrictionSimulation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchImdgPckDesc(e);
			}
		}
		return eventResponse;
	}

	/**
	 * VOP_SCG_0001 : Retrieve <br>
	 * UN Number 의 Detail을 조회 합니다. <br>
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
	 * Excepted Q'ty, Away from SG/Separated from SG 을 조회 합니다. <br>
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
	 * Segregation Auto Creation 을 조회 합니다. <br>
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
	 * UN Number을 생성/수정 합니다. <br>
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
	 * UN Number 의 List를 조회 합니다. <br>
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
	 * Segregation Table의 List를 조회 합니다. <br>
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
	 * Segregation Table의 내용을 수정 합니다. <br>
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
	 * Segregation Table의 내용을 조회 합니다. <br>
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
	 * Numbers & symbols in segregation table between various Classes의 내용을 조회 합니다. <br>
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
	 * Permitted mixed stowage for goods of class 1의 내용을 조회 합니다. <br>
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
	 * Segregation Simulation in a CNTR 을 조회 합니다. <br>
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
	
	/**
	 * VOP_SCG_0110 :  <br>
	 * Packing Instruction Simulation 에서 validation 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRestrictionSimulation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopScg0110Event event = (VopScg0110Event)e;
		PartnerLinesDangerousCargoApprovalBC command = new PartnerLinesDangerousCargoApprovalBCImpl();
		PreRestrictionInputVO containerVO = new PreRestrictionInputVO();

		try{
			containerVO.setInnerPreRestrictionInputVO(event.getPreRestrictionInputVO());
			containerVO.setInnerPreRestrictionInputVOS(event.getPreRestrictionInputVOS());
			PreRestrictionOutputVO preRestrictionOutputVO = command.checkPreRestriction(containerVO);
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionSegregationVOs());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionPortVOs());
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionVesselOperatorVOs());
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionRegulatoryVOs());
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionInvalidReasonDetailVOs());
				eventResponse.setRsVoList(preRestrictionOutputVO.getPreRestrictionSppDetailVOs());
			}

		}catch(EventException ex){
			//throw ex;
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instruction Simulation"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Packing Instruction Simulation"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * (VOP_SCG_0110) imdgPckCd, imdgPckTpCd info retrieve	 *
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchImdgPckDesc(Event e) throws EventException {
		try{
			VopScg0110Event event = (VopScg0110Event)e;
			IMDGCodeMgtBC command = new IMDGCodeMgtBCImpl();

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			ScgImdgPckCdVO imdgPckDescVO = command.searchImdgPckDesc(event.getImdgPckCd(), event.getImdgPckTpCd());

			if(imdgPckDescVO != null){
				eventResponse.setETCData(imdgPckDescVO.getColumnValues());
			}else{
				
				eventResponse.setETCData("imdg_pck_desc","");				
				eventResponse.setUserMessage(new ErrorHandler("BKG00010").getUserMessage());
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}	

}