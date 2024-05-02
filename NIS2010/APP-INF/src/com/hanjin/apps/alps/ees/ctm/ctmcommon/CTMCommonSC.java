/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CTMCommonSC.java
*@FileTitle : CTM Common Util
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.06 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.ctmcommon;

import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.basic.ContainerMovementValidationBC;
import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.basic.ContainerMovementValidationBCImpl;
import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.event.CtmComEvent;
import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.integration.ContainerMovementValidationDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-CTMCommon Business Logic ServiceCommand - ALPS-CTMCommon 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KyungMin Woo
 * @see ContainerMovementValidationDBDAO
 * @since J2EE 1.4
 */
public class CTMCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CTMCommon system 업무 시나리오 선행작업<br>
	 * CTMCommon업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * CTMCommon system 업무 시나리오 마감작업<br>
	 * CTMCommon 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CTMCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CTMCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("CtmComEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				log.debug("Location Name");
				eventResponse = getLocationName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				log.debug("searchReasonList");
				eventResponse = searchReasonList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				log.debug("MGSet Check");
				eventResponse = searchMGSet(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				log.debug("Chassis Check");
				eventResponse = searchChassisCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				log.debug("Movement Status Check");
				eventResponse = searchMvmtStsCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkContainerNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = checkYard(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = checkVVDCNTR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				log.debug("SvrCode Check");
				eventResponse = checkSvrCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				log.debug("야드 체크");
				eventResponse = searchYard(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				log.debug("벤더 체크");
				eventResponse = checkServiceProvider(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				log.debug("로그인 사용자의 Country코드로 Lacal코드 조회");
				eventResponse = searchUserLocalCode();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				log.debug("BOOKING NUMBER CHECK");
				eventResponse = checkBookingNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = getCodeValue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				log.debug("Value 존재유무 Check");
				eventResponse = searchCodeExist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				log.debug("Container 유무 Check");
				eventResponse = checkContainerYard(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				log.debug("Office코드로 국가코드를 조회");
				eventResponse = searchUserCntCode();
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				log.debug("File Upload");
				eventResponse = fileUpload(e);
			}
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * Reason List 조회<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReasonList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnValue = command.searchReasonList();
			eventResponse.setETCData("rtnValue", rtnValue);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - searchReasonList] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - searchReasonList] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * Yard를 얻어서 Combo에서 사용되는 YardList를 생성한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkYard(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkYard(event.getCtmCommonVO().getPYard1());
			String cntCd = command.searchUserCntCode(account.getOfc_cd());
			String svrCd = command.checkSvrCode(event.getCtmCommonVO().getPYard1(), cntCd);
			eventResponse.setETCData("svrChk", svrCd);
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - checkYard] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - checkYard] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * Vender의 Name을 조회한다. (Grid Data Validation).<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkServiceProvider(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkServiceProvider(event.getCtmCommonVO().getPVender());
			eventResponse.setETCData("rtnValue", "S");
			eventResponse.setETCData("rtnName", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - checkServiceProvider] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - checkServiceProvider] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * Yard를 존재 유무를 체크한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchYard(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.searchYard(event.getCtmCommonVO().getPYard1());
			String cntCd = command.searchUserCntCode(account.getOfc_cd());
			String svrCd = command.checkSvrCode(event.getCtmCommonVO().getPYard1(), cntCd);
			eventResponse.setETCData("svrChk", svrCd);
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - searchYard] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - searchYard] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * Location Name을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse getLocationName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.getLocationName(event.getCtmCommonVO().getPYard1());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - getLocationName] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - getLocationName] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * Yard, VVD, Type을 받아서 VVD가 존재하는지 체크한다. 성공 S.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkVVDCNTR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkVVDCNTR(event.getCtmCommonVO().getPYard1(), event.getCtmCommonVO().getVvdcode(), event.getCtmCommonVO().getPVvdType());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - checkVVDCNTR] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - checkVVDCNTR] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * 컨테이너 번호를 읽어오고 해당하는 컨테이너의 상태등을 리턴한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkContainerNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkContainerNo(event.getCtmCommonVO().getPCntrno(), "");
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - checkContainerNo] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - checkContainerNo] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * 컨테이너와 야드정보를 읽어오고 해당하는 컨테이너의 상태등을 리턴한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkContainerYard(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkContainerYard(event.getCtmCommonVO().getPCntrno(), event.getCtmCommonVO().getPYard1());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - checkContainerYard] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - checkContainerYard] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * Office코드로 서버아이디를 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUserLocalCode() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String cntCd = command.searchUserCntCode(account.getOfc_cd());
			String rtnStr = command.searchUserLocalCode(cntCd);
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - searchUserLocalCode] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - searchUserLocalCode] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * 넘겨받은 Booking No를 Validation한다.<br>
	 * OP일경우호출. BKG_NO_SPLIT || CNMV_RCV_TERM || DST_YD_CD
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkBookingNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkBookingNo(event.getCtmCommonVO().getPBkgNo());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - checkBookingNo] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - checkBookingNo] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * Value, Column, Table을 Param으로 받아서 Value(rows data)를 가져옴<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse getCodeValue(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.getCodeValue(event.getCtmCommonVO());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - getCodeValue] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - getCodeValue] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * Value, Column, Table을 Param으로 받아서 Value가 존재하는지 Check.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCodeExist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.searchCodeExist(event.getCtmCommonVO());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - searchCodeExist] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - searchCodeExist] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * MDM_MVMT_STS 테이블에서 사용자가 입력한 Movement Status Code의 유효성을 체크한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMvmtStsCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.searchMvmtStsCd(event.getCtmCommonVO().getMvmtStsCd());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - searchMvmtStsCd] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - searchMvmtStsCd] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * Chassis Code의 유효성을 체크한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchChassisCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.searchChassisCd(event.getCtmCommonVO().getPChassisNo());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - searchChassisCd] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - searchChassisCd] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * MGSet Code의 유효성을 체크한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMGSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.searchMGSet(event.getCtmCommonVO().getPMGSet());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - searchMGSet] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - searchMGSet] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * CTM : 공통
	 * 입력된 yard_cd/loc_cd의 앞2자리와 사용자 cnt_cd가 맞는지 체크한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkSvrCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String cntCd = command.searchUserCntCode(account.getOfc_cd());
			String rtnStr = command.checkSvrCode(event.getCtmCommonVO().getPYard1(), cntCd);
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - checkSvrCode] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - checkSvrCode] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * Office코드로 국가코드를 조회<br>
	 *
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUserCntCode() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.searchUserCntCode(account.getOfc_cd());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - searchUserCntCode] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - searchUserCntCode] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * File Upload 처리
	 * @param event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse fileUpload(Event event) throws EventException {
		CtmComEvent ctmComEvent = (CtmComEvent)event;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse.setETCData("fileSaveId", ctmComEvent.getFilekeys().get(0));
		} catch(Exception e) {
			log.error("\n\n[CommonSC - fileUpload] Exception :  " + e.getMessage(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}

		return eventResponse;
	}
}