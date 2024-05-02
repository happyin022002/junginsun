/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMReportSC.java
*@FileTitle : ACMReportSC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.16 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmreport;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmreport.acmreport.basic.ACMReportBC;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.basic.ACMReportBCImpl;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.event.EsmAcm0034Event;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.event.EsmAcm0037Event;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.event.EsmAcm0111Event;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.event.EsmAcm0118Event;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.integration.ACMReportDBDAO;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.vo.CSRDetailVO;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.vo.CSRInquiryVO;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.vo.CommReportVO;
import com.clt.apps.opus.esm.acm.acmreport.acmreport.vo.ReportItemVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMReport Business Logic ServiceCommand<br>
 * - OPUS-ACMReport에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Bong-Gyoon
 * @see ACMReportDBDAO
 * @since J2EE 1.6
 */

public class ACMReportSC extends ServiceCommandSupport {

	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMReport system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ACMReportSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMReport system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ACMReportSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-ACMReport system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmAcm0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCSRInquiry(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0111Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCSRDetail(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getReportGroup();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getReportItem(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {    // 1 - start backendjob
				eventResponse = startBackEndJobSearchCommReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {    // 2 - get status of backendjob
				eventResponse = getBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {    // 3 - result return
				eventResponse = resultBackEndJobSearchCommReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {    // 1 - start backendjob
				eventResponse = startBackEndJobSearchCommReport2(e);
//				eventResponse = searchReportListByCntrNo(e);	
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0118Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportItemList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageReportItem(e);
			}
		}
		return eventResponse;
	}

	/**
	 * BackEndJob공통 - BackEndJob status를 return<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ACMReportBC command = new ACMReportBCImpl();
		try{
			String status = command.getBackEndJobStatus((String)e.getAttribute("backendjob_key"));
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0034] Retrieve<br>
	 * CSR Inquiry 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRInquiry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0034Event event = (EsmAcm0034Event)e;
		ACMReportBC command = new ACMReportBCImpl();
		try{
			List<CSRInquiryVO> list1 = command.searchCSRInquiry(event.getCSRInquiryVO());
			List<CSRInquiryVO> list2 = command.searchCSRInquiryCurrAMT(event.getCSRInquiryVO());
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0111] Retrieve<br>
	 * CSR Detail 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0111Event event = (EsmAcm0111Event)e;
		ACMReportBC command = new ACMReportBCImpl();
		try{
			List<CSRDetailVO> list = command.searchCSRDetail(event.getCsrDetailVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0037], [ESM_ACM_0118] Onload<br>
	 * Commission Report 목록을 조회<br>
	 *
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getReportGroup() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ACMReportBC command = new ACMReportBCImpl();
		try{
			List<ReportItemVO> list = command.getReportGroup(account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0037] OnChange<br>
	 * Customized RPT Form 콤보에 따른 IBSheet헤더명을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getReportItem(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0037Event event = (EsmAcm0037Event)e;
		ACMReportBC command = new ACMReportBCImpl();
		try{
			List<ReportItemVO> list = command.getReportItem(event.getReportItemVO(), account);
			StringBuilder reportItem = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				reportItem.append(list.get(i).getRptItmColNm() + "|");
			}
			eventResponse.setETCData("report_item", "|" + reportItem.toString());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0037] Retrieve - BackEndJob 시작<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobSearchCommReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0037Event event = (EsmAcm0037Event)e;
		ACMReportBC command = new ACMReportBCImpl();
		try {
			begin();
			eventResponse.setETCData("backendjob_key", command.startBackEndJobSearchCommReport(event.getCommReportVO(), account));
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0037] Retrieve - BackEndJob 시작<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobSearchCommReport2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0037Event event = (EsmAcm0037Event)e;
		ACMReportBC command = new ACMReportBCImpl();
		try {
			begin();
			eventResponse.setETCData("backendjob_key", command.startBackEndJobSearchCommReport2(event.getCommReportVO(), account));
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0037] BackEndJob 결과<br>
	 * Commission Report 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobSearchCommReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0037Event event = (EsmAcm0037Event)e;
		ACMReportBC command = new ACMReportBCImpl();
		try{
			List<CommReportVO> list = command.resultBackEndJobSearchCommReport((String)event.getAttribute("backendjob_key"));
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0118] OnLoad / Retrieve<br>
	 * Customized RPT Form 컬럼 Item 목록을 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportItemList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0118Event event = (EsmAcm0118Event)e;
		ACMReportBC command = new ACMReportBCImpl();
		try{
			List<ReportItemVO> list = command.getReportItem(event.getReportItemVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0118] Save<br>
	 * Customized RPT Form 콤보 그룹명과 컬럼 Item 목록을 저장
	 *
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageReportItem(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0118Event event = (EsmAcm0118Event)e;
		ACMReportBC command = new ACMReportBCImpl();
		try {
			begin();
			command.manageReportItem(event.getReportItemVO(), event.getReportItemVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

//	/**
//	 * [ESM_ACM_0037] By Container No. Retrieve 
//	 * @param e
//	 * @return
//	 * @throws EventException
//	 */
//	private EventResponse searchReportListByCntrNo(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmAcm0037Event event = (EsmAcm0037Event)e;
//		ACMReportBC command = new ACMReportBCImpl();
//		try{
//			List<CommReportVO> list = command.searchReportListByCntrNo(event.getCommReportVO());
//			eventResponse.setRsVoList(list);
//		} catch(EventException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		} catch(Exception ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return eventResponse;
//	}
}