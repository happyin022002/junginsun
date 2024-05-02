/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceBCImpl.java
*@FileTitle : AccountPayableInvoiceBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBC;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBCImpl;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration.AccountPayableInvoiceDBDAO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.APManualInvoiceAccuralCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.AsaClearingVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceAccrualCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceAccrualVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceApprovalInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceApprovalListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryLineListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePayScheduleListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePrintVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceReceiptCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceReceiptListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipDetailListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipPaymentListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentLineCheckVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentPayScheduleCheckVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementApplyListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementInvoiceListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementUnapplyListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceDetailVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceHeaderVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.UnsettledAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.UnsettledEntryCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentApplyUnapplyVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.AsaInfoVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceInterfaceSAPTypeCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.basic.AccountPayablePaymentBC;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.basic.AccountPayablePaymentBCImpl;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchEntryVendorSumInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentEntryLineVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchSelectedListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCancelCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingPaymentCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APAccountingListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.AsaClearingVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryLineListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBC;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingInterfaceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.util.ScheduleUtil;

import java.math.BigDecimal;

/**
 * OPUS-SAP Invoices Logic Command Interface<br>
 *
 * @author KIM, O. R.
 * @see Stm_Sap_0010Event, AccountPayableInvoiceBC DAO Class
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceBCImpl extends BasicCommandSupport implements AccountPayableInvoiceBC {	

	private transient AccountPayableInvoiceDBDAO dbDao = null;
	
	/**
	 * AccountPayableInvoiceBCImpl object creation<br>
	 * AccountPayableInvoiceDBDAO creation<br>
	 */
	public AccountPayableInvoiceBCImpl() {
		dbDao = new AccountPayableInvoiceDBDAO();		
	}
	
	/**
	 * [STM_SAP_0010] Retrieve<br>
	 * Invoice Header List retrieve<br>
	 *
	 * @param InvoiceEntryCondVO invoiceEntryCondVO
	 * @return List<InvoiceEntryListVO>
	 * @exception EventException
	 */
	public List<InvoiceEntryListVO> searchInvoiceEntryList(InvoiceEntryCondVO invoiceEntryCondVO) throws EventException {
		try {
			return dbDao.searchInvoiceEntryList(invoiceEntryCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [STM_SAP_0010] Retrieve<br>
	 * Invoice Line List retrieve<br>
	 *
	 * @param String invoiceID
	 * @return List<InvoiceEntryLineListVO>
	 * @exception EventException
	 */
	public List<InvoiceEntryLineListVO> searchInvoiceEntryLineList(String invoiceID) throws EventException {
		try {
			return dbDao.searchInvoiceEntryLineList(invoiceID);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	

	/**
	 * [STM_SAP_0010] Retrieve<br>
	 * Payment Schedule List retrieve<br>
	 *
	 * @param String invoiceID
	 * @return List<InvoicePayScheduleListVO>
	 * @exception EventException
	 */
	public List<InvoicePayScheduleListVO> searchInvoicePayScheduleList(String invoiceID) throws EventException {
		try {
			return dbDao.searchInvoicePayScheduleList(invoiceID);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * [STM_SAP_0010]
	 * INVOICES list save<br>
	 *
	 * @param InvoiceEntryListVO[] invoiceEntryListVOs
	 * @param InvoiceEntryLineListVO[] invoiceEntryLineListVOs 
	 * @param InvoicePayScheduleListVO[] invoicePayScheduleListVOs
	 * @param SignOnUserAccount account
	 * @param String ap_ofc_cd
	 * @return String
	 * @exception EventException
	 */
	public String manageInvoiceEntryInfo(InvoiceEntryListVO[] invoiceEntryListVOs, InvoiceEntryLineListVO[] invoiceEntryLineListVOs, InvoicePayScheduleListVO[] invoicePayScheduleListVOs, SignOnUserAccount account, String ap_ofc_cd) throws EventException {
		try {
			
			String invSeq = "";
			String csr_no = "";
			
			//SAP_INV_HDR
			if (invoiceEntryListVOs != null ) {
				List<InvoiceEntryListVO> insertVoList = new ArrayList<InvoiceEntryListVO>();
				List<InvoiceEntryListVO> updateVoList = new ArrayList<InvoiceEntryListVO>();
				List<InvoiceEntryListVO> deleteVoList = new ArrayList<InvoiceEntryListVO>();
				
				for (int i=0; i<invoiceEntryListVOs.length; i++) {
					
					if(invoiceEntryListVOs[i].getChkFlg().equals("1")) {
						invoiceEntryListVOs[i].setUsrId(account.getUsr_id());
						invSeq = invoiceEntryListVOs[i].getInvSeq();
						
						if (invoiceEntryListVOs[i].getIbflag().equals("I")) {
							// setting next inv_seq
							invSeq = dbDao.searchNextInvSeq();
							invoiceEntryListVOs[i].setInvSeq(invSeq);
							
							// setting next csr_no
							SapCommonVO sapCommonVO = new SapCommonVO();
							sapCommonVO.setValue0("02");  // manual csr_no
							sapCommonVO.setValue1(invoiceEntryListVOs[i].getInvTpLuCd().substring(0,1));  //invoice type's init charater
							sapCommonVO.setValue2(invoiceEntryListVOs[i].getUsrId());  // usr_id
							sapCommonVO.setValue3(ap_ofc_cd);  // LOGIN USER'S AP_OFC_CD 						
							csr_no = dbDao.addCSRNo(sapCommonVO);
							
							if (csr_no == null || csr_no.equals("")) {
								throw new EventException(new ErrorHandler("COM12192", new String[]{"[NOTHING CSR_NO]"}).getMessage());
							}	
							
							if (csr_no.equals(dbDao.searchCSRNoDupChk(csr_no))) {
								throw new EventException(new ErrorHandler("SAP00003", new String[]{"["+csr_no+"]"}).getMessage());
							}
							invoiceEntryListVOs[i].setInvNo(csr_no);
							
							insertVoList.add(invoiceEntryListVOs[i]);
						} else if (invoiceEntryListVOs[i].getIbflag().equals("U")) {
							updateVoList.add(invoiceEntryListVOs[i]);
						} else if (invoiceEntryListVOs[i].getIbflag().equals("D")) {
							deleteVoList.add(invoiceEntryListVOs[i]);
						}
					}
				}
	
				if (insertVoList.size() > 0) {
					dbDao.addInvoiceHeader(insertVoList);
				}
				if (updateVoList.size() > 0) {
					dbDao.modifyInvoiceHeader(updateVoList);
				}
				//if (deleteVoList.size() > 0) {
					//dbDao.removeInvoiceHeader(deleteVoList);  //header delete 는 아래의 removeInvoiceEntryInfo 로직을 타야함.
				//}
			}
			//SAP_INV_DTL
			if (invoiceEntryLineListVOs != null ) {
				List<InvoiceEntryLineListVO> insertVoListLine = new ArrayList<InvoiceEntryLineListVO>();
				List<InvoiceEntryLineListVO> updateVoListLine = new ArrayList<InvoiceEntryLineListVO>();
				List<InvoiceEntryLineListVO> deleteVoListLine = new ArrayList<InvoiceEntryLineListVO>();
				
				for (int i=0; i<invoiceEntryLineListVOs.length; i++) {
					invoiceEntryLineListVOs[i].setUsrId(account.getUsr_id());
					invoiceEntryLineListVOs[i].setInvSeq(invSeq);
					if (invoiceEntryLineListVOs[i].getIbflag().equals("I")) {
						insertVoListLine.add(invoiceEntryLineListVOs[i]);
					} else if (invoiceEntryLineListVOs[i].getIbflag().equals("U")) {
						updateVoListLine.add(invoiceEntryLineListVOs[i]);
					} else if (invoiceEntryLineListVOs[i].getIbflag().equals("D")) {
						deleteVoListLine.add(invoiceEntryLineListVOs[i]);
					}
				}
	
				if (insertVoListLine.size() > 0) {
					dbDao.addInvoiceLine(insertVoListLine);
				}
				if (updateVoListLine.size() > 0) {
					dbDao.modifyInvoiceLine(updateVoListLine);
				}
				if (deleteVoListLine.size() > 0) {
					dbDao.removeInvoiceLine(deleteVoListLine);
				}			
			}		
			
			
			//SAP_PAY_SKD
			if (invoicePayScheduleListVOs != null ) {
				List<InvoicePayScheduleListVO> insertVoListPaySchedule = new ArrayList<InvoicePayScheduleListVO>();
				List<InvoicePayScheduleListVO> updateVoListPaySchedule = new ArrayList<InvoicePayScheduleListVO>();
				List<InvoicePayScheduleListVO> deleteVoListPaySchedule = new ArrayList<InvoicePayScheduleListVO>();
				
				for (int i=0; i<invoicePayScheduleListVOs.length; i++) {
					invoicePayScheduleListVOs[i].setUsrId(account.getUsr_id());
					invoicePayScheduleListVOs[i].setInvSeq(invSeq);
					if (invoicePayScheduleListVOs[i].getIbflag().equals("I")) {
						insertVoListPaySchedule.add(invoicePayScheduleListVOs[i]);
					} else if (invoicePayScheduleListVOs[i].getIbflag().equals("U")) {
						updateVoListPaySchedule.add(invoicePayScheduleListVOs[i]);
					} else if (invoicePayScheduleListVOs[i].getIbflag().equals("D")) {
						deleteVoListPaySchedule.add(invoicePayScheduleListVOs[i]);
					}
				}
	
				if (insertVoListPaySchedule.size() > 0) {
					dbDao.addInvoicePaySchedule(insertVoListPaySchedule);
				}
				if (updateVoListPaySchedule.size() > 0) {
					dbDao.modifyInvoicePaySchedule(updateVoListPaySchedule);
				}
				if (deleteVoListPaySchedule.size() > 0) {
					dbDao.removeInvoicePaySchedule(deleteVoListPaySchedule);
				}
				
				//SAKURA I/F WHEN HOLD
				if (updateVoListPaySchedule.size() > 0) {
					InvoicePayScheduleListVO skdVO = new InvoicePayScheduleListVO();
					String prepayYN = "";
					for (int i=0; i<updateVoListPaySchedule.size(); i++) {
						skdVO = updateVoListPaySchedule.get(i);
						if(skdVO.getInvHldFlg().equals("0") && skdVO.getOrgInvHldFlg().equals("1")) {
							prepayYN = dbDao.searchInvoiceLinePrepayCheck(skdVO.getInvSeq());
							if(prepayYN.equals("Y")) {
								AccountPayablePaymentBC payCommand = new AccountPayablePaymentBCImpl();
								manageInterfaceSAP(dbDao.searchInvoiceCSRNoBySeq(skdVO.getInvSeq()), account.getUsr_id());
								//AP Invoice Accounting Call
								payCommand.manageAccountingCaptureCsrNo(csr_no, account.getUsr_id());
								dbDao.modifyInvoicePayScheduleIFResult(skdVO.getInvSeq());
							}
						}

					}
				}
			}
			
			//Manually ASA I/F 
			//manageAsaClearingIF(csr_no);
			
			return invSeq;
		} catch (EventException ex) {
			if(ex.getMessage().indexOf("SAR00001") > 0) {
				 //throw new EventException("It's not available to create ASA Outstanding to SAR module. Please check Rep. Customer of Office. ", ex); 
				 throw new EventException(new ErrorHandler("CGM10003", new String[]{"It's not available to create ASA Outstanding to SAR module. Please check Rep. Customer of Office. \nData"}).getMessage());
			} else {
				throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	
	/**
	 * [STM_SAP_0010]
	 * INVOICES list delete<br>
	 *
	 * @param InvoiceEntryListVO[] invoiceEntryListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeInvoiceEntryInfo(InvoiceEntryListVO[] invoiceEntryListVOs, SignOnUserAccount account) throws EventException {
		try {
			
			if (invoiceEntryListVOs != null ) {
				
				
				List<InvoiceEntryListVO> deleteVoList = new ArrayList<InvoiceEntryListVO>();
				
				for (int i=0; i<invoiceEntryListVOs.length; i++) {
					
					if(invoiceEntryListVOs[i].getChkFlg().equals("1")) {
						// N : delete impossible , Y : delete available
						if ( "N".equals(dbDao.searchInvoiceStatusCheck(invoiceEntryListVOs[i].getInvSeq()))) {
							throw new EventException(new ErrorHandler("SAP00002", new String[]{invoiceEntryListVOs[i].getInvSeq()}).getMessage());
						}
						
						invoiceEntryListVOs[i].setUsrId(account.getUsr_id());
						deleteVoList.add(invoiceEntryListVOs[i]);
					}
				}

				if (deleteVoList.size() > 0) {
					dbDao.removeInvoiceHeader(deleteVoList);
					dbDao.removeInvoiceLineByInvSeq(deleteVoList);
					dbDao.removeInvoicePayScheduleByInvSeq(deleteVoList);
				}
			}


		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
				
	}
	
	/**
	 * [STM_SAP_0010]
	 * searchLineVendorInvoiceNoDupCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchLineVendorInvoiceNoDupCheck(SapCommonVO sapCommonVO) throws EventException {
		try {
			SapCommonVO rtnVO = dbDao.searchLineVendorInvoiceNoDupCheck(sapCommonVO);  		
   		 return rtnVO;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
	}	
	
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceStatusCheck <br>
	 * 
	 * @param String inv_seq
	 * @return String
	 * @exception EventException
	*/
	public String searchInvoiceStatusCheck(String inv_seq) throws EventException {
		try {
   		 String rtnValue = dbDao.searchInvoiceStatusCheck(inv_seq);  		
   		 return rtnValue;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
	}	
	
	/**
	 * [STM_SAP_0010]
	 * searchLineAccountTypeList <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception EventException
	*/
	public List<SapCommonVO> searchLineAccountTypeList(SapCommonVO sapCommonVO) throws EventException {
		try {
   		 List<SapCommonVO> returnList = dbDao.searchLineAccountTypeList(sapCommonVO);  		
   		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
	}
	
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceLiabilityAccountCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception EventException
	*/
	public List<SapCommonVO> searchInvoiceLiabilityAccountCheck(SapCommonVO sapCommonVO) throws EventException {
		try {
   		 List<SapCommonVO> returnList = dbDao.searchInvoiceLiabilityAccountCheck(sapCommonVO);  		
   		 return returnList;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
	}
	
	/**
	 * [STM_SAP_0010]
	 * manageInvoiceApprovalInfo <br>
	 *
	 * @param InvoiceEntryListVO[] invoiceEntryListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageInvoiceCancelInfo(InvoiceEntryListVO[] invoiceEntryListVOs,  SignOnUserAccount account) throws EventException {
		try {
			
			String gl_date = "";
			String new_gl_date = "";
			
			//SAP_INV_HDR
			if (invoiceEntryListVOs != null ) {
				List<InvoiceEntryListVO> insertVoList = new ArrayList<InvoiceEntryListVO>();
				
				for (int i=0; i<invoiceEntryListVOs.length; i++) {
					
					if(invoiceEntryListVOs[i].getChkFlg().equals("1")) {
						invoiceEntryListVOs[i].setUsrId(account.getUsr_id());
						gl_date = invoiceEntryListVOs[i].getGlDt();
						
						String chkPeriod = dbDao.searchInvoiceCancelGLDateCheck(gl_date);
						if (!chkPeriod.equals("O")) {
							new_gl_date = dbDao.searchInvoiceCancelNextGLDateCheck(gl_date);
							if (new_gl_date.equals("")) {
								throw new EventException(new ErrorHandler("SAP00001", new String[]{gl_date}).getMessage());
							} else {
								invoiceEntryListVOs[i].setGlDt(new_gl_date);
							}
						} else {
							invoiceEntryListVOs[i].setGlDt(gl_date);
						}
						
						insertVoList.add(invoiceEntryListVOs[i]);	
					}
				}
	
				if (insertVoList.size() > 0) {
					dbDao.addInvoiceLineSelectInfo(insertVoList);
					dbDao.modifyInvoiceHeaderCancelInfo(insertVoList);
					dbDao.modifyInvoicePayScheduleCancelInfo(insertVoList);				
					
					for (int i=0; i<insertVoList.size(); i++) {
						//Manually ASA I/F 
						manageAsaClearingIF(insertVoList.get(i).getInvNo());
					}
				}
				
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		
	}
	
	
	/**
	 * [STM_SAP_0010]
	 * searchAccountValiInfo <br>
	 * 
	 * @param String acct_cd
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchAccountValiInfo(String acct_cd) throws EventException {
		try {
			return dbDao.searchAccountValiInfo(acct_cd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	
	/**
	 * [STM_SAP_0010]
	 * searchVendorValiInfo <br>
	 * 
	 * @param String vendor_no
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchVendorValiInfo(String vendor_no) throws EventException {
		try {
			return dbDao.searchVendorValiInfo(vendor_no);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [STM_SAP_0010]
	 * searchOffValiInfo <br>
	 * 
	 * @param String ofc_cd
	 * @param String securityFlag
	 * @param SignOnUserAccount account
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchOffValiInfo(String ofc_cd, String securityFlag, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchOffValiInfo(ofc_cd, securityFlag, account.getUsr_id(), account.getOfc_cd());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceASAPeriodToDateInfo <br>
	 * 
	 * @param String asa_no
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchInvoiceASAPeriodToDateInfo(String asa_no) throws EventException {
		try {
			return dbDao.searchInvoiceASAPeriodToDateInfo(asa_no);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0010]
	 * searchLegrValiInfo <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception EventException
	*/
	public List<SapCommonVO> searchLegrValiInfo(SapCommonVO sapCommonVO) throws EventException {
		try {
			return dbDao.searchLegrValiInfo(sapCommonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0010]
	 * searchAsaValiInfo <br>
	 * 
	 * @param String asa_no
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchAsaValiInfo(String asa_no) throws EventException {
		try {
			return dbDao.searchAsaValiInfo(asa_no);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0010]
	 * searchSupplierBankValiInfo <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchSupplierBankValiInfo(SapCommonVO sapCommonVO) throws EventException {
		try {
			SapCommonVO rtnVO = dbDao.searchSupplierBankValiInfo(sapCommonVO);  		
   		 return rtnVO;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
	}
	
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceASACloseStatusCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return String
	 * @exception EventException
	*/
	public String searchInvoiceASACloseStatusCheck(SapCommonVO sapCommonVO) throws EventException {
		try {
			return dbDao.searchInvoiceASACloseStatusCheck(sapCommonVO);  		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
	}
	
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceInterfaceToSAKURAStatusCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return String
	 * @exception EventException
	*/
	public String searchInvoiceInterfaceToSAKURAStatusCheck(SapCommonVO sapCommonVO) throws EventException {
		try {
			return dbDao.searchInvoiceInterfaceToSAKURAStatusCheck(sapCommonVO);  		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
	}
	
	/**
	 * [STM_SAP_0010] [STM_SAP_0240]] [STM_SAP_0030]
	 * printInvoiceList <br>
	 * @param  InvoicePrintVO[] invoicePrintVOs
	 * @param  SignOnUserAccount account
	 * @param  String call_flag
	 * @return String
	 * @exception EventException
	*/	
	public String printInvoiceList(InvoicePrintVO[] invoicePrintVOs, SignOnUserAccount account, String call_flag) throws EventException {
		String invoice_request_id = "";
		try {
			if ( invoicePrintVOs != null ) {
				List<InvoicePrintVO> addVoList = new ArrayList<InvoicePrintVO>();
				invoice_request_id =  dbDao.searchInvoiceSlipPrintRequestInfo();

				for (int i=0; i<invoicePrintVOs.length; i++) {
					invoicePrintVOs[i].setUsrId(account.getUsr_id());
					invoicePrintVOs[i].setInvRqstSeq(invoice_request_id);
					if("INVOICE".equals(call_flag)) {
						if( invoicePrintVOs[i].getChkFlg().equals("1") ) {
							addVoList.add(invoicePrintVOs[i]);	
						}	
					} else {
						if( invoicePrintVOs[i].getCheckbox().equals("1") ) {
							addVoList.add(invoicePrintVOs[i]);	
						}	
					}
				} 
				
				if (addVoList.size() > 0 ) {
					dbDao.removeInvoiceSlipPrintRequest(addVoList.get(0));
					dbDao.addInvoiceSlipPrintInfo(addVoList);
					
					if("INVOICE".equals(call_flag)) { 
						dbDao.modifyInvoiceSlipPrintFlagInfo(addVoList);
					}
				}
			}
		}  catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}	
		return invoice_request_id;
	}

	
	/**
	 * [STM_SAP_0241] Retrieve<br>
	 * Prepayment Apply-Unapply Invoices - Header Info Retrieve <br>
	 *
	 * @param String inv_seq
	 * @return List<PrepaymentSettlementInvoiceListVO>
	 * @exception EventException
	 */
	public List<PrepaymentSettlementInvoiceListVO> searchPrepaymentSettlementInvoiceList(String inv_seq) throws EventException {
		try {
	   		 return dbDao.searchPrepaymentSettlementInvoiceList(inv_seq);  		
		}  catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}		
	}

	
	/**
	 * [STM_SAP_0241] Retrieve<br>
	 * Prepayment Apply-Unapply Invoices - Apply Info Retrieve <br>
	 *
	 * @param PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO
	 * @return List<PrepaymentSettlementApplyListVO>
	 * @exception EventException
	 */
	public List<PrepaymentSettlementApplyListVO> searchPrepaymentSettlementApplyList(PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO) throws EventException {
		try {
	   		 return dbDao.searchPrepaymentSettlementApplyList(prepaymentSettlementInvoiceListVO);  		
		}  catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}		
	}
	
	/**
	 * [STM_SAP_0241] Retrieve<br>
	 * Prepayment Apply-Unapply Invoices - Unapply Info Retrieve <br>
	 *
	 * @param PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO
	 * @return List<PrepaymentSettlementUnapplyListVO>
	 * @exception EventException
	 */
	public List<PrepaymentSettlementUnapplyListVO> searchPrepaymentSettlementUnapplyList(PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO) throws EventException {
		try {
	   		 return dbDao.searchPrepaymentSettlementUnapplyList(prepaymentSettlementInvoiceListVO);  		
		}  catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}		
	}

	/**
	 * [STM_SAP_0241]<br>
	 * searchPrepayGLDatePeriodInfo <br>
	 *
	 * @param String gl_date
	 * @param String ofc_cd 
	 * @return String (gl_date)
	 * @exception EventException
	 */
	public String searchPrepayGLDatePeriodInfo(String gl_date, String ofc_cd ) throws EventException {
		try {
			String gl_dt1 = dbDao.searchOpenNextGLDatePeriodInfo(gl_date, ofc_cd);
			if (gl_dt1 != null && !gl_dt1.equals("")) {
				return gl_dt1;					
			} else {
				String gl_dt2 = dbDao.searchAPOpenNextGLDatePeriodInfo(gl_date);
				return gl_dt2;
			}
		}  catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}		
	}
	

	/**
	 * [STM_SAP_0241]
	 * 
	 * @param PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO
	 * @param PrepaymentSettlementApplyListVO[] prepaymentSettlementApplyListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String managePrepaymentApplyInfo(PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO,  PrepaymentSettlementApplyListVO[] prepaymentSettlementApplyListVOs, SignOnUserAccount account) throws EventException {
		try {
			
			if (prepaymentSettlementApplyListVOs != null ) {
				List<PrepaymentApplyUnapplyVO> targetVoList = new ArrayList<PrepaymentApplyUnapplyVO>();
				List<PrepaymentApplyUnapplyVO> pVoList = new ArrayList<PrepaymentApplyUnapplyVO>();
				List<PrepaymentApplyUnapplyVO> sVoList = new ArrayList<PrepaymentApplyUnapplyVO>();
				
				for (int i=0; i<prepaymentSettlementApplyListVOs.length; i++) {
					
					if(prepaymentSettlementApplyListVOs[i].getApply().equals("1")) {
						PrepaymentApplyUnapplyVO targetVo = new PrepaymentApplyUnapplyVO();
						
						targetVo.setUsrId(account.getUsr_id());
						targetVo.setStandardInvSeq(prepaymentSettlementApplyListVOs[i].getInvSeq());  //POPUP'S LINE  standard
						targetVo.setCurrency(prepaymentSettlementInvoiceListVO.getInvCurrCd());
						targetVo.setApplyGlDate(prepaymentSettlementApplyListVOs[i].getApplyGlDate());
						targetVo.setPrepaymentInvSeq(prepaymentSettlementInvoiceListVO.getInvSeq());  	//POPUP'S HEAD prepayment
						targetVo.setFunctionalCurrency(prepaymentSettlementInvoiceListVO.getFunctionalCurrency());
						
						targetVo.setPrepaymentLineNo("1");  //default setting
						targetVo.setApplyAmount(prepaymentSettlementApplyListVOs[i].getAmountApply().replaceAll(",", ""));  //default setting
						
						targetVoList.add(targetVo);		
						
					}
				}
				
				//선급전표 처리.  =====================================================================
				int idxP = 0;
				int idxS = 0;
				float tempP = 0;
				float tempS = 0;
				float diff = 0;
				
				
				List<PrepaymentLineCheckVO> prepaymentLineCheckVOs = dbDao.searchFindPrepaymentLineCheck(prepaymentSettlementInvoiceListVO.getInvSeq());
					
				int pSize = prepaymentLineCheckVOs.size();
				int sSize = targetVoList.size();
				
				while (idxP < pSize) { 
					
					if (idxP != 0 ) tempP = Float.parseFloat(prepaymentLineCheckVOs.get(idxP).getApplyAmt());
					if (idxS == targetVoList.size()) break;
					for (int k=idxS; k<targetVoList.size(); k++) {
						if(idxP == 0 && idxS == 0 ) {
							tempP = Float.parseFloat(prepaymentLineCheckVOs.get(idxP).getApplyAmt());
							tempS = Float.parseFloat(targetVoList.get(idxS).getApplyAmount());
						}						
					
						diff = tempP - tempS;
						
						PrepaymentApplyUnapplyVO targetVo = new PrepaymentApplyUnapplyVO();
						
						if (diff > 0 ) {
							
							//default targetVo setting 
							targetVo.setUsrId            (account.getUsr_id());
							targetVo.setCurrency         (prepaymentSettlementInvoiceListVO.getInvCurrCd());
							targetVo.setFunctionalCurrency(targetVoList.get(idxS).getFunctionalCurrency()); 
							targetVo.setPrepaymentInvSeq (prepaymentSettlementInvoiceListVO.getInvSeq()); 
							targetVo.setApplyGlDate      (targetVoList.get(idxS).getApplyGlDate()); 
							targetVo.setStandardInvSeq   (targetVoList.get(idxS).getStandardInvSeq()); 							
							
							//line, amount setting
							targetVo.setPrepaymentLineNo(prepaymentLineCheckVOs.get(idxP).getDtrbLineNo());
							targetVo.setApplyAmount     (tempS + "");
							tempP = tempP - tempS;
							idxS++;
							if(idxS < sSize) tempS = Float.parseFloat(targetVoList.get(idxS).getApplyAmount());	
							sVoList.add(targetVo);
							break;	
						} else if ( diff < 0 ) {
							
							//default targetVo setting 
							targetVo.setUsrId            (account.getUsr_id());
							targetVo.setCurrency         (prepaymentSettlementInvoiceListVO.getInvCurrCd());
							targetVo.setFunctionalCurrency(targetVoList.get(idxS).getFunctionalCurrency()); 
							targetVo.setPrepaymentInvSeq (prepaymentSettlementInvoiceListVO.getInvSeq()); 
							targetVo.setApplyGlDate      (targetVoList.get(idxS).getApplyGlDate()); 
							targetVo.setStandardInvSeq   (targetVoList.get(idxS).getStandardInvSeq()); 
							
							//line, amount setting
							targetVo.setPrepaymentLineNo(prepaymentLineCheckVOs.get(idxP).getDtrbLineNo());
							targetVo.setApplyAmount     (tempP + "");
							tempS = diff * (-1);
							idxP++;
							
							sVoList.add(targetVo);
							//pVoList.add(targetVo);
							break;								
						} else if ( diff == 0 ) {
							
							//default targetVo setting 
							targetVo.setUsrId            (account.getUsr_id());
							targetVo.setCurrency         (prepaymentSettlementInvoiceListVO.getInvCurrCd());
							targetVo.setFunctionalCurrency(targetVoList.get(idxS).getFunctionalCurrency()); 
							targetVo.setPrepaymentInvSeq (prepaymentSettlementInvoiceListVO.getInvSeq()); 
							targetVo.setApplyGlDate      (targetVoList.get(idxS).getApplyGlDate()); 
							targetVo.setStandardInvSeq   (targetVoList.get(idxS).getStandardInvSeq()); 
							
							//line, amount setting
							targetVo.setPrepaymentLineNo(prepaymentLineCheckVOs.get(idxP).getDtrbLineNo());  //idxP에 있는 라인 
							targetVo.setApplyAmount     (tempP + "");
							
							// logic setting 
							idxP++;
							idxS++;
							
							if(idxP < pSize) tempP = Float.parseFloat(prepaymentLineCheckVOs.get(idxP).getApplyAmt());
							if(idxS < sSize) tempS = Float.parseFloat(targetVoList.get(idxS).getApplyAmount());
							
							sVoList.add(targetVo);
							break;
						}
						
					}
				}
		
				idxP = 0;
				idxS = 0;
				tempP = 0;
				tempS = 0;
				diff = 0;
				float lineApply = 0;	
				
				sSize = targetVoList.size();
				
				for (int i=0; i < sSize; i++) {
					List<PrepaymentPayScheduleCheckVO> prepaymentPayScheduleCheckVOs = dbDao.searchFindPrepaymentPayScheduleCheck(targetVoList.get(i).getStandardInvSeq(),"APPLY");
					lineApply = Float.parseFloat(targetVoList.get(i).getApplyAmount().replaceAll(",", ""));
					
					pSize = prepaymentPayScheduleCheckVOs.size();
					for (int k=0; k<pSize; k++) {
						tempP = Float.parseFloat(prepaymentPayScheduleCheckVOs.get(k).getPayRmnAmt());
						diff = tempP - lineApply;
						
						PrepaymentApplyUnapplyVO targetVo = new PrepaymentApplyUnapplyVO();
						
						if ( diff > 0 ) {
							
							//default targetVo setting 
							targetVo.setUsrId            (account.getUsr_id());
							targetVo.setCurrency         (prepaymentSettlementInvoiceListVO.getInvCurrCd());
							targetVo.setFunctionalCurrency(targetVoList.get(i).getFunctionalCurrency()); 
							targetVo.setPrepaymentInvSeq (prepaymentSettlementInvoiceListVO.getInvSeq()); 
							targetVo.setApplyGlDate      (targetVoList.get(i).getApplyGlDate()); 
							targetVo.setStandardInvSeq   (targetVoList.get(i).getStandardInvSeq()); 
							
							//line, amount setting
							targetVo.setStandardLineNo(prepaymentPayScheduleCheckVOs.get(k).getPaySkdNo());
							targetVo.setApplyAmount     (lineApply + "");
							
							pVoList.add(targetVo);
							
							k = pSize;
							break;
							
						} else if ( diff < 0 ) {
							//default targetVo setting 
							targetVo.setUsrId            (account.getUsr_id());
							targetVo.setCurrency         (prepaymentSettlementInvoiceListVO.getInvCurrCd());
							targetVo.setFunctionalCurrency(targetVoList.get(i).getFunctionalCurrency());
							targetVo.setPrepaymentInvSeq (prepaymentSettlementInvoiceListVO.getInvSeq()); 
							targetVo.setApplyGlDate      (targetVoList.get(i).getApplyGlDate()); 
							targetVo.setStandardInvSeq   (targetVoList.get(i).getStandardInvSeq()); 
							
							//line, amount setting
							targetVo.setStandardLineNo(prepaymentPayScheduleCheckVOs.get(k).getPaySkdNo());
							targetVo.setApplyAmount     (tempP + "");
							lineApply = diff * (-1);
							
							pVoList.add(targetVo);
							
						} else if ( diff == 0 ) {
							//default targetVo setting 
							targetVo.setUsrId            (account.getUsr_id());
							targetVo.setCurrency         (prepaymentSettlementInvoiceListVO.getInvCurrCd());
							targetVo.setFunctionalCurrency(targetVoList.get(i).getFunctionalCurrency());
							targetVo.setPrepaymentInvSeq (prepaymentSettlementInvoiceListVO.getInvSeq()); 
							targetVo.setApplyGlDate      (targetVoList.get(i).getApplyGlDate()); 
							targetVo.setStandardInvSeq   (targetVoList.get(i).getStandardInvSeq()); 
							
							//line, amount setting
							targetVo.setStandardLineNo(prepaymentPayScheduleCheckVOs.get(k).getPaySkdNo());
							targetVo.setApplyAmount     (tempP + "");
							
							pVoList.add(targetVo);
				
							break;
							
						}
					}
				}
				
				if (targetVoList.size() > 0) {
					dbDao.addApplyedPrepaymentLineInfo(sVoList);
					dbDao.modifyApplyedPrepaymentPayScheduleInfo(pVoList);
					dbDao.modifyApplyPrepaymentPayInvoiceInfo(targetVoList);
					dbDao.modifyApplyPrepaymentLinePrepayInfo(sVoList);
				}   
				
			}
			
			return "SUCCESS";

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [STM_SAP_0241]
	 * 
	 * @param PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO
	 * @param PrepaymentSettlementUnapplyListVO[] prepaymentSettlementUnapplyListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String managePrepaymentUnApplyInfo(PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO,  PrepaymentSettlementUnapplyListVO[] prepaymentSettlementUnapplyListVOs, SignOnUserAccount account) throws EventException {
		try {
			
			if (prepaymentSettlementUnapplyListVOs != null ) {
				List<PrepaymentApplyUnapplyVO> targetVoList = new ArrayList<PrepaymentApplyUnapplyVO>();
				List<PrepaymentApplyUnapplyVO> pVoList = new ArrayList<PrepaymentApplyUnapplyVO>();
				
				for (int i=0; i<prepaymentSettlementUnapplyListVOs.length; i++) {
					
					if(prepaymentSettlementUnapplyListVOs[i].getUnapply().equals("1")) {
						PrepaymentApplyUnapplyVO targetVo = new PrepaymentApplyUnapplyVO();
						
						targetVo.setUsrId				(account.getUsr_id());
						targetVo.setPrepaymentInvSeq	(prepaymentSettlementUnapplyListVOs[i].getPpayInvSeq());  	//prepayment inv_seq
						targetVo.setPrepaymentLineNo	(prepaymentSettlementUnapplyListVOs[i].getPpayLineNo());  	//prepayment line_no
						targetVo.setStandardInvSeq		(prepaymentSettlementUnapplyListVOs[i].getInvSeq());        //POPUP'S LINE  standard
						targetVo.setStandardLineNo		(prepaymentSettlementUnapplyListVOs[i].getDtrbLineNo());  	//POPUP'S LINE  standard
						targetVo.setCurrency			(prepaymentSettlementInvoiceListVO.getInvCurrCd());
						targetVo.setUnapplyGlDate		(prepaymentSettlementUnapplyListVOs[i].getUnapplyGlDate());
						targetVo.setUnapplyAmount		(prepaymentSettlementUnapplyListVOs[i].getPrepayAmountApplied().replaceAll(",", ""));  
						targetVo.setFunctionalCurrency  (prepaymentSettlementInvoiceListVO.getFunctionalCurrency());
						targetVoList.add(targetVo);		
						
					}
				}
				
				float tempP = 0;
				float diff = 0;
				float lineApply = 0;	
				
				int sSize = targetVoList.size();
				
				for (int i=0; i < sSize; i++) {
					List<PrepaymentPayScheduleCheckVO> prepaymentPayScheduleCheckVOs = dbDao.searchFindPrepaymentPayScheduleCheck(targetVoList.get(i).getStandardInvSeq(), "UNAPPLY");
					lineApply = Float.parseFloat(targetVoList.get(i).getUnapplyAmount().replaceAll(",", ""));
					
					int pSize = prepaymentPayScheduleCheckVOs.size();
					for (int k=0; k<pSize; k++) {
						tempP = Float.parseFloat(prepaymentPayScheduleCheckVOs.get(k).getPayGrsAmt());
						diff = tempP - lineApply;
						
						PrepaymentApplyUnapplyVO targetVo = new PrepaymentApplyUnapplyVO();
						
						if ( diff > 0 ) {
							
							//default targetVo setting 
							targetVo.setUsrId				(account.getUsr_id());
							targetVo.setPrepaymentInvSeq	(targetVoList.get(i).getPrepaymentInvSeq());  	//prepayment inv_seq
							targetVo.setPrepaymentLineNo	(targetVoList.get(i).getPrepaymentLineNo());  	//prepayment line_no
							targetVo.setStandardInvSeq		(targetVoList.get(i).getStandardInvSeq());        //POPUP'S LINE  standard
							targetVo.setCurrency			(targetVoList.get(i).getCurrency());
							targetVo.setFunctionalCurrency  (targetVoList.get(i).getFunctionalCurrency());
							targetVo.setUnapplyGlDate		(targetVoList.get(i).getUnapplyGlDate());
							
							//line, amount setting
							targetVo.setStandardLineNo(prepaymentPayScheduleCheckVOs.get(k).getPaySkdNo());
							targetVo.setUnapplyAmount     (lineApply + "");
							
							pVoList.add(targetVo);
							
							k = pSize;
							break;
							
						} else if ( diff < 0 ) {
							//default targetVo setting 
							targetVo.setUsrId				(account.getUsr_id());
							targetVo.setPrepaymentInvSeq	(targetVoList.get(i).getPrepaymentInvSeq());  	//prepayment inv_seq
							targetVo.setPrepaymentLineNo	(targetVoList.get(i).getPrepaymentLineNo());  	//prepayment line_no
							targetVo.setStandardInvSeq		(targetVoList.get(i).getStandardInvSeq());        //POPUP'S LINE  standard
							targetVo.setCurrency			(targetVoList.get(i).getCurrency());
							targetVo.setFunctionalCurrency  (targetVoList.get(i).getFunctionalCurrency());
							targetVo.setUnapplyGlDate		(targetVoList.get(i).getUnapplyGlDate());
							
							//line, amount setting
							targetVo.setStandardLineNo(prepaymentPayScheduleCheckVOs.get(k).getPaySkdNo());
							targetVo.setUnapplyAmount     (tempP + "");
							lineApply = diff * (-1);
							
							pVoList.add(targetVo);
				
							
							
						} else if ( diff == 0 ) {
							//default targetVo setting 
							targetVo.setUsrId				(account.getUsr_id());
							targetVo.setPrepaymentInvSeq	(targetVoList.get(i).getPrepaymentInvSeq());  	//prepayment inv_seq
							targetVo.setPrepaymentLineNo	(targetVoList.get(i).getPrepaymentLineNo());  	//prepayment line_no
							targetVo.setStandardInvSeq		(targetVoList.get(i).getStandardInvSeq());        //POPUP'S LINE  standard
							targetVo.setCurrency			(targetVoList.get(i).getCurrency());
							targetVo.setFunctionalCurrency  (targetVoList.get(i).getFunctionalCurrency());
							targetVo.setUnapplyGlDate		(targetVoList.get(i).getUnapplyGlDate());
							
							//line, amount setting
							targetVo.setStandardLineNo(prepaymentPayScheduleCheckVOs.get(k).getPaySkdNo());
							targetVo.setUnapplyAmount     (tempP + "");
							
							pVoList.add(targetVo);
				
							break;
							
						}
					}
				}				
				
				if (targetVoList.size() > 0) {
					dbDao.addUnApplyedPrepaymentLineInfo(targetVoList);
					dbDao.modifyUnApplyedPrepaymentApplyLineInfo(targetVoList);
					dbDao.modifyUnApplyedPrepaymentPayScheduleInfo(pVoList);
					dbDao.modifyUnApplyPrepaymentPayInvoiceInfo(targetVoList);
					dbDao.modifyUnApplyPrepaymentLinePrepayInfo(targetVoList);
				}  
			
			}
			
			return "SUCCESS";

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [STM_SAP_0210]

	 * @category STM_SAP_0210
	 * @category modifyPaymentSelectedInvoiceReturnInfo
	 * @param List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO
	 * @exception EventException
	 */
	public void modifyPaymentSelectedInvoiceReturnInfo(List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO) throws EventException {
		try {
			dbDao.modifyPaymentSelectedInvoiceReturnInfo(paymentBatchSelectedListVO); 			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	/**
	 * [STM_SAP_0210]

	 * @category STM_SAP_0210
	 * @category modifyPaymentSelectedInvoiceFixInfo
	 * @param List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO
	 * @exception EventException
	 */
	public void modifyPaymentSelectedInvoiceFixInfo(List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO) throws EventException {
		try {
			dbDao.modifyPaymentSelectedInvoiceFixInfo(paymentBatchSelectedListVO); 			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	 
	/**
	 * [STM_SAP_0210]

	 * @category STM_SAP_0210
	 * @category modifyPayCaptureSelectedInvoiceChangeInfo
	 * @param List<PaymentBatchListVO> paymentBatchListVO
	 * @exception EventException
	 */
	public void modifyPayCaptureSelectedInvoiceChangeInfo(List<PaymentBatchListVO> paymentBatchListVO) throws EventException {
		try {
			dbDao.modifyPayCaptureSelectedInvoiceChangeInfo(paymentBatchListVO); 			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	 
	
	/**
	 * [STM_SAP_0210]
	 * managePaymentSelectedInvoiceInfo<br>
	 *
	 * @param PaymentBatchListVO[] paymentBatchListVOs
	 * @param PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs
	 * @param String fCurrCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePaymentSelectedInvoiceInfo(PaymentBatchListVO[] paymentBatchListVOs, PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs, String fCurrCd, SignOnUserAccount account) throws EventException {
		try {
			
			if ( paymentBatchSelectedListVOs != null ) {
				
				List<PaymentBatchSelectedListVO> addVoList = new ArrayList<PaymentBatchSelectedListVO>();
				List<PaymentBatchSelectedListVO> modVoList = new ArrayList<PaymentBatchSelectedListVO>();
				
				for (int i=0; i<paymentBatchSelectedListVOs.length; i++) {
					if(paymentBatchSelectedListVOs[i].getIbflag().equals("I")) {
						paymentBatchSelectedListVOs[i].setUsrId(account.getUsr_id());
						paymentBatchSelectedListVOs[i].setPayDt(paymentBatchListVOs[0].getPayDt());
						paymentBatchSelectedListVOs[i].setFunctionalCurrency(fCurrCd);
						addVoList.add(paymentBatchSelectedListVOs[i]);
					} else if(paymentBatchSelectedListVOs[i].getIbflag().equals("D")) {
						paymentBatchSelectedListVOs[i].setUsrId(account.getUsr_id());
						paymentBatchSelectedListVOs[i].setPayDt(paymentBatchListVOs[0].getPayDt());
						modVoList.add(paymentBatchSelectedListVOs[i]);
					}
				}

				if (addVoList.size() > 0) {
					dbDao.modifyPaymentSelectedInvoiceFixInfo(addVoList);
				}
				if (modVoList.size() > 0) {
					dbDao.modifyPaymentSelectedInvoiceReturnInfo(modVoList);
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}	


	/**
	 * [STM_SAP_0210]
	 * managePaymentCaptureInfo<br>
	 *
	 * @param PaymentBatchListVO[] paymentBatchListVOs
	 * @param PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs
	 * @param String fCurrCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePaymentCaptureInfo(PaymentBatchListVO[] paymentBatchListVOs, PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs, String fCurrCd, SignOnUserAccount account) throws EventException {
		try {
			
			if ( paymentBatchListVOs != null ) {
				
				List<PaymentBatchListVO> addVoList = new ArrayList<PaymentBatchListVO>();
				
				for (int i=0; i<paymentBatchListVOs.length; i++) {
					paymentBatchListVOs[i].setUsrId(account.getUsr_id());
					paymentBatchListVOs[i].setPayDt(paymentBatchListVOs[0].getPayDt());
					paymentBatchListVOs[i].setFunctionalCurrency(fCurrCd);
					addVoList.add(paymentBatchListVOs[i]);
				}

				if (addVoList.size() > 0) {
					dbDao.modifyPayCaptureSelectedInvoiceChangeInfo(addVoList);					
				}
				
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	
	/**
	 * [STM_SAP_0210]
	 * managePaymentConfirmInfo<br>
	 *
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList
	 * @exception EventException
	 */
	public void managePaymentConfirmInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList) throws EventException {

		try {
			
			if (paymentBatchEntryVendorSumInfoVOList.size() > 0) {
				dbDao.modifyBatchPaymentInvScheduleCompleteInfo(paymentBatchEntryVendorSumInfoVOList);
				dbDao.modifyBatchPaymentInvoiceHeaderCompleteInfo(paymentBatchEntryVendorSumInfoVOList);				
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}

	/**
	 * CREATE Invoice Interface Header<br>
	 * 
	 * @author ORKIM
	 * @category addInvoiceHeaderIF
	 * @param List<SapInvoiceInterfaceHeaderVO> sapInvoiceInterfaceHeaderVOList
	 * @exception EventException
	 */
	public void addInvoiceHeaderIF(List<SapInvoiceInterfaceHeaderVO> sapInvoiceInterfaceHeaderVOList) throws EventException {
		try {
			if (sapInvoiceInterfaceHeaderVOList.size() > 0) {
				dbDao.addInvoiceIFHeader(sapInvoiceInterfaceHeaderVOList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	/**
	 * CREATE Invoice Interface Detail<br>
	 * 
	 * @author ORKIM
	 * @category addInvoiceLineIF
	 * @param List<SapInvoiceInterfaceDetailVO> sapInvoiceInterfaceDetailVOList
	 * @exception EventException
	 */
	public void addInvoiceLineIF(List<SapInvoiceInterfaceDetailVO> sapInvoiceInterfaceDetailVOList) throws EventException {
		try {
			if (sapInvoiceInterfaceDetailVOList.size() > 0) {
				dbDao.addInvoiceLineIF(sapInvoiceInterfaceDetailVOList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	 
	/**
	 * Search Invoice Header IF Next Sequence <br>
	 * 
	 * @author ORKIM
	 * @category searchInoviceHeaderIFNextSeq
	 * @return String rtnValue (SAP_INV_HDR_IF_SEQ.NEXTVAL)
	 * @exception EventException
	*/
	public String searchInoviceHeaderIFNextSeq() throws EventException {
		try {
			return dbDao.searchInoviceHeaderIFNextSeq();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0220]
	 * modifyAccountingDetailInvLineFlag<br>
	 * 
	 * @author ORKIM
	 * @category modifyAccountingDetailInvLineFlag
	 * @param List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs
	 * @exception EventException
	 */
	public void modifyAccountingDetailInvLineFlag(List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs) throws EventException {
		try {
			if (accountingInvoiceCheckVOs.size() > 0) {
				dbDao.modifyAccountingDetailInvLineFlag(accountingInvoiceCheckVOs);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	
	/**
	 * [STM_SAP_0220]
	 * modifyAccountingDetailInvLineCancelFlag<br>
	 * 
	 * @author ORKIM
	 * @category modifyAccountingDetailInvLineFlag
	 * @param List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs
	 * @exception EventException
	 */
	public void modifyAccountingDetailInvLineCancelFlag(List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs) throws EventException {
		try {
			if (accountingInvoiceCancelCheckVOs.size() > 0) {
				dbDao.modifyAccountingDetailInvLineCancelFlag(accountingInvoiceCancelCheckVOs);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0220]
	 * modifyAccountingDetailPrepayApplyLineFlag<br>
	 * 
	 * @author ORKIM
	 * @category modifyAccountingDetailPrepayApplyLineFlag
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception EventException
	 */
	public void modifyAccountingDetailPrepayApplyLineFlag(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws EventException {
		try {
			if (accountingPaymentCheckVOs.size() > 0) {
				dbDao.modifyAccountingDetailPrepayApplyLineFlag(accountingPaymentCheckVOs);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0220]
	 * modifyAccountingDetailInvoiceLineRestore<br>
	 * 
	 * @author ORKIM
	 * @category modifyAccountingDetailInvoiceLineRestore
	 * @param List<APAccountingListVO> aPAccountingListVOs
	 * @exception EventException
	 */
	public void modifyAccountingDetailInvoiceLineRestore(List<APAccountingListVO> aPAccountingListVOs) throws EventException {
		try {
			if (aPAccountingListVOs.size() > 0) {
				dbDao.modifyAccountingDetailInvoiceLineRestore(aPAccountingListVOs);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0010] <br>
	 * searhAsaInfoList<br>
	 *
	 * @param String ofc_cd
	 * @param String inv_seq
	 * @param String inv_curr_cd
	 * @return List<AsaInfoVO>
	 * @exception EventException
	 */
	public List<AsaInfoVO> searhAsaInfoList(String ofc_cd, String inv_seq, String inv_curr_cd) throws EventException { 
		try {
	   		 return dbDao.searhAsaInfoList(ofc_cd, inv_seq, inv_curr_cd);  		
		}  catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}		
	}
	
	
	/**
	 * [STM_SAP_0010]
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchAsaIFTransYN
	 * @param String inv_seq
	 * @return String
	 * @exception EventException
	 */
	public String searchAsaIFTransYN(String inv_seq) throws EventException {
		try {
	   		 return dbDao.searchAsaIFTransYN(inv_seq);  		
		}  catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}		 
	 }
    
	/**
	 * [STM_SAP_0010] <br>
	 * searchOfficeRegionEnableVendorCheck<br>
	 *
	 * @param String ofcCd
	 * @param String vndrCd
	 * @return String
	 * @exception EventException
	 */
	public String searchOfficeRegionEnableVendorCheck(String ofcCd, String vndrCd) throws EventException { 
		try {
	   		 return dbDao.searchInvoiceInterfaceOfficeEnableVendorCheck(ofcCd, vndrCd);  		
		}  catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}		
	}
	
	/**
	 * [STM_SAP_0240] <br>
	 * searchOfficeRegionEnableVendorPrepayCheck<br>
	 *
	 * @param String ofcCd
	 * @param String vndrCd
	 * @return String
	 * @exception EventException
	 */
	public String searchOfficeRegionEnableVendorPrepayCheck(String ofcCd, String vndrCd) throws EventException { 
		try {
	   		 return dbDao.searchInvoiceInterfaceOfficeEnableVendorCheck(ofcCd, vndrCd);  		
		}  catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}		
	}
	
    /**
	 * [STM_SAP_0020]
	 * Invoice Approval List -  retrieve<br> 
	 * @author JBLEE
	 * @param String ofcCd
	 * @param String vndrNo
	 * @param String creDt
	 * @param String invNo
	 * @return List<InvoiceApprovalListVO>
	 * @exception EventException
    */    
    public List<InvoiceApprovalListVO> searchInvoiceApprovalList(String ofcCd, String vndrNo, String creDt, String invNo) throws EventException {
    	try {
    		 return dbDao.searchInvoiceApprovalList(ofcCd, vndrNo, creDt, invNo);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
     }
    
    /**
	 * [STM_SAP_0020]
	 * Invoice Approval<br> 
	 * @author JBLEE
	 * @param InvoiceApprovalInfoListVO[] invoiceApprovalInfoListVOs
	 * @param String lginUsrApOfc
	 * @param SignOnUserAccount account
	 * @exception EventException
    */    
    public void modifyInvoiceApprovalInfo(InvoiceApprovalInfoListVO[] invoiceApprovalInfoListVOs, String lginUsrApOfc, SignOnUserAccount account) throws EventException {
    	try {
    		 if (invoiceApprovalInfoListVOs != null ) {
    			 AccountPayableCommonBC command = new AccountPayableCommonBCImpl();
    			 List<InvoiceApprovalInfoListVO> modifyVoList = new ArrayList<InvoiceApprovalInfoListVO>();
    			 
    			 for (int i=0; i<invoiceApprovalInfoListVOs.length; i++) { 					
    				 invoiceApprovalInfoListVOs[i].setUsrId(account.getUsr_id());
    				 invoiceApprovalInfoListVOs[i].setLginUsrNm(account.getUsr_nm());
    				 invoiceApprovalInfoListVOs[i].setLginUsrApOfc(lginUsrApOfc);
    				 
    				 // 2016.05.23 Add validation of GL period 
    				 String ofc_cd = invoiceApprovalInfoListVOs[i].getOfcCd();
    				 String gl_dt = invoiceApprovalInfoListVOs[i].getGlDt();
    				 String inv_no = invoiceApprovalInfoListVOs[i].getInvNo();
    				 String rtnValue = "";
    				 rtnValue = command.searchInvoicesGLDatePeriodCheck(gl_dt, ofc_cd);
    				 
    				 if (rtnValue == null || rtnValue.equals("")) {
						throw new EventException(new ErrorHandler("COM12192", new String[]{"[NOTHING Period of GL Date]"}).getMessage());
    				 }	
					
    				 if (!rtnValue.equals("O")) {
						throw new EventException(new ErrorHandler("SAP00061", new String[]{gl_dt, inv_no}).getMessage());
    				 }

    				 modifyVoList.add(invoiceApprovalInfoListVOs[i]);
    			 }
    			 dbDao.modifyInvoiceApprovalInfo(modifyVoList);
    			 AccountPayablePaymentBC payCommand = new AccountPayablePaymentBCImpl();
    			 
    			//SAKURA I/F Call  (approval을 먼저 수행해야 함)
    			 for (int i=0; i<invoiceApprovalInfoListVOs.length; i++) { 					
    				 manageInterfaceSAP(invoiceApprovalInfoListVOs[i].getInvNo(),account.getUsr_id());
    				 
    				 //Manually ASA I/F 
    				 manageAsaClearingIF(invoiceApprovalInfoListVOs[i].getInvNo());
    				 
    				 //AP Invoice Accounting Call
    				 payCommand.manageAccountingCaptureCsrNo(invoiceApprovalInfoListVOs[i].getInvNo(),account.getUsr_id());
    			 }
    		 }
    	} catch (EventException ex) {
			if(ex.getMessage().indexOf("SAR00001") > 0) {
				 //throw new EventException("It's not available to create ASA Outstanding to SAR module. Please check Rep. Customer of Office. ", ex); 
				 throw new EventException(new ErrorHandler("CGM10003", new String[]{"It's not available to create ASA Outstanding to SAR module. Please check Rep. Customer of Office. \nData"}).getMessage());
			} else {
				throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			}
    	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
     }
    
    /**
	 * [STM_SAP_0020] [STM_SAP_0040]
	 * Invoice Cancel<br> 
	 * @author JBLEE
	 * @param InvoiceEntryListVO[] invoiceEntryListVOs
	 * @param String usrId
	 * @exception EventException
    */    
    public void manageInvoiceApprovalInfo(InvoiceEntryListVO[] invoiceEntryListVOs, String usrId) throws EventException {
    	try {
    		 String prdStsCd = "";
    		 String glDt = "";
    		 String invSeq = "";
    		 String ofcCd = "";
    		 String invCurrCd = "";
    		 String openASANo = "";

    		 if (invoiceEntryListVOs != null ) {
    			 List<InvoiceEntryListVO> insertVoList = new ArrayList<InvoiceEntryListVO>();
    			 List<InvoiceEntryListVO> modifyVoList = new ArrayList<InvoiceEntryListVO>();
    			 
    			 for (int i=0; i<invoiceEntryListVOs.length; i++) { 	
    				 
    				 glDt = invoiceEntryListVOs[i].getGlDt();
    				 invSeq = invoiceEntryListVOs[i].getInvSeq();
    				 ofcCd = invoiceEntryListVOs[i].getOfcCd();
    				 invCurrCd = invoiceEntryListVOs[i].getInvCurrCd();
    				 
    				 prdStsCd = dbDao.searchInvoiceCancelGLDateCheck(glDt);
    				 
    	    		 if (prdStsCd.equals("C")) {
    	    			 glDt = dbDao.searchInvoiceCancelNextGLDateCheck(glDt);
    	    		 }
    	    		 
    	    		 openASANo = dbDao.searhNextOpenedAsaCheckInfo(invSeq, ofcCd, invCurrCd);
    	    		 if (openASANo.equals("Y")) {
    	    			 invoiceEntryListVOs[i].setAttrCtnt5("");
    	    		 } else if (openASANo.equals("N")) {
    	    			 throw new EventException(new ErrorHandler("SAP00063", new String[]{ofcCd}).getMessage());
    	    		 } else {
    	    			 invoiceEntryListVOs[i].setAttrCtnt5(openASANo);
    	    		 }
    	    		 
    	    		 invoiceEntryListVOs[i].setGlDt(glDt);
    	    		 invoiceEntryListVOs[i].setUsrId(usrId);

    				 insertVoList.add(invoiceEntryListVOs[i]);
    				 modifyVoList.add(invoiceEntryListVOs[i]);   				 
    				 
    			 }
    			 
    			 dbDao.addInvoiceLineSelectInfo(modifyVoList);
    			 dbDao.modifyInvoiceHeaderCancelInfo(modifyVoList);
    			 dbDao.modifyInvoicePayScheduleCancelInfo(modifyVoList);
    			 
    			 for (int i=0; i<invoiceEntryListVOs.length; i++) { 	
    				 //Manually ASA I/F 
    				 manageAsaClearingIF(invoiceEntryListVOs[i].getInvNo());
    			 }
    		 }
    		 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
     }
     
    /**
	 *[STM_SAP_0040]
	 * CSR Receipt Entry - retrieve<br> 
	 * @author JBLEE
	 * @param InvoiceReceiptCondVO invoiceReceiptCondVO
	 * @return List<InvoiceReceiptListVO>
	 * @exception EventException
    */   
	public List<InvoiceReceiptListVO> searchInvoiceReceiptList(InvoiceReceiptCondVO invoiceReceiptCondVO) throws EventException {
    	try {
   		 return dbDao.searchInvoiceReceiptList(invoiceReceiptCondVO);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	
    /**
	 * [STM_SAP_0040]
	 * CSR Receipt Entry - Confirm<br> 
	 * @author JBLEE
	 * @param InvoiceReceiptListVO[] invoiceReceiptListVOs
	 * @param String lginUsrApOfc
	 * @param String loclTm  
	 * @param String usrId
	 * @exception EventException
    */    
    public void manageInvoiceReceiptInfo(InvoiceReceiptListVO[] invoiceReceiptListVOs, String lginUsrApOfc, String loclTm, String usrId) throws EventException {
    	try {
    		 String invRctNo  = "";
    		 String invCurrCd = "";
    		 String rctNoCmb  = "";
    		 String invSeq    = "";

    		 if (invoiceReceiptListVOs != null ) {
    			 
    			 for (int i=0; i<invoiceReceiptListVOs.length; i++) {
    				 
    				 invCurrCd = invoiceReceiptListVOs[i].getInvCurrCd();
    				 invSeq    = invoiceReceiptListVOs[i].getInvSeq();
    				  		 
    				 rctNoCmb = lginUsrApOfc + "G" +  invCurrCd + loclTm.substring(2);
    				 
    				 invRctNo = dbDao.searchInvoiceReceiptNumber(rctNoCmb);
    				 // SAP_INV_RCT Insert   				 
    				 dbDao.addInvoiceReceiptNoInfo(invRctNo, invSeq, usrId);
    				 // SAP_INV_HDR Update
    				 dbDao.modifyInvoiceReceiptInfo(invRctNo, invSeq, usrId);
    			 }
    		 }
    		 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
     }
    
    /**
	 * [STM_SAP_0040]
	 * CSR Receipt Entry - Release<br> 
	 * @author JBLEE
	 * @param InvoiceReceiptListVO[] invoiceReceiptListVOs
	 * @param String usrId
	 * @exception EventException
    */    
    public void modifyInvoiceReceiptReleaseInfo(InvoiceReceiptListVO[] invoiceReceiptListVOs, String usrId) throws EventException {
    	try {
    		 if (invoiceReceiptListVOs != null ) {
    			 List<InvoiceReceiptListVO> modifyVoList = new ArrayList<InvoiceReceiptListVO>();
    			 
    			 for (int i=0; i<invoiceReceiptListVOs.length; i++) { 	

    				 invoiceReceiptListVOs[i].setUsrId(usrId); 

    				 modifyVoList.add(invoiceReceiptListVOs[i]);
    			 }
    			 
    			 dbDao.modifyInvoiceReceiptReleaseInfo(modifyVoList);
    		 }
    		 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
     }
    
    /**
	 * [STM_SAP_0040]
	 * CSR Receipt Entry - save<br> 
	 * @author JBLEE
	 * @param InvoiceReceiptListVO[] invoiceReceiptListVOs
	 * @param String usrId
	 * @exception EventException
    */    
    public void manageInvoiceReceiptEntryInfo(InvoiceReceiptListVO[] invoiceReceiptListVOs, String usrId) throws EventException {
    	try {
   		 if (invoiceReceiptListVOs != null ) {
   			 List<InvoiceReceiptListVO> modifyVoList = new ArrayList<InvoiceReceiptListVO>();
   			 
   			 for (int i=0; i<invoiceReceiptListVOs.length; i++) { 	

   				 invoiceReceiptListVOs[i].setUsrId(usrId); 

   				 modifyVoList.add(invoiceReceiptListVOs[i]);
   			 }
   			 
   			 dbDao.modifyInvoiceReceiptEntryInvHeaderInfo(modifyVoList);
   			 dbDao.modifyInvoiceReceiptEntryPayScheduleInfo(modifyVoList);
   		 }
   		 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_B001]
	 * ASA Interface Update<br> 
	 * @author JBLEE
	 * @param List<InvoiceEntryLineListVO> invoiceEntryLineListVOs
	 * @exception EventException
    */    
    public void modifyASAInterfaceFlag(List<InvoiceEntryLineListVO> invoiceEntryLineListVOs) throws EventException {
    	try {
   		 if (invoiceEntryLineListVOs != null ) {
   			 dbDao.modifyASAInterfaceFlag(invoiceEntryLineListVOs);
   		 }
   		 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
	 * [STM_SAP_0030]
	 *  Invoice Slip - Invoice Header Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param InvoiceSlipCondVO invoiceSlipCondVO
	 * @param SignOnUserAccount account
	 * @return List<InvoiceSlipListVO>
	 * @exception EventException
	 */
    public List<InvoiceSlipListVO> searchInvoiceSlipList(InvoiceSlipCondVO invoiceSlipCondVO, SignOnUserAccount account) throws EventException {
    	try{
    		invoiceSlipCondVO.setUsrId(account.getUsr_id());
    		List<InvoiceSlipListVO> returnList = dbDao.searchInvoiceSlipList(invoiceSlipCondVO);
    		return returnList;
    		
    	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }
    
    /**
	 * [STM_SAP_0030]
	 *  Invoice Slip - Invoice Line (TAB) Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param String invSeq
	 * @param String invCurrCd 
	 * @return List<InvoiceSlipDetailListVO>
	 * @exception EventException
	 */
    public List<InvoiceSlipDetailListVO> searchInvoiceSlipDetailList(String invSeq, String invCurrCd) throws EventException {
    	try{
    		List<InvoiceSlipDetailListVO> returnList = dbDao.searchInvoiceSlipDetailList(invSeq, invCurrCd);
    		return returnList;
    	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }
    
    /**
	 * [STM_SAP_0030]
	 *  Invoice Slip - Invoice Payment (TAB) Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param String invSeq
	 * @return List<InvoiceSlipPaymentListVO>
	 * @exception EventException
	 */
    public List<InvoiceSlipPaymentListVO> searchInvoiceSlipPaymentList(String invSeq) throws EventException{
    	try{
    		List<InvoiceSlipPaymentListVO> returnList = dbDao.searchInvoiceSlipPaymentList(invSeq);
    		return returnList;
    		
    	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_0060]
	 *  Payment Entry Invoice & Skd 등록<br>
	 *
	 * @author sangyoung cha
	 * @param List<PaymentEntryLineVO> insertVoListLine
	 * @exception EventException
	 */   
	public void managePaymentInvSkd(List<PaymentEntryLineVO> insertVoListLine) throws EventException {
		try {
											
			dbDao.modifyPaymentInvoice(insertVoListLine);
			dbDao.modifyPaymentSchedule(insertVoListLine);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
    /**
	 * [STM_SAP_0060]
	 *  Payment Entry Invoice & Skd 취소 및 환원<br>
	 *
	 * @author sangyoung cha
	 * @param List<PaymentEntryLineVO> voidVoLineList
	 * @exception EventException
	 */ 
	public void managePaymentInvSkdCancel(List<PaymentEntryLineVO> voidVoLineList) throws EventException {
		try {
											
			dbDao.modifyInvoiceHeaderVoid(voidVoLineList); //취소 처리
			dbDao.modifyPaymentScheduleVoid(voidVoLineList); //취소 처리

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}	
    
	/**
	 * [STM_SAP_0340]
	 * Unsettled Summary에  전월 미결 자료 내역이 존재 여부 체크 <br>
	 * 
	 * @param String glDt
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchUnsettledAccountSummaryExistsCheck(String glDt) throws EventException {
		try {
			return dbDao.searchUnsettledAccountSummaryExistsCheck(glDt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
    /**
     * [STM_SAP_0340]
     * Unsettled Report By Account -  retrieve<br> 
     * @author sangyoung cha
     * @param UnsettledEntryCondVO unsettledEntryCondVO
     * @param SignOnUserAccount account
     * @return List<UnsettledAccountListVO>
     * @exception EventException
	*/    
    public List<UnsettledAccountListVO> searchUnsettledAccountList(UnsettledEntryCondVO unsettledEntryCondVO, SignOnUserAccount account) throws EventException{
    	try {  		
    		unsettledEntryCondVO.setUsrId(account.getUsr_id()); 
    		return dbDao.searchUnsettledAccountList(unsettledEntryCondVO);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    	
	
	/**
	 * [STM_SAP_0340]
	 * Capture 처리할 대상월의 Period가 닫혀 있는지를 확인 체크 <br>
	 * 
	 * @param String unstlYrmon
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO selectUnsettledAccountCapturePeriodCheck(String unstlYrmon) throws EventException {
		try {
			return dbDao.selectUnsettledAccountCapturePeriodCheck(unstlYrmon);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
    /**
	 * [STM_SAP_0340]
	 *  Unsettled Report By Account - capture <br>
	 *
	 * @author sangyoung cha
	 * @param String unstlYrmon
	 * @param String usrId
	 * @exception EventException
	 */    
    public void manageUnsettledAcctCaptureInfo(String unstlYrmon, String usrId) throws EventException {
		try {
			
			dbDao.removeUnsettledAccountCapture(unstlYrmon); 
			dbDao.addUnsettledAccountInvoiceSummary(unstlYrmon, usrId);
			dbDao.addUnsettledAccountPrepaymentInvoiceSummary(unstlYrmon, usrId);
			dbDao.addUnsettledAccountPaymentSummary(unstlYrmon, usrId);
			dbDao.addUnsettledAccountPrepaymentApplyPrepaySummary(unstlYrmon, usrId);
			dbDao.addUnsettledAccountPrepaymentApplyInvSummary(unstlYrmon, usrId);
			dbDao.addUnsettledAccountPreviousSummaryMoveNext(unstlYrmon, usrId);
			dbDao.modifyUnsettledAccountSummarySettle(unstlYrmon, usrId);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	
	
    /**
	 * [STM_SAP_0250]
	 *  SAP_IF_VALIDATE_IMPORT_CHECK <br>
	 *
	 * @author sangyoung cha
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceReqNumCheck() throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceReqNumCheck();
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_0250]
	 *  searchSapInvoiceInterfaceHeader <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return SapInvoiceInterfaceHeaderVO
	 * @exception EventException
	 */    
    public SapInvoiceInterfaceHeaderVO searchSapInvoiceInterfaceHeader(String csrNo) throws EventException {
		try {
			
			return dbDao.searchSapInvoiceInterfaceHeader(csrNo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_0250]
	 *  searchSoInvoiceInterfaceHeader <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @param String ifRequestSeq
	 * @return SapInvoiceInterfaceHeaderVO
	 * @exception EventException
	 */    
    public SapInvoiceInterfaceHeaderVO searchSoInvoiceInterfaceHeader(String csrNo, String ifRequestSeq) throws EventException {
		try {
			
			return dbDao.searchSoInvoiceInterfaceHeader(csrNo, ifRequestSeq);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    

    /**
	 * STM_SAP_0250 : interface batch
	 *  searchInvoiceLineNumDupCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceLineNumDupCheck(String csrNo) throws EventException {
		try {
			
			return dbDao.searchInvoiceLineNumDupCheck(csrNo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	    
    
    /**
     * [STM_SAP_0250]
     * searchSapInvoiceInterfaceDetail<br> 
     * @author sangyoung cha
     * @param String csrNo
     * @return List<SapInvoiceInterfaceDetailVO>
     * @exception EventException
	*/    
    public List<SapInvoiceInterfaceDetailVO> searchSapInvoiceInterfaceDetail(String csrNo) throws EventException{
    	try {  		
   		 	 return dbDao.searchSapInvoiceInterfaceDetail(csrNo);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    

    /**
     * [STM_SAP_0250]
     * searchSoInvoiceInterfaceDetail<br> 
     * @author sangyoung cha
     * @param String csrNo
     * @param String ifRequestSeq
     * @return List<SapInvoiceInterfaceDetailVO>
     * @exception EventException
	*/    
    public List<SapInvoiceInterfaceDetailVO> searchSoInvoiceInterfaceDetail(String csrNo, String ifRequestSeq) throws EventException{
    	try {  		
   		 	 return dbDao.searchSoInvoiceInterfaceDetail(csrNo, ifRequestSeq);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceDetailApIfSumAmtCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceDetailApIfSumAmtCheck(String csrNo) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceDetailApIfSumAmtCheck(csrNo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	    

    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceDetailSumAmtCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceDetailSumAmtCheck(String csrNo) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceDetailSumAmtCheck(csrNo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	
    
    /**
	 * [STM_SAP_0250]
	 *  manageAPInvoiceInterfaceResult <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @param String ifErrRsn
	 * @exception EventException
	 */    
    public void manageAPInvoiceInterfaceResult(String csrNo, String ifErrRsn) throws EventException {
		try {
			
			dbDao.modifyAPInvoiceInterfaceResult(csrNo, ifErrRsn); 
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
       
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceCurrUseCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String invAmt
	 * @param String invCurrCd
	 * @return SapCommonVO
	 * @exception EventException
	 */    
    public SapCommonVO searchInvoiceInterfaceCurrUseCheck(String invAmt, String invCurrCd) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceCurrUseCheck(invAmt, invCurrCd);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceCurrExchangeRateCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String glDt
	 * @param String invCurrCd
	 * @param String functionalCurrency
	 * @return SapCommonVO
	 * @exception EventException
	 */    
    public SapCommonVO searchInvoiceInterfaceCurrExchangeRateCheck(String glDt, String invCurrCd, String functionalCurrency) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceCurrExchangeRateCheck(glDt, invCurrCd, functionalCurrency);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceInvNODupCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String invNo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceInvNODupCheck(String invNo) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceInvNODupCheck(invNo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceFrontGLDateCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String glDt
	 * @param String glSystemDivFlg
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceFrontGLDateCheck(String glDt, String glSystemDivFlg, String ofcCd) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceFrontGLDateCheck(glDt, glSystemDivFlg, ofcCd);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	
    

    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceAPGLDateCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String glDt
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceAPGLDateCheck(String glDt) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceAPGLDateCheck(glDt);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceSupplierActiveCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String vndrNo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceSupplierActiveCheck(String vndrNo) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceSupplierActiveCheck(vndrNo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceTermsNameCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String invTermNm
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceTermsNameCheck(String invTermNm) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceTermsNameCheck(invTermNm);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceExchangeMethodCheck <br>
	 *
	 * @author Kyungsam Jo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceExchangeMethodCheck() throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceExchangeMethodCheck();
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceSystemSourceCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String ifSrcNm
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceSystemSourceCheck(String ifSrcNm) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceSystemSourceCheck(ifSrcNm);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	  
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheck <br>
	 *
	 * @author KS Jo
	 * @param String ifVndNo
	 * @param String ifCurrCd
	 * @param String ifLiabAcct
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheck(String ifVndNo, String ifCurrCd, String ifLiabAcct) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheck(ifVndNo, ifCurrCd, ifLiabAcct);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfacePaymentMethodCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String vndrNo
	 * @return SapCommonVO
	 * @exception EventException
	 */    
    public SapCommonVO searchInvoiceInterfacePaymentMethodCheck(String vndrNo) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfacePaymentMethodCheck(vndrNo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	     
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceApPaymentMethodCodeCheck <br>
	 *
	 * @author jo kyung sam
	 * @param String paymentMethod
	 * @return SapCommonVO
	 * @exception EventException
	 */    
    public SapCommonVO searchInvoiceInterfaceApPaymentMethodCodeCheck(String paymentMethod) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceApPaymentMethodCodeCheck(paymentMethod);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfacePayGroupExistsCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String payGrpLuCd
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfacePayGroupExistsCheck(String payGrpLuCd, String ofcCd) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfacePayGroupExistsCheck(payGrpLuCd, ofcCd);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	    
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceInterCompanyCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String liabCdCmbSeq
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceInterCompanyCheck(String liabCdCmbSeq) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceInterCompanyCheck(liabCdCmbSeq);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceVendorInterCompanyCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String vndrNo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceVendorInterCompanyCheck(String vndrNo) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceVendorInterCompanyCheck(vndrNo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	    
 
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceAccountAndVVDCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String liabCdCmbSeq
	 * @return SapCommonVO
	 * @exception EventException
	 */    
    public SapCommonVO searchInvoiceInterfaceAccountAndVVDCheck(String liabCdCmbSeq) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceAccountAndVVDCheck(liabCdCmbSeq);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }	
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceAccountAndVVDLevelCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String liabCoaAcctNo
	 * @param String liabCoaVvdCd
	 * @return SapCommonVO
	 * @exception EventException
	 */    
    public SapCommonVO searchInvoiceInterfaceAccountAndVVDLevelCheck(String liabCoaAcctNo, String liabCoaVvdCd) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceAccountAndVVDLevelCheck(liabCoaAcctNo, liabCoaVvdCd);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceCodeCombinationCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String liabCdCmbSeq
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceCodeCombinationCheck(String liabCdCmbSeq) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceCodeCombinationCheck(liabCdCmbSeq);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceCombineCombinationCheck <br>
	 *
	 * @author sangyoung cha
	 * @param SapCommonVO vo
	 * @return SapCommonVO
	 * @exception EventException
	 */    
    public SapCommonVO searchInvoiceInterfaceCombineCombinationCheck(SapCommonVO vo) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceCombineCombinationCheck(vo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 

    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceAPOfficeCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceAPOfficeCheck(String ofcCd) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceAPOfficeCheck(ofcCd);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceOfficeEnableVendorCheck <br>
	 *
	 * @author kyungsam jo
	 * @param String ofcCd
	 * @param String vndrCd
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceOfficeEnableVendorCheck(String ofcCd, String vndrCd) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceOfficeEnableVendorCheck(ofcCd, vndrCd);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfacePrepaymentAvailableCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String ppayInvNo
	 * @param String ppayInvLineNo
	 * @param String ppayAplyAmt
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfacePrepaymentAvailableCheck(String ppayInvNo, String ppayInvLineNo, String ppayAplyAmt) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfacePrepaymentAvailableCheck(ppayInvNo, ppayInvLineNo, ppayAplyAmt);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceASAOfficeCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceASAOfficeCheck(String ofcCd) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceASAOfficeCheck(ofcCd);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }   
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceASAMasterCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String attrCtnt2
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceASAMasterCheck(String attrCtnt2) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceASAMasterCheck(attrCtnt2);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceASAMasterCurrencyCheck <br>
	 *
	 * @author jo kyung sam
	 * @param String attrCtnt2
	 * @param String invCurrencyCode
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceASAMasterCurrencyCheck(String attrCtnt2, String invCurrencyCode) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceASAMasterCurrencyCheck(attrCtnt2, invCurrencyCode);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceASAClearingAccountCheck <br>
	 *
	 * @author jo kyung sam
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceASAClearingAccountCheck() throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceASAClearingAccountCheck();
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceAPClearingAcctCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceAPClearingAcctCheck(String csrNo) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceAPClearingAcctCheck(csrNo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceSOClearingAcctCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceSOClearingAcctCheck(String csrNo) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceSOClearingAcctCheck(csrNo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceLineCurrUseCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String dtrbAmt
	 * @param String invCurrCd
	 * @return SapCommonVO
	 * @exception EventException
	 */    
    public SapCommonVO searchInvoiceInterfaceLineCurrUseCheck(String dtrbAmt, String invCurrCd) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceLineCurrUseCheck(dtrbAmt, invCurrCd);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceLineInterCompanyCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String dtrbCdCmbSeq
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceLineInterCompanyCheck(String dtrbCdCmbSeq) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceLineInterCompanyCheck(dtrbCdCmbSeq);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
 
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceLineAccountAndVVDCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String dtrbCdCmbSeq
	 * @return SapCommonVO
	 * @exception EventException
	 */    
    public SapCommonVO searchInvoiceInterfaceLineAccountAndVVDCheck(String dtrbCdCmbSeq) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceLineAccountAndVVDCheck(dtrbCdCmbSeq);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceLineVndrInvNoDupCheckRSQL <br>
	 *
	 * @author sangyoung cha
	 * @param String vndrNo
	 * @param String csrNo
	 * @param String attrCtnt1
	 * @return String
	 * @exception EventException
	 */    
    public String searchInvoiceInterfaceLineVndrInvNoDupCheckRSQL(String vndrNo, String csrNo, String attrCtnt1) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceLineVndrInvNoDupCheckRSQL(vndrNo, csrNo, attrCtnt1);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceLineTaxCodeCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String dtrbVatCd
	 * @return SapCommonVO
	 * @exception EventException
	 */    
    public SapCommonVO searchInvoiceInterfaceLineTaxCodeCheck(String dtrbVatCd) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceLineTaxCodeCheck(dtrbVatCd);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    } 
    
    /**
	 * [STM_SAP_0250]
	 *  searchInvoiceInterfaceLineUnsettleAccountCheck <br>
	 *
	 * @author sangyoung cha
	 * @param String dtrbCoaAcctNo
	 * @return SapCommonVO
	 * @exception EventException
	 */    
    public SapCommonVO searchInvoiceInterfaceLineUnsettleAccountCheck(String dtrbCoaAcctNo) throws EventException {
		try {
			
			return dbDao.searchInvoiceInterfaceLineUnsettleAccountCheck(dtrbCoaAcctNo);
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }  
    
	/**
	 * [STM_SAP_0250]
	 * manageSapIfValidateImportCheck <br>
	 *
	 * @param SapInvoiceInterfaceHeaderVO headerVo
	 * @param List<SapInvoiceInterfaceDetailVO> lineVo
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageSapIfValidateImportCheck(SapInvoiceInterfaceHeaderVO headerVo, List<SapInvoiceInterfaceDetailVO> lineVo,  String usrId) throws EventException {
		try {
					
			// Header VO Insert 처리						
			if(!JSPUtil.getNull(headerVo.getInvXchRt()).equals("")) {				
				headerVo.setFunctionalAmount(JSPUtil.getNull(dbDao.searchInvoiceInterfaceFunctionalAmtCalculateCheck(headerVo.getInvAmt(), headerVo.getInvXchRt(), headerVo.getFunctionalCurrency())));
			}
			else {
				headerVo.setFunctionalAmount(headerVo.getInvAmt());
			}
			
			SapCommonVO vndrBankAcctInfo = dbDao.searchInvoiceInterfaceVendorBankAccountInfoCheck(headerVo.getInvCurrCd(), headerVo.getVndrNo());	
			//headerVo.setVndrBankAcctPrioCd(JSPUtil.getNull(vndrBankAcctInfo.getValue0()));
			headerVo.setVndrBankAcctSeq(JSPUtil.getNull(vndrBankAcctInfo.getValue1()));
			headerVo.setVndrBankAcctVndrNo(JSPUtil.getNull(vndrBankAcctInfo.getValue2()));
			
			String nextInvSeq = dbDao.searchNextInvSeq();
			headerVo.setInvSeq(nextInvSeq);
			headerVo.setUsrId(usrId);
			
			dbDao.addInvoiceInterfaceHeaderInfo(headerVo); // SAP_INV_HDR 저장
			dbDao.addInvoiceInterfacePayScheduleInfo(headerVo); // SAP_PAY_SKD 저장
			
			//Line Insert (Loop을 돌면서 또는 배열 변수로 처리)
			 SapInvoiceInterfaceDetailVO line 	= null;
			 int lineSize 						= lineVo.size();			 
			 BigDecimal lLineFunctionalTotalAmt = new BigDecimal("0");
			 BigDecimal lFunctionalLineAmt = new BigDecimal("0");
			 BigDecimal lFunctionalHeaderAmt = new BigDecimal("0");
			 BigDecimal lGainTotalAmt = new BigDecimal("0");
			 BigDecimal lLossTotalAmt = new BigDecimal("0");
			 for(int i=0; i<lineSize; i++) {
				 line = (SapInvoiceInterfaceDetailVO) lineVo.get(i);
				 
				 lineVo.get(i).setCreationUser(headerVo.getCreationUser());
				 
				 if(!JSPUtil.getNull(line.getExchangeRateType()).equals("LINE")) {
					 if(!JSPUtil.getNull(headerVo.getInvXchRt()).equals("")) {
						 line.setLineFunctionalAmount(JSPUtil.getNull(dbDao.searchInvoiceInterfaceFunctionalAmtCalculateCheck(line.getDtrbAmt(), headerVo.getInvXchRt(), headerVo.getFunctionalCurrency())));					 
						 lLineFunctionalTotalAmt = lLineFunctionalTotalAmt.add(new BigDecimal(line.getLineFunctionalAmount()));
					 }
					 else {
						 line.setLineFunctionalAmount(line.getDtrbAmt());
					 }
				 } else {
					 if(!JSPUtil.getNull(line.getDtrbXchRt()).equals("")) {
						line.setLineFunctionalAmount(JSPUtil.getNull(dbDao.searchInvoiceInterfaceFunctionalAmtCalculateCheck(line.getDtrbAmt(), line.getDtrbXchRt(), headerVo.getFunctionalCurrency())));
						lFunctionalLineAmt = new BigDecimal(JSPUtil.getNull(line.getLineFunctionalAmount()));
						lFunctionalHeaderAmt = new BigDecimal(JSPUtil.getNull(dbDao.searchInvoiceInterfaceFunctionalAmtCalculateCheck(line.getDtrbAmt(), headerVo.getInvXchRt(), headerVo.getFunctionalCurrency())));
 
						//Gain & Loss process
						if(Float.valueOf(JSPUtil.getNull(line.getDtrbXchRt())).compareTo(Float.valueOf(JSPUtil.getNull(headerVo.getInvXchRt()))) >= 0 ) {
							if(Float.parseFloat(JSPUtil.getNull(line.getDtrbAmt())) >= 0 ) {
								line.setDtrbFuncGainAmt((lFunctionalLineAmt.subtract(lFunctionalHeaderAmt)).abs().toString());
								lGainTotalAmt = lGainTotalAmt.add(lFunctionalLineAmt.subtract(lFunctionalHeaderAmt).abs());
							} else {
								line.setDtrbFuncLssAmt((lFunctionalLineAmt.subtract(lFunctionalHeaderAmt)).abs().toString());
								lLossTotalAmt = lLossTotalAmt.add(lFunctionalLineAmt.subtract(lFunctionalHeaderAmt).abs());
							}
						} else {
							if(Float.parseFloat(JSPUtil.getNull(line.getDtrbAmt())) >= 0 ) {
								line.setDtrbFuncLssAmt((lFunctionalLineAmt.subtract(lFunctionalHeaderAmt)).abs().toString());
								lLossTotalAmt = lLossTotalAmt.add(lFunctionalLineAmt.subtract(lFunctionalHeaderAmt).abs());
							} else {
								line.setDtrbFuncGainAmt((lFunctionalLineAmt.subtract(lFunctionalHeaderAmt)).abs().toString());
								lGainTotalAmt = lGainTotalAmt.add(lFunctionalLineAmt.subtract(lFunctionalHeaderAmt).abs());
							}
						}

						lLineFunctionalTotalAmt = lLineFunctionalTotalAmt.add(new BigDecimal(line.getLineFunctionalAmount()));
					 }
					 else {
						 line.setLineFunctionalAmount(line.getDtrbAmt());
					 }
				 }
				 
				 /*if(i == (lineSize - 1)) { // 마지막 Row인 경우
					 if(!JSPUtil.getNull(headerVo.getInvXchRt()).equals("")) {						 
						 line.setLInvRoundAmount((new BigDecimal(headerVo.getFunctionalAmount()).subtract(lLineFunctionalTotalAmt)).toString());
					 }
					 else {
						 line.setLInvRoundAmount(""); 
					 }
				 }*/
				 
				 line.setInvSeq(nextInvSeq);
				 line.setUsrId(usrId);	
				 line.setCreationUser(headerVo.getCreationUser());			
				
			 } // end for
			 
			 // 1번 Row에 Round 금액 처리
			 if(!JSPUtil.getNull(headerVo.getInvXchRt()).equals("")) {						 
				 lineVo.get(0).setLInvRoundAmount((new BigDecimal(headerVo.getFunctionalAmount()).subtract(lLineFunctionalTotalAmt).add(lGainTotalAmt).subtract(lLossTotalAmt)).toString());
			 }
			 else {
				 lineVo.get(0).setLInvRoundAmount(""); 
			 }
			 
			 //Line(Detail) Insert 
			 dbDao.addInvoiceInterfaceLineInfo(lineVo); //SAP_INV_DTL 저장
			 //Line의 비용 Item에 대한 국내 부가세 Tax 가 존재하는 경우 해당 Tax Code 정보를 Update 처리
			 dbDao.modifyInvoiceInterfaceVatCodeAllocateInvInfo(headerVo); //SAP_INV_DTL 수정
			 
			 //선급금 No을 갖고 있는 경우 해당 선급금 정보로 정산 처리
			 if(!JSPUtil.getNull(headerVo.getPpayInvNo()).equals("")) {
				 dbDao.addInvoiceInterfacePrepayApplyLineInfo(headerVo); //SAP_INV_DTL 등록
				 dbDao.modifyInvoiceInterfacePrepayApplyPayInvInfo(headerVo); //SAP_INV_HDR 수정
				 dbDao.modifyInvoiceInterfacePrepayApplyPayScheduleInfo(headerVo); //SAP_PAY_SKD 수정
				 dbDao.modifyInvoiceInterfacePrepayApplyPayPrepaymentInfo(headerVo); //SAP_INV_DTL 수정				 
			 }
			 
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		
	}	

    /**
	 * [STM_SAP_0250]
	 *  manageAPInvoiceInterfaceSucess <br>
	 *
	 * @author sangyoung cha
	 * @param String csrNo
	 * @exception EventException
	 */    
    public void manageAPInvoiceInterfaceSucess(String csrNo) throws EventException {
		try {
			
			dbDao.modifyAPInvoiceInterfaceSucess(csrNo); 
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }  
    
	/**
	 * [SAKURA I/F]
	 * manageInterfaceSAP <br>
	 * 
	 * @author ORKIM
	 * @category manageInterfaceSAP
	 * @param String csrNo
	 * @param String usr_id
	 * @exception EventException
	*/   
    public void manageInterfaceSAP(String csrNo, String usr_id) throws EventException {
    	
		try {
			
			InvoiceInterfaceSAPTypeCheckVO ifChkVO = dbDao.searchInvoiceInterfaceSAPTypeCheck(csrNo, usr_id); 
			String slip_if_seq = dbDao.searchInvoiceInterfaceSAPDaySeqCheck();
			
			ifChkVO.setSlipInterfaceSeq(slip_if_seq);
			ifChkVO.setUsrId(usr_id);

			String holdFlag 		= ifChkVO.getHoldFlag();
			String approvalFlag 	= ifChkVO.getApprovalFlag();
			String cancelFlag 		= ifChkVO.getCancelFlag();
			String accrualFlag 		= ifChkVO.getAccrualFlag();
			String slipType 		= ifChkVO.getSlipType();
			String asaFlag 			= ifChkVO.getAsaFlag();
			String invoiceType		= ifChkVO.getInvoiceType();
			int    prepayCnt 		= Integer.parseInt(ifChkVO.getPrepayCount());
			int    taxCnt  			= Integer.parseInt(ifChkVO.getTaxCount());
			int    itemTaxCnt  		= Integer.parseInt(ifChkVO.getItemTaxCount());
			String ppayRemainingFlag= ifChkVO.getPpayRemainingFlag();
			String ppayExDiffFlag   = ifChkVO.getPpayExDiffFlag();
			float  prepayroundamt   = Float.parseFloat(ifChkVO.getPrepayRound());
			String upstreamApplyFlag = ifChkVO.getUpstreamApply();
			String fullApplyFlag    = ifChkVO.getFullApplyFlag();
			
			if (!holdFlag.equals("Y") && approvalFlag.equals("Y") && cancelFlag.equals("N") && accrualFlag.equals("N") ) {
				if(slipType.equals("STANDARD NON JP") && asaFlag.equals("N")) {
					if (upstreamApplyFlag.equals("N")) {
						dbDao.addInterfaceSAPStandardNonJPDetailInfo(ifChkVO);
						dbDao.addInterfaceSAPStandardNonJPDetailOverseasTAXInfo(ifChkVO);
						if(prepayCnt > 0) {
							dbDao.addInterfaceSAPStandardNonJPDetailPrepayInfo(ifChkVO);
						}
						if(ppayRemainingFlag.equals("Y")) {
							dbDao.addInterfaceSAPStandardNonJPDetailOTSPrepayInfo(ifChkVO);
						}
						
						//2016.08.05 Partial Apply의 금액 선 적용
						if(prepayCnt > 0 && fullApplyFlag.equals("N")) {
							dbDao.modifyInterfaceSAPUpstreamStandardPartialApplyInfo(ifChkVO); //Apply금액에 대해서 Line의 Activity date 순으로 Apply 금액 적용 처리
						}
						if(ppayExDiffFlag.equals("Y")) {
							dbDao.addInterfaceSAPStandardNonJPDetailPrepayGainLossInfo(ifChkVO);
						} else if (prepayroundamt != 0) {
							dbDao.addInterfaceSAPStandardNonJPDetailPrepayRoundInfo(ifChkVO);
						}
						if(prepayCnt > 0 && fullApplyFlag.equals("N")) {
							dbDao.addInterfaceSAPStandardNonJPHeaderPrepayInfo(ifChkVO); // 건별 Liability 잔액에 대한 처리
							dbDao.addInterfaceSAPStandardNonJPHeaderPrepayGainLossInfo(ifChkVO); // Gain&Loss 존재하는 경우 처리
							dbDao.modifyInterfaceSAPStandardNonJPDRCRDiffInfo(ifChkVO); // 건별/합계 금액간 funcational amount 금액 Diff 조정
						} else if (taxCnt > 0 && itemTaxCnt > 0) {
							dbDao.addInterfaceSAPStandardNonJPHeaderTaxInfo(ifChkVO);
						} else if (prepayCnt == 0) {
							dbDao.addInterfaceSAPStandardNonJPHeaderOtherInfo(ifChkVO);
						}
					} else {
						if (fullApplyFlag.equals("Y")) {
							dbDao.addInterfaceSAPUpstreamStandardNonJPHeaderFullInfo(ifChkVO);
						} else {
							dbDao.modifyInterfaceSAPUpstreamStandardPartialApplyInfo(ifChkVO);
							dbDao.addInterfaceSAPUpstreamStandardNonJPHeaderPartialInfo(ifChkVO);
						}
						if(prepayCnt > 0) {
							dbDao.addInterfaceSAPStandardNonJPDetailPrepayInfo(ifChkVO);
						}
						if(ppayRemainingFlag.equals("Y")) {
							dbDao.addInterfaceSAPStandardNonJPDetailOTSPrepayInfo(ifChkVO);
						} 
						if (fullApplyFlag.equals("Y")) {
							if(ppayExDiffFlag.equals("Y")) {
								dbDao.addInterfaceSAPStandardNonJPDetailPrepayGainLossInfo(ifChkVO);
							} else if (prepayroundamt != 0) {
								dbDao.addInterfaceSAPStandardNonJPDetailPrepayRoundInfo(ifChkVO);
							}
						} else {
							String prepay_round_amt = dbDao.searchUpstreamInvoiceAccountedRoundCheck(csrNo);
							ifChkVO.setPrepayRound(prepay_round_amt);
							if(prepay_round_amt.equals("0")) {
								dbDao.addInterfaceSAPUpstreamStandardNonJPPrepayGainLossInfo(ifChkVO);
							} else {
								dbDao.addInterfaceSAPStandardNonJPDetailPrepayRoundInfo(ifChkVO);
							}
						}
					}
				} else if(slipType.equals("STANDARD JP") && asaFlag.equals("N")) {
					if (upstreamApplyFlag.equals("N")) {
						dbDao.addInterfaceSAPStandardJPDetailInfo(ifChkVO);
						if(prepayCnt > 0) {
							dbDao.addInterfaceSAPStandardJPDetailPrepayInfo(ifChkVO);
						} 
						if(ppayRemainingFlag.equals("Y")) {
							dbDao.addInterfaceSAPStandardJPDetailOTSPrepayInfo(ifChkVO);
						}
						
						//2016.08.05 Partial Apply의 금액 선 적용
						if(prepayCnt > 0 && fullApplyFlag.equals("N")) {
							dbDao.modifyInterfaceSAPUpstreamStandardPartialApplyInfo(ifChkVO); //Apply금액에 대해서 Line의 Activity date 순으로 Apply 금액 적용 처리
						}
						if(ppayExDiffFlag.equals("Y")) {
							dbDao.addInterfaceSAPStandardJPDetailPrepayGainLossInfo(ifChkVO);
						} else if (prepayroundamt != 0) {
							dbDao.addInterfaceSAPStandardJPDetailPrepayRoundInfo(ifChkVO);
						}
						if(prepayCnt > 0 && fullApplyFlag.equals("N")) {
							dbDao.addInterfaceSAPStandardJPHeaderPrepayInfo(ifChkVO); // 건별 Liability 잔액에 대한 처리
							dbDao.addInterfaceSAPStandardJPHeaderPrepayGainLossInfo(ifChkVO); // Gain&Loss 존재하는 경우 처리
							dbDao.modifyInterfaceSAPStandardNonJPDRCRDiffInfo(ifChkVO); // 건별/합계 금액간 funcational amount 금액 Diff 조정
						} else if (taxCnt > 0 && itemTaxCnt > 0) {
							dbDao.addInterfaceSAPStandardJPHeaderTaxInfo(ifChkVO);
						} else if (prepayCnt == 0) {
							dbDao.addInterfaceSAPStandardJPHeaderOtherInfo(ifChkVO);
						}
					} else {
						if (fullApplyFlag.equals("Y")) {
							dbDao.addInterfaceSAPUpstreamStandardJPHeaderFullInfo(ifChkVO);
						} else {
							dbDao.modifyInterfaceSAPUpstreamStandardPartialApplyInfo(ifChkVO);
							dbDao.addInterfaceSAPUpstreamStandardJPHeaderPartialInfo(ifChkVO);
						}
						if(prepayCnt > 0) {
							dbDao.addInterfaceSAPStandardJPDetailPrepayInfo(ifChkVO);
						} 
						if(ppayRemainingFlag.equals("Y")) {
							dbDao.addInterfaceSAPStandardJPDetailOTSPrepayInfo(ifChkVO);
						} 
						if (fullApplyFlag.equals("Y")) {
							if(ppayExDiffFlag.equals("Y")) {
								dbDao.addInterfaceSAPStandardJPDetailPrepayGainLossInfo(ifChkVO);
							} else if (prepayroundamt != 0) {
								dbDao.addInterfaceSAPStandardJPDetailPrepayRoundInfo(ifChkVO);
							}
						} else {
							String prepay_round_amt = dbDao.searchUpstreamInvoiceAccountedRoundCheck(csrNo);
							ifChkVO.setPrepayRound(prepay_round_amt);
							if(prepay_round_amt.equals("0")) {
								dbDao.addInterfaceSAPUpstreamStandardJPPrepayGainLossInfo(ifChkVO);
							} else {
								dbDao.addInterfaceSAPStandardJPDetailPrepayRoundInfo(ifChkVO);
							}
						}
					}
				} else if(slipType.equals("CREDIT NON JP") && asaFlag.equals("N")) {
					dbDao.addInterfaceSAPCreditNonJPDetailInfo(ifChkVO);
					dbDao.addInterfaceSAPCreditNonJPDetailOverseasTAXInfo(ifChkVO);
					if (taxCnt > 0 && itemTaxCnt > 0) {
						dbDao.addInterfaceSAPCreditNonJPHeaderTaxInfo(ifChkVO);
					} else {
						dbDao.addInterfaceSAPCreditNonJPHeaderOtherInfo(ifChkVO);
					}
				} else if(slipType.equals("CREDIT JP") && asaFlag.equals("N")) {
					dbDao.addInterfaceSAPCreditJPDetailInfo(ifChkVO);
					
					if (taxCnt > 0 && itemTaxCnt > 0) {
						dbDao.addInterfaceSAPCreditJPHeaderTaxInfo(ifChkVO);
					} else {
						dbDao.addInterfaceSAPCreditJPHeaderOtherInfo(ifChkVO);
					}
				} else if(slipType.equals("PREPAYMENT NON JP")) {
					dbDao.addInterfaceSAPPrepaymentNonJPDetailInfo(ifChkVO);
					dbDao.addInterfaceSAPPrepaymentNonJPHeaderInfo(ifChkVO);
				} else if(slipType.equals("PREPAYMENT JP")) {
					dbDao.addInterfaceSAPPrepaymentJPDetailInfo(ifChkVO);
					dbDao.addInterfaceSAPPrepaymentJPHeaderInfo(ifChkVO);
				} else if((invoiceType.equals("STANDARD") || invoiceType.equals("CREDIT")) && asaFlag.equals("Y")) {
					dbDao.addInterfaceSAPStandardASADetailInfo(ifChkVO);
					dbDao.addInterfaceSAPStandardASATaxLineInfo(ifChkVO);  // H5 TYpe의 Tax 추가 처리
					dbDao.addInterfaceSAPStandardASALineInfo(ifChkVO);
					dbDao.addInterfaceSAPStandardASAGainLossInfo(ifChkVO);
				} 
				//dbDao.modifyInterfaceSAPLocalAmtZeroNotInterfaceInfo(ifChkVO);
			}
			


		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}    	
    }
	/**
	 * [STM_SAP_0010]
	 * searchInvoiceLinePrepayCheck <br>
	 *
	 * @param String inv_seq
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceLinePrepayCheck(String inv_seq) throws EventException {
		try {
			return dbDao.searchInvoiceLinePrepayCheck(inv_seq);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
   /**
	 * SAKURA I/F for PAYMENT  
	 * modifyPaymentInvoice <br> 
	 * @author ORKIM
	 * @param List<PaymentEntryLineVO> payEntryLineVOList
	 * @exception EventException
   */ 
	public void modifyPaymentInvoice(List<PaymentEntryLineVO> payEntryLineVOList) throws EventException {
		try {
			if (payEntryLineVOList != null ) {
				dbDao.modifyPaymentInvoice(payEntryLineVOList);					
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
   /**
	 * SAKURA I/F for PAYMENT  
	 * modifyPaymentSchedule <br> 
	 * @author ORKIM
	 * @param List<PaymentEntryLineVO> payEntryLineVOList
	 * @exception EventException
   */ 
	public void modifyPaymentSchedule(List<PaymentEntryLineVO> payEntryLineVOList) throws EventException {
		try {
			if (payEntryLineVOList != null ) {
				dbDao.modifyPaymentSchedule(payEntryLineVOList);					
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * [STM_SAP_0250]
	 * searchSakuraInterfaceCSRInfo <br>
	 * 
	 * @param String invfromdt
	 * @param String invtodt
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public List<SapCommonVO> searchSakuraInterfaceCSRInfo(String invfromdt, String invtodt) throws EventException {
		try {
			return dbDao.searchSakuraInterfaceCSRInfo(invfromdt, invtodt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0150]
	 * SearchInvoiceAccrualList <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0150
	 * @category SearchInvoiceAccrualList
	 * @param InvoiceAccrualCondVO invoiceAccrualCondVO
	 * @return List<InvoiceAccrualVO>
	 * @exception EventException
	 */
	public List<InvoiceAccrualVO> searchInvoiceAccrualList(InvoiceAccrualCondVO invoiceAccrualCondVO) throws  EventException {
		try {
			return dbDao.searchInvoiceAccrualList(invoiceAccrualCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0150]
	 * ModifyAPManualInvoiceAccrualFlag <br>

	 * @category STM_SAP_0150
	 * @category modifyAPManualInvoiceAccrualFlag
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @exception EventException
	 */
	public void modifyAPManualInvoiceAccrualFlag(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws EventException {
		try {
			dbDao.modifyAPManualInvoiceAccrualFlag(aPManualInvoiceAccuralCondVO); 			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0150]
	 * ModifyAPManualInvoiceAccrualCancelFlag <br>

	 * @category STM_SAP_0150
	 * @category ModifyAPManualInvoiceAccrualCancelFlag
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @exception EventException
	 */
	public void modifyAPManualInvoiceAccrualCancelFlag(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws EventException {
		try {
			dbDao.modifyAPManualInvoiceAccrualCancelFlag(aPManualInvoiceAccuralCondVO); 			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0250]
	 * callSAKURAPaymentIF <br>
	 * 
	 * @author KSJO
	 * @category STM_SAP_0250
	 * @category callSAKURAPaymentIF
	 * @exception EventException
	 */
	public void callSAKURAPaymentIF() throws EventException{
		try {
			ScheduleUtil su = new ScheduleUtil();
			String batResult = su.directExecuteJob("STM_SAP_B002","");
			log.debug("callSAKURAPaymentIF Batch Porcess....." + batResult );
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"callSAKURAPaymentIF"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"callSAKURAPaymentIF"}).getMessage(),e);
		}
	}
	
	/**
	 * [STM_SAR_5002]
	 * callASAInvoiceInterface <br>
	 * 
	 * @author KSJO
	 * @category STM_SAR_5002
	 * @category callASAInvoiceInterface
	 * @exception EventException
	 */
	public void callASAInvoiceInterface() throws EventException{
		try {
			ScheduleUtil su = new ScheduleUtil();
			String batResult = su.directExecuteJob("STM_SAP_B001","");
			log.debug("callASAInvoiceInterface Batch Porcess....." + batResult );
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"callASAInvoiceInterface"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"callASAInvoiceInterface"}).getMessage(),e);
		}
	}
	
	/**
	 * [STM_SAR_5002]
	 * searchASAInvoiceUnInterfaceCheck <br>
	 *
	 * @author KSJO
	 * @param String asa_no
	 * @return String
	 * @exception EventException
	 */
	public String searchASAInvoiceUnInterfaceCheck(String asa_no) throws EventException {
		try {
			return dbDao.searchASAInvoiceUnInterfaceCheck(asa_no);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * Asa Clearing 대상 조회<br>
	 * 
	 * @author ORKIM
	 * @category manageAsaClearingIF
	 * @param String inv_no
	 * @exception EventException
	 */
	public void manageAsaClearingIF(String inv_no) throws EventException {
		try {
			
			Date Termsdate  = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Calendar cal = Calendar.getInstance();
			String chkAsaCnt = "";
			String AsaStatus = "";
			if(!inv_no.equals("BATCH")) {
				chkAsaCnt = dbDao.searchAsaClearingPreCheck(inv_no);
			} else {
				chkAsaCnt = "1";
			}
			
			if(chkAsaCnt != null && !chkAsaCnt.equals("0")) { 
			
				AccountReceivableOutstandingBC arCommand = new AccountReceivableOutstandingBCImpl();
				AccountReceivableCommonBC arCmd = new AccountReceivableCommonBCImpl();
				
				List<OutstandingInterfaceVO> insertVoList = new ArrayList<OutstandingInterfaceVO>();
				List<InvoiceEntryLineListVO> modifyVoList = new ArrayList<InvoiceEntryLineListVO>();
				
				if(!inv_no.equals("BATCH")) {
					AsaStatus = dbDao.searchAsaNoStatusCheckbyCSRNo(inv_no);
					if (AsaStatus.equals("C")) {
						throw new EventException(new ErrorHandler("SAP00064", new String[]{inv_no}).getMessage());
   	    		 	}
				}
				
				if(inv_no.equals("BATCH")) {
					inv_no = "";
				}
				
				List<AsaClearingVO> asaClearingVOs = dbDao.searchAsaClearingList(inv_no);
				
				if(asaClearingVOs != null && asaClearingVOs.size() > 0 ) {
					for(int i=0; i < asaClearingVOs.size(); i++ ) {
						OutstandingInterfaceVO outstandingInterfaceVo = new OutstandingInterfaceVO();
						InvoiceEntryLineListVO invoiceEntryLineListVO = new InvoiceEntryLineListVO();
									
						//String rowId           = asaClearingVOs.get(i).getRowId();
						//String invSeq          = asaClearingVOs.get(i).getInvSeq();
						String invNo           = asaClearingVOs.get(i).getInvNo();
						//String dtrbLineNo      = asaClearingVOs.get(i).getDtrbLineNo();
						String asaNo           = asaClearingVOs.get(i).getAsaNo();
						String invCurrCd       = asaClearingVOs.get(i).getInvCurrCd();
						//String apOfficeCode    = asaClearingVOs.get(i).getApOfficeCode();
						//String liabCdCmbSeq    = asaClearingVOs.get(i).getLiabCdCmbSeq();
						String asaOfficeCode   = asaClearingVOs.get(i).getAsaOfficeCode();
						//String asaAgentCode    = asaClearingVOs.get(i).getAsaAgentCode();
						String asaPeriodTo     = asaClearingVOs.get(i).getAsaPeriodTo();
						String asaCustCntCd    = asaClearingVOs.get(i).getAsaCustCntCd();
						String asaCustSeq      = asaClearingVOs.get(i).getAsaCustSeq();
						String asaCreditTerm   = asaClearingVOs.get(i).getAsaCreditTerm();
						//String asaCurrencyCode = asaClearingVOs.get(i).getAsaCurrencyCode();
						String asaLocationCode = asaClearingVOs.get(i).getAsaLocationCode();
						String asaArHqOffice   = asaClearingVOs.get(i).getAsaArHqOffice();
						String invDtrbSeq      = asaClearingVOs.get(i).getInvDtrbSeq();
						String dtrbAmt         = asaClearingVOs.get(i).getDtrbAmt();
						//String accountingDate  = asaClearingVOs.get(i).getAccountingDate();
						//String dtrbCdCmbSeq    = asaClearingVOs.get(i).getDtrbCdCmbSeq();
						//String sourceCode      = asaClearingVOs.get(i).getSourceCode();
						//String financeRegionCd = asaClearingVOs.get(i).getFinanceRegionCd();
						//String glCenterCd      = asaClearingVOs.get(i).getGlCenterCd();
						String arCurrCd        = asaClearingVOs.get(i).getArCurrCd();
						//String asaExpenseType  = asaClearingVOs.get(i).getAsaExpenseType();			
						//String repTpSrcCd      = asaClearingVOs.get(i).getRepTpSrcCd();
						String chgTpCd         = asaClearingVOs.get(i).getChgTpCd();
						String dueDate         = asaClearingVOs.get(i).getDueDate();
						String bkgIoFlag       = asaClearingVOs.get(i).getBkgIoFlag();
						String ifNo            = asaClearingVOs.get(i).getIfNo();
						String usrId           = asaClearingVOs.get(i).getUsrId();
						String revTpSrcCd      = asaClearingVOs.get(i).getRevTpSrcCd();
						
						log.debug("ASA Period Date of Before = "+asaPeriodTo);
						
						asaPeriodTo = arCmd.searchEffectiveDate(asaPeriodTo, asaOfficeCode, "35", "R");
						log.debug("ASA Period Date of After = "+asaPeriodTo);
						if(Integer.parseInt(asaCreditTerm) == 0 ) {
							dueDate = asaPeriodTo;
							log.debug("ASA Due Date of Terms Zero = "+dueDate);
						} else {
							Termsdate = sdf.parse(asaPeriodTo); 
							cal.setTime(Termsdate);
							cal.add(Calendar.DATE, Integer.parseInt(asaCreditTerm));
							dueDate = sdf.format(cal.getTime());
							log.debug("ASA Due Date of No Terms Zero = "+dueDate);
						}
										
						outstandingInterfaceVo.setIfNo(ifNo);
						outstandingInterfaceVo.setRhqCd(asaArHqOffice);
						outstandingInterfaceVo.setArOfcCd(asaOfficeCode);
						outstandingInterfaceVo.setCltOfcCd(asaOfficeCode);
						outstandingInterfaceVo.setBlNo(asaNo);
						outstandingInterfaceVo.setInvNo(asaNo);
						outstandingInterfaceVo.setOfcCurrCd(arCurrCd);
						outstandingInterfaceVo.setOtsSrcCd("STM AP");
						outstandingInterfaceVo.setBilToCustCntCd(asaCustCntCd);
						outstandingInterfaceVo.setBilToCustSeq(asaCustSeq);
						outstandingInterfaceVo.setShpToCustCntCd(asaCustCntCd);
						outstandingInterfaceVo.setShpToCustSeq(asaCustSeq);
						outstandingInterfaceVo.setBkgNo(asaNo);
						outstandingInterfaceVo.setVslCd("CNTC");
						outstandingInterfaceVo.setSkdVoyNo(asaPeriodTo.substring(2, 6));
						outstandingInterfaceVo.setDirCd("M");
						outstandingInterfaceVo.setTrnkVvdCd("CNTC"+asaPeriodTo.substring(2, 6)+"MM");   
						outstandingInterfaceVo.setLaneCd("CNT");
						outstandingInterfaceVo.setSailArrDt(asaPeriodTo);
						outstandingInterfaceVo.setBkgIoBndCd(bkgIoFlag);
						outstandingInterfaceVo.setPorCd(asaLocationCode);
						outstandingInterfaceVo.setPolCd(asaLocationCode);
						outstandingInterfaceVo.setPodCd(asaLocationCode);
						outstandingInterfaceVo.setDelCd(asaLocationCode);
						outstandingInterfaceVo.setDueDt(dueDate);
						outstandingInterfaceVo.setXchRtTpCd("A"); 
						outstandingInterfaceVo.setOtsRmk(invNo);
						outstandingInterfaceVo.setIfDt(asaPeriodTo);
						outstandingInterfaceVo.setTjSrcNm("AGENT");
						outstandingInterfaceVo.setChgTpCd(chgTpCd);
						outstandingInterfaceVo.setGlDt(asaPeriodTo);
						outstandingInterfaceVo.setBlCurrCd(invCurrCd);
						outstandingInterfaceVo.setOtsAmt(dtrbAmt);
						outstandingInterfaceVo.setRevTpSrcCd(revTpSrcCd);
						outstandingInterfaceVo.setCreUsrId(usrId);
						outstandingInterfaceVo.setUpdUsrId(usrId);
						outstandingInterfaceVo.setSvcScpCd("OTH");
						
						insertVoList.add(outstandingInterfaceVo);
						
						invoiceEntryLineListVO.setInvDtrbSeq(invDtrbSeq);
						invoiceEntryLineListVO.setUsrId(usrId);
						
						modifyVoList.add(invoiceEntryLineListVO);
					}
				}
				
				
				if (insertVoList.size() > 0) {
					arCommand.addOutstandingInterface(insertVoList);
					modifyASAInterfaceFlag(modifyVoList);
					
					for (int i = 0; i < insertVoList.size(); i++) {
						String ifNo = insertVoList.get(i).getIfNo();
						arCommand.createOutstandingByInterface(ifNo);
					}
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [CSR I/F - Approval]
	 * searchCSRNoDupChk <br>
	 *
	 * @author OKRYEKIM
	 * @param String csr_no
	 * @return String
	 * @exception EventException
	 */
	public String searchCSRNoDupChk(String csr_no) throws EventException {
		try {
			return dbDao.searchCSRNoDupChk(csr_no);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}	
        
}