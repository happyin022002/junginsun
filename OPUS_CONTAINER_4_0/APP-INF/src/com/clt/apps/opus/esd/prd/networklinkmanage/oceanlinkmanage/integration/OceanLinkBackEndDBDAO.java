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
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.basic.OceanLinkManageBCImpl;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS-PRD에 대한 DB 처리를 담당<br>
 * - OPUS-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Man-geon
 * @see OceanLinkManageBCImpl 참조
 * @since J2EE 1.4
 */
public class OceanLinkBackEndDBDAO extends DBDAOSupport {

	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -1;

	/**
	 * InsertPrdPfTxTmSql ★2009-09-15 kim kwijin생성
	 * 
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int insertPrdPfTxTm(SaveOceanLinkVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOInsertPrdPfTxTmCSQL(), param, null);
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
	 * updateManualPfTzTm ★2009-09-15 kim kwijin생성
	 * 
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int updateManualPfTzTm(SaveOceanLinkVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOOceanLinkUpdaeManualPfTzTmUSQL(), param, null);
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
	 * OceanLinkManageDBDAO's deleteManualPfTzTm ★2010-10-19 진마리아 생성 CHM-201006410-01 HQ Link Management Logic 변경 요청
	 * 
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int deleteManualPfTzTm(SaveOceanLinkVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOOceanLinkDeleteManualPfTzTmUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00066")).getMessage());
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
	 * ★2009-09-15 kim kwijin생성
	 * 
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int oceanLinkUpdate1(SaveOceanLinkVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOOceanLinkQueryStr1USQL(), param, null);
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
	 * OceanLinkManageDBDAO's historyOcnAdd
	 * 
	 * @param String org
	 * @param String dest
	 * @param String routSeq
	 * @return int
	 * @throws DAOException int
	 */
	public int historyOcnAdd(String org, String dest, String routSeq) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			param.put("org", org);
			param.put("dest", dest);
			param.put("routSeq", routSeq);

			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOHistoryOcnAddCSQL(), param, null);
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
	 * OceanLinkManageDBDAO's searchDirecOcnRout ★2009-09-15 kim kwijin수정
	 * 
	 * @param String org
	 * @param String dest
	 * @param String seq
	 * @param String dircd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDirecOcnRout(String org, String dest, String seq, String dircd) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			Map<String, String> param = new HashMap<String, String>();
			param.put("org", org);
			param.put("dest", dest);
			param.put("seq", seq);
			param.put("dircd", dircd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new OceanLinkBackEndDBDAOSearchDirectOcnRoutRSQL(), param, null);
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
	 * oceanLinkMergeInto ★2009-09-15 kim kwijin생성
	 * 
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int oceanLinkMergeInto(SaveOceanLinkVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOOceanLinkMergeUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00067")).getMessage());
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
	 * ★2011-08-02 mgpark
	 * 
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int removeOceanRouteByHQLink(SaveOceanLinkVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAORemoveOceanRouteByHQLinkUSQL(), param, null);
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
	 * ★2011-08-02 mgpark
	 * 
	 * @param SaveOceanLinkVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int addOceanRouteHistoryByHQLink(SaveOceanLinkVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOAddOceanRouteHistoryByHQLinkCSQL(), param, null);
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
	 * updateManualOcnRout 2011-08-02 Park Man-geon
	 * 
	 * @param SaveOceanLinkVO vo
	 * @param String lnkSeq
	 * @return int
	 * @throws DAOException
	 */
	public int updateManualOcnRout(SaveOceanLinkVO vo, String lnkSeq) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			vo.setLnkSeq(lnkSeq);
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new OceanLinkBackEndDBDAOModifyOceanRouteByLinkUSQL(), param, param);
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

}