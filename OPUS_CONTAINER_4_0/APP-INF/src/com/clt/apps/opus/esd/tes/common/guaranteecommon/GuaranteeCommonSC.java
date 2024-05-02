/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GuaranteeCommonSC.java
 *@FileTitle : GuaranteeCommon
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.common.guaranteecommon;

import java.util.List;

import com.clt.apps.opus.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBC;
import com.clt.apps.opus.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBCImpl;
import com.clt.apps.opus.esd.tes.common.guaranteecommon.event.EsdTes2004Event;
import com.clt.apps.opus.esd.tes.common.guaranteecommon.event.GuaranteeCommonEvent;
import com.clt.apps.opus.esd.tes.common.guaranteecommon.integration.GuaranteeCommonDBDAO;
import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBC;
import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.basic.TPBInterfaceBC;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TesGnteCntrListVO;

/**
 * GuaranteeCommon Business Logic ServiceCommand -- Handling business transaction for GuaranteeCommon
 * 
 * @author yOng hO lEE
 * @see GuaranteeCommonDBDAO
 * @since J2EE 1.6
 */

public class GuaranteeCommonSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * GuaranteeCommon system preceding process for biz scenario<br>
	 * preceding process for biz scenario<br>
	 */
	public void doStart() {
		log.debug("GuaranteeCommonSC 시작");
		try {
			// comment --> Login Check
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * GuaranteeCommon system Handling for the end of working scenario<br>
	 * Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		log.debug("GuaranteeCommonSC 종료");
	}

	/**
	 * GuaranteeCommon system Handling working scenario of each event<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		/* Guarantee Reference No */
		if (e.getEventName().equalsIgnoreCase("EsdTes2004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// Reference No. Select
				eventResponse = searchRefNoList(e);
			}
		}

		/* Guarantee Common */
		if (e.getEventName().equalsIgnoreCase("GuaranteeCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// Guarantee Container Info ( Bkg No, Bl No, VVD ) Search
				eventResponse = searchUSGuaranteeCntrInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				// Customer Code Valid Check
				eventResponse = validateCustomerCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				// NonTPB Delete Flag Check
				eventResponse = checkNonTPB(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				// Container No. Duplication Check.
				eventResponse = checkDupCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				// Guarantee Container Booking No Search => SEARCH01
				eventResponse = searchCntrBkgNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				// Validate Office Code
				eventResponse = validateOfficeCode(e);
			}

		}
		return eventResponse;
	}

	/**
	 * ESD_TES_2004 : [Event]<br>
	 * Search [Reference No(Guarantee No. Or Irregular No.)]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRefNoList(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchRefNoList] \n");
		GuaranteeCommonBC command = new GuaranteeCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2004Event event = (EsdTes2004Event) e;

		try {
			eventResponse.setRsVoList(command.searchRefNoList(event.getGuaranteeCommonVO()));
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * GuaranteeCommon : [Event]<br>
	 * Search [Guarantee Container Info]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSGuaranteeCntrInfo(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchUSGuaranteeCntrInfo] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC command = new GuaranteeCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GuaranteeCommonEvent event = (GuaranteeCommonEvent) e;

		try {
			eventResponse.setRs(command.searchUSGuaranteeCntrInfo(event.getGuaranteeCommonVO()));

			eventResponse.setETCData("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid());

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * GuaranteeCommon : [Event]<br>
	 * Search [Customer Code Validate]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateCustomerCode(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][validateCustomerCode] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC command = new GuaranteeCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GuaranteeCommonEvent event = (GuaranteeCommonEvent) e;

		try {
			eventResponse.setRs(command.validateCustomerCode(event.getGuaranteeCommonVO()));

			eventResponse.setETCData("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid());

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * GuaranteeCommon : [Event]<br>
	 * Search [TPB I/F Delete Flag]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkNonTPB(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][checkNonTPB] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC command = new GuaranteeCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GuaranteeCommonEvent event = (GuaranteeCommonEvent) e;

		TPBInterfaceBC tpbIfCommand = new TPBInterfaceBCImpl();
		List<TesGnteCntrListVO> list = null;
		TesGnteCntrListVO tesGnteCntrListVO = null;
		TPBInterfaceVO[] tpbInterfaceVOs = null;
		String[] tpbResult = null;
		// String retStr = "";
		StringBuffer retStrBuf = new StringBuffer();

		try {
			list = command.checkNonTPB(event.getTesGnteCntrListVO());

			tpbInterfaceVOs = new TPBInterfaceVO[list.size()];

			for (int i = 0; list != null && i < list.size(); i++) {
				tesGnteCntrListVO = (TesGnteCntrListVO) list.get(i); // new TPBInterfaceVO();
				tpbInterfaceVOs[i] = new TPBInterfaceVO();

				tpbInterfaceVOs[i].setTmlIfOfcCd(tesGnteCntrListVO.getTmlIfOfcCd());
				tpbInterfaceVOs[i].setTmlIfSeq(tesGnteCntrListVO.getTmlIfSeq());
			}

			tpbResult = tpbIfCommand.searchTpbTesDltFlg(tpbInterfaceVOs);

			for (int i = 0; tpbResult != null && i < tpbResult.length; i++) {
				// if ( retStr.length() > 0 ) retStr = retStr + "|";
				// retStr = retStr + tpbResult[i];

				retStrBuf.append("|").append(tpbResult[i]);
			}

			eventResponse.setETCData(event.getGuaranteeCommonVO().getOid(), retStrBuf.toString());

			// eventResponse.setETCData("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid() );

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * GuaranteeCommon : [Event]<br>
	 * Check [Container No. Duplication]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDupCntr(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchCntrBkgNo] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC command = new GuaranteeCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GuaranteeCommonEvent event = (GuaranteeCommonEvent) e;

		// boolean isSuccess = false;

		try {
			// isSuccess = command.checkDupCntr ( event.getGuaranteeCommonVO() );

			eventResponse.setETCData("success_flg", String.valueOf(command.checkDupCntr(event.getGuaranteeCommonVO())));

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * GuaranteeCommon : [Event]<br>
	 * Search [Guarantee Container Booking No]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrBkgNo(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchCntrBkgNo] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC command = new GuaranteeCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GuaranteeCommonEvent event = (GuaranteeCommonEvent) e;

		try {
			eventResponse.setRs(command.searchCntrBkgNo(event.getGuaranteeCommonVO()));
			eventResponse.setETCData("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid());

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * GuaranteeCommon : [Event]<br>
	 * Validate [Office code]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateOfficeCode(Event e) throws EventException {
		EventResponse eventResponse = null;
		GuaranteeCommonEvent event = (GuaranteeCommonEvent) e;

		try {
			GuaranteeCommonBC command = new GuaranteeCommonBCImpl();
			eventResponse = command.validateOfficeCode(event.getTesGnteHdrVO());

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

}