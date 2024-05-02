/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountPayableInvoiceDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.03.11. K.O.R.
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.APManualInvoiceAccuralCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceApprovalInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceApprovalListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryLineListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePayScheduleListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceReceiptCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceReceiptListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipDetailListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceSlipPaymentListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePrintVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceDetailVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceHeaderVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.UnsettledAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.UnsettledEntryCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementInvoiceListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementApplyListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentSettlementUnapplyListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentLineCheckVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentApplyUnapplyVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.PrepaymentPayScheduleCheckVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.AsaInfoVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceInterfaceSAPTypeCheckVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceAccrualCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceAccrualVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchEntryVendorSumInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentEntryLineVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.PaymentBatchSelectedListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCancelCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingInvoiceCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingPaymentCheckVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APAccountingListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.AsaClearingVO;

/**
 * AccountPayableInvoiceDBDAO <br>
 * - AccountPayableInvoice system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM.O.R.
 * @see AccountPayableInvoiceBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AccountPayableInvoiceDBDAO extends DBDAOSupport {
	

	/**
	 * [STM_SAP_0010]
	 * [HEADER]- HEADER 목록을 조회<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchInvoiceEntryList
	 * @param InvoiceEntryCondVO invoiceEntryCondVO
	 * @return List<InvoiceEntryListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvoiceEntryListVO> searchInvoiceEntryList(InvoiceEntryCondVO invoiceEntryCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceEntryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (invoiceEntryCondVO != null) {
				Map<String, String> mapVO= invoiceEntryCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceEntryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceEntryListVO.class);
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
	 * [STM_SAP_0010]
	 * [LINE]- LINE 목록을 조회<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchInvoiceEntryLineList
	 * @param String  invoiceID
	 * @return List<InvoiceEntryLineListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvoiceEntryLineListVO> searchInvoiceEntryLineList(String invoiceID) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceEntryLineListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (invoiceID != null) {
				param.put("inv_seq", invoiceID);		
				velParam.put("inv_seq", invoiceID);		
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceEntryLineListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceEntryLineListVO.class);
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
	 * [STM_SAP_0010]
	 * [LINE]- PAY SCHEDULE 목록을 조회<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchInvoicePayScheduleList
	 * @param String  invoiceID
	 * @return List<InvoicePayScheduleListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvoicePayScheduleListVO> searchInvoicePayScheduleList(String invoiceID) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoicePayScheduleListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (invoiceID != null) {
				param.put("inv_seq", invoiceID);	
				velParam.put("inv_seq", invoiceID);					
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoicePayScheduleListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoicePayScheduleListVO.class);
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
	 * [STM_SAP_0010]
	 * 비용 전표 Header을 생성하는데 NEXT INV_SEQ SEARCH<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchNextInvSeq
	 * @return String
	 * @exception DAOException
	 */	 
	public String searchNextInvSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchNextInvSeqRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("INV_SEQ");
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
	 * [STM_SAP_0010]
	 * 비용 전표 Header을 생성하는데 Input 자료로 SAP_INV_HDR 테이블을 생성<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category addInvoiceHeader
	 * @param List<InvoiceEntryListVO> invoiceEntryListVOlist
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addInvoiceHeader(List<InvoiceEntryListVO> invoiceEntryListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invoiceEntryListVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInvoiceHeaderCSQL(), invoiceEntryListVOlist, null);
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
	 * [STM_SAP_0010]
	 * SAP_INV_HDR update<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category modifyInvoiceHeader
	 * @param List<InvoiceEntryListVO> invoiceEntryListVOlist
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyInvoiceHeader(List<InvoiceEntryListVO> invoiceEntryListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invoiceEntryListVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceHeaderUSQL(), invoiceEntryListVOlist, null);
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
	 * [STM_SAP_0010]
	 * 비용 전표 Header을 생성하는데 Input 자료로 SAP_INV_HDR 테이블을 삭제 <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category removeInvoiceHeader
	 * @param List<InvoiceEntryListVO> invoiceEntryListVOlist
	 * @exception DAOException
	 */
	public void removeInvoiceHeader(List<InvoiceEntryListVO> invoiceEntryListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (invoiceEntryListVOlist.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAORemoveInvoiceHeaderDSQL(), invoiceEntryListVOlist, null);
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
	 * [STM_SAP_0010]
	 * 비용 전표 Line 생성하는데 Input 자료로 SAP_INV_DTL 테이블을 생성<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category addInvoiceLine
	 * @param List<InvoiceEntryLineListVO> invoiceEntryLineListVOlist
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addInvoiceLine(List<InvoiceEntryLineListVO> invoiceEntryLineListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invoiceEntryLineListVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInvoiceLineCSQL(), invoiceEntryLineListVOlist, null);
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
	 * [STM_SAP_0010]
	 * SAP_INV_DTL update <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category modifyInvoiceLine
	 * @param List<InvoiceEntryLineListVO> invoiceEntryLineListVOlist
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyInvoiceLine(List<InvoiceEntryLineListVO> invoiceEntryLineListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invoiceEntryLineListVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceLineUSQL(), invoiceEntryLineListVOlist, null);
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
	 * [STM_SAP_0010]
	 * 비용 전표 Header을 생성하는데 Input 자료로 SAP_INV_DTL 테이블을 삭제 <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category removeInvoiceLine
	 * @param List<InvoiceEntryLineListVO> invoiceEntryLineListVOlist
	 * @exception DAOException
	 */
	public void removeInvoiceLine(List<InvoiceEntryLineListVO> invoiceEntryLineListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (invoiceEntryLineListVOlist.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAORemoveInvoiceLineDSQL(), invoiceEntryLineListVOlist, null);
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
	 * [STM_SAP_0010]
	 * 비용 전표 Header을 생성하는데 Input 자료로 SAP_INV_DTL 테이블을 삭제 <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category removeInvoiceLineByInvSeq
	 * @param List<InvoiceEntryListVO> invoiceEntryListVOlist
	 * @exception DAOException
	 */
	public void removeInvoiceLineByInvSeq(List<InvoiceEntryListVO> invoiceEntryListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (invoiceEntryListVOlist.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAORemoveInvoiceLineByInvSeqDSQL(), invoiceEntryListVOlist, null);
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
	 * [STM_SAP_0010]
	 * 비용 전표 Pay Schedule 생성하는데 Input 자료로 SAP_PAY_SKD 테이블을 생성<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category addInvoicePaySchedule
	 * @param List<InvoicePayScheduleListVO> invoicePayScheduleListVOlist
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addInvoicePaySchedule(List<InvoicePayScheduleListVO> invoicePayScheduleListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invoicePayScheduleListVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInvoicePayScheduleCSQL(), invoicePayScheduleListVOlist, null);
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
	 * [STM_SAP_0010]
	 * 비용 전표 Pay Schedule 생성하는데 Input 자료로 SAP_PAY_SKD 테이블을 생성<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category modifyInvoicePaySchedule
	 * @param List<InvoicePayScheduleListVO> invoicePayScheduleListVOlist
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyInvoicePaySchedule(List<InvoicePayScheduleListVO> invoicePayScheduleListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invoicePayScheduleListVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoicePayScheduleUSQL(), invoicePayScheduleListVOlist, null);
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
	 * [STM_SAP_0010]
	 * SAKURA에 I/F 후 (HOLD -> UNHOLD시) ATTR_CTNT14 컬럼에 Y 세팅<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category modifyInvoicePayScheduleIFResult
	 * @param String inv_seq
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyInvoicePayScheduleIFResult(String inv_seq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			param.put("inv_seq",inv_seq);
			velParam.put("inv_seq",inv_seq);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoicePayScheduleIFResultUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
		 
	/**
	 * [STM_SAP_0010]
	 * 비용 전표 Pay Schedule 생성하는데 Input 자료로 SAP_PAY_SKD 테이블을 삭제<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category removeInvoicePaySchedule
	 * @param List<InvoicePayScheduleListVO> invoicePayScheduleListVOlist
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void removeInvoicePaySchedule(List<InvoicePayScheduleListVO> invoicePayScheduleListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (invoicePayScheduleListVOlist.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAORemoveInvoicePayScheduleDSQL(), invoicePayScheduleListVOlist, null);
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
	 * [STM_SAP_0010]
	 * 비용 전표 Header을 생성하는데 Input 자료로 SAP_INV_DTL 테이블을 삭제 <br>
	 *
	 * @param List<InvoiceEntryListVO> invoiceEntryListVOlist
	 * @exception DAOException
	 */
	public void removeInvoicePayScheduleByInvSeq(List<InvoiceEntryListVO> invoiceEntryListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (invoiceEntryListVOlist.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAORemoveInvoicePayScheduleByInvSeqDSQL(), invoiceEntryListVOlist, null);
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
	 * [STM_SAP_0010]
	 * searchLineVendorInvoiceNoDupCheck <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchLineVendorInvoiceNoDupCheck
	 * @param SapCommonVO sapCommonVO
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	 
	public SapCommonVO searchLineVendorInvoiceNoDupCheck(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {
				param.put("vendor_no", sapCommonVO.getValue0());	
				param.put("inv_no", sapCommonVO.getValue1());	
				param.put("vendor_invoice_no", sapCommonVO.getValue2());	
				velParam.put("vendor_no", sapCommonVO.getValue0());	
				velParam.put("inv_no", sapCommonVO.getValue1());	
				velParam.put("vendor_invoice_no", sapCommonVO.getValue2());	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchLineVendorInvoiceNoDupCheckRSQL(), param, velParam);
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
	 * [STM_SAP_0010]
	 * searchInvoiceStatusCheck <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchInvoiceStatusCheck
	 * @param String inv_seq
	 * @return String
	 * @exception DAOException
	*/
	 
	public String searchInvoiceStatusCheck(String inv_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("inv_seq", inv_seq);			
			velParam.put("inv_seq", inv_seq);				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceStatusCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("DEL_AVAILABLE");
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
	 * [STM_SAP_0010]
	 * searchLineAccountTypeList <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchLineAccountTypeList
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception DAOException
	*/
	 
	public List<SapCommonVO> searchLineAccountTypeList(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<SapCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {
				Map<String, String> mapVO = sapCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchLineAccountTypeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapCommonVO.class);             
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
	 * [STM_SAP_0010]
	 * addCSRNo <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category addCSRNo
	 * @param SapCommonVO sapCommonVO
	 * @return String
	 * @exception DAOException
	*/
	 
	public String addCSRNo(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {
				Map<String, String> mapVO = sapCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOAddCSRNoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("NEW_CSR_NO");
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
	 * [STM_SAP_0010]
	 * searchInvoiceLiabilityAccountCheck <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchInvoiceLiabilityAccountCheck
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception DAOException
	*/
	 
	public List<SapCommonVO> searchInvoiceLiabilityAccountCheck(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<SapCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {
				Map<String, String> mapVO = sapCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceLiabilityAccountCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapCommonVO.class);             
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
	 * [STM_SAP_0010]
	 * searchInvoiceCancelGLDateCheck <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchInvoiceCancelGLDateCheck
	 * @param String gl_date
	 * @return String rtnValue
	 * @exception DAOException
	*/
	 
	public String searchInvoiceCancelGLDateCheck(String gl_date) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if (gl_date != null) {
				param.put("gl_date", gl_date);	
				velParam.put("gl_date", gl_date);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceCancelGLDateCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("PRD_STS_CD");
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
	 * [STM_SAP_0010]
	 * searchInvoiceCancelNextGLDateCheck <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchInvoiceCancelNextGLDateCheck
	 * @param String gl_date
	 * @return String rtnValue
	 * @exception DAOException
	*/
	 
	public String searchInvoiceCancelNextGLDateCheck(String gl_date) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (gl_date != null) {
				param.put("gl_date", gl_date);	
				velParam.put("gl_date", gl_date);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceCancelNextGLDateCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("NEXT_GL_DATE");
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
	 * [STM_SAP_0010]
	 * Cancel 전표 생성 <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category addInvoiceLineSelectInfo
	 * @param List<InvoiceEntryListVO> invoiceEntryListVOlist
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addInvoiceLineSelectInfo(List<InvoiceEntryListVO> invoiceEntryListVOlist) throws DAOException {
		
		 	 try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invoiceEntryListVOlist.size() > 0 ) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInvoiceLineSelectInfoCSQL(), invoiceEntryListVOlist, null);
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
	 * [STM_SAP_0010]
	 * SAP_INV_HDR Cancel<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category modifyInvoiceHeaderCancelInfo
	 * @param List<InvoiceEntryListVO> invoiceEntryListVOlist
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyInvoiceHeaderCancelInfo(List<InvoiceEntryListVO> invoiceEntryListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invoiceEntryListVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceHeaderCancelInfoUSQL(), invoiceEntryListVOlist, null);
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
	 * [STM_SAP_0010]
	 * SAP_PAY_SKD Cancel<br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category modifyInvoicePayScheduleCancelInfo
	 * @param List<InvoiceEntryListVO> invoiceEntryListVOlist
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyInvoicePayScheduleCancelInfo(List<InvoiceEntryListVO> invoiceEntryListVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invoiceEntryListVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoicePayScheduleCancelInfoUSQL(), invoiceEntryListVOlist, null);
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
	 * [STM_SAP_0010]
	 * searchAccountValiInfo 단건 조회 <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchAccountValiInfo
	 * @param String acct_cd
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	 
	public SapCommonVO searchAccountValiInfo(String acct_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (acct_cd != null) {
				param.put("acct_cd", acct_cd);	
				velParam.put("acct_cd", acct_cd);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchAccountValiInfoRSQL(), param, velParam);
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
	 * [STM_SAP_0010]
	 * searchVendorValiInfo 단건 조회 <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchVendorValiInfo
	 * @param String vendor_no
	 * @return List<SapCommonVO> 
	 * @exception DAOException
	*/
	 
	public SapCommonVO searchVendorValiInfo(String vendor_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (vendor_no != null) {
				param.put("vendor_no", vendor_no);	
				velParam.put("vendor_no", vendor_no);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchVendorValiInfoRSQL(), param, velParam);
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
	 * [STM_SAP_0010]
	 * searchOffValiInfo 단건조회 <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchOffValiInfo
	 * @param String ofc_cd
	 * @param String securityFlag
	 * @param String usrId
	 * @param String login_ofc_cd
	 * @return List<SapCommonVO> 
	 * @exception DAOException
	*/
	 
	public SapCommonVO searchOffValiInfo(String ofc_cd, String securityFlag, String usrId, String login_ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (ofc_cd != null) {
				param.put("ofc_cd", ofc_cd);	
				param.put("security_flag", securityFlag);
				param.put("login_ofc_cd", login_ofc_cd);
				param.put("usr_id", usrId);
				
				velParam.put("ofc_cd", ofc_cd);	
				velParam.put("security_flag", securityFlag);
				velParam.put("login_ofc_cd", login_ofc_cd);
				velParam.put("usr_id", usrId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchOffValiInfoRSQL(), param, velParam);
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
	 * [STM_SAP_0010]
	 * searchInvoiceASAPeriodToDateInfo 단건조회 <br>
	 * 
	 * @author KSJO
	 * @category STM_SAP_0010
	 * @category searchInvoiceASAPeriodToDateInfo
	 * @param String asa_no
	 * @return List<SapCommonVO> 
	 * @exception DAOException
	*/
	 
	public SapCommonVO searchInvoiceASAPeriodToDateInfo(String asa_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (asa_no != null) {
				param.put("asa_no", asa_no);	
				velParam.put("asa_no", asa_no);	
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceASAPeriodToDateInfoRSQL(), param, velParam);
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
	 * [STM_SAP_0010]
	 * searchLegrValiInfo <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchLegrValiInfo
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception DAOException
	*/
	 
	public List<SapCommonVO> searchLegrValiInfo(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<SapCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {
				Map<String, String> mapVO = sapCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchLegrValiInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapCommonVO.class);             
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
	 * [STM_SAP_0010]
	 * searchAsaValiInfo 단건조회 <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchAsaValiInfo
	 * @param String asa_no
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	 
	public SapCommonVO searchAsaValiInfo(String asa_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (asa_no != null) {
				param.put("asa_no", asa_no);	
				velParam.put("asa_no", asa_no);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchAsaValiInfoRSQL(), param, velParam);
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
	 * [STM_SAP_0010]
	 * searchAccountValiInfo 단건 조회 <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchAccountValiInfo
	 * @param SapCommonVO sapCommonVO
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	 
	public SapCommonVO searchSupplierBankValiInfo(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {
				param.put("curr_cd", sapCommonVO.getValue0());	
				param.put("vendor_no", sapCommonVO.getValue1());	
				velParam.put("curr_cd", sapCommonVO.getValue0());	
				velParam.put("vendor_no", sapCommonVO.getValue1());	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchSupplierBankValiInfoRSQL(), param, velParam);
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
	 * [STM_SAP_0010]
	 * searchInvoiceASACloseStatusCheck 단건 조회 <br>
	 * 
	 * @author JoKyungSam
	 * @category STM_SAP_0010
	 * @category searchInvoiceASACloseStatusCheck
	 * @param SapCommonVO sapCommonVO
	 * @return String
	 * @exception DAOException
	*/
	 
	public String searchInvoiceASACloseStatusCheck(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {
				param.put("inv_seq", sapCommonVO.getValue0());	
				velParam.put("inv_seq", sapCommonVO.getValue0());	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceASACloseStatusCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("ASA_STATUS_FLAG");
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
	 * [STM_SAP_0010]
	 * searchInvoiceInterfaceToSAKURAStatusCheck 단건 조회 <br>
	 * 
	 * @author JoKyungSam
	 * @category STM_SAP_0010
	 * @category searchInvoiceInterfaceToSAKURAStatusCheck
	 * @param SapCommonVO sapCommonVO
	 * @return String
	 * @exception DAOException
	*/
	 
	public String searchInvoiceInterfaceToSAKURAStatusCheck(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {
				param.put("inv_no", sapCommonVO.getValue0());	
				velParam.put("inv_no", sapCommonVO.getValue0());	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceToSAKURAStatusCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("EXISTS_FLAG");
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
	 * [STM_SAP_0010]
	 * searchCSRNoDupChk <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchCSRNoDupChk
	 * @param String csr_no
	 * @return String rtnValue
	 * @exception DAOException
	*/
	 
	public String searchCSRNoDupChk(String csr_no) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if (csr_no != null) {
				param.put("inv_no", csr_no);	
				velParam.put("inv_no", csr_no);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchCSRNoDupChkRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("inv_no");
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
	 * [STM_SAP_0010]
	 * searchInvoiceSlipPrintRequestInfo <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchInvoiceSlipPrintRequestInfo
	 * @return String rtnValue
	 * @exception DAOException
	*/
	 
	public String searchInvoiceSlipPrintRequestInfo() throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceSlipPrintRequestInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("INV_RQST_SEQ");
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
	 * [STM_SAP_0010]
	 * searchCSRNoDupChk <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category removeInvoiceSlipPrintRequest
	 * @param InvoicePrintVO invoicePrintVO
	 * @return int
	 * @exception DAOException
	*/
	 
	public int removeInvoiceSlipPrintRequest(InvoicePrintVO invoicePrintVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try{
			if(invoicePrintVO != null){
				Map<String, String> mapVO = invoicePrintVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAORemoveInvoiceSlipPrintRequestDSQL(), param, velParam);			
			if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to delete SQL");		
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return result;
		

	}	

	/**
	 * [STM_SAP_0010]
	 * addInvoiceSlipPrintInfo <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category addInvoiceSlipPrintInfo
	 * @param List<InvoicePrintVO> invoicePrintVOs
	 * @exception DAOException
	*/
	 
	public void addInvoiceSlipPrintInfo(List<InvoicePrintVO> invoicePrintVOs) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invoicePrintVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInvoiceSlipPrintInfoCSQL(), invoicePrintVOs, null);
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
	 * [STM_SAP_0010]
	 * modifyInvoiceSlipPrintFlagInfo <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category modifyInvoiceSlipPrintFlagInfo
	 * @param List<InvoicePrintVO> invoicePrintVOs
	 * @exception DAOException
	*/
	 
	public void modifyInvoiceSlipPrintFlagInfo(List<InvoicePrintVO> invoicePrintVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invoicePrintVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceSlipPrintFlagInfoUSQL(), invoicePrintVOs, null);
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
	 * [STM_SAP_0241]
	 * Prepayment Apply-Unapply Invoices - Header Info Retrieve <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0241
	 * @category searchPrepaymentSettlementInvoiceList
	 * @param String inv_seq
	 * @return List<PrepaymentSettlementInvoiceListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PrepaymentSettlementInvoiceListVO> searchPrepaymentSettlementInvoiceList(String inv_seq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PrepaymentSettlementInvoiceListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (inv_seq != null) {
				param.put("inv_seq", inv_seq);
				velParam.put("inv_seq", inv_seq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchPrepaymentSettlementInvoiceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrepaymentSettlementInvoiceListVO.class);
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
	 * [STM_SAP_0241]
	 * Prepayment Apply-Unapply Invoices - Apply Info Retrieve <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0241
	 * @category searchPrepaymentSettlementApplyList
	 * @param PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO
	 * @return List<PrepaymentSettlementApplyListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PrepaymentSettlementApplyListVO> searchPrepaymentSettlementApplyList(PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PrepaymentSettlementApplyListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (prepaymentSettlementInvoiceListVO != null) {
				Map<String, String> mapVO= prepaymentSettlementInvoiceListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchPrepaymentSettlementApplyListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrepaymentSettlementApplyListVO.class);
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
	 * [STM_SAP_0241]
	 * Prepayment Apply-Unapply Invoices - Unapply Info Retrieve <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0241
	 * @category searchPrepaymentSettlementInvoiceList
	 * @param PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO
	 * @return List<PrepaymentSettlementUnapplyListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PrepaymentSettlementUnapplyListVO> searchPrepaymentSettlementUnapplyList(PrepaymentSettlementInvoiceListVO prepaymentSettlementInvoiceListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PrepaymentSettlementUnapplyListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (prepaymentSettlementInvoiceListVO != null) {
				Map<String, String> mapVO= prepaymentSettlementInvoiceListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchPrepaymentSettlementUnapplyListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrepaymentSettlementUnapplyListVO.class);
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
	 * [STM_SAP_0241]
	 * searchOpenNextGLDatePeriodInfo <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0241
	 * @category searchOpenNextGLDatePeriodInfo
	 * @param String gl_date
	 * @param String ofc_cd
	 * @return String rtnValue
	 * @exception DAOException
	*/
	 
	public String searchOpenNextGLDatePeriodInfo(String gl_date, String ofc_cd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if (ofc_cd != null) {
				param.put("ofc_cd", ofc_cd);	
				param.put("gl_date", gl_date);	
				velParam.put("ofc_cd", ofc_cd);	
				velParam.put("gl_date", gl_date);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchOpenNextGLDatePeriodInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("NEXT_GL_DATE");
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
	 * [STM_SAP_0241]
	 * searchAPOpenNextGLDatePeriodInfo <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0241
	 * @category searchAPOpenNextGLDatePeriodInfo
	 * @param String gl_date
	 * @return String rtnValue
	 * @exception DAOException
	*/
	 
	public String searchAPOpenNextGLDatePeriodInfo(String gl_date) throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if (gl_date != null) {
				param.put("gl_date", gl_date);	
				velParam.put("gl_date", gl_date);	
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchAPOpenNextGLDatePeriodInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("NEXT_GL_DATE");
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
	 * [STM_SAP_0241]
	 * @author ORKIM
	 * @category STM_SAP_0240
	 * @category searchFindPrepaymentLineCheck
	 * @param String inv_seq
	 * @return List<PrepaymentLineCheckVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PrepaymentLineCheckVO> searchFindPrepaymentLineCheck(String inv_seq) throws DAOException {
		DBRowSet dbRowset = null;
		List<PrepaymentLineCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (inv_seq != null) {
				param.put("inv_seq", inv_seq);
				velParam.put("inv_seq", inv_seq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchFindPrepaymentLineCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrepaymentLineCheckVO.class);
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
	 * [STM_SAP_0241]
	 * @author ORKIM
	 * @category STM_SAP_0240
	 * @category addInvoiceHeader
	 * @param List<PrepaymentApplyUnapplyVO> PrepaymentApplyUnapplyVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addApplyedPrepaymentLineInfo(List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (prepaymentApplyUnapplyVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOAddApplyedPrepaymentLineInfoCSQL(), prepaymentApplyUnapplyVO, null);
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
	 * [STM_SAP_0241]
	 * @author ORKIM
	 * @category STM_SAP_0240
	 * @category modifyApplyedPrepaymentPayScheduleInfo
	 * @param List<PrepaymentApplyUnapplyVO> PrepaymentApplyUnapplyVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyApplyedPrepaymentPayScheduleInfo(List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (prepaymentApplyUnapplyVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyApplyedPrepaymentPayScheduleInfoUSQL(), prepaymentApplyUnapplyVO, null);
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
	 * [STM_SAP_0241]
	 * @author ORKIM
	 * @category STM_SAP_0240
	 * @category modifyApplyPrepaymentPayInvoiceInfo
	 * @param List<PrepaymentApplyUnapplyVO> PrepaymentApplyUnapplyVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyApplyPrepaymentPayInvoiceInfo(List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (prepaymentApplyUnapplyVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyApplyPrepaymentPayInvoiceInfoUSQL(), prepaymentApplyUnapplyVO, null);
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
	 * [STM_SAP_0241]
	 * @author ORKIM
	 * @category STM_SAP_0240
	 * @category modifyApplyPrepaymentPayInvoiceInfo
	 * @param List<PrepaymentApplyUnapplyVO> PrepaymentApplyUnapplyVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyApplyPrepaymentLinePrepayInfo(List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (prepaymentApplyUnapplyVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyApplyPrepaymentLinePrepayInfoUSQL(), prepaymentApplyUnapplyVO, null);
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
	 * [STM_SAP_0241]
	 * @author ORKIM
	 * @category STM_SAP_0240
	 * @category addUnApplyedPrepaymentLineInfo
	 * @param List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addUnApplyedPrepaymentLineInfo(List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (prepaymentApplyUnapplyVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOAddUnApplyedPrepaymentLineInfoCSQL(), prepaymentApplyUnapplyVO, null);
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
	 * [STM_SAP_0241]
	 * @author ORKIM
	 * @category STM_SAP_0240
	 * @category modifyUnApplyedPrepaymentApplyLineInfo
	 * @param List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyUnApplyedPrepaymentApplyLineInfo(List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (prepaymentApplyUnapplyVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyUnApplyedPrepaymentApplyLineInfoUSQL(), prepaymentApplyUnapplyVO, null);
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
	 * [STM_SAP_0241]
	 * @author ORKIM
	 * @category STM_SAP_0240
	 * @category modifyUnApplyedPrepaymentPayScheduleInfo
	 * @param List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyUnApplyedPrepaymentPayScheduleInfo(List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (prepaymentApplyUnapplyVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyUnApplyedPrepaymentPayScheduleInfoUSQL(), prepaymentApplyUnapplyVO, null);
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
	 * [STM_SAP_0241]
	 * @author ORKIM
	 * @category STM_SAP_0240
	 * @category modifyUnApplyPrepaymentPayInvoiceInfo
	 * @param List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyUnApplyPrepaymentPayInvoiceInfo(List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (prepaymentApplyUnapplyVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyUnApplyPrepaymentPayInvoiceInfoUSQL(), prepaymentApplyUnapplyVO, null);
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
	 * [STM_SAP_0241]
	 * @author ORKIM
	 * @category STM_SAP_0240
	 * @category modifyUnApplyPrepaymentLinePrepayInfo
	 * @param List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyUnApplyPrepaymentLinePrepayInfo(List<PrepaymentApplyUnapplyVO> prepaymentApplyUnapplyVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (prepaymentApplyUnapplyVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyUnApplyPrepaymentLinePrepayInfoUSQL(), prepaymentApplyUnapplyVO, null);
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
	 * [STM_SAP_0241]
	 * @author ORKIM
	 * @category STM_SAP_0240
	 * @category searchFindPrepaymentLineCheck
	 * @param String inv_seq
	 * @param String apply_flg
	 * @return List<PrepaymentPayScheduleCheckVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PrepaymentPayScheduleCheckVO> searchFindPrepaymentPayScheduleCheck(String inv_seq, String apply_flg) throws DAOException {
		DBRowSet dbRowset = null;
		List<PrepaymentPayScheduleCheckVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (inv_seq != null) {
				param.put("inv_seq", inv_seq);
				velParam.put("inv_seq", inv_seq);
				
				param.put("apply_flg", apply_flg);
				velParam.put("apply_flg", apply_flg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchFindPrepaymentPayScheduleCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PrepaymentPayScheduleCheckVO.class);
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
	 * @author ORKIM
	 * @category STM_SAP_0210
	 * @category modifyPaymentSelectedInvoiceReturnInfo
	 * @param List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyPaymentSelectedInvoiceReturnInfo(List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchSelectedListVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyPaymentSelectedInvoiceReturnInfoUSQL(), paymentBatchSelectedListVO, null);
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
	 * @author ORKIM
	 * @category STM_SAP_0210
	 * @category modifyPaymentSelectedInvoiceFixInfo
	 * @param List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyPaymentSelectedInvoiceFixInfo(List<PaymentBatchSelectedListVO> paymentBatchSelectedListVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchSelectedListVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyPaymentSelectedInvoiceFixInfoUSQL(), paymentBatchSelectedListVO, null);
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
	 * @author ORKIM
	 * @category STM_SAP_0210
	 * @category modifyPayCaptureSelectedInvoiceChangeInfo
	 * @param List<PaymentBatchListVO> paymentBatchListVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyPayCaptureSelectedInvoiceChangeInfo(List<PaymentBatchListVO> paymentBatchListVO) throws DAOException {
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchListVO.size() > 0) {
				Map<String, String> mapVO= paymentBatchListVO.get(0).getColumnValues();				
				velParam.putAll(mapVO);
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyPayCaptureSelectedInvoiceChangeInfoUSQL(), paymentBatchListVO, velParam);
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
	 * @author ORKIM
	 * @category STM_SAP_0210
	 * @category modifyBatchPaymentInvScheduleCompleteInfo
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyBatchPaymentInvScheduleCompleteInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchEntryVendorSumInfoVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyBatchPaymentInvScheduleCompleteInfoUSQL(), paymentBatchEntryVendorSumInfoVO, null);
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
	 * @author ORKIM
	 * @category STM_SAP_0210
	 * @category modifyBatchPaymentInvoiceHeaderCompleteInfo
	 * @param List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyBatchPaymentInvoiceHeaderCompleteInfo(List<PaymentBatchEntryVendorSumInfoVO> paymentBatchEntryVendorSumInfoVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentBatchEntryVendorSumInfoVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyBatchPaymentInvoiceHeaderCompleteInfoUSQL(), paymentBatchEntryVendorSumInfoVO, null);
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
	 * CREATE Invoice Interface Header<br>
	 * 
	 * @author ORKIM
	 * @category addInvoiceIFHeader
	 * @param List<SapInvoiceInterfaceHeaderVO> sapInvoiceInterfaceHeaderVOList
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addInvoiceIFHeader(List<SapInvoiceInterfaceHeaderVO> sapInvoiceInterfaceHeaderVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (sapInvoiceInterfaceHeaderVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInvoiceHeaderIFCSQL(), sapInvoiceInterfaceHeaderVOList, null);
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
	 * CREATE Invoice Interface Detail<br>
	 * 
	 * @author ORKIM
	 * @category addInvoiceDetailIF
	 * @param List<SapInvoiceInterfaceDetailVO> sapInvoiceInterfaceDetailVOList
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addInvoiceLineIF(List<SapInvoiceInterfaceDetailVO> sapInvoiceInterfaceDetailVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (sapInvoiceInterfaceDetailVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInvoiceLineIFCSQL(), sapInvoiceInterfaceDetailVOList, null);
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
	 * Search Invoice Header IF Next Sequence <br>
	 * 
	 * @author ORKIM
	 * @category searchInoviceHeaderIFNextSeq
	 * @return String rtnValue (SAP_INV_HDR_IF_SEQ.NEXTVAL)
	 * @exception DAOException
	*/
	 
	public String searchInoviceHeaderIFNextSeq() throws DAOException {
		
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInoviceHeaderIFNextSeqRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("INV_IF_SEQ");
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
	 * modifyAccountingDetailInvLineFlag<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void modifyAccountingDetailInvLineFlag(List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyAccountingDetailInvLineFlagUSQL(), accountingInvoiceCheckVOs, null);
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
	 * modifyAccountingDetailInvLineCancelFlag<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void modifyAccountingDetailInvLineCancelFlag(List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingInvoiceCancelCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyAccountingDetailInvLineCancelFlagUSQL(), accountingInvoiceCancelCheckVOs, null);
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
	 * ModifyAccountingDetailPrepayApplyLineFlag<br>
	 *
	 * @author ORKIM
	 * @param List<AccountingPaymentCheckVO> accountingPaymentCheckVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void modifyAccountingDetailPrepayApplyLineFlag(List<AccountingPaymentCheckVO> accountingPaymentCheckVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (accountingPaymentCheckVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyAccountingDetailPrepayApplyLineFlagUSQL(), accountingPaymentCheckVOs, null);
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
	 * modifyAccountingDetailInvoiceLineRestore<br>
	 *
	 * @author ORKIM
	 * @param List<APAccountingListVO> aPAccountingListVOs
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public void modifyAccountingDetailInvoiceLineRestore(List<APAccountingListVO> aPAccountingListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (aPAccountingListVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyAccountingDetailInvoiceLineRestoreUSQL(), aPAccountingListVOs, null);
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
	 * [STM_SAP_0010]
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searhAsaInfoList
	 * @param String ofc_cd
	 * @param String inv_seq
	 * @param String inv_curr_cd
	 * @return List<AsaInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AsaInfoVO> searhAsaInfoList(String ofc_cd, String inv_seq, String inv_curr_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsaInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ofc_cd != null) {
				param.put("ofc_cd", ofc_cd);
				velParam.put("ofc_cd", ofc_cd);
				param.put("inv_seq", inv_seq);
				velParam.put("inv_seq", inv_seq);
				param.put("inv_curr_cd", inv_curr_cd);
				velParam.put("inv_curr_cd", inv_curr_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearhAsaInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsaInfoVO.class);
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
	 * [STM_SAP_0010]
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchAsaIFTransYN
	 * @param String inv_seq
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchAsaIFTransYN(String inv_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			param.put("inv_seq", inv_seq);
			velParam.put("inv_seq", inv_seq);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchAsaIFTransYNRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("TRANS_YN");
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
	 * [STM_SAP_0020]
	 * Invoice Approval List -  retrieve<br> 
	 * @author JBLEE
	 * @param String ofcCd
	 * @param String vndrNo
	 * @param String creDt
	 * @param String invNo
	 * @return List<InvoiceApprovalListVO>
	 * @exception DAOException
	*/
		 
	@SuppressWarnings("unchecked")
    public List<InvoiceApprovalListVO> searchInvoiceApprovalList(String ofcCd, String vndrNo, String creDt, String invNo) throws DAOException {
		DBRowSet dbRowset = null;
    
		List<InvoiceApprovalListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {	
    	
			 param.put("ofc_cd",  ofcCd);
			 param.put("vndr_no", vndrNo);
			 param.put("cre_dt",  creDt);
			 param.put("inv_no",  invNo);
     	
			 velParam.put("ofc_cd",  ofcCd);
			 velParam.put("vndr_no", vndrNo);
			 velParam.put("cre_dt",  creDt);
			 velParam.put("inv_no",  invNo);
        
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceApprovalListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceApprovalListVO.class);             
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
    /**
	 * [STM_SAP_0020]
	 * Invoice Approval<br> 
	 * @author JBLEE
	 * @param List<InvoiceApprovalInfoListVO> invoiceApprovalInfoListVOs
	 * @exception DAOException
    */
		 
	@SuppressWarnings("unchecked")
	public void modifyInvoiceApprovalInfo(List<InvoiceApprovalInfoListVO> invoiceApprovalInfoListVOs) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		//return variable
		int insCnt[] = null;
		
		try {	
			 if (invoiceApprovalInfoListVOs.size() > 0) {
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceApprovalInfoUSQL(), invoiceApprovalInfoListVOs, null);
				 for (int i=0; i<insCnt.length; i++) {
					 if (insCnt[i]== Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update No"+ i + " SQL");
				 }
			 }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [STM_SAP_0040]
	 * searhNextOpenedAsaCheckInfo <br>
	 * 
	 * @author KSJO
	 * @category STM_SAP_0040
	 * @category searhNextOpenedAsaCheckInfo
	 * @param String invSeq
	 * @param String ofcCd
	 * @param String invCurrCd
	 * @return String
	 * @exception DAOException
	*/
	 
	public String searhNextOpenedAsaCheckInfo(String invSeq, String ofcCd, String invCurrCd) throws DAOException {
		
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
				param.put("ofc_cd", ofcCd);	
				velParam.put("ofc_cd", ofcCd);
				param.put("inv_curr_cd", invCurrCd);	
				velParam.put("inv_curr_cd", invCurrCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearhNextOpenedAsaCheckInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("OPEN_ASA_NO");
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
	 *[STM_SAP_0040]
	 * CSR Receipt Entry - retrieve<br> 
	 * @author JBLEE
	 * @param InvoiceReceiptCondVO invoiceReceiptCondVO
	 * @return List<InvoiceReceiptListVO>
	 * @exception DAOException
    */

	@SuppressWarnings("unchecked")
    public List<InvoiceReceiptListVO> searchInvoiceReceiptList(InvoiceReceiptCondVO invoiceReceiptCondVO) throws DAOException {
		DBRowSet dbRowset = null;
 
		List<InvoiceReceiptListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {	
			 if(invoiceReceiptCondVO != null) {
				 Map<String, String> mapVO = invoiceReceiptCondVO.getColumnValues();
 	 
				 param.putAll(mapVO);        	
				 velParam.putAll(mapVO);
			 }
      
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceReceiptListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceReceiptListVO.class);             
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
    /**
	 *[STM_SAP_0040]
	 * CSR Receipt Entry - Confirm<br> 
	 * @author JBLEE
	 * @param String rctNoCmb
	 * @return String
	 * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public String searchInvoiceReceiptNumber(String rctNoCmb) throws DAOException {
		
		DBRowSet dbRowset = null;
		String invRctNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if (rctNoCmb != null) {
				param.put("rct_no_cmb", rctNoCmb);	
				velParam.put("rct_no_cmb", rctNoCmb);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceReceiptNumberRSQL(), param, velParam);
			if(dbRowset.next()) {
				invRctNo = dbRowset.getString("inv_rct_no");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return invRctNo;
	}
	
    /**
	 *[STM_SAP_0040]
	 * CSR Receipt Entry - Confirm<br> 
	 * @author JBLEE
	 * @param String invRctNo
	 * @param String invSeq
	 * @param String usrId  
	 * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void addInvoiceReceiptNoInfo(String invRctNo, String invSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;

		try{
			param.put("inv_rct_no", invRctNo);
			param.put("inv_seq",    invSeq);
			param.put("usr_id",     usrId);
			
    		velParam.put("inv_rct_no", invRctNo);
		    velParam.put("inv_seq",    invSeq);
			velParam.put("usr_id",     usrId);
			 
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInvoiceReceiptNoInfoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to insert SQL");                
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
	 *[STM_SAP_0040]
	 * CSR Receipt Entry - Confirm<br> 
	 * @author JBLEE
	 * @param String invRctNo
	 * @param String invSeq
	 * @param String usrId  
	 * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void modifyInvoiceReceiptInfo(String invRctNo, String invSeq, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		SQLExecuter sqlExe = new SQLExecuter("");
		
		int result = 0;

		try{
			 param.put("inv_rct_no", invRctNo);
			 param.put("inv_seq",    invSeq);
			 param.put("usr_id",     usrId);
    	
			 velParam.put("inv_rct_no", invRctNo);
			 velParam.put("inv_seq",    invSeq);
			 velParam.put("usr_id",     usrId);
			 
			 result = sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceReceiptInfoUSQL(), param, velParam);
			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to update SQL");                
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
	 *[STM_SAP_0040]
	 * CSR Receipt Entry - Release<br> 
	 * @author JBLEE
	 * @param List<InvoiceReceiptListVO> invoiceReceiptListVOs
	 * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void modifyInvoiceReceiptReleaseInfo(List<InvoiceReceiptListVO> invoiceReceiptListVOs) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		//return variable
		int insCnt[] = null;
		
		try {	
			 if (invoiceReceiptListVOs.size() > 0) {
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceReceiptReleaseInfoUSQL(), invoiceReceiptListVOs, null);
				 for (int i=0; i<insCnt.length; i++) {
					 if (insCnt[i]== Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update No"+ i + " SQL");
				 }
			 }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
	 *[STM_SAP_0040]
	 * CSR Receipt Entry - save<br> 
	 * @author JBLEE
	 * @param List<InvoiceReceiptListVO> invoiceReceiptListVOs
	 * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void modifyInvoiceReceiptEntryInvHeaderInfo(List<InvoiceReceiptListVO> invoiceReceiptListVOs) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		//return variable
		int insCnt[] = null;
		
		try {	
			 if (invoiceReceiptListVOs.size() > 0) {
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceReceiptEntryInvHeaderInfoUSQL(), invoiceReceiptListVOs, null);
				 for (int i=0; i<insCnt.length; i++) {
					 if (insCnt[i]== Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update No"+ i + " SQL");
				 }
			 }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
	 *[STM_SAP_0040]
	 * CSR Receipt Entry - save<br> 
	 * @author JBLEE
	 * @param List<InvoiceReceiptListVO> invoiceReceiptListVOs
	 * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void modifyInvoiceReceiptEntryPayScheduleInfo(List<InvoiceReceiptListVO> invoiceReceiptListVOs) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		//return variable
		int insCnt[] = null;
		
		try {	
			 if (invoiceReceiptListVOs.size() > 0) {
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceReceiptEntryPayScheduleInfoUSQL(), invoiceReceiptListVOs, null);
				 for (int i=0; i<insCnt.length; i++) {
					 if (insCnt[i]== Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update No"+ i + " SQL");
				 }
			 }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
	 * [STM_SAP_B001]
	 * ASA Interface Update<br> 
	 * @author JBLEE
	 * @param List<InvoiceEntryLineListVO> invoiceEntryLineListVOs
	 * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void modifyASAInterfaceFlag(List<InvoiceEntryLineListVO> invoiceEntryLineListVOs) throws DAOException {
		
		SQLExecuter sqlExe = new SQLExecuter("");
		//return variable
		int insCnt[] = null;
		
		try {	
			 if (invoiceEntryLineListVOs.size() > 0) {
				 insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyASAInterfaceFlagUSQL(), invoiceEntryLineListVOs, null);
				 for (int i=0; i<insCnt.length; i++) {
					 if (insCnt[i]== Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update No"+ i + " SQL");
				 }
			 }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [STM_SAP_0030]
	 *  Invoice Slip - Invoice Header Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param InvoiceSlipCondVO invoiceSlipCondVO
	 * @return List<InvoiceSlipListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceSlipListVO> searchInvoiceSlipList(InvoiceSlipCondVO invoiceSlipCondVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<InvoiceSlipListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if (invoiceSlipCondVO != null) {
				Map<String, String> mapVO= invoiceSlipCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceSlipListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceSlipListVO.class);     
			
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
	 * [STM_SAP_0030]
	 *  Invoice Slip - Invoice Line (TAB) Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param String invSeq
	 * @param String invCurrCd 
	 * @return List<InvoiceSlipDetailListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceSlipDetailListVO> searchInvoiceSlipDetailList(String invSeq, String invCurrCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<InvoiceSlipDetailListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(invSeq != null && invCurrCd != null) {
				param.put("inv_seq", invSeq);	
	         	velParam.put("inv_seq", invSeq);
              
	         	param.put("inv_curr_cd", invCurrCd);	
	         	velParam.put("inv_curr_cd", invCurrCd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceSlipDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceSlipDetailListVO.class);     
			
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
	 * [STM_SAP_0030]
	 *  Invoice Slip - Invoice Payment (TAB) Retrieve<br>
	 *
	 * @author Hannah Lee
	 * @param String invSeq
	 * @return List<InvoiceSlipPaymentListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceSlipPaymentListVO> searchInvoiceSlipPaymentList(String invSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<InvoiceSlipPaymentListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(invSeq != null) {
				param.put("inv_seq", invSeq);	
	         	velParam.put("inv_seq", invSeq);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceSlipPaymentListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceSlipPaymentListVO.class);     
			
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
	 * Payment Invoice Modify<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category modifyPaymentInvoice
	 * @param List<PaymentEntryLineVO> paymentEntryLineVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyPaymentInvoice(List<PaymentEntryLineVO> paymentEntryLineVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentEntryLineVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyPaymentInvoiceUSQL(), paymentEntryLineVO, null);
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
	 * Payment Invoice Schedule Modify<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category modifyPaymentSchedule
	 * @param List<PaymentEntryLineVO> paymentEntryLineVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyPaymentSchedule(List<PaymentEntryLineVO> paymentEntryLineVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentEntryLineVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyPaymentScheduleUSQL(), paymentEntryLineVO, null);
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
	 * Payment Invoice Void 처리<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category modifyInvoiceHeaderVoid
	 * @param List<PaymentEntryLineVO> paymentEntryLineVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyInvoiceHeaderVoid(List<PaymentEntryLineVO> paymentEntryLineVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentEntryLineVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceHeaderVoidUSQL(), paymentEntryLineVO, null);
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
	 * Payment Invoice Schedule Void 처리<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0060
	 * @category modifyPaymentScheduleVoid
	 * @param List<PaymentEntryLineVO> paymentEntryLineVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyPaymentScheduleVoid(List<PaymentEntryLineVO> paymentEntryLineVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentEntryLineVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyPaymentScheduleVoidUSQL(), paymentEntryLineVO, null);
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
	 * [STM_SAP_0340]
	 *  Unsettled Summary에  전월 미결 자료 내역이 존재 여부 체크 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0340
	 * @category searchUnsettledAccountSummaryExistsCheck
	 * @param String glDt
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	 
	public SapCommonVO searchUnsettledAccountSummaryExistsCheck(String glDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (glDt != null) {
				param.put("gl_dt", glDt);	
				velParam.put("gl_dt", glDt);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchUnsettledAccountSummaryExistsCheckRSQL(), param, velParam);
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
     * [STM_SAP_0340]
     * Unsettled Report By Account -  retrieve<br> 
     * @author sangyoung cha
     * @param UnsettledEntryCondVO unsettledEntryCondVO
     * @return List<UnsettledAccountListVO>
     * @exception DAOException
	*/

	@SuppressWarnings("unchecked")
    public List<UnsettledAccountListVO> searchUnsettledAccountList(UnsettledEntryCondVO unsettledEntryCondVO) throws DAOException {
		 
		DBRowSet dbRowset = null;
 
		List<UnsettledAccountListVO> list = null;
 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
 
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {	
			 if(unsettledEntryCondVO != null) {
				 Map<String, String> mapVO = unsettledEntryCondVO.getColumnValues();
 	 
				 param.putAll(mapVO);        	
				 velParam.putAll(mapVO);
			 }
      
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchUnsettledAccountListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnsettledAccountListVO.class);             
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * [STM_SAP_0340]
	 *  Capture 처리할 대상월의 Period가 닫혀 있는지를 확인 체크 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0340
	 * @category selectUnsettledAccountCapturePeriodCheck
	 * @param String unstlYrmon
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	 
	public SapCommonVO selectUnsettledAccountCapturePeriodCheck(String unstlYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (unstlYrmon != null) {
				param.put("unstl_yrmon", unstlYrmon);	
				velParam.put("unstl_yrmon", unstlYrmon);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSelectUnsettledAccountCapturePeriodCheckRSQL(), param, velParam);
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
	 * [STM_SAP_0340]
	 * 미결 내역의 기존 산출 자료가 존재하는 경우 해당 자료를 삭제 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0340
	 * @category removeUnsettledAccountCapture
	 * @param String unstlYrmon
	 * @exception DAOException
	 */
	public void removeUnsettledAccountCapture(String unstlYrmon) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			if (unstlYrmon != null) {
				param.put("unstl_yrmon", unstlYrmon);		
				velParam.put("unstl_yrmon", unstlYrmon);		
			}
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAORemoveUnsettledAccountCaptureDSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00066")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}	
		
	/**
	 * [STM_SAP_0340]
	 * 미결 내역 Summary 테이블에 저장 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0340
	 * @category addUnsettledAccountInvoiceSummary
	 * @param String unstlYrmon
	 * @param String usrId
	 * @exception DAOException
	 */
	public void addUnsettledAccountInvoiceSummary(String unstlYrmon, String usrId) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			if (unstlYrmon != null) {
				param.put("unstl_yrmon", unstlYrmon);		
				param.put("usr_id", usrId);
				velParam.put("unstl_yrmon", unstlYrmon);	
				velParam.put("usr_id", usrId);
			}
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOAddUnsettledAccountInvoiceSummaryCSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}		
	
	/**
	 * [STM_SAP_0340]
	 * 미결 내역 Summary 테이블에 저장 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0340
	 * @category addUnsettledAccountPrepaymentInvoiceSummary
	 * @param String unstlYrmon
	 * @param String usrId
	 * @exception DAOException
	 */
	public void addUnsettledAccountPrepaymentInvoiceSummary(String unstlYrmon, String usrId) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			if (unstlYrmon != null) {
				param.put("unstl_yrmon", unstlYrmon);		
				param.put("usr_id", usrId);
				velParam.put("unstl_yrmon", unstlYrmon);	
				velParam.put("usr_id", usrId);
			}
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOAddUnsettledAccountPrepaymentInvoiceSummaryCSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	

	/**
	 * [STM_SAP_0340]
	 * 미결 내역 Summary 테이블에 저장 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0340
	 * @category addUnsettledAccountPaymentSummary
	 * @param String unstlYrmon
	 * @param String usrId
	 * @exception DAOException
	 */
	public void addUnsettledAccountPaymentSummary(String unstlYrmon, String usrId) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			if (unstlYrmon != null) {
				param.put("unstl_yrmon", unstlYrmon);		
				param.put("usr_id", usrId);
				velParam.put("unstl_yrmon", unstlYrmon);	
				velParam.put("usr_id", usrId);
			}
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOAddUnsettledAccountPaymentSummaryCSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * [STM_SAP_0340]
	 * 미결 내역 Summary 테이블에 저장 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0340
	 * @category addUnsettledAccountPrepaymentApplyPrepaySummary
	 * @param String unstlYrmon
	 * @param String usrId
	 * @exception DAOException
	 */
	public void addUnsettledAccountPrepaymentApplyPrepaySummary(String unstlYrmon, String usrId) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			if (unstlYrmon != null) {
				param.put("unstl_yrmon", unstlYrmon);		
				param.put("usr_id", usrId);
				velParam.put("unstl_yrmon", unstlYrmon);	
				velParam.put("usr_id", usrId);
			}
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOAddUnsettledAccountPrepaymentApplyPrepaySummaryCSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}	
	
	/**
	 * [STM_SAP_0340]
	 * 미결 내역 Summary 테이블에 저장 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0340
	 * @category addUnsettledAccountPrepaymentApplyInvSummary
	 * @param String unstlYrmon
	 * @param String usrId
	 * @exception DAOException
	 */
	public void addUnsettledAccountPrepaymentApplyInvSummary(String unstlYrmon, String usrId) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			if (unstlYrmon != null) {
				param.put("unstl_yrmon", unstlYrmon);		
				param.put("usr_id", usrId);
				velParam.put("unstl_yrmon", unstlYrmon);	
				velParam.put("usr_id", usrId);
			}
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOAddUnsettledAccountPrepaymentApplyInvSummaryCSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}	
		
	/**
	 * [STM_SAP_0340]
	 * 미결 내역 Summary 테이블에 저장 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0340
	 * @category addUnsettledAccountPreviousSummaryMoveNext
	 * @param String unstlYrmon
	 * @param String usrId
	 * @exception DAOException
	 */
	public void addUnsettledAccountPreviousSummaryMoveNext(String unstlYrmon, String usrId) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			if (unstlYrmon != null) {
				param.put("unstl_yrmon", unstlYrmon);		
				param.put("usr_id", usrId);
				velParam.put("unstl_yrmon", unstlYrmon);	
				velParam.put("usr_id", usrId);
			}
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOAddUnsettledAccountPreviousSummaryMoveNextCSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * [STM_SAP_0340]
	 * 미결 내역 Summary 테이블에 저장 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0340
	 * @category modifyUnsettledAccountSummarySettle
	 * @param String unstlYrmon
	 * @param String usrId
	 * @exception DAOException
	 */
	public void modifyUnsettledAccountSummarySettle(String unstlYrmon, String usrId) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			if (unstlYrmon != null) {
				param.put("unstl_yrmon", unstlYrmon);		
				param.put("usr_id", usrId);
				velParam.put("unstl_yrmon", unstlYrmon);	
				velParam.put("usr_id", usrId);
			}
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOModifyUnsettledAccountSummarySettleUSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	

    /**
	 *[STM_SAP_0250]
	 * searchInvoiceInterfaceReqNumCheck<br> 
	 * @author sangyoung cha
	 * @return String
	 * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public String searchInvoiceInterfaceReqNumCheck() throws DAOException {
		
		DBRowSet dbRowset = null;
		String ifRequestSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceReqNumCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				ifRequestSeq = dbRowset.getString("if_request_seq");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ifRequestSeq;
	}
	

	/**
	 * [STM_SAP_0250]
	 *  I/F대상 테이블의 Header 내역을 VO로 생성 처리 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0250
	 * @category searchSapInvoiceInterfaceHeader
	 * @param String csrNo
	 * @return SapInvoiceInterfaceHeaderVO
	 * @exception DAOException
	*/
	 
	public SapInvoiceInterfaceHeaderVO searchSapInvoiceInterfaceHeader(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapInvoiceInterfaceHeaderVO> list = null;
		SapInvoiceInterfaceHeaderVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("csr_no", csrNo);	
			velParam.put("csr_no", csrNo);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceHeaderRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapInvoiceInterfaceHeaderVO.class);    
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
	 * [STM_SAP_0250]
	 *  I/F대상 테이블의 Header 내역을 VO로 생성 처리 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0250
	 * @category searchSoInvoiceInterfaceHeader
	 * @param String csrNo
	 * @param String ifRequestSeq
	 * @return SapInvoiceInterfaceHeaderVO
	 * @exception DAOException
	*/
	 
	public SapInvoiceInterfaceHeaderVO searchSoInvoiceInterfaceHeader(String csrNo, String ifRequestSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapInvoiceInterfaceHeaderVO> list = null;
		SapInvoiceInterfaceHeaderVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("csr_no", csrNo);	
			param.put("if_request_seq", ifRequestSeq);
			velParam.put("csr_no", csrNo);
			velParam.put("if_request_seq", ifRequestSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchSoInvoiceInterfaceHeaderRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapInvoiceInterfaceHeaderVO.class);    
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
	 * STM_SAP_0250 : interface batch
	 * searchInvoiceLineNumDupCheck<br> 
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceLineNumDupCheck(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String errorCnt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("csr_no", csrNo);		
			velParam.put("csr_no", csrNo);	
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceLineNumDupCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				errorCnt = dbRowset.getString("error_cnt");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return errorCnt;
	}        
	
	/**
	 * [STM_SAP_0250]
	 *  I/F대상 테이블의 Detail(Line) 내역을 VO로 생성 처리
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0250
	 * @category searchSapInvoiceInterfaceDetail
	 * @param String csrNo
	 * @return List<SapInvoiceInterfaceDetailVO>
	 * @exception DAOException
	*/
	 
	public List<SapInvoiceInterfaceDetailVO> searchSapInvoiceInterfaceDetail(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapInvoiceInterfaceDetailVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("csr_no", csrNo);	
			velParam.put("csr_no", csrNo);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchSapInvoiceInterfaceDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapInvoiceInterfaceDetailVO.class);    
			
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
	 * [STM_SAP_0250]
	 *  I/F대상 테이블의 Detail(Line) 내역을 VO로 생성 처리
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0250
	 * @category searchSoInvoiceInterfaceDetail
	 * @param String csrNo
	 * @param String ifRequestSeq
	 * @return List<SapInvoiceInterfaceDetailVO>
	 * @exception DAOException
	*/
	 
	public List<SapInvoiceInterfaceDetailVO> searchSoInvoiceInterfaceDetail(String csrNo, String ifRequestSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapInvoiceInterfaceDetailVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			param.put("csr_no", csrNo);	
			param.put("if_request_seq", ifRequestSeq);	
			velParam.put("csr_no", csrNo);
			velParam.put("if_request_seq", ifRequestSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchSoInvoiceInterfaceDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapInvoiceInterfaceDetailVO.class);    
			
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
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceDetailApIfSumAmtCheck<br> 
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceDetailApIfSumAmtCheck(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String invSumAmt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("csr_no", csrNo);		
			velParam.put("csr_no", csrNo);					
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceDetailApIfSumAmtCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				invSumAmt = dbRowset.getString("inv_sum_amt");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return invSumAmt;
	}        
	
	
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceDetailSumAmtCheck<br> 
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceDetailSumAmtCheck(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String invSumAmt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("csr_no", csrNo);		
			velParam.put("csr_no", csrNo);					
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceDetailSumAmtCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				invSumAmt = dbRowset.getString("inv_sum_amt");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return invSumAmt;
	}        
	
	/**
	 * [STM_SAP_0250]
	 * AP 오류 테이블에 저장 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0250
	 * @category modifyAPInvoiceInterfaceResult
	 * @param String csrNo
	 * @param String ifErrRsn
	 * @exception DAOException
	 */
	public void modifyAPInvoiceInterfaceResult(String csrNo, String ifErrRsn) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			param.put("csr_no", csrNo);		
			param.put("if_err_rsn", ifErrRsn);
			velParam.put("csr_no", csrNo);	
			velParam.put("if_err_rsn", ifErrRsn);
		
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOModifyAPInvoiceInterfaceResultUSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}	
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceCurrUseCheck<br> 
	 * @author sangyoung cha
	 * @param String invAmt
	 * @param String invCurrCd
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfaceCurrUseCheck(String invAmt, String invCurrCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("inv_amt", invAmt);		
			param.put("inv_curr_cd", invCurrCd);
			velParam.put("inv_amt", invAmt);
			velParam.put("inv_curr_cd", invCurrCd);					
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCurrUseCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("curr_cd"));
				sapCommonVO.setValue1(dbRowset.getString("curr_precision_amt"));
				sapCommonVO.setValue2(dbRowset.getString("functional_currency"));
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	}        
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceCurrExchangeRateCheck<br> 
	 * @author sangyoung cha
	 * @param String glDt
	 * @param String invCurrCd
	 * @param String functionalCurrency
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfaceCurrExchangeRateCheck(String glDt, String invCurrCd, String functionalCurrency) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("gl_dt", glDt);		
			param.put("inv_curr_cd", invCurrCd);
			param.put("functional_currency", functionalCurrency);
			velParam.put("gl_dt", glDt);
			velParam.put("inv_curr_cd", invCurrCd);
			velParam.put("functional_currency", functionalCurrency);					
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCurrExchangeRateCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("acct_xch_rt_dt"));
				sapCommonVO.setValue1(dbRowset.getString("acct_xch_rt_lvl"));
				sapCommonVO.setValue2(dbRowset.getString("conv_xch_rt"));
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	}     
	

	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceInvNODupCheck<br> 
	 * @author sangyoung cha
	 * @param String invNo
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceInvNODupCheck(String invNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String dupInvNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("inv_no", invNo);		
			velParam.put("inv_no", invNo);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceInvNODupCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				dupInvNo = dbRowset.getString("dup_inv_no");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dupInvNo;
	}        
		
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceFrontGLDateCheck<br> 
	 * @author sangyoung cha
	 * @param String glDt
	 * @param String glSystemDivFlg
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceFrontGLDateCheck(String glDt, String glSystemDivFlg, String ofcCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String periodUseFlag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("gl_dt", glDt);
			param.put("gl_system_div_flg", glSystemDivFlg);	
			param.put("ofc_cd", ofcCd);	
			velParam.put("gl_dt", glDt);	
			velParam.put("gl_system_div_flg", glSystemDivFlg);	
			velParam.put("ofc_cd", ofcCd);						
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceFrontGLDateCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				periodUseFlag = dbRowset.getString("period_use_flag");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return periodUseFlag;
	}      
	

	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceAPGLDateCheck<br> 
	 * @author sangyoung cha
	 * @param String glDt
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceAPGLDateCheck(String glDt) throws DAOException {
		
		DBRowSet dbRowset = null;
		String apPeriodUseFlag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			param.put("gl_dt", glDt);		
			velParam.put("gl_dt", glDt);		
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPGLDateCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				apPeriodUseFlag = dbRowset.getString("ap_period_use_flag");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return apPeriodUseFlag;
	}    

	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceSupplierActiveCheck<br> 
	 * @author sangyoung cha
	 * @param String vndrNo
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceSupplierActiveCheck(String vndrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String supplierNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("vndr_no", vndrNo);		
			velParam.put("vndr_no", vndrNo);	
					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceSupplierActiveCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				supplierNo = dbRowset.getString("supplier_no");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return supplierNo;
	}   
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceTermsNameCheck<br> 
	 * @author sangyoung cha
	 * @param String invTermNm
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceTermsNameCheck(String invTermNm) throws DAOException {
		
		DBRowSet dbRowset = null;
		String termsName = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("inv_term_nm", invTermNm);		
			velParam.put("inv_term_nm", invTermNm);					
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceTermsNameCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				termsName = dbRowset.getString("terms_name");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return termsName;
	}   
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceExchangeMethodCheck<br> 
	 * @author Kyungsam Jo
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceExchangeMethodCheck() throws DAOException {
		
		DBRowSet dbRowset = null;
		String apexchangemethod = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceExchangeMethodCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				apexchangemethod = dbRowset.getString("exchange_method");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return apexchangemethod;
	}   

	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceSystemSourceCheck<br> 
	 * @author sangyoung cha
	 * @param String ifSrcNm
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceSystemSourceCheck(String ifSrcNm) throws DAOException {
		
		DBRowSet dbRowset = null;
		String systemSource = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("if_src_nm", ifSrcNm);		
			velParam.put("if_src_nm", ifSrcNm);					
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceSystemSourceCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				systemSource = dbRowset.getString("system_source");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return systemSource;
	} 	
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheck<br> 
	 * @author KS Jo
	 * @param String ifVndNo
	 * @param String ifCurrCd
	 * @param String ifLiabAcct
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheck(String ifVndNo, String ifCurrCd, String ifLiabAcct) throws DAOException {
		
		DBRowSet dbRowset = null;
		String localCurrency = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("ifVndNo", ifVndNo);		
			velParam.put("ifVndNo", ifVndNo);	
			param.put("ifCurrCd", ifCurrCd);		
			velParam.put("ifCurrCd", ifCurrCd);
			param.put("ifLiabAcct", ifLiabAcct);		
			velParam.put("ifLiabAcct", ifLiabAcct);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLocalCurrencyofACHPaymentMethodCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				localCurrency = dbRowset.getString("cnt_curr_cd");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return localCurrency;
	} 	
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfacePaymentMethodCheck<br> 
	 * @author sangyoung cha
	 * @param String vndrNo
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfacePaymentMethodCheck(String vndrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("vndr_no", vndrNo);		
			velParam.put("vndr_no", vndrNo);						
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfacePaymentMethodCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("payment_method"));
				sapCommonVO.setValue1(dbRowset.getString("Pay_Term_Tp_Cd"));
				sapCommonVO.setValue2(dbRowset.getString("bank_acct_flg"));
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	}     
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceApPaymentMethodCodeCheck<br> 
	 * @author jo kyung sam
	 * @param String paymentMethod
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfaceApPaymentMethodCodeCheck(String paymentMethod) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("payment_method", paymentMethod);		
			velParam.put("payment_method", paymentMethod);						
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceApPaymentMethodCodeCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("payment_method"));
				sapCommonVO.setValue1(dbRowset.getString("pay_method_name"));
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	}   
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfacePayGroupExistsCheck<br> 
	 * @author sangyoung cha
	 * @param String payGrpLuCd
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfacePayGroupExistsCheck(String payGrpLuCd, String ofcCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String paygroupLookupCode = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("pay_grp_lu_cd", payGrpLuCd);		
			param.put("ofc_cd", ofcCd);	
			velParam.put("pay_grp_lu_cd", payGrpLuCd);	
			velParam.put("ofc_cd", ofcCd);					
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfacePayGroupExistsCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				paygroupLookupCode = dbRowset.getString("paygroup_lookup_code");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return paygroupLookupCode;
	}     
		
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceInterCompanyCheck<br> 
	 * @author sangyoung cha
	 * @param String liabCdCmbSeq
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceInterCompanyCheck(String liabCdCmbSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String intercompanyCode = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("liab_cd_cmb_seq", liabCdCmbSeq);		
			velParam.put("liab_cd_cmb_seq", liabCdCmbSeq);	
								
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceInterCompanyCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				intercompanyCode = dbRowset.getString("intercompany_code");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return intercompanyCode;
	}     
		
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceVendorInterCompanyCheck<br> 
	 * @author sangyoung cha
	 * @param String vndrNo
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceVendorInterCompanyCheck(String vndrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String vendorIntercompanyCode = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("vndr_no", vndrNo);		
			velParam.put("vndr_no", vndrNo);						
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceVendorInterCompanyCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				vendorIntercompanyCode = dbRowset.getString("vendor_intercompany_code");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vendorIntercompanyCode;
	}   		

	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceAccountAndVVDCheck<br> 
	 * @author sangyoung cha
	 * @param String liabCdCmbSeq
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfaceAccountAndVVDCheck(String liabCdCmbSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("liab_cd_cmb_seq", liabCdCmbSeq);		
			velParam.put("liab_cd_cmb_seq", liabCdCmbSeq);	
								
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAccountAndVVDCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("coa_account_code"));
				sapCommonVO.setValue1(dbRowset.getString("coa_vvd_code"));				
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	}     
		
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceAccountAndVVDLevelCheck<br> 
	 * @author sangyoung cha
	 * @param String liabCoaAcctNo
	 * @param String liabCoaVvdCd
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfaceAccountAndVVDLevelCheck(String liabCoaAcctNo, String liabCoaVvdCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("liab_coa_acct_no", liabCoaAcctNo);
			param.put("liab_coa_vvd_cd", liabCoaVvdCd);	
			velParam.put("liab_coa_acct_no", liabCoaAcctNo);	
			velParam.put("liab_coa_vvd_cd", liabCoaVvdCd);						
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAccountAndVVDLevelCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("acct_cd"));
				sapCommonVO.setValue1(dbRowset.getString("vvd_level_1"));	
				sapCommonVO.setValue2(dbRowset.getString("vvd_level_2"));	
				sapCommonVO.setValue3(dbRowset.getString("vvd_level_3"));	
				sapCommonVO.setValue4(dbRowset.getString("vvd_level_4"));	
				sapCommonVO.setValue5(dbRowset.getString("vvd_level_5"));	
				sapCommonVO.setValue6(dbRowset.getString("vvd_level_6"));	
				sapCommonVO.setValue7(dbRowset.getString("vvd_cd"));	
				sapCommonVO.setValue8(dbRowset.getString("vvd_common_level"));
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	}    	
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceCodeCombinationCheck<br> 
	 * @author sangyoung cha
	 * @param String liabCdCmbSeq
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceCodeCombinationCheck(String liabCdCmbSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String cdCmbSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("liab_cd_cmb_seq", liabCdCmbSeq);		
			velParam.put("liab_cd_cmb_seq", liabCdCmbSeq);						
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCodeCombinationCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				cdCmbSeq = dbRowset.getString("cd_cmb_seq");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cdCmbSeq;
	}   		

	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceCombineCombinationCheck<br> 
	 * @author sangyoung cha
	 * @param SapCommonVO vo
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfaceCombineCombinationCheck(SapCommonVO vo) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("liab_coa_co_cd", vo.getValue0());
			param.put("liab_coa_rgn_cd", vo.getValue1());	
			param.put("liab_coa_ctr_cd", vo.getValue2());
			param.put("liab_coa_acct_no", vo.getValue3());	
			param.put("liab_coa_inter_co_cd", vo.getValue4());
			param.put("liab_coa_vvd_cd", vo.getValue5());				
			velParam.put("liab_coa_co_cd", vo.getValue0());	
			velParam.put("liab_coa_rgn_cd", vo.getValue1());						
			velParam.put("liab_coa_ctr_cd", vo.getValue2());	
			velParam.put("liab_coa_acct_no", vo.getValue3());	
			velParam.put("liab_coa_inter_co_cd", vo.getValue4());	
			velParam.put("liab_coa_vvd_cd", vo.getValue5());							
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceCombineCombinationCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("cd_cmb_seq"));
				sapCommonVO.setValue1(dbRowset.getString("compnay_code"));	
				sapCommonVO.setValue2(dbRowset.getString("region_code"));	
				sapCommonVO.setValue3(dbRowset.getString("center_code"));	
				sapCommonVO.setValue4(dbRowset.getString("account_code"));	
				sapCommonVO.setValue5(dbRowset.getString("intercompany_code"));	
				sapCommonVO.setValue6(dbRowset.getString("vvd_code"));									
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	}    	
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceAPOfficeCheck<br> 
	 * @author sangyoung cha
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceAPOfficeCheck(String ofcCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String officeCode = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("ofc_cd", ofcCd);		
			velParam.put("ofc_cd", ofcCd);						
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPOfficeCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				officeCode = dbRowset.getString("office_code");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return officeCode;
	}   
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceOfficeEnableVendorCheck<br> 
	 * @author kyungsam jo
	 * @param String ofcCd
	 * @param String vndrCd
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceOfficeEnableVendorCheck(String ofcCd, String vndrCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String enable_flg = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("ofc_cd", ofcCd);		
			velParam.put("ofc_cd", ofcCd);	
			param.put("vndr_cd", vndrCd);		
			velParam.put("vndr_cd", vndrCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceOfficeEnableVendorCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				enable_flg = dbRowset.getString("enable_flg");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return enable_flg;
	} 

	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfacePrepaymentAvailableCheck<br> 
	 * @author sangyoung cha
	 * @param String ppayInvNo
	 * @param String ppayInvLineNo
	 * @param String ppayAplyAmt
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfacePrepaymentAvailableCheck(String ppayInvNo, String ppayInvLineNo, String ppayAplyAmt) throws DAOException {
		
		DBRowSet dbRowset = null;
		String prepayInvoiceNumber = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("ppay_inv_no", ppayInvNo);		
			param.put("ppay_inv_line_no", ppayInvLineNo);	
			param.put("ppay_aply_amt", ppayAplyAmt);	
			velParam.put("ppay_inv_no", ppayInvNo);			
			velParam.put("ppay_inv_line_no", ppayInvLineNo);	
			velParam.put("ppay_aply_amt", ppayAplyAmt);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfacePrepaymentAvailableCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				prepayInvoiceNumber = dbRowset.getString("prepay_invoice_number");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return prepayInvoiceNumber;
	}   	
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceASAOfficeCheck<br> 
	 * @author sangyoung cha
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceASAOfficeCheck(String ofcCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String officeAsaFlag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("ofc_cd", ofcCd);		
			velParam.put("ofc_cd", ofcCd);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAOfficeCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				officeAsaFlag = dbRowset.getString("office_asa_flag");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return officeAsaFlag;
	}  
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceASAMasterCheck<br> 
	 * @author sangyoung cha
	 * @param String attrCtnt2
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceASAMasterCheck(String attrCtnt2) throws DAOException {
		
		DBRowSet dbRowset = null;
		String asaNumber = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("attr_ctnt2", attrCtnt2);		
			velParam.put("attr_ctnt2", attrCtnt2);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAMasterCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				asaNumber = dbRowset.getString("asa_number");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return asaNumber;
	}  	
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceASAMasterCurrencyCheck<br> 
	 * @author kyungsam jo
	 * @param String attrCtnt2
	 * @param String invCurrencyCode
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceASAMasterCurrencyCheck(String attrCtnt2, String invCurrencyCode) throws DAOException {
		
		DBRowSet dbRowset = null;
		String asaCurrency = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("attr_ctnt2", attrCtnt2);		
			velParam.put("attr_ctnt2", attrCtnt2);	
			param.put("inv_currency_code", invCurrencyCode);		
			velParam.put("inv_currency_code", invCurrencyCode);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAMasterCurrencyCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				asaCurrency = dbRowset.getString("asa_currency");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return asaCurrency;
	}  
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceASAClearingAccountCheck<br> 
	 * @author kyungsam jo
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceASAClearingAccountCheck() throws DAOException {
		
		DBRowSet dbRowset = null;
		String asaClearAcct = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceASAClearingAccountCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				asaClearAcct = dbRowset.getString("asa_clear_acct");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return asaClearAcct;
	}  

	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceAPClearingAcctCheck<br> 
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceAPClearingAcctCheck(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String clearingCount = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("csr_no", csrNo);		
			velParam.put("csr_no", csrNo);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAPClearingAcctCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				clearingCount = dbRowset.getString("clearing_count");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return clearingCount;
	} 
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceSOClearingAcctCheck<br> 
	 * @author sangyoung cha
	 * @param String csrNo
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceSOClearingAcctCheck(String csrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String clearingCount = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("csr_no", csrNo);		
			velParam.put("csr_no", csrNo);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceSOClearingAcctCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				clearingCount = dbRowset.getString("clearing_count");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return clearingCount;
	} 	
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceLineCurrUseCheck<br> 
	 * @author sangyoung cha
	 * @param String dtrbAmt
	 * @param String invCurrCd
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfaceLineCurrUseCheck(String dtrbAmt, String invCurrCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("dtrb_amt", dtrbAmt);
			param.put("inv_curr_cd", invCurrCd);	
			velParam.put("dtrb_amt", dtrbAmt);	
			velParam.put("inv_curr_cd", invCurrCd);						
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineCurrUseCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("l_curr_cd"));
				sapCommonVO.setValue1(dbRowset.getString("l_curr_precision_amt"));	
				sapCommonVO.setValue2(dbRowset.getString("l_functional_currency"));	
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	}    			

	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceLineInterCompanyCheck<br> 
	 * @author sangyoung cha
	 * @param String dtrbCdCmbSeq
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceLineInterCompanyCheck(String dtrbCdCmbSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String lIntercompanyCode = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("dtrb_cd_cmb_seq", dtrbCdCmbSeq);		
			velParam.put("dtrb_cd_cmb_seq", dtrbCdCmbSeq);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineInterCompanyCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				lIntercompanyCode = dbRowset.getString("l_intercompany_code");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return lIntercompanyCode;
	} 
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceLineAccountAndVVDCheck<br> 
	 * @author sangyoung cha
	 * @param String dtrbCdCmbSeq
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfaceLineAccountAndVVDCheck(String dtrbCdCmbSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("dtrb_cd_cmb_seq", dtrbCdCmbSeq);
			velParam.put("dtrb_cd_cmb_seq", dtrbCdCmbSeq);					
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineAccountAndVVDCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("l_coa_account_code"));
				sapCommonVO.setValue1(dbRowset.getString("l_coa_vvd_code"));					
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	} 
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceLineVndrInvNoDupCheckRSQL<br> 
	 * @author sangyoung cha
	 * @param String vndrNo
	 * @param String csrNo
	 * @param String attrCtnt1
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceLineVndrInvNoDupCheckRSQL(String vndrNo, String csrNo, String attrCtnt1) throws DAOException {
		
		DBRowSet dbRowset = null;
		String vndrDupReason = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("vndr_no", vndrNo);	
			param.put("csr_no", csrNo);
			param.put("attr_ctnt1", attrCtnt1);
			velParam.put("vndr_no", vndrNo);			
			velParam.put("csr_no", csrNo);
			velParam.put("attr_ctnt1", attrCtnt1);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineVndrInvNoDupCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				vndrDupReason = dbRowset.getString("vndr_dup_reason");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return vndrDupReason;
	} 
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceLineTaxCodeCheck<br> 
	 * @author sangyoung cha
	 * @param String dtrbVatCd
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfaceLineTaxCodeCheck(String dtrbVatCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("dtrb_vat_cd", dtrbVatCd);
			velParam.put("dtrb_vat_cd", dtrbVatCd);					
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineTaxCodeCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("ap_tax_nm"));
				sapCommonVO.setValue1(dbRowset.getString("tax_no"));
				sapCommonVO.setValue2(dbRowset.getString("tax_rt"));
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	} 
	
	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceLineUnsettleAccountCheck<br> 
	 * @author sangyoung cha
	 * @param String dtrbCoaAcctNo
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfaceLineUnsettleAccountCheck(String dtrbCoaAcctNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("dtrb_coa_acct_no", dtrbCoaAcctNo);
			velParam.put("dtrb_coa_acct_no", dtrbCoaAcctNo);					
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceLineUnsettleAccountCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("l_account_code"));
				sapCommonVO.setValue1(dbRowset.getString("l_unsettled_flag"));				
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	}
	

	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceFunctionalAmtCalculateCheck<br> 
	 * @author sangyoung cha
	 * @param String invAmt
	 * @param String invXchRt
	 * @param String functionalCurrency
	 * @return String
	 * @exception DAOException
	*/
	public String searchInvoiceInterfaceFunctionalAmtCalculateCheck(String invAmt, String invXchRt, String functionalCurrency) throws DAOException {
		
		DBRowSet dbRowset = null;
		String functionalAmount = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("inv_amt", invAmt);	
			param.put("inv_xch_rt", invXchRt);	
			param.put("functional_currency", functionalCurrency);	
			velParam.put("inv_amt", invAmt);
			velParam.put("inv_xch_rt", invXchRt);
			velParam.put("functional_currency", functionalCurrency);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceFunctionalAmtCalculateCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				functionalAmount = dbRowset.getString("functional_amount");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return functionalAmount;
	} 
	

	/**
	 * [STM_SAP_0250]
	 * searchInvoiceInterfaceVendorBankAccountInfoCheck<br> 
	 * @author sangyoung cha
	 * @param String invCurrCd
	 * @param String vndrNo
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	public SapCommonVO searchInvoiceInterfaceVendorBankAccountInfoCheck(String invCurrCd, String vndrNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		SapCommonVO sapCommonVO = new SapCommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("inv_curr_cd", invCurrCd);
			param.put("vndr_no", vndrNo);
			velParam.put("inv_curr_cd", invCurrCd);		
			velParam.put("vndr_no", vndrNo);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceVendorBankAccountInfoCheckRSQL(), param, velParam);
			if(dbRowset.next()) {				
				sapCommonVO.setValue0(dbRowset.getString("vndr_bank_acct_prio_cd"));
				sapCommonVO.setValue1(dbRowset.getString("vndr_bank_acct_seq"));		
				sapCommonVO.setValue2(dbRowset.getString("vndr_bank_acct_vndr_no"));	
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sapCommonVO;
	}	
	
	/**
	 * [STM_SAP_0250]
	 * SAP_INV_HDR 테이블에 저장 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0250
	 * @category addInvoiceInterfaceHeaderInfo
	 * @param SapInvoiceInterfaceHeaderVO headerVo
	 * @exception DAOException
	 */
	public void addInvoiceInterfaceHeaderInfo(SapInvoiceInterfaceHeaderVO headerVo) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			param.put("inv_seq", headerVo.getInvSeq());		
			param.put("vndr_no", headerVo.getVndrNo());			
			param.put("inv_no", headerVo.getInvNo());	
			param.put("inv_curr_cd", headerVo.getInvCurrCd());
			param.put("inv_pay_curr_cd", headerVo.getInvPayCurrCd());
			param.put("inv_amt", headerVo.getInvAmt());
			param.put("inv_dt", headerVo.getInvDt());
			param.put("if_src_nm", headerVo.getIfSrcNm());
			param.put("inv_tp_lu_cd", headerVo.getInvTpLuCd());
			param.put("inv_desc", headerVo.getInvDesc());
			param.put("if_request_seq", headerVo.getInvIfSeq());
			param.put("inv_vat_amt", headerVo.getInvVatAmt());
			param.put("inv_term_nm", headerVo.getInvTermNm());
			param.put("inv_term_dt", headerVo.getInvTermDt());
			param.put("ap_pay_mzd_lu_cd", headerVo.getApPayMzdLuCd());
			param.put("pay_grp_lu_cd", headerVo.getPayGrpLuCd());
			param.put("liab_coa_co_cd", headerVo.getLiabCoaCoCd());
			param.put("liab_coa_rgn_cd", headerVo.getLiabCoaRgnCd());
			param.put("liab_coa_ctr_cd", headerVo.getLiabCoaCtrCd());
			param.put("liab_coa_acct_no", headerVo.getLiabCoaAcctNo());
			param.put("liab_coa_vvd_cd", headerVo.getLiabCoaVvdCd());
			param.put("liab_coa_inter_co_cd", headerVo.getLiabCoaInterCoCd());
			param.put("functional_amount", headerVo.getFunctionalAmount());
			param.put("inv_vat_cd", headerVo.getInvVatCd());
			param.put("inv_xch_rt", headerVo.getInvXchRt());
			param.put("inv_xch_rt_tp_cd", headerVo.getInvXchRtTpCd());
			param.put("inv_xch_dt", headerVo.getInvXchDt());
			param.put("inv_tp_lu_cd", headerVo.getInvTpLuCd());
			param.put("attr_ctnt1", headerVo.getAttrCtnt1());
			param.put("attr_ctnt2", headerVo.getAttrCtnt2());
			param.put("attr_ctnt3", headerVo.getAttrCtnt3());
			param.put("attr_ctnt4", headerVo.getAttrCtnt4());
			param.put("attr_ctnt5", headerVo.getAttrCtnt5());
			param.put("attr_ctnt6", headerVo.getAttrCtnt6());
			param.put("attr_ctnt7", headerVo.getAttrCtnt7());
			param.put("attr_ctnt8", headerVo.getAttrCtnt8());
			param.put("attr_ctnt9", headerVo.getAttrCtnt9());
			param.put("attr_ctnt10", headerVo.getAttrCtnt10());
			param.put("attr_ctnt11", headerVo.getAttrCtnt11());
			param.put("attr_ctnt12", headerVo.getAttrCtnt12());
			param.put("attr_ctnt13", headerVo.getAttrCtnt13());			
			param.put("attr_ctnt14", headerVo.getAttrCtnt14());
			param.put("attr_ctnt15", headerVo.getAttrCtnt15());			
			param.put("l_attribute_category", headerVo.getLAttributeCategory());
			param.put("ofc_cd", headerVo.getOfcCd());
			param.put("glo_attr_cate_nm", headerVo.getGloAttrCateNm());	
			param.put("glo_attr_ctnt1", headerVo.getGloAttrCtnt1());
			param.put("glo_attr_ctnt2", headerVo.getGloAttrCtnt2());	
			param.put("glo_attr_ctnt3", headerVo.getGloAttrCtnt3());
			param.put("glo_attr_ctnt4", headerVo.getGloAttrCtnt4());	
			param.put("glo_attr_ctnt5", headerVo.getGloAttrCtnt5());
			param.put("glo_attr_ctnt6", headerVo.getGloAttrCtnt6());
			param.put("glo_attr_ctnt7", headerVo.getGloAttrCtnt7());	
			param.put("glo_attr_ctnt8", headerVo.getGloAttrCtnt8());
			param.put("glo_attr_ctnt9", headerVo.getGloAttrCtnt9());
			param.put("glo_attr_ctnt10", headerVo.getGloAttrCtnt10());	
			param.put("glo_attr_ctnt11", headerVo.getGloAttrCtnt11());
			param.put("glo_attr_ctnt12", headerVo.getGloAttrCtnt12());	
			param.put("glo_attr_ctnt13", headerVo.getGloAttrCtnt13());
			param.put("glo_attr_ctnt14", headerVo.getGloAttrCtnt14());	
			param.put("glo_attr_ctnt15", headerVo.getGloAttrCtnt15());
			param.put("glo_attr_ctnt16", headerVo.getGloAttrCtnt16());
			param.put("glo_attr_ctnt17", headerVo.getGloAttrCtnt17());	
			param.put("glo_attr_ctnt18", headerVo.getGloAttrCtnt18());
			param.put("glo_attr_ctnt19", headerVo.getGloAttrCtnt19());
			param.put("glo_attr_ctnt20", headerVo.getGloAttrCtnt20());	
			param.put("gl_dt", headerVo.getGlDt());	
			param.put("vndr_bank_acct_seq", headerVo.getVndrBankAcctSeq());	
			param.put("usr_id", headerVo.getUsrId());	
			param.put("liab_cd_cmb_seq", headerVo.getLiabCdCmbSeq());			
			param.put("creation_user", headerVo.getCreationUser());				
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOAddInvoiceInterfaceHeaderInfoCSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * [STM_SAP_0250]
	 * SAP_PAY_SKD 테이블에 저장 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0250
	 * @category addInvoiceInterfacePayScheduleInfo
	 * @param SapInvoiceInterfaceHeaderVO headerVo
	 * @exception DAOException
	 */
	public void addInvoiceInterfacePayScheduleInfo(SapInvoiceInterfaceHeaderVO headerVo) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			param.put("inv_seq", headerVo.getInvSeq());		
			param.put("inv_amt", headerVo.getInvAmt());			
			param.put("inv_term_dt", headerVo.getInvTermDt());
			param.put("inv_term_nm", headerVo.getInvTermNm());
			param.put("inv_amt", headerVo.getInvAmt());
			param.put("ap_pay_mzd_lu_cd", headerVo.getApPayMzdLuCd());
			param.put("vndr_bank_acct_prio_cd", headerVo.getVndrBankAcctPrioCd());			
			param.put("vndr_bank_acct_seq", headerVo.getVndrBankAcctSeq());
			param.put("vndr_bank_acct_vndr_no", headerVo.getVndrBankAcctVndrNo());
			param.put("usr_id", headerVo.getUsrId());	
			param.put("creation_user", headerVo.getCreationUser());		
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOAddInvoiceInterfacePayScheduleInfoCSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}	

	/**
	 * [STM_SAP_0250]
	 * SAP_INV_DTL 테이블에 저장<br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0250
	 * @category addInvoiceInterfaceLineInfo
	 * @param List<SapInvoiceInterfaceDetailVO> lineVo
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addInvoiceInterfaceLineInfo(List<SapInvoiceInterfaceDetailVO> lineVo) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (lineVo.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInvoiceInterfaceLineInfoCSQL(), lineVo, null);
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
	 * [STM_SAP_0250]
	 * SAP_INV_DTL 테이블에 저장(선급금 No을 갖고 있는 경우 해당 선급금 정보로 정산 처리) <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0250
	 * @category addInvoiceInterfacePrepayApplyLineInfo
	 * @param SapInvoiceInterfaceHeaderVO headerVo
	 * @exception DAOException
	 */
	public void addInvoiceInterfacePrepayApplyLineInfo(SapInvoiceInterfaceHeaderVO headerVo) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			param.put("ppay_aply_gl_dt", headerVo.getPpayAplyGlDt());		
			param.put("inv_seq", headerVo.getInvSeq());			
			param.put("ppay_aply_amt", headerVo.getPpayAplyAmt());
			param.put("functional_currency", headerVo.getFunctionalCurrency());
			param.put("inv_xch_dt", headerVo.getInvXchDt());
			param.put("inv_xch_rt", headerVo.getInvXchRt());
			param.put("inv_xch_rt_tp_cd", headerVo.getInvXchRtTpCd());			
			param.put("usr_id", headerVo.getUsrId());
			param.put("ppay_inv_no", headerVo.getPpayInvNo());	
			param.put("ppay_inv_line_no", headerVo.getPpayInvLineNo());
			param.put("creation_user", headerVo.getCreationUser());		
								
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOAddInvoiceInterfacePrepayApplyLineInfoCSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}	
	
   	/**
   	 * [STM_SAP_0250]
   	 * modifyInvoiceInterfacePrepayApplyPayInvInfo<br>
   	 * @author sangyoung cha
   	 * @category STM_SAP_0250
   	 * @param  SapInvoiceInterfaceHeaderVO headerVo
   	 * @exception DAOException
   	*/
   	@SuppressWarnings("unchecked")
   	public void modifyInvoiceInterfacePrepayApplyPayInvInfo(SapInvoiceInterfaceHeaderVO headerVo) throws DAOException {
   		//query parameter
   		Map<String, Object> param = new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam = new HashMap<String, Object>();
   		
   		int successFlag = 0;

   		try{
   				
   			param.put("ppay_aply_amt", headerVo.getPpayAplyAmt());	
   			param.put("usr_id", headerVo.getUsrId());
   			param.put("inv_seq", headerVo.getInvSeq());		
   			
   			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceInterfacePrepayApplyPayInvInfoUSQL(), param, velParam);
   			if(successFlag == Statement.EXECUTE_FAILED)
   				 throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
   			
   		} catch (SQLException se) {
   			log.error(se.getMessage(), se);
   			throw new DAOException(new ErrorHandler(se).getMessage());
   		} catch(Exception ex) {
   			log.error(ex.getMessage(), ex);
   			throw new DAOException(new ErrorHandler(ex).getMessage());
   		}
   	}
   	
   	/**
   	 * [STM_SAP_0250]
   	 * modifyInvoiceInterfaceVatCodeAllocateInvInfo<br>
   	 * @author KSJO
   	 * @category STM_SAP_0250
   	 * @param  SapInvoiceInterfaceHeaderVO headerVo
   	 * @exception DAOException
   	*/
   	@SuppressWarnings("unchecked")
   	public void modifyInvoiceInterfaceVatCodeAllocateInvInfo(SapInvoiceInterfaceHeaderVO headerVo) throws DAOException {
   		//query parameter
   		Map<String, Object> param = new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam = new HashMap<String, Object>();
   		
   		int successFlag = 0;

   		try{

   			param.put("inv_seq", headerVo.getInvSeq());		
   			
   			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceInterfaceVatCodeAllocateInvInfoUSQL(), param, velParam);
   			if(successFlag == Statement.EXECUTE_FAILED)
   				 throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
   			
   		} catch (SQLException se) {
   			log.error(se.getMessage(), se);
   			throw new DAOException(new ErrorHandler(se).getMessage());
   		} catch(Exception ex) {
   			log.error(ex.getMessage(), ex);
   			throw new DAOException(new ErrorHandler(ex).getMessage());
   		}
   	}
   			
   	/**
   	 * [STM_SAP_0250]
   	 * modifyInvoiceInterfacePrepayApplyPayScheduleInfo<br>
   	 * @author sangyoung cha
   	 * @category STM_SAP_0250
   	 * @param  SapInvoiceInterfaceHeaderVO headerVo
   	 * @exception DAOException
   	*/
   	@SuppressWarnings("unchecked")
   	public void modifyInvoiceInterfacePrepayApplyPayScheduleInfo(SapInvoiceInterfaceHeaderVO headerVo) throws DAOException {
   		//query parameter
   		Map<String, Object> param = new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam = new HashMap<String, Object>();
   		
   		int successFlag = 0;

   		try{
   				
   			param.put("ppay_aply_amt", headerVo.getPpayAplyAmt());	
   			param.put("usr_id", headerVo.getUsrId());
   			param.put("inv_seq", headerVo.getInvSeq());		
   			
   			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceInterfacePrepayApplyPayScheduleInfoUSQL(), param, velParam);
   			if(successFlag == Statement.EXECUTE_FAILED)
   				 throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
   			
   		} catch (SQLException se) {
   			log.error(se.getMessage(), se);
   			throw new DAOException(new ErrorHandler(se).getMessage());
   		} catch(Exception ex) {
   			log.error(ex.getMessage(), ex);
   			throw new DAOException(new ErrorHandler(ex).getMessage());
   		}
   	}
   	
   	/**
   	 * [STM_SAP_0250]
   	 * modifyInvoiceInterfacePrepayApplyPayPrepaymentInfo<br>
   	 * @author sangyoung cha
   	 * @category STM_SAP_0250
   	 * @param  SapInvoiceInterfaceHeaderVO headerVo
   	 * @exception DAOException
   	*/
   	@SuppressWarnings("unchecked")
   	public void modifyInvoiceInterfacePrepayApplyPayPrepaymentInfo(SapInvoiceInterfaceHeaderVO headerVo) throws DAOException {
   		//query parameter
   		Map<String, Object> param = new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam = new HashMap<String, Object>();
   		
   		int successFlag = 0;

   		try{
   				
   			param.put("ppay_aply_amt", headerVo.getPpayAplyAmt());	
   			param.put("usr_id", headerVo.getUsrId());
   			param.put("ppay_inv_no", headerVo.getPpayInvNo());		
   			param.put("ppay_inv_line_no", headerVo.getPpayInvLineNo());
   			
   			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInvoiceInterfacePrepayApplyPayPrepaymentInfoUSQL(), param, velParam);
   			if(successFlag == Statement.EXECUTE_FAILED)
   				 throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
   			
   		} catch (SQLException se) {
   			log.error(se.getMessage(), se);
   			throw new DAOException(new ErrorHandler(se).getMessage());
   		} catch(Exception ex) {
   			log.error(ex.getMessage(), ex);
   			throw new DAOException(new ErrorHandler(ex).getMessage());
   		}
   	}
   	
	/**
	 * [STM_SAP_0250]
	 * AP 성공 메세지 저장 <br>
	 * 
	 * @author sangyoung cha
	 * @category STM_SAP_0250
	 * @category modifyAPInvoiceInterfaceSucess
	 * @param String csrNo
	 * @exception DAOException
	 */
	public void modifyAPInvoiceInterfaceSucess(String csrNo) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			param.put("csr_no", csrNo);					
			velParam.put("csr_no", csrNo);						
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableInvoiceDBDAOModifyAPInvoiceInterfaceSucessUSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	
	/**
	 * [SAKURA I/F]
	 * searchInvoiceInterfaceSAPTypeCheck <br>
	 * 
	 * @author ORKIM
	 * @category searchLineVendorInvoiceNoDupCheck
	 * @param String csr_no
	 * @param String usr_id
	 * @return InvoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/
	 
	public InvoiceInterfaceSAPTypeCheckVO searchInvoiceInterfaceSAPTypeCheck(String csr_no, String usr_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceInterfaceSAPTypeCheckVO> list = null;
		InvoiceInterfaceSAPTypeCheckVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("csr_no", csr_no);					
			velParam.put("csr_no", csr_no);		
			param.put("usr_id", usr_id);					
			velParam.put("usr_id", usr_id);				

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceSAPTypeCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceInterfaceSAPTypeCheckVO.class); 
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
	 * [SAKURA I/F]
	 * searchInvoiceInterfaceSAPDaySeqCheck <br>
	 * 
	 * @author ORKIM
	 * @category searchInvoiceInterfaceSAPDaySeqCheck
	 * @return String SLIP_INTERFACE_SEQ
	 * @exception DAOException
	*/ 
	public String searchInvoiceInterfaceSAPDaySeqCheck() throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceInterfaceSAPDaySeqCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("SLIP_INTERFACE_SEQ");
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
	 * [SAKURA I/F]
	 * searchUpstreamInvoiceAccountedRoundCheck <br>
	 * 
	 * @author KSJO
	 * @category searchUpstreamInvoiceAccountedRoundCheck
	 * @param String csr_no
	 * @return String PREPAY_ROUND_AMT
	 * @exception DAOException
	*/ 
	public String searchUpstreamInvoiceAccountedRoundCheck(String csr_no) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("csr_no", csr_no);					
			velParam.put("csr_no", csr_no);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchUpstreamInvoiceAccountedRoundCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("PREPAY_ROUND_AMT");
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
	 * [SAKURA I/F] - 01 
	 * addInterfaceSAPStandardNonJPDetailInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardNonJPDetailInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardNonJPDetailInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPDetailInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardNonJPDetailOverseasTAXInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardNonJPDetailOverseasTAXInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardNonJPDetailOverseasTAXInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPDetailOverseasTAXInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPStandardNonJPDetailPrepayInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardNonJPDetailPrepayInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardNonJPDetailPrepayInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPDetailPrepayInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPStandardNonJPDetailOTSPrepayInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardNonJPDetailOTSPrepayInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardNonJPDetailOTSPrepayInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPDetailOTSPrepayInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPStandardNonJPDetailPrepayGainLossInfo <br>
	 * 
	 * @author KyungsamJO
	 * @category addInterfaceSAPStandardNonJPDetailPrepayGainLossInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardNonJPDetailPrepayGainLossInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPDetailPrepayGainLossInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPStandardNonJPHeaderPrepayGainLossInfo <br>
	 * 
	 * @author KyungsamJO
	 * @category addInterfaceSAPStandardNonJPHeaderPrepayGainLossInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardNonJPHeaderPrepayGainLossInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPHeaderPrepayGainLossInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPUpstreamStandardNonJPPrepayGainLossInfo <br>
	 * 
	 * @author KyungsamJO
	 * @category addInterfaceSAPUpstreamStandardNonJPPrepayGainLossInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPUpstreamStandardNonJPPrepayGainLossInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPUpstreamStandardNonJPPrepayGainLossInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPUpstreamStandardJPPrepayGainLossInfo <br>
	 * 
	 * @author KyungsamJO
	 * @category addInterfaceSAPUpstreamStandardJPPrepayGainLossInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPUpstreamStandardJPPrepayGainLossInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPUpstreamStandardJPPrepayGainLossInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPStandardNonJPDetailPrepayRoundInfo <br>
	 * 
	 * @author KyungsamJO
	 * @category addInterfaceSAPStandardNonJPDetailPrepayRoundInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardNonJPDetailPrepayRoundInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPDetailPrepayRoundInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPStandardNonJPHeaderPrepayInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardNonJPHeaderPrepayInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardNonJPHeaderPrepayInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPHeaderPrepayInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * modifyInterfaceSAPStandardNonJPDRCRDiffInfo <br>
	 * 
	 * @author KSJO
	 * @category modifyInterfaceSAPStandardNonJPDRCRDiffInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void modifyInterfaceSAPStandardNonJPDRCRDiffInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInterfaceSAPStandardNonJPDRCRDiffInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * modifyInterfaceSAPUpstreamStandardPartialApplyInfo <br>
	 * 
	 * @author KSJO
	 * @category modifyInterfaceSAPUpstreamStandardPartialApplyInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void modifyInterfaceSAPUpstreamStandardPartialApplyInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInterfaceSAPUpstreamStandardPartialApplyInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardNonJPHeaderTaxInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardNonJPHeaderTaxInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardNonJPHeaderTaxInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPHeaderTaxInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardNonJPHeaderOtherInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardNonJPHeaderOtherInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardNonJPHeaderOtherInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardNonJPHeaderOtherInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPUpstreamStandardNonJPHeaderFullInfo <br>
	 * 
	 * @author KSJO
	 * @category addInterfaceSAPUpstreamStandardNonJPHeaderFullInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPUpstreamStandardNonJPHeaderFullInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPUpstreamStandardNonJPHeaderFullInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPUpstreamStandardNonJPHeaderPartialInfo <br>
	 * 
	 * @author KSJO
	 * @category addInterfaceSAPUpstreamStandardNonJPHeaderPartialInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPUpstreamStandardNonJPHeaderPartialInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPUpstreamStandardNonJPHeaderPartialInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPUpstreamStandardJPHeaderPartialInfo <br>
	 * 
	 * @author KSJO
	 * @category addInterfaceSAPUpstreamStandardJPHeaderPartialInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPUpstreamStandardJPHeaderPartialInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPUpstreamStandardJPHeaderPartialInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardJPDetailInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardJPDetailInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardJPDetailInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPDetailInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardJPHeaderPrepayInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardJPHeaderPrepayInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardJPHeaderPrepayInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPHeaderPrepayInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardJPHeaderTaxInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardJPHeaderTaxInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardJPHeaderTaxInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPHeaderTaxInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPStandardJPHeaderOtherInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardJPHeaderOtherInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardJPHeaderOtherInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPHeaderOtherInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPUpstreamStandardJPHeaderFullInfo <br>
	 * 
	 * @author KSJO
	 * @category addInterfaceSAPUpstreamStandardJPHeaderFullInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPUpstreamStandardJPHeaderFullInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPUpstreamStandardJPHeaderFullInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPCreditNonJPDetailInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPCreditNonJPDetailInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPCreditNonJPDetailInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPCreditNonJPDetailInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPCreditNonJPHeaderTaxInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPCreditNonJPHeaderTaxInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPCreditNonJPHeaderTaxInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPCreditNonJPHeaderTaxInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPCreditNonJPHeaderOtherInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPCreditNonJPHeaderOtherInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPCreditNonJPHeaderOtherInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPCreditNonJPHeaderOtherInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPCreditJPDetailInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPCreditJPDetailInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPCreditJPDetailInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPCreditJPDetailInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPCreditJPHeaderTaxInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPCreditJPHeaderTaxInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPCreditJPHeaderTaxInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPCreditJPHeaderTaxInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPCreditJPHeaderOtherInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPCreditJPHeaderOtherInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPCreditJPHeaderOtherInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPCreditJPHeaderOtherInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPPrepaymentNonJPDetailInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPPrepaymentNonJPDetailInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPPrepaymentNonJPDetailInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPPrepaymentNonJPDetailInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPPrepaymentNonJPHeaderInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPPrepaymentNonJPHeaderInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPPrepaymentNonJPHeaderInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPPrepaymentNonJPHeaderInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPPrepaymentJPDetailInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPPrepaymentJPDetailInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPPrepaymentJPDetailInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPPrepaymentJPDetailInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] - 02 
	 * addInterfaceSAPPrepaymentJPHeaderInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPPrepaymentJPHeaderInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPPrepaymentJPHeaderInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPPrepaymentJPHeaderInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPStandardASADetailInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardASADetailInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardASADetailInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardASADetailInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F]
	 * addInterfaceSAPStandardASATaxLineInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardASATaxLineInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardASATaxLineInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardASAOverseasTAXInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardASALineInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardASALineInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardASALineInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardASALineInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardASAGainLossInfo <br>
	 * 
	 * @author KSJO
	 * @category addInterfaceSAPStandardASAGainLossInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardASAGainLossInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardASAGainLossInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardJPDetailPrepayInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardJPDetailPrepayInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardJPDetailPrepayInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPDetailPrepayInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardJPDetailOTSPrepayInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPStandardJPDetailOTSPrepayInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardJPDetailOTSPrepayInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPDetailOTSPrepayInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardJPDetailPrepayGainLossInfo <br>
	 * 
	 * @author KyungsamJO
	 * @category addInterfaceSAPStandardJPDetailPrepayGainLossInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardJPDetailPrepayGainLossInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPDetailPrepayGainLossInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardJPHeaderPrepayGainLossInfo <br>
	 * 
	 * @author KyungsamJO
	 * @category addInterfaceSAPStandardJPHeaderPrepayGainLossInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardJPHeaderPrepayGainLossInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPHeaderPrepayGainLossInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPStandardJPDetailPrepayRoundInfo <br>
	 * 
	 * @author KyungsamJO
	 * @category addInterfaceSAPStandardJPDetailPrepayRoundInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPStandardJPDetailPrepayRoundInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPStandardJPDetailPrepayRoundInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * [SAKURA I/F] 
	 * addInterfaceSAPCreditNonJPDetailOverseasTAXInfo <br>
	 * 
	 * @author ORKIM
	 * @category addInterfaceSAPCreditNonJPDetailOverseasTAXInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void addInterfaceSAPCreditNonJPDetailOverseasTAXInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOAddInterfaceSAPCreditNonJPDetailOverseasTAXInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * [SAKURA I/F]
	 * modifyInterfaceSAPLocalAmtZeroNotInterfaceInfo <br>
	 * 
	 * @author KSJO
	 * @category modifyInterfaceSAPLocalAmtZeroNotInterfaceInfo
	 * @param InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO
	 * @exception DAOException
	*/ 
	public void modifyInterfaceSAPLocalAmtZeroNotInterfaceInfo(InvoiceInterfaceSAPTypeCheckVO invoiceInterfaceSAPTypeCheckVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = invoiceInterfaceSAPTypeCheckVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyInterfaceSAPLocalAmtZeroNotInterfaceInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [STM_SAP_0010]
	 * 정산전표인지 체크 FOR SAKURA I/F <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchInvoiceLinePrepayCheck
	 * @param  String inv_seq
	 * @return String
	 * @exception DAOException
	 */	 
	public String searchInvoiceLinePrepayCheck(String inv_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("inv_seq", inv_seq);	
			velParam.put("inv_seq", inv_seq);	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceLinePrepayCheckRSQL(), param, velParam);
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
	 * [STM_SAP_0010]
	 * CSR_NO 를 구한다. <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchInvoiceCSRNoBySeq
	 * @param  String inv_seq
	 * @return String
	 * @exception DAOException
	 */	 
	public String searchInvoiceCSRNoBySeq(String inv_seq) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("inv_seq", inv_seq);	
			velParam.put("inv_seq", inv_seq);	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceCSRNoBySeqRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("CSR_NO");
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
	 * [STM_SAP_0150]
	 * SearchInvoiceAccrualList <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0150
	 * @category SearchInvoiceAccrualList
	 * @param InvoiceAccrualCondVO invoiceAccrualCondVO
	 * @return List<InvoiceAccrualVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvoiceAccrualVO> searchInvoiceAccrualList(InvoiceAccrualCondVO invoiceAccrualCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceAccrualVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (invoiceAccrualCondVO != null) {
				Map<String, String> mapVO= invoiceAccrualCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchInvoiceAccrualListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceAccrualVO.class);
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
	 * [STM_SAP_0150]
	 * SAP_INV_HDR Accural I/F Flag<br>
	 * 
	 * @author KSJO
	 * @category STM_SAP_0150
	 * @category modifyAPManualInvoiceAccrualFlag
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyAPManualInvoiceAccrualFlag(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws DAOException {
	 	//query parameter
   		Map<String, Object> param = new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam = new HashMap<String, Object>();
   		
   		int successFlag = 0;
	   		
		try {
			
			param.put("inv_seq", aPManualInvoiceAccuralCondVO.getInvSeq());
			param.put("usr_id", aPManualInvoiceAccuralCondVO.getUsrId());
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyAPManualInvoiceAccrualFlagUSQL(), param, velParam);
   			if(successFlag == Statement.EXECUTE_FAILED)
   				 throw new DAOException((new ErrorHandler("PRD00065")).getMessage());

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 /**
	 * [STM_SAP_0150]
	 * SAP_INV_HDR Accural I/F Cancel Flag<br>
	 * 
	 * @author KSJO
	 * @category STM_SAP_0150
	 * @category modifyAPManualInvoiceAccrualCancelFlag
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyAPManualInvoiceAccrualCancelFlag(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws DAOException {
	 	//query parameter
   		Map<String, Object> param = new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam = new HashMap<String, Object>();
   		
   		int successFlag = 0;
	   		
		try {
			
			param.put("inv_seq", aPManualInvoiceAccuralCondVO.getInvSeq());
			param.put("usr_id", aPManualInvoiceAccuralCondVO.getUsrId());
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate)new AccountPayableInvoiceDBDAOModifyAPManualInvoiceAccrualCancelFlagUSQL(), param, velParam);
   			if(successFlag == Statement.EXECUTE_FAILED)
   				 throw new DAOException((new ErrorHandler("PRD00065")).getMessage());

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 /**
	 * [STM_SAP_0250]
	 * searchSakuraInterfaceCSRInfo 조회 <br>
	 * 
	 * @author ORKIM
	 * @category STM_SAP_0010
	 * @category searchSakuraInterfaceCSRInfo
	 * @param String invfromdt
	 * @param String invtodt
	 * @return List<SapCommonVO>
	 * @exception DAOException
	*/
	 
	public List<SapCommonVO> searchSakuraInterfaceCSRInfo(String invfromdt, String invtodt) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (invfromdt != null) {
				param.put("invfromdt", invfromdt);	
				velParam.put("invfromdt", invfromdt);	
			}
			if (invtodt != null) {
				param.put("invtodt", invtodt);	
				velParam.put("invtodt", invtodt);	
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchSakuraInterfaceCSRInfoRSQL(), param, velParam);
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
		return list;
	}
	
	/**
	 * Asa Clearing 체크<br>
	 * 
	 * @author ORKIM
	 * @category searchAsaClearingPreCheck
	 * @param String inv_no
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchAsaClearingPreCheck(String inv_no) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (inv_no != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("inv_no", inv_no);
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchAsaClearingPreCheckRSQL(), param, velParam);
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
	 * Asa No Open 여부  조회 by CSR No <br>
	 * 
	 * @author KSJO
	 * @category searchAsaNoStatusCheckbyCSRNo
	 * @param String inv_no
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchAsaNoStatusCheckbyCSRNo(String inv_no) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (inv_no != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("inv_no", inv_no);
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchAsaNoStatusCheckbyCSRNoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("ASA_STATUS");
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
	 * Asa Clearing 대상 조회<br>
	 * 
	 * @author ORKIM
	 * @category searchAsaClearingList
	 * @param String inv_no
	 * @return List<AsaClearingVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AsaClearingVO> searchAsaClearingList(String inv_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<AsaClearingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (inv_no != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("inv_no", inv_no);
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchAsaClearingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AsaClearingVO.class);
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
	 * [STM_SAR_5002]
	 * searchASAInvoice Inteface 여부 조회<br> 
	 * 
	 * @category searchASAInvoiceUnInterfaceCheck
	 * @author KSJO
	 * @param String asa_no
	 * @return String
	 * @exception DAOException
	*/
	public String searchASAInvoiceUnInterfaceCheck(String asa_no) throws DAOException {
		
		DBRowSet dbRowset = null;
		String uninterfaceCount = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("asa_no", asa_no);		
			velParam.put("asa_no", asa_no);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableInvoiceDBDAOSearchASAInvoiceUnInterfaceCheckRSQL(), param, velParam);
			if(dbRowset.next()) {								
				uninterfaceCount = dbRowset.getString("UNINTERFACE_ASA");
			}     
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return uninterfaceCount;
	} 	
	 
}