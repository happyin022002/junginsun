/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupTerminalKpiManageDBDAO.java
*@FileTitle : EvaluationGroupTargetManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 권정화
*@LastVersion : 1.0
* 2009.07.22 권정화
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.basic.EvaluationGroupTerminalKpiManageBCImpl;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo.SearchEGTerminalKpiManageVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo.SearchVndrSeqVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.SpeEvGrpTmlKpiTgtRtoVO;

 
/**
 * ALPS EvaluationGroupTerminalKpiManageDBDAO <br>
 * - ALPS-EvaluationGroupTargetManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kown Jeong hwa
 * @see EvaluationGroupTerminalKpiManageBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EvaluationGroupTerminalKpiManageDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEGTerminalKpiManageVO searchEGTerminalKpiManageVO
	 * @return List<SearchEGTerminalKpiManageVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEGTerminalKpiManageVO> searchEGTerminalKpiManage(SearchEGTerminalKpiManageVO searchEGTerminalKpiManageVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEGTerminalKpiManageVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchEGTerminalKpiManageVO != null){
				Map<String, String> mapVO = searchEGTerminalKpiManageVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupTerminalKpiManageDBDAOSearchEGTerminalKpiManageRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEGTerminalKpiManageVO .class);
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
	 * @param List<SpeEvGrpTmlKpiTgtRtoVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiSpeEvGrpTmlKpiTgtRtoS(List<SpeEvGrpTmlKpiTgtRtoVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupTerminalKpiManageDBDAOMultiSpeEvGrpTmlKpiTgtRtoCSQL(), insModels,null);
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
	 * @param List<SpeEvGrpTmlKpiTgtRtoVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiSpeEvGrpTmlKpiTgtRtoS(List<SpeEvGrpTmlKpiTgtRtoVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupTerminalKpiManageDBDAOMultiSpeEvGrpTmlKpiTgtRtoUSQL(), updModels,null);
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
	 * @param List<SpeEvGrpTmlKpiTgtRtoVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removemultiSpeEvGrpTmlKpiTgtRtoS(List<SpeEvGrpTmlKpiTgtRtoVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new EvaluationGroupTerminalKpiManageDBDAOMultiSpeEvGrpTmlKpiTgtRtoDSQL(), delModels,null);
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
	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchVndrSeqVO searchVndrSeqVO
	 * @return List<SearchVndrSeqVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchVndrSeqVO> searchVndrSeq(SearchVndrSeqVO searchVndrSeqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVndrSeqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchVndrSeqVO != null){
				Map<String, String> mapVO = searchVndrSeqVO .getColumnValues();
			
				param.putAll(mapVO);
				//velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupTerminalKpiManageDBDAOSearchVndrSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVndrSeqVO .class);
			log.debug("#### DBDAO ###############");
			log.debug(list);
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
		 * checking the unique of data
		 * @param String egId
		 * @param String egIdSeq
		 * @param String vndrSeq
		 * @param String evYr
		 * @param String ydCd
		 * @return boolean
		 * @throws DAOException
		 */
		public boolean confirmUnique(String egId,String egIdSeq,String vndrSeq, String evYr, String ydCd) throws DAOException{
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
//				Map<String, Object> velParam = new HashMap<String, Object>();
			
			boolean result = false;
						 
			 try{
					param.put("eg_id", egId);
					param.put("eg_id_seq", egIdSeq);
					param.put("vndr_seq", vndrSeq);
					param.put("ev_yr", evYr);
					param.put("yd_cd", ydCd);
									
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EvaluationGroupTerminalKpiManageDBDAOConfirmUniqueRSQL(), param, null);
					
					if(dbRowset.getRowCount() <= 0 )
					result = true;							
					
				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
			return result;
		}
	 
}