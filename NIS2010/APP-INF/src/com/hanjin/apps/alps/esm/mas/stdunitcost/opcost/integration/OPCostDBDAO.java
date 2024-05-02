/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OPCostDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.04 
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.basic.OPCostBCImpl;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUseQtyVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUtCostDtlVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.vo.StndUtCostVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS OPCostDBDAO <br>
 * - ALPS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jong-Ock KIM
 * @see OPCostBCImpl 참조
 * @since J2EE 1.6
 */
public class OPCostDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8860416366174806503L;


	/**
	 * ESM_MAS_0315, ESM_MAS_0316 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<StndUtCostVO>
	 * @throws DAOException
	 */
	public List<StndUtCostVO> searchStndUtCostList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StndUtCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPCostDBDAOStndUtCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StndUtCostVO .class);
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
	 * ESM_MAS_0315- Save<br>
	 *
	 * @param  @param List<StndUtCostVO> updModels
	 * @throws DAOException
	 */
	public void modifyStndUtCost(List<StndUtCostVO> updModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OPCostDBDAOStndUtCostUSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0315- Create<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String createStndUtCost(SearchConditionVO searchConditionVO) throws DAOException {
		String pErrorCode = "";
		try{
			Map<String, String> param = new HashMap<String, String>();
			param.put("f_year", searchConditionVO.getFYear());
			param.put("f_qtr", searchConditionVO.getFQtr()+"Q");
			param.put("f_sweek", searchConditionVO.getFSweek());
			param.put("f_dur", searchConditionVO.getFDur());
			param.put("f_cobcost", searchConditionVO.getFCobcost());
			param.put("f_usr_id", searchConditionVO.getFUsrId());
			param.put("p_error_code", pErrorCode);
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate)new OPCostDBDAOStndUtCostCSQL(), param, null);
			if (rtnrslt != null){ 
				pErrorCode = (String) rtnrslt.get("p_error_code");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return pErrorCode;
	}
	
	/**
	 * ESM_MAS_0317 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<StndUtCostDtlVO>
	 * @throws DAOException
	 */
	public List<StndUtCostDtlVO> searchStndUtCostDtlList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StndUtCostDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPCostDBDAOStndUtCostDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StndUtCostDtlVO .class);
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
	 * ESM_MAS_0317- Save<br>
	 *
	 * @param  @param List<StndUtCostDtlVO> updModels
	 * @throws DAOException
	 */
	public void modifyStndUtCostDtl(List<StndUtCostDtlVO> updModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OPCostDBDAOStndUtCostDtlUSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0317- Create<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String createStndUtCostDtl(SearchConditionVO searchConditionVO) throws DAOException {
		String pErrorCode = "";
		try{
			Map<String, String> param = new HashMap<String, String>();
			param.put("f_yearweek", searchConditionVO.getFYearweek());
			param.put("f_cobcost", searchConditionVO.getFCobcost());
			param.put("f_usr_id", searchConditionVO.getFUsrId());
			param.put("p_error_code", pErrorCode);
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate)new OPCostDBDAOStndUtCostDtlCSQL(), param, null);
			if (rtnrslt != null){ 
				pErrorCode = (String) rtnrslt.get("p_error_code");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return pErrorCode;
	}
	
	/**
	 * ESM_MAS_0318 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<StndUseQtyVO>
	 * @throws DAOException
	 */
	public List<StndUseQtyVO> searchStndUseQtyList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StndUseQtyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPCostDBDAOStndUseQtyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StndUseQtyVO .class);
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
	 * ESM_MAS_0318- Save<br>
	 *
	 * @param  @param List<StndUseQtyVO> updModels
	 * @throws DAOException
	 */
	public void modifyStndUseQty(List<StndUseQtyVO> updModels) throws DAOException,Exception {
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OPCostDBDAOStndUseQtyUSQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_MAS_0318- Create<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String createStndUseQty(SearchConditionVO searchConditionVO) throws DAOException {
		String pErrorCode = "";
		try{
			Map<String, String> param = new HashMap<String, String>();
			param.put("f_yearweek", searchConditionVO.getFYearweek());
			param.put("f_usr_id", searchConditionVO.getFUsrId());
			param.put("p_error_code", pErrorCode);
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate)new OPCostDBDAOStndUseQtyCSQL(), param, null);
			if (rtnrslt != null){ 
				pErrorCode = (String) rtnrslt.get("p_error_code");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return pErrorCode;
	}
	
	/**
	 * ESM_MAS_0319 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<StndUtCostDtlVO>
	 * @throws DAOException
	 */
	public List<StndUtCostDtlVO> searchStndUtCostDtlPopList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<StndUtCostDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OPCostDBDAOStndUtCostDtlPopRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StndUtCostDtlVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
}