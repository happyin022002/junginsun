/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentBCImpl.java
*@FileTitle : AccountPayablePaymentBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
* 2014.03.14
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.basic;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBC;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBCImpl;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBC;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBCImpl;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration.AccountPayablePaymentDBDAO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APTransactionCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APTransactionVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingDetailValidateInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCancelCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingPaymentCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingPaymentLineCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankAccountAdjustmentListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankBalanceAdjustmentListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankBalanceByOfficeCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankBalanceByOfficeVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentDetailCurrSumListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentEntryLineVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentEntryVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentScheduleCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentScheduleListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentDetailListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipLineListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchSelectedListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchEntryVendorSumInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APAccountingListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentProcessListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentCSRInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentCompleteCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentBANKExistsCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentBANKInfoCheckVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBC;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBCImpl;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.LedgerCodeCombinationListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;


/**
 * OPUS-SAP AccountPayablePaymentBC Business Logic Command Interface<br>
 *
 * @author ORKIM
 * @see AccountPayablePaymentSC 
 * @since J2EE 1.6
 */	
public class AccountPayablePaymentBCImpl extends BasicCommandSupport implements AccountPayablePaymentBC {	
	
	// Database Access Object
    private transient AccountPayablePaymentDBDAO dbDao = null;    
    
    public AccountPayablePaymentBCImpl() {
        dbDao = new AccountPayablePaymentDBDAO();        
    }
	
    /**
	 * [STM_SAP_0050] Retrieve<br>
	 * Payment Schedule Inquiry - retrieve<br>
	 * @author hannah lee
	 * @param PaymentScheduleCondVO paymentScheduleCondVO
	 * @return List<PaymentScheduleListVO> 
	 * @exception EventException
	 */    
    public List<PaymentScheduleListVO> searchPaymentScheduleList(PaymentScheduleCondVO paymentScheduleCondVO) throws EventException {
    	try {
    		List<PaymentScheduleListVO> returnList = dbDao.searchPaymentScheduleList(paymentScheduleCondVO);
   		
    		return returnList;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_0070] Retrieve<br>
	 * Payment Slip - Payment retrieve<br>
	 * @author hannah lee
	 * @param PaymentSlipCondVO paymentSlipCondVO
	 * @return List<PaymentSlipListVO> 
	 * @exception EventException
	 */
    public List<PaymentSlipListVO> searchPaymentSlipList(PaymentSlipCondVO paymentSlipCondVO) throws EventException {
    	try {
    		List<PaymentSlipListVO> returnList = dbDao.searchPaymentSlipList(paymentSlipCondVO);
    		
    		return returnList;
    	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * [STM_SAP_0070]  Retrieve<br>
	 * Payment Slip - Payment Detail retrieve<br>
	 * @author hannah lee
	 * @param String paySeq
	 * @return List<PaymentSlipLineListVO> 
	 * @exception EventException
	 */
    public List<PaymentSlipLineListVO> searchPaymentSlipLineList(String paySeq) throws EventException {
    	try {
    		List<PaymentSlipLineListVO> returnList = dbDao.searchPaymentSlipLineList(paySeq);
    		
    		return returnList;
    	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }
    
    /**
	 * [STM_SAP_0130] Retrieve<br>
	 * Inquiry of Bank Balance - retrieve<br>
	 * @author hannah lee
	 * @param BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO
	 * @return List<BankBalanceByOfficeVO> 
	 * @exception EventException
	 */    
    public List<BankBalanceByOfficeVO> searchBankBalanceByOffice(BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO) throws EventException {
    	try {
    		List<BankBalanceByOfficeVO> returnList = dbDao.searchBankBalanceByOffice(bankBalanceByOfficeCondVO);
   		
    		return returnList;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }


	/**
     * [STM_SAP_0330] Retrieve
     * Payment Detail Inquiry <br>
     * @author sangyoung cha
     * @param PaymentDetailListVO paymentDetailListVO 
     * @return List<PaymentDetailListVO>
     * @throws EventException
     */	    
    public List<PaymentDetailListVO> searchPaymentDetailList(PaymentDetailListVO paymentDetailListVO) throws EventException {
    	try {
    		List<PaymentDetailListVO> returnList = dbDao.searchPaymentDetailList(paymentDetailListVO);
   		
    		return returnList;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
	/**
     * [STM_SAP_0330]
     * Payment Detail Inquiry Current Sum<br>
     * @author sangyoung cha
     * @param PaymentDetailCurrSumListVO paymentDetailCurrSumListVO
     * @return List<PaymentDetailCurrSumListVO>
     * @throws EventException
     */	
    public List<PaymentDetailCurrSumListVO> searchPaymentDetailCurrSumList(PaymentDetailCurrSumListVO paymentDetailCurrSumListVO) throws EventException {
    	try {
    		List<PaymentDetailCurrSumListVO> returnList = dbDao.searchPaymentDetailCurrSumList(paymentDetailCurrSumListVO);
   		
    		return returnList;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }   
    
	/**
     * [STM_SAP_0060]
     * Payment Entry List<br>
     * @author sangyoung cha
     * @param PaymentEntryVO paymentEntryVO
     * @return List<PaymentEntryVO>
     * @throws EventException
     */	
    public List<PaymentEntryVO> searchPaymentEntryList(PaymentEntryVO paymentEntryVO) throws EventException {
    	try {
    		List<PaymentEntryVO> returnList = dbDao.searchPaymentEntryList(paymentEntryVO);
   		
    		return returnList;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }  
    

	/**
     * [STM_SAP_0060]
     * Payment Entry Line List<br>
     * @author sangyoung cha
     * @param String paySeq  
     * @return List<PaymentEntryLineVO>
     * @throws EventException
     */	
    public List<PaymentEntryLineVO> searchPaymentEntryLineList(String paySeq) throws EventException {
    	try {
    		List<PaymentEntryLineVO> returnList = dbDao.searchPaymentEntryLineList(paySeq);
   		
    		return returnList;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }  
    
	/**
	 * [STM_SAP_0060]
	 * searchLineVendorPaymentNoDupCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return SapCommonVO
	 * @exception EventException
	*/
	public SapCommonVO searchLineVendorPaymentNoDupCheck(SapCommonVO sapCommonVO) throws EventException {
		try {
			SapCommonVO rtnVO = dbDao.searchLineVendorPaymentNoDupCheck(sapCommonVO);  		
   		 return rtnVO;    		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
	}	
	

	
	/**
	 * [STM_SAP_0060]
	 * Payment list save<br>
	 *
	 * @param PaymentEntryVO[] paymentEntryVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String managePaymentEntryInfo(PaymentEntryVO[] paymentEntryVOs, SignOnUserAccount account) throws EventException {
		try {
			
			String paySeq = "";					
			String payNo = "";					
		
			List<PaymentEntryVO> insertVoList = new ArrayList<PaymentEntryVO>();
			List<PaymentEntryVO> updateVoList = new ArrayList<PaymentEntryVO>();
			List<PaymentEntryVO> deleteVoList = new ArrayList<PaymentEntryVO>();
			
			for (int i=0; i<paymentEntryVOs.length; i++) {
				
				if(paymentEntryVOs[i].getChkFlg().equals("1")) {
					paymentEntryVOs[i].setUsrId(account.getUsr_id());
					paySeq = paymentEntryVOs[i].getPaySeq();						
					
					if (paymentEntryVOs[i].getIbflag().equals("I")) {
						// setting next pay_seq
						paySeq = dbDao.searchNextPaySeq();
						paymentEntryVOs[i].setPaySeq(paySeq);							
						// setting next pay_no
						payNo = dbDao.searchNextPayNo(paymentEntryVOs[i].getPayMzdLuCd());
						paymentEntryVOs[i].setPayNo(payNo);
													
						insertVoList.add(paymentEntryVOs[i]);
					} else if (paymentEntryVOs[i].getIbflag().equals("U")) {						
						updateVoList.add(paymentEntryVOs[i]);
					} else if (paymentEntryVOs[i].getIbflag().equals("D")) {						
						deleteVoList.add(paymentEntryVOs[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.modifyNextPayNo(insertVoList);
				dbDao.addPaymentHeader(insertVoList);				
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyPaymentHeader(updateVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removePaymentHeader(deleteVoList);
			}
		
			return paySeq;	

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	

	/**
	 * [STM_SAP_0060]
	 * Payment list Line save<br>
	 *
	 * @param List<PaymentEntryLineVO> insertVoListLine
	 * @param List<PaymentEntryLineVO> updateVoListLine
	 * @param List<PaymentEntryLineVO> deleteVoListLine
	 * @exception EventException
	 */
	public void managePaymentEntryLineInfo(List<PaymentEntryLineVO> insertVoListLine, List<PaymentEntryLineVO> updateVoListLine, List<PaymentEntryLineVO> deleteVoListLine) throws EventException {
		try {
			
			if (insertVoListLine.size() > 0) {
				dbDao.addPaymentLine(insertVoListLine);										
			}
			if (updateVoListLine.size() > 0) {
				dbDao.modifyPaymentLine(updateVoListLine);
			}
			if (deleteVoListLine.size() > 0) {
				dbDao.removePaymentLine(deleteVoListLine);
			}												

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}	
	
	/**
	 * [STM_SAP_0060]
	 * searchPaymentStatusCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return String
	 * @exception EventException
	*/
	public String searchPaymentStatusCheck(SapCommonVO sapCommonVO) throws EventException {
		try {
		
			return dbDao.searchPaymentStatusCheck(sapCommonVO);  		
   		     		
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getUserMessage());
		}
	}		
	
	
	/**
	 * [STM_SAP_0060]
	 * Payment list delete<br>
	 *
	 * @param PaymentEntryVO[] paymentEntryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removePaymentEntryInfo(PaymentEntryVO[] paymentEntryVOs, SignOnUserAccount account) throws EventException {
		try {
			
											
			List<PaymentEntryVO> deleteVoList = new ArrayList<PaymentEntryVO>();
			
			for (int i=0; i<paymentEntryVOs.length; i++) {
				
				if(paymentEntryVOs[i].getChkFlg().equals("1")) {
					paymentEntryVOs[i].setUsrId(account.getUsr_id());
					deleteVoList.add(paymentEntryVOs[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removePaymentHeader(deleteVoList);
				dbDao.removePaymentLineByPaySeq(deleteVoList);					
			}
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
				
	}
		

	/**
	 * [STM_SAP_0060]
	 * Payment list void<br>
	 *
	 * @param PaymentEntryVO[] paymentEntryVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePaymentEntryVoid(PaymentEntryVO[] paymentEntryVOs, SignOnUserAccount account) throws EventException {
		try {
			
			if (paymentEntryVOs != null ) {
								
				List<PaymentEntryVO> voidVoList = new ArrayList<PaymentEntryVO>();
				
				for (int i=0; i<paymentEntryVOs.length; i++) {
					
					if(paymentEntryVOs[i].getChkFlg().equals("1")) {
						paymentEntryVOs[i].setUsrId(account.getUsr_id());
						voidVoList.add(paymentEntryVOs[i]);
					}
				}

				if (voidVoList.size() > 0) {
					dbDao.modifyPaymentHeaderVoid(voidVoList);
					dbDao.modifyPaymentLineVoidRvsFlg(voidVoList);
					dbDao.addPaymentLineVoid(voidVoList);	
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
	* searchPaymentBatchList<br>
	*
	* @param PaymentBatchCondVO paymentBatchCondVO
	* @return List<PaymentBatchListVO>
	* @exception EventException
	*/
	public List<PaymentBatchListVO> searchPaymentBatchList(PaymentBatchCondVO paymentBatchCondVO) throws EventException {
    	try {
    		List<PaymentBatchListVO> returnList = dbDao.searchPaymentBatchList(paymentBatchCondVO);
   		
    		return returnList;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
		
	
	/**
	* [STM_SAP_0210]
	* searchPaymentBatchSelectedList<br>
	*
	* @param String pay_bat_seq
	* @param String pay_bat_nm
	* @return List<PaymentBatchSelectedListVO>
	* @exception EventException
	*/
	public List<PaymentBatchSelectedListVO> searchPaymentBatchSelectedList(String pay_bat_seq, String pay_bat_nm) throws EventException {
    	try {
    		List<PaymentBatchSelectedListVO> returnList = dbDao.searchPaymentBatchSelectedList(pay_bat_seq, pay_bat_nm );
   		
    		return returnList;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
		 
	/**
	* [STM_SAP_0210]
	* searchPaymentPossibleInvoiceList<br>
	*
	* @param String inv_no
	* @param String pay_bat_seq
	* @param String pay_bat_nm
	* @return List<PaymentBatchSelectedListVO>
	* @exception EventException
	*/
	public List<PaymentBatchSelectedListVO> searchPaymentPossibleInvoiceList(String inv_no, String pay_bat_seq, String pay_bat_nm) throws EventException {
    	try {
    		List<PaymentBatchSelectedListVO> returnList = dbDao.searchPaymentPossibleInvoiceList(inv_no, pay_bat_seq, pay_bat_nm );
   		
    		return returnList;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	* [STM_SAP_0210]
	* searchPaymentBatchUniqueCheck<br>
	*
	* @param String pay_bat_nm
	* @return String
	* @exception EventException
	*/
	public String searchPaymentBatchUniqueCheck(String pay_bat_nm) throws EventException {
    	try {
    		String returnStr = dbDao.searchPaymentBatchUniqueCheck(pay_bat_nm );
   		
    		return returnStr;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	* [STM_SAP_0210]
	* searchPaymentBatchNameDupCheck<br>
	*
	* @param String pay_bat_nm
	* @return String
	* @exception EventException
	*/
	public String searchPaymentBatchNameDupCheck(String pay_bat_nm) throws EventException {
    	try {
    		String returnStr = dbDao.searchPaymentBatchNameDupCheck(pay_bat_nm );
   		
    		return returnStr;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	* [STM_SAP_0210]
	* selectPaymentProcessDupCheck<br>
	*
	* @param String bank_acct_seq
	* @param String pay_mzd_lu_cd
	* @return String
	* @exception EventException
	*/
	public String selectPaymentProcessDupCheck(String bank_acct_seq, String pay_mzd_lu_cd) throws EventException {
    	try {
    		String returnStr = dbDao.selectPaymentProcessDupCheck(bank_acct_seq, pay_mzd_lu_cd );
   		
    		return returnStr;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [STM_SAP_0210]
	 * managePaymentBatchEntryInfo<br>
	 *
	 * @param PaymentBatchListVO[] paymentBatchListVOs
	 * @param SignOnUserAccount account
	 * @return String pay_bat_seq
	 * @exception EventException
	 */
	public String managePaymentBatchEntryInfo(PaymentBatchListVO[] paymentBatchListVOs, SignOnUserAccount account) throws EventException {
		String pay_bat_seq = "";
		try {
			
			if (paymentBatchListVOs != null ) {
				
				List<PaymentBatchListVO> addVoList = new ArrayList<PaymentBatchListVO>();
				List<PaymentBatchListVO> modVoList = new ArrayList<PaymentBatchListVO>();
				List<PaymentBatchEntryVendorSumInfoVO> detailVoList = new ArrayList<PaymentBatchEntryVendorSumInfoVO>();
				for (int i=0; i<paymentBatchListVOs.length; i++) {
					if(paymentBatchListVOs[i].getIbflag().equals("I")) {
						//Dup check : batch name
						if ( paymentBatchListVOs[i].getPayBatNm().equals(dbDao.searchPaymentBatchNameDupCheck(paymentBatchListVOs[i].getPayBatNm()))) {
							throw new EventException(new ErrorHandler("SAP00004", new String[]{paymentBatchListVOs[i].getPayBatNm()}).getMessage());
						}
						
						pay_bat_seq = dbDao.selectPaymentBatchEntryIDSeqCheck();
						paymentBatchListVOs[i].setPayBatSeq(pay_bat_seq);
						paymentBatchListVOs[i].setUsrId(account.getUsr_id());
						addVoList.add(paymentBatchListVOs[i]);
					} else if(paymentBatchListVOs[i].getIbflag().equals("D")) {
						paymentBatchListVOs[i].setUsrId(account.getUsr_id());
						modVoList.add(paymentBatchListVOs[i]);
						
						PaymentBatchEntryVendorSumInfoVO tempVO = new PaymentBatchEntryVendorSumInfoVO();
						tempVO.setPayBatSeq(paymentBatchListVOs[i].getPayBatSeq());
						tempVO.setPayBatNm(paymentBatchListVOs[i].getPayBatNm());
						detailVoList.add(tempVO);
					}
				}
				
				if (addVoList.size() > 0) {
					dbDao.addPaymentBatchEntryInfo(addVoList);
				}
				
				if (modVoList.size() > 0) {
					dbDao.removePaymentSelectedInvoiceAllInfo(detailVoList);
					dbDao.removePaymentBatchEntryInfo(modVoList);						
				}
			}
			
			return pay_bat_seq;

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
					dbDao.addPaymentSelectedInvoiceInfo(addVoList);
				}
				if (modVoList.size() > 0) {
					dbDao.removePaymentSelectedInvoiceInfo(modVoList);
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
	 * @return String
	 * @exception EventException
	 */
	public String managePaymentCaptureInfo(PaymentBatchListVO[] paymentBatchListVOs, PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs, String fCurrCd, SignOnUserAccount account) throws EventException {
		String updStsCd = "CAPTURE";
		
		try {
			
			if ( paymentBatchListVOs != null ) {
				
				List<PaymentBatchListVO> addVoList = new ArrayList<PaymentBatchListVO>();
				
				for (int i=0; i<paymentBatchListVOs.length; i++) {
					paymentBatchListVOs[i].setUsrId(account.getUsr_id());
					paymentBatchListVOs[i].setPayDt(paymentBatchListVOs[0].getPayDt());
					paymentBatchListVOs[i].setFunctionalCurrency(fCurrCd);
					paymentBatchListVOs[i].setUpdPayStsCd("CAPTURE");
					addVoList.add(paymentBatchListVOs[i]);
				}

				if (addVoList.size() > 0) {
					int cnt = 0;
					
					cnt = Integer.parseInt(dbDao.searchPayCaptureSelectedInvoiceInfoCount(addVoList));
					
					if (cnt == 0) {
						updStsCd = "CANCELLED NO PAYMENTS";
						for (int i=0; i<paymentBatchListVOs.length; i++) {
							paymentBatchListVOs[i].setUpdPayStsCd("CANCELLED NO PAYMENTS");
						}
					} else {
						dbDao.addPayCaptureSelectedInvoiceInfo(addVoList);
					}
					
					dbDao.modifyPaymentCaptureStatusChangeInfo(addVoList);
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
		
		return updStsCd;
	}
	
	
	/**
	 * [STM_SAP_0210]
	 * managePaymentConfirmInfo<br>
	 *
	 * @param PaymentBatchListVO[] paymentBatchListVOs
	 * @param PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs
	 * @param String fCurrCd
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int managePaymentConfirmInfoCheck(PaymentBatchListVO[] paymentBatchListVOs, PaymentBatchSelectedListVO[] paymentBatchSelectedListVOs, String fCurrCd, SignOnUserAccount account) throws EventException {
		
		int cntBat = 0;
		try {
			
			if ( paymentBatchListVOs != null ) {
				cntBat = Integer.parseInt( dbDao.selectPaymentSelectedInvoiceExistsCheck(paymentBatchListVOs[0].getPayBatSeq(), paymentBatchListVOs[0].getPayBatNm()) );
				
				if(cntBat <= 0 ) {
					List<PaymentBatchListVO> addVoList = new ArrayList<PaymentBatchListVO>();
					addVoList.add(paymentBatchListVOs[0]);
					dbDao.modifyPaymentBatchEntryEndInfo(addVoList);
				}
					
			}
			return cntBat;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	* [STM_SAP_0210]
	* searchPaymentBatchEntryVendorSumInfo<br>
	*
	* @param String pay_bat_seq
	* @param String pay_bat_nm
	* @return List<PaymentBatchEntryVendorSumInfoVO>
	* @exception EventException
	*/
	public List<PaymentBatchEntryVendorSumInfoVO> searchPaymentBatchEntryVendorSumInfo(String pay_bat_seq, String pay_bat_nm) throws EventException {
    	try {
    		List<PaymentBatchEntryVendorSumInfoVO> returnList = dbDao.searchPaymentBatchEntryVendorSumInfo(pay_bat_seq, pay_bat_nm);
   		
    		return returnList;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}	
	
	/**
	 * [STM_SAP_0210]
	 * managePaymentConfirmInfo<br>
	 *
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList
	 * @param String functional_currency
	 * @param SignOnUserAccount account
	 * @return List<PaymentBatchEntryVendorSumInfoVO>
	 * @exception EventException
	 */
	public List<PaymentBatchEntryVendorSumInfoVO>  managePaymentConfirmInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList, String functional_currency, SignOnUserAccount account) throws EventException {
		
		String next_pay_seq = "";

		try {
			for (int i=0; i<paymentBatchEntryVendorSumInfoVOList.size(); i++) {
				next_pay_seq = dbDao.selectBatchPaymentHeaderIDSeqCheck();
				paymentBatchEntryVendorSumInfoVOList.get(i).setPaySeq(next_pay_seq);
				paymentBatchEntryVendorSumInfoVOList.get(i).setLoopIndex( (i+1)+"");
				paymentBatchEntryVendorSumInfoVOList.get(i).setUsrId(account.getUsr_id());
				paymentBatchEntryVendorSumInfoVOList.get(i).setFunctionalCurrency(functional_currency);
			}
			
			if (paymentBatchEntryVendorSumInfoVOList.size() > 0) {
				dbDao.addBatchPaymentHeaderAllInfo(paymentBatchEntryVendorSumInfoVOList);
				dbDao.addBatchPaymentDetailAllInfo(paymentBatchEntryVendorSumInfoVOList);
				dbDao.modifyPaymentBatchEntryCompleteInfo(paymentBatchEntryVendorSumInfoVOList);
			}

			return paymentBatchEntryVendorSumInfoVOList;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * [STM_SAP_0210]
	 * removePaymentSelectedInvoiceAllInfo<br>
	 *
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList
	 * @exception EventException
	 */
	public void  removePaymentSelectedInvoiceAllInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVOList) throws EventException {
		try {
			if (paymentBatchEntryVendorSumInfoVOList.size() > 0) {
				dbDao.removePaymentSelectedInvoiceAllInfo(paymentBatchEntryVendorSumInfoVOList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	* [STM_SAP_0220]
	* searchAPAccountingList<br>
	*
	* @param AccountingCondVO accountingCondVO
	* @return List<APAccountingListVO>
	* @exception EventException
	*/
	public List<APAccountingListVO> searchAPAccountingList(AccountingCondVO accountingCondVO) throws EventException {
    	try {
    		List<APAccountingListVO> returnList = dbDao.searchAPAccountingList(accountingCondVO);
   		
    		return returnList;    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * manageAccountingCaptureInfo BackEndJob process
	 * 
	 * @author ORKIM
	 * @param String capture_period
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String manageAccountingCaptureInfo(String capture_period, String usrId) throws EventException {
		AccountPayablePaymentBackEndJob accountPayablePaymentBackEndJob = new AccountPayablePaymentBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			accountPayablePaymentBackEndJob.setCapturePeriod(capture_period);
			accountPayablePaymentBackEndJob.setUsrId(usrId);

			return backEndJobManager.execute(accountPayablePaymentBackEndJob, usrId, "manageAccountingCaptureInfo");
		 } catch (Exception ex) {
			throw new EventException(new ErrorHandler("SAP00023", new String[]{"manageAccountingCaptureInfo BackEndJob"}).getMessage(),ex);
		}
	}
	
	/**
	 * manageAccountingCaptureCsrNo
	 * 
	 * @author ORKIM
	 * @param String csrNo
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String manageAccountingCaptureCsrNo(String csrNo, String usrId) throws EventException {
		
		String[] arrAcctParams = new String[5];
		
		String resultMsg = "";
		//String capturePeriod = "";
		String functional_currency_code = "";
		String accounting_request_id = ""; 
		
		AccountPayableCommonBC	   comCommand = new AccountPayableCommonBCImpl();		
		
		try {

			//Accounting 여부체크  
			String chkAcctExist = dbDao.searchAccountingExistsCheckCsrNo(csrNo);
			
			if(chkAcctExist != null && chkAcctExist.equals("Y")){
				throw new EventException(new ErrorHandler("SAP00054", new String[]{""}).getMessage());
			}

			functional_currency_code = comCommand.searchFunctionalCurrencyCode().get(0).getValue0();
			
			//SEARCH SAP_ACCTG_REQ_SEQ.NEXTVAL 
			accounting_request_id = dbDao.searchAccountingRequestIdInfo();

			arrAcctParams[0] = "";  //capturePeriod
			arrAcctParams[1] = csrNo;
			arrAcctParams[2] = functional_currency_code;
			arrAcctParams[3] = accounting_request_id;
			arrAcctParams[4] = usrId;
			
			//SETUP 정보(AP ACCOUNT SETUP) 체크
			String[] ccidChk = checkAPAccountSetup("INIT", null, arrAcctParams);
			if( !"OK".equals(ccidChk[0])) {
				resultMsg =new ErrorHandler("SAP00048",new String[]{ccidChk[0]}).getUserMessage();
				throw new EventException(resultMsg);
			}

			//Accounting 대상 구분 체크  
			String chkAcctPartType = dbDao.searchAccountingInvoiceSectionCheckCsrNo(csrNo);
			
			if(chkAcctPartType != null && (chkAcctPartType.equals("INVOICE") || chkAcctPartType.equals("ALL"))) { 
				processInvoice(arrAcctParams);
				processInvoiceCancellation(arrAcctParams);
			}
			//processPayment(arrAcctParams);
			//processPaymentCancel(arrAcctParams);
			if(chkAcctPartType != null && (chkAcctPartType.equals("PREPAY") || chkAcctPartType.equals("ALL"))) {
				processPrepaymentApply(arrAcctParams);
				processPrepaymentUnapply(arrAcctParams);
			}
			processErrorCheck(arrAcctParams);
		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return csrNo;
	}	
	
	/**
	 * return result of  Back End Job.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJob(String key) throws EventException {
		DBRowSet rowSet;
		try {
			String[] result = new String[2];
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			
			if(rowSet.next()) {
				//Thread.sleep(1000);
				result[0] = rowSet.getString("jb_sts_flg");
				result[1] = rowSet.getString("jb_usr_err_msg");
			}
			return result;
		} catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
		
	/**
	 * [STM_SAP_0220]
	 * Accounting list delete<br>
	 *
	 * @param List<APAccountingListVO> updateVoList
	 * @exception EventException
	 */
	public void removeAccountingInfo(List<APAccountingListVO> updateVoList) throws EventException {
		try {
			dbDao.removeAccountingEvent(updateVoList);
			dbDao.removeAccountingEventHeader(updateVoList);
			dbDao.removeAccountingEventLine(updateVoList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0220]
	 * modifyAccountingDetailPaymentLineRestore<br>
	 *
	 * @param List<APAccountingListVO> updateVoList
	 * @exception EventException
	 */
	public void modifyAccountingDetailPaymentLineRestore(List<APAccountingListVO> updateVoList) throws EventException {
		try {
			dbDao.modifyAccountingDetailPaymentLineRestore(updateVoList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
   /**
	 * [STM_SAP_0120]
	 * Bank Balance Adjustment - retrieve<br> 
	 * @author JBLEE
	 * @param BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO
	 * @return List<BankAccountAdjustmentListVO>
	 * @exception EventException
   */   
	public List<BankAccountAdjustmentListVO> searchBankAccountAdjustmentList(BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO) throws EventException {
		try {
				return dbDao.searchBankAccountAdjustmentList(bankBalanceByOfficeCondVO);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
   }
	
   /**
	 * [STM_SAP_0120]
	 * Bank Account Adjustment - Recalculate<br> 
	 * @author JBLEE
	 * @param BankBalanceAdjustmentListVO[] bankBalanceAdjustmentListVOs
     * @param String usrId
	 * @exception EventException
   */
	public void manageBankAccountAdjustment(BankBalanceAdjustmentListVO[] bankBalanceAdjustmentListVOs, String usrId) throws EventException {
   	try {
   			if (bankBalanceAdjustmentListVOs != null ) {
   				List<BankBalanceAdjustmentListVO> insertVoList = new ArrayList<BankBalanceAdjustmentListVO>();
   				List<BankBalanceAdjustmentListVO> modifyVoList = new ArrayList<BankBalanceAdjustmentListVO>();
   				
   				for (int i = 0; i < bankBalanceAdjustmentListVOs.length; i++) {
   					
   					if (bankBalanceAdjustmentListVOs[i].getSaveChk().equals("1")) { 
	   					String bankAcctSeq  = bankBalanceAdjustmentListVOs[i].getBankAcctSeq();
	   					String bankStmtDt   = bankBalanceAdjustmentListVOs[i].getBankStmtDt();
	   					//String bankStmtDesc = bankBalanceAdjustmentListVOs[i].getBankStmtDesc();
	
	   					//BigDecimal aftBgnBalAmt  = new BigDecimal(bankBalanceAdjustmentListVOs[i].getCtrlBgnBalAmt());
	   					
	   					BigDecimal ctrl_bgn_bal_amt  = new BigDecimal(bankBalanceAdjustmentListVOs[i].getCtrlBgnBalAmt());
	   					BigDecimal ctrl_ttl_rct_amt  = new BigDecimal(bankBalanceAdjustmentListVOs[i].getCtrlTtlRctAmt());
	   					BigDecimal ctrl_ttl_pay_amt  = new BigDecimal(bankBalanceAdjustmentListVOs[i].getCtrlTtlPayAmt());
	   					
	   					BigDecimal aftBgnBalAmt = ctrl_bgn_bal_amt.add(ctrl_ttl_rct_amt).subtract(ctrl_ttl_pay_amt);  //전일잔액 = 전일잔액 + 전일입금 - 전일출금
	   					
	   					
	   	    			BigDecimal aftRctAmt     = new BigDecimal(bankBalanceAdjustmentListVOs[i].getReceiptAmtToday());  //입금액
	   	    			BigDecimal aftPayAmt     = new BigDecimal(bankBalanceAdjustmentListVOs[i].getPaymentAmtToday());  //출금액
	   	    			//BigDecimal aftEndgBalAmt = new BigDecimal(bankBalanceAdjustmentListVOs[i].getAftEndgBalAmt());    
	   	    			BigDecimal aftEndgBalAmt = aftBgnBalAmt.add(aftRctAmt).subtract(aftPayAmt);    //현재잔액 = 전일잔액 + 입금액 - 출금액 
	   	    			
	   	    			// bankAcctSeq, bankStmtDt 기준 크거나 같은 값 조회
	   					List<BankBalanceAdjustmentListVO> reCalcVoList =  dbDao.searchAccountAdjustmentRecalculationList(bankAcctSeq, bankStmtDt);
	
	   					if (reCalcVoList.size() > 0) {    						

	   						bankBalanceAdjustmentListVOs[i].setCtrlBgnBalAmt(aftBgnBalAmt.toString());
	   						bankBalanceAdjustmentListVOs[i].setCtrlTtlRctAmt(aftRctAmt.toString());
	   						bankBalanceAdjustmentListVOs[i].setCtrlTtlPayAmt(aftPayAmt.toString());
	   						bankBalanceAdjustmentListVOs[i].setCtrlEndgBalAmt(aftEndgBalAmt.toString());
	   						bankBalanceAdjustmentListVOs[i].setUsrId(usrId);
	   						modifyVoList.add(bankBalanceAdjustmentListVOs[i]);
	   					} else {   
	   						bankBalanceAdjustmentListVOs[i].setCtrlBgnBalAmt(aftBgnBalAmt.toString());
	   						bankBalanceAdjustmentListVOs[i].setCtrlTtlRctAmt(aftRctAmt.toString());
	   						bankBalanceAdjustmentListVOs[i].setCtrlTtlPayAmt(aftPayAmt.toString());
	   						bankBalanceAdjustmentListVOs[i].setCtrlEndgBalAmt(aftEndgBalAmt.toString());
	   						bankBalanceAdjustmentListVOs[i].setUsrId(usrId);
	   						
	   						insertVoList.add(bankBalanceAdjustmentListVOs[i]);
						}
   					}
   				}  // end of for 
   				if (insertVoList.size() > 0) {
   					dbDao.addBankAccountAdjustment(insertVoList);
   				}
   				if (modifyVoList.size() > 0) {
   					dbDao.modifyBankAccountAdjustment(modifyVoList);
   				}    				
   			} 
   	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
   }
	
   /**
	 * [STM_SAP_0140]
	 * Inquiry of Transaction - Retrieve<br> 
	 * @author ORKIM
	 * @param APTransactionCondVO aPTransactionCondVO
	 * @return List<APTransactionVO>
	 * @exception EventException
  */   
	public List<APTransactionVO> searchInquiryofTransactionList(APTransactionCondVO aPTransactionCondVO) throws EventException {
		try {
			return dbDao.searchInquiryofTransactionList(aPTransactionCondVO);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
   /**
	 * [STM_SAP_0140]
	 * Inquiry of Transaction - Retrieve BeginBalance <br> 
	 * @author ORKIM
	 * @param APTransactionCondVO aPTransactionCondVO
	 * @return String
	 * @exception EventException
   */ 
	public String searchInquiryofTrxBeginBalance(APTransactionCondVO aPTransactionCondVO) throws EventException {
		try {
			return dbDao.searchInquiryofTrxBeginBalance(aPTransactionCondVO);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
   /**
	 * [STM_SAP_0140]
	 * Inquiry of Transaction - Retrieve Sum <br> 
	 * @author ORKIM
	 * @param APTransactionCondVO aPTransactionCondVO
	 * @return String[]
	 * @exception EventException
   */ 
	public String[] searchInquiryofTransactionSum(APTransactionCondVO aPTransactionCondVO) throws EventException {
		try {
			return dbDao.searchInquiryofTransactionSum(aPTransactionCondVO);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * [STM_SAP_0060] Retrieve<br>
	 * Payment Schedule Inquiry - retrieve<br>
	 * @author ORKIM
	 * @param String csr_no
	 * @param String flag
	 * @return String
	 * @exception EventException
	 */
	public String manageSOInterface(String csr_no, String flag) throws EventException {
		String rtnValue = "";
		try {			
			String srcCd = dbDao.searchInvHdrSrcCd(csr_no);
			
			if(srcCd.equals("SO_TERMINAL")){
				log.debug("manageSOInterface TES!!");
				dbDao.modifySOInterfaceTES(csr_no, flag);    	
			}else if(srcCd.equals("BROKERAGE") || srcCd.equals("COMMISSION")){
				log.debug("manageSOInterface AGT!!");
			}else if(srcCd.equals("SO_M&R") || srcCd.equals("EQ") || srcCd.equals("SO_LEASE") || srcCd.equals("SO_PORT") || srcCd.equals("SO_CHASSIS") || srcCd.equals("SO_MGSET") || srcCd.equals("SO_CCC")){
				log.debug("manageSOInterface CSR!!");
			//	dbDao.modifySOInterfaceETC(csr_no, flag);    					
			}else if(srcCd.equals("SO_TRANS")){ 
				log.debug("manageSOInterface TRS!!");
				dbDao.modifySOInterfaceTRS(csr_no, flag);    
				dbDao.modifySOInterfaceTRSRail(csr_no, flag);    
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
		
	}
	
	/**
	 * Interface<br>
	 * searchInvHdrSrcCd<br>
	 * @author ORKIM
	 * @param String csr_no
	 * @return String
	 * @exception EventException
	 */
	public String searchInvHdrSrcCd(String csr_no) throws EventException {
		try {
			return dbDao.searchInvHdrSrcCd(csr_no);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * Interface<br>
	 * searchSAPToSOInterfaceData <br>
	 * @author ORKIM
	 * @param String csr_no
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSAPToSOInterfaceData(String csr_no) throws EventException {
		try {
			return dbDao.searchSAPToSOInterfaceData(csr_no);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * Interface<br>
	 * searchSAPToSOInterfaceDataBatch <br>
	 * @author ORKIM
	 * @param String pay_bat_seq
	 * @param String pay_bat_nm
	 * @param String vndr_no
	 * @return List<PaymentEntryLineVO>
	 * @exception EventException
	 */
	public List<PaymentEntryLineVO>  searchSAPToSOInterfaceDataBatch(String pay_bat_seq, String pay_bat_nm, String vndr_no) throws EventException {
		try {
			return dbDao.searchSAPToSOInterfaceDataBatch(pay_bat_seq, pay_bat_nm,vndr_no);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * [STM_SAP_0060]   
	 * [header] / [line] list delete validation <br>
	 *
	 * @param String pay_seq
	 * @return String
	 * @exception EventException
	 */
	public String searchPaymentApplyCheck(String pay_seq) throws EventException {
		try {
			return dbDao.searchPaymentApplyCheck(pay_seq);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	

   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentProcessList <br> 
	 * @author ORKIM
	 * @return List<APIFPaymentProcessListVO>
	 * @exception EventException
   */ 
	public List<APIFPaymentProcessListVO>  searchAPIFPaymentProcessList() throws EventException {
		try {
			return dbDao.searchAPIFPaymentProcessList();    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

		
   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPPaymentBatchProcessName <br> 
	 * @author ORKIM
	 * @return String
	 * @exception EventException
   */ 
	public String searchAPPaymentBatchProcessName() throws EventException {
		try {
			return dbDao.searchAPPaymentBatchProcessName();    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

		

   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentCSRInfoList <br> 
	 * @author ORKIM
	 * @param  APIFPaymentProcessListVO aPIFPaymentProcessListVO
	 * @return List<APIFPaymentCSRInfoListVO>
	 * @exception EventException
   */ 
	public List<APIFPaymentCSRInfoListVO>  searchAPIFPaymentCSRInfoList(APIFPaymentProcessListVO aPIFPaymentProcessListVO) throws EventException {
		try {
			return dbDao.searchAPIFPaymentCSRInfoList(aPIFPaymentProcessListVO);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentCompleteCheck <br> 
	 * @author ORKIM
	 * @param  APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO
	 * @return List<APIFPaymentCompleteCheckVO>
	 * @exception EventException
   */ 
	public List<APIFPaymentCompleteCheckVO>  searchAPIFPaymentCompleteCheck(APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO) throws EventException {
		try {
			return dbDao.searchAPIFPaymentCompleteCheck(aPIFPaymentCSRInfoListVO);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
		
   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentBANKExistsCheck <br> 
	 * @author ORKIM
	 * @param  APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO
	 * @return List<APIFPaymentBANKExistsCheckVO>
	 * @exception EventException
   */ 
	public List<APIFPaymentBANKExistsCheckVO>  searchAPIFPaymentBANKExistsCheck(APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO) throws EventException {
		try {
			return dbDao.searchAPIFPaymentBANKExistsCheck(aPIFPaymentCSRInfoListVO);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}


   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentBANKInfoCheck <br> 
	 * @author ORKIM
	 * @param  APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO
	 * @return List<APIFPaymentBANKInfoCheckVO>
	 * @exception EventException
   */ 
	public List<APIFPaymentBANKInfoCheckVO>  searchAPIFPaymentBANKInfoCheck(APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO) throws EventException {
		try {
			return dbDao.searchAPIFPaymentBANKInfoCheck(aPIFPaymentCSRInfoListVO);    		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

   /**
	 * SAKURA I/F for PAYMENT  
	 * searchNextPaySeq <br> 
	 * @author ORKIM
	 * @return String
	 * @exception EventException
   */ 
	public String searchNextPaySeq() throws EventException {
		try {
			return dbDao.searchNextPaySeq();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}	
		
	/**
	 * SAKURA I/F for PAYMENT  
	 * manageAPIFPayment <br> 
	 * @author ORKIM
	 * @param List<PaymentEntryVO> payEntryVOList
	 * @param List<PaymentEntryLineVO> payEntryLineVOList
	 * @param List<APIFPaymentProcessListVO> ifProcessVOList
	 * @exception EventException
    */ 
	public void manageAPIFPayment(List<PaymentEntryVO> payEntryVOList, List<PaymentEntryLineVO> payEntryLineVOList, List<APIFPaymentProcessListVO> ifProcessVOList) throws EventException {
		try {
			
			if (payEntryVOList != null ) {
				dbDao.addPaymentHeader(payEntryVOList);
				dbDao.addPaymentLine(payEntryLineVOList);
				dbDao.modifyAPIFPaymentStatus(ifProcessVOList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
				
	}
		
   /**
	 * SAKURA I/F for PAYMENT  
	 * addPaymentHeader <br> 
	 * @author ORKIM
	 * @param List<PaymentEntryVO> payEntryVOList
	 * @exception EventException
   */ 
	public void addPaymentHeader(List<PaymentEntryVO> payEntryVOList) throws EventException {
		try {
			if (payEntryVOList != null ) {
				dbDao.addPaymentHeader(payEntryVOList);					
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
		
   /**
	 * SAKURA I/F for PAYMENT  
	 * addPaymentLine <br> 
	 * @author ORKIM
	 * @param List<PaymentEntryLineVO> payEntryLineVOList
	 * @exception EventException
   */ 
	public void addPaymentLine(List<PaymentEntryLineVO> payEntryLineVOList) throws EventException {
		try {
			if (payEntryLineVOList != null ) {
				dbDao.addPaymentLine(payEntryLineVOList);					
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
		
   /**
	 * SAKURA I/F for PAYMENT  
	 * modifyAPIFPaymentStatus <br> 
	 * @author ORKIM
	 * @param List<APIFPaymentProcessListVO> ifProcessVOList
	 * @exception EventException
   */ 
	public void modifyAPIFPaymentStatus(List<APIFPaymentProcessListVO> ifProcessVOList) throws EventException {
		try {
			if (ifProcessVOList != null ) {
				dbDao.modifyAPIFPaymentStatus(ifProcessVOList);					
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
   /**
	 * checkAPAccountSetup
	 * @author ORKIM
	 * @param  String callFlag
	 * @param  String[] argParam
	 * @param  String[] arrAcctParams
	 * @return String[]
	 * @exception EventException
   */ 	
	public String[] checkAPAccountSetup(String callFlag, String[] argParam, String[] arrAcctParams) throws EventException {
		
		StatementCommonBC 		   scoCommand = new StatementCommonBCImpl();
		
		
		String strResult[] = new String[2];
		String[] coaArr;
		
		strResult[0]= "ERROR";
		
		/*String capturePeriod 			= JSPUtil.getNull(arrAcctParams[0]);
		String csrNo 					= JSPUtil.getNull(arrAcctParams[1]);
		String functional_currency_code = JSPUtil.getNull(arrAcctParams[2]);
		String accounting_request_id 	= JSPUtil.getNull(arrAcctParams[3]);*/
		String usrId 					= JSPUtil.getNull(arrAcctParams[4]);
		
		//coaArr[0]  company
		//coaArr[1]  region 
		//coaArr[2]  center  
		//coaArr[3]  account
		//coaArr[4]  intercompany
		//coaArr[5]  vvd
		//coaArr[6]  cd_cmb_seq
		
		try {
		
			if ("INIT".equals(callFlag)) { 
			
				//LOSS ACCOUNT
				coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
				
				if(JSPUtil.getNull(coaArr[6]).equals("")) {
					 LedgerCodeCombinationListVO ccidVO = new LedgerCodeCombinationListVO();
					 ccidVO.setSgmCtnt1( coaArr[0] );
					 ccidVO.setSgmCtnt2( coaArr[1] );
					 ccidVO.setSgmCtnt3( coaArr[2] );
					 ccidVO.setSgmCtnt4( coaArr[3] );
					 ccidVO.setSgmCtnt5( coaArr[4] );
					 ccidVO.setSgmCtnt6( coaArr[5] );
					 
					 String ccidChk[] = scoCommand.manageLedgerCodeCombinationBiz(ccidVO, usrId);
					 
					 if(!ccidChk[0].equals("OK")) {
						 strResult[0] = ccidChk[0];
						 return strResult;					 
					 } 			
				}
				
				//GAIN ACCOUNT
				coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
				if(JSPUtil.getNull(coaArr[6]).equals("")) {
					 LedgerCodeCombinationListVO ccidVO = new LedgerCodeCombinationListVO();
					 ccidVO.setSgmCtnt1( coaArr[0] );
					 ccidVO.setSgmCtnt2( coaArr[1] );
					 ccidVO.setSgmCtnt3( coaArr[2] );
					 ccidVO.setSgmCtnt4( coaArr[3] );
					 ccidVO.setSgmCtnt5( coaArr[4] );
					 ccidVO.setSgmCtnt6( coaArr[5] );
					 
					 String ccidChk[] = scoCommand.manageLedgerCodeCombinationBiz(ccidVO, usrId);
					 
					 if(!ccidChk[0].equals("OK")) {
						 strResult[0] = ccidChk[0];
						 return strResult;					 
					 } 			
				}	
				
				//ROUNDING ACCOUNT
				coaArr = dbDao.searchAccountingPaymentInvRoundInfoCheck();
				if(JSPUtil.getNull(coaArr[6]).equals("")) {
					 LedgerCodeCombinationListVO ccidVO = new LedgerCodeCombinationListVO();
					 ccidVO.setSgmCtnt1( coaArr[0] );
					 ccidVO.setSgmCtnt2( coaArr[1] );
					 ccidVO.setSgmCtnt3( coaArr[2] );
					 ccidVO.setSgmCtnt4( coaArr[3] );
					 ccidVO.setSgmCtnt5( coaArr[4] );
					 ccidVO.setSgmCtnt6( coaArr[5] );
					 
					 String ccidChk[] = scoCommand.manageLedgerCodeCombinationBiz(ccidVO, usrId);
					 
					 if(!ccidChk[0].equals("OK")) {
						 strResult[0] = ccidChk[0];
						 return strResult;					 
					 } 			
				}
			} else {
				LedgerCodeCombinationListVO ccidVO = new LedgerCodeCombinationListVO();
				ccidVO.setSgmCtnt1( argParam[0] );
				ccidVO.setSgmCtnt2( argParam[1] );
				ccidVO.setSgmCtnt3( argParam[2] );
				ccidVO.setSgmCtnt4( argParam[3] );
				ccidVO.setSgmCtnt5( argParam[4] );
				ccidVO.setSgmCtnt6( argParam[5] );
				
				String ccidChk[] = scoCommand.manageLedgerCodeCombinationBiz(ccidVO, usrId);
				 
				if(!ccidChk[0].equals("OK")) {
					strResult[0] = ccidChk[0];
					return strResult;					 
				} else {
					strResult[0] = "OK";
					strResult[1] = ccidChk[1];
					return strResult;					 
				}
			}
			
			strResult[0] = "OK";
			return strResult;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
   /**
	 * processInvoice
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */ 	
	public void processInvoice(String[] arrAcctParams) throws EventException {
		
		AccountPayableInvoiceBC	   invCommand = new AccountPayableInvoiceBCImpl();		
		
		String capturePeriod 			= JSPUtil.getNull(arrAcctParams[0]);
		String csrNo 					= JSPUtil.getNull(arrAcctParams[1]);
		String functional_currency_code = JSPUtil.getNull(arrAcctParams[2]);
		String accounting_request_id 	= JSPUtil.getNull(arrAcctParams[3]);
		String usrId 					= JSPUtil.getNull(arrAcctParams[4]);
		
		try { 
			List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs = null;
			if(!capturePeriod.equals("")) { 
				accountingInvoiceCheckVOs = dbDao.searchAccountingInvoiceCheck(capturePeriod);
			} else {
				accountingInvoiceCheckVOs = dbDao.searchAccountingInvoiceCheckCsrNo(csrNo);
			}
			List<AccountingInvoiceCheckVO> gainlossInvoiceVOs = new ArrayList<AccountingInvoiceCheckVO>();
			AccountingInvoiceCheckVO gainLossInvoiceVO;
			//Accounting 처리를 위한 Invoice Line의 Exchange Rate 처리 기준 정보
			String chkInvExRateBase = dbDao.searchAccountingInvoiceExchangeRateRuleCheckInfo();
			String[] coaCtnt;
			String[] coaArr;
			String[] paramCoaArr;
			String coa_seq;
			
			if(accountingInvoiceCheckVOs != null && accountingInvoiceCheckVOs.size() > 0 ) {
				for(int i=0; i < accountingInvoiceCheckVOs.size(); i++ ) {
					accountingInvoiceCheckVOs.get(i).setUsrId(usrId);
					accountingInvoiceCheckVOs.get(i).setAccountingRequestId(accounting_request_id);
					accountingInvoiceCheckVOs.get(i).setAccountingHeaderId(dbDao.searchAccountingHeaderIdInfo());
					accountingInvoiceCheckVOs.get(i).setAccountingEventId(dbDao.searchAccountingEventIdInfo());
					accountingInvoiceCheckVOs.get(i).setFunctionalCurrency(functional_currency_code);
					
					if (chkInvExRateBase.equals("LINE")) {
						String chkInvGainLossExists = dbDao.searchAccountingInvoiceGainLossCheck(accountingInvoiceCheckVOs.get(i).getInvSeq());
						if (chkInvGainLossExists.equals("DR") || chkInvGainLossExists.equals("CR")) {
							coaCtnt = dbDao.searchAccountingPaymentInvLiabilityInfoCheck(accountingInvoiceCheckVOs.get(i).getInvSeq());
							
							if(chkInvGainLossExists.equals("DR")) {
								coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvLossCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"LOSS CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gainLossInvoiceVO = new AccountingInvoiceCheckVO();
								
								ObjectCloner.build(accountingInvoiceCheckVOs.get(i), gainLossInvoiceVO);
								
								gainLossInvoiceVO.setAcctGainLossCoa(coa_seq);
								gainLossInvoiceVO.setAcctJournalType(chkInvGainLossExists);
								
								gainlossInvoiceVOs.add(gainLossInvoiceVO);
								
							} else if(chkInvGainLossExists.equals("CR")) {
								coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvGainCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"GAIN CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gainLossInvoiceVO = new AccountingInvoiceCheckVO();
								
								ObjectCloner.build(accountingInvoiceCheckVOs.get(i), gainLossInvoiceVO);
								
								gainLossInvoiceVO.setAcctGainLossCoa(coa_seq);
								gainLossInvoiceVO.setAcctJournalType(chkInvGainLossExists);
								
								gainlossInvoiceVOs.add(gainLossInvoiceVO);
							}
						}
					}
				}
			
				 dbDao.addAccountingEventInvInfo(accountingInvoiceCheckVOs);
				 dbDao.addAccountingHeaderInvInfo(accountingInvoiceCheckVOs);
				 if (chkInvExRateBase.equals("LINE")) {
					 dbDao.addAccountingDetailInvLineExRateInfo(accountingInvoiceCheckVOs); 
					// loss & gain 
					if (gainlossInvoiceVOs.size() > 0) {
						dbDao.addAccountingDetailInvLineGainLossInfo(gainlossInvoiceVOs);
					}
				 } else {
					dbDao.addAccountingDetailInvLineInfo(accountingInvoiceCheckVOs);
				 }
				 invCommand.modifyAccountingDetailInvLineFlag(accountingInvoiceCheckVOs);
				 dbDao.addAccountingDetailInvHeaderInfo(accountingInvoiceCheckVOs);
			}	
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}
	
   /**
	 * processInvoiceCancellation
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */ 
	public void processInvoiceCancellation(String[] arrAcctParams) throws EventException {
		
		AccountPayableInvoiceBC	   invCommand = new AccountPayableInvoiceBCImpl();	
		String capturePeriod 			= JSPUtil.getNull(arrAcctParams[0]);
		String csrNo 					= JSPUtil.getNull(arrAcctParams[1]);
		String functional_currency_code = JSPUtil.getNull(arrAcctParams[2]);
		String accounting_request_id 	= JSPUtil.getNull(arrAcctParams[3]);
		String usrId 					= JSPUtil.getNull(arrAcctParams[4]);
		
		try { 
			//List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs = dbDao.searchAccountingInvoiceCancelCheck(capturePeriod);
			
			List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs = null;
			if(!capturePeriod.equals("")) { 
				accountingInvoiceCancelCheckVOs = dbDao.searchAccountingInvoiceCancelCheck(capturePeriod);
			} else {
				accountingInvoiceCancelCheckVOs = dbDao.searchAccountingInvoiceCancelCheckCsrNo(csrNo);
			}
			List<AccountingInvoiceCancelCheckVO> gainlossInvoiceCancelVOs = new ArrayList<AccountingInvoiceCancelCheckVO>();
			AccountingInvoiceCancelCheckVO gainLossInvoiceCancelVO;
			//Accounting 처리를 위한 Invoice Line의 Exchange Rate 처리 기준 정보
			String chkInvExRateBase = dbDao.searchAccountingInvoiceExchangeRateRuleCheckInfo();
			String[] coaCtnt;
			String[] coaArr;
			String[] paramCoaArr;
			String coa_seq;
			
			if(accountingInvoiceCancelCheckVOs != null && accountingInvoiceCancelCheckVOs.size() > 0 ) {
				for(int i=0; i < accountingInvoiceCancelCheckVOs.size(); i++ ) {
					accountingInvoiceCancelCheckVOs.get(i).setUsrId(usrId);
					accountingInvoiceCancelCheckVOs.get(i).setAccountingRequestId(accounting_request_id);
					accountingInvoiceCancelCheckVOs.get(i).setAccountingHeaderId(dbDao.searchAccountingHeaderIdInfo());
					accountingInvoiceCancelCheckVOs.get(i).setAccountingEventId(dbDao.searchAccountingEventIdInfo());
					accountingInvoiceCancelCheckVOs.get(i).setFunctionalCurrency(functional_currency_code);
					
					if (chkInvExRateBase.equals("LINE")) {
						String chkInvGainLossExists = dbDao.searchAccountingInvoiceCancelGainLossCheck(accountingInvoiceCancelCheckVOs.get(i).getInvSeq());
						if (chkInvGainLossExists.equals("DR") || chkInvGainLossExists.equals("CR")) {
							coaCtnt = dbDao.searchAccountingPaymentInvLiabilityInfoCheck(accountingInvoiceCancelCheckVOs.get(i).getInvSeq());
							
							if(chkInvGainLossExists.equals("DR")) {
								coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvLossCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"LOSS CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gainLossInvoiceCancelVO = new AccountingInvoiceCancelCheckVO();
								
								ObjectCloner.build(accountingInvoiceCancelCheckVOs.get(i), gainLossInvoiceCancelVO);
								
								gainLossInvoiceCancelVO.setAcctGainLossCoa(coa_seq);
								gainLossInvoiceCancelVO.setAcctJournalType(chkInvGainLossExists);
								
								gainlossInvoiceCancelVOs.add(gainLossInvoiceCancelVO);
								
							} else if(chkInvGainLossExists.equals("CR")) {
								coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvGainCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"GAIN CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gainLossInvoiceCancelVO = new AccountingInvoiceCancelCheckVO();
								
								ObjectCloner.build(accountingInvoiceCancelCheckVOs.get(i), gainLossInvoiceCancelVO);
								
								gainLossInvoiceCancelVO.setAcctGainLossCoa(coa_seq);
								gainLossInvoiceCancelVO.setAcctJournalType(chkInvGainLossExists);
								
								gainlossInvoiceCancelVOs.add(gainLossInvoiceCancelVO);
							}
						}
					}
				}
			
				 dbDao.addAccountingEventInvCancelInfo(accountingInvoiceCancelCheckVOs);
				 dbDao.addAccountingHeaderInvCancelInfo(accountingInvoiceCancelCheckVOs);
				 if (chkInvExRateBase.equals("LINE")) {
					dbDao.addAccountingDetailInvLineCancelExRateInfo(accountingInvoiceCancelCheckVOs); 
					// loss & gain 
					if (gainlossInvoiceCancelVOs.size() > 0) {
						dbDao.addAccountingDetailInvCancelLineGainLossInfo(gainlossInvoiceCancelVOs);
					}
				 } else {
					 dbDao.addAccountingDetailInvLineCancelInfo(accountingInvoiceCancelCheckVOs);
				 }
				 invCommand.modifyAccountingDetailInvLineCancelFlag(accountingInvoiceCancelCheckVOs);
				 dbDao.addAccountingDetailInvHeaderCancelInfo(accountingInvoiceCancelCheckVOs);
				
			}	
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}

   /**
	 * processPayment
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */	
	public void processPayment(String[] arrAcctParams) throws EventException {
		
		String capturePeriod 			= JSPUtil.getNull(arrAcctParams[0]);
		String csrNo 					= JSPUtil.getNull(arrAcctParams[1]);
		String functional_currency_code = JSPUtil.getNull(arrAcctParams[2]);
		String accounting_request_id 	= JSPUtil.getNull(arrAcctParams[3]);
		String usrId 					= JSPUtil.getNull(arrAcctParams[4]);
		
		try { 
			//List<AccountingPaymentCheckVO> accountingPaymentCheckVOs = dbDao.searchAccountingPaymentCheck(capturePeriod);
			
			List<AccountingPaymentCheckVO> accountingPaymentCheckVOs = null;
			if(!capturePeriod.equals("")) { 
				accountingPaymentCheckVOs = dbDao.searchAccountingPaymentCheck(capturePeriod);
			} else {
				accountingPaymentCheckVOs = dbDao.searchAccountingPaymentCheckCsrNo(csrNo);
			}
			
			if(accountingPaymentCheckVOs != null && accountingPaymentCheckVOs.size() > 0 ) {
				
				List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs  = null;
				List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckFullVOs  = new ArrayList<AccountingPaymentLineCheckVO>();
				List<AccountingPaymentLineCheckVO> detailPaymentVOs = null;
				List<AccountingPaymentLineCheckVO> gainPaymentVOs = null;
				List<AccountingPaymentLineCheckVO> lossPaymentVOs = null;
				List<AccountingPaymentCheckVO> roundPaymentHVOs = new ArrayList<AccountingPaymentCheckVO>();
				List<AccountingPaymentCheckVO> roundPaymentDVOs = new ArrayList<AccountingPaymentCheckVO>();
				
				AccountingPaymentLineCheckVO gainLossPaymentVO;
				
				String gain_loss_type = "";
				String[] gainLossChkArr;
				String[] coaCtnt;
				String[] coaArr;
				String[] paramCoaArr;
				
				String inv_gl_yymm;
				String pay_gl_yymm;
				String inv_xch_rt;
				String pay_xch_rt;
				String pay_amt;
				
				String coa_seq;
				String gain_loss_amt;
				
				int accounting_line_no = 0;
				String accounting_header_id = ""; 
				String accounting_event_id = ""; 
				
				for(int i=0; i < accountingPaymentCheckVOs.size(); i++ ) {
					
					accounting_header_id = dbDao.searchAccountingHeaderIdInfo();
					accounting_event_id = dbDao.searchAccountingEventIdInfo();
					
					accountingPaymentCheckVOs.get(i).setUsrId(usrId);
					accountingPaymentCheckVOs.get(i).setAccountingRequestId(accounting_request_id);
					accountingPaymentCheckVOs.get(i).setAccountingHeaderId(accounting_header_id);
					accountingPaymentCheckVOs.get(i).setAccountingEventId(accounting_event_id);
				}
					
				dbDao.addAccountingEventPayInfo(accountingPaymentCheckVOs);
				dbDao.addAccountingHeaderPayInfo(accountingPaymentCheckVOs);
				
				for(int i=0; i < accountingPaymentCheckVOs.size(); i++ ) {	
					accountingPaymentLineCheckVOs = dbDao.searchAccountingPaymentLineCheck(accountingPaymentCheckVOs.get(i).getPaySeq());
					
					if(accountingPaymentLineCheckVOs != null && accountingPaymentLineCheckVOs.size() > 0 ) {
						accounting_line_no = 0;
						for(int j=0; j < accountingPaymentLineCheckVOs.size(); j++ ) {
							accounting_line_no += 1;
							accounting_header_id = accountingPaymentCheckVOs.get(i).getAccountingHeaderId();
							accounting_event_id  = accountingPaymentCheckVOs.get(i).getAccountingEventId();
							
							accountingPaymentLineCheckVOs.get(j).setUsrId(usrId);
							accountingPaymentLineCheckVOs.get(j).setAccountingRequestId(accounting_request_id);
							accountingPaymentLineCheckVOs.get(j).setAccountingHeaderId(accounting_header_id);
							accountingPaymentLineCheckVOs.get(j).setAccountingEventId(accounting_event_id);
							accountingPaymentLineCheckVOs.get(j).setAccountingLineNo(accounting_line_no+"");
							accountingPaymentLineCheckVOs.get(j).setFunctionalCurrency(functional_currency_code);
							
							
							accountingPaymentLineCheckFullVOs.add(accountingPaymentLineCheckVOs.get(j));
							
							detailPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
							detailPaymentVOs.add(accountingPaymentLineCheckVOs.get(j));
							dbDao.addAccountingDetailPayDetailInfo(detailPaymentVOs);
							accounting_line_no = Integer.parseInt(accountingPaymentLineCheckVOs.get(j).getAccountingLineNo());
							gainLossChkArr = dbDao.searchAccountingPaymentLineGainLossCheck(accountingPaymentLineCheckVOs.get(j));
							inv_gl_yymm = gainLossChkArr[0];
							pay_gl_yymm = gainLossChkArr[1];
							inv_xch_rt  = gainLossChkArr[2];
							pay_xch_rt  = gainLossChkArr[3];
							pay_amt     = gainLossChkArr[4];
							
							if(gainLossChkArr != null) {
								if (!(inv_gl_yymm.equals(pay_gl_yymm)) && !(inv_xch_rt.equals(pay_xch_rt))) {
									accounting_line_no += 1;
									
									coaCtnt = dbDao.searchAccountingPaymentInvLiabilityInfoCheck(accountingPaymentLineCheckVOs.get(j).getInvSeq());
									
									//if(Float.parseFloat(pay_xch_rt) > Float.parseFloat(inv_xch_rt)) {
									if(Float.valueOf(pay_xch_rt).compareTo(Float.valueOf(inv_xch_rt)) > 0 ) {
										if(Integer.parseInt(pay_amt) >= 0 ) {
											gain_loss_type = "LOSS";
										} else {
											gain_loss_type = "GAIN";
										}
									} else {
										if(Integer.parseInt(pay_amt) >= 0 ) {
											gain_loss_type = "GAIN";
										} else {
											gain_loss_type = "LOSS";
										}
									}
									
									if("LOSS".equals(gain_loss_type)) {
										coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
										paramCoaArr = new String[6];
										paramCoaArr[0] = coaArr[0];  //company
										paramCoaArr[1] = coaCtnt[0];  //region **
										paramCoaArr[2] = coaCtnt[1];  //center ** 
										paramCoaArr[3] = coaArr[3];  //account
										paramCoaArr[4] = coaArr[4];  //intercompany
										paramCoaArr[5] = coaArr[5];  //vvd
										coa_seq = dbDao.searchAccountingPaymentInvLossCoaInfo(paramCoaArr);
										
										String[] ccidChk = new String[2];
										if("".equals(JSPUtil.getNull(coa_seq))) {
											ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
											if(!ccidChk[0].equals("OK")) {												
												String resultMsg =new ErrorHandler("COM12241",new String[]{"LOSS CCID"}).getUserMessage();
												throw new EventException(resultMsg);
											} else {
												coa_seq = ccidChk[1]; 
											}											
										}
										
										gain_loss_amt = dbDao.searchAccountingPaymentInvGainLossAmtInfo(accountingPaymentLineCheckVOs.get(j));
										
										gainLossPaymentVO = new AccountingPaymentLineCheckVO();
										
										ObjectCloner.build(accountingPaymentLineCheckVOs.get(j), gainLossPaymentVO);
										
										gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
										gainLossPaymentVO.setCoaSeq(coa_seq);
										gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
										
										lossPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
										lossPaymentVOs.add(gainLossPaymentVO);
										dbDao.addAccountingDetailInvLossInfo(lossPaymentVOs);
										
									} else if("GAIN".equals(gain_loss_type)) {
										coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
										paramCoaArr = new String[6];
										paramCoaArr[0] = coaArr[0];  //company
										paramCoaArr[1] = coaCtnt[0];  //region **
										paramCoaArr[2] = coaCtnt[1];  //center ** 
										paramCoaArr[3] = coaArr[3];  //account
										paramCoaArr[4] = coaArr[4];  //intercompany
										paramCoaArr[5] = coaArr[5];  //vvd
										coa_seq = dbDao.searchAccountingPaymentInvGainCoaInfo(paramCoaArr);
										
										String[] ccidChk = new String[2];
										if("".equals(JSPUtil.getNull(coa_seq))) {
											ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
											if(!ccidChk[0].equals("OK")) {												
												String resultMsg =new ErrorHandler("COM12241",new String[]{"GAIN CCID"}).getUserMessage();
												throw new EventException(resultMsg);
											} else {
												coa_seq = ccidChk[1]; 
											}											
										}
										
										gain_loss_amt = dbDao.searchAccountingPaymentInvGainLossAmtInfo(accountingPaymentLineCheckVOs.get(j));
										
										gainLossPaymentVO = new AccountingPaymentLineCheckVO();
										
										ObjectCloner.build(accountingPaymentLineCheckVOs.get(j), gainLossPaymentVO);
										
										gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
										gainLossPaymentVO.setCoaSeq(coa_seq);
										gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
										
										gainPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
										gainPaymentVOs.add(gainLossPaymentVO);
										dbDao.addAccountingDetailInvGainInfo(gainPaymentVOs);
									
									}
								}
							}
						}
					}
				}
				
				for(int i=0; i < accountingPaymentCheckVOs.size(); i++ ) {	
					String pay_accounted_cr = dbDao.searchAccountingDetailPayFunctionalAmtInfo(accountingPaymentCheckVOs.get(i).getPaySeq());
					String[] drCrSumArr = dbDao.searchAccountingDetailPayAccountedSumInfo(accounting_header_id);
					String accounted_dr_sum = drCrSumArr[0];
					String accounted_cr_sum = drCrSumArr[1];
					String accounted_round_dr = "";
					String accounted_round_cr = "";
					
					/*if (Float.parseFloat(accounted_dr_sum) > ( Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr) ) ) {
						accounted_round_dr = ( Float.parseFloat(accounted_dr_sum) - (Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr)) ) + ""; 
					} else if (Float.parseFloat(accounted_dr_sum) < ( Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr) ) ) {
						accounted_round_cr = (Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr) - Float.parseFloat(accounted_dr_sum) ) + "";
					} else {
						accounted_round_dr = "0";
						accounted_round_cr = "0";
					}*/
					
					if (Float.valueOf(accounted_dr_sum).compareTo(( Float.valueOf(Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr))) ) > 0 ) {
						accounted_round_dr = ( Float.parseFloat(accounted_dr_sum) - (Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr)) ) + ""; 
					} else if (Float.valueOf(accounted_dr_sum).compareTo(Float.valueOf ( Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr) )) < 0 ) {
						accounted_round_cr = (Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr) - Float.parseFloat(accounted_dr_sum) ) + "";
					} else {
						accounted_round_dr = "0";
						accounted_round_cr = "0";
					}
					
					
					if (accounted_round_dr.equals("0") || accounted_round_cr.equals("0")) {
						accounting_line_no += 1;
						
						String[] paramCoaArr2 = dbDao.searchAccountingPaymentInvRoundInfoCheck();
						coa_seq = paramCoaArr2[6];
						
						String[] ccidChk = new String[2];
						if("".equals(JSPUtil.getNull(coa_seq))) {
							ccidChk = checkAPAccountSetup("", paramCoaArr2, arrAcctParams);
							if(!ccidChk[0].equals("OK")) {												
								String resultMsg =new ErrorHandler("COM12241",new String[]{"ROUNDING CCID"}).getUserMessage();
								throw new EventException(resultMsg);
							} else {
								coa_seq = ccidChk[1]; 
							}											
						}
						
						AccountingPaymentCheckVO tempCheckVO = new AccountingPaymentCheckVO();
						ObjectCloner.build(accountingPaymentCheckVOs.get(i), tempCheckVO);
						tempCheckVO.setAccountingLineNo(accounting_line_no + "");
						tempCheckVO.setCoaSeq(coa_seq);
						roundPaymentHVOs.add(tempCheckVO);
					}
					accounting_line_no += 1;
					AccountingPaymentCheckVO tempCheckVO = new AccountingPaymentCheckVO();
					ObjectCloner.build(accountingPaymentCheckVOs.get(i), tempCheckVO);
					tempCheckVO.setAccountingLineNo(accounting_line_no + "");						
					roundPaymentDVOs.add(tempCheckVO);
					
					
				} // end of accountingPaymentCheckVOs loop
				 
				dbDao.modifyAccountingDetailPayLineFlag(accountingPaymentLineCheckFullVOs);
				 
				//round
				if (roundPaymentHVOs.size() > 0) {
					dbDao.addAccountingDetailInvRoundInfo(roundPaymentHVOs);
				}
				if (roundPaymentDVOs.size() > 0) {
					dbDao.addAccountingDetailPayHeaderInfo(roundPaymentDVOs);
				}
				
			} // end of accountingPaymentCheckVOs if 
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}	
	
   /**
	 * processPaymentCancel
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */	
	public void processPaymentCancel(String[] arrAcctParams) throws EventException {
		
		String capturePeriod 			= JSPUtil.getNull(arrAcctParams[0]);
		String csrNo 					= JSPUtil.getNull(arrAcctParams[1]);
		String functional_currency_code = JSPUtil.getNull(arrAcctParams[2]);
		String accounting_request_id 	= JSPUtil.getNull(arrAcctParams[3]);
		String usrId 					= JSPUtil.getNull(arrAcctParams[4]);
		
		
		try { 
			//List<AccountingPaymentCheckVO> accountingPaymentCancelCheckVO = dbDao.searchAccountingPaymentCancelCheck(capturePeriod);
			List<AccountingPaymentCheckVO> accountingPaymentCancelCheckVO = null;
			if(!capturePeriod.equals("")) { 
				accountingPaymentCancelCheckVO = dbDao.searchAccountingPaymentCancelCheck(capturePeriod);
			} else {
				accountingPaymentCancelCheckVO = dbDao.searchAccountingPaymentCancelCheckCsrNo(csrNo);
			}
			
			if(accountingPaymentCancelCheckVO != null && accountingPaymentCancelCheckVO.size() > 0 ) {
				
				List<AccountingPaymentLineCheckVO> accountingPaymentCancelLineCheckVOs = null;
				List<AccountingPaymentLineCheckVO> accountingPaymentCancelLineCheckFullVOs  = new ArrayList<AccountingPaymentLineCheckVO>();
				List<AccountingPaymentLineCheckVO> detailPaymentVOs = null;
				List<AccountingPaymentLineCheckVO> gainPaymentVOs = null;
				List<AccountingPaymentLineCheckVO> lossPaymentVOs = null;
				List<AccountingPaymentCheckVO> roundPaymentHVOs = new ArrayList<AccountingPaymentCheckVO>();
				List<AccountingPaymentCheckVO> roundPaymentDVOs = new ArrayList<AccountingPaymentCheckVO>();
				
				AccountingPaymentLineCheckVO gainLossPaymentVO;
				
				String gain_loss_type = "";
				String[] gainLossChkArr;

				String[] coaCtnt;
				String[] coaArr;
				String[] paramCoaArr;
				
				String inv_gl_yymm;
				String pay_gl_yymm;
				String inv_xch_rt;
				String pay_xch_rt;
				String pay_amt;
				
				String coa_seq;
				String gain_loss_amt;
				
				int accounting_line_no = 0;
				String accounting_header_id = ""; 
				String accounting_event_id = ""; 
				
				for(int i=0; i < accountingPaymentCancelCheckVO.size(); i++ ) {
					
					accounting_header_id = dbDao.searchAccountingHeaderIdInfo();
					accounting_event_id = dbDao.searchAccountingEventIdInfo();
					
					accountingPaymentCancelCheckVO.get(i).setUsrId(usrId);
					accountingPaymentCancelCheckVO.get(i).setAccountingRequestId(accounting_request_id);
					accountingPaymentCancelCheckVO.get(i).setAccountingHeaderId(accounting_header_id);
					accountingPaymentCancelCheckVO.get(i).setAccountingEventId(accounting_event_id);
				}
				
				dbDao.addAccountingEventPayCancelInfo(accountingPaymentCancelCheckVO);
				dbDao.addAccountingHeaderPayCancelInfo(accountingPaymentCancelCheckVO);
				
				
				for(int i=0; i < accountingPaymentCancelCheckVO.size(); i++ ) {	                                            
					accountingPaymentCancelLineCheckVOs = dbDao.searchAccountingPaymentCancelLineCheck(accountingPaymentCancelCheckVO.get(i).getPaySeq());
					
					if(accountingPaymentCancelLineCheckVOs != null && accountingPaymentCancelLineCheckVOs.size() > 0 ) {
						for(int j=0; j < accountingPaymentCancelLineCheckVOs.size(); j++ ) {
							accounting_line_no += 1;
							accounting_header_id = accountingPaymentCancelCheckVO.get(i).getAccountingHeaderId();
							accounting_event_id  = accountingPaymentCancelCheckVO.get(i).getAccountingEventId();
							
							accountingPaymentCancelLineCheckVOs.get(j).setUsrId(usrId);
							accountingPaymentCancelLineCheckVOs.get(j).setAccountingRequestId(accounting_request_id);
							accountingPaymentCancelLineCheckVOs.get(j).setAccountingHeaderId(accounting_header_id);
							accountingPaymentCancelLineCheckVOs.get(j).setAccountingEventId(accounting_event_id);
							accountingPaymentCancelLineCheckVOs.get(j).setAccountingLineNo(accounting_line_no+"");
							accountingPaymentCancelLineCheckVOs.get(j).setFunctionalCurrency(functional_currency_code);
							
							accountingPaymentCancelLineCheckFullVOs.add(accountingPaymentCancelLineCheckVOs.get(j));
							
							detailPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
							detailPaymentVOs.add(accountingPaymentCancelLineCheckVOs.get(j));
							dbDao.addAccountingDetailPayCancelDetailInfo(detailPaymentVOs);
							
							
							gainLossChkArr = dbDao.searchAccountingPaymentCancelLineGainLossCheck(accountingPaymentCancelLineCheckVOs.get(j));
							inv_gl_yymm = gainLossChkArr[0];
							pay_gl_yymm = gainLossChkArr[1];
							inv_xch_rt  = gainLossChkArr[2];
							pay_xch_rt  = gainLossChkArr[3];
							pay_amt     = gainLossChkArr[4];
							
							if(gainLossChkArr != null) {
								if (!(inv_gl_yymm.equals(pay_gl_yymm)) && !(inv_xch_rt.equals(pay_xch_rt))) {
									accounting_line_no += 1;
									
									coaCtnt = dbDao.searchAccountingPaymentInvLiabilityInfoCheck(accountingPaymentCancelLineCheckVOs.get(j).getInvSeq());
									if(Float.valueOf(pay_xch_rt).compareTo(Float.valueOf(inv_xch_rt)) > 0 ) {
										if(Integer.parseInt(pay_amt) >= 0 ) {
											gain_loss_type = "LOSS";
										} else {
											gain_loss_type = "GAIN";
										}
									} else {
										if(Integer.parseInt(pay_amt) >= 0 ) {
											gain_loss_type = "GAIN";
										} else {
											gain_loss_type = "LOSS";
										}
									}
									
									if("LOSS".equals(gain_loss_type)) {
										coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
										paramCoaArr = new String[6];
										paramCoaArr[0] = coaArr[0];  //company
										paramCoaArr[1] = coaCtnt[0];  //region **
										paramCoaArr[2] = coaCtnt[1];  //center ** 
										paramCoaArr[3] = coaArr[3];  //account
										paramCoaArr[4] = coaArr[4];  //intercompany
										paramCoaArr[5] = coaArr[5];  //vvd
										coa_seq = dbDao.searchAccountingPaymentInvLossCoaInfo(paramCoaArr);
										
										String[] ccidChk = new String[2];
										if("".equals(JSPUtil.getNull(coa_seq))) {
											ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
											if(!ccidChk[0].equals("OK")) {												
												String resultMsg =new ErrorHandler("COM12241",new String[]{"LOSS CCID"}).getUserMessage();
												throw new EventException(resultMsg);
											} else {
												coa_seq = ccidChk[1]; 
											}											
										}
										gain_loss_amt = dbDao.searchAccountingPaymentInvGainLossAmtInfo(accountingPaymentCancelLineCheckVOs.get(j));
										
										gainLossPaymentVO = new AccountingPaymentLineCheckVO();
										
										ObjectCloner.build(accountingPaymentCancelLineCheckVOs.get(j), gainLossPaymentVO);
										
										gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
										gainLossPaymentVO.setCoaSeq(coa_seq);
										gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
										lossPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
										lossPaymentVOs.add(gainLossPaymentVO);
										dbDao.addAccountingDetailPayCancelLossInfo(lossPaymentVOs);
										
									} else if("GAIN".equals(gain_loss_type)) {
										coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
										paramCoaArr = new String[6];
										paramCoaArr[0] = coaArr[0];  //company
										paramCoaArr[1] = coaCtnt[0];  //region **
										paramCoaArr[2] = coaCtnt[1];  //center ** 
										paramCoaArr[3] = coaArr[3];  //account
										paramCoaArr[4] = coaArr[4];  //intercompany
										paramCoaArr[5] = coaArr[5];  //vvd
										coa_seq = dbDao.searchAccountingPaymentInvGainCoaInfo(paramCoaArr);
										
										String[] ccidChk = new String[2];
										if("".equals(JSPUtil.getNull(coa_seq))) {
											ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
											if(!ccidChk[0].equals("OK")) {												
												String resultMsg =new ErrorHandler("COM12241",new String[]{"GAIN CCID"}).getUserMessage();
												throw new EventException(resultMsg);
											} else {
												coa_seq = ccidChk[1]; 
											}											
										}
										
										gain_loss_amt = dbDao.searchAccountingPaymentInvGainLossAmtInfo(accountingPaymentCancelLineCheckVOs.get(j));
										
										gainLossPaymentVO = new AccountingPaymentLineCheckVO();
										
										ObjectCloner.build(accountingPaymentCancelLineCheckVOs.get(j), gainLossPaymentVO);
										
										gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
										gainLossPaymentVO.setCoaSeq(coa_seq);
										gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
										gainPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
										gainPaymentVOs.add(gainLossPaymentVO);
										dbDao.addAccountingDetailPayCancelGainInfo(gainPaymentVOs);
									
										
									}
								}
							}
						}
						
					}
				}
				
				for(int i=0; i < accountingPaymentCancelCheckVO.size(); i++ ) {	
					String pay_accounted_cr = dbDao.searchAccountingDetailPayFunctionalAmtInfo(accountingPaymentCancelCheckVO.get(i).getPaySeq());
					String[] drCrSumArr = dbDao.searchAccountingDetailPayAccountedSumInfo(accounting_header_id);
					String accounted_dr_sum = drCrSumArr[0];
					String accounted_cr_sum = drCrSumArr[1];
					String accounted_round_dr = "";
					String accounted_round_cr = "";
					
					if (Float.valueOf(accounted_dr_sum).compareTo(( Float.valueOf(Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr))) ) > 0 ) {
						accounted_round_dr = ( Float.parseFloat(accounted_dr_sum) - (Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr)) ) + ""; 
					} else if (Float.valueOf(accounted_dr_sum).compareTo(Float.valueOf ( Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr) )) < 0 ) {
						accounted_round_cr = (Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr) - Float.parseFloat(accounted_dr_sum) ) + "";
					} else {
						accounted_round_dr = "0";
						accounted_round_cr = "0";
					}
					
					if (accounted_round_dr.equals("0") || accounted_round_cr.equals("0")) {
						accounting_line_no += 1;
						String[] paramCoaArr2 = dbDao.searchAccountingPaymentInvRoundInfoCheck();
						coa_seq = paramCoaArr2[6];
						
						String[] ccidChk = new String[2];
						if("".equals(JSPUtil.getNull(coa_seq))) {
							ccidChk = checkAPAccountSetup("", paramCoaArr2, arrAcctParams);
							if(!ccidChk[0].equals("OK")) {												
								String resultMsg =new ErrorHandler("COM12241",new String[]{"ROUNDING CCID"}).getUserMessage();
								throw new EventException(resultMsg);
							} else {
								coa_seq = ccidChk[1]; 
							}											
						}
						AccountingPaymentCheckVO tempCheckVO = new AccountingPaymentCheckVO();
						ObjectCloner.build(accountingPaymentCancelCheckVO.get(i), tempCheckVO);
						tempCheckVO.setAccountingLineNo(accounting_line_no + "");
						tempCheckVO.setCoaSeq(coa_seq);
						roundPaymentHVOs.add(tempCheckVO);
					}
					accounting_line_no += 1;
					AccountingPaymentCheckVO tempCheckVO = new AccountingPaymentCheckVO();
					ObjectCloner.build(accountingPaymentCancelCheckVO.get(i), tempCheckVO);
					tempCheckVO.setAccountingLineNo(accounting_line_no + "");						
					roundPaymentDVOs.add(tempCheckVO);	
				}

				dbDao.modifyAccountingDetailPayLineFlag(accountingPaymentCancelLineCheckFullVOs);
				 
				//round
				if (roundPaymentHVOs.size() > 0) {
					dbDao.addAccountingDetailPayCancelRoundInfo(roundPaymentHVOs);
				}
				if (roundPaymentDVOs.size() > 0) {
					dbDao.addAccountingDetailPayHeaderCancelInfo(roundPaymentDVOs);
				}
				
			} // end of accountingPaymentCancelCheckVO if 					
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}	
	
   /**
	 * processPrepaymentApply
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */		
	public void processPrepaymentApply(String[] arrAcctParams) throws EventException {
		
		String capturePeriod 			= JSPUtil.getNull(arrAcctParams[0]);
		String csrNo 					= JSPUtil.getNull(arrAcctParams[1]);
		String functional_currency_code = JSPUtil.getNull(arrAcctParams[2]);
		String accounting_request_id 	= JSPUtil.getNull(arrAcctParams[3]);
		String usrId 					= JSPUtil.getNull(arrAcctParams[4]);
		
		
		try { 
			//List<AccountingPaymentCheckVO> accountingPrepayApplyCheckVOs = dbDao.searchAccountingPrepayApplyCheck(capturePeriod);
			List<AccountingPaymentCheckVO> accountingPrepayApplyCheckVOs = null;
			if(!capturePeriod.equals("")) { 
				accountingPrepayApplyCheckVOs = dbDao.searchAccountingPrepayApplyCheck(capturePeriod);
			} else {
				accountingPrepayApplyCheckVOs = dbDao.searchAccountingPrepayApplyCheckCsrNo(csrNo);
			}
			
			if(accountingPrepayApplyCheckVOs != null && accountingPrepayApplyCheckVOs.size() > 0 ) {
				
				List<AccountingPaymentCheckVO> gainPaymentVOs = new ArrayList<AccountingPaymentCheckVO>();
				List<AccountingPaymentCheckVO> lossPaymentVOs = new ArrayList<AccountingPaymentCheckVO>();
				
				AccountingPaymentCheckVO gainLossPaymentVO;
				
				String gain_loss_type = "";
				String[] gainLossChkArr;
				String[] coaCtnt;
				String[] coaArr;
				String[] paramCoaArr;
				
				//String inv_gl_yymm;
				//String pay_gl_yymm;
				String inv_xch_rt;
				String pay_xch_rt;
				String pay_amt;
				
				String coa_seq;
				String gain_loss_amt;
				
				int accounting_line_no = 0;
				String accounting_header_id = ""; 
				String accounting_event_id = ""; 
				
				for(int i=0; i < accountingPrepayApplyCheckVOs.size(); i++ ) {
					
					accounting_header_id = dbDao.searchAccountingHeaderIdInfo();
					accounting_event_id = dbDao.searchAccountingEventIdInfo();
					
					accountingPrepayApplyCheckVOs.get(i).setUsrId(usrId);
					accountingPrepayApplyCheckVOs.get(i).setAccountingRequestId(accounting_request_id);
					accountingPrepayApplyCheckVOs.get(i).setAccountingHeaderId(accounting_header_id);
					accountingPrepayApplyCheckVOs.get(i).setAccountingEventId(accounting_event_id);
					accountingPrepayApplyCheckVOs.get(i).setFunctionalCurrency(functional_currency_code);
				}
				
				dbDao.addAccountingEventPrepayApplyInfo(accountingPrepayApplyCheckVOs);
				dbDao.addAccountingHeaderPrepayApplyInfo(accountingPrepayApplyCheckVOs);
				dbDao.addAccountingDetailPrepayApplyLineInfo(accountingPrepayApplyCheckVOs);
				dbDao.addAccountingDetailPrepayApplyLiabilityInfo(accountingPrepayApplyCheckVOs);
				
				for(int i=0; i < accountingPrepayApplyCheckVOs.size(); i++ ) {	
							
					gainLossChkArr = dbDao.searchAccountingPrepayApplyGainLossCheck(accountingPrepayApplyCheckVOs.get(i).getInvDtrbSeq());
					//inv_gl_yymm = gainLossChkArr[0];
					//pay_gl_yymm = gainLossChkArr[1];
					inv_xch_rt  = gainLossChkArr[2];
					pay_xch_rt  = gainLossChkArr[3];
					pay_amt     = gainLossChkArr[4];
					
					if(gainLossChkArr != null) {
						if (!(inv_xch_rt.equals(pay_xch_rt))) {
							accounting_line_no += 1;
							
							coaCtnt = dbDao.searchAccountingPrepayApplyLiabilityInfoCheck(accountingPrepayApplyCheckVOs.get(i).getInvDtrbSeq());
							if(Float.valueOf(pay_xch_rt).compareTo(Float.valueOf(inv_xch_rt)) > 0 ) {
								if(Integer.parseInt(pay_amt) < 0 ) {
									gain_loss_type = "LOSS";
								} else {
									gain_loss_type = "GAIN";
								}
							} else {
								if(Integer.parseInt(pay_amt) < 0 ) {
									gain_loss_type = "GAIN";
								} else {
									gain_loss_type = "LOSS";
								}
							}
							
							if("LOSS".equals(gain_loss_type)) {
								coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvLossCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"LOSS CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gain_loss_amt = dbDao.searchAccountingPrepayApplyGainLossAmtInfo(accountingPrepayApplyCheckVOs.get(i).getInvDtrbSeq(), accountingPrepayApplyCheckVOs.get(i).getFunctionalCurrency());
								
								gainLossPaymentVO = new AccountingPaymentCheckVO();
								
								ObjectCloner.build(accountingPrepayApplyCheckVOs.get(i), gainLossPaymentVO);
								
								gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
								gainLossPaymentVO.setCoaSeq(coa_seq);
								gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
								
								lossPaymentVOs.add(gainLossPaymentVO);
								
							} else if("GAIN".equals(gain_loss_type)) {
								coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvGainCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"GAIN CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gain_loss_amt = dbDao.searchAccountingPrepayApplyGainLossAmtInfo(accountingPrepayApplyCheckVOs.get(i).getInvDtrbSeq(), accountingPrepayApplyCheckVOs.get(i).getFunctionalCurrency());
								
								gainLossPaymentVO = new AccountingPaymentCheckVO();
								
								ObjectCloner.build(accountingPrepayApplyCheckVOs.get(i), gainLossPaymentVO);
								
								gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
								gainLossPaymentVO.setCoaSeq(coa_seq);
								gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
								
								gainPaymentVOs.add(gainLossPaymentVO);
							
							}
						}
					}
					
				} // end of accountingPrepayApplyCheckVOs loop
				 
				// loss & gain 
				if (lossPaymentVOs.size() > 0) {
					dbDao.addAccountingDetailPrepayApplyLossInfo(lossPaymentVOs);
				}
				if (gainPaymentVOs.size() > 0) {
					dbDao.addAccountingDetailPrepayApplyGainInfo(gainPaymentVOs);
				}
				
				AccountPayableInvoiceBC	   invCommand = new AccountPayableInvoiceBCImpl();					
				invCommand.modifyAccountingDetailPrepayApplyLineFlag(accountingPrepayApplyCheckVOs);
				
			} // end of accountingPrepayApplyCheckVOs if 	
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}	
	
   /**
	 * processPrepaymentUnapply
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */		
	public void processPrepaymentUnapply(String[] arrAcctParams) throws EventException {
		
		String capturePeriod 			= JSPUtil.getNull(arrAcctParams[0]);
		String csrNo 					= JSPUtil.getNull(arrAcctParams[1]);
		String functional_currency_code = JSPUtil.getNull(arrAcctParams[2]);
		String accounting_request_id 	= JSPUtil.getNull(arrAcctParams[3]);
		String usrId 					= JSPUtil.getNull(arrAcctParams[4]);
		
		try { 
			//List<AccountingPaymentCheckVO> accountingPrepayUnapplyCheckVOs = dbDao.searchAccountingPrepayUnApplyCheck(capturePeriod);
			List<AccountingPaymentCheckVO> accountingPrepayUnapplyCheckVOs = null;
			if(!capturePeriod.equals("")) { 
				accountingPrepayUnapplyCheckVOs = dbDao.searchAccountingPrepayUnApplyCheck(capturePeriod);
			} else {
				accountingPrepayUnapplyCheckVOs = dbDao.searchAccountingPrepayUnApplyCheckCsrNo(csrNo);
			}
			
			if(accountingPrepayUnapplyCheckVOs != null && accountingPrepayUnapplyCheckVOs.size() > 0 ) {
				
				List<AccountingPaymentCheckVO> gainPaymentVOs = new ArrayList<AccountingPaymentCheckVO>();
				List<AccountingPaymentCheckVO> lossPaymentVOs = new ArrayList<AccountingPaymentCheckVO>();
				
				AccountingPaymentCheckVO gainLossPaymentVO;
				
				String gain_loss_type = "";
				String[] gainLossChkArr;
				String[] coaCtnt;
				String[] coaArr;
				String[] paramCoaArr;
				
				//String inv_gl_yymm;
				//String pay_gl_yymm;
				String inv_xch_rt;
				String pay_xch_rt;
				String pay_amt;
				
				String coa_seq;
				String gain_loss_amt;
				
				int accounting_line_no = 0;
				String accounting_header_id = ""; 
				String accounting_event_id = ""; 
				
				for(int i=0; i < accountingPrepayUnapplyCheckVOs.size(); i++ ) {
					
					accounting_header_id = dbDao.searchAccountingHeaderIdInfo();
					accounting_event_id = dbDao.searchAccountingEventIdInfo();
					
					accountingPrepayUnapplyCheckVOs.get(i).setUsrId(usrId);
					accountingPrepayUnapplyCheckVOs.get(i).setAccountingRequestId(accounting_request_id);
					accountingPrepayUnapplyCheckVOs.get(i).setAccountingHeaderId(accounting_header_id);
					accountingPrepayUnapplyCheckVOs.get(i).setAccountingEventId(accounting_event_id);
					accountingPrepayUnapplyCheckVOs.get(i).setFunctionalCurrency(functional_currency_code);
				}
				
				dbDao.addAccountingEventPrepayUnApplyInfo(accountingPrepayUnapplyCheckVOs);
				dbDao.addAccountingHeaderPrepayUnApplyInfo(accountingPrepayUnapplyCheckVOs);
				dbDao.addAccountingDetailPrepayUnApplyLineInfo(accountingPrepayUnapplyCheckVOs);
				dbDao.addAccountingDetailPrepayUnApplyLiabilityInfo(accountingPrepayUnapplyCheckVOs);
				
				for(int i=0; i < accountingPrepayUnapplyCheckVOs.size(); i++ ) {	
							
					gainLossChkArr = dbDao.searchAccountingPrepayApplyGainLossCheck(accountingPrepayUnapplyCheckVOs.get(i).getInvDtrbSeq());
					//inv_gl_yymm = gainLossChkArr[0];
					//pay_gl_yymm = gainLossChkArr[1];
					inv_xch_rt  = gainLossChkArr[2];
					pay_xch_rt  = gainLossChkArr[3];
					pay_amt     = gainLossChkArr[4];
					
					if(gainLossChkArr != null) {
						if (!(inv_xch_rt.equals(pay_xch_rt))) {
							accounting_line_no += 1;
							
							coaCtnt = dbDao.searchAccountingPrepayApplyLiabilityInfoCheck(accountingPrepayUnapplyCheckVOs.get(i).getInvDtrbSeq());
							if(Float.valueOf(pay_xch_rt).compareTo(Float.valueOf(inv_xch_rt)) > 0 ) {
								if(Integer.parseInt(pay_amt) > 0 ) {
									gain_loss_type = "LOSS";
								} else {
									gain_loss_type = "GAIN";
								}
							} else {
								if(Integer.parseInt(pay_amt) > 0 ) {
									gain_loss_type = "GAIN";
								} else {
									gain_loss_type = "LOSS";
								}
							}
							
							if("LOSS".equals(gain_loss_type)) {
								coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvLossCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"LOSS CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gain_loss_amt = dbDao.searchAccountingPrepayApplyGainLossAmtInfo(accountingPrepayUnapplyCheckVOs.get(i).getInvDtrbSeq(), accountingPrepayUnapplyCheckVOs.get(i).getFunctionalCurrency());
								
								gainLossPaymentVO = new AccountingPaymentCheckVO();
								
								ObjectCloner.build(accountingPrepayUnapplyCheckVOs.get(i), gainLossPaymentVO);
								
								gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
								gainLossPaymentVO.setCoaSeq(coa_seq);
								gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
								
								lossPaymentVOs.add(gainLossPaymentVO);
								
							} else if("GAIN".equals(gain_loss_type)) {
								coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvGainCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr, arrAcctParams);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"GAIN CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gain_loss_amt = dbDao.searchAccountingPrepayApplyGainLossAmtInfo(accountingPrepayUnapplyCheckVOs.get(i).getInvDtrbSeq(),accountingPrepayUnapplyCheckVOs.get(i).getFunctionalCurrency());
								
								gainLossPaymentVO = new AccountingPaymentCheckVO();
								
								ObjectCloner.build(accountingPrepayUnapplyCheckVOs.get(i), gainLossPaymentVO);
								
								gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
								gainLossPaymentVO.setCoaSeq(coa_seq);
								gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
								
								gainPaymentVOs.add(gainLossPaymentVO);
							
							}
						}
					}
					
				} // end of accountingPrepayUnapplyCheckVOs loop
				 
				// loss & gain 
				if (lossPaymentVOs.size() > 0) {
					dbDao.addAccountingDetailPrepayUnApplyLossInfo(lossPaymentVOs);
				}
				if (gainPaymentVOs.size() > 0) {
					dbDao.addAccountingDetailPrepayUnApplyGainInfo(gainPaymentVOs);
				}
				AccountPayableInvoiceBC	   invCommand = new AccountPayableInvoiceBCImpl();		
				invCommand.modifyAccountingDetailPrepayApplyLineFlag(accountingPrepayUnapplyCheckVOs);
				
			} // end of accountingPrepayUnapplyCheckVOs if 		
	
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}	
	
	
   /**
	 * processErrorCheck
	 * @author ORKIM
	 * @param  String[] arrAcctParams
	 * @exception EventException
   */		
	public void processErrorCheck(String[] arrAcctParams) throws EventException {
		
		//String capturePeriod 			= JSPUtil.getNull(arrAcctParams[0]);
		//String csrNo 					= JSPUtil.getNull(arrAcctParams[1]);
		//String functional_currency_code = JSPUtil.getNull(arrAcctParams[2]);
		String accounting_request_id 	= JSPUtil.getNull(arrAcctParams[3]);
		String usrId 					= JSPUtil.getNull(arrAcctParams[4]);
		
		try { 
			List<AccountingDetailValidateInfoVO> accountingDetailValidateInfoVOs = dbDao.searchAccountingDetailValidateInfo(accounting_request_id);
			
			if(accountingDetailValidateInfoVOs != null && accountingDetailValidateInfoVOs.size() > 0 ) {
				String[] chkValidtAmtArr = new String[4];
				String coa_null_cnt = "";
				String[] chkCoaArr = new String[2]; 
				String tempErrMsg = "";
				boolean isErr = false;
				
				List<AccountingDetailValidateInfoVO> updateAccountingErrVOs = new ArrayList<AccountingDetailValidateInfoVO>();
				AccountingDetailValidateInfoVO accountingDetailValidateInfoVO = null;
				
				for(int i=0; i < accountingDetailValidateInfoVOs.size(); i++ ) {
					tempErrMsg = "";
					chkValidtAmtArr = dbDao.searchAccountingDetailAmountValidate(accountingDetailValidateInfoVOs.get(i));
					//if (( Float.parseFloat(chkValidtAmtArr[0]) != Float.parseFloat(chkValidtAmtArr[1]) ) || ( Float.parseFloat(chkValidtAmtArr[2]) != Float.parseFloat(chkValidtAmtArr[3]) )) {
					if (( Float.valueOf(chkValidtAmtArr[0]).compareTo(Float.valueOf(chkValidtAmtArr[1])) != 0 ) || ( Float.valueOf(chkValidtAmtArr[2]).compareTo(Float.valueOf(chkValidtAmtArr[3])) != 0 )) {
						tempErrMsg = "DR CR Amount is Different";
						isErr = true;
					}
					
					if (!isErr) {
						coa_null_cnt    = dbDao.searchAccountingDetailCoaValidate(accountingDetailValidateInfoVOs.get(i));
						if (Integer.parseInt(coa_null_cnt) > 0) {
							tempErrMsg = "Accounting COA is Null";
							isErr = true;						
						}
					}
					
					chkCoaArr       = dbDao.searchAccountingDetailCoaValueValidate(accountingDetailValidateInfoVOs.get(i));
					if (Integer.parseInt(chkCoaArr[0]) != Integer.parseInt(chkCoaArr[1])) {
						tempErrMsg = "COA is Not Available";
						isErr = true;							
					}
					
					if (isErr) {
						accountingDetailValidateInfoVO = new AccountingDetailValidateInfoVO();
						ObjectCloner.build(accountingDetailValidateInfoVOs.get(i), accountingDetailValidateInfoVO);
						accountingDetailValidateInfoVO.setAcctgErrCd(tempErrMsg);
						accountingDetailValidateInfoVO.setUsrId(usrId);
						updateAccountingErrVOs.add(accountingDetailValidateInfoVO);
					}
					
				} //end of accountingDetailValidateInfoVOs for
				
				
				if (isErr && updateAccountingErrVOs.size() > 0) {
					dbDao.modifyAccountingDetailValidateResultInfo(updateAccountingErrVOs);
				}
				
			} // end of accountingDetailValidateInfoVOs if 
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}
	
}