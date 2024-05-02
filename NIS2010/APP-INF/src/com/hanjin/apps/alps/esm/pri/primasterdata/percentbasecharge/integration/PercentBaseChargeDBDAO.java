/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PercentBaseChargeDBDAO.java
*@FileTitle : Percent Base CHG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.02
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.09.02 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriScgPctBseChgVO;
import com.hanjin.syscommon.common.table.PriScgPctBseVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.vo.RsltPercentBaseChargeVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.vo.RsltPercentBaseChargeGroupingVO;


/**
 * ALPS PercentBaseChargeDBDAO <br>
 * - ALPS-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SongHoJin
 * @see PercentBaseChargeBCImpl 참조
 * @since J2EE 1.6
 */
public class PercentBaseChargeDBDAO extends DBDAOSupport {

	/**
	 * ESM_PRI_4034 : Retrieve <br>
	 * 
	 * @return List<RsltPercentBaseChargeVO>
	 * @exception DAOException
	 */
	public List<RsltPercentBaseChargeVO> searchPercentBaseCharge() throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPercentBaseChargeVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PercentBaseChargeDBDAOSearchPercentBaseChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPercentBaseChargeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_4034 : sheet1 on select cell <br>
	 * 
	 * @param PriScgPctBseVO priScgPctBseVO
	 * @return List<RsltPercentBaseChargeGroupingVO>
	 * @exception DAOException
	 */
	public List<RsltPercentBaseChargeGroupingVO> searchPercentBaseChargeGrouping(PriScgPctBseVO priScgPctBseVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPercentBaseChargeGroupingVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(priScgPctBseVO != null){
				Map<String, String> mapVO = priScgPctBseVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PercentBaseChargeDBDAOSearchPercentBaseChargeGroupingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPercentBaseChargeGroupingVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * ESM_PRI_4034 : sheet1 SAVE <br>
	 * adding PCT_BSE_CD
	 * 
	 * @param List<PriScgPctBseVO> insModels
	 * @exception DAOException
	 */
	public void addPercentBaseCharge(List<PriScgPctBseVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PercentBaseChargeDBDAOAddPercentBaseChargeCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_4034 : sheet1 SAVE <br>
	 * updating PCT_BSE_CD
	 * 
	 * @param List<PriScgPctBseVO> priScgPctBseVOs
	 * @exception DAOException
	 */
	public void modifyPercentBaseCharge(List<PriScgPctBseVO> priScgPctBseVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(priScgPctBseVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PercentBaseChargeDBDAOModifyPercentBaseChargeUSQL(), priScgPctBseVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_4034 : sheet1 SAVE <br>
	 * deleting PCT_BSE_CD
	 * 
	 * @param List<PriScgPctBseVO> priScgPctBseVOs
	 * @exception DAOException
	 */
	public void removePercentBaseCharge(List<PriScgPctBseVO> priScgPctBseVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(priScgPctBseVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PercentBaseChargeDBDAORemovePercentBaseChargeDSQL(), priScgPctBseVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_4034 : sheet2 SAVE <br>
	 * adding CHG_CD
	 * 
	 * @param List<PriScgPctBseChgVO> insModels
	 * @exception DAOException
	 */
	public void addPercentBaseChargeGrouping(List<PriScgPctBseChgVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			
			if(insModels != null) {
				for(int i=0; i < insModels.size(); i++) {
					Map<String, String> mapVO = insModels.get(i).getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					result = sqlExe.executeUpdate((ISQLTemplate)new PercentBaseChargeDBDAOAddPercentBaseChargeGroupingCSQL(), param, velParam);
					
					if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_4034 : sheet2 SAVE <br>
	 * deleting CHG_CD
	 * 
	 * @param List<PriScgPctBseChgVO> priScgPctBseChgVOs
	 * @exception DAOException
	 */
	public void removePercentBaseChargeGrouping(List<PriScgPctBseChgVO> priScgPctBseChgVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(priScgPctBseChgVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PercentBaseChargeDBDAORemovePercentBaseChargeGroupingDSQL(), priScgPctBseChgVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		 
}