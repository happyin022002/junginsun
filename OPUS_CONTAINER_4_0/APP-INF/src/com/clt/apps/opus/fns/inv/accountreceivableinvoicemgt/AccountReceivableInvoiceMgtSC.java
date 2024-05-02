/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableInvoiceMgtSC.java
 *@FileTitle : (Korea) Terminal GIRO Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 정휘택
 *@LastVersion : 1.0
 * 2009.04.27 정휘택
 * 1.0 Creation
-------------------------------------------------------------
 * History
 =========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CancelInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExRateCountVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvNewCustVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.basic.AccountReceivableEDISendBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.basic.AccountReceivableEDISendBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0112Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event.FnsInv0113Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.APCInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0016Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0017Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0018Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0027Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0028Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0029Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0033Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv009401Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv009402Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0098Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv9999Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BkgNoCaNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MDMCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.basic.ARInvoiceInquiryBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.basic.ARInvoiceInquiryBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0009Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0011Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0031Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0050Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0051Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0053Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0057Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0059Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0103Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0104Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0106Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0110Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0115Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0116Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceIssueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CprtItemVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.DXBInvoiceListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentResultVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TemplateItemVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TemplateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv003401Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv003402Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0035Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0087Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration.InvoiceIssueDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CustomerListForIssueVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceFaxEmailListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueOptionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.AROfficeListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBC;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBCImpl;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.log4j.StringUtils;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComBakEndJbVO;
import com.clt.syscommon.common.table.InvArIssVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.ScoBatHisVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceSplitCondVO;

  
/**
 * AccountReceivableInvoiceMgt Business Logic ServiceCommand 
 * - Handling AccountReceivableInvoiceMgt Business transaction  
 * 
 * @author Jung Hwi Taek
 * @see InvoiceIssueDBDAO
 * @since J2EE 1.4
 */

public class AccountReceivableInvoiceMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Precede AccountReceivableInvoiceMgt system <br>
	 * Create Object when FNS_INV_0064 job call<br>
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
	 * Follow AccountReceivableInvoiceMgt system <br>
	 * Release Object when FNS_INV_0064 job end<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableInvoiceMgtSC 종료");
	}

	/**
	 * proceeding job each Event<br>
	 * Handling every Event on AccountReceivableInvoiceMgt system <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("FnsInv0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARInvoiceListByGoodDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceByInvoiceNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0087Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceRemark(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARInvoiceByBLNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAROffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARInvoiceByIFNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv003401Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceCopyCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = issueGeneralInvoiceBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = issueGeneralInvoiceBackEndJobFile(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchErrorBLNumberList(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCustomerListForIssue(e);				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchBKGInterfaceCount(e);				
			}  else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = issueGeneralInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = issueGeneralInvoiceBackEndJobKey(e);			
			}	
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOTSSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchARInvoiceByBL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyARInvoiceByBL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDueDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0035Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceCopyCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPrintInvoice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv003402Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIssuedGeneralInvoiceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAttachFileKey(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createIssueMain(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = createFileUpload(e); 
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0059Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFaxEmailSentResultListBySendDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0098Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerNo(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("FnsInv0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNotIssueListByCustomer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopInvoiceListByIssueDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchARInvoiceListByDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchARCustomerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyARInvoiceListByDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv009401Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChangeCustomerInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createCustomerChangeInvoice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv009402Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChangeCustomerInvoiceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRepCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createCustomerChangeInvoiceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createCustomerChangeInvoiceListBackEndJobKey(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createCustomerChangeInvoiceListBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = createCustomerChangeInvoiceListBackEndJobFile(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySysClearList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifySysClearListByIfNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = modifyExchangeRateListBackEndJobKey(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = modifyExchangeRateListBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = modifyExchangeRateListBackEndJobFile(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSplitARInvoiceByIFNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = splitARInvoiceByIFNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSplitCustInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = checkBackEndJob(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSplitARInvoiceByInvoiceNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = splitARInvoiceByInvoiceNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createManualInterface(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManualInterface(e);
			}/*else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = createBKGInvoiceBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = createBKGInvoiceBackEndJobFile(e);
			}*/
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDXBInvoiceList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0115Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchARRhqList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAROfficeListByRhq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchErpErrorList(e);
			} 
			
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0116Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransactionDataComparisonReportList(e);
			} 			
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCPRTInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTemplateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTemplateItemList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBlNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = issueCPRTInvoice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSelectedItemList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTemplateName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchReportItemList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTemplateItem(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = removeTemplate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCPRTHistoryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCPRTIDList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEDI310Invoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInvoiceEDILevel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendEDI310Invoice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0113Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAPCInvoice(e); 
			//Shipment Invoice	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendAPCInvoice(e); 
				//eventResponse = makeAPCInvoiceByShipFlatFile(e); 
			//Non Shipment Invoice
			} /*else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				//eventResponse = makeAPCInvoiceByNonShipFlatFile(e);
			} */
		} else if (e.getEventName().equalsIgnoreCase("FnsInv9999Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createBKGManualInterface(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createOTHManualInterface(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBKGManualInterface(e);
			}
		}  
		
		return eventResponse;
	}


	/**
	 * FNS_INV_0031 : Retrieve<br>
	 * Retrieve BR,Invoice Info by Interface Date <br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARInvoiceListByGoodDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0031Event event = (FnsInv0031Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ARInvoiceListByIFDateVO> list = command.searchARInvoiceListByGoodDate(event.getInvByGoodVO());
			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
				
				eventResponse.setETCData("bl_count", list.get(0).getInvoiceSumVO().getBlCount());
				eventResponse.setETCData("usd_total", list.get(0).getInvoiceSumVO().getGrandUsdTotal());
				eventResponse.setETCData("lcl_total", list.get(0).getInvoiceSumVO().getGrandLclTotal());

				eventResponse.setETCData("dp_prcs_knt", list.get(0).getDpPrcsKnt());
				eventResponse.setETCData("dp_prcs_knt_local", list.get(0).getDpPrcsKntLcl());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());

				eventResponse.setETCData("bl_count", "0");
				eventResponse.setETCData("usd_total", "0");
				eventResponse.setETCData("lcl_total", "0");

				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("dp_prcs_knt_local", "0");
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0053 : Retrieve<br>
	 * Retrieve Invoice issue Info by Invoice No <br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceByInvoiceNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0053Event event = (FnsInv0053Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		ARInvoiceByBLNoVO aRInvoiceByBLNoVO = new ARInvoiceByBLNoVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			aRInvoiceByBLNoVO = command.searchInvoiceByInvoiceNo(event.getInvNo(), event.getOfc());

			if (aRInvoiceByBLNoVO != null) {
				eventResponse.setRsVo(aRInvoiceByBLNoVO);
				//eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeSumVO());
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO());

				if (aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO() != null && aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO().size() > 0) {
					eventResponse.setETCData("dp_prcs_knt", aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO().get(0).getDpPrcsKnt());
					eventResponse.setETCData("dp_prcs_knt_local", aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO().get(0).getDpPrcsKntLocal());
				} else {
					eventResponse.setETCData("dp_prcs_knt", "0");
					eventResponse.setETCData("dp_prcs_knt_local", "0");
				}
			} else {
				aRInvoiceByBLNoVO = new ARInvoiceByBLNoVO();

				eventResponse.setRsVo(aRInvoiceByBLNoVO);
				//eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeSumVO());
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO());

				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("dp_prcs_knt_local", "0");

				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * Retrieve Invoice Remark(s) event<br>
	 * 
	 * @author Jung Hwi Taek
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0087Event event = (FnsInv0087Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<InvArIssVO> list = command.searchInvoiceRemark(event.getInvArIssVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0009 : Retrieve<br>
	 * Retrieve BR,Invoice Detail and Histroy by Info B/L No<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARInvoiceByBLNo(Event e) throws EventException {
		FnsInv0009Event event = (FnsInv0009Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();

		ARInvoiceByBLNoVO aRInvoiceByBLNoVO = new ARInvoiceByBLNoVO();

		try {
			aRInvoiceByBLNoVO = command.searchARInvoiceByBLNo(event.getARInvoiceInputByBLNoVO());

			if (aRInvoiceByBLNoVO != null && aRInvoiceByBLNoVO.getBlSrcNo() != null) {
				if (aRInvoiceByBLNoVO.getListInvoiceChargeSumVO() != null && aRInvoiceByBLNoVO.getListInvoiceChargeSumVO().size() > 0) {
					eventResponse.setETCData("dp_prcs_knt", aRInvoiceByBLNoVO.getListInvoiceChargeSumVO().get(0).getDpPrcsKnt());
					eventResponse.setETCData("dp_prcs_knt_local", aRInvoiceByBLNoVO.getListInvoiceChargeSumVO().get(0).getDpPrcsKntLocal());
				} else {
					eventResponse.setETCData("dp_prcs_knt", "0");
					eventResponse.setETCData("dp_prcs_knt_local", "0");
				}
				
				eventResponse.setRsVo(aRInvoiceByBLNoVO);
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeSumVO());
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceChargeByBLNoVO());
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceHistoryByBLNoVO());
				eventResponse.setRsVoList(aRInvoiceByBLNoVO.getListInvoiceContainerVO());
				
				List<String> list = aRInvoiceByBLNoVO.getListArOfcCd();

				StringBuffer arOfcInfo = new StringBuffer("");
				if (list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						arOfcInfo.append("|").append(list.get(i));
						
					}
					eventResponse.setETCData("ar_ofc_cd", arOfcInfo.toString());
				}				
			} else {
				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("dp_prcs_knt_local", "0");

				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage());
		}
	}


	/**
	 * FNS_INV_0011 : Retrieve<br>
	 * Retrieve BR,Invoice Info by Interface No<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARInvoiceByIFNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0011Event event = (FnsInv0011Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		ARInvoiceCorrectionVO invoiceCorrectionVO = new ARInvoiceCorrectionVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			invoiceCorrectionVO = command.searchARInvoiceByIFNo(event.getIfNo(), account.getOfc_cd());

			eventResponse.setRsVo(invoiceCorrectionVO);
			eventResponse.setRsVoList(invoiceCorrectionVO.getListInvoiceChargeSumVO());
			eventResponse.setRsVoList(invoiceCorrectionVO.getListInvoiceChargeCorrectionVO());
			eventResponse.setRsVoList(invoiceCorrectionVO.getListInvoiceContainerVO());

			if (invoiceCorrectionVO.getBlSrcNo() == null) {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			} else {
				if (invoiceCorrectionVO.getListInvoiceChargeSumVO() != null && invoiceCorrectionVO.getListInvoiceChargeSumVO().size() > 0) {
					eventResponse.setETCData("dp_prcs_knt", invoiceCorrectionVO.getListInvoiceChargeSumVO().get(0).getDpPrcsKnt());
					eventResponse.setETCData("dp_prcs_knt_local", invoiceCorrectionVO.getListInvoiceChargeSumVO().get(0).getDpPrcsKntLocal());
				} else {
					eventResponse.setETCData("dp_prcs_knt", "0");
					eventResponse.setETCData("dp_prcs_knt_local", "0");
				}
			}

			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0034_01 : Open, Office@CHANGE <br>
	 * Retrieve Invoice issue Copy <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceCopyCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		String ofcCd = "";
		String pageType = "";
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equals("FnsInv003401Event")) {
				FnsInv003401Event event = (FnsInv003401Event) e;
				ofcCd = event.getOfcCd();
				pageType = event.getPageType();

			} else if (e.getEventName().equals("FnsInv0035Event")) {
				FnsInv0035Event event = (FnsInv0035Event) e;
				ofcCd = event.getOfcCd();
				pageType = event.getPageType();
			}

			INVCommonUtil command = new INVCommonUtil();
			InvoiceIssueBC command2 = new InvoiceIssueBCImpl();
			List<String> list = null;
			int copyCnt = 0;

			if (ofcCd != null && !ofcCd.equals("")) {
				copyCnt = command2.searchInvoiceCopyCnt(ofcCd);
				eventResponse.setETCData("copy_cnt", String.valueOf(copyCnt));
			} else {
				list = command.searchAROfficeList(account.getOfc_cd(), pageType);
				StringBuffer ar_ofc_info = new StringBuffer("");

				for (int i = 0; i < list.size(); i++) {
					ar_ofc_info.append("|").append(list.get(i));
				}
				eventResponse.setETCData("ar_ofc_cd", ar_ofc_info.toString());

				String ar_ofc_info_1 = list.get(0);
				String[] result = StringUtils.delimitedListToStringArray(ar_ofc_info_1, "^");
				String arOfcCd = result[1];

				copyCnt = command2.searchInvoiceCopyCnt(arOfcCd);

				eventResponse.setETCData("copy_cnt", String.valueOf(copyCnt));
			}
			
			String printName = command.searchARPrinterName(account.getOfc_cd(), account.getUsr_id());
			eventResponse.setETCData("inv_prn_dvc_nm", printName);
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
	 * FNS_INV_0016 : 조회<BR>
	 * Retrieve OTS Summary code ,Retrieve office code<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchOTSSummary(Event e) throws EventException {
		FnsInv0016Event event = (FnsInv0016Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String otsSmryCd = command.searchOTSSummary(event.getOfcCd());
			eventResponse.setETCData("ots_smry_cd", otsSmryCd);
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
	 * FNS_INV_0016 : Retrieve<br>
	 * Retrieve Invoice Item by B/L<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchARInvoiceByBL(Event e) throws EventException {
		FnsInv0016Event event = (FnsInv0016Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ARInvoiceCorrectionVO aRInvoiceCorrectionVO = command
					.searchARInvoiceByBL(event.getOfcCd(), event.getBlNo(), event.getInvNo(), event.getOtsSmryCd());

			eventResponse.setRsVo(aRInvoiceCorrectionVO);
			eventResponse.setRsVoList(aRInvoiceCorrectionVO.getListInvoiceChargeSumVO());
			eventResponse.setRsVoList(aRInvoiceCorrectionVO.getListInvoiceChargeCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceCorrectionVO.getInvArCntrVO());
			eventResponse.setRsVoList(aRInvoiceCorrectionVO.getInvArMnVO());
			eventResponse.setETCData("dp_prcs_knt_local", aRInvoiceCorrectionVO.getListInvoiceChargeSumVO().get(0).getDpPrcsKntLocal());
			
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
	 * FNS_INV_0016 : Retrieve<br>
	 * Retrieve ARCredit and Due date.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchDueDate(Event e) throws EventException {
		FnsInv0016Event event = (FnsInv0016Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ARCreditVO aRCreditVO = command.searchARCredit(event.getARCreditInputVO());

			if(aRCreditVO!=null){
				eventResponse.setETCData(aRCreditVO.getColumnValues());
			}else{
				eventResponse.setETCData("cr_flg","N");
				eventResponse.setETCData("cr_term","0");
				eventResponse.setETCData("due_dt","");
			}
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
	 * FNS_INV_0016 : insert, update, delete<br>
	 * Handling ERP Interface Corrected Invoice Items by B/L <br>  
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyARInvoiceByBL(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0016Event event = (FnsInv0016Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		INVCommonUtil utilCmd = new INVCommonUtil();
		AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();
		InvoiceIssueBC command3 = new InvoiceIssueBCImpl();
		
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		List<InvArIfNoVO> maxIfNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
		InvArIfNoVO maxArIfNoVO = new InvArIfNoVO();
		//String newIfNo="";
		
		try {
			begin();
			
			String ifCnt = command3.searchBKGInterfaceCount("'"+event.getBlNo()+"'");
			
			if(!("0").equals(ifCnt)){
				throw new EventException(new ErrorHandler("INV00191",new String[]{}).getMessage());
			}
			
			if(("Y").equals(event.getBlSrchFlg())){
				String ifNo = command.searchMaxInterfaceNoByBL(event.getOfcCd(), event.getBlNo(), "");
				
				if(!ifNo.equals(event.getIfNo())){
					throw new EventException(new ErrorHandler("INV00191",new String[]{}).getMessage());
				}
			}
			
			String invNo = command.searchInvNoByIfNo(event.getIfNo());
			
			if(!invNo.equals(event.getInvNo())){
				throw new EventException(new ErrorHandler("INV00193",new String[]{}).getMessage());
			}
			
			if(event.getActInvFlag().equals("Y")) {
				int splitCnt = command.searchSplitCountByIfNo(event.getIfNo());
				
				if(splitCnt > 0){
					throw new EventException(new ErrorHandler("INV00194",new String[]{}).getMessage());
				}
			}
			
			if (event.getOtsSmryCd().equals("INV")||event.getOtsSmryCd().equals("CLR")) {

				// when Inv Cust,Act Cust,Pol,Pod,Vvd changed
				if (event.getModFlag().equals("Y")) {

					InvArMnVO[] invArMnVOs = event.getInvArMnVOs();

					//log.info("invArMnVOs.length=========>" + invArMnVOs.length);
					if (invArMnVOs !=null && invArMnVOs.length > 0) {
						//Cancel 
						for (int i = 0; i < invArMnVOs.length; i++) {
							String vvd = invArMnVOs[i].getVslCd() + invArMnVOs[i].getSkdVoyNo() + invArMnVOs[i].getSkdDirCd();			
							
							ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();

							aRCorrectionCkVO.setBkgNo(invArMnVOs[i].getBkgNo());
							aRCorrectionCkVO.setIoBndCd(invArMnVOs[i].getIoBndCd().substring(0,1));
							aRCorrectionCkVO.setInvCustFlg(event.getInvCustFlg());
							aRCorrectionCkVO.setOfcCd(invArMnVOs[i].getArOfcCd());
							aRCorrectionCkVO.setSailingDt(invArMnVOs[i].getSailDt());
							aRCorrectionCkVO.setVvdCd(vvd);
							aRCorrectionCkVO.setPod(invArMnVOs[i].getPodCd());
							aRCorrectionCkVO.setPol(invArMnVOs[i].getPolCd());

							// Retrieve Rev Type, Effective Dt, Zone Ioc
							ARCorrectionCkReturnVO arCorctCkReturnVO = command.checkARCorrection(aRCorrectionCkVO);

							// Good
							if (!invArMnVOs[i].getBlInvCfmDt().equals("")) {								
								
								// Cancel Data setting
																
								CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

								cancelInvoiceVO.setIfNo(invArMnVOs[i].getArIfNo());
								cancelInvoiceVO.setEffDt(arCorctCkReturnVO.getEffectiveDt());
								//cancelInvoiceVO.setRevTpCd(arCorctCkReturnVO.getRevTpCd());
								//cancelInvoiceVO.setRevSrcCd(arCorctCkReturnVO.getRevSrcCd());
								cancelInvoiceVO.setInvCustFlg(event.getInvCustFlg());
								if(event.getInvCustFlg().equals("Y")){
									cancelInvoiceVO.setInvCustCntCd(invArMnVOs[i].getInvCustCntCd());
									cancelInvoiceVO.setInvCustSeq(invArMnVOs[i].getInvCustSeq());
								}
								cancelInvoiceVO.setOtsSmryCd(event.getOtsSmryCd());
								cancelInvoiceVO.setUserId(account.getUsr_id());

								// Cancel Data create
								String cancelIfNo = bcommand.createARCancelInvoice(cancelInvoiceVO);
								
								if(!cancelIfNo.equals("")){
									if(event.getOtsSmryCd().equals("INV")){
										maxArIfNoVO = new InvArIfNoVO();
										maxArIfNoVO.setIfNo(invArMnVOs[i].getArIfNo());
										maxIfNos.add(maxArIfNoVO);
									}
									invArIfNoVO = new InvArIfNoVO();
									invArIfNoVO.setIfNo(cancelIfNo);
									ifNos.add(invArIfNoVO);
									
									log.debug("erp_cancelIfNo1 = " + cancelIfNo);
								}
							} 
						}
					}
					
					// MAX IF Cancel
					ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.checkARCorrection(event.getArCorrectionCkVO());

					if (arCorrectionCkReturnVO.getZoneIoc() != null) {
						event.getArInvoiceCreationVO().getInvArMnVO().setZnIocCd(arCorrectionCkReturnVO.getZoneIoc());
					}
					event.getArInvoiceCreationVO().getInvArMnVO().setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());

					// Good Data=============//
					if (!event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt().equals("")) {
						// Cancel Data setting
						CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();
						cancelInvoiceVO.setEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						cancelInvoiceVO.setIfNo(event.getIfNo());
						cancelInvoiceVO.setOtsSmryCd(event.getOtsSmryCd());
						cancelInvoiceVO.setUserId(account.getUsr_id());
						cancelInvoiceVO.setInvCustFlg(event.getInvCustFlg());
						//cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						//cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						if(event.getInvCustFlg().equals("Y")){
							cancelInvoiceVO.setInvCustCntCd(event.getArInvoiceCreationVO().getInvArMnVO().getInvCustCntCd());
							cancelInvoiceVO.setInvCustSeq(event.getArInvoiceCreationVO().getInvArMnVO().getInvCustSeq());
						}

						String cancelIfNo = bcommand.createARCancelInvoice(cancelInvoiceVO);
						
						if(!cancelIfNo.equals("")){
							
							if(event.getOtsSmryCd().equals("INV")){
								maxArIfNoVO = new InvArIfNoVO();
								maxArIfNoVO.setIfNo(event.getIfNo());
								maxIfNos.add(maxArIfNoVO);
							}
							
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(cancelIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_cancelIfNo2 = " + cancelIfNo);
						}
					}
					
					
					if (invArMnVOs !=null && invArMnVOs.length > 0) {
						//Create 하는 For
						for (int i = 0; i < invArMnVOs.length; i++) {
							String vvd = invArMnVOs[i].getVslCd() + invArMnVOs[i].getSkdVoyNo() + invArMnVOs[i].getSkdDirCd();
							String port = invArMnVOs[i].getIoBndCd().equals("O")?invArMnVOs[i].getPolCd():invArMnVOs[i].getPodCd();								
							
							String sailArrDt = utilCmd.searchSADate(vvd, port, invArMnVOs[i].getIoBndCd());
							
							/*
							DueDateInputVO dueDateInputVO = new DueDateInputVO();

							dueDateInputVO.setBnd(invArMnVOs[i].getIoBndCd());
							dueDateInputVO.setCustCntCd(invArMnVOs[i].getActCustCntCd());
							dueDateInputVO.setCustSeq(invArMnVOs[i].getActCustSeq());
							dueDateInputVO.setSaDt(!sailArrDt.equals("")?sailArrDt.replace("-", ""):sailArrDt);
							dueDateInputVO.setOfcCd(invArMnVOs[i].getArOfcCd());
							// Due Date 조회
							List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
							*/
							
							ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();

							aRCorrectionCkVO.setBkgNo(invArMnVOs[i].getBkgNo());
							aRCorrectionCkVO.setInvCustFlg(event.getInvCustFlg());
							aRCorrectionCkVO.setOfcCd(invArMnVOs[i].getArOfcCd());
							aRCorrectionCkVO.setSailingDt(invArMnVOs[i].getSailDt());
							aRCorrectionCkVO.setVvdCd(vvd);
							aRCorrectionCkVO.setPod(invArMnVOs[i].getPodCd());
							aRCorrectionCkVO.setPol(invArMnVOs[i].getPolCd());
							aRCorrectionCkVO.setIoBndCd(invArMnVOs[i].getIoBndCd().substring(0,1));

							// Retrieve Rev Type, Effective Dt, Zone Ioc 
							ARCorrectionCkReturnVO arCorctCkReturnVO = command.checkARCorrection(aRCorrectionCkVO);

							// Good
							if (!invArMnVOs[i].getBlInvCfmDt().equals("")) {
								
								// New Data setting
								InvNewCustVO invNewCustVO = new InvNewCustVO();

								invNewCustVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
								invNewCustVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
								invNewCustVO.setInvCustCntCd(invArMnVOs[i].getInvCustCntCd());
								invNewCustVO.setInvCustSeq(invArMnVOs[i].getInvCustSeq());
								invNewCustVO.setVslCd(invArMnVOs[i].getVslCd());
								invNewCustVO.setSkdVoyNo(invArMnVOs[i].getSkdVoyNo());
								invNewCustVO.setSkdDirCd(invArMnVOs[i].getSkdDirCd());
								invNewCustVO.setPolCd(invArMnVOs[i].getPolCd());
								invNewCustVO.setPodCd(invArMnVOs[i].getPodCd());
								/*
								if (list.size() > 0) {
									// Due Date setting
									invNewCustVO.setDueDt(list.get(0).getDueDate());
									invNewCustVO.setCustCrFlg(list.get(0).getCrFlg());
									invNewCustVO.setCrTermDys(list.get(0).getCrTermDys());
								}
								*/
								invNewCustVO.setArIfNo(invArMnVOs[i].getArIfNo());
								invNewCustVO.setBlInvCfmDt(invArMnVOs[i].getBlInvCfmDt());
								invNewCustVO.setOtsSmryCd(event.getOtsSmryCd());
								invNewCustVO.setGlEffDt(arCorctCkReturnVO.getEffectiveDt());
								invNewCustVO.setInvCustFlg(event.getInvCustFlg());
								//invNewCustVO.setRevTpCd(arCorctCkReturnVO.getRevTpCd());
								//invNewCustVO.setRevSrcCd(arCorctCkReturnVO.getRevSrcCd());
								invNewCustVO.setZnIocCd(arCorctCkReturnVO.getZoneIoc());
								invNewCustVO.setSailArrDt(!sailArrDt.equals("")?sailArrDt.replace("-", ""):sailArrDt);
								invNewCustVO.setUiType("F");
								invNewCustVO.setSplitFlag(event.getActInvFlag().equals("Y") ? "C" : "");

								// New Data create
								String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
								
								if(!newIfNo.equals("")){
									invArIfNoVO = new InvArIfNoVO();
									invArIfNoVO.setIfNo(newIfNo);
									ifNos.add(invArIfNoVO);
									
									log.debug("erp_newIfNo1 = " + newIfNo);
								}
								
								// No Goood 
							} else {
								// New Data setting
								InvNewCustVO invNewCustVO = new InvNewCustVO();

								invNewCustVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
								invNewCustVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
								invNewCustVO.setInvCustCntCd(invArMnVOs[i].getInvCustCntCd());
								invNewCustVO.setInvCustSeq(invArMnVOs[i].getInvCustSeq());
								invNewCustVO.setVslCd(invArMnVOs[i].getVslCd());
								invNewCustVO.setSkdVoyNo(invArMnVOs[i].getSkdVoyNo());
								invNewCustVO.setSkdDirCd(invArMnVOs[i].getSkdDirCd());
								invNewCustVO.setPolCd(invArMnVOs[i].getPolCd());
								invNewCustVO.setPodCd(invArMnVOs[i].getPodCd());
								/*
								if (list.size() > 0) {
									// Due Date setting
									invNewCustVO.setDueDt(list.get(0).getDueDate());
									invNewCustVO.setCustCrFlg(list.get(0).getCrFlg());
									invNewCustVO.setCrTermDys(list.get(0).getCrTermDys());
								}
								*/
								invNewCustVO.setSailArrDt(!sailArrDt.equals("")?sailArrDt.replace("-", ""):sailArrDt);
								invNewCustVO.setArIfNo(invArMnVOs[i].getArIfNo());
								invNewCustVO.setBlInvCfmDt(invArMnVOs[i].getBlInvCfmDt());
								invNewCustVO.setUiType("F");
								invNewCustVO.setSplitFlag(event.getActInvFlag().equals("Y") ? "C" : "");
								//invNewCustVO.setSplitFlag("");
								invNewCustVO.setOtsSmryCd(event.getOtsSmryCd());
								invNewCustVO.setGlEffDt(arCorctCkReturnVO.getEffectiveDt());
								invNewCustVO.setInvCustFlg(event.getInvCustFlg());
								//invNewCustVO.setRevTpCd(arCorctCkReturnVO.getRevTpCd());
								//invNewCustVO.setRevSrcCd(arCorctCkReturnVO.getRevSrcCd());
								invNewCustVO.setZnIocCd(arCorctCkReturnVO.getZoneIoc());

								// New Data create
								String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
								
								if(!newIfNo.equals("")){
									invArIfNoVO = new InvArIfNoVO();
									invArIfNoVO.setIfNo(newIfNo);
									ifNos.add(invArIfNoVO);
								}
								log.debug("erp_newIfNo2 = " + newIfNo);
							}
						}
					}

					// MAX IF Create					
					// Good Data=============//
					if (!event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt().equals("")) {
						
						event.getInvNewCustVO().setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						event.getInvNewCustVO().setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						event.getInvNewCustVO().setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						event.getInvNewCustVO().setBlInvCfmDt(event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt());
						event.getInvNewCustVO().setSplitFlag(event.getActInvFlag().equals("Y") ? "C" : "");

						String newIfNo = bcommand.createNewCustomerARInvoice(event.getInvNewCustVO(), account.getUsr_id());
						
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_newIfNo3 = " + newIfNo);
						}
						
						// ==== Actual Cust or Inv Cust Change and No Good =============//
					} else {
						event.getInvNewCustVO().setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						event.getInvNewCustVO().setInvCustFlg(event.getInvCustFlg());
						//event.getInvNewCustVO().setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						//event.getInvNewCustVO().setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						event.getInvNewCustVO().setBlInvCfmDt(event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt());
						event.getInvNewCustVO().setSplitFlag(event.getActInvFlag().equals("Y") ? "C" : "");
						//event.getInvNewCustVO().setSplitFlag("");

						String newIfNo = bcommand.createNewCustomerARInvoice(event.getInvNewCustVO(), account.getUsr_id());
						
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_newIfNo4 = " + newIfNo);
						}
					}
					
					

					// when Inv Cust,Act Cust,Pol,Pod,Vvd not change
				} else {
					
					String newIfNo = bcommand.modifyARInvoice(event.getArInvoiceCreationVO(), account.getUsr_id());
					if(!newIfNo.equals("")){
						invArIfNoVO = new InvArIfNoVO();
						invArIfNoVO.setIfNo(newIfNo);
						ifNos.add(invArIfNoVO);
						
						log.debug("erp_newIfNo5 = " + newIfNo);
					}
				}

			} else {
				ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.checkARCorrection(event.getArCorrectionCkVO());

				if (arCorrectionCkReturnVO.getZoneIoc() != null) {
					event.getArInvoiceCreationVO().getInvArMnVO().setZnIocCd(arCorrectionCkReturnVO.getZoneIoc());
				}
				event.getArInvoiceCreationVO().getInvArMnVO().setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());

				// ==== Actual Cust or Inv Cust No Change and other Value Change =============//
				if (event.getActInvFlag().equals("N")) {
					String modIfNo = bcommand.modifyARInvoice(event.getArInvoiceCreationVO(), account.getUsr_id());
					
					if(!modIfNo.equals("")){
						invArIfNoVO = new InvArIfNoVO();
						invArIfNoVO.setIfNo(modIfNo);
						ifNos.add(invArIfNoVO);
						
						log.debug("erp_modIfNo1 = " + modIfNo);
					}
					
				} else {
					// ==== Actual Cust or Inv Cust Change and Good =============//
					if (!event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt().equals("")) {
						// Cancel Data setting
						CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();
						cancelInvoiceVO.setEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						cancelInvoiceVO.setIfNo(event.getIfNo());
						cancelInvoiceVO.setOtsSmryCd(event.getOtsSmryCd());
						cancelInvoiceVO.setUserId(account.getUsr_id());
						cancelInvoiceVO.setInvCustFlg(event.getInvCustFlg());
						//cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						//cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						if(event.getInvCustFlg().equals("Y")){
							cancelInvoiceVO.setInvCustCntCd(event.getArInvoiceCreationVO().getInvArMnVO().getInvCustCntCd());
							cancelInvoiceVO.setInvCustSeq(event.getArInvoiceCreationVO().getInvArMnVO().getInvCustSeq());
						}

						String cancelIfNo = bcommand.createARCancelInvoice(cancelInvoiceVO);
						
						if(!cancelIfNo.equals("")){
							
							if(event.getOtsSmryCd().equals("INV")){
								maxArIfNoVO = new InvArIfNoVO();
								maxArIfNoVO.setIfNo(event.getIfNo());
								maxIfNos.add(maxArIfNoVO);
							}
							
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(cancelIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_cancelIfNo3 = " + cancelIfNo);
						}
						
						event.getInvNewCustVO().setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						event.getInvNewCustVO().setInvCustFlg(event.getInvCustFlg());
						//event.getInvNewCustVO().setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						//event.getInvNewCustVO().setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						event.getInvNewCustVO().setBlInvCfmDt(event.getArInvoiceCreationVO().getInvArMnVO().getBlInvCfmDt());

						String newIfNo = bcommand.createNewCustomerARInvoice(event.getInvNewCustVO(), account.getUsr_id());
						
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_newIfNo6 = " + newIfNo);
						}
						
						// ==== Actual Cust or Inv Cust Change and No Good =============//
					} else {
						String modIfNo = bcommand.modifyARInvoice(event.getArInvoiceCreationVO(), account.getUsr_id());
						if(!modIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(modIfNo);
							ifNos.add(invArIfNoVO);
							
							log.debug("erp_modIfNo2 = " + modIfNo);
						}
					}
				}
			}
			
			/*
			begin();
			if(maxIfNos!= null && maxIfNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(maxIfNos, "U");
			}
			
			if(ifNos!= null && ifNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
			}
			commit();
			*/
			
			// 2014.06.10 AR OTS creation
			// 2014.08.14 block maxifno
			//if(maxIfNos!= null && maxIfNos.size()>0){
			//	command2.createOutstandingInfo(maxIfNos);
			//}
			
			if(ifNos!= null && ifNos.size()>0){
				command2.createOutstandingInfo(ifNos);
			}
			
			commit();
			
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			if(ex.getMessage().contains("COM")||ex.getMessage().contains("FRM")||ex.getMessage().contains("INV00053")){
				throw new EventException(new ErrorHandler("INV00195").getMessage(), ex);
			}
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0035 : Paper Re-issue <br>
	 * Save Re-issue 할 Invoice List and Re-issue History<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrintInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0035Event event = (FnsInv0035Event) e;
		PrintInvoiceVO prtInvoiceVo = null;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		//BookingARCreationBC command2 = new BookingARCreationBCImpl();
		List<InvIssMainVO> list = null;
		StringBuffer rInvNos = new StringBuffer("");
		StringBuffer cmbFlg = new StringBuffer("");
		StringBuffer issGrpTpCd = new StringBuffer("");

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			prtInvoiceVo = event.getPrtInvoiceVo();
			prtInvoiceVo.setUserOfc(event.getPrtInvoiceVo().getUserOfc());
			prtInvoiceVo.setIssOfcCd(event.getPrtInvoiceVo().getIssOfcCd());
			prtInvoiceVo.setOtsSmryCd(event.getPrtInvoiceVo().getOtsSmryCd());
			prtInvoiceVo.setUserId(event.getPrtInvoiceVo().getUserId());
			prtInvoiceVo.setPrevFlg(event.getPrtInvoiceVo().getPrevFlg());
			prtInvoiceVo.setGotoFlg(event.getPrtInvoiceVo().getGotoFlg());
			
			log.info("\n########## prtInvoiceVo.getUserOfc() : "+prtInvoiceVo.getUserOfc());
			log.info("\n########## prtInvoiceVo.getIssOfcCd() : "+prtInvoiceVo.getIssOfcCd());
			
			begin();

			list = command.searchPrintInvoice(prtInvoiceVo);

			for (int i = 0; i < list.size(); i++) {
				rInvNos.append(list.get(i).getInvNo()).append("|");
				cmbFlg.append(list.get(i).getInvIssCmbFlg()).append("|");
				issGrpTpCd.append(list.get(i).getIssGrpTpCd()).append("|");
				
				// reissue batch 건으로 인한 주석 20160526
				//if (!prtInvoiceVo.getPrevFlg().equals("Y")) {
				//	command2.modifyInvoiceReIssue(list.get(i).getInvNo(), prtInvoiceVo.getOtsSmryCd(), prtInvoiceVo.getUserId(), prtInvoiceVo.getIssOfcCd());
				//}		
			}

			eventResponse.setETCData("r_inv_nos", rInvNos.toString());
			eventResponse.setETCData("cmb_flg", cmbFlg.toString());
			eventResponse.setETCData("iss_grp_tp_cd", issGrpTpCd.toString());
			
			commit();
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			
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
	 * FNS_INV_0034_01 : Paper Issue, Go to Send <br>
	 * Issue Europe, part of Southwest Asia , north China Invoice. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	private EventResponse issueGeneralInvoiceOld(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		List<IssueTargetVO> list2 = new ArrayList<IssueTargetVO>();
		try {
			begin();

			// Issue 대상을 조회한다
			List<IssueTargetVO> list = command.searchTargetBLForIssue(event.getGenInvVo());

			if (list.size() < 1) {
				eventResponse.setUserMessage(new ErrorHandler("INV00095", new String[] {}).getUserMessage());
			}

			String invNos = "";
			InvIssueVO invIssueVO = null;

			// 조회된 Issue 대상만큼 Looping 
			for (int i = 0; i < list.size(); i++) {
				list2 = command.issueGeneralInvoice(list.get(i), event.getGenInvVo(), account.getUsr_id());
				invNos = invNos + list2.get(0).getInvNo() + "|";

				// 반환된 업데이트 대상만큼 Looping
				for (int j = 0; j < list2.size(); j++) {

					invIssueVO = new InvIssueVO();
					invIssueVO.setInvno(list2.get(j).getInvNo());
					invIssueVO.setIssflg("Y");
					invIssueVO.setIfno(list2.get(j).getArIfNo());
					invIssueVO.setDuedt(list2.get(j).getDueDt());
					invIssueVO.setBkgno(list2.get(j).getBkgNo());
					invIssueVO.setInvrmk(list2.get(j).getInvRmk());

					command2.modifyInvoiceIssue(invIssueVO, event.getGenInvVo().getOtsSmryCd(), account.getUsr_id());
				}
			}
			commit();

			eventResponse.setETCData("inv_nos", invNos);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}
	*/
	
	/**
	 * FNS_INV_0034_01 : Paper Issue, Go to Send <br>
	 * Issue Europe, part of Southwest Asia , north China Invoice.(BackEndJob) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerListForIssue(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event)e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();

		try{
			List<CustomerListForIssueVO> list = command.searchCustomerListForIssue(event.getGenInvVo());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * FNS_INV_0034_01 : Paper Issue, Go to Send <br>
	 * Issue Europe, part of Southwest Asia , north China Invoice.(BackEndJob) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueGeneralInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		try {
			begin();
			
			String backEndJobKey = command.issueGeneralInvoiceBackEndJobKey(event.getGenInvVo(), event.getCustomerListForIssueVOs(), account.getUsr_id());
			
				eventResponse.setETCData("BackEndJobKey", backEndJobKey); 
			commit();
			
		} catch (EventException ex) {
			rollback();
			log.error("errSc1=============>> " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("errSc2=============>> " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}		
	
	

	/**
	 * FNS_INV_0034_02, FNS_INV_0037 : Open <br>
	 * Retrieve Fax / E-mail Send Or Print Invoice Info <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIssuedGeneralInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// FnsInv003402Event event = (FnsInv003402Event)e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		INVCommonUtil commonUtil = new INVCommonUtil();
		List<InvoiceFaxEmailListVO> list = null;
		String printName = "";
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {

			if (e.getEventName().equalsIgnoreCase("FnsInv003402Event")) {
				FnsInv003402Event event = (FnsInv003402Event) e;
				log.info("\n########## IssueGubn : " + event.getPrtInvoiceVo().getIssueGubn());
				list = command.searchIssuedGeneralInvoiceList(event.getPrtInvoiceVo());
			}

			if(list != null){
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setRsVoList(null);
			}
			
			printName = commonUtil.searchARPrinterName(account.getOfc_cd(), account.getUsr_id());
			log.info("\n########## printName : " + printName);
			eventResponse.setETCData("inv_prn_dvc_nm", printName);

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
	 * FNS_INV_0059 : Retrieve Invoice Fax  Or E-mail send Result satus.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFaxEmailSentResultListBySendDate(Event e) throws EventException {
		FnsInv0059Event event = (FnsInv0059Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		try {
			List<FaxEmailSentResultVO> list = command.searchFaxEmailSentResultListBySendDate(event.getFaxEmailSentDateVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0034_02, FNS_INV_0037 : Send <br>
	 *  Fax / E-mail send  or Print when after Invoice Info create or correct <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createIssueMain(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)

		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		String issueCnt = "0";

		try {
			InvIssMainVO[] issMainVOs = null;
			String sendFlag = "";
			String sendFlag2 = "";
			String issueGubn = "";
			String issOfcCd = "";
			String rdName = "";
			String nameFlag = "";
			String titleFlag = "";
			String sendType = "";
			String issueType = "";
			String copyCnt = "";
			String issLehbb = "";
			String logoGb = "";
			String officeCntCd = "";

			if (e.getEventName().equalsIgnoreCase("FnsInv003402Event")) {
				FnsInv003402Event event = (FnsInv003402Event) e;
				issMainVOs = event.getIssMainVOs();
				sendFlag = event.getSendFlag();
				sendFlag2 = event.getSendFlag2();
				issueGubn = event.getIssueGubn();
				issOfcCd = event.getOfcCd();
				rdName = event.getRdName();
				officeCntCd = event.getOfficeCntCd();
				nameFlag = "";
				titleFlag = "";
				sendType = event.getSendType();
				issueType = event.getIssueType();
				copyCnt = event.getCopyCnt();
				issLehbb = event.getIssLehbb();
				logoGb = event.getLogoGb();
			} 
			
			if(issMainVOs == null){
				issMainVOs = new InvIssMainVO[0];
			}
			
			IssueOptionVO issOptionVO = new IssueOptionVO();
			if(sendFlag != null){issOptionVO.setSendFlag(sendFlag);}
			if(sendFlag2 != null){issOptionVO.setSendFlag2(sendFlag2);}
			if(issueGubn != null){issOptionVO.setIssueGubn(issueGubn);}
			if(issOfcCd != null){issOptionVO.setIssOfcCd(issOfcCd);}
			if(rdName != null){issOptionVO.setRdName(rdName);}
			if(nameFlag != null){issOptionVO.setNameFlag(nameFlag);}
			if(titleFlag != null){issOptionVO.setTitleFlag(titleFlag);}
			if(sendType != null){issOptionVO.setSendType(sendType);}
			if(issueType != null){issOptionVO.setIssueType(issueType);}
			if(copyCnt != null){issOptionVO.setCopyCnt(copyCnt);}
			if(issLehbb != null){issOptionVO.setIssLehbb(issLehbb);}
			if(logoGb != null){issOptionVO.setLogoGb(logoGb);}
			if(officeCntCd != null){issOptionVO.setOfficeCntCd(officeCntCd);}
			
			for (int i = 0; i < issMainVOs.length; i++) {
				issMainVOs[i].setCreUsrId(account.getUsr_id());
				issMainVOs[i].setUsrId(account.getUsr_id());
				issMainVOs[i].setUsrNm(account.getUsr_nm());
				issMainVOs[i].setAccountCreUsrId(account.getCre_usr_id());
				issMainVOs[i].setAccountUpdUsrId(account.getUpd_usr_id());
			}

			begin();

			//Change Reissue to Batch 20160527 
			if ("R".equals(issueGubn)) {
				issueCnt = command.createReissueMain(issMainVOs, issOptionVO, account);	
			} else {
				issueCnt = command.createIssueMain(issMainVOs, issOptionVO, account.getUsr_id());
				
				command2.modifyInvoiceIssueEmail(issMainVOs, issOfcCd, issueGubn, account.getUsr_id());
				
				if (sendFlag.equals("P")) {
					log.info("########## sendFlag2 : "+sendFlag);
					command.sendGeneralInvoiceByPaper(issMainVOs, issOptionVO, account, officeCntCd);
				} else if (sendFlag.equals("E") || sendFlag.equals("F")) {
					log.info("########## sendFlag2 : "+sendFlag);
					command.sendGeneralInvoiceByFaxEmail(issMainVOs, issOptionVO, account, officeCntCd); // 2016.03.04 OfficeCntCd 추가
				}			
			}

			commit();

			eventResponse.setETCData("issueCnt", issueCnt);
			return eventResponse;

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0034_02, FNS_INV_0037 : Add <br>
	 * search attached E-Mail File Key<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAttachFileKey(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("FnsInv003402Event")) {
				FnsInv003402Event event = (FnsInv003402Event) e;
				eventResponse.setETCData("fileKey", event.getKeys().get(0));
			} 
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ex);
		}
		return eventResponse;
	}

	
	
	/**
	 * FNS_INV_0098 : CNTR No@FOCUS OUT <br>
	 * Retrieve Container no type size. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerNo(Event e) throws EventException {

		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		FnsInv0098Event event = (FnsInv0098Event) e;
		String cntrTpszCd = "";
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			cntrTpszCd = command.searchContainerNo(event.getCntrNo());
			eventResponse.setETCData("cntr_tpsz_cd", cntrTpszCd);

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
	 * FNS_INV_0057 : Retrieve<br>
	 * Retrieve not issued Invoice by Customer.<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNotIssueListByCustomer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0057Event event = (FnsInv0057Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<NotIssuedListVO> list = command.searchNotIssueListByCustomer(event.getNotissuedInputVO());
			
			if (list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
				
				eventResponse.setETCData("dp_prcs_knt", list.get(0).getDpPrcsKnt());
				eventResponse.setETCData("cr_amt", list.get(0).getCrAmt());
				eventResponse.setETCData("ib_cr_term_dys", list.get(0).getIbCrTermDys());
				eventResponse.setETCData("ob_cr_term_dys", list.get(0).getObCrTermDys());
			} else {
				eventResponse.setETCData("dp_prcs_knt", "0");
				eventResponse.setETCData("cr_amt", "");
				eventResponse.setETCData("ib_cr_term_dys", "");
				eventResponse.setETCData("ob_cr_term_dys", "");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * FNS_INV_0106 : Retrieve <br>
	 * Retrieve Invoice order by issued date (Use Re-Issue UI). <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopInvoiceListByIssueDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		FnsInv0106Event event = (FnsInv0106Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<ARInvoiceIssueDateVO> list = command.searchPopInvoiceListByIssueDate(event.getInvoiceIssueDateVO());

			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
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
	 * FNS_INV_0017 : 조회<br>
	 * Retrieve Invoice Customer Correction by Interface Date .<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchARInvoiceListByDate(Event e) throws EventException {
		FnsInv0017Event event = (FnsInv0017Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			List<ARInvoiceCustomerVO> list = command.searchARInvoiceListByDate(event.getARInvoiceCustomerInputVO());
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
	 * FNS_INV_0017 : 조회<br>
	 * Retrieve Customer List by Customer Name.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchARCustomerList(Event e) throws EventException {
		FnsInv0017Event event = (FnsInv0017Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<MDMCustomerVO> list = command.searchARCustomerList(event.getOfcCd(), event.getCustNm());
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
	 * FNS_INV_0017 : insert, update<br>
	 * Handling Interface ERP Invoice Correction by B/L.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyARInvoiceListByDate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0017Event event = (FnsInv0017Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();

		InvArMnVO[] invArMnVOs = event.getInvArMnVOs();
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
		List<InvArIfNoVO> maxIfNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO maxArIfNoVO = new InvArIfNoVO();
		//String newIfNo="";		
		String otsSmryCd = "";
		try {
			begin();
			
			if (invArMnVOs != null) {
				for (int i = 0; i < invArMnVOs.length; i++) {
					// OTSSummary 조회
					otsSmryCd = command.searchOTSSummary(invArMnVOs[i].getArOfcCd());
					
					// Retrieve correct list by BLNo
					List<InvArMnVO> invArMnList = command.searchARInvoiceMainList(invArMnVOs[i].getArOfcCd(), invArMnVOs[i].getBlSrcNo(), invArMnVOs[i].getArIfNo());

					
					if (otsSmryCd.equals("INV")||otsSmryCd.equals("CLR")) {					
						
					
						if (invArMnList != null) {
							for (int j = 0; j < invArMnList.size(); j++) {							
								
								ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();
	
								aRCorrectionCkVO.setBkgNo(invArMnList.get(j).getBkgNo());
								aRCorrectionCkVO.setInvCustFlg("Y");
								aRCorrectionCkVO.setOfcCd(invArMnList.get(j).getArOfcCd());
								aRCorrectionCkVO.setSailingDt(invArMnList.get(j).getSailDt());
								aRCorrectionCkVO.setBlInvCfmDt(invArMnList.get(j).getBlInvCfmDt());
								// Retrieve Rev Type, Effective Dt
								ARCorrectionCkReturnVO arCrctCkRtVO = command.checkARCorrection(aRCorrectionCkVO);
	
								// Cancel Data setting
								CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();
	
								cancelInvoiceVO.setEffDt(arCrctCkRtVO.getEffectiveDt());
								cancelInvoiceVO.setIfNo(invArMnList.get(j).getArIfNo());
								cancelInvoiceVO.setOtsSmryCd(otsSmryCd);
								cancelInvoiceVO.setUserId(account.getUsr_id());
								cancelInvoiceVO.setInvCustFlg("Y");
								//cancelInvoiceVO.setRevTpCd(arCrctCkRtVO.getRevTpCd());
								//cancelInvoiceVO.setRevSrcCd(arCrctCkRtVO.getRevSrcCd());
								cancelInvoiceVO.setInvCustCntCd(invArMnVOs[i].getActCustCntCd());
								cancelInvoiceVO.setInvCustSeq(invArMnVOs[i].getActCustSeq());
								
								// Good Data : Cancel->New
								if (!invArMnList.get(j).getBlInvCfmDt().equals("")) {
									String cancelIfNo = bcommand.createARCancelInvoice(cancelInvoiceVO);	
	
									if(!cancelIfNo.equals("")){
										if(otsSmryCd.equals("INV")){
											maxArIfNoVO = new InvArIfNoVO();
											maxArIfNoVO.setIfNo(invArMnList.get(j).getArIfNo());
											maxIfNos.add(maxArIfNoVO);
										}
										
										invArIfNoVO = new InvArIfNoVO();
										invArIfNoVO.setIfNo(cancelIfNo);
										ifNos.add(invArIfNoVO);
									}								
								} 
							}		
						}
					
					}
					
					ARCorrectionCkVO aRCorCkVO = new ARCorrectionCkVO();

					aRCorCkVO.setBkgNo(invArMnVOs[i].getBkgNo());
					aRCorCkVO.setInvCustFlg("Y");
					aRCorCkVO.setOfcCd(invArMnVOs[i].getArOfcCd());
					aRCorCkVO.setSailingDt(invArMnVOs[i].getSailDt());
					aRCorCkVO.setBlInvCfmDt(invArMnVOs[i].getBlInvCfmDt());
					// Retrieve Rev Type, Effective Dt 
					ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.checkARCorrection(aRCorCkVO);

					// Cancel Data setting
					CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

					cancelInvoiceVO.setEffDt(arCorrectionCkReturnVO.getEffectiveDt());
					cancelInvoiceVO.setIfNo(invArMnVOs[i].getArIfNo());
					cancelInvoiceVO.setOtsSmryCd(otsSmryCd);
					cancelInvoiceVO.setUserId(account.getUsr_id());
					cancelInvoiceVO.setInvCustFlg("Y");
					//cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
					//cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
					cancelInvoiceVO.setInvCustCntCd(invArMnVOs[i].getActCustCntCd());
					cancelInvoiceVO.setInvCustSeq(invArMnVOs[i].getActCustSeq());
					
					if (!invArMnVOs[i].getBlInvCfmDt().equals("")) {
						String cancelIfNo = bcommand.createARCancelInvoice(cancelInvoiceVO);
						if(!cancelIfNo.equals("")){
							
							if(otsSmryCd.equals("INV")){
								maxArIfNoVO = new InvArIfNoVO();
								maxArIfNoVO.setIfNo(invArMnVOs[i].getArIfNo());
								maxIfNos.add(maxArIfNoVO);
							}
							
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(cancelIfNo);
							ifNos.add(invArIfNoVO);
						}
					}
					
					if (otsSmryCd.equals("INV")||otsSmryCd.equals("CLR")) {
					
						if (invArMnList != null) {						
							for (int j = 0; j < invArMnList.size(); j++) {
								
								/*
								DueDateInputVO dueDateInputVO = new DueDateInputVO();
	
								dueDateInputVO.setBnd(invArMnList.get(j).getIoBndCd());
								dueDateInputVO.setCustCntCd(invArMnVOs[i].getActCustCntCd());
								dueDateInputVO.setSaDt(invArMnList.get(j).getSailArrDt());
								dueDateInputVO.setCustSeq(invArMnVOs[i].getActCustSeq());
								dueDateInputVO.setOfcCd(invArMnList.get(j).getArOfcCd());
								// Retrieve Due Date
								List<DueDateVO> dueDtList = command.searchDueDate(dueDateInputVO);
								*/
								ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();
	
								aRCorrectionCkVO.setBkgNo(invArMnList.get(j).getBkgNo());
								aRCorrectionCkVO.setInvCustFlg("Y");
								aRCorrectionCkVO.setOfcCd(invArMnList.get(j).getArOfcCd());
								aRCorrectionCkVO.setSailingDt(invArMnList.get(j).getSailDt());
								aRCorrectionCkVO.setBlInvCfmDt(invArMnList.get(j).getBlInvCfmDt());
								//Retrieve Rev Type, Effective Dt 
								ARCorrectionCkReturnVO arCrctCkRtVO = command.checkARCorrection(aRCorrectionCkVO);
								
								// New Data setting
								InvNewCustVO invNewCustVO = new InvNewCustVO();
	
								invNewCustVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
								invNewCustVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
								invNewCustVO.setInvCustCntCd(invArMnVOs[i].getActCustCntCd());
								invNewCustVO.setInvCustSeq(invArMnVOs[i].getActCustSeq());
								/*
								if (dueDtList.size() > 0) {
									// Due Date setting
									invNewCustVO.setDueDt(dueDtList.get(0).getDueDate());
									invNewCustVO.setCustCrFlg(dueDtList.get(0).getCrFlg());
									invNewCustVO.setCrTermDys(dueDtList.get(0).getCrTermDys());
								}
								*/
								
								invNewCustVO.setArIfNo(invArMnList.get(j).getArIfNo());
								invNewCustVO.setInvRmk(invArMnList.get(j).getInvRmk());
								invNewCustVO.setUiType("C");
								
								invNewCustVO.setOtsSmryCd(otsSmryCd);
								invNewCustVO.setGlEffDt(arCrctCkRtVO.getEffectiveDt());
								invNewCustVO.setInvCustFlg("Y");
								//invNewCustVO.setRevTpCd(arCrctCkRtVO.getRevTpCd());
								//invNewCustVO.setRevSrcCd(arCrctCkRtVO.getRevSrcCd());
								invNewCustVO.setBlInvCfmDt(invArMnList.get(j).getBlInvCfmDt());
								
								// Good Data : Cancel->New
								if (!invArMnList.get(j).getBlInvCfmDt().equals("")) {
									invNewCustVO.setSplitFlag("C");	
									String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
									
									if(!newIfNo.equals("")){
										invArIfNoVO = new InvArIfNoVO();
										invArIfNoVO.setIfNo(newIfNo);
										ifNos.add(invArIfNoVO);
									}
									// No Good Data :
								} else {
									invNewCustVO.setSplitFlag("C");								
									String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
									if(!newIfNo.equals("")){
										invArIfNoVO = new InvArIfNoVO();
										invArIfNoVO.setIfNo(newIfNo);
										ifNos.add(invArIfNoVO);
									}
								}
								
							}
						}
					
					}
					
					/*
					DueDateInputVO dueDateInputVO = new DueDateInputVO();

					dueDateInputVO.setBnd(invArMnVOs[i].getIoBndCd());
					dueDateInputVO.setCustCntCd(invArMnVOs[i].getActCustCntCd());
					dueDateInputVO.setSaDt(invArMnVOs[i].getSailArrDt());
					dueDateInputVO.setCustSeq(invArMnVOs[i].getActCustSeq());
					dueDateInputVO.setOfcCd(invArMnVOs[i].getArOfcCd());
					// Retrieve Due Date
					List<DueDateVO> list = command.searchDueDate(dueDateInputVO);

					*/					

					// New Data setting
					InvNewCustVO invNewCustVO = new InvNewCustVO();

					invNewCustVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
					invNewCustVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
					invNewCustVO.setInvCustCntCd(invArMnVOs[i].getActCustCntCd());
					invNewCustVO.setInvCustSeq(invArMnVOs[i].getActCustSeq());
					/*
					if (list.size() > 0) {
						// Due Date setting
						invNewCustVO.setDueDt(list.get(0).getDueDate());
						invNewCustVO.setCustCrFlg(list.get(0).getCrFlg());
						invNewCustVO.setCrTermDys(list.get(0).getCrTermDys());
					}
					*/
					invNewCustVO.setArIfNo(invArMnVOs[i].getArIfNo());
					invNewCustVO.setInvRmk(invArMnVOs[i].getInvRmk());
					invNewCustVO.setUiType("C");
					invNewCustVO.setOtsSmryCd(otsSmryCd);
					invNewCustVO.setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
					invNewCustVO.setInvCustFlg("Y");
					//invNewCustVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
					//invNewCustVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
					invNewCustVO.setBlInvCfmDt(invArMnVOs[i].getBlInvCfmDt());
					// Good Data : Cancel->New
					if (!invArMnVOs[i].getBlInvCfmDt().equals("")) {						
						invNewCustVO.setSplitFlag("C");
						
						String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
						}
						// No Good Data 
					} else {
						invNewCustVO.setSplitFlag("C");
						
						String newIfNo = bcommand.createNewCustomerARInvoice(invNewCustVO, account.getUsr_id());
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
						}
					}
				}
			}
			
			/*
			begin();
			if(maxIfNos!= null && maxIfNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(maxIfNos, "U");
			}
			
			if(ifNos!= null && ifNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
			}
			commit();
			*/
			
			// 2014.06.11 AR OTS creation  
			// 2014.08.14 block maxifno
		    //if(maxIfNos!= null && maxIfNos.size()>0){
		    //	command2.createOutstandingInfo(maxIfNos);
		    //}
		   
		    if(ifNos!= null && ifNos.size()>0){
		    	command2.createOutstandingInfo(ifNos);
		    }
		   
		    commit();
			   
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
	 * FNS_INV_0094_01 : Retrieve <br>
	 * Retrieve Invoice Customer Change (Single)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChangeCustomerInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv009401Event event = (FnsInv009401Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		InvoiceCustomerChangeVO invoiceCustomerChangeVO = new InvoiceCustomerChangeVO();
		try {
			//Add checking no issued count 2016.05.16
			int notIssCnt = command.searchNotIssuedCount(event.getOfcCd(), event.getInvNo());
			eventResponse.setETCData("no_iss_cnt", Integer.toString(notIssCnt));
			
			invoiceCustomerChangeVO = command.searchChangeCustomerInvoice(event.getOfcCd(), event.getInvNo());
			
			eventResponse.setRsVo(invoiceCustomerChangeVO);
			eventResponse.setRsVoList(invoiceCustomerChangeVO.getInvoiceCustomerChangeChargeVOs());
			//eventResponse.setRsVoList(invoiceCustomerChangeVO.getDueDateInputVOs());
			if (invoiceCustomerChangeVO.getInvoiceCustomerChangeChargeVOs() != null && invoiceCustomerChangeVO.getInvoiceCustomerChangeChargeVOs().size() > 0) {
				eventResponse.setETCData("dp_prcs_knt_local", invoiceCustomerChangeVO.getInvoiceCustomerChangeChargeVOs().get(0).getDpPrcsKntLocal());
			} else {
				eventResponse.setETCData("dp_prcs_knt_local", "0");
			}

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
	 * FNS_INV_0094_01 : insert,update<br>
	 * create Invoice Customer Change (Single) Cancel Data , New Data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCustomerChangeInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv009401Event event = (FnsInv009401Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();

		//DueDateInputVO[] dueDateInputVOs = event.getDueDateInputVOs();
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();	
		String newIfNo="";		
		
		try {
			begin();

			int repCustCnt = 0;

			repCustCnt = command.checkRepCustomer(event.getActCustCntCd(), event.getActCustSeq());

			if (repCustCnt > 0) {
				eventResponse.setUserMessage(new ErrorHandler("INV00123", new String[] {}).getUserMessage());
			}

			int invRepCustCnt = 0;

			invRepCustCnt = command.checkRepCustomer(event.getInvCustCntCd(), event.getInvCustSeq());

			if (invRepCustCnt > 0) {
				eventResponse.setUserMessage(new ErrorHandler("INV00123", new String[] {}).getUserMessage());
			}

			
			//if (dueDateInputVOs != null) {
					// Cancel Data create

				ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(event.getBkgNo(), "C");

				CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

				cancelInvoiceVO.setIfNo(event.getArIfNo());
				cancelInvoiceVO.setOtsSmryCd("");
				cancelInvoiceVO.setUserId(account.getUsr_id());
				cancelInvoiceVO.setInvNo(event.getInvNo());
				cancelInvoiceVO.setRevTpCd(event.getRevTpCd().equals("M")?event.getRevTpCd():arCorrectionCkReturnVO.getRevTpCd());
				cancelInvoiceVO.setRevSrcCd(event.getRevTpCd().equals("M")?event.getRevSrcCd():arCorrectionCkReturnVO.getRevSrcCd());
				cancelInvoiceVO.setUiType("C");
				//cancelInvoiceVO.setInvCurrCd(event.getInvCurrCd());  //2015.01.09
				
				newIfNo = bcommand.createCancelIssueARInvoice(cancelInvoiceVO);
				
				if(!newIfNo.equals("")){
					invArIfNoVO = new InvArIfNoVO();
					invArIfNoVO.setIfNo(newIfNo);
					ifNos.add(invArIfNoVO);
				}

				CancelInvoiceVO newInvoiceVO = new CancelInvoiceVO();

				newInvoiceVO.setActCustCntCd(event.getActCustCntCd());
				newInvoiceVO.setActCustSeq(event.getActCustSeq());
				newInvoiceVO.setInvCustCntCd(event.getInvCustCntCd());
				newInvoiceVO.setInvCustSeq(event.getInvCustSeq());
				newInvoiceVO.setIfNo(event.getArIfNo());
				newInvoiceVO.setInvNo(event.getInvNo());
				newInvoiceVO.setRevTpCd(event.getRevTpCd().equals("M")?event.getRevTpCd():arCorrectionCkReturnVO.getRevTpCd());
				newInvoiceVO.setRevSrcCd(event.getRevTpCd().equals("M")?event.getRevSrcCd():arCorrectionCkReturnVO.getRevSrcCd());
				newInvoiceVO.setUiType("C");
				newInvoiceVO.setUserId(account.getUsr_id());

				// New Data create
				//if(event.getRevTpCd().equals("M")&&event.getBkgNo().equals("")){
				//2010-05-14	
				if(event.getRevTpCd().equals("M")){
					newIfNo = bcommand.createNewMIssueARInvoice(newInvoiceVO);
				}else{
					newIfNo = bcommand.createNewIssueARInvoice(newInvoiceVO);
				}
				
				if(!newIfNo.equals("")){
					invArIfNoVO = new InvArIfNoVO();
					invArIfNoVO.setIfNo(newIfNo);
					ifNos.add(invArIfNoVO);
				}
				
				bcommand.modifySplitCodebyInvNo(event.getInvNo(), event.getOfcCd(),"M", account.getUsr_id());
				
				/*
				for (int i = 0; i < dueDateInputVOs.length; i++) {
					bcommand.modifySplitCode(dueDateInputVOs[i].getArIfNo(), "M", "", account.getUsr_id());
				}*/
				
			//}
			
			// 2014.06.13 AR OTS creation
			if(ifNos!= null && ifNos.size()>0){
				command2.createOutstandingInfo(ifNos);
			}
			
			commit();
			
			//화면단에서 성공메세지 처리 2015.04.27 
			//eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			if(ex.getMessage().contains("COM")||ex.getMessage().contains("FRM")||ex.getMessage().contains("INV00053")){
				throw new EventException(new ErrorHandler("INV00195").getMessage(), ex);
			}
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	

	/**
	 * FNS_INV_0094_02: Retrieve<br>
	 * Retrieve Invoice Customer Change (Multi).<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChangeCustomerInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv009402Event event = (FnsInv009402Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		InvoiceCustomerChangeVO invoiceCustomerChangeVO = new InvoiceCustomerChangeVO();

		try {
			invoiceCustomerChangeVO = command.searchChangeCustomerInvoiceList(event.getChangeCustomerInputVO());

			eventResponse.setRsVoList(invoiceCustomerChangeVO.getInvoiceCustomerChangeListVOs());
			eventResponse.setRsVoList(invoiceCustomerChangeVO.getDueDateInputVOs());

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
	 * FNS_INV_0094_02: Retrieve<br>
	 * Check Invoice Customer Change (Single) RepCustomer<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkRepCustomer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv009402Event event = (FnsInv009402Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			int repCustCnt = 0;

			repCustCnt = command.checkRepCustomer(event.getActCustCntCd(), event.getActCustSeq());
			
			eventResponse.setETCData("rep_cust_cnt", Integer.toString(repCustCnt));

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
	 * FNS_INV_0094_02 : 입력,수정<br>
	 * Retrieve BackEndJob Key for create Invoice Customer Change (Multi) Cancel Data , New Data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCustomerChangeInvoiceListBackEndJobKey(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv009402Event event = (FnsInv009402Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();

		try {
			begin();
			
			InvoiceCustomerChangeVO invoiceCustomerChangeVO = new InvoiceCustomerChangeVO();
			
			invoiceCustomerChangeVO.setActCustCntCd(event.getActCustCntCd());
			invoiceCustomerChangeVO.setActCustSeq(event.getActCustSeq());
			invoiceCustomerChangeVO.setInvCustCntCd(event.getInvCustCntCd());
			invoiceCustomerChangeVO.setInvCustSeq(event.getInvCustSeq());
			
	        String backEndJobKey = command.createCustomerChangeInvoiceList(event.getDueDateInputVOs(), invoiceCustomerChangeVO, account.getUsr_id());
	        eventResponse.setETCData("BackEndJobKey", backEndJobKey);
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
	 * FNS_INV_0094_02 : 입력,수정<br>
	 * Retrieve BackEndJob Status for create Invoice Customer Change (Multi) Cancel Data , New Data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse createCustomerChangeInvoiceListBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv009402Event event = (FnsInv009402Event) e;

    	try {    		
	    	if(event.getBackEndJobKey() != null && !event.getBackEndJobKey().equals("")) {
    			// check Backend job completed
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(event.getBackEndJobKey());

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	
		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		// avoid Error when Background job framework art not functional.
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}

    	return eventResponse;
    }
	
	/**
	 * FNS_INV_0094_02 : insert,update<br>
	 * Retrieve BackEndJob LoadFile method result for create Invoice Customer Change (Multi) Cancel Data , New Data<br>
     * 
     * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCustomerChangeInvoiceListBackEndJobFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv009402Event event = (FnsInv009402Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();

		try {
			command.getBackEndJobResutModifyExchangeRateList(event.getBackEndJobKey());			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

        return eventResponse;
	}
	
	/**
	 * FNS_INV_0094_02 : insert,update<br>
	 * create Invoice Customer Change (Multi) Cancel Data , New Data.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCustomerChangeInvoiceList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv009402Event event = (FnsInv009402Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		//AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();

		DueDateInputVO[] dueDateInputVOs = event.getDueDateInputVOs();
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();	
		String newIfNo="";		
		
		try {
			begin();

			int repCustCnt = 0;

			repCustCnt = command.checkRepCustomer(event.getActCustCntCd(), event.getActCustSeq());

			if (repCustCnt > 0) {
				eventResponse.setUserMessage(new ErrorHandler("INV00123", new String[] {}).getUserMessage());
			}

			if (dueDateInputVOs != null) {

				for (int i = 0; i < dueDateInputVOs.length; i++) {
						
					ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(dueDateInputVOs[i].getBkgNo(), "C");

					CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

					cancelInvoiceVO.setIfNo(dueDateInputVOs[i].getArIfNo());
					cancelInvoiceVO.setOtsSmryCd("");
					cancelInvoiceVO.setUserId(account.getUsr_id());
					cancelInvoiceVO.setInvNo(dueDateInputVOs[i].getInvNo());
					cancelInvoiceVO.setRevTpCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevTpCd():arCorrectionCkReturnVO.getRevTpCd());
					cancelInvoiceVO.setRevSrcCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevSrcCd():arCorrectionCkReturnVO.getRevSrcCd());
					cancelInvoiceVO.setUiType("C");
					
					newIfNo = bcommand.createCancelIssueARInvoice(cancelInvoiceVO);
					
					if(!newIfNo.equals("")){
						invArIfNoVO = new InvArIfNoVO();
						invArIfNoVO.setIfNo(newIfNo);
						ifNos.add(invArIfNoVO);
					}

					CancelInvoiceVO newInvoiceVO = new CancelInvoiceVO();

					newInvoiceVO.setActCustCntCd(event.getActCustCntCd());
					newInvoiceVO.setActCustSeq(event.getActCustSeq());
					newInvoiceVO.setIfNo(dueDateInputVOs[i].getArIfNo());
					newInvoiceVO.setInvNo(dueDateInputVOs[i].getInvNo());
					newInvoiceVO.setRevTpCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevTpCd():arCorrectionCkReturnVO.getRevTpCd());
					newInvoiceVO.setRevSrcCd(dueDateInputVOs[i].getRevTpCd().equals("M")?dueDateInputVOs[i].getRevSrcCd():arCorrectionCkReturnVO.getRevSrcCd());
					newInvoiceVO.setUiType("C");
					newInvoiceVO.setUserId(account.getUsr_id());
					
					
					// New Data create
					//if(dueDateInputVOs[i].getRevTpCd().equals("M")&&dueDateInputVOs[i].getBkgNo().equals("")){
					if(dueDateInputVOs[i].getRevTpCd().equals("M")){
						newIfNo = bcommand.createNewMIssueARInvoice(newInvoiceVO);
					}else{
						newIfNo = bcommand.createNewIssueARInvoice(newInvoiceVO);
					}
					
					
					if(!newIfNo.equals("")){
						invArIfNoVO = new InvArIfNoVO();
						invArIfNoVO.setIfNo(newIfNo);
						ifNos.add(invArIfNoVO);
					}
					
					bcommand.modifySplitCodebyInvNo(dueDateInputVOs[i].getInvNo(), dueDateInputVOs[i].getOfcCd(),"M", account.getUsr_id());
					

				// Invoice Split Code  Update.
				//bcommand.modifySplitCode(dueDateInputVOs[i].getArIfNo(), "M", "", account.getUsr_id());
				}
				
			}
		
			// 2014.06.13 AR OTS creation
			//if(ifNos!= null && ifNos.size()>0){
			//	command2.createOutstandingInfo(ifNos);
			//}
			
			commit();
			
			//화면단에서 성공메세지 처리 2015.04.27 
			//eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
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
	 * FNS_INV_0029 : Execute<br>
	 * Handling B/L data 'Sys Clear' when Invoice amount total is 0(zero).<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySysClearList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0029Event event = (FnsInv0029Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		int result = 0;
		try {
			begin();

			SysClearVO sysClearVo = event.getSysClearVo();

			sysClearVo.setUserId(account.getUsr_id());

			result = command.modifySysClearList(sysClearVo);

			eventResponse.setETCData("result_cnt", String.valueOf(result));

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
	 * FNS_INV_0029 : Execute<br>
	 * Handling I/F No. 'Sys Clear' when Invoice amount total is 0(zero).<br>
	 * 
	 * @author JungJin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySysClearListByIfNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0029Event event = (FnsInv0029Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		int result = 0;
		try {
			begin();

			SysClearVO sysClearVo = event.getSysClearVo();

			sysClearVo.setUserId(account.getUsr_id());

			result = command.modifySysClearListByIfNo(sysClearVo);

			eventResponse.setETCData("result_cnt", String.valueOf(result));

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
	 * FNS_INV_0027: update <br> 
	 *  Retrieve BackEndJob Key for update rate info when Rates are empty<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyExchangeRateListBackEndJobKey(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0027Event event = (FnsInv0027Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();
		//ScoBatHisVO scoBatHisVO = new ScoBatHisVO();					//Local Execute
		//StatementCommonBC scoCommand = new StatementCommonBCImpl();	//Local Execute
		
		try {
			
			//insert SCO_BAT_HIS
			begin();
			String batSeq = command.createScoBatHisByExRate(event.getExrateInputVOs(),event.getExrateInputVO(),event.getRunOpt(), event.getOfcCd(), account.getUsr_id());
			commit();
			
			
			//FNS_INV_B005 BATCH CALL
			if(!batSeq.equals("")) {
				//check batch status
				String pgmNo = "FNS_INV_B005";
				String batStsCd = command.searchExchangeRateBatStsCd(pgmNo);		
				
				if("S".equals(batStsCd)){
					command.callModifyExchangeRateListBat(batSeq, account.getUsr_id());
				}else if("R".equals(batStsCd)){	// Running
					begin();
					// sco_bat_his 에 E 로 업데이트 한다
					command.manageCancelExchangeRateBat(batSeq, account);
					eventResponse.setETCData("batStsCd", batStsCd); 
					commit();
				}
			}
			
			
			//Local Execute Start ================================================================================
			/*if(!batSeq.equals("")) {
				
				scoBatHisVO.setCreUsrId(account.getUsr_id());
				scoBatHisVO.setUpdUsrId(account.getUsr_id());
				scoBatHisVO.setBatSeq(batSeq);
				
				//1. ScoBatch 시작 상태로 update
				begin();
				scoBatHisVO.setBatRsltCd("B");
				scoCommand.modifyScoBatHis(scoBatHisVO);
				commit();
				
				//2. 실제 처리 로직				
				begin();
				command.readyModifyExchangeRateListByBatSeq(batSeq);
				commit();
				
				//3. ScoBatch 종료 상태로 update
				begin();
				scoBatHisVO.setBatRsltCd("S");
				scoCommand.modifyScoBatHis(scoBatHisVO);
				commit();
			}*/
			//Local Execute End ================================================================================
			
			
			eventResponse.setETCData("BackEndJobKey", batSeq);

		} catch (EventException ex) {
			rollback();
			
			//Local Execute Start ================================================================================
			//4. Exception 발생 시 ScoBatch Error 상태로 update
			/*begin();
			scoBatHisVO.setBatRsltCd("E");
			scoBatHisVO.setBatRsltDesc(ex.getMessage());
			scoCommand.modifyScoBatHis(scoBatHisVO);
			commit();*/
			//Local Execute End ================================================================================
			
			
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0027: update <br> 
	 * Retrieve BackEndJob status for update rate info when Rates are empty<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse modifyExchangeRateListBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StatementCommonBC scoCommand = new StatementCommonBCImpl();
		
		FnsInv0027Event event = (FnsInv0027Event) e;
		try {

				String backEndJobKey = event.getBackEndJobKey() ;
				
				ScoBatHisVO batHisVO = scoCommand.searchScoBatHis(backEndJobKey);
				if(batHisVO == null){
					eventResponse.setETCData("jb_sts_flg", "4");
				} else {
					if(batHisVO.getBatRsltCd().equals("W") || batHisVO.getBatRsltCd().equals("B")){
						eventResponse.setETCData("jb_sts_flg", "1");
					} else if(batHisVO.getBatRsltCd().equals("S")){
						eventResponse.setETCData("jb_sts_flg", "3");
					} else if(batHisVO.getBatRsltCd().equals("E")){
						eventResponse.setETCData("jb_sts_flg", "4");
					}
				}
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("SCO00003",
					new String[] {}).getMessage());
		}
		return eventResponse;
		
		
		/*GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0027Event event = (FnsInv0027Event) e;

    	try {    		
	    	if(event.getBackEndJobKey() != null && !event.getBackEndJobKey().equals("")) {
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(event.getBackEndJobKey());

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	
		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}

    	return eventResponse;*/
		
    }
	
	/**
	 * FNS_INV_0027: 수정 <br> 
	 * Retrieve BackEndJob LoadFile method result for update rate info when Rates are empty<br>
     * 
     * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyExchangeRateListBackEndJobFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0027Event event = (FnsInv0027Event) e;
		BookingARCreationBC command = new BookingARCreationBCImpl();

		try {
			
			
			INVCommonUtil invUtil = new INVCommonUtil();			
			String key = event.getBackEndJobKey();
			key = "999" + invUtil.lPad(key, 12, "0");
				
			
			List<ExRateCountVO> exRateCountVOs = command.getBackEndJobResutModifyExchangeRateList(key);
			
			
			InvoiceIssueBC issCommand = new InvoiceIssueBCImpl();
			issCommand.removeInvoiceIssueTemp(key);
			
			if(exRateCountVOs.size()>0){				
				eventResponse.setRsVoList(exRateCountVOs);				
				eventResponse.setETCData("tot_cnt", exRateCountVOs.get(0).getCount1());
				eventResponse.setETCData("good_cnt", exRateCountVOs.get(0).getCount2());
				eventResponse.setETCData("no_good_cnt", exRateCountVOs.get(0).getCount3());
			}else{
				eventResponse.setETCData("tot_cnt", "0");
				eventResponse.setETCData("good_cnt", "0");
				eventResponse.setETCData("no_good_cnt", "0");
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

        return eventResponse;
	}

	


	/**
	 * FNS_INV_0018 : retrieve <br>
	 * Retrieve B/L or Invoice info when split or Customer change by I/F No.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchSplitARInvoiceByIFNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0018Event event = (FnsInv0018Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		//BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			//begin();
			ARInvoiceSplitVO aRInvoiceSplitVO = command.searchSplitARInvoiceByIFNo(event.getIfNo(), event.getSplitCnt(), event.getOfcCd(), event.getIssToSplitFlg(), event.getInvDeltDivCd());

			//bcommand.modifyNewInterfaceNo(event.getOfcCd(), aRInvoiceSplitVO.getMaxSeq(), account.getUsr_id());
			//commit();
			
			eventResponse.setRsVo(aRInvoiceSplitVO.getARInvoiceCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceSplitVO.getListInvoiceChargeCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceSplitVO.getInvArCntrVOs());
			// eventResponse.setRsVo(aRInvoiceSplitVO);
			eventResponse.setRsVo(aRInvoiceSplitVO.getARInvoiceCustomerVO());

			eventResponse.setETCData("max_seq", aRInvoiceSplitVO.getMaxSeq());
			eventResponse.setETCData("org_if_no_list", aRInvoiceSplitVO.getOrgIfNoList());
			eventResponse.setETCData("cxl_if_no_list", aRInvoiceSplitVO.getCxlIfNoList());
			eventResponse.setETCData("max_if_no", aRInvoiceSplitVO.getMaxIfNo());
			
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
	 * FNS_INV_0018 : insert,update<br>
	 * 
	 * split B/L, invoice info 2 or more customer or change Customer  by I/F No. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse splitARInvoiceByIFNo(Event e) throws EventException {
		
		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0018Event event = (FnsInv0018Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		
		InvArMnVO[] invArMnVOs = event.getInvArMnVOs();
		InvArChgVO[] invArChgVOs = event.getInvArChgVOs();
		InvArAmtVO[] invArAmtVOs = event.getInvArAmtVOs();
		InvArCntrVO[] invArCntrVOs = event.getInvArCntrVOs();
		ARInvoiceSplitCondVO arSplitCondVO = event.getARInvoiceSplitCondVO();
		
		
		arSplitCondVO.setUsrId(account.getUsr_id());

		try{
			begin();
			String backEndJobKey = command.manageSplitARInvoiceByIFNo(arSplitCondVO, invArMnVOs, invArChgVOs, invArAmtVOs, invArCntrVOs, account.getUsr_id());
			commit();
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
		
		
		/*
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0018Event event = (FnsInv0018Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();

		InvArMnVO[] invArMnVOs = event.getInvArMnVOs();
		InvArChgVO[] invArChgVOs = event.getInvArChgVOs();
		InvArAmtVO[] invArAmtVOs = event.getInvArAmtVOs();
		InvArCntrVO[] invArCntrVOs = event.getInvArCntrVOs();
		
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();
		List<InvArIfNoVO> maxIfNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO maxArIfNoVO = new InvArIfNoVO();
		
		ARCorrectionCkReturnVO arCorrectionCkReturnVO = null;
		
		String newIfNo="";
		
		String otsSmryCd = "";
		int repCustCnt = 0;

		String[] orgIfNoList = null;
		String[] cxlIfNoList = null;
		int loopCnt = 1;
		
		try {
			begin();
			otsSmryCd = command.searchOTSSummary(event.getOfcCd());

			if(("Y").equals(event.getIssToSplitFlg())){
				orgIfNoList = event.getOrgIfNoList().split(",");
				cxlIfNoList = event.getCxlIfNoList().split(",");
				
				loopCnt = orgIfNoList.length;
			}
			
			for(int p = 0; p < loopCnt; p++){
				ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();
	
				aRCorrectionCkVO.setBkgNo(event.getBkgNo());
				aRCorrectionCkVO.setInvCustFlg("");
				aRCorrectionCkVO.setOfcCd(event.getOfcCd());
				
				if(("Y").equals(event.getIssToSplitFlg())){
					String sailDt = command.searchSailDateByIfNo(orgIfNoList[p].substring(0,11));
					
					aRCorrectionCkVO.setSailingDt(sailDt);
					aRCorrectionCkVO.setBlInvCfmDt(sailDt);
				}else{
					aRCorrectionCkVO.setSailingDt(event.getSailDt());
					aRCorrectionCkVO.setBlInvCfmDt(event.getSailDt());
				}
				
				arCorrectionCkReturnVO = command.checkARCorrection(aRCorrectionCkVO);
				
				if(("Y").equals(event.getIssToSplitFlg())){
					bcommand.modifySplitCode(orgIfNoList[p].substring(0,11), "M", "", account.getUsr_id());
				}else{
					bcommand.modifySplitCode(event.getIfNo(), "M", otsSmryCd, account.getUsr_id());
				}
	
				CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();
	
				if(("Y").equals(event.getIssToSplitFlg())){
					cancelInvoiceVO.setIfNo(orgIfNoList[p].substring(0,11));
					cancelInvoiceVO.setNewIfNo(cxlIfNoList[p]);
				}else{
					cancelInvoiceVO.setIfNo(event.getIfNo());
					cancelInvoiceVO.setNewIfNo(event.getCancelIfNo());
				}
				
				cancelInvoiceVO.setEffDt(arCorrectionCkReturnVO.getEffectiveDt());
				
				if(("Y").equals(event.getIssToSplitFlg())){
					cancelInvoiceVO.setOtsSmryCd("");
				}else{
					cancelInvoiceVO.setOtsSmryCd(otsSmryCd);
				}
				
				cancelInvoiceVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
				cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
				//cancelInvoiceVO.setInvCurrCd(event.getInvCurrCd());
				cancelInvoiceVO.setUserId(account.getUsr_id());
	
				// Cancel Data create
				newIfNo = bcommand.createARCancelSplitInvoice(cancelInvoiceVO);
				
				if(!newIfNo.equals("")){
					if(otsSmryCd.equals("INV")){
						maxArIfNoVO = new InvArIfNoVO();
						maxArIfNoVO.setIfNo(event.getIfNo());
						maxIfNos.add(maxArIfNoVO);
					}
					
					invArIfNoVO = new InvArIfNoVO();
					invArIfNoVO.setIfNo(newIfNo);
					ifNos.add(invArIfNoVO);
				}
				
				if(("Y").equals(event.getIssToSplitFlg())){			
					if(("N").equals(orgIfNoList[p].substring(11,12))){
						bcommand.modifySysClear(orgIfNoList[p].substring(0,11), account.getUsr_id());
						bcommand.modifySysClear(cxlIfNoList[p], account.getUsr_id());
					}
				} else {
					if(("BL").equals(otsSmryCd)){
						bcommand.modifySysClear(event.getIfNo(), account.getUsr_id());
						bcommand.modifySysClear(event.getCancelIfNo(), account.getUsr_id());
					}
				}
				
				SysClearVO sysClearVo = new SysClearVO();
				
				sysClearVo.setOfcCd(event.getOfcCd());
				sysClearVo.setBlNo(event.getBlSrcNo());
				sysClearVo.setUserId(account.getUsr_id());
				sysClearVo.setVvdCd("");
				sysClearVo.setCustCd("");
				
				bcommand.modifySysClearList(sysClearVo);
			}
			
			if (invArMnVOs != null) {

				for (int i = 0; i < invArMnVOs.length; i++) {

					if((("Y").equals(event.getIssToSplitFlg()) && !("Y").equals(invArMnVOs[i].getDelFlg())) || ("N").equals(event.getIssToSplitFlg())){
						
						repCustCnt = command.checkRepCustomer(invArMnVOs[i].getActCustCntCd(), invArMnVOs[i].getActCustSeq());
	
						if (repCustCnt > 0) {
							throw new EventException(new ErrorHandler("INV00036",new String[]{}).getMessage());
						}
						
						ARInvoiceSplitVO invSplitVo = new ARInvoiceSplitVO();
						InvArMnVO invArMnVO = new InvArMnVO();
	
						invArMnVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
						invArMnVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
						invArMnVO.setBfrInvCurrCd(invArMnVOs[i].getBfrInvCurrCd());
	
						invArMnVO.setArIfNo(invArMnVOs[i].getArIfNo());
						invArMnVO.setBkgTeuQty(invArMnVOs[i].getBkgTeuQty());
						invArMnVO.setBkgFeuQty(invArMnVOs[i].getBkgFeuQty());
						invArMnVO.setInvRefNo(invArMnVOs[i].getInvRefNo());
						invArMnVO.setCoStfCtnt(invArMnVOs[i].getCoStfCtnt());
						invArMnVO.setInvRmk(invArMnVOs[i].getInvRmk());
						invArMnVO.setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
						invArMnVO.setRevTpCd(arCorrectionCkReturnVO.getRevTpCd());
						invArMnVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
						invSplitVo.setOtsSmryCd(otsSmryCd);
						invSplitVo.setUserId(account.getUsr_id());
	
						List<InvArChgVO> invArChgVs = new ArrayList<InvArChgVO>();
						if (invArChgVOs != null) {
							for (int j = 0; j < invArChgVOs.length; j++) {
								if (invArChgVOs[j].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
									invArChgVs.add(invArChgVOs[j]);
								}
							}
						}
	
						List<InvArAmtVO> invArAmtVs = new ArrayList<InvArAmtVO>();
						if (invArAmtVOs != null) {
							for (int k = 0; k < invArAmtVOs.length; k++) {
								if (invArAmtVOs[k].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
									invArAmtVs.add(invArAmtVOs[k]);
								}
							}
						}
	
						List<InvArCntrVO> invArCntrVs = new ArrayList<InvArCntrVO>();
						if (invArCntrVOs != null) {
							for (int l = 0; l < invArCntrVOs.length; l++) {
								if (invArCntrVOs[l].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
									invArCntrVs.add(invArCntrVOs[l]);
								}
							}
						}
						invSplitVo.setIfNo(event.getIfNo());
						invSplitVo.setInvArMnVO(invArMnVO);
						invSplitVo.setInvArChgVOs(invArChgVs);
						invSplitVo.setInvArAmtVOs(invArAmtVs);
						invSplitVo.setInvArCntrVOs(invArCntrVs);
						//invSplitVo.setInvCurrCd(event.getInvCurrCd());
	
						// New Data create
						newIfNo = bcommand.createSplitInvoice(invSplitVo);
						
						if(!newIfNo.equals("")){
							invArIfNoVO = new InvArIfNoVO();
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
						}
						
						SysClearVO splitSysClearVo = new SysClearVO();
						
						splitSysClearVo.setOfcCd(event.getOfcCd());
						splitSysClearVo.setBlNo(event.getBlSrcNo());
						splitSysClearVo.setUserId(account.getUsr_id());
						splitSysClearVo.setVvdCd("");
						splitSysClearVo.setCustCd("");
						
						bcommand.modifySysClearList(splitSysClearVo);
					}
				}
			}
			
			SysClearVO finalSysClearVo = new SysClearVO();
			
			finalSysClearVo.setOfcCd(event.getOfcCd());
			finalSysClearVo.setBlNo(event.getBlSrcNo());
			finalSysClearVo.setUserId(account.getUsr_id());
			finalSysClearVo.setVvdCd("");
			finalSysClearVo.setCustCd("");
			
			bcommand.modifySysClearList(finalSysClearVo);
			
			
			SysClearVO ifNoSysClearVo = new SysClearVO();
			
			ifNoSysClearVo.setOfcCd(event.getOfcCd());
			ifNoSysClearVo.setBlNo(event.getBlSrcNo());
			ifNoSysClearVo.setUserId(account.getUsr_id());
			ifNoSysClearVo.setVvdCd("");
			ifNoSysClearVo.setCustCd("");
			
			command.modifySysClearByIFNo(ifNoSysClearVo);
			
		
			// 2014.06.11 AR OTS creation  
			// 2014.08.14 block maxifno
			//if(maxIfNos!= null && maxIfNos.size()>0){
			//    command2.createOutstandingInfo(maxIfNos);
			//}
			   
			if(ifNos!= null && ifNos.size()>0){
			    command2.createOutstandingInfo(ifNos);
			}
			   
			commit();
			
			//화면에서 성공메세지 처리 2015.04.27
			//eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			//throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse; */

	}

	/**
	 * FNS_INV_0033 : retrieve<br>
	 * Retrieve B/L or Invoice info when split or Customer change by Invoice No.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSplitARInvoiceByInvoiceNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0033Event event = (FnsInv0033Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		//BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			//begin();
			ARInvoiceSplitVO aRInvoiceSplitVO = command.searchSplitARInvoiceByInvoiceNo(event.getInvNo(), event.getSplitCnt(), event.getOfcCd());

			//bcommand.modifyNewInterfaceNo(event.getOfcCd(), aRInvoiceSplitVO.getMaxSeq(), account.getUsr_id());
			//commit();
			eventResponse.setRsVo(aRInvoiceSplitVO.getARInvoiceCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceSplitVO.getListInvoiceChargeCorrectionVO());
			eventResponse.setRsVoList(aRInvoiceSplitVO.getInvArCntrVOs());
			eventResponse.setRsVoList(aRInvoiceSplitVO.getInvArIfNoVOs());
			eventResponse.setRsVo(aRInvoiceSplitVO.getARInvoiceCustomerVO());

			eventResponse.setETCData("max_seq", aRInvoiceSplitVO.getMaxSeq());

		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00080", new String[] {}).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0033 : insert,update <br>
	 * split B/L, invoice info 2 or more customer or change Customer  by invoice No. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse splitARInvoiceByInvoiceNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0033Event event = (FnsInv0033Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();

		InvArMnVO[] invArMnVOs = event.getInvArMnVOs();
		InvArChgVO[] invArChgVOs = event.getInvArChgVOs();
		InvArAmtVO[] invArAmtVOs = event.getInvArAmtVOs();
		InvArCntrVO[] invArCntrVOs = event.getInvArCntrVOs();
		InvArIfNoVO[] invArIfNoVOs = event.getInvArIfNoVOs();
		
		List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
		InvArIfNoVO invArIfNoVO = new InvArIfNoVO();	
		String newIfNo="";
		String maxIfNo="";
		String otsSmryCd = "";
		int repCustCnt = 0;

		try {
			begin();

			// otsSmryCd = command.searchOTSSummary(event.getOfcCd());

			
			maxIfNo = invArIfNoVOs[0].getMaxIfNo().equals("")?invArIfNoVOs[0].getMIfNo():invArIfNoVOs[0].getMaxIfNo();
			
			ARCorrectionCkVO aRCorrectionCkVO = new ARCorrectionCkVO();

			aRCorrectionCkVO.setBkgNo(event.getBkgNo());
			aRCorrectionCkVO.setInvCustFlg("");
			aRCorrectionCkVO.setOfcCd(event.getOfcCd());
			aRCorrectionCkVO.setSailingDt(event.getSailDt());
			aRCorrectionCkVO.setBlInvCfmDt(event.getSailDt());

			ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.checkARCorrection(aRCorrectionCkVO);
			
			//ARCorrectionCkReturnVO arCorrectionCkReturnVO = command.searchRevTypeSrc(event.getBkgNo(), "");	
			
			CancelInvoiceVO cancelInvoiceVO = new CancelInvoiceVO();

			cancelInvoiceVO.setIfNo(maxIfNo);
			cancelInvoiceVO.setInvNo(event.getInvNo());
			cancelInvoiceVO.setNewIfNo(event.getCancelIfNo());
			cancelInvoiceVO.setArOfcCd(event.getOfcCd());
			cancelInvoiceVO.setOtsSmryCd("");
			cancelInvoiceVO.setRevTpCd(!invArIfNoVOs[0].getMaxIfNo().equals("")?arCorrectionCkReturnVO.getRevTpCd():"M");
			cancelInvoiceVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
			cancelInvoiceVO.setUserId(account.getUsr_id());
			cancelInvoiceVO.setUiType("S");
			// Cancel Data create
			newIfNo = bcommand.createCancelIssueARInvoice(cancelInvoiceVO);
			
			if(!newIfNo.equals("")){
				invArIfNoVO = new InvArIfNoVO();
				invArIfNoVO.setIfNo(newIfNo);
				ifNos.add(invArIfNoVO);
			}
			
			if (invArIfNoVOs != null) {
				for (int i = 0; i < invArIfNoVOs.length; i++) {

					bcommand.modifySplitCode(invArIfNoVOs[i].getIfNo(), "M", otsSmryCd, account.getUsr_id());					
				}
			}

			if (invArMnVOs != null) {

				for (int i = 0; i < invArMnVOs.length; i++) {

					repCustCnt = command.checkRepCustomer(invArMnVOs[i].getActCustCntCd(), invArMnVOs[i].getActCustSeq());

					if (repCustCnt > 0) {
						throw new EventException(new ErrorHandler("INV00036",new String[]{}).getMessage());
					}
					
					/*
					DueDateInputVO dueDateInputVO = new DueDateInputVO();

					dueDateInputVO.setOfcCd(event.getOfcCd());
					dueDateInputVO.setBnd(invArMnVOs[i].getIoBndCd());
					dueDateInputVO.setSaDt(invArMnVOs[i].getSailArrDt());
					dueDateInputVO.setCustCntCd(invArMnVOs[i].getActCustCntCd());
					dueDateInputVO.setCustSeq(invArMnVOs[i].getActCustSeq());

					List<DueDateVO> list = command.searchDueDate(dueDateInputVO);
					*/
					ARInvoiceSplitVO invSplitVo = new ARInvoiceSplitVO();
					InvArMnVO invArMnVO = new InvArMnVO();

					invArMnVO.setActCustCntCd(invArMnVOs[i].getActCustCntCd());
					invArMnVO.setActCustSeq(invArMnVOs[i].getActCustSeq());
					invArMnVO.setBfrInvCurrCd(invArMnVOs[i].getBfrInvCurrCd());
					/*
					if (list.size() > 0) {
						invArMnVO.setDueDt(list.get(0).getDueDate());
						invArMnVO.setCustCrFlg(list.get(0).getCrFlg());
						invArMnVO.setCrTermDys(list.get(0).getCrTermDys());
					}
					*/
					invArMnVO.setArIfNo(invArMnVOs[i].getArIfNo());
					invArMnVO.setBkgTeuQty(invArMnVOs[i].getBkgTeuQty());
					invArMnVO.setBkgFeuQty(invArMnVOs[i].getBkgFeuQty());
					invArMnVO.setInvRefNo(invArMnVOs[i].getInvRefNo());
					invArMnVO.setCoStfCtnt(invArMnVOs[i].getCoStfCtnt());
					invArMnVO.setInvRmk(invArMnVOs[i].getInvRmk());
					invArMnVO.setGlEffDt(arCorrectionCkReturnVO.getEffectiveDt());
					invArMnVO.setRevTpCd(!invArIfNoVOs[0].getMaxIfNo().equals("")?arCorrectionCkReturnVO.getRevTpCd():"M");
					invArMnVO.setRevSrcCd(arCorrectionCkReturnVO.getRevSrcCd());
					invSplitVo.setOtsSmryCd(otsSmryCd);
					invSplitVo.setUserId(account.getUsr_id());

					List<InvArChgVO> invArChgVs = new ArrayList<InvArChgVO>();
					if (invArChgVOs != null) {
						for (int j = 0; j < invArChgVOs.length; j++) {
							if (invArChgVOs[j].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
								invArChgVs.add(invArChgVOs[j]);
							}
						}
					}

					List<InvArAmtVO> invArAmtVs = new ArrayList<InvArAmtVO>();
					if (invArAmtVOs != null) {
						for (int k = 0; k < invArAmtVOs.length; k++) {
							if (invArAmtVOs[k].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
								invArAmtVs.add(invArAmtVOs[k]);
							}
						}
					}

					List<InvArCntrVO> invArCntrVs = new ArrayList<InvArCntrVO>();
					if (invArCntrVOs != null) {
						for (int l = 0; l < invArCntrVOs.length; l++) {
							if (invArCntrVOs[l].getArIfNo().equals(invArMnVOs[i].getArIfNo())) {
								invArCntrVs.add(invArCntrVOs[l]);
							}
						}
					}
					invSplitVo.setIfNo(event.getIfNo());
					invSplitVo.setInvArMnVO(invArMnVO);
					invSplitVo.setInvArChgVOs(invArChgVs);
					invSplitVo.setInvArAmtVOs(invArAmtVs);
					invSplitVo.setInvArCntrVOs(invArCntrVs);
					//invSplitVo.setInvCurrCd(event.getInvCurrCd());  //2015.01.09

					// New Data 생성
					newIfNo = bcommand.createSplitInvoice(invSplitVo);
					
					if(!newIfNo.equals("")){
						invArIfNoVO = new InvArIfNoVO();
						invArIfNoVO.setIfNo(newIfNo);
						ifNos.add(invArIfNoVO);
					}
				}
			}
			
			/*
			begin();
			if(ifNos!= null && ifNos.size()>0){
				bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
			}
			commit();
			*/
			
			// 2014.06.11 AR OTS creation
			if(ifNos!= null && ifNos.size()>0){
			    command2.createOutstandingInfo(ifNos);
			}
			   
			commit();
			 
			//화면에서 성공메세지 처리 2015.04.27 
			//eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage()); 
			
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
	 * FNS_INV_0028 : retrieve<br>
	 * Invoice Data Manual Interface<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManualInterface(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0028Event event = (FnsInv0028Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		try {
			begin();

			List<BkgNoCaNoVO> bkgNoCaNoVOs = command.searchManualInterface(event.getManualInputVO());

			if (bkgNoCaNoVOs.size() > 0) {
				eventResponse.setRsVoList(bkgNoCaNoVOs);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			
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
	 * FNS_INV_0028 : insert,update<br>
	 * Invoice Data Manual Interface<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createManualInterface(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0028Event event = (FnsInv0028Event) e;
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		
		try {
			
			//String backEndJobKey = "";
	        
			if(event.getManDivInd().equals("M")){
				if(!event.getBkgNo().equals("")){
					begin();
					
					ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
					bkgIfVO.setBkgNo(event.getBkgNo());
					bkgIfVO.setBkgSeq("");
					bkgIfVO.setManDivInd("M");
					bkgIfVO.setUserId(account.getUsr_id());					
					
					//List<InvArIfNoVO> ifNos = bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					
					commit();
					/*
					begin();
					if(ifNos!= null && ifNos.size()>0){
						log.error("ifNos.size() = "+ifNos.size());
						
						bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
					}
					commit();
					*/
					   
				}else{
					begin();
					if(!event.getVvd().equals("")){
						List<ARBkgInterfaceCreationVO> aRBkgIfCreationVOs = command.searchBkgNoByVvd(event.getVvd(),event.getPol(),event.getPod());
						if(aRBkgIfCreationVOs != null) {
							for(int i=0; i<aRBkgIfCreationVOs.size(); i++) {
								aRBkgIfCreationVOs.get(i).setManDivInd("M");
								aRBkgIfCreationVOs.get(i).setUserId(account.getUsr_id());
							}
				
							if (aRBkgIfCreationVOs.size() > 0) {
								bcommand.interfaceBKGARInvoiceToINV(aRBkgIfCreationVOs);
							}
						}
						
					}
					commit();
				}
				
			}else if(event.getManDivInd().equals("I")){			
				begin();
				
				BkgNoCaNoVO[] bkgNoCaNoVOs = event.getBkgNoCaNoVOs();
				//List<ARBkgInterfaceCreationVO> bkgIfVOs =  new ArrayList<ARBkgInterfaceCreationVO>();;
				
				//List<InvArIfNoVO> allIfNos = new ArrayList<InvArIfNoVO>();
				
				for (int i = 0; i < bkgNoCaNoVOs.length; i++) {
					ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
					bkgIfVO.setBkgNo(bkgNoCaNoVOs[i].getBkgNo());
					bkgIfVO.setBkgSeq("");
					//bkgIfVO.setBkgSeq(bkgNoCaNoVOs[i].getBkgSeq());
					//bkgIfVO.setManDivInd("I");
					bkgIfVO.setManDivInd("M");
					bkgIfVO.setUserId(account.getUsr_id());
					//List<InvArIfNoVO> ifNos = bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					//bkgIfVOs.add(bkgIfVO);
					
					/*
					if(ifNos!=null && ifNos.size()>0){
						log.error("ifNos.size() = "+ifNos.size());
						allIfNos.addAll(ifNos);
					}
					*/
					
				}
				
				commit();
				
				/*
				begin();
				if(allIfNos!= null && allIfNos.size()>0){
					log.error("allIfNos.size() = "+allIfNos.size());
					bcommand.interfaceARInvoiceToERPAR(allIfNos, "C");
				}
				
				commit();
				*/
				
				//bcommand.interfaceBKGARInvoiceToINV(bkgIfVOs);
			}else{
				begin();
				String newIfNo = bcommand.createMaxIFCancel(event.getArIfNo(), "", account.getUsr_id(), "");
				
				List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
				if(!newIfNo.equals("")){
					InvArIfNoVO invArIfNoVO = new InvArIfNoVO();				
					invArIfNoVO.setIfNo(newIfNo);
					ifNos.add(invArIfNoVO);
				}
				//bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
				commit();
				
			}
			
			//eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}
	
	
	
	/**
	 * FNS_INV_0034_01 : Paper Issue, Go to Send <br>
	 * Issue Invoice Europe, part of southwest aisa, north China.(BackEndJob) <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueGeneralInvoiceBackEndJobKey(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
//		BookingARCreationBC command2 = new BookingARCreationBCImpl();
//		List<IssueTargetVO> list2 = new ArrayList<IssueTargetVO>();

		try {
//			begin();
//
//			List<IssueTargetVO> list = command.searchTargetBLForIssue(event.getGenInvVo());
//
//			if (list.size() < 1) {
//				eventResponse.setUserMessage(new ErrorHandler("INV00095", new String[] {}).getUserMessage());
//			}
//
//			String invNos = "";
//			InvIssueVO invIssueVO = null;
//
//			for (int i = 0; i < list.size(); i++) {
//				list2 = command.issueGeneralInvoice(list.get(i), event.getGenInvVo(), account.getUsr_id());
//				invNos = invNos + list2.get(0).getInvNo() + "|";
//
//				// 반환된 업데이트 대상만큼 Looping
//				for (int j = 0; j < list2.size(); j++) {
//
//					invIssueVO = new InvIssueVO();
//					invIssueVO.setInvno(list2.get(j).getInvNo());
//					invIssueVO.setIssflg("Y");
//					invIssueVO.setIfno(list2.get(j).getArIfNo());
//					invIssueVO.setDuedt(list2.get(j).getDueDt());
//					invIssueVO.setBkgno(list2.get(j).getBkgNo());
//					invIssueVO.setInvrmk(list2.get(j).getInvRmk());
//
//					command2.modifyInvoiceIssue(invIssueVO, event.getGenInvVo().getOtsSmryCd(), account.getUsr_id());
//				}
//			}
//			commit();
//
//			eventResponse.setETCData("inv_nos", invNos);
			
			begin();
		        String backEndJobKey = command.issueGeneralInvoiceBackEndJobKey(event.getGenInvVo(),event.getCustomerListForIssueVOs(),  account.getUsr_id());
		        eventResponse.setETCData("BackEndJobKey", backEndJobKey);
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
	 * FNS_INV_0034_01<br>
	 * Retrieve BackEndJob status for issue Invoice.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse issueGeneralInvoiceBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event)e;

    	try {    		
	    	if(event.getBackEndJobKey() != null && !event.getBackEndJobKey().equals("")) {
    			// Backend job 완료여부를 검사한다.
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(event.getBackEndJobKey());

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	
		    	
				
		    	String jb_sts_flg = "0"; // Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    	String jb_usr_err_msg = "";
		    	
				if(rowSet.next()) {
					//Thread.sleep(1000);
					jb_sts_flg = rowSet.getString("jb_sts_flg");
					jb_usr_err_msg = rowSet.getString("jb_usr_err_msg");
				}
				
				eventResponse.setETCData("jb_sts_flg", jb_sts_flg);
		    	eventResponse.setETCData("jb_usr_err_msg", jb_usr_err_msg);
		    	
		    	
		    	/*List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	
		    	ComBakEndJbVO jobVo = null;
		    	if (dbRowSetlist.size() == 0) {
		    		// Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
		    	eventResponse.setETCData("jb_usr_err_msg", jobVo.getJbMsg());*/
		    	
		    	
		    	
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}

    	return eventResponse;
    }
	
	/**
	 * FNS_INV_0034_01<br>
     *  Retrieve BackEndJob loadFile method result for issue Invoice.<br><br>
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueGeneralInvoiceBackEndJobFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event)e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();

		try {
//			List<UnmatchRevenueVesselVO> list = new ArrayList<UnmatchRevenueVesselVO>();
//			list = command.getBackEndJobResutUnmatchRevenueVVDListByDate(event.getBackEndJobKey());
//			eventResponse.setRsVoList(list);
			
			String invNos = "";
			invNos = command.getBackEndJobResutIssueGeneralInvoice(event.getBackEndJobKey());
			
			eventResponse.setETCData("inv_nos", invNos);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

        return eventResponse;
	}
	
	

	/**
	 * FNS_INV_0034_01 : Paper Issue, Go to Send <br>
	 * Retrieve not issued Invoice Data. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErrorBLNumberList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
        StringBuffer blNos = new StringBuffer("");
        
		try {
			begin();

			List<String> list = command.searchErrorBLNumberList(event.getGenInvVo());
			for (int i = 0; i < list.size(); i++) {
				blNos.append(list.get(i)).append((i == list.size() -1 ? "" : ", "));
			}

			commit();

			eventResponse.setETCData("bl_nos", blNos.toString());
			
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
	 * Handling Retrieve AR Office <br>
	 * Retrieve A/R Office  by User ID.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROffice(Event e) throws EventException {
		FnsInv0009Event event = (FnsInv0009Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			AROfficeListVO arOfficeListVO = command.searchAROffice(event.getARInvoiceInputByBLNoVO().getLoginOfcCd());

			String arOfcInfo = "";
			if (arOfficeListVO != null) {
				arOfcInfo = arOfficeListVO.getArOfcCd() + "^" + arOfficeListVO.getInvDupFlg();
				eventResponse.setETCData("ar_ofc_cd", arOfcInfo);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00075").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}
	
	
	/**
	 * FNS_INV_0110<br>
	 * Retrieve not Issue (DXBBB)INV B/L.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDXBInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0110Event event = (FnsInv0110Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();

		try {
			List<DXBInvoiceListVO> list = command.searchDXBInvoiceList(event.getGeneralInvoiceVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * FNS_INV_0115 : Open<br>
	 * Retrieve A/R Office code by User ID.<br>
	 * @author KIM HYUN HWA
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARRhqList(Event e) throws EventException {
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<String> list = command.searchARRhqList(account.getOfc_cd());
			StringBuffer arHdQtrOfcInfo = new StringBuffer("");
			
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					arHdQtrOfcInfo.append("|").append(list.get(i));
				}

				eventResponse.setETCData("ar_hd_qtr_ofc_cd", arHdQtrOfcInfo.toString());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00075").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0115 : Open<br>
	 *Retrieve A/R OFFICE CODE by A/R HEAD QUARTER OFFICE.<br>
	 * @author KIM HYUN HWA
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROfficeListByRhq(Event e) throws EventException {
		FnsInv0115Event event = (FnsInv0115Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String rhq = event.getErpErrorInputVO().getArHdQtrOfcCd();
			List<String> list = command.searchAROfficeListByRhq(rhq, account.getOfc_cd());
			StringBuffer arOfcInfo = new StringBuffer("");

			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					arOfcInfo.append("|").append(list.get(i));
				}
				eventResponse.setETCData("ar_ofc_cd", arOfcInfo.toString());
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00075").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0115 : Retrieve<br>
	 * Retrieve ERP I/F ERROR history.<br>
	 * 
	 * @author KIM HYUN HWA
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErpErrorList(Event e) throws EventException {
		FnsInv0115Event event = (FnsInv0115Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<ErpErrorVO> list = command.searchErpErrorList(event.getErpErrorInputVO());
			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * FNS_INV_0116 : Retrieve<br>
	 * Retrieve Transaction AR Invoice to ERP I/F data.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransactionDataComparisonReportList(Event e) throws EventException {
		FnsInv0116Event event = (FnsInv0116Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<TransDataComparisonReportVO> list = command.searchTransactionDataComparisonReportList(event.getTransDataComparisonReportInputVO());
			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * FNS_INV_0050 : Open<br>
	 * CPRT에서 user가 사용 가능한 Template을 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTemplateList(Event e) throws EventException {
		// FnsInv0050Event event = (FnsInv0050Event)e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String tmplt = "";
		StringBuffer tmpltBuff = new StringBuffer();
		try {
			List<TemplateVO> list = command.searchTemplateList(account.getUsr_id(), account.getOfc_cd());

			for (int i = 0; i < list.size(); i++) {
				tmpltBuff.append(list.get(i).getRptTmpltNm() + "|");
				//tmplt = tmplt + list.get(i).getRptTmpltNm() + "|";				
			}
			tmplt = tmpltBuff.toString();
			eventResponse.setETCData("tmplt", tmplt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0050 : TemplateName CHANGE<br>
	 * CPRT에서 Report 생성시 선택한 Template의 item를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTemplateItemList(Event e) throws EventException {
		FnsInv0050Event event = (FnsInv0050Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			event.getCPRTInputVO().setArOfcCd(event.getOfcCd());
			List<TemplateItemVO> list = command.searchTemplateItemList(event.getRptTmpltNm(), event.getCPRTInputVO());
			if (list.size() > 0) {
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
	 * FNS_INV_0050 : bkg no 조회<br>
	 * CPR 에서 bl preview 조회시 bkg_no가 없을 경우, 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlNo(Event e) throws EventException {
		FnsInv0050Event event = (FnsInv0050Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String bkgNo = command.searchBlNo(event.getBlNo());
			eventResponse.setETCData("bkgNo", bkgNo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0050 : Retrieve<br>
	 * Customer Preferable Report 대상 정보를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCPRTInvoice(Event e) throws EventException {
		FnsInv0050Event event = (FnsInv0050Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			//event.getCPRTInputVO().setArOfcCd(account.getOfc_cd());
			event.getCPRTInputVO().setArOfcCd(event.getOfcCd());
			event.getCPRTInputVO().setRptTmpltNm(event.getRptTmpltNm());
			List<CPRTInvoiceVO> list = command.searchCPRTInvoice(event.getCPRTInputVO(), event.getRptItmId());
			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			}
//			TemplateVO templateVO = command.searchCPRTInvoice(event.getCPRTInputVO(), event.getRptItmId());
//			log.debug("SC=================================");
//			log.debug(templateVO.getListTemplateItemVO());
//			log.debug("SC==================end============");
////		if (templateVO.size() > 0) {
//				eventResponse.setRsVoList(templateVO.getListTemplateItemVO());
//				eventResponse.setRsVoList(templateVO.getListCPRTInvoiceVO());
////			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0050 : Save<br>
	 * Customer Preferable Report . 조회조건에 해당 하는 데이터를 Save시 Report ID를 생성한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse issueCPRTInvoice(Event e) throws EventException {
		FnsInv0050Event event = (FnsInv0050Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String reportId = "";
		try {
			event.getCPRTInputVO().setCreUsrId(account.getUsr_id());
			event.getCPRTInputVO().setArOfcCd(account.getOfc_cd());
			reportId = command.issueCPRTInvoice(event.getRptTmpltNm(), event.getCPRTInputVO());

			eventResponse.setETCData("reportId", reportId);
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
	 * FNS_INV_0051 : Open<br>
	 * CPR(Customer Preferable Report)에서 사용. 선택가능한 모든 항목 List 와 를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportItemList(Event e) throws EventException {
		//FnsInv0051Event event = (FnsInv0051Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CprtItemVO cprtItemVO = command.searchReportItemList(account.getUsr_id(), account.getOfc_cd());
			eventResponse.setRsVoList(cprtItemVO.getCprtItemListVOs());
			eventResponse.setRsVoList(cprtItemVO.getRptTmpltNmVOs());


		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0051 : TempleteName CHANGE<br>
	 * CPR 에서 사용. Template으로 등록된 선택 item정보를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSelectedItemList(Event e) throws EventException {
		FnsInv0051Event event = (FnsInv0051Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			TemplateVO templateVO  = command.searchSelectedItemList(event.getRptTmpltNm(), event.getOfcCd());
			
//			List<TemplateItemVO> templateItemVOs = command.searchSelectedItemList(event.getRptTmpltNm(), account.getOfc_cd());

			//eventResponse.setRsVo(templateVO);

			eventResponse.setRsVoList(templateVO.getListTemplateItemVO());
			eventResponse.setRsVoList(templateVO.getListInvCprtTmpltChgVO());

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0051 : TempleteName CHANGE<br>
	 * CPR 에서 사용. 입력한 Template명이 테이블에 존재하는 Template명인지를 CHECK한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTemplateName(Event e) throws EventException {
		FnsInv0051Event event = (FnsInv0051Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String tmpleName = command.searchTemplateName(event.getRptTmpltNm());

			eventResponse.setETCData("tmpleName", tmpleName);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0051 : Save<br>
	 * CPR(Customer preFerable Report)에서 사용할 item을 user 가 선택한하여 Template으로 관리 한다.(등록, 수정, 삭제)<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTemplateItem(Event e) throws EventException {
		FnsInv0051Event event = (FnsInv0051Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			command.manageTemplateItem(event.getTemplateVOs(), event.getInvCprtTmpltChgVOs(), account.getUsr_id(), account.getOfc_cd());
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
	 * FNS_INV_0051 : Save<br>
	 * CPR(Customer preFerable Report)에서 사용할 item을 user 가 선택한하여 Template으로 관리 한다.(등록, 수정, 삭제)<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeTemplate(Event e) throws EventException {
		FnsInv0051Event event = (FnsInv0051Event) e;
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			command.removeTemplate(event.getRptTmpltNm(), event.getOfcCd());
			//command.removeTemplate(event.getRptTmpltNm(), account.getOfc_cd());
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
	 * FNS_INV_0103 : Retrieve<br>
	 * Customer Preferable Report Report ID 로 History로 저장된 내용을 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCPRTHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		FnsInv0103Event event = (FnsInv0103Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			event.getCPRTListVO().setCustRptId(event.getCustRptId());
			List<CPRTMainVO> list = command.searchCPRTHistoryList(event.getCPRTListVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0104 : Retrieve<br>
	 * Customer Preferable Report Report ID 를 생성 기간 및 생성 user, Office등의 조건으로 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCPRTIDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ARInvoiceInquiryBC command = new ARInvoiceInquiryBCImpl();
		FnsInv0104Event event = (FnsInv0104Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CPRTListVO> list = command.searchCPRTIDList(event.getCPRIDListInputVO());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Search EDI 310 Invoice<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDI310Invoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0112Event event = (FnsInv0112Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			List<EDI310InvoiceVO> list = command.searchEDI310Invoice(event.getEDI310InputVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Search Invoice EDI Level<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceEDILevel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0112Event event = (FnsInv0112Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			String invEDILvl = command.searchInvoiceEDILevel(event.getCntcTpCd(), event.getScRfaNo());
			eventResponse.setETCData("inv_edi_lvl", invEDILvl);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Send EDI 310 Invoice<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEDI310Invoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0112Event event = (FnsInv0112Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			begin();
			List<String> list = command.sendEDI310Invoice(Arrays.asList(event.getEDI310InvoiceVOs()), account.getUsr_id());
			StringBuffer excludeBLNO = new StringBuffer("");
			if(list != null && list.size() > 0) {
				for(int i=0; i<list.size(); i++) {
					excludeBLNO.append(list.get(i).toString());
					if(i < list.size()-1 ){
						excludeBLNO.append(",");
					}
				}
			}
			eventResponse.setETCData("excludeBLNO", excludeBLNO.toString());
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
	 * Retrieve APC Invoice<br>
	 * 
	 * @author Myoungsin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAPCInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv0113Event event = (FnsInv0113Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {	
			List<APCInvoiceVO> list = command.searchAPCInvoice(event.getaPCInvoiceVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Send APC Invoice<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendAPCInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0113Event event = (FnsInv0113Event) e;
		AccountReceivableEDISendBC command = new AccountReceivableEDISendBCImpl();

		try {
			begin();
			command.sendAPCInvoice(Arrays.asList(event.getaPCInvoiceVOs()), account.getUsr_id()); 
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
	 * FNS_INV_0034_02, FNS_INV_0037 : Send <br>
	 *  Fax / E-mail send  or Print when after Invoice Info create or correct <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createFileUpload(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("FnsInv003402Event")) {
				//FnsInv003402Event event = (FnsInv003402Event) e;
				List<String> key = (List<String>)e.getAttribute("FILE_SAV_ID");   
				eventResponse.setETCData("fileKey", key.get(0));
			}  
				
		// PDTO(Data Transfer Object including Parameters)
			return eventResponse;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_9999 : insert,update<br>
	 * Manual Interface<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBKGManualInterface(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv9999Event event = (FnsInv9999Event) e;
		BookingARCreationBC bcommand = new BookingARCreationBCImpl();
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		AccountReceivableOutstandingBC command2 = new AccountReceivableOutstandingBCImpl();
		
		try {
			
			//String backEndJobKey = "";
	        
			if(event.getManDivInd().equals("M")){
				if(!event.getBkgNo().equals("")){
					begin();
					
					ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
					bkgIfVO.setBkgNo(event.getBkgNo());
					bkgIfVO.setBkgSeq("");
					bkgIfVO.setManDivInd("M");
					bkgIfVO.setUserId(account.getUsr_id());					
					
					//List<InvArIfNoVO> ifNos = bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					
					commit();
					/*
					begin();
					if(ifNos!= null && ifNos.size()>0){
						log.error("ifNos.size() = "+ifNos.size());
						
						bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
					}
					commit();
					*/
					   
				}else{
					begin();
					if(!event.getVvd().equals("")){
						List<ARBkgInterfaceCreationVO> aRBkgIfCreationVOs = command.searchBkgNoByVvd(event.getVvd(),event.getPol(),event.getPod());
						if(aRBkgIfCreationVOs != null) {
							for(int i=0; i<aRBkgIfCreationVOs.size(); i++) {
								aRBkgIfCreationVOs.get(i).setManDivInd("M");
								aRBkgIfCreationVOs.get(i).setUserId(account.getUsr_id());
							}
				
							if (aRBkgIfCreationVOs.size() > 0) {
								bcommand.interfaceBKGARInvoiceToINV(aRBkgIfCreationVOs);
							}
						}
						
					}
					commit();
				}
				
			}else if(event.getManDivInd().equals("I")){			
				begin();
				
				BkgNoCaNoVO[] bkgNoCaNoVOs = event.getBkgNoCaNoVOs();
				//List<ARBkgInterfaceCreationVO> bkgIfVOs =  new ArrayList<ARBkgInterfaceCreationVO>();;
				
				//List<InvArIfNoVO> allIfNos = new ArrayList<InvArIfNoVO>();
				
				for (int i = 0; i < bkgNoCaNoVOs.length; i++) {
					ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();
					bkgIfVO.setBkgNo(bkgNoCaNoVOs[i].getBkgNo());
					bkgIfVO.setBkgSeq("");
					//bkgIfVO.setBkgSeq(bkgNoCaNoVOs[i].getBkgSeq());
					//bkgIfVO.setManDivInd("I");
					bkgIfVO.setManDivInd("M");
					bkgIfVO.setUserId(account.getUsr_id());
					//List<InvArIfNoVO> ifNos = bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					bcommand.executeInterfaceBKGARInvoiceToINV(bkgIfVO);
					//bkgIfVOs.add(bkgIfVO);
					
					/*
					if(ifNos!=null && ifNos.size()>0){
						log.error("ifNos.size() = "+ifNos.size());
						allIfNos.addAll(ifNos);
					}
					*/
					
				}
				
				commit();
				
				/*
				begin();
				if(allIfNos!= null && allIfNos.size()>0){
					log.error("allIfNos.size() = "+allIfNos.size());
					bcommand.interfaceARInvoiceToERPAR(allIfNos, "C");
				}
				
				commit();
				*/
				
				//bcommand.interfaceBKGARInvoiceToINV(bkgIfVOs);
			}else{
				begin();
				
				String[] ifNoList = event.getArIfNo().split(",");
				
				if(ifNoList.length > 0){
					for(int i = 0; i < ifNoList.length; i++){
						String newIfNo = bcommand.createMaxIFCancelForInv(ifNoList[i], "", account.getUsr_id(), "");
						
						List<InvArIfNoVO> ifNos = new ArrayList<InvArIfNoVO>();
						if(!newIfNo.equals("")){
							InvArIfNoVO invArIfNoVO = new InvArIfNoVO();				
							invArIfNoVO.setIfNo(newIfNo);
							ifNos.add(invArIfNoVO);
						}
						//bcommand.interfaceARInvoiceToERPAR(ifNos, "C");
						
						if(ifNos!= null && ifNos.size()>0){
							command2.createOutstandingInfo(ifNos);
						}
					}
				}		
				
				commit();
				
			}
			
			//eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * FNS_INV_9999 : retrieve<br>
	 * Manual Interface<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKGManualInterface(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv9999Event event = (FnsInv9999Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		try {
			begin();

			List<BkgNoCaNoVO> bkgNoCaNoVOs = command.searchManualInterface(event.getManualInputVO());

			if (bkgNoCaNoVOs.size() > 0) {
				eventResponse.setRsVoList(bkgNoCaNoVOs);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			
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
	 * Other Manual Interface<br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOTHManualInterface(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv9999Event event = (FnsInv9999Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		GeneralARInvoiceCreationBC command2 = new GeneralARInvoiceCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			begin();
			List<ARInterfaceCreationVO> genIfVos = command.searchGeneralARInvoiceInterface(event.getSrcIfDt(), event.getSrcIfSeq());
			command2.interfaceGeneralARInvoiceToINV(genIfVos);
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
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
	 * Search split customer info<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSplitCustInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0018Event event = (FnsInv0018Event) e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		String custCd = "";
		
		try {
			List<String> custCdList = command.searchSplitCustInfo(event.getIfNo());
			
			for(int i = 0; i < custCdList.size(); i++){
				custCd = custCd.concat(custCdList.get(i));
				if(i < custCdList.size() - 1) custCd = custCd + "|";
			}
			
			eventResponse.setETCData("split_cust_cd", custCd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Search BKG Interface Count<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKGInterfaceCount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv003401Event event = (FnsInv003401Event) e;
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		
		try {
			String bkgIfCnt = command.searchBKGInterfaceCount(event.getBlNos());
			
			eventResponse.setETCData("bkg_if_cnt", bkgIfCnt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * [FNS_INV_0018]  - COMMAND01
     * After SAVE - backendjob status check <br>
     * @author KIMOKRYE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */	
	private EventResponse checkBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0018Event event = (FnsInv0018Event)e;
		ARInvoiceCorrectionBC command = new ARInvoiceCorrectionBCImpl();
		
		try{
			log.debug("event.getBackEndJobKey():::" + event.getBackEndJobKey());
			String[] result = command.checkBackEndJob(event.getBackEndJobKey());
			eventResponse.setETCData("jb_sts_flg",		result[0]);
			eventResponse.setETCData("jb_usr_err_msg",	result[1]);
			
		}catch(EventException ex){
			throw ex;
		}
		return eventResponse;
	}		
}