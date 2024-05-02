/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgencyCommissionDBDAO.java
*@FileTitle : Other Commission Inquiry (PA/RA)
*Open Issues :
*@LastModifyDate : 2009.09.21
*@LastModifier : 장영석
*@LastVersion : 1.2
* 2009.09.21 장영석
* 1.0 Creation
* *Change history :
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.agencycommission.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.agencycommission.basic.AgencyCommissionBCImpl;
import com.hanjin.apps.alps.esm.coa.stdunitcost.agencycommission.vo.SearchAgnOtrCommCostListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.CoaOtrCommVO;



/**
 * ALPS AgencyCommissionDBDAO <br>
 * - ALPS-STDUnitCost system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jang Yeong-seok
 * @see AgencyCommissionBCImpl 참조
 * @since J2EE 1.6
 */
public class AgencyCommissionDBDAO extends DBDAOSupport {


	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchAgnOtrCommCostListVO>
	 * @throws DAOException
	 */
	public List<SearchAgnOtrCommCostListVO> searchAgnOtrCommCostList(SearchAgnOtrCommCostListVO searchAgnOtrCommCostListVO
			                                                         ,SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAgnOtrCommCostListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgencyCommissionDBDAOSearchAgnOtrCommCostListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgnOtrCommCostListVO .class);
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
	 * @param List<CoaOtrCommVO> coaOtrCommVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiAgnOtrCommCost(List<CoaOtrCommVO> coaOtrCommVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaOtrCommVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgencyCommissionDBDAOCoaOtrCommVOCSQL(), coaOtrCommVO,null);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CoaOtrCommVO> coaOtrCommVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiAgnOtrCommCost(List<CoaOtrCommVO> coaOtrCommVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaOtrCommVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AgencyCommissionDBDAOCoaOtrCommVOUSQL(), coaOtrCommVO,null);
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
	 * @param List<CoaOtrCommVO> coaOtrCommVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiAgnOtrCommCost(List<CoaOtrCommVO> coaOtrCommVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(coaOtrCommVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AgencyCommissionDBDAOCoaOtrCommVODSQL(), coaOtrCommVO,null);
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