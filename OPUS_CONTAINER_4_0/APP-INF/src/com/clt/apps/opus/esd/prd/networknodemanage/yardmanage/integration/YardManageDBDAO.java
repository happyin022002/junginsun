/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : YardManageDBDAO.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.basic.YardManageBCImpl;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchLeaseListVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchNodeListVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchYardDetailVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchZoneDetailVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchZonePostCodeVO;
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
 * @see YardManageBCImpl 참조
 * @since J2EE 1.4
 */
public class YardManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * YardManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param vo
	 * @return List
	 * @throws com.clt.framework.core.layer.integration.DAOException
	 */
	@SuppressWarnings( "rawtypes" )
	public List searchNodeList(SearchNodeListVO vo) throws DAOException {
		List list = new ArrayList();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new YardManageDBDAOSearchNodeListRSQL(), mapVO, mapVO, SearchNodeListVO.class);
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
	 * YardManageDBDAO's searchYardDetail
	 * 
	 * @param vo
	 * @return List
	 * @throws com.clt.framework.core.layer.integration.DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchYardDetailVO> searchYardDetail(SearchYardDetailVO vo) throws DAOException {
		List<SearchYardDetailVO> list = new ArrayList<SearchYardDetailVO>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new YardManageDBDAOSearchYardDetailRSQL(), mapVO, mapVO, SearchYardDetailVO.class);
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
	 * YardManageDBDAO's searchZoneDetail
	 * 
	 * @param vo
	 * @return List
	 * @throws com.clt.framework.core.layer.integration.DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchZoneDetailVO> searchZoneDetail(SearchZoneDetailVO vo) throws DAOException {
		List<SearchZoneDetailVO> list = new ArrayList<SearchZoneDetailVO>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new YardManageDBDAOSearchZoneDetailRSQL(), mapVO, mapVO, SearchZoneDetailVO.class);
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
	 * YardManageDBDAO's searchZonePostCode
	 * 
	 * @param vo
	 * @return List
	 * @throws com.clt.framework.core.layer.integration.DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchZonePostCodeVO> searchZonePostCode(SearchZonePostCodeVO vo) throws DAOException {
		List<SearchZonePostCodeVO> list = new ArrayList<SearchZonePostCodeVO>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new YardManageDBDAOSearchZonePostCodeRSQL(), mapVO, mapVO, SearchZonePostCodeVO.class);
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
	 * YardManageDBDAO's searchLeaseList
	 * 
	 * @param searchLeaseListRSQLVO
	 * @return List
	 * @throws com.clt.framework.core.layer.integration.DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchLeaseListVO> searchLeaseList(SearchLeaseListVO searchLeaseListRSQLVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLeaseListVO> list = new ArrayList<SearchLeaseListVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchLeaseListRSQLVO != null) {
				Map<String, String> mapVO = searchLeaseListRSQLVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new YardManageDBDAOSearchLeaseListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchLeaseListVO.class);
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
