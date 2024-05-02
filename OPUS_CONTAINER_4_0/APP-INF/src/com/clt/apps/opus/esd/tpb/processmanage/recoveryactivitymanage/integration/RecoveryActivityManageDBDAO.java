/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RecoveryActivityManageDBDAO.java
*@FileTitle : RecoveryActivitiManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-28
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.2
* 2008-10-10 O Wan-Ki 			1.0	최초 생성
* 2009-03-05 O Wan-Ki 			1.1 TPB 4차보완(N200902240160)에 의한 표시시간 변경.
* 2009-09-28 Jong-Geon Byeon	1.2 Renewal Migration
* -------------------------------------------------------
* History
* 2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.vo.SearchRecoveryActivityListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  RecoveryActivityManageDBDAO <br>
 * - -RecoveryActivityManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author GUN-HA HWANG
 * @see RecoveryActivityManageBCImpl 참조
 * @since J2EE 1.6
 */
public class RecoveryActivityManageDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchRecoveryActivityListVO searchRecoveryActivityListVO
	 * @return List<SearchRecoveryActivityListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchRecoveryActivityListVO> searchRecoveryActivityListValue(SearchRecoveryActivityListVO searchRecoveryActivityListVO) throws DAOException {
		//2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
		DBRowSet dbRowset = null;
		List<SearchRecoveryActivityListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
//		log.debug("abc:dbdao:getUserOfcCd: "+searchRecoveryActivityListVO.getUserOfcCd());
//		log.debug("abc:dbdao:getN3ptyNo: "+searchRecoveryActivityListVO.getN3ptyNo());
//		log.debug("abc:dbdao:getSortNo: "+searchRecoveryActivityListVO.getSortNo());

		try{
			if(searchRecoveryActivityListVO != null){
				Map<String, String> mapVO = searchRecoveryActivityListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RecoveryActivityManageDBDAOSearchRecoveryActivityListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRecoveryActivityListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchRecoveryActivityListVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addMultiRecoveryActivityManageListVOS(List<SearchRecoveryActivityListVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RecoveryActivityManageDBDAOCreateRecoveryActivityListCSQL(), insModels,null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchRecoveryActivityListVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyMultiRecoveryActivityManageListVOS(List<SearchRecoveryActivityListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RecoveryActivityManageDBDAOModifyRecoveryActivityListUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchRecoveryActivityListVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeMultiRecoveryActivityManageListVOS(List<SearchRecoveryActivityListVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RecoveryActivityManageDBDAORemoveRecoveryActivityListDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
}