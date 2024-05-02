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
 * 2009-07-13 alps framework 구조 변경 noh seung bae
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration.CgmCodeMgtDBDAOModifyCPSCHSSPoolDataUSQL;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration.CgmCodeMgtDBDAOSearchCPSCHSSPoolListDataRSQL;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.basic.YardManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event.EsdPrd0008Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event.EsdPrd0088Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchLeaseListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchNodeDefaultSpInfoListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchNodeListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchYardDetailVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchYardDwellHistoryVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchZoneDetailVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchZonePostCodeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * alps-PRD에 대한 DB 처리를 담당<br>
 * - alps-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kimyoungchul
 * @see YardManageBCImpl 참조
 * @since J2EE 1.4
 */
public class YardManageDBDAO extends DBDAOSupport{

	/**
	 * YardManage의 모든 목록을 가져온다.<br>
	 * 
	 * @param vo
	 * @return List
	 * @throws com.hanjin.framework.core.layer.integration.DAOException
	 */
	public List searchNodeList(SearchNodeListVO vo) throws DAOException{
		List<SearchYardDetailVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new YardManageDBDAOSearchNodeListRSQL(), mapVO, mapVO, SearchNodeListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
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
	 * @throws com.hanjin.framework.core.layer.integration.DAOException
	 */
	public List searchYardDetail(SearchYardDetailVO vo) throws DAOException{
		List<SearchYardDetailVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new YardManageDBDAOSearchYardDetailRSQL(), mapVO, mapVO, SearchYardDetailVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
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
	 * @throws com.hanjin.framework.core.layer.integration.DAOException
	 */
	public List searchZoneDetail(SearchZoneDetailVO vo) throws DAOException{
		List<SearchZoneDetailVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new YardManageDBDAOSearchZoneDetailRSQL(), mapVO, mapVO, SearchZoneDetailVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
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
	 * @throws com.hanjin.framework.core.layer.integration.DAOException
	 */
	public List searchZonePostCode(SearchZonePostCodeVO vo) throws DAOException{
		List<SearchZonePostCodeVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new YardManageDBDAOSearchZonePostCodeRSQL(), mapVO, mapVO, SearchZonePostCodeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
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
	 * @throws com.hanjin.framework.core.layer.integration.DAOException
	 */
	public List searchLeaseList(SearchLeaseListVO searchLeaseListRSQLVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchLeaseListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchLeaseListRSQLVO != null){
				Map<String, String> mapVO = searchLeaseListRSQLVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new YardManageDBDAOSearchLeaseListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchLeaseListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * @param searchYardDwellHistoryVO
	 * @return
	 * @throws DAOException
	 */
	public List<SearchYardDwellHistoryVO> searchDwellTimeHIstory(
			SearchYardDwellHistoryVO searchYardDwellHistoryVO)  throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchYardDwellHistoryVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchYardDwellHistoryVO != null){
				Map<String, String> mapVO = searchYardDwellHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new YardManageDBDAOSearchYardDwellHistoryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchYardDwellHistoryVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * @param searchNodeDefaultSpInfoListVO
	 * @return List
	 * @throws DAOException
	 */
	public List searchNodeDefaultSpInfoList(SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchNodeDefaultSpInfoListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchNodeDefaultSpInfoListVO != null){
				Map<String, String> mapVO = searchNodeDefaultSpInfoListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new YardManageDBDAOSearchNodeDefaultSpInfoListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchNodeDefaultSpInfoListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	
	/**
	 * @param updateVoList
	 * @throws DAOException
	 */
	public void modifyNodeDefaultSpInfoList(	List<SearchNodeDefaultSpInfoListVO> updateVoList) throws DAOException {
		 try{
			 int result = -1;
				Map<String, Object> param = new HashMap<String, Object>();
				Map<String, Object> velParam = new HashMap<String, Object>();

					for(int i=0;i < updateVoList.size();i++ ){
						if(updateVoList.get(i) != null){
							Map<String, String> mapVO = updateVoList.get(i).getColumnValues();
							param.putAll(mapVO);
							velParam.putAll(mapVO);
						}
						result = new SQLExecuter("").executeUpdate((ISQLTemplate) new YardManageDBDAOModifyNodeDefaultSpInfoListUSQL(), param, velParam);						
						if(result == Statement.EXECUTE_FAILED){
							 throw new DAOException("Fail to insert No"+ i + " SQL");
						 }
					}

		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getUserMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getUserMessage());
		 }
	}
	
	
	/**
	 * @param searchNodeDefaultSpInfoListVO
	 * @return List
	 * @throws DAOException
	 */
	public List searchSubOfficeSOManageList(SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchNodeDefaultSpInfoListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchNodeDefaultSpInfoListVO != null){
				Map<String, String> mapVO = searchNodeDefaultSpInfoListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new YardManageDBDAOSearchSubOfficeSOManageListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchNodeDefaultSpInfoListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * @param searchNodeDefaultSpInfoListVO
	 * @return List
	 * @throws DAOException
	 */
	public List searchSubOfficeCList(SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchNodeDefaultSpInfoListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchNodeDefaultSpInfoListVO != null){
				Map<String, String> mapVO = searchNodeDefaultSpInfoListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new YardManageDBDAOSearchSubOfficeCListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchNodeDefaultSpInfoListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

}
