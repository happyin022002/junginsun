/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMRequestSC.java
*@FileTitle : ACMRequestSC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.02 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.basic.AGNCommAuditBC;
import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.basic.AGNCommAuditBCImpl;
import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.event.EsmAcm0008Event;
import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.integration.AGNCommAuditDBDAO;
import com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.vo.AGNCommAuditVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.facommaudit.basic.FACommAuditBC;
import com.hanjin.apps.alps.esm.acm.acmaudit.facommaudit.basic.FACommAuditBCImpl;
import com.hanjin.apps.alps.esm.acm.acmaudit.facommaudit.event.EsmAcm0028Event;
import com.hanjin.apps.alps.esm.acm.acmaudit.facommaudit.vo.FACCommListVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.basic.FFCmpnAuditBC;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.basic.FFCmpnAuditBCImpl;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.event.EsmAcm0027Event;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.event.EsmAcm0117Event;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnAuditVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailBasicbyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailChargebyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnDetailHistorybyBlVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnRateInfoVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.basic.OTRCommAuditBC;
import com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.basic.OTRCommAuditBCImpl;
import com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.event.EsmAcm0015Event;
import com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.vo.OTRCommAuditVO;
import com.hanjin.apps.alps.esm.acm.acmaudit.spclcmpnaudit.basic.SPCLCmpnAuditBC;
import com.hanjin.apps.alps.esm.acm.acmaudit.spclcmpnaudit.basic.SPCLCmpnAuditBCImpl;
import com.hanjin.apps.alps.esm.acm.acmaudit.spclcmpnaudit.event.EsmAcm0029Event;
import com.hanjin.apps.alps.esm.acm.acmaudit.spclcmpnaudit.vo.SPCLCmpnAuditVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMRequest Business Logic ServiceCommand<br>
 * - ALPS-ACMRequest에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see AGNCommAuditDBDAO
 * @since J2EE 1.6
 */
public class ACMAuditSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ACMRequest system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ACMRequestSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ACMRequest system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ACMRequestSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ACMRequest system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmAcm0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAGNCommAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAGNCommAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = rejectAGNCommAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = auditCancelAGNCommAudit(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOTRCommAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAOTRCommAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = rejectOtrAGNCommAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = auditCancelOtrAGNCommAudit(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFFCmpnAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = reCalculateFFAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFFCmpnAudit(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFACommAudit(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = reCalculateFACAudit(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSPCLCmpnAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSPCLCmpnAudit(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmAcm0117Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFFCmpnDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFFCmpnDetailHistorybyBl(e);
			}
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0008] Retrive<br>
	 * Agent Commission Audit 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGNCommAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0008Event event = (EsmAcm0008Event)e;
		AGNCommAuditBC command = new AGNCommAuditBCImpl();

		try{
			List<AGNCommAuditVO> list = command.searchAGNCommAudit(event.getAGNCommAuditVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0015] Retrive<br>
	 * Other Commission Audit 화면 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOTRCommAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0015Event event = (EsmAcm0015Event)e;
		OTRCommAuditBC command = new OTRCommAuditBCImpl();

		try{
			List<OTRCommAuditVO> list = command.searchOTRCommAudit(event.getOtrCommAuditVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0027] Retrive<br>
	 * FF Compensation Audit 화면 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFCmpnAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0027Event event = (EsmAcm0027Event)e;
		FFCmpnAuditBC command = new FFCmpnAuditBCImpl();

		try{
			List<FFCmpnAuditVO> list = command.searchFFCmpnAudit(event.getAgnCommAuditVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0028] Retrive<br>
	 * FAC Audit 화면 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACommAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0028Event event = (EsmAcm0028Event)e;
		FACommAuditBC command = new FACommAuditBCImpl();

		try{
			List<FACCommListVO> list = command.searchFACommAudit(event.getFacCommListVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0029] Retrive<br>
	 * Special Compensation Audit 화면 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSPCLCmpnAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0029Event event = (EsmAcm0029Event)e;
		SPCLCmpnAuditBC command = new SPCLCmpnAuditBCImpl();

		try{
			List<SPCLCmpnAuditVO> list = command.searchSPCLCmpnAudit(event.getSpcLCmpnAuditVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0029] Retrive<br>
	 * Agent Commission Audit 목록을 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSPCLCmpnAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0029Event event = (EsmAcm0029Event)e;
		SPCLCmpnAuditBC command = new SPCLCmpnAuditBCImpl();

		try{
			begin();
			command.manageSPCLCmpnAudit(event.getSpcLCmpnAuditVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [ESM_ACM_0028] Re-Calculate<br>
	 * FAC Audit 재계산<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reCalculateFACAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0028Event event = (EsmAcm0028Event)e;
		FACommAuditBC command = new FACommAuditBCImpl();

		try{
			FACCommListVO[] facCommListVOs = event.getFacCommListVOs();
			//log.debug("facCommListVOs.length===>"+facCommListVOs.length);
			for(int i=0; i<facCommListVOs.length; i++)
			{
					log.debug("\n facCommListVOs[i].getBkgNo()===>"+facCommListVOs[i].getBkgNo());
					command.reCalculateFACAudit(facCommListVOs[i].getBkgNo(), event.getSignOnUserAccount());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0027] Re-Calculate<br>
	 * FF Audit 재계산<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reCalculateFFAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0027Event event = (EsmAcm0027Event)e;
		FFCmpnAuditBC command = new FFCmpnAuditBCImpl();

		try{
			FFCmpnAuditVO[] ffCommListVOs = event.getFfcmpnAuditVOs();
			//log.debug("facCommListVOs.length===>"+facCommListVOs.length);
			for(int i=0; i<ffCommListVOs.length; i++)
			{
					log.debug("\n facCommListVOs[i].getBkgNo()===>"+ffCommListVOs[i].getBkgNo());
					command.reCalculateFFAudit(ffCommListVOs[i].getBkgNo(), event.getSignOnUserAccount());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0008] Audit<br>
	 * Agent Commission Audit 저장 Audit 버튼<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAGNCommAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0008Event event = (EsmAcm0008Event)e;
		AGNCommAuditBC command = new AGNCommAuditBCImpl();

		try{
			begin();
			command.manageAGNCommAudit(event.getAGNCommAuditVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [ESM_ACM_0015] Audit<br>
	 * Other Commission Audit 저장 Audit 버튼<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAOTRCommAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0015Event event = (EsmAcm0015Event)e;
		OTRCommAuditBC command = new OTRCommAuditBCImpl();

		try{
			begin();
			command.manageAGNCommAudit(event.getOtrCommAuditVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [ESM_ACM_0008] Reject<br>
	 * Agent Commission Audit 화면의 Reject 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectAGNCommAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0008Event event = (EsmAcm0008Event)e;
		AGNCommAuditBC command = new AGNCommAuditBCImpl();

		try{
			begin();
			command.rejectAGNCommAudit(event.getAGNCommAuditVOs(), account, event.getAGNCommAuditVO().getAcTpCd());
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [ESM_ACM_0008] Audit Cancel<br>
	 * Agent Commission Audit 화면의 Audit Cancel  <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse auditCancelAGNCommAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0008Event event = (EsmAcm0008Event)e;
		AGNCommAuditBC command = new AGNCommAuditBCImpl();

		try{
			begin();
			command.auditCancelAGNCommAudit(event.getAGNCommAuditVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [ESM_ACM_0015] Reject<br>
	 * Other Commission Audit 화면의 Reject 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectOtrAGNCommAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0015Event event = (EsmAcm0015Event)e;
		OTRCommAuditBC command = new OTRCommAuditBCImpl();

		try{
			begin();
			command.rejectOtrAGNCommAudit(event.getOtrCommAuditVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [ESM_ACM_0015] Reject<br>
	 * Other Commission Audit 화면의 Audit Cancel <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse auditCancelOtrAGNCommAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0015Event event = (EsmAcm0015Event)e;
		OTRCommAuditBC command = new OTRCommAuditBCImpl();

		try{
			begin();
			command.auditCancelOtrAGNCommAudit(event.getOtrCommAuditVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [ESM_ACM_0027] Save<br>
	 * FF Compensation Audit 화면의 Reject 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFFCmpnAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0027Event event = (EsmAcm0027Event)e;
		FFCmpnAuditBC command = new FFCmpnAuditBCImpl();

		try{
			begin();
			command.manageFFCmpnAudit(event.getFfcmpnAuditVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * [ESM_ACM_0117] Retrive<br>
	 * FF Compensation Details &amp; History for B/L 기본 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFCmpnDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0117Event event = (EsmAcm0117Event)e;
		FFCmpnAuditBC command = new FFCmpnAuditBCImpl();

		try {
			List<FFCmpnDetailBasicbyBlVO> list0 = command.searchFFCmpnDetailBasicbyBlList(event.getFfCmpnDetailBasicbyBlVO());
			// list0을 ETC-DATA로 setting
			for (int i = 0; i < list0.size(); i++) {
				eventResponse.setETCData(list0.get(i).getColumnValues());
			}
			List<FFCmpnDetailHistorybyBlVO> list2 = command.searchFFCmpnDetailHistorybyBlList(event.getFfCmpnDetailBasicbyBlVO());
			eventResponse.setRsVoList(list2);
			List<FFCmpnDetailChargebyBlVO> list3 = command.searchFFCmpnDetailChargebyBlList(event.getFfCmpnDetailBasicbyBlVO());
			eventResponse.setRsVoList(list3);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_ACM_0117] Retrive<br>
	 * FF Compensation Details &amp; History for B/L 화면 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFFCmpnDetailHistorybyBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAcm0117Event event = (EsmAcm0117Event)e;
		FFCmpnAuditBC command = new FFCmpnAuditBCImpl();

		try {
			List<FFCmpnRateInfoVO> list = command.searchFFCmpnRateInfoList(event.getFfCmpnDetailHistorybyBlVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

}