/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanRouteManageDBDAO.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-22
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-22 kimyoungchul
 * 1.0 최초 생성
 * 080918 OCN ROUT MANUAL CREATE시 DIRECTION도 추가
 * 080929 INSERTUPDATE 에도 조건에 DIRECTION도 추가
 * 090128 ocn route remark 추가
 * csr N200903120230 20080414  [PRD] Ocean Route 기능 보완
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.basic.OceanRouteManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.RowSearchOceanRouteManageVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanLaneVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteAutoCreationVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteMultiCreationVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteSingleCreationVO;
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
 * @see OceanRouteManageBCImpl 참조
 * @since J2EE 1.4
 */
public class OceanRouteManageDBDAO extends DBDAOSupport{
	private static final long serialVersionUID = 1L;

	/**
	 * OceanRouteManage의 모든 목록을 가져온다.<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOceanRouteList() throws DAOException{
		log.debug("\n[CALL] DAO ----------------------------- ");
		return null;
	}

	/**
	 * OceanRouteManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ★2009-08-20 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchOceanRouteListVO> searchOceanRouteList(SearchConditionVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchOceanRouteListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteManageDBDAOSearchOceanRouteListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanRouteListVO.class);
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
	 * OceanRouteManageDBDAO's searchOceanRouteDelList
	 * ★2009-08-20 kim kwijin 생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchOceanRouteListVO> searchOceanRouteDelList(SearchConditionVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchOceanRouteListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteManageDBDAOSearchOceanRouteDelListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanRouteListVO.class);
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
	 * DEL CHK
	 * ★2009-08-21 kim kwijin 생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet delChkPs(SaveOceanRouteVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteManageDBDAODelChkRSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;


	}

	/**
	 * GET MAX ROUTE SEQ
	 * ★2009-08-21 kim kwijin 생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet getMaxSeqPs(SaveOceanRouteVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteManageDBDAOGetMaxSeqRSQL(), param, velParam);

		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * insert update
	 *★ 2009-08-21 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int insertUpdatePs(SaveOceanRouteVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanRouteManageDBDAOOceanRouteInsertUpdateUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;


	}

	/**
	 * insert ocean route
	 *★ 2009-08-21 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int insertOceanRoute(SaveOceanRouteVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanRouteManageDBDAOInsertOceanRouteCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;


	}

	/**
	 * update ocean route
	 * ★ 2009-08-21 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int updateOceanRoute(SaveOceanRouteVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanRouteManageDBDAOUpdateOceanRouteUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * delete ocean route
	 * ★ 2009-08-21 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public int deleteOceanRoute(SaveOceanRouteVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanRouteManageDBDAODeleteOceanRouteUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;


	}

	/**
	 * OceanRouteManageDBDAO's searchOceanRouteAutoCreationList
	 * ★2009-09-07 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchOceanRouteAutoCreationVO> searchOceanRouteAutoCreationList(SearchOceanRouteAutoCreationVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchOceanRouteAutoCreationVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteManageDBDAOSearchOceanRouteAutoCreationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanRouteAutoCreationVO.class);
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
	 * OceanRouteManageDBDAO's searchOceanLane
	 * ★2009-08-31 kim kiwjin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchOceanLaneVO> searchOceanLane(SearchOceanLaneVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchOceanLaneVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteManageDBDAOSearchOceanLaneRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanLaneVO.class);
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
	 * OceanRouteManageDBDAO's rowSearchOceanRouteManage
	 * ★2009-08-31 kim kiwjin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<RowSearchOceanRouteManageVO> rowSearchOceanRouteManage(RowSearchOceanRouteManageVO vo) throws DAOException{
		List<RowSearchOceanRouteManageVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new OceanRouteManageDBDAORowSearchOceanRouteManageRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RowSearchOceanRouteManageVO.class);
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
	 * OceanRouteManageDBDAO's searchOceanRouteMultiCreationList
	 * ★2009-09-02 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchOceanRouteMultiCreationVO> searchOceanRouteMultiCreationList(SearchOceanRouteMultiCreationVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchOceanRouteMultiCreationVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteManageDBDAOSearchOceanRouteMultiCreationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanRouteMultiCreationVO.class);
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
	 * OceanRouteManageDBDAO's historyOcnAdd
	 * @param org
	 * @param dest
	 * @param routSeq
	 * @throws DAOException int
	 */
	public void historyOcnAdd(String org, String dest, String routSeq) throws DAOException{
		try{
			Map<String, String> param = new HashMap<String, String>();
			param.put("org", org);
			param.put("dest", dest);
			param.put("routSeq", routSeq);


			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new OceanRouteManageDBDAOHistoryOcnAddCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}




	}

	/**
	 *
	 * @param org
	 * @param dest
	 * @param n1stLane
	 * @param dir1
	 * @param n2ndPol
	 * @param n2ndLane
	 * @param dir2
	 * @param n3rdPol
	 * @param n3rdLane
	 * @param dir3
	 * @param n4thPol
	 * @param n4thLane
	 * @param dir4
	 * @return
	 * @throws DAOException
	 */
	public int historyOcnAddByLink(String org, String dest, String n1stLane, String dir1, String n2ndPol, String n2ndLane,
			String dir2, String n3rdPol, String n3rdLane, String dir3,
			String n4thPol, String n4thLane, String dir4) throws DAOException{
		int result = -1;

		try{


			Map<String,String> param = new HashMap<String,String>();
			param.put("org", org);
			param.put("dest", dest);

			param.put("n1stLane", n1stLane);
			param.put("dir1", dir1);

			param.put("n2ndPol", n2ndPol);
			param.put("n2ndLane", n2ndLane);
			param.put("dir2", dir2);
			param.put("n3rdPol", n3rdPol);
			param.put("n3rdLane", n3rdLane);
			param.put("dir3", dir3);
			param.put("n4thPol", n4thPol);
			param.put("n4thLane", n4thLane);
			param.put("dir4", dir4);


			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanRouteManageDBDAOHistoryOcnAddByLinkCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;



	}

	/**
	 *
	 * @param n1stLane
	 * @param n2ndLane
	 * @param n3rdLane
	 * @param n4thLane
	 * @return
	 * @throws DAOException
	 */
	public int historyOcnAddByLane(String n1stLane, String n2ndLane, String n3rdLane, String n4thLane) throws DAOException{
		int result = -1;

		try{
			Map<String, String> param = new HashMap<String, String>();
			param.put("n1stLane", n1stLane);
			param.put("n2ndLane", n2ndLane);

			param.put("n3rdLane", n3rdLane);
			param.put("n4thLane", n4thLane);



			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanRouteManageDBDAOHistoryOcnAddByLaneCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;


	}
	
	/**
	 * OceanRouteManageDBDAO's searchOceanRouteSingleCreation
	 * @param vo
	 * @return List<SearchOceanRouteSingleCreationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchOceanRouteSingleCreationVO> searchOceanRouteSingleCreation(SearchOceanRouteSingleCreationVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchOceanRouteSingleCreationVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteManageDBDAOSearchOceanRouteSingleCreationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanRouteSingleCreationVO.class);
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