/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : MnrAdvanceAuditSC.java
*@FileTitle : Equipment Auto Audit 
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-04-13 Jeong-Min Park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.basic.MnrAdvanceAuditBC;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.basic.MnrAdvanceAuditBCImpl;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0360Event;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0361Event;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0362Event;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0363Event;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0364Event;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0365Event;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0366Event;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0367Event;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0369Event;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.CleaningContainerBKGListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.CleaningContainerInquiryDetailVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.CleaningContainerInquiryListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MNRPreAuditCriterionVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrChargeDetailListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrChargeListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrGeneralCodeVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrMovementVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRByAreaDetailVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRByAreaListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRByPeriodDetailVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRbyPeriodListVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * TransportmanageSC PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jeong-Min Park
 * @see ServiceCommandSupport 참조
 * @since J2EE 1.4
 */
public class MnrAdvanceAuditSC extends ServiceCommandSupport {
	
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * EAS 업무 시나리오 선행작업<br>
	 * Mnradvanceaudit업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch(Exception e) {
			log.error("MnrAdvanceAudit 선행 작업 시 오류 " + e.toString(), e);
		}
	}
	
	/**
	 * EAS 업무 시나리오 마감작업<br>
	 * Mnradvanceaudit업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("MnrAdvanceAudit 종료");
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Transportmanage event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if(e.getEventName().equalsIgnoreCase("EsdEas0360Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMNRChargeList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchMNRGeneralCodeList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageMNRChargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = saveReBatchTarget(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0361Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMNRChargeDetailList(e);
			}
			
		}else if(e.getEventName().equalsIgnoreCase("EsdEas0362Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMnrPreAuditCriterionByErrorCode(e);
			} else if(e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = insertMnrPreAuditCriterionByErrorCode(e);
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = deleteMnrPreAuditCriterionByErrorCode(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = updateMnrPreAuditCriterionByErrorCode(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchMNROfficeCodeForValidation(e);
			}
			
		}else if(e.getEventName().equalsIgnoreCase("EsdEas0363Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMnrPreAuditCriterionByDifference(e);
			} else if(e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = insertMnrPreAuditCriterionByDifference(e);
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = deleteMnrPreAuditCriterionByDifference(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = updateMnrPreAuditCriterionByDifference(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchMNROfficeCodeForValidation(e);
			}
			
		}else if(e.getEventName().equalsIgnoreCase("EsdEas0364Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMultipleRepairCNTRByAreaList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMultipleRepairCNTRByAreaDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0365Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMultipleRepairCNTRByPeriodList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMultipleRepairCNTRByPeriodDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0366Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCleaningContainerInquiryList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCleaningContainerInquiryDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0367Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCleaningContainerBKGList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsdEas0369Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMovementList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMovementListMail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0360 M&R Invoice Charge
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMNRChargeList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsdEas0360Event event = (EsdEas0360Event) e;
			
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			
			//20160311 BackEndJob 제거-->
			//String status = command.searchMNRChargeList(event.getMnrInvoiceChargeINVO(), account);
			//eventResponse.setETCData("BackEndJobKey", status);
			//<--20160311 BackEndJob 제거
			List<MnrChargeListVO> list = command.searchMNRChargeList(event.getMnrInvoiceChargeINVO(), account);
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
	}
	
	/**
	 * ESD_EAS_0360 M&R Invoice Charge
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMNRChargeDetailList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0361Event event = (EsdEas0361Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			List<MnrChargeDetailListVO> list = command.searchMNRChargeDetailList(event.getMnrInvoiceChargeINVO());
			
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0360 M&R General Code List
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMNRGeneralCodeList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsdEas0360Event event = (EsdEas0360Event) e;
			
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			List<MnrGeneralCodeVO> list = command.searchMnrGeneralCode(event.getMnrInvoiceChargeINVO());

			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
	}
	
	/**
	 * ESD_EAS_0360 Confirm M&R Invoice Charge
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageMNRChargeList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsdEas0360Event event = (EsdEas0360Event) e;
			
			MnrChargeListVO[] mnrChargeListVOS = event.getMnrChargeListVOS();
			
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			command.manageMNRChargeList(mnrChargeListVOS, account);
			
			return eventResponse;
		} catch(EventException de) { 
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} 
	}
	
	/**
	 * ESD_EAS_0364 LIST searchMultipleRepairCNTRByAreaList
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMultipleRepairCNTRByAreaList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0364Event event = (EsdEas0364Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();

			String status = command.searchMultipleRepairCNTRByAreaList(event.getMnrReportINVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD_EAS_0364 DETAIL searchMultipleRepairCNTRByAreaDetail
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMultipleRepairCNTRByAreaDetail(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0364Event event = (EsdEas0364Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			List<MultipleRepairCNTRByAreaDetailVO> list = command.searchMultipleRepairCNTRByAreaDetail(event.getMnrReportINVO());
			
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD_EAS_0365 LIST searchMultipleRepairCNTRByPeriodList
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMultipleRepairCNTRByPeriodList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0365Event event = (EsdEas0365Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			
			String status = command.searchMultipleRepairCNTRByPeriodList(event.getMnrReportINVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD_EAS_0365 DETAIL searchMultipleRepairCNTRByPeriodDetail
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMultipleRepairCNTRByPeriodDetail(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0365Event event = (EsdEas0365Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			List<MultipleRepairCNTRByPeriodDetailVO> list = command.searchMultipleRepairCNTRByPeriodDetail(event.getMnrReportINVO());
			
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD_EAS_0366 LIST searchCleaningContainerInqiuryList
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCleaningContainerInquiryList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0366Event event = (EsdEas0366Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			
			String status = command.searchCleaningContainerInquiryList(event.getMnrReportINVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD_EAS_0366 DETAIL searchCleaningContainerInqiuryDetail
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCleaningContainerInquiryDetail(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0366Event event = (EsdEas0366Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			List<CleaningContainerInquiryDetailVO> list = command.searchCleaningContainerInquiryDetail(event.getMnrReportINVO());
			
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0367 LIST searchCleaningContainerBKGList
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCleaningContainerBKGList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0367Event event = (EsdEas0367Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			
			String status = command.searchCleaningContainerBKGList(event.getMnrReportINVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	

	/**
	 * ESD_EAS_0362 MNR PRE-AUDIT CRITERION BY ERROR CODE
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMnrPreAuditCriterionByErrorCode(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0362Event event = (EsdEas0362Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			List<MNRPreAuditCriterionVO> list = command.searchMnrPreAuditCriterionByErrorCode(event.getMnrPreAuditCriterionVO());
			
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD_EAS_0362 MNR PRE-AUDIT CRITERION BY ERROR CODE
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse insertMnrPreAuditCriterionByErrorCode(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0362Event event = (EsdEas0362Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			command.insertMnrPreAuditCriterionByErrorCode(event.getMnrPreAuditCriterionVO(), account);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0362 MNR PRE-AUDIT CRITERION BY ERROR CODE
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse deleteMnrPreAuditCriterionByErrorCode(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0362Event event = (EsdEas0362Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			command.deleteMnrPreAuditCriterionByErrorCode(event.getMnrPreAuditCriterionVO(), account);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0362 MNR PRE-AUDIT CRITERION BY ERROR CODE
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse updateMnrPreAuditCriterionByErrorCode(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0362Event event = (EsdEas0362Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			command.updateMnrPreAuditCriterionByErrorCode(event.getMnrPreAuditCriterionVOs(), account);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0363 MNR Pre-Audit Criterion By Difference W/O & INV AMT
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMnrPreAuditCriterionByDifference(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0363Event event = (EsdEas0363Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			List<MNRPreAuditCriterionVO> list = command.searchMnrPreAuditCriterionByDifference(event.getMnrPreAuditCriterionVO());
			
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD_EAS_0363 MNR Pre-Audit Criterion By Difference W/O & INV AMT
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse insertMnrPreAuditCriterionByDifference(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0363Event event = (EsdEas0363Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			command.insertMnrPreAuditCriterionByDifference(event.getMnrPreAuditCriterionVO(), account);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0363 MNR Pre-Audit Criterion By Difference W/O & INV AMT
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse deleteMnrPreAuditCriterionByDifference(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0363Event event = (EsdEas0363Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			command.deleteMnrPreAuditCriterionByDifference(event.getMnrPreAuditCriterionVO(), account);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0363 MNR Pre-Audit Criterion By Difference W/O & INV AMT
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse updateMnrPreAuditCriterionByDifference(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0363Event event = (EsdEas0363Event) e;
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			command.updateMnrPreAuditCriterionByDifference(event.getMnrPreAuditCriterionVOs(), account);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0363 MNR Pre-Audit Criterion By Difference W/O & INV AMT
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMNROfficeCodeForValidation(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0362Event event = (EsdEas0362Event) e;
		String[] string = new String[5];
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			string = command.searchMNROfficeCodeForValidation(event.getMnrPreAuditCriterionVO(), account);
			
			eventResponse.setETCData("EAS_0362_AVAILABILITY", string[0]);
			eventResponse.setETCData("EAS_0362_VALIDATION", string[1]);
			eventResponse.setETCData("EAS_0363_AVAILABILITY", string[2]);
			eventResponse.setETCData("EAS_0363_VALIDATION", string[3]);
			eventResponse.setETCData("EAS_0362_0363_RHQ_CHECK", string[4]);

			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 *ESD_EAS_0364, ESD_EAS_0365, ESD_EAS_0366 : BackEndJob<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			String key = (String)e.getAttribute("KEY");

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESD_EAS_0364, ESD_EAS_0365, ESD_EAS_0366 : BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String key = (String)e.getAttribute("KEY");
		List list = new ArrayList();

		try {
			if(e.getEventName().equalsIgnoreCase("EsdEas0360Event")){
				list = (List<MnrChargeListVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EsdEas0364Event")) {
				list = (List<MultipleRepairCNTRByAreaListVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EsdEas0365Event")) {
				list = (List<MultipleRepairCNTRbyPeriodListVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EsdEas0366Event")) {
				list = (List<CleaningContainerInquiryListVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EsdEas0367Event")) {
				list = (List<CleaningContainerBKGListVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EsdEas0369Event")) {
				list = (List<MnrMovementVO>)BackEndJobResult.loadFromFile(key);
			}

			eventResponse.setRsVoList(list);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EsdEas0360Event  <br>
	 * 실시간 배치 대상을 저장한다.
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse saveReBatchTarget(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0360Event event = (EsdEas0360Event) e;
		
		MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
		
		try{
			begin();
			MnrChargeListVO[] voList = event.getMnrChargeListVOS();
			for(int i=0;i<voList.length;i++){
				voList[i].setCreUsrId(account.getUsr_id());
				voList[i].setUpdUsrId(account.getUsr_id());
				voList[i].setCreOfcCd(account.getOfc_cd());
			}
			command.saveReBatchTarget(voList);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"saveReBatchTarget"}).getMessage(), ex);
		}
		
	}
	/**
	 * EsdEas0369Event Futile Trip Container 조회.
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMovementList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0369Event event = (EsdEas0369Event) e;
		
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			
			String status = command.searchMovementList(event.getMnrMovementVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage()); 
		}
	}
	
	/**
	 * EsdEas0369Event Futile Trip Container 조회.
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMovementListMail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0369Event event = (EsdEas0369Event) e;
		
		try {
			MnrAdvanceAuditBC command = new MnrAdvanceAuditBCImpl();
			
			String status = command.searchMovementListMail(event.getMnrMovementVO(), account);
			eventResponse.setETCData("BatchStatus", status);
			
			return eventResponse;
		} catch(EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
}


