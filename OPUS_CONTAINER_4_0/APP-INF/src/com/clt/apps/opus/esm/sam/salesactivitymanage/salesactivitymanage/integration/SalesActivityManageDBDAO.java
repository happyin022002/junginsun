/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesActivityManageDBDAO.java
*@FileTitle : Sales Activity Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration.SalesRepInfoManageDAOsearchSRepNameRSQL;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.basic.SalesActivityManageBCImpl;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SRepInfoVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamActivityInfoVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamActivityInputVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamPFMCbyCustInputVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS SalesActivityManageDBDAO <br>
 * - OPUS-SalesActivityManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author LEEKUANSIAN
 * @see SalesActivityManageBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class SalesActivityManageDBDAO extends DBDAOSupport {
	
	/**
	 * ESM_SAM_0008<br>
	 * [Sheet1] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SRepInfoVO sRepInfoVO
	 * @return List<SRepInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SRepInfoVO> searchSalesReportInfo(SRepInfoVO sRepInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SRepInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sRepInfoVO != null){
				Map<String, String> mapVO = sRepInfoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesActivityManageDBDAOSearchSalesReportInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SRepInfoVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	
	/**
	 * ESM_SAM_0008<br>
	 * [Sheet1] 정보를 [변경 후 저장] 합니다.<br>
	 * 
	 * @param List<SRepInfoVO> sRepInfoVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifySalesReportInfo(List<SRepInfoVO> sRepInfoVOs) throws Exception{
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(sRepInfoVOs.size() > 0){
				Map<String, String> mapVO = sRepInfoVOs.get(0).getColumnValues();
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new SalesActivityManageDBDAOModifySalesReportInfoUSQL(), param, velParam);
	            if (result == Statement.EXECUTE_FAILED) {
	                throw new DAOException("Fail to update SQL");
	            }
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SAM_0008<br>
	 * [Sheet1] 정보를 [저장 시 ESM_SAM_0007화면의 Call Report 와 Actual date 값을 업데이트] 합니다.<br>
	 * 
	 * @param List<SRepInfoVO> sRepInfoVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCallFlgActDt(List<SRepInfoVO> sRepInfoVOs) throws Exception{
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(sRepInfoVOs.size() > 0){
				Map<String, String> mapVO = sRepInfoVOs.get(0).getColumnValues();
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new SalesActivityManageDBDAOModifyCallFlgActDtUSQL(), param, velParam);
	            if (result == Statement.EXECUTE_FAILED) {
	                throw new DAOException("Fail to update SQL");
	            }
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SAM_0008<br>
	 * [Sheet1] 정보를 [생성 후 저장] 합니다.<br>
	 * 
	 * @param List<SRepInfoVO> sRepInfoVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addSalesReportInfo(List<SRepInfoVO> sRepInfoVOs) throws Exception{
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(sRepInfoVOs.size() > 0){
				Map<String, String> mapVO = sRepInfoVOs.get(0).getColumnValues();
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new SalesActivityManageDBDAOAddSalesReportInfoCSQL(), param, velParam);
	            if (result == Statement.EXECUTE_FAILED) {
	                throw new DAOException("Fail to update SQL");
	            }
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * ESM_SAM_0008<br>
	 * [Sheet2] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SRepInfoVO sRepInfoVO
	 * @return List<SRepInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SRepInfoVO> searchCustSatisFaction(SRepInfoVO sRepInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SRepInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sRepInfoVO != null){
				Map<String, String> mapVO = sRepInfoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesActivityManageDBDAOSearchCustSatisFactionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SRepInfoVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
	
	/**
	 * ESM_SAM_0008<br>
	 * [Sheet2] 정보를 [변경 후 저장] 합니다.<br>
	 * 
	 * @param SRepInfoVO sRepInfoVOs
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyCustSatisFaction(SRepInfoVO sRepInfoVOs) throws Exception{
		//velocity parameter
		int modCnt = 0;
		try {
			if(sRepInfoVOs != null){
				Map<String, String> mapVO = sRepInfoVOs.getColumnValues();
				Map<String, String> velParams = sRepInfoVOs.getColumnValues();

				SQLExecuter sqlExe = new SQLExecuter("");
				modCnt = sqlExe.executeUpdate((ISQLTemplate)new SalesActivityManageDBDAOModifyCustSatisFactionUSQL(), mapVO, velParams);
				if(modCnt== Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to update No SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return modCnt;
	}

	
	/**
	 * ESM_SAM_0008<br>
	 * [Sheet2] 정보를 [생성 후 저장] 합니다.<br>
	 * 
	 * @param SRepInfoVO sRepInfoVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addCustSatisFaction(SRepInfoVO sRepInfoVOs) throws Exception{
		//velocity parameter
		int modCnt = 0;
		try {
			if(sRepInfoVOs != null){
				
				Map<String, String> mapVO = sRepInfoVOs.getColumnValues();
				Map<String, String> velParams = sRepInfoVOs.getColumnValues();

				SQLExecuter sqlExe = new SQLExecuter("");
				modCnt = sqlExe.executeUpdate((ISQLTemplate)new SalesActivityManageDBDAOAddCustSatisFactionCSQL(), mapVO, velParams);
				if(modCnt== Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert No SQL");
				}
			}
				
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_SAM_0901 : Retrieve<br>
	 * ESM_SAM_0007 : Retrieve<br>
	 * 
	 * @param SamActivityInputVO samActivityInputVO
	 * @return List<SamActivityInputVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SamActivityInputVO> searchSalesActivityList(SamActivityInputVO samActivityInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamActivityInputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(samActivityInputVO != null){
				Map<String, String> mapVO = samActivityInputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesActivityManageDBDAOSearchActivityInputRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SamActivityInputVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
 /**
 * ESM_SAM_0009 : Retrieve<br>
 * 
 * @param SamPFMCbyCustInputVO samPFMCbyCustInputVO
 * @return List<SamPFMCbyCustInputVO>
 * @exception DAOException
 */
 @SuppressWarnings("unchecked")
public List<SamPFMCbyCustInputVO> searchPFMCbyCustList(SamPFMCbyCustInputVO samPFMCbyCustInputVO) throws DAOException {
	DBRowSet dbRowset = null;
	List<SamPFMCbyCustInputVO> list = null;
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		if(samPFMCbyCustInputVO != null){
			Map<String, String> mapVO = samPFMCbyCustInputVO .getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesActivityManageDBDAOSearchPFMCbyCustInputRSQL(), param, velParam);
		list = (List)RowSetUtil.rowSetToVOs(dbRowset, SamPFMCbyCustInputVO.class);
	} catch(SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	} catch(Exception ex) {
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return list;
}

 /**
	 * ESM_SAM_0007 : Save<br>
	 * 
	 * @param List<SamActivityInfoVO> samActivityInfoVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifySalesActivityInfo(List<SamActivityInfoVO> samActivityInfoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(samActivityInfoVOs .size() > 0){
				int[] updCnt = sqlExe.executeBatch((ISQLTemplate)new SalesActivityManageDBDAOModifyActivityInfoUSQL(), samActivityInfoVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	 /**
	 * ESM_SAM_0007 : Insert<br>
	 * 
	 * @param List<SamActivityInfoVO> samActivityInfoVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addSalesActivityInfo(List<SamActivityInfoVO> samActivityInfoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(samActivityInfoVOs .size() > 0){
				int[] updCnt = sqlExe.executeBatch((ISQLTemplate)new SalesActivityManageDBDAOAddActivityInfoCSQL(), samActivityInfoVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_SAM_0007 : SELECT <br>
	 * [ON_CHANGE] CUS_CODE
	 * 
	 * @param SamActivityInfoVO samActivityInfoVO
	 * @return String      
	 * @exception DAOException
	 */
	public String searchCustName(SamActivityInfoVO samActivityInfoVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String repInfo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (samActivityInfoVO != null) {

				param.put("cus_code", samActivityInfoVO.getCusCode());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SalesActivityManageDBDAOSearchCustNameRSQL(), param, velParam);
			if (dbRowset.next())
				repInfo = dbRowset.getString("CUS_NAME");
						

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repInfo;
	}
	
	/**
	 * ESM_SAM_0007 : SELECT <br>
	 * [ON_CHANGE] CUS_CODE
	 * 
	 * @param SamActivityInfoVO samActivityInfoVO
	 * @return String           
	 * @exception DAOException
	 */
	public String searchSrepsManageCustList(SamActivityInfoVO samActivityInfoVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String repInfo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (samActivityInfoVO != null) {
				param.put("sls_code", samActivityInfoVO.getSlsCode());
				param.put("cus_code", samActivityInfoVO.getCusCode());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SalesActivityManageDBDAOsearchSrepsManageCustListRSQL(), param, velParam);
			if (dbRowset.next())
				repInfo = dbRowset.getString("CUS_CODE");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repInfo;
	}
	
	 /**
	 * ESM_SAM_0008 : SELECT <br>
	 * [ON_CHANGE] SalesRepName
	 * 
	 * @param SRepInfoVO sRepInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchSalesRepName(SRepInfoVO sRepInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String repInfo = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sRepInfoVO != null) {
				param.put("srep_cd", sRepInfoVO.getSrepCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SalesRepInfoManageDAOsearchSRepNameRSQL(),param, velParam);
			if (dbRowset.next()) repInfo = dbRowset.getString("srep_nm");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return repInfo;
	}
}