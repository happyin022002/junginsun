/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableInvoiceMasterDataMgtSC.java
 *@FileTitle : Ex. Rate Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.04.24 김세일
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic.ARInvoiceCustomerMgtBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic.ARInvoiceCustomerMgtBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0013Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0086Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0090Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0091Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CreditCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PopCustomerListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PriCustomerListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic.ARInvoiceExRateMgtBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic.ARInvoiceExRateMgtBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0006Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0007Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0008Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0089Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0100Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0101Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0105Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0107Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0081Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration.ARInvoiceExRateMgtDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExRateListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateDateHisVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDandPortListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExRateHistoryVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.basic.GeneralARInvoiceMasterDataMgtBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.basic.GeneralARInvoiceMasterDataMgtBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0072Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0073Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0076Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0102Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0108Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArStupOfcVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCprtCdConvVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCutOffLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PrinterbyUserIdVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.DailyExchangeRateTmpVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.InvRevAcctCdVO;
import com.clt.syscommon.common.table.MdmChargeVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.framework.component.util.object.ObjectCloner;


/**
 * AccountReceivableInvoiceMasterDataMgt Business Logic ServiceCommand 
 * - Handling AccountReceivableInvoiceMasterDataMgt Business transaction.
 * 
 * @author saeil kim
 * @see ARInvoiceExRateMgtDBDAO
 * @since J2EE 1.4
 */ 

public class AccountReceivableInvoiceMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Precede AccountReceivableInvoiceMasterDataMgt system <br>
	 *  Create Object when FNS_INV-0006 job call<br>
	 */
	public void doStart() {
		try {
			//Checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

		}
	}

	/**
	 * Follow AccountReceivableInvoiceMasterDataMgt system<br>
	 * Release Object when FNS_INV-0006 job end<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableInvoiceMasterDataMgtSC 종료");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  AccountReceivableInvoiceMasterDataMgt system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("FnsInv0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchServiceScopeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchExchangeRateList(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("FnsInv0076Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevenueAccountList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRevenueAccount(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDailyExchangeRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustomerDailyExchangeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOfcCurrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = preManageCustomerDailyExchangeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDailyExchangeRateTmpList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCreditCustomer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCustomerExchangeRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustomerDailyExchangeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOfcCurrList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0089Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMultiCustomerExRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerMonExRate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0086Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopCustomerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0072Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCutOffLaneListByAROffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCutOffLaneByAROffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSvcLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAROfficeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0090Event")) {
			eventResponse = searchRFACustomerList(e);
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0091Event")) {
			eventResponse = searchSCCustomerList(e);
		}  else if (e.getEventName().equalsIgnoreCase("FnsInv0073Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIssueStandardByOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageIssueStandardByOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchChargeCodeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0100Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // open
				eventResponse = this.searchPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // retrieve I/O
				eventResponse = this.searchPortListByBnd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // retrieve triangle
				eventResponse = this.searchPortListByTri(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // retrieve EUR
				eventResponse = this.searchEURPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.createVVDExchangeRate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // open
				eventResponse = this.searchPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //VVD 입력시
				eventResponse = this.searchPortScpListbyVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // retrieve
				eventResponse = this.searchVVDExchangeRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.manageVVDExchangeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = this.searchARInvoiceExist(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchINVPrinterbyUserId(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageINVPrinterName(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchCodeConversionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchCustomerName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = this.searchCustomerName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchCompanyCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.manageCodeConversion(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = this.createCodeConversion(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // open
				eventResponse = this.searchPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //VVD 입력시
				eventResponse = this.searchPortScpListbyVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // retrieve
				eventResponse = this.searchVVDExRateDateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = this.searchDailyExRateExist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.manageVVDExRateDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = this.searchARInvoiceExist2(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0107Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 
				eventResponse = this.searchVVDExRateDateHistList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchExRateHistoryList(e);
			} 
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0006 : retrieve<br>
	 * retrieve [COMBO BOX List] MDM Service Scope<br>
	 * All/OTH 추가
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeList(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<String> scpList = command.searchServiceScopeList();
			StringBuffer svcCd = new StringBuffer("ALL");

			for (int i = 0; i < scpList.size(); i++) {
				svcCd.append("|").append(scpList.get(i));
			}

			svcCd.append("|").append("OTH");
			eventResponse.setETCData("svc_scp_cd", svcCd.toString());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	

	/**
	 * FNS_INV_0076 : Retrieve <br>
	 * retrieve Revenue account(decide revenue account by charge when create B/L). <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenueAccountList(Event e) throws EventException {
		FnsInv0076Event event = (FnsInv0076Event) e;
		GeneralARInvoiceMasterDataMgtBC gmdm = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String source = event.getInvRevAcctCdVO().getInvSrcCd();
			String revGroup = event.getInvRevAcctCdVO().getRevTpGrpCd();
			String del = event.getInvRevAcctCdVO().getDeltFlg();

			List<InvRevAcctCdVO> list = gmdm.searchRevenueAccountList(source, revGroup, del);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0076 : Save<br>
	 * save , correct, delete Revenue account info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRevenueAccount(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0076Event event = (FnsInv0076Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			begin();
			command.manageRevenueAccount(event.getInvRevAcctCdVOS(), account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0008 : retrieve <br>
	 * retrieve Daily exchange rate.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyExchangeRateList(Event e) throws EventException {
		FnsInv0008Event event = (FnsInv0008Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CustDailyExRateVO> list = command.searchDailyExchangeRateList(event.getSearchExRateVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
	 * FNS_INV_0008 : save, correct, delte <br>
	 * save, correct, delete Daily exchange rate.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse preManageCustomerDailyExchangeRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0008Event event = (FnsInv0008Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			begin();
			String[] officeArr = event.getMultiOfficeList().split(",");
			String tmpPK = command.manageCustomerDailyExchangeRateMulti(event.getCustDailyExRateVOs(), account.getUsr_id(), officeArr);
			List<DailyExchangeRateTmpVO> list = command.searchDailyExchangeRateTmpList(event.getMultiOfficeList(), tmpPK);
			//command.removeDailyExchangeRateTmpList(tmpPK);
			eventResponse.setRsVoList(list);	
			eventResponse.setETCData("tmpPK", tmpPK);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * FNS_INV_0008 : save, correct, delte <br>
	 * save, correct, delete Daily exchange rate.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyExchangeRateTmpList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0008Event event = (FnsInv0008Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			begin();
			List<DailyExchangeRateTmpVO> list = command.searchDailyExchangeRateTmpList(event.getMultiOfficeList(), event.getTmpPK());
			command.removeDailyExchangeRateTmpList(event.getTmpPK());
			eventResponse.setRsVoList(list);			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	

	/**
	 * FNS_INV_0008 : save, correct, delte <br>
	 * save, correct, delete Daily exchange rate.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustomerDailyExchangeRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0008Event event = (FnsInv0008Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		
		
		try {
			
			if(event.getCustDailyExRateVOs() != null && event.getCustDailyExRateVOs().length > 0 ) { 
				begin();
				
				String str0008Flag= "N";
				
				//FNS_INV_0008 화면에서 Multi Office 
				if(event.getCallPageName() != null && event.getCallPageName().equals("FNS_INV_0008")) {
					//for(int i=0;i<event.getCustDailyExRateVOs().length;i++) {
					//	event.getCustDailyExRateVOs()[i].setIbflag(event.getCustDailyExRateVOs()[i].getTmpIbFlag());
					//}
					str0008Flag = "Y";	//Tmp Table 에서 일괄로 체크하기 때문에.
					
				}
				
				command.manageCustomerDailyExchangeRate(event.getCustDailyExRateVOs(), account.getUsr_id(), str0008Flag);
				//환율 B/L 적용은 환율 타입이 C, D 인것만
				/*ExchangeRateVO exchangeRateVOs[] = null;
				List<ExchangeRateVO> exchangeRateList = new ArrayList<ExchangeRateVO>();
				
				
				log.debug("event.getExchangeRateVOs().length::::::" + event.getExchangeRateVOs().length);
				
				for (int i = 0; i < event.getExchangeRateVOs().length; i++) {
					log.debug("event.getExchangeRateVOs()[i]:::::" + event.getExchangeRateVOs()[i].toString());
					if (event.getExchangeRateVOs()[i].getXchRtTpCd().equals("C") || event.getExchangeRateVOs()[i].getXchRtTpCd().equals("D") ) {
						ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
						ObjectCloner.build(event.getExchangeRateVOs()[i], exchangeRateVO);
						if(str0008Flag.equals("Y")) {
							exchangeRateVO.setIbflag(event.getExchangeRateVOs()[i].getTmpIbFlag());
						}
						exchangeRateList.add(exchangeRateVO);
					}
				}
				
				int arrSize = exchangeRateList.size();
				if (arrSize > 0) {
					exchangeRateVOs = new ExchangeRateVO[arrSize];
					for (int i = 0; i < arrSize; i++) {
						//exchangeRateVOs[i] = exchangeRateList.get(i);
						ObjectCloner.build(exchangeRateList.get(i), exchangeRateVOs[i]);
					}
				}
				
				if (exchangeRateVOs != null && exchangeRateVOs.length > 0) {
					String backEndJobKey = command2.manageARInvoiceExRateList(exchangeRateVOs, account.getUsr_id());
					eventResponse.setCustomData("KEY", backEndJobKey);
				}*/
				
				String backEndCallFlag = "";
				for (int i = 0; i < event.getExchangeRateVOs().length; i++) {
					if (event.getExchangeRateVOs()[i].getXchRtTpCd().equals("C") || event.getExchangeRateVOs()[i].getXchRtTpCd().equals("D")  || event.getExchangeRateVOs()[i].getXchRtTpCd().equals("I") ) {
						backEndCallFlag = "Y";
						if(str0008Flag.equals("Y")) {
							event.getExchangeRateVOs()[i].setIbflag(event.getExchangeRateVOs()[i].getTmpIbFlag());
						}						
					}
				}
				
				if (backEndCallFlag.equals("Y")) {
					String backEndJobKey = command2.manageARInvoiceExRateList(event.getExchangeRateVOs(), account.getUsr_id());
					eventResponse.setCustomData("KEY", backEndJobKey);
				}
	
				commit();
				
				/*if(event.getCallPageName() != null && event.getCallPageName().equals("FNS_INV_0008")) {
					INVCommonUtil util = new INVCommonUtil();
					String multiOfc = util.makeInQueryStr( event.getSearchExRateVO().getMultiOfficeList(), "," );
					event.getSearchExRateVO().setMultiOfficeList(multiOfc);
					List<CustDailyExRateVO> list = command.searchDailyExchangeRateList(event.getSearchExRateVO());
					eventResponse.setRsVoList(list);
				}*/
	
				//2015.06.24 VVD Ex Rate Date 가 존재하는데 VVD 환율은 존재하지 않은경우, Daily Rate 저장시 메시지 display by IY Cho
				if(str0008Flag.equals("Y")) {
					String thirdVvd ="";
					String fmDt="";
					fmDt = event.getCustDailyExRateVOs()[0].getFmDt();
					thirdVvd = command.search3rdExRateNotExist(fmDt, event.getMultiOfficeList());
					if(!thirdVvd.equals("") && thirdVvd != null){
						eventResponse.setETCData("third_vvd", thirdVvd);
					}
				}
				
				if(!str0008Flag.equals("Y")) {
					eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
				}
			}
			
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0007 : retrieve <br>
	 * retrieve Customer exchange rate.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerExchangeRateList(Event e) throws EventException {
		
		FnsInv0007Event event = (FnsInv0007Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CustDailyExRateVO> list = command.searchCustomerExchangeRateList(event.getSearchExRateVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0013 : Retrieve<br>
	 * retrieve basic info and Customer's credit.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCreditCustomer(Event e) throws EventException {
		FnsInv0013Event event = (FnsInv0013Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		try {
			CreditCustomerVO creditCustomerVO = command.searchCreditCustomer(event.getFrmCustCntCd(), event.getFrmCustSeq(), event.getFrmCustRgstNo());
			eventResponse.setRsVo(creditCustomerVO);

			 if(creditCustomerVO == null){ 
				 eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage()); 
			 }
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0007,FNS_INV_0008,FNS_INV_0080,FNS_INV_0100 : retrieve<br>
	 * retrieve AR Office, currency list, Service Scope.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcCurrList(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		List<String> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("FnsInv0007Event")) {
				FnsInv0007Event event = (FnsInv0007Event) e;
				list = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0008Event")) {
				FnsInv0008Event event = (FnsInv0008Event) e;
				list = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0100Event")) {
				FnsInv0100Event event = (FnsInv0100Event) e;
				list = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			}
			
			List<MdmCurrencyVO> currList = command.searchCurrencyCodeList();

			StringBuffer ar_ofc_info = new StringBuffer("");
			StringBuffer currInfo = new StringBuffer("");

			if(list != null){
				for (int i = 0; i < list.size(); i++) {
					ar_ofc_info.append("|").append(list.get(i));
				}
			}
			
			if(currList != null){
				for (int i = 0; i < currList.size(); i++) {
					currInfo.append("|").append(currList.get(i).getCurrCd());
				}
			}
			
			if (e.getEventName().equalsIgnoreCase("FnsInv0100Event")) {
				List<String> scpList = command.searchServiceScopeList();

				StringBuffer svcCd = new StringBuffer("ALL");

				for (int i = 0; i < scpList.size(); i++) {
					svcCd.append("|").append(scpList.get(i));
				}

				svcCd.append("|").append("OTH");
				eventResponse.setETCData("svc_scp_cd", svcCd.toString());
			}

			eventResponse.setETCData("ar_ofc_cd", ar_ofc_info.toString());
			eventResponse.setETCData("currInfo", currInfo.toString());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	
	/**
	 * FNS_INV_0086 : Retrieve<br>
	 * retrieve  Customer List.(use POP UP UI)<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopCustomerList(Event e) throws EventException {
		FnsInv0086Event event = (FnsInv0086Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<PopCustomerListVO> list = command.searchPopCustomerList(event.getCntry(), event.getCustNm(), event.getZipNo(), event.getChkNm(), event.getCustRgstNo());
			eventResponse.setRsVoList(list);
			if (list.size() <= 0) {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0089: save, correct, delete <br>
	 * Multi save, correct, delete Customer exchange rate.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMultiCustomerExRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0089Event event = (FnsInv0089Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		try {
			begin();
			command.manageMultiCustomerExRate(event.getMultiCustomerVOs(), event.getCustDailyExRateVOs(), account.getUsr_id());
			commit();
			
			begin();
			String backEndJobKey = command2.manageARInvoiceExRateList(event.getExchangeRateVOs(), account.getUsr_id());
			commit();
			eventResponse.setCustomData("KEY", backEndJobKey);

			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			

		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00001").getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0089: 조회<br>
	 * retrieve Customer exchange rate by month.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerMonExRate(Event e) throws EventException {
		FnsInv0089Event event = (FnsInv0089Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		int cnt = 0;
		try {
			cnt = command.searchCustomerMonExRate(event.getCustCndCd(), event.getCustSeq(), event.getMon());
			eventResponse.setETCData("cnt", Integer.toString(cnt));
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0072 : Retrieve<br>
	 * retrieve cut off lane AR office list.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCutOffLaneListByAROffice(Event e) throws EventException {
		FnsInv0072Event event = (FnsInv0072Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<InvCutOffLaneVO> list = command.searchCutOffLaneListByAROffice(event.getOldOfc(), event.getNewOfc());
			eventResponse.setRsVoList(list);
			if (list.size() <= 0) {
				eventResponse.setUserMessage(new ErrorHandler("COM10053").getUserMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0072 : Save<br>
	 * save, correct, delete Cut Off Lane info by A/R Office<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCutOffLaneByAROffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0072Event event = (FnsInv0072Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			begin();
			command.manageCutOffLaneByAROffice(event.getInvCutOffLaneVOS(), account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			// eventResponse.setUserMessage("OK");
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0072 : Lane FOCUS OUT<br>
	 * validate lane code.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcLane(Event e) throws EventException {
		FnsInv0072Event event = (FnsInv0072Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String slanCd = command.searchSvcLane(event.getSlanCd());
			eventResponse.setETCData("dataVal", slanCd);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0072 : Port FOCUS OUT, FNS_INV_0020 : check LocCd <br>
	 * validate Port code.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocation(Event e) throws EventException {		
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("FnsInv0072Event")) {
				FnsInv0072Event event = (FnsInv0072Event) e;
				String portCd = command.searchLocation(event.getPortCd());
				eventResponse.setETCData("dataVal", portCd);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0072 : vvd FOCUS OUT<br>
	 * validate VVD.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0072Event event = (FnsInv0072Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		INVCommonUtil command2 = new INVCommonUtil();
		try {
			String saDate = "";
			String vslCd = command.searchVVD(event.getVslCd(), event.getSkdVoyNo(), event.getSkdDirCd());
			eventResponse.setETCData("dataVal", vslCd);
			if (vslCd.length() > 0) {
				saDate = command2.searchSADate(event.getVslCd() + event.getSkdVoyNo() + event.getSkdDirCd(), event.getPortCd(), event.getIoBndCd());
				eventResponse.setETCData("saDate", saDate);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0090 : retrieve<br>
	 * retrieve RFA.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFACustomerList(Event e) throws EventException {
		FnsInv0090Event event = (FnsInv0090Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<PriCustomerListVO> list = command.searchRFACustomerList(event.getRfaNo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0091 : retrieve <br>
	 * retrieve SC.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCCustomerList(Event e) throws EventException {
		FnsInv0091Event event = (FnsInv0091Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<PriCustomerListVO> list = command.searchSCCustomerList(event.getScNo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * FNS_INV_0073 : Retrieve<br>
	 * retrieve invoice issue standard by office.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIssueStandardByOffice(Event e) throws EventException {
		FnsInv0073Event event = (FnsInv0073Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			InvArStupOfcVO invArStupOfcVO = command.searchIssueStandardByOffice(event.getArOfcCd());
			if(invArStupOfcVO != null){
				String chgCd = invArStupOfcVO.getChgCd();
				if(chgCd != null){
					eventResponse.setETCData("chg_cd", chgCd);
				}	
				eventResponse.setRsVo(invArStupOfcVO);	
			}else{
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0073 : Save<br>
	 * save, correct invoice issue standard by A/R Office.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIssueStandardByOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0073Event event = (FnsInv0073Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			begin();
			event.getInvArStupOfcVO().setCreUsrId(account.getUsr_id());
			event.getInvArStupOfcVO().setUpdUsrId(account.getUsr_id());

			command.manageIssueStandardByOffice(event.getInvArStupOfcVO());

			command.manageMriChgcdByOffice(event.getArOfcCd(), event.getChgCd(), account.getUsr_id());

			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			// eventResponse.setUserMessage("OK");
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * FNS_INV_0100,FNS_INV_0101 : retrieve<br>
	 * retrieve port by SvrID,OfcCd. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String svrId = "";
		String ofcCd = "";
		String pageType = "";
		try {
			if (e.getEventName().equalsIgnoreCase("FnsInv0100Event")) {
				FnsInv0100Event event = (FnsInv0100Event) e;
				svrId = event.getSvrId();
				ofcCd = event.getOfcCd();

			} else if (e.getEventName().equalsIgnoreCase("FnsInv0101Event")) {
				FnsInv0101Event event = (FnsInv0101Event) e;
				svrId = event.getSvrId();
				ofcCd = event.getOfcCd();
				
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0105Event")) {
				FnsInv0105Event event = (FnsInv0105Event) e;
				svrId = event.getSvrId();
				ofcCd = event.getOfcCd();
			}

			INVCommonUtil bcommand = new INVCommonUtil();

			List<String> ofcList = null;
			// officeList
			ofcList = bcommand.searchAROfficeList(account.getOfc_cd(), pageType);

			// currList
			List<MdmCurrencyVO> currList = bcommand.searchCurrencyCodeList();

			// log.info(currList);

			StringBuffer arOfcInfo = new StringBuffer("");
			StringBuffer currInfo = new StringBuffer("");

			for (int i = 0; i < ofcList.size(); i++) {
				arOfcInfo.append("|").append(ofcList.get(i));

				StringTokenizer stTemp = new StringTokenizer(ofcList.get(i), "^");
				List<String> ofcTemp = new ArrayList<String>();
				String ofcStrTemp = null;
				while (stTemp.hasMoreTokens()) {
					ofcStrTemp = stTemp.nextToken();
					ofcTemp.add(ofcStrTemp);
				}
				if (account.getOfc_cd().equals(ofcTemp.get(1))) {
					if (svrId.trim().length() < 1) {
						svrId = ofcTemp.get(7).toString();
					}
					if (ofcCd.trim().length() < 1) {
						ofcCd = ofcTemp.get(1).toString();
					}
				}
			}

			for (int i = 0; i < currList.size(); i++) {
				currInfo.append("|").append(currList.get(i).getCurrCd()).append("^").append(currList.get(i).getCurrNm());
			}

			List<String> scpList = bcommand.searchServiceScopeList();

			StringBuffer svcCd = new StringBuffer("ALL");
			for (int i = 0; i < scpList.size(); i++) {
				svcCd.append("|").append(scpList.get(i));
			}
			svcCd.append("|").append("OTH");

			ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();

			List<String> list = command.searchPortList(svrId, ofcCd);

			StringBuffer portList = new StringBuffer("ALL");
			for (int i = 0; i < list.size(); i++) {
				portList.append("|").append(list.get(i));
			}

			eventResponse.setETCData("svc_scp_cd", svcCd.toString());
			eventResponse.setETCData("ar_ofc_cd", arOfcInfo.toString());
			eventResponse.setETCData("currInfo", currInfo.toString());
			eventResponse.setETCData("portList", portList.toString());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0100 : retrieve <br>
	 * retrieve Port list by IN/OUTBOUND. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortListByBnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0100Event event = (FnsInv0100Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			List<VVDandPortListVO> list = command.searchPortListByBnd(event.getSearchVVDPortVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0100 : 조회 <br>
	 * retrieve Port list when select Triangle.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortListByTri(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0100Event event = (FnsInv0100Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			List<VVDandPortListVO> list = command.searchPortListByTri(event.getSearchVVDPortVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0100 : 조회 <br>
	 * retrieve  PORT list when SVR_ID is EUR<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEURPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0100Event event = (FnsInv0100Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			List<VVDandPortListVO> list = command.searchEURPortList(event.getSearchVVDPortVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0100 : save,correct,delete<br>
	 * save VVD rate.<br>
	 * interface ERP AR.(EAI : FNS019-0002).<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createVVDExchangeRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0100Event event = (FnsInv0100Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		try {
			begin();
			
			String svrId = event.getSvrId();
			String triYn = event.getTriYn();
			String ofc = event.getOfcCd();
			
			List<VVDandPortListVO> vVDandPortListVOs = event.getVvdAndPortListVOs();				
			ExchangeRateVO[] exchangeRateVOs = event.getExchangeRateVOs();
			ExchangeRateVO[] allExchangeRateVOs = null;
			List<VVDExrateVO> vVDExrateVOs = event.getVvdExrateVOs();
			List<VVDExrateVO> allVVDExrateVOs = new ArrayList<VVDExrateVO>();
			
			allVVDExrateVOs.addAll(vVDExrateVOs);
			
			log.debug("allVVDExrateVOs="+allVVDExrateVOs.size());
			
			if(svrId.equals("EUR")&&triYn.equals("N")){
				List<VVDandPortListVO> allVvdPortVOs = new ArrayList<VVDandPortListVO>();
				
				if(vVDandPortListVOs.size()>0){
					for(int i = 0 ; i < vVDandPortListVOs.size() ; i ++){
						List<VVDandPortListVO> vvdPortVOs= command.searchEURVVDList(vVDandPortListVOs.get(i).getVvdCd());						
						allVvdPortVOs.addAll(vvdPortVOs);
					}
				}
				
				
				BigDecimal usdInvXchRt = new BigDecimal("0");
				
				for (int i = 0; i < vVDExrateVOs.size(); i++) {
					if(vVDExrateVOs.get(i).getChgCurrCd().equals("USD")){
						usdInvXchRt = new BigDecimal(vVDExrateVOs.get(i).getInvXchRt());
					}
				}
				
				for (int i = 0; i < vVDExrateVOs.size(); i++) {
					
					int currCnt = command.searchARCurrCd( ofc, vVDExrateVOs.get(i).getChgCurrCd() );
					
					if(currCnt > 0){
						if(!vVDExrateVOs.get(i).getChgCurrCd().equals("USD")){
							VVDExrateVO vVDExrateVO = new VVDExrateVO();						
							
							vVDExrateVO.setLoclCurrCd(vVDExrateVOs.get(i).getChgCurrCd());
							vVDExrateVO.setChgCurrCd(vVDExrateVOs.get(i).getLoclCurrCd());
							vVDExrateVO.setInvXchRt(vVDExrateVOs.get(i).getIvsXchRt());
							vVDExrateVO.setIvsXchRt(vVDExrateVOs.get(i).getInvXchRt());
							vVDExrateVO.setArOfcCd(vVDExrateVOs.get(i).getArOfcCd());	
							
							allVVDExrateVOs.add(vVDExrateVO);
							
							if( !usdInvXchRt.toString().equals("0")){
								vVDExrateVO = new VVDExrateVO();	
								
								BigDecimal invXchRt = new BigDecimal(vVDExrateVOs.get(i).getInvXchRt());
								
								//BigDecimal exRate = invXchRt.divide(usdInvXchRt,6,BigDecimal.ROUND_UP);
								//BigDecimal ivsXchRt = usdInvXchRt.divide(invXchRt,6,BigDecimal.ROUND_UP);
								
								BigDecimal ivsXchRt = invXchRt.divide(usdInvXchRt,6,BigDecimal.ROUND_UP);
								BigDecimal exRate = usdInvXchRt.divide(invXchRt,6,BigDecimal.ROUND_UP);
								
								//vVDExrateVO.setLoclCurrCd("USD");
								//vVDExrateVO.setChgCurrCd(vVDExrateVOs.get(i).getChgCurrCd());
								vVDExrateVO.setLoclCurrCd(vVDExrateVOs.get(i).getChgCurrCd());
								vVDExrateVO.setChgCurrCd("USD");
								
								vVDExrateVO.setInvXchRt(exRate.toString());
								vVDExrateVO.setIvsXchRt(ivsXchRt.toString());
								vVDExrateVO.setArOfcCd(vVDExrateVOs.get(i).getArOfcCd());	
								
								allVVDExrateVOs.add(vVDExrateVO);
							}
						}
					}
				}
				
				log.debug("allVVDExrateVOs2="+allVVDExrateVOs.size());				
				
				command.createVVDExchangeRate(allVvdPortVOs, allVVDExrateVOs, account.getUsr_id());
				
				List<ExchangeRateVO> allExRateVOs = new ArrayList<ExchangeRateVO>();								
				
				for (int i = 0; i < exchangeRateVOs.length; i++) {
					
					for (int j = 0; j < allVvdPortVOs.size(); j++) {					
						ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
						exchangeRateVO.setVslCd(allVvdPortVOs.get(j).getVvdCd().substring(0,4));
						exchangeRateVO.setSkdVoyNo(allVvdPortVOs.get(j).getVvdCd().substring(4,8));
						exchangeRateVO.setSkdDirCd(allVvdPortVOs.get(j).getVvdCd().substring(8,9));
						exchangeRateVO.setIoBndCd(allVvdPortVOs.get(j).getIoBndCd());
						exchangeRateVO.setPortCd(allVvdPortVOs.get(j).getVpsPortCd());
						exchangeRateVO.setSvcScpCd(allVvdPortVOs.get(j).getSvcScpCd());
						exchangeRateVO.setChgCurrCd(exchangeRateVOs[i].getChgCurrCd());
						exchangeRateVO.setLoclCurrCd(exchangeRateVOs[i].getLoclCurrCd());
						exchangeRateVO.setXchRtTpCd(exchangeRateVOs[i].getXchRtTpCd());
						exchangeRateVO.setInvXchRt(exchangeRateVOs[i].getInvXchRt());
						exchangeRateVO.setIbflag(exchangeRateVOs[i].getIbflag());
						allExRateVOs.add(exchangeRateVO);
					}
				}
				
				log.debug("allExRateVOs="+allExRateVOs.size());				
				
				for (int i = 0; i < exchangeRateVOs.length; i++) {
					for (int j = 0; j < allVvdPortVOs.size(); j++) {						
						
						int currCnt = command.searchARCurrCd( ofc, exchangeRateVOs[i].getChgCurrCd() );
						
						if(!exchangeRateVOs[i].getChgCurrCd().equals("USD") && currCnt > 0){
							ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
							exchangeRateVO.setVslCd(allVvdPortVOs.get(j).getVvdCd().substring(0,4));
							exchangeRateVO.setSkdVoyNo(allVvdPortVOs.get(j).getVvdCd().substring(4,8));
							exchangeRateVO.setSkdDirCd(allVvdPortVOs.get(j).getVvdCd().substring(8,9));
							exchangeRateVO.setIoBndCd(allVvdPortVOs.get(j).getIoBndCd());
							exchangeRateVO.setPortCd(allVvdPortVOs.get(j).getVpsPortCd());
							exchangeRateVO.setSvcScpCd(allVvdPortVOs.get(j).getSvcScpCd());
							exchangeRateVO.setChgCurrCd(exchangeRateVOs[i].getLoclCurrCd());
							exchangeRateVO.setLoclCurrCd(exchangeRateVOs[i].getChgCurrCd());
							exchangeRateVO.setXchRtTpCd(exchangeRateVOs[i].getXchRtTpCd());
							exchangeRateVO.setInvXchRt(exchangeRateVOs[i].getIvsXchRt());
							exchangeRateVO.setIbflag(exchangeRateVOs[i].getIbflag());
							allExRateVOs.add(exchangeRateVO);
							
							if( !usdInvXchRt.toString().equals("0")){
								
								exchangeRateVO = new ExchangeRateVO();
								
								BigDecimal invXchRt = new BigDecimal(exchangeRateVOs[i].getInvXchRt());	
								//BigDecimal exRate = invXchRt.divide(usdInvXchRt,6,BigDecimal.ROUND_UP);
								BigDecimal exRate = usdInvXchRt.divide(invXchRt,6,BigDecimal.ROUND_UP);
								
								log.debug("invXchRt="+invXchRt);
								log.debug("exRate="+exRate);
								
								exchangeRateVO.setVslCd(allVvdPortVOs.get(j).getVvdCd().substring(0,4));
								exchangeRateVO.setSkdVoyNo(allVvdPortVOs.get(j).getVvdCd().substring(4,8));
								exchangeRateVO.setSkdDirCd(allVvdPortVOs.get(j).getVvdCd().substring(8,9));
								exchangeRateVO.setIoBndCd(allVvdPortVOs.get(j).getIoBndCd());
								exchangeRateVO.setPortCd(allVvdPortVOs.get(j).getVpsPortCd());
								exchangeRateVO.setSvcScpCd(allVvdPortVOs.get(j).getSvcScpCd());
								//exchangeRateVO.setChgCurrCd(exchangeRateVOs[i].getChgCurrCd());
								//exchangeRateVO.setLoclCurrCd("USD");
								exchangeRateVO.setChgCurrCd("USD");
								exchangeRateVO.setLoclCurrCd(exchangeRateVOs[i].getChgCurrCd());
								exchangeRateVO.setXchRtTpCd(exchangeRateVOs[i].getXchRtTpCd());
								exchangeRateVO.setInvXchRt(exRate.toString());
								exchangeRateVO.setIbflag(exchangeRateVOs[i].getIbflag());
								allExRateVOs.add(exchangeRateVO);
							}
						}
					}
				}
				
				log.debug("allExRateVOs2="+allExRateVOs.size());		
				
				allExchangeRateVOs = new ExchangeRateVO[allExRateVOs.size()];
				allExchangeRateVOs = allExRateVOs.toArray(allExchangeRateVOs);
				
			}else{
				command.createVVDExchangeRate(vVDandPortListVOs, event.getVvdExrateVOs(), account.getUsr_id());
				
				List<ExchangeRateVO> allExRateVOs = new ArrayList<ExchangeRateVO>();
				
				for (int i = 0; i < exchangeRateVOs.length; i++) {					
					for (int j = 0; j < vVDandPortListVOs.size(); j++) {
						ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
						exchangeRateVO.setVslCd(vVDandPortListVOs.get(j).getVvdCd().substring(0,4));
						exchangeRateVO.setSkdVoyNo(vVDandPortListVOs.get(j).getVvdCd().substring(4,8));
						exchangeRateVO.setSkdDirCd(vVDandPortListVOs.get(j).getVvdCd().substring(8,9));
						exchangeRateVO.setIoBndCd(vVDandPortListVOs.get(j).getIoBndCd());
						exchangeRateVO.setPortCd(vVDandPortListVOs.get(j).getVpsPortCd());
						exchangeRateVO.setSvcScpCd(vVDandPortListVOs.get(j).getSvcScpCd());
						exchangeRateVO.setChgCurrCd(exchangeRateVOs[i].getChgCurrCd());
						exchangeRateVO.setLoclCurrCd(exchangeRateVOs[i].getLoclCurrCd());
						exchangeRateVO.setXchRtTpCd(exchangeRateVOs[i].getXchRtTpCd());
						exchangeRateVO.setInvXchRt(exchangeRateVOs[i].getInvXchRt());
						exchangeRateVO.setIvsXchRt(exchangeRateVOs[i].getIvsXchRt());
						exchangeRateVO.setIbflag(exchangeRateVOs[i].getIbflag());
						allExRateVOs.add(exchangeRateVO);
					}
				}
				
				allExchangeRateVOs = new ExchangeRateVO[allExRateVOs.size()];
				allExchangeRateVOs = allExRateVOs.toArray(allExchangeRateVOs);				
			}
			commit();
			
			begin();			
			command2.manageARInvoiceExRateList(allExchangeRateVOs, account.getUsr_id());			
			commit();
			
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			eventResponse.setRsVoList(Arrays.asList(allExchangeRateVOs));
			
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0101 : retrieve<br>
	 * retrieve VVD rate.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDExchangeRateList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0101Event event = (FnsInv0101Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			List<VVDExrateVO> list = command.searchVVDExchangeRateList(event.getSearchVVDExRateVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0101 : retrieve<br>
	 * retrieve VVD USD rate.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*private EventResponse searchVVDSADate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0101Event event = (FnsInv0101Event) e;
		INVCommonUtil command = new INVCommonUtil();
		try {
			
			//2009-11-30 경리환율 체크시 SA Date 가 아닌 SysMon 으로 변경 이상희과장			
			String saDt = DateTime.getDateString().replace(".", "").substring(0,6);
			
			String usd_locl_xch_rt = "";
			if (!saDt.equals("")) {
				saDt = saDt.replace("-", "").substring(0, 6);

				String from_currCd = event.getFromCurrCd();
				String to_currCd = event.getToCurrCd();
				String effDt = saDt;

				usd_locl_xch_rt = command.searchAccountRate(from_currCd, to_currCd, effDt);

			} else {
				usd_locl_xch_rt = "saDt";
			}

			eventResponse.setETCData("usd_locl_xch_rt", usd_locl_xch_rt);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}*/

	/**
	 * FNS_INV_0101 : retrieve<br>
	 * retrieve AR invoice.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARInvoiceExist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0101Event event = (FnsInv0101Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			String cnt = command.searchARInvoiceExist(event.getExchangeRateVO());
			eventResponse.setETCData("cnt", cnt);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0101 : save,correct,delete<br>
	 * manage VVD rate.<br>
	 * interface ERP AR.(EAI : FNS019-0002)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVVDExchangeRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0101Event event = (FnsInv0101Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		try {

			begin();
			command.manageVVDExchangeRate(event.getVvdExrateVOs(), account.getUsr_id());
			commit();
			
			begin();
			String backEndJobKey = command2.manageARInvoiceExRateList(event.getExchangeRateVOs(), account.getUsr_id());
			commit();
			eventResponse.setCustomData("KEY", backEndJobKey);
			
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * FNS_INV_0006 : retrieve<br>
	 * retrieve exchange rate.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExchangeRateList(Event e) throws EventException {
		FnsInv0006Event event = (FnsInv0006Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ExRateListVO exRateListVO = command.searchExchangeRateList(event.getSearchVVDExRateVO());

			String xchRtTpCd = event.getSearchVVDExRateVO().getXchRtTpCd();

			if (xchRtTpCd.equals("V")) {
				eventResponse.setRsVoList(exRateListVO.getVvdExrateList());
			} else if (xchRtTpCd.equals("I") || xchRtTpCd.equals("C") || xchRtTpCd.equals("D")) {
				eventResponse.setRsVoList(exRateListVO.getCustDailyExRateList());
			} else if (xchRtTpCd.equals("A")) {
				eventResponse.setRsVoList(exRateListVO.getGlMonExrateList());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0108<br>
	 * retrieve INVOICE Printer Set up info.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchINVPrinterbyUserId(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0108Event event = (FnsInv0108Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();

		try {
			List<PrinterbyUserIdVO> printerbyUserIdVO = command.searchINVPrinterbyUserId(event.getOfcCd(), event.getUsrId());
			eventResponse.setETCData("ArOfcCd", printerbyUserIdVO.get(0).getArOfcCd());
			eventResponse.setETCData("InvPrnDvcNm", printerbyUserIdVO.get(0).getInvPrnDvcNm());
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * FNS_INV_0108<br>
	 * save, correct INVOICE Printer Set up info.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageINVPrinterName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0108Event event = (FnsInv0108Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		
		try{
			begin();
			command.manageINVPrinterName(event.getArOfcCd(), account.getUsr_id(), event.getInvPrnDvcNm());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * FNS_INV_0073 : Open<br>
	 * retrieve ofc cd,chg cd<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeCodeList(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		List<String> ofcList = null;
		List<MdmChargeVO> chgCodeList = null;
		FnsInv0073Event event = (FnsInv0073Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ofcList = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			chgCodeList = command.searchChargeCodeList();

			StringBuffer arOfcInfo = new StringBuffer("");
			for (int i = 0; i < ofcList.size(); i++) {
				arOfcInfo.append("|").append(ofcList.get(i));
			}
			StringBuffer chgCodeInfo = new StringBuffer("");
			for (int i = 0; i < chgCodeList.size(); i++) {
				if (!chgCodeList.get(i).getChgCd().trim().equals("")) {
					chgCodeInfo.append("|").append(chgCodeList.get(i).getChgCd());
				}
			}
			eventResponse.setETCData("ar_ofc_cd", arOfcInfo.toString());
			eventResponse.setETCData("chg_cd", chgCodeInfo.toString());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * FNS_INV_0072 : Open<br>
	 * A/R Office list(contain office basic info)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROfficeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();

		
		try {
			List<String> list = command.searchAROfficeList(account.getOfc_cd());

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
	 * FNS_INV_0102 : Retrieve<br>
	 * CPR(Customer preFerable Report)에서 사용할 code로 조회조건으로 입력한 ,S/C NO, RFA NO, Code 유형으로 조회한다.
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeConversionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0102Event event = (FnsInv0102Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			List<InvCprtCdConvVO> list = command.searchCodeConversionList(event.getScNo(), event.getRfaNO(), event.getCodeTy());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0102 : S/C NO or RFA NO@FOCUS OUT<br>
	 * CPR 에서 사용.(입력한 S/C NO or RFA NO 로 PRI 정보에서 Customer name를 찾아와 보여준다.
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0102Event event = (FnsInv0102Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			String customerName = command.searchCustomerName(event.getScNo(), event.getRfaNO());
			eventResponse.setETCData("customerName", customerName);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0102 : COMPANY CODE FOCUS OUT<br>
	 * 입력한 CODE가 유형별로 사용 가능한 유효한 code인지를 CHECK한다.
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCompanyCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0102Event event = (FnsInv0102Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			String coCode = command.searchCompanyCode(event.getCdTp(), event.getCd());
			eventResponse.setETCData("coCode", coCode);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0102 : Save<br>
	 * CPR(Customer preFerable Report)에서 사용할 code. <br>
	 * 입력된 Conversion code 들을 선택한 유형으로 S/C NO 나 RFA NO 별로 등로가, 수정,삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCodeConversion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0102Event event = (FnsInv0102Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			begin();
			command.manageCodeConversion(event.getInvCprtCdConvVOs(), account.getUsr_id());
			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0102 : Copy to now<br>
	 * CPR(Customer preFerable Report)에서 사용할 code. <br>
	 * 이미 입력된 Conversion code 들을 입력한 S/C NO 나 RFA NO 로 동일 하게 신규생성해 준다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCodeConversion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0102Event event = (FnsInv0102Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			begin();
			command.createCodeConversion(event.getInvCprtCdConvVOs(), account);
			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0105 : VVD에 해당하는 PORT/SCOPE를 조회하여 해당 List에 Setting한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortScpListbyVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		String vvd = "";
		try {
			if (e.getEventName().equalsIgnoreCase("FnsInv0101Event")) {
				FnsInv0101Event event = (FnsInv0101Event) e;
				vvd = event.getVvd();
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0105Event")) {
				FnsInv0105Event event = (FnsInv0105Event) e;
				vvd = event.getVvd();
			}

			List<String> portList = command.searchPortListbyVVD(vvd);

			StringBuffer portCd = new StringBuffer("ALL");
			for (int i = 0; i < portList.size(); i++) {
				portCd.append("|").append(portList.get(i));
			}
			
			List<String> svcScpList = command.searchSvcScpByLane(vvd);

			StringBuffer svcScpCd = new StringBuffer("ALL");
			for (int i = 0; i < svcScpList.size(); i++) {
				svcScpCd.append("|").append(svcScpList.get(i));
			}
			
			eventResponse.setETCData("portList", portCd.toString());
			eventResponse.setETCData("svcScpList", svcScpCd.toString());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0105 : INV_VVD_XCH_RT_DT 테이블에 조건에 해당하는 환율기준날짜를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDExRateDateList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0105Event event = (FnsInv0105Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			List<VVDExrateVO> list = command.searchVVDExRateDateList(event.getSearchVVDExRateVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * FNS_INV_0105 : VVD 환율기준날짜 및 VVD 환율을 입력/수정/삭제한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVVDExRateDate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0105Event event = (FnsInv0105Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		List<ExchangeRateVO> allList = new ArrayList<ExchangeRateVO>();
		
		try {

			begin();
			List<VVDExrateVO> targetVoList = command.manageVVDExchangeRateDate(event.getVvdExrateVOs(), account.getUsr_id(), event.getUiFlag());
			commit();

			for(int i = 0; i < targetVoList.size(); i++){
				List<ExchangeRateVO> list = command.searchVVDExRate(targetVoList.get(i));
				allList.addAll(list);
			}
			
			ExchangeRateVO[] exchangeRateVos = new ExchangeRateVO[allList.size()];
			
			for(int j = 0; j < allList.size(); j++){
				exchangeRateVos[j] = allList.get(j);
			}
			
			begin();
			String backEndJobKey = command2.manageARInvoiceExRateList(exchangeRateVos, account.getUsr_id());
			commit();
		
			eventResponse.setCustomData("KEY", backEndJobKey);
			
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0105 : INV_VVD_XCH_RT_DT_HIS 테이블에서 환율기준날짜 History 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDExRateDateHistList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0107Event event = (FnsInv0107Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			List<VVDExrateDateHisVO> list = command.searchVVDExRateDateHistList(event.getVvdExrateDateHisVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0105 : INV AR CHARGE 테이블에서 해당 환율이 반영된 데이터가 존재하는지 체크한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARInvoiceExist2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0105Event event = (FnsInv0105Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			String cnt = command.searchARInvoiceExist2(event.getVvdExrateVOs());
			eventResponse.setETCData("cnt", cnt);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0105 : DAILY 환율 (환율타입:V) 이 존재하는지 체크한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyExRateExist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0105Event event = (FnsInv0105Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			String ex_cnt = command.searchDailyExRateExist(event.getVvdExrateVOs());
			eventResponse.setETCData("ex_cnt", ex_cnt);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * FNS_INV_0081 : retrieve <br>
	 * retrieve exchange rate history<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExRateHistoryList(Event e) throws EventException {
		FnsInv0081Event event = (FnsInv0081Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ExRateHistoryVO> list = command.searchExRateHistoryList(event.getSearchExRateVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
}