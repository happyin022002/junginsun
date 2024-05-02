/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandRouteManageDBDAO.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-04
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-04 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteMstVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.GetReferenceNoVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteSelCreVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchEmptyMasterVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchInlandRouteManageVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchMasterVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchEmptyInlandRouteMasterListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchInlandRouteManageAsiaEuVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * PRD에 대한 DB 처리를 담당<br>
 * PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * @author jungsunyong
 * @see InlandRouteManageBCImpl 참조
 * @since J2EE 1.4
 */
public class InlandRouteManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * InlandRouteManage의 ROW을 가져온다.<br>
	 * ★2009-08-13 KIM KWIJIN 생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RowSearchInlandRouteManageVO> rowSearchInlandRouteManage(RowSearchInlandRouteManageVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RowSearchInlandRouteManageVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAORowSearchInlandRouteManageRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, RowSearchInlandRouteManageVO.class);
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
	 * InlandRouteManage의 ROW을 가져온다.<br>
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws DAOException ★ 2009-08-12 kim kwijin
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RowSearchMasterVO> rowSearchMaster(InlandRouteMsUSVO inlandRouteMsUSVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RowSearchMasterVO> list = new ArrayList<RowSearchMasterVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (inlandRouteMsUSVO != null) {
				param.putAll(inlandRouteMsUSVO.getColumnValues());
				dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageDBDAORowSearchMasterRSQL(), param, null);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, RowSearchMasterVO.class);
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
	 * InlandRouteManage의 ROW을 가져온다.<br>
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public String searchPrioSeq(InlandRouteMsUSVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuilder retVal = new StringBuilder();
		int row_cnt = 0;
		int max_prio_seq = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOSearchPrioSeqRSQL(), param, velParam);
				if (dbRowset.next()) {
					row_cnt = dbRowset.getInt("row_cnt");
					max_prio_seq = dbRowset.getInt("max_prio_seq");
				}
				if (max_prio_seq < row_cnt) {
					for (int i = 0; i <= row_cnt; i++) {
						retVal.append(i).append("|");
					}
				} else {
					for (int i = 0; i <= max_prio_seq; i++) {
						retVal.append(i).append("|");
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
		return retVal.toString();

	}

	/**
	 * InlandRouteManage의 모든 목록을 가져온다.<br>
	 * @param inlandRouteDetVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InlandRouteDetVO> searchInlandRouteManage(InlandRouteDetVO inlandRouteDetVO) throws DAOException {
		List<InlandRouteDetVO> list = null;
		try {
			Map<String, String> param = inlandRouteDetVO.getColumnValues();
			list = (List) RowSetUtil.rowSetToVOs(new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOInlandRouteDetRSQL(), param, param), InlandRouteDetVO.class);
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
	 * InlandRouteManage의 데이타 모델에 해당되는 값을 불러온다(아시아/유럽).<br>
	 * ★2009-09-08 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchInlandRouteManageAsiaEuVO> searchInlandRouteManageList(SearchConditionVO vo) throws DAOException {
		List<SearchInlandRouteManageAsiaEuVO> list = null;
		try {
			Map<String, String> param = vo.getColumnValues();
			list = (List) RowSetUtil.rowSetToVOs(new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOSearchInlandRouteManageAsiaEuRSQL(), param, param),
					SearchInlandRouteManageAsiaEuVO.class);
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
	 * InlandRouteManage의 데이타 모델에 해당되는 값을 불러온다. ★ 2009/07/29 kim kwi-jin 생성
	 * @param inlandRouteVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InlandRouteVO> searchInlandRouteManageList01(InlandRouteVO inlandRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlandRouteVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inlandRouteVO != null) {
				Map<String, String> mapVO = inlandRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOInlandRouteRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InlandRouteVO.class);
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
	 * update asia eu ★2009-09-09 kim kwijin생성
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateAsiaEuPs(List<SearchInlandRouteManageAsiaEuVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new InlandRouteManageDBDAOInlandRouteUpdateAsiaEuUSQL(), updModels, null);
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
	 * undelupdate asia eu ★2009-09-09 kim kwijin생성
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateUndelAsiEu(List<SearchInlandRouteManageAsiaEuVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new InlandRouteManageDBDAOInlandRouteUndelUpdateAsioEuUSQL(), updModels, null);
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
	 * strDelUpdAsiaEu ★2009-09-09 kim kwijin생성
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] strDelUpdAsiaEu(List<SearchInlandRouteManageAsiaEuVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new InlandRouteManageDBDAOInlandRouteStrDelUpdAsiaEuUSQL(), updModels, null);
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
	 * UPDATE EMPTYPS ★2009-08-24 KIM KWIJIN생성
	 * @param updModels
	 * @return
	 * @throws DAOException
	 */
	public int[] updateEmptyPs(List<EmptySaveInlandRouteMstVO> updModels) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new InlandRouteManageDBDAOUpdateEmptyPsUSQL(), updModels, null);
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
	 * UPDATE UNDEL EMPTY PS ★2009-08-24 KIM KWIJIN생성
	 * @param updModels
	 * @return
	 * @throws DAOException
	 */
	public int[] undelUpdateEmptyPs(List<EmptySaveInlandRouteMstVO> updModels) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new InlandRouteManageDBDAOUnDelUpdateEmptyPsUSQL(), updModels, null);
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
	 * selectPs
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws DAOException ★2009-08-11 kimkwijin
	 */
	public Map<String, String> selectPs(InlandRouteMsUSVO inlandRouteMsUSVO) throws DAOException {
		Map<String, String> retVal = new HashMap<String, String>();
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (inlandRouteMsUSVO != null) {
				Map<String, String> mapVO = inlandRouteMsUSVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOGetNewRouteSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				String i_rout_seq = dbRowset.getString("next_rout_seq");
				String prioSeq = dbRowset.getString("next_prio_seq");

				retVal.put("next_rout_seq", i_rout_seq);
				retVal.put("next_prio_seq", prioSeq);
			}
			return retVal;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * insertquery1
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int insertPs1(InlandRouteMsUSVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter().executeUpdate((ISQLTemplate) new InlandRouteManageDBDAOInsert1PsCSQL(), param, null);
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
	 * updatePs
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int updatePs(InlandRouteMsUSVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter().executeUpdate((ISQLTemplate) new InlandRouteManageDBDAOUpdatePsUSQL(), param, param);
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
	 * deletePs
	 * @param vo
	 * @return
	 * @throws DAOException ★2009-08-11 kimkwijin
	 */
	public int deletePs(InlandRouteMsUSVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new InlandRouteManageDBDAODeletePsDSQL(), param, velParam);
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
	 * checkPs
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws DAOException ★2009-08-11 kimkwijin
	 */
	public String checkPs(InlandRouteMsUSVO inlandRouteMsUSVO) throws DAOException {
		String retVal = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inlandRouteMsUSVO != null) {
				Map<String, String> mapVO = inlandRouteMsUSVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOCheckPsRSQL(), param, velParam);

			if (dbRowset.next()) {
				retVal = dbRowset.getString(1);
			}

			return retVal;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * insert2ps
	 * @param insModels
	 * @throws DAOException
	 * @throws Exception ★2009-08-11 kim kwijin
	 */
	public void insert2Ps(List<InlandRouteUSDetVO> insModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			if (insModels.size() > 0) {
				insCnt = new SQLExecuter().executeBatch((ISQLTemplate) new InlandRouteManageDBDAOInsert2PsCSQL(), insModels, null);
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
		// return insCnt;
	}

	/**
	 * InlandRouteManageDBDAO's isPseudoYard
	 * @param vo
	 * @return
	 * @throws DAOException ★ 2009-08-11 kim kwijin
	 */
	public boolean isPseudoYard(InlandRouteMsUSVO vo) throws DAOException {
		boolean retVal = false;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOIsPseudoYardRSQL(), param, velParam);

			if (dbRowset.next()) {
				if (dbRowset.getString("ORG").equals("Y") || dbRowset.getString("DEST").equals("Y")) {
					retVal = true;
				}
			}

			return retVal;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * InlandRouteManageDBDAO's isPseudoYard ★2009-08-25 kim kwijin수정
	 * @param orgNode
	 * @param destNode
	 * @return
	 * @throws DAOException boolean
	 */
	public boolean isPseudoYard(String orgNode, String destNode) throws DAOException {

		boolean retVal = false;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		try {

			param.put("i_rout_org_nod_cd", orgNode);
			param.put("i_rout_dest_nod_cd", destNode);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOIsPseudoYardRSQL(), param, null);

			if (dbRowset.next()) {
				if (dbRowset.getString("ORG").equals("Y") || dbRowset.getString("DEST").equals("Y")) {
					retVal = true;
				}
			}

			return retVal;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * InlandRouteManageDBDAO's upDateHubLoc
	 * @param vo
	 * @throws DAOException ★2009-08-12 KIM KWIJIN
	 */
	public void upDateHubLoc(InlandRouteMsUSVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new InlandRouteManageDBDAOUpdateHubLocUSQL(), param, velParam);
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
		// return result;
	}

	/**
	 * InlandRouteManageDBDAO's isDoorTml
	 * @param tml
	 * @return
	 * @throws DAOException boolean ★ 2009-08-11 kimkwijin
	 */
	public boolean isDoorTml(String tml) throws DAOException {
		boolean isDoor = false;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("nod_cd", tml);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOisDoorTmlRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (dbRowset.getString("nod_tp_cd").equals("Z")) {
					isDoor = true;
				}
			}
			return isDoor;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * empty get rout seq ★2009-08-25 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEmptyRoutSeq(EmptySaveInlandRouteDetVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOSearchEmptyRoutSeqRSQL(), param, velParam);
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
	 * empty inland rout insert1 ps ★2009-08-25 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int insert1Empty1Ps(EmptySaveInlandRouteDetVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new InlandRouteManageDBDAOInsert1Empty1PsCSQL(), param, null);
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
	 * empty inland route det update
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int updateEmptyDetPs(EmptySaveInlandRouteDetVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			int result = new SQLExecuter().executeUpdate((ISQLTemplate) new InlandRouteManageDBDAOUpdateEmptyDetPsUSQL(), param, null);
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
	 * empty inlnad route det delete ★2009-08-25 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int deleteEmptyDetPs(EmptySaveInlandRouteDetVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new InlandRouteManageDBDAODeleteEmptyDetPsDSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00066")).getMessage());
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
	 * empty inland route check det ps ★ 2009-08-25 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet checkEmptyDetPs(EmptySaveInlandRouteDetVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageDBDAOCheckEmptyDetPsRSQL(), param, null);

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
	 * empty inland route det insert2 ★2009-08-25 kim kwijin생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 */
	public int[] insertEmpty2Ps(List<EmptySaveInlandRouteDetVO> insModels) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new InlandRouteManageDBDAOInsertEmpty2PsCSQL(), insModels, null);
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
	 * check port ★ 2009-09-01 kim kwijin생성
	 * @param iOrgCd
	 * @param iDestCd
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet portChk(String iOrgCd, String iDestCd) throws DAOException {
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("i_org_cd", iOrgCd);
			mapVO.put("i_dest_cd", iDestCd);
			return new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOInlandRoutePortChkRSQL(), mapVO, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * check hub ★2009-09-01 kim kwijin생성
	 * @param fromChk
	 * @param iOrgCd
	 * @param toChk
	 * @param iDestCd
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet hubChk(String fromChk, String iOrgCd, String toChk, String iDestCd) throws DAOException {
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("i_org_cd", iOrgCd);
			mapVO.put("i_dest_cd", iDestCd);
			mapVO.put("fromChk", fromChk);
			mapVO.put("toChk", toChk);
			return new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOInlandRouteHubChkRSQL(), mapVO, null);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * InlandRouteManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ★ 2009-09-01 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<InlandRouteSelCreVO> searchInlandRouteManageCreateList(InlandRouteSelCreVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlandRouteSelCreVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOInlandRouteSelCreRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InlandRouteSelCreVO.class);
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
	 * InlandRouteManageDBDAO's getReferenceNo ★ 2009-08-13 kim kwijin
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<GetReferenceNoVO> getReferenceNo(GetReferenceNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<GetReferenceNoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOGetReferenceNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GetReferenceNoVO.class);
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
	 * save as selectps ★2009-08-28 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet inlandRouteSaveAsSelectPs(InlandRouteMsUSVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOInlandRouteUsSaveAsSelectPsRSQL(), param, velParam);
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
	 * inland route mst save as insert ★2009-08-28 kim kwijin생성
	 * @param vo
	 * @throws DAOException
	 */
	public void inlandRouteSaveAsInsert1(InlandRouteMsUSVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = new SQLExecuter().executeUpdate((ISQLTemplate) new InlandRouteManageDBDAOInlandRouteSaveAsUsInsert1PsCSQL(), param, velParam);
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
		// return result;

	}

	/**
	 * inland route det save as insert ★2009-08-28 kim kwijin생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 */
	public int[] inlandRouteSaveAsInsert2(List<InlandRouteUSDetVO> insModels) throws DAOException {
		int insCnt[] = null;
		try {
			if (insModels.size() > 0) {
				insCnt = new SQLExecuter().executeBatch((ISQLTemplate) new InlandRouteManageDBDAOInlandRouteSaveAsUsInsert2PsCSQL(), insModels, null);
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
	 * inlnad route save as last check ★2009-08-28 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet inlandRouteSaveAsCheckLastPs(InlandRouteMsUSVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOInlandRouteSaveAsUSCheckLastPsRSQL(), param, velParam);
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
	 * ★2009-08-10 kim kwijin InlandRouteManageDBDAO's getInLandRouteExistCount
	 * @param e
	 * @return
	 * @throws DAOException DBRowSet
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DBRowSet getInLandRouteExistCount(InlandRouteMsUSVO inlandRouteMsUSVO, InlandRouteUSDetVO[] InlandRouteUSDetVOs) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (inlandRouteMsUSVO != null) {
				inlandRouteMsUSVO.setiWrsFlCd(inlandRouteMsUSVO.getWrsFChk());
				Map<String, String> mapVO = inlandRouteMsUSVO.getColumnValues();
				param.putAll(mapVO);
				List vals = new ArrayList();
				if (InlandRouteUSDetVOs != null) {
					for (int i = 1; i <= InlandRouteUSDetVOs.length; i++) {
						Map itm = new HashMap();
						itm.put("a", i);
						itm.put("lnk_org_loc", InlandRouteUSDetVOs[i - 1].getLnkOrgLoc());
						itm.put("lnk_org_type", InlandRouteUSDetVOs[i - 1].getLnkOrgType());
						itm.put("trsp_mod_cd", InlandRouteUSDetVOs[i - 1].getTrspModCd());
						itm.put("vndr_seq", InlandRouteUSDetVOs[i - 1].getVndrSeq());
						itm.put("agmt_no", InlandRouteUSDetVOs[i - 1].getAgmtNo());
						itm.put("inlnd_rout_cmb_flg", JSPUtil.getNull(InlandRouteUSDetVOs[i - 1].getCombinedMd()).equals("1") ? "Y" : "N");
						itm.put("rail_crr_tp_cd", InlandRouteUSDetVOs[i - 1].getRailCrrTpCd());
						itm.put("inlnd_rout_junc_nm", InlandRouteUSDetVOs[i - 1].getInlndRoutJuncNm());
						vals.add(itm);
					}
				}
				velParam.put("param_val", vals);
				velParam.put("param_size", (InlandRouteUSDetVOs == null) ? "0" : InlandRouteUSDetVOs.length + "");
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageUsaDBDAOInlandRouteMsUSRSQL(), param, velParam);
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
	 * InlandRouteManageDBDAO's getEmptyInLandRouteExistCount
	 * @param vos
	 * @param vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DBRowSet getEmptyInLandRouteExistCount(EmptySaveInlandRouteDetVO[] vos, EmptySaveInlandRouteDetVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				List vals = new ArrayList();
				for (int i = 1; i <= vos.length; i++) {
					Map itm = new HashMap();
					itm.put("a", i);
					itm.put("ibflag", vos[i - 1].getIbflag());
					itm.put("lnk_org_loc", vos[i - 1].getLnkOrgLoc());
					itm.put("lnk_org_type", vos[i - 1].getLnkOrgType());
					itm.put("lnk_dest_loc", vos[i - 1].getLnkDestLoc());
					itm.put("lnk_dest_type", vos[i - 1].getLnkDestType());
					itm.put("trsp_mod_cd", vos[i - 1].getTrspModCd());
					itm.put("vndr_seq", vos[i - 1].getVndrSeq());
					itm.put("agmt_no", vos[i - 1].getAgmtNo());
					itm.put("inlnd_rout_cmb_flg", JSPUtil.getNull(vos[i - 1].getInlndRoutCmbFlg()).equals("1") ? "Y" : "N");
					itm.put("rail_crr_tp_cd", vos[i - 1].getRailCrrTpCd());
					itm.put("inlnd_rout_junc_nm", vos[i - 1].getInlndRoutJuncNm());
					vals.add(itm);
				}
				velParam.put("param_val", vals);
				velParam.put("param_size", vos.length + "");
				velParam.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOGetEmptyInlandRouteExistCountRSQL(), param, velParam);
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
	 * ★ 2009-08-10 kim kwijin
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int getInLandRouteRemarkCompare(InlandRouteMsUSVO inlandRouteMsUSVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlandRouteMsUSVO> list = new ArrayList<InlandRouteMsUSVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		String cnt = "";
		int retCnt = 0;
		String i_route_rmk = "";
		try {
			if (inlandRouteMsUSVO != null) {
				i_route_rmk = inlandRouteMsUSVO.getIRouteRmk();
				Map<String, String> mapVO = inlandRouteMsUSVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageUsaDBDAOInlandRouteRemarkCompareRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InlandRouteMsUSVO.class);
			if (list.size() > 0) {
				cnt = list.get(0).getCnt();
			}

			if (cnt.equals(i_route_rmk)) {
				retCnt = 0;
			} else {
				retCnt = 1;
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retCnt;

	}

	/**
	 * updateRemark
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int updateRemark(InlandRouteMsUSVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter().executeUpdate((ISQLTemplate) new InlandRouteManageDBDAOUpdateRemarkUSQL(), param, null);
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
	 * InlandRouteManageDBDAO's updateEmptyRemark ★2009-08-25 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int updateEmptyRemark(EmptySaveInlandRouteDetVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter().executeUpdate((ISQLTemplate) new InlandRouteManageDBDAOUpdateEmptyRemarkUSQL(), param, null);
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
	 * InlandRouteManageDBDAO's searchEmptyInlandRouteManageList
	 * @param fromCd
	 * @param toCd
	 * @param wrsFlg
	 * @param delFlg
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchEmptyInlandRouteMasterListVO> searchEmptyInlandRouteManageList(String fromCd, String toCd, String wrsFlg, String delFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEmptyInlandRouteMasterListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("fromCd", fromCd);
			param.put("toCd", toCd);
			param.put("wrsFlg", wrsFlg);
			param.put("delFlg", delFlg);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOSearchEmptyInlandRouteMasterListRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchEmptyInlandRouteMasterListVO.class);
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
	 * InlandRouteManageDBDAO's rowSearchEmptyMaster ★2009-08-25 kim kwijin 생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RowSearchEmptyMasterVO> rowSearchEmptyMaster(EmptySaveInlandRouteDetVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RowSearchEmptyMasterVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAORowSearchEmptyMasterRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RowSearchEmptyMasterVO.class);
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
	 * getInlandRoutAddItems ★2009-10-12 kim kwijin생성
	 * @param String iRoutOrgNodCd
	 * @param String iRoutDestNodCd
	 * @param String iRoutSeq
	 * @return Map<String, String>
	 * @throws DAOException
	 */
	public Map<String, String> getInlandRoutAddItems(String iRoutOrgNodCd, String iRoutDestNodCd, String iRoutSeq) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, String> res = new HashMap<String, String>();

		try {
			param.put("i_rout_org_nod_cd", iRoutOrgNodCd);
			param.put("i_rout_dest_nod_cd", iRoutDestNodCd);
			param.put("i_rout_seq", iRoutSeq);

			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageDBDAOGetInlandRouteAddItemsRSQL(), param, null);
			if (dbRowset.next()) {
				res.put("fullRtnYdCd", dbRowset.getString("FULL_RTN_YD_CD"));
				res.put("fullPkupYdCd", dbRowset.getString("FULL_PKUP_YD_CD"));
				res.put("trspModCd", dbRowset.getString("TRSP_MOD_CD"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return res;
	}

	/**
	 * updateInlandRoutAddItems ★2009-10-12 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int updateInlandRoutAddItems(InlandRouteMsUSVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = new SQLExecuter().executeUpdate((ISQLTemplate) new InlandRouteManageDBDAOUpdateInlandRoutAddItemsUSQL(), param, velParam);
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
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int updatePrdInlndRoutMst(InlandRouteMsUSVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = new SQLExecuter().executeUpdate((ISQLTemplate) new InlandRouteManageDBDAOUpdatePrdInlndRoutMstUSQL(), param, velParam);
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
	 * EMPTY WRS CHECK ★2009-08-24 KIM KWIJIN생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet checkEmptyWrs(EmptySaveInlandRouteMstVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageDBDAOCheckEmptyWrsRSQL(), param, null);
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
	 * check empty wrs ★ 2009-08-25 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */

	public DBRowSet checkEmptyWrs(EmptySaveInlandRouteDetVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageDBDAOCheckEmptyWrsRSQL(), param, null);
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
	 * chkwrs1
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws DAOException ★2009-08-11 kimkwijin
	 */
	public String checkWrs(InlandRouteMsUSVO inlandRouteMsUSVO) throws DAOException {
		String retVal = "";
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (inlandRouteMsUSVO != null) {
				Map<String, String> mapVO = inlandRouteMsUSVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageDBDAOCheckWrsRSQL(), param, velParam);
			if (dbRowset.next()) {
				retVal = dbRowset.getString("WRS_F_CHK");
			}
			return retVal;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * check wrs2
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws DAOException
	 */
	public String checkWrs2(InlandRouteMsUSVO inlandRouteMsUSVO) throws DAOException {
		String retVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (inlandRouteMsUSVO != null) {
				Map<String, String> mapVO = inlandRouteMsUSVO.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageDBDAOCheckWrs2RSQL(), param, null);
			if (dbRowset.next()) {
				retVal = dbRowset.getString("WRS_F_CHK");
			}
			return retVal;
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
	 * @param lnkOrgNodCd
	 * @param lnkDestNodCd
	 * @param trspModCd
	 * @return
	 * @throws DAOException
	 */
	public boolean validCheckPrdInlndEachLink(String lnkOrgNodCd, String lnkDestNodCd, String trspModCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		boolean isExist = false;
		try {
			param.put("lnk_org_nod_cd", lnkOrgNodCd);
			param.put("lnk_dest_nod_cd", lnkDestNodCd);
			param.put("trsp_mod_cd", trspModCd);
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageDBDAOValidCheckPrdInlndEachLinkRSQL(), param, null);
			if (dbRowset.next()) {
				isExist = dbRowset.getInt(1) > 0 ? true : false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isExist;

	}
}
