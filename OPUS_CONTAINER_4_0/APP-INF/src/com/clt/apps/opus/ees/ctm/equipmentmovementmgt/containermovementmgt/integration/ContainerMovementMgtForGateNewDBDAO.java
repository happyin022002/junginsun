/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgt2DBDAO.java
*@FileTitle : DBDAO for GATE NEW
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.07.06 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CtmMvmtEdiBkgVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDICtmEqMvmtListVO;

 
/**
 * OPUS ContainerMovementMgtDBDAO <br>
 * - OPUS-EquipmentMovementMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see ContainerMovementMgt2BCImpl 참조
 * @since J2EE 1.6
 */
public class ContainerMovementMgtForGateNewDBDAO extends DBDAOSupport {
	
	/**
	 * MDM_YARD 테이블에 존재하는 YD_CD SELECT 한다.<br>
	 *
	 * @param String event yard
	 * @return String
	 * @throws DAOException
	 */  
	public String getMdmYardYdCd(String event_yard) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("event_yard", event_yard);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetMdmYardYdCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("EVENT_YARD");
			} else{
				rtnValue = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/** selectEDIBkgBlMvmt
	 * 
	 * @param bkgNo
	 * @param blNo
	 * @return String
	 * @throws DAOException
	 */
	public int selectEDIBkgBlMvmtCnt(String bkgNo, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnValue = 0;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bl_no", blNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSelectEDIBkgBlMvmtCntRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getInt("CNT");
			} else{
				rtnValue = 0;
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * insertEDIBkgBlMvmt for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertEDIBkgBlMvmt(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();
			
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOInsertBkgBlMvmtCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * updateEDIBkgBlMvmt for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateEDIBkgBlMvmt(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOUpdateBkgBlMvmtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * deleteEDIBkgBlMvmt for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteEDIBkgBlMvmt(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAODeleteBkgBlMvmtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * insertEDIDomBkgMvmt for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertEDIDomBkgMvmt(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOInsertEDIDomBkgMvmtCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * updateEDIDomBkgMvmt for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateEDIDomBkgMvmt(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOUpdateEDIDomBkgMvmtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * deleteEDIDomBkgMvmt for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteEDIDomBkgMvmt(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAODeleteEDIDomBkgMvmtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** selectEDIEppMvmt for EppBookingNew<br>
	 * 
	 * @param String bkgNo
	 * @return int
	 * @throws DAOException
	 */
	public int selectEDIEppMvmt(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnValue = 0;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSelectEDIEppMvmtRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getInt("CNT");
			} else{
				rtnValue = 0;
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/** selectEDIDmstMvmt for EppBookingNew<br>
	 * 
	 * @param String bkgNo
	 * @return int
	 * @throws DAOException
	 */
	public int selectEDIDmstMvmt(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnValue = 0;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSelectEDIDmstMvmtRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getInt("CNT");
			} else{
				rtnValue = 0;
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/** selectEDIEppMvmt for EppBookingNew<br>
	 * 
	 * @param String bkgNo 
	 * @param String cntrNo
	 * @return int
	 * @throws DAOException
	 */	
	public int selectEDIEppMvmt(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnValue = 0;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSelectEDICtmBkgCntrRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getInt("CNT");
			} else{
				rtnValue = 0;
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	/**
	 * insertEDIEppMvmt for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertEDIEppMvmt(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOInsertEDIEccMvmtCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * updateEDIEppMvmt for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateEDIEppMvmt(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOUpdateEDIEccMvmtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * deleteEDIEppMvmt for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteEDIEppMvmt(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAODeleteEDIEccMvmtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * insertEDICtmErrLog for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @param String errMsg
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertEDICtmErrLog(SearchEDICtmEqMvmtListVO ediCtmEqVO, String errMsg) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			
			param.put("brg_tp_id", ediCtmEqVO.getBrgTpId());
			param.put("bkg_no", ediCtmEqVO.getBkgNo());
			param.put("bl_no", ediCtmEqVO.getBlNo());
			param.put("cntr_no", ediCtmEqVO.getCntrNo());
			param.put("vsl_cd", ediCtmEqVO.getVslCd());
			param.put("skd_voy_no", ediCtmEqVO.getSkdVoyNo());
			param.put("skd_dir_cd", ediCtmEqVO.getSkdDirCd());
			param.put("err_msg", errMsg);
			param.put("dat_mnpl_cd", ediCtmEqVO.getDatMnplCd());
			
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOInsertEDICtmErrLogCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** selectEDICtmBkgCntr
	 * 
	 * @param bkgNo
	 * @param cntrNo
	 * @return
	 * @throws DAOException
	 */
	public int selectEDICtmBkgCntr(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnValue = 0;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSelectEDICtmBkgCntrRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getInt("CNT");
			} else{
				rtnValue = 0;
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/** checkContainerStatus
	 * 
	 * @param cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String checkContainerStatus(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckContainerStatusRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("RESULT");
			} else{
				rtnValue = "0";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * insertEDICtmBkgCntr for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertEDICtmBkgCntr(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOInsertEDIBkgEppCntrCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * insertEDICtmBkgCntrWithoutCycNo for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertEDICtmBkgCntrWithoutCycNo(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOInsertEDIBkgEppCntrWithoutCycNoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** updateVLVvd
	 * 
	 * @param ediCtmEqVO
	 */
	public void updateVLVvd(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtForGateNewDBDAOUpdateVLVvdUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		

	/** updateEDICtmBkgCntr
	 * 
	 * @param ediCtmEqVO
	 */
	public void updateEDICtmBkgCntr(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOUpdateEDIBkgEppCntrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/** deleteEDICtmBkgCntr
	 * 
	 * @param ediCtmEqVO
	 */
	public void deleteEDICtmBkgCntr(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAODeleteEDIBkgEppCntrDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/** selectEDICtmBkgVvd
	 * 
	 * @param bkgNo
	 * @param vslPrePstCd
	 * @param vslSeq
	 * @return int
	 * @throws DAOException
	 */
	public int selectEDICtmBkgVvd(String bkgNo, 	String vslPrePstCd, String vslSeq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnValue = 0;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("vsl_pre_pst_cd", vslPrePstCd);
			mapVO.put("vsl_seq", vslSeq);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSelectEDICtmBkgVvdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getInt("CNT");
			} else{
				rtnValue = 0;
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * insertEDICtmBkgVvd for EppBookingNew<br>
	 *
	 * @param SearchEDICtmEqMvmtListVO ediCtmEqVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertEDICtmBkgVvd(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOInsertEDICtmBkgVvdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** updateEDICtmBkgVvd
	 * 
	 * @param ediCtmEqVO
	 */
	public void updateEDICtmBkgVvd(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOUpdateEDICtmBkgVvdUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/** deleteEDICtmBkgVvd
	 * 
	 * @param ediCtmEqVO
	 */
	public void deleteEDICtmBkgVvd(SearchEDICtmEqMvmtListVO ediCtmEqVO) {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ediCtmEqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAODeleteEDICtmBkgVvdDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			insertEDICtmErrLog(ediCtmEqVO, se.toString());
			//throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			insertEDICtmErrLog(ediCtmEqVO, ex.toString());
			//throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * decideStatus for GateNew<br>
	 *
	 * @param String fullStsCd
	 * @param String gateIo
	 * @param String msgTpId
	 * @param String sightCd
	 * @return String
	 * @throws DAOException
	 */
	public String decideStatus(String fullStsCd, String gateIo, String msgTpId, String sightCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = null;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("full_sts_cd", fullStsCd);
			mapVO.put("gate_io", gateIo);
			mapVO.put("msg_tp_id", msgTpId);
			mapVO.put("sight_cd", sightCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAODecideStatusForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("SET_MVMTSTATUS");
			} else{
				rtnValue = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * getVendorSeq for GateNew<br>
	 * Vendor Seq 가져오기<br>
	 *
	 * @param String UsaEdiCd
	 * @return String
	 * @throws DAOException
	 */
	public String getVendorSeq(String UsaEdiCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = null;
		try{
			if(UsaEdiCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("usa_edi_cd", UsaEdiCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetVendorSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("VNDR_SEQ");
			} else{
				rtnValue = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * defineChssCode for GateNew<br>
	 * Chssis Code Adjustment<br>
	 *
	 * @param String chssCode
	 * @return String
	 * @throws DAOException
	 */
	public String defineChssCode(String chssCode) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = null;
		try{
			if(chssCode != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("chss_code", chssCode);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAODefineChssCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("CHSS_CODE");
			} else{
				rtnValue = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * getEqNo for GateNew<br>
	 * Chssis Code로 EQ No 가져오기<br>
	 *
	 * @param String chssAlsNo
	 * @return String
	 * @throws DAOException
	 */
	public String getEqNo(String chssAlsNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = null;
		try{
			if(chssAlsNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("chss_als_no", chssAlsNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetEqNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("EQ_NO");
			} else{
				rtnValue = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * getOfcCd for GateNew<br>
	 * MDM_YARD테이블에서 OfcCd 가져오기<br>
	 *
	 * @param String eventYard
	 * @return String
	 * @throws DAOException
	 */
	public String getOfcCd(String eventYard) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = null;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("yd_cd", eventYard);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetOfcCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("OFC_CD");
			} else{
				rtnValue = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * getBookingInfo for GateNew<br>
	 * Booking 상세정보 가져오기
	 *
	 * @param String bkgNumber
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getBookingInfo(String bkgNumber) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnValue = new String[5];
		try{
			if(bkgNumber != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bkg_number", bkgNumber);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetBookingInfoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("BKG_STS");
				rtnValue[1] = dbRowset.getString("BKG_SPLIT_IND");
				rtnValue[2] = dbRowset.getString("BKG_COM_NO");
				rtnValue[3] = dbRowset.getString("BKG_LENGTH");
				rtnValue[4] = dbRowset.getString("BKG_CRE_TP_CD");
			} else {
				rtnValue[0] = "";
				rtnValue[1] = "";
				rtnValue[2] = "";
				rtnValue[3] = "";
				rtnValue[4] = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * getFromBkgNo for GateNew<br>
	 * From Booking 가져오기
	 *
	 * @param String bkgNumber
	 * @return String
	 * @throws DAOException
	 */
	public String getFromBkgNo(String bkgNumber) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			if(bkgNumber != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bkg_number", bkgNumber);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetFromBkgNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("FROM_BKG");
			} else {
				rtnValue = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/** searchBookingRoute
	 * 
	 * @param bkgNumber
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchBookingRoute(String bkgNumber) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnValue = new String[5];
		try{
			if(bkgNumber != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bkg_number", bkgNumber);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtForGateNewDBDAOSearchBookingRouteRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("POR_CD");
				rtnValue[1] = dbRowset.getString("POL_CD");
				rtnValue[2] = dbRowset.getString("POD_CD");
				rtnValue[3] = dbRowset.getString("DEL_CD");
				
			} else {
				rtnValue[0] = "";
				rtnValue[1] = "";
				rtnValue[2] = "";
				rtnValue[3] = "";
				
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * getBkgNo for GateNew<br>
	 *
	 * @param String cntrNo
	 * @param String bkgNumber
	 * @return String
	 * @throws DAOException
	 */
	public String getBkgNo(String cntrNo, String bkgNumber) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = null;
		try{
			if(cntrNo != null && bkgNumber != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("cntr_no", cntrNo);
				mapVO.put("bkg_number", bkgNumber);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetBkgNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("BKG_NO");
			} else{
				rtnValue = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * getVslCd for GateNew<br>
	 *
	 * @param String callSignNo
	 * @param String lloydNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getVslCd(String callSignNo, String lloydNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] returnValues = new String[3];
		returnValues[0] = "";
		returnValues[1] = "";
		returnValues[2] = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("call_sgn_no", callSignNo);
			mapVO.put("lloyd_no", lloydNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetVslCdForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				dbRowset.first();
				for (int i=0; i<dbRowset.getRowCount(); i++) {
					returnValues[i] = dbRowset.getString("VSL_CD");
					dbRowset.next();
				}
			} else {
				returnValues[0] = "";
				returnValues[1] = "";
				returnValues[2] = "";
			}

		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValues;
	}

	/**
	 * getVslCd with Vessel Name for GateNew<br>
	 *
	 * @param String vslEngNm
	 * @return String
	 * @throws DAOException
	 */
	public String getVslCd(String vslEngNm) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String returnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_eng_nm", vslEngNm);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetVslCdWithVslNmForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("VSL_CD");
			} else {
				returnValue = "";
			}

		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * getOscarVslCd for GateNew<br>
	 *
	 * @param String vslCd
	 * @return String
	 * @throws DAOException
	 */
	public String getOscarVslCd(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String returnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetOscarVslCdForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("VSL_CD");
			} else {
				returnValue = "";
			}

		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * getOscaBkgFlg for GateNew<br>
	 *
	 * @param String cntrNo
	 * @param String maxCycleNo
	 * @return String
	 * @throws DAOException
	 */
	public String[] getOscaBkgFlg(String cntrNo, String maxCycleNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String returnValue[] = new String[1];
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("max_cycle_no", maxCycleNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetOscaBkgFlgRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("BKG_NO");
			} else {
				returnValue[0] = "";
			}

		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * getOPUSBkgFlg for GateNew<br>
	 *
	 * @param String cntrNo
	 * @param String cnmvCycNo
	 * @return String
	 * @throws DAOException
	 */
	public String getOPUSBkgFlg(String cntrNo, String cnmvCycNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String returnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("cnmv_cyc_no", cnmvCycNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetOPUSBkgFlgRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("BKG_NO");
			} else {
				returnValue = "";
			}

		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * getVvdCdByVL for GateNew<br>
	 * VSK_VSL_PORT_SKD, VSK_VSL_SKD 테이블에서 VVD_CD가져오기<br>
	 *
	 * @param String eventDate
	 * @param String eventYard
	 * @param String vslCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getVvdCdByVL(String eventDate, String eventYard, String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnValue = new String[3];
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("event_date", eventDate);
			mapVO.put("event_yard", eventYard);
			mapVO.put("vsl_cd", vslCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetVvdCdByVLForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("VSL_CD") + "";
				rtnValue[1] = dbRowset.getString("SKD_VOY_NO") + "";
				rtnValue[2] = dbRowset.getString("SKD_DIR_CD") + "";
			} else {
				rtnValue[0] = "";
				rtnValue[1] = "";
				rtnValue[2] = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * getVvdCdByVD for GateNew<br>
	 * VSK_VSL_PORT_SKD, VSK_VSL_SKD SKD 테이블에서 VVD_CD가져오기<br>
	 *
	 * @param String eventDate
	 * @param String eventYard
	 * @param String vslCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getVvdCdByVD(String eventDate, String eventYard, String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnValue = new String[3];
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("event_date", eventDate);
			mapVO.put("event_yard", eventYard);
			mapVO.put("vsl_cd", vslCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetVvdCdByVDForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("VSL_CD") + "";
				rtnValue[1] = dbRowset.getString("SKD_VOY_NO") + "";
				rtnValue[2] = dbRowset.getString("SKD_DIR_CD") + "";
			} else {
				rtnValue[0] = "";
				rtnValue[1] = "";
				rtnValue[2] = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * getVvdCd for GateNew<br>
	 * BKG_VVD 테이블에서 VVD_CD가져오기<br>
	 *
	 * @param String bkgNumber
	 * @param String gateIoCd
	 * @param String eventYard
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getVvdCd(String bkgNumber, String gateIoCd, String eventYard) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnValue = new String[3];
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_number", bkgNumber);
			mapVO.put("gate_io_cd", gateIoCd);
			mapVO.put("event_yard", eventYard);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetVvdCdForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("VSL_CD");
				rtnValue[1] = dbRowset.getString("SKD_VOY_NO");
				rtnValue[2] = dbRowset.getString("SKD_DIR_CD");
			} else {
				rtnValue[0] = "";
				rtnValue[1] = "";
				rtnValue[2] = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * getMtCntrBkgNo for GateNew<br>
	 * Empty VL, VD를 위한 Empty Container BKG을 가져온다
	 *
	 * @param String cntrNo
	 * @param String gateIoCd
	 * @param String eventYard
	 * @param String bkgCgoTpCd
	 * @return String
	 * @throws DAOException
	 */
	public String getMtCntrBkgNo(String cntrNo, String gateIoCd, String eventYard, String bkgCgoTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = null;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("gate_io_cd", gateIoCd);
			mapVO.put("event_yard", eventYard);
			mapVO.put("bkg_cgo_tp_cd", bkgCgoTpCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetMtCntrBkgNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("BKG_NO");
			} else{
				rtnValue = "";
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	
	/**
	 * searchDomsticBooking for GateNew<br>
	 * Empty Container BKG을 가져온다
	 *
	 * @param String bkgNo
	 * @return Integer
	 * @throws DAOException
	 */
	public Integer searchDomsticBooking(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnValue = 0;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetDomsticBookingRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getInt("CNT");
			} else{
				rtnValue = 0;
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/** checkEdiMessage
	 * 	
	 * @param cntrNo
	 * @param evntYdCd
	 * @param evntDt
	 * @param ediGateIoCd
	 * @return int
	 * @throws DAOException
	 */
	public int checkEdiMessage(String cntrNo, String evntYdCd, String evntDt, String ediGateIoCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnValue = 0;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("evnt_yd_cd", evntYdCd);
			mapVO.put("evnt_dt", evntDt);
			mapVO.put("edi_gate_io_cd", ediGateIoCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtForGateNewDBDAOCheckEdiMessageRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getInt("CNT");
			} else{
				rtnValue = 0;
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * getBkgNoByBlNo for GateNew<br>
	 * ContainerMovementFinderDBDAOSearchMovementListByGetBkgNoVORSQL
	 *
	 * @param String blNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getBkgNoByBlNo(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] returnValue = new String[2];
		try{
			if(blNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bl_no", blNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetBkgNoByBlNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("BKG_NO");
				returnValue[1] = dbRowset.getString("BKG_STS_CD");
			} else {
				returnValue[0] = "";
				returnValue[1] = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * checkCombienBkgNo for GateNew<br>
	 *
	 * @param String bkgNumber
	 * @param String cntrNo
	 * @return Boolean
	 * @throws DAOException
	 */
	public Boolean checkCombienBkgNo(String bkgNumber, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean returnValue = false;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_number", bkgNumber);
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckCombienBkgNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getString("1").equals("1")) {
					returnValue = true;
				} else {
					returnValue = false;
				}
			} else{
				returnValue = false;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * getOldBkgNo for GateNew<br>
	 *
	 * @param String cntrNo
	 * @param String gateIoCd
	 * @return String
	 * @throws DAOException
	 */
	public String getOldBkgNo(String cntrNo, String gateIoCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String returnValue = null;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("gate_io_cd", gateIoCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetOldBkgNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("BKG_NO");
			} else{
				returnValue = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * getMaxCnmvCycNo for GateNew<br>
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String getMaxCnmvCycNo(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String returnValue = null;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetMaxCnmvCycNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("CNMV_CYC_NO");
			} else{
				returnValue = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * getCurrCnmvCycNo for GateNew<br>
	 *
	 * @param String bkgNumber
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String getCurrCnmvCycNo(String bkgNumber, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String returnValue = null;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			String oscaBkgFlg = bkgNumber.length()==10?"Y":"N";
			mapVO.put("bkg_number", bkgNumber);
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("osca_bkg_flg", oscaBkgFlg);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetCurrCnmvCycNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("CNMV_CYC_NO");
			} else{
				returnValue = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * getPreCnmvCycNo for GateNew<br>
	 *
	 * @param String cntrNo
	 * @param String gateIoCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getPreCnmvCycNo(String cntrNo, String gateIoCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String[] returnValue = new String[2];
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("gate_io_cd", gateIoCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetPreCnmvCycNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("BKG_NO");
				returnValue[1] = dbRowset.getString("CNMV_CYC_NO");
			} else {
				returnValue[0] = "";
				returnValue[1] = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * getCnmsCd for GateNew<br>
	 *
	 * @param String cntrNo
	 * @param String cnmvCycNo
	 * @param String eventYard
	 * @return String
	 * @throws DAOException
	 */
	public String getCnmsCd(String cntrNo, String cnmvCycNo, String eventYard) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String returnValue = null;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("cnmv_cyc_no", cnmvCycNo);
			mapVO.put("event_yard", eventYard);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetCnmsCdForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("MVMT_STS_CD");
			} else{
				returnValue = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * checkCnmvCycNo for GateNew<br>
	 *
	 * @param String cntrNo
	 * @param String cnmvCycNo
	 * @return Boolean
	 * @throws DAOException
	 */
	public Boolean checkCnmvCycNo(String cntrNo, String cnmvCycNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		boolean returnValue = false;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("cnmv_cyc_no", cnmvCycNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckCnmvCycNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getString("1").equals("1")) {
					returnValue = true;
				} else {
					returnValue = false;
				}
			} else{
				returnValue = false;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * checkVdCnmvCycNo for GateNew<br>
	 *
	 * @param String cntrNo
	 * @param String bkgNumber
	 * @return Boolean
	 * @throws DAOException
	 */
	public Boolean checkVdCnmvCycNo(String cntrNo, String bkgNumber) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		boolean returnValue = false;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			String oscaBkgFlg = bkgNumber.length()==10?"Y":"N";
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("bkg_number", bkgNumber);
			mapVO.put("osca_bkg_flg", oscaBkgFlg);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckVdCnmvCycNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getString("1").equals("1")) {
					returnValue = true;
				} else {
					returnValue = false;
				}
			} else{
				returnValue = false;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * checkPodCd for GateNew<br>
	 *
	 * @param String bkgNumber
	 * @param String podCd
	 * @return Boolean
	 * @throws DAOException
	 */
	public Boolean checkPodCd(String bkgNumber, String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		boolean returnValue = false;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_number", bkgNumber);
			mapVO.put("pod_cd", podCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckPodCdForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getString("1").equals("1")) {
					returnValue = true;
				} else {
					returnValue = false;
				}
			} else{
				returnValue = false;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * getEdiIdfromDual for GateNew<br>
	 *
	 * @param String msgId
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getEdiIdfromDual(String msgId) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String[] returnValue = new String[2];
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("msg_id", msgId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetEdiIdFromDualForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("EDI_ID");
				returnValue[1] = dbRowset.getString("MUID_DT");
			} else {
				returnValue[0] = "";
				returnValue[1] = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * getMaxMuidSeq for GateNew<br>
	 *
	 * @param String mvmtEdiTpCd
	 * @param String mvmtEdiMsgTpId
	 * @param String mvmtEdiMsgAreaCd
	 * @param String mvmtEdiMsgYrmondy
	 * @return String
	 * @throws DAOException
	 */
	public String getMaxMuidSeq(String mvmtEdiTpCd, String mvmtEdiMsgTpId, String mvmtEdiMsgAreaCd, String mvmtEdiMsgYrmondy) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String returnValue = null;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("mvmt_edi_tp_cd", mvmtEdiTpCd);
			mapVO.put("mvmt_edi_msg_tp_id", mvmtEdiMsgTpId);
			mapVO.put("mvmt_edi_msg_area_cd", mvmtEdiMsgAreaCd);
			mapVO.put("mvmt_edi_msg_yrmondy", mvmtEdiMsgYrmondy);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetMaxMuidSeqForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("MVMT_EDI_MSG_SEQ");
			} else{
				returnValue = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * insertEDIMessage for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertEDIMessage(FlatFileForGateNewVO flatFileForGateNewVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = flatFileForGateNewVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOInsertEDIMessageForGateNewCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * insertEDIBooking for GateNew<br>
	 *
	 * @param CtmMvmtEdiBkgVO ctmMvmtEdiBkgVo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertEDIBooking(CtmMvmtEdiBkgVO ctmMvmtEdiBkgVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = ctmMvmtEdiBkgVo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOInsertEDIBookingForGateNewCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * getLccSccForGateNew for GateNew<br>
	 *
	 * @param String dmstBkgNo
	 * @param String locCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getLccSccForGateNew(String dmstBkgNo, String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String[] returnValue = new String[4];
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("dmst_bkg_no", dmstBkgNo);
			mapVO.put("loc_cd", locCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetLccSccForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("DEL_SCC");
				returnValue[1] = dbRowset.getString("DEL_LCC");
				returnValue[2] = dbRowset.getString("EVENT_SCC");
				returnValue[3] = dbRowset.getString("EVENT_LCC");
			} else {
				returnValue[0] = "";
				returnValue[1] = "";
				returnValue[2] = "";
				returnValue[3] = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}	

	/**
	 * getAciacDivCd for GateNew<br>
	 * CNTO NO로 AciacDivCd 가져오기
	 *
	 * @param String cntrNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getAciacDivCd(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String[] returnValue = new String[5];
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetAciacDivCdForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("ACIAC_DIV_CD");
				returnValue[1] = dbRowset.getString("LSTM_CD");
				returnValue[2] = dbRowset.getString("CNTR_STS_CD");
				returnValue[3] = dbRowset.getString("CNTR_TPSZ_CD");
				returnValue[4] = dbRowset.getString("CO_CRE_FLG");
			} else {
				returnValue[0] = "";
				returnValue[1] = "";
				returnValue[2] = "";
				returnValue[3] = "";
				returnValue[4] = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * BKG_BOOKING 테이블에 존재하는 bkg_number인지를 체크한다.<br>
	 *
	 * @param String bkgNumber
	 * @return String
	 * @throws DAOException
	 */
	public String checkBkgNoForGateNew(String bkgNumber) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_number", bkgNumber);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckBkgNoForGateNewRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnValue = dbRowset.getString("1");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * BKG_BOOKING 테이블에 존재하는 EMPTY REPO bkg_number인지를 체크한다.<br>
	 *
	 * @param String bkgNumber
	 * @param String blNumber
	 * @return String
	 * @throws DAOException
	 */
	public String checkEDIBkgNoForGateNew(String bkgNumber, String blNumber) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_number", bkgNumber);
			mapVO.put("bl_number", blNumber);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckEDIBkgNoForGateNewRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnValue = dbRowset.getString("1");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * MST_CONTAINER CNTR_NO COUNT<br>
	 *
	 * @param String    cntrNo
	 * @return int
	 * @throws DAOException
	 */
	public int getCntrNoCount(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnValue = 0;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetCntrNoCountForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getInt("CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * MST_CONTAINER 테이블에서 CNTR_NO를 가져온다.<br>
	 *
	 * @param String    cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String getCntrNo(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetCntrNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("CNTR_NO");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * MST_CONTAINER 테이블에서 CNTR_NO를 가져온다.<br>
	 *
	 * @param String    cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String getCntrNoNotLike(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetCntrNoNotLikeForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("CNTR_NO");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * bkg_number와 bl_no로 Cross Checking (for GateNew)<br>
	 *
	 * @param String    blNo
	 * @param String    bkgNumber
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getBkgNoForCrossCheck(String blNo, String bkgNumber) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] returnValue = new String[2];
		try{
			if(blNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bl_no", blNo);
				mapVO.put("bkg_number", bkgNumber);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetBkgNoCrssForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("BKG_NO");
				returnValue[1] = dbRowset.getString("BKG_STS_CD");
			} else {
				returnValue[0] = "";
				returnValue[1] = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * eventYard로 LocalTime 가져오기 (for GateNew)<br>
	 *
	 * @param String    eventYard
	 * @return String
	 * @throws DAOException
	 */
	public String getLocalTime(String eventYard) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String returnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("event_yard", eventYard);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetLocalTimeForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * BKG_BOOKING 테이블에서 DEL_CD, DE_TERM_CD값을 불러온다.<br>
	 *
	 * @param String cntrNumber
	 * @param String blNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public String[] searchBlNo(String cntrNumber, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnValue = new String[2];
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_number", cntrNumber);
			mapVO.put("bl_no", blNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchBlNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("FLG");
				rtnValue[1] = dbRowset.getString("BKG_NO");
			} else {
				rtnValue[0] = "";
				rtnValue[1] = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * BKG_BOOKING 테이블에서 DEL_CD, DE_TERM_CD값을 불러온다.<br>
	 *
	 * @param String bkgNumber
	 * @param String blNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public String[] searchDelCode(String bkgNumber, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnValue = new String[2];
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_number", bkgNumber);
			mapVO.put("bl_no", blNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchDelCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("DEL_CD");
				rtnValue[1] = dbRowset.getString("DE_TERM_CD");
			} else {
				rtnValue[0] = "";
				rtnValue[1] = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * LOC_CD로 LCC_CD 값을 불러온다.<br>
	 *
	 * @param String    lccScc
	 * @param String    locCode
	 * @return String
	 * @throws DAOException
	 */
	public String searchLccScc(String lccScc, String locCode) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("return_nm", lccScc);
			mapVO.put("loc_cd", locCode);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchLccSccRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("RETURN_NM");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * PRD_PROD_CTL_ROUT_DTL 테이블의 TRSP_MOD_CD 값을 불러온다.<br>
	 *
	 * @param String    bkgNumber
	 * @param String    cntrNo
	 * @param String    eventYard
	 * @return String
	 * @throws DAOException
	 */
	public String searchTrspModCode(String bkgNumber, String cntrNo, String eventYard) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_number", bkgNumber);
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("event_yard", eventYard);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchTrspModCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("TRSP_MOD_CD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * PRD_PROD_CTL_ROUT_DTL 테이블의 FinalFacility 값을 불러온다.<br>
	 *
	 * @param String    bkgNumber
	 * @param String    cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchFinalFacility(String bkgNumber, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_number", bkgNumber);
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchFinalFacilityRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("NOD_CD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * BKG_BOOKING에서 BKG_STS_CD와 BKG_CGO_TP_CD를 가져온다.<br>
	 *
	 * @param String bkgNumber
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getBkgStsCd(String bkgNumber) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] returnValues = new String[2];
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_number", bkgNumber);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetBkgStsCdForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValues[0] = dbRowset.getString("BKG_STS_CD");
				returnValues[1] = dbRowset.getString("BKG_CGO_TP_CD");
			} else {
				returnValues[0] = "";
				returnValues[1] = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValues;
	}

	/**
	 * Value, Column, Table을 Param으로 받아서 Value가 존재하는지 Check.<br>
	 *
	 * @param String tableNm
	 * @param String columnNm
	 * @param String codeValue
	 * @return String
	 * @Exception DAOException
	 */
	public String searchCodeExistForGateNew(String tableNm, String columnNm, String codeValue) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("table_nm", tableNm);
			mapVO.put("column_nm", columnNm);
			mapVO.put("code_value", codeValue);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchCodeExistForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("1");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * Value, Column, Table을 Param으로 받아서 Value(rownum=1)를 가져옴<br>
	 *
	 * @param String tableNm
	 * @param String columnNm
	 * @param String returnNm
	 * @param String codeValue
	 * @return String
	 * @Exception DAOException
	 */
	public String getCodeValueForGateNew(String tableNm, String columnNm, String returnNm, String codeValue) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("table_nm", tableNm);
			mapVO.put("column_nm", columnNm);
			mapVO.put("return_nm", returnNm);
			mapVO.put("code_value", codeValue);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetCodeValueForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("RETURN_NM");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * Local Time대비 Event DT가 5일 전/후 일 경우 Ignored 처리를 위해 Event DT 시간 Gap을 가져옴<br>
	 *
	 * @param String muidArea
	 * @param String eventYard
	 * @param String eventDate
	 * @return Double
	 * @Exception DAOException
	 */
	public Double getEventTimeGap(String muidArea, String eventYard, String eventDate) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Double rtnValue = null;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("muid_area", muidArea);
			mapVO.put("event_yard", eventYard);
			mapVO.put("event_date", eventDate);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetEventTimeGapForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getDouble("GAP");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * CTM Damage Flag 체크 후 상태 변경 <br>
	 *
	 * @param String cntrNo
	 * @param String eventDate
	 * @param String eventYard
	 * @return String
	 * @Exception DAOException
	 */
	public String getCntrDamageFlg(String cntrNo, String evntDate, String eventYard) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("evnt_dt", evntDate);
			mapVO.put("event_yard", eventYard);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetCTMDamageFlgRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("CNTR_DMG_FLG");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * MST Damage Flag 체크 <br>
	 *
	 * @param String cntrNo
	 * @return String
	 * @Exception DAOException
	 */
	public String getMSTDamageFlg(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetMSTDamageFlgRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("DMG_FLG");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * getBkgNoByBlNo for GateNew<br>
	 * ContainerMovementFinderDBDAOSearchMovementListByGetBkgNoVORSQL
	 *
	 * @param String bkgNo
	 * @param String blNo
	 * @return String
	 * @throws DAOException
	 */
	public String getPolByBkgNoOrBlNo(String bkgNo, String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String returnValue = "";
		try{
			if(blNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bkg_no", blNo);
				mapVO.put("bl_no", blNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetPolByBkgNoOrBlNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("POL_CD");
			} else {
				returnValue = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}
	
	/** searchBkgNoForOscar
	 * 
	 * @param blNo
	 * @param cntrNo
	 * @return String 
	 * @throws DAOException
	 */
	public String searchBkgNoForOscar(String blNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			if(blNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bl_no", blNo);
				mapVO.put("cntr_no", cntrNo);
 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchBkgNoForOscarRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("BKG_NO");
			}
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/** searchBkgNoForOscar2
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgNoForOscar2(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			if(bkgNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bkg_no", bkgNo);
				mapVO.put("cntr_no", cntrNo);
 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchBkgNoForOscar2RSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("BKG_NO");
			}
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}		
	
	/**
	 * checkOutbound for GateNew<br>
	 *
	 * @param String bkgNumber
	 * @param String podCd
	 * @return Boolean
	 * @throws DAOException
	 */
	public Boolean checkOutbound(String bkgNumber, String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		boolean returnValue = false;
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNumber);
			mapVO.put("org_yd_cd", podCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckOutboundForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getString("1").equals("1")) {
					returnValue = true;
				} else {
					returnValue = false;
				}
			} else{
				returnValue = false;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}
	
	/**
	 * checkPrevMvmt for GateNew<br>
	 *
	 * @param String cntrNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] checkPrevMvmt(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] returnValues = new String[4];

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckPrevMvmtRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValues[0] = dbRowset.getString("MVMT_STS_CD");
				returnValues[1] = dbRowset.getString("FCNTR_FLG");
				returnValues[2] = dbRowset.getString("MTY_PLN_NO");
				returnValues[3] = dbRowset.getString("MTY_REPO_NO");
			} else{
				returnValues[0] = "";
				returnValues[1] = "";
				returnValues[2] = "";
				returnValues[3] = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValues;
	}
	
	/** checkEqrRefNo
	 * 
	 * @param String mtyPlnNo
	 * @param String mtyRepoNo
	 * @return String 
	 * @throws DAOException
	 */
	public String checkEqrRefNo(String mtyPlnNo, String mtyRepoNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("mty_pln_no", mtyPlnNo);
			mapVO.put("mty_repo_no", mtyRepoNo);
 
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckEqrRefNoRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("EXIST");
			}
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/** checkOPSts
	 * 
	 * @param String cntrNo
	 * @param String evntDt
	 * @return String 
	 * @throws DAOException
	 */
	public String checkOPSts(String cntrNo, String evntDt) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("evnt_dt", evntDt);
 
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckOPStsRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("MVMT_STS_CD");
			} else {
				rtnValue = "";
			}
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/** 
	 * BKG_BOOKING의 BKG_STS_CD를 조회한다.<br>
	 * @param String bkgNo
	 * @return String 
	 * @throws DAOException
	 */
	public String searchBkgStatus(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtForGateNewDBDAOSearchBkgStatusRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("BKG_STS_CD");
			} else {
				rtnValue = "";
			}
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
}