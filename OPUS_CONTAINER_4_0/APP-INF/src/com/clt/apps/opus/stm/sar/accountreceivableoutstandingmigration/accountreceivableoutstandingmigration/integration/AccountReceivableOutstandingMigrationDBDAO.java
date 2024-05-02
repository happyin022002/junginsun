/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountReceivableOutstandingMigrationDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingHeaderRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingDetailRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingHistRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingChargeRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchOutstandingRevTypeRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOCheckOutstandingHeaderRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOAddOutstandingDetailCSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOAddOutstandingHeaderCSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOCheckOutstandingDetailRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOModifyOutstandingDetailUSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOModifyOutstandingHeaderUSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOModifyOTSSettleFlagUSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOModifyOTSHeaderINVExrateUSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOModifyOutstandingHistInvNoUSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOModifyOutstandingChargeInvNoUSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOCheckOutstandingHistRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchOutstandingHistSeqRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOAddOutstandingHistCSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOAddOutstandingChargeCSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchLookupListRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchCurrencyCodeRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchRegionCenterRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchInterCompanyRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchOutstandingAccountRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchLedgerCombinationRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOAddLedgerCombinationCSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchAccountExrateRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchMDMChargeForAccountRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOModifyOTSChargeAcctMtxSeqUSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOAddOutstandingDistributionCSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOModifyOtsDtrbForASAApprovalUSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchOtsDtrbREVASARSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOModifyOtsDtrbREVASAApprovalUSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchASARevenueAmountRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.integration.AccountReceivableOutstandingMigrationDBDAOSearchASAAccountRSQL;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.basic.AccountReceivableOutstandingMigrationBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingChgVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingHistVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.AROutstandingCheckVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.LookupInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.CurrencyCodeVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.RegionCenterVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.OutstandingAccountCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.OutstandingAccountVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.LedgerCombinationCondVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.ARExrateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.OutstandingDtrbVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo.ASAAccountCondVO;
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
 * @see AccountReceivableOutstandingMigrationBCImpl
 * @since J2EE 1.4
 */
public class AccountReceivableOutstandingMigrationDBDAO extends DBDAOSupport { 
	 
	private static final long serialVersionUID = 1L;
	
	private String dataSource = "";
	/**
	 * AccountReceivableOutstandingMigrationDBDAO object creation<br>
	 * AccountReceivableOutstandingMigrationDBDAO creation<br>
	 */
	public AccountReceivableOutstandingMigrationDBDAO() { }
	
	
	/**
	 * AccountReceivableOutstandingMigrationDBDAO object creation<br>
	 * AccountReceivableOutstandingMigrationDBDAO creation<br>
	 * @param String dataSource
	 */
	public AccountReceivableOutstandingMigrationDBDAO(String dataSource) {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingHeaderRSQL(), param, velParam);											
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingDetailRSQL(), param, velParam);											
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingHistRSQL(), param, velParam);											
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchINVForOutstandingChargeRSQL(), param, velParam);											
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchOutstandingRevTypeRSQL(), param, velParam);											
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOCheckOutstandingHeaderRSQL(), param, velParam);											
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
	 * Insert into SAR_OTS_DTL<br>
	 * @param List<AROutstandingDtlVO> arOutstandingDtlVO
	 * @exception DAOException
	 */	 
	public void addOutstandingDetail (List<AROutstandingDtlVO> arOutstandingDtlVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(arOutstandingDtlVO.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOAddOutstandingDetailCSQL(), arOutstandingDtlVO, null);
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
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOAddOutstandingHeaderCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOCheckOutstandingDetailRSQL(), param, velParam);											
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
	 * Update to SAR_OTS_DTL<br>
	 * @param List<AROutstandingDtlVO> arOutstandingDtlVO
	 * @exception DAOException
	 */	 
	public void modifyOutstandingDetail (List<AROutstandingDtlVO> arOutstandingDtlVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(arOutstandingDtlVO.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOModifyOutstandingDetailUSQL(), arOutstandingDtlVO, null);
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
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOModifyOutstandingHeaderUSQL(), param, velParam);
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
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOModifyOTSSettleFlagUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
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
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOModifyOTSHeaderINVExrateUSQL(), param, velParam);
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
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOModifyOutstandingHistInvNoUSQL(), arOutstandingHistVO, null);
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
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOModifyOutstandingChargeInvNoUSQL(), arOutstandingChgVO, null);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOCheckOutstandingHistRSQL(), param, velParam);											
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
	 * Search Outstanding History Sequence<br>
	 * 
	 * @param String hisCnt
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchOutstandingHistSeq(String hisCnt) throws DAOException {
		DBRowSet dbRowset = null;
		String otsHisSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("his_cnt", hisCnt);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchOutstandingHistSeqRSQL(), param, velParam);											
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
	 * Insert into SAR_OTS_HIS<br>
	 * @param List<AROutstandingHistVO> arOutstandingHistVO
	 * @exception DAOException
	 */	 
	public void addOutstandingHist (List<AROutstandingHistVO> arOutstandingHistVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(arOutstandingHistVO.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOAddOutstandingHistCSQL(), arOutstandingHistVO, null);
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
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOAddOutstandingChargeCSQL(), arOutstandingChgVO, null);
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
	 * [COMMON Lookup Code]
	 * [lookup code]- 紐⑸줉��議고쉶<br>
	 *
	 * @param String lu_tp_cd
	 * @return List<LookupInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LookupInfoVO> searchLookupList(String lu_tp_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<LookupInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (lu_tp_cd != null) {
				param.put("lu_tp_cd", lu_tp_cd);
				velParam.put("lu_tp_cd", lu_tp_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchLookupListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LookupInfoVO.class);
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
	 * Search Currency Code List<br>
	 *
	 * @param String currCd
	 * @return List<CurrencyCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CurrencyCodeVO> searchCurrencyCode(String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CurrencyCodeVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("curr_cd", currCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableOutstandingMigrationDBDAOSearchCurrencyCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CurrencyCodeVO .class);

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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchRegionCenterRSQL(), param, velParam);											
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchInterCompanyRSQL(), param, velParam);											
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchOutstandingAccountRSQL(), param, velParam);											
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchLedgerCombinationRSQL(), param, velParam);											
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
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOAddLedgerCombinationCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Search Account exchange rate<br>
	 *
	 * @param ARExrateVO arExrateVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchAccountExrate(ARExrateVO arExrateVO) throws DAOException {
		DBRowSet dbRowset = null;
		String exrate = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = arExrateVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new AccountReceivableOutstandingMigrationDBDAOSearchAccountExrateRSQL(), param, velParam);
			if(dbRowset.next()){
				exrate = dbRowset.getString("exrate");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return exrate;
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchMDMChargeForAccountRSQL(), param, velParam);											
			
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
	 * Update account matrix sequence to SAR_OTS_CHG<br>
	 * @param List<AROutstandingChgVO> arOutstandingChgVO
	 * @exception DAOException
	 */	 
	public void modifyOTSChargeAcctMtxSeq (List<AROutstandingChgVO> arOutstandingChgVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(arOutstandingChgVO.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOModifyOTSChargeAcctMtxSeqUSQL(), arOutstandingChgVO, null);
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
	 * Insert into SAR_OTS_DTRB<br>
	 * @param List<OutstandingDtrbVO> outstandingDtrbVO
	 * @exception DAOException
	 */	 
	public void addOutstandingDistribution (List<OutstandingDtrbVO> outstandingDtrbVO) throws DAOException,Exception {
		try {	
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(outstandingDtrbVO.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOAddOutstandingDistributionCSQL(), outstandingDtrbVO, null);
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
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOModifyOtsDtrbForASAApprovalUSQL(), param, velParam);
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
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchOtsDtrbREVASARSQL(), param, velParam);											
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
				updCnt = sqlExe.executeBatch(new AccountReceivableOutstandingMigrationDBDAOModifyOtsDtrbREVASAApprovalUSQL(), outstandingDtrbVOs, null);
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchASARevenueAmountRSQL(), param, velParam);											
			
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableOutstandingMigrationDBDAOSearchASAAccountRSQL(), param, velParam);											
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
	
}