/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtSC.java
*@FileTitle : Stevedore Damage Part Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.12 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt;

import java.util.List;

import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic.OperationNPerformMasterDataMgtBC;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic.OperationNPerformMasterDataMgtBCImpl;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0034Event;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0035Event;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0048Event;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0049Event;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0050Event;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0067Event;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0068Event;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0075Event;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event.VopOpf0087Event;
import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration.OperationNPerformMasterDataMgtDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.OpfCodRjctCdVO;
import com.hanjin.syscommon.common.table.OpfRstwgRsnCdVO;
import com.hanjin.syscommon.common.table.OpfStvDmgCdVO;
import com.hanjin.syscommon.common.table.OpfTmlProdRptRsnCdVO;


/**
 * NIS2010-OperationNPerformMasterDataMgt Business Logic ServiceCommand - NIS2010-OperationNPerformMasterDataMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Ji Seok Woo
 * @see OperationNPerformMasterDataMgtDBDAO
 * @since J2EE 1.4
 */

public class OperationNPerformMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * OperationNPerformMasterDataMgt system 업무 시나리오 선행작업<br>
	 * vop_opf_0048업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * OperationNPerformMasterDataMgt system 업무 시나리오 마감작업<br>
	 * vop_opf_0048 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("OperationNPerformMasterDataMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-OperationNPerformMasterDataMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopOpf0048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStevedoreDamagePartCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStevedoreDamagePartCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStevedoreDamagePartCodeInquiryList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStevedoreDamageReasonCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageStevedoreDamageReasonCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0087Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExcludeTPRReasonCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageExcludeTPRReasonCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0075Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRestowReasonCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = mamageRestowReasonCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCODRejectReasonCodeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCODRejectReasonCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCODRejectReasonCodeInquiryList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPRTargetLaneList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTPRTargetLaneList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopOpf0068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPRTargetPortList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTPRTargetPort(e);
			}
		}
		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Retrieve <br>
	 * StevedoreDamagePartCodeList을 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStevedoreDamagePartCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0048Event event = (VopOpf0048Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
            OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfStvDmgCdVO> list = command.searchStevedoreDamagePartCodeList(event.getOpfStvDmgCdVO());
 
    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Stevedore Damage Retrieve"}).getMessage(), ex);
        }
		return eventResponse;
	}  
	/**
	 * VOP_OPF_0075 : Retrieve <br>
	 * StevedoreDamagePartCodeInquiryList을 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStevedoreDamagePartCodeInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0050Event event = (VopOpf0050Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
    		List<OpfStvDmgCdVO> list = command.searchStevedoreDamagePartCodeList(event.getOpfStvDmgCdVO());

    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Stevedore Damage Part Code Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}	
	/**
	 * VOP_OPF_0075 : Retrieve <br>
	 * StevedoreDamageReasonCodeList을 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStevedoreDamageReasonCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0049Event event = (VopOpf0049Event)e;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfStvDmgCdVO> list = command.searchStevedoreDamageReasonCodeList(event.getOpfStvDmgCdVO());

    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Stevedore Damage Reason Code Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Retrieve <br>
	 * ExcludeTPRReasonCodeList을 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExcludeTPRReasonCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0087Event event = (VopOpf0087Event)e;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfTmlProdRptRsnCdVO> list = command.searchExcludeTPRReasonCodeList(event.getOpfTmlProdRptRsnCdVO());

    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Exclude TPRReason Code Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Save <br>
	 * StevedoreDamagePartCode을 저장합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageStevedoreDamagePartCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0048Event event = (VopOpf0048Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageStevedoreDamagePartCode(event.getOpfStvDmgCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Stevedore Damage Part"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Save <br>
	 * StevedoreDamageReasonCode을 저장합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageStevedoreDamageReasonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0049Event event = (VopOpf0049Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageStevedoreDamageReasonCode(event.getOpfStvDmgCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Stevedore Damage Reason"}).getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Save <br>
	 * ExcludeTPRReasonCode을 저장합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExcludeTPRReasonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0087Event event = (VopOpf0087Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageExcludeTPRReasonCode(event.getOpfTmlProdRptRsnCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Exclude TPR Reason"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	// VOP_OPF_0075 Start ==========================================================//
	/**
	 * VOP_OPF_0075 : Retrieve <br>
	 * Restow Reason Code을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRestowReasonCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0075Event event = (VopOpf0075Event)e;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfRstwgRsnCdVO> list = command.searchRestowReasonCodeList(event.getOpfRstwgRsnCdVO());
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Restow Reason Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	/**
	 * VOP_OPF_0075 : Save <br>
	 * Restow Reason Code을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse mamageRestowReasonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0075Event event = (VopOpf0075Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.mamageRestowReasonCode(event.getOpfRstwgRsnCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Restow Reason Code"}).getMessage(), ex);
        }
		return eventResponse;
	}
	// VOP_OPF_0075 End ============================================================//
	
	// VOP_OPF_0034 Start ==========================================================//
	/**
	 * VOP_OPF_0034 : Retrieve <br>
	 * COD Reject Reason Code을 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODRejectReasonCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0034Event event = (VopOpf0034Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfCodRjctCdVO> list = command.searchCODRejectReasonCodeList(event.getOpfCodRjctCdVO());

    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Reject Reason Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	/**
	 * VOP_OPF_0034 : Save <br>
	 * COD Reject Reason Code을 저장 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCODRejectReasonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0034Event event = (VopOpf0034Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageCODRejectReasonCode(event.getOpfCodRjctCdVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Reject Reason Code"}).getMessage(), ex);
        }
		return eventResponse;
	}
	// VOP_OPF_0034 End ============================================================//

	// VOP_OPF_0035 Start ============================================================//
	/**
	 * VOP_OPF_0035 : Retreive <br>
	 * COD Reject Reason Code 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODRejectReasonCodeInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0035Event event = (VopOpf0035Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
    		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
    		List<OpfCodRjctCdVO> list = command.searchCODRejectReasonCodeList(event.getOpfCodRjctCdVO());
    
    		eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"COD Reject Reason Code Retrieve"}).getMessage(), ex);
        }

		return eventResponse;
	}
	// VOP_OPF_0035 End ============================================================//
	
	// VOP_OPF_0067 Start ==========================================================//
	/**
	 * VOP_OPF_0067 : TPR Target Lane Creation <br>
	 * TPR Target Lane Creation 을 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPRTargetLaneList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0067Event event = (VopOpf0067Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			List<MdmVslSvcLaneVO> list = command.searchTPRTargetLaneList(event.getMdmVslSvcLaneVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"TPR Target Lane Creation"}).getMessage(), ex);
		}
		
		return eventResponse;
	}
	/**
	 * 멀티 이벤트 처리<br>
	 * VOP_OPF_0067 : TPR Target Lane Creation <br>
	 * TPR Target Lane Creation 을 저장 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTPRTargetLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0067Event event = (VopOpf0067Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageTPRTargetLaneList(event.getMdmVslSvcLaneVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
        } catch (EventException ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TPR Target Lane Creation"}).getMessage(), ex);
        }
		return eventResponse;
	}

	// VOP_OPF_0067 End ============================================================//	
	// VOP_OPF_0068 Start ==========================================================//
	/**
	 * VOP_OPF_0068 : 1.Retrieve 2.PortCode_OnChange<br>
	 * 1. TPR 제외한 모든 Port를 조회 합니다. <br>
	 * 2. TPR 해당하는 Port를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPRTargetPortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopOpf0068Event event = (VopOpf0068Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<MdmLocationVO> list = command.searchAllPortList(event.getMdmLocationVO());
			List<MdmLocationVO> list2 = command.searchTPRTargetPortList(event.getMdmLocationVO());

			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("COM12203", new String[]{"TPR Target Lane Creation"}).getMessage(), ex);
		}
		
		
		return eventResponse;
	}
	
	/**
	 * VOP_OPF_0068 : Save  <br>
	 * TPR Target Port Creation 을 저장 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTPRTargetPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopOpf0068Event event = (VopOpf0068Event)e;
		OperationNPerformMasterDataMgtBC command = new OperationNPerformMasterDataMgtBCImpl();
		try{
			begin();
			command.manageTPRTargetPort(event.getMdmLocationVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("OPF50006", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Terminal Departure Report Header"}).getMessage(), ex);
		}
		return eventResponse;
	}
	// VOP_OPF_0068 End ============================================================//	
}