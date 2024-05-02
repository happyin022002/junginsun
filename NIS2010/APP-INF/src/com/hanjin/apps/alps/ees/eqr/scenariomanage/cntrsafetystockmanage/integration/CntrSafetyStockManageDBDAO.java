/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrSafetyStockManageDBDAO.java
*@FileTitle : Safty Stock
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.11 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.basic.CntrSafetyStockManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.vo.EesEqr0026ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrScnrEccSftStkVO;


/**
 * ALPS CntrSafetyStockManageDBDAO <br>
 * - ALPS-ScenarioManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Haeng-ji,Lee
 * @see CntrSafetyStockManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrSafetyStockManageDBDAO extends DBDAOSupport {

	/**
	 * [ EES_EQR_0026 : Safty Stock - Search ]<br>
	 * 
	 * @param EesEqr0026ConditionVO eesEqr0026ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchCntrSafetyStock(EesEqr0026ConditionVO eesEqr0026ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr0026ConditionVO != null){
				Map<String, String> mapVO = eesEqr0026ConditionVO .getColumnValues();
				String tpsz = eesEqr0026ConditionVO.getTpsztype();
				String location = eesEqr0026ConditionVO.getLocation();
				List<String> arrtpsz	=  Utils.replaceStrToList(tpsz);
				List<String> arrlocation =  Utils.replaceStrToList(location);
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrtpsz", arrtpsz);
				velParam.put("arrlocation", arrlocation);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrSafetyStockManageDBDAOSearchCntrSafetyStockRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [ EES_EQR_0026 : Safty Stock - Check SFST_VOL_QTY ]<br>
	 * 
	 * @param EesEqr0026ConditionVO eesEqr0026ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchCntrSafetyStockQty(EesEqr0026ConditionVO eesEqr0026ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr0026ConditionVO != null){
				Map<String, String> mapVO = eesEqr0026ConditionVO .getColumnValues();
				
				String cntr_tpsz_cd = eesEqr0026ConditionVO.getCol().substring(0,2).toUpperCase();
			
				param.putAll(mapVO);
				param.put("cntr_tpsz_cd", cntr_tpsz_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrSafetyStockManageDBDAOSearchCntrSafetyStockQtyRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}	

	/**
	 * [ EES_EQR_0026 : Safty Stock - Merge ]<br>
	 * 
	 * @param List<EqrScnrEccSftStkVO> eqrScnrEccSftStkVO
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] multiCntrSafetyStock(List<EqrScnrEccSftStkVO> eqrScnrEccSftStkVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrScnrEccSftStkVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrSafetyStockManageDBDAOMergeCntrSafetyStockCSQL(), eqrScnrEccSftStkVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * [ EES_EQR_0026 : Safty Stock - Delete ]<br>
	 * 
	 * @param List<EqrScnrEccSftStkVO> eqrScnrEccSftStkVO
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] removeCntrSafetyStock(List<EqrScnrEccSftStkVO> eqrScnrEccSftStkVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqrScnrEccSftStkVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CntrSafetyStockManageDBDAODeleteCntrSafetyStockDSQL(), eqrScnrEccSftStkVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
}