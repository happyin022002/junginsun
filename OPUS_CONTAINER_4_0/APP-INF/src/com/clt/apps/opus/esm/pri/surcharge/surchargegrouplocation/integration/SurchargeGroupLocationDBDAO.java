/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeGroupLocationDAO.java
*@FileTitle : Surcharge Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.06 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.basic.SurchargeGroupLocationBCImpl;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo.RsltPriScgGrpLocDtlVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegrouplocation.vo.RsltPriScgGrpLocVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriScgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriScgGrpLocVO;


/**
 *  SurchargeGroupLocationDAO <br>
 * - Surcharge system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung Jun Lee
 * @see SurchargeGroupLocationBCImpl 참조
 * @since J2EE 1.4
 */
public class SurchargeGroupLocationDBDAO extends DBDAOSupport {

	
	/**
	 * Group Location 시퀀스 맥스값을 조회한다.<br>
	 * 
	 * @param PriScgGrpLocVO priScgGrpLocVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchGroupLocationMaxSeq(PriScgGrpLocVO priScgGrpLocVO) throws DAOException {
		int max_seq = 0;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScgGrpLocVO != null){
				Map<String, String> mapVO = priScgGrpLocVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("max_seq");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}
	
	
	/**
	 * Surcharge Group Location Detail 정보를 조회한다.<br>
	 * 
	 * @param PriScgGrpLocDtlVO priScgGrpLocDtlVO
	 * @return List<RsltPriScgGrpLocDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriScgGrpLocDtlVO> searchGroupLocationDetailList(PriScgGrpLocDtlVO priScgGrpLocDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriScgGrpLocDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScgGrpLocDtlVO != null){
				Map<String, String> mapVO = priScgGrpLocDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}															  
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriScgGrpLocDtlVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Surcharge Group Location 정보를 조회한다.<br>
	 * 
	 * @param PriScgGrpLocVO priScgGrpLocVO
	 * @return List<RsltPriScgGrpLocVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriScgGrpLocVO> searchGroupLocationList(PriScgGrpLocVO priScgGrpLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriScgGrpLocVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priScgGrpLocVO != null){
				Map<String, String> mapVO = priScgGrpLocVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriScgGrpLocVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Surcharge Group Location 단건 데이터를 생성.(pri_scg_grp_loc_dtl)<br>
	 * 
	 * @param PriScgGrpLocDtlVO priScgGrpLocDtlVO
	 * @exception DAOException
	 */
	public void addGroupLocationDetail(PriScgGrpLocDtlVO priScgGrpLocDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScgGrpLocDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocDtlVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Surcharge Group Location 단건 데이터를 갱신.(pri_scg_grp_loc_dtl)<br>
	 * 
	 * @param PriScgGrpLocDtlVO priScgGrpLocDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyGroupLocationDetail(PriScgGrpLocDtlVO priScgGrpLocDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScgGrpLocDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocDtlVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * Surcharge Group Location 단건의 데이터를 삭제한다.(pri_scg_grp_loc_dtl)<br>
	 * 
	 * @param PriScgGrpLocDtlVO priScgGrpLocDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGroupLocationDetail(PriScgGrpLocDtlVO priScgGrpLocDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScgGrpLocDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");       
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocDtlVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * Surcharge Group Location 본문별 데이터를 삭제한다.(pri_scg_grp_loc_dtl)<br>
	 * 
	 * @param PriScgGrpLocVO priScgGrpLocVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGroupLocationDetail(PriScgGrpLocVO priScgGrpLocVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScgGrpLocVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");       
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupLocationDAOPriScgGrpLocDtlVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Surcharge Group Location. 다건 데이터를 생성(pri_scg_grp_loc_dtl)<br>
	 * 
	 * @param List<PriScgGrpLocDtlVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocationDetail(List<PriScgGrpLocDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			log.debug("***************insModels.size()**************************************");
			log.debug(insModels.size());
			log.debug("***************insModels.size()**************************************");
			if(insModels.size() > 0){
				
				
				PriScgGrpLocDtlVO priScgGrpLocDtlVO  = new PriScgGrpLocDtlVO();
				
				priScgGrpLocDtlVO = (PriScgGrpLocDtlVO)insModels.get(0);
				
				log.debug("*****************************************************");
				log.debug("priScgGrpLocDtlVOs[i].GetCreUsrId : " +priScgGrpLocDtlVO.getCreUsrId());
				log.debug("priScgGrpLocDtlVOs[i].GetUpdUsrId : " +priScgGrpLocDtlVO.getUpdUsrId());

				log.debug("priScgGrpLocDtlVOs[i].GetEffDt : " +priScgGrpLocDtlVO.getEffDt());
				log.debug("priScgGrpLocDtlVOs[i].GetExpDt : " +priScgGrpLocDtlVO.getExpDt());
				log.debug("****************************************************");					
				
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocDtlVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Surcharge Group Location 의 다건 데이터를 일괄 갱신.(pri_scg_grp_loc_dtl)<br>
	 * 
	 * @param List<PriScgGrpLocDtlVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupLocationDetail(List<PriScgGrpLocDtlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocDtlVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Surcharge Group Location다건의 데이터를 일괄적으로 삭제한다.(pri_scg_grp_loc_dtl)<br>
	 * 
	 * @param List<PriScgGrpLocDtlVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupLocationDetail(List<PriScgGrpLocDtlVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocDtlVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Group Location 데이터를 생성한다.(pri_scg_grp_loc)<br>
	 * 
	 * @param PriScgGrpLocVO priScgGrpLocVO
	 * @exception DAOException
	 */
	public void addGroupLocation(PriScgGrpLocVO priScgGrpLocVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priScgGrpLocVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 *  Surcharge Group Location 단건 데이터를 갱신(pri_scg_grp_loc)<br>
	 * 
	 * @param PriScgGrpLocVO priScgGrpLocVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyGroupLocation(PriScgGrpLocVO priScgGrpLocVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScgGrpLocVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * Surcharge Group Location 단건 데이터를 삭제한다.(pri_scg_grp_loc)<br>
	 * 
	 * @param PriScgGrpLocVO priScgGrpLocVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGroupLocation(PriScgGrpLocVO priScgGrpLocVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priScgGrpLocVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Group Location 데이터를 다건 생성.(pri_scg_grp_loc)<br>
	 * 
	 * @param List<PriScgGrpLocVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocation(List<PriScgGrpLocVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Surcharge Group Location 다건 갱신.(pri_scg_grp_loc)<br>
	 * 
	 * @param List<PriScgGrpLocVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupLocation(List<PriScgGrpLocVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 삭제한다.(pri_scg_grp_loc)<br>
	 * 
	 * @param List<PriScgGrpLocVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupLocation(List<PriScgGrpLocVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SurchargeGroupLocationDBDAOPriScgGrpLocVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
}
