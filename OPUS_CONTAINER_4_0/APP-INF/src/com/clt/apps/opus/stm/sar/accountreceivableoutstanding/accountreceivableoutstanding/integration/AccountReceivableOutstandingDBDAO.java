/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableOutstandingDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.BatHisVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROustandingbySADateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingCheckVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingChgVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROutstandingHistVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.ASAAccountCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.ApplyOutstandingCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.ApplyOutstandingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.LedgerCombinationCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSAgingBaseVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSAgingBucketVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSAgingPKVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSForApplyAdjustVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingAccountCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingAccountVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingDtlByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingDtrbVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingHdrByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingHisByDateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingInterfaceVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingSumByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterByEmailFaxVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterHisVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterSumVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.RegionCenterVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.SarOtsRctTmpVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * AccountReceivableOutstandingDBDAO <br>
 * - AccountReceivableOutstanding system Business Logic<br>
 * 
 * @author 
 * @see AccountReceivableOutstandingBCImpl
 * @since J2EE 1.4
 */
public class AccountReceivableOutstandingDBDAO extends DBDAOSupport { 
	
	private static final long serialVersionUID = 1L;
	
	private String dataSource = "";
	/**
	 * AccountReceivableOutstandingDBDAO object creation<br>
	 * AccountReceivableOutstandingDBDAO creation<br>
	 */
	public AccountReceivableOutstandingDBDAO() { }
	
	
	/**
	 * AccountReceivableOutstandingDBDAO object creation<br>
	 * AccountReceivableOutstandingDBDAO creation<br>
	 * @param String dataSource
	 */
	public AccountReceivableOutstandingDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}
		
	/**
	 * Search Invoice Info to create Outstanding Header<br>
	 * 
	 * @param String ifNo
	 * @return AROutstandingHdrVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AROutstandingHdrVO searchINVForOutstandingHeader(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		AROutstandingHdrVO arOutstandingHdrVO = null;
		List<AROutstandingHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchINVForOutstandingHeaderRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingHdrVO .class);
			
			if (list != null && list.size() > 0) {
				arOutstandingHdrVO = (AROutstandingHdrVO) list.get(0);
			} 
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arOutstandingHdrVO;
	}		
	
	/**
	 * Search Invoice Info to create Outstanding Detail<br>
	 * 
	 * @param String ifNo
	 * @return List<AROutstandingDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingDtlVO> searchINVForOutstandingDetail(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchINVForOutstandingDetailRSQL(), param, velParam);											
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
	 * Search Invoice Info to create Outstanding History<br>
	 * 
	 * @param String ifNo
	 * @return List<AROutstandingHistVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingHistVO> searchINVForOutstandingHist(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingHistVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchINVForOutstandingHistRSQL(), param, velParam);											
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
	 * Search Invoice Info to create Outstanding Charge<br>
	 * 
	 * @param String ifNo
	 * @return List<AROutstandingChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingChgVO> searchINVForOutstandingCharge(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchINVForOutstandingChargeRSQL(), param, velParam);											
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
	 * Search Revenue Type from Outstanding<br>
	 * 
	 * @param AROutstandingCheckVO arOutstandingCheckVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOutstandingRevType(AROutstandingCheckVO arOutstandingCheckVO) throws DAOException {
		DBRowSet dbRowset = null;
		String revTypeCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = arOutstandingCheckVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchOutstandingRevTypeRSQL(), param, velParam);											
			if(dbRowset.next()){
				revTypeCd = dbRowset.getString("rev_tp_src_cd");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return revTypeCd;
	}		
	
	/**
	 * Check Outstanding Header<br>
	 * 
	 * @param AROutstandingCheckVO arOutstandingCheckVO
	 * @return Boolean
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Boolean checkOutstandingHeader(AROutstandingCheckVO arOutstandingCheckVO) throws DAOException {
		DBRowSet dbRowset = null;
		Boolean flag = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = arOutstandingCheckVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOcheckOutstandingHeaderRSQL(), param, velParam);											
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
	 * Check Outstanding Detail<br>
	 * 
	 * @param AROutstandingCheckVO arOutstandingCheckVO
	 * @return Boolean
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Boolean checkOutstandingDetail(AROutstandingCheckVO arOutstandingCheckVO) throws DAOException {
		DBRowSet dbRowset = null;
		Boolean flag = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = arOutstandingCheckVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOcheckOutstandingDetailRSQL(), param, velParam);											
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
	 * Insert into SAR_OTS_HDR<br>
	 * @param AROutstandingHdrVO arOutstandingHdrVO
	 * @exception DAOException
	 */	 
	public void addOutstandingHeader (AROutstandingHdrVO arOutstandingHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = arOutstandingHdrVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOaddOutstandingHeaderCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Insert into SAR_OTS_DTL<br>
	 * @param List<AROutstandingDtlVO> arOutstandingDtlVO
	 * @exception DAOException
	 */	 
	 
	public void addOutstandingDetail (List<AROutstandingDtlVO> arOutstandingDtlVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(arOutstandingDtlVO.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingDBDAOaddOutstandingDetailCSQL(), arOutstandingDtlVO, null);
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
	 * Insert into SAR_OTS_HIS<br>
	 * @param List<AROutstandingHistVO> arOutstandingHistVO
	 * @exception DAOException
	 */	 
	 
	public void addOutstandingHist (List<AROutstandingHistVO> arOutstandingHistVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(arOutstandingHistVO.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingDBDAOaddOutstandingHistCSQL(), arOutstandingHistVO, null);
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
	 * Insert into SAR_OTS_CHG<br>
	 * @param List<AROutstandingChgVO> arOutstandingChgVO
	 * @exception DAOException
	 */	 
	 
	public void addOutstandingCharge (List<AROutstandingChgVO> arOutstandingChgVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(arOutstandingChgVO.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingDBDAOaddOutstandingChargeCSQL(), arOutstandingChgVO, null);
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
	 * Update to SAR_OTS_HDR<br>
	 * @param AROutstandingHdrVO arOutstandingHdrVO
	 * @exception DAOException
	 */	 
	public void modifyOutstandingHeader (AROutstandingHdrVO arOutstandingHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = arOutstandingHdrVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOmodifyOutstandingHeaderUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Update to SAR_OTS_DTL<br>
	 * @param List<AROutstandingDtlVO> arOutstandingDtlVO
	 * @exception DAOException
	 */	 
	 
	public void modifyOutstandingDetail (List<AROutstandingDtlVO> arOutstandingDtlVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(arOutstandingDtlVO.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingDBDAOmodifyOutstandingDetailUSQL(), arOutstandingDtlVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Update Invoice No to SAR_OTS_CHG<br>
	 * @param List<AROutstandingChgVO> arOutstandingChgVO
	 * @exception DAOException
	 */	 
	 
	public void modifyOutstandingChargeInvNo (List<AROutstandingChgVO> arOutstandingChgVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(arOutstandingChgVO.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingDBDAOmodifyOutstandingChargeInvNoUSQL(), arOutstandingChgVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Update Invoice No to SAR_OTS_HIS<br>
	 * @param List<AROutstandingHistVO> arOutstandingHistVO
	 * @exception DAOException
	 */	 
	 
	public void modifyOutstandingHistInvNo (List<AROutstandingHistVO> arOutstandingHistVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(arOutstandingHistVO.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingDBDAOModifyOutstandingHistInvNoUSQL(), arOutstandingHistVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Update Settle Flag and Exrate Flag<br>
	 * @param AROutstandingHdrVO arOutstandingHdrVO
	 * @exception DAOException
	 */	 
	public void modifyOTSSettleFlag (AROutstandingHdrVO arOutstandingHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = arOutstandingHdrVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOmodifyOTSSettleFlagUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Search OTS for Apply List<br>
	 * 
	 * @param ApplyOutstandingCondVO applyOutstandingCondVO
	 * @return List<ApplyOutstandingListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ApplyOutstandingListVO> searchApplyOutstandingList(ApplyOutstandingCondVO applyOutstandingCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApplyOutstandingListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = applyOutstandingCondVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchApplyOutstandingListRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApplyOutstandingListVO .class);
		
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
     * Outstanding Inquiry<br><br>
     * 
     * @author YJLEE
     * @category STM_SAR_1002
     * @category searchOustandingByDate
     * @param AROustandingbySADateVO aROustandingbySADateVO      
     * @return List<AROustandingbySADateVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<AROustandingbySADateVO> searchOustandingByDate(AROustandingbySADateVO aROustandingbySADateVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<AROustandingbySADateVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
       try {	
        	
    	   if(aROustandingbySADateVO != null){
    		   
				 // 페이징 처리
				int paseSize    = Integer.parseInt(aROustandingbySADateVO.getPagerows());
				int currentPage = Integer.parseInt(aROustandingbySADateVO.getIPage());
				int startPart   = paseSize * (currentPage - 1) + 1;
				int endPart     = paseSize * currentPage;
				log.error("STM_SAR_1002 Paging Start Page " + startPart + " and End Page" + endPart);
				param.put("startpart", startPart);
				param.put("endpart", endPart);
				velParam.put("startpart", startPart);
				velParam.put("endpart", endPart);
				
				
				Map<String, String> mapVO = aROustandingbySADateVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchOustandingbySADateRSQLRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROustandingbySADateVO.class);             
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
     * Payment Request Letter<br><br>
     * 
     * @author YJLEE
     * @category STM_SAR_1005
     * @category searchPaymentRequestLetter
     * @param PaymentRequestLetterVO paymentRequestLetterVO      
     * @return List<PaymentRequestLetterVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PaymentRequestLetterVO> searchPaymentRequestLetter(PaymentRequestLetterVO paymentRequestLetterVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PaymentRequestLetterVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
       try {	
    	   if(paymentRequestLetterVO != null){
    		   Map<String, String> mapVO = paymentRequestLetterVO.getColumnValues();
			   param.putAll(mapVO);
			   velParam.putAll(mapVO);
			   if(paymentRequestLetterVO.getAgnOfcCdText().length()>0){ 
					 List<String> colOfcs = new ArrayList<String>();     
					 String[] arrColOfcs =  paymentRequestLetterVO.getAgnOfcCdText().split(",");
					 for(int i = 0; i < arrColOfcs.length; i ++){         
						 colOfcs.add(arrColOfcs[i]);           
					 }     
					 velParam.put("colOfcs", colOfcs);
			   }
			}
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentRequestLetterVO.class);             
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
     * Payment Request Letter<br><br>
     * 
     * @author YJLEE
     * @category STM_SAR_1005
     * @category searchPaymentRequestLetter
     * @param PaymentRequestLetterVO paymentRequestLetterVO      
     * @return List<PaymentRequestLetterSumVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PaymentRequestLetterSumVO> searchPaymentRequestLetterSum(PaymentRequestLetterVO paymentRequestLetterVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	List<PaymentRequestLetterSumVO> list = null;
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	try {	
    		if(paymentRequestLetterVO != null){
    			Map<String, String> mapVO = paymentRequestLetterVO.getColumnValues();
    			param.putAll(mapVO);
 			   	velParam.putAll(mapVO); 
 			   	if(paymentRequestLetterVO.getAgnOfcCdText().length()>0){
 					 List<String> colOfcs = new ArrayList<String>();     
 					 String[] arrColOfcs =  paymentRequestLetterVO.getAgnOfcCdText().split(",");
 					 for(int i = 0; i < arrColOfcs.length; i ++){         
 						 colOfcs.add(arrColOfcs[i]);           
 					 }     
 					 velParam.put("colOfcs", colOfcs);
 			   	}
    		}
    		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterSumRSQL(), param, velParam);
    		list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentRequestLetterSumVO.class);             
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
     * Payment Request Letter<br><br>
     * SAR_PAY_RQST_LTR_SND_LIST TABLE
     * 
     * @author MyoungSin park
     * @category STM_SAR_1005
     * @param List<PaymentRequestLetterVO> paymentRequestLetterVOs
     * @throws DAOException
     */
	public void addPaymentRequestLetterTemp(List<PaymentRequestLetterVO> paymentRequestLetterVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (paymentRequestLetterVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new AccountReceivableOutstandingDBDAOaddPaymentRequestLetterTempCSQL(), paymentRequestLetterVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	 /**
		 * Search Payment Request Letter email Sequence<br>
		 * 
	     * @author YJLEE
	     * @category STM_SAR_1005
	     * @category searchPaymentRequestLetterSeq
	     * @return String
	     * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public String searchPaymentRequestLetterSeq() throws DAOException {
			DBRowSet dbRowset = null;
			String arEmlSeq = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterEmailSeqRSQL(), param, velParam);											
				if(dbRowset.next()){
					arEmlSeq = dbRowset.getString("ar_eml_seq");
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return arEmlSeq;
		}	
		
		/**
		 * Search Payment Request Letter email fax<br>
		 * 
		 * @author YJLEE
	     * @category STM_SAR_1005
	     * @category searchPaymentRequestLetterEmailFax
	     * @param PaymentRequestLetterVO paymentRequestLetterVO       
	     * @return List<PaymentRequestLetterVO>
	     * @throws DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<PaymentRequestLetterVO> searchPaymentRequestLetterEmailFax(PaymentRequestLetterVO paymentRequestLetterVO) throws DAOException {
			DBRowSet dbRowset = null;
	        
	        List<PaymentRequestLetterVO> list = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
		    	   if(paymentRequestLetterVO != null){
						Map<String, String> mapVO = paymentRequestLetterVO.getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
		             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterEmailFaxRSQL(), param, velParam);
		             list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentRequestLetterVO.class);             
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
	 * Search Outstanding History Sequence<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOutstandingHistSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String otsHisSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchOutstandingHistSeqRSQL(), param, velParam);											
			if(dbRowset.next()){
				otsHisSeq = dbRowset.getString("ots_his_seq");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return otsHisSeq;
	}		
	
	/**
	 * Search Target OTS for Apply and Adjust<br>
	 * 
	 * @param AROutstandingCheckVO arOutstandingCheckVO
	 * @return List<OTSForApplyAdjustVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OTSForApplyAdjustVO> searchOutstandingForApplyAdjust(AROutstandingCheckVO arOutstandingCheckVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OTSForApplyAdjustVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = arOutstandingCheckVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchOutstandingForApplyAdjustRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTSForApplyAdjustVO .class);
		
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
	 * Search OTS Balance Amount<br>
	 * 
	 * @param AROutstandingCheckVO arOutstandingCheckVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOutstandingBalance(AROutstandingCheckVO arOutstandingCheckVO) throws DAOException {
		DBRowSet dbRowset = null;
		String balAmt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = arOutstandingCheckVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchOutstandingBalanceRSQL(), param, velParam);											
			if(dbRowset.next()){
				balAmt = dbRowset.getString("bal_amt");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return balAmt;
	}
	
	/**
	 * Update Balance to SAR_OTS_CHG<br>
	 * @param List<AROutstandingChgVO> arOutstandingChgVO
	 * @exception DAOException
	 */	 
	 
	public void modifyOutstandingChargeAmt (List<AROutstandingChgVO> arOutstandingChgVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(arOutstandingChgVO.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingDBDAOmodifyOutstandingChargeAmtUSQL(), arOutstandingChgVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Update Balance to SAR_OTS_CHG<br>
	 * @param AROutstandingChgVO aROutstandingChgVO
	 * @exception DAOException
	 */	 
	 
	public void modifyOutstandingChargeAmtByEach (AROutstandingChgVO aROutstandingChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try {	
			Map<String, String> mapVO = aROutstandingChgVO.getColumnValues();
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOmodifyOutstandingChargeAmtByEachUSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Update Collected Office<br>
	 * @param AROutstandingHdrVO arOutstandingHdrVO
	 * @exception DAOException
	 */	 
	public void modifyCollectedOffice (AROutstandingHdrVO arOutstandingHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = arOutstandingHdrVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOmodifyCollectedOfficeUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * Search Outstanding Inquiry by B/L(Invoice) Header <br>
	 * @author jinyoonoh 2014. 4. 23.
	 * @param OutstandingHdrByBlVO vo
	 * @return List<OutstandingHdrByBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OutstandingHdrByBlVO> searchOutstandingHdrByBl(OutstandingHdrByBlVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OutstandingHdrByBlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = vo.getColumnValues();		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchOutstandingHdrByBlRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OutstandingHdrByBlVO .class);
		
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
	 * Search Outstanding Inquiry by B/L(Invoice) Detail <br>
	 * 
	 * @author jinyoonoh 2014. 4. 23.
	 * @param OutstandingDtlByBlVO vo
	 * @return List<OutstandingDtlByBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OutstandingDtlByBlVO> searchOutstandingDtlByBl(OutstandingDtlByBlVO vo) throws DAOException {
			
		DBRowSet dbRowset = null;
		List<OutstandingDtlByBlVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingDBDAOsearchOutstandingDtlByBlRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OutstandingDtlByBlVO.class);
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
	 * Search Outstanding Inquiry by B/L(Invoice) Detail <br>
	 * 
	 * @author jinyoonoh 2014. 4. 23.
	 * @param OutstandingSumByBlVO vo
	 * @return List<OutstandingSumByBlVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OutstandingSumByBlVO> searchOutstandingSumByBl(OutstandingSumByBlVO vo) throws DAOException {
			
		DBRowSet dbRowset = null;
		List<OutstandingSumByBlVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingDBDAOsearchOutstandingSumByBlRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OutstandingSumByBlVO.class);

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
	 * Search Outstanding Inquiry by B/L(Invoice) History popup <br>
	 * 
	 * @author jinyoonoh 2014. 4. 23.
	 * @param OutstandingHisByDateVO vo
	 * @return List<OutstandingHisByDateVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OutstandingHisByDateVO> searchOutstandingHisByDate(OutstandingHisByDateVO vo) throws DAOException {
			
		DBRowSet dbRowset = null;
		List<OutstandingHisByDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingDBDAOsearchOutstandingHisByDateRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,OutstandingHisByDateVO.class);
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
	 * Search outstanding account<br>
	 * 
	 * @param OutstandingAccountCondVO outstandingAccountCondVO
	 * @return OutstandingAccountVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public OutstandingAccountVO searchOutstandingAccount(OutstandingAccountCondVO outstandingAccountCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OutstandingAccountVO> list = null;
		OutstandingAccountVO outstandingAccountVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = outstandingAccountCondVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchOutstandingAccountRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OutstandingAccountVO .class);
		
			if (list != null && list.size() > 0) {
				outstandingAccountVO = (OutstandingAccountVO) list.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return outstandingAccountVO;
	}
	
	/**
	 * Search MDM Charge for account code<br>
	 * 
	 * @param String chgTpCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchMDMChargeForAccount(String chgTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String acctCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("chg_tp_cd", chgTpCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchMDMChargeForAccountRSQL(), param, velParam);											
			
			if(dbRowset.next()){
				acctCd = dbRowset.getString("acct_cd");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return acctCd;
	}	
	
	/**
	 * Search Inter Company code<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchInterCompany(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String subsCoCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", custCntCd);
			mapVO.put("cust_seq", custSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchInterCompanyRSQL(), param, velParam);											
			
			if(dbRowset.next()){
				subsCoCd = dbRowset.getString("subs_co_cd");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return subsCoCd;
	}
	
	/**
	 * Search Region/Center code<br>
	 * 
	 * @param String ofcCd
	 * @return RegionCenterVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RegionCenterVO searchRegionCenter(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		RegionCenterVO regionCenterVO = null;
		List<RegionCenterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchRegionCenterRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RegionCenterVO .class);
			
			if (list != null && list.size() > 0) {
				regionCenterVO = (RegionCenterVO) list.get(0);
			} 
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return regionCenterVO;
	}		
	
	/**
	 * Update account matrix sequence to SAR_OTS_CHG<br>
	 * @param List<AROutstandingChgVO> arOutstandingChgVO
	 * @exception DAOException
	 */	 
	 
	public void modifyOTSChargeAcctMtxSeq (List<AROutstandingChgVO> arOutstandingChgVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(arOutstandingChgVO.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingDBDAOModifyOTSChargeAcctMtxSeqUSQL(), arOutstandingChgVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Search Ledger Combination Sequence<br>
	 * 
	 * @param LedgerCombinationCondVO ledgerCombinationCondVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchLedgerCombination(LedgerCombinationCondVO ledgerCombinationCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cmbSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = ledgerCombinationCondVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchLedgerCombinationRSQL(), param, velParam);											
			if(dbRowset.next()){
				cmbSeq = dbRowset.getString("cd_cmb_seq");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cmbSeq;
	}
	
	/**
	 * Insert into SAR_OTS_DTRB<br>
	 * @param List<OutstandingDtrbVO> outstandingDtrbVO
	 * @exception DAOException
	 */	 
	 
	public void addOutstandingDistribution (List<OutstandingDtrbVO> outstandingDtrbVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(outstandingDtrbVO.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingDBDAOAddOutstandingDistributionCSQL(), outstandingDtrbVO, null);
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
	 * Search Outstanding Aging base sum of amount
	 * @author jinyoonoh 2014. 5. 21.
	 * @param OTSAgingBaseVO vo
	 * @return List<OTSAgingBaseVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OTSAgingBaseVO> searchOTSAgingBaseAmtList(OTSAgingBaseVO vo) throws DAOException {
			
		DBRowSet dbRowset = null;
		List<OTSAgingBaseVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingDBDAOSearchOTSAgingBaseRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,OTSAgingBaseVO.class);
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
	 * Search Outstanding Aging base Count
	 * @author jinyoonoh 2014. 5. 21.
	 * @param OTSAgingBaseVO vo
	 * @return List<OTSAgingBaseVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OTSAgingBaseVO> searchOTSAgingBaseCntList(OTSAgingBaseVO vo) throws DAOException {
			
		DBRowSet dbRowset = null;
		List<OTSAgingBaseVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingDBDAOSearchOTSAgingBaseCntListRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,OTSAgingBaseVO.class);
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
	 * Search Outstanding Aging Bucket
	 * @author jinyoonoh 2014. 5. 21.
	 * @param OTSAgingBucketVO vo
	 * @return List<OTSAgingBucketVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OTSAgingBucketVO> searchOTSAgingBucketList(OTSAgingBucketVO vo) throws DAOException {
			
		DBRowSet dbRowset = null;
		List<OTSAgingBucketVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingDBDAOSearchOTSAgingBucketRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,OTSAgingBucketVO.class);
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
	 * Search Outstanding Aging Bucket
	 * @author jinyoonoh 2014. 5. 21.
	 * @param OTSAgingBaseVO paramVO
	 * @return List<OTSAgingPKVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OTSAgingPKVO> searchOTSAgingPK(OTSAgingBaseVO paramVO) throws DAOException {
			
		DBRowSet dbRowset = null;
		List<OTSAgingPKVO> list = new ArrayList<OTSAgingPKVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = paramVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingDBDAOSearchOTSAgingPKRSQL(),param, velParam);							
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OTSAgingPKVO.class);
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
	 * Insert into SAR_OTS_IF<br>
	 * @param List<OutstandingInterfaceVO> outstandingInterfaceVOs
	 * @exception DAOException
	 */	 
	 
	public void addOutstandingInterface (List<OutstandingInterfaceVO> outstandingInterfaceVOs) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(outstandingInterfaceVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingDBDAOAddOutstandingInterfaceCSQL(), outstandingInterfaceVOs, null);
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
	 * Search Outstanding interface info<br>
	 * 
	 * @param String ifNo
	 * @return List<OutstandingInterfaceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OutstandingInterfaceVO> searchOutstandingInterface(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OutstandingInterfaceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchOutstandingInterfaceRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OutstandingInterfaceVO .class);
		
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
	 * Search Interface Info to create Outstanding Header<br>
	 * 
	 * @param String otsIfSeq
	 * @return AROutstandingHdrVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AROutstandingHdrVO searchInterfaceForOutstandingHeader(String otsIfSeq) throws DAOException {
		DBRowSet dbRowset = null;
		AROutstandingHdrVO arOutstandingHdrVO = null;
		List<AROutstandingHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ots_if_seq", otsIfSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingHeaderRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingHdrVO .class);
			
			if (list != null && list.size() > 0) {
				arOutstandingHdrVO = (AROutstandingHdrVO) list.get(0);
			} 
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arOutstandingHdrVO;
	}		
	
	/**
	 * Search Interface Info to create Outstanding Detail<br>
	 * 
	 * @param String otsIfSeq
	 * @return AROutstandingDtlVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AROutstandingDtlVO searchInterfaceForOutstandingDetail(String otsIfSeq) throws DAOException {
		DBRowSet dbRowset = null;
		AROutstandingDtlVO arOutstandingDtlVO = null;
		List<AROutstandingDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ots_if_seq", otsIfSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingDetailRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingDtlVO .class);
			
			if (list != null && list.size() > 0) {
				arOutstandingDtlVO = (AROutstandingDtlVO) list.get(0);
			} 
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arOutstandingDtlVO;
	}		
	
	/**
	 * Search Interface Info to create Outstanding History<br>
	 * 
	 * @param String otsIfSeq
	 * @return AROutstandingHistVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AROutstandingHistVO searchInterfaceForOutstandingHist(String otsIfSeq) throws DAOException {
		DBRowSet dbRowset = null;
		AROutstandingHistVO arOutstandingHistVO = null;
		List<AROutstandingHistVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ots_if_seq", otsIfSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingHistRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingHistVO .class);
			
			if (list != null && list.size() > 0) {
				arOutstandingHistVO = (AROutstandingHistVO) list.get(0);
			} 
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arOutstandingHistVO;
	}		
	
	/**
	 * Search Interface Info to create Outstanding Charge<br>
	 * 
	 * @param String otsIfSeq
	 * @return AROutstandingChgVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AROutstandingChgVO searchInterfaceForOutstandingCharge(String otsIfSeq) throws DAOException {
		DBRowSet dbRowset = null;
		AROutstandingChgVO arOutstandingChgVO = null;
		List<AROutstandingChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ots_if_seq", otsIfSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchInterfaceForOutstandingChargeRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingChgVO .class);
			
			if (list != null && list.size() > 0) {
				arOutstandingChgVO = (AROutstandingChgVO) list.get(0);
			} 
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arOutstandingChgVO;
	}		
	
	/**
	 * Update to SAR_OTS_IF<br>
	 * @param String otsIfSeq
	 * @param String otsIfFlg
	 * @exception DAOException
	 */	 
	public void modifyOTSInterfaceFlag (String otsIfSeq, String otsIfFlg) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ots_if_seq", otsIfSeq);	
			mapVO.put("ots_if_flg", otsIfFlg);	
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOModifyOTSInterfaceFlagUSQL(), param, velParam);
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
	 * @param LedgerCombinationCondVO legrCmbCondVO
	 * @exception DAOException
	 */	 
	public void addLedgerCombination (LedgerCombinationCondVO legrCmbCondVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = legrCmbCondVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOAddLedgerCombinationCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * Search Outstanding view accounting
	 * @author jinyoonoh 2014. 7. 16.
	 * @param OTSViewAccountingListVO vo
	 * @return List<OTSViewAccountingListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OTSViewAccountingListVO> searchOTSViewAccountingList(OTSViewAccountingListVO vo) throws DAOException {
			
		DBRowSet dbRowset = null;
		List<OTSViewAccountingListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new AccountReceivableOutstandingDBDAOSearchOTSViewAccountingListRSQL(),param, velParam);							
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,OTSViewAccountingListVO.class);
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
	 * Search ASA Exchange Rate Gain/Loss, Round Account<br>
	 * 
	 * @param ASAAccountCondVO asaAccountCondVO
	 * @return LedgerCombinationCondVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public LedgerCombinationCondVO searchASAAccount(ASAAccountCondVO asaAccountCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		LedgerCombinationCondVO ledgerCombinationCondVO = null;
		List<LedgerCombinationCondVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = asaAccountCondVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchASAAccountRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LedgerCombinationCondVO .class);
			
			if (list != null && list.size() > 0) {
				ledgerCombinationCondVO = (LedgerCombinationCondVO) list.get(0);
			} 
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ledgerCombinationCondVO;
	}		
	
	/**
	 * Search ASA Revenue Amount<br>
	 * 
	 * @param String adjNo
	 * @param String blCurrCd
	 * @param String xchRtDt
	 * @param String asaCurrCd
	 * @param String funcCurrCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchASARevenueAmount(String adjNo, String blCurrCd, String xchRtDt, String asaCurrCd, String funcCurrCd) throws DAOException {
		DBRowSet dbRowset = null;
		String revAmt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("adj_no", adjNo);
			mapVO.put("bl_curr_cd", blCurrCd);
			mapVO.put("xch_rt_dt", xchRtDt);
			mapVO.put("asa_curr_cd", asaCurrCd);
			mapVO.put("func_curr_cd", funcCurrCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchASARevenueAmountRSQL(), param, velParam);											
			
			if(dbRowset.next()){
				revAmt = dbRowset.getString("rev_amt");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return revAmt;
	}
	
	/**
	 * Search Payment Request Letter email history Sequence<br>
	 * 
     * @author myoungsin park
     * @category STM_SAR_1005
     * @category searchPaymentRequestLetterHisSeq
     * @return String
     * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchPaymentRequestLetterHisSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String arEmlHisSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterHisSeqRSQL(), param, velParam);											
			if(dbRowset.next()){
				arEmlHisSeq = dbRowset.getString("stmt_his_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arEmlHisSeq;
	}
	
	/**
	 * addPaymentRequestLetterHisHdr
	 * @author myoungsin park 2014. 11. 18 
	 * @param PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO
	 * @exception DAOException
	 */
	public void addPaymentRequestLetterHisHdr(PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO) throws DAOException {
		//query parameter  
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;				 	
		
		try {   
			Map<String, String> mapVO = paymentRequestLetterByEmailFaxVO.getColumnValues();
				
			param.putAll(mapVO);       
			velParam.putAll(mapVO);     
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOaddPaymentRequestLetterHisHdrCSQL(), param, velParam);
		     		
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to insert addPaymentRequestLetterHisHdr");  
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
	}
	
	/**
	 * modifyPaymentRequestLetterHisHdr
	 * @author myoungsin park 2014. 11. 18 
	 * @param String arEmlHisSeq
	 * @exception DAOException
	 */
	public void modifyPaymentRequestLetterHisHdr(String arEmlHisSeq) throws DAOException {
		//query parameter  
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;				 	
		
		try {   
			Map<String, String> mapVO = new HashMap<String, String>(); 
			mapVO.put("stmt_his_seq", arEmlHisSeq);
			param.putAll(mapVO);       
			velParam.putAll(mapVO);        
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOmodifyPaymentRequestLetterHisHdrUSQL(), param, velParam);
		     		
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to insert modifyPaymentRequestLetterHisHdr");  
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
	}
	
	/**
	 * addPaymentRequestLetterHisDtl
	 * @author myoungsin park 2014. 11. 18 
	 * @param List<PaymentRequestLetterByEmailFaxVO> paymentRequestLetterByEmailFaxVOS
	 * @exception DAOException
	 */
	public void addPaymentRequestLetterHisDtl(List<PaymentRequestLetterByEmailFaxVO> paymentRequestLetterByEmailFaxVOS)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (paymentRequestLetterByEmailFaxVOS.size() > 0) {
				insCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new AccountReceivableOutstandingDBDAOaddPaymentRequestLetterHisDtlCSQL(),
								paymentRequestLetterByEmailFaxVOS, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to AccountReceivableOutstandingDBDAOaddSarIFDataCSQL insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
     * Payment Request Letter<br><br>
     * 
     * @author YJLEE
     * @category STM_SAR_1005
     * @category searchPaymentRequestLetter
     * @param PaymentRequestLetterVO paymentRequestLetterVO      
     * @return List<PaymentRequestLetterVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PaymentRequestLetterVO> searchPaymentRequestLetterCustomer(PaymentRequestLetterVO paymentRequestLetterVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PaymentRequestLetterVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
       try {	
    	   if(paymentRequestLetterVO != null){
				Map<String, String> mapVO = paymentRequestLetterVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if(paymentRequestLetterVO.getAgnOfcCdText().length()>0){
					 List<String> colOfcs = new ArrayList<String>();     
					 String[] arrColOfcs =  paymentRequestLetterVO.getAgnOfcCdText().split(",");
					 for(int i = 0; i < arrColOfcs.length; i ++){         
						 colOfcs.add(arrColOfcs[i]);           
					 }     
					 velParam.put("colOfcs", colOfcs);
   				}
			}
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterCustomerRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentRequestLetterVO.class);             
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
	 * search PaymentRequestLetterHistory<br>
	 * 
	 * @param PaymentRequestLetterHisVO paymentRequestLetterHisVO
	 * @return List<PaymentRequestLetterHisVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentRequestLetterHisVO> searchPaymentRequestLetterHistory(PaymentRequestLetterHisVO paymentRequestLetterHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PaymentRequestLetterHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = paymentRequestLetterHisVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterHistoryRSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentRequestLetterHisVO .class);
		
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
   	 * search SCO_BAT_HIS seq. <br>
   	 *
   	 * @return String
   	 * @exception DAOException
   	 */ 
   	 public String searchBatHisSeqData() throws DAOException{
   	 	DBRowSet dbRowset = null;    
   	 	String returnVal = "";
   	 	Map<String, Object> param = new HashMap<String, Object>();
   	 	//velocity parameter
   	 	Map<String, Object> velParam = new HashMap<String, Object>();
   	 	
   	 	try{
   	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchBatHisSeqDataRSQL(), param, velParam);
   	 		if(dbRowset.next()){
   	 			returnVal = dbRowset.getString("SEQ");
   	 		}
   	 	}catch(SQLException se){
   	 		log.error(se.getMessage(),se); 
   	 		throw new DAOException(new ErrorHandler(se).getMessage());
   	 	}catch(Exception ex){
   	 		log.error(ex.getMessage(),ex);  	
   	 		throw new DAOException(new ErrorHandler(ex).getMessage());
   	 	}    
   	 	return returnVal;
   	 }
   	 
   	/**
	 * Insert into SCO_BAT_HIS <br>
	 * @author myoungsin park 
	 * @param BatHisVO paramVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBatHis(BatHisVO paramVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = paramVO.getColumnValues();		
			
			param.putAll(mapVO); 
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOaddBatHisCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}  
    
	/**
	 * Search Outstanding Header Info<br>
	 * 
	 * @param AROutstandingCheckVO arOutstandingCheckVO
	 * @return AROutstandingHdrVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AROutstandingHdrVO searchOTSHeaderInfo(AROutstandingCheckVO arOutstandingCheckVO) throws DAOException {
		DBRowSet dbRowset = null;
		AROutstandingHdrVO arOutstandingHdrVO = null;
		List<AROutstandingHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = arOutstandingCheckVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchOTSHeaderInfoRSQL(), param, velParam);	
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AROutstandingHdrVO .class);
			
			if (list != null && list.size() > 0) {
				arOutstandingHdrVO = (AROutstandingHdrVO) list.get(0);
			} 
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arOutstandingHdrVO;
	}
	
	/**
	 * Update INV Exrate<br>
	 * @param AROutstandingHdrVO arOutstandingHdrVO
	 * @exception DAOException
	 */	 
	public void modifyOTSHeaderINVExrate (AROutstandingHdrVO arOutstandingHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = arOutstandingHdrVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOModifyOTSHeaderINVExrateUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Insert/Update to BKG_OUTSTANDING<br>
	 * @param AROutstandingHdrVO arOutstandingHdrVO
	 * @exception DAOException
	 */	 
	public void modifyBKGOutstanding (AROutstandingHdrVO arOutstandingHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = arOutstandingHdrVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOModifyBKGOutstandingUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Insert into SAR_OTS_RCT_TMP<br>
	 * @param List<SarOtsRctTmpVO> sarOtsRctTmpVOs
	 * @exception DAOException
	 */	 
	 
	public void addOutstandingReceiptTemp (List<SarOtsRctTmpVO> sarOtsRctTmpVOs) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(sarOtsRctTmpVOs.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingDBDAOAddOutstandingReceiptTempCSQL(), sarOtsRctTmpVOs, null);
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
	 * Search Outstanding Receipt Temp Sequence<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOutstandingReceiptTempSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String otsRctTmpSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOSearchOutstandingReceiptTempSeqRSQL(), param, velParam);											
			if(dbRowset.next()){
				otsRctTmpSeq = dbRowset.getString("ots_rct_tmp_seq");
			}
		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return otsRctTmpSeq;
	}	
	
	/**
	 * Delete SAR OUTSTANDING RECEIPT TEMP<br>
	 * @author sung yong park
	 * @param String otsRctTmpSeq
	 * @exception DAOException
	 */	 
	 
	public void removeOutstandingReceiptTemp (String otsRctTmpSeq) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ots_rct_tmp_seq", otsRctTmpSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAORemoveOutstandingReceiptTempDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Update SAR_OTS_DTRB REC GL_XX col  <br>
	 * @param OutstandingDtrbVO outstandingDtrbVO
	 * @exception DAOException
	 */	 
	public void modifyOtsDtrbForASAApproval(OutstandingDtrbVO outstandingDtrbVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = outstandingDtrbVO.getColumnValues();		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOmodifyOtsDtrbForASAApprovalUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * search OtsDtrb REV ASA<br>
	 * 
	 * @param OutstandingDtrbVO outstandingDtrbVO
	 * @return List<OutstandingDtrbVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OutstandingDtrbVO> searchOtsDtrbREVASA(OutstandingDtrbVO outstandingDtrbVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OutstandingDtrbVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = outstandingDtrbVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOsearchOtsDtrbREVASARSQL(), param, velParam);											
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OutstandingDtrbVO .class);
		
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
     * Update SAR_OTS_DTRB REV GL_XX col  <br>
     * @author myoung sin park
     * @param List<OutstandingDtrbVO> outstandingDtrbVOs
     * @throws DAOException
     */
	public void modifyOtsDtrbREVASAApproval(List<OutstandingDtrbVO> outstandingDtrbVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (outstandingDtrbVOs.size() > 0) {
				updCnt = sqlExe.executeBatch(new AccountReceivableOutstandingDBDAOmodifyOtsDtrbREVASAApprovalUSQL(), outstandingDtrbVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Check Outstanding History<br>
	 * 
	 * @param String ifNo
	 * @return Boolean
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Boolean checkOutstandingHist(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		Boolean flag = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingDBDAOCheckOutstandingHistRSQL(), param, velParam);											
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
	 * Search for VAT merge<br>
	 * 
	 * @param List<String> otsHisLists
	 * @return List<AROutstandingDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROutstandingHistVO> searchReFindSakuraIfNo(List<String> otsHisLists) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROutstandingHistVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ots_his_list", otsHisLists);
			velParam.put("ots_his_list", otsHisLists); 
					
			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableOutstandingDBDAOsearchReFindSakuraIfNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AROutstandingHistVO.class);

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
	 * Update OBL_ISS_OFC_CD to SAR_OTS_HDR<br>
	 * @param AROutstandingHdrVO arOutstandingHdrVO
	 * @exception DAOException
	 */	 
	public void modifyOBLIssueOffice (AROutstandingHdrVO arOutstandingHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = arOutstandingHdrVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOModifyOBLIssueOfficeUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * batch 가 running 상태일 경우, E로 update
	 * 
	 * @param batSeq
	 * @throws DAOException
	 */
	public void manageCancelBatLetterOFC(String batSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {

			param.put("bat_seq",batSeq);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingDBDAOManageBatLetterOFCUSQL(), param, null);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}