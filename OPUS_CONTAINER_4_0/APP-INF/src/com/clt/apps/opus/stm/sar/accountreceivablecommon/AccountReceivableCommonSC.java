/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableCommonSC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.03.03 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.fin.financemanagement.financecreation.vo.GlEstmRevVvdVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopSupplierListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic.AccountReceivableCollectIFBC;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic.AccountReceivableCollectIFBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBC;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar0001Event;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar0002Event;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar0003Event;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar0005Event;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar0141Event;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar4001Event;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar9002Event;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar9003Event;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar9999Event;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSarCommonEvent;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration.AccountReceivableCommonDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARAcctListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARCustomerVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AROfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARRhqListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARRhqOfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AcctTypeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ApOfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.BankListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CreditCustomerVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CurrencyCodeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.OfficeAddInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.OtsSourceExcludeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PopCustomerListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.RevAcctMatrixInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.basic.AccountReceivableOutstandingIFBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstandingif.basic.AccountReceivableOutstandingIFBCImpl;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBC;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * AccountReceivableCommon Business Logic ServiceCommand 
 * - Handling AccountReceivableCommon Business transaction.
 * 
 * @author 
 * @see AccountReceivableCommonDBDAO
 * @since J2EE 1.6
 */ 

public class AccountReceivableCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Precede AccountReceivableCommon system <br>
	 *  Create Object when STM_SAR job call<br>
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
	 * Follow AccountReceivableCommon system<br>
	 * Release Object when STM_SAR job end<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableCommonSC 종료");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  AccountReceivableCommon system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("StmSarCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchExchangeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEffectiveDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchAROfficeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAgentOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchAccountType(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchARCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchLocalTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchCurrencyCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchARRhqList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchARAcctList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchARRhqOfficeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchMDMChargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {	//2014.08.25 add
				eventResponse = checkMiscLimitAmount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchCtrlOfficeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchCollectionOfficeList(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchAROfficePlusRepList(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchIsHiddenInoice(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = searchLoginUserOfcType(e); 
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBankList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSar0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopAPOfficeList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSar0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopSupplierList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSar0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMultiOfficeCodeList(e);
			}		
		}else if (e.getEventName().equalsIgnoreCase("StmSar0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOtsSourceExcludeList(e);
			}		
		}else if (e.getEventName().equalsIgnoreCase("StmSar4001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevAcctMatrixInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRevAcctMatrixInfo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSar0141Event")) {		
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	
				eventResponse = searchPopAccountTypeList(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("StmSar9002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCreditCustomer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar9003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopCustomerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar9999Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) { 
				eventResponse = executePgm(e,FormCommand.COMMAND01);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = executePgm(e,FormCommand.COMMAND02);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = executePgm(e,FormCommand.COMMAND03);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = executePgm(e,FormCommand.COMMAND04);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = executePgm(e,FormCommand.COMMAND05);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = executePgm(e,FormCommand.COMMAND06);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = executePgm(e,FormCommand.COMMAND07);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)) {
				eventResponse = executePgm(e,FormCommand.COMMAND08);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = executePgm(e,FormCommand.COMMAND09);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)) {
				eventResponse = executePgm(e,FormCommand.COMMAND10);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				eventResponse = executePgm(e,FormCommand.COMMAND11);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND12)) {
				eventResponse = executePgm(e,FormCommand.COMMAND12);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)) {
				eventResponse = createMissVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND14)) {
				eventResponse = createMigVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND15)) {
				eventResponse = createOutstandingByInterface(e);
			}
		}
		return eventResponse;
	}

	/**
	 * Search Exchange Rate <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExchangeRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String exRate = "";
		
		try {
			String xchRtTpCd = event.getARExrateVO().getXchRtTpCd();
			
			if(xchRtTpCd.equals("V")){
				exRate = command.searchVVDExrate(event.getARExrateVO());
			} else if(xchRtTpCd.equals("I")){
				exRate = command.searchIndExrate(event.getARExrateVO());
			} else if(xchRtTpCd.equals("D")){
				exRate = command.searchDailyExrate(event.getARExrateVO());
			} else if(xchRtTpCd.equals("A")){
				exRate = command.searchAccountExrate(event.getARExrateVO());
			} else {
				exRate = command.searchAccountExrate(event.getARExrateVO());
			}
			
			eventResponse.setETCData("ex_rate", exRate);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search Effective Date <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEffectiveDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String newEffDt = command.searchEffectiveDate(event.getEffDt(), event.getOfcCd(), event.getSysDivCd());
			
			eventResponse.setETCData("new_eff_dt", newEffDt);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search AR Office List <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			List<AROfficeListVO> list = command.searchAROfficeList(account.getOfc_cd(), event.getOfcLvlTp(), event.getOfcBrncAgnTpCd());
			StringBuffer sb =  new StringBuffer("");
			
			for(int i = 0; i < list.size(); i++){
				sb.append("|").append(list.get(i).getOtsOfcCd()).append("^");
				sb.append(list.get(i).getArOfcCd()).append("^").append(list.get(i).getRhqCd()).append("^");
				sb.append(list.get(i).getOtsSmryCd()).append("^").append(list.get(i).getOtsCd()).append("^");
				sb.append(list.get(i).getRepOtsOfcCd()).append("^").append(list.get(i).getRctTpCd()).append("^");
				sb.append(list.get(i).getRctUnapyFlg()).append("^").append(list.get(i).getOfcEntrLvlCd()).append("^");
				sb.append(list.get(i).getArCurrCd()).append("^").append(list.get(i).getDpPrcsKnt()).append("^");
				sb.append(list.get(i).getBankCtrlCd()).append("^").append(list.get(i).getAgnCurrCd()).append("^");
				sb.append(list.get(i).getAgnPfxCd()).append("^").append(list.get(i).getAgnOtsLmtAmt()).append("^");
				sb.append(list.get(i).getOfcBrncAgnTpCd()).append("^").append(list.get(i).getAgnCmbCd()).append("^");
				sb.append(list.get(i).getRctDocCd());
			}
			
			eventResponse.setETCData("ots_ofc_cd", sb.toString());
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search Office in RHQ  List <br>
	 * 
	 * @author JunYong Lee
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARRhqOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			List<ARRhqOfficeListVO> list = command.searchARRhqOfficeList(event.getArRhqCd());
			
			StringBuffer sb = new StringBuffer("");
			
			for (int i = 0; i < list.size(); i++) {
				sb.append("|").append(list.get(i).getOtsOfcCd());
			}
			
			eventResponse.setETCData("ots_ofc_cd", sb.toString());
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search RHQ List <br>
	 * 
	 * @author JunYong Lee
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARRhqList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			List<ARRhqListVO> list = command.searchARRhqList(event.getRhqCd());
			
			StringBuffer sb = new StringBuffer("");
			
			for (int i = 0; i < list.size(); i++) {
				sb.append("|").append(list.get(i).getRhqCd());
			}
			
			eventResponse.setETCData("rhq_cd", sb.toString());
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search Account List <br>
	 * 
	 * @author JunYong Lee
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARAcctList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			List<ARAcctListVO> list = command.searchARAcctList(event.getAcctCd());
			
			StringBuffer sb = new StringBuffer("");
			
			for (int i = 0; i < list.size(); i++) {
				sb.append("|").append(list.get(i).getArAcctCd()).append("^").append(list.get(i).getAcctTpNm());
			}
			
			eventResponse.setETCData("ar_acct_cd", sb.toString());
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search Agent Office List <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentOffice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<String> list = command.searchAgentOffice(event.getAROfficeListVO());
			
			StringBuffer sb = new StringBuffer("");
			
			for (int i = 0; i < list.size(); i++) {
				sb.append("|").append(list.get(i));
			}

			eventResponse.setETCData("agt_ofc_cd", sb.toString());
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search Account Type List <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccountType(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<AcctTypeVO> list = command.searchAccountType(event.getAcctCtnt(), event.getAcctCtnt2(), event.getAcctCtnt3(), event.getAcctCtnt4(), event.getOfcCd());  //2014.08.19 add ofc_cd
			
			StringBuffer acctTypeCd = new StringBuffer("");
			StringBuffer acctTypeNm = new StringBuffer("");
			StringBuffer payAcctCd = new StringBuffer("");
			StringBuffer amtSgnCd = new StringBuffer("");
			
			for (int i = 0; i < list.size(); i++) {
				acctTypeCd.append("|").append(list.get(i).getAcctTpCd());
				acctTypeNm.append("|").append(list.get(i).getAcctTpCd()).append("\t").append(list.get(i).getAcctTpNm());
				payAcctCd.append("|").append(list.get(i).getPayAcctCd());
				amtSgnCd.append("|").append(list.get(i).getAmtSgnCd());
			}

			eventResponse.setETCData("acct_tp_cd", acctTypeCd.toString());
			eventResponse.setETCData("acct_tp_nm", acctTypeNm.toString());
			eventResponse.setETCData("pay_acct_cd", payAcctCd.toString());
			eventResponse.setETCData("amt_sgn_cd", amtSgnCd.toString());
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search AR Customer<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARCustomer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ARCustomerVO arCustomerVO = command.searchARCustomer(event.getCustCntCd(), event.getCustSeq(), event.getCustUseFlg());
			
			if(arCustomerVO != null){
				eventResponse.setETCData(arCustomerVO.getColumnValues());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Search Local Time <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalTime(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String lclTime = command.searchLocalTime(account.getOfc_cd());

			eventResponse.setETCData("lcl_time", lclTime);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search Bank List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBankList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar0005Event event = (StmSar0005Event) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
			List<BankListVO> list = new ArrayList<BankListVO>();
			
			if("I".equals(event.getUiType())){
				list = command.searchReceiptBankList(event.getReceiptBankListCondVO());
			} else {
				list = command.searchBankList(event.getRctTpCd(), event.getRctOfcCd(), event.getBankCtrlCd(), event.getBankAcctNm(), event.getLocalCurrCd());
			}
			
			eventResponse.setRsVoList(list); 
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Invoice Remark(s) event<br>
	 * 
	 * @author SWJEON
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	// StmSar0001Event
	private EventResponse searchPopAPOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();   //화면으로 다시 리턴해줄 객치

		StmSar0001Event event = (StmSar0001Event) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl(); // 
		try {
			List<ApOfficeListVO> list = command.searchPopAPOfficeList(event.getOfccd());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("ap_ofc_cd",  list.get(0).getApOfcCd());
				eventResponse.setETCData("ofc_eng_nm", list.get(0).getApOfcCd());
				eventResponse.setETCData("ofc_krn_nm", list.get(0).getApOfcCd());
			} else {
				eventResponse.setETCData("ap_ofc_cd", "NO_DATA");
				eventResponse.setETCData("ofc_eng_nm", "NO_DATA");
				eventResponse.setETCData("ofc_krn_nm", "NO_DATA");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieve Invoice Remark(s) event<br>
	 * 
	 * @author MCJung 2014.03.18 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopSupplierList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// 화면리턴할 부분
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		
		StmSar0002Event event = (StmSar0002Event) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		
		
		try {
			
			List<PopSupplierListVO> list = command.searchPopSupplierList(event.getVndr_lgl_eng_nm(),event.getVndr_seq(),event.getDelt_flg());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("vndr_lgl_eng_nm", list.get(0).getVndrLglEngNm());
				eventResponse.setETCData("vndr_seq",        list.get(0).getVndrSeq());
				eventResponse.setETCData("inv_curr_cd",     list.get(0).getInvCurrCd());
				eventResponse.setETCData("pay_curr_cd",     list.get(0).getPayCurrCd());
				eventResponse.setETCData("gen_pay_term_cd", list.get(0).getGenPayTermCd());
				eventResponse.setETCData("vndr_cnt_cd",     list.get(0).getVndrCntCd());
				eventResponse.setETCData("rgst_no",         list.get(0).getRgstNo());
				eventResponse.setETCData("tax_id",          list.get(0).getTaxId());
			} else {
				eventResponse.setETCData("vndr_lgl_eng_nm", "NO_DATA");
				eventResponse.setETCData("vndr_seq",        "NO_DATA");
				eventResponse.setETCData("inv_curr_cd",     "NO_DATA");
				eventResponse.setETCData("pay_curr_cd",     "NO_DATA");
				eventResponse.setETCData("gen_pay_term_cd", "NO_DATA");
				eventResponse.setETCData("vndr_cnt_cd",     "NO_DATA");
				eventResponse.setETCData("rgst_no",         "NO_DATA");
				eventResponse.setETCData("tax_id",          "NO_DATA");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * Search Currency Code List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrencyCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CurrencyCodeVO> list = command.searchCurrencyCode(event.getCurrCd());
			
			if(list.size() > 0){
				eventResponse.setETCData(list.get(0).getColumnValues());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
			}
			
			StringBuffer currCd = new StringBuffer("");
			StringBuffer dpPrcsKnt = new StringBuffer("");
			
			for (int i = 0; i < list.size(); i++) {
				currCd.append("|").append(list.get(i).getCurrCd());
				dpPrcsKnt.append("|").append(list.get(i).getDpPrcsKnt());
			}
			
			eventResponse.setETCData("curr_cd_list", currCd.toString());
			eventResponse.setETCData("dp_prcs_knt_list", dpPrcsKnt.toString());
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * Retrieve Multi Office Code popup event<br>
	 * @author jinyoonoh 2014. 4. 3. 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchMultiOfficeCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();   //화면으로 다시 리턴해줄 객치
		StmSar0003Event event = (StmSar0003Event) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl(); // 
		try {
			List<AROfficeListVO> list = command.searchAROfficeList(account.getOfc_cd(), event.getOfcLvlTp());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * Retrieve Outstanding Source To Exclude<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOtsSourceExcludeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//StmSar0004Event event = (StmSar0004Event) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<OtsSourceExcludeListVO> list = command.searchOtsSourceExcludeList();
			eventResponse.setRsVoList(list);       
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * StmSar4001Event : Account Matrix  <br>
	 * search Account Matrix <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevAcctMatrixInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar4001Event event = (StmSar4001Event) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		
	try {
			List<RevAcctMatrixInfoVO> revAcctMatrixInfoVO = command.searchRevAcctMatrixInfo(event.getRevAcctMatrixInfoCondVO());
			eventResponse.setRsVoList(revAcctMatrixInfoVO);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * StmSar4001Event : Account Matrix  <br>
	 * manage Account Matrix <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRevAcctMatrixInfo (Event e) throws EventException { 
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSar4001Event event = (StmSar4001Event)e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();

		try{
			begin();
			if ( event.getRevAcctMatrixInfoVOs() != null && event.getRevAcctMatrixInfoVOs().length > 0 ) {
				command.manageRevAcctMatrixInfo(event.getRevAcctMatrixInfoVOs(),account);	
			}            
			commit();
			
		} catch(EventException ex) { 
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }	
		return eventResponse;
	}	
	
	/**
	 * StmSar0141Event : Account Type Code Popup <br>
	 *  Account Type Code - Retrieve <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopAccountTypeList(Event e) throws EventException {			
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
				
		StmSar0141Event event = (StmSar0141Event) e;		
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
				
		try {		
			List<RevAcctMatrixInfoVO> list = command.searchPopAccountTypeList(event.getRevAcctMatrixInfoCondVO());	 
			eventResponse.setRsVoList(list);	
			
			String acctTypeCd = "";
			String acctTypeNm = "";
			
			for (int i = 0; i < list.size(); i++) {
				acctTypeCd = list.get(i).getAcctTpCd();
				acctTypeNm = list.get(i).getAcctTpNm();
			}
			eventResponse.setETCData("acct_tp_cd", acctTypeCd);
			eventResponse.setETCData("acct_tp_nm", acctTypeNm);
			
		} catch (EventException ex) {		
			throw ex;	
		} catch (Exception ex) {		
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}		
		return eventResponse;		
	}
	
	/**
	 * Search MDM Charge List <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMDMChargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<String> list = command.searchMDMChargeList();
			
			StringBuffer chargeList = new StringBuffer("");
			
			for (int i = 0; i < list.size(); i++) {
				chargeList.append("|").append(list.get(i));
			}

			eventResponse.setETCData("chg_list", chargeList.toString());
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Check MI/ML Limit Amount <br>
	 * 
	 * @author SungYong Park 2014.08.25
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMiscLimitAmount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String chkMiscLmt = command.checkMiscLimitAmount(event.getMiscLimitCondVO());

			eventResponse.setETCData("chk_misc_lmt", chkMiscLmt.toString());
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search AR Office List <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCtrlOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			//Search CTRL OFC
			List<AROfficeListVO> list = command.searchCtrlOfficeList(account.getOfc_cd(), event.getOfcLvlTp(), event.getOfcBrncAgnTpCd());
			StringBuffer ctrlOfcInfo = new StringBuffer("");
			StringBuffer colOfcInfo = new StringBuffer("");
			boolean findSelfOfc = false;
			for(int i = 0; i < list.size(); i++){
				ctrlOfcInfo.append("|").append(list.get(i).getCtrlOfcCd()).append("^");
				ctrlOfcInfo.append(list.get(i).getOtsCd()).append("^");
				ctrlOfcInfo.append(list.get(i).getChkOfcYn()).append("^");
				ctrlOfcInfo.append(list.get(i).getRhqCd()).append("^");
				ctrlOfcInfo.append(list.get(i).getOtsSmryCd());
				
				if(list.get(i).getChkOfcYn().equals("Y")){
					findSelfOfc =  true;
					List<AROfficeListVO> list2 = command.searchControlOfficeListByRep(account.getOfc_cd(),list.get(i).getOtsCd(),list.get(i).getCtrlOfcCd());
					for (int j = 0; j < list2.size(); j++) {
						colOfcInfo.append("|").append(list2.get(j).getOtsOfcCd()).append("^");
						colOfcInfo.append(list2.get(j).getArOfcCd()).append("^").append(list2.get(j).getRhqCd()).append("^");
						colOfcInfo.append(list2.get(j).getOtsSmryCd()).append("^").append(list2.get(j).getOtsCd()).append("^");
						colOfcInfo.append(list2.get(j).getRepOtsOfcCd()).append("^").append(list2.get(j).getRctTpCd()).append("^");
						colOfcInfo.append(list2.get(j).getRctUnapyFlg()).append("^").append(list2.get(j).getOfcEntrLvlCd()).append("^");
						colOfcInfo.append(list2.get(j).getArCurrCd()).append("^").append(list2.get(j).getDpPrcsKnt()).append("^");
						colOfcInfo.append(list2.get(j).getBankCtrlCd()).append("^").append(list2.get(j).getAgnCurrCd()).append("^");
						colOfcInfo.append(list2.get(j).getAgnPfxCd()).append("^").append(list2.get(j).getAgnOtsLmtAmt()).append("^");
						colOfcInfo.append(list2.get(j).getOfcBrncAgnTpCd()).append("^").append(list2.get(j).getAgnCmbCd()).append("^");
						colOfcInfo.append(list2.get(j).getRctDocCd());
					}
				} 
			}
			
			if(!findSelfOfc){   
				//첫번째 걸로 재조회
				if(list.size() > 0){
					colOfcInfo = new StringBuffer("");
					List<AROfficeListVO> list2 = command.searchControlOfficeListByRep(account.getOfc_cd(),list.get(0).getOtsCd(),list.get(0).getCtrlOfcCd());
					for (int j = 0; j < list2.size(); j++) {
						colOfcInfo.append("|").append(list2.get(j).getOtsOfcCd()).append("^");
						colOfcInfo.append(list2.get(j).getArOfcCd()).append("^").append(list2.get(j).getRhqCd()).append("^");
						colOfcInfo.append(list2.get(j).getOtsSmryCd()).append("^").append(list2.get(j).getOtsCd()).append("^");
						colOfcInfo.append(list2.get(j).getRepOtsOfcCd()).append("^").append(list2.get(j).getRctTpCd()).append("^");
						colOfcInfo.append(list2.get(j).getRctUnapyFlg()).append("^").append(list2.get(j).getOfcEntrLvlCd()).append("^");
						colOfcInfo.append(list2.get(j).getArCurrCd()).append("^").append(list2.get(j).getDpPrcsKnt()).append("^");
						colOfcInfo.append(list2.get(j).getBankCtrlCd()).append("^").append(list2.get(j).getAgnCurrCd()).append("^");
						colOfcInfo.append(list2.get(j).getAgnPfxCd()).append("^").append(list2.get(j).getAgnOtsLmtAmt()).append("^");
						colOfcInfo.append(list2.get(j).getOfcBrncAgnTpCd()).append("^").append(list2.get(j).getAgnCmbCd()).append("^");
						colOfcInfo.append(list2.get(j).getRctDocCd());
					}
				}
			}
			eventResponse.setETCData("ctrl_ofc_cd", ctrlOfcInfo.toString());
			eventResponse.setETCData("ots_ofc_cd", colOfcInfo.toString());  
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search AR Office List <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCollectionOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			StringBuffer colOfcInfo = new StringBuffer("");
			List<AROfficeListVO> list2 = command.searchControlOfficeListByRep(account.getOfc_cd(),event.getAcctCd(),event.getOfcCd());
			for (int j = 0; j < list2.size(); j++) {
				colOfcInfo.append("|").append(list2.get(j).getOtsOfcCd()).append("^");
				colOfcInfo.append(list2.get(j).getArOfcCd()).append("^").append(list2.get(j).getRhqCd()).append("^");
				colOfcInfo.append(list2.get(j).getOtsSmryCd()).append("^").append(list2.get(j).getOtsCd()).append("^");
				colOfcInfo.append(list2.get(j).getRepOtsOfcCd()).append("^").append(list2.get(j).getRctTpCd()).append("^");
				colOfcInfo.append(list2.get(j).getRctUnapyFlg()).append("^").append(list2.get(j).getOfcEntrLvlCd()).append("^");
				colOfcInfo.append(list2.get(j).getArCurrCd()).append("^").append(list2.get(j).getDpPrcsKnt()).append("^");
				colOfcInfo.append(list2.get(j).getBankCtrlCd()).append("^").append(list2.get(j).getAgnCurrCd()).append("^");
				colOfcInfo.append(list2.get(j).getAgnPfxCd()).append("^").append(list2.get(j).getAgnOtsLmtAmt()).append("^");
				colOfcInfo.append(list2.get(j).getOfcBrncAgnTpCd()).append("^").append(list2.get(j).getAgnCmbCd()).append("^");
				colOfcInfo.append(list2.get(j).getRctDocCd());
			}
			eventResponse.setETCData("ots_ofc_cd", colOfcInfo.toString());  
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * STM_SAR_9002 : Retrieve<br>
	 * retrieve basic info and Customer's credit.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCreditCustomer(Event e) throws EventException {
		StmSar9002Event event = (StmSar9002Event) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
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
	 * FNS_INV_0086 : Retrieve<br>
	 * retrieve  Customer List.(use POP UP UI)<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopCustomerList(Event e) throws EventException {
		StmSar9003Event event = (StmSar9003Event) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
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
	 * Search AR Office List <br>
	 * 
	 * @author MyoungSin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROfficePlusRepList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			 
			List<AROfficeListVO> list = command.searchAROfficePlusRepList(account.getOfc_cd(), event.getOfcLvlTp(), event.getOfcBrncAgnTpCd());
			
			StringBuffer ofcInfo = new StringBuffer("");
			
			for(int i = 0; i < list.size(); i++){
				ofcInfo.append("|").append(list.get(i).getOtsOfcCd()).append("^");
				ofcInfo.append(list.get(i).getRhqCd()).append("^");
				ofcInfo.append(list.get(i).getOtsSmryCd()).append("^");
				ofcInfo.append(list.get(i).getOtsCd()).append("^");
				ofcInfo.append(list.get(i).getRepOtsOfcCd()).append("^");
				ofcInfo.append(list.get(i).getOfcBrncAgnTpCd());
			
			} 
			
			eventResponse.setETCData("ots_ofc_cd", ofcInfo.toString());
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Execute pgm : Retrieve<br>
	 * @param Event e
	 * @param int cmd
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executePgm(Event e,int cmd) throws EventException { 
		StmSar9999Event event = (StmSar9999Event) e; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		try { 
			if (cmd == FormCommand.COMMAND01) { 
				String ym =  event.getRateYm().replaceAll("-", ""); 
				command.createExchangeRate(ym);
			} else if (cmd == FormCommand.COMMAND02) {
				String ifNo = event.getIfNo();
				AccountReceivableOutstandingIFBC  sakuraIfBC = new AccountReceivableOutstandingIFBCImpl();
				sakuraIfBC.createSakuraOTSIFdata(ifNo,"P");
			} else if (cmd == FormCommand.COMMAND03) {
				String adjNo = event.getAdjNo();
				AccountReceivableCollectIFBC sakuraIfBC = new AccountReceivableCollectIFBCImpl();
				sakuraIfBC.createAdjustSakuraIFdata(adjNo,"P");
			} else if (cmd == FormCommand.COMMAND04) {
				String offNo = event.getOffsetNo();
				AccountReceivableCollectIFBC sakuraIfBC = new AccountReceivableCollectIFBCImpl();
				sakuraIfBC.createOffsetSakuraIFdata(offNo,"P"); 
			} else if (cmd == FormCommand.COMMAND05) {
				String recNo = event.getReceiptNo();
				AccountReceivableCollectIFBC sakuraIfBC = new AccountReceivableCollectIFBCImpl();
				sakuraIfBC.createReceiptSakuraIFdata(recNo,"P"); 
			}  else if (cmd == FormCommand.COMMAND06) {
				String asaNo = event.getAsaNo();
				AccountReceivableCollectIFBC sakuraIfBC = new AccountReceivableCollectIFBCImpl();
				sakuraIfBC.createASASakuraIFdata(asaNo,"P");
			
			//**************   Batch ********************* //
			} else if (cmd == FormCommand.COMMAND07) {
				AccountReceivableOutstandingIFBC  sakuraIfBC = new AccountReceivableOutstandingIFBCImpl();
				sakuraIfBC.createSakuraBatch("INV");
			} else if (cmd == FormCommand.COMMAND08) { 
				AccountReceivableOutstandingIFBC  sakuraIfBC = new AccountReceivableOutstandingIFBCImpl();
				sakuraIfBC.createSakuraBatch("ADJ");
			} else if (cmd == FormCommand.COMMAND09) { 
				AccountReceivableOutstandingIFBC  sakuraIfBC = new AccountReceivableOutstandingIFBCImpl();
				sakuraIfBC.createSakuraBatch("OFF");
			} else if (cmd == FormCommand.COMMAND10) { 
				AccountReceivableOutstandingIFBC  sakuraIfBC = new AccountReceivableOutstandingIFBCImpl();
				sakuraIfBC.createSakuraBatch("REC");
			}  else if (cmd == FormCommand.COMMAND11) { 
				AccountReceivableOutstandingIFBC  sakuraIfBC = new AccountReceivableOutstandingIFBCImpl();
				sakuraIfBC.createSakuraBatch("ASA");
			}  else if (cmd == FormCommand.COMMAND12) { 
				command.createZeroBalance(event.getArHdQtrOfcCd(),event.getOfcCd()); 
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Search inv hidden flg <br>
	 * 
	 * @author MyoungSin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIsHiddenInoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSarCommonEvent event = (StmSarCommonEvent) e;
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String hdnYn = "N";
		String arOfcCd = "";
		String arHdQtrOfcCD = "";
		String hqFlg = "";
		String otsCateCd = "";
		try {
			OfficeAddInfoVO officeAddInfoVO = command.searchIsHiddenInoice(event.getOfcCd());
			if(officeAddInfoVO != null){
				arOfcCd = officeAddInfoVO.getArOfcCd();
				arHdQtrOfcCD = officeAddInfoVO.getArHdQtrOfcCd();
				hqFlg = officeAddInfoVO.getHqFlg();
				otsCateCd = officeAddInfoVO.getOtsCateCd();
				hdnYn = officeAddInfoVO.getInvHdnYn();
			}
			eventResponse.setETCData("ar_ofc_cd", arOfcCd);
			eventResponse.setETCData("ar_hd_qtr_ofc_cd", arHdQtrOfcCD);
			eventResponse.setETCData("hq_flg", hqFlg);
			eventResponse.setETCData("ots_cate_cd", otsCateCd);
			eventResponse.setETCData("hidden_yn", hdnYn);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Create Miss Revenue VVD <br>
	 * 
	 * @author seungjoon Lee
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMissVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StatementCommonBC command = new StatementCommonBCImpl();
		StmSar9999Event event = (StmSar9999Event)e;
		try {
			begin();
			
			log.debug("event.getMissDt() 	: ----------------------------->" + event.getMissDt()	);
			log.debug("event.getMissSlan() 	: ----------------------------->" + event.getMissSlan()	);
			log.debug("event.getMissVvd() 	: ----------------------------->" + event.getMissVvd()	);
			GlEstmRevVvdVO glestmRevVvdVO = command.manageMissVvd(event.getMissDt(), event.getMissVvd(), account.getUsr_id(), event.getMissSlan());
			 
			if(glestmRevVvdVO.getPoResult().equals("E"))
			{
				rollback();
				throw new EventException(new ErrorHandler(glestmRevVvdVO.getPoErrMsg()).getMessage());
			} 
			eventResponse.setUserMessage(glestmRevVvdVO.getPoErrMsg());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Create Migration Revenue VVD <br>
	 * 
	 * @author seungjoon Lee
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMigVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StatementCommonBC command = new StatementCommonBCImpl();
		StmSar9999Event event = (StmSar9999Event)e;
		try {
			begin();
			
			log.debug("event.getMigDt() 	: ----------------------------->" + event.getMigDt()	);
			log.debug("event.getMigVvd() 	: ----------------------------->" + event.getMigVvd()	);
			GlEstmRevVvdVO glestmRevVvdVO = command.manageMigVvd(event.getMigDt(), event.getMigVvd());
			 
			if(glestmRevVvdVO.getPoResult().equals("E"))
			{
				rollback();
				throw new EventException(new ErrorHandler(glestmRevVvdVO.getPoErrMsg()).getMessage());
			} 
			eventResponse.setUserMessage(glestmRevVvdVO.getPoErrMsg());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Create OTS from Interface<br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOutstandingByInterface(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar9999Event event = (StmSar9999Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			begin();
			command.createOutstandingByInterface(event.getOtsIfNo());
			eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());
			commit();	
		
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
		
		return eventResponse;
	}
	
	/**
	 * [SEARCH18] Search Login User's Office Type Code <br>
	 * 
	 * @author KIMOKRYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLoginUserOfcType(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		AccountReceivableCommonBC command = new AccountReceivableCommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String loginUserOfcTpCd = command.searchLoginUserOfcType(account.getOfc_cd());
			eventResponse.setETCData("login_user_ofc_tp_cd", loginUserOfcTpCd);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	

}
