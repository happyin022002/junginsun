/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CommonSC.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.25
*@LastModifier : 유선오
*@LastVersion : 1.7
* 2006-10-27 juhyun
* 1.0 최초 생성
* -----------------------------------------------------------------
* History
* 1.1 2011.02.10 민정호 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 1.3 2011.02.18  손은주  [CHM-201108834-01]	[TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청- 월별 주차별 검색기간 추가
* 1.4 2011.03.28 손은주 [CHM-201109560-01] Split 04-Intra - Europe Business 관련 VAT 기능 개발 - 대륙코드 조회
* 1.5 2011.08.31 유선오 [CHM-201112874] [TRS] OTHER S/O Creation 화면상 오류 수정 요청
* 1.6 2011.10.19 유선오 [CHM-201112874][TRS]  OTHER S/O Creation 화면 상 오류 수정요청
* 1.7 2011.10.25 유선오 [CHM-201112874][TRS] 품질결함수정 - 사용하지 않는 지역 변수를 점검한다 : searchCustCd메소드 Line 181, 사용하지 않은  event 변수 사용하도록 변경
* 2011.11.17 변종건[CHM-201114528-01] TRS 시스템 담당자용 버튼 개발
* 2012.01.06 김종호 [CHM-201109410] [TRS] CNTR No. 유효성에 대한 Validation 절차 추가요청 : (searchCntrEqNo)
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경 : Actual Customer 자동 조회 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.basic.ActualCustomerPopupBC;
import com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.basic.ActualCustomerPopupBCImpl;
import com.hanjin.apps.alps.esd.trs.common.actualcustomerpopup.event.EsdTrs0914Event;
import com.hanjin.apps.alps.esd.trs.common.awkwardcargodetailinquiry.basic.AwkWardCargoDetailInquiryBC;
import com.hanjin.apps.alps.esd.trs.common.awkwardcargodetailinquiry.basic.AwkWardCargoDetailInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.common.awkwardcargodetailinquiry.event.EsdTrs0936Event;
import com.hanjin.apps.alps.esd.trs.common.breakbulkcargodetailinquiry.basic.BreakBulkCargoDetailInquiryBC;
import com.hanjin.apps.alps.esd.trs.common.breakbulkcargodetailinquiry.basic.BreakBulkCargoDetailInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.common.breakbulkcargodetailinquiry.event.EsdTrs0937Event;
import com.hanjin.apps.alps.esd.trs.common.containerselectpopup.basic.ContainerSelectPopupBC;
import com.hanjin.apps.alps.esd.trs.common.containerselectpopup.basic.ContainerSelectPopupBCImpl;
import com.hanjin.apps.alps.esd.trs.common.containerselectpopup.event.EsdTrs0908Event;
import com.hanjin.apps.alps.esd.trs.common.dangercargodetailinquiry.basic.DangerCargoDetailInquiryBC;
import com.hanjin.apps.alps.esd.trs.common.dangercargodetailinquiry.basic.DangerCargoDetailInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.common.dangercargodetailinquiry.event.EsdTrs0938Event;
import com.hanjin.apps.alps.esd.trs.common.fileattach.event.EsdTrs0977Event;
import com.hanjin.apps.alps.esd.trs.common.fileattach.vo.TrsFileVO;
import com.hanjin.apps.alps.esd.trs.common.mtyreposelectpopup.basic.MtyRepoSelectPopupBC;
import com.hanjin.apps.alps.esd.trs.common.mtyreposelectpopup.basic.MtyRepoSelectPopupBCImpl;
import com.hanjin.apps.alps.esd.trs.common.mtyreposelectpopup.event.EsdTrs0909Event;
import com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.basic.MultistopLocationInquiryBC;
import com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.basic.MultistopLocationInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.event.EsdTrs0933Event;
import com.hanjin.apps.alps.esd.trs.common.refercargodetailinquiry.basic.ReferCargoDetailInquiryBC;
import com.hanjin.apps.alps.esd.trs.common.refercargodetailinquiry.basic.ReferCargoDetailInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.common.refercargodetailinquiry.event.EsdTrs0935Event;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.event.EsdTrs0999Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
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
			account=getSignOnUserAccount();
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
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0935Event")) {
			//Refer Cargo Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				
				eventResponse = searchReferCargoDetailInquiry(e);				
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0936Event")) {
			//Awkward Cargo Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAwkWardCargoDetailInquiry(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0938Event")) {
			//Dangerous Cargo Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDangerCargoDetailInquiry(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0933Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMultistopLocationInquiryList(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0914Event")) {
			//ACTUAL CUSTOMER POPUP
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
        		/* ACTUAL CUSTOMER POPUP : Header List	*/
				eventResponse = searchActualCustomerList(e);				
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				/* ACTUAL CUSTOMER POPUP : Detail List	*/	
				eventResponse = searchActualCustomer(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				/* ACTUAL CUSTOMER Auto Inquiry */	
				eventResponse = searchActualCustomerName(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0908Event")) {
			//Container Select
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerSelectPopup(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerSelectMainList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContainerSelectSubList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchContainerSelectReplaceTPSZList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchSplitBkgList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0909Event")) {
			//MtyRepoSelectPopup
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {

				eventResponse = searchMtyRepoSelectPopup(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0999Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContiCd(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPeriod(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchContiCode(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCmdtCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCustCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchBtnAuthority(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchCntrEqNo(e);	//Container Validation
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchPeriod(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchLocalTime(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchMdmCntrTpActive(e);	
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdTrs0977Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAttachFile(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAttachFile(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeAttachFileAll(e);
			}

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

	private EventResponse searchCustCd(Event e) throws EventException{
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EsdTrs0999Event event=(EsdTrs0999Event)e;
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
	 * 조회 이벤트 처리<br>
	 * BreakBulkCargoDetailInquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBreakBulkCargoDetailInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0937Event event = (EsdTrs0937Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0935Event event = (EsdTrs0935Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0936Event event = (EsdTrs0936Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0938Event event = (EsdTrs0938Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0933Event event = (EsdTrs0933Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0914Event event = (EsdTrs0914Event)e;
		
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
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0914Event event = (EsdTrs0914Event)e;
		
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
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event = (EsdTrs0908Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * ACTUAL CUSTOMER Name<br>	
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCustomerName(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		EsdTrs0914Event event = (EsdTrs0914Event)e;

		try {
			ActualCustomerPopupBC command = new ActualCustomerPopupBCImpl();
			eventResponse = command.searchActualCustomerName(event);

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
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event = (EsdTrs0908Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event = (EsdTrs0908Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event = (EsdTrs0908Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0908Event event = (EsdTrs0908Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0909Event event = (EsdTrs0909Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	private EventResponse searchContiCd(Event e) throws EventException {

		EsdTrs0999Event event = (EsdTrs0999Event)e;

		EventResponse eventResponse = null;
		
		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchContiCd(event);			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * searchContiCode: 해당 오피스의 대륙코드 조회<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws String
	 */
	private EventResponse searchContiCode(Event e) throws EventException {

		EsdTrs0999Event event = (EsdTrs0999Event)e;

		EventResponse eventResponse = null;
		
		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchContiCode(event);			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 월,주차 검색기간 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPeriod(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchPeriod(e);
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
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * 버튼 권한 조회 이벤트 처리
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBtnAuthority(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchBtnAuthority(account);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Container Validation
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCntrEqNo(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchCntrEqNo(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Container Validation
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLocalTime(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchLocalTime(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Container type - Active
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMdmCntrTpActive(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			TrsCommonBC command = new TrsCommonBCImpl();
			eventResponse = command.searchMdmCntrTpActive();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	private EventResponse searchAttachFile(Event e) throws EventException {
		try{
			EsdTrs0977Event event = (EsdTrs0977Event)e;
			TrsCommonBC command = new TrsCommonBCImpl();
			List<TrsFileVO> list = command.searchTrsFile(event.getTrsFileVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchAttachFile"}).getMessage(), ex);
		}
	}
	
	private EventResponse manageAttachFile(Event e) throws EventException {
		EsdTrs0977Event event = (EsdTrs0977Event)e;
		TrsCommonBC command = new TrsCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			String atchFileLnkId = command.manageTrsFile(event.getTrsFileVOs() ,account);
			eventResponse.setETCData("atch_file_lnk_id",atchFileLnkId);
			eventResponse.setUserMessage(new ErrorHandler("TRS90511").getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"deleteAttachFile"}).getMessage(), ex);
		}
	}
	
	private EventResponse removeAttachFileAll(Event e) throws EventException {
		EsdTrs0977Event event = (EsdTrs0977Event)e;
		TrsCommonBC command = new TrsCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.removeTrsFileAll(event.getTrsFileVO());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"deleteAttachFile"}).getMessage(), ex);
		}
	}	
		
}
