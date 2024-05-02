/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableInvoiceCreationSC.java
 *@FileTitle : Other Revenue Invoice Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.04.27 김세일
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.11.23 권 민 [CHM-201114430-01] MRI 생성 관련 CREDIT TERM 로직 보완 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.basic.AGNCommCalculationBC;
import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.basic.AGNCommCalculationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.event.Fns012R001Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ChinaVATInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ERPIfReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.OtherRevReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.event.Esm0670001Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.event.UbizhjsAlpsinvInvoicEvent;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.DOMDestInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic.ManualARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic.ManualARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.event.FnsInv0022Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.event.FnsInv0023Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.event.FnsInv0071Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.event.FnsInv0136Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration.ManualARCreationDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGContainerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingARVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.RevenueAcctVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.VvdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ARCustomerVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.ExchangeRateVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.log4j.StringUtils;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.syscommon.common.table.PriRatUtVO;

/**
 * ALPS-AccountReceivableInvoiceCreation Business Logic ServiceCommand - ALPS-AccountReceivableInvoiceCreation 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author saeil kim
 * @see ManualARCreationDBDAO
 * @since J2EE 1.4
 */
public class AccountReceivableInvoiceCreationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AccountReceivableInvoiceCreation system 업무 시나리오 선행작업<br>
	 * FNS_INV_0022업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * AccountReceivableInvoiceCreation system 업무 시나리오 마감작업<br>
	 * FNS_INV_0022 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableInvoiceCreationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-AccountReceivableInvoiceCreation system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("FnsInv0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNonShippingARByIFNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchAccountRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = searchAutoBLNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchRevenueAcctCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchBLCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createNonShippingAR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = issueOtherRevenueARInvoice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0071Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOfficeRevenueSourceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBKGMaxInterface(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchBKGNewInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchRevenueSourceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchChargeCurrencyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchLocalChargeExist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchExrateSADate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchMiscellaneousARByIFNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchLocalTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchBlckChg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchIvaRateMstIFNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchSpndVatRgstNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchSADateDueDate(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchOfcCdByUserId(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchEuCheck(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
				eventResponse = searchVvdByBkgNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createMiscellaneousAR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = searchAutoBLNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNonShippingARList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("Fns012R001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				modifyARInvoiceERPReturn(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("UbizhjsAlpsinvInvoicEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				interfaceTerminalARInvoiceToINV(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("Esm0670001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				interfaceDomesticARInvoiceToINV(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0136Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchChinaVATMiscellaneousARInvoiceData(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = createChinaVATMiscellaneousARInvoice(e);
			} else {//로딩시 환율코드 가져오기 SEARCH
				eventResponse = searchChargeCurrencyList(e);
			}
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0022 : Retrieve<br>
	 * 기 생성된 비해운 운임 data 를 I/F No 로 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNonShippingARByIFNo(Event e) throws EventException {
		FnsInv0022Event event = (FnsInv0022Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			NonShippingARVO nonShippingARVO = new NonShippingARVO();

			// 입력한 I/F No 의 비해운 운임수입 매출채권 정보를 조회한다.
			nonShippingARVO = command.searchNonShippingARByIFNo(event.getArIfNo());

			if (nonShippingARVO != null) {
				eventResponse.setRsVo(nonShippingARVO.getNonShippingMainVO());
				eventResponse.setRsVoList(nonShippingARVO.getNonShippingChargeVOS());

				eventResponse.setETCData("dp_prcs_knt", nonShippingARVO.getNonShippingMainVO().getDpPrcsKnt());
				eventResponse.setETCData("dp_prcs_knt_lcl", nonShippingARVO.getNonShippingMainVO().getDpPrcsKntLocal());
			} else {
				nonShippingARVO = new NonShippingARVO();

				eventResponse.setRsVo(nonShippingARVO.getNonShippingMainVO());
				eventResponse.setRsVoList(nonShippingARVO.getNonShippingChargeVOS());

				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("dp_prcs_knt_lcl", "0");

				eventResponse.setUserMessage(new ErrorHandler("INV00095").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0071 : onLoad <br>
	 * AR Office, Rev. Type을 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeRevenueSourceList(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		FnsInv0071Event event = (FnsInv0071Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<String> list = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());

			String ar_ofc_info = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			
			for (int i = 0; i < list.size(); i++) {
				arOfcInfoBuff.append("|" + list.get(i));
				//ar_ofc_info = ar_ofc_info + "|" + list.get(i);
			}
			ar_ofc_info = arOfcInfoBuff.toString();

			eventResponse.setETCData("ar_ofc_cd", ar_ofc_info);

			ManualARCreationBC command2 = new ManualARCreationBCImpl();

			String ar_ofc_info_1 = list.get(0);

			String[] result = StringUtils.delimitedListToStringArray(ar_ofc_info_1, "^");

			String rhqCd = result[0];
			String arOfcCd = result[3];
			//String ofcCd = result[1];
			String ofcCd = event.getSignOnUserAccount().getOfc_cd();
			String svrId = result[7];
			log.debug("arOfcCd="+arOfcCd);
			List<String> list2 = command2.searchOfficeRevenueSourceList(svrId, rhqCd, arOfcCd);

			String rev_type = "";
			StringBuffer revTypeBuff = new StringBuffer();

			for (int i = 0; i < list2.size(); i++) {
				revTypeBuff.append("|" + list2.get(i));
				//rev_type = rev_type + "|" + list2.get(i);
			}
			rev_type = revTypeBuff.toString();
			
			if(account.getOfc_cd().equals("HAMRUG")){
				rev_type = rev_type + "|TV";
			}
			
			eventResponse.setETCData("rev_tp_cd", rev_type);
			
			String localTime = command2.searchLocalTime(ofcCd);
			
			eventResponse.setETCData("local_time", localTime);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0071 : onLoad <br>
	 * AR Office, Rev. Type을 조회 합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenueSourceList(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command2 = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String rhqCd = event.getRhqCd();
			String ofcCd = event.getOfcCd();
			//String ofcCd = event.getSignOnUserAccount().getOfc_cd();
			String svrId = event.getSvrId();
			
			log.info("\n########## rhqCd1 : "+rhqCd);
			log.info("\n########## ofcCd1 : "+ofcCd);
			log.info("\n########## svrId1 : "+svrId);

			List<String> list2 = command2.searchOfficeRevenueSourceList(svrId, rhqCd, ofcCd);

			String revSrcCd = "";
			StringBuffer revSrcCdBuff = new StringBuffer();

			for (int i = 0; i < list2.size(); i++) {
				revSrcCdBuff.append("|" + list2.get(i));
				//revSrcCd = revSrcCd + "|" + list2.get(i);
			}
			revSrcCd = revSrcCdBuff.toString();
			
			if(account.getOfc_cd().equals("HAMRUG")){
				revSrcCd = revSrcCd + "|TV";
			}

			eventResponse.setETCData("rev_src_cd", revSrcCd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * Max Interface 조회 이벤트 처리<br>
	 * FnsInv0071Event event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKGMaxInterface(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		INVCommonUtil command2 = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String cntryCd = "";
			String custCd = "";

			String svrId = event.getSvrId();
			String blNo = event.getBlNo();
			String ofcCd = event.getOfcCd();
			String locCd = event.getLocCd().substring(0, 2);

			List<BKGInvoiceVO> list = command.searchBKGMaxInterface(svrId, ofcCd, blNo, locCd);
			List<BKGContainerVO> list2 = null;
			ARCustomerVO arCustomerVO = null;
			BKGInvoiceVO bkgInvoiceVo = null;

			// MaxInterface 정보
			for (int i = 0; i < list.size(); i++) {
				eventResponse.setETCData(list.get(i).getColumnValues());
			}

			if (list.size() > 0) {
				// Customer 정보
				cntryCd = eventResponse.getETCData("act_cust_cnt_cd");
				custCd = eventResponse.getETCData("act_cust_seq");
				//arCustomerVO = command2.searchARCustomer(cntryCd, Long.parseLong(custCd));
				arCustomerVO = command2.searchARCustomer(cntryCd, custCd, "");
				if(arCustomerVO != null) {
					eventResponse.setETCData(arCustomerVO.getColumnValues());
				}

				// Container 정보
				bkgInvoiceVo = list.get(0);
				list2 = bkgInvoiceVo.getBkgContainerVo();
				eventResponse.setRsVoList(list2);

			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
		return eventResponse;
	}

	/**
	 * Max Interface 조회 이벤트 처리<br>
	 * FnsInv0071Event event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKGNewInvoice(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		INVCommonUtil command2 = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String cntryCd = "";
			String custCd = "";

			List<BKGInvoiceVO> list = command.searchBKGNewInvoice(event.getMriInputVO());
			List<BKGContainerVO> list2 = null;
			ARCustomerVO arCustomerVO = null;
			BKGInvoiceVO bkgInvoiceVo = null;

			// MaxInterface 정보
			for (int i = 0; i < list.size(); i++) {
				eventResponse.setETCData(list.get(i).getColumnValues());
			}

			if (list.size() > 0) {
				// Customer 정보
				cntryCd = eventResponse.getETCData("act_cust_cnt_cd");
				custCd = eventResponse.getETCData("act_cust_seq");

				//arCustomerVO = command2.searchARCustomer(cntryCd, Long.parseLong(custCd));
				arCustomerVO = command2.searchARCustomer(cntryCd, custCd, "");
				if (arCustomerVO!= null) {
					eventResponse.setETCData(arCustomerVO.getColumnValues());
				}

				// Container 정보
				bkgInvoiceVo = list.get(0);
				list2 = bkgInvoiceVo.getBkgContainerVo();
				eventResponse.setRsVoList(list2);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * charge 조회 및 currency list 이벤트 처리<br>
	 * ARInvoiceCustomerMgt event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * INVCommon의 bc 이용
	 * 
	 * @author junght
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeCurrencyList(Event e) throws EventException {
//		FnsInv0071Event event = (FnsInv0071Event) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			//2010-06-18 ofc 상관없이 Chg_cd 전부 가져오게 변경
			//List<MdmChargeVO> chgList = command.searchChargeCodeList(event.getOfcCd());
			List<MdmChargeVO> chgList = command.searchChargeCodeList();
			List<MdmCurrencyVO> currList = command.searchCurrencyCodeList();
			List<PriRatUtVO> perList = command.searchPerTpCdList();

			String chgInfo = "";
			String currInfo = "";
			String perInfo = "";
			StringBuffer chgInfoBuff = new StringBuffer();
			StringBuffer currInfoBuff = new StringBuffer();
			StringBuffer perInfoBuff = new StringBuffer();

			for (int i = 0; i < chgList.size(); i++) {
				chgInfoBuff.append("|" + chgList.get(i).getChgCd());
				//chgInfo = chgInfo + "|" + chgList.get(i).getChgCd();
			}
			chgInfo = chgInfoBuff.toString();

			for (int i = 0; i < currList.size(); i++) {
				currInfoBuff.append("|" + currList.get(i).getCurrCd() + "^" + currList.get(i).getDpPrcsKnt());
				//currInfo = currInfo + "|" + currList.get(i).getCurrCd() + "^" + currList.get(i).getDpPrcsKnt();
			}
			currInfo = currInfoBuff.toString();
			
			for (int i = 0; i < perList.size(); i++) {
				perInfoBuff.append("|" + perList.get(i).getRatUtCd());
				//perInfo = perInfo + "|" + perList.get(i).getRatUtCd();
			}
			perInfo = perInfoBuff.toString();

			eventResponse.setETCData("chgInfo", chgInfo);
			eventResponse.setETCData("currInfo", currInfo);
			eventResponse.setETCData("perInfo", perInfo);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * Local Charge 조회 <br>
	 * ARInvoiceCustomerMgt event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @author junght
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalChargeExist(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String existYn = "N";
		
		try {
			
			if (command.searchLocalChargeExist(event.getChgCd(), event.getOfcCd())) {
				existYn = "Y";
			}

			eventResponse.setETCData("exist_yn", existYn);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * INVCommon화면에 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * INVCommon event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author junght
	 */
	private EventResponse searchExrateSADate(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {			
			String vsl = "";
			String voy = "";
			String dep = "";
			String bnd = "";
			String pol = "";
			String pod = "";
			String port = "";
			
			String saDate = "";
			
			log.info("\n########## event.getSvrId() : "+event.getSvrId());
			
			ExchangeRateVO exchangeRateVo = command.searchExchangeRate(event.getVvdCustomerVo());

			eventResponse.setETCData(exchangeRateVo.getColumnValues());

			vsl = event.getVvdCustomerVo().getVsl();
			voy = event.getVvdCustomerVo().getVoy();
			dep = event.getVvdCustomerVo().getDep();
			bnd = event.getVvdCustomerVo().getBnd();
			pol = event.getVvdCustomerVo().getPol();
			pod = event.getVvdCustomerVo().getPod();

			if (bnd.equals("O")) {
				port = pol;
			} else if (bnd.equals("I")) {
				port = pod;
			}

			saDate = command.searchSADate(vsl + voy + dep, port, bnd);

			eventResponse.setETCData("sa_date", saDate);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * MiscellaneousAR 생성 이벤트 처리<br>
	 * FnsInv0071Event event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMiscellaneousAR(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvArMnVO invMain = null;
		try {
			FnsInv0071Event event = (FnsInv0071Event) e;

			ManualARCreationBC command = new ManualARCreationBCImpl();
			BookingARCreationBC command2 = new BookingARCreationBCImpl();
			AGNCommCalculationBC command3 = new AGNCommCalculationBCImpl();
			
			List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
			InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
			
			String vsl = event.getVvdCustomerVo().getVsl();
			String voy = event.getVvdCustomerVo().getVoy();
			String dep = event.getVvdCustomerVo().getDep();
			String bnd = event.getVvdCustomerVo().getBnd();
			String pol = event.getVvdCustomerVo().getPol();
			String pod = event.getVvdCustomerVo().getPod();
			String del = event.getVvdCustomerVo().getDel();
			String por = event.getVvdCustomerVo().getPor();
			String scp = event.getVvdCustomerVo().getSvcScp();
			
			String port = "";
			
			begin();
			
			if (bnd.equals("O")) {
				port = pol;
			} else if (bnd.equals("I")) {
				port = pod;
			}		
			if(pol != null && !pol.equals("")){
				command.checkPort(pol);
			}
			if(pod != null && !pod.equals("")){
				command.checkPort(pod);
			}
			if(del != null && !del.equals("")){
				command.checkPort(del);
			}
			if(por != null && !por.equals("")){
				command.checkPort(por);
			}
			
//			String effDt = "";
//			String clzStsCd = "";
			
//			if (event.getARInvoiceCreationVO().getRevSrcCd().equals("TM") || event.getARInvoiceCreationVO().getRevSrcCd().equals("TN")) {
//				
//				effDt = event.getARInvoiceCreationVO().getEffDt().replaceAll("-", "");	
//				log.info("\n########## effDt111 : "+effDt);
//				
//				clzStsCd = command.searchClosingStatus(event.getARInvoiceCreationVO().getOfcCd(), effDt, "M");
//
//				if (!clzStsCd.equals("O")) {
//					eventResponse.setUserMessage(new ErrorHandler("INV00015").getMessage());
//					return eventResponse;
//				}
//				
//			}	
			
			if (!vsl.equals("CFDR") && !vsl.equals("USAC") && !vsl.equals("CNTC")) { 			
				command.checkMiscellaneousAR(vsl, voy, dep, port, scp);
			}
			
			//if (event.getVvdCustomerVo().getArIfNo() == null || event.getVvdCustomerVo().getArIfNo().equals("")) {
			if (!event.getARInvoiceCreationVO().getRevSrcCd().equals("TM")) {	
				invMain = command2.createMiscellaneousARInvoice(event.getARInvoiceCreationVO(), account.getUsr_id());
				
				if(!invMain.getArIfNo().equals("")){
					invArIfNoVO = new InvArIfNoVO();
					invArIfNoVO.setIfNo(invMain.getArIfNo());
					ifNos.add(invArIfNoVO);
				}
				
				eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());				
			
			} else {				
				
				invMain = command2.modifyMiscellaneousARInvoice(event.getARInvoiceCreationVO(), event.getVvdCustomerVo().getArIfNo(), account.getUsr_id());
				
				if(!invMain.getArIfNo().equals("")){
					invArIfNoVO = new InvArIfNoVO();
					invArIfNoVO.setIfNo(invMain.getArIfNo());
					ifNos.add(invArIfNoVO);
				}
				
				eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
				
			}
			
			//2017.09.05 ACM Charge Commission 관련 추가
			if(event.getARInvoiceCreationVO().getBkgNo() != null && !("").equals(event.getARInvoiceCreationVO().getBkgNo())){
				command3.addCalcBatchByINV(event.getARInvoiceCreationVO().getBkgNo(), "INV_MRI");
			}
			
			commit();
			
			begin();
			
			if(ifNos!= null && ifNos.size()>0){
				command2.interfaceARInvoiceToERPAR(ifNos, "C");
			}
			
			commit();
			
			
			eventResponse.setETCData("ar_if_no", invMain.getArIfNo());
			eventResponse.setETCData("due_dt", invMain.getDueDt());
			eventResponse.setETCData("eff_dt", invMain.getGlEffDt());			
			
			
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0022 : Currency@CHANGE<br>
	 * 경리환율 값을 불러온다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccountRate(Event e) throws EventException {
		FnsInv0022Event event = (FnsInv0022Event) e;
		INVCommonUtil command1 = new INVCommonUtil();
		ManualARCreationBC command2 = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String ofc = event.getOffice();
			String from_currCd = event.getCurrCd();
			String to_currCd = event.getLocalCurrCd();
			String effDt = event.getGlEffDt().replaceAll("-", "").substring(0, 6);

			// 데이터 분류/office로 관리되는 결산월의 마감여부를 체크한다.
			String clzStsCd = command2.searchClosingStatus(ofc, effDt, "O");

			if (clzStsCd.equals("O")) {
				// INVCommonDAO의 경리환율 해당되는 값을 불러온다.
				String usd_locl_xch_rt = command1.searchAccountRate(from_currCd, to_currCd, effDt);

				eventResponse.setETCData("usd_locl_xch_rt", usd_locl_xch_rt);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00015").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0022 : Auto B/L No <br>
	 * 비해운 운임수입 매출채권을 생성할 B/L No 를 자동채번한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAutoBLNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();

//			FnsInv0022Event event = (FnsInv0022Event) e;
//			ManualARCreationBC command = new ManualARCreationBCImpl();
//
//			String ofc = event.getOffice();
//
//			// 비해운 운임수입 매출채권 생성시 Office 별로 관리하고 있는 B/L No 를 채번하여 구한다.
//			String blMaxSeq = command.searchAutoBLNo(ofc, account.getUsr_id());
//			eventResponse.setETCData("bl_max_seq", (String) blMaxSeq);
			
			ManualARCreationBC command = new ManualARCreationBCImpl();
			String blMaxSeq = "";
			String ofcCd = "";
			
			if (e.getEventName().equalsIgnoreCase("FnsInv0022Event")) {
				FnsInv0022Event event = (FnsInv0022Event) e;
				ofcCd = event.getOffice();
				blMaxSeq = command.searchAutoBLNo(ofcCd, account.getUsr_id());
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0071Event")) {
				FnsInv0071Event event = (FnsInv0071Event) e;
				ofcCd = event.getOfcCd();
				blMaxSeq = command.searchAutoBLNo(ofcCd, account.getUsr_id());
			}
			
			eventResponse.setETCData("bl_max_seq", (String) blMaxSeq);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0023 : Retrieve<br>
	 * G/L Date, Slip Number, Account Code 등의 조건으로 비해운 운임수입 매출채권 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNonShippingARList(Event e) throws EventException {
		FnsInv0023Event event = (FnsInv0023Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<NonShippingListVO> list = command.searchNonShippingARList(event.getNonShippingInputVO());

			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0022 : Save<br>
	 * 비해운 운임수입으로 발생한 매출채권 정보를 신규 생성한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createNonShippingAR(Event e) throws EventException {
		OtherRevReturnVO otherRevReturnVO = new OtherRevReturnVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();

			FnsInv0022Event event = (FnsInv0022Event) e;

			ManualARCreationBC command = new ManualARCreationBCImpl();
			BookingARCreationBC command2 = new BookingARCreationBCImpl();
			INVCommonUtil command3 = new INVCommonUtil();

			String ofcCd = "";
			String usdXchRt = "";
			String slpNo = "";

			ofcCd = event.getARInvoiceCreationVO().getOfcCd();

			// 전표번호를 조회한다.
			slpNo = command.searchSlipNo(ofcCd);
			event.getARInvoiceCreationVO().setSlpNo(slpNo);

			// INVCommonDAO의 경리환율 해당되는 값을 불러온다.
			usdXchRt = command3.searchAccountRate("USD", event.getARInvoiceCreationVO().getLclCurr(), event.getARInvoiceCreationVO().getEffDt().replaceAll(",",
					"").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "").substring(0, 6));
			event.getARInvoiceCreationVO().setUsdXchRt(usdXchRt);

			ARInvoiceCreationVO aRInvoiceCreationVO = event.getARInvoiceCreationVO();
			aRInvoiceCreationVO.setUserId(account.getUsr_id());

			otherRevReturnVO = command2.createOtherRevenueARInvoice(aRInvoiceCreationVO);

			eventResponse.setETCData("ar_if_no", otherRevReturnVO.getArIfNo());
			eventResponse.setETCData("slp_no", otherRevReturnVO.getSlipNo());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0022 : Open, New<br>
	 * Revenue Account 의 Account Code, Account English Name, Account Korean Name 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenueAcctCdList(Event e) throws EventException {
		FnsInv0022Event event = (FnsInv0022Event) e;
		INVCommonUtil command1 = new INVCommonUtil();
		ManualARCreationBC command2 = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String ofcCd = event.getLoginOfcCd();
			String rhqOfcCd = command1.searchRhqOfcCd(ofcCd);

//			log.debug("ofcCd==>"+ofcCd);
//			log.debug("rhqOfcCd==>"+rhqOfcCd);
			// 1.User ID 소속의 A/R Office 관련 정보를 조회한다.
			List<String> officeList = command1.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			String ar_ofc_info = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			for (int i = 0; i < officeList.size(); i++) {
				arOfcInfoBuff.append("|" + officeList.get(i));
				//ar_ofc_info = ar_ofc_info + "|" + officeList.get(i);
			}
			ar_ofc_info = arOfcInfoBuff.toString();
			eventResponse.setETCData("ar_ofc_cd", ar_ofc_info);

			// 2.Currency Code List 를 조회한다.
			List<MdmCurrencyVO> currList = command1.searchCurrencyCodeList();
			String currInfo = "";
			String dpPrcsKnt = "";
			StringBuffer currInfoBuff = new StringBuffer();
			StringBuffer dpPrcsKntBuff = new StringBuffer();
			for (int i = 0; i < currList.size(); i++) {
				currInfoBuff.append("|" + currList.get(i).getCurrCd());
				dpPrcsKntBuff.append("|" + currList.get(i).getDpPrcsKnt());
				//currInfo = currInfo + "|" + currList.get(i).getCurrCd();
				//dpPrcsKnt = dpPrcsKnt + "|" + currList.get(i).getDpPrcsKnt();
			}
			currInfo = currInfoBuff.toString();
			dpPrcsKnt = dpPrcsKntBuff.toString();
			
			eventResponse.setETCData("currInfo", currInfo);
			eventResponse.setETCData("dpPrcsKnt", dpPrcsKnt);

 
			// 3.Revenue Account(계정) 코드 정보의 리스트를 조회한다.
			List<RevenueAcctVO> list = command2.searchRevenueAcctCdList(ofcCd, rhqOfcCd);
			String acct_cd = "";
			String acct_eng_nm = "";
			String acct_krn_nm = "";
			String rev_cd = "";
			String chg_cd = "";
			String rep_chg_cd = "";
			StringBuffer acctCdBuff = new StringBuffer();
			StringBuffer acctEngNmBuff = new StringBuffer();
			StringBuffer acctKrnNmBuff = new StringBuffer();
			StringBuffer revCdBuff = new StringBuffer();
			StringBuffer chgCdBuff = new StringBuffer();
			StringBuffer repChgCdBuff = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				acctCdBuff.append("|" + list.get(i).getAcctCd());
				acctEngNmBuff.append("|" + list.get(i).getAcctEngNm());
				acctKrnNmBuff.append("|" + list.get(i).getAcctKrnNm());
				revCdBuff.append("|" + list.get(i).getRevCd());
				chgCdBuff.append("|" + list.get(i).getChgCd());
				repChgCdBuff.append("|" + list.get(i).getRepChgCd());
				//acct_cd = acct_cd + "|" + list.get(i).getAcctCd();
				//acct_eng_nm = acct_eng_nm + "|" + list.get(i).getAcctEngNm();
				//acct_krn_nm = acct_krn_nm + "|" + list.get(i).getAcctKrnNm();
				//rev_cd = rev_cd + "|" + list.get(i).getRevCd();
				//chg_cd = chg_cd + "|" + list.get(i).getChgCd();
				//rep_chg_cd = rep_chg_cd + "|" + list.get(i).getRepChgCd();
			}
			acct_cd = acctCdBuff.toString();
			acct_eng_nm = acctEngNmBuff.toString();
			acct_krn_nm = acctKrnNmBuff.toString();
			rev_cd = revCdBuff.toString();
			chg_cd = chgCdBuff.toString();
			rep_chg_cd = repChgCdBuff.toString();

			eventResponse.setETCData("acct_cd", acct_cd);
			eventResponse.setETCData("acct_eng_nm", acct_eng_nm);
			eventResponse.setETCData("acct_krn_nm", acct_krn_nm);
			eventResponse.setETCData("rev_cd", rev_cd);
			eventResponse.setETCData("chg_cd", chg_cd);
			eventResponse.setETCData("rep_chg_cd", rep_chg_cd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0022 : BL/NO@CHANGE <br>
	 * 해당 B/L NO로 동일 Office 내 기 생성된 데이터(Max(AR_IF_NO)로 생성된 데이터)의 Customer 정보를 가져온다.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLCustomer(Event e) throws EventException {
		FnsInv0022Event event = (FnsInv0022Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// 해당 B/L NO로 동일 Office 내 기 생성된 데이터(Max(AR_IF_NO)로 생성된 데이터)의 Customer 정보를 가져온다.
			List<ARCustomerVO> list = command.searchBLCustomer(event.getOffice(), event.getBlSrcNo());

			for (int i = 0; i < list.size(); i++) {
				eventResponse.setETCData(list.get(i).getColumnValues());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * Interface 조회 이벤트 처리<br>
	 * FnsInv0071Event event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMiscellaneousARByIFNo(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		INVCommonUtil command2 = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String vvd = "";
		String bnd = "";
		String port = "";
		String saDt = "";
		
		try {
			ARInvoiceCreationVO arInvCreVo = command.searchMiscellaneousARByIFNo(event.getArIfNo());
			
			vvd = arInvCreVo.getInvArMnVO().getVslCd() + arInvCreVo.getInvArMnVO().getSkdVoyNo() + arInvCreVo.getInvArMnVO().getSkdDirCd();			
			bnd = arInvCreVo.getInvArMnVO().getIoBndCd();
			if (bnd.equals("I")) {
				port = arInvCreVo.getInvArMnVO().getPodCd();
			} else {
				port = arInvCreVo.getInvArMnVO().getPolCd();
			}
			
			log.info("\n########## vvd : "+vvd);
			log.info("\n########## bnd : "+bnd);
			log.info("\n########## port : "+port);
			
			saDt = command2.searchSADate(vvd, port, bnd);
			arInvCreVo.getInvArMnVO().setSailArrDt(saDt);
			
			log.info("\n########## saDt : "+saDt);
			log.info("\n########## arInvCreVo.getInvArMnVO().getDeltFlg() : "+arInvCreVo.getInvArMnVO().getDeltFlg());

			eventResponse.setETCData(arInvCreVo.getInvArMnVO().getColumnValues());
			eventResponse.setRsVoList(arInvCreVo.getArInvChgSumVOs());
			eventResponse.setRsVoList(arInvCreVo.getInvArChgVOs());
			eventResponse.setRsVoList(arInvCreVo.getInvArCntrVOs());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
		return eventResponse;
	}

	/**
	 * FNS012-R001 : Receive <br>
	 * ERP에서 전송받은 정보로 INV_AR_AMT Table을 수정합니다. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private void modifyARInvoiceERPReturn(Event e) throws EventException {
		BookingARCreationBC command = new BookingARCreationBCImpl();
		XmlObject xmlObject = ((Fns012R001Event) e).getXmlObject();
		ERPIfReturnVO[] erpIfReturnVOs = command.fns012R001Receive(xmlObject);

		try {
			begin();
				command.modifyARInvoiceERPReturn(erpIfReturnVOs);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
	}

	/**
	 * UBIZHJS_ALPSINV_INVOIC : Receive <br>
	 * 터미널 INVOICE Data를 e-SVC센터로 부터 MQ를 통해 INTERFACE 받아서 INVOICE 채권을 생성한다. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private void interfaceTerminalARInvoiceToINV(Event e) throws EventException {
		GeneralARInvoiceCreationBC command = new GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> genIfVOs = null;
		try {
			
			begin();
				UbizhjsAlpsinvInvoicEvent event = (UbizhjsAlpsinvInvoicEvent) e;
				genIfVOs = command.interfaceTerminalARInvoiceToIF(event.getFlatFile(), "", event.getIntegrationId());
			commit();
			
			begin();
				command.interfaceGeneralARInvoiceToINV(genIfVOs);
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
	}
	
	/**
	 * ESM067_0001 : Receive <br>
	 * Domestic 에서 전송받은 정보로 Other Interface BC 를 호출 합니다. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private void interfaceDomesticARInvoiceToINV(Event e) throws EventException {
		GeneralARInvoiceCreationBC command = new GeneralARInvoiceCreationBCImpl();
		XmlObject xmlObject = ((Esm0670001Event) e).getXmlObject();
		DOMDestInvoiceVO[] dOMDestInvoiceVOs = command.esm0670001Receive(xmlObject);

		try {
			ARInterfaceCreationVO genIfVO = new ARInterfaceCreationVO();
			List<ARInterfaceCreationVO> genIfVOs = new ArrayList<ARInterfaceCreationVO>();	
			List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();	
			InvArIfMnVO invArIfMnVO = new InvArIfMnVO();
			InvArIfChgVO invArIfChgVO = new InvArIfChgVO();
			List<InvArIfChgVO> invArIfChgVOs = new ArrayList<InvArIfChgVO>();
			InvArIfCntrVO invArIfCntrVO = null;
			List<InvArIfCntrVO> invArIfCntrVOs = new ArrayList<InvArIfCntrVO>();
			
			if (dOMDestInvoiceVOs != null) {
			
				invArIfMnVO.setBlSrcNo(dOMDestInvoiceVOs[0].getInvNo());  
				invArIfMnVO.setCustCntCd(dOMDestInvoiceVOs[0].getCustCntCd());  
				invArIfMnVO.setCustSeq(dOMDestInvoiceVOs[0].getCustSeq());  
				invArIfMnVO.setOfcCd(dOMDestInvoiceVOs[0].getOfcCd());  
				invArIfMnVO.setIfSrcCd(dOMDestInvoiceVOs[0].getDom());
				invArIfMnVO.setVslCd(dOMDestInvoiceVOs[0].getVslCd());
				invArIfMnVO.setSkdVoyNo(dOMDestInvoiceVOs[0].getSkdVoyNo());
				invArIfMnVO.setSkdDirCd(dOMDestInvoiceVOs[0].getSkdDirCd());
				invArIfMnVO.setSvcScpCd(dOMDestInvoiceVOs[0].getSvcScpCd());
				invArIfMnVO.setSlanCd(dOMDestInvoiceVOs[0].getSlanCd());
				invArIfMnVO.setSailDt(dOMDestInvoiceVOs[0].getSailDt());
				invArIfMnVO.setSailArrDt(dOMDestInvoiceVOs[0].getSailArrDt());
				invArIfMnVO.setDueDt(dOMDestInvoiceVOs[0].getDueDt());
				invArIfMnVO.setGlEffDt(dOMDestInvoiceVOs[0].getGlEffDt());
				invArIfMnVO.setIoBndCd(dOMDestInvoiceVOs[0].getIoBndCd());
				invArIfMnVO.setTrnkVslCd(dOMDestInvoiceVOs[0].getTrnkVslCd());
				invArIfMnVO.setTrnkSkdVoyNo(dOMDestInvoiceVOs[0].getTrnkSkdVoyNo());
				invArIfMnVO.setTrnkSkdDirCd(dOMDestInvoiceVOs[0].getTrnkSkdDirCd());
				invArIfMnVO.setPorCd(dOMDestInvoiceVOs[0].getPorCd());
				invArIfMnVO.setPolCd(dOMDestInvoiceVOs[0].getPolCd());
				invArIfMnVO.setPodCd(dOMDestInvoiceVOs[0].getPodCd());
				invArIfMnVO.setDelCd(dOMDestInvoiceVOs[0].getDelCd());
				invArIfMnVO.setBkgTeuQty(dOMDestInvoiceVOs[0].getBkgTeuQty());
				invArIfMnVO.setBkgFeuQty(dOMDestInvoiceVOs[0].getBkgFeuQty());
				invArIfMnVO.setCreUsrId(dOMDestInvoiceVOs[0].getCreateUserId());
				invArIfMnVO.setCreDt(dOMDestInvoiceVOs[0].getCreateDate());
				invArIfMnVO.setUpdUsrId(dOMDestInvoiceVOs[0].getCreateUserId());
				invArIfMnVO.setUpdDt(dOMDestInvoiceVOs[0].getCreateDate());
			
				//invArIfChgVO.setChgSeq(dOMDestInvoiceVOs[0].getChgSeq());
				invArIfChgVO.setCurrCd(dOMDestInvoiceVOs[0].getCurrCd());
				invArIfChgVO.setChgCd(dOMDestInvoiceVOs[0].getChgCd());
				invArIfChgVO.setChgFullNm(dOMDestInvoiceVOs[0].getChgFullNm());
				invArIfChgVO.setPerTpCd(dOMDestInvoiceVOs[0].getPerTpCd());
				invArIfChgVO.setTrfRtAmt(dOMDestInvoiceVOs[0].getTrfRtAmt());
				invArIfChgVO.setRatAsCntrQty(dOMDestInvoiceVOs[0].getRatAsCntrQty());
				invArIfChgVO.setChgAmt(dOMDestInvoiceVOs[0].getChgAmt());
				invArIfChgVO.setInvXchRt(dOMDestInvoiceVOs[0].getInvXchRt());
				invArIfChgVO.setTvaFlg(dOMDestInvoiceVOs[0].getTvaFlg());
				invArIfChgVO.setRepChgCd(dOMDestInvoiceVOs[0].getRepChgCd());
				invArIfChgVO.setChgRmk(dOMDestInvoiceVOs[0].getChgRmk());
				invArIfChgVO.setCreUsrId(dOMDestInvoiceVOs[0].getCreateUserId());
				invArIfChgVO.setCreDt(dOMDestInvoiceVOs[0].getCreateDate());
				invArIfChgVO.setUpdUsrId(dOMDestInvoiceVOs[0].getCreateUserId());
				invArIfChgVO.setUpdDt(dOMDestInvoiceVOs[0].getCreateDate());
				
				invArIfChgVOs.add(invArIfChgVO);
			
				for (int i = 0; i < dOMDestInvoiceVOs.length; i++) {
					invArIfCntrVO = new InvArIfCntrVO();
					//invArIfCntrVO.setCntrSeq(dOMDestInvoiceVOs[0].getCntrSeq());
					invArIfCntrVO.setCntrNo(dOMDestInvoiceVOs[i].getCntrNo());
					invArIfCntrVO.setCntrTpszCd(dOMDestInvoiceVOs[i].getCntrTpszCd());
					invArIfCntrVO.setCreUsrId(dOMDestInvoiceVOs[i].getCreateUserId());
					invArIfCntrVO.setCreDt(dOMDestInvoiceVOs[i].getCreateDate());
					invArIfCntrVO.setUpdUsrId(dOMDestInvoiceVOs[i].getCreateUserId());
					invArIfCntrVO.setUpdDt(dOMDestInvoiceVOs[i].getCreateDate());
					
					invArIfCntrVOs.add(invArIfCntrVO);
					
				}
				
				genIfVO.setInvArIfMnVO(invArIfMnVO);
				genIfVO.setInvArIfChgVOs(invArIfChgVOs);
				genIfVO.setInvArIfCntrVOs(invArIfCntrVOs);
				
				genIfVOs.add(genIfVO);				
			
			}
						
			begin();
			rGenIfVOs = command.interfaceGeneralARInvoiceToIF(genIfVOs);
			commit();
			
			begin();
			String ar_if_no = command.interfaceGeneralARInvoiceToINV(rGenIfVOs);
			commit();
			
			if(ar_if_no != null && !ar_if_no.equals("")) {
				String ar_if_no_arr[] =	ar_if_no.split("::");
				
				if(ar_if_no_arr[0].equals("S")){
					begin();
					command.interfaceARInvoiceToERPAR(ar_if_no_arr[1]);
					commit();
				}
			}

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0071 : REV_TP_CD@CHANGE <br>
	 * office 별 Local Time 조회 <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchLocalTime(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {

			String ofcCd = event.getOfcCd().trim();
			String localTime = command.searchLocalTime(ofcCd);
			eventResponse.setETCData("local_time", localTime);
					
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}	
	
	/**
	 * FNS_INV_0071 : CHG_CD@CHANGE <br>
	 * office 별 block charge 조회 <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchBlckChg(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        String blckChg = "";
        
		try {

			blckChg = command.searchBlckChg(event.getChgCd(), event.getOfcCd());
			eventResponse.setETCData("blck_chg", blckChg);
					
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}
	
	
	/**
	 * FNS_INV_0071 : 조회 <br>
	 * VLCSC MIC 일 경우 입력된 IFNo 로 IVA 요율을 가져온다. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchIvaRateMstIFNo(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        String ivaRate = "";
        
		try {

			ivaRate = command.searchIvaRateMstIFNo(event.getMstIfNo(), event.getOfcCd());
			eventResponse.setETCData("iva_rate", ivaRate);
					
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}
	
	/**
	 * FNS_INV_0022 : Issue<br>
	 * Other Revenue Issue 처리함. (General Issue 로직과 동일)<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueOtherRevenueARInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();

			FnsInv0022Event event = (FnsInv0022Event) e;

			InvoiceIssueBC command = new InvoiceIssueBCImpl();
			BookingARCreationBC command2 = new BookingARCreationBCImpl();

			String invNo = "";
			String ofcCd = event.getOffice();
			String ifNo = event.getArIfNo();
			
			List<IssueEachTargetVO> issueEachTargetVOs = Arrays.asList(event.getIssEachTgtVOs());
			for (int i=0; i<issueEachTargetVOs.size(); i++) {
				IssueEachTargetVO issueEachTargetVO = issueEachTargetVOs.get(i);
				
				issueEachTargetVO.setArIfNo(ifNo);
				issueEachTargetVO.setOfcCd(ofcCd);
			}
			
			
			invNo = command.issueOtherRevInvoice(event.getInvIssMainVO(), issueEachTargetVOs, ofcCd, account.getUsr_id());

			command2.modifyOtherRevIssueFlag(invNo, ifNo, account.getUsr_id());

			eventResponse.setETCData("inv_no", invNo);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}
	
	/**
	 * FNS_INV_0071 : 조회 <br>
	 * CMBSC일 경우 입력된 CustCd로 INV_AR_SPND_VAT_RGST_NO테이블에서 SPND_VAT_RGST_NO값을 가져온다. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchSpndVatRgstNo(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String rgstNoExist = "";
		
		try {
			
			String custCntCd = event.getARInvoiceCreationVO().getCustCntCd();
			String custSeq = event.getARInvoiceCreationVO().getCustSeq();
			
			rgstNoExist = command.searchSpndVatRgstNo(custCntCd, custSeq);
			if (rgstNoExist != null && !rgstNoExist.equals("")) { 
				rgstNoExist = "Y";
			} else {
				rgstNoExist = "N";
			}
			eventResponse.setETCData("spnd_vat_rgst", rgstNoExist);
			
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
		
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0071 : 조회 <br>
	 * SA Date 에 따른 Due Date 값을 계산하여 가져온다. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchSADateDueDate(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		INVCommonUtil command = new INVCommonUtil();
		ManualARCreationBC command2 = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			// S/A Date 구하기 위한 parameter
			String vsl = "";
			String voy = "";
			String dep = "";
			String bnd = "";
			String pol = "";
			String pod = "";
			String port = "";
			
			String revSrcCd	= "";

			// Due Date 구하기 위한 parameter
			String custCntCd	= "";
			String custSeq		= "";
			String ofcCd		= "";
			
			String saDate	= "";
			String dueDate	= "";
			
			vsl = event.getVvdCustomerVo().getVsl();
			voy = event.getVvdCustomerVo().getVoy();
			dep = event.getVvdCustomerVo().getDep();
			bnd = event.getVvdCustomerVo().getBnd();
			pol = event.getVvdCustomerVo().getPol();
			pod = event.getVvdCustomerVo().getPod();
			
			revSrcCd = event.getARInvoiceCreationVO().getRevSrcCd(); 

			custCntCd	= event.getARInvoiceCreationVO().getCustCntCd();
			custSeq		= event.getARInvoiceCreationVO().getCustSeq();
			ofcCd		= event.getARInvoiceCreationVO().getOfcCd();
			
			if (bnd.equals("O")) {
				port = pol;
			} else if (bnd.equals("I")) {
				port = pod;
			}

			if(("TN").equals(revSrcCd) || ("EQ").equals(revSrcCd)){
				saDate 		= command.searchLocalTime(ofcCd);
				if(saDate != null && !saDate.equals("")){
					saDate	= saDate.substring(0, 4) + "-" + saDate.substring(4, 6) + "-" + saDate.substring(6, 8);
				}
			}else{
				if(("CFDR").equals(vsl) || ("USAC").equals(vsl) || ("CNTC").equals(vsl)){
					// localTime
					saDate		= command2.searchLocalTime(ofcCd);
					if(saDate != null){
						saDate	= saDate.substring(0, 4) + "-" + saDate.substring(4, 6) + "-" + saDate.substring(6, 8);
					}
				}else{
					saDate 		= command.searchSADate(vsl + voy + dep, port, bnd);
				}
			}
			
			/*
			System.out.println("vsl ====================================> " + vsl);
			System.out.println("voy ====================================> " + voy);
			System.out.println("dep ====================================> " + dep);
			System.out.println("bnd ====================================> " + bnd);
			System.out.println("pol ====================================> " + pol);
			System.out.println("pod ====================================> " + pod);
			System.out.println("port ====================================> " + port);
			System.out.println("saDate ====================================> " + saDate);
			System.out.println("cust_cnt_cd ====================================> " + custCntCd);
			System.out.println("cust_seq ====================================> " + custSeq);
			System.out.println("ofc_cd ====================================> " + ofcCd);
			*/
			
			dueDate		= command2.searchDueDate(bnd, saDate, custCntCd, custSeq, ofcCd);
			
			eventResponse.setETCData("sa_date", saDate);
			eventResponse.setETCData("due_date", dueDate);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}
	
	
	/**
	 * FNS_INV_0071 : 조회 <br>
	 * 로그인 유저에 따른 OFC_CD를 COM_USER에서 가져온다. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchOfcCdByUserId(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
		
			String ofcCd = command.searchOfcCdByUserId(account.getUsr_id());
			eventResponse.setETCData("usr_ofc_cd", ofcCd);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
		
		return eventResponse;
	}
	
	
	/**
	 * FNS_INV_0071 : 조회 <br>
	 * VVD변경여부를 판별하기위해 BKG으로부터 VVD정보를 가져온다. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchVvdByBkgNo(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command2 = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
			
		try {
			String blNo	= "";
			blNo = event.getBlNo();
			
			// 해당 B/L NO로 동일 Office 내 기 생성된 데이터(Max(AR_IF_NO)로 생성된 데이터)의 Customer 정보를 가져온다.
			VvdVO vvdVo = command2.searchVvdByBkgNo(blNo);
			eventResponse.setETCData(vvdVo.getColumnValues());
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
		
		return eventResponse;
	}
	
	
	/**
	 * FNS_INV_0136 : 조회 <br>
	 * China Region VAT Creation Validation check <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchChinaVATMiscellaneousARInvoiceData(Event e) throws EventException {
		FnsInv0136Event event = (FnsInv0136Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			BookingARCreationBC command = new BookingARCreationBCImpl();
			List<ChinaVATInvoiceCreationVO> list = command.searchChinaVATMiscellaneousARInvoiceData(event.getChinaVATInvoiceCreationVOS());
			eventResponse.setRsVoList(list);
			return eventResponse; 
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}	
	}
	
	/**
	 * China Region VAT 생성 이벤트 처리<br>
	 * FnsInv0136Event event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createChinaVATMiscellaneousARInvoice(Event e) throws EventException {
		
		FnsInv0136Event event = (FnsInv0136Event)e; // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<InvArIfNoVO> ifNos = null;
		
		try {
			begin();
//			String userId = event.getSignOnUserAccount().getUsr_id();
			BookingARCreationBC command = new BookingARCreationBCImpl();
			ifNos = command.createChinaVATMiscellaneousARInvoice(event.getChinaVATInvoiceCreationVOS());
			commit();		
			
			//IF
			begin();
			if(ifNos!= null && ifNos.size()>0){
				command.interfaceARInvoiceToERPAR(ifNos, "C");
			}
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse; 

	}

	/**
	 * FNS_INV_0071 : 조회 <br>
	 * POL_CD, POD_CD 를 이용하여 EU여부를 체크한다. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchEuCheck(Event e) throws EventException {
		ManualARCreationBC command = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0071Event event = (FnsInv0071Event) e;
		String euCheck = "";
		try {
			
			String polCd = event.getVvdCustomerVo().getPol();
			String podCd = event.getVvdCustomerVo().getPod();
			
			euCheck = command.searchEuCheck(polCd, podCd);
 
			eventResponse.setETCData("eu_check", euCheck);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}
		
		return eventResponse;
	}
	
}