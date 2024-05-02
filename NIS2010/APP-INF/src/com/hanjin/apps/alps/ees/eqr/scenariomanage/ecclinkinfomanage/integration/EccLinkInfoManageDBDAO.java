/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EccLinkInfoManageDBDAO.java
*@FileTitle : SCNR Link 정보 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	yongchan shin		2006-10-17		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.24		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.24
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.basic.EccLinkInfoManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.vo.EesEqr0009ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.vo.SearchEccLinkInfoVO;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrScnrEccLnkVO;


/**
 * ALPS EccLinkInfoManageDBDAO <br>
 * - ALPS-EccLinkInfoManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see EccLinkInfoManageBCImpl 참조
 * @since J2EE 1.6
 */
public class EccLinkInfoManageDBDAO extends DBDAOSupport {

	/**
	 * EccLinkInfoManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param conditionVO EesEqr0009ConditionVO
	 * @return List<SearchEccLinkInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEccLinkInfoVO> searchECCLinkInfo(EesEqr0009ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEccLinkInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList fromEccArr = (ArrayList) Utils.replaceStrToList(conditionVO.getFromLocation());
			ArrayList toEccArr = (ArrayList) Utils.replaceStrToList(conditionVO.getToLocation());
			Map<String, String> mapVO = conditionVO .getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("fromEccArr", fromEccArr);
			velParam.put("toEccArr", toEccArr);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EccLinkInfoManageDBDAOSearchEccLinkInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEccLinkInfoVO .class);
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
	 * @param updModels List<EqrScnrEccLnkVO>
	 * @exception DAOException
	 */
	public void modifyECCLinkInfo(List<EqrScnrEccLnkVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EccLinkInfoManageDBDAOMergeEccLinkInfoCSQL(), updModels,null);
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
	 * 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param delModels List<EqrScnrEccLnkVO>
	 * @exception DAOException
	 */
	public void deleteECCLinkInfo(List<EqrScnrEccLnkVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(delModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EccLinkInfoManageDBDAODeleteEccLinkInfoDSQL(), delModels,null);
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