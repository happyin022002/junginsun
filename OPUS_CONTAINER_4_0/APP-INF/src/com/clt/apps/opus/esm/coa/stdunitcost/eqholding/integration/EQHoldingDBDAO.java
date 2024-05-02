/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQHoldingDBDAO.java
*@FileTitle : 실적장비비 표준단가 조회, 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.26 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.eqholding.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.eqholding.basic.EQHoldingBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.eqholding.vo.EqHoldingCostVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS EQHoldingDBDAO <br>
 * - OPUS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Song Ho Jin
 * @see EQHoldingBCImpl 참조
 * @since J2EE 1.6
 */
public class EQHoldingDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @return List<EqHoldingCostVO>
	 * @throws DAOException
	 */
	public List<EqHoldingCostVO> searchEQHoldingCost(SearchConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqHoldingCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQHoldingDBDAOSearchEQHoldingCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqHoldingCostVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<EqHoldingCostVO> eqHoldingCostVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyEQHoldingCost(List<EqHoldingCostVO> eqHoldingCostVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqHoldingCostVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAOMultiEQHoldingCostUSQL(), eqHoldingCostVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<EqHoldingCostVO> eqHoldingCostVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addEQHoldingCost(List<EqHoldingCostVO> eqHoldingCostVO) throws DAOException,Exception {
		int insertCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqHoldingCostVO .size() > 0){
				insertCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAOMultiEQHoldingCostCSQL(), eqHoldingCostVO,null);
				for(int i = 0; i < insertCnt.length; i++){
					if(insertCnt[i]== Statement.EXECUTE_FAILED)
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
		return insertCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<EqHoldingCostVO> eqHoldingCostVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeEQHoldingCost(List<EqHoldingCostVO> eqHoldingCostVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(eqHoldingCostVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new EQHoldingDBDAOMultiEQHoldingCostDSQL(), eqHoldingCostVO,null);
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