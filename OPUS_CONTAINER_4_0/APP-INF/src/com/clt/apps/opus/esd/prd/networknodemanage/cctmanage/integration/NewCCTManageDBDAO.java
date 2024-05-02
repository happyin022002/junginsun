/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NewCCTManageDBDAO.java
 *@FileTitle : Yard별 CCT
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-09
 *@LastModifier : Jeongseon An
 *@LastVersion : 1.0
 * 20090608 jsy
 * 1.0 최초 생성
 =========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.vo.NewCCTManageVO;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.vo.PrdCstSkdByPortVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * PRD에 대한 DB 처리를 담당<br>
 * PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeongseon An
 * @see CCTmanageBCImpl 참조
 * @since J2EE 1.4
 */
public class NewCCTManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * CCTmanage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCCTManage(NewCCTManageVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new NewCCTManageDBDAOSearchCCTManageRSQL(), param, velParam);
			}
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
	 * @param vo
	 * @throws DAOException
	 */
	public void updateMultiCCTManage(NewCCTManageVO vo) throws DAOException {
		try {
			int successFlag = 0;
			Map<String, String> mapVO = vo.getColumnValues();
			successFlag = new SQLExecuter().executeUpdate((ISQLTemplate) new NewCCTManageDBDAOMultiCCTManageRSQL(), mapVO, mapVO);
			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param newCCTManageVO
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet checkCct(NewCCTManageVO newCCTManageVO) throws DAOException {
		try {
			return new SQLExecuter().executeQuery((ISQLTemplate) new NewCCTManageDBDAOCheckCctRSQL(), newCCTManageVO.getColumnValues(), null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 해당 Port의 Costal Schedule 정보를 조회합니다.<br>
	 * 
	 * @param PrdCstSkdByPortVO cstSkdByPortVO
	 * @return List<PrdCstSkdByPortVO>
	 * @exception DAOException
	 */
	public DBRowSet searchCstSkdByPort(PrdCstSkdByPortVO cstSkdByPortVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cstSkdByPortVO.getColumnValues();
			param.putAll(mapVO);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new NewCCTManageDBDAOSearchCstSkdByPortRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;
	}

	/**
	 * @param vo
	 * @throws DAOException
	 */
	public void multiVslCgoClzDate(PrdCstSkdByPortVO vo) throws DAOException {
		try {
			int successFlag = 0;
			Map<String, String> mapVO = vo.getColumnValues();
			successFlag = new SQLExecuter().executeUpdate((ISQLTemplate) new NewCCTManageDBDAOMultiVslCgoClzDateUSQL(), mapVO, mapVO);
			if (successFlag == Statement.EXECUTE_FAILED) {
				throw new DAOException((new ErrorHandler("PRD00065")).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

}
