/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanRouteConditionManageDBDAO.java
 *@FileTitle : Carrier별 이용터미널 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-02
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-02 jungsunyoung
 * 1.0 최초 생성
 * * N200902100240 2009-02-27 Terminal Matrix Exception UI 추가 개발 (ESD_PRD_041)
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.basic.OceanRouteConditionManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchCallingTmlMtxExptVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchEmbargoVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchOceanRouteConditionVO;
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
 * @author jungsunyoung
 * @see OceanRouteConditionManageBCImpl 참조
 * @since J2EE 1.4
 */
public class OceanRouteConditionManageDBDAO extends DBDAOSupport{

	/**
	 * OceanRouteConditionManage의 모든 목록을 가져온다.<br>
	 * ★ 2009-09-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<SearchOceanRouteConditionVO> searchOceanRouteConditionManageList(SearchOceanRouteConditionVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchOceanRouteConditionVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteConditionManageDBDAOSearchOceanRouteConditionRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanRouteConditionVO.class);
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
	 * OceanRouteConditionManageDBDAO's searchCallingTmlMtxExptList
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<SearchCallingTmlMtxExptVO> searchCallingTmlMtxExptList(SearchCallingTmlMtxExptVO vo) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		List<SearchCallingTmlMtxExptVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteConditionManageDBDAOSearchCallingTmlMtxExptRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCallingTmlMtxExptVO.class);
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
	 * oceanRouteCondiInsert
	 * ★2009-09-16 kim kwijin생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] oceanRouteCondiInsert(List<SearchOceanRouteConditionVO> insModels) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OceanRouteConditionManageDBDAOOceanRouteCondiInsertCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * oceanRouteCondiUpdate
	 * ★2009-09-16 kim kwijin생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] oceanRouteCondiUpdate(List<SearchOceanRouteConditionVO> insModels) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OceanRouteConditionManageDBDAOOceanRouteCondiUpdateUSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;

	}

	/**
	 * oceanRouteCondiDelete
	 * ★2009-09-16 kim kwijin생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] oceanRouteCondiDelete(List<SearchOceanRouteConditionVO> insModels) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OceanRouteConditionManageDBDAOOceanRouteCondiDeleteDSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;

	}

	/**
	 * oceanRouteCondiHistoryAdd
	 * ★2009-09-16 kim kwijin생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] oceanRouteCondiHistoryAdd(List<SearchOceanRouteConditionVO> insModels) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OceanRouteConditionManageDBDAOOceanRouteCondiHistoryCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;

	}

	/**
	 * oceanRouteCondiHistoryMax
	 *  ★2009-09-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public DBRowSet oceanRouteCondiHistoryMax(SearchOceanRouteConditionVO vo) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteConditionManageDBDAOOceanRouteCondiHistoryMaxRSQL(), param, null);

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
	 * OceanRouteConditionManageDBDAO's searchEmbargoManageList
	 * ★2009-09-18 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<SearchEmbargoVO> searchEmbargoManageList(SearchEmbargoVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchEmbargoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanRouteConditionManageDBDAOSearchEmbargoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchEmbargoVO.class);
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
	 * insertEmbargo
	 * ★2009-09-18 kim kwijin생성
	 * @param models
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] insertEmbargo(List<SearchEmbargoVO> models) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OceanRouteConditionManageDBDAOEmbargoInsertCSQL(), models, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;


	}

	/**
	 * updateEmbargo
	 * ★2009-09-18 kim kwijin생성
	 * @param models
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateEmbargo(List<SearchEmbargoVO> models) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OceanRouteConditionManageDBDAOUpdateEmbargoUSQL(), models, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to update No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;


	}

	/**
	 * deleteEmbargo
	 * ★2009-09-18 kim kwijin생성
	 * @param models
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteEmbargo(List<SearchEmbargoVO> models) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OceanRouteConditionManageDBDAODeleteEmbargoDSQL(), models, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;


	}

	/**
	 * mergeCallingTmlMtxExpt
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int mergeCallingTmlMtxExpt(SearchCallingTmlMtxExptVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanRouteConditionManageDBDAOMergeCallingTmlMtxExptUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00067")).getMessage() );
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
	 * deleteCallingTmlMtxExpt
	 * ★2009-09-17 kim kwijin생성
	 * @param delModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteCallingTmlMtxExpt(List<SearchCallingTmlMtxExptVO> delModels) throws DAOException, Exception{
		int delCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate) new OceanRouteConditionManageDBDAODeleteCallingTmlMtxExptDSQL(), delModels, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete No" + i + " SQL");
					}
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
}
