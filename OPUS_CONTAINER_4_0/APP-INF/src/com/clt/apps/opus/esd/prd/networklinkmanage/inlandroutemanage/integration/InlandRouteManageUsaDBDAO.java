/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandRouteManageDBDAO.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-08-03
 *@LastModifier : kim kwi-jin
 *@LastVersion : 1.0
 * 2006-09-04 jungsunyong
 * 1.0 최초 생성
 * 2009-08-03 kim kwi-jin
 * 1.1 수정
 *
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.CheckWrsVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
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
 * @author jungsunyong
 * @see InlandRouteManageBCImpl 참조
 * @since J2EE 1.4
 */
public class InlandRouteManageUsaDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * InlandRouteManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param inlandRouteUSVO
	 * @return
	 * @throws DAOException ★ 2009/08/03 kim kwi-jin 생성
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<lnlandRouteUSVO> searchInlandRouteMasterUSA(lnlandRouteUSVO inlandRouteUSVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<lnlandRouteUSVO> list = new ArrayList<lnlandRouteUSVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inlandRouteUSVO != null) {
				Map<String, String> mapVO = inlandRouteUSVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOlnlandRouteUSRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, lnlandRouteUSVO.class);
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
	 * InlandRouteManageUsaDBDAO's searchInlandRouteDetailUSA
	 * 
	 * @param searchConditionVO
	 * @return
	 * @throws DAOException 2009-08-05 kim kiwjin 생성
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<InlandRouteUSDetVO> searchInlandRouteDetailUSA(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InlandRouteUSDetVO> list = new ArrayList<InlandRouteUSDetVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (searchConditionVO != null) {
				Map<String, String> mapVO = searchConditionVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageUsaDBDAOInlandRouteUSDetRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InlandRouteUSDetVO.class);
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
	 * InlandRouteManageUsaDBDAO's saveInlandRouteMasterUSA01
	 * 
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] saveInlandRouteMasterUSA01(List<lnlandRouteUSVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			if (updModels.size() > 0) {
				updCnt = new SQLExecuter().executeBatch((ISQLTemplate) new InlandRouteManageUsaDBDAOInlandRouteUSC1USQL(), updModels, null);
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
	 * InlandRouteManageUsaDBDAO's saveInlandRouteMasterUSA02
	 * 
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] saveInlandRouteMasterUSA02(List<lnlandRouteUSVO> updModels) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			if (updModels.size() > 0) {
				updCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new InlandRouteManageUsaDBDAOInlandRouteUSC2USQL(), updModels, null);
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
	 * InlandRouteManageUsaDBDAO's saveInlandRoutePriorityUSA<br>
	 * 2009-08-06 kim kwijin 생성
	 * 
	 * @param inlandRouteUSVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] saveInlandRoutePriorityUSA(List<lnlandRouteUSVO> inlandRouteUSVOs) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			if (inlandRouteUSVOs.size() > 0) {
				updCnt = new SQLExecuter("").executeBatch((ISQLTemplate) new InlandRouteManageUsaDBDAOInlandRouteUSUSQL(), inlandRouteUSVOs, null);
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
	 * CHECK WRS
	 * 
	 * @param checkWrsVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CheckWrsVO> getChkWrs(CheckWrsVO checkWrsVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckWrsVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (checkWrsVO != null) {
				Map<String, String> mapVO = checkWrsVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new InlandRouteManageUsaDBDAOCheckWrsRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckWrsVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}
