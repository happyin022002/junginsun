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
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import org.apache.xmlbeans.XmlObject;

//import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
//import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.OtherRevReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic.ManualARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.basic.ManualARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.event.FnsInv0022Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.event.FnsInv0023Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.event.FnsInv0071Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration.ManualARCreationDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGContainerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.BKGInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingARVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.NonShippingListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo.RevenueAcctVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ARCustomerVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExchangeRateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.log4j.StringUtils;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmChargeVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.syscommon.common.table.PriRatUtVO;

/**
 * AccountReceivableInvoiceCreation Business Logic ServiceCommand
 * Handling AccountReceivableInvoiceCreation Business transaction.
 * 
 * @author saeil kim
 * @see ManualARCreationDBDAO
 * @since J2EE 1.4
 */
public class AccountReceivableInvoiceCreationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Precede AccountReceivableInvoiceCreation system <br>
	 * Create Object when FNS_INV_0022 job call<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Follow AccountReceivableInvoiceCreation system<br>
	 * Release Object when FNS_INV_0022 job end<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableInvoiceCreationSC 종료");
	}

	/**
	 *  proceeding job each Even<br>
	 *  Handling every Event on AccountReceivableInvoiceCreation system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchExrateSADatebyVVD(e);
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
				eventResponse = searchBlNoCntForMOS(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchMasterInvNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createMiscellaneousAR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = searchAutoBLNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNonShippingARList(e);
			}
		} 
		return eventResponse;
	}

	/**
	 * FNS_INV_0022 : Retrieve<br>
	 * Retrieve none shipping AR data by I/F No.<br>
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
	 * retrieve AR Office, Rev. Type.<br>
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

			StringBuffer ar_ofc_info = new StringBuffer("");

			for (int i = 0; i < list.size(); i++) {
				ar_ofc_info.append("|").append(list.get(i));
			}

			eventResponse.setETCData("ar_ofc_cd", ar_ofc_info.toString());

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

			StringBuffer rev_type = new StringBuffer("");

			for (int i = 0; i < list2.size(); i++) {
				rev_type.append("|").append(list2.get(i));
			}
			
			eventResponse.setETCData("rev_tp_cd", rev_type.toString());
			
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
	 * retrieve AR Office, Rev. Type. <br>
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

			StringBuffer revSrcCd = new StringBuffer("");

			for (int i = 0; i < list2.size(); i++) {
				revSrcCd.append("|").append(list2.get(i));
			}

			eventResponse.setETCData("rev_src_cd", revSrcCd.toString());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * Max Interface retrieve<br>
	 * handling FnsInv0071Event event<br>
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

			if (list.size() > 0) {
				cntryCd = list.get(0).getActCustCntCd(); //  eventResponse.getETCData("act_cust_cnt_cd");
				custCd = list.get(0).getActCustSeq(); //eventResponse.getETCData("act_cust_seq");
				//arCustomerVO = command2.searchARCustomer(cntryCd, Long.parseLong(custCd));
				arCustomerVO = command2.searchARCustomer(cntryCd, custCd, "");
				if(arCustomerVO != null) {
					eventResponse.setETCData(arCustomerVO.getColumnValues());
				}

				for (int i = 0; i < list.size(); i++) {
					eventResponse.setETCData(list.get(i).getColumnValues());
				}
				
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
	 * Max Interface  retrieve<br>
	 * handling FnsInv0071Event event<br>
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

			for (int i = 0; i < list.size(); i++) {
				eventResponse.setETCData(list.get(i).getColumnValues());
			}

			if (list.size() > 0) {
				cntryCd = eventResponse.getETCData("act_cust_cnt_cd");
				custCd = eventResponse.getETCData("act_cust_seq");

				//arCustomerVO = command2.searchARCustomer(cntryCd, Long.parseLong(custCd));
				arCustomerVO = command2.searchARCustomer(cntryCd, custCd, "");
				if (arCustomerVO!= null) {
					eventResponse.setETCData(arCustomerVO.getColumnValues());
				}

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
	 * retrieve charge and handling retrieve currency list <br>
	 * handling ARInvoiceCustomerMgt event<br>
	 * use INVCommon bc
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
			//List<MdmChargeVO> chgList = command.searchChargeCodeList(event.getOfcCd());
			List<MdmChargeVO> chgList = command.searchChargeCodeList();
			List<MdmCurrencyVO> currList = command.searchCurrencyCodeList();
			List<PriRatUtVO> perList = command.searchPerTpCdList();

			StringBuffer chgInfo = new StringBuffer("");
			StringBuffer currInfo = new StringBuffer("");
			StringBuffer perInfo = new StringBuffer("");

			for (int i = 0; i < chgList.size(); i++) {
				chgInfo.append("|").append(chgList.get(i).getChgCd());
			}

			for (int i = 0; i < currList.size(); i++) {
				currInfo.append("|").append(currList.get(i).getCurrCd()).append("^").append(currList.get(i).getDpPrcsKnt());
				
			}
			
			for (int i = 0; i < perList.size(); i++) {
				perInfo.append("|").append(perList.get(i).getRatUtCd());
			}

			eventResponse.setETCData("chgInfo", chgInfo.toString());
			eventResponse.setETCData("currInfo", currInfo.toString());
			eventResponse.setETCData("perInfo", perInfo.toString());
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	
	/**
	 * handling retrieve event <br>
	 * retrieve Ex. rage in INVCommon UI.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author junght
	 */
	private EventResponse searchExrateSADatebyVVD(Event e) throws EventException {
		FnsInv0022Event event = (FnsInv0022Event) e;
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
			
			log.info("\n########## event.getSvrId() : "+ event.getSvrId());
			
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
	 * handling retrieve event <br>
	 * retrieve Ex. rage in INVCommon UI.<br>
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
	 * handling create MiscellaneousAR event<br>
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
			AccountReceivableOutstandingBC command3 = new AccountReceivableOutstandingBCImpl();
			
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
			
			if (!vsl.equals("CFDR") && !vsl.equals("USAC")) { 			
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
			
			/*
			begin();
			
			if(ifNos!= null && ifNos.size()>0){
				command2.interfaceARInvoiceToERPAR(ifNos, "C");
			}
			
			commit();
			
			*/
			
			//2014.03.12 AR OTS creation
			if(ifNos!= null && ifNos.size()>0){
				command3.createOutstandingInfo(ifNos);
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
	 * retrieve account rate.<br>
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

			String clzStsCd = command2.searchClosingStatus(ofc, effDt, "O");

			if (clzStsCd.equals("O")) {
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
	 * auto create B/L No.<br>
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
	 * retrieve none shipping AR by G/L Date, Slip Number, Account Code.<br>
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
	 * save none shipping AR.<br>
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
			AccountReceivableOutstandingBC command4 = new AccountReceivableOutstandingBCImpl();

			List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
			InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
			
			String ofcCd = "";
			String usdXchRt = "";
			String slpNo = "";
			String voy = "";
			String vsl = "";
			String dep = "";
			String lcl_vvd = "";
			String pol = "";
			String scp = "";
			String port = "";

			ofcCd = event.getARInvoiceCreationVO().getOfcCd();

			slpNo = command.searchSlipNo(ofcCd);
			event.getARInvoiceCreationVO().setSlpNo(slpNo);

			usdXchRt = command3.searchAccountRate("USD", event.getARInvoiceCreationVO().getLclCurr(), event.getARInvoiceCreationVO().getEffDt().replaceAll(",",
					"").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "").substring(0, 6));
			event.getARInvoiceCreationVO().setUsdXchRt(usdXchRt);

			ARInvoiceCreationVO aRInvoiceCreationVO = event.getARInvoiceCreationVO();
			aRInvoiceCreationVO.setUserId(account.getUsr_id());
			
			lcl_vvd = event.getARInvoiceCreationVO().getLclVvd();
			if (lcl_vvd.length() >= 9) {
				vsl = event.getARInvoiceCreationVO().getLclVvd().substring(0, 4);
				voy = event.getARInvoiceCreationVO().getLclVvd().substring(4, 8);				
				dep = event.getARInvoiceCreationVO().getLclVvd().substring(8, 9);
		    }	
			pol = event.getARInvoiceCreationVO().getPolCd();
			if(pol != null && !pol.equals("")){
				command.checkPort(pol);
			}
			port = pol;
			scp = event.getARInvoiceCreationVO().getSvcScpCd();
			log.info("SvcScpCd:"+scp);
			log.info("Vessel:"+vsl);
			if (!vsl.equals("CFDR") && !vsl.equals("USAC") && !vsl.equals("CNTC") && !vsl.equals("COMC")) { 
				log.info("VVD:"+vsl+voy+dep+port+scp);
				command.checkMiscellaneousAR(vsl, voy, dep, port, scp);
			}

			otherRevReturnVO = command2.createOtherRevenueARInvoice(aRInvoiceCreationVO);

			// 2014.06.13 Set I/F No for AR OTS creation
			if(!otherRevReturnVO.getArIfNo().equals("")){
				invArIfNoVO = new InvArIfNoVO();
				invArIfNoVO.setIfNo(otherRevReturnVO.getArIfNo());
				ifNos.add(invArIfNoVO);
			}
			
			eventResponse.setETCData("ar_if_no", otherRevReturnVO.getArIfNo());
			eventResponse.setETCData("slp_no", otherRevReturnVO.getSlipNo());

			// 2014.06.13 AR OTS creation
			if(ifNos!= null && ifNos.size()>0){
				command4.createOutstandingInfo(ifNos);
			}
						
			commit();
		} catch (EventException ex) {
			log.info("Aerr_message:"+ex.getMessage());
			rollback();
			//throw ex;
			throw new EventException(new ErrorHandler(ex).getMessage()); 
			//throw new EventException(ERR_MSG, ex);
			//throw new EventException(ex.getMessage(), ex);
			//throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			//throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0022 : Open, New<br>
	 * retrieve Account Code, Account English Name, Account Korean Name in Revenue Account.<br>
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
			List<String> officeList = command1.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			StringBuffer ar_ofc_info = new StringBuffer("");
			for (int i = 0; i < officeList.size(); i++) {
				ar_ofc_info.append("|").append(officeList.get(i));
			}
			eventResponse.setETCData("ar_ofc_cd", ar_ofc_info.toString());

			List<MdmCurrencyVO> currList = command1.searchCurrencyCodeList();
			StringBuffer currInfo = new StringBuffer("");
			StringBuffer dpPrcsKnt = new StringBuffer("");
			for (int i = 0; i < currList.size(); i++) {
				currInfo.append("|").append(currList.get(i).getCurrCd());
				dpPrcsKnt.append("|").append(currList.get(i).getDpPrcsKnt());
			}
			eventResponse.setETCData("currInfo", currInfo.toString());
			eventResponse.setETCData("dpPrcsKnt", dpPrcsKnt.toString());

			List<RevenueAcctVO> list = command2.searchRevenueAcctCdList(event.getGlEffDt());
			StringBuffer acct_cd = new StringBuffer("");
			StringBuffer acct_eng_nm = new StringBuffer("");
			StringBuffer acct_krn_nm = new StringBuffer("");
			StringBuffer rev_cd = new StringBuffer("");
			StringBuffer chg_cd = new StringBuffer("");
			StringBuffer rep_chg_cd = new StringBuffer("");
			for (int i = 0; i < list.size(); i++) {
				acct_cd.append("|").append(list.get(i).getAcctCd());
				acct_eng_nm.append("|").append(list.get(i).getAcctEngNm());
				acct_krn_nm.append("|").append(list.get(i).getAcctKrnNm());
				rev_cd.append("|").append(list.get(i).getRevCd());
				chg_cd.append("|").append(list.get(i).getChgCd());
				rep_chg_cd.append("|").append(list.get(i).getRepChgCd());
			}
			
			//String[] tmpDate = command2.searchRevenueAcctMaxEndDate(event.getGlEffDt());	
			//String fm_acct_end_dt = tmpDate[0];
			//String to_acct_end_dt = tmpDate[1];
			
			String[] tmpDate2 = command2.searchDefaultDRRevAcct(event.getGlEffDt());	
			String drAcctCode = tmpDate2[0];
			String drAcctName = tmpDate2[1];

			eventResponse.setETCData("acct_cd", acct_cd.toString());
			eventResponse.setETCData("acct_eng_nm", acct_eng_nm.toString());
			eventResponse.setETCData("acct_krn_nm", acct_krn_nm.toString());
			eventResponse.setETCData("rev_cd", rev_cd.toString());
			eventResponse.setETCData("chg_cd", chg_cd.toString());
			eventResponse.setETCData("rep_chg_cd", rep_chg_cd.toString());
			//eventResponse.setETCData("fm_acct_end_dt", fm_acct_end_dt);
			//eventResponse.setETCData("to_acct_end_dt", to_acct_end_dt);
			eventResponse.setETCData("dr_acct_code", drAcctCode);
			eventResponse.setETCData("dr_acct_name", drAcctName);
			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		}

		return eventResponse;
	}
	

	/**
	 * FNS_INV_0022 : BL/NO@CHANGE <br>
	 * retrieve Customer Info created by (Max(AR_IF_NO) in same office by B/L NO.<br>
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
	 * handling Interface retrieve event<br>
	 * handling FnsInv0071Event event<br>
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
	 * update INV_AR_AMT Table from ERP. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	/*
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
	*/

	
	
	/**
	 * ESM067_0001 : Receive <br>
	 * call Other Interface BC from Domestic. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	/*
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
			command.interfaceGeneralARInvoiceToINV(rGenIfVOs);
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
	}
	*/
	
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
	 * retrieve block charge by office <br>
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
	 * FNS_INV_0071 : retrieve <br>
	 * retrieve IVA by IFNo when VLCBB MIC. <br>
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
	 * FNS_INV_0071 :  입력된 B/L No.이 Invoice Main 과 Booking Main 테이블에 존재하는지 체크한다<br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchBlNoCntForMOS(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        String chkVal = "";
        
		try {

			chkVal = command.searchBlNoCntForMOS(event.getBlNo() );
			eventResponse.setETCData("bl_no_yn", chkVal);
					
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
	 * FNS_INV_0071 :  입력된 B/L No.이 Invoice Main 과 Booking Main 테이블에 존재하는지 체크한다<br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchMasterInvNo(Event e) throws EventException {
		FnsInv0071Event event = (FnsInv0071Event) e;
		ManualARCreationBC command = new ManualARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        String chkVal = "";
        
		try {

			chkVal = command.searchMasterInvNo(event.getMasterInv(), event.getOfcCd() );
			eventResponse.setETCData("org_inv_yn", chkVal);
					
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
	 * handling Other Revenue Issue . (same logic in General Issue )<br>
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
			AccountReceivableOutstandingBC command3 = new AccountReceivableOutstandingBCImpl();

			List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
			InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
			
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

			invArIfNoVO.setIfNo(ifNo);
			ifNos.add(invArIfNoVO);

			if(("INV").equals(event.getOtsSmryCd()) && ifNos!= null && ifNos.size()>0){
				command3.createOutstandingInfo(ifNos);
			}
			
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
}