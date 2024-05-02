/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : HubLocationMatchingManageDBDAO.java
 *@FileTitle : HubLocation 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-30
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-08-30 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.basic.HubLocationMatchingManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.vo.SearchHubLocationListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.utility.CheckUtilities;

/**
 * PRD에 대한 DB 처리를 담당<br>
 * PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author jungsunyong
 * @see HubLocationMatchingManageBCImpl 참조
 * @since J2EE 1.4
 */
public class HubLocationMatchingManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * HubLocationMatchingManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param searchHubLocationListVO
	 * @return List<ApPayInvVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchHubLocationListVO> searchHubLocationMatchingManage(SearchHubLocationListVO searchHubLocationListVO) throws DAOException {
		List<SearchHubLocationListVO> list = new ArrayList<SearchHubLocationListVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchHubLocationListVO != null) {
				if (!CheckUtilities.isInBlank(searchHubLocationListVO.getInPortCd()) || !CheckUtilities.isInBlank(searchHubLocationListVO.getInHubLocCd()) || !CheckUtilities.isInBlank(searchHubLocationListVO.getInLocCd())) {
					Map<String, String> mapVO = searchHubLocationListVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new HubLocationMatchingManageDBDAOSearchHubLocationListRSQL(), param, velParam, SearchHubLocationListVO.class);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * hub location<br>
	 * 2009/07/28 kim kwi-jin
	 * 
	 * @param insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 * */
	public int[] addHubLocationSaveS(List<SearchHubLocationListVO> insModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new HubLocationMatchingManageDBDAOHubLocationCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * hub location <br>
	 * 2009/07/28 kim kwi-jin
	 * 
	 * @param updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 * */
	public int[] modifyHubLocationSaveS(List<SearchHubLocationListVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new HubLocationMatchingManageDBDAOHubLocationUSQL(), updModels, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * hub location <br>
	 * 2009/07/28 kim kwi-jin
	 * 
	 * @param delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 * */
	public int[] removeHubLocationSaveS(List<SearchHubLocationListVO> delModels) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new HubLocationMatchingManageDBDAOHubLocationDSQL(), delModels, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * @param insertVoList
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int checkHubLocation(SearchHubLocationListVO insertVoList) throws DAOException, Exception {
		int chkCnt = 0;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (insertVoList != null) {
				Map<String, String> mapVO = insertVoList.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new HubLocationMatchingManageDBDAOCheckHubLocationRSQL(), param, velParam);
			// chkCnt = dbRowset.getRowCount();
			if (dbRowset.next()) {
				chkCnt = dbRowset.getInt("cnt");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chkCnt;

	}
}
