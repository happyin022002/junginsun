/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CandidateConfirmDBDAO.java
*@FileTitle : CandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : O Wan-Ki
*@LastVersion : 1.1
* 2009.08.31 Park Sung-Jin 1.0 Creation
* 2009.09.02 O Wan-Ki      1.1 쿼리변경에 의한 반영
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.basic.CandidateConfirmBCImpl;
import com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.vo.SearchCandidateListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  CandidateConfirmDBDAO <br>
 * - -CandidateManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author GUN-HA HWANG
 * @see CandidateConfirmBCImpl 참조
 * @since J2EE 1.6
 */
public class CandidateConfirmDBDAO extends DBDAOSupport {
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchCandidateListVO searchCandidateListVO
	 * @return List<SearchCandidateListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCandidateListVO> searchCandidateList(SearchCandidateListVO searchCandidateListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCandidateListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchCandidateListVO != null){
				Map<String, String> mapVO = searchCandidateListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CandidateConfirmDBDAOSearchCandidateListRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCandidateListVO .class);

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
	 * @param SearchCandidateListVO searchCandidateListVO
	 * @return List<SearchCandidateListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCandidateListVO> searchUpdatedList(SearchCandidateListVO searchCandidateListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCandidateListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchCandidateListVO != null){
				Map<String, String> mapVO = searchCandidateListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CandidateConfirmDBDAOSearchUpdatedListRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCandidateListVO .class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
//	/**
//	 * [처리대상] 정보를 [행위] 합니다.<br>
//	 * 
//	 * @param SearchCandidateListVO vo
//	 * @return String resultNo
//	 * @throws Exception
//	 */
//	public String multiCandidateConfirm(SearchCandidateListVO vo) throws DAOException,Exception {
//		Map resultMap = null;
//		String resultNo = null;
//		String tempNo = null;
//
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try {
//			if(vo != null){
//				Map<String, String> mapVO = vo .getColumnValues();
//				
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//
//			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new CandidateConfirmDBDAOModifyCandidateListUSQL(), param, velParam);
//			resultNo = (String) resultMap.get("n3pty_no");
//			tempNo = (String) resultMap.get("v_n3pty_no");
//			log.debug("resultNo=================>"+resultNo);
//			log.debug("resultNo=================>"+resultNo);
//			log.debug("tempNo=================>"+tempNo);
//			log.debug("otsseq=================>"+otsseq);
//			log.debug("userid=================>"+userid);
//
//			return resultNo;
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		
//	}
//	

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchCandidateListVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyCandidateList(List<SearchCandidateListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CandidateConfirmDBDAOModifyCandidateListUSQL(), updModels,null);
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
	 * @param SearchCandidateListVO searchCandidateListVO
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String chkTrdPartyVal(SearchCandidateListVO searchCandidateListVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtnValue = "";
		try{
			Map<String, String> mapVO = searchCandidateListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CandidateConfirmDBDAOSearchCheckTrdPartyRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("validyn");
			} else {
				rtnValue = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<SearchCandidateListVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyCandidateCancelList(List<SearchCandidateListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CandidateConfirmDBDAOModifyCandidateCancelListUSQL(), updModels,null);
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
}