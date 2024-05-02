/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountPayableCommonSC.java
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
package com.clt.apps.opus.stm.sap.accountpayablecommon;

import java.util.List;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBC;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBCImpl;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBC;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBCImpl;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.APManualInvoiceAccuralCondVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0001Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0003Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0004Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0005Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0007Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0009Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0012Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0033Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0063Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0064Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0080Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0081Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0090Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0100Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0110Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0211Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0230Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0310Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0311Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0312Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0341Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0360Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0002Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0032Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0034Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0420Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0430Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0440Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0450Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0460Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0470Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0023Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0500Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0510Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0350Event;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSapCommonEvent;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.APBankAccountByOfficeVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApCSRNoListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApOfficeListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApPayBatchNameListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApSupplierRegisterListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountSupplierListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankBranchVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankNameListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CardBrandListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CenterListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CreditCardListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CreditCardMasterListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.FinanceOfficeListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.InterCompanyListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.InvoiceTypeListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PaymentMethodListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopPayGroupListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopPayInvoiceInfomationListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.RegionListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SourceListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SupplierBankAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.TermsListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.UnsettledAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopSupplierListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CompanyListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.MdmCurrencyVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.VVDListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.LocationListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.WorkPlacesListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.TaxCodeVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.APVendorInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.InternalBankAcctVO;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * AccountPayableCommon Business Logic ServiceCommand 
 * - Handling AccountPayableCommon Business transaction.
 * 
 * @author 
 * @see AccountPayableCommonDBDAO
 * @since J2EE 1.6
 */ 

public class AccountPayableCommonSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Precede AccountPayableCommon system <br>
	 *  Create Object when STM_SAP_CODES job call<br>
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
	 * Follow AccountPayableCommon system<br>
	 * Release Object when STM_SAP_CODES job end<br>
	 */
	public void doEnd() {
		log.debug("AccountPayableCommonSC 종료");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  AccountPayableCommon system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("StmSapCommonEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfcCdByUserId(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLocalTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGLDatePeriodCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchExchangeRateCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchFunctionalCurrencyCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
					eventResponse = searchCurrencyCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchTaxCodeList(e);			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchCOAInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchAPLineServiceLaneCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchBankAccountCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchGLDateAPPeriodCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = searchSupplierInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = searchOffValiInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)) {
				eventResponse = searchPaymentApplyCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = searchInvoiceActivityPlaceCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)) {
				eventResponse = searchInvoiceServiceLaneCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)) {
				eventResponse = searchGLDateAPPeriodCheckByInvNo(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("StmSap0312Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopCardBrandList(e);
			}
		} else	if (e.getEventName().equalsIgnoreCase("StmSap0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopCSRNoList(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("StmSap0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopSourceList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSap0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopSupplierRegisterList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSap0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopInvoiceTypeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSap0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopTermsList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSap0440Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopCenterList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSap0460Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopInterCompanyList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSap0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopLocationList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("StmSap0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopSupplierList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSap0420Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopCompanyList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSap0450Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopAccountList(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("StmSap0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopAPOfficeList(e);
			}
		} 
		
		else if (e.getEventName().equalsIgnoreCase("StmSap0360Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopAROfficeList(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("StmSap0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopPaymentMethodList(e);
			}
		} 

		else if (e.getEventName().equalsIgnoreCase("StmSap0230Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopBankNameList(e);
			}
		} 

		else if (e.getEventName().equalsIgnoreCase("StmSap0341Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopUnsettledAccountList(e);
			}
		} 

		else if (e.getEventName().equalsIgnoreCase("StmSap0311Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCreditCardList(e);
			}
		} 
		
		else if (e.getEventName().equalsIgnoreCase("StmSap0004Event")) {		
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	
				eventResponse = searchPopPayGroupList(e);
			}	
		}
		
		else if (e.getEventName().equalsIgnoreCase("StmSap0034Event")) {		
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	
				eventResponse = searchPopWorkPlacesList(e);
			}	
		}
		else if (e.getEventName().equalsIgnoreCase("StmSap0430Event")) {		
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	
				eventResponse = searchPopRegionList(e);
			}	
		}
		else if (e.getEventName().equalsIgnoreCase("StmSap0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopSupplierBankAccountList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("StmSap0063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopBankAccountInfoList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("StmSap0064Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopPayInvoiceInfomationList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("StmSap0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBankBranchList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBankBranchEntry(e);
			}			
		}		
		else if (e.getEventName().equalsIgnoreCase("StmSap0081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBankBranchCodeList(e);
			}		
		}
		else if (e.getEventName().equalsIgnoreCase("StmSap0090Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBankAccountList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBankAccountEntry(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchBankAccountLegerList(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchBankAcctNoDupCheck(e);
			}	
		}
		else if (e.getEventName().equalsIgnoreCase("StmSap0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBankAccountSupplierList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBankAccountSupplierInfo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("StmSap0100Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBankAccountByOffice(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("StmSap0211Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopPayBatchNameList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSap0310Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCreditCardMasterList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCreditCardEntryInfo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSap0470Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopVVDList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSap0500Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopFinanceOfficeList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("StmSap0510Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopInternalBankAcctList(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("StmSap0350Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAPVendorInfoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAPVendorInfoList(e);
			}				
		}
		return eventResponse;
	}
	
	
	/**
	 * COMMON : searchOfcCdByUserId (SEARCH01) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcCdByUserId(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			String[] rtnVal = command.searchOfcCdByUserId(account.getUsr_id(), account.getOfc_cd());
			eventResponse.setETCData("ap_ofc_cd", rtnVal[0]);
			eventResponse.setETCData("ar_curr_cd", rtnVal[1]);
			eventResponse.setETCData("loc_cd", rtnVal[2]);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * COMMON : searchLocalTime (SEARCH02) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalTime(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			String rtnVal = command.searchLocalTime(account.getUsr_id(), account.getOfc_cd());
			eventResponse.setETCData("local_time", rtnVal);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		

	
	/**
	 * COMMON : searchGLDatePeriodCheck (SEARCH03) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGLDatePeriodCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			
			String gl_dt = event.getSapCommonVO().getValue0();
			String ofc_cd = event.getSapCommonVO().getValue1();
			String rtnValue = command.searchInvoicesGLDatePeriodCheck(gl_dt, ofc_cd);
			
			if ( rtnValue != null  ) {
				eventResponse.setETCData("chk_period", rtnValue);
			} else {
				eventResponse.setETCData("chk_period", "NO_DATA");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * COMMON : searchExchangeRateCheck (SEARCH04) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExchangeRateCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
		
			List<SapCommonVO> list = command.searchExchangeRateCheck(event.getSapCommonVO());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("x_date", list.get(0).getValue0());
				eventResponse.setETCData("x_type", list.get(0).getValue1());
				eventResponse.setETCData("x_rate", list.get(0).getValue2());
				eventResponse.setETCData("x_prcs", list.get(0).getValue3());
			} else {
				eventResponse.setETCData("x_rate", "NO_DATA");
				eventResponse.setETCData("x_date", "NO_DATA");
				eventResponse.setETCData("x_type", "NO_DATA");
				eventResponse.setETCData("x_prcs", "NO_DATA");
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * COMMON : searchFunctionalCurrencyCode (SEARCH05) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFunctionalCurrencyCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			List<SapCommonVO> list = command.searchFunctionalCurrencyCode();
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("curr_cd", list.get(0).getValue0());
				eventResponse.setETCData("dp_prcs_knt", list.get(0).getValue1());
			} else {
				eventResponse.setETCData("curr_cd", "NO_DATA");
				eventResponse.setETCData("dp_prcs_knt", "NO_DATA");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * COMMON : searchAPLineServiceLaneCheck (SEARCH09) <br>
	 * @author KS.JO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAPLineServiceLaneCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			String vvd = event.getSapCommonVO().getValue0();
			
			String rtnValue = command.searchAPLineServiceLaneCheck(vvd);

			if ( rtnValue != null  ) {
				eventResponse.setETCData("service_lane", rtnValue);
			} else {
				eventResponse.setETCData("service_lane", "NO_DATA");
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * COMMON : searchCurrencyCode (SEARCH06) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrencyCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			List<MdmCurrencyVO> list = command.searchCurrencyCode(event.getSapCommonVO());
			StringBuffer code 					= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size() ; i++) {
					
					code.append(list.get(i).getCurrCd()).append("=")
					    .append(list.get(i).getCurrNm()).append("=")
					    .append(list.get(i).getCurrDesc()).append("=")
					    .append(list.get(i).getCntCd()).append("=")
					    .append(list.get(i).getFmEffDt()).append("=")
					    .append(list.get(i).getToEffDt()).append("=")
					    .append(list.get(i).getDpPrcsKnt()).append("=")
					    .append(list.get(i).getXtdPrcsKnt()).append("=")
					    .append(list.get(i).getEaiEvntDt()).append("=")
					    .append(list.get(i).getEaiIfId())
					    ;
					
					if (i < list.size() - 1)	code.append("|");
				}
				
				eventResponse.setETCData("curr_cd_list", code.toString());
				eventResponse.setRsVoList(list);
			}
						

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * COMMON : searchPopLocationList (SEARCH06) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopLocationList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0023Event event = (StmSap0023Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			List<LocationListVO> list = command.searchPopLocationList(event.getLocationListVO());
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("loc_cd", list.get(0).getLocCd());
				eventResponse.setETCData("loc_nm", list.get(0).getLocNm());
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setETCData("loc_cd", "NO_DATA");
				eventResponse.setETCData("loc_nm", "NO_DATA");
			}
			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * COMMON : searchTaxCodeList (SEARCH07) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTaxCodeList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		StringBuffer combo_tax_code 	= new StringBuffer();
		StringBuffer combo_tax_nm 		= new StringBuffer();
		StringBuffer combo_tax_nm_rt 	= new StringBuffer();
		StringBuffer combo_tax_rt 		= new StringBuffer();
		try {
			List<TaxCodeVO> list = command.searchTaxCodeList(event.getTaxCodeVO());
			StringBuffer code 					= new StringBuffer();
			
			if (list != null && list.size() > 0) {
				eventResponse.setETCData("tax_no", list.get(0).getTaxNo());
				eventResponse.setETCData("ap_tax_nm", list.get(0).getApTaxNm());
				eventResponse.setETCData("ap_tax_rt", list.get(0).getTaxRt());
				for (int i = 0 ; i < list.size() ; i++) {
					
					code.append(list.get(i).getTaxNo()).append("=")
					    .append(list.get(i).getApTaxNm()).append("=")
					    .append(list.get(i).getTaxRt()).append("=")
					    ;
					
					if (i < list.size() - 1)	code.append("|");
					
					combo_tax_code = combo_tax_code.append("|").append(list.get(i).getTaxNo());
					combo_tax_nm = combo_tax_nm.append("|").append(list.get(i).getTaxNo()).append("\t").append(list.get(i).getApTaxNm());
					combo_tax_nm_rt = combo_tax_nm_rt.append("|").append(list.get(i).getTaxNo()).append("\t").append(list.get(i).getApTaxNm()).append("\t").append(list.get(i).getTaxRt());
					combo_tax_rt = combo_tax_rt.append("|").append(list.get(i).getTaxRt());
				}
				
				
				eventResponse.setETCData("combo_tax_code", combo_tax_code.toString());
				eventResponse.setETCData("combo_tax_nm", combo_tax_nm.toString());
				eventResponse.setETCData("combo_tax_nm_rt", combo_tax_nm_rt.toString());
				eventResponse.setETCData("combo_tax_rt", combo_tax_rt.toString());
				
				eventResponse.setETCData("tax_cd_list", code.toString());
				eventResponse.setRsVoList(list);
				
			} else {
				eventResponse.setETCData("tax_no", "NO_DATA");
				eventResponse.setETCData("ap_tax_nm", "NO_DATA");
				eventResponse.setETCData("ap_tax_rt", "NO_DATA");
			}
			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * COMMON : searchGLDateAPPeriodCheck (COMMAND02) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGLDateAPPeriodCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			
			String gl_dt = event.getSapCommonVO().getValue0();
			String rtnValue = command.searchGLDateAPPeriodCheck(gl_dt);
			
			if ( rtnValue != null  ) {
				eventResponse.setETCData("chk_period", rtnValue);
			} else {
				eventResponse.setETCData("chk_period", "NO_DATA");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * searchOffValiInfo (COMMAND07) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffValiInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchOffValiInfo(event.getSapCommonVO().getValue0(), event.getSapCommonVO().getValue1(), account);
			if ( rtnVo != null ) {
				eventResponse.setETCData("ofc_cd", rtnVo.getValue0());		
				eventResponse.setETCData("so_if_cd",  rtnVo.getValue1());		//상계정산대리점인경우 'O'		
				eventResponse.setETCData("ap_ctr_cd",  rtnVo.getValue2());
				eventResponse.setETCData("finc_rgn_cd",  rtnVo.getValue3());
			} else {
				eventResponse.setETCData("ofc_cd", "NO_DATA");		
				eventResponse.setETCData("so_if_cd",  "NO_DATA");	
				eventResponse.setETCData("ap_ctr_cd",  "NO_DATA");	
				eventResponse.setETCData("finc_rgn_cd",  "NO_DATA");	
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * searchInvoiceActivityPlaceCheck (COMMAND09) <br>
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceActivityPlaceCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchInvoiceActivityPlaceCheck(event.getSapCommonVO().getValue0());
			if ( rtnVo != null ) {
				eventResponse.setETCData("activity_palce", rtnVo.getValue0());		
			} else {
				eventResponse.setETCData("activity_palce", "NO_DATA");		
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * searchInvoiceServiceLaneCheck (COMMAND10) <br>
	 * @author KSJO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceServiceLaneCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
		
			SapCommonVO rtnVo = command.searchInvoiceServiceLaneCheck(event.getSapCommonVO().getValue0());
			if ( rtnVo != null ) {
				eventResponse.setETCData("service_lane_cd", rtnVo.getValue0());		
			} else {
				eventResponse.setETCData("service_lane_cd", "NO_DATA");		
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * searchSupplierInfo (COMMAND03) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSupplierInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			//String vndr_seq, String vndr_lgl_eng_nm, String delt_flg
			SapCommonVO rtnVo = command.searchSupplierInfo(event.getSapCommonVO().getValue0(), event.getSapCommonVO().getValue1(), event.getSapCommonVO().getValue2());
			
			if ( rtnVo != null ) {
				eventResponse.setETCData("vndr_seq",         rtnVo.getValue0());	
				eventResponse.setETCData("vndr_lgl_eng_nm",  rtnVo.getValue1());				
				eventResponse.setETCData("inv_curr_cd",      rtnVo.getValue2());
				eventResponse.setETCData("pay_curr_cd",      rtnVo.getValue3());
				eventResponse.setETCData("gen_pay_term_cd",  rtnVo.getValue4());
				eventResponse.setETCData("vndr_cnt_cd",      rtnVo.getValue5());
				eventResponse.setETCData("rgst_no",          rtnVo.getValue6());
				eventResponse.setETCData("bank_acct_flg",    rtnVo.getValue7());
				eventResponse.setETCData("pay_mzd_cd",       rtnVo.getValue8());
				eventResponse.setETCData("sap_pay_mzd_cd",   rtnVo.getValue9());				
			} else {
				eventResponse.setETCData("vndr_lgl_eng_nm", "NO_DATA");
				eventResponse.setETCData("vndr_seq",        "NO_DATA");
				eventResponse.setETCData("inv_curr_cd",     "NO_DATA");
				eventResponse.setETCData("pay_curr_cd",     "NO_DATA");
				eventResponse.setETCData("gen_pay_term_cd", "NO_DATA");
				eventResponse.setETCData("vndr_cnt_cd",     "NO_DATA");
				eventResponse.setETCData("rgst_no",         "NO_DATA");
				eventResponse.setETCData("bank_acct_flg",   "NO_DATA");
				eventResponse.setETCData("pay_mzd_cd",      "NO_DATA");
				eventResponse.setETCData("sap_pay_mzd_cd",  "NO_DATA");
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0063] Retrieve<br>
	 * Bank Information Popup List retrieve<br> * 
	 * @author JISONG
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBankAccountCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			String bankAcctNm = event.getSapCommonVO().getValue1();
			String bankAcctNo = event.getSapCommonVO().getValue2();
			String ofcCd = event.getSapCommonVO().getValue3();
			
			List<BankAccountInfoListVO> list = command.searchBankAccountCheck(bankAcctNm, bankAcctNo, ofcCd );
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("bank_acct_nm", list.get(0).getBankAcctNm());		
				eventResponse.setETCData("bank_acct_no",  list.get(0).getBankAcctNo());		
				eventResponse.setETCData("bank_acct_seq",  list.get(0).getBankAcctSeq());
				eventResponse.setETCData("curr_cd",  list.get(0).getCurrCd());
				eventResponse.setETCData("bank_nm",  list.get(0).getBankNm());
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setETCData("bank_acct_nm", "NO_DATA");		
				eventResponse.setETCData("bank_acct_no",  "NO_DATA");		
				eventResponse.setETCData("bank_acct_seq",  "NO_DATA");		
				eventResponse.setETCData("curr_cd",  "NO_DATA");		
				eventResponse.setETCData("bank_nm",  "NO_DATA");		
			}			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	} 	
	
	/**
	 * [STM_SAP_0350] Retrieve<br>
	 * AP Vendor List retrieve<br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAPVendorInfoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0350Event event = (StmSap0350Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			List<APVendorInfoVO> list = command.searchAPVendorInfoList(event.getVndrNo(), event.getVndrNm());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;

	} 
	
	/**
	 * [STM_SAP_0350] Save<br>
	 * AP Vendor CUD<br> * 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAPVendorInfoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0350Event event = (StmSap0350Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			begin();
			command.manageAPVendorInfoList(event.getAPVendorInfoVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;

	} 	
	
	/**
	 * [STM_SAP_0100] <br>
	 * Bank Account Inquiry - Retrieve<br>
	 * @author Hannah Lee
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBankAccountByOffice(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0100Event event = (StmSap0100Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			List<APBankAccountByOfficeVO> list = command.searchBankAccountByOffice(event.getAPBankAccountByOfficeCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0032] <br>
	 * Supplier Bank Account Popup<br>
	 * @author Hannah Lee
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopSupplierBankAccountList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0032Event event = (StmSap0032Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
				
		try {
			List<SupplierBankAccountListVO> list = command.searchPopSupplierBankAccountList(event.getVndr_seq(),event.getCurr_cd(),event.getBankAcctTpNm(),event.getCallFlag(), event.getVndr_name());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("bank_acct_no", list.get(0).getBankAcctNo());
				eventResponse.setETCData("vndr_seq", list.get(0).getVndrSeq());
				eventResponse.setETCData("curr_cd", list.get(0).getCurrCd());
				eventResponse.setETCData("vndr_lgl_eng_nm", list.get(0).getVndrLglEngNm());
				eventResponse.setETCData("bank_acct_seq", list.get(0).getBankAcctSeq());
			} else {
				eventResponse.setETCData("bank_acct_no", "NO_DATA");
				eventResponse.setETCData("vndr_seq", "NO_DATA");
				eventResponse.setETCData("curr_cd", "NO_DATA");
				eventResponse.setETCData("vndr_lgl_eng_nm", "NO_DATA");
				eventResponse.setETCData("bank_acct_seq", "NO_DATA");
			}
			
			
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0310] <br>
	 * Create Credit Card<br>
	 * @author Hannah Lee
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCreditCardMasterList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0310Event event = (StmSap0310Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
				
		try {
			List<CreditCardMasterListVO> list = command.searchCreditCardMasterList(event.getCrdSeq(), event.getCrdNo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0310]
	 * Create Credit Card - Save <br> 
	 * @author Hannah Lee
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
   */
   private EventResponse manageCreditCardEntryInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0310Event event = (StmSap0310Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			 begin();
			 
			 String crdNo = command.manageCreditCardEntryInfo(event.getCreditCardMasterListVO(), account.getUsr_id());
			 
			 eventResponse.setETCData("crd_no", crdNo);
			 eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
			 commit();
		} catch (EventException ex) {
		  rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
   }
   
   /**
	 * [STM_SAP_0500] <br>
	 * Finance Office Code Popup<br>
	 * @author Hannah Lee
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopFinanceOfficeList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0500Event event = (StmSap0500Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
				
		try {
			List<FinanceOfficeListVO> list = command.searchPopFinanceOfficeList(event.getOfcTp(), event.getOfcCd());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("ofc_tp", list.get(0).getOfcTp());
				eventResponse.setETCData("user_id", list.get(0).getUserId());
				eventResponse.setETCData("ofc_cd", list.get(0).getOfcCd());
				eventResponse.setETCData("ofc_eng_nm", list.get(0).getOfcEngNm());
				eventResponse.setETCData("ctrl_ofc_cd", list.get(0).getCtrlOfcCd());
			} else {
				eventResponse.setETCData("ofc_tp",      "NO_DATA");
				eventResponse.setETCData("user_id",     "NO_DATA");
				eventResponse.setETCData("ofc_cd",      "NO_DATA");
				eventResponse.setETCData("ofc_eng_nm",  "NO_DATA");
				eventResponse.setETCData("ctrl_ofc_cd", "NO_DATA");
			}
			
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
   /**
	 * [STM_SAP_0510] <br>
	 * Internal Bank Account Popup<br>
	 * @author ORKIM
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopInternalBankAcctList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0510Event event = (StmSap0510Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
				
		try {
			List<InternalBankAcctVO> list = command.searchPopInternalBankAcctList(event.getOfcCd(), event.getOfcType(), event.getInactiveType(), event.getBankAcctNo());
			eventResponse.setRsVoList(list);
			
			if(list != null && list.size() > 0) {
				eventResponse.setETCData(list.get(0).getColumnValues());
			}
			
			
			
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
		
		
	/**
	 * Retrieve Card Brand event<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopCardBrandList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0312Event event = (StmSap0312Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			List<CardBrandListVO> list = command.searchPopCardBrandList(event.getLu_cd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * [STM_SAP_0003] Retrieve<br>
	 * CSR No Popup event<br>
	 * @author JKKIL
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopCSRNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		StmSap0003Event event = (StmSap0003Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			event.getApCSRNoListVO().setUsrId(account.getUsr_id());
			List<ApCSRNoListVO> list = command.searchPopCSRNoList(event.getApCSRNoListVO());
			eventResponse.setRsVoList(list);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	

	
	/**
	 * [STM_SAP_0005] Retrieve<br>
	 * Source Popup List retrieve<br> * 
	 * @author JISONG
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopSourceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0005Event event = (StmSap0005Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<SourceListVO> list = command.searchPopSourceList(event.getSource());
		
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0012] Retrieve<br>
	 * Supplier Register Popup List retrieve<br> * 
	 * @author JISONG
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopSupplierRegisterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0012Event event = (StmSap0012Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<ApSupplierRegisterListVO> list = command.searchPopSupplierRegisterList(event.getRegisterNo());
		
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("rgst_no", list.get(0).getRgstNo());
				eventResponse.setETCData("vndr_lgl_eng_nm", list.get(0).getVndrLglEngNm());
				eventResponse.setETCData("vndr_seq", list.get(0).getVndrSeq());
			} else {
				eventResponse.setETCData("rgst_no", "NO_DATA");
				eventResponse.setETCData("vndr_lgl_eng_nm", "NO_DATA");
				eventResponse.setETCData("vndr_seq", "NO_DATA");
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [STM_SAP_0009] Retrieve<br>
	 * Invoice Type Popup event<br>
	 * @author JKKil
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopInvoiceTypeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		StmSap0009Event event = (StmSap0009Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<InvoiceTypeListVO> list = command.searchPopInvoiceTypeList(event.getInvoiceTypeListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		

	/**
	 * [STM_SAP_0033] Retrieve<br>
	 * Terms Popup event<br>
	 * @author JKKil
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopTermsList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		StmSap0033Event event = (StmSap0033Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<TermsListVO> list = command.searchPopTermsListVO(event.getTermsListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		

	/**
	 * [STM_SAP_0440] Retrieve<br>
	 * Center Popup event<br>
	 * @author JKKil
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopCenterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		StmSap0440Event event = (StmSap0440Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<CenterListVO> list = command.searchPopCenterListVO(event.getCenterListVO());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("ctr_erp_no",  list.get(0).getCtrErpNo());
				eventResponse.setETCData("ctr_desc", list.get(0).getCtrDesc());				
			} else {
				eventResponse.setETCData("ctr_erp_no", "NO_DATA");
				eventResponse.setETCData("ctr_desc", "NO_DATA");
			}			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * [STM_SAP_0460] Retrieve<br>
	 * Inter Company Popup event<br>
	 * @author JKKil
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopInterCompanyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		StmSap0460Event event = (StmSap0460Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<InterCompanyListVO> list = command.searchPopInterCompanyListVO(event.getInterCompanyListVO());
			eventResponse.setRsVoList(list);
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
	 * @author SWJEON
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopAPOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();   //화면으로 다시 리턴해줄 객치

		StmSap0001Event event = (StmSap0001Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl(); // 
		try {
			List<ApOfficeListVO> list = command.searchPopAPOfficeList(event.getOfccd(), event.getStr_security_flag(), account);
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
	 * @author KS.JO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopAROfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();   //화면으로 다시 리턴해줄 객치

		StmSap0360Event event = (StmSap0360Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl(); // 
		try {
			List<ApOfficeListVO> list = command.searchPopAROfficeList(event.getOfccd(), event.getStr_security_flag(), account);
			eventResponse.setRsVoList(list);
			

			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("ar_ofc_cd",  list.get(0).getArOfcCd());
				eventResponse.setETCData("ofc_eng_nm", list.get(0).getArOfcCd());
				eventResponse.setETCData("ofc_krn_nm", list.get(0).getArOfcCd());
			} else {
				eventResponse.setETCData("ar_ofc_cd", "NO_DATA");
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
	 * searchPopPaymentMethodList event<br>
	 * 
	 * @author KS.JO
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopPaymentMethodList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();   //화면으로 다시 리턴해줄 객치

		StmSap0007Event event = (StmSap0007Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl(); // 
		try {
			List<PaymentMethodListVO> list = command.searchPopPaymentMethodList(event.getLuCd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * Retrieve searchPopBankNameList event<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopBankNameList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();   // 화면으로 다시 리턴해줄 객치

		StmSap0230Event event = (StmSap0230Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl(); // 
		try {
			List<BankNameListVO> list = command.searchPopBankNameList(event.getBankNm());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * searchPopUnsettledAccountList event<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopUnsettledAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();   // 화면으로 다시 리턴해줄 객치

		StmSap0341Event event = (StmSap0341Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl(); // 
		try {
			List<UnsettledAccountListVO> list = command.searchPopUnsettledAccountList(event.getLuCd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * searchCreditCardList event<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCreditCardList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0311Event event = (StmSap0311Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<CreditCardListVO> list = command.searchCreditCardList(event.getCreditCardlistVO());
		
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}				
			
	/**			
	 * Pay Group Popup - Retrieve<br> 			
	 * 			
     * @category STM_SAP_0004				
	 * @author CYJ			
	 * @param Event e			
	 * @return EventResponse			
	 * @exception EventException			
	*/			
	private EventResponse searchPopPayGroupList(Event e) throws EventException {			
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
				
		StmSap0004Event event = (StmSap0004Event) e;		
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();		
				
		try {		
			List<PopPayGroupListVO> list = command.searchPopPayGroupList(event.getLuCd(), event.getAttrCtnt1());	
			eventResponse.setRsVoList(list);	
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("lu_cd",  list.get(0).getLuCd());
				eventResponse.setETCData("lu_desc", list.get(0).getLuDesc());
			} else {
				eventResponse.setETCData("lu_cd", "NO_DATA");
				eventResponse.setETCData("lu_desc", "NO_DATA");
			}
			
		} catch (EventException ex) {		
			throw ex;	
		} catch (Exception ex) {		
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}		
		return eventResponse;		
	}			
	
	/**			
	 * WorkPlaces Popup - Retrieve<br> 			
	 * 			
     * @category STM_SAP_0034				
	 * @author CYJ			
	 * @param Event e			
	 * @return EventResponse			
	 * @exception EventException			
	*/	
	private EventResponse searchPopWorkPlacesList(Event e) throws EventException {			
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
				
		StmSap0034Event event = (StmSap0034Event) e;		
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();		
				
		try {		
			List<WorkPlacesListVO> list = command.searchPopWorkPlacesList(event.getLuCd());	
			eventResponse.setRsVoList(list);	
		} catch (EventException ex) {		
			throw ex;	
		} catch (Exception ex) {		
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}		
		return eventResponse;		
	}
	
	/**			
	 * Region Popup - Retrieve<br> 			
	 * 			
     * @category STM_SAP_0430				
	 * @author CYJ			
	 * @param Event e			
	 * @return EventResponse			
	 * @exception EventException			
	*/			
	private EventResponse searchPopRegionList(Event e) throws EventException {			
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
				
		StmSap0430Event event = (StmSap0430Event) e;		
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();		
				
		try {		
			List<RegionListVO> list = command.searchPopRegionList(event.getLuCd());	
			eventResponse.setRsVoList(list);	
		} catch (EventException ex) {		
			throw ex;	
		} catch (Exception ex) {		
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}		
		return eventResponse;		
	}
	
	/**
	 * [STM_SAP_0211] Retrieve<br>
	 * Payment Batch Name Popup List retrieve<br> * 
	 * @author JISONG
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopPayBatchNameList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0211Event event = (StmSap0211Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<ApPayBatchNameListVO> list = command.searchPopPayBatchNameList(event.getPayBatNm(),event.getPayFromDate(), event.getPayToDate());
		
			eventResponse.setRsVoList(list);
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
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0002Event event = (StmSap0002Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
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
				eventResponse.setETCData("bank_acct_flg",   list.get(0).getBankAcctFlg());
				eventResponse.setETCData("pay_mzd_cd",      list.get(0).getPayMzdCd());
				eventResponse.setETCData("sap_pay_mzd_cd",  list.get(0).getSapPayMzdCd());
			} else {
				eventResponse.setETCData("vndr_lgl_eng_nm", "NO_DATA");
				eventResponse.setETCData("vndr_seq",        "NO_DATA");
				eventResponse.setETCData("inv_curr_cd",     "NO_DATA");
				eventResponse.setETCData("pay_curr_cd",     "NO_DATA");
				eventResponse.setETCData("gen_pay_term_cd", "NO_DATA");
				eventResponse.setETCData("vndr_cnt_cd",     "NO_DATA");
				eventResponse.setETCData("rgst_no",         "NO_DATA");
				eventResponse.setETCData("bank_acct_flg",   "NO_DATA");
				eventResponse.setETCData("pay_mzd_cd",      "NO_DATA");
				eventResponse.setETCData("sap_pay_mzd_cd",  "NO_DATA");
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
	 * @author MCJung 2014.04.03 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopCompanyList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0420Event event = (StmSap0420Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			
			List<CompanyListVO> list = command.searchPopCompanyList(event.getLu_cd());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("lu_cd",          list.get(0).getLuCd());
				eventResponse.setETCData("lu_desc",        list.get(0).getLuDesc());
			} else {
				eventResponse.setETCData("lu_cd",          "NO_DATA");
				eventResponse.setETCData("lu_desc",        "NO_DATA");
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
	 * @author MCJung 2014.04.01 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopAccountList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0450Event event = (StmSap0450Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			
			List<PopAccountListVO> list = command.searchPopAccountList(event.getAcct_cd(),event.getAcctg_mng_tp_cd(), event.getPnd_tgt_flg(), event.getLine_type(), event.getAcct_eng_nm());
			
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0470] Retrieve<br>
	 * VVD Popup List retrieve<br> * 
	 * @author JISONG
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopVVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0470Event event = (StmSap0470Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<VVDListVO> list = command.searchPopVVDList(event.getVvdCd(), event.getVvdType(), event.getAcctCd());
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("vvd_cd",          list.get(0).getVvdCd());
				eventResponse.setETCData("vvd_desc",        list.get(0).getVvdDesc());
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setETCData("vvd_cd",          "NO_DATA");
				eventResponse.setETCData("vvd_desc",        "NO_DATA");
			}		
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}  
	
	/**
	 * [STM_SAP_0063] Retrieve<br>
	 * Bank Information Popup List retrieve<br> * 
	 * @author JISONG
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopBankAccountInfoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0063Event event = (StmSap0063Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {			
			List<BankAccountInfoListVO> list = command.searchPopBankAccountInfoList(event.getBankAcctNm(), event.getBankAcctNo(), event.getOfcCd(), event.getBankAcctTpNm(), event.getAcctTpCd());
		
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}  
	
	
	/**
	 * [STM_SAP_0080] Bank Branch Detail Info Retrieve<br>
	 * Bank Branch Detail Info retrieve<br> * 
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBankBranchList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0080Event event = (StmSap0080Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<BankBranchVO> list = command.searchBankBranchList(event.getBankBranchVO());
		
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0080] Bank Branch insert or update<br>
	 * Bank Branch insert or update<br> * 
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private GeneralEventResponse manageBankBranchEntry(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0080Event event = (StmSap0080Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try{
			begin();
			String max_seq = command.manageBankBranchEntry(event.getBankBranchVO(), account);
			
			//입력후 생성된 next branch seq 로 조회. 
			eventResponse.setETCData("BANK_BRNC_SEQ", max_seq);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
	/**
	 * [STM_SAP_0081]Bank Branch Code List Retrieve<br>
	 * Bank Branch Code List retrieve<br> * 
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBankBranchCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0081Event event = (StmSap0081Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<BankBranchVO> list = command.searchBankBranchCodeList(event.getBankBranchVO());
		
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}				
	
	
	/**
	 * [STM_SAP_0064]Pay Invoice Information List Retrieve<br>
	 * Pay Invoice Information List retrieve<br> * 
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopPayInvoiceInfomationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0064Event event = (StmSap0064Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<PopPayInvoiceInfomationListVO> list = command.searchPopPayInvoiceInfomationList(event.getPopPayInvoiceInfomationListVO());
		
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}				
	
	/**
	 * [STM_SAP_0090] Bank Account insert or update<br>
	 * Bank Account insert or update<br> * 
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private GeneralEventResponse manageBankAccountEntry(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSap0090Event event = (StmSap0090Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try{
			begin();
			String max_seq = command.manageBankAccountEntry(event.getBankAccountListVO(), account);
			
			//입력후 생성된 next account seq 로 조회. 
			eventResponse.setETCData("BANK_ACCT_SEQ", max_seq);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * [STM_SAP_0090] Bank Account Detail Info Retrieve<br>
	 * Bank Branch Account Info retrieve<br> * 
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBankAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0090Event event = (StmSap0090Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<BankAccountListVO> list = command.searchBankAccountList(event.getBankAccountListVO());
		
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		
	
	/**
	 * [STM_SAP_0090] Bank Account Leger Retrieve<br>
	 * Bank Branch Account Leger retrieve<br> * 
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBankAccountLegerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0090Event event = (StmSap0090Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<BankAccountListVO> list = command.searchBankAccountLegerList(event.getBankAccountListVO());
		
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}		
	
	
	/**
	 * COMMON : searchLegerInfo (SEARCH08) <br>
	 * @author sangyoung cha
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCOAInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
		
			List<SapCommonVO> list = command.searchCOAInfo(event.getSapCommonVO());
			eventResponse.setRsVoList(list);
		      
			if ( list != null && list.size() > 0) {
				eventResponse.setETCData("cd_cmb_seq", list.get(0).getValue0());			
				eventResponse.setETCData("company_code", list.get(0).getValue1());	
				eventResponse.setETCData("region_code", list.get(0).getValue2());				
				eventResponse.setETCData("center_code", list.get(0).getValue3());				
				eventResponse.setETCData("account_code", list.get(0).getValue4());				
				eventResponse.setETCData("intercompany_code", list.get(0).getValue5());				
				eventResponse.setETCData("vvd_code", list.get(0).getValue6());	
				
			} else {
				eventResponse.setETCData("cd_cmb_seq", "NO_DATA");			
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0110]
	 * Bank Account Creation ( Supplier Bank ) - retrieve <br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
   */
   private EventResponse searchBankAccountSupplierList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0110Event event = (StmSap0110Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			List<BankAccountSupplierListVO> list = command.searchBankAccountSupplierList(event.getBankAcctSeq());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
   }
   
	/**
	 * [STM_SAP_0110]
	 * Bank Account Creation ( Supplier Bank ) - save <br> 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
   */
   private EventResponse manageBankAccountSupplierInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0110Event event = (StmSap0110Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			 begin();
			 String bank_seq = command.manageBankAccountSupplierInfo(event.getBankAccountSupplierListVO(), account.getUsr_id());
			 eventResponse.setETCData("bank_acct_seq", bank_seq);		
			 eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			 commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
   }
   
	/**
	 * [STM_SAP_0010] [STM_SAP_0060] <br>
	 * searchPaymentApplyCheck (COMMAND08) <br>
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentApplyCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableInvoiceBC command = new AccountPayableInvoiceBCImpl();
		
		try {
		
			String applyYN = command.searchInvoiceLinePrepayCheck(event.getSapCommonVO().getValue0());
			if ( applyYN != null ) {
				eventResponse.setETCData("apply_yn", applyYN);		
			} else {
				eventResponse.setETCData("apply_yn", "NO_DATA");		
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}   
	
	/**
	 * [STM_SAP_0090] searchBankAcctNoDupCheck<br>
	 * searchBankAcctNoDupCheck<br> 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBankAcctNoDupCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSap0090Event event = (StmSap0090Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			String dup_chk = command.searchBankAcctNoDupCheck(event.getBankAccountListVO().getBankAcctNo(), event.getBankAccountListVO().getBankAcctTpNm());
			if ( dup_chk != null ) {
				eventResponse.setETCData("dup_chk", dup_chk);		
			} else {
				eventResponse.setETCData("dup_chk", "NO_DATA");		
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [STM_SAP_0090] searchGLDateAPPeriodCheckByInvNo<br>
	 * searchGLDateAPPeriodCheckByInvNo<br> 
	 * @author ORKIM
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGLDateAPPeriodCheckByInvNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSapCommonEvent event = (StmSapCommonEvent) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
		
		try {
			
			String inv_no = event.getSapCommonVO().getValue1();
			String rtnValue = command.searchGLDateAPPeriodCheckByInvNo(inv_no);
			
			if ( rtnValue != null  ) {
				eventResponse.setETCData("chk_period", rtnValue);
			} else {
				eventResponse.setETCData("chk_period", "NO_DATA");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
}