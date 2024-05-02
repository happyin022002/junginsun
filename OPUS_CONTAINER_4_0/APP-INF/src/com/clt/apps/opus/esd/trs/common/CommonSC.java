/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_932SC.java
 *@FileTitle : BKG CGO SPE Detail Popup - HG
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-27
 *@LastModifier : juhyun
 *@LastVersion : 1.0
 * 2006-10-27 juhyun
 * 1.0 최초 생성
 * 2011.10.20 황효근 [TRS] Rail Company 조회 방법 변경 (searchRailVndrCd 메소드 추가 )
=========================================================*/
package com.clt.apps.opus.esd.trs.common;

import java.util.List;

import com.clt.apps.opus.esd.trs.common.actualcustomerpopup.basic.ActualCustomerPopupBC;
import com.clt.apps.opus.esd.trs.common.actualcustomerpopup.basic.ActualCustomerPopupBCImpl;
import com.clt.apps.opus.esd.trs.common.actualcustomerpopup.event.EsdTrs0914Event;
import com.clt.apps.opus.esd.trs.common.awkwardcargodetailinquiry.basic.AwkWardCargoDetailInquiryBC;
import com.clt.apps.opus.esd.trs.common.awkwardcargodetailinquiry.basic.AwkWardCargoDetailInquiryBCImpl;
import com.clt.apps.opus.esd.trs.common.awkwardcargodetailinquiry.event.EsdTrs0936Event;
import com.clt.apps.opus.esd.trs.common.breakbulkcargodetailinquiry.basic.BreakBulkCargoDetailInquiryBC;
import com.clt.apps.opus.esd.trs.common.breakbulkcargodetailinquiry.basic.BreakBulkCargoDetailInquiryBCImpl;
import com.clt.apps.opus.esd.trs.common.breakbulkcargodetailinquiry.event.EsdTrs0937Event;
import com.clt.apps.opus.esd.trs.common.containerselectpopup.basic.ContainerSelectPopupBC;
import com.clt.apps.opus.esd.trs.common.containerselectpopup.basic.ContainerSelectPopupBCImpl;
import com.clt.apps.opus.esd.trs.common.containerselectpopup.event.EsdTrs0908Event;
import com.clt.apps.opus.esd.trs.common.dangercargodetailinquiry.basic.DangerCargoDetailInquiryBC;
import com.clt.apps.opus.esd.trs.common.dangercargodetailinquiry.basic.DangerCargoDetailInquiryBCImpl;
import com.clt.apps.opus.esd.trs.common.dangercargodetailinquiry.event.EsdTrs0938Event;
import com.clt.apps.opus.esd.trs.common.internalremarkpopup.basic.InternalRemarkPopupBC;
import com.clt.apps.opus.esd.trs.common.internalremarkpopup.basic.InternalRemarkPopupBCImpl;
import com.clt.apps.opus.esd.trs.common.internalremarkpopup.event.EsdTrs0982Event;
import com.clt.apps.opus.esd.trs.common.internalremarkpopup.vo.InternalRemarkVO;
import com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.basic.MtyRepoSelectPopupBC;
import com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.basic.MtyRepoSelectPopupBCImpl;
import com.clt.apps.opus.esd.trs.common.mtyreposelectpopup.event.EsdTrs0909Event;
import com.clt.apps.opus.esd.trs.common.multistoplocationinquiry.basic.MultistopLocationInquiryBC;
import com.clt.apps.opus.esd.trs.common.multistoplocationinquiry.basic.MultistopLocationInquiryBCImpl;
import com.clt.apps.opus.esd.trs.common.multistoplocationinquiry.event.EsdTrs0933Event;
import com.clt.apps.opus.esd.trs.common.portselectpopup.basic.PortSelectPopupBC;
import com.clt.apps.opus.esd.trs.common.portselectpopup.basic.PortSelectPopupBCImpl;
import com.clt.apps.opus.esd.trs.common.portselectpopup.event.EsdTrs0981Event;
import com.clt.apps.opus.esd.trs.common.portselectpopup.vo.PortVO;
import com.clt.apps.opus.esd.trs.common.refercargodetailinquiry.basic.ReferCargoDetailInquiryBC;
import com.clt.apps.opus.esd.trs.common.refercargodetailinquiry.basic.ReferCargoDetailInquiryBCImpl;
import com.clt.apps.opus.esd.trs.common.refercargodetailinquiry.event.EsdTrs0935Event;
import com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.basic.StccCodeRestrictionBC;
import com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.basic.StccCodeRestrictionBCImpl;
import com.clt.apps.opus.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.clt.apps.opus.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.clt.apps.opus.esd.trs.common.trscommon.event.EsdTrs0999Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCountryVO;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author juhyun
 * @see BookingSpecialCargoDetailInquiryDBDAO 참조
 * @since J2EE 1.4
 */
public class CommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * Common업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("CommonSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * Common업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("CommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0937Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBreakBulkCargoDetailInquiry(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0935Event")) {
			// Refer Cargo Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReferCargoDetailInquiry(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0936Event")) {
			// Awkward Cargo Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAwkWardCargoDetailInquiry(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0938Event")) {
			// Dangerous Cargo Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDangerCargoDetailInquiry(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0933Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMultistopLocationInquiryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0914Event")) {
			// ACTUAL CUSTOMER POPUP
			if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				/* ACTUAL CUSTOMER POPUP : Header List */
				eventResponse = searchActualCustomerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				/* ACTUAL CUSTOMER POPUP : Detail List */
				eventResponse = searchActualCustomer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0908Event")) {
			// Container Select
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerSelectPopup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerSelectMainList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContainerSelectSubList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchContainerSelectReplaceTPSZList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchSplitBkgList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0909Event")) {
			// MtyRepoSelectPopup
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {

				eventResponse = searchMtyRepoSelectPopup(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0999Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRailVndrCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCmdtCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCustCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchChangeWeight(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchMdmPckTp(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0981Event")) { // Port Select
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCountryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0939Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStccCodeRestriction(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0982Event")) { // Internal Remark
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInternalRemarkList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				manageInternalRemarkList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // CY&Door S/O Delete
				manageInternalRemarkListbySoWo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Supplement S/O Delete
				manageInternalRemarkListbySoWo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // Other S/O Delete
				manageInternalRemarkListbySoWo(e);
			}
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * BreakBulkCargoDetailInquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBreakBulkCargoDetailInquiry(Event e) throws EventException {
		EsdTrs0937Event event = (EsdTrs0937Event) e;
		EventResponse eventResponse = null;
		try {
			BreakBulkCargoDetailInquiryBC command = new BreakBulkCargoDetailInquiryBCImpl();
			eventResponse = command.searchBreakBulkCargoDetailInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ReferCargoDetailInquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReferCargoDetailInquiry(Event e) throws EventException {
		EsdTrs0935Event event = (EsdTrs0935Event) e;
		EventResponse eventResponse = null;
		try {
			ReferCargoDetailInquiryBC command = new ReferCargoDetailInquiryBCImpl();
			eventResponse = command.searchReferCargoDetailInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * AwkWardCargoDetailInquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkWardCargoDetailInquiry(Event e) throws EventException {
		EsdTrs0936Event event = (EsdTrs0936Event) e;
		EventResponse eventResponse = null;
		try {
			AwkWardCargoDetailInquiryBC command = new AwkWardCargoDetailInquiryBCImpl();
			eventResponse = command.searchAwkWardCargoDetailInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * DangerCargoDetailInquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDangerCargoDetailInquiry(Event e) throws EventException {
		EsdTrs0938Event event = (EsdTrs0938Event) e;
		EventResponse eventResponse = null;
		try {
			DangerCargoDetailInquiryBC command = new DangerCargoDetailInquiryBCImpl();
			eventResponse = command.searchDangerCargoDetailInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MultistopLocationInquiry 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMultistopLocationInquiryList(Event e) throws EventException {
		EsdTrs0933Event event = (EsdTrs0933Event) e;
		EventResponse eventResponse = null;
		try {
			MultistopLocationInquiryBC command = new MultistopLocationInquiryBCImpl();
			eventResponse = command.searchMultistopLocationInquiryList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * ACTUAL CUSTOMER POPUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCustomerList(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0914Event event = (EsdTrs0914Event) e;
		try {
			ActualCustomerPopupBC command = new ActualCustomerPopupBCImpl();
			eventResponse = command.searchActualCustomerList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * ACTUAL CUSTOMER DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCustomer(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0914Event event = (EsdTrs0914Event) e;
		try {
			ActualCustomerPopupBC command = new ActualCustomerPopupBCImpl();
			eventResponse = command.searchActualCustomer(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerSelectPopup(Event e) throws EventException {
		EsdTrs0908Event event = (EsdTrs0908Event) e;
		EventResponse eventResponse = null;
		try {
			ContainerSelectPopupBC command = new ContainerSelectPopupBCImpl();
			eventResponse = command.searchContainerSelectPopup(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerSelectMainList(Event e) throws EventException {
		EsdTrs0908Event event = (EsdTrs0908Event) e;
		EventResponse eventResponse = null;
		try {
			ContainerSelectPopupBC command = new ContainerSelectPopupBCImpl();
			eventResponse = command.searchContainerSelectMainList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerSelectSubList(Event e) throws EventException {
		EsdTrs0908Event event = (EsdTrs0908Event) e;
		EventResponse eventResponse = null;
		try {
			ContainerSelectPopupBC command = new ContainerSelectPopupBCImpl();
			eventResponse = command.searchContainerSelectSubList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerSelectReplaceTPSZList(Event e) throws EventException {
		EsdTrs0908Event event = (EsdTrs0908Event) e;
		EventResponse eventResponse = null;
		try {
			ContainerSelectPopupBC command = new ContainerSelectPopupBCImpl();
			eventResponse = command.searchContainerSelectReplaceTPSZList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ContainerSelectPopup의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSplitBkgList(Event e) throws EventException {
		EsdTrs0908Event event = (EsdTrs0908Event) e;
		EventResponse eventResponse = null;
		try {
			ContainerSelectPopupBC command = new ContainerSelectPopupBCImpl();
			eventResponse = command.searchSplitBkgList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * MtyRepoSelectPopup의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyRepoSelectPopup(Event e) throws EventException {
		EsdTrs0909Event event = (EsdTrs0909Event) e;
		EventResponse eventResponse = null;
		try {
			MtyRepoSelectPopupBC command = new MtyRepoSelectPopupBCImpl();
			eventResponse = command.searchMtyRepoSelectPopup(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchContiCd<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws String
	 */
	private EventResponse searchRailVndrCd(Event e) throws EventException {
		EsdTrs0999Event event = (EsdTrs0999Event) e;
		EventResponse eventResponse = null;
		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchRailVndrCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Commodity 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmdtCd(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchCmdtCd(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OtherSO Manage의 event에 대한 customer code 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustCd(Event e) throws EventException {
		EsdTrs0999Event event = (EsdTrs0999Event) e;
		EventResponse eventResponse = null;
		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchCustCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Retrieving Port<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPortList(Event e) throws EventException {
		try {
			PortVO portVO = null;
			EsdTrs0981Event event = (EsdTrs0981Event) e;
			portVO = event.getPortVO();

			PortSelectPopupBC command = new PortSelectPopupBCImpl();
			List<PortVO> list = command.searchPortList(portVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("PORT_NAME", list.get(0).getLocNm());
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * Retrieving Country List<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCountryList(Event e) throws EventException {
		try {
			MdmCountryVO vo = null;
			EsdTrs0981Event event = (EsdTrs0981Event) e;
			vo = event.getMdmCountryVO();

			PortSelectPopupBC command = new PortSelectPopupBCImpl();
			List<MdmCountryVO> list = command.searchCountryList(vo.getCntCd());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("cnt_nm", list.get(0).getCntNm());
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchStccCodeRestriction(Event event) throws EventException {
		try {
			StccCodeRestrictionBC command = new StccCodeRestrictionBCImpl();
			return command.searchStccCodeRestriction(event);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * Retrieve Internal Remarks
	 * 
	 * @param e
	 * @return EventResponse response
	 * @throws EventException
	 */
	public EventResponse searchInternalRemarkList(Event e) throws EventException {
		EsdTrs0982Event event = (EsdTrs0982Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<InternalRemarkVO> list = null;
			InternalRemarkPopupBC command = new InternalRemarkPopupBCImpl();

			list = command.searchInternalRemarkList(event);
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Manage Internal Remarks
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void manageInternalRemarkList(Event e) throws EventException {
		try {
			begin();
			EsdTrs0982Event event = (EsdTrs0982Event) e;
			InternalRemarkPopupBC command = new InternalRemarkPopupBCImpl();

			command.manageInternalRemarkList(event.getInternalRemarkVOs(), account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Manage Internal Remarks by S/O no, W/O no
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void manageInternalRemarkListbySoWo(Event e) throws EventException {
		try {
			begin();
			EsdTrs0982Event event = (EsdTrs0982Event) e;
			InternalRemarkPopupBC command = new InternalRemarkPopupBCImpl();
			command.manageInternalRemarkListbySoWo(event, account);
			commit();
		} catch (EventException de) {
			rollback();
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
	private EventResponse searchChangeWeight(Event e) throws EventException {
		EsdTrs0999Event event = (EsdTrs0999Event) e;
		EventResponse eventResponse = null;
		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchChangeWeight(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * CodeManage event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMdmPckTp(Event e) throws EventException {
		EsdTrs0999Event event = (EsdTrs0999Event) e;
		EventResponse eventResponse = null;
		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchMdmPckTp(event);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}
