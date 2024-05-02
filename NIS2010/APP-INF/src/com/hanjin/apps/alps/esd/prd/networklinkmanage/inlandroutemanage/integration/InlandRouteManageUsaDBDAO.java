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
 * 2012.09.24 정선용  CHM-201220334-01: [PRD] Optimum flag 범위확대 요청
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic.InlandRouteManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.CheckWrsVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
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
 * @author jungsunyong
 * @see InlandRouteManageBCImpl 참조
 * @since J2EE 1.4
 */
public class InlandRouteManageUsaDBDAO extends DBDAOSupport{

	/**
	 * InlandRouteManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param inlandRouteUSVO
	 * @return
	 * @throws DAOException
	 * ★ 2009/08/03 kim kwi-jin 생성
	 * 
	 */
	public List<lnlandRouteUSVO> searchInlandRouteMasterUSA(lnlandRouteUSVO inlandRouteUSVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<lnlandRouteUSVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inlandRouteUSVO != null){
				Map<String, String> mapVO = inlandRouteUSVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageDBDAOlnlandRouteUSRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, lnlandRouteUSVO.class);
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
	 * InlandRouteManageUsaDBDAO's searchInlandRouteDetailUSA
	 * @param searchConditionVO
	 * @return
	 * @throws DAOException
	 * 2009-08-05 kim kiwjin 생성
	 */
	public List<InlandRouteUSDetVO> searchInlandRouteDetailUSA(SearchConditionVO searchConditionVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<InlandRouteUSDetVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageUsaDBDAOInlandRouteUSDetRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InlandRouteUSDetVO.class);
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
	 * InlandRouteManageUsaDBDAO's saveInlandRouteMasterUSA01
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] saveInlandRouteMasterUSA01(List<lnlandRouteUSVO> updModels) throws DAOException, Exception{
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new InlandRouteManageUsaDBDAOInlandRouteUSC1USQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
		return updCnt;
	}

	/**
	 * InlandRouteManageUsaDBDAO's saveInlandRouteMasterUSA02
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] saveInlandRouteMasterUSA02(List<lnlandRouteUSVO> updModels) throws DAOException, Exception{
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new InlandRouteManageUsaDBDAOInlandRouteUSC2USQL(), updModels, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
		return updCnt;

	}

	/**
	 * CHECK WRS
	 * @param checkWrsVO
	 * @return
	 * @throws DAOException
	 */
	public List<CheckWrsVO> getChkWrs(CheckWrsVO checkWrsVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<CheckWrsVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(checkWrsVO != null){
				Map<String, String> mapVO = checkWrsVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InlandRouteManageUsaDBDAOCheckWrsRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckWrsVO.class);
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
	 * forceWrcFlgSett01
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int forceWrcFlgSett01(lnlandRouteUSVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new InlandRouteManageUsaDBDAOForceWrsFlg01USQL(), param, velParam);
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
	 * forceWrcFlgSett02
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int forceWrcFlgSett02(lnlandRouteUSVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new InlandRouteManageUsaDBDAOForceWrsFlg02USQL(), param, velParam);
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
	 * forceWrcFlgSett03
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int forceWrcFlgSett03(lnlandRouteUSVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new InlandRouteManageUsaDBDAOForceWrsFlg03USQL(), param, velParam);
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
	 *  InlandRouteManageUsaDBDAO's saveInlandRoutePriorityUSA<br>
	 *  2009-08-06 kim kwijin 생성 
	 * @param inlandRouteUSVOs
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 *
	 */
	public int[] saveInlandRoutePriorityUSA(List<lnlandRouteUSVO> inlandRouteUSVOs) throws DAOException, Exception{
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(inlandRouteUSVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new InlandRouteManageUsaDBDAOInlandRouteUSUSQL(), inlandRouteUSVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
		return updCnt;
	}

	/**
	 * 미주 Optimum Flag Remove
	 * @param List<lnlandRouteUSVO> optimumVoList
	 * @return int[] 
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[]  updateRemoveOptimumFlag(List<lnlandRouteUSVO> optimumVoList) throws DAOException, Exception{
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(optimumVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new InlandRouteManageDBDAOupdateRemoveOptimumFlagUSQL(), optimumVoList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
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
		return updCnt;
		
	}
}
