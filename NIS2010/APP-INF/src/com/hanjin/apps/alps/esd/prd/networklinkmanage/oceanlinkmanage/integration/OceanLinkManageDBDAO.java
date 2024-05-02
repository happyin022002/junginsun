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
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.basic.OceanLinkManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkRHQVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkRHQVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS-PRD에 대한 DB 처리를 담당<br>
 * - NIS-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kimyoungchul
 * @see OceanLinkManageBCImpl 참조
 * @since J2EE 1.4
 */
public class OceanLinkManageDBDAO extends DBDAOSupport{

	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -1;

	/**
	 * OceanLinkManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * ★2009-09-14 kim kiwjin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<SearchOceanLinkVO> searchOceanLinkList(SearchOceanLinkVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchOceanLinkVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkManageDBDAOSearchOceanLinkRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanLinkVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

//	/**
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int oceanLinkUpdate1(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkQueryStr1USQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}

//	/**
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int oceanLinkUpdate2(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkQuerySql2USQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}
//
//	/**
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int oceanLinkUpdate3(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkQuerySql3USQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}
//
//	/**
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int oceanLinkUpdate4(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkQuerySql4USQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}
//
//	/**
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int oceanLinkUpdate5(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkQuerySql5USQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}

	/**
	 * chkSQL
	 * ★2009-09-15 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet oceanLinkSChk(SaveOceanLinkVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkChkSqlRSQL(), param, null);

		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

//	/**
//	 * InsertPrdPfTxTmSql
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int insertPrdPfTxTm(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOInsertPrdPfTxTmSqlCSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}

//	/**
//	 * oceanLinkMergeInto
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int oceanLinkMergeInto(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkMergeSqlUSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00067")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}

//	/**
//	 * updateManualPfTzTm
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int updateManualPfTzTm(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkUpdaeManualPfTzTmSqlUSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//	}

//	/**
//	 * updateManualOcnRoutN1st
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int updateManualOcnRoutN1st(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkUpdateManualOcnRoutN1stUSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//
//	}
//
//	/**
//	 * updateManualOcnRoutN2nd
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int updateManualOcnRoutN2nd(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkUpdateManualOcnRoutN2ndUSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//
//	}
//
//	/**
//	 * updateManualOcnRoutN3rd
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int updateManualOcnRoutN3rd(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkUpdateManualOcnRoutN3rdUSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//
//	}
//
//	/**
//	 * updateManualOcnRoutN4th
//	 * ★2009-09-15 kim kwijin생성
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int updateManualOcnRoutN4th(SaveOceanLinkVO vo) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkUpdateManualOcnRoutN4thUSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//
//	}

	/**
	 * OceanLinkManageDBDAO's searchOceanLinkListRHQ
	 * ★2009-09-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	public List<SearchOceanLinkRHQVO> searchOceanLinkListRHQ(SearchOceanLinkRHQVO vo) throws DAOException{
		DBRowSet dbRowset = null;
		List<SearchOceanLinkRHQVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkManageDBDAOSearchOceanLinkRHQRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOceanLinkRHQVO.class);
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
	 * oceanLinkRHQInsert
	 * ★2009-09-17 kim kwijin생성
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] oceanLinkRHQInsert(List<SaveOceanLinkRHQVO> insModels) throws DAOException, Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate) new OceanLinkManageDBDAORHQLinkInsertCSQL(), insModels, null);
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
	 * oceanLinkRHQUpdate
	 * ★2009-09-17 kim kwijin생성
	 * @param updModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] oceanLinkRHQUpdate(List<SaveOceanLinkRHQVO> updModels) throws DAOException, Exception{
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate) new OceanLinkManageDBDAORHQLinkUpdateUSQL(), updModels, null);
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
	 * oceanLinkRHQUpdate2
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQUpdate2(SaveOceanLinkRHQVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkUpdate2USQL(), param, null);
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
	 * oceanLinkRHQUpdate3
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQUpdate3(SaveOceanLinkRHQVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkUpdate3USQL(), param, null);
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
	 * oceanLinkRHQUpdate4
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQUpdate4(SaveOceanLinkRHQVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkUpdate4USQL(), param, null);
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
	 * oceanLinkRHQUpdate5
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQUpdate5(SaveOceanLinkRHQVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkUpdate5USQL(), param, null);
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
	 * oceanLinkRHQDelete
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQDelete(SaveOceanLinkRHQVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkDeleteDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00066")).getMessage() );
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
	 * oceanLinkRHQDelete2
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQDelete2(SaveOceanLinkRHQVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkDelete2USQL(), param, null);
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
	 * oceanLinkRHQDelete3
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQDelete3(SaveOceanLinkRHQVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkDelete3USQL(), param, null);
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
	 * oceanLinkRHQDelete4
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQDelete4(SaveOceanLinkRHQVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkDelete4USQL(), param, null);
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
	 * oceanLinkRHQDelete5
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int oceanLinkRHQDelete5(SaveOceanLinkRHQVO vo) throws DAOException, Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORHQLinkDelete5USQL(), param, null);
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

//	/**
//	 * OceanLinkManageDBDAO's searchDirecOcnRout
//	 * ★2009-09-15 kim kwijin수정
//	 * @param org
//	 * @param dest
//	 * @param seq
//	 * @return
//	 * @throws DAOException DBRowSet
//	 */
//	public DBRowSet searchDirecOcnRout(String org, String dest, String seq) throws DAOException{
//		DBRowSet dbRowset = null;
//		try{
//			Map param = new HashMap();
//			param.put("org", org);
//			param.put("dest", dest);
//			param.put("seq", seq);
//
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkManageDBDAOSearchDirectOcnRoutRSQL(), param, null);
//
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return dbRowset;
//	}

//	/**
//	 * OceanLinkManageDBDAO's historyOcnAdd
//	 * @param org
//	 * @param dest
//	 * @param routSeq
//	 * @return
//	 * @throws DAOException int
//	 */
//	public int historyOcnAdd(String org, String dest, String routSeq) throws DAOException{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			param.put("org", org);
//			param.put("dest", dest);
//			param.put("routSeq", routSeq);
//
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOHistoryOcnAddCSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//
//
//	}

	/**
	 * OceanLinkManageDBDAO's historyOcnAddByLinkNo
	 * ★2009-09-15 kim kwijin수정
	 * @param nPol
	 * @param nPod
	 * @param lane
	 * @param linkNo
	 * @return
	 * @throws DAOException int
	 */
	public int historyOcnAddByLinkNo(String nPol, String nPod, String lane, String linkNo) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{

			param.put("nPol", nPol);
			param.put("nPod", nPod);
			param.put("lane", lane);
			param.put("linkNo", linkNo);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOHistoryOcnAddLinkNoCSQL(), param, null);
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
	 * OceanLinkManageDBDAO's historyOcnFdrAddByLinkNo
	 * ★2009-09-17 kim kwijin수정
	 * @param nPol
	 * @param nPod
	 * @param linkNo
	 * @return
	 * @throws DAOException
	 */
	public int historyOcnFdrAddByLinkNo(String nPol, String nPod, String linkNo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			param.put("nPol", nPol);
			param.put("nPod", nPod);
			param.put("linkNo", linkNo);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOHistoryOcnFdrAddByLinkNoCSQL(), param, null);
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
	
//	/**
//	 * OceanLinkManageDBDAO's deleteManualPfTzTm
//	 * ★2010-10-19 진마리아 생성
//	 * CHM-201006410-01 HQ Link Management Logic 변경 요청
//	 * @param vo
//	 * @return
//	 * @throws DAOException
//	 */
//	public int deleteManualPfTzTm(SaveOceanLinkVO vo) throws DAOException, Exception{
//		Map<String, Object> param = new HashMap<String, Object>();
//		int result = 0;
//		try{
//			Map<String, String> mapVO = vo.getColumnValues();
//			param.putAll(mapVO);
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkDeleteManualPfTzTmSqlUSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException( (new ErrorHandler("PRD00066")).getMessage() );
//			}
//		}catch(SQLException se){
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return result;
//
//	}
	
	

	

}
