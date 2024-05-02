/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOCandidateConfirmDBDAO.java
*@FileTitle : JOCandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.6
* 2008-10-21 O Wan-Ki 			1.0  최초 생성
* 2008-11-19 O Wan-Ki 			1.1  금액수정관련 로직 구현.
* 2009-01-22 O Wan-Ki 			1.2 Candidate 조회쿼리 보완.
* 2009-01-28 O Wan-Ki 			1.3 Interfaced by Name 추가.
* 2009-03-27 O Wan-Ki 			1.4 N200903170210, Cancel Flag 추가에 의한 보완.
* 2009-09-03 O Wan-Ki 			1.5 CHM-200900993, 조회대상컬럼 변경 
* 2009-09-14 Jong-Geon Byeon	1.6 Renewal Migration
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.jocandidateconfirm.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tpb.jocasemanage.jocandidateconfirm.basic.JOCandidateConfirmBCImpl;
import com.clt.apps.opus.esd.tpb.jocasemanage.jocandidateconfirm.vo.SearchJOCandidateConfirmListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  JOCandidateConfirmDBDAO <br>
 * - -CandidateManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author GUN-HA HWANG
 * @see JOCandidateConfirmBCImpl 참조
 * @since J2EE 1.6
 */
public class JOCandidateConfirmDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchJOCandidateConfirmListVO SearchJOCandidateConfirmListVO
	 * @return List<SearchJOCandidateConfirmListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchJOCandidateConfirmListVO> searchCandidateList(SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchJOCandidateConfirmListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchJOCandidateConfirmListVO != null){
				Map<String, String> mapVO = searchJOCandidateConfirmListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOCandidateConfirmDBDAOSearchJOCandidateConfirmListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchJOCandidateConfirmListVO .class);
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
	 * @param SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO
	 * @return List<SearchJOCandidateConfirmListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchJOCandidateConfirmListVO> searchCandidateUpdatedList(SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchJOCandidateConfirmListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchJOCandidateConfirmListVO != null){
				Map<String, String> mapVO = searchJOCandidateConfirmListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOCandidateConfirmDBDAOSearchJOUpdatedListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchJOCandidateConfirmListVO .class);
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
	 * @param List<SearchJOCandidateConfirmListVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyCandidateConfirm(List<SearchJOCandidateConfirmListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JOCandidateConfirmDBDAOModifyJOCandidateConfirmListUSQL(), updModels,null);
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
	 * @param SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO
	 * @return List<SearchJOCandidateConfirmListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchJOCandidateConfirmListVO> searchUpdatedList(SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchJOCandidateConfirmListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchJOCandidateConfirmListVO != null){
				Map<String, String> mapVO = searchJOCandidateConfirmListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOCandidateConfirmDBDAOSearchJOUpdatedListRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchJOCandidateConfirmListVO .class);

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
	 * @param SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String chkTrdPartyVal(SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtnValue = "";
		try{
			Map<String, String> mapVO = searchJOCandidateConfirmListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JOCandidateConfirmDBDAOSearchCheckTrdPartyRSQL(), param, velParam);
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
	 * @param List<SearchJOCandidateConfirmListVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyCandidateCancelList(List<SearchJOCandidateConfirmListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JOCandidateConfirmDBDAOModifyJOCandidateCancelConfirmListUSQL(), updModels,null);
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