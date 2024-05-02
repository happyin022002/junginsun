/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanLinkManageDBDAO.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.25
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2006-09-19 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
/*
 * 2010.10.25 진마리아 CHM-201006410-01 HQ Link Management Logic 변경 요청
 */
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.basic.OceanLinkManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkRHQVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkRHQVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * PRD에 대한 DB 처리를 담당<br>
 * PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kimyoungchul
 * @see OceanLinkManageBCImpl 참조
 * @since J2EE 1.4
 */
public class OceanLinkManageDBDAO extends DBDAOSupport {

	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -1;

	/**
	 * OceanLinkManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ★2009-09-14 kim kiwjin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOceanLinkVO> searchOceanLinkList(SearchOceanLinkVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOceanLinkVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkManageDBDAOSearchOceanLinkRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanLinkVO.class);
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
	 * chkSQL ★2009-09-15 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet oceanLinkSChk(SaveOceanLinkVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkChkSqlRSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * OceanLinkManageDBDAO's searchOceanLinkListRHQ ★2009-09-16 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOceanLinkRHQVO> searchOceanLinkListRHQ(SearchOceanLinkRHQVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOceanLinkRHQVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkManageDBDAOSearchOceanLinkRHQRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanLinkRHQVO.class);
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
	 * oceanLinkRHQInsert ★2009-09-17 kim kwijin생성
	 * 
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] oceanLinkRHQInsert(List<SaveOceanLinkRHQVO> insModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			if (insModels.size() > 0) {
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new OceanLinkManageDBDAORHQLinkInsertCSQL(), insModels, null);
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
	 * oceanLinkRHQUpdate ★2009-09-17 kim kwijin생성
	 * 
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] oceanLinkRHQUpdate(List<SaveOceanLinkRHQVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			if (updModels.size() > 0) {
				updCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new OceanLinkManageDBDAORHQLinkUpdateUSQL(), updModels, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update No" + i + " SQL");
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
	 * oceanLinkRHQUpdate2 ★2009-09-17 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQUpdate2(SaveOceanLinkRHQVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkUpdate2USQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * oceanLinkRHQUpdate3 ★2009-09-17 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQUpdate3(SaveOceanLinkRHQVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkUpdate3USQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * oceanLinkRHQUpdate4 ★2009-09-17 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQUpdate4(SaveOceanLinkRHQVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkUpdate4USQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * oceanLinkRHQUpdate5 ★2009-09-17 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQUpdate5(SaveOceanLinkRHQVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkUpdate5USQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * oceanLinkRHQDelete ★2009-09-17 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQDelete(SaveOceanLinkRHQVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkDeleteDSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00066")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;

	}

	/**
	 * oceanLinkRHQDelete2 ★2009-09-17 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQDelete2(SaveOceanLinkRHQVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkDelete2USQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;

	}

	/**
	 * oceanLinkRHQDelete3 ★2009-09-17 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQDelete3(SaveOceanLinkRHQVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkDelete3USQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;

	}

	/**
	 * oceanLinkRHQDelete4 ★2009-09-17 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQDelete4(SaveOceanLinkRHQVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkDelete4USQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;

	}

	/**
	 * oceanLinkRHQDelete5 ★2009-09-17 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQDelete5(SaveOceanLinkRHQVO vo) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkDelete5USQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;

	}

	/**
	 * OceanLinkManageDBDAO's historyOcnAddByLinkNo ★2009-09-15 kim kwijin수정
	 * 
	 * @param nPol
	 * @param nPod
	 * @param lane
	 * @param linkNo
	 * @return
	 * @throws DAOException int
	 */
	public int historyOcnAddByLinkNo(String nPol, String nPod, String lane, String linkNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			param.put("nPol", nPol);
			param.put("nPod", nPod);
			param.put("lane", lane);
			param.put("linkNo", linkNo);

			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOHistoryOcnAddLinkNoCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00064")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;

	}

	/**
	 * OceanLinkManageDBDAO's historyOcnFdrAddByLinkNo ★2009-09-17 kim kwijin수정
	 * 
	 * @param nPol
	 * @param nPod
	 * @param linkNo
	 * @return
	 * @throws DAOException
	 */
	public int historyOcnFdrAddByLinkNo(String nPol, String nPod, String linkNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			param.put("nPol", nPol);
			param.put("nPod", nPod);
			param.put("linkNo", linkNo);

			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOHistoryOcnFdrAddByLinkNoCSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00064")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * checkDupRhqLink
	 * 
	 * @param saveOceanLinkRHQVO
	 * @return
	 * @throws DAOException
	 */
	public int checkDupRhqLink(SaveOceanLinkRHQVO saveOceanLinkRHQVO) throws DAOException {
		DBRowSet dbRowset = null;
		int retVal = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			if (saveOceanLinkRHQVO != null) {
				Map<String, String> mapVO = saveOceanLinkRHQVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new OceanLinkManageDBDAOCheckDupRhqLinkRSQL(), param, null);
			if (dbRowset.next()) {
				retVal = dbRowset.getInt("dup_cnt");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("").getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("").getMessage());
		}
		return retVal;
	}
}
