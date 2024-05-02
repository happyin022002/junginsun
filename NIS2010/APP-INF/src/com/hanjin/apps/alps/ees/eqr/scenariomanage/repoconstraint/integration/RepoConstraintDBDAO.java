/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoConstraintDBDAO.java
*@FileTitle : Constraint by Lane/ECC
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1		1.0		Se-Hoon Park		2006-11-03		1.0 최초 생성
* 2		1.15		Haeng-ji, Lee		2009-04-03		CSR No : R200903240002 - Cntr Tpsz 자동화
* 3      	1.0      	Lee Byoung Hun	2009.08.12		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.12
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.basic.RepoConstraintBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.vo.EesEqr0138ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrScnrPortDchgCnstVO;


/**
 * ALPS RepoConstraintDBDAO <br>
 * - ALPS-ScenarioManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see RepoConstraintBCImpl 참조
 * @since J2EE 1.6
 */
public class RepoConstraintDBDAO extends DBDAOSupport {
	
	/**
	 * Constraint by Lane/ECC 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchConstraintLaneEccInfo(EesEqr0138ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			ArrayList arrCntrTpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getTpsz());
			ArrayList arrFmEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getLoctype());
			ArrayList arrLane = (ArrayList) Utils.replaceStrToList(conditionVO.getLane());
			
			String scnrId    = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("scnrId", scnrId);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrLane", arrLane);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepoConstraintDBDAOSearchConstLaneEccRSQL(), param, velParam);
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
	 * Constraint by Lane/ECC 멀티 이벤트 처리 (입력/수정)<br>
	 * 
	 * @param updModels
	 * @return
	 * @exception DAOException,Exception
	 */
	public int[] modifyConstraintLaneEccInfo(List<EqrScnrPortDchgCnstVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoConstraintDBDAOMergeConstLaneEccCSQL(), updModels,null);
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
	 * Constraint by Lane/ECC 멀티 이벤트 처리 (삭제)<br>
	 * 
	 * @param delModels
	 * @return
	 * @exception DAOException,Exception
	 */
	public int[] deleteConstraintLaneEccInfo(List<EqrScnrPortDchgCnstVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new RepoConstraintDBDAODeleteConstLaneEccDSQL(), delModels,null);
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

	/**
     * RepoConstraint의 테이터 모델 정보 조회
     * 
     * @param String scnrid
     * @param String cnsttype
     * @param List<String> tpszArr
     * @return CommonRsVO
     * @exception DAOException
    */
	public CommonRsVO searchEmptyRepoConstraintInfo(String scnrid, String cnsttype, List<String> tpszArr) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("scnr_id", scnrid);
			param.put("cnsttype", cnsttype);
			velParam.put("tpszArr", tpszArr);
			velParam.put("cnsttype", cnsttype);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepoConstraintDBDAOSearchEmptyRepoConstRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
			
			return commonRsVO;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	
	

	/**
	 * RepoConstraint의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param updModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyEmptyRepoConstraintInfo(List updModels) throws DAOException { 
		
        int updCnt[] = null;
        
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
        	
			
			// INSERT, UPDATE, DELETE 를 DB에 적용
        	
			updCnt = sqlExe.executeBatch((ISQLTemplate)new RepoConstraintDBDAOUpdateEmptyRepoConstUSQL(), updModels,null);
			for(int i = 0; i < updCnt.length; i++){
				if(updCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
			}
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
    }

	/**
	 * RepoConstraint의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param delModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void deleteEmptyRepoConstraintInfo(List delModels) throws DAOException { 
		
        int delCnt[] = null;

        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
        	
			
			// INSERT, UPDATE, DELETE 를 DB에 적용
			delCnt = sqlExe.executeBatch((ISQLTemplate)new RepoConstraintDBDAODeleteEmptyRepoConstDSQL(), delModels,null);
			for(int i = 0; i < delCnt.length; i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
			}

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
    }

	/**
	 * RepoConstraint의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param insModels List
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void insertEmptyRepoConstraintInfo(List insModels) throws DAOException { 
        
        int insCnt[] = null;

        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
			
			// INSERT, UPDATE, DELETE 를 DB에 적용
			insCnt = sqlExe.executeBatch((ISQLTemplate)new RepoConstraintDBDAOInsertEmptyRepoConstCSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
    }
	

	/**
     * RepoConstraint의 테이터 모델 정보 조회
     * 
     * @return int
     * @exception DAOException
    */		
	public int createCnstSeq() throws DAOException {

		DBRowSet dbRowset = null;
		
		int cnstSeq = 0;
    	  
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepoConstraintDBDAOCreateCnstSeqRSQL(), null, null);
			
            if (dbRowset != null && dbRowset.next()) { 
            	cnstSeq = dbRowset.getInt("REPO_CNST_SEQ");
            }

            log.debug("\n\n 멧소드에서 값 ==========>"+cnstSeq);
			return cnstSeq;
        
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	
	/**
     * RepoConstraint의 테이터 모델 정보 조회
     * 
     * @param nationCode	String
     * @param cnstTypeCode	String
     * @param scnrId		String
     * @return int
     * @exception DAOException
    */		
	public int createCnstRuleId(String nationCode, String cnstTypeCode, String scnrId) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int cnstRuleId = 0;
	
		try {
			param.put("nationCode", nationCode);
			param.put("cnstTypeCode", cnstTypeCode);
			param.put("scnrId", scnrId);
  			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepoConstraintDBDAOCreateCnstRuleIDRSQL(), param, null);
			
            if (dbRowset != null && dbRowset.next()) { 
            	cnstRuleId = dbRowset.getInt("cnst_rule_id");
            }

			return cnstRuleId;
        
		} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}	
}