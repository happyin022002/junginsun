/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableReceiptDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.basic.AccountReceivableReceiptBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.APCombinationSeqCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.APInterfaceStatusVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyHeaderVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyListCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.BankAcctCmbSeqVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.LedgerCmbCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.OTSDistributionVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.RCTViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.RctHdrSeqTmpVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.RcvApplSeqTmpVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptAccountCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptAccountVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptDistributionVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptForAPInterfaceVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankConditionVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankDateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByChequeCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByChequeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByDetailCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptMainVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptUserListConditionVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptUserListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceivableApplVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.UnapplyReceiptCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.UnapplyReceiptListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingChgVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHistVO;
import com.clt.bizcommon.comm.Constants;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * AccountReceivableReceiptDBDAO <br>
 * - AccountReceivableReceipt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see AccountReceivableReceiptBCImpl 참조
 * @since J2EE 1.4
 */
public class AccountReceivableReceiptDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String dataSource = "";
	/**
	 * AccountReceivableReceiptDBDAO object creation<br>
	 * AccountReceivableReceiptDBDAO creation<br>
	 */
	public AccountReceivableReceiptDBDAO() { }
	
	/**
	 * AccountReceivableReceiptDBDAO object creation<br>
	 * AccountReceivableReceiptDBDAO creation<br>
	 * @param String dataSource
	 */
	public AccountReceivableReceiptDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * searchReceiptUserList<br>
	 * 
	 * @param ReceiptUserListConditionVO receiptUserListConditionVO
	 * @return List<ReceiptUserListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReceiptUserListVO> searchReceiptUserList(ReceiptUserListConditionVO receiptUserListConditionVO) throws DAOException {
	     DBRowSet dbRowset = null;
	     
	     List<ReceiptUserListVO> list = null;
	     
	     //query parameter
	     Map<String, Object> param = new HashMap<String, Object>();
	     
	     //velocity parameter
	     Map<String, Object> velParam = new HashMap<String, Object>();
	
	     try {	
	     	
	     	 if(receiptUserListConditionVO != null){  ///??????????????????????????????????
	     		 Map<String, String> mapVO = receiptUserListConditionVO.getColumnValues();
	     	 
	     		 param.putAll(mapVO);        	
	     		 velParam.putAll(mapVO);
	 		 }
	          
	          dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchReceiptUserListRSQL(), param, velParam);
	          list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceiptUserListVO.class);             
	     }catch(SQLException se){
	         log.error(se.getMessage(),se);
	         throw new DAOException(new ErrorHandler(se).getMessage());
	     }catch(Exception ex){
	         log.error(ex.getMessage(),ex);
	         throw new DAOException(new ErrorHandler(ex).getMessage());
	     }
	     
	     return list;
	}   
	
	/**
	 * Search OTS Header for Apply<br>
	 * 
	 * @param ApplyListCondVO applyListCondVO
	 * @return List<ApplyHeaderVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ApplyHeaderVO> searchOTSHeaderForApply(ApplyListCondVO applyListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApplyHeaderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = applyListCondVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchOTSHeaderForApplyRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApplyHeaderVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	
	/**
	 * Search OTS Charge for Apply<br>
	 * 
	 * @param ApplyListCondVO applyListCondVO
	 * @return List<ApplyDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ApplyDetailVO> searchOTSChargeForApply(ApplyListCondVO applyListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApplyDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = applyListCondVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchOTSChargeForApplyRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApplyDetailVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	
	/**
	 * Search Unapply Receipt List<br>
	 * 
	 * @param UnapplyReceiptCondVO unapplyReceiptCondVO
	 * @return List<UnapplyReceiptListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UnapplyReceiptListVO> searchUnapplyReceiptList(UnapplyReceiptCondVO unapplyReceiptCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<UnapplyReceiptListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = unapplyReceiptCondVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchUnapplyReceiptListRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnapplyReceiptListVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	
	/**
	 * Search Receipt Main<br>
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return ReceiptMainVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ReceiptMainVO searchReceiptMain(String rctOfcCd, String rctNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReceiptMainVO> list = null;
		ReceiptMainVO receiptMainVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_ofc_cd", rctOfcCd);
			mapVO.put("rct_no", rctNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchReceiptMainRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceiptMainVO .class);
		
			if (list != null && list.size() > 0) {
				receiptMainVO = (ReceiptMainVO) list.get(0);
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return receiptMainVO;
	}		
	
	/**
	 * Search Apply Header<br>
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return List<ApplyHeaderVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ApplyHeaderVO> searchApplyHeader(String rctOfcCd, String rctNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApplyHeaderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_ofc_cd", rctOfcCd);
			mapVO.put("rct_no", rctNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchApplyHeaderRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApplyHeaderVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	
	/**
	 * Search Apply Detail<br>
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return List<ApplyDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ApplyDetailVO> searchApplyDetail(String rctOfcCd, String rctNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApplyDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_ofc_cd", rctOfcCd);
			mapVO.put("rct_no", rctNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchApplyDetailRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApplyDetailVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	
	/**
	 * Insert into SAR_RECEIPT<br>
	 * @param ReceiptMainVO receiptMainVO
	 * @exception DAOException
	 */	 
	public void addReceiptMain (ReceiptMainVO receiptMainVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = receiptMainVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableReceiptDBDAOaddReceiptMainCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Insert into SAR_RCT_APLY_HDR<br>
	 * @param List<ApplyHeaderVO> applyHeaderVOs
	 * @exception DAOException
	 */	 
	 
	public void addApplyHeader (List<ApplyHeaderVO> applyHeaderVOs) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(applyHeaderVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableReceiptDBDAOaddApplyHeaderCSQL(), applyHeaderVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Update SAR_RCT_APLY_HDR<br>
	 * @param List<ApplyHeaderVO> applyHeaderVOs
	 * @exception DAOException
	 */	 
	 
	public void modifyApplyHeaderAmount (List<ApplyHeaderVO> applyHeaderVOs) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(applyHeaderVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableReceiptDBDAOmodifyApplyHeaderAmountUSQL(), applyHeaderVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Insert into SAR_RCT_APLY_DTL<br>
	 * @param List<ApplyDetailVO> applyDetailVOs
	 * @exception DAOException
	 */	 
	 
	public void addApplyDetail (List<ApplyDetailVO> applyDetailVOs) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(applyDetailVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableReceiptDBDAOaddApplyDetailCSQL(), applyDetailVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Update SAR_RECEIPT<br>
	 * @param ReceiptMainVO receiptMainVO
	 * @exception DAOException
	 */	 
	public void modifyReceiptMain (ReceiptMainVO receiptMainVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = receiptMainVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableReceiptDBDAOmodifyReceiptMainUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Search Receipt Sequence<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchReceiptSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String rctSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchReceiptSeqRSQL(), param, velParam);											
		
			if(dbRowset.next()){
				rctSeq = dbRowset.getString("rct_seq");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rctSeq;
	}		
	
	/**
	 * Search Apply Header Sequence<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchHeaderSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String hdrSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchHeaderSeqRSQL(), param, velParam);											
		
			if(dbRowset.next()){
				hdrSeq = dbRowset.getString("hdr_seq");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return hdrSeq;
	}	
	
	/**
	 * Search Apply Detail Sequence<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchDetailSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String dtlSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchDetailSeqRSQL(), param, velParam);											
		
			if(dbRowset.next()){
				dtlSeq = dbRowset.getString("dtl_seq");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return dtlSeq;
	}	
	
	/**
	 * Update SAR_RCT_APLY_HDR<br>
	 * @param List<ApplyHeaderVO> applyHeaderVOs
	 * @exception DAOException
	 */	 
	 
	public void modifyReverseApplyHeader (List<ApplyHeaderVO> applyHeaderVOs) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(applyHeaderVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableReceiptDBDAOmodifyReverseApplyHeaderUSQL(), applyHeaderVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Update SAR_RECEIPT<br>
	 * @param ReceiptMainVO receiptMainVO
	 * @exception DAOException
	 */	 
	public void modifyReceiptCancelInfo (ReceiptMainVO receiptMainVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = receiptMainVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableReceiptDBDAOmodifyReceiptCancelInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * searchReceiptListByBankDate <br>
	 * 
	 * @param ReceiptListByBankConditionVO receiptListByBankConditionVO
	 * @return List<ReceiptListByBankDateVO>
	 * @exception DAOException
	 */
	public List<ReceiptListByBankDateVO> searchReceiptListByBankDate(ReceiptListByBankConditionVO receiptListByBankConditionVO) throws DAOException {
	     DBRowSet dbRowset = null;
	     
	     List<ReceiptListByBankDateVO> list = null;
	     
	     //query parameter
	     Map<String, Object> param = new HashMap<String, Object>();
	     
	     //velocity parameter
	     Map<String, Object> velParam = new HashMap<String, Object>();
	
	     try {	
	     	
	     	 if(receiptListByBankConditionVO != null){  
	     		 Map<String, String> mapVO = receiptListByBankConditionVO.getColumnValues();
	     	 
	     		 param.putAll(mapVO);        	
	     		 velParam.putAll(mapVO);
	 		 }
	          
	          dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchReceiptListByBankDateRSQL(), param, velParam);
	          list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceiptListByBankDateVO.class);             
	     }catch(SQLException se){
	         log.error(se.getMessage(),se);
	         throw new DAOException(new ErrorHandler(se).getMessage());
	     }catch(Exception ex){
	         log.error(ex.getMessage(),ex);
	         throw new DAOException(new ErrorHandler(ex).getMessage());
	     }
	     
	     return list;
	}   	

	/**
	 * searchReceiptListByBank <br>
	 * 
	 * @param ReceiptListByBankConditionVO receiptListByBankConditionVO
	 * @return List<ReceiptListByBankVO>
	 * @exception DAOException
	 */
	public List<ReceiptListByBankVO> searchReceiptListByBank(ReceiptListByBankConditionVO receiptListByBankConditionVO) throws DAOException {
	     DBRowSet dbRowset = null;
	     
	     List<ReceiptListByBankVO> list = null;
	     
	     //query parameter
	     Map<String, Object> param = new HashMap<String, Object>();
	     
	     //velocity parameter
	     Map<String, Object> velParam = new HashMap<String, Object>();
	
	     try {	
	     	
	     	 if(receiptListByBankConditionVO != null){  
	     		 Map<String, String> mapVO = receiptListByBankConditionVO.getColumnValues();
	     	 
	     		 param.putAll(mapVO);        	
	     		 velParam.putAll(mapVO);
	 		 }
	          
	          dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchReceiptListByBankRSQL(), param, velParam);
	          list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceiptListByBankVO.class);             
	     }catch(SQLException se){
	         log.error(se.getMessage(),se);
	         throw new DAOException(new ErrorHandler(se).getMessage());
	     }catch(Exception ex){
	         log.error(ex.getMessage(),ex);
	         throw new DAOException(new ErrorHandler(ex).getMessage());
	     }
	     
	     return list;
	}  	

	/**
	 * searchReceiptListByCheque <br>
	 * @author SHIN
	 * @param ReceiptListByChequeCondVO receiptListByChequeCondVO
	 * @return List<ReceiptListByChequeVO>
	 * @exception DAOException
	 */
	public List<ReceiptListByChequeVO> searchReceiptListByCheque(ReceiptListByChequeCondVO receiptListByChequeCondVO) throws DAOException {
	     DBRowSet dbRowset = null;
	     
	     List<ReceiptListByChequeVO> list = null;
	     
	     //query parameter
	     Map<String, Object> param = new HashMap<String, Object>();
	     
	     //velocity parameter
	     Map<String, Object> velParam = new HashMap<String, Object>();
	
	     try {	
	     	
	     	 if(receiptListByChequeCondVO != null){  
	     		 Map<String, String> mapVO = receiptListByChequeCondVO.getColumnValues();
	     	 
	     		 param.putAll(mapVO);        	
	     		 velParam.putAll(mapVO);
	 		 }
	          
	          dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchReceiptListByChequeRSQL(), param, velParam);
	          list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceiptListByChequeVO.class);             
	     }catch(SQLException se){
	         log.error(se.getMessage(),se);
	         throw new DAOException(new ErrorHandler(se).getMessage());
	     }catch(Exception ex){
	         log.error(ex.getMessage(),ex);
	         throw new DAOException(new ErrorHandler(ex).getMessage());
	     }
	     
	     return list;
	}  		
	
	/**
	 * [STM_SAR_2002]
	 * searchReceiptListByDetail <br>
	 * 
	 * @author yhha
	 * @category STM_SAR_2002
	 * @category searchReceiptListByDetail
	 * @param ReceiptListByDetailCondVO receiptListByDetailCondVO
	 * @return List<ReceiptListByDetailVO>
	 * @throws DAOException
	*/	 
	public List<ReceiptListByDetailVO> searchReceiptListByDetail(ReceiptListByDetailCondVO receiptListByDetailCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<ReceiptListByDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (receiptListByDetailCondVO != null) {
				
				//log.debug(receiptListByDetailCondVO.toString());
				
				// 페이징 처리
				int paseSize    = Integer.parseInt(receiptListByDetailCondVO.getPagerows());
				int currentPage = Integer.parseInt(receiptListByDetailCondVO.getIPage());
				int startPart   = paseSize * (currentPage - 1) + 1;
				int endPart     = paseSize * currentPage;
				param.put("startpart", startPart);
				param.put("endpart", endPart);
				
				
				Map<String, String> mapVO = receiptListByDetailCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchReceiptListByDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceiptListByDetailVO.class);             
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
	 * Insert into SAR_RCV_APPL<br>
	 * @param List<ReceivableApplVO> receivableApplVOs
	 * @exception DAOException
	 */	 
	 
	public void addReceivableApplication (List<ReceivableApplVO> receivableApplVOs) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(receivableApplVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableReceiptDBDAOaddReceivableApplicationCSQL(), receivableApplVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Search Last Application Status<br>
	 * 
	 * @param String rctSeq
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchLastApplicationStatus(String rctSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String rcvApplSts = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_seq", rctSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchLastApplicationStatusRSQL(), param, velParam);											
			
			if(dbRowset.next()){
				rcvApplSts = dbRowset.getString("rcv_appl_sts_cd");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rcvApplSts;
	}	
	
	/**
	 * Search Receivable Appl Sequence<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchReceivableApplSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String rcvApplSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchReceivableApplSeqRSQL(), param, velParam);											
		
			if(dbRowset.next()){
				rcvApplSeq = dbRowset.getString("rcv_appl_seq");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rcvApplSeq;
	}	
	
	/**
	 * Check Bank Charge<br>
	 * 
	 * @param String rctSeq
	 * @return Boolean
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Boolean checkBankCharge(String rctSeq) throws DAOException {
		DBRowSet dbRowset = null;
		Boolean flag = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_seq", rctSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOcheckBankChargeRSQL(), param, velParam);											
			if(dbRowset.next()){
				if(dbRowset.getInt("cnt") > 0){
					flag = true;
				}
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flag;
	}		
	
	/**
	 * Search Receivable Application for Reverse<br>
	 * 
	 * @param String rctSeq
	 * @param String aplyDtlSeq
	 * @param String bcFlg
	 * @return List<ReceivableApplVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReceivableApplVO> searchReceivableApplForReverse(String rctSeq, String aplyDtlSeq, String bcFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReceivableApplVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_seq", rctSeq);
			mapVO.put("rct_aply_dtl_seq", aplyDtlSeq);
			mapVO.put("bc_flg", bcFlg);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchReceivableApplForReverseRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceivableApplVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Search Receivable Application for Cancel<br>
	 * 
	 * @param String rctSeq
	 * @return List<ReceivableApplVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReceivableApplVO> searchReceivableApplForCancel(String rctSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReceivableApplVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_seq", rctSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchReceivableApplForCancelRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceivableApplVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Update SAR_RCV_APPL<br>
	 * @param List<ReceivableApplVO> receivableApplVOs
	 * @exception DAOException
	 */	 
	 
	public void modifyReceivableApplType (List<ReceivableApplVO> receivableApplVOs) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(receivableApplVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableReceiptDBDAOmodifyReceivableApplTypeUSQL(), receivableApplVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Search Receivable for OTS History<br>
	 * 
	 * @param List<String> rcvApplSeq
	 * @return List<AROutstandingHistVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingHistVO> searchReceivableForOTSHistory(List<String> rcvApplSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingHistVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("rcv_appl_seq", rcvApplSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchReceivableForOTSHistoryRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingHistVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Search Receivable for OTS Header<br>
	 * 
	 * @param List<String> rcvApplSeq
	 * @return List<AROutstandingHdrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingHdrVO> searchReceivableForOTSHeader(List<String> rcvApplSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("rcv_appl_seq", rcvApplSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchReceivableForOTSHeaderRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingHdrVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Search Receivable for OTS Detail<br>
	 * 
	 * @param List<String> rcvApplSeq
	 * @return List<AROutstandingDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingDtlVO> searchReceivableForOTSDetail(List<String> rcvApplSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("rcv_appl_seq", rcvApplSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchReceivableForOTSDetailRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingDtlVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Search Receivable for OTS Charge<br>
	 * 
	 * @param List<String> rcvApplSeq
	 * @return List<AROutstandingChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingChgVO> searchReceivableForOTSCharge(List<String> rcvApplSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("rcv_appl_seq", rcvApplSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOsearchReceivableForOTSChargeRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingChgVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Insert into SAR_CLT_DTRB<br>
	 * @param ReceiptDistributionVO receiptDistributionVO
	 * @exception DAOException
	 */	 
	 
	public void addReceiptDistribution (ReceiptDistributionVO receiptDistributionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = receiptDistributionVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableReceiptDBDAOAddReceiptDistributionCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Update SAR_RCV_APPL<br>
	 * @param ReceivableApplVO receivableApplVO
	 * @exception DAOException
	 */	 
	public void modifyReceivableApplCmbSeq (ReceivableApplVO receivableApplVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = receivableApplVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableReceiptDBDAOModifyReceivableApplCmbSeqUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Search Bank Account combination sequence<br>
	 * 
	 * @param String bankAcctSeq
	 * @return BankAcctCmbSeqVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BankAcctCmbSeqVO searchBankAcctCmbSeq(String bankAcctSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BankAcctCmbSeqVO> list = null;
		BankAcctCmbSeqVO bankAcctCmbSeqVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bank_acct_seq", bankAcctSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchBankAcctCmbSeqRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankAcctCmbSeqVO .class);
		
			if (list != null && list.size() > 0) {
				bankAcctCmbSeqVO = (BankAcctCmbSeqVO) list.get(0);
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bankAcctCmbSeqVO;
	}		
	
	/**
	 * Search account matrix info for receipt<br>
	 * 
	 * @param ReceiptAccountCondVO receiptAccountCondVO
	 * @return ReceiptAccountVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ReceiptAccountVO searchReceiptAccount(ReceiptAccountCondVO receiptAccountCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReceiptAccountVO> list = null;
		ReceiptAccountVO receiptAccountVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = receiptAccountCondVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchReceiptAccountRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceiptAccountVO .class);
		
			if (list != null && list.size() > 0) {
				receiptAccountVO = (ReceiptAccountVO) list.get(0);
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return receiptAccountVO;
	}		
	
	/**
	 * Search ledger combination sequence<br>
	 * 
	 * @param LedgerCmbCondVO ledgerCmbCondVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchLedgerCombination(LedgerCmbCondVO ledgerCmbCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dtrbCdCmbSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = ledgerCmbCondVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchLedgerCombinationRSQL(), param, velParam);											
			
			if(dbRowset.next()){
				dtrbCdCmbSeq = dbRowset.getString("cd_cmb_seq");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return dtrbCdCmbSeq;
	}	
	
	/**
	 * Search OTS distribution info<br>
	 * 
	 * @param String otsHisSeq
	 * @param String chgTpCd
	 * @return OTSDistributionVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public OTSDistributionVO searchOTSDistribution(String otsHisSeq, String chgTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<OTSDistributionVO> list = null;
		OTSDistributionVO otsDistributionVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ots_his_seq", otsHisSeq);
			mapVO.put("chg_tp_cd", chgTpCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchOTSDistributionRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTSDistributionVO .class);
		
			if (list != null && list.size() > 0) {
				otsDistributionVO = (OTSDistributionVO) list.get(0);
			} 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return otsDistributionVO;
	}	
	
	/**
	 * Insert into SAR_CLT_DTRB<br>
	 * @param ReceivableApplVO receivableApplVO
	 * @exception DAOException
	 */	 
	 
	public void addReverseCancelDistribution (ReceivableApplVO receivableApplVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = receivableApplVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableReceiptDBDAOAddReverseCancelDistributionCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Search receipt info for AP interface<br>
	 * 
	 * @param String rctNo
	 * @param List<String> aplyHdrSeq
	 * @param String saveKindCd
	 * @param String usrId
	 * @return List<ReceiptForAPInterfaceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReceiptForAPInterfaceVO> searchReceiptForAPInterface(String rctNo, List<String> aplyHdrSeq, String saveKindCd, String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReceiptForAPInterfaceVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_no", rctNo);
			mapVO.put("save_kind_cd", saveKindCd);
			mapVO.put("usr_id", usrId);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("rct_aply_hdr_seq", aplyHdrSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchReceiptForAPInterfaceRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ReceiptForAPInterfaceVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Search AP combination sequence<br>
	 * 
	 * @param APCombinationSeqCondVO apCombinationSeqCondVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAPCombinationSeq(APCombinationSeqCondVO apCombinationSeqCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String apCdCmbSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = apCombinationSeqCondVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchAPCombinationSeqRSQL(), param, velParam);											
			
			if(dbRowset.next()){
				apCdCmbSeq = dbRowset.getString("cd_cmb_seq");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return apCdCmbSeq;
	}	
	
	/**
	 * Update SAR_RCT_APLY_DTL<br>
	 * @param APInterfaceStatusVO apInterfaceStatusVO
	 * @exception DAOException
	 */	 
	public void modifyAPInterfaceStatus(APInterfaceStatusVO apInterfaceStatusVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = apInterfaceStatusVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableReceiptDBDAOModifyAPInterfaceStatusUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Search open ASA list<br>
	 * 
	 * @param String agnCd
	 * @param String rctNo
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchOpenASAList(String agnCd, String rctNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("agn_cd", agnCd);
			mapVO.put("rct_no", rctNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchOpenASAListRSQL(), param, velParam);											
			while(dbRowset.next()) {						
				list.add(dbRowset.getString("asa_no") + "," + dbRowset.getString("curr_cd"));
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Insert into SCO_LEGR_CD_CMB<br>
	 * @param LedgerCmbCondVO ledgerCmbCondVO
	 * @exception DAOException
	 */	 
	 
	public void addLedgerCombinationForReceipt (LedgerCmbCondVO ledgerCmbCondVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = ledgerCmbCondVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableReceiptDBDAOAddLedgerCombinationForReceiptCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Insert into SCO_LEGR_CD_CMB<br>
	 * @param APCombinationSeqCondVO apCombinationSeqCondVO
	 * @exception DAOException
	 */	 
	 
	public void addLedgerCombinationForAPInterface (APCombinationSeqCondVO apCombinationSeqCondVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = apCombinationSeqCondVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableReceiptDBDAOAddLedgerCombinationForAPInterfaceCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Search Receipts view accounting
	 * @author jinyoonoh 2014. 7. 16.
	 * @param RCTViewAccountingListVO vo
	 * @return List<RCTViewAccountingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RCTViewAccountingListVO> searchRCTViewAccountingList(RCTViewAccountingListVO vo) throws DAOException {
			
		DBRowSet dbRowset = null;
		List<RCTViewAccountingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableReceiptDBDAOSearchRCTViewAccountingListRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,RCTViewAccountingListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Search OTS Header from Temp<br>
	 * 
	 * @param String otsRctTmpSeq
	 * @return List<ApplyHeaderVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ApplyHeaderVO> searchOutstandingReceiptHdrTemp(String otsRctTmpSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApplyHeaderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ots_rct_tmp_seq", otsRctTmpSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchOutstandingReceiptHdrTempRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApplyHeaderVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	
	/**
	 * Search OTS Charge from Temp<br>
	 * 
	 * @param String otsRctTmpSeq
	 * @return List<ApplyDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ApplyDetailVO> searchOutstandingReceiptDtlTemp(String otsRctTmpSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApplyDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ots_rct_tmp_seq", otsRctTmpSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchOutstandingReceiptDtlTempRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApplyDetailVO .class);
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}		
	
	/**
	 * Search Apply Total Amount from Temp<br>
	 * 
	 * @param String otsRctTmpSeq
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOTSTempTotalAmount(String otsRctTmpSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String ttlAplyAmt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ots_rct_tmp_seq", otsRctTmpSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchOTSTempTotalAmountRSQL(), param, velParam);											
			if(dbRowset.next()){
				ttlAplyAmt = dbRowset.getString("ttl_aply_amt");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ttlAplyAmt;
	}	
	
	/**
	 * Insert into SAR_RCV_APPL_SEQ_TMP<br>
	 * @param List<RcvApplSeqTmpVO> rcvApplSeqTmpVOs
	 * @exception DAOException
	 */	 
	 
	public void addRcvApplSeqTmp (List<RcvApplSeqTmpVO> rcvApplSeqTmpVOs) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(rcvApplSeqTmpVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableReceiptDBDAOAddRcvApplSeqTmpCSQL(), rcvApplSeqTmpVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Insert into SAR_RCT_HDR_SEQ_TMP<br>
	 * @param List<RctHdrSeqTmpVO> rctHdrSeqTmpVOs
	 * @exception DAOException
	 */	 
	 
	public void addRctHdrSeqTmp (List<RctHdrSeqTmpVO> rctHdrSeqTmpVOs) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(rctHdrSeqTmpVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableReceiptDBDAOAddRctHdrSeqTmpCSQL(), rctHdrSeqTmpVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * rct_no 를 조회하기 위한 BackEndJob의 LoadFile함수를 통해 결과를 조회한다.<br>
	 * 
	 * @param String backendjobKey
	 * @return String
	 * @exception EventException, DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchReceiptBackEndJobFile(String backendjobKey) throws Exception, DAOException {
			
		try {
			return (String)BackEndJobResult.loadFromFile(backendjobKey);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Search Apply Total Amount<br>
	 * 
	 * @param String rctOfcCd
	 * @param String rctNo
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchApplyTotalAmount(String rctOfcCd, String rctNo) throws DAOException {
		DBRowSet dbRowset = null;
		String ttlAplyAmt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_ofc_cd", rctOfcCd);
			mapVO.put("rct_no", rctNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchApplyTotalAmountRSQL(), param, velParam);											
			if(dbRowset.next()){
				ttlAplyAmt = dbRowset.getString("ttl_aply_amt");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ttlAplyAmt;
	}	
	
	/**
	 * Search balance receipt account amount<br>
	 * 
	 * @param String rctSeq
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchBalRctAcctAmt(String rctSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String balRctAcctAmt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_seq", rctSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchBalRctAcctAmtRSQL(), param, velParam);											
			
			if(dbRowset.next()){
				balRctAcctAmt = dbRowset.getString("bal_rct_acct_amt");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return balRctAcctAmt;
	}	
	
	/**
	 * Search distribution account amount<br>
	 * 
	 * @param ReceivableApplVO receivableApplVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchDtrbAcctAmt(ReceivableApplVO receivableApplVO) throws DAOException {
		DBRowSet dbRowset = null;
		String acctAmt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = receivableApplVO.getColumnValues();	
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableReceiptDBDAOSearchDtrbAcctAmtRSQL(), param, velParam);											
			
			if(dbRowset.next()){
				acctAmt = dbRowset.getString("acct_amt");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return acctAmt;
	}
	
	/**
	 * Update SAR_RECEIPT<br>
	 * @param String rctSeq
	 * @param String balRctAcctAmt
	 * @exception DAOException
	 */	 
	public void modifyBalRctAcctAmt(String rctSeq, String balRctAcctAmt) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rct_seq", rctSeq);	
			mapVO.put("bal_rct_acct_amt", balRctAcctAmt);	
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableReceiptDBDAOModifyBalRctAcctAmtUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}