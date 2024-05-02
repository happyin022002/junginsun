/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : INVCommonSC.java
 *@FileTitle : INVCommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.04.24 김세일
 * 1.0 Creation
 * History
 =========================================================*/
package com.clt.apps.opus.fns.inv.invcommon;

import java.util.List;

import com.clt.apps.opus.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.event.InvCommonEvent;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.integration.INVCommonDBDAO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ARCustomerVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.CodeInputVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmChargeVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;

/**
 * INVCommon Business Logic ServiceCommand 
 * - INVCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author saeil kim
 * @see INVCommonDBDAO
 * @since J2EE 1.4
 */
public class INVCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
 
	/**
	 * INVCommon system 업무 시나리오 선행작업<br>
	 * INVCommon업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * INVCommon system 업무 시나리오 마감작업<br>
	 * INVCommon 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("INVCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * INVCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("InvCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchServiceScopeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAROfficeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchARCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAccountRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchExchangeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchVesslName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchSADate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchSailingDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchEffectiveDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchARPrinterName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchCurrencyCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchChargeCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchSvcLaneCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchLocalTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchARCustomerByCustRgstNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchCodeInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchLatestRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {	//VVD information
				eventResponse = searchVslName(e);
			}
		}
		return eventResponse;
	}

	
	/**
	 * Scope 조회 이벤트 처리<br>
	 * INVCommon의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeList(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<String> list = command.searchServiceScopeList();

			StringBuffer svcCd = new StringBuffer("ALL");
			for (int i = 0; i < list.size(); i++) {
				svcCd.append("|").append(list.get(i));
			}
			svcCd.append("|").append("OTH");
			eventResponse.setETCData("svc_scp_cd1", svcCd.toString());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * AR Office 조회 이벤트 처리<br>
	 * UI PAGE TYPE별 사용가능한 A/R Office 리스트(오피스별 기본정보 포함)
	 * INQ 화면인 경우 User ID 소속의 RHQ내의 A/R Office 전체를 조회한다.<br>
	 * ENTRY 화면인 경우 User ID 소속의 A/R Office만 조회한다.<br>
	 * KOR 인 경우 RHQ내의 A/R Office 전체를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROfficeList(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<String> list = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());

			StringBuffer arOfcInfo = new StringBuffer("");
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					arOfcInfo.append("|").append(list.get(i));
				}
				eventResponse.setETCData("ar_ofc_cd", arOfcInfo.toString());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00075").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * AR Customer 조회 이벤트 처리<br>
	 * AccountReceivableInvoiceMasterDataMgt event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARCustomer(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String cntryCd = event.getCntryCd().trim();
			String custCd = event.getCustCd().trim();
			String custRgstNo = "";

			ARCustomerVO arCustomerVO = command.searchARCustomer(cntryCd, custCd, custRgstNo);

			// 조회된 유저 유무 체크
			if (arCustomerVO != null) {
				// 삭제된 유저 체크 (Entry에서만 체크)
				if (event.getPageType() != null && event.getPageType().equals("E")) {
					if (!arCustomerVO.getDeltFlg().equals("Y")) {
						eventResponse.setETCData(arCustomerVO.getColumnValues());
					} else {
						eventResponse.setUserMessage(new ErrorHandler("INV00060").getUserMessage());
					}
				} else {
					eventResponse.setETCData(arCustomerVO.getColumnValues());
				}
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00008").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 currency List에 해당되는 값을 불러온다.<br>
	 * INVCommon event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author saeil kim
	 */
	private EventResponse searchCurrencyCodeList(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<MdmCurrencyVO> currList = command.searchCurrencyCodeList();

			StringBuffer currInfo = new StringBuffer("");
			for (int i = 0; i < currList.size(); i++) {
				currInfo.append("|").append(currList.get(i).getCurrCd());
			}

			eventResponse.setETCData("currInfo", currInfo.toString());
			// eventResponse.setRsVoList(currList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 경리환율 해당되는 값을 불러온다.<br>
	 * INVCommon event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author saeil kim
	 */
	private EventResponse searchAccountRate(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String from_currCd = event.getFromCurrCd();
			String to_currCd = event.getToCurrCd();
			String effDt = event.getEffDt();

			String usd_locl_xch_rt = command.searchAccountRate(from_currCd, to_currCd, effDt);

			eventResponse.setETCData("usd_locl_xch_rt", usd_locl_xch_rt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 charge List에 해당되는 값을 불러온다.<br>
	 * INVCommon event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author junght
	 */
	private EventResponse searchChargeCodeList(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		List<MdmChargeVO> chgCodeList = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			chgCodeList = command.searchChargeCodeList();
			StringBuffer chgCodeInfo = new StringBuffer("");
			for (int i = 0; i < chgCodeList.size(); i++) {
				if (!chgCodeList.get(i).getChgCd().trim().equals("")) {
					chgCodeInfo.append("|").append(chgCodeList.get(i).getChgCd());
				}
			}

			eventResponse.setETCData("chg_cd", chgCodeInfo.toString());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 Ex.Rate에 해당되는 값을 불러온다.<br>
	 * INVCommon event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author junght
	 */
	private EventResponse searchExchangeRate(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			ExchangeRateVO exchangeRateVo = command.searchExchangeRate(event.getVvdCustomerVo());
			eventResponse.setETCData(exchangeRateVo.getColumnValues());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * INVCommon의 event에 대한 vsl_eng_nm 조회 이벤트 처리<br>
	 * 
	 * @author Jung Hwi Taek
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesslName(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String vvd = event.getVvd().trim();
			String vslEngNm = command.searchVesslName(vvd);

			eventResponse.setETCData("vsl_eng_nm", vslEngNm);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * INVCommon의 event에 대한 S/A Date 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSADate(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String vvd = event.getVvd().trim();
			String port = event.getPort().trim();
			String bnd = event.getBnd().trim();

			String saDt = command.searchSADate(vvd, port, bnd);

			eventResponse.setETCData("sail_arr_dt", saDt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * INVCommon의 event에 대한 Sailing Date 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSailingDate(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String bkgNo = event.getBkgNo().trim();

			String sailDt = command.searchSailingDate(bkgNo);

			eventResponse.setETCData("sail_dt", sailDt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * INVCommon의 event에 대한 Effective Date 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEffectiveDate(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String ofcCd = event.getOfcCd().trim();
			String sailDt = event.getSailDt().trim();

			String effDt = command.searchEffectiveDate(ofcCd, sailDt);

			eventResponse.setETCData("eff_dt", effDt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * INVCommon의 event에 대한 Effective Date 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARPrinterName(Event e) throws EventException {
		//InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			//String ofcCd = event.getOfcCd().trim();
			String ofcCd = account.getOfc_cd();
			String userId = account.getUsr_id();

			String invPrnDvcNm = command.searchARPrinterName(ofcCd, userId);

			eventResponse.setETCData("inv_prn_dvc_nm", invPrnDvcNm);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * INVCommon의 event에 대한 Lane 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcLaneCode(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String lane = command.searchSvcLaneCode(event.getLane());
			eventResponse.setETCData("lane", lane);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Local Time을 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalTime(Event e) throws EventException {
		//InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String effDt = command.searchLocalTime(account.getOfc_cd());
			eventResponse.setETCData("lcl_time", effDt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * AR Customer 조회 이벤트 처리<br>
	 * AccountReceivableInvoiceMasterDataMgt event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARCustomerByCustRgstNo(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String cntryCd = event.getCntryCd().trim();
			String custCd = event.getCustCd().trim();
			String custRgstNo = event.getCustRgstNo().trim();

			ARCustomerVO arCustomerVO = command.searchARCustomer(cntryCd, custCd, custRgstNo);

			// 조회된 유저 유무 체크
			if (arCustomerVO != null) {
				// 삭제된 유저 체크 (Entry에서만 체크)
				if (event.getPageType() != null && event.getPageType().equals("E")) {
					if (!arCustomerVO.getDeltFlg().equals("Y")) {
						eventResponse.setETCData(arCustomerVO.getColumnValues());
					} else {
						eventResponse.setUserMessage(new ErrorHandler("INV00060").getUserMessage());
					}
				} else {
					eventResponse.setETCData(arCustomerVO.getColumnValues());
				}
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00008").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	
	
	/**
	 * code Description 가져오기<br>
	 * AccountReceivableInvoiceMasterDataMgt event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeInfo(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CodeInputVO inputVO = new CodeInputVO();
		CodeInputVO returnVO = new CodeInputVO();
		
		try {
		
			inputVO = event.getCodeInputVO();
			
			returnVO = command.searchCodeInfo(inputVO);
			
			// 조회된 유저 유무 체크
			if (returnVO != null) {
             // code가 있는지 check
		     eventResponse.setETCData("code_desc", returnVO.getCodeDesc());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00008").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 가장 최근의 환율 데이터를 가져온다.<br>
	 * INVCommon event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author KIM OK RYE
	 */
	private EventResponse searchLatestRate(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String from_currCd = event.getFromCurrCd();
			String to_currCd = event.getToCurrCd();
			String ar_ofc_cd = event.getArOfcCd();

			String[] rtnVal = command.searchLatestRate(from_currCd, to_currCd, ar_ofc_cd);

			if (rtnVal != null && rtnVal.length == 2) { 
				eventResponse.setETCData("O_INV_XCH_RT", rtnVal[0]);
				eventResponse.setETCData("I_INV_XCH_RT", rtnVal[1]);
			} else {
				eventResponse.setETCData("O_INV_XCH_RT", "NO_DATA");
				eventResponse.setETCData("I_INV_XCH_RT", "NO_DATA");
			}
    		
    		
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Vessel Name 조회 <br>
	 * INVCommon event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author KIM OK RYE
	 */
	private EventResponse searchVslName(Event e) throws EventException {
		InvCommonEvent event = (InvCommonEvent) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String vvd = event.getVvd();
			
			String rtnVal = command.searchVslName(vvd);
			if ( rtnVal == null || rtnVal.equals("") ) rtnVal = "";
			eventResponse.setETCData("vsl_name", rtnVal);			
    		
    		
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
}