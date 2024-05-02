/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EccInfoManageDBDAO.java
*@FileTitle : SCNR ECC 정보 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	yongchan shin		2006-09-28		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.20		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.20
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.basic.EccInfoManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.EesEqr0007ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.SearchEccInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.SearchEccTSTMLInfoVO;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrScnrEccVO;
import com.hanjin.syscommon.common.table.EqrScnrTsTmlVO;


/**
 * NIS2010 EccInfoManageDBDAO <br>
 * - NIS2010-ScenarioManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see EccInfoManageBCImpl 참조
 * @since J2EE 1.6
 */
public class EccInfoManageDBDAO extends DBDAOSupport {

	/**
	 * EccInfoManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param conditionVO EesEqr0007ConditionVO
	 * @return List<SearchEccInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEccInfoVO> searchECCInfo(EesEqr0007ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEccInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList arrLocation = (ArrayList) Utils.replaceStrToList(conditionVO.getLocation());
			Map<String, String> mapVO = conditionVO .getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("arrlocation", arrLocation);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EccInfoManageDBDAOSearchEccInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEccInfoVO .class);
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
	 * EccInfoManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param conditionVO EesEqr0007ConditionVO
	 * @return List<SearchEccTSTMLInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEccTSTMLInfoVO> searchTSTMLInfo(EesEqr0007ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEccTSTMLInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
		
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EccInfoManageDBDAOSearchEccTSTMLInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEccTSTMLInfoVO .class);
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
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrScnrEccVO>
	 * @exception DAOException
	 */
	public void modifyECCInfo(List<EqrScnrEccVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EccInfoManageDBDAOUpdateEccInfoUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrScnrTsTmlVO>
	 * @exception DAOException
	 */
	public void modifyTSTMLInfo(List<EqrScnrTsTmlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EccInfoManageDBDAOUpdateEccTSTMLInfoUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		 
}