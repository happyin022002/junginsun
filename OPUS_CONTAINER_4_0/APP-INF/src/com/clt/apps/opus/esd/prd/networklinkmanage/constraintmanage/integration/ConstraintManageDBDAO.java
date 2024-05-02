/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ConstraintManageDBDAO.java
 *@FileTitle : Node Constraint Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-16 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.basic.ConstraintManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.ConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchHubConstraintListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchLinkConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchNodeConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.clt.framework.component.common.AbstractValueObject;
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
 * @see ConstraintManageBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class ConstraintManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchNodeConstraintVO> searchNodeConstraintList(ConstraintVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchNodeConstraintVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOSearchNodeConstraintRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchNodeConstraintVO.class);
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
	 * NODE INSERT
	 * 
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] insertNode(List<SearchNodeConstraintVO> insModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOInsertNodeConstraintCSQL(), insModels, null);
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
	 * NODE UPDATE ★ 2009-08-19 KIM KWIJIN생성
	 * 
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateNode(List<SearchNodeConstraintVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOUpdateNodeConstraintUSQL(), updModels, null);
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
	 * NODE DELETE ★ 2009-08-19 KIM KWIJIN생성
	 * 
	 * @param delModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteNode(List<SearchNodeConstraintVO> delModels) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAODeleteNodeConstraintDSQL(), delModels, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to delete No" + i + " SQL");
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
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchLinkConstraintVO> searchLinkConstraintList(ConstraintVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLinkConstraintVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOSearchLinkConstraintRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchLinkConstraintVO.class);
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
	 * INSERT LINK
	 * 
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] insertLink(List<SearchLinkConstraintVO> insModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOInsertLinkConstraintCSQL(), insModels, null);
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
	 * UPDATE LINK ★2009-08-19 kim kwijin 생성
	 * 
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateLink(List<SearchLinkConstraintVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOUpdateLinkConstraintUSQL(), updModels, null);
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
	 * DELETE LINK ★2009-08-19 kim kwijin 생성
	 * 
	 * @param delModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteLink(List<SearchLinkConstraintVO> delModels) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAODeleteLinkConstraintUSQL(), delModels, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) {
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
		return delCnt;

	}

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchRouteConstraintVO> searchRouteConstraintList(ConstraintVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRouteConstraintVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOSearchRouteConstraintRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRouteConstraintVO.class);
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
	 * insertRoute
	 * 
	 * @param insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] insertRoute(List<SearchRouteConstraintVO> insModels) throws DAOException, Exception {
		int insCnt[] = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (insModels.size() > 0) {
				insCnt = new int[insModels.size()];
				SQLExecuter sqlExe = new SQLExecuter("");
				for (int i = 0; i < insModels.size(); i++) {
					Map<String, String> mapVO = insModels.get(i).getColumnValues();
					param.putAll(mapVO);
					insCnt[i] = sqlExe.executeUpdate((ISQLTemplate) new ConstraintManageDBDAOInsertRouteConstraintCSQL(), param, param);
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
	 * UPDATE ROUTE ★2009-08-19 KIM KWIJIN 생성
	 * 
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateRoute(List<SearchRouteConstraintVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOUpdateRouteConstraintUSQL(), updModels, null);
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
	 * DELETE ROUTE ★2009-08-19 KIM KWIJIN 생성
	 * 
	 * @param delModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteRoute(List<SearchRouteConstraintVO> delModels) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAODeleteRouteConstraintUSQL(), delModels, null);
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
	 * INSERT UPDATE ROUTE
	 * 
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] insertUpdateRoute(List<SearchRouteConstraintVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ConstraintManageDBDAOInsertUpdateConstraintUSQL(), updModels, null);
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
	 * chkPs ★2009-08-19 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet chkPs(SearchRouteConstraintVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);

				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOCheckPsRSQL(), param, velParam);

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
	 * chkPsNODE ★2009-08-19 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet chkPsNode(SearchNodeConstraintVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOCheckPsNodeRSQL(), param, velParam);
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
	 * chkPsLINK ★2009-08-19 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet chkPsLink(SearchLinkConstraintVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOCheckPsLinkRSQL(), param, velParam);
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
	 * get MAX SEQ ★2009-08-19 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet getMaxSeq(SearchRouteConstraintVO vo) throws DAOException {
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOGetMaxSeqRSQL(), param, velParam);

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
	 * ConstraintManageDBDAO's checkCommodity ★ 2009-08-20 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CheckCommodityVO> checkCommodity(CheckCommodityVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckCommodityVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOCheckCommodityRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckCommodityVO.class);
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
	 * insertNode
	 * 
	 * @param searchNodeConstraintVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int insertNode(SearchNodeConstraintVO searchNodeConstraintVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchNodeConstraintVO != null) {
				Map<String, String> mapVO = searchNodeConstraintVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new ConstraintManageDBDAOInsertNodeConstraintCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00064")).getMessage());
			}
			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * insertLink
	 * 
	 * @param searchLinkConstraintVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int insertLink(SearchLinkConstraintVO searchLinkConstraintVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchLinkConstraintVO != null) {
				Map<String, String> mapVO = searchLinkConstraintVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new ConstraintManageDBDAOInsertLinkConstraintCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00064")).getMessage());
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * insertRoute
	 * 
	 * @param searchRouteConstraintVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int insertRoute(SearchRouteConstraintVO searchRouteConstraintVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchRouteConstraintVO != null) {
				Map<String, String> mapVO = searchRouteConstraintVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new ConstraintManageDBDAOInsertRouteConstraintCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00064")).getMessage());
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * insertUpdateRoute
	 * 
	 * @param searchRouteConstraintVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int insertUpdateRoute(SearchRouteConstraintVO searchRouteConstraintVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (searchRouteConstraintVO != null) {
				Map<String, String> mapVO = searchRouteConstraintVO.getColumnValues();
				param.putAll(mapVO);
			}
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new ConstraintManageDBDAOInsertUpdateConstraintUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00064")).getMessage());
			}
			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<AbstractValueObject> searchHubConstraintList(ConstraintVO vo) throws DAOException {
		try {
			Map<String, String> param = vo.getColumnValues();
			return new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOSearchHubConstraintListRSQL(), param, param, SearchHubConstraintListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Search Constraint - Duplicate Check
	 * 
	 * @param constraintListVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public boolean searchHubConstraintDupCheck(SearchHubConstraintListVO constraintListVO) throws DAOException, Exception {
		DBRowSet dbRowSet = null;
		try {
			HashMap<String, String> params = constraintListVO.getColumnValues();
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOSearchHubConstraintDupCheckRSQL(), params, params);
			dbRowSet.next();
			return dbRowSet.getInt("cnt") > 0 ? true : false;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Hub Constraint - ADD
	 * 
	 * @param constraintListVOs
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addHubConstraint(List<SearchHubConstraintListVO> constraintListVOs) throws DAOException, Exception {
		int batchCnt[] = null;
		try {
			if (constraintListVOs.size() > 0) {
				batchCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ConstraintManageDBDAOAddHubConstraintCSQL(), constraintListVOs, null);
				for (int i = 0; i < batchCnt.length; i++) {
					if (batchCnt[i] == Statement.EXECUTE_FAILED) {
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
		return batchCnt;
	}

	/**
	 * Hub Constraint - Modify
	 * 
	 * @param constraintListVOs
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyHubConstraint(List<SearchHubConstraintListVO> constraintListVOs) throws DAOException, Exception {
		int batchCnt[] = null;
		try {
			if (constraintListVOs.size() > 0) {
				batchCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ConstraintManageDBDAOModifyHubConstraintUSQL(), constraintListVOs, null);
				for (int i = 0; i < batchCnt.length; i++) {
					if (batchCnt[i] == Statement.EXECUTE_FAILED) {
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
		return batchCnt;
	}

	/**
	 * Hub Constraint - Remove
	 * 
	 * @param constraintListVOs
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeHubConstraint(List<SearchHubConstraintListVO> constraintListVOs) throws DAOException, Exception {
		int batchCnt[] = null;
		try {
			if (constraintListVOs.size() > 0) {
				batchCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new ConstraintManageDBDAORemoveHubConstraintDSQL(), constraintListVOs, null);
				for (int i = 0; i < batchCnt.length; i++) {
					if (batchCnt[i] == Statement.EXECUTE_FAILED) {
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
		return batchCnt;
	}

	/**
	 * 
	 * @param constraintVO
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchContainerTypeSize(ConstraintVO constraintVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cntr_tp_cd", constraintVO.getCntrTpCd());
			param.put("cntr_sz_cd", constraintVO.getCntrSzCd());
			param.put("p_gubun", constraintVO.getpGubun());
			return new SQLExecuter("").executeQuery((ISQLTemplate) new ConstraintManageDBDAOSearchContainerTypeSizeRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
