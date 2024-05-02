/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CTMCommonSC.java
*@FileTitle : CTM Common Util
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon;

import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.basic.ContainerMovementValidationBC;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.basic.ContainerMovementValidationBCImpl;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.event.CtmComEvent;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration.ContainerMovementValidationDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CTMCommon Business Logic ServiceCommand - handling business transaction for OPUS-CTMCommon 
 *
 * @author KyungMin Woo
 * @see ContainerMovementValidationDBDAO
 * @since J2EE 1.4
 */
public class CTMCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding business scenario job for CTMCommon system 
	 * creating object when calling CTMCommon business scenarioCTMCommon
	 */
	public void doStart() {
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * closing CTMCommon system business scenario
	 */
	public void doEnd() {
		log.debug("CTMCommonSC 종료");
	}

	/**
	 * processing business scenarios for events
	 * handling event for OPUS--OPUS-CTMCommon system 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH21)) {
				log.debug("CTM BOOKING NUMBER CHECK");
				eventResponse = checkCtmBookingNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				log.debug("CTM BOOKING CONTAINER CHECK");
				eventResponse = checkCtmBookingContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH23)) {
				eventResponse = checkVVDCNTRAll(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH24)) {
				log.debug("야드 체크");
				eventResponse = checkYardOnly(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH25)) {
				log.debug("Service Lane 체크");
				eventResponse = checkSlan(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH26)) {
				log.debug("Office time");
				eventResponse = searchOfficeDt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH27)) {
				log.debug("Max Cycle Booking");
				eventResponse = searchMaxBkg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH28)) {
				log.debug("Prev MVMT EQR Ref No");
				eventResponse = searchPrevEqrRefNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH29)) {
				log.debug("Check EQR Ref No");
				eventResponse = checkEqrRefNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH30)) {
				log.debug("Max Cycle");
				eventResponse = searchMaxCycle(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH31)) {
				log.debug("LSTM CD");
				eventResponse = searchLstmCd(e);
			}
		}
		return eventResponse;
	}

	/**
	 * CTM : common
	 * retrieving Reason List
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
	 * CTM : common
	 * creating yard list in Combo by getting yard
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
			String ydOfc = command.checkYardOfcCode(event.getCtmCommonVO().getPYard1());
			String ofcCd = command.checkOfcCode(ydOfc, account.getOfc_cd());
			eventResponse.setETCData("svrChk", svrCd);
			eventResponse.setETCData("ofcChk", ofcCd);
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
	 * CTM : common
	 * retrieving Vender's Name(Grid Data Validation)
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
	 * CTM : common
	 * checking Yard existence
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
	 * CTM : common
	 * checking Yard existence
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkYardOnly(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkYardOnly(event.getCtmCommonVO().getPYard1());
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
	 * CTM : common
	 * checking Service Lane existence
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkSlan(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkSlan(event.getCtmCommonVO().getSlanCd());
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
	 * CTM : common
	 * retrieving Location Name
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
	 * CTM : common
	 * validating VVD with inputed Yard, VVD, Type
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
			String rtnStr = command.checkVVDCNTR(event.getCtmCommonVO().getPYard1(), event.getCtmCommonVO().getVvdcode(), event.getCtmCommonVO().getPVvdType(), event.getCtmCommonVO().getOscaBkgFlg());
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
	
	/** checkVVDCNTRAll
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkVVDCNTRAll(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkVVDCNTRAll(event.getCtmCommonVO().getVvdcode());
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
	 * CTM : common
	 * getting container no and returning contianer's status
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
	 * CTM : common
	 * getting container no & yard , returning contianer's status
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
	 * CTM : common
	 * retrieving server ID for office code
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
	 * CTM : common
	 * validating inputed booking no
	 * calling in case of OP. BKG_NO_SPLIT || CNMV_RCV_TERM || DST_YD_CD
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
	
	/** checkCtmBookingNo
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCtmBookingNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkCtmBookingNo(event.getCtmCommonVO().getPBkgNo());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - checkCtmBookingNo] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - checkCtmBookingNo] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}
	
	/** checkCtmBookingNo
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCtmBookingContainer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkCtmBookingContainer(event.getCtmCommonVO().getPCntrno(),event.getCtmCommonVO().getPBkgNo());
			eventResponse.setETCData("rtnValue", rtnStr);
		} catch(EventException ex) {
			log.error("\n\n[CommonSC - checkCtmBookingNo] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[CommonSC - checkCtmBookingNo] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}
	
	/**
	 * CTM : common
	 * getting Value(rows data) by using Value, Column, Table as parameters
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
	 * CTM : common
	 * checking value existence by using Value, Column, Table as parameters
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
	 * CTM : common
	 * validating inputed Movement Status Code from MDM_MVMT_STS 
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
	 * CTM : common
	 * validating Chassis Code
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
	 * CTM : common
	 * validating MGSet Code
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
			String rtnStr = command.searchMGSet(event.getCtmCommonVO().getPMgset());
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
	 * CTM : common
	 * checking user's cnt_cd compare to inputed yard_cd/loc_cd first 2 characters
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
	 * retrieving country code for Office code
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
	 * CTM : common
	 * searching Office Date
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOfficeDt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String locCd = command.searchUserLocCode(account.getOfc_cd());
			String rtnStr = command.searchOfficeDt(locCd);
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
	 * CTM : common
	 * searching Max Cycle Bkg
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMaxBkg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String cycNo = command.searchMaxCycle(event.getCtmCommonVO().getPCntrno());
			String rtnStr = "";
			if (cycNo.equals("") || cycNo == null) {
				rtnStr = "";
			} else {
				rtnStr = command.searchMaxBkg(event.getCtmCommonVO().getPCntrno(), cycNo);
			}
			
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
	 * CTM : common
	 * searching Prev MVMT EQR Ref No
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPrevEqrRefNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.searchPrevEqrRefNo(event.getCtmCommonVO().getPCntrno());
			
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
	 * CTM : common
	 * checking EQR Ref No
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkEqrRefNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.checkEqrRefNo(event.getCtmCommonVO().getMtyPlnNo());
			
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
	 * CTM : common
	 * search Max Cycle
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMaxCycle(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.searchMaxCycle(event.getCtmCommonVO().getPCntrno());
			
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
	 * CTM : common
	 * search Lstm Cd
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLstmCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CtmComEvent event = (CtmComEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementValidationBC command = new ContainerMovementValidationBCImpl();
		try {
			String rtnStr = command.searchLstmCd(event.getCtmCommonVO().getPCntrno());
			
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
}