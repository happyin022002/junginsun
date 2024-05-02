/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanLinkBackEndDBDAO.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.08.03
 *@LastModifier : Park Man-geon
 *@LastVersion : 1.0
 * 2011-08-03 Park Man-geon
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.basic.OceanLinkManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS-PRD에 대한 DB 처리를 담당<br>
 * - ALPS-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Park Man-geon
 * @see OceanLinkManageBCImpl 참조
 * @since J2EE 1.4
 */
public class OceanLinkBackEndDBDAO extends DBDAOSupport{

	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -1;

//	/**
//	 * chkSQL
//	 * ★2009-09-15 kim kwijin생성
//	 * 
//	 * @param SaveOceanLinkVO vo
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet oceanLinkSChk(SaveOceanLinkVO vo) throws DAOException{
//		DBRowSet dbRowset = null;
//		Map<String, Object> param = new HashMap<String, Object>();
//		try{
//			if(vo != null){
//				Map<String, String> mapVO = vo.getColumnValues();
//				param.putAll(mapVO);
//			}
////			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkChkSqlRSQL(), param, null);
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkBackEndDBDAOOceanLinkChkRSQL(), param, null);
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

	/**
	 * InsertPrdPfTxTmSql
	 * ★2009-09-15 kim kwijin생성
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int insertPrdPfTxTm(SaveOceanLinkVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOInsertPrdPfTxTmSqlCSQL(), param, null);
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOInsertPrdPfTxTmCSQL(), param, null);
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
	 * updateManualPfTzTm
	 * ★2009-09-15 kim kwijin생성
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int updateManualPfTzTm(SaveOceanLinkVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkUpdaeManualPfTzTmSqlUSQL(), param, null);
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOOceanLinkUpdaeManualPfTzTmUSQL(), param, null);
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
	 * OceanLinkManageDBDAO's deleteManualPfTzTm
	 * ★2010-10-19 진마리아 생성
	 * CHM-201006410-01 HQ Link Management Logic 변경 요청
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int deleteManualPfTzTm(SaveOceanLinkVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkDeleteManualPfTzTmSqlUSQL(), param, null);
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOOceanLinkDeleteManualPfTzTmUSQL(), param, null);
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
	 * ★2009-09-15 kim kwijin생성
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int oceanLinkUpdate1(SaveOceanLinkVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkQueryStr1USQL(), param, null);
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOOceanLinkQueryStr1USQL(), param, null);
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
	 * OceanLinkManageDBDAO's historyOcnAdd
	 * @param String org
	 * @param String dest
	 * @param String routSeq
	 * @return int
	 * @throws DAOException int
	 */
	public int historyOcnAdd(String org, String dest, String routSeq) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			param.put("org", org);
			param.put("dest", dest);
			param.put("routSeq", routSeq);

			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOHistoryOcnAddCSQL(), param, null);
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOHistoryOcnAddCSQL(), param, null);
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
	 * OceanLinkManageDBDAO's searchDirecOcnRout
	 * ★2009-09-15 kim kwijin수정
	 * @param String org
	 * @param String dest
	 * @param String seq
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDirecOcnRout(String org, String dest, String seq) throws DAOException{
		DBRowSet dbRowset = null;
		try{
			Map<String,String> param = new HashMap<String,String>();
			param.put("org", org);
			param.put("dest", dest);
			param.put("seq", seq);

//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkManageDBDAOSearchDirectOcnRoutRSQL(), param, null);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkBackEndDBDAOSearchDirectOcnRoutRSQL(), param, null);

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
	 * oceanLinkMergeInto
	 * ★2009-09-15 kim kwijin생성
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int oceanLinkMergeInto(SaveOceanLinkVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkMergeSqlUSQL(), param, null);
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOOceanLinkMergeUSQL(), param, null);
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
	 * ★2011-08-02 mgpark
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int removeOceanRouteByHQLink(SaveOceanLinkVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAORemoveOceanRouteByHQLinkUSQL(), param, null); // 신규(mgpark)
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAORemoveOceanRouteByHQLinkUSQL(), param, null);
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
	 * ★2011-08-02 mgpark
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int addOceanRouteHistoryByHQLink(SaveOceanLinkVO vo) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOAddOceanRouteHistoryByHQLinkCSQL(), param, null); // 신규(mgpark)
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOAddOceanRouteHistoryByHQLinkCSQL(), param, null);
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
	 * updateManualOcnRout
	 * 2011-08-02 Park Man-geon
	 * @param SaveOceanLinkVO vo
	 * @param String lnkSeq
	 * @return int
	 * @throws DAOException
	 */
	public int updateManualOcnRout(SaveOceanLinkVO vo, String lnkSeq) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try{
			vo.setLnkSeq(lnkSeq);
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkManageDBDAOOceanLinkUpdateManualOcnRoutCSQL(), param, param); // 신규(mgpark) - 통합
			result = sqlExe.executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOModifyOceanRouteByLinkUSQL(), param, param);
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

}