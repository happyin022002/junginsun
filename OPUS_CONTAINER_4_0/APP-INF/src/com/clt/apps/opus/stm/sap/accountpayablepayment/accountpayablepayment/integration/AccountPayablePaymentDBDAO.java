/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountPayablePaymentDBDAO.java
 *@FileTitle : AccountPayablePaymentDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
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
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APAccountingListVO;  
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingCondVO;  
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipLineListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentSlipListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchSelectedListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchEntryVendorSumInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCancelCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingPaymentCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingPaymentLineCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingDetailValidateInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APTransactionVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APTransactionCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentProcessListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentCSRInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentCompleteCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentBANKExistsCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APIFPaymentBANKInfoCheckVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * AccountPayablePaymentDBDAO <br>
 * - AccountPayablePaymentBC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see   AccountPayablePaymentBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AccountPayablePaymentDBDAO extends DBDAOSupport {
	
	/**
	 * [STM_SAP_0050]
	 * Payment Schedule Inquiry - Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param PaymentScheduleCondVO paymentScheduleCondVO
	 * @return List<PaymentScheduleCondVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentScheduleListVO> searchPaymentScheduleList(PaymentScheduleCondVO paymentScheduleCondVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<PaymentScheduleListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (paymentScheduleCondVO != null) {
				Map<String, String> mapVO= paymentScheduleCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentScheduleListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentScheduleListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}
	
	/**
	 * [STM_SAP_0070]
	 *  Payment Slip - Payment Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param PaymentSlipCondVO paymentSlipCondVO
	 * @return List<PaymentSlipListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentSlipListVO> searchPaymentSlipList(PaymentSlipCondVO paymentSlipCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PaymentSlipListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (paymentSlipCondVO != null) {
				Map<String, String> mapVO= paymentSlipCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentSlipListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentSlipListVO.class);
						
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
		
	}
	
	/**
	 * [STM_SAP_0070]
	 *  Payment Slip - Payment Detail Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param String paySeq
	 * @return List<PaymentSlipLineListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentSlipLineListVO> searchPaymentSlipLineList(String paySeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PaymentSlipLineListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (paySeq != null) {
				param.put("pay_seq", paySeq);
				velParam.put("pay_seq", paySeq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentSlipLineListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentSlipLineListVO.class);
						
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
		
	}
	
	
	/**
	 * [STM_SAP_0130]
	 * Inquiry of Bank Balance - Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO
	 * @return List<BankBalanceByOfficeCondVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BankBalanceByOfficeVO> searchBankBalanceByOffice(BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BankBalanceByOfficeVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bankBalanceByOfficeCondVO != null) {
				Map<String, String> mapVO= bankBalanceByOfficeCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchBankBalanceByOfficeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankBalanceByOfficeVO.class);
						
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
				
	}
	
	/**
	 * [STM_SAP_0330]
	 * Payment Detail Inquiry<br>
	 *
	 * @author sangyoung cha
	 * @param PaymentDetailListVO paymentDetailListVO
	 * @return List<PaymentDetailListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentDetailListVO> searchPaymentDetailList(PaymentDetailListVO paymentDetailListVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<PaymentDetailListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (paymentDetailListVO != null) {
				
				Map<String, String> mapVO= paymentDetailListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentDetailListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}	
	
	
	/**
	 * [STM_SAP_0330]
	 * Payment Detail Inquiry Current Sum<br>
	 *
	 * @author sangyoung cha
	 * @param PaymentDetailCurrSumListVO paymentDetailCurrSumListVO
	 * @return List<PaymentDetailCurrSumListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentDetailCurrSumListVO> searchPaymentDetailCurrSumList(PaymentDetailCurrSumListVO paymentDetailCurrSumListVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<PaymentDetailCurrSumListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (paymentDetailCurrSumListVO != null) {
				
				Map<String, String> mapVO= paymentDetailCurrSumListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentDetailCurrSumListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentDetailListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}		
	
	/**
	 * [STM_SAP_0060]
	 * Payment Entry List<br>
	 *
	 * @author sangyoung cha
	 * @param PaymentEntryVO paymentEntryVO
	 * @return List<PaymentEntryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentEntryVO> searchPaymentEntryList(PaymentEntryVO paymentEntryVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<PaymentEntryVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (paymentEntryVO != null) {
				
				Map<String, String> mapVO= paymentEntryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentEntryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentEntryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}	
	
	
	
	/**
	 * [STM_SAP_0060]
	 * Payment Entry Line List<br>
	 *
	 * @author sangyoung cha
	 * @param String paySeq 
	 * @return List<PaymentEntryLineVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentEntryLineVO> searchPaymentEntryLineList(String paySeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<PaymentEntryLineVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (paySeq != null) {
				param.put("pay_seq", paySeq);					
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentEntryLineListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentEntryLineVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}
	
	
	/**
	 * [STM_SAP_0060]
	 * searchLineVendorPaymentNoDupCheck <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category searchLineVendorPaymentNoDupCheck
	 * @param SapCommonVO sapCommonVO
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	 
	public SapCommonVO searchLineVendorPaymentNoDupCheck(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {	
				param.put("inv_no", sapCommonVO.getValue0());	
				velParam.put("inv_no", sapCommonVO.getValue0());					
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchLineVendorPaymentNoDupCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapCommonVO.class); 
			if(list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}	
		

	/**
	 * [STM_SAP_0060]
	 * Payment Header을 생성하는데 NEXT PAY_SEQ 채번<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category searchNextPaySeq
	 * @return String
	 * @exception DAOException
	 */	 
	public String searchNextPaySeq() throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchNextPaySeqRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("PAY_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}   	
	
	
	/**
	 * [STM_SAP_0060]
	 * Payment Header을 생성하는데 NEXT PAY_NO 채번<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category searchNextPayNo
	 * @param  String pay_mzd_lu_cd
	 * @return String
	 * @exception DAOException
	 */	 
	public String searchNextPayNo(String pay_mzd_lu_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("pay_mzd_lu_cd", pay_mzd_lu_cd);	
			velParam.put("pay_mzd_lu_cd", pay_mzd_lu_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchNextPayNoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("PAY_NO");
			}			
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	} 	 
 	

	/**
	 * [STM_SAP_0060]
	 * SCO_LU_DTL 테이블에 next Pay No 를 업데이트<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category modifyNextPayNo
	 * @param List<PaymentEntryVO> paymentEntryVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyNextPayNo(List<PaymentEntryVO> paymentEntryVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentEntryVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyNextPayNoUSQL(), paymentEntryVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 * [STM_SAP_0060]
	 * Payment Header을 생성하는데 Input Data<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category addPaymentHeader
	 * @param List<PaymentEntryVO> paymentEntryVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addPaymentHeader(List<PaymentEntryVO> paymentEntryVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentEntryVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddPaymentHeaderCSQL(), paymentEntryVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * [STM_SAP_0060]
	 * Payment Line을  생성하는데 Input Data<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category addPaymentLine
	 * @param List<PaymentEntryLineVO> paymentEntryLineVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addPaymentLine(List<PaymentEntryLineVO> paymentEntryLineVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentEntryLineVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddPaymentLineCSQL(), paymentEntryLineVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [STM_SAP_0060]
	 * searchPaymentStatusCheck <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category searchPaymentStatusCheck
	 * @param SapCommonVO sapCommonVO
	 * @return String
	 * @exception DAOException
	*/
	public String searchPaymentStatusCheck(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {	
				param.put("pay_seq", sapCommonVO.getValue0());	
				velParam.put("pay_seq", sapCommonVO.getValue0());					
			}
								
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentStatusCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("ACCTG_YN");
			}     
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
			 
 
	/**
	 * [STM_SAP_0060]
	 * payment header 삭제 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category removePaymentHeader
	 * @param List<PaymentEntryVO> paymentEntryVO
	 * @exception DAOException
	 */
	public void removePaymentHeader(List<PaymentEntryVO> paymentEntryVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (paymentEntryVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAORemovePaymentHeaderDSQL(), paymentEntryVO, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
		
	/**
	 * [STM_SAP_0060]
	 * payment line 삭제 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category removePaymentLineByPaySeq
	 * @param List<PaymentEntryVO> paymentEntryVO
	 * @exception DAOException
	 */
	public void removePaymentLineByPaySeq(List<PaymentEntryVO> paymentEntryVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (paymentEntryVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAORemovePaymentLineByPaySeqDSQL(), paymentEntryVO, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	
	
	/**
	 * [STM_SAP_0060]
	 * payment header void 처리 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category modifyPaymentHeaderVoid
	 * @param List<PaymentEntryVO> paymentEntryVO
	 * @exception DAOException
	 */
	public void modifyPaymentHeaderVoid(List<PaymentEntryVO> paymentEntryVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (paymentEntryVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyPaymentHeaderVoidUSQL(), paymentEntryVO, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [STM_SAP_0060]
	 * payment line void 시 rvs_flg 컬럼 'Y' 처리 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category modifyPaymentLineVoidRvsFlg
	 * @param List<PaymentEntryVO> paymentEntryVO
	 * @exception DAOException
	 */
	public void modifyPaymentLineVoidRvsFlg(List<PaymentEntryVO> paymentEntryVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (paymentEntryVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyPaymentLineVoidRvsFlgUSQL(), paymentEntryVO, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	
	/**
	 * [STM_SAP_0060]
	 * payment line void 처리 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category addPaymentLineVoid
	 * @param List<PaymentEntryVO> paymentEntryVO
	 * @exception DAOException
	 */
	public void addPaymentLineVoid(List<PaymentEntryVO> paymentEntryVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (paymentEntryVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddPaymentLineVoidCSQL(), paymentEntryVO, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
		 
		 
	/**
	 * [STM_SAP_0060]
	 * payment header update <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category modifyPaymentHeader
	 * @param List<PaymentEntryVO> paymentEntryVO
	 * @exception DAOException
	 */
	public void modifyPaymentHeader(List<PaymentEntryVO> paymentEntryVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (paymentEntryVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyPaymentHeaderUSQL(), paymentEntryVO, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}			 
		 
		
	/**
	 * [STM_SAP_0060]
	 * Payment Line Update<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category modifyPaymentLine
	 * @param List<PaymentEntryLineVO> paymentEntryLineVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyPaymentLine(List<PaymentEntryLineVO> paymentEntryLineVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentEntryLineVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyPaymentLineUSQL(), paymentEntryLineVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
		
		 
	/**
	 * [STM_SAP_0060]
	 * Payment Line Delete<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category removePaymentLine
	 * @param List<PaymentEntryLineVO> paymentEntryLineVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void removePaymentLine(List<PaymentEntryLineVO> paymentEntryLineVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentEntryLineVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAORemovePaymentLineDSQL(), paymentEntryLineVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}			 
		 
	/**
	 * [STM_SAP_0210]
	 * searchPaymentBatchList<br>
	 *
	 * @author ORKIM
	 * @param PaymentBatchCondVO paymentBatchCondVO
	 * @return List<PaymentBatchListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentBatchListVO> searchPaymentBatchList(PaymentBatchCondVO paymentBatchCondVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<PaymentBatchListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (paymentBatchCondVO != null) {
				Map<String, String> mapVO= paymentBatchCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentBatchListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentBatchListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}		

	/**
	 * [STM_SAP_0210]
	 * searchPaymentBatchSelectedList<br>
	 *
	 * @author ORKIM
	 * @param String pay_bat_seq
	 * @param String pay_bat_nm
	 * @return List<PaymentBatchSelectedListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentBatchSelectedListVO> searchPaymentBatchSelectedList(String pay_bat_seq, String pay_bat_nm) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<PaymentBatchSelectedListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (pay_bat_seq != null) {
				param.put("pay_bat_seq", pay_bat_seq);	
				velParam.put("pay_bat_seq", pay_bat_seq);
				
				param.put("pay_bat_nm", pay_bat_nm);	
				velParam.put("pay_bat_nm", pay_bat_nm);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentBatchSelectedListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentBatchSelectedListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}	
		 
	/**
	 * [STM_SAP_0210]
	 * searchPaymentPossibleInvoiceList<br>
	 *
	 * @author ORKIM
	 * @param String inv_no
	 * @param String pay_bat_seq
	 * @param String pay_bat_nm
	 * @return List<PaymentBatchSelectedListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentBatchSelectedListVO> searchPaymentPossibleInvoiceList(String inv_no, String pay_bat_seq, String pay_bat_nm) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<PaymentBatchSelectedListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (pay_bat_seq != null) {
				
				param.put("inv_no", inv_no);	
				param.put("pay_bat_seq", pay_bat_seq);	
				param.put("pay_bat_nm", pay_bat_nm);	
				
				velParam.put("inv_no", inv_no);
				velParam.put("pay_bat_seq", pay_bat_seq);
				velParam.put("pay_bat_nm", pay_bat_nm);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentPossibleInvoiceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentBatchSelectedListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}	
	
	/**
	 * [STM_SAP_0210]
	 * searchPaymentBatchUniqueCheck<br>
	 *
	 * @author ORKIM
	 * @param String pay_bat_nm
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPaymentBatchUniqueCheck(String pay_bat_nm) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (pay_bat_nm != null) {
				param.put("pay_bat_nm", pay_bat_nm);	
				velParam.put("pay_bat_nm", pay_bat_nm);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentBatchUniqueCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("DUP_CHK");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
		
	}	
	
	/**
	 * [STM_SAP_0210]
	 * searchPaymentBatchNameDupCheck<br>
	 *
	 * @author ORKIM
	 * @param String pay_bat_nm
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPaymentBatchNameDupCheck(String pay_bat_nm) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (pay_bat_nm != null) {
				param.put("pay_bat_nm", pay_bat_nm);	
				velParam.put("pay_bat_nm", pay_bat_nm);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentBatchNameDupCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("PAY_BAT_NM");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0210]
	 * selectPaymentProcessDupCheck<br>
	 *
	 * @author ORKIM
	 * @param String bank_acct_seq
	 * @param String pay_mzd_lu_cd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String selectPaymentProcessDupCheck(String bank_acct_seq, String pay_mzd_lu_cd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bank_acct_seq != null) {
				param.put("bank_acct_seq", bank_acct_seq);	
				velParam.put("bank_acct_seq", bank_acct_seq);
				param.put("pay_mzd_lu_cd", pay_mzd_lu_cd);	
				velParam.put("pay_mzd_lu_cd", pay_mzd_lu_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSelectPaymentProcessDupCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("CNT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0210]
	 * addPaymentBatchEntryInfo<br>
	 *
	 * @author ORKIM
	 * @param List<PaymentBatchListVO> paymentBatchListVO
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addPaymentBatchEntryInfo(List<PaymentBatchListVO> paymentBatchListVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchListVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddPaymentBatchEntryInfoCSQL(), paymentBatchListVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * [STM_SAP_0210]
	 * selectBatchPaymentHeaderIDSeqCheck<br>
	 *
	 * @author ORKIM
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String selectPaymentBatchEntryIDSeqCheck() throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSelectPaymentBatchEntryIDSeqCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("PAY_BAT_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	 

	/**
	 * [STM_SAP_0210]
	 * modifyPaymentBatchEntryInfo<br>
	 *
	 * @author ORKIM
	 * @param List<PaymentBatchListVO> paymentBatchListVO
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void modifyPaymentBatchEntryInfo(List<PaymentBatchListVO> paymentBatchListVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchListVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyPaymentBatchEntryInfoUSQL(), paymentBatchListVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		 
	/**
	 * [STM_SAP_0210]
	 * removePaymentBatchEntryInfo<br>
	 *
	 * @author ORKIM
	 * @param List<PaymentBatchListVO> paymentBatchListVO
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void removePaymentBatchEntryInfo(List<PaymentBatchListVO> paymentBatchListVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchListVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAORemovePaymentBatchEntryInfoDSQL(), paymentBatchListVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * [STM_SAP_0210]
	 * searchPayCaptureSelectedInvoiceInfoCount<br>
	 *
	 * @author ORKIM
	 * @param List<PaymentBatchListVO> paymentBatchListVO
	 * @return String
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public String searchPayCaptureSelectedInvoiceInfoCount(List<PaymentBatchListVO> paymentBatchListVO) throws DAOException {
			DBRowSet dbRowset = null;
			String rtnValue = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (paymentBatchListVO != null) {
					Map<String, String> mapVO= paymentBatchListVO.get(0).getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPayCaptureSelectedInvoiceInfoCountRSQL(), param, velParam);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("CNT");
				}
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtnValue;
	}	 
	 
	/**
	 * [STM_SAP_0210]
	 * addPayCaptureSelectedInvoiceInfo<br>
	 *
	 * @author ORKIM
	 * @param  List<PaymentBatchListVO> paymentBatchListVO
	 * @return int
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public int addPayCaptureSelectedInvoiceInfo(List<PaymentBatchListVO> paymentBatchListVO) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int resultCnt = 0;	
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchListVO.size() > 0) {
				Map<String, String> mapVO= paymentBatchListVO.get(0).getColumnValues();				
				velParam.putAll(mapVO);
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddPayCaptureSelectedInvoiceInfoCSQL(), paymentBatchListVO, velParam);
			
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					} else {
						resultCnt += 1;
					}
				}
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}
	 
	/**
	 * [STM_SAP_0210]
	 * @author ORKIM
	 * @category STM_SAP_0210
	 * @category modifyPaymentCaptureStatusChangeInfo
	 * @param List<PaymentBatchListVO> paymentBatchListVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyPaymentCaptureStatusChangeInfo(List<PaymentBatchListVO> paymentBatchListVO) throws DAOException {
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchListVO.size() > 0) {
				Map<String, String> mapVO= paymentBatchListVO.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyPaymentCaptureStatusChangeInfoUSQL(), paymentBatchListVO, velParam);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		 
	 
	/**
	 * [STM_SAP_0210]
	 * selectPaymentSelectedInvoiceExistsCheck<br>
	 *
	 * @author ORKIM
	 * @param String pay_bat_seq
	 * @param String pay_bat_nm
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String selectPaymentSelectedInvoiceExistsCheck(String pay_bat_seq, String pay_bat_nm) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (pay_bat_nm != null) {
				param.put("pay_bat_seq", pay_bat_seq);	
				velParam.put("pay_bat_seq", pay_bat_seq);			
				
				param.put("pay_bat_nm", pay_bat_nm);	
				velParam.put("pay_bat_nm", pay_bat_nm);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSelectPaymentSelectedInvoiceExistsCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("BAT_CNT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [STM_SAP_0210]
	 * modifyPaymentBatchEntryEndInfo<br>
	 *
	 * @author ORKIM
	 * @param List<PaymentBatchListVO> paymentBatchListVO
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void modifyPaymentBatchEntryEndInfo(List<PaymentBatchListVO> paymentBatchListVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchListVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyPaymentBatchEntryEndInfoUSQL(), paymentBatchListVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
		 
	/**
	 * [STM_SAP_0210]
	 * searchPaymentPossibleInvoiceList<br>
	 *
	 * @author ORKIM
	 * @param String pay_bat_seq
	 * @param String pay_bat_nm
	 * @return List<PaymentBatchEntryVendorSumInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentBatchEntryVendorSumInfoVO> searchPaymentBatchEntryVendorSumInfo(String pay_bat_seq, String pay_bat_nm) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<PaymentBatchEntryVendorSumInfoVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (pay_bat_seq != null) {
				
				param.put("pay_bat_seq", pay_bat_seq);	
				param.put("pay_bat_nm", pay_bat_nm);	
				
				velParam.put("pay_bat_seq", pay_bat_seq);
				velParam.put("pay_bat_nm", pay_bat_nm);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentBatchEntryVendorSumInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentBatchEntryVendorSumInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}
	
	/**
	 * [STM_SAP_0210]
	 * selectBatchPaymentHeaderIDSeqCheck<br>
	 *
	 * @author ORKIM
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String selectBatchPaymentHeaderIDSeqCheck() throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSelectBatchPaymentHeaderIDSeqCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("PAY_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	 
	/**
	 * [STM_SAP_0210]
	 * addBatchPaymentHeaderAllInfo<br>
	 *
	 * @author ORKIM
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addBatchPaymentHeaderAllInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchEntryVendorSumInfoVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddBatchPaymentHeaderAllInfoCSQL(), paymentBatchEntryVendorSumInfoVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	 
	/**
	 * [STM_SAP_0210]
	 * addBatchPaymentDetailAllInfo<br>
	 *
	 * @author ORKIM
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addBatchPaymentDetailAllInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchEntryVendorSumInfoVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddBatchPaymentDetailAllInfoCSQL(), paymentBatchEntryVendorSumInfoVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 
	/**
	 * [STM_SAP_0210]
	 * modifyPaymentBatchEntryCompleteInfo<br>
	 *
	 * @author ORKIM
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void modifyPaymentBatchEntryCompleteInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchEntryVendorSumInfoVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyPaymentBatchEntryCompleteInfoUSQL(), paymentBatchEntryVendorSumInfoVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	 

	 
	/**
	 * [STM_SAP_0210]
	 * removePaymentSelectedInvoiceAllInfo<br>
	 *
	 * @author ORKIM
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void removePaymentSelectedInvoiceAllInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchEntryVendorSumInfoVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAORemovePaymentSelectedInvoiceAllInfoDSQL(), paymentBatchEntryVendorSumInfoVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 
	 
	 
	/**
	 * [STM_SAP_0210]
	 * addPaymentSelectedInvoiceInfo<br>
	 *
	 * @author ORKIM
	 * @param List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addPaymentSelectedInvoiceInfo(List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchSelectedListVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddPaymentSelectedInvoiceInfoCSQL(), paymentBatchSelectedListVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 	 
	 
	 
	/**
	 * [STM_SAP_0210]
	 * removePaymentSelectedInvoiceInfo<br>
	 *
	 * @author ORKIM
	 * @param List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void removePaymentSelectedInvoiceInfo(List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchSelectedListVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAORemovePaymentSelectedInvoiceInfoDSQL(), paymentBatchSelectedListVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	} 	 
	
	/**
	 * [STM_SAP_0220]
	 * searchAPAccountingList<br>
	 *
	 * @author ORKIM
	 * @param AccountingCondVO accountingCondVO
	 * @return List<APAccountingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<APAccountingListVO> searchAPAccountingList(AccountingCondVO accountingCondVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<APAccountingListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (accountingCondVO != null) {
				Map<String, String> mapVO= accountingCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAPAccountingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APAccountingListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}
		
	/**
	 * [STM_SAP_0220]
	 * searchAccountingExistsCheck<br>
	 *
	 * @author ORKIM
	 * @param String capture_period
	 * @return String[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String[] searchAccountingExistsCheck(String capture_period) throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[3];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (capture_period != null) {
				param.put("capture_period", capture_period);	
				velParam.put("capture_period", capture_period);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingExistsCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("PAY_BAT_NM");
				rtnValue[1] = dbRowset.getString("OFC_CD");
				rtnValue[2] = dbRowset.getString("BATCH_CNT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingRequestIdInfo<br>
	 *
	 * @author ORKIM
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAccountingRequestIdInfo() throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingRequestIdInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("ACCOUNTING_REQUEST_ID");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingEventIdInfo<br>
	 *
	 * @author ORKIM
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAccountingEventIdInfo() throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingEventIdInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("ACCOUNTING_EVENT_ID");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
		
	/**
	 * [STM_SAP_0220]
	 * searchAccountingHeaderIdInfo<br>
	 *
	 * @author ORKIM
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAccountingHeaderIdInfo() throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingHeaderIdInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("ACCOUNTING_HEADER_ID");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingInvoiceCheck<br>
	 *
	 * @author ORKIM
	 * @param  String capture_period
	 * @return List<AccountingInvoiceCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingInvoiceCheckVO> searchAccountingInvoiceCheck(String capture_period) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingInvoiceCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (capture_period != null) {
				param.put("capture_period", capture_period);	
				velParam.put("capture_period", capture_period);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingInvoiceCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingInvoiceCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}	

	/**
	 * [STM_SAP_0220]
	 * searchAccountingInvoiceCheckCsrNo<br>
	 *
	 * @author ORKIM
	 * @param  String csrNo
	 * @return List<AccountingInvoiceCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingInvoiceCheckVO> searchAccountingInvoiceCheckCsrNo(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingInvoiceCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (csrNo != null) {
				param.put("csr_no", csrNo);	
				velParam.put("csr_no", csrNo);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingInvoiceCheckCsrNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingInvoiceCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}	
	 
	/**
	 * [STM_SAP_0220]
	 * addAccountingEventInvInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingEventInvInfo(List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingEventInvInfoCSQL(), accountingInvoiceCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingHeaderInvInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingHeaderInvInfo(List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingHeaderInvInfoCSQL(), accountingInvoiceCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailInvLineInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailInvLineInfo(List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailInvLineInfoCSQL(), accountingInvoiceCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	 /**
	  * [STM_SAP_0220]
	  * addAccountingDetailInvLineExRateInfo<br>
	  *
	  * @author KSJO
	  * @param List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs
	  * @exception DAOException
	  */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailInvLineExRateInfo(List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailInvLineExRateInfoCSQL(), accountingInvoiceCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 /**
	  * [STM_SAP_0220]
	  * addAccountingDetailInvLineGainLossInfo<br>
	  *
	  * @author KSJO
	  * @param List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs
	  * @exception DAOException
	  */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailInvLineGainLossInfo(List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailInvLineGainLossInfoCSQL(), accountingInvoiceCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 /**
	  * [STM_SAP_0220]
	  * addAccountingDetailInvCancelLineGainLossInfo<br>
	  *
	  * @author KSJO
	  * @param List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs
	  * @exception DAOException
	  */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailInvCancelLineGainLossInfo(List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCancelCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailInvCancelLineGainLossInfoCSQL(), accountingInvoiceCancelCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailInvHeaderInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailInvHeaderInfo(List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailInvHeaderInfoCSQL(), accountingInvoiceCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		 
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingInvoiceCancelCheck<br>
	 *
	 * @author ORKIM
	 * @param  String capture_period
	 * @return List<AccountingInvoiceCancelCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingInvoiceCancelCheckVO> searchAccountingInvoiceCancelCheck(String capture_period) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingInvoiceCancelCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (capture_period != null) {
				param.put("capture_period", capture_period);	
				velParam.put("capture_period", capture_period);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingInvoiceCancelCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingInvoiceCancelCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingInvoiceCancelCheckCsrNo<br>
	 *
	 * @author ORKIM
	 * @param  String csrNo
	 * @return List<AccountingInvoiceCancelCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingInvoiceCancelCheckVO> searchAccountingInvoiceCancelCheckCsrNo(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingInvoiceCancelCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (csrNo != null) {
				param.put("csr_no", csrNo);	
				velParam.put("csr_no", csrNo);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingInvoiceCancelCheckCsrNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingInvoiceCancelCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}	
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingEventInvCancelInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingEventInvCancelInfo(List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCancelCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingEventInvCancelInfoCSQL(), accountingInvoiceCancelCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	/**
	 * [STM_SAP_0220]
	 * addAccountingHeaderInvCancelInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingHeaderInvCancelInfo(List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCancelCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingHeaderInvCancelInfoCSQL(), accountingInvoiceCancelCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	 
	 
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailInvLineCancelInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailInvLineCancelInfo(List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCancelCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailInvLineCancelInfoCSQL(), accountingInvoiceCancelCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	 /**
	 * [STM_SAP_0220]
	 * addAccountingDetailInvLineCancelExRateInfo<br>
	 *
	 * @author KSJO
	 * @param List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailInvLineCancelExRateInfo(List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCancelCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailInvLineCancelExRateInfoCSQL(), accountingInvoiceCancelCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
 
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailInvHeaderCancelInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailInvHeaderCancelInfo(List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCancelCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailInvHeaderCancelInfoCSQL(), accountingInvoiceCancelCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * [STM_SAP_0220] PAYMENT
	 * searchAccountingPaymentCheck<br>  
	 *
	 * @author ORKIM
	 * @param  String capture_period
	 * @return List<AccountingPaymentCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingPaymentCheckVO> searchAccountingPaymentCheck(String capture_period) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingPaymentCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (capture_period != null) {
				param.put("capture_period", capture_period);	
				velParam.put("capture_period", capture_period);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingPaymentCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [STM_SAP_0220] PAYMENT
	 * searchAccountingPaymentCheckCsrNo<br>  
	 *
	 * @author ORKIM
	 * @param  String csrNo
	 * @return List<AccountingPaymentCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingPaymentCheckVO> searchAccountingPaymentCheckCsrNo(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingPaymentCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (csrNo != null) {
				param.put("csr_no", csrNo);	
				velParam.put("csr_no", csrNo);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentCheckCsrNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingPaymentCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingEventPayInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingEventPayInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingEventPayInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	/**
	 * [STM_SAP_0220]
	 * addAccountingHeaderPayInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingHeaderPayInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingHeaderPayInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		 

	/**
	 * [STM_SAP_0220]
	 * searchAccountingPaymentLineCheck<br>
	 *
	 * @author ORKIM
	 * @param  String pay_seq
	 * @return List<AccountingPaymentLineCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingPaymentLineCheckVO> searchAccountingPaymentLineCheck(String pay_seq) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingPaymentLineCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (pay_seq != null) {
				param.put("pay_seq", pay_seq);	
				velParam.put("pay_seq", pay_seq);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentLineCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingPaymentLineCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPayDetailInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPayDetailInfo(List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentLineCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPayDetailInfoCSQL(), accountingPaymentLineCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPayHeaderInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPayHeaderInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPayHeaderInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPaymentLineGainLossCheck<br>
	 *
	 * @author ORKIM
	 * @param  AccountingPaymentLineCheckVO accountingPaymentLineCheckVO
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingPaymentLineGainLossCheck(AccountingPaymentLineCheckVO accountingPaymentLineCheckVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[5];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (accountingPaymentLineCheckVO != null) {
				Map<String, String> mapVO= accountingPaymentLineCheckVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentLineGainLossCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("INV_GL_YYMM");
				rtnValue[1] = dbRowset.getString("PAY_GL_YYMM");
				rtnValue[2] = dbRowset.getString("INV_XCH_RT");
				rtnValue[3] = dbRowset.getString("PAY_XCH_RT");
				rtnValue[4] = dbRowset.getString("PAY_AMT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPaymentInvLiabilityInfoCheck<br>
	 *
	 * @author ORKIM
	 * @param  String inv_seq
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingPaymentInvLiabilityInfoCheck(String inv_seq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (inv_seq != null) {
				param.put("inv_seq", inv_seq);				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentInvLiabilityInfoCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("COA_REGION_CODE");
				rtnValue[1] = dbRowset.getString("COA_CENTER_CODE");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPaymentInvLossInfoCheck<br>
	 *
	 * @author ORKIM
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingPaymentInvLossInfoCheck() throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[7];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentInvLossInfoCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("L_COMPANY_CODE");
				rtnValue[1] = dbRowset.getString("L_REGION_CODE");
				rtnValue[2] = dbRowset.getString("L_CENTER_CODE");
				rtnValue[3] = dbRowset.getString("L_ACCOUNT_CODE");
				rtnValue[4] = dbRowset.getString("L_INTERCOMPANY_CODE");
				rtnValue[5] = dbRowset.getString("L_VVD_CODE");
				rtnValue[6] = dbRowset.getString("CD_CMB_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPaymentInvLossCoaInfo<br>
	 *
	 * @author ORKIM
	 * @param  String[] aryStr
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String searchAccountingPaymentInvLossCoaInfo(String[] aryStr) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (aryStr != null) {
				param.put("l_compnay_code",aryStr[0]);
				param.put("coa_region_code",aryStr[1]);
				param.put("coa_center_code",aryStr[2]);
				param.put("l_account_code",aryStr[3]);
				param.put("l_intercompany_code",aryStr[4]);
				param.put("l_vvd_code",aryStr[5]);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentInvLossCoaInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("LOSS_COA_SEQ");				
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPaymentInvGainLossAmtInfo<br>
	 *
	 * @author ORKIM
	 * @param  AccountingPaymentLineCheckVO accountingPaymentLineCheckVO
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String searchAccountingPaymentInvGainLossAmtInfo(AccountingPaymentLineCheckVO accountingPaymentLineCheckVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (accountingPaymentLineCheckVO != null) {
				Map<String, String> mapVO= accountingPaymentLineCheckVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentInvGainLossAmtInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("GAIN_LOSS_AMT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [STM_SAP_0220]
	 * AddAccountingDetailInvLossInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailInvLossInfo(List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentLineCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailInvLossInfoCSQL(), accountingPaymentLineCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPaymentInvGainInfoCheck<br>
	 *
	 * @author ORKIM
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingPaymentInvGainInfoCheck() throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[7];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentInvGainInfoCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("G_COMPANY_CODE");
				rtnValue[1] = dbRowset.getString("G_REGION_CODE");
				rtnValue[2] = dbRowset.getString("G_CENTER_CODE");
				rtnValue[3] = dbRowset.getString("G_ACCOUNT_CODE");
				rtnValue[4] = dbRowset.getString("G_INTERCOMPANY_CODE");
				rtnValue[5] = dbRowset.getString("G_VVD_CODE");
				rtnValue[6] = dbRowset.getString("CD_CMB_SEQ");
				
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPaymentInvGainCoaInfo<br>
	 *
	 * @author ORKIM
	 * @param  String[] aryStr
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String searchAccountingPaymentInvGainCoaInfo(String[] aryStr) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (aryStr != null) {
				param.put("g_compnay_code",aryStr[0]);
				param.put("coa_region_code",aryStr[1]);
				param.put("coa_center_code",aryStr[2]);
				param.put("g_account_code",aryStr[3]);
				param.put("g_intercompany_code",aryStr[4]);
				param.put("g_vvd_code",aryStr[5]);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentInvGainCoaInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("GAIN_COA_SEQ");				
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [STM_SAP_0220]
	 * AddAccountingDetailInvLossInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailInvGainInfo(List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentLineCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailInvGainInfoCSQL(), accountingPaymentLineCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	/**
	 * [STM_SAP_0220]
	 * modifyAccountingDetailPayLineFlag<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void modifyAccountingDetailPayLineFlag(List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentLineCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyAccountingDetailPayLineFlagUSQL(), accountingPaymentLineCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * [STM_SAP_0220]
	 * searchAccountingDetailPayFunctionalAmtInfo<br>
	 *
	 * @author ORKIM
	 * @param  String pay_seq
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String searchAccountingDetailPayFunctionalAmtInfo(String pay_seq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (pay_seq != null) {
				param.put("pay_seq",pay_seq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingDetailPayFunctionalAmtInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("PAY_ACCOUNTED_CR");				
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	 
	
	 
	/**
	 * [STM_SAP_0220]
	 * searchAccountingDetailPayAccountedSumInfo<br>
	 *
	 * @author ORKIM
	 * @param  String accounting_header_id
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingDetailPayAccountedSumInfo(String accounting_header_id) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue[] = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (accounting_header_id != null) {
				param.put("accounting_header_id",accounting_header_id);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingDetailPayAccountedSumInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("ACCOUNTED_DR_SUM");		
				rtnValue[1] = dbRowset.getString("ACCOUNTED_CR_SUM");			
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPaymentInvRoundInfoCheck<br>
	 *
	 * @author ORKIM
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingPaymentInvRoundInfoCheck() throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[7];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentInvRoundInfoCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("COMPANY_CODE");
				rtnValue[1] = dbRowset.getString("REGION_CODE");
				rtnValue[2] = dbRowset.getString("CENTER_CODE");
				rtnValue[3] = dbRowset.getString("ACCOUNT_CODE");
				rtnValue[4] = dbRowset.getString("INTERCOMPANY_CODE");
				rtnValue[5] = dbRowset.getString("VVD_CODE");
				rtnValue[6] = dbRowset.getString("CD_CMB_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailInvRoundInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailInvRoundInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailInvRoundInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	/**
	 * [STM_SAP_0220] PAYMENT Cancel
	 * searchAccountingPaymentCancelCheck<br>  
	 *
	 * @author ORKIM
	 * @param  String capture_period
	 * @return List<AccountingPaymentCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingPaymentCheckVO> searchAccountingPaymentCancelCheck(String capture_period) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingPaymentCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (capture_period != null) {
				param.put("capture_period", capture_period);	
				velParam.put("capture_period", capture_period);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentCancelCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingPaymentCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * [STM_SAP_0220] PAYMENT Cancel
	 * searchAccountingPaymentCancelCheck<br>  
	 *
	 * @author ORKIM
	 * @param  String csrNo
	 * @return List<AccountingPaymentCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingPaymentCheckVO> searchAccountingPaymentCancelCheckCsrNo(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingPaymentCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (csrNo != null) {
				param.put("csr_no", csrNo);	
				velParam.put("csr_no", csrNo);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentCancelCheckCsrNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingPaymentCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
		
	/**
	 * [STM_SAP_0220]
	 * addAccountingEventPayCancelInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingEventPayCancelInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingEventPayCancelInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
		 
	/**
	 * [STM_SAP_0220]
	 * addAccountingHeaderPayCancelInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingHeaderPayCancelInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingHeaderPayCancelInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		 

	/**
	 * [STM_SAP_0220]
	 * searchAccountingPaymentCancelLineCheck<br>
	 *
	 * @author ORKIM
	 * @param  String pay_seq
	 * @return List<AccountingPaymentLineCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingPaymentLineCheckVO> searchAccountingPaymentCancelLineCheck(String pay_seq) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingPaymentLineCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (pay_seq != null) {
				param.put("pay_seq", pay_seq);	
				velParam.put("pay_seq", pay_seq);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentCancelLineCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingPaymentLineCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
		
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPayCancelDetailInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPayCancelDetailInfo(List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentLineCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPayCancelDetailInfoCSQL(), accountingPaymentLineCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
 
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPaymentCancelLineGainLossCheck<br>
	 *
	 * @author ORKIM
	 * @param  AccountingPaymentLineCheckVO accountingPaymentLineCheckVO
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingPaymentCancelLineGainLossCheck(AccountingPaymentLineCheckVO accountingPaymentLineCheckVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[5];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (accountingPaymentLineCheckVO != null) {
				Map<String, String> mapVO= accountingPaymentLineCheckVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPaymentCancelLineGainLossCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("INV_GL_YYMM");
				rtnValue[1] = dbRowset.getString("PAY_GL_YYMM");
				rtnValue[2] = dbRowset.getString("INV_XCH_RT");
				rtnValue[3] = dbRowset.getString("PAY_XCH_RT");
				rtnValue[4] = dbRowset.getString("PAY_AMT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
		


	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPayCancelLossInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPayCancelLossInfo(List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentLineCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPayCancelLossInfoCSQL(), accountingPaymentLineCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
		 
		
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPayCancelGainInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPayCancelGainInfo(List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentLineCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPayCancelGainInfoCSQL(), accountingPaymentLineCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
		 
		
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPayCancelRoundInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPayCancelRoundInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPayCancelRoundInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
		 
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPayHeaderCancelInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPayHeaderCancelInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPayHeaderCancelInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	 
	 
	/**
	 * [STM_SAP_0220] Prepayment Apply
	 * searchAccountingPrepayApplyCheck<br>  
	 *
	 * @author ORKIM
	 * @param  String capture_period
	 * @return List<AccountingPaymentCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingPaymentCheckVO> searchAccountingPrepayApplyCheck(String capture_period) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingPaymentCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (capture_period != null) {
				param.put("capture_period", capture_period);	
				velParam.put("capture_period", capture_period);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPrepayApplyCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingPaymentCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * [STM_SAP_0220] Prepayment Apply
	 * searchAccountingPrepayApplyCheck<br>  
	 *
	 * @author ORKIM
	 * @param  String csrNo
	 * @return List<AccountingPaymentCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingPaymentCheckVO> searchAccountingPrepayApplyCheckCsrNo(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingPaymentCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (csrNo != null) {
				param.put("csr_no", csrNo);	
				velParam.put("csr_no", csrNo);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPrepayApplyCheckCsrNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingPaymentCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingEventPrepayApplyInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingEventPrepayApplyInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingEventPrepayApplyInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	/**
	 * [STM_SAP_0220]
	 * addAccountingHeaderPrepayApplyInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingHeaderPrepayApplyInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingHeaderPrepayApplyInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	 
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPrepayApplyLineInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPrepayApplyLineInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPrepayApplyLineInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	 
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPrepayApplyLiabilityInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPrepayApplyLiabilityInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPrepayApplyLiabilityInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPrepayApplyGainLossCheck<br>
	 *
	 * @author ORKIM
	 * @param  String inv_dtrb_seq
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingPrepayApplyGainLossCheck(String inv_dtrb_seq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[5];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (inv_dtrb_seq != null) {
				param.put("inv_dtrb_seq", inv_dtrb_seq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPrepayApplyGainLossCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("INV_GL_YYMM");
				rtnValue[1] = dbRowset.getString("APPLY_GL_YYMM");
				rtnValue[2] = dbRowset.getString("INV_XCH_RT");
				rtnValue[3] = dbRowset.getString("APPLY_XCH_RT");
				rtnValue[4] = dbRowset.getString("APPLY_AMT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPrepayApplyLiabilityInfoCheck<br>
	 *
	 * @author ORKIM
	 * @param  String inv_dtrb_seq
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingPrepayApplyLiabilityInfoCheck(String inv_dtrb_seq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (inv_dtrb_seq != null) {
				param.put("inv_dtrb_seq", inv_dtrb_seq);				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPrepayApplyLiabilityInfoCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("COA_REGION_CODE");
				rtnValue[1] = dbRowset.getString("COA_CENTER_CODE");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPrepayApplyGainLossAmtInfo<br>
	 *
	 * @author ORKIM
	 * @param  String inv_dtrb_seq
	 * @param  String functional_currency
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String searchAccountingPrepayApplyGainLossAmtInfo(String inv_dtrb_seq, String functional_currency) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (inv_dtrb_seq != null) {
				param.put("inv_dtrb_seq", inv_dtrb_seq);
				param.put("functional_currency", functional_currency);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPrepayApplyGainLossAmtInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("GAIN_LOSS_AMT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPrepayApplyLossInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPrepayApplyLossInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPrepayApplyLossInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPrepayApplyGainInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPrepayApplyGainInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPrepayApplyGainInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 

	/**
	 * [STM_SAP_0220] Prepayment UnApply
	 * searchAccountingPrepayUnApplyCheck<br>  
	 *
	 * @author ORKIM
	 * @param  String capture_period
	 * @return List<AccountingPaymentCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingPaymentCheckVO> searchAccountingPrepayUnApplyCheck(String capture_period) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingPaymentCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (capture_period != null) {
				param.put("capture_period", capture_period);	
				velParam.put("capture_period", capture_period);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPrepayUnApplyCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingPaymentCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * [STM_SAP_0220] Prepayment UnApply
	 * searchAccountingPrepayUnApplyCheck<br>  
	 *
	 * @author ORKIM
	 * @param  String  csrNo
	 * @return List<AccountingPaymentCheckVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingPaymentCheckVO> searchAccountingPrepayUnApplyCheckCsrNo(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingPaymentCheckVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if ( csrNo != null) {
				param.put(" csr_no",  csrNo);	
				velParam.put(" csr_no",  csrNo);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPrepayUnApplyCheckCsrNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingPaymentCheckVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingEventPrepayUnApplyInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingEventPrepayUnApplyInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingEventPrepayUnApplyInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	/**
	 * [STM_SAP_0220]
	 * addAccountingHeaderPrepayUnApplyInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingHeaderPrepayUnApplyInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingHeaderPrepayUnApplyInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	 
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPrepayUnApplyLineInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPrepayUnApplyLineInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPrepayUnApplyLineInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	 
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPrepayUnApplyLiabilityInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPrepayUnApplyLiabilityInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPrepayUnApplyLiabilityInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPrepayUnApplyGainLossCheck<br>
	 *
	 * @author ORKIM
	 * @param  AccountingPaymentLineCheckVO accountingPaymentLineCheckVO
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingPrepayUnApplyGainLossCheck(AccountingPaymentLineCheckVO accountingPaymentLineCheckVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[5];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (accountingPaymentLineCheckVO != null) {
				Map<String, String> mapVO= accountingPaymentLineCheckVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPrepayUnApplyGainLossCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("INV_GL_YYMM");
				rtnValue[1] = dbRowset.getString("APPLY_GL_YYMM");
				rtnValue[2] = dbRowset.getString("INV_XCH_RT");
				rtnValue[3] = dbRowset.getString("APPLY_XCH_RT");
				rtnValue[4] = dbRowset.getString("APPLY_AMT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingPrepayUnApplyGainLossAmtInfo<br>
	 *
	 * @author ORKIM
	 * @param  AccountingPaymentLineCheckVO accountingPaymentLineCheckVO
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String searchAccountingPrepayUnApplyGainLossAmtInfo(AccountingPaymentLineCheckVO accountingPaymentLineCheckVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (accountingPaymentLineCheckVO != null) {
				Map<String, String> mapVO= accountingPaymentLineCheckVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingPrepayUnApplyGainLossAmtInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("GAIN_LOSS_AMT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPrepayUnApplyLossInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPrepayUnApplyLossInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPrepayUnApplyLossInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	
	/**
	 * [STM_SAP_0220]
	 * addAccountingDetailPrepayUnApplyGainInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void addAccountingDetailPrepayUnApplyGainInfo(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddAccountingDetailPrepayUnApplyGainInfoCSQL(), accountingPaymentCheckVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	/**
	 * [STM_SAP_0220] 에러여부체크 
	 * searchAccountingDetailValidateInfo<br>  
	 *
	 * @author ORKIM
	 * @param  String accounting_request_id
	 * @return List<AccountingDetailValidateInfoVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<AccountingDetailValidateInfoVO> searchAccountingDetailValidateInfo(String accounting_request_id) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<AccountingDetailValidateInfoVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (accounting_request_id != null) {
				param.put("accounting_request_id", accounting_request_id);	
				velParam.put("accounting_request_id", accounting_request_id);						
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingDetailValidateInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AccountingDetailValidateInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingDetailAmountValidate<br>
	 *
	 * @author ORKIM
	 * @param  AccountingDetailValidateInfoVO accountingDetailValidateInfoVO
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingDetailAmountValidate(AccountingDetailValidateInfoVO accountingDetailValidateInfoVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[4];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (accountingDetailValidateInfoVO != null) {
				Map<String, String> mapVO= accountingDetailValidateInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingDetailAmountValidateRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("ENTERED_DR_SUM");
				rtnValue[1] = dbRowset.getString("ENTERED_CR_SUM");
				rtnValue[2] = dbRowset.getString("ACCOUNTED_DR_SUM");
				rtnValue[3] = dbRowset.getString("ACCOUNTED_CR_SUM");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [STM_SAP_0220]
	 * modifyAccountingDetailValidateResultInfo<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingDetailValidateInfoVO> accountingDetailValidateInfoVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void modifyAccountingDetailValidateResultInfo(List<AccountingDetailValidateInfoVO> accountingDetailValidateInfoVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingDetailValidateInfoVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyAccountingDetailValidateResultInfoUSQL(), accountingDetailValidateInfoVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * [STM_SAP_0220]
	 * searchAccountingDetailCoaValidate<br>
	 *
	 * @author ORKIM
	 * @param  AccountingDetailValidateInfoVO accountingDetailValidateInfoVO
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String searchAccountingDetailCoaValidate(AccountingDetailValidateInfoVO accountingDetailValidateInfoVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (accountingDetailValidateInfoVO != null) {
				Map<String, String> mapVO= accountingDetailValidateInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingDetailCoaValidateRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("COA_NULL_CNT");
				
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	 
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingDetailCoaValueValidate<br>
	 *
	 * @author ORKIM
	 * @param  AccountingDetailValidateInfoVO accountingDetailValidateInfoVO
	 * @return String[]
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String[] searchAccountingDetailCoaValueValidate(AccountingDetailValidateInfoVO accountingDetailValidateInfoVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (accountingDetailValidateInfoVO != null) {
				Map<String, String> mapVO= accountingDetailValidateInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingDetailCoaValueValidateRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("COA_CNT");
				rtnValue[1] = dbRowset.getString("DTL_CNT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	
	/**
	 * [STM_SAP_0220] DELETE Button 
	 * modifyAccountingDetailPaymentLineRestore<br>
	 *
	 * @author ORKIM
	 * @param List<APAccountingListVO> aPAccountingListVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void modifyAccountingDetailPaymentLineRestore(List<APAccountingListVO> aPAccountingListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (aPAccountingListVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyAccountingDetailValidateResultInfoUSQL(), aPAccountingListVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
		
	/**
	 * [STM_SAP_0220] DELETE Button 
	 * removeAccountingEvent<br>
	 *
	 * @author ORKIM
	 * @param List<APAccountingListVO> aPAccountingListVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void removeAccountingEvent(List<APAccountingListVO> aPAccountingListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (aPAccountingListVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAORemoveAccountingEventDSQL(), aPAccountingListVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	/**
	 * [STM_SAP_0220] DELETE Button 
	 * removeAccountingEventHeader<br>
	 *
	 * @author ORKIM
	 * @param List<APAccountingListVO> aPAccountingListVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void removeAccountingEventHeader(List<APAccountingListVO> aPAccountingListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (aPAccountingListVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAORemoveAccountingEventHeaderDSQL(), aPAccountingListVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	 
	/**
	 * [STM_SAP_0220] DELETE Button 
	 * removeAccountingEventLine<br>
	 *
	 * @author ORKIM
	 * @param List<APAccountingListVO> aPAccountingListVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void removeAccountingEventLine(List<APAccountingListVO> aPAccountingListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (aPAccountingListVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAORemoveAccountingEventLineDSQL(), aPAccountingListVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	 
	
   /**
	 * [STM_SAP_0120]
	 * Bank Balance Adjustment - retrieve<br> 
	 * @author JBLEE
	 * @param BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO
	 * @return List<BankAccountAdjustmentListVO>
	 * @exception DAOException
   */
	@SuppressWarnings("unchecked")
	public List<BankAccountAdjustmentListVO> searchBankAccountAdjustmentList(BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BankAccountAdjustmentListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bankBalanceByOfficeCondVO != null) {
				Map<String, String> mapVO= bankBalanceByOfficeCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchBankAccountAdjustmentListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankAccountAdjustmentListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}
	
   /**
	 * [STM_SAP_0120]
	 * Bank Account Adjustment - Recalculate<br> 
	 * @author JBLEE
	 * @param String bankAcctSeq
	 * @param String bankStmtDt
	 * @return List<BankBalanceAdjustmentListVO>
	 * @exception DAOException
   */
	@SuppressWarnings("unchecked")
	public List<BankBalanceAdjustmentListVO> searchAccountAdjustmentRecalculationList(String bankAcctSeq, String bankStmtDt) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BankBalanceAdjustmentListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			 param.put("bank_acct_seq",    bankAcctSeq);
			 param.put("bank_stmt_dt",     bankStmtDt);
   	
			 velParam.put("bank_acct_seq", bankAcctSeq);
			 velParam.put("bank_stmt_dt",   bankStmtDt);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountAdjustmentRecalculationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankBalanceAdjustmentListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}
	
	/**
	 * [STM_SAP_0120]
	 * Bank Account Adjustment - Recalculate<br> 
	 * @author JBLEE
	 * @param List<BankBalanceAdjustmentListVO> bankBalanceAdjustmentListVOs
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public void addBankAccountAdjustment(List<BankBalanceAdjustmentListVO> bankBalanceAdjustmentListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bankBalanceAdjustmentListVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOAddBankAccountAdjustmentCSQL(), bankBalanceAdjustmentListVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [STM_SAP_0120]
	 * Bank Account Adjustment - Recalculate<br> 
	 * @author JBLEE
	 * @param List<BankBalanceAdjustmentListVO> bankBalanceAdjustmentListVOs
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public void modifyBankAccountAdjustment(List<BankBalanceAdjustmentListVO> bankBalanceAdjustmentListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (bankBalanceAdjustmentListVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyBankAccountAdjustmentUSQL(), bankBalanceAdjustmentListVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
   /**
	 * [STM_SAP_0140]
	 * Inquiry of Transaction - Retrieve<br> 
	 * @author ORKIM
	 * @param APTransactionCondVO aPTransactionCondVO
	 * @return List<APTransactionVO>
	 * @exception DAOException
   */
	@SuppressWarnings("unchecked")
	public List<APTransactionVO> searchInquiryofTransactionList(APTransactionCondVO aPTransactionCondVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<APTransactionVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (aPTransactionCondVO != null) {
				Map<String, String> mapVO= aPTransactionCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchInquiryofTransactionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APTransactionVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
		
	}	
	
   /**
	 * [STM_SAP_0140]
	 * Inquiry of Transaction - Retrieve BeginBalance <br> 
	 * @author ORKIM
	 * @param APTransactionCondVO aPTransactionCondVO
	 * @return String
	 * @exception DAOException
   */ 
	public String searchInquiryofTrxBeginBalance(APTransactionCondVO aPTransactionCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (aPTransactionCondVO != null) {
				Map<String, String> mapVO= aPTransactionCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchInquiryofTrxBeginBalanceRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("CTRL_BGN_BAL_AMT");
			}			
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	

   /**
	 * [STM_SAP_0140]
	 * Inquiry of Transaction - Retrieve Sum <br> 
	 * @author ORKIM
	 * @param APTransactionCondVO aPTransactionCondVO
	 * @return String[]
	 * @exception DAOException
   */ 
	public String[] searchInquiryofTransactionSum(APTransactionCondVO aPTransactionCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[2];;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (aPTransactionCondVO != null) {
				Map<String, String> mapVO= aPTransactionCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchInquiryofTransactionSumRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("PAYMENT_AMOUNT");
				rtnValue[1] = dbRowset.getString("RECEIPT_AMOUNT");
			}			
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
   /**
	 * INTERFACE
	 * searchInvHdrSrcCd <br> 
	 * @author ORKIM
	 * @param String inv_no
	 * @return String
	 * @exception DAOException
   */ 
	public String searchInvHdrSrcCd(String inv_no) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			 param.put("inv_no",    inv_no);
			 velParam.put("inv_no", inv_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchInvHdrSrcCdRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("AP_INV_SRC_CD");					
			}			
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
		
   /**
	 * INTERFACE
	 * searchSAPToSOInterfaceData <br> 
	 * @author ORKIM
	 * @param String inv_no
	 * @return String[]
	 * @exception DAOException
   */ 
	public String[] searchSAPToSOInterfaceData(String inv_no) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[3];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("inv_no",    inv_no);
			velParam.put("inv_no", inv_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchSAPToSOInterfaceDataRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("PAY_DT");	
				rtnValue[1] = dbRowset.getString("PAY_MZD_LU_CD");	
				rtnValue[2] = dbRowset.getString("PAY_AMT");	
			}			
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}		
		
   /**
	 * INTERFACE 
	 * searchSAPToSOInterfaceDataBatch <br> 
	 * @author ORKIM
	 * @param String pay_bat_seq
	 * @param String pay_bat_nm
	 * @param String vndr_no
	 * @return List<PaymentEntryLineVO>
	 * @exception DAOException
   */ 
	public List<PaymentEntryLineVO>  searchSAPToSOInterfaceDataBatch(String pay_bat_seq, String pay_bat_nm, String vndr_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<PaymentEntryLineVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("pay_bat_seq",    pay_bat_seq);
			velParam.put("pay_bat_seq", pay_bat_seq);
			
			param.put("pay_bat_nm",    pay_bat_nm);
			velParam.put("pay_bat_nm", pay_bat_nm);
			
			param.put("vndr_no",    vndr_no);
			velParam.put("vndr_no", vndr_no);
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchSAPToSOInterfaceDataBatchRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentEntryLineVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
			
   /**
	 * INTERFACE 
	 * modifySOInterfaceTES <br> 
	 * @author ORKIM
	 * @param String csr_no
	 * @param String status
	 * @exception DAOException
    */ 			
	public void modifySOInterfaceTES(String csr_no, String status) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try {
			
			param.put("csr_no", csr_no);
			velParam.put("csr_no", csr_no);
			param.put("status", status);
			velParam.put("status", status);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AccountPayablePaymentDBDAOModifySOInterfaceTESUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
	 * INTERFACE 
	 * modifySOInterfaceTRS <br> 
	 * @author ORKIM
	 * @param String csr_no
	 * @param String status
	 * @exception DAOException
    */ 		
	public void modifySOInterfaceTRS(String csr_no, String status) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try {
			
			param.put("csr_no", csr_no);
			velParam.put("csr_no", csr_no);
			param.put("status", status);
			velParam.put("status", status);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AccountPayablePaymentDBDAOModifySOInterfaceTRSUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
    /**
	 * INTERFACE 
	 * modifySOInterfaceTRSRail <br> 
	 * @author ORKIM
	 * @param String csr_no
	 * @param String status
	 * @exception DAOException
    */ 
	public void modifySOInterfaceTRSRail(String csr_no, String status) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try {
			
			param.put("csr_no", csr_no);
			velParam.put("csr_no", csr_no);
			param.put("status", status);
			velParam.put("status", status);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AccountPayablePaymentDBDAOModifySOInterfaceTRSRailUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
		
	
    /**
	 * INTERFACE 
	 * modifySOInterfaceETC <br> 
	 * @author ORKIM
	 * @param String csr_no
	 * @param String status
	 * @exception DAOException
    */ 	
	public void modifySOInterfaceETC(String csr_no, String status) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try {
			
			param.put("csr_no", csr_no);
			velParam.put("csr_no", csr_no);
			param.put("status", status);
			velParam.put("status", status);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AccountPayablePaymentDBDAOModifySOInterfaceETCUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
		
	/**
	 * [STM_SAP_0060]
	 * Payment Entry에서 Delete 시 apply 여부 체크<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0060
	 * @category searchPaymentApplyCheck
	 * @param  String pay_seq
	 * @return String
	 * @exception DAOException
	 */	 
	public String searchPaymentApplyCheck(String pay_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("pay_seq", pay_seq);
			velParam.put("pay_seq", pay_seq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchPaymentApplyCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("APPLY_FLG");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
		
   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentProcessList <br> 
	 * @author ORKIM
	 * @return List<APIFPaymentProcessListVO>
	 * @exception DAOException
   */ 
	public List<APIFPaymentProcessListVO>  searchAPIFPaymentProcessList() throws DAOException {
		DBRowSet dbRowset = null;
		List<APIFPaymentProcessListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAPIFPaymentProcessListRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APIFPaymentProcessListVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		
   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPPaymentBatchProcessName <br> 
	 * @author ORKIM
	 * @return String
	 * @exception DAOException
   */ 
	public String searchAPPaymentBatchProcessName() throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAPPaymentBatchProcessNameRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("payment_batch_name");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
		
	
   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentCSRInfoList <br> 
	 * @author ORKIM
	 * @param  APIFPaymentProcessListVO aPIFPaymentProcessListVO
	 * @return List<APIFPaymentCSRInfoListVO>
	 * @exception DAOException
   */ 
	public List<APIFPaymentCSRInfoListVO>  searchAPIFPaymentCSRInfoList(APIFPaymentProcessListVO aPIFPaymentProcessListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<APIFPaymentCSRInfoListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (aPIFPaymentProcessListVO != null) {
				Map<String, String> mapVO= aPIFPaymentProcessListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAPIFPaymentCSRInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APIFPaymentCSRInfoListVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
		
	
   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentCompleteCheck <br> 
	 * @author ORKIM
	 * @param  APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO
	 * @return List<APIFPaymentCompleteCheckVO>
	 * @exception DAOException
   */ 
	public List<APIFPaymentCompleteCheckVO>  searchAPIFPaymentCompleteCheck(APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<APIFPaymentCompleteCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (aPIFPaymentCSRInfoListVO != null) {
				Map<String, String> mapVO= aPIFPaymentCSRInfoListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAPIFPaymentCompleteCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APIFPaymentCompleteCheckVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
		
   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentBANKExistsCheck <br> 
	 * @author ORKIM
	 * @param  APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO
	 * @return List<APIFPaymentBANKExistsCheckVO>
	 * @exception DAOException
   */ 
	public List<APIFPaymentBANKExistsCheckVO>  searchAPIFPaymentBANKExistsCheck(APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<APIFPaymentBANKExistsCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (aPIFPaymentCSRInfoListVO != null) {
				Map<String, String> mapVO= aPIFPaymentCSRInfoListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAPIFPaymentBANKExistsCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APIFPaymentBANKExistsCheckVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

   /**
	 * SAKURA I/F for PAYMENT  
	 * searchAPIFPaymentBANKInfoCheck <br> 
	 * @author ORKIM
	 * @param  APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO
	 * @return List<APIFPaymentBANKInfoCheckVO>
	 * @exception DAOException
   */ 
	public List<APIFPaymentBANKInfoCheckVO>  searchAPIFPaymentBANKInfoCheck(APIFPaymentCSRInfoListVO aPIFPaymentCSRInfoListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<APIFPaymentBANKInfoCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (aPIFPaymentCSRInfoListVO != null) {
				Map<String, String> mapVO= aPIFPaymentCSRInfoListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAPIFPaymentBANKInfoCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APIFPaymentBANKInfoCheckVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
		

   /**
	 * SAKURA I/F for PAYMENT  
	 * modifyAPIFPaymentStatus <br> 
	 * @author ORKIM
	 * @param List<APIFPaymentProcessListVO> aPIFPaymentProcessListVO
	 * @exception DAOException
   */ 
	public void modifyAPIFPaymentStatus(List<APIFPaymentProcessListVO> aPIFPaymentProcessListVO) throws DAOException {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (aPIFPaymentProcessListVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayablePaymentDBDAOModifyAPIFPaymentStatusUSQL(), aPIFPaymentProcessListVO, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingExistsCheckCsrNo<br>
	 *
	 * @author ORKIM
	 * @param String csrNo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAccountingExistsCheckCsrNo(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (csrNo != null) {
				param.put("inv_no", csrNo);	
				velParam.put("inv_no", csrNo);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingExistsCheckCSRNoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("ACCTG_YN");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}		
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingInvoiceSectionCheckCsrNo<br>
	 *
	 * @author KSJO
	 * @param String csrNo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAccountingInvoiceSectionCheckCsrNo(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (csrNo != null) {
				param.put("inv_no", csrNo);	
				velParam.put("inv_no", csrNo);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingInvoiceSectionCheckCsrNoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("INV_STATUS");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}		
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingInvoiceExchangeRateRuleCheckInfo<br>
	 *
	 * @author KSJO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAccountingInvoiceExchangeRateRuleCheckInfo() throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingInvoiceExchangeRateRuleCheckInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("EX_RATE_BASE");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingInvoiceGainLossCheck<br>
	 *
	 * @author KSJO
	 * @param String invSeq
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAccountingInvoiceGainLossCheck(String invSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (invSeq != null) {
				param.put("inv_seq", invSeq);	
				velParam.put("inv_seq", invSeq);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingInvoiceGainLossCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("JOURNAL_TYPE");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * [STM_SAP_0220]
	 * searchAccountingInvoiceCancelGainLossCheck<br>
	 *
	 * @author KSJO
	 * @param String invSeq
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAccountingInvoiceCancelGainLossCheck(String invSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (invSeq != null) {
				param.put("inv_seq", invSeq);	
				velParam.put("inv_seq", invSeq);			
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayablePaymentDBDAOSearchAccountingInvoiceCancelGainLossCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("JOURNAL_TYPE");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
		
}