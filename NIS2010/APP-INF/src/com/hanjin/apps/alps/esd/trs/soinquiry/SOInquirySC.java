/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SOInquirySC.java
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08 
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2006.10.18 juhyun
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2010.09.30 최 선       1.1 [] SO Inquiry 엑셀 다운로드 수정
* 2010.11.08 최 선       1.2 [CHM-201006928] Performance Evaluation Save 후, 불필요한 재조회 프로세스 제외 처리
* 2011.06.28 손은주 [CHM-201111573-01]	[TRS] S/O history function 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry;

import com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.basic.PendingListBC;
import com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.basic.PendingListBCImpl;
import com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.basic.SOInquiryBC;
import com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.basic.SOInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.event.EsdTrs0019Event;
import com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.basic.SpperformancEvaluationBC;
import com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.basic.SpperformancEvaluationBCImpl;
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
 * @see ESD_TRS_001EventResponse,PendingListDBDAO 참조
 * @since J2EE 1.4
 */
public class SOInquirySC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	private String sofficeCd = "";

	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * PendingList업무 시나리오 호출시 관련 내부객체 `생성<br>
	 */
	public void doStart() {
		try {
			account=getSignOnUserAccount();
			sofficeCd = account.getOfc_cd();
		} catch (Exception e) {
			log.error("ESD_TRS_0001SC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * PendingList업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ESD_TRS_0001SC 종료");
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
		if (e.getEventName().equalsIgnoreCase("EsdTrs0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPendingListList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = search_vvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = search_ofc(e);
			} else {
				//eventResponse = searchPendingListList(e);
			}
		}

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSOInquiry(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = search_office(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSOInquiryExcelDown(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchSOHistory(e);
			}
		}



		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpperformancEvaluationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSpperformancEvaluation(e);
			} else {
				//eventResponse = searchSpperformancEvaluationList();
			}
		}



		return eventResponse;

	}

	/**
	 * 조회 이벤트 처리<br>
	 * PendingList 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPendingListList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//ESD_TRS_001Event event = (ESD_TRS_001Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			PendingListBC command = new PendingListBCImpl();
			eventResponse = command.searchPendingListList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * VVD체크 이벤트 처리<br>
	 * PendingList 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search_vvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//ESD_TRS_001Event event = (ESD_TRS_001Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			PendingListBC command = new PendingListBCImpl();
			eventResponse = command.search_vvd(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * ofc체크 이벤트 처리<br>
	 * PendingList 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search_ofc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//ESD_TRS_001Event event = (ESD_TRS_001Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			PendingListBC command = new PendingListBCImpl();
			eventResponse = command.search_ofc(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SOInquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSOInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0019Event event = (EsdTrs0019Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;		
		try {			
			SOInquiryBC command = new SOInquiryBCImpl();
			eventResponse = command.searchSOInquiry(event,sofficeCd);			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SOInquiry의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSOInquiryExcelDown(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0019Event event = (EsdTrs0019Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {			
			SOInquiryBC command = new SOInquiryBCImpl();

			eventResponse.setCustomData("rowset", command.getRowSet(event,sofficeCd));
			eventResponse.setCustomData("title", command.getTitle(event));
			eventResponse.setCustomData("columns", command.getColumns(event));
			eventResponse.setCustomData("fileName", "TRS_0205_EXCEL.xls");
			eventResponse.setCustomData("isZip", true);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * search office체크 이벤트 처리<br>
	 * PendingList 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search_office(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//ESD_TRS_019Event event = (ESD_TRS_019Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			SOInquiryBC command = new SOInquiryBCImpl();
			eventResponse = command.search_office(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SO History의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSOHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0019Event event = (EsdTrs0019Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;		
		try {			
			SOInquiryBC command = new SOInquiryBCImpl();
			eventResponse = command.searchSOHistory(event);			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * SpperformancEvaluation 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpperformancEvaluationList(Event e) throws EventException {
		//PDTO(Data Transfer Object including Parameters)
		//ESD_TRS_0039Event event = (ESD_TRS_0039Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			SpperformancEvaluationBC command = new SpperformancEvaluationBCImpl();
			eventResponse = command.searchSpperformancEvaluationList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}



	/**
	 * 멀티 이벤트 처리<br>
	 * SpperformancEvaluation의 event에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSpperformancEvaluation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//ESD_TRS_0039Event event = (ESD_TRS_0039Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			SpperformancEvaluationBC command = new SpperformancEvaluationBCImpl();
			eventResponse = command.multiSpperformancEvaluation(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}
