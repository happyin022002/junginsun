/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DwellNotificationManageSC.java
*@FileTitle : DwellNotification 을 수행하는  class 를 구동한다.
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.04
*@LastModifier : 조풍연
*@LastVersion : 1.0
* 2011.07.04 조풍연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC;
import com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl;
import com.hanjin.apps.alps.esd.sce.dwellnotification.basic.DwellNotificationBC;
import com.hanjin.apps.alps.esd.sce.dwellnotification.basic.DwellNotificationBCImpl;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0140Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0146Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0150Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0151Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0152Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0154Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0155Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0157Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0160Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0163Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0164Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0165Event;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DewllNotifiySetupExpContainerVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellNofifySendStsVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellNotifyLMTDateVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwellRnsVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwllNtfcSrchVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchMSExptSaveVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchOneTimeSndHistVO;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBC;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0035Event;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-DwellNotificationManage Business Logic ServiceCommand - ALPS-DwellNotificationManag 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim In-soo
 * @see DwellNotificationManageDAO
 * @since J2EE 1.6
 */

public class DwellNotificationSC extends ServiceCommandSupport {
	// Login User Information

	private SignOnUserAccount account = null;

	/**
	 * DwellNotificationManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("DwellNotificationManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DwellNotificationManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DwellNotificationManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DwellNotificationManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdSce0140Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchComCode0140(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDwellList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDwellTotalCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDwellResonByVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDwellEmailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRvisCntrCustTpCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = updateDwellResonByVVD(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0146Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMSExptList(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyMSExptList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = modifyMSExptList(e);
				eventResponse = updateMSExptList(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0151Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				   eventResponse = searchComCode0154(e);
			   }else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchDwllNtfcExptList(e);
		       }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				   eventResponse = addDwllNtfcExpt(e);
		       }else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
		    	   eventResponse = checkCustCd(e);
		       }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
		    	   eventResponse = searchDwllNtfcExptItem(e);
		       }
		}
			   
		if (e.getEventName().equalsIgnoreCase("EsdSce0154Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				   eventResponse = searchComCode0154(e);
			   }else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchDwllNtfcSvcList(e);
		       }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				   eventResponse = searchDwllNtfcSvcItem(e);
		       }
		       else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				   eventResponse = addDwllNtfcExptForSvc(e);
		       }
			   
			   
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0155Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchDwllNtfcSvcPopUpList(e);
		       }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				   eventResponse = manageDwllNtfcSvcList(e);
		       }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				   eventResponse = modifyDwllNtfcSvcListDtl(e);
		       }
			   
			   
		}
		
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0150Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				   eventResponse = searchComCode0140(e);
			   }else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchDwellNofifySendSts(e);
		       }
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0152Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchDwellNofifySendStsDtl(e);
		       }else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
		    	   eventResponse = searchScNoInfo(e);
		       }
		}	
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0157Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchDwllNtfcExptCntList(e);
		       }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				   eventResponse = addDwllNtfcExptCnt(e);
		       }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				   eventResponse = searchDwllNtfcExptCntMastBkg(e);
		       }
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0160Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchComCode0140(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDwellCandidateTotalCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDwellCandidateList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDwellRsn(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageDwellRsn(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0163Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchCandidateDwllNtfcSvcPopUpList(e);
		       }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				   eventResponse = manageCandidateDwllNtfcSvcList(e);
		       }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				   eventResponse = modifyDwllNtfcSvcListDtl(e);
		       }
		}
		if (e.getEventName().equalsIgnoreCase("EsdSce0164Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyDwllEmailSendOptin(e);
			} 
		}
		if (e.getEventName().equalsIgnoreCase("EsdSce0165Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOneTimeSndHistList(e);
			} 
		}
		return eventResponse;
	}
	
	/**
	 * Dwell Type별 List를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDwellList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        EsdSce0140Event event = (EsdSce0140Event)e;
        DwellNotificationBC command = new DwellNotificationBCImpl();
        try{
        	eventResponse = command.searchDwellList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * DWELL REASON 의 입력 내역을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDwellResonByVVD(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        EsdSce0140Event event = (EsdSce0140Event)e;
        DwellNotificationBC command = new DwellNotificationBCImpl();
        try{
        	eventResponse = command.searchDwellResonByVVD(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * DWELL Emailing list를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDwellEmailList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        EsdSce0140Event event = (EsdSce0140Event)e;
        DwellNotificationBC command = new DwellNotificationBCImpl();
        try{
        	eventResponse = command.searchDwellEmailList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * DWELL REASON 의 입력 내역을 수정합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateDwellResonByVVD(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        EsdSce0140Event event = (EsdSce0140Event)e;
        DwellNotificationBC command = new DwellNotificationBCImpl();
        try{
        	begin();
        	eventResponse = command.updateDwellResonByVVD(event);
        	commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * UI_ESD_SCE_0140 조회화면의 SC COMBO 값 조회(공통 CODE 조회)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0140(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CodeUtilBC command = new CodeUtilBCImpl();
		String result = null;
		try{
			result = command.searchScPrefixList();
			eventResponse.setETCData("sc_no", result);
			DwellNotificationBC dwCommand = new DwellNotificationBCImpl();
			DwellNotifyLMTDateVO lmtDate = dwCommand.searchDwellNotifyLMTDate();
			eventResponse.setETCData("dflt_eml_snd_dt", lmtDate.getDfltEmlSndDt());
			eventResponse.setETCData("dflt_fm_snd_dt", lmtDate.getDfltFmSndDt());
			eventResponse.setETCData("dflt_to_snd_dt", lmtDate.getDfltToSndDt());

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * UI_ESD_SCE_0140 조회화면의 Tab별 Total Count 값 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDwellTotalCnt(Event e) throws EventException {
		EventResponse eventResponse = null;
        EsdSce0140Event event = (EsdSce0140Event)e;
        DwellNotificationBC command = new DwellNotificationBCImpl();
        try{
        	eventResponse = command.searchDwellTotalCnt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * UI_ESD_SCE_0146 조회화면의 Dwell Exception 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMSExptList(Event e) throws EventException {
		EventResponse eventResponse = null;
        EsdSce0146Event event = (EsdSce0146Event)e;
        DwellNotificationBC command = new DwellNotificationBCImpl();
        try{
        	eventResponse = command.searchMSExptList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * UI_ESD_SCE_0146 조회화면의 Dwell Exception 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMSExptList(Event e) throws EventException {
		EventResponse eventResponse = null;
        EsdSce0146Event event = (EsdSce0146Event)e;
        DwellNotificationBC command = new DwellNotificationBCImpl();
		try {
			begin();
			command.modifyMSExptList(event, account.getUsr_id());
	        commit();
	        eventResponse = searchMSExptList(e);
		}catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * UI_ESD_SCE_0146 조회화면의 체크 값 315 EDI 전송<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMSExptList(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdSce0146Event event = (EsdSce0146Event) e;
		List<Edi315SendVO> edi315SendVOs = null;

		edi315SendVOs = event.getEdi315SendVOs();
		if (edi315SendVOs != null && edi315SendVOs.size() > 0) {
			log.debug("vos size : " + edi315SendVOs.size());
			/* Cre ID 및 Upd ID 를 세팅하는 부분 */
			for (int n = 0; n < edi315SendVOs.size(); n++) {
				edi315SendVOs.get(n).setCreId(account.getUsr_id());
				edi315SendVOs.get(n).setUpdId(account.getUsr_id());
			}// for
		}// if

		try {
			sendEdi315(edi315SendVOs);
			eventResponse = searchMSExptList(e);
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * Edi Document Send
	 * 
	 * @param List<Edi315SendVO> edi315SendVOs
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse sendEdi315(List<Edi315SendVO> edi315SendVOs)
			throws EventException {
		Edi315SendBC command = new Edi315SendBCImpl();
//		EventResponse eventResponse = null;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			if (edi315SendVOs != null && edi315SendVOs.size() > 0) {
				int len = edi315SendVOs.size();
				String[] result_str = new String[len];
				for (int m = 0; m < len; m++) {
					begin();
					result_str[m] = command
							.edi315Send((Edi315SendVO) edi315SendVOs.get(m));
					commit();
				}// for
			}// if

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	  * UI_ESD_SCE_0154 조회화면의 SC COMBO 값 조회(공통 CODE 조회)<br>
	  *
	  * @param Event e
	  * @return EventResponse
	  * @exception EventException
	  */
	 private EventResponse searchComCode0154(Event e) throws EventException {
	  GeneralEventResponse eventResponse = new GeneralEventResponse();
	  CodeUtilBC command = new CodeUtilBCImpl();
	  String result = null;
	  try{
	   result = command.searchScPrefixList();
	   eventResponse.setETCData("sc_no", result);
	  } catch (EventException de) {
	   log.error("err " + de.toString(), de);
	   throw new EventException(de.getMessage());
	  }
	  return eventResponse;
	 }

	 /**
	     * Email List 조회
	     *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
	     */
	private EventResponse searchDwllNtfcSvcList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0154Event event   = (EsdSce0154Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
		CodeUtilBC utilcommand = new CodeUtilBCImpl();
			try {
				List scpfxArr = utilcommand.replaceStrToList(event.getDwllNtfcSrchVO().getScpfxcd());
				event.getDwllNtfcSrchVO().setScpfxcdlist(scpfxArr);
				List<DwllNtfcSrchVO>  list = command.searchDwllNtfcSvcList(event);
				eventResponse.setRsVoList(list); 
			

			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
	
	 /**
    * Email List 조회(단건, Row Add일 경우)
    *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
    */
	private EventResponse searchDwllNtfcSvcItem(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0154Event event   = (EsdSce0154Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
		DwllNtfcSrchVO conditionVO = event.getDwllNtfcSrchVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
			try {
				DwllNtfcSrchVO  list = command.searchDwllNtfcSvcItem(event.getDwllNtfcSrchVO());
				returnVOList.add(conditionVO);
				returnVOList.add(list);
				eventResponse.setRsVoList(returnVOList); 
			} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Dwell Notification Exception List 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addDwllNtfcExptForSvc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0154Event event   = (EsdSce0154Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
	
		try {
			begin();
			command.addDwllNtfcExptForSvc(event ,account.getUsr_id(), account.getOfc_cd());
	        commit();

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
   }
	
	 /**
     * PopUp 화면 Email List 조회
     *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
	private EventResponse searchDwllNtfcSvcPopUpList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0155Event event   = (EsdSce0155Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
			try {
				List<DwllNtfcSrchVO>  list = command.searchDwllNtfcSvcPopUpList(event.getDwllNtfcSrchVO());
				eventResponse.setRsVoList(list); 

			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}

	/**
	 * Email List 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDwllNtfcSvcList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0155Event event   = (EsdSce0155Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
		try {
			begin();
			command.manageDwllNtfcSvcList(event ,account.getUsr_id(), account.getOfc_cd());
	        commit();

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
   }

	/**
	 * Email Detail List 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDwllNtfcSvcListDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0155Event event   = (EsdSce0155Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
		try {
			begin();
			command.modifyDwllNtfcSvcListDtl(event ,account.getUsr_id());
	        commit();

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
   }
	 /**
     * E-mail Sending Exception List 조회
     *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
	private EventResponse searchDwllNtfcExptList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0151Event event   = (EsdSce0151Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
		CodeUtilBC utilcommand = new CodeUtilBCImpl();
			try {
				List scpfxArr = utilcommand.replaceStrToList(event.getDwllNtfcSrchVO().getScpfxcd());
				event.getDwllNtfcSrchVO().setScpfxcdlist(scpfxArr);
				event.getDwllNtfcSrchVO().setOfcCd(account.getOfc_cd());
				List<DwllNtfcSrchVO>  list = command.searchDwllNtfcExptList(event.getDwllNtfcSrchVO());
				eventResponse.setRsVoList(list); 
		
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}

	/**
	 * E-mail Sending Exception List 저장을 한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addDwllNtfcExpt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0151Event event   = (EsdSce0151Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
		try {
			begin();
			command.addDwllNtfcExpt(event ,account.getUsr_id(), account.getOfc_cd());
			commit();

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Dwell Type별 E-Mail로 발송된 CNTR 개수를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDwellNofifySendSts(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0150Event event = (EsdSce0150Event)e;
        DwellNotificationBC command = new DwellNotificationBCImpl();
        CodeUtilBC utilcommand = new CodeUtilBCImpl();
        
        try{

        	List<String> scpfxArr = utilcommand.replaceStrToList(event.getScNo());
        	
        	event.setScpfxArr(scpfxArr); 
        	
        	List<DwellNofifySendStsVO> list  = command.searchDwellNofifySendSts(event);
        	eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Dwell Type별 E-Mail로 발송된 CNTR 개수를 Customer Code별로 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDwellNofifySendStsDtl(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0152Event event = (EsdSce0152Event)e;
        DwellNotificationBC command = new DwellNotificationBCImpl();
           
        try{        	
        	List<DwellNofifySendStsVO> list  = command.searchDwellNofifySendStsDtl(event);
        	eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 해당 SC No를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScNoInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0152Event event = (EsdSce0152Event)e;
        DwellNotificationBC command = new DwellNotificationBCImpl();
        String sc_no = null;
        try{
        	sc_no = command.searchScNoInfo(event.getCustCd());
        	eventResponse.setETCData("sc_no", sc_no);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	 /**
     * Set up for Exception by Container List 조회
     *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
	private EventResponse searchDwllNtfcExptCntList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0157Event event   = (EsdSce0157Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
			try {
				List<DewllNotifiySetupExpContainerVO>  list = command.searchDwllNtfcExptCntList(event.getDewllNotifiySetupExpContainerVO());
				eventResponse.setRsVoList(list); 
		
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}

	/**
	 * E-mail Sending Exception List 저장을 한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addDwllNtfcExptCnt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0157Event event   = (EsdSce0157Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
		try {
			begin();
			command.addDwllNtfcExptCnt(event ,account.getUsr_id(),account.getOfc_cd());
			commit();

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	 /**
	    * Master bkg 조회(상단리스트 조회) &&&
	    *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
	    */
		private EventResponse searchDwllNtfcExptCntMastBkg(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			EsdSce0157Event event   = (EsdSce0157Event) e;
			DwellNotificationBC command = new DwellNotificationBCImpl();
			//DewllNotifiySetupExpContainerVO conditionVO = event.getDwllNtfcSrchVO();
			List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
				try {
					DewllNotifiySetupExpContainerVO  list = command.searchDwllNtfcExptCntMastBkg(event.getDewllNotifiySetupExpContainerVO());
					returnVOList.add(list);
					eventResponse.setRsVoList(returnVOList); 
				} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		/**
		 * Candidate Inquiry by Dwell Type별 List를 조회합니다.<br>
		 *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchDwellCandidateList(Event e) throws EventException {
	        // PDTO(Data Transfer Object including Parameters)
	        EventResponse eventResponse = null;
	        EsdSce0160Event event = (EsdSce0160Event)e;
	        DwellNotificationBC command = new DwellNotificationBCImpl();
	        try{
	        	eventResponse = command.searchDwellCandidateList(event);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		/**
		 * Customer Type Code 조회.<br>
		 *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchRvisCntrCustTpCd(Event e) throws EventException {
	        // PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	        EsdSce0140Event event = (EsdSce0140Event)e;
	        DwellNotificationBC command = new DwellNotificationBCImpl();
	        String rvis_cntr_cust_tp_cd = null;
	        try{
	        	rvis_cntr_cust_tp_cd = command.searchRvisCntrCustTpCd(event.getCust_cd());
	        	eventResponse.setETCData("rvis_cntr_cust_tp_cd", rvis_cntr_cust_tp_cd);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
		
		 /**
	     * Candidate PopUp 화면 Email List 조회
	     *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
	     */
		private EventResponse searchCandidateDwllNtfcSvcPopUpList(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			EsdSce0163Event event   = (EsdSce0163Event) e;
			DwellNotificationBC command = new DwellNotificationBCImpl();
				try {
					List<DwllNtfcSrchVO>  list = command.searchCandidateDwllNtfcSvcPopUpList(event.getDwllNtfcSrchVO());
					eventResponse.setRsVoList(list); 

				} catch (EventException de) {
					log.error("err " + de.toString(), de);
					throw new EventException(de.getMessage());
				}
				return eventResponse;
			}

		/**
		 * Candidate Email List 저장
		 *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse manageCandidateDwllNtfcSvcList(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			EsdSce0163Event event   = (EsdSce0163Event) e;
			DwellNotificationBC command = new DwellNotificationBCImpl();
			try {
				begin();
				command.manageCandidateDwllNtfcSvcList(event ,account.getUsr_id(), account.getOfc_cd());
		        commit();

			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
	   }
	   
		/**
		 * UI_ESD_SCE_0164의 cnrt_no 별 sned option 상태 저장 br>
		 *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse modifyDwllEmailSendOptin(Event e) throws EventException {
			EventResponse eventResponse = null;
	        EsdSce0164Event event = (EsdSce0164Event)e;
	        DwellNotificationBC command = new DwellNotificationBCImpl();
	        try{
	        	begin();
	        	eventResponse = command.modifyDwllEmailSendOption(event  ,account.getUsr_id());
	        	commit();
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
	
		 /**
	     * UI_ESD_SCE_0160 조회화면의 Dwell rns을 조회 후 자동 저장 
	     *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
	     */
		private EventResponse searchDwellRsn(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			EsdSce0160Event event   = (EsdSce0160Event) e;
			DwellNotificationBC command = new DwellNotificationBCImpl();
			DwellRnsVO conditionVO = event.getDwellRnsVO();
			List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
			String[] cloumndata  = null;
				try {
						begin();
						DwellRnsVO  list = command.searchDwellRsn(event.getDwellRnsVO());
						cloumndata = list.getResultStrArray();
						command.manageDwellRsn1(event.getDwellRnsVO() ,cloumndata ,account.getUsr_id());
						returnVOList.add(conditionVO);
						returnVOList.add(list);
						eventResponse.setRsVoList(returnVOList);
						commit();
				
				} catch (EventException de) {
					log.error("err " + de.toString(), de);
					throw new EventException(de.getMessage());
				}
				return eventResponse;
			}
		
		/**
		 * DWLL RSN  저장
		 *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse manageDwellRsn(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			EsdSce0160Event event   = (EsdSce0160Event) e;
			DwellNotificationBC command = new DwellNotificationBCImpl();
			try {
				begin();
				command.manageDwellRsn(event ,account.getUsr_id());
		        commit();

			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
	   }
		
		/**
		 * Customer Code 유/무 조회
		 *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse checkCustCd(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			EsdSce0151Event event   = (EsdSce0151Event) e;
			DwellNotificationBC command = new DwellNotificationBCImpl();
			String knt = null;
			try {
				knt = command.checkCustCd(event.getDwllNtfcSrchVO().getCustCd());
				eventResponse.setETCData("knt", knt);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
	   }
	
		 /**
	     * Dwell Notification Exception 항목 단건 조회
	     *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
	     */
	private EventResponse searchDwllNtfcExptItem(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0151Event event   = (EsdSce0151Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
		DwllNtfcSrchVO conditionVO = event.getDwllNtfcSrchVO();
		List<AbstractValueObject> returnVOList = new ArrayList<AbstractValueObject>();
			try {
				event.getDwllNtfcSrchVO().setOfcCd(account.getOfc_cd());
				DwllNtfcSrchVO  list = command.searchDwllNtfcExptItem(event.getDwllNtfcSrchVO());
				returnVOList.add(conditionVO);
				returnVOList.add(list);
				eventResponse.setRsVoList(returnVOList); 

			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
	
	 /**
     * One Time Send History PopUp 화면 Email List 조회
     *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
	private EventResponse searchOneTimeSndHistList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsdSce0165Event event   = (EsdSce0165Event) e;
		DwellNotificationBC command = new DwellNotificationBCImpl();
			try {
				List<SearchOneTimeSndHistVO>  list = command.searchOneTimeSndHistList(event.getSearchOneTimeSndHistVO());
				eventResponse.setRsVoList(list); 

			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			return eventResponse;
		}
	/**
	 * UI_ESD_SCE_0160 조회화면의 Tab별 Total Count 값 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDwellCandidateTotalCnt(Event e) throws EventException {
		EventResponse eventResponse = null;
        EsdSce0160Event event = (EsdSce0160Event)e;
        DwellNotificationBC command = new DwellNotificationBCImpl();
        try{
        	eventResponse = command.searchDwellCandidateTotalCnt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}