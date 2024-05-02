/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsDeclarationCommonMgtSC.java
 *@FileTitle : CustomsDeclarationCommonMgtSC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.1
 * 1.0 Creation
=======================================================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event.BkgCstmsCommonEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event.EsmBkg1513Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event.EsmBkg200101Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event.EsmBkg2001Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event.EsmBkg2002Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.event.EsmBkg2003Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.BkgCstmsCommonReturnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvSeqVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsErrCdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsPckTpConvVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclaration Business Logic ServiceCommand -
 * OPUS-CustomsDeclaration에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationCommonMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclaration system 업무 시나리오 선행작업<br>
	 * ESM_BKG-0017업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclaration system 업무 시나리오 마감작업<br>
	 * ESM_BKG-0017 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationCommonMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CustomsDeclaration system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("BkgCstmsCommonEvent")) {
			eventResponse = getMdmYardInfo(e);

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg2001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsCdConvDescList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCstmsCdConvDesc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageCstmsCdConvCtnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCstmsCdConvCtntList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkCstmsCdConvDesc(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg200101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsCdConvSeqDescList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCstmsCdConvSeqCtnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCstmsCdConvSeqCtntList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg2002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsPckTpConvList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsPckTpConv(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCstmsPckTpConv(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkPckTpCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCstmsCdConvCtntList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg2003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsAdvErrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsAdvErr(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1513Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsEmlNtfc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsEmlNtfc(e);
			}
		}
		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * [Common]
	 * Searching MDM_YARD information.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getMdmYardInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();
		BkgCstmsCommonEvent event = (BkgCstmsCommonEvent) e;

		try {
			List<BkgCstmsCommonReturnVO> list = command.getCodeValue(event.getBkgCstmsCommonInputVO());
			if (list.size() > 0) {
				eventResponse.setETCData(list.get(0).getColumnValues());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2001 : IBSEARCH searching Country Code, Customs Division ID, * Customs Code Description
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCstmsCdConvDescList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2001Event event =(EsmBkg2001Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			List<CstmsCdConvVO> list = command.searchCstmsCdConvDescList(event.getCstmsCdConvVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2001 : SEARCH01 searching Country Code, Customs Division ID, * Attribute Content information
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCstmsCdConvDesc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2001Event event =(EsmBkg2001Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			begin();
			command.manageCstmsCdConvDesc(event.getCstmsCdConvVOs(), account);
			commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2001 : MULTI02 <br>
	 * managing information of Country Code, Customs Division ID, Attribute
	 * Content<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCstmsCdConvCtnt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2001Event event =(EsmBkg2001Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			begin();
			command.manageCstmsCdConvCtnt(event.getCstmsCdConvVOs(), account);
			commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2001 : SEARCH02 searching duplication of Country Code, Customs
	 * Division ID
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCstmsCdConvCtntList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg2001Event")) {

				EsmBkg2001Event event =(EsmBkg2001Event) e;
				CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();
				List<CstmsCdConvVO> list = command.searchCstmsCdConvCtntList(event.getCstmsCdConvVO());
				eventResponse.setRsVoList(list);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg2002Event")) {

				EsmBkg2002Event event =(EsmBkg2002Event) e;
				CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();
				List<CstmsCdConvVO> list = command.searchCstmsCdConvCtntList(event.getCstmsCdConvVO());
				eventResponse.setRsVoList(list);

			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2001 : MULTI01 <br>
	 * managing information of Country Code, Customs Division ID, Customs Code
	 * Description <br>
	 *
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCstmsCdConvDesc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2001Event event =(EsmBkg2001Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		String cntCd = null;
		String cstmsDivId = null;
		String conv_cnt = null;

		try {
			cntCd = event.getCstmsCdConvVO().getChkCntCd();
			cstmsDivId = event.getCstmsCdConvVO().getChkCstmsDivId();
			conv_cnt = command.checkCstmsCdConvDesc(cntCd, cstmsDivId);
			eventResponse.setETCData("conv_cnt", conv_cnt);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_200101 : IBSEARCH searching Country Code, Customs Division ID, * Customs Code Description
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCstmsCdConvSeqDescList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg200101Event event =(EsmBkg200101Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			List<CstmsCdConvSeqVO> list = command.searchCstmsCdConvSeqDescList(event.getcstmsCdConvSeqVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_200101 : MULTI02 <br>
	 * managing information of Country Code, Customs Division ID, Attribute
	 * Content<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCstmsCdConvSeqCtnt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg200101Event event =(EsmBkg200101Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			begin();
			command.manageCstmsCdConvSeqCtnt(event.getCstmsCdConvSeqVOs(), account);
			commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_200101 : SEARCH02 searching duplication of Country Code, Customs
	 * Division ID
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCstmsCdConvSeqCtntList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg200101Event")) {

				EsmBkg200101Event event =(EsmBkg200101Event) e;
				CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();
				List<CstmsCdConvSeqVO> list = command.searchCstmsCdConvSeqCtntList(event.getcstmsCdConvSeqVO());
				eventResponse.setRsVoList(list);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg2002Event")) {

				EsmBkg2002Event event =(EsmBkg2002Event) e;
				CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();
				List<CstmsCdConvVO> list = command.searchCstmsCdConvCtntList(event.getCstmsCdConvVO());
				eventResponse.setRsVoList(list);

			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2002 : IBSEARCH searching Country Code, Package Type Code, * Customs Package Type Code
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCstmsPckTpConvList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2002Event event =(EsmBkg2002Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			List<CstmsPckTpConvVO> list = command.searchCstmsPckTpConvList(event.getCstmsPckTpConvVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2002 : MULTI <br>
	 * managing information of Country Code, Package Type Code, Customs Package
	 * Type Code <br>
	 *
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCstmsPckTpConv(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2002Event event =(EsmBkg2002Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			begin();
			command.manageCstmsPckTpConv(event.getCstmsPckTpConvVOs(), account);
			commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2002 : SEARCH01 searching duplication of Country Code, Package
	 * Type Code, Customs Package Type Code
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCstmsPckTpConv(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2002Event event =(EsmBkg2002Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		String cntCd = null;
		String pckTpCd = null;
		String rcvrId = null;
		String pck_tp_cnt = null;

		try {
			cntCd = event.getCstmsPckTpConvVO().getChkCntCd();
			pckTpCd = event.getCstmsPckTpConvVO().getChkPckTpCd();
			rcvrId = event.getCstmsPckTpConvVO().getRcvrId();
			pck_tp_cnt = command.checkCstmsPckTpConv(cntCd, pckTpCd, rcvrId);
			eventResponse.setETCData("pck_tp_cnt", pck_tp_cnt);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2002 : SEARCH02 searching Package Type Code
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkPckTpCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2002Event event =(EsmBkg2002Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		String pckTpCd = null;
		String pck_tp_cnt1 = null;

		try {
			pckTpCd = event.getCstmsPckTpConvVO().getChkPckTpCd();
			pck_tp_cnt1 = command.checkPckTpCd(pckTpCd);
			eventResponse.setETCData("pck_tp_cnt1", pck_tp_cnt1);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2003 : IBSEARCH searching Country Code, Customs Error Code
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCstmsAdvErrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2003Event event = (EsmBkg2003Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			List<CstmsErrCdVO> list = command.searchCstmsAdvErrList(event.getCstmsErrCdVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2003 : MULTI <br>
	 * managing information Country Code, Customs Error Code <br>
	 *
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCstmsAdvErr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2003Event event = (EsmBkg2003Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			begin();
			String errChkRst = "";
			List<CstmsErrCdVO> detailList = command.manageCstmsAdvErr(event.getCstmsErrCdVOs(), account);
			if (detailList.size() > 0 ) errChkRst = "Y";
			eventResponse.setETCData("err_chk_rst", errChkRst);
			eventResponse.setRsVoList(detailList);
			commit();
		}
		catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1513] Retrive<br>
	 * Searching Manifest e-Maiil Notification List.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsEmlNtfc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();
		EsmBkg1513Event event = (EsmBkg1513Event) e;

		try {
			eventResponse.setRsVoList(command.searchCstmsEmlNtfc(event.getCstmsEmlNtfcVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_1513] Save<br>
	 * Managing Manifest e-Maiil Notification List.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsEmlNtfc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();
		EsmBkg1513Event event = (EsmBkg1513Event) e;

		try {
			begin();
			command.manageCstmsEmlNtfc(event.getCstmsEmlNtfcVOs(), account);
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
	}
// end class
